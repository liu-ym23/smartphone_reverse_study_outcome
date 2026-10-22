package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v0 implements u2, com.bytedance.android.scope.o {
    public final HashMap<String, List<com.bytedance.android.livesdk.gift.model.n>> a;
    public final HashMap<String, List<com.bytedance.android.livesdk.gift.model.e3>> b;
    public final sc6.a c;
    public final jy0.a d;

    public final void onStart() {
    }

    public final void onStop() {
        this.a.clear();
        this.b.clear();
    }

    public v0(sc6.a r2, jy0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "giftDetailRepository");
        Intrinsics.checkNotNullParameter(r3, "aLogService");
        this.c = r2;
        this.d = r3;
        this.a = new HashMap();
        this.b = new HashMap();
    }

    public final void a(ArrayList<com.bytedance.android.livesdk.gift.model.n> r11, long r13) {
        ArrayList r0 = new ArrayList();
        Iterator<com.bytedance.android.livesdk.gift.model.n> r14 = r11.iterator();
    L3:
        Object r2 = null;
        boolean r3 = false;
        if (r14.hasNext() == false) goto L58;
        com.bytedance.android.livesdk.gift.model.n r1 = r14.next();
        Intrinsics.checkNotNullParameter(r1, "$this$convertToString");
        JSONObject r4 = new JSONObject();
        r4.put("main_text", r1.getMainText());
        r4.put("sub_text", r1.getSubText());
        r4.put(com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS, gz1.c.a(gz1.c.g(r1), 1));
        r4.put("total_diamonds", r1.getTotalDiamonds());
        KProperty[] r5 = com.bytedance.android.livesdk.gift.model.o.a;
        Intrinsics.checkNotNullParameter(r1, "$this$localIconBitmap");
        vh7.i r6 = com.bytedance.android.livesdk.gift.model.o.b;
        KProperty[] r7 = com.bytedance.android.livesdk.gift.model.o.a;
        KProperty r8 = r7[0];
        boolean r9 = r1 instanceof FlexModelBase;
        if (r9 == true) goto L8;
        com.bytedance.android.livesdk.gift.model.n r10 = null;
    L9:
        FlexModelBase r15 = (FlexModelBase) r10;
        if (r15 == null) goto L12;
        Object r16 = r15.get(r6.a);
    L13:
        String r17 = (String) r16;
        String r18 = BuildConfig.FLAVOR;
        if (r17 != null) goto L16;
        r17 = BuildConfig.FLAVOR;
    L16:
        r4.put(sz1.a.KEY_LOCAL_ICON_BITMAP, r17);
        com.bytedance.android.livesdk.gift.model.j r19 = com.bytedance.android.livesdk.gift.model.o.b(r1);
        if (r19 == null) goto L19;
        JSONObject r20 = gz1.b.b(r19);
    L20:
        r4.put(sz1.a.KEY_GIFT_TOOLBAR_FRAME, r20);
        com.bytedance.android.livesdk.gift.model.j r21 = com.bytedance.android.livesdk.gift.model.o.a(r1);
        if (r21 == null) goto L23;
        JSONObject r23 = gz1.b.b(r21);
    L24:
        r4.put(sz1.a.KEY_GIFT_CELL_FRAME, r23);
        Intrinsics.checkNotNullParameter(r1, "$this$isRecommend");
        vh7.i r24 = com.bytedance.android.livesdk.gift.model.o.e;
        KProperty r25 = r7[3];
        if (r9 == true) goto L27;
        com.bytedance.android.livesdk.gift.model.n r26 = null;
    L28:
        FlexModelBase r27 = (FlexModelBase) r26;
        if (r27 == null) goto L31;
        Object r28 = r27.get(r24.a);
    L32:
        r4.put(sz1.a.KEY_IS_RECOMMEND, Intrinsics.areEqual((Boolean) r28, Boolean.TRUE) ? 1 : 0);
        String r29 = r1.getMainTextAfterSend();
        if (r29 == null) goto L36;
        r18 = r29;
    L36:
        r4.put("main_text_after_send", r18);
        Intrinsics.checkNotNullParameter(r1, "$this$isNewCard");
        vh7.i r30 = com.bytedance.android.livesdk.gift.model.o.f;
        KProperty r31 = r7[4];
        if (r9 == true) goto L39;
        com.bytedance.android.livesdk.gift.model.n r33 = null;
    L40:
        FlexModelBase r34 = (FlexModelBase) r33;
        if (r34 == null) goto L43;
        Object r35 = r34.get(r30.a);
    L44:
        Boolean r36 = (Boolean) r35;
        if (r36 == null) goto L47;
        boolean r37 = r36.booleanValue();
    L48:
        r4.put("is_new_card", r37);
        Intrinsics.checkNotNullParameter(r1, "$this$isLocal");
        vh7.i r38 = com.bytedance.android.livesdk.gift.model.o.g;
        KProperty r39 = r7[5];
        if (r9 == true) goto L51;
        r1 = null;
    L51:
        FlexModelBase r40 = (FlexModelBase) r1;
        if (r40 == null) goto L54;
        r2 = r40.get(r38.a);
    L54:
        Boolean r41 = (Boolean) r2;
        if (r41 == null) goto L57;
        r3 = r41.booleanValue();
    L57:
        r4.put("is_local", r3);
        r0.add(r4.toString());
        goto L3
    L47:
        r37 = false;
        goto L48
    L43:
        r35 = null;
        goto L44
    L39:
        r33 = r1;
        goto L40
    L31:
        r28 = null;
        goto L32
    L27:
        r26 = r1;
        goto L28
    L23:
        r23 = new JSONObject();
        goto L24
    L19:
        r20 = new JSONObject();
        goto L20
    L12:
        r16 = null;
        goto L13
    L8:
        r10 = r1;
        goto L9
    L58:
        com.bytedance.tools.kcp.spongepreference.runtime.a r110 = cd6.a.b;
        KProperty[] r43 = cd6.a.a;
        Map r44 = MapsKt.toMutableMap((Map) r110.getValue(null, r43[0]));
        r44.put(String.valueOf(r13), r0);
        Intrinsics.checkNotNullParameter(r44, "<set-?>");
        r110.setValue(null, r43[0], r44);
    }
}
