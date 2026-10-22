package com.larus.bootprotector.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001BQ\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/larus/bootprotector/entity/LastException;", "Lcom/larus/bootprotector/entity/BaseExceptionInfo;", "exceptionStackTrace", "", "exceptionTime", "", "type", "Lcom/larus/bootprotector/entity/BaseExceptionInfo$Type;", "appVersion", "updateVersion", "", "osVersion", "processName", "threadName", "<init>", "(Ljava/lang/String;JLcom/larus/bootprotector/entity/BaseExceptionInfo$Type;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getExceptionStackTrace", "()Ljava/lang/String;", "setExceptionStackTrace", "(Ljava/lang/String;)V", "getExceptionTime", "()J", "setExceptionTime", "(J)V", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LastException extends BaseExceptionInfo {
    private String exceptionStackTrace;
    private long exceptionTime;

    public String toString() {
        StringBuilder r0 = new StringBuilder("exceptionStackTrace=");
        String r1 = this.exceptionStackTrace;
        if (r1 == null) goto L5;
        String r2 = StringsKt.take(r1, 200);
    L6:
        r0.append(r2);
        r0.append(",exceptionTime=");
        r0.append(this.exceptionTime);
        r0.append(",type=");
        r0.append(getCrashType());
        r0.append(",appVersion=");
        r0.append(getAppVersion());
        r0.append(",updateVersion=");
        r0.append(getUpdateVersion());
        r0.append(",osVersion=");
        r0.append(getOsVersion());
        r0.append(",processName=");
        r0.append(getProcessName());
        r0.append(",threadName=");
        r0.append(getThreadName());
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final String getExceptionStackTrace() {
        return this.exceptionStackTrace;
    }

    public final long getExceptionTime() {
        return this.exceptionTime;
    }

    public final void setExceptionStackTrace(String r1) {
        this.exceptionStackTrace = r1;
    }

    public final void setExceptionTime(long r1) {
        this.exceptionTime = r1;
    }

    public LastException(String r9, long r10, BaseExceptionInfo.Type r12, String r13, int r14, int r15, String r16, String r17) {
        Intrinsics.checkNotNullParameter(r12, "type");
        super(r12, r13, r14, r15, r16, r17);
        this.exceptionStackTrace = r9;
        this.exceptionTime = r10;
    }
}
