package com.bytedance.android.live.saas.middleware.monitor;

import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/monitor/MonitorConfig;", "", "monitorReport", "Lcom/bytedance/android/live/saas/middleware/monitor/IMonitorReport;", "standalone", "", "isToBVersion", Constants.OperatorKey.KEY_APP_ID, "", "inhouseSdkMonitor", "(Lcom/bytedance/android/live/saas/middleware/monitor/IMonitorReport;ZZLjava/lang/String;Z)V", "getAppId", "()Ljava/lang/String;", "getInhouseSdkMonitor", "()Z", "getMonitorReport", "()Lcom/bytedance/android/live/saas/middleware/monitor/IMonitorReport;", "setMonitorReport", "(Lcom/bytedance/android/live/saas/middleware/monitor/IMonitorReport;)V", "getStandalone", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class MonitorConfig {
    private final String appId;
    private final boolean inhouseSdkMonitor;
    private final boolean isToBVersion;
    private IMonitorReport monitorReport;
    private final boolean standalone;

    public MonitorConfig(IMonitorReport r9) {
        this(r9, false, false, null, false, 30, null);
    }

    public MonitorConfig(IMonitorReport r9, boolean r10) {
        this(r9, r10, false, null, false, 28, null);
    }

    public MonitorConfig(IMonitorReport r9, boolean r10, boolean r12) {
        this(r9, r10, r12, null, false, 24, null);
    }

    public MonitorConfig(IMonitorReport r9, boolean r10, boolean r12, String r13) {
        this(r9, r10, r12, r13, false, 16, null);
    }

    public static /* synthetic */ MonitorConfig copy$default(MonitorConfig r3, IMonitorReport r4, boolean r5, boolean r6, String r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.monitorReport;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.standalone;
    L8:
        boolean r12 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.isToBVersion;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.appId;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.inhouseSdkMonitor;
    L17:
        IMonitorReport r13 = r4;
        return r3.copy(r13, r12, r0, r1, r8);
    }

    public final IMonitorReport component1() {
        return this.monitorReport;
    }

    public final boolean component2() {
        return this.standalone;
    }

    public final boolean component3() {
        return this.isToBVersion;
    }

    public final String component4() {
        return this.appId;
    }

    public final boolean component5() {
        return this.inhouseSdkMonitor;
    }

    public final MonitorConfig copy(IMonitorReport r8, boolean r9, boolean r10, String r12, boolean r13) {
        return new MonitorConfig(r8, r9, r10, r12, r13);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof MonitorConfig) == false) goto L16;
        MonitorConfig r4 = (MonitorConfig) r3;
        if (Intrinsics.areEqual(this.monitorReport, r4.monitorReport) == true) goto L8;
        return false;
    L8:
        if (this.standalone == r4.standalone) goto L10;
        return false;
    L10:
        if (this.isToBVersion == r4.isToBVersion) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appId, r4.appId) == true) goto L14;
        return false;
    L14:
        if (this.inhouseSdkMonitor == r4.inhouseSdkMonitor) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        IMonitorReport r0 = this.monitorReport;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.standalone;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.isToBVersion;
        ?? r9 = r8;
        if (r8 == false) goto L12;
        r9 = 1;
    L12:
        int r10 = (r7 + r9) * 31;
        String r12 = this.appId;
        if (r12 == null) goto L15;
        r1 = r12.hashCode();
    L15:
        int r13 = (r10 + r1) * 31;
        boolean r14 = this.inhouseSdkMonitor;
        if (r14 == true) goto L20;
        r5 = r14;
    L20:
        return r13 + r5;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "MonitorConfig(monitorReport=" + this.monitorReport + ", standalone=" + this.standalone + ", isToBVersion=" + this.isToBVersion + ", appId=" + this.appId + ", inhouseSdkMonitor=" + this.inhouseSdkMonitor + ")";
    }

    public final String getAppId() {
        return this.appId;
    }

    public final boolean getInhouseSdkMonitor() {
        return this.inhouseSdkMonitor;
    }

    public final IMonitorReport getMonitorReport() {
        return this.monitorReport;
    }

    public final boolean getStandalone() {
        return this.standalone;
    }

    public final boolean isToBVersion() {
        return this.isToBVersion;
    }

    public final void setMonitorReport(IMonitorReport r1) {
        this.monitorReport = r1;
    }

    public MonitorConfig(IMonitorReport r1, boolean r2, boolean r3, String r4, boolean r5) {
        this.monitorReport = r1;
        this.standalone = r2;
        this.isToBVersion = r3;
        this.appId = r4;
        this.inhouseSdkMonitor = r5;
    }

    public /* synthetic */ MonitorConfig(IMonitorReport r8, boolean r9, boolean r10, String r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        boolean r3 = false;
    L7:
        if ((r14 & 4) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r14 & 8) == 0) goto L13;
        r12 = null;
    L13:
        String r5 = r12;
        if ((r14 & 16) == 0) goto L16;
        boolean r6 = false;
    L17:
        this(r8, r3, r4, r5, r6);
        return;
    L16:
        r6 = r13;
        goto L17
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }
}
