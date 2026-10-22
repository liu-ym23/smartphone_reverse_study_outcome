package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bG\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 U2\u00020\u0001:\u0001UBÁ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003J\t\u0010>\u001a\u00020\tHÆ\u0003J\t\u0010?\u001a\u00020\tHÆ\u0003J\t\u0010@\u001a\u00020\tHÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\tHÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\t\u0010D\u001a\u00020\tHÆ\u0003J\t\u0010E\u001a\u00020\tHÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\tHÆ\u0003J\t\u0010I\u001a\u00020\tHÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\tHÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0006HÆ\u0003Jï\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020\u0003HÖ\u0001J\t\u0010T\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0011\u0010\u0013\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R\u0011\u0010\u0015\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0011\u0010\u0016\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001fR\u0016\u0010\u001b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\"¨\u0006V"}, d2 = {"Lcom/obric/memorydata/database/entity/UserActionEntity;", "", "dataId", "", "dataVersion", "timestamp", "", "imageId", "appName", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "activityName", "viewTreeJsonString", InfoRequestQPSOptTraceLogger.REASON, "eventType", "eventName", "className", "viewTreeTextInfo", WsConstants.KEY_EXTRA, "uniqueId", "operateNodeInfo", "description", "imageUrl", "mergeStatus", "ocrContent", "urlType", "memoryState", OaidModel.KEY_ID, "<init>", "(IIJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIJ)V", "getDataId", "()I", "getDataVersion", "getTimestamp", "()J", "getImageId", "getAppName", "()Ljava/lang/String;", "getPackageName", "getActivityName", "getViewTreeJsonString", "getReason", "getEventType", "getEventName", "getClassName", "getViewTreeTextInfo", "getExtra", "getUniqueId", "getOperateNodeInfo", "getDescription", "getImageUrl", "getMergeStatus", "getOcrContent", "getUrlType", "getMemoryState", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9255a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9256b;
    private final int c;
    private final long d;
    private final long e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final int k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;
    private final String s;
    private final int t;
    private final String u;
    private final int v;
    private final int w;
    private final long x;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/database/entity/UserActionEntity$Companion;", "", "<init>", "()V", "NEED_MEMORY", "", "MEMORIZED", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9255a = new a(null);
    }

    public jb(int r17, int r18, long r19, long r21, String r23, String r24, String r25, String r26, String r27, int r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, int r37, String r38, int r39, int r40, long r41) {
        Intrinsics.checkNotNullParameter(r23, "appName");
        Intrinsics.checkNotNullParameter(r24, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r25, "activityName");
        Intrinsics.checkNotNullParameter(r26, "viewTreeJsonString");
        Intrinsics.checkNotNullParameter(r27, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r29, "eventName");
        Intrinsics.checkNotNullParameter(r30, "className");
        Intrinsics.checkNotNullParameter(r31, "viewTreeTextInfo");
        Intrinsics.checkNotNullParameter(r32, WsConstants.KEY_EXTRA);
        Intrinsics.checkNotNullParameter(r33, "uniqueId");
        Intrinsics.checkNotNullParameter(r34, "operateNodeInfo");
        Intrinsics.checkNotNullParameter(r35, "description");
        Intrinsics.checkNotNullParameter(r36, "imageUrl");
        Intrinsics.checkNotNullParameter(r38, "ocrContent");
        this.f9256b = r17;
        this.c = r18;
        this.d = r19;
        this.e = r21;
        this.f = r23;
        this.g = r24;
        this.h = r25;
        this.i = r26;
        this.j = r27;
        this.k = r28;
        this.l = r29;
        this.m = r30;
        this.n = r31;
        this.o = r32;
        this.p = r33;
        this.q = r34;
        this.r = r35;
        this.s = r36;
        this.t = r37;
        this.u = r38;
        this.v = r39;
        this.w = r40;
        this.x = r41;
    }

    public final int a() {
        return this.f9256b;
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

    public final String e() {
        return this.f;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, jb.class) == true) goto L8;
        return false;
    L8:
        jb r10 = (jb) ZeusTransformUtils.preCheckCast(r9, jb.class, "com.obric.memorydata.plugin");
        if (this.f9256b == r10.f9256b) goto L12;
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
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L30;
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
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.m, r10.m) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.n, r10.n) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.o, r10.o) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.p, r10.p) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.q, r10.q) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.r, r10.r) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.s, r10.s) == true) goto L63;
        return false;
    L63:
        if (this.t == r10.t) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.u, r10.u) == true) goto L69;
        return false;
    L69:
        if (this.v == r10.v) goto L72;
        return false;
    L72:
        if (this.w == r10.w) goto L75;
        return false;
    L75:
        if (this.x == r10.x) goto L77;
        return false;
    L77:
        return true;
    }

    public final String f() {
        return this.g;
    }

    public final String g() {
        return this.h;
    }

    public final String h() {
        return this.i;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((Integer.hashCode(this.f9256b) * 31) + Integer.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + Integer.hashCode(this.k)) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + this.p.hashCode()) * 31) + this.q.hashCode()) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31) + Integer.hashCode(this.t)) * 31) + this.u.hashCode()) * 31) + Integer.hashCode(this.v)) * 31) + Integer.hashCode(this.w)) * 31) + Long.hashCode(this.x);
    }

    public final String i() {
        return this.j;
    }

    public final int j() {
        return this.k;
    }

    public final String k() {
        return this.l;
    }

    public final String l() {
        return this.m;
    }

    public final String m() {
        return this.n;
    }

    public final String n() {
        return this.o;
    }

    public final String o() {
        return this.p;
    }

    public final String p() {
        return this.q;
    }

    public final String q() {
        return this.r;
    }

    public final String r() {
        return this.s;
    }

    public final int s() {
        return this.t;
    }

    public final String t() {
        return this.u;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("UserActionEntity(dataId=").append(this.f9256b).append(", dataVersion=").append(this.c).append(", timestamp=").append(this.d).append(", imageId=").append(this.e).append(", appName=").append(this.f).append(", packageName=").append(this.g).append(", activityName=").append(this.h).append(", viewTreeJsonString=").append(this.i).append(", reason=").append(this.j).append(", eventType=").append(this.k).append(", eventName=").append(this.l).append(", className=");
        r0.append(this.m).append(", viewTreeTextInfo=").append(this.n).append(", extra=").append(this.o).append(", uniqueId=").append(this.p).append(", operateNodeInfo=").append(this.q).append(", description=").append(this.r).append(", imageUrl=").append(this.s).append(", mergeStatus=").append(this.t).append(", ocrContent=").append(this.u).append(", urlType=").append(this.v).append(", memoryState=").append(this.w).append(", id=").append(this.x);
        r0.append(')');
        return r0.toString();
    }

    public final int u() {
        return this.v;
    }

    public final int v() {
        return this.w;
    }

    public final long w() {
        return this.x;
    }
}
