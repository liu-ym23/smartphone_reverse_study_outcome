package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 5, 1})
final class GiftKmpDIYService$notifyWriteToDiskCache$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $giftId;
    final /* synthetic */ List $pluginInfo;
    final /* synthetic */ v0 this$0;

    public GiftKmpDIYService$notifyWriteToDiskCache$4(v0 r1, long r2, List r4) {
        this.this$0 = r1;
        this.$giftId = r2;
        this.$pluginInfo = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m315invoke() {
        v0 r3 = this.this$0;
        long r4 = this.$giftId;
        List r6 = this.$pluginInfo;
        r3.getClass();
        FlexModelBase r9 = null;
        Iterable r0 = (List) ((Map) cd6.a.b.getValue(null, cd6.a.a[0])).get(String.valueOf(r4));
        if (r0 != null) goto L5;
        r0 = new ArrayList();
    L5:
        ArrayList<com.bytedance.android.livesdk.gift.model.n> r7 = new ArrayList();
        Iterator r10 = r0.iterator();
        FlexModelBase r11 = null;
    L7:
        if (r10.hasNext() == false) goto L95;
        String r15 = (String) r10.next();
        FlexModelBase r13 = (com.bytedance.android.livesdk.gift.model.n) vh7.f.c(com.bytedance.android.livesdk.gift.model.n.class);
        Intrinsics.checkNotNullParameter(r13, "$this$convertFromString");
        if (r15 != null) goto L11;
    L88:
        v0 r14 = r3;
        long r18 = r4;
    L89:
        FlexModelBase r5 = null;
    L90:
        if (r6 == null) goto L94;
        if (gz1.c.h(new ArrayList(CollectionsKt.toList(r6)), gz1.c.g(r13)) == false) goto L94;
        r11 = r13;
    L94:
        r7.add(r13);
        r9 = r5;
        r3 = r14;
        r4 = r18;
        goto L7
    L11:
        if (r15.length() <= 0) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L16;
        String r2 = r15;
    L17:
        if (r2 == null) goto L88;
        JSONObject r8 = new JSONObject(r15);     // Catch: Exception -> L85
        r13.setMainText(r8.optString("main_text", BuildConfig.FLAVOR));     // Catch: Exception -> L85
        r13.setSubText(r8.optString("sub_text"));     // Catch: Exception -> L85
        r13.setPluginsFlex(gz1.c.d(new JSONArray(r8.optString(com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS))));     // Catch: Exception -> L85
        r14 = r3;
        r18 = r4;
        r13.setTotalDiamonds(r8.optLong("total_diamonds"));     // Catch: Exception -> L83
        String r16 = r8.optString(sz1.a.KEY_LOCAL_ICON_BITMAP);     // Catch: Exception -> L83
        KProperty[] r17 = com.bytedance.android.livesdk.gift.model.o.a;     // Catch: Exception -> L83
        Intrinsics.checkNotNullParameter(r13, "$this$localIconBitmap");     // Catch: Exception -> L83
        vh7.i r19 = com.bytedance.android.livesdk.gift.model.o.b;     // Catch: Exception -> L83
        KProperty[] r20 = com.bytedance.android.livesdk.gift.model.o.a;     // Catch: Exception -> L83
        KProperty r110 = r20[0];     // Catch: Exception -> L83
        if ((r13 instanceof FlexModelBase) == true) goto L23;
        FlexModelBase r21 = null;
    L24:
        FlexModelBase r23 = r21;     // Catch: Exception -> L83
        if (r23 == null) goto L27;
        r23.set(r19.a, r16);     // Catch: Exception -> L83
    L27:
        com.bytedance.android.livesdk.gift.model.j r24 = new com.bytedance.android.livesdk.gift.model.j();     // Catch: Exception -> L83
        Intrinsics.checkNotNullParameter(r13, "$this$giftToolbarFrame");     // Catch: Exception -> L83
        vh7.i r25 = com.bytedance.android.livesdk.gift.model.o.c;     // Catch: Exception -> L83
        KProperty r111 = r20[1];     // Catch: Exception -> L83
        if ((r13 instanceof FlexModelBase) == true) goto L30;
        FlexModelBase r26 = null;
    L31:
        FlexModelBase r27 = r26;     // Catch: Exception -> L83
        if (r27 == null) goto L34;
        r27.set(r25.a, r24);     // Catch: Exception -> L83
    L34:
        com.bytedance.android.livesdk.gift.model.j r28 = com.bytedance.android.livesdk.gift.model.o.b(r13);     // Catch: Exception -> L83
        if (r28 == null) goto L37;
        gz1.b.a(r28, r8.optJSONObject(sz1.a.KEY_GIFT_TOOLBAR_FRAME));     // Catch: Exception -> L83
    L37:
        com.bytedance.android.livesdk.gift.model.j r29 = new com.bytedance.android.livesdk.gift.model.j();     // Catch: Exception -> L83
        Intrinsics.checkNotNullParameter(r13, "$this$giftCellFrame");     // Catch: Exception -> L83
        vh7.i r30 = com.bytedance.android.livesdk.gift.model.o.d;     // Catch: Exception -> L83
        KProperty r31 = r20[2];     // Catch: Exception -> L83
        if ((r13 instanceof FlexModelBase) == true) goto L40;
        FlexModelBase r33 = null;
    L41:
        FlexModelBase r34 = r33;     // Catch: Exception -> L83
        if (r34 == null) goto L44;
        r34.set(r30.a, r29);     // Catch: Exception -> L83
    L44:
        com.bytedance.android.livesdk.gift.model.j r35 = com.bytedance.android.livesdk.gift.model.o.a(r13);     // Catch: Exception -> L83
        if (r35 == null) goto L48;
        gz1.b.a(r35, r8.optJSONObject(sz1.a.KEY_GIFT_CELL_FRAME));     // Catch: Exception -> L83
    L48:
        if (r8.optInt(sz1.a.KEY_IS_RECOMMEND) <= 0) goto L50;
        boolean r112 = true;
    L51:
        Boolean r36 = Boolean.valueOf(r112);     // Catch: Exception -> L83
        Intrinsics.checkNotNullParameter(r13, "$this$isRecommend");     // Catch: Exception -> L83
        vh7.i r37 = com.bytedance.android.livesdk.gift.model.o.e;     // Catch: Exception -> L83
        KProperty r38 = r20[3];     // Catch: Exception -> L83
        if ((r13 instanceof FlexModelBase) == true) goto L54;
        FlexModelBase r39 = null;
    L55:
        FlexModelBase r40 = r39;     // Catch: Exception -> L83
        if (r40 == null) goto L58;
        r40.set(r37.a, r36);     // Catch: Exception -> L83
    L58:
        Boolean r41 = Boolean.valueOf(r8.optBoolean("is_local"));     // Catch: Exception -> L83
        Intrinsics.checkNotNullParameter(r13, "$this$isLocal");     // Catch: Exception -> L83
        vh7.i r43 = com.bytedance.android.livesdk.gift.model.o.g;     // Catch: Exception -> L83
        KProperty r44 = r20[5];     // Catch: Exception -> L83
        if ((r13 instanceof FlexModelBase) == true) goto L61;
        FlexModelBase r45 = null;
    L62:
        FlexModelBase r46 = r45;     // Catch: Exception -> L83
        if (r46 == null) goto L65;
        r46.set(r43.a, r41);     // Catch: Exception -> L83
    L65:
        r13.setMainTextAfterSend(r8.optString("main_text_after_send"));     // Catch: Exception -> L83
        Boolean r47 = Boolean.valueOf(r8.optBoolean("is_new_card"));     // Catch: Exception -> L74
        Intrinsics.checkNotNullParameter(r13, "$this$isNewCard");     // Catch: Exception -> L74
        vh7.i r48 = com.bytedance.android.livesdk.gift.model.o.f;     // Catch: Exception -> L74
        KProperty r49 = r20[4];     // Catch: Exception -> L74
        if ((r13 instanceof FlexModelBase) == true) goto L69;
        FlexModelBase r50 = null;
    L70:
        FlexModelBase r51 = r50;     // Catch: Exception -> L74
        if (r51 == null) goto L89;
        r51.set(r48.a, r47);     // Catch: Exception -> L74
    L69:
        r50 = r13;
    L74:
        Boolean r53 = Boolean.FALSE;     // Catch: Exception -> L83
        KProperty[] r54 = com.bytedance.android.livesdk.gift.model.o.a;     // Catch: Exception -> L83
        Intrinsics.checkNotNullParameter(r13, "$this$isNewCard");     // Catch: Exception -> L83
        vh7.i r55 = com.bytedance.android.livesdk.gift.model.o.f;     // Catch: Exception -> L83
        KProperty r56 = com.bytedance.android.livesdk.gift.model.o.a[4];     // Catch: Exception -> L83
        if ((r13 instanceof FlexModelBase) == true) goto L77;
        FlexModelBase r57 = null;
    L78:
        FlexModelBase r58 = r57;     // Catch: Exception -> L83
        if (r58 == null) goto L81;
        r58.set(r55.a, r53);     // Catch: Exception -> L83
    L81:
        jy0.b.c(sz1.a.TAG, "isOldCard", null, 4);     // Catch: Exception -> L83
        goto L89
    L77:
        r57 = r13;
        goto L78
    L61:
        r45 = r13;
        goto L62
    L54:
        r39 = r13;
        goto L55
    L50:
        r112 = false;
        goto L51
    L40:
        r33 = r13;
        goto L41
    L30:
        r26 = r13;
        goto L31
    L23:
        r21 = r13;
    L83:
        e = e;
    L87:
        r5 = null;
        jy0.b.c(sz1.a.TAG, "convertFromString exception: " + e.getMessage() + " string: " + r15, null, 4);
    L85:
        e = e;
        r14 = r3;
        r18 = r4;
        goto L87
    L16:
        r2 = null;
        goto L17
    L13:
        r1 = false;
        goto L14
    L95:
        v0 r113 = r3;
        long r114 = r4;
        FlexModelBase r59 = r9;
        if (r11 == null) goto L102;
        if (r7.remove(r11) == false) goto L100;
        ListProtector.add(r7, 0, r11);
    L100:
        r113.a(r7, r114);
        return;
    L102:
        if (r6 != null) goto L104;
    L113:
        FlexModelBase r60 = r59;
    L114:
        if (r60 == null) goto L128;
        ListProtector.add(r7, 0, r60);
        r113.a(r7, r114);
        return;
    L128:
        return;
    L104:
        if ((!r6.isEmpty()) != true) goto L113;
        FlexModelBase r61 = (com.bytedance.android.livesdk.gift.model.n) vh7.f.c(com.bytedance.android.livesdk.gift.model.n.class);
        ArrayList r63 = new ArrayList(CollectionsKt.toList(r6));
        Intrinsics.checkNotNullParameter(r61, "$this$plugins");
        Intrinsics.checkNotNullParameter(r63, "value");
        r61.setPluginsFlex(r63);
        Boolean r64 = Boolean.TRUE;
        KProperty[] r65 = com.bytedance.android.livesdk.gift.model.o.a;
        Intrinsics.checkNotNullParameter(r61, "$this$isRecommend");
        vh7.i r66 = com.bytedance.android.livesdk.gift.model.o.e;
        KProperty r67 = com.bytedance.android.livesdk.gift.model.o.a[3];
        if ((r61 instanceof FlexModelBase) == true) goto L108;
        FlexModelBase r68 = r59;
    L109:
        FlexModelBase r69 = r68;
        if (r69 == null) goto L112;
        r69.set(r66.a, r64);
    L112:
        r60 = r61;
        goto L114
    L108:
        r68 = r61;
        goto L109
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m315invoke();
        return Unit.INSTANCE;
    }
}
