package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0001FB§\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u000bHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J½\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0003HÆ\u0001J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u000bHÖ\u0001J\t\u0010E\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0016\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001a¨\u0006G"}, d2 = {"Lcom/obric/memorydata/database/entity/InAppTraceUploadEntity;", "", OaidModel.KEY_ID, "", "fileId", "", "traceSessionId", "localPath", "startTimestamp", "endTimestamp", "eventCount", "", "zipSize", "sha256", "state", "tosUri", "retryCount", "nextRetryAt", "lastError", "createdAt", "updatedAt", "leaseUntil", "observationId", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;JJJJ)V", "getId", "()J", "getFileId", "()Ljava/lang/String;", "getTraceSessionId", "getLocalPath", "getStartTimestamp", "getEndTimestamp", "getEventCount", "()I", "getZipSize", "getSha256", "getState", "getTosUri", "getRetryCount", "getNextRetryAt", "getLastError", "getCreatedAt", "getUpdatedAt", "getLeaseUntil", "getObservationId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class cc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8962a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f8963b;
    private final String c;
    private final String d;
    private final String e;
    private final long f;
    private final long g;
    private final int h;
    private final long i;
    private final String j;
    private final String k;
    private final String l;
    private final int m;
    private final long n;
    private final String o;
    private final long p;
    private final long q;
    private final long r;
    private final long s;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/database/entity/InAppTraceUploadEntity$Companion;", "", "<init>", "()V", "STATE_READY", "", "STATE_WAIT_OBSERVATION", "STATE_TOS_UPLOADING", "STATE_TOS_UPLOADED", "STATE_REPORTING", "STATE_DELETE_PENDING", "STATE_COMPLETED", "STATE_FILE_DELETED", "STATE_DEBUG_TOS_READY", "STATE_DEBUG_REPORT_READY", "STATE_DEBUG_COMPLETED", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8962a = new a(null);
    }

    public cc(long r11, String r13, String r14, String r15, long r16, long r18, int r20, long r21, String r23, String r24, String r25, int r26, long r27, String r29, long r30, long r32, long r34, long r36) {
        Intrinsics.checkNotNullParameter(r13, "fileId");
        Intrinsics.checkNotNullParameter(r14, "traceSessionId");
        Intrinsics.checkNotNullParameter(r15, "localPath");
        Intrinsics.checkNotNullParameter(r23, "sha256");
        Intrinsics.checkNotNullParameter(r24, "state");
        Intrinsics.checkNotNullParameter(r25, "tosUri");
        Intrinsics.checkNotNullParameter(r29, "lastError");
        this.f8963b = r11;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r18;
        this.h = r20;
        this.i = r21;
        this.j = r23;
        this.k = r24;
        this.l = r25;
        this.m = r26;
        this.n = r27;
        this.o = r29;
        this.p = r30;
        this.q = r32;
        this.r = r34;
        this.s = r36;
    }

    public /* synthetic */ cc(long r33, String r35, String r36, String r37, long r38, long r40, int r42, long r43, String r45, String r46, String r47, int r48, long r49, String r51, long r52, long r54, long r56, long r58, int r60, DefaultConstructorMarker r61) {
        if ((r60 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r60 & 512) == 0) goto L9;
        String r18 = "READY";
    L11:
        if ((r60 & 1024) == 0) goto L13;
        String r19 = "";
    L15:
        if ((r60 & 2048) == 0) goto L17;
        int r20 = 0;
    L19:
        if ((r60 & 4096) == 0) goto L21;
        long r21 = 0;
    L23:
        if ((r60 & 8192) == 0) goto L25;
        String r23 = "";
    L27:
        if ((65536 & r60) == 0) goto L29;
        long r28 = 0;
    L31:
        if ((r60 & 131072) == 0) goto L33;
        long r30 = 0;
    L34:
        this(r5, r35, r36, r37, r38, r40, r42, r43, r45, r18, r19, r20, r21, r23, r52, r54, r28, r30);
        return;
    L33:
        r30 = r58;
        goto L34
    L29:
        r28 = r56;
        goto L31
    L25:
        r23 = r51;
        goto L27
    L21:
        r21 = r49;
        goto L23
    L17:
        r20 = r48;
        goto L19
    L13:
        r19 = r47;
        goto L15
    L9:
        r18 = r46;
        goto L11
    L5:
        r5 = r33;
        goto L7
    }

    public static /* synthetic */ cc a(cc r17, long r18, String r20, String r21, String r22, long r23, long r25, int r27, long r28, String r30, String r31, String r32, int r33, long r34, String r36, long r37, long r39, long r41, long r43, int r45, Object r46) {
        if ((r45 & 1) == 0) goto L5;
        long r2 = r17.f8963b;
    L7:
        if ((r45 & 2) == 0) goto L9;
        String r4 = r17.c;
    L11:
        if ((r45 & 4) == 0) goto L13;
        String r5 = r17.d;
    L15:
        if ((r45 & 8) == 0) goto L17;
        String r6 = r17.e;
    L19:
        if ((r45 & 16) == 0) goto L21;
        long r7 = r17.f;
    L23:
        if ((r45 & 32) == 0) goto L25;
        long r9 = r17.g;
    L27:
        if ((r45 & 64) == 0) goto L29;
        int r11 = r17.h;
    L31:
        if ((r45 & 128) == 0) goto L33;
        long r12 = r17.i;
    L35:
        if ((r45 & 256) == 0) goto L37;
        String r14 = r17.j;
    L39:
        if ((r45 & 512) == 0) goto L41;
        String r15 = r17.k;
    L42:
        String r35 = r15;
        if ((r45 & 1024) == 0) goto L45;
        String r16 = r17.l;
    L46:
        String r38 = r16;
        if ((r45 & 2048) == 0) goto L49;
        int r19 = r17.m;
    L50:
        int r310 = r19;
        String r311 = r14;
        if ((r45 & 4096) == 0) goto L53;
        long r110 = r17.n;
    L54:
        long r312 = r110;
        if ((r45 & 8192) == 0) goto L57;
        String r111 = r17.o;
    L58:
        String r313 = r111;
        if ((r45 & 16384) == 0) goto L61;
        long r112 = r17.p;
    L62:
        long r314 = r112;
        if ((r45 & 32768) == 0) goto L65;
        long r113 = r17.q;
    L66:
        long r315 = r113;
        if ((r45 & 65536) == 0) goto L69;
        long r114 = r17.r;
    L70:
        long r42 = r114;
        if ((r45 & 131072) == 0) goto L73;
        long r115 = r17.s;
    L75:
        return r17.a(r2, r4, r5, r6, r7, r9, r11, r12, r311, r35, r38, r310, r312, r313, r314, r315, r42, r115);
    L73:
        r115 = r43;
        goto L75
    L69:
        r114 = r41;
        goto L70
    L65:
        r113 = r39;
        goto L66
    L61:
        r112 = r37;
        goto L62
    L57:
        r111 = r36;
        goto L58
    L53:
        r110 = r34;
        goto L54
    L49:
        r19 = r33;
        goto L50
    L45:
        r16 = r32;
        goto L46
    L41:
        r15 = r31;
        goto L42
    L37:
        r14 = r30;
        goto L39
    L33:
        r12 = r28;
        goto L35
    L29:
        r11 = r27;
        goto L31
    L25:
        r9 = r25;
        goto L27
    L21:
        r7 = r23;
        goto L23
    L17:
        r6 = r22;
        goto L19
    L13:
        r5 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final long a() {
        return this.f8963b;
    }

    public final cc a(long r30, String r32, String r33, String r34, long r35, long r37, int r39, long r40, String r42, String r43, String r44, int r45, long r46, String r48, long r49, long r51, long r53, long r55) {
        Intrinsics.checkNotNullParameter(r32, "fileId");
        Intrinsics.checkNotNullParameter(r33, "traceSessionId");
        Intrinsics.checkNotNullParameter(r34, "localPath");
        Intrinsics.checkNotNullParameter(r42, "sha256");
        Intrinsics.checkNotNullParameter(r43, "state");
        Intrinsics.checkNotNullParameter(r44, "tosUri");
        Intrinsics.checkNotNullParameter(r48, "lastError");
        return new cc(r30, r32, r33, r34, r35, r37, r39, r40, r42, r43, r44, r45, r46, r48, r49, r51, r53, r55);
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final long e() {
        return this.f;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, cc.class) == true) goto L8;
        return false;
    L8:
        cc r10 = (cc) ZeusTransformUtils.preCheckCast(r9, cc.class, "com.obric.memorydata.plugin");
        if (this.f8963b == r10.f8963b) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L21;
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
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.k, r10.k) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L42;
        return false;
    L42:
        if (this.m == r10.m) goto L45;
        return false;
    L45:
        if (this.n == r10.n) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.o, r10.o) == true) goto L51;
        return false;
    L51:
        if (this.p == r10.p) goto L54;
        return false;
    L54:
        if (this.q == r10.q) goto L57;
        return false;
    L57:
        if (this.r == r10.r) goto L60;
        return false;
    L60:
        if (this.s == r10.s) goto L62;
        return false;
    L62:
        return true;
    }

    public final long f() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }

    public final long h() {
        return this.i;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((Long.hashCode(this.f8963b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + Integer.hashCode(this.m)) * 31) + Long.hashCode(this.n)) * 31) + this.o.hashCode()) * 31) + Long.hashCode(this.p)) * 31) + Long.hashCode(this.q)) * 31) + Long.hashCode(this.r)) * 31) + Long.hashCode(this.s);
    }

    public final String i() {
        return this.j;
    }

    public final String j() {
        return this.k;
    }

    public final String k() {
        return this.l;
    }

    public final int l() {
        return this.m;
    }

    public final long m() {
        return this.n;
    }

    public final String n() {
        return this.o;
    }

    public final long o() {
        return this.p;
    }

    public final long p() {
        return this.q;
    }

    public final long q() {
        return this.r;
    }

    public final long r() {
        return this.s;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("InAppTraceUploadEntity(id=").append(this.f8963b).append(", fileId=").append(this.c).append(", traceSessionId=").append(this.d).append(", localPath=").append(this.e).append(", startTimestamp=").append(this.f).append(", endTimestamp=").append(this.g).append(", eventCount=").append(this.h).append(", zipSize=").append(this.i).append(", sha256=").append(this.j).append(", state=").append(this.k).append(", tosUri=").append(this.l).append(", retryCount=");
        r0.append(this.m).append(", nextRetryAt=").append(this.n).append(", lastError=").append(this.o).append(", createdAt=").append(this.p).append(", updatedAt=").append(this.q).append(", leaseUntil=").append(this.r).append(", observationId=").append(this.s).append(')');
        return r0.toString();
    }
}
