package com.obric.memorydata.memory.ui.feedback;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/FeedbackInputHeightResult;", "", "targetHeightPx", "", "requiresScrollableBody", "", "<init>", "(IZ)V", "getTargetHeightPx", "()I", "getRequiresScrollableBody", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10932b;

    public c(int r1, boolean r2) {
        this.f10931a = r1;
        this.f10932b = r2;
    }

    public final int a() {
        return this.f10931a;
    }

    public final boolean b() {
        return this.f10932b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (this.f10931a == r6.f10931a) goto L12;
        return false;
    L12:
        if (this.f10932b == r6.f10932b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f10931a) * 31) + Boolean.hashCode(this.f10932b);
    }

    public String toString() {
        return "FeedbackInputHeightResult(targetHeightPx=" + this.f10931a + ", requiresScrollableBody=" + this.f10932b + ')';
    }
}
