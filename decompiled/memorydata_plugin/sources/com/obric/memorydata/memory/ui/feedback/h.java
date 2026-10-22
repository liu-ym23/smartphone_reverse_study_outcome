package com.obric.memorydata.memory.ui.feedback;

import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReportData;", "", "module", "Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "logId", "", "entityJson", "Lorg/json/JSONObject;", "<init>", "(Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;Ljava/lang/String;Lorg/json/JSONObject;)V", "getModule", "()Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "getLogId", "()Ljava/lang/String;", "getEntityJson", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MemoryReviewModule f10950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10951b;
    private final JSONObject c;

    public h(MemoryReviewModule r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "module");
        Intrinsics.checkNotNullParameter(r3, "logId");
        Intrinsics.checkNotNullParameter(r4, "entityJson");
        this.f10950a = r2;
        this.f10951b = r3;
        this.c = r4;
    }

    public final MemoryReviewModule a() {
        return this.f10950a;
    }

    public final String b() {
        return this.f10951b;
    }

    public final JSONObject c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
        if (this.f10950a == r6.f10950a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10951b, r6.f10951b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f10950a.hashCode() * 31) + this.f10951b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "MemoryFeedbackOdpReportData(module=" + this.f10950a + ", logId=" + this.f10951b + ", entityJson=" + this.c + ')';
    }
}
