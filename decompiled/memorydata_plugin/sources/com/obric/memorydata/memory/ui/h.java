package com.obric.memorydata.memory.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/ui/ObservationMemorySourcePresentation;", "", "labelRes", "", "iconRes", "<init>", "(II)V", "getLabelRes", "()I", "getIconRes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10967b;

    public h(int r1, int r2) {
        this.f10966a = r1;
        this.f10967b = r2;
    }

    public final int a() {
        return this.f10966a;
    }

    public final int b() {
        return this.f10967b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
        if (this.f10966a == r6.f10966a) goto L12;
        return false;
    L12:
        if (this.f10967b == r6.f10967b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f10966a) * 31) + Integer.hashCode(this.f10967b);
    }

    public String toString() {
        return "ObservationMemorySourcePresentation(labelRes=" + this.f10966a + ", iconRes=" + this.f10967b + ')';
    }
}
