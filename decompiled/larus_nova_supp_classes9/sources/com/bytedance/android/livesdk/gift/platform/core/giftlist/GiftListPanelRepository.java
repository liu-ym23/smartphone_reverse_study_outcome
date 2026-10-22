package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import android.os.SystemClock;
import androidx.collection.LongSparseArray;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.configmodel.d0;
import com.bytedance.android.livesdk.gift.configmodel.e2;
import com.bytedance.android.livesdk.gift.configmodel.n0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftListSortDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.IncrementalUpdatePanelGiftList;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshGiftMostlyUsedStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateLoadMoreState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdatePanelGiftList;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetsUtils;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.f1;
import com.bytedance.android.livesdk.gift.platform.core.utils.b0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftListPanelRepository implements com.bytedance.android.scope.o, yz0.m, h {
    public final Map<ReceiverType, com.bytedance.android.livesdk.gift.platform.core.model.l> a;
    public final Map<ReceiverType, List<k>> b;
    public final Map<ReceiverType, Pair<com.bytedance.android.livesdk.gift.platform.core.model.j, Long>> c;
    public final Map<ReceiverType, List<k>> d;
    public final Map<ReceiverType, Pair<String, List<p>>> e;
    public final yz0.k f;
    public final com.bytedance.android.scope.j g;
    public final i h;
    public final GiftListFilterService i;
    public final e1 j;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onWidgetLoaded() {
    }

    public final void x() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.h
    public final void Kg() {
        IRoom r0 = this.f.getRoom();
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.L.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[36])).booleanValue() == true) goto L23;
        IRoomAuthStatus r1 = r0.getRoomAuthStatus();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.getEnableGift() == true) goto L9;
        return;
    L9:
        if (r0.isVsRoom() == false) goto L11;
        return;
    L11:
        if (r0.isMergeVSRoom() == true) goto L27;
        long r2 = this.f.getRoom().getRoomLayout();
        long r5 = r0.getRoomId();
        if (((n0) nz1.a.b0.getValue(null, nz1.a.a[52])).a() == false) goto L15;
        int r7 = 13;
    L16:
        IBaseUser r3 = r0.getOwner();
        if (r3 == null) goto L20;
        Intrinsics.checkNotNullParameter(r3, "$this$secUidExt");
        String r4 = r3.getCastSecUid();
        if (r4 == null) goto L20;
    L21:
        GiftListRepo.j(null, r5, r7, false, r4, (int) r2);
        return;
    L20:
        r4 = BuildConfig.FLAVOR;
        goto L21
    L15:
        r7 = 2;
        goto L16
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.h
    public final boolean Si() {
        Map<ReceiverType, com.bytedance.android.livesdk.gift.platform.core.model.l> r0 = this.a;
        ReceiverType r1 = ReceiverType.Anchor;
        com.bytedance.android.livesdk.gift.platform.core.model.l r2 = (com.bytedance.android.livesdk.gift.platform.core.model.l) ((LinkedHashMap) r0).get(r1);
        if (r2 == null) goto L13;
        List<j> r3 = r2.a;
        if (r3 == null) goto L13;
        if ((!r3.isEmpty()) != true) goto L13;
        com.bytedance.android.livesdk.gift.platform.core.model.l r4 = (com.bytedance.android.livesdk.gift.platform.core.model.l) ((LinkedHashMap) this.a).get(r1);
        if (r4 == null) goto L13;
        if (r4.c != 15) goto L13;
        return true;
    L13:
        return false;
    }

    public final long a() {
        i12.d r0 = i12.m.e2.a();
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = com.bytedance.android.scope.m.e.d(r0, GiftListSortDataStore.class);
    L7:
        if (((GiftListSortDataStore) r2) == null) goto L9;
        return 0;
    L9:
        i12.e r3 = i12.o.b();
        if (r3 == null) goto L12;
        r1 = com.bytedance.android.scope.m.e.d(r3, f1.class);
    L12:
        f1 r4 = (f1) r1;
        return 0;
    L5:
        r2 = null;
        goto L7
    }

    public final void f() {
        Boolean r2 = null;
        if (((d0) com.bytedance.android.livesdk.gift.platform.core.h.H0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[84])).e() == false) goto L5;
        return;
    L5:
        e1 r0 = (e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class);
        long r3 = this.f.getRoom().getRoomId();
        if (r0.a >= 0) goto L9;
        r0.a = r3;
    L9:
        if (com.bytedance.android.livesdk.gift.platform.business.a.b().d() > 0) goto L11;
    L40:
        Kg();
        return;
    L11:
        if (com.bytedance.android.livesdk.gift.platform.business.a.b().e() <= 0) goto L40;
        if (com.bytedance.android.livesdk.gift.platform.business.a.b().h() == false) goto L15;
    L17:
        KmpEnv r1 = KmpEnv.a;
        if (KmpEnv.b() == false) goto L48;
        yz0.k r4 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r4 == null) goto L36;
        List r5 = r4.getToolbarDataList();
        if (r5 == null) goto L36;
        Iterator r6 = r5.iterator();
    L25:
        if (r6.hasNext() == false) goto L32;
        Object r7 = r6.next();
        if (((IToolbarComponentData) r7).getId() != 30) goto L29;
        boolean r8 = true;
    L30:
        if (r8 == false) goto L25;
    L34:
        if (((IToolbarComponentData) r7) == null) goto L36;
        r2 = Boolean.TRUE;
        goto L36
    L29:
        r8 = false;
        goto L30
    L32:
        r7 = null;
    L36:
        if (r2 != null) goto L38;
    L39:
        Kg();
        return;
    L38:
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == true) goto L39;
        return;
    L48:
        return;
    L15:
        if (((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).a != this.f.getRoom().getRoomId()) goto L17;
        Kg();
    }

    public final void onStop() {
        this.i.h = null;
    }

    public final void i() {
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().b() != 1) goto L5;
        f();
    L5:
        GiftListFilterService r0 = this.i;
        yz0.k r1 = this.f;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "roomService");
        boolean r2 = g02.a.e();
        r0.c = r2;
        AssetsService r3 = r0.i;
        r3.s = AssetsUtils.b(r2);
        r0.h = r1.getRoom();
    }

    public final void onViewReady() {
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().b() != 2) goto L6;
        f();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.h
    public final Map<ReceiverType, com.bytedance.android.livesdk.gift.platform.core.model.l> M4() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.h
    public final com.bytedance.android.livesdk.gift.platform.core.model.j Mn(final ReceiverType r25) {
        Intrinsics.checkNotNullParameter(r25, "receiverType");
        StringBuilder r2 = new StringBuilder("get room cache, currentReceiverType");
        r2.append(r25);
        r2.append(", cache is empty");
        com.bytedance.android.livesdk.gift.platform.core.model.l r3 = (com.bytedance.android.livesdk.gift.platform.core.model.l) ((LinkedHashMap) this.a).get(r25);
        if (r3 == null) goto L5;
        List<j> r4 = r3.a;
    L6:
        List<j> r5 = r4;
        int r6 = 1;
        if (r5 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        r2.append(r7);
        d.a("GiftListPanelRepository", r2.toString());
        a();
        GiftPanelBizBoostUtils.E.getClass();
        if (((Boolean) GiftPanelBizBoostUtils.D.getValue()).booleanValue() == false) goto L23;
        Pair r8 = (Pair) ((LinkedHashMap) this.c).get(r25);
        if (r8 == null) goto L23;
        com.bytedance.android.livesdk.gift.platform.core.model.j r9 = (com.bytedance.android.livesdk.gift.platform.core.model.j) r8.component1();
        if ((SystemClock.uptimeMillis() - ((Number) r8.component2()).longValue()) < 60000) goto L24;
        this.c.put(r25, null);
    L24:
        if (r9 == null) goto L27;
        return r9;
    L27:
        if (((LinkedHashMap) this.a).get(r25) == null) goto L110;
        com.bytedance.android.livesdk.gift.platform.core.model.l r10 = (com.bytedance.android.livesdk.gift.platform.core.model.l) ((LinkedHashMap) this.a).get(r25);
        if (r10 == null) goto L31;
        List<j> r11 = r10.a;
    L32:
        if (r11 != null) goto L34;
        final Pair r13 = null;
        long r18 = -1;
    L109:
        boolean r15 = true;
    L173:
        if (r13 == null) goto L176;
        Object r14 = (List) r13.getSecond();
        if (r14 == null) goto L176;
    L177:
        this.j.getClass();
        e1.f();
        this.e.put(r25, new Pair(BuildConfig.FLAVOR, r14));
        com.bytedance.android.livesdk.gift.platform.core.model.l r16 = (com.bytedance.android.livesdk.gift.platform.core.model.l) ((LinkedHashMap) this.a).get(r25);
        if (r16 == null) goto L186;
        List<j> r17 = r16.a;
        if (r17 == null) goto L186;
        Sequence r19 = CollectionsKt.asSequence(r17);
        if (r19 == null) goto L186;
        Sequence r20 = SequencesKt.map(r19, new GiftListPanelRepository$getGiftPageList$giftPages$1(this, r13, r25));
        if (r20 == null) goto L186;
        List r21 = SequencesKt.toList(r20);
    L187:
        if (r16 == null) goto L189;
        long r23 = r16.b;
    L190:
        if (r16 == null) goto L192;
        int r24 = r16.c;
    L193:
        if (r16 == null) goto L195;
        long r26 = r16.d;
    L196:
        String r27 = "0";
        if (r16 == null) goto L200;
        String r28 = r16.e;
        if (r28 == null) goto L200;
    L201:
        List r110 = r21;
        if (r110 != null) goto L204;
    L207:
        if (r15 == false) goto L221;
        com.bytedance.android.livesdk.gift.platform.core.model.j r29 = this.h.N3();
        List<w1> r30 = r29.c;
        if (r30 == null) goto L215;
        this.i.e = 0;
        Sequence r31 = CollectionsKt.asSequence(r30);
        if (r31 == null) goto L215;
        Sequence r33 = SequencesKt.map(r31, new GiftListPanelRepository$getGiftPageList$3(this, r25));
        if (r33 == null) goto L215;
        List r34 = SequencesKt.toList(r33);
    L216:
        long r35 = Long.valueOf(r29.d).longValue();
        int r36 = Integer.valueOf(r29.e).intValue();
        long r37 = Long.valueOf(r29.f).longValue();
        String r38 = r29.g;
        if (r38 == null) goto L220;
        r27 = r38;
    L220:
        int r111 = r36;
        long r112 = r35;
        long r113 = r37;
        String r114 = r27;
        r21 = r34;
    L222:
        if (r21 != null) goto L224;
        List r115 = CollectionsKt.emptyList();
    L225:
        com.bytedance.android.livesdk.gift.platform.core.model.j r39 = new com.bytedance.android.livesdk.gift.platform.core.model.j(r115, r112, r111, r113, r114);
        GiftPanelBizBoostUtils.E.getClass();
        if (((Boolean) GiftPanelBizBoostUtils.D.getValue()).booleanValue() == false) goto L229;
        this.c.put(r25, TuplesKt.to(r39, Long.valueOf(SystemClock.uptimeMillis())));
    L229:
        return r39;
    L224:
        r115 = r21;
    L215:
        r34 = null;
        goto L216
    L221:
        r114 = r28;
        r112 = r23;
        r111 = r24;
        r113 = r26;
        goto L222
    L204:
        if (r110.isEmpty() == true) goto L207;
        r15 = false;
    L200:
        r28 = "0";
        goto L201
    L195:
        r26 = r18;
        goto L196
    L192:
        r24 = 0;
        goto L193
    L189:
        r23 = 0;
    L186:
        r21 = null;
    L176:
        r14 = new ArrayList();
        goto L177
    L34:
        e1 r116 = (e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class);
        LongSparseArray r117 = e1.a();
        e1 r118 = (e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class);
        e1.f();
        if (r117 != null) goto L37;
    L108:
        r18 = -1;
    L112:
        r13 = null;
        goto L109
    L37:
        if (r117.size() == 0) goto L108;
        ArrayList r119 = new ArrayList();
        List<Integer> r40 = ((e2) com.bytedance.android.livesdk.gift.platform.core.h.h0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[58])).c();
        Iterator<T> r120 = r11.iterator();
    L41:
        if (r120.hasNext() == false) goto L48;
        Object r121 = r120.next();
        if (((j) r121).a != 1) goto L45;
        boolean r122 = true;
    L46:
        if (r122 == false) goto L41;
    L49:
        j r123 = (j) r121;
        int r124 = r117.size();
        int r125 = 0;
    L50:
        if (r125 >= r124) goto L107;
        Integer r126 = (Integer) r117.valueAt(r125);
        if (r126 == null) goto L105;
        long r127 = r117.keyAt(r125);
        int r41 = r11.size();
        if (r123 == null) goto L70;
        List<Long> r43 = r123.l;
        if (r43 == null) goto L70;
        Iterator<T> r44 = r43.iterator();
    L59:
        if (r44.hasNext() == false) goto L66;
        Object r128 = r44.next();
        if (((Number) r128).longValue() != r127) goto L63;
        boolean r129 = true;
    L64:
        if (r129 == false) goto L59;
    L67:
        Long r130 = (Long) r128;
        if (r130 == null) goto L70;
        long r45 = r130.longValue();
    L71:
        int r210 = r124;
        j r211 = r123;
        if (r45 <= (-1)) goto L77;
        h1 r46 = this.h.y3(r45);
        if (r46 == null) goto L106;
        r119.add(new p(r46, r126.intValue(), r6));
    L106:
        r125 = r125 + 1;
        r123 = r211;
        r124 = r210;
        r6 = 1;
        goto L50
    L77:
        int r47 = 0;
    L78:
        if (r47 >= r41) goto L106;
        j r48 = (j) ListProtector.get(r11, r47);
        int r49 = r48.a;
        if (r49 == r6) goto L104;
        if (r40 == null) goto L104;
        if (r40.contains(Integer.valueOf(r49)) != r6) goto L104;
        Iterator<T> r50 = r48.l.iterator();
    L86:
        if (r50.hasNext() == false) goto L93;
        Object r131 = r50.next();
        if (((Number) r131).longValue() != r127) goto L90;
        boolean r132 = true;
    L91:
        if (r132 == false) goto L86;
    L94:
        Long r133 = (Long) r131;
        if (r133 == null) goto L97;
        long r134 = r133.longValue();
    L99:
        if (r134 <= (-1)) goto L104;
        h1 r51 = this.h.z1(r134, null);
        if (r51 == null) goto L104;
        r119.add(new p(r51, r126.intValue(), r48.a));
        goto L106
    L97:
        r134 = -1;
        goto L99
    L90:
        r132 = false;
        goto L91
    L93:
        r131 = null;
    L104:
        r47 = r47 + 1;
        r6 = 1;
        goto L78
    L63:
        r129 = false;
        goto L64
    L66:
        r128 = null;
    L70:
        r45 = -1;
        goto L71
    L105:
        r210 = r124;
        r211 = r123;
        goto L106
    L107:
        r18 = -1;
        r13 = new Pair(BuildConfig.FLAVOR, r119);
        goto L109
    L45:
        r122 = false;
        goto L46
    L48:
        r121 = null;
        goto L49
    L31:
        r11 = null;
        goto L32
    L110:
        r18 = -1;
        e1 r53 = (e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class);
        List<w1> r54 = this.h.N3().c;
        if (r54 == null) goto L112;
        LongSparseArray r55 = e1.a();
        e1.f();
        if (r55 != null) goto L116;
    L172:
        r15 = true;
        r13 = null;
        goto L173
    L116:
        if (r55.size() == 0) goto L172;
        ArrayList r56 = new ArrayList();
        int r57 = r55.size();
        h1 r58 = null;
        List<Integer> r59 = ((e2) com.bytedance.android.livesdk.gift.platform.core.h.h0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[58])).c();
        Iterator<T> r60 = r54.iterator();
    L120:
        if (r60.hasNext() == false) goto L127;
        Object r135 = r60.next();
        if (((w1) r135).getPageType() != 1) goto L124;
        boolean r136 = true;
    L125:
        if (r136 == false) goto L120;
    L128:
        w1 r137 = (w1) r135;
        int r61 = 0;
    L129:
        if (r61 >= r57) goto L171;
        Integer r138 = (Integer) r55.valueAt(r61);
        long r139 = r55.keyAt(r61);
        int r140 = r54.size();
        if (r137 == null) goto L145;
        List<h1> r141 = r137.getGifts();
        if (r141 == null) goto L145;
        Iterator<T> r142 = r141.iterator();
    L136:
        if (r142.hasNext() == false) goto L143;
        Object r143 = r142.next();
        if (((h1) r143).getId() != r139) goto L140;
        boolean r144 = true;
    L141:
        if (r144 == false) goto L136;
    L144:
        h1 r145 = (h1) r143;
    L146:
        if (r145 == null) goto L148;
        r56.add(new p(r145, r138.intValue(), 1));
        List<w1> r146 = r54;
    L170:
        r61 = r61 + 1;
        r54 = r146;
        r58 = null;
        goto L129
    L148:
        int r63 = 0;
    L149:
        if (r63 >= r140) goto L169;
        w1 r147 = (w1) ListProtector.get(r54, r63);
        r146 = r54;
        if (r147.getPageType() == 1) goto L168;
        if (r59 == null) goto L168;
        if (r59.contains(Integer.valueOf(r147.getPageType())) != true) goto L168;
        Iterator<T> r64 = r147.getGifts().iterator();
    L157:
        if (r64.hasNext() == false) goto L164;
        Object r212 = r64.next();
        if (((h1) r212).getId() != r139) goto L161;
        boolean r213 = true;
    L162:
        if (r213 == false) goto L157;
    L165:
        h1 r65 = (h1) r212;
        if (r65 == null) goto L168;
        r56.add(new p(r65, r138.intValue(), r147.getPageType()));
        goto L170
    L161:
        r213 = false;
        goto L162
    L164:
        r212 = null;
    L168:
        r63 = r63 + 1;
        r54 = r146;
        goto L149
    L169:
        r146 = r54;
        goto L170
    L140:
        r144 = false;
        goto L141
    L143:
        r143 = r58;
    L145:
        r145 = r58;
        goto L146
    L171:
        r15 = true;
        r13 = new Pair(BuildConfig.FLAVOR, r56);
        goto L173
    L124:
        r136 = false;
        goto L125
    L127:
        r135 = null;
    L23:
        r9 = null;
        goto L24
    L9:
        if (r5.isEmpty() == true) goto L12;
        r7 = false;
        goto L13
    L5:
        r4 = null;
        goto L6
    }

    public final Pair<String, List<p>> c(ReceiverType r3) {
        Intrinsics.checkNotNullParameter(r3, "receiverType");
        a();
        Pair<String, List<p>> r4 = (Pair) ((LinkedHashMap) this.e).get(r3);
        if (r4 == null) goto L5;
        return r4;
    L5:
        return new Pair(BuildConfig.FLAVOR, CollectionsKt.emptyList());
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.h
    public final List<Long> vb(ReceiverType r2) {
        Intrinsics.checkNotNullParameter(r2, "receiverType");
        com.bytedance.android.livesdk.gift.platform.core.model.l r3 = (com.bytedance.android.livesdk.gift.platform.core.model.l) ((LinkedHashMap) this.a).get(r2);
        if (r3 == null) goto L10;
        List<j> r4 = r3.a;
        if (r4 == null) goto L10;
        return SequencesKt.toList(SequencesKt.flatMapIterable(CollectionsKt.asSequence(r4), GiftListPanelRepository$getPanelShowGiftList$1.INSTANCE));
    L10:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.h
    public final w1 ve(ReceiverType r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "receiverType");
        Iterator<T> r5 = Mn(r3).c.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        Object r0 = r5.next();
        if (((w1) r0).getPageType() != r4) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L4;
    L13:
        return (w1) r0;
    L8:
        r1 = false;
        goto L9
    L11:
        r0 = null;
        goto L13
    }

    public final k d(ReceiverType r8, int r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "receiverType");
        Object r4 = null;
        if (r10 > 0) goto L5;
    L19:
        List r11 = (List) ((LinkedHashMap) this.b).get(r8);
        if (r11 == null) goto L43;
        Iterator r13 = r11.iterator();
    L23:
        if (r13.hasNext() == false) goto L31;
        Object r14 = r13.next();
        if (((k) r14).a != r9) goto L27;
        boolean r15 = true;
    L28:
        if (r15 == false) goto L23;
        r4 = r14;
        goto L31
    L27:
        r15 = false;
    L31:
        return (k) r4;
    L43:
        return null;
    L5:
        if (v.g() == false) goto L19;
        List r16 = (List) ((LinkedHashMap) this.d).get(r8);
        if (r16 == null) goto L42;
        Iterator r17 = r16.iterator();
    L10:
        if (r17.hasNext() == false) goto L18;
        Object r18 = r17.next();
        if (((k) r18).a != r10) goto L14;
        boolean r0 = true;
    L15:
        if (r0 == false) goto L10;
        r4 = r18;
        goto L18
    L14:
        r0 = false;
    L18:
        return (k) r4;
    L42:
        return null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.h
    public final void N(long r10, int r13, int r14, ReceiverType r15) {
        Intrinsics.checkNotNullParameter(r15, "receiverType");
        com.bytedance.android.livesdk.gift.platform.core.model.l r0 = (com.bytedance.android.livesdk.gift.platform.core.model.l) ((LinkedHashMap) this.a).get(r15);
        if (r0 == null) goto L112;
        List<j> r1 = r0.a;
        if (r1 == null) goto L113;
        Iterator<T> r2 = r1.iterator();
    L7:
        Object r5 = null;
        if (r2.hasNext() == false) goto L15;
        Object r3 = r2.next();
        if (((j) r3).a != 17) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L7;
    L16:
        j r4 = (j) r3;
        if (r4 != null) goto L19;
        return;
    L19:
        if (r14 == 1) goto L58;
        if (r14 != 2) goto L118;
        List<Long> r7 = CollectionsKt.toMutableList(r4.l);
        r7.remove(Long.valueOf(r10));
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r4.l = r7;
        Pair r16 = (Pair) ((LinkedHashMap) this.c).get(r15);
        if (r16 == null) goto L54;
        com.bytedance.android.livesdk.gift.platform.core.model.j r17 = (com.bytedance.android.livesdk.gift.platform.core.model.j) r16.getFirst();
        if (r17 == null) goto L54;
        List<w1> r18 = r17.c;
        if (r18 == null) goto L54;
        Iterator<T> r19 = r18.iterator();
    L31:
        if (r19.hasNext() == false) goto L38;
        Object r8 = r19.next();
        if (((w1) r8).getPageType() != 17) goto L35;
        boolean r9 = true;
    L36:
        if (r9 == false) goto L31;
    L39:
        w1 r11 = (w1) r8;
        if (r11 == null) goto L54;
        Iterator<T> r110 = r11.getGifts().iterator();
    L43:
        if (r110.hasNext() == false) goto L50;
        Object r20 = r110.next();
        if (((h1) r20).getId() != r10) goto L47;
        boolean r21 = true;
    L48:
        if (r21 == false) goto L43;
        r5 = r20;
        goto L50
    L47:
        r21 = false;
    L50:
        h1 r23 = (h1) r5;
        if (r23 == null) goto L54;
        List<? extends h1> r111 = CollectionsKt.toMutableList(r11.getGifts());
        r111.remove(r23);
        Unit r24 = Unit.INSTANCE;
        r11.setGifts(r111);
        goto L54
    L35:
        r9 = false;
        goto L36
    L38:
        r8 = null;
    L54:
        uz1.a r112 = b0.b();
        if (r112 == null) goto L115;
        r112.a(new RefreshGiftMostlyUsedStatus(r10, r14, r13, false, 8, null));
        return;
    L115:
        return;
    L118:
        return;
    L58:
        if (r4.l.contains(Long.valueOf(r10)) == true) goto L60;
        List<Long> r25 = CollectionsKt.toMutableList(r4.l);
        ListProtector.add(r25, 0, Long.valueOf(r10));
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r4.l = r25;
    L60:
        h1 r26 = this.h.o4(r10, Integer.valueOf(r13));
        if (r26 != null) goto L63;
        return;
    L63:
        Pair r113 = (Pair) ((LinkedHashMap) this.c).get(r15);
        if (r113 == null) goto L87;
        com.bytedance.android.livesdk.gift.platform.core.model.j r114 = (com.bytedance.android.livesdk.gift.platform.core.model.j) r113.getFirst();
        if (r114 == null) goto L87;
        List<w1> r115 = r114.c;
        if (r115 == null) goto L87;
        Iterator<T> r116 = r115.iterator();
    L71:
        if (r116.hasNext() == false) goto L78;
        Object r27 = r116.next();
        if (((w1) r27).getPageType() != 17) goto L75;
        boolean r28 = true;
    L76:
        if (r28 == false) goto L71;
        r5 = r27;
        goto L78
    L75:
        r28 = false;
    L78:
        w1 r29 = (w1) r5;
        if (r29 == null) goto L87;
        List<h1> r117 = r29.getGifts();
        ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator<T> r118 = r117.iterator();
    L82:
        if (r118.hasNext() == false) goto L85;
        r30.add(Long.valueOf(((h1) r118.next()).getId()));
        goto L82
    L85:
        if (r30.contains(Long.valueOf(r10)) == true) goto L87;
        List<? extends h1> r119 = CollectionsKt.toMutableList(r29.getGifts());
        ListProtector.add(r119, 0, r26);
        Unit r31 = Unit.INSTANCE;
        r29.setGifts(r119);
    L87:
        uz1.a r120 = b0.b();
        if (r120 == null) goto L117;
        r120.a(new RefreshGiftMostlyUsedStatus(r10, r14, r13, false, 8, null));
        return;
    L117:
        return;
    L12:
        r6 = false;
        goto L13
    L15:
        r3 = null;
        goto L16
    L113:
        return;
    }

    public GiftListPanelRepository(yz0.k r2, com.bytedance.android.scope.j r3, i r4, GiftListFilterService r5, e1 r6) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "giftListRepository");
        Intrinsics.checkNotNullParameter(r5, "listFilterService");
        Intrinsics.checkNotNullParameter(r6, "giftListService");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.a = new LinkedHashMap();
        new ArrayList();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.h
    public final void lm(final ReceiverType r17, com.bytedance.android.livesdk.gift.platform.core.model.l r18, List<k> r19, List<k> r20, int r21, String r23) {
        Intrinsics.checkNotNullParameter(r17, "receiverType");
        Intrinsics.checkNotNullParameter(r18, "giftPanelModelData");
        Intrinsics.checkNotNullParameter(r19, "pagingGiftListModel");
        Intrinsics.checkNotNullParameter(r20, "topicPagingGiftListModel");
        Intrinsics.checkNotNullParameter(r23, "logId");
        this.i.e = 0;
        Long r7 = null;
        final boolean r5 = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.T.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[44])).booleanValue();
        List<j> r2 = r18.a;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r8.add(ModelUtilsKt.b((j) r3.next(), GiftListPanelRepository$updateCacheFromRemoteForPagingOpt$giftPages$1$1.INSTANCE, new GiftListPanelRepository$updateCacheFromRemoteForPagingOpt$$inlined$map$lambda$1(this)));
        goto L4
    L6:
        long r9 = System.currentTimeMillis();
        Map<ReceiverType, com.bytedance.android.livesdk.gift.platform.core.model.l> r4 = this.a;
        yz0.k r6 = this.f;
        if (r6 == null) goto L11;
        IRoom r10 = r6.getRoom();
        if (r10 == null) goto L11;
        r7 = Long.valueOf(r10.getRoomId());
    L11:
        r4.put(r17, new com.bytedance.android.livesdk.gift.platform.core.model.l(r8, r9, r21, r7.longValue(), r23));
        Map<ReceiverType, List<k>> r11 = this.b;
        List<k> r13 = r19;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r15 = r13.iterator();
    L13:
        if (r15.hasNext() == false) goto L19;
        k r16 = (k) r15.next();
        if (r5 == false) goto L17;
        Function1 r24 = new GiftListPanelRepository$updateCacheFromRemoteForPagingOpt$$inlined$map$lambda$2(this, r5, r17);
    L18:
        r14.add(PagingGiftListModelKt.a(r16, r24, new GiftListPanelRepository$updateCacheFromRemoteForPagingOpt$$inlined$map$lambda$3(this, r5, r17)));
        goto L13
    L17:
        r24 = GiftListPanelRepository$updateCacheFromRemoteForPagingOpt$1$2.INSTANCE;
        goto L18
    L19:
        r11.put(r17, r14);
        if (v.g() == false) goto L30;
        Map<ReceiverType, List<k>> r25 = this.d;
        ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator<T> r27 = r20.iterator();
    L23:
        if (r27.hasNext() == false) goto L29;
        k r28 = (k) r27.next();
        if (r5 == false) goto L27;
        Function1 r29 = new GiftListPanelRepository$updateCacheFromRemoteForPagingOpt$$inlined$map$lambda$4(this, r5, r17);
    L28:
        r26.add(PagingGiftListModelKt.a(r28, r29, new GiftListPanelRepository$updateCacheFromRemoteForPagingOpt$$inlined$map$lambda$5(this, r5, r17)));
        goto L23
    L27:
        r29 = GiftListPanelRepository$updateCacheFromRemoteForPagingOpt$2$2.INSTANCE;
        goto L28
    L29:
        r25.put(r17, r26);
    L30:
        ((LinkedHashMap) this.c).clear();
        uz1.a r30 = b0.a();
        if (r30 == null) goto L33;
        r30.a(new UpdatePanelGiftList(r17));
    L33:
        d.a("GiftListPanelRepository", "update room cache, currentReceiverType" + r17);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.h
    public final void t1(final ReceiverType r19, Integer r20, Long r21, com.bytedance.android.livesdk.gift.platform.core.model.l r23, List<k> r24, List<k> r25, int r26, String r27) {
        Intrinsics.checkNotNullParameter(r19, "receiverType");
        Intrinsics.checkNotNullParameter(r23, "giftPanelModelData");
        Intrinsics.checkNotNullParameter(r24, "pagingGiftListModel");
        Intrinsics.checkNotNullParameter(r25, "topicPagingGiftListModel");
        Intrinsics.checkNotNullParameter(r27, "logId");
        Long r8 = null;
        final boolean r6 = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.T.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[44])).booleanValue();
        List<j> r3 = r23.a;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r9.add(ModelUtilsKt.b((j) r4.next(), GiftListPanelRepository$updateCacheFromRemoteForPagingLoadMore$giftPages$1$1.INSTANCE, new GiftListPanelRepository$updateCacheFromRemoteForPagingLoadMore$$inlined$map$lambda$1(this)));
        goto L4
    L6:
        long r10 = System.currentTimeMillis();
        Map<ReceiverType, com.bytedance.android.livesdk.gift.platform.core.model.l> r5 = this.a;
        yz0.k r7 = this.f;
        if (r7 == null) goto L11;
        IRoom r11 = r7.getRoom();
        if (r11 == null) goto L11;
        r8 = Long.valueOf(r11.getRoomId());
    L11:
        r5.put(r19, new com.bytedance.android.livesdk.gift.platform.core.model.l(r9, r10, r26, r8.longValue(), r27));
        Map<ReceiverType, List<k>> r13 = this.b;
        List<k> r14 = r24;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L13:
        if (r16.hasNext() == false) goto L19;
        k r17 = (k) r16.next();
        if (r6 == false) goto L17;
        Function1 r18 = new GiftListPanelRepository$updateCacheFromRemoteForPagingLoadMore$$inlined$map$lambda$2(this, r6, r19);
    L18:
        r15.add(PagingGiftListModelKt.a(r17, r18, new GiftListPanelRepository$updateCacheFromRemoteForPagingLoadMore$$inlined$map$lambda$3(this, r6, r19)));
        goto L13
    L17:
        r18 = GiftListPanelRepository$updateCacheFromRemoteForPagingLoadMore$1$2.INSTANCE;
        goto L18
    L19:
        r13.put(r19, r15);
        if (v.g() == false) goto L30;
        Map<ReceiverType, List<k>> r28 = this.d;
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
        Iterator<T> r30 = r25.iterator();
    L23:
        if (r30.hasNext() == false) goto L29;
        k r31 = (k) r30.next();
        if (r6 == false) goto L27;
        Function1 r33 = new GiftListPanelRepository$updateCacheFromRemoteForPagingLoadMore$$inlined$map$lambda$4(this, r6, r19);
    L28:
        r29.add(PagingGiftListModelKt.a(r31, r33, new GiftListPanelRepository$updateCacheFromRemoteForPagingLoadMore$$inlined$map$lambda$5(this, r6, r19)));
        goto L23
    L27:
        r33 = GiftListPanelRepository$updateCacheFromRemoteForPagingLoadMore$2$2.INSTANCE;
        goto L28
    L29:
        r28.put(r19, r29);
    L30:
        ((LinkedHashMap) this.c).clear();
        if (r20 == null) goto L50;
        r20.intValue();
        uz1.a r34 = b0.a();
        if (r34 == null) goto L35;
        r34.a(new UpdateLoadMoreState(false, r20.intValue(), r21));
    L35:
        uz1.a r35 = b0.a();
        if (r35 == null) goto L51;
        int r36 = r20.intValue();
        if (r21 == null) goto L40;
        long r37 = r21.longValue();
    L41:
        r35.a(new IncrementalUpdatePanelGiftList(r19, r36, r37));
        return;
    L40:
        r37 = 0;
        goto L41
    L51:
        return;
    }
}
