package com.bytedance.android.ec.common.impl.sku.presenter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuBannerStruct;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ SkuBannerStruct a;
    public final /* synthetic */ c b;

    public b(SkuBannerStruct r1, c r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        SkuViewModel r15 = this.b.a.f;
        if (r15 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L6:
        if (r15.getSkuParams().isFromLiveRoom() == true) goto L12;
        SkuViewModel r16 = this.b.a.f;
        if (r16 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        if (r16.getSkuParams().isFrom3D() == true) goto L12;
    L25:
        String r17 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b5267.c2164.d7883", Boolean.TRUE).withView(this.b.a.a0()).build());
        Map<String, Boolean> r10 = bf.a.a;
        FragmentActivity r11 = this.b.a.Y().a();
        a r12 = this.b.a;
        String r13 = this.a.getSchema();
        r12.getClass();
        Uri.Builder r18 = UriProtector.parse(r13).buildUpon();
        SkuViewModel r19 = r12.f;
        if (r19 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L28:
        r18.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r19.getSkuParams().getAuthorId());
        SkuViewModel r20 = r12.f;
        if (r20 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L31:
        ECAdLogExtra r21 = r20.getSkuParams().getAdLogExtra();
        if (r21 == null) goto L36;
        String r22 = r21.getCreativeId();
        if (r22 == null) goto L36;
        r18.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID, r22);
    L36:
        SkuViewModel r23 = r12.f;
        if (r23 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L39:
        ECAdLogExtra r24 = r23.getSkuParams().getAdLogExtra();
        if (r24 == null) goto L44;
        String r25 = r24.getGroupId();
        if (r25 == null) goto L44;
        r18.appendQueryParameter("ad_group_id", r25);
    L44:
        SkuViewModel r26 = r12.f;
        if (r26 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L47:
        ECAdLogExtra r27 = r26.getSkuParams().getAdLogExtra();
        if (r27 == null) goto L52;
        String r28 = r27.getAdExtraData();
        if (r28 == null) goto L52;
        r18.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_AD_EXTRA_DATA, r28);
    L52:
        SkuViewModel r29 = r12.f;
        if (r29 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L55:
        ECAdLogExtra r30 = r29.getSkuParams().getAdLogExtra();
        if (r30 == null) goto L60;
        String r31 = r30.getLogExtra();
        if (r31 == null) goto L60;
        r18.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, r31);
    L60:
        SkuViewModel r32 = r12.f;
        if (r32 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L63:
        String r33 = r32.getSkuParams().getV3EventAdditions();
        if (r33 == null) goto L66;
        r18.appendQueryParameter("v3_event_addition", r33);
    L66:
        SkuViewModel r34 = r12.f;
        if (r34 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L69:
        String r35 = r34.getSkuParams().getEntranceInfo();
        if (r35 == null) goto L72;
        r18.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r35);
    L72:
        bf.a.c(r11, r18.build(), false, false);
        SkuViewModel r36 = this.b.a.f;
        if (r36 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L75:
        SkuViewModel.doSkuEventAction$default(r36, "comment_key_word_click", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, "product_params_detail"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_MODULE), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_WORD_NAME, this.a.getTitle()), TuplesKt.to("btm_id", r17)}, null, null, null, 28, null);
        return;
    L12:
        int r110 = ECSdk.a;
        IEShoppingService r111 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r111 == null) goto L25;
        Context r37 = this.b.a.a0().getContext();
        if ((r37 instanceof Activity) == true) goto L17;
        r37 = null;
    L17:
        Activity r38 = (Activity) r37;
        SkuViewModel r39 = this.b.a.f;
        if (r39 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        String r40 = r39.getSkuParams().getRoomId();
        if (r40 == null) goto L23;
        Long r41 = Long.valueOf(CastLongProtector.parseLong(r40));
    L24:
        r111.startShowFloatInNextLifecycle(r38, new n83.c("product_params_detail", r41, null, null));
        goto L25
    L23:
        r41 = null;
        goto L24
    }
}
