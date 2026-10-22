package com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine;

import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IBattleBarConfig;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.ITeamTask;
import com.bytedance.android.livesdk.link.model.a1;
import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.b1;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.g7;
import com.bytedance.android.livesdk.link.model.i3;
import com.bytedance.android.livesdk.link.model.l9;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.u1;
import com.bytedance.android.livesdk.link.model.z2;
import com.bytedance.android.livesdk.link.model.z4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int p = 0;
    public final IBaseBattleSetting a;
    public final Map<String, IBattleUserInfo> b;
    public final List<a1> c;
    public final Map<Long, g7> d;
    public final long e;
    public final IBattleBarConfig f;
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.b g;
    public final Map<String, z2> h;
    public final n3 i;
    public final l9 j;
    public final ITeamTask k;
    public final String l;
    public final Map<String, String> m;
    public final z4 n;
    public final p0 o;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a$a, reason: collision with other inner class name */
    public static final class C0134a {
        public static a a(c3 r38) {
            if (r38 == null) goto L29;
            c1 r1 = r38.getBattleSetting();
            List r0 = r38.getBattleScorePairList();
            Map r2 = r38.getMultiPkTeam();
            c1 r3 = r38.getBattleSetting();
            if (r3 == null) goto L6;
            IBattleBarConfig r7 = r3.getBarConfig();
        L7:
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r8 = new com.bytedance.android.live.revlink.impl.mergepk.pkbase.b(r38.getSkinType(), r38.getSkinConfig());
            ITeamTask r12 = r38.getTeamTask();
            String r13 = r38.getTeamTaskJson();
            n3 r10 = r38.getBreakthroughInfo();
            Map r4 = r38.getBattleUserInfoMap();
            l9 r14 = r38.getSurvivalInfo();
            c1 r5 = r38.getBattleSetting();
            if (r5 == null) goto L10;
            long r6 = r5.getFinished();
        L11:
            Map<String, String> r15 = h41.h.a(r38.getEventTrackingInfo());
            if (r0 == null) goto L14;
            List r9 = CollectionsKt.toList(r0);
        L15:
            if (r2 == null) goto L21;
            LinkedHashMap r16 = new LinkedHashMap(MapsKt.mapCapacity(r2.size()));
            Iterator r17 = r2.entrySet().iterator();
        L18:
            if (r17.hasNext() == false) goto L20;
            Map.Entry r18 = (Map.Entry) r17.next();
            r16.put(Long.valueOf(((Number) r18.getKey()).longValue()), r18.getValue());
            goto L18
        L20:
            Map r19 = MapsKt.toMap(r16);
        L23:
            if (r4 == null) goto L25;
            Map r20 = MapsKt.toMap(r4);
        L27:
            return new a(r1, r20, r9, r19, r6, r7, r8, null, r10, r14, r12, r13, r15, null, null, 24704);
        L25:
            r20 = null;
            goto L27
        L21:
            r19 = null;
            goto L23
        L14:
            r9 = null;
            goto L15
        L10:
            r6 = 0;
            goto L11
        L6:
            r7 = null;
            goto L7
        L29:
            return new a(null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 32767);
        }

        public static a b(a5 r20, IBattleBarConfig r22, com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r23) {
            Intrinsics.checkNotNullParameter(r20, "battleFinishMessage");
            u1 r2 = r20.getBattleSetting();
            List r0 = r20.getBattleScorePairList();
            Map r3 = r20.getBattleUserInfoMap();
            Map r4 = r20.getGradeChanges();
            n3 r12 = r20.getBreakthroughInfo();
            l9 r13 = r20.getSurvivalInfo();
            Map<String, String> r15 = h41.h.a(r20.getEventTrackingInfo());
            z4 r16 = r20.getBattleFinishExtra();
            List r1 = CollectionsKt.toList(r0);
            Map r5 = null;
            if (r3 == null) goto L5;
            Map r6 = MapsKt.toMap(r3);
        L7:
            if (r4 == null) goto L10;
            r5 = MapsKt.toMap(r4);
        L10:
            return new a(r2, r6, r1, null, 0, r22, r23, r5, r12, r13, null, null, r15, r16, null, 19480);
        L5:
            r6 = null;
            goto L7
        }
    }

    static {
    }

    public a() {
        this(null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 32767);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L36;
        a r7 = (a) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r7.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r7.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r7.n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r7.o) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    public final int hashCode() {
        IBaseBattleSetting r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, IBattleUserInfo> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<a1> r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<Long, g7> r10 = this.d;
        if (r10 == null) goto L17;
        int r12 = r10.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        long r14 = this.e;
        int r15 = (r13 + ((int) (r14 ^ (r14 >>> 32)))) * 31;
        IBattleBarConfig r16 = this.f;
        if (r16 == null) goto L21;
        int r17 = r16.hashCode();
    L22:
        int r18 = (r15 + r17) * 31;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r19 = this.g;
        if (r19 == null) goto L25;
        int r20 = r19.hashCode();
    L26:
        int r22 = (r18 + r20) * 31;
        Map<String, z2> r23 = this.h;
        if (r23 == null) goto L29;
        int r24 = r23.hashCode();
    L30:
        int r25 = (r22 + r24) * 31;
        n3 r26 = this.i;
        if (r26 == null) goto L33;
        int r27 = r26.hashCode();
    L34:
        int r28 = (r25 + r27) * 31;
        l9 r29 = this.j;
        if (r29 == null) goto L37;
        int r30 = r29.hashCode();
    L38:
        int r32 = (r28 + r30) * 31;
        ITeamTask r33 = this.k;
        if (r33 == null) goto L41;
        int r34 = r33.hashCode();
    L42:
        int r35 = (r32 + r34) * 31;
        String r36 = this.l;
        if (r36 == null) goto L45;
        int r37 = r36.hashCode();
    L46:
        int r38 = (r35 + r37) * 31;
        Map<String, String> r39 = this.m;
        if (r39 == null) goto L49;
        int r40 = r39.hashCode();
    L50:
        int r42 = (r38 + r40) * 31;
        z4 r43 = this.n;
        if (r43 == null) goto L53;
        int r44 = r43.hashCode();
    L54:
        int r45 = (r42 + r44) * 31;
        p0 r46 = this.o;
        if (r46 == null) goto L58;
        r1 = r46.hashCode();
    L58:
        return r45 + r1;
    L53:
        r44 = 0;
        goto L54
    L49:
        r40 = 0;
        goto L50
    L45:
        r37 = 0;
        goto L46
    L41:
        r34 = 0;
        goto L42
    L37:
        r30 = 0;
        goto L38
    L33:
        r27 = 0;
        goto L34
    L29:
        r24 = 0;
        goto L30
    L25:
        r20 = 0;
        goto L26
    L21:
        r17 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final long a() {
        IBaseBattleSetting r0 = this.a;
        if (r0 == null) goto L10;
        r0.setPunishDuration(af2.d.b(r0));
        if (r0.getPunishStartTimeMs() == 0) goto L7;
        long r1 = (r0.getPunishDuration() * ((long) WebcastRedirectException.UNKNOWN)) + r0.getPunishStartTimeMs();
        long r3 = com.bytedance.live.kmp.util.e.a();
    L9:
        return r1 - r3;
    L7:
        r1 = ((r0.getDuration() + r0.getPunishDuration()) * ((long) WebcastRedirectException.UNKNOWN)) + r0.getStartTimeMs();
        r3 = com.bytedance.live.kmp.util.e.a();
        goto L9
    L10:
        return 0;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("PKStateInfo {battleSetting : ");
        IBaseBattleSetting r1 = this.a;
        ArrayList r2 = null;
        if (r1 == null) goto L5;
        String r3 = af2.d.e(r1);
    L6:
        r0.append(r3);
        r0.append(", battleUserInfoMap : ");
        Map<String, IBattleUserInfo> r4 = this.b;
        if (r4 == null) goto L12;
        LinkedHashMap r5 = new LinkedHashMap(MapsKt.mapCapacity(r4.size()));
        Iterator<T> r6 = r4.entrySet().iterator();
    L10:
        if (r6.hasNext() == false) goto L13;
        Map.Entry r7 = (Map.Entry) r6.next();
        r5.put(r7.getKey(), i3.a((IBattleUserInfo) r7.getValue()));
    L13:
        r0.append(r5);
        r0.append(", battleScorePairList : ");
        List<a1> r8 = this.c;
        if (r8 == null) goto L19;
        List<a1> r9 = r8;
        r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L17:
        if (r10.hasNext() == false) goto L19;
        r2.add(b1.a((a1) r10.next()));
    L19:
        r0.append(r2);
        r0.append(", multiPKTeam : ");
        r0.append(this.d);
        r0.append(", finished : ");
        r0.append(this.e);
        return r0.toString();
    L12:
        r5 = null;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public a(IBaseBattleSetting r17, Map r18, List r19, Map r20, long r22, IBattleBarConfig r23, com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r24, Map r25, n3 r26, l9 r27, ITeamTask r28, String r29, Map r30, z4 r32, p0 r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        IBaseBattleSetting r2 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        Map r4 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        List r5 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        Map r6 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        long r7 = 0;
    L23:
        if ((r34 & 32) == 0) goto L25;
        IBattleBarConfig r9 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r10 = null;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Map r12 = null;
    L35:
        if ((r34 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L37;
        n3 r13 = null;
    L39:
        if ((r34 & 512) == 0) goto L41;
        l9 r14 = null;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        ITeamTask r15 = null;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r16 = null;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        Map r3 = null;
    L54:
        Map r110 = r3;
        if ((r34 & 8192) == 0) goto L57;
        z4 r8 = null;
    L59:
        if ((r34 & 16384) == 0) goto L61;
        p0 r1 = null;
    L62:
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r9;
        this.g = r10;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r16;
        this.m = r110;
        this.n = r8;
        this.o = r1;
        return;
    L61:
        r1 = r33;
        goto L62
    L57:
        r8 = r32;
        goto L59
    L53:
        r3 = r30;
        goto L54
    L49:
        r16 = r29;
        goto L51
    L45:
        r15 = r28;
        goto L47
    L41:
        r14 = r27;
        goto L43
    L37:
        r13 = r26;
        goto L39
    L33:
        r12 = r25;
        goto L35
    L29:
        r10 = r24;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r4 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }
}
