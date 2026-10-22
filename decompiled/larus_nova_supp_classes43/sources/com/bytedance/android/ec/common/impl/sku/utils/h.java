package com.bytedance.android.ec.common.impl.sku.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfo;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfoItem;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.common.utility.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public h() {
    }

    static {
    }

    public static /* synthetic */ void b(Fragment r21, SkuViewModel r22, SkuInfoVO r23, Context r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String[] r34, String r35, String r36, String r37, int r38, String r39, String r40) {
        a(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, null, r40);
    }

    public static void a(Fragment r29, SkuViewModel r30, SkuInfoVO r31, Context r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String[] r42, String r43, String r44, String r45, int r46, String r47, String r48, String r49) {
        Intrinsics.checkNotNullParameter(r29, "fragment");
        Intrinsics.checkNotNullParameter(r30, "viewModel");
        Intrinsics.checkNotNullParameter(r31, "skuInfo");
        Intrinsics.checkNotNullParameter(r32, "context");
        Intrinsics.checkNotNullParameter(r33, "originType");
        Intrinsics.checkNotNullParameter(r34, "originId");
        Intrinsics.checkNotNullParameter(r35, "promotionId");
        Intrinsics.checkNotNullParameter(r36, "productId");
        Intrinsics.checkNotNullParameter(r37, "authorId");
        Intrinsics.checkNotNullParameter(r38, BdpAwemeConstant.KEY_ROOM_ID);
        Intrinsics.checkNotNullParameter(r39, "shopId");
        Intrinsics.checkNotNullParameter(r40, "comboId");
        Intrinsics.checkNotNullParameter(r41, "comboNum");
        Intrinsics.checkNotNullParameter(r42, "selectedKeys");
        Intrinsics.checkNotNullParameter(r43, "trackExtra");
        Intrinsics.checkNotNullParameter(r45, "channelId");
        if (TextUtils.isEmpty(r40) == false) goto L5;
    L158:
        UIUtils.displayToast(r32, th.a.g(r32, 2131913776));
        Set<String> r0 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_sku"), -2, null, null, null, 14);
        return;
    L5:
        if (TextUtils.isEmpty(r35) == false) goto L9;
        if (r30.getSkuParams().getRoomType() != 2) goto L158;
    L9:
        if (TextUtils.isEmpty(r36) == true) goto L158;
        String r10 = ECAppInfoService.e.getServerDeviceId();
        com.bytedance.android.btm.api.model.e r1 = BtmSDK.INSTANCE.getBtmPageInfo(PageFinder.via(r44));
        if (r1 == null) goto L15;
        String r11 = r1.a;
        if (r11 == null) goto L15;
    L16:
        com.bytedance.android.btm.api.model.d r12 = new com.bytedance.android.btm.api.model.d();
        if (r48 == null) goto L20;
        String r16 = a2.d(r48);
        if (r16 == null) goto L20;
    L21:
        r12.a = r16;
        r12.b = PageFinder.via(r29);
        r12.c = new BcmParams();
        String r19 = EcomBcmTracker.g(r12);
        JSONObject r13 = new JSONObject(r43);     // Catch: Exception -> L118
        if ((!StringsKt.isBlank(r38)) == false) goto L26;
        String r14 = r38;
    L28:
        if (r14 == null) goto L31;
        r13.put(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r14);     // Catch: Exception -> L118
    L31:
        if ((!StringsKt.isBlank(r39)) == false) goto L33;
        String r15 = r39;
    L34:
        if (r15 == null) goto L38;
        r13.put("shop_user_id", r15);     // Catch: Exception -> L118
    L38:
        if ((!StringsKt.isBlank(r37)) == false) goto L40;
        String r17 = r37;
    L42:
        if (r17 == null) goto L44;
        r13.put(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r17);     // Catch: Exception -> L118
    L44:
        if (r47 == null) goto L48;
        String r18 = a2.d(r47);     // Catch: Exception -> L118
        if (r18 == null) goto L48;
        r13.put("biz_campaign_type", r18);     // Catch: Exception -> L118
    L48:
        if (r49 == null) goto L52;
        String r20 = a2.d(r49);     // Catch: Exception -> L118
        if (r20 == null) goto L52;
        r13.put("cps_track", r20);     // Catch: Exception -> L118
    L52:
        String r21 = r13.optString("cart_track");     // Catch: Exception -> L118
        if (r21.length() <= 0) goto L55;
        boolean r110 = true;
    L56:
        if (r110 == false) goto L58;
        JSONObject r111 = new JSONObject(r21);     // Catch: Exception -> L118
    L59:
        String r22 = r13.optString(com.bytedance.android.ec.core.event.a.KEY_ECOM_SCENE_ID);     // Catch: Exception -> L118
        if ((!Intrinsics.areEqual(r22, "1003")) == false) goto L63;
        r13.put(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID, r35);     // Catch: Exception -> L118
        r111.put(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID, r35);     // Catch: Exception -> L118
    L63:
        if ((!StringsKt.isBlank(r37)) == false) goto L65;
        String r23 = r37;
    L66:
        if (r23 == null) goto L69;
        r111.put(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r23);     // Catch: Exception -> L118
    L69:
        if ((!StringsKt.isBlank(r38)) == false) goto L71;
        String r24 = r38;
    L72:
        if (r24 == null) goto L75;
        r111.put(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r24);     // Catch: Exception -> L118
    L75:
        if ((!StringsKt.isBlank(r22)) == true) goto L78;
        r22 = null;
    L78:
        if (r22 == null) goto L80;
        r111.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_SCENE_ID, r22);     // Catch: Exception -> L118
    L80:
        String r25 = r13.optString(com.bytedance.android.ec.core.event.a.KEY_GROUP_ID);     // Catch: Exception -> L118
        if ((!StringsKt.isBlank(r25)) == true) goto L84;
        r25 = null;
    L84:
        if (r25 != null) goto L87;
        r25 = r111.optString(com.bytedance.android.ec.core.event.a.KEY_GROUP_ID);     // Catch: Exception -> L118
    L87:
        if ((!StringsKt.isBlank(r25)) == true) goto L90;
        r25 = null;
    L90:
        if (r25 == null) goto L92;
        r13.put(com.bytedance.android.ec.core.event.a.KEY_GROUP_ID, r25);     // Catch: Exception -> L118
        r111.put(com.bytedance.android.ec.core.event.a.KEY_GROUP_ID, r25);     // Catch: Exception -> L118
    L92:
        SkuExtraData r26 = r30.getSkuParams().getSkuExtraData();     // Catch: Exception -> L118
        if (r26 == null) goto L103;
        String r27 = r26.getTransitionTrackerData();     // Catch: Exception -> L118
        if (r27 == null) goto L103;
        JSONObject r28 = jg.g.f(r27);     // Catch: Exception -> L118
        if (r28 == null) goto L103;
        Iterator<String> r50 = r28.keys();     // Catch: Exception -> L118
    L100:
        if (r50.hasNext() == false) goto L102;
        String r51 = r50.next();     // Catch: Exception -> L118
        r111.put(r51, r28.optString(r51));     // Catch: Exception -> L118
        goto L100
    L102:
        Unit r52 = Unit.INSTANCE;     // Catch: Exception -> L118
    L103:
        String r53 = r30.getSkuParams().getAddCartEntranceInfo();     // Catch: Exception -> L118
        if (r53 == null) goto L112;
        JSONObject r54 = jg.g.f(r53);     // Catch: Exception -> L118
        if (r54 == null) goto L112;
        Iterator<String> r55 = r54.keys();     // Catch: Exception -> L118
    L109:
        if (r55.hasNext() == false) goto L111;
        String r56 = r55.next();     // Catch: Exception -> L118
        r111.put(r56, r54.optString(r56));     // Catch: Exception -> L118
        goto L109
    L111:
        Unit r57 = Unit.INSTANCE;     // Catch: Exception -> L118
    L112:
        String r58 = r111.toString();     // Catch: Exception -> L118
        String r59 = EcomBcmTracker.d(r12, r58);     // Catch: Exception -> L118
        if (r59 == null) goto L116;
        r58 = r59;
    L116:
        r13.put("cart_track", r58);     // Catch: Exception -> L118
        r13.put("btm_show_id", r11);     // Catch: Exception -> L118
        String r60 = r13.toString();     // Catch: Exception -> L118
    L119:
        List<SpecInfo> r61 = r31.getSpecInfoList();
        ArrayList r62 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r61, 10));
        Iterator<T> r63 = r61.iterator();
        int r64 = 0;
    L121:
        if (r63.hasNext() == false) goto L136;
        Object r65 = r63.next();
        int r66 = r64 + 1;
        if (r64 >= 0) goto L125;
        CollectionsKt.throwIndexOverflow();
    L125:
        SpecInfo r67 = (SpecInfo) r65;
        StringBuilder r68 = new StringBuilder();
        r68.append(r67.getName());
        r68.append(":");
        List<SpecInfoItem> r69 = r67.getSpecItems();
        ArrayList r112 = new ArrayList();
        Iterator<T> r70 = r69.iterator();
    L127:
        if (r70.hasNext() == false) goto L131;
        Object r113 = r70.next();
        if (Intrinsics.areEqual(((SpecInfoItem) r113).getId(), r42[r64]) == false) goto L127;
        r112.add(r113);
        goto L127
    L131:
        ArrayList r71 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator r72 = r112.iterator();
    L133:
        if (r72.hasNext() == false) goto L135;
        r71.add(((SpecInfoItem) r72.next()).getName());
        goto L133
    L135:
        r68.append(CollectionsKt.joinToString$default(r71, null, null, null, 0, null, null, 63, null));
        r62.add(r68.toString());
        r64 = r66;
        goto L121
    L136:
        String r73 = CollectionsKt.joinToString$default(r62, " ", null, null, 0, null, null, 62, null);
        Result.Companion r74 = Result.Companion;     // Catch: Throwable -> L148
        String r75 = r30.getComboId();     // Catch: Throwable -> L148
        if (r75 != null) goto L140;
    L143:
        boolean r76 = true;
    L144:
        if (r76 == false) goto L146;
        SkuViewModel.doSkuEventAction$default(r30, "sku_error_monitor", new Pair[]{TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "Native_Android"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ERROR_TYPE, "SERIOUS_BUSINESS_ERROR"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, "加购combo_id为null, product_id:" + r30.getSkuParams().getProductId())}, null, null, null, 28, null);     // Catch: Throwable -> L148
    L146:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L148
    L151:
        if (r30.getSkuParams().isSchemaOpen() == true) goto L156;
        if (r10 != null) goto L154;
        String r114 = "";
    L155:
        r30.addShopCart(r33, r34, r40, r41, r73, r114, r60, r45, r46, r19);
        return;
    L154:
        r114 = r10;
        goto L155
    L156:
        r30.addShopCartNew(r40, r41, r60, r45, r46, r19);
        return;
    L140:
        if (r75.length() == 0) goto L143;
        r76 = false;
    L148:
        th = move-exception;
        Result.Companion r77 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L151
    L71:
        r24 = null;
        goto L72
    L65:
        r23 = null;
        goto L66
    L58:
        r111 = new JSONObject();     // Catch: Exception -> L118
        goto L59
    L55:
        r110 = false;
        goto L56
    L40:
        r17 = null;
        goto L42
    L33:
        r15 = null;
        goto L34
    L26:
        r14 = null;
    L118:
        r60 = r43;
    L20:
        r16 = "a1.b5267.c7323.d1871";
    L15:
        r11 = "";
        goto L16
    }
}
