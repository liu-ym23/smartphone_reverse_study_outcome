package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/database/entity/AutoMemoryProTraceEntity;", "", OaidModel.KEY_ID, "", "timestamp", "trace", "", "batchScreenshot", "historyIds", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getTimestamp", "getTrace", "()Ljava/lang/String;", "getBatchScreenshot", "getHistoryIds", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryProTraceEntity {
    private final String batchScreenshot;
    private final String historyIds;
    private final long id;
    private final long timestamp;
    private final String trace;

    public AutoMemoryProTraceEntity(long r2, long r4, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "trace");
        Intrinsics.checkNotNullParameter(r7, "batchScreenshot");
        Intrinsics.checkNotNullParameter(r8, "historyIds");
        this.id = r2;
        this.timestamp = r4;
        this.trace = r6;
        this.batchScreenshot = r7;
        this.historyIds = r8;
    }

    public /* synthetic */ AutoMemoryProTraceEntity(long r11, long r13, String r15, String r16, String r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        long r3 = 0;
    L6:
        this(r3, r13, r15, r16, r17);
        return;
    L5:
        r3 = r11;
        goto L6
    }

    public static /* synthetic */ AutoMemoryProTraceEntity copy$default(AutoMemoryProTraceEntity r8, long r9, long r11, String r13, String r14, String r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        long r1 = r8.id;
    L7:
        if ((r16 & 2) == 0) goto L9;
        long r3 = r8.timestamp;
    L11:
        if ((r16 & 4) == 0) goto L13;
        String r5 = r8.trace;
    L15:
        if ((r16 & 8) == 0) goto L17;
        String r6 = r8.batchScreenshot;
    L19:
        if ((r16 & 16) == 0) goto L21;
        String r7 = r8.historyIds;
    L23:
        return r8.copy(r1, r3, r5, r6, r7);
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.trace;
    }

    public final String component4() {
        return this.batchScreenshot;
    }

    public final String component5() {
        return this.historyIds;
    }

    public final AutoMemoryProTraceEntity copy(long r9, long r11, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "trace");
        Intrinsics.checkNotNullParameter(r14, "batchScreenshot");
        Intrinsics.checkNotNullParameter(r15, "historyIds");
        return new AutoMemoryProTraceEntity(r9, r11, r13, r14, r15);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AutoMemoryProTraceEntity.class) == true) goto L8;
        return false;
    L8:
        AutoMemoryProTraceEntity r10 = (AutoMemoryProTraceEntity) ZeusTransformUtils.preCheckCast(r9, AutoMemoryProTraceEntity.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (this.timestamp == r10.timestamp) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.trace, r10.trace) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.batchScreenshot, r10.batchScreenshot) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.historyIds, r10.historyIds) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final String getBatchScreenshot() {
        return this.batchScreenshot;
    }

    public final String getHistoryIds() {
        return this.historyIds;
    }

    public final long getId() {
        return this.id;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTrace() {
        return this.trace;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.timestamp)) * 31) + this.trace.hashCode()) * 31) + this.batchScreenshot.hashCode()) * 31) + this.historyIds.hashCode();
    }

    public String toString() {
        return "AutoMemoryProTraceEntity(id=" + this.id + ", timestamp=" + this.timestamp + ", trace=" + this.trace + ", batchScreenshot=" + this.batchScreenshot + ", historyIds=" + this.historyIds + ')';
    }
}
