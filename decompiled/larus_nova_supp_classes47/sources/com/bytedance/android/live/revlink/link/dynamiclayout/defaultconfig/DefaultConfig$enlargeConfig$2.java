package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import t51.e;
import t51.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt51/g;", "invoke", "()Lt51/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class DefaultConfig$enlargeConfig$2 extends FunctionReferenceImpl implements Function0<g> {
    public DefaultConfig$enlargeConfig$2(DefaultConfig r8) {
        super(0, r8, DefaultConfig.class, "initEnlargeConfig", "initEnlargeConfig()Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/RevLayoutConfig;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final g m948invoke() {
        DefaultConfig r1 = (DefaultConfig) ((CallableReference) this).receiver;
        int r2 = DefaultConfig.m;
        r1.getClass();
        g r3 = new g();
        LinkedHashMap r4 = new LinkedHashMap();
        r4.putAll(r1.c().b());
        DeviceType r5 = DeviceType.NORMAL_MOBILE;
        r4.put(Integer.valueOf(r5.ordinal() + 512), DefaultConfig.a());
        r4.put(Integer.valueOf(r5.ordinal() + 1024), DefaultConfig.a());
        Unit r6 = Unit.INSTANCE;
        r3.g(r4);
        Map<Integer, ? extends List<e>> r7 = MapsKt.toMutableMap(r1.c().e());
        e r8 = new e();
        r8.m(0.0f);
        double r9 = s11.a.a;
        float r10 = (float) r9;
        r8.n(r10);
        r8.l((float) 0.6613333333333333d);
        r8.h((float) 0.693d);
        r8.i(0);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r12 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r13 = Integer.valueOf(r12.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.c r14 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.c.c;
        r8.t(MapsKt.mapOf(TuplesKt.to(r13, 3)));
        r8.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r12.ordinal()), 3)));
        e r15 = new e();
        float r16 = (float) 0.6641111111111111d;
        r15.m(r16);
        r15.n(r10);
        float r17 = (float) 0.3358888888888889d;
        r15.l(r17);
        float r18 = (float) 0.2299583333333333d;
        r15.h(r18);
        r15.i(1);
        Integer r19 = Integer.valueOf(r12.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.d r110 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.d.c;
        r15.t(MapsKt.mapOf(TuplesKt.to(r19, 4)));
        r15.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r12.ordinal()), 4)));
        e r20 = new e();
        r20.m(r16);
        r20.n((float) ((r9 + 0.2299583333333333d) + 0.0015625d));
        r20.l(r17);
        r20.h(r18);
        int r22 = 2;
        r20.i(2);
        r20.t(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r12.ordinal()), 3)));
        r20.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r12.ordinal()), 3)));
        e r23 = new e();
        r23.m(r16);
        r23.n((float) (r9 + 0.4630416666666666d));
        r23.l(r17);
        r23.h(r18);
        r23.i(3);
        r23.t(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r12.ordinal()), 3)));
        r23.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r12.ordinal()), 3)));
        r7.put(4, CollectionsKt.listOf(new e[]{r8, r15, r20, r23}));
        ArrayList r24 = new ArrayList();
        int r25 = 0;
    L3:
        double r26 = 0.7707777777777778d;
        double r111 = 0.768d;
        if (r25 > 4) goto L10;
        if (r25 != 0) goto L8;
        e r27 = new e();
        r27.m(0.0f);
        r27.n((float) s11.a.a);
        r27.l((float) 0.768d);
        r27.h((float) 0.7889999999999999d);
        r27.i(r25);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r112 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r113 = Integer.valueOf(r112.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.j r114 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.j.c;
        IAnchorUpdateLayoutContent.AnchorLayoutRange r115 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom;
        Integer r116 = Integer.valueOf(r115.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.k r117 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.k.c;
        r27.t(MapsKt.mapOf(new Pair[]{TuplesKt.to(r113, 13), TuplesKt.to(r116, 12)}));
        r27.r(MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(r112.ordinal()), 12), TuplesKt.to(Integer.valueOf(r115.ordinal()), 12)}));
        Unit r28 = Unit.INSTANCE;
        r24.add(r27);
    L9:
        r25 = r25 + 1;
        goto L3
    L8:
        e r118 = new e();
        r118.m((float) 0.7707777777777778d);
        r118.n((float) (s11.a.a + (((double) (r25 - 1)) * 0.197640625d)));
        r118.l((float) 0.22922222222222222d);
        r118.h((float) 0.196078125d);
        r118.i(r25);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r29 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r30 = Integer.valueOf(r29.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.j r119 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.j.c;
        r118.t(MapsKt.mapOf(TuplesKt.to(r30, 13)));
        r118.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r29.ordinal()), 13)));
        Unit r32 = Unit.INSTANCE;
        r24.add(r118);
        goto L9
    L10:
        int r33 = 5;
        r7.put(5, r24);
        ArrayList r34 = new ArrayList();
        int r35 = 0;
    L11:
        if (r35 > r33) goto L17;
        if (r35 != 0) goto L15;
        e r36 = new e();
        r36.m(0.0f);
        r36.n((float) s11.a.a);
        r36.l((float) r111);
        r36.h((float) 0.7889999999999999d);
        r36.i(r35);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r120 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r37 = Integer.valueOf(r120.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.l r210 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.l.c;
        IAnchorUpdateLayoutContent.AnchorLayoutRange r121 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom;
        Integer r122 = Integer.valueOf(r121.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.k r123 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.k.c;
        r36.t(MapsKt.mapOf(new Pair[]{TuplesKt.to(r37, 14), TuplesKt.to(r122, 12)}));
        r36.r(MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(r120.ordinal()), 12), TuplesKt.to(Integer.valueOf(r121.ordinal()), 12)}));
        Unit r124 = Unit.INSTANCE;
        r34.add(r36);
        long r38 = 4597426621207215720L;
    L16:
        r35 = r35 + 1;
        r33 = 5;
        r26 = 0.7707777777777778d;
        r111 = 0.768d;
        goto L11
    L15:
        e r39 = new e();
        r39.m((float) r26);
        r39.n((float) (s11.a.a + (((double) (r35 - 1)) * 0.1581125d)));
        r38 = 4597426621207215720L;
        r39.l((float) 0.22922222222222222d);
        r39.h((float) 0.15655d);
        r39.i(r35);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r125 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r126 = Integer.valueOf(r125.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.l r127 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.l.c;
        r39.t(MapsKt.mapOf(TuplesKt.to(r126, 14)));
        r39.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r125.ordinal()), 14)));
        Unit r128 = Unit.INSTANCE;
        r34.add(r39);
        goto L16
    L17:
        int r40 = 6;
        r7.put(6, r34);
        ArrayList r42 = new ArrayList();
        int r43 = 0;
    L18:
        double r44 = 0.4986111111111111d;
        if (r43 > r40) goto L25;
        if (r43 != 0) goto L23;
        e r129 = new e();
        r129.m(0.0f);
        ArrayList r211 = r42;
        r129.n((float) s11.a.a);
        r129.l((float) 0.4986111111111111d);
        r129.h((float) 0.6807210286458334d);
        r129.i(r43);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r45 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r46 = Integer.valueOf(r45.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.m r47 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.m.c;
        IAnchorUpdateLayoutContent.AnchorLayoutRange r48 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom;
        Integer r49 = Integer.valueOf(r48.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.n r130 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.n.c;
        r129.t(MapsKt.mapOf(new Pair[]{TuplesKt.to(r46, 16), TuplesKt.to(r49, 15)}));
        r129.r(MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(r45.ordinal()), 15), TuplesKt.to(Integer.valueOf(r48.ordinal()), 15)}));
        Unit r50 = Unit.INSTANCE;
        ArrayList r52 = r211;
        r52.add(r129);
    L24:
        r43 = r43 + 1;
        r42 = r52;
        r40 = 6;
        goto L18
    L23:
        r52 = r42;
        e r53 = new e();
        int r54 = r43 - 1;
        r53.m((float) ((((double) (r54 % 2)) * 0.25069444444444444d) + 0.5013888888888889d));
        r53.n((float) (s11.a.a + (((double) (r54 / 2)) * 0.22742784288194445d)));
        r53.l((float) 0.24791666666666667d);
        r53.h((float) 0.22586534288194446d);
        r53.i(r43);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r55 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r56 = Integer.valueOf(r55.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.m r131 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.m.c;
        r53.t(MapsKt.mapOf(TuplesKt.to(r56, 16)));
        r53.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r55.ordinal()), 16)));
        Unit r57 = Unit.INSTANCE;
        r52.add(r53);
        goto L24
    L25:
        ArrayList r58 = r42;
        double r59 = 0.6807210286458334d;
        int r132 = 7;
        r7.put(7, r58);
        ArrayList r60 = new ArrayList();
        int r133 = 0;
    L27:
        if (r133 > r132) goto L32;
        if (r133 != 0) goto L30;
        e r134 = new e();
        r134.m(0.0f);
        r134.n((float) s11.a.a);
        r134.l((float) 0.4986111111111111d);
        r134.h((float) r59);
        r134.i(r133);
        Pair[] r135 = new Pair[r22];
        IAnchorUpdateLayoutContent.AnchorLayoutRange r136 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r62 = Integer.valueOf(r136.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.o r212 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.o.c;
        r135[0] = TuplesKt.to(r62, 17);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r137 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom;
        Integer r63 = Integer.valueOf(r137.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.n r138 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.n.c;
        r135[1] = TuplesKt.to(r63, 15);
        r134.t(MapsKt.mapOf(r135));
        Pair[] r139 = new Pair[r22];
        r139[0] = TuplesKt.to(Integer.valueOf(r136.ordinal()), 15);
        r139[1] = TuplesKt.to(Integer.valueOf(r137.ordinal()), 15);
        r134.r(MapsKt.mapOf(r139));
        Unit r140 = Unit.INSTANCE;
        r60.add(r134);
    L31:
        r133 = r133 + 1;
        r59 = 0.6807210286458334d;
        r22 = 2;
        r132 = 7;
        goto L27
    L30:
        e r141 = new e();
        int r142 = r133 - 1;
        r141.m((float) ((((double) (r142 % 2)) * 0.25069444444444444d) + 0.5013888888888889d));
        r141.n((float) (s11.a.a + (((double) (r142 / r22)) * 0.17057088216145835d)));
        r141.l((float) 0.24791666666666667d);
        r141.h((float) 0.16900838216145836d);
        r141.i(r133);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r64 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r65 = Integer.valueOf(r64.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.o r66 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.o.c;
        r141.t(MapsKt.mapOf(TuplesKt.to(r65, 17)));
        r141.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r64.ordinal()), 17)));
        Unit r67 = Unit.INSTANCE;
        r60.add(r141);
        goto L31
    L32:
        int r68 = 8;
        r7.put(8, r60);
        ArrayList r69 = new ArrayList();
        int r70 = 0;
    L33:
        if (r70 > r68) goto L38;
        if (r70 != 0) goto L36;
        e r72 = new e();
        r72.m(0.0f);
        r72.n((float) s11.a.a);
        r72.l((float) r44);
        r72.h((float) 0.6807210286458334d);
        r72.i(r70);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r213 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r73 = Integer.valueOf(r213.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.o r214 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.o.c;
        IAnchorUpdateLayoutContent.AnchorLayoutRange r74 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom;
        Integer r75 = Integer.valueOf(r74.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.n r76 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.n.c;
        r72.t(MapsKt.mapOf(new Pair[]{TuplesKt.to(r73, 17), TuplesKt.to(r75, 15)}));
        r72.r(MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(r213.ordinal()), 15), TuplesKt.to(Integer.valueOf(r74.ordinal()), 15)}));
        Unit r77 = Unit.INSTANCE;
        r69.add(r72);
    L37:
        r70 = r70 + 1;
        r68 = 8;
        r44 = 0.4986111111111111d;
        goto L33
    L36:
        e r78 = new e();
        int r79 = r70 - 1;
        r78.m((float) ((((double) (r79 % 2)) * 0.25069444444444444d) + 0.5013888888888889d));
        r78.n((float) (s11.a.a + (((double) (r79 / 2)) * 0.17057088216145835d)));
        r78.l((float) 0.24791666666666667d);
        r78.h((float) 0.16900838216145836d);
        r78.i(r70);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r80 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r82 = Integer.valueOf(r80.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.o r143 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.o.c;
        r78.t(MapsKt.mapOf(TuplesKt.to(r82, 17)));
        r78.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r80.ordinal()), 17)));
        Unit r83 = Unit.INSTANCE;
        r69.add(r78);
        goto L37
    L38:
        r7.put(9, r69);
        Unit r84 = Unit.INSTANCE;
        r3.i(r7);
        return r3;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m948invoke();
    }
}
