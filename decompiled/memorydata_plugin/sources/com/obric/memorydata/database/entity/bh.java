package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 72\u00020\u0001:\u00017B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u008b\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005HÆ\u0001J\u0013\u00102\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0005HÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017¨\u00068"}, d2 = {"Lcom/obric/memorydata/database/entity/EntityIndexLifecycleEntity;", "", "rawDbId", "", "entityType", "", "firstCompletionStartedAt", "backlogRoundStartedAt", "firstCompletionFinished", "", "backlogRoundId", "updatedAt", "coveragePolicyVersion", "coverageSourceTimestamp", "coverageRequiredCount", "coverageSuccessCount", "coverageTerminalFailureCount", "coverageState", "<init>", "(JIJJZJJIJIIII)V", "getRawDbId", "()J", "getEntityType", "()I", "getFirstCompletionStartedAt", "getBacklogRoundStartedAt", "getFirstCompletionFinished", "()Z", "getBacklogRoundId", "getUpdatedAt", "getCoveragePolicyVersion", "getCoverageSourceTimestamp", "getCoverageRequiredCount", "getCoverageSuccessCount", "getCoverageTerminalFailureCount", "getCoverageState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8929a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f8930b;
    private final int c;
    private final long d;
    private final long e;
    private final boolean f;
    private final long g;
    private final long h;
    private final int i;
    private final long j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/entity/EntityIndexLifecycleEntity$Companion;", "", "<init>", "()V", "COVERAGE_UNKNOWN", "", "COVERAGE_INCOMPLETE", "COVERAGE_COMPLETE", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8929a = new a(null);
    }

    public bh(long r4, int r6, long r7, long r9, boolean r11, long r12, long r14, int r16, long r17, int r19, int r20, int r21, int r22) {
        this.f8930b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r9;
        this.f = r11;
        this.g = r12;
        this.h = r14;
        this.i = r16;
        this.j = r17;
        this.k = r19;
        this.l = r20;
        this.m = r21;
        this.n = r22;
    }

    public /* synthetic */ bh(long r25, int r27, long r28, long r30, boolean r32, long r33, long r35, int r37, long r38, int r40, int r41, int r42, int r43, int r44, DefaultConstructorMarker r45) {
        if ((r44 & 4) == 0) goto L5;
        long r8 = 0;
    L7:
        if ((r44 & 8) == 0) goto L9;
        long r10 = 0;
    L11:
        if ((r44 & 16) == 0) goto L13;
        boolean r12 = false;
    L15:
        if ((r44 & 32) == 0) goto L17;
        long r13 = 0;
    L19:
        if ((r44 & 64) == 0) goto L21;
        long r15 = 0;
    L23:
        if ((r44 & 128) == 0) goto L25;
        int r17 = 0;
    L27:
        if ((r44 & 256) == 0) goto L29;
        long r18 = 0;
    L31:
        if ((r44 & 512) == 0) goto L33;
        int r20 = -1;
    L35:
        if ((r44 & 1024) == 0) goto L37;
        int r21 = 0;
    L39:
        if ((r44 & 2048) == 0) goto L41;
        int r22 = 0;
    L43:
        if ((r44 & 4096) == 0) goto L45;
        int r23 = 0;
    L46:
        this(r25, r27, r8, r10, r12, r13, r15, r17, r18, r20, r21, r22, r23);
        return;
    L45:
        r23 = r43;
        goto L46
    L41:
        r22 = r42;
        goto L43
    L37:
        r21 = r41;
        goto L39
    L33:
        r20 = r40;
        goto L35
    L29:
        r18 = r38;
        goto L31
    L25:
        r17 = r37;
        goto L27
    L21:
        r15 = r35;
        goto L23
    L17:
        r13 = r33;
        goto L19
    L13:
        r12 = r32;
        goto L15
    L9:
        r10 = r30;
        goto L11
    L5:
        r8 = r28;
        goto L7
    }

    public final long a() {
        return this.f8930b;
    }

    public final int b() {
        return this.c;
    }

    public final long c() {
        return this.d;
    }

    public final long d() {
        return this.e;
    }

    public final boolean e() {
        return this.f;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, bh.class) == true) goto L8;
        return false;
    L8:
        bh r10 = (bh) ZeusTransformUtils.preCheckCast(r9, bh.class, "com.obric.memorydata.plugin");
        if (this.f8930b == r10.f8930b) goto L12;
        return false;
    L12:
        if (this.c == r10.c) goto L15;
        return false;
    L15:
        if (this.d == r10.d) goto L18;
        return false;
    L18:
        if (this.e == r10.e) goto L21;
        return false;
    L21:
        if (this.f == r10.f) goto L24;
        return false;
    L24:
        if (this.g == r10.g) goto L27;
        return false;
    L27:
        if (this.h == r10.h) goto L30;
        return false;
    L30:
        if (this.i == r10.i) goto L33;
        return false;
    L33:
        if (this.j == r10.j) goto L36;
        return false;
    L36:
        if (this.k == r10.k) goto L39;
        return false;
    L39:
        if (this.l == r10.l) goto L42;
        return false;
    L42:
        if (this.m == r10.m) goto L45;
        return false;
    L45:
        if (this.n == r10.n) goto L47;
        return false;
    L47:
        return true;
    }

    public final long f() {
        return this.g;
    }

    public final long g() {
        return this.h;
    }

    public final int h() {
        return this.i;
    }

    public int hashCode() {
        return (((((((((((((((((((((((Long.hashCode(this.f8930b) * 31) + Integer.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + Long.hashCode(this.j)) * 31) + Integer.hashCode(this.k)) * 31) + Integer.hashCode(this.l)) * 31) + Integer.hashCode(this.m)) * 31) + Integer.hashCode(this.n);
    }

    public final long i() {
        return this.j;
    }

    public final int j() {
        return this.k;
    }

    public final int k() {
        return this.l;
    }

    public final int l() {
        return this.m;
    }

    public final int m() {
        return this.n;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("EntityIndexLifecycleEntity(rawDbId=").append(this.f8930b).append(", entityType=").append(this.c).append(", firstCompletionStartedAt=").append(this.d).append(", backlogRoundStartedAt=").append(this.e).append(", firstCompletionFinished=").append(this.f).append(", backlogRoundId=").append(this.g).append(", updatedAt=").append(this.h).append(", coveragePolicyVersion=").append(this.i).append(", coverageSourceTimestamp=").append(this.j).append(", coverageRequiredCount=").append(this.k).append(", coverageSuccessCount=").append(this.l).append(", coverageTerminalFailureCount=");
        r0.append(this.m).append(", coverageState=").append(this.n).append(')');
        return r0.toString();
    }
}
