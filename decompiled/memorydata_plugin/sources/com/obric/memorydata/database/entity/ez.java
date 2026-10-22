package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b0\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\t\u00107\u001a\u00020\u000fHÆ\u0003J\t\u00108\u001a\u00020\u0011HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\t\u0010=\u001a\u00020\fHÆ\u0003J¹\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\fHÆ\u0001J\u0013\u0010?\u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020BHÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010%R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0016\u0010\u0015\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0016\u0010\u0016\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010#¨\u0006D"}, d2 = {"Lcom/obric/memorydata/database/entity/ProactiveRecommendationEntity;", "", "recommendId", "", "taskId", "subscriptionId", "recommendText", "emoji", "actionExecuteInstruction", "actionContext", "sourcePackages", "created", "", "updated", "isDelete", "", "score", "", InfoRequestQPSOptTraceLogger.REASON, "status", "type", "timestamp", OaidModel.KEY_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJZDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getRecommendId", "()Ljava/lang/String;", "getTaskId", "getSubscriptionId", "getRecommendText", "getEmoji", "getActionExecuteInstruction", "getActionContext", "getSourcePackages", "getCreated", "()J", "getUpdated", "()Z", "getScore", "()D", "getReason", "getStatus", "getType", "getTimestamp", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ez {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9107b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final long i;
    private final long j;
    private final boolean k;
    private final double l;
    private final String m;
    private final String n;
    private final String o;
    private final long p;
    private final long q;

    public ez(String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, long r19, long r21, boolean r23, double r24, String r26, String r27, String r28, long r29, long r31) {
        Intrinsics.checkNotNullParameter(r11, "recommendId");
        Intrinsics.checkNotNullParameter(r12, "taskId");
        Intrinsics.checkNotNullParameter(r13, "subscriptionId");
        Intrinsics.checkNotNullParameter(r14, "recommendText");
        Intrinsics.checkNotNullParameter(r15, "emoji");
        Intrinsics.checkNotNullParameter(r26, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r27, "status");
        Intrinsics.checkNotNullParameter(r28, "type");
        this.f9106a = r11;
        this.f9107b = r12;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r21;
        this.k = r23;
        this.l = r24;
        this.m = r26;
        this.n = r27;
        this.o = r28;
        this.p = r29;
        this.q = r31;
    }

    public /* synthetic */ ez(String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, long r34, long r36, boolean r38, double r39, String r41, String r42, String r43, long r44, long r46, int r48, DefaultConstructorMarker r49) {
        if ((r48 & 128) == 0) goto L5;
        String r10 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L7:
        if ((r48 & 1024) == 0) goto L9;
        boolean r15 = false;
    L11:
        if ((r48 & 16384) == 0) goto L13;
        String r20 = "immediate";
    L15:
        if ((32768 & r48) == 0) goto L17;
        long r21 = System.currentTimeMillis();
    L19:
        if ((r48 & 65536) == 0) goto L21;
        long r23 = 0;
    L22:
        this(r26, r27, r28, r29, r30, r31, r32, r10, r34, r36, r15, r39, r41, r42, r20, r21, r23);
        return;
    L21:
        r23 = r46;
        goto L22
    L17:
        r21 = r44;
        goto L19
    L13:
        r20 = r43;
        goto L15
    L9:
        r15 = r38;
        goto L11
    L5:
        r10 = r33;
        goto L7
    }

    public final String a() {
        return this.f9106a;
    }

    public final String b() {
        return this.f9107b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ez.class) == true) goto L8;
        return false;
    L8:
        ez r10 = (ez) ZeusTransformUtils.preCheckCast(r9, ez.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9106a, r10.f9106a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9107b, r10.f9107b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L42;
        return false;
    L42:
        if (Double.compare(this.l, r10.l) == 0) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r10.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r10.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r10.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r10.p) goto L57;
        return false;
    L57:
        if (this.q == r10.q) goto L59;
        return false;
    L59:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final String getType() {
        return this.o;
    }

    public final String h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((((((((this.f9106a.hashCode() * 31) + this.f9107b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.h;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((((((((((((((((((r7 + r2) * 31) + Long.hashCode(this.i)) * 31) + Long.hashCode(this.j)) * 31) + Boolean.hashCode(this.k)) * 31) + Double.hashCode(this.l)) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + Long.hashCode(this.p)) * 31) + Long.hashCode(this.q);
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final long i() {
        return this.i;
    }

    public final long j() {
        return this.j;
    }

    public final boolean k() {
        return this.k;
    }

    public final double l() {
        return this.l;
    }

    public final String m() {
        return this.m;
    }

    public final String n() {
        return this.n;
    }

    public final long o() {
        return this.p;
    }

    public final long p() {
        return this.q;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ProactiveRecommendationEntity(recommendId=").append(this.f9106a).append(", taskId=").append(this.f9107b).append(", subscriptionId=").append(this.c).append(", recommendText=").append(this.d).append(", emoji=").append(this.e).append(", actionExecuteInstruction=").append(this.f).append(", actionContext=").append(this.g).append(", sourcePackages=").append(this.h).append(", created=").append(this.i).append(", updated=").append(this.j).append(", isDelete=").append(this.k).append(", score=");
        r0.append(this.l).append(", reason=").append(this.m).append(", status=").append(this.n).append(", type=").append(this.o).append(", timestamp=").append(this.p).append(", id=").append(this.q).append(')');
        return r0.toString();
    }
}
