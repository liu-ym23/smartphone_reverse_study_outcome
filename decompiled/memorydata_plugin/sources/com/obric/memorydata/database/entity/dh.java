package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006$"}, d2 = {"Lcom/obric/memorydata/database/entity/MemoryTraceReportEntity;", "", OaidModel.KEY_ID, "", "logId", "", "reportData", "lastReportTime", "isTriggeredReport", "", "reportStatus", "lastError", "<init>", "(JLjava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getLogId", "()Ljava/lang/String;", "getReportData", "getLastReportTime", "()Z", "getReportStatus", "getLastError", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class dh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9023b;
    private final String c;
    private final long d;
    private final boolean e;
    private final String f;
    private final String g;

    public dh(long r2, String r4, String r5, long r6, boolean r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r4, "logId");
        Intrinsics.checkNotNullParameter(r5, "reportData");
        Intrinsics.checkNotNullParameter(r9, "reportStatus");
        this.f9022a = r2;
        this.f9023b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r8;
        this.f = r9;
        this.g = r10;
    }

    public /* synthetic */ dh(long r14, String r16, String r17, long r18, boolean r20, String r21, String r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r23 & 8) == 0) goto L9;
        long r8 = 0;
    L11:
        if ((r23 & 16) == 0) goto L13;
        boolean r10 = false;
    L15:
        if ((r23 & 32) == 0) goto L17;
        String r11 = "pending";
    L19:
        if ((r23 & 64) == 0) goto L21;
        String r12 = null;
    L22:
        this(r4, r16, r17, r8, r10, r11, r12);
        return;
    L21:
        r12 = r22;
        goto L22
    L17:
        r11 = r21;
        goto L19
    L13:
        r10 = r20;
        goto L15
    L9:
        r8 = r18;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    public final long a() {
        return this.f9022a;
    }

    public final String b() {
        return this.f9023b;
    }

    public final String c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, dh.class) == true) goto L8;
        return false;
    L8:
        dh r10 = (dh) ZeusTransformUtils.preCheckCast(r9, dh.class, "com.obric.memorydata.plugin");
        if (this.f9022a == r10.f9022a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9023b, r10.f9023b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public int hashCode() {
        int r0 = ((((((((((Long.hashCode(this.f9022a) * 31) + this.f9023b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode()) * 31;
        String r3 = this.g;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r0 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        return "MemoryTraceReportEntity(id=" + this.f9022a + ", logId=" + this.f9023b + ", reportData=" + this.c + ", lastReportTime=" + this.d + ", isTriggeredReport=" + this.e + ", reportStatus=" + this.f + ", lastError=" + this.g + ')';
    }
}
