package com.obric.memorydata.memory.review.provider;

import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J#\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/InAppTraceReportRequest;", "", "items", "", "Lcom/obric/memorydata/memory/api/InAppTraceReportItem;", "requestTimestamp", "", "<init>", "(Ljava/util/List;J)V", "getItems", "()Ljava/util/List;", "getRequestTimestamp", "()J", "toJson", "Lorg/json/JSONObject;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.obric.memorydata.memory.api.b> f10474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10475b;

    public y(List<com.obric.memorydata.memory.api.b> r3, long r4) {
        List<com.obric.memorydata.memory.api.b> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "items");
        this.f10474a = r5;
        this.f10475b = r4;
    }

    public final JSONObject a() {
        JSONArray r0 = new JSONArray();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f10474a, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        com.obric.memorydata.memory.api.b r2 = (com.obric.memorydata.memory.api.b) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.memorydata.memory.api.b.class, "com.obric.memorydata.plugin");
        r0.put(new JSONObject().put("tos_uri", r2.a()).put("start_timestamp", r2.b()).put("end_timestamp", r2.c()));
        goto L4
    L6:
        JSONObject r8 = new JSONObject().put("uniq_id", "memory_trace_in_app_trace_" + this.f10475b + '_' + UUID.randomUUID()).put("log_id", "in_app_trace").put(WsConstants.KEY_EXTRA, new JSONObject().put("in_app_traces", r0).toString());
        Intrinsics.checkNotNullExpressionValue(r8, "put(...)");
        return r8;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, y.class) == true) goto L8;
        return false;
    L8:
        y r8 = (y) ZeusTransformUtils.preCheckCast(r7, y.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10474a, r8.f10474a) == true) goto L12;
        return false;
    L12:
        if (this.f10475b == r8.f10475b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f10474a.hashCode() * 31) + Long.hashCode(this.f10475b);
    }

    public String toString() {
        return "InAppTraceReportRequest(items=" + this.f10474a + ", requestTimestamp=" + this.f10475b + ')';
    }
}
