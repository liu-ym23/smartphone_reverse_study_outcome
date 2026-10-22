package com.obric.memorydata.memory.ui.detail;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/PreviewImageLayout;", "", "width", "", "height", "isVertical", "", "<init>", "(IIZ)V", "getWidth", "()I", "getHeight", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10844b;
    private final boolean c;

    public ac(int r1, int r2, boolean r3) {
        this.f10843a = r1;
        this.f10844b = r2;
        this.c = r3;
    }

    public final int a() {
        return this.f10843a;
    }

    public final int b() {
        return this.f10844b;
    }

    public final boolean c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ac.class) == true) goto L8;
        return false;
    L8:
        ac r6 = (ac) ZeusTransformUtils.preCheckCast(r5, ac.class, "com.obric.memorydata.plugin");
        if (this.f10843a == r6.f10843a) goto L12;
        return false;
    L12:
        if (this.f10844b == r6.f10844b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f10843a) * 31) + Integer.hashCode(this.f10844b)) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "PreviewImageLayout(width=" + this.f10843a + ", height=" + this.f10844b + ", isVertical=" + this.c + ')';
    }
}
