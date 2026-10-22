package com.obric.memorydata.middleware.impl.npth;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/middleware/impl/npth/CrashInfo;", "", "crashLog", "", "firstCrashTime", "", "crashTimes", "", "<init>", "(Ljava/lang/String;JI)V", "getCrashLog", "()Ljava/lang/String;", "getFirstCrashTime", "()J", "setFirstCrashTime", "(J)V", "getCrashTimes", "()I", "setCrashTimes", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CrashInfo {
    private final String crashLog;
    private int crashTimes;
    private long firstCrashTime;

    public CrashInfo(String r2, long r3, int r5) {
        Intrinsics.checkNotNullParameter(r2, "crashLog");
        this.crashLog = r2;
        this.firstCrashTime = r3;
        this.crashTimes = r5;
    }

    public static /* synthetic */ CrashInfo copy$default(CrashInfo r0, String r1, long r2, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.crashLog;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.firstCrashTime;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.crashTimes;
    L12:
        return r0.copy(r1, r2, r4);
    }

    public final String component1() {
        return this.crashLog;
    }

    public final long component2() {
        return this.firstCrashTime;
    }

    public final int component3() {
        return this.crashTimes;
    }

    public final CrashInfo copy(String r1, long r2, int r4) {
        Intrinsics.checkNotNullParameter(r1, "crashLog");
        return new CrashInfo(r1, r2, r4);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, CrashInfo.class) == true) goto L8;
        return false;
    L8:
        CrashInfo r10 = (CrashInfo) ZeusTransformUtils.preCheckCast(r9, CrashInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.crashLog, r10.crashLog) == true) goto L12;
        return false;
    L12:
        if (this.firstCrashTime == r10.firstCrashTime) goto L15;
        return false;
    L15:
        if (this.crashTimes == r10.crashTimes) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getCrashLog() {
        return this.crashLog;
    }

    public final int getCrashTimes() {
        return this.crashTimes;
    }

    public final long getFirstCrashTime() {
        return this.firstCrashTime;
    }

    public int hashCode() {
        return (((this.crashLog.hashCode() * 31) + Long.hashCode(this.firstCrashTime)) * 31) + Integer.hashCode(this.crashTimes);
    }

    public final void setCrashTimes(int r1) {
        this.crashTimes = r1;
    }

    public final void setFirstCrashTime(long r1) {
        this.firstCrashTime = r1;
    }

    public String toString() {
        return "CrashInfo(crashLog=" + this.crashLog + ", firstCrashTime=" + this.firstCrashTime + ", crashTimes=" + this.crashTimes + ')';
    }
}
