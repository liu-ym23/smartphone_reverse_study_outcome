package com.obric.memorydata.memory.review.provider;

import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/PreparedTraceRequest;", "", Ext.KEY_REQUEST, "Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportRequest;", "originalBodyBytes", "", "finalBodyBytes", "droppedViewTreeCount", "fits", "", "<init>", "(Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportRequest;IIIZ)V", "getRequest", "()Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportRequest;", "getOriginalBodyBytes", "()I", "getFinalBodyBytes", "getDroppedViewTreeCount", "getFits", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ar f10429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10430b;
    private final int c;
    private final int d;
    private final boolean e;

    public ax(ar r2, int r3, int r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        this.f10429a = r2;
        this.f10430b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public final ar a() {
        return this.f10429a;
    }

    public final int b() {
        return this.f10430b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ax.class) == true) goto L8;
        return false;
    L8:
        ax r6 = (ax) ZeusTransformUtils.preCheckCast(r5, ax.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10429a, r6.f10429a) == true) goto L12;
        return false;
    L12:
        if (this.f10430b == r6.f10430b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f10429a.hashCode() * 31) + Integer.hashCode(this.f10430b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
    }

    public String toString() {
        return "PreparedTraceRequest(request=" + this.f10429a + ", originalBodyBytes=" + this.f10430b + ", finalBodyBytes=" + this.c + ", droppedViewTreeCount=" + this.d + ", fits=" + this.e + ')';
    }
}
