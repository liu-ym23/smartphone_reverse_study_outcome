package com.bytedance.android.live.revlink.widgetservice;

import com.bytedance.android.live.revlink.impl.control.launchcontext.c;
import com.bytedance.revenue.platform.api.core.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevLinkAnchorLaunchParam {
    public static final /* synthetic */ int q = 0;
    public final int a;
    public final String b;
    public final long c;
    public final Function0<Integer> d;
    public final Function0<Integer> e;
    public final boolean f;
    public final Map<Long, String> g;
    public final Map<Long, String> h;
    public final Map<Long, String> i;
    public final Map<Long, String> j;
    public final com.bytedance.android.live.revlink.impl.control.launchcontext.a k;
    public final c l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.widgetservice.RevLinkAnchorLaunchParam$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    final class AnonymousClass1 extends Lambda implements Function0<Integer> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        public final int invoke() {
            return 0;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m986invoke() {
            return Integer.valueOf(invoke());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.widgetservice.RevLinkAnchorLaunchParam$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    final class AnonymousClass2 extends Lambda implements Function0<Integer> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(0);
        }

        public final int invoke() {
            return 0;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m987invoke() {
            return Integer.valueOf(invoke());
        }
    }

    public static final class Companion {
        public static RevLinkAnchorLaunchParam a(int r18, long r19, boolean r22) {
            return new RevLinkAnchorLaunchParam(r18, "", r19, RevLinkAnchorLaunchParam$Companion$genMergeSceneSwitchParam$1.INSTANCE, RevLinkAnchorLaunchParam$Companion$genMergeSceneSwitchParam$2.INSTANCE, d.a(new Pair[0]), d.a(new Pair[0]), d.a(new Pair[0]), d.a(new Pair[0]), null, null, false, false, true, r22);
        }
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof RevLinkAnchorLaunchParam) == false) goto L38;
        RevLinkAnchorLaunchParam r7 = (RevLinkAnchorLaunchParam) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
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
        if (this.m == r7.m) goto L32;
        return false;
    L32:
        if (this.n == r7.n) goto L34;
        return false;
    L34:
        if (this.o == r7.o) goto L36;
        return false;
    L36:
        if (this.p == r7.p) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30, types: [int] */
    /* JADX WARN: Type inference failed for: r1v32, types: [int] */
    /* JADX WARN: Type inference failed for: r1v34, types: [int] */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        long r4 = this.c;
        int r5 = (((r0 + r3) * 31) + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        Function0<Integer> r6 = this.d;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        Function0<Integer> r9 = this.e;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r12 = (r8 + r10) * 31;
        boolean r13 = this.f;
        ?? r14 = 1;
        ?? r15 = r13;
        if (r13 == false) goto L17;
        r15 = 1;
    L17:
        int r16 = (r12 + r15) * 31;
        Map<Long, String> r17 = this.g;
        if (r17 == null) goto L20;
        int r18 = r17.hashCode();
    L21:
        int r19 = (r16 + r18) * 31;
        Map<Long, String> r20 = this.h;
        if (r20 == null) goto L24;
        int r22 = r20.hashCode();
    L25:
        int r23 = (r19 + r22) * 31;
        Map<Long, String> r24 = this.i;
        if (r24 == null) goto L28;
        int r25 = r24.hashCode();
    L29:
        int r26 = (r23 + r25) * 31;
        Map<Long, String> r27 = this.j;
        if (r27 == null) goto L32;
        int r28 = r27.hashCode();
    L33:
        int r29 = (r26 + r28) * 31;
        com.bytedance.android.live.revlink.impl.control.launchcontext.a r30 = this.k;
        if (r30 == null) goto L36;
        int r32 = r30.hashCode();
    L37:
        int r33 = (r29 + r32) * 31;
        c r34 = this.l;
        if (r34 == null) goto L40;
        r2 = r34.hashCode();
    L40:
        int r35 = (r33 + r2) * 31;
        boolean r36 = this.m;
        ?? r37 = r36;
        if (r36 == false) goto L43;
        r37 = 1;
    L43:
        int r38 = (r35 + r37) * 31;
        boolean r39 = this.n;
        ?? r40 = r39;
        if (r39 == false) goto L46;
        r40 = 1;
    L46:
        int r42 = (r38 + r40) * 31;
        boolean r43 = this.o;
        ?? r44 = r43;
        if (r43 == false) goto L49;
        r44 = 1;
    L49:
        int r45 = (r42 + r44) * 31;
        boolean r46 = this.p;
        if (r46 == true) goto L54;
        r14 = r46;
    L54:
        return r45 + r14;
    L36:
        r32 = 0;
        goto L37
    L32:
        r28 = 0;
        goto L33
    L28:
        r25 = 0;
        goto L29
    L24:
        r22 = 0;
        goto L25
    L20:
        r18 = 0;
        goto L21
    L13:
        r10 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "RevLinkAnchorLaunchParam(scene=" + this.a + ", selfLinkerID=" + this.b + ", channelID=" + this.c + ", containerWidth=" + this.d + ", containerHeight=" + this.e + ", selfIsPKStarter=" + this.f + ", rtcData=" + this.g + ", liveCoreData=" + this.h + ", indexRtcData=" + this.i + ", indexLiveCoreData=" + this.j + ", multiLinkAnchorLaunchContext=" + this.k + ", pkAnchorLaunchContext=" + this.l + ", hasStartRtc=" + this.m + ", needJoinChannel=" + this.n + ", isMergeSceneSwitchData=" + this.o + ", resetPKDataContext=" + this.p + ")";
    }

    public RevLinkAnchorLaunchParam(int r12, String r13, long r14, Function0 r15, Function0 r16, Map r17, Map r18, Map r19, Map r20, com.bytedance.android.live.revlink.impl.control.launchcontext.a r22, c r23, boolean r24, boolean r25, boolean r26, boolean r27) {
        Intrinsics.checkNotNullParameter(r13, "selfLinkerID");
        Intrinsics.checkNotNullParameter(r15, "containerWidth");
        Intrinsics.checkNotNullParameter(r16, "containerHeight");
        Intrinsics.checkNotNullParameter(r17, "rtcData");
        Intrinsics.checkNotNullParameter(r18, "liveCoreData");
        Intrinsics.checkNotNullParameter(r19, "indexRtcData");
        Intrinsics.checkNotNullParameter(r20, "indexLiveCoreData");
        this.a = r12;
        this.b = r13;
        this.c = r14;
        this.d = r15;
        this.e = r16;
        this.f = false;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r20;
        this.k = r22;
        this.l = r23;
        this.m = r24;
        this.n = r25;
        this.o = r26;
        this.p = r27;
    }
}
