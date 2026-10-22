package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AnchorHeightFixMode;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AudienceHeightFixMode;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.live.layout.AdjustBase;
import com.bytedance.live.layout.LayoutAlign;
import com.bytedance.live.layout.LayoutScale;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import t51.e;
import t51.g;
import t51.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt51/g;", "invoke", "()Lt51/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class DefaultConfig$fullConfig$2 extends FunctionReferenceImpl implements Function0<g> {
    public DefaultConfig$fullConfig$2(DefaultConfig r8) {
        super(0, r8, DefaultConfig.class, "initFullConfig", "initFullConfig()Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/RevLayoutConfig;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final g m950invoke() {
        DefaultConfig r1 = (DefaultConfig) ((CallableReference) this).receiver;
        int r2 = DefaultConfig.m;
        r1.getClass();
        g r3 = new g();
        LinkedHashMap r4 = new LinkedHashMap();
        Integer r5 = Integer.valueOf(DeviceType.NORMAL_MOBILE.ordinal());
        t51.a r6 = new t51.a();
        AdjustBase r7 = AdjustBase.CANVAS;
        r6.m(r7.ordinal());
        r6.t(LayoutScale.FIT_HEIGHT.ordinal());
        LayoutAlign r8 = LayoutAlign.RIGHT_CENTER;
        r6.n(r8.ordinal());
        i r9 = new i();
        float r10 = 0.0f;
        r9.j(0.0f);
        r9.m(0.0f);
        r9.k(1.0f);
        r9.i(1.0f);
        Unit r12 = Unit.INSTANCE;
        r6.v(r9);
        AnchorHeightFixMode r13 = AnchorHeightFixMode.PreviewHeight;
        r6.p(r13.ordinal());
        AudienceHeightFixMode r14 = AudienceHeightFixMode.OriginContainerHeight;
        r6.r(r14.ordinal());
        r4.put(r5, r6);
        Integer r15 = Integer.valueOf(DeviceType.PAD_V.ordinal());
        t51.a r16 = new t51.a();
        r16.m(r7.ordinal());
        LayoutScale r17 = LayoutScale.ASPECT_FIT;
        r16.t(r17.ordinal());
        r16.n(r8.ordinal());
        i r18 = new i();
        r18.j(0.0f);
        r18.m(0.0f);
        r18.k(1.0f);
        r18.i(1.0f);
        r16.v(r18);
        r16.p(r13.ordinal());
        r16.r(r14.ordinal());
        r4.put(r15, r16);
        Integer r19 = Integer.valueOf(DeviceType.PAD_H.ordinal());
        t51.a r20 = new t51.a();
        r20.m(r7.ordinal());
        r20.t(r17.ordinal());
        r20.n(LayoutAlign.CENTER.ordinal());
        i r22 = new i();
        r22.j(0.0f);
        r22.m(0.0f);
        r22.k(1.0f);
        r22.i(1.0f);
        r20.v(r22);
        r20.p(r13.ordinal());
        r20.r(r14.ordinal());
        r4.put(r19, r20);
        r3.g(r4);
        DefaultConfig$initFullConfig$1$2 r23 = DefaultConfig$initFullConfig$1$2.INSTANCE;
        ArrayList r24 = new ArrayList();
        int r25 = 0;
    L3:
        double r26 = 0.7889999999999999d;
        if (r25 > 4) goto L9;
        if (r25 != 0) goto L7;
        e r110 = new e();
        r110.m(0.0f);
        r110.n((float) s11.a.a);
        r110.l((float) 0.768d);
        r110.h((float) 0.7889999999999999d);
        r110.i(r25);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r111 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r112 = Integer.valueOf(r111.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.j r113 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.j.c;
        IAnchorUpdateLayoutContent.AnchorLayoutRange r114 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom;
        Integer r115 = Integer.valueOf(r114.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.k r116 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.k.c;
        r110.t(MapsKt.mapOf(new Pair[]{TuplesKt.to(r112, 13), TuplesKt.to(r115, 12)}));
        r110.r(MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(r111.ordinal()), 12), TuplesKt.to(Integer.valueOf(r114.ordinal()), 12)}));
        Unit r27 = Unit.INSTANCE;
        r24.add(r110);
    L8:
        r25 = r25 + 1;
        goto L3
    L7:
        e r28 = new e();
        r28.m((float) 0.7707777777777778d);
        r28.n((float) (s11.a.a + (((double) (r25 - 1)) * 0.197640625d)));
        r28.l((float) 0.22922222222222222d);
        r28.h((float) 0.196078125d);
        r28.i(r25);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r29 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r30 = Integer.valueOf(r29.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.j r117 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.j.c;
        r28.t(MapsKt.mapOf(TuplesKt.to(r30, 13)));
        r28.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r29.ordinal()), 13)));
        Unit r32 = Unit.INSTANCE;
        r24.add(r28);
        goto L8
    L9:
        ArrayList r33 = new ArrayList();
        int r118 = 0;
    L11:
        if (r118 > 5) goto L17;
        if (r118 != 0) goto L15;
        e r119 = new e();
        r119.m(0.0f);
        ArrayList r120 = r33;
        r119.n((float) s11.a.a);
        r119.l((float) 0.768d);
        r119.h((float) r26);
        r119.i(r118);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r34 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r35 = Integer.valueOf(r34.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.l r121 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.l.c;
        IAnchorUpdateLayoutContent.AnchorLayoutRange r36 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom;
        Integer r122 = Integer.valueOf(r36.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.k r123 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.k.c;
        r119.t(MapsKt.mapOf(new Pair[]{TuplesKt.to(r35, 14), TuplesKt.to(r122, 12)}));
        r119.r(MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(r34.ordinal()), 12), TuplesKt.to(Integer.valueOf(r36.ordinal()), 12)}));
        Unit r37 = Unit.INSTANCE;
        ArrayList r38 = r120;
        r38.add(r119);
    L16:
        r118 = r118 + 1;
        r33 = r38;
        r26 = 0.7889999999999999d;
        goto L11
    L15:
        r38 = r33;
        e r39 = new e();
        r39.m((float) 0.7707777777777778d);
        r39.n((float) (s11.a.a + (((double) (r118 - 1)) * 0.1581125d)));
        r39.l((float) 0.22922222222222222d);
        r39.h((float) 0.15655d);
        r39.i(r118);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r40 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r124 = Integer.valueOf(r40.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.l r125 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.l.c;
        r39.t(MapsKt.mapOf(TuplesKt.to(r124, 14)));
        r39.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r40.ordinal()), 14)));
        Unit r42 = Unit.INSTANCE;
        r38.add(r39);
        goto L16
    L17:
        ArrayList r43 = r33;
        ArrayList r44 = new ArrayList();
        int r45 = 0;
    L18:
        double r126 = 0.4986111111111111d;
        double r46 = 0.6807210286458334d;
        if (r45 > 6) goto L25;
        if (r45 != 0) goto L23;
        e r127 = new e();
        r127.m(r10);
        r127.n((float) s11.a.a);
        r127.l((float) 0.4986111111111111d);
        r127.h((float) 0.6807210286458334d);
        r127.i(r45);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r47 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r48 = Integer.valueOf(r47.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.m r128 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.m.c;
        IAnchorUpdateLayoutContent.AnchorLayoutRange r49 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom;
        Integer r129 = Integer.valueOf(r49.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.n r130 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.n.c;
        r127.t(MapsKt.mapOf(new Pair[]{TuplesKt.to(r48, 16), TuplesKt.to(r129, 15)}));
        r127.r(MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(r47.ordinal()), 15), TuplesKt.to(Integer.valueOf(r49.ordinal()), 15)}));
        Unit r50 = Unit.INSTANCE;
        r44.add(r127);
    L24:
        r45 = r45 + 1;
        r10 = 0.0f;
        goto L18
    L23:
        e r52 = new e();
        int r53 = r45 - 1;
        r52.m((float) ((((double) (r53 % 2)) * 0.25069444444444444d) + 0.5013888888888889d));
        r52.n((float) (s11.a.a + (((double) (r53 / 2)) * 0.22742784288194445d)));
        r52.l((float) 0.24791666666666667d);
        r52.h((float) 0.22586534288194446d);
        r52.i(r45);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r54 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r55 = Integer.valueOf(r54.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.m r131 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.m.c;
        r52.t(MapsKt.mapOf(TuplesKt.to(r55, 16)));
        r52.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r54.ordinal()), 16)));
        Unit r56 = Unit.INSTANCE;
        r44.add(r52);
        goto L24
    L25:
        ArrayList r57 = new ArrayList();
        int r58 = 0;
    L27:
        if (r58 > 7) goto L32;
        if (r58 != 0) goto L30;
        e r59 = new e();
        r59.m(0.0f);
        r59.n((float) s11.a.a);
        r59.l((float) r126);
        r59.h((float) r46);
        r59.i(r58);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r132 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r60 = Integer.valueOf(r132.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.o r133 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.o.c;
        IAnchorUpdateLayoutContent.AnchorLayoutRange r62 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom;
        Integer r134 = Integer.valueOf(r62.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.n r210 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.n.c;
        r59.t(MapsKt.mapOf(new Pair[]{TuplesKt.to(r60, 17), TuplesKt.to(r134, 15)}));
        r59.r(MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(r132.ordinal()), 15), TuplesKt.to(Integer.valueOf(r62.ordinal()), 15)}));
        Unit r63 = Unit.INSTANCE;
        r57.add(r59);
    L31:
        r58 = r58 + 1;
        r46 = 0.6807210286458334d;
        r126 = 0.4986111111111111d;
        goto L27
    L30:
        e r64 = new e();
        int r65 = r58 - 1;
        r64.m((float) ((((double) (r65 % 2)) * 0.25069444444444444d) + 0.5013888888888889d));
        r64.n((float) (s11.a.a + (((double) (r65 / 2)) * 0.17057088216145835d)));
        r64.l((float) 0.24791666666666667d);
        r64.h((float) 0.16900838216145836d);
        r64.i(r58);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r66 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r135 = Integer.valueOf(r66.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.o r136 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.o.c;
        r64.t(MapsKt.mapOf(TuplesKt.to(r135, 17)));
        r64.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r66.ordinal()), 17)));
        Unit r67 = Unit.INSTANCE;
        r57.add(r64);
        goto L31
    L32:
        ArrayList r68 = new ArrayList();
        int r69 = 0;
    L34:
        if (r69 > 8) goto L39;
        if (r69 != 0) goto L37;
        e r137 = new e();
        r137.m(0.0f);
        r137.n((float) s11.a.a);
        r137.l((float) 0.4986111111111111d);
        r137.h((float) 0.6807210286458334d);
        r137.i(r69);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r70 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r138 = Integer.valueOf(r70.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.o r211 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.o.c;
        IAnchorUpdateLayoutContent.AnchorLayoutRange r139 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom;
        Integer r140 = Integer.valueOf(r139.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.n r141 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.n.c;
        r137.t(MapsKt.mapOf(new Pair[]{TuplesKt.to(r138, 17), TuplesKt.to(r140, 15)}));
        r137.r(MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(r70.ordinal()), 15), TuplesKt.to(Integer.valueOf(r139.ordinal()), 15)}));
        Unit r72 = Unit.INSTANCE;
        r68.add(r137);
        long r142 = 4595257188985934098L;
    L38:
        r69 = r69 + 1;
        goto L34
    L37:
        e r73 = new e();
        int r143 = r69 - 1;
        r73.m((float) ((((double) (r143 % 2)) * 0.25069444444444444d) + 0.5013888888888889d));
        r73.n((float) (s11.a.a + (((double) (r143 / 2)) * 0.17057088216145835d)));
        r73.l((float) 0.24791666666666667d);
        r142 = 4595257188985934098L;
        r73.h((float) 0.16900838216145836d);
        r73.i(r69);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r144 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r145 = Integer.valueOf(r144.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.o r146 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.o.c;
        r73.t(MapsKt.mapOf(TuplesKt.to(r145, 17)));
        r73.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r144.ordinal()), 17)));
        Unit r147 = Unit.INSTANCE;
        r68.add(r73);
        goto L38
    L39:
        r3.i(MapsKt.mapOf(new Pair[]{TuplesKt.to(1, r23.invoke(1, true)), TuplesKt.to(2, r23.invoke(2, true)), TuplesKt.to(3, r23.invoke(3, true)), TuplesKt.to(4, r23.invoke(4, true)), TuplesKt.to(5, r24), TuplesKt.to(6, r43), TuplesKt.to(7, r44), TuplesKt.to(8, r57), TuplesKt.to(9, r68)}));
        r3.j(MapsKt.mapOf(new Pair[]{TuplesKt.to(1, DefaultConfig$initFullConfig$1$2.invoke$default(r23, 1, false, 2, null)), TuplesKt.to(2, DefaultConfig$initFullConfig$1$2.invoke$default(r23, 2, false, 2, null)), TuplesKt.to(3, DefaultConfig$initFullConfig$1$2.invoke$default(r23, 3, false, 2, null)), TuplesKt.to(4, DefaultConfig$initFullConfig$1$2.invoke$default(r23, 4, false, 2, null)), TuplesKt.to(5, r24), TuplesKt.to(6, r43), TuplesKt.to(7, r44), TuplesKt.to(8, r57), TuplesKt.to(9, r68)}));
        r3.h(MapsKt.mapOf(new Pair[]{TuplesKt.to(1, DefaultConfig$initFullConfig$1$2.invoke$default(r23, 1, false, 2, null)), TuplesKt.to(2, DefaultConfig$initFullConfig$1$2.invoke$default(r23, 2, false, 2, null)), TuplesKt.to(3, DefaultConfig$initFullConfig$1$2.invoke$default(r23, 3, false, 2, null)), TuplesKt.to(4, DefaultConfig$initFullConfig$1$2.invoke$default(r23, 4, false, 2, null)), TuplesKt.to(5, r24), TuplesKt.to(6, r43), TuplesKt.to(7, r44), TuplesKt.to(8, r57), TuplesKt.to(9, r68)}));
        return r3;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m950invoke();
    }
}
