package com.obric.memorydata.memory.review.provider;

import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportRequest;", "", "uniqId", "", "logId", WsConstants.KEY_EXTRA, "Lorg/json/JSONObject;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "getUniqId", "()Ljava/lang/String;", "getLogId", "getExtra", "()Lorg/json/JSONObject;", "toJson", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10424b;
    private final JSONObject c;

    public ar(String r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "uniqId");
        Intrinsics.checkNotNullParameter(r3, "logId");
        Intrinsics.checkNotNullParameter(r4, WsConstants.KEY_EXTRA);
        this.f10423a = r2;
        this.f10424b = r3;
        this.c = r4;
    }

    public final JSONObject a() {
        return this.c;
    }

    public final JSONObject b() {
        JSONObject r3 = new JSONObject().put("uniq_id", this.f10423a).put("log_id", this.f10424b).put(WsConstants.KEY_EXTRA, this.c.toString());
        Intrinsics.checkNotNullExpressionValue(r3, "put(...)");
        return r3;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ar.class) == true) goto L8;
        return false;
    L8:
        ar r6 = (ar) ZeusTransformUtils.preCheckCast(r5, ar.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10423a, r6.f10423a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10424b, r6.f10424b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f10423a.hashCode() * 31) + this.f10424b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "MemoryTraceReportRequest(uniqId=" + this.f10423a + ", logId=" + this.f10424b + ", extra=" + this.c + ')';
    }
}
