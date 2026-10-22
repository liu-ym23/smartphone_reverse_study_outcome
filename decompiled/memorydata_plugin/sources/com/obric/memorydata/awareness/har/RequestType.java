package com.obric.memorydata.awareness.har;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/awareness/har/RequestType;", "", "requestType", "", CommonConsts.COUNT_TYPE, "", "interval", LocationMonitorConst.TIMEOUT, "<init>", "(Ljava/lang/String;III)V", "getRequestType", "()Ljava/lang/String;", "getCount", "()I", "getInterval", "getTimeout", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RequestType {
    private final int count;
    private final int interval;
    private final String requestType;
    private final int timeout;

    public RequestType(String r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "requestType");
        this.requestType = r2;
        this.count = r3;
        this.interval = r4;
        this.timeout = r5;
    }

    public /* synthetic */ RequestType(String r2, int r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r2, r3, r4, r5);
    }

    public static /* synthetic */ RequestType copy$default(RequestType r0, String r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.requestType;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.count;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.interval;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.timeout;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.requestType;
    }

    public final int component2() {
        return this.count;
    }

    public final int component3() {
        return this.interval;
    }

    public final int component4() {
        return this.timeout;
    }

    public final RequestType copy(String r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "requestType");
        return new RequestType(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RequestType.class) == true) goto L8;
        return false;
    L8:
        RequestType r6 = (RequestType) ZeusTransformUtils.preCheckCast(r5, RequestType.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.requestType, r6.requestType) == true) goto L12;
        return false;
    L12:
        if (this.count == r6.count) goto L15;
        return false;
    L15:
        if (this.interval == r6.interval) goto L18;
        return false;
    L18:
        if (this.timeout == r6.timeout) goto L20;
        return false;
    L20:
        return true;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final String getRequestType() {
        return this.requestType;
    }

    public final int getTimeout() {
        return this.timeout;
    }

    public int hashCode() {
        return (((((this.requestType.hashCode() * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.interval)) * 31) + Integer.hashCode(this.timeout);
    }

    public String toString() {
        return "RequestType(requestType=" + this.requestType + ", count=" + this.count + ", interval=" + this.interval + ", timeout=" + this.timeout + ')';
    }
}
