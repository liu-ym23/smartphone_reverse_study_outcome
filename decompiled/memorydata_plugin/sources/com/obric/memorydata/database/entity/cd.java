package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b=\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0001NB\u0093\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0006HÆ\u0003J\t\u0010@\u001a\u00020\u0006HÆ\u0003J\t\u0010A\u001a\u00020\fHÆ\u0003J\t\u0010B\u001a\u00020\fHÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\t\u0010E\u001a\u00020\fHÆ\u0003J\t\u0010F\u001a\u00020\u0012HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\u009f\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0003HÆ\u0001J\u0013\u0010J\u001a\u00020\u00122\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\u0006HÖ\u0001J\t\u0010M\u001a\u00020\fHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR$\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010&R$\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010#\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010&R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010+R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010+\"\u0004\b2\u0010-R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u00103\"\u0004\b4\u00105R\u001e\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u0010&R\u001e\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0018\"\u0004\b9\u0010\u001a¨\u0006O"}, d2 = {"Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "", OaidModel.KEY_ID, "", "rawDbId", "entityType", "", "timestamp", "createTimeStamp", "state", "progress", "columnContent", "", "buildType", "indexProgress", LBSLightLocationTraceLogger.TOTAL, WsConstants.KEY_EXTRA, "isScheduledSlowTask", "", "retryCount", "nextRetryAt", "<init>", "(JJIJJIILjava/lang/String;Ljava/lang/String;IILjava/lang/String;ZIJ)V", "getId", "()J", "setId", "(J)V", "getRawDbId", "getEntityType", "()I", "getTimestamp", "setTimestamp", "getCreateTimeStamp", "setCreateTimeStamp", "getState$annotations", "()V", "getState", "setState", "(I)V", "getProgress$annotations", "getProgress", "setProgress", "getColumnContent", "()Ljava/lang/String;", "setColumnContent", "(Ljava/lang/String;)V", "getBuildType", "getIndexProgress", "getTotal", "getExtra", "setExtra", "()Z", "setScheduledSlowTask", "(Z)V", "getRetryCount", "setRetryCount", "getNextRetryAt", "setNextRetryAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8964a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8965b;
    private final long c;
    private final int d;
    private long e;
    private long f;
    private int g;
    private int h;
    private String i;
    private final String j;
    private final int k;
    private final int l;
    private String m;
    private boolean n;
    private int o;
    private long p;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/entity/IndexPendingEntity$Companion;", "", "<init>", "()V", "UNINDEXED", "", "LOW_POWER_INDEXED", "HIGH_POWER_INDEXING", "FULLY_INDEXED", "PAUSED_INDEX", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8964a = new a(null);
    }

    public cd(long r7, long r9, int r11, long r12, long r14, int r16, int r17, String r18, String r19, int r20, int r21, String r22, boolean r23, int r24, long r25) {
        Intrinsics.checkNotNullParameter(r18, "columnContent");
        Intrinsics.checkNotNullParameter(r19, "buildType");
        Intrinsics.checkNotNullParameter(r22, WsConstants.KEY_EXTRA);
        this.f8965b = r7;
        this.c = r9;
        this.d = r11;
        this.e = r12;
        this.f = r14;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r20;
        this.l = r21;
        this.m = r22;
        this.n = r23;
        this.o = r24;
        this.p = r25;
    }

    public /* synthetic */ cd(long r26, long r28, int r30, long r31, long r33, int r35, int r36, String r37, String r38, int r39, int r40, String r41, boolean r42, int r43, long r44, int r46, DefaultConstructorMarker r47) {
        if ((r46 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r46 & 32) == 0) goto L9;
        int r14 = 0;
    L11:
        if ((r46 & 64) == 0) goto L13;
        int r15 = 0;
    L15:
        if ((r46 & 128) == 0) goto L17;
        String r16 = "";
    L19:
        if ((r46 & 512) == 0) goto L21;
        int r18 = 0;
    L23:
        if ((r46 & 1024) == 0) goto L25;
        int r19 = 1;
    L27:
        if ((r46 & 2048) == 0) goto L29;
        String r20 = "";
    L31:
        if ((r46 & 4096) == 0) goto L33;
        boolean r21 = false;
    L35:
        if ((r46 & 8192) == 0) goto L37;
        int r22 = 0;
    L39:
        if ((r46 & 16384) == 0) goto L41;
        long r23 = 0;
    L42:
        this(r5, r28, r30, r31, r33, r14, r15, r16, r38, r18, r19, r20, r21, r22, r23);
        return;
    L41:
        r23 = r44;
        goto L42
    L37:
        r22 = r43;
        goto L39
    L33:
        r21 = r42;
        goto L35
    L29:
        r20 = r41;
        goto L31
    L25:
        r19 = r40;
        goto L27
    L21:
        r18 = r39;
        goto L23
    L17:
        r16 = r37;
        goto L19
    L13:
        r15 = r36;
        goto L15
    L9:
        r14 = r35;
        goto L11
    L5:
        r5 = r26;
        goto L7
    }

    public static /* synthetic */ cd a(cd r16, long r17, long r19, int r21, long r22, long r24, int r26, int r27, String r28, String r29, int r30, int r31, String r32, boolean r33, int r34, long r35, int r37, Object r38) {
        if ((r37 & 1) == 0) goto L5;
        long r2 = r16.f8965b;
    L7:
        if ((r37 & 2) == 0) goto L9;
        long r4 = r16.c;
    L11:
        if ((r37 & 4) == 0) goto L13;
        int r6 = r16.d;
    L15:
        if ((r37 & 8) == 0) goto L17;
        long r7 = r16.e;
    L19:
        if ((r37 & 16) == 0) goto L21;
        long r9 = r16.f;
    L23:
        if ((r37 & 32) == 0) goto L25;
        int r11 = r16.g;
    L27:
        if ((r37 & 64) == 0) goto L29;
        int r12 = r16.h;
    L31:
        if ((r37 & 128) == 0) goto L33;
        String r13 = r16.i;
    L35:
        if ((r37 & 256) == 0) goto L37;
        String r14 = r16.j;
    L39:
        if ((r37 & 512) == 0) goto L41;
        int r15 = r16.k;
    L42:
        int r36 = r15;
        if ((r37 & 1024) == 0) goto L45;
        int r18 = r16.l;
    L46:
        int r39 = r18;
        if ((r37 & 2048) == 0) goto L49;
        String r110 = r16.m;
    L50:
        String r310 = r110;
        if ((r37 & 4096) == 0) goto L53;
        boolean r111 = r16.n;
    L54:
        boolean r311 = r111;
        if ((r37 & 8192) == 0) goto L57;
        int r112 = r16.o;
    L58:
        String r210 = r14;
        int r312 = r112;
        if ((r37 & 16384) == 0) goto L61;
        long r113 = r16.p;
    L63:
        return r16.a(r2, r4, r6, r7, r9, r11, r12, r13, r210, r36, r39, r310, r311, r312, r113);
    L61:
        r113 = r35;
        goto L63
    L57:
        r112 = r34;
        goto L58
    L53:
        r111 = r33;
        goto L54
    L49:
        r110 = r32;
        goto L50
    L45:
        r18 = r31;
        goto L46
    L41:
        r15 = r30;
        goto L42
    L37:
        r14 = r29;
        goto L39
    L33:
        r13 = r28;
        goto L35
    L29:
        r12 = r27;
        goto L31
    L25:
        r11 = r26;
        goto L27
    L21:
        r9 = r24;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final long a() {
        return this.f8965b;
    }

    public final cd a(long r23, long r25, int r27, long r28, long r30, int r32, int r33, String r34, String r35, int r36, int r37, String r38, boolean r39, int r40, long r41) {
        Intrinsics.checkNotNullParameter(r34, "columnContent");
        Intrinsics.checkNotNullParameter(r35, "buildType");
        Intrinsics.checkNotNullParameter(r38, WsConstants.KEY_EXTRA);
        return new cd(r23, r25, r27, r28, r30, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41);
    }

    public final void a(long r1) {
        this.e = r1;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.m = r2;
    }

    public final long b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.f;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, cd.class) == true) goto L8;
        return false;
    L8:
        cd r10 = (cd) ZeusTransformUtils.preCheckCast(r9, cd.class, "com.obric.memorydata.plugin");
        if (this.f8965b == r10.f8965b) goto L12;
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
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L36;
        return false;
    L36:
        if (this.k == r10.k) goto L39;
        return false;
    L39:
        if (this.l == r10.l) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.m, r10.m) == true) goto L45;
        return false;
    L45:
        if (this.n == r10.n) goto L48;
        return false;
    L48:
        if (this.o == r10.o) goto L51;
        return false;
    L51:
        if (this.p == r10.p) goto L53;
        return false;
    L53:
        return true;
    }

    public final int f() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }

    public final String h() {
        return this.i;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((Long.hashCode(this.f8965b) * 31) + Long.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + Integer.hashCode(this.k)) * 31) + Integer.hashCode(this.l)) * 31) + this.m.hashCode()) * 31) + Boolean.hashCode(this.n)) * 31) + Integer.hashCode(this.o)) * 31) + Long.hashCode(this.p);
    }

    public final String i() {
        return this.j;
    }

    public final int j() {
        return this.k;
    }

    public final int k() {
        return this.l;
    }

    public final String l() {
        return this.m;
    }

    public final boolean m() {
        return this.n;
    }

    public final int n() {
        return this.o;
    }

    public final long o() {
        return this.p;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("IndexPendingEntity(id=").append(this.f8965b).append(", rawDbId=").append(this.c).append(", entityType=").append(this.d).append(", timestamp=").append(this.e).append(", createTimeStamp=").append(this.f).append(", state=").append(this.g).append(", progress=").append(this.h).append(", columnContent=").append(this.i).append(", buildType=").append(this.j).append(", indexProgress=").append(this.k).append(", total=").append(this.l).append(", extra=");
        r0.append(this.m).append(", isScheduledSlowTask=").append(this.n).append(", retryCount=").append(this.o).append(", nextRetryAt=").append(this.p).append(')');
        return r0.toString();
    }
}
