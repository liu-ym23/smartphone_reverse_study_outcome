package com.bytedance.android.live.revlink.link.core.service;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.impl.multianchor.model.WindowType;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.link.core.layoutstatus.LayoutSnapShotCollect;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AnchorHeightFixMode;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AnchorDynamicLayoutImpl {
    public static final /* synthetic */ int g = 0;
    public final o51.b a;
    public final LayoutSnapShotCollect b;
    public final com.bytedance.android.live.revlink.link.infra.rtcbiz.b c;
    public final AnchorLinkUserCenterV2 d;
    public final AnchorLayoutDataContext e;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g f;

    public static final class a {
    }

    static {
    }

    public final String b(String r3) {
        com.bytedance.android.livesdk.link.model.p r0 = this.d.getGuestInfo(null, r3);
        if (r0 == null) goto L11;
        IBaseUser r1 = r0.getUser();
        if (r1 == null) goto L12;
        String r2 = iz.a.a(r1);
        if (r2 != null) goto L10;
        return r3;
    L10:
        return r2;
    L12:
        return r3;
    L11:
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    public static final void a(AnchorDynamicLayoutImpl r37, com.bytedance.android.live.revlink.link.core.layoutstatus.n r38) {
        r37.getClass();
        o51.e r2 = r38.a;
        com.bytedance.android.live.revlink.link.core.layoutstatus.f r3 = r38.b;
        Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r4 = r38.c;
        List<Long> r5 = r38.d;
        Map<String, Integer> r6 = r38.e;
        Map<String, com.bytedance.android.live.revlink.link.core.layoutstatus.i> r7 = r38.f;
        com.bytedance.android.live.revlink.link.core.layoutstatus.l r1 = r38.g;
        String r10 = null;
        jy0.b.c("RevenueDynamicLayoutClient", "onSnapShotRefresh with layoutConfigSnap=" + r3 + ", validStream=" + r4 + ", forwardControl=" + r5 + ", anchorPosition=" + r6, null, 4);
        if (r2 == null) goto L311;
        if (r3 == null) goto L312;
        if (r4 == null) goto L313;
        if (r5 == null) goto L314;
        if (r6 == null) goto L315;
        if (r7 == null) goto L316;
        if (r1 == null) goto L317;
        Set<String> r8 = r4.keySet();
        ArrayList r12 = new ArrayList();
        Iterator r9 = r8.iterator();
    L19:
        if (r9.hasNext() == false) goto L54;
        Object r13 = r9.next();
        String r14 = (String) r13;
        com.bytedance.android.livesdk.link.model.p r15 = r37.d.getGuestInfo(r10, r14);
        if (r15 == null) goto L25;
        IBaseUser r16 = r15.getUser();
        if (r16 == null) goto L25;
        Object r17 = Long.valueOf(com.bytedance.android.live.base.model.user.n.a(r16));
    L26:
        List<Long> r18 = r5;
        List<Long> r19 = r5;
        boolean r20 = CollectionsKt.contains(r18, r17);
        Map<String, Integer> r22 = r6;
        com.bytedance.android.live.revlink.link.core.layoutstatus.i r23 = r7.get(r14);
        Iterator r110 = r9;
        o51.e r24 = r2;
        Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r25 = r4;
        jy0.b.d("RevenueDynamicLayoutClient", "filter remote valid linker id " + r14 + ", guestInfo " + r15 + ", guestLiveRoomId " + r17 + ", contains " + r20 + ", handler " + r23 + ", accept " + com.bytedance.android.live.revlink.link.core.layoutstatus.k.a(r23));
        com.bytedance.android.livesdk.link.model.p r26 = r37.d.getGuestInfo(null, r14);
        if (r26 == null) goto L35;
        IBaseUser r27 = r26.getUser();
        if (r27 == null) goto L35;
        Intrinsics.checkNotNullParameter(r27, "$this$ownRoomExt");
        py.p r28 = r27.getOwnRoom();
        if (r28 == null) goto L35;
        List r29 = r28.getRoomIdStrList();
        if (r29 == null) goto L35;
        String r30 = (String) ListProtector.get(r29, 0);
    L36:
        if (r30 == null) goto L38;
        Long r32 = Long.valueOf(CastLongProtector.parseLong(r30));
    L39:
        com.bytedance.android.livesdk.link.model.p r33 = r37.d.getGuestInfo(null, r14);
        if (r33 == null) goto L44;
        IBaseUser r34 = r33.getUser();
        if (r34 == null) goto L44;
        Long r35 = Long.valueOf(com.bytedance.android.live.base.model.user.n.a(r34));
    L45:
        jy0.b.d("RevenueDynamicLayoutClient", "filter remote valid linker id, roomIdStr " + r30 + ", roomIdLong " + r32 + ", liveRoomIdExt " + r35);
        if (CollectionsKt.contains(r18, r32) == true) goto L48;
    L50:
        boolean r111 = false;
    L51:
        if (r111 == false) goto L53;
        r12.add(r13);
    L53:
        r5 = r19;
        r9 = r110;
        r6 = r22;
        r2 = r24;
        r4 = r25;
        r10 = null;
        goto L19
    L48:
        if (com.bytedance.android.live.revlink.link.core.layoutstatus.k.a(r7.get(r14)) == false) goto L50;
        r111 = true;
    L44:
        r35 = null;
        goto L45
    L38:
        r32 = null;
    L35:
        r30 = null;
    L25:
        r17 = r10;
        goto L26
    L54:
        o51.e r210 = r2;
        Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r211 = r4;
        Map<String, Integer> r212 = r6;
        List r36 = CollectionsKt.mutableListOf(new String[]{r37.f.Zl()});
        r36.addAll(r12);
        Unit r39 = Unit.INSTANCE;
        int r40 = r1.a - r36.size();
        if (r40 <= 0) goto L62;
        if (1 > r40) goto L62;
        int r42 = 1;
    L59:
        r36.add("fake_linker_" + r42);
        if (r42 == r40) goto L62;
        r42 = r42 + 1;
    L62:
        int r43 = r36.size();
        t51.g r44 = r3.b;
        t51.a r45 = r44.a(DeviceType.NORMAL_MOBILE, r43);
        if (r45 == null) goto L65;
        int r46 = r45.d();
    L66:
        if (r45 == null) goto L68;
        int r47 = com.bytedance.android.live.revenue.common.i.b(r45.e());
    L69:
        int r112 = r37.f.getContainerWidth();
        if (r46 != AnchorHeightFixMode.OriginContainerHeight.ordinal()) goto L73;
        int r48 = r37.f.l();
    L80:
        List<t51.e> r113 = r44.e().get(Integer.valueOf(r43));
        if (r113 == null) goto L318;
        List<t51.b> r114 = r44.d().get(Integer.valueOf(r43));
        List<t51.b> r115 = r44.f().get(Integer.valueOf(r43));
        if (r45 == null) goto L87;
        t51.c r116 = r45.i();
        if (r116 == null) goto L87;
    L88:
        t51.c r117 = r116;
        jy0.b.c("RevenueDynamicLayoutClient", "onSnapShotRefresh get layout count " + r43 + " config with config: " + r113 + ", mixStreamConfig: " + r114 + ", and seiConfig=" + r115, null, 4);
        Map<String, Integer> r49 = r1.b;
        if (r49 != null) goto L91;
        r49 = r212;
    L91:
        Map r50 = MapsKt.toMutableMap(r49);
        LinkedHashMap r52 = new LinkedHashMap();
        ArrayList r118 = new ArrayList();
        IntRange r53 = RangesKt.until(0, r43);
        int r310 = r47;
        LinkedHashMap r119 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r53, 10)), 16));
        Iterator r54 = r53.iterator();
    L93:
        if (r54.hasNext() == false) goto L95;
        Object r55 = r54.next();
        ((Number) r55).intValue();
        r119.put(r55, Boolean.TRUE);
        goto L93
    L95:
        Map r56 = MapsKt.toMutableMap(r119);
        LinkedHashMap r57 = new LinkedHashMap();
        List r58 = r36;
        Iterator r59 = r58.iterator();
    L97:
        if (r59.hasNext() == false) goto L102;
        String r120 = r37.b((String) r59.next());
        Iterator r213 = r59;
        Integer r60 = (Integer) r50.get(r120);
        if (r60 == null) goto L101;
        r57.put(r120, r60);
    L101:
        r59 = r213;
        goto L97
    L102:
        Iterator r62 = r58.iterator();
    L103:
        List<t51.b> r311 = r115;
        if (r62.hasNext() == false) goto L123;
        String r121 = (String) r62.next();
        Integer r122 = (Integer) r50.get(r37.b(r121));
        if (r122 == null) goto L108;
        int r123 = r122.intValue();
        int r63 = -1;
    L109:
        if (r123 != r63) goto L119;
        r118.add(r121);
        Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r64 = r211;
        if (r64.containsKey(r121) == false) goto L113;
    L116:
        boolean r124 = true;
    L117:
        r52.put(r121, Boolean.valueOf(r124));
        r211 = r64;
    L122:
        r62 = r62;
        r115 = r311;
        goto L103
    L113:
        if (Intrinsics.areEqual(r121, r37.f.Zl()) == true) goto L116;
        r124 = false;
        goto L117
    L119:
        if (r56.containsKey(Integer.valueOf(r123)) == false) goto L121;
        r56.put(Integer.valueOf(r123), Boolean.FALSE);
    L121:
        r52.put(r121, Boolean.TRUE);
        goto L122
    L108:
        r63 = -1;
        r123 = -1;
        goto L109
    L123:
        Iterator r65 = r118.iterator();
    L125:
        if (r65.hasNext() == false) goto L140;
        String r125 = (String) r65.next();
        LinkedHashMap r126 = new LinkedHashMap();
        Iterator r127 = r56.entrySet().iterator();
    L128:
        if (r127.hasNext() == false) goto L132;
        Map.Entry r214 = (Map.Entry) r127.next();
        if (((Boolean) r214.getValue()).booleanValue() == false) goto L128;
        r126.put(r214.getKey(), r214.getValue());
        r65 = r65;
        r127 = r127;
        goto L128
    L132:
        Iterator r215 = r65;
        ArrayList r66 = new ArrayList(r126.size());
        Iterator r128 = r126.entrySet().iterator();
    L134:
        if (r128.hasNext() == false) goto L136;
        r66.add(Integer.valueOf(((Number) ((Map.Entry) r128.next()).getKey()).intValue()));
        goto L134
    L136:
        Integer r67 = (Integer) CollectionsKt.firstOrNull(r66);
        if (r67 == null) goto L139;
        int r68 = r67.intValue();
        r56.put(Integer.valueOf(r68), Boolean.FALSE);
        r50.put(r37.b(r125), Integer.valueOf(r68));
        r57.put(r37.b(r125), Integer.valueOf(r68));
    L139:
        r65 = r215;
        goto L125
    L140:
        Iterator r69 = r57.entrySet().iterator();
        int r70 = -1;
    L142:
        if (r69.hasNext() == false) goto L144;
        r70 = RangesKt.coerceAtLeast(r70, ((Number) ((Map.Entry) r69.next()).getValue()).intValue());
        goto L142
    L144:
        jy0.b.c("RevenueDynamicLayoutClient", "max position: " + r70 + " and count: " + r43, null, 4);
        StringBuilder r72 = new StringBuilder("safePositionMap: ");
        r72.append(r57);
        jy0.b.c("RevenueDynamicLayoutClient", r72.toString(), null, 4);
        r37.a.getClass();
        Intrinsics.checkNotNullParameter(r57, "anchorPosition");
        Intrinsics.checkNotNullParameter(r210, "uiLayout");
        if ((r210 instanceof o51.e.f) == false) goto L147;
    L177:
        LinkedHashMap r73 = new LinkedHashMap(MapsKt.mapCapacity(r57.size()));
        Iterator r74 = r57.entrySet().iterator();
    L179:
        if (r74.hasNext() == false) goto L181;
        Map.Entry r75 = (Map.Entry) r74.next();
        r73.put(r75.getKey(), TuplesKt.to(r75.getValue(), 0));
    L181:
        Pair r76 = TuplesKt.to(r73, r52);
        Map r77 = (Map) r76.component1();
        Map r78 = (Map) r76.component2();
        LinkedHashMap r79 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r58, 10)), 16));
        Iterator r80 = r58.iterator();
    L183:
        if (r80.hasNext() == false) goto L204;
        Object r82 = r80.next();
        String r129 = (String) r82;
        Pair r130 = (Pair) r77.get(r37.b(r129));
        if (r130 != null) goto L187;
        r130 = TuplesKt.to(-1, 0);
    L187:
        int r131 = ((Number) r130.component1()).intValue();
        int r216 = ((Number) r130.component2()).intValue();
        Iterator r132 = r113.iterator();
    L189:
        if (r132.hasNext() == false) goto L197;
        Object r217 = r132.next();
        Iterator r312 = r80;
        if (((t51.e) r217).b() != r131) goto L193;
        boolean r83 = true;
    L194:
        if (r83 == true) goto L198;
        r80 = r312;
    L198:
        t51.e r218 = (t51.e) r217;
        if (r218 != null) goto L201;
        t51.e r219 = new t51.e();
    L202:
        r79.put(r82, c(r129, r219, r112, r48, Integer.valueOf(r131), r216, r114, r311, r310, Intrinsics.areEqual((Boolean) r78.get(r129), Boolean.TRUE)));
        r80 = r312;
        goto L183
    L201:
        r219 = r218;
        goto L202
    L193:
        r83 = false;
        goto L194
    L197:
        r312 = r80;
        r217 = null;
        goto L198
    L204:
        if ((r210 instanceof o51.e.c) == false) goto L210;
        y41.f r84 = y41.f.N;
        r84.getClass();
        if (((Boolean) y41.f.I.getValue(r84, y41.f.a[33])).booleanValue() == false) goto L210;
        if (r211.size() <= 3) goto L210;
        boolean r85 = true;
    L211:
        if (r45 == null) goto L215;
        t51.d r86 = r45.c();
        if (r86 == null) goto L215;
        float r87 = r86.b();
    L216:
        float r88 = r48;
        int r89 = (int) (r87 * r88);
        if (r45 == null) goto L221;
        t51.d r133 = r45.c();
        if (r133 == null) goto L221;
        float r134 = r133.a();
    L222:
        float r135 = r112;
        int r136 = (int) (r134 * r135);
        if ((r210 instanceof o51.e.i) == true) goto L225;
        int r220 = r43;
        int r313 = r89;
        ?? r90 = CollectionsKt.emptyList();
    L243:
        if ((r210 instanceof o51.e.h) == true) goto L246;
    L265:
        n r221 = null;
    L266:
        Matrix r314 = o51.a.a(new RectF(0.0f, 0.0f, 1.0f, 1.0f), new RectF(0.0f, 0.0f, r135, r88));
        jy0.b.c("RevenueDynamicLayoutClient", "onSnapShotRefresh with containerHeight: " + r48 + ", containerWidth: " + r112 + " and frames=" + r79, null, 4);
        NextLiveData<p> r92 = r37.e.getLayoutFrame();
        o51.e r0 = r37.b.k;
        if (r85 == false) goto L269;
        g r315 = new g(r136, r313);
    L270:
        r92.setValue(new p(r79, r90, r221, r117, r220, r0, r314, r315, Integer.valueOf(r48), Integer.valueOf(r112)));
        return;
    L269:
        r315 = null;
        goto L270
    L246:
        if (((o51.e.h) r210).e == false) goto L248;
        int r93 = 10002;
    L249:
        List<t51.e> r94 = r44.e().get(2);
        if (r94 == null) goto L265;
        Iterator r95 = r94.iterator();
    L253:
        if (r95.hasNext() == false) goto L260;
        Object r96 = r95.next();
        if (((t51.e) r96).b() != r93) goto L257;
        boolean r137 = true;
    L258:
        if (r137 == false) goto L253;
    L261:
        t51.e r222 = (t51.e) r96;
        if (r222 == null) goto L265;
        r221 = c("", r222, r112, r48, 0, 0, r44.d().get(2), r44.f().get(2), r310, true);
        goto L266
    L257:
        r137 = false;
        goto L258
    L260:
        r96 = null;
        goto L261
    L248:
        r93 = 10001;
        goto L249
    L225:
        List<t51.b> r138 = r44.d().get(2);
        List<t51.b> r97 = r44.f().get(2);
        r220 = r43;
        List<t51.e> r98 = r44.e().get(2);
        if (r98 == null) goto L241;
        ArrayList r139 = new ArrayList();
        Iterator r99 = r98.iterator();
    L229:
        if (r99.hasNext() == false) goto L237;
        Object r140 = r99.next();
        Iterator r223 = r99;
        int r316 = r89;
        if (((t51.e) r140).getType() != WindowType.Guest.ordinal()) goto L233;
        boolean r100 = true;
    L234:
        if (r100 == false) goto L236;
        r139.add(r140);
    L236:
        r99 = r223;
        r89 = r316;
        goto L229
    L233:
        r100 = false;
        goto L234
    L237:
        r313 = r89;
        r90 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r139, 10));
        Iterator r101 = r139.iterator();
    L239:
        if (r101.hasNext() == false) goto L243;
        t51.e r224 = (t51.e) r101.next();
        r90.add(c("", r224, r112, r48, Integer.valueOf(r224.b()), 20000, r138, r97, r310, true));
        goto L239
    L241:
        r313 = r89;
        r90 = CollectionsKt.emptyList();
    L221:
        r134 = 0.0f;
    L215:
        r87 = 0.0f;
    L210:
        r85 = false;
        goto L211
    L147:
        if ((r210 instanceof o51.e.d) == true) goto L177;
        if ((r210 instanceof o51.e.c) == true) goto L177;
        if ((r210 instanceof o51.e.g) == true) goto L177;
        if ((r210 instanceof o51.e.h) == true) goto L177;
        if ((r210 instanceof o51.e.C0283e) == true) goto L177;
        if ((r210 instanceof o51.e.a) == true) goto L177;
        if ((r210 instanceof o51.e.i) == false) goto L176;
        o51.e.i r102 = (o51.e.i) r210;
        r73 = new LinkedHashMap(MapsKt.mapCapacity(r57.size()));
        Iterator r103 = r57.entrySet().iterator();
    L163:
        if (r103.hasNext() == false) goto L181;
        Map.Entry r141 = (Map.Entry) r103.next();
        Object r142 = r141.getKey();
        String r143 = (String) r141.getKey();
        int r144 = ((Number) r141.getValue()).intValue();
        Iterator r225 = r103;
        if (Intrinsics.areEqual(r143, r102.g) == false) goto L169;
        if (r102.e == false) goto L169;
    L172:
        r144 = r144 + 30000;
        int r104 = 30000;
    L174:
        r73.put(r142, TuplesKt.to(Integer.valueOf(r144), Integer.valueOf(r104)));
        r103 = r225;
    L169:
        if (Intrinsics.areEqual(r143, r102.h) == true) goto L171;
    L173:
        r104 = 0;
        goto L174
    L171:
        if (r102.f == false) goto L173;
    L176:
        throw new NoWhenBranchMatchedException();
    L87:
        r116 = new t51.c();
        goto L88
    L318:
        return;
    L73:
        if (r46 != AnchorHeightFixMode.RationTransformHeight.ordinal()) goto L76;
        int r105 = r37.f.getContainerWidth();
    L79:
        r48 = (int) ((((double) r105) / 9.0d) * 16.0d);
        goto L80
    L76:
        if (r46 != AnchorHeightFixMode.PreviewHeight.ordinal()) goto L78;
        r48 = r37.f.n;
        goto L80
    L78:
        r105 = r37.f.getContainerWidth();
        goto L79
    L68:
        r47 = 0;
        goto L69
    L65:
        r46 = AnchorHeightFixMode.RationTransformHeight.ordinal();
        goto L66
    L317:
        return;
    L316:
        return;
    L315:
        return;
    L314:
        return;
    L313:
        return;
    L312:
        return;
    }

    public AnchorDynamicLayoutImpl(s r7, com.bytedance.android.live.revlink.link.infra.rtcbiz.b r8, AnchorLinkUserCenterV2 r9, AnchorLayoutDataContext r10, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r12) {
        Intrinsics.checkNotNullParameter(r7, "dynamicLayoutClient");
        Intrinsics.checkNotNullParameter(r8, "rtcDataContext");
        Intrinsics.checkNotNullParameter(r9, "anchorLinkUserCenter");
        Intrinsics.checkNotNullParameter(r10, "anchorLayoutDataContext");
        Intrinsics.checkNotNullParameter(r12, "context");
        this.c = r8;
        this.d = r9;
        this.e = r10;
        this.f = r12;
        this.a = new o51.b(r12);
        this.b = new LayoutSnapShotCollect(r7, r8, r9, r12, new AnchorDynamicLayoutImpl$layoutSnapShotCollect$1(this));
    }

    public static n c(String r13, t51.e r14, int r15, int r16, Integer r17, int r18, List r19, List r20, int r22, boolean r23) {
        float r1 = r15;
        int r2 = (int) (r14.e() * r1);
        float r3 = r16;
        int r4 = ((int) (r14.f() * r3)) + r22;
        int r5 = (int) (r14.d() * r1);
        int r6 = (int) (r14.a() * r3);
        if (r17 == null) goto L5;
        int r0 = r17.intValue();
    L6:
        q r12 = new q(r13, r2, r4, r5, r6, r0 - r18, r14.g(), r14.getType(), r14.c(), r23);
        Object r7 = null;
        if (r19 == null) goto L23;
        Iterator r8 = r19.iterator();
    L10:
        if (r8.hasNext() == false) goto L20;
        Object r9 = r8.next();
        int r10 = ((t51.b) r9).b();
        if (r17 != null) goto L15;
    L17:
        boolean r24 = false;
    L18:
        if (r24 == false) goto L10;
    L21:
        t51.b r25 = (t51.b) r9;
        if (r25 == null) goto L23;
    L24:
        if (r20 == null) goto L39;
        Iterator r26 = r20.iterator();
    L27:
        if (r26.hasNext() == false) goto L37;
        Object r27 = r26.next();
        int r28 = ((t51.b) r27).b();
        if (r17 != null) goto L32;
    L34:
        boolean r29 = false;
    L35:
        if (r29 == false) goto L27;
        r7 = r27;
        goto L37
    L32:
        if (r28 != r17.intValue()) goto L34;
        r29 = true;
    L37:
        t51.b r30 = (t51.b) r7;
        if (r30 == null) goto L39;
    L41:
        return new n(r12, r14, r25, r30);
    L39:
        r30 = r14;
        goto L41
    L15:
        if (r10 != r17.intValue()) goto L17;
        r24 = true;
        goto L18
    L20:
        r9 = null;
    L23:
        r25 = r14;
        goto L24
    L5:
        r0 = 0;
        goto L6
    }
}
