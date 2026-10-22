package com.obric.memorydata.database.entity;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0006HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00064"}, d2 = {"Lcom/obric/memorydata/database/entity/MemorySynthesisTaskCard;", "", "taskId", "", "runId", "schemaVersion", "", ChatMessage.TYPE_QUERY, InfoRequestQPSOptTraceLogger.REASON, "taskDesignJson", "memoryRefsJson", "checkpointsJson", "queryStyleJson", "reviewJson", "status", "createTime", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getTaskId", "()Ljava/lang/String;", "getRunId", "getSchemaVersion", "()I", "getQuery", "getReason", "getTaskDesignJson", "getMemoryRefsJson", "getCheckpointsJson", "getQueryStyleJson", "getReviewJson", "getStatus", "getCreateTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class dg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9021b;
    private final int c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final long l;

    public dg(String r2, String r3, int r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, long r13) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "runId");
        Intrinsics.checkNotNullParameter(r5, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r6, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r7, "taskDesignJson");
        Intrinsics.checkNotNullParameter(r8, "memoryRefsJson");
        Intrinsics.checkNotNullParameter(r9, "checkpointsJson");
        Intrinsics.checkNotNullParameter(r10, "queryStyleJson");
        Intrinsics.checkNotNullParameter(r11, "reviewJson");
        Intrinsics.checkNotNullParameter(r12, "status");
        this.f9020a = r2;
        this.f9021b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }

    public final String a() {
        return this.f9020a;
    }

    public final int b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.g;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, dg.class) == true) goto L8;
        return false;
    L8:
        dg r8 = (dg) ZeusTransformUtils.preCheckCast(r7, dg.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9020a, r8.f9020a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9021b, r8.f9021b) == true) goto L15;
        return false;
    L15:
        if (this.c == r8.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r8.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r8.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r8.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r8.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r8.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r8.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r8.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r8.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r8.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final long f() {
        return this.l;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.f9020a.hashCode() * 31) + this.f9021b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + Long.hashCode(this.l);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("MemorySynthesisTaskCard(taskId=").append(this.f9020a).append(", runId=").append(this.f9021b).append(", schemaVersion=").append(this.c).append(", query=").append(this.d).append(", reason=").append(this.e).append(", taskDesignJson=").append(this.f).append(", memoryRefsJson=").append(this.g).append(", checkpointsJson=").append(this.h).append(", queryStyleJson=").append(this.i).append(", reviewJson=").append(this.j).append(", status=").append(this.k).append(", createTime=");
        r0.append(this.l).append(')');
        return r0.toString();
    }
}
