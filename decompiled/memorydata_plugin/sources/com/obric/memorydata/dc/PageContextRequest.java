package com.obric.memorydata.dc;

import android.content.ComponentName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/dc/PageContextRequest;", "", "componentName", "Landroid/content/ComponentName;", "timeoutMs", "", "<init>", "(Landroid/content/ComponentName;J)V", "getComponentName", "()Landroid/content/ComponentName;", "getTimeoutMs", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "deep_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PageContextRequest {
    private final ComponentName componentName;
    private final long timeoutMs;

    public PageContextRequest(ComponentName r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "componentName");
        this.componentName = r2;
        this.timeoutMs = r3;
    }

    public /* synthetic */ PageContextRequest(ComponentName r1, long r2, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = 10000;
    L5:
        this(r1, r2);
    }

    public static /* synthetic */ PageContextRequest copy$default(PageContextRequest r0, ComponentName r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.componentName;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.timeoutMs;
    L9:
        return r0.copy(r1, r2);
    }

    public final ComponentName component1() {
        return this.componentName;
    }

    public final long component2() {
        return this.timeoutMs;
    }

    public final PageContextRequest copy(ComponentName r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "componentName");
        return new PageContextRequest(r1, r2);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, PageContextRequest.class) == true) goto L8;
        return false;
    L8:
        PageContextRequest r8 = (PageContextRequest) ZeusTransformUtils.preCheckCast(r7, PageContextRequest.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.componentName, r8.componentName) == true) goto L12;
        return false;
    L12:
        if (this.timeoutMs == r8.timeoutMs) goto L14;
        return false;
    L14:
        return true;
    }

    public final ComponentName getComponentName() {
        return this.componentName;
    }

    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    public int hashCode() {
        return (this.componentName.hashCode() * 31) + Long.hashCode(this.timeoutMs);
    }

    public String toString() {
        return "PageContextRequest(componentName=" + this.componentName + ", timeoutMs=" + this.timeoutMs + ')';
    }
}
