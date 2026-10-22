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
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import r41.f;
import t51.d;
import t51.e;
import t51.g;
import t51.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt51/g;", "invoke", "()Lt51/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class DefaultConfig$normalConfig$2 extends FunctionReferenceImpl implements Function0<g> {
    public DefaultConfig$normalConfig$2(DefaultConfig r8) {
        super(0, r8, DefaultConfig.class, "initNormalConfig", "initNormalConfig()Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/RevLayoutConfig;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final g m955invoke() {
        DefaultConfig r1 = (DefaultConfig) ((CallableReference) this).receiver;
        int r2 = DefaultConfig.m;
        r1.getClass();
        g r3 = new g();
        LinkedHashMap r4 = new LinkedHashMap();
        DeviceType r5 = DeviceType.NORMAL_MOBILE;
        Integer r6 = Integer.valueOf(r5.ordinal());
        t51.a r7 = new t51.a();
        AdjustBase r8 = AdjustBase.CONTENT;
        r7.m(r8.ordinal());
        LayoutScale r9 = LayoutScale.FIT_WIDTH;
        r7.t(r9.ordinal());
        LayoutAlign r10 = LayoutAlign.CENTER_TOP;
        r7.n(r10.ordinal());
        i r12 = new i();
        r12.j(0.0f);
        r12.m(0.19f);
        r12.k(1.0f);
        r12.i(1.0f);
        Unit r13 = Unit.INSTANCE;
        r7.v(r12);
        d r14 = new d();
        r14.c();
        r14.d();
        r7.o(r14);
        AnchorHeightFixMode r15 = AnchorHeightFixMode.RationTransformHeight;
        r7.p(r15.ordinal());
        boolean r16 = f.a;
        if (r16 == false) goto L5;
        int r17 = 32;
    L6:
        r7.u(r17);
        if (r16 == false) goto L9;
        int r18 = 32;
    L10:
        r7.q(r18);
        r4.put(r6, r7);
        Integer r19 = Integer.valueOf(DeviceType.PAD_V.ordinal());
        t51.a r20 = new t51.a();
        r20.m(r8.ordinal());
        r20.t(r9.ordinal());
        r20.n(r10.ordinal());
        i r22 = new i();
        r22.j(0.0f);
        r22.l();
        r22.k(1.0f);
        r22.i(1.0f);
        r20.v(r22);
        r20.p(r15.ordinal());
        if (r16 == true) goto L13;
    L15:
        int r23 = 16;
    L16:
        r20.u(r23);
        r4.put(r19, r20);
        Integer r24 = Integer.valueOf(DeviceType.PAD_H.ordinal());
        t51.a r25 = new t51.a();
        r25.m(r8.ordinal());
        LayoutScale r26 = LayoutScale.FIT_HEIGHT;
        r25.t(r26.ordinal());
        r25.n(LayoutAlign.CENTER.ordinal());
        i r110 = new i();
        r110.j(0.0f);
        r110.m(0.0f);
        r110.k(1.0f);
        r110.i(1.0f);
        r25.v(r110);
        r25.p(r15.ordinal());
        AudienceHeightFixMode r111 = AudienceHeightFixMode.OriginContainerHeight;
        r25.r(r111.ordinal());
        r4.put(r24, r25);
        Integer r27 = Integer.valueOf(DeviceType.FOLD_FULL.ordinal());
        t51.a r28 = new t51.a();
        r28.m(r8.ordinal());
        LayoutScale r112 = LayoutScale.ASPECT_FIT;
        r28.t(r112.ordinal());
        r28.n(r10.ordinal());
        i r113 = new i();
        r113.j(0.2f);
        r113.m(0.19f);
        r113.k(0.8f);
        r113.i(1.0f);
        r28.v(r113);
        r28.p(r15.ordinal());
        r28.r(r111.ordinal());
        if (r16 == false) goto L19;
        int r114 = 32;
    L20:
        r28.u(r114);
        if (r16 == false) goto L23;
        int r115 = 32;
    L24:
        r28.q(r115);
        r4.put(r27, r28);
        Integer r29 = Integer.valueOf(DeviceType.NORMAL_MOBILE_H.ordinal());
        t51.a r30 = new t51.a();
        r30.m(r8.ordinal());
        r30.t(r112.ordinal());
        r30.n(r10.ordinal());
        i r116 = new i();
        r116.j(0.3f);
        r116.m(0.19f);
        r116.k(0.7f);
        r116.i(1.0f);
        r30.v(r116);
        r30.p(r15.ordinal());
        r30.r(r111.ordinal());
        r4.put(r29, r30);
        Integer r32 = Integer.valueOf(r5.ordinal() + com.bytedance.android.live.saas.middleware.fresco.DefaultConfig.MAX_CACHE_ENTRIES);
        t51.a r33 = new t51.a();
        r33.m(r8.ordinal());
        r33.t(r26.ordinal());
        r33.n(r10.ordinal());
        i r34 = new i();
        r34.j(0.0f);
        r34.m(0.19f);
        r34.k(1.0f);
        r34.i(0.59625f);
        r33.v(r34);
        if (r16 == true) goto L27;
    L29:
        int r35 = 4;
    L30:
        r33.q(r35);
        if (r16 == false) goto L33;
        int r117 = 16;
    L34:
        r33.u(r117);
        r33.p(r15.ordinal());
        r33.r(r111.ordinal());
        r4.put(r32, r33);
        r4.put(Integer.valueOf(r5.ordinal() + 512), DefaultConfig.b());
        r4.put(Integer.valueOf(r5.ordinal() + 1024), DefaultConfig.b());
        r3.g(r4);
        LinkedHashMap r36 = new LinkedHashMap();
        e r37 = new e();
        r37.m(0.0f);
        r37.n(0.0f);
        r37.l(1.0f);
        r37.h(1.0f);
        r37.i(0);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r38 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        r37.t(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r38.ordinal()), 0)));
        r37.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r38.ordinal()), 0)));
        r36.put(1, CollectionsKt.listOf(r37));
        e r118 = new e();
        r118.m(0.0f);
        r118.n(0.19f);
        r118.l(0.5f);
        r118.h(0.40625f);
        r118.i(0);
        r118.s();
        e r119 = new e();
        r119.m(0.5f);
        r119.n(0.19f);
        r119.l(0.5f);
        r119.h(0.40625f);
        r119.i(1);
        r119.s();
        r36.put(2, CollectionsKt.listOf(new e[]{r118, r119}));
        e r120 = new e();
        r120.m(0.0f);
        double r121 = s11.a.a;
        float r122 = (float) r121;
        r120.n(r122);
        float r39 = (float) 0.4986111111111111d;
        r120.l(r39);
        r120.h(r39);
        r120.i(0);
        Integer r40 = Integer.valueOf(r38.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.b r123 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.b.c;
        r120.t(MapsKt.mapOf(TuplesKt.to(r40, 1)));
        r120.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r38.ordinal()), 1)));
        e r42 = new e();
        float r43 = (float) 0.5013888888888889d;
        r42.m(r43);
        r42.n(r122);
        r42.l(r39);
        float r124 = (float) 0.24852430555555555d;
        r42.h(r124);
        r42.i(1);
        Integer r125 = Integer.valueOf(r38.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.e r210 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.e.c;
        r42.t(MapsKt.mapOf(TuplesKt.to(r125, 2)));
        r42.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r38.ordinal()), 2)));
        e r44 = new e();
        r44.m(r43);
        r44.n((float) ((r121 + 0.24852430555555555d) + 0.0015625d));
        r44.l(r39);
        r44.h(r124);
        r44.i(2);
        r44.t(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r38.ordinal()), 2)));
        r44.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r38.ordinal()), 2)));
        r36.put(3, CollectionsKt.listOf(new e[]{r120, r42, r44}));
        e r45 = new e();
        r45.m(0.0f);
        r45.n(r122);
        r45.l(r39);
        r45.h(r124);
        r45.i(0);
        r45.t(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r38.ordinal()), 2)));
        r45.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r38.ordinal()), 2)));
        e r46 = new e();
        r46.m(r43);
        r46.n(r122);
        r46.l(r39);
        r46.h(r124);
        r46.i(1);
        r46.t(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r38.ordinal()), 2)));
        r46.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r38.ordinal()), 2)));
        e r47 = new e();
        r47.m(r43);
        float r48 = (float) ((r121 + 0.0015625d) + 0.24852430555555555d);
        r47.n(r48);
        r47.l(r39);
        r47.h(r124);
        r47.i(3);
        r47.t(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r38.ordinal()), 2)));
        r47.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r38.ordinal()), 2)));
        e r49 = new e();
        r49.m(0.0f);
        r49.n(r48);
        r49.l(r39);
        r49.h(r124);
        r49.i(2);
        r49.t(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r38.ordinal()), 2)));
        r49.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r38.ordinal()), 2)));
        r36.put(4, CollectionsKt.listOf(new e[]{r45, r46, r47, r49}));
        ArrayList r50 = new ArrayList();
        int r52 = 0;
    L35:
        double r126 = 0.33425925925925926d;
        if (r52 > 4) goto L41;
        if (r52 >= 2) goto L39;
        e r53 = new e();
        r53.m((r52 * r43) + 0.0f);
        r53.n((float) s11.a.a);
        r53.l(r39);
        r53.h(r124);
        r53.i(r52);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r127 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r128 = Integer.valueOf(r127.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.f r129 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.f.c;
        r53.t(MapsKt.mapOf(TuplesKt.to(r128, 8)));
        r53.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r127.ordinal()), 8)));
        Unit r54 = Unit.INSTANCE;
        r50.add(r53);
    L40:
        r52 = r52 + 1;
        goto L35
    L39:
        e r55 = new e();
        r55.m(((r52 - 2) * ((float) 0.33425925925925926d)) + 0.0f);
        r55.n((float) ((s11.a.a + 0.0015625d) + 0.24852430555555555d));
        r55.l((float) 0.3314814814814815d);
        r55.h(r124);
        r55.i(r52);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r130 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r131 = Integer.valueOf(r130.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.g r132 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.g.c;
        r55.t(MapsKt.mapOf(TuplesKt.to(r131, 9)));
        r55.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r130.ordinal()), 9)));
        Unit r56 = Unit.INSTANCE;
        r50.add(r55);
        goto L40
    L41:
        int r57 = 5;
        r36.put(5, r50);
        ArrayList r58 = new ArrayList();
        int r59 = 0;
    L43:
        if (r59 > r57) goto L45;
        e r133 = new e();
        r133.m(((r59 % 3) * ((float) r126)) + 0.0f);
        r133.n(((float) s11.a.a) + ((r59 / 3) * ((float) 0.25008680555555557d)));
        r133.l((float) 0.3314814814814815d);
        r133.h(r124);
        r133.i(r59);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r60 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r62 = Integer.valueOf(r60.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.g r134 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.g.c;
        r133.t(MapsKt.mapOf(TuplesKt.to(r62, 9)));
        r133.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r60.ordinal()), 9)));
        Unit r63 = Unit.INSTANCE;
        r58.add(r133);
        r59 = r59 + 1;
        r57 = 5;
        r126 = 0.33425925925925926d;
        goto L43
    L45:
        int r64 = 6;
        r36.put(6, r58);
        ArrayList r65 = new ArrayList();
        int r66 = 0;
    L47:
        if (r66 > r64) goto L56;
        if (r66 != 0) goto L51;
        e r67 = new e();
        r67.m(0.0f);
        r67.n((float) s11.a.a);
        r67.l(r39);
        r67.h(r124);
        r67.i(r66);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r135 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r136 = Integer.valueOf(r135.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.f r137 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.f.c;
        r67.t(MapsKt.mapOf(TuplesKt.to(r136, 8)));
        r67.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r135.ordinal()), 8)));
        Unit r68 = Unit.INSTANCE;
        r65.add(r67);
    L55:
        r66 = r66 + 1;
        r64 = 6;
        goto L47
    L51:
        if (r66 >= 3) goto L54;
        e r69 = new e();
        r69.m(((r66 - 1) * ((float) 0.25069444444444444d)) + r43);
        r69.n((float) s11.a.a);
        r69.l((float) 0.24791666666666667d);
        r69.h(r124);
        r69.i(r66);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r70 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r72 = Integer.valueOf(r70.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.h r138 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.h.c;
        r69.t(MapsKt.mapOf(TuplesKt.to(r72, 10)));
        r69.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r70.ordinal()), 10)));
        Unit r73 = Unit.INSTANCE;
        r65.add(r69);
        goto L55
    L54:
        e r74 = new e();
        r74.m((r66 - 3) * ((float) 0.25069444444444444d));
        r74.n((float) ((s11.a.a + 0.0015625d) + 0.24852430555555555d));
        r74.l((float) 0.24791666666666667d);
        r74.h(r124);
        r74.i(r66);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r75 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r76 = Integer.valueOf(r75.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.h r139 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.h.c;
        r74.t(MapsKt.mapOf(TuplesKt.to(r76, 10)));
        r74.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r75.ordinal()), 10)));
        Unit r77 = Unit.INSTANCE;
        r65.add(r74);
        goto L55
    L56:
        int r78 = 7;
        r36.put(7, r65);
        ArrayList r79 = new ArrayList();
        int r80 = 0;
    L57:
        if (r80 > r78) goto L59;
        e r82 = new e();
        r82.m((r80 % 4) * ((float) 0.25069444444444444d));
        r82.n(((float) s11.a.a) + ((r80 / 4) * ((float) 0.25008680555555557d)));
        r82.l((float) 0.24791666666666667d);
        r82.h(r124);
        r82.i(r80);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r83 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r84 = Integer.valueOf(r83.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.h r85 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.h.c;
        r82.t(MapsKt.mapOf(TuplesKt.to(r84, 10)));
        r82.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r83.ordinal()), 10)));
        Unit r86 = Unit.INSTANCE;
        r79.add(r82);
        r80 = r80 + 1;
        r78 = 7;
        goto L57
    L59:
        r36.put(8, r79);
        ArrayList r87 = new ArrayList();
        int r88 = 0;
    L60:
        if (r88 > 8) goto L62;
        e r89 = new e();
        r89.m((r88 % 3) * ((float) 0.33425925925925926d));
        r89.n(((float) s11.a.a) + ((r88 / 3) * ((float) 0.16672453703703705d)));
        r89.l((float) 0.3314814814814815d);
        r89.h((float) 0.16516203703703705d);
        r89.i(r88);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r90 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r140 = Integer.valueOf(r90.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.i r141 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.i.c;
        r89.t(MapsKt.mapOf(TuplesKt.to(r140, 11)));
        r89.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r90.ordinal()), 11)));
        Unit r92 = Unit.INSTANCE;
        r87.add(r89);
        r88 = r88 + 1;
        goto L60
    L62:
        r36.put(9, r87);
        Unit r93 = Unit.INSTANCE;
        r3.i(r36);
        return r3;
    L33:
        r117 = 0;
        goto L34
    L27:
        if (y41.f.N.e() == true) goto L29;
        r35 = 20;
        goto L30
    L23:
        r115 = 16;
        goto L24
    L19:
        r114 = 16;
        goto L20
    L13:
        if (y41.f.N.e() == true) goto L15;
        r23 = 32;
        goto L16
    L9:
        r18 = 16;
        goto L10
    L5:
        r17 = 16;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m955invoke();
    }
}
