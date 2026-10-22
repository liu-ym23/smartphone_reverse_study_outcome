package com.obric.memorydata.memory.ui.detail;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ImageViewerPresentation;", "", "backgroundColor", "", "showProgress", "", "showViewer", "allowTiledViewerDraw", "contentTransition", "Lcom/obric/memorydata/memory/ui/detail/ImageViewerContentTransition;", "<init>", "(IZZZLcom/obric/memorydata/memory/ui/detail/ImageViewerContentTransition;)V", "getBackgroundColor", "()I", "getShowProgress", "()Z", "getShowViewer", "getAllowTiledViewerDraw", "getContentTransition", "()Lcom/obric/memorydata/memory/ui/detail/ImageViewerContentTransition;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10865b;
    private final boolean c;
    private final boolean d;
    private final ImageViewerContentTransition e;

    public m(int r2, boolean r3, boolean r4, boolean r5, ImageViewerContentTransition r6) {
        Intrinsics.checkNotNullParameter(r6, "contentTransition");
        this.f10864a = r2;
        this.f10865b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ m(int r7, boolean r8, boolean r9, boolean r10, ImageViewerContentTransition r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = ImageViewerContentTransition.NONE;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    public final int a() {
        return this.f10864a;
    }

    public final boolean b() {
        return this.f10865b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final ImageViewerContentTransition e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.memorydata.plugin");
        if (this.f10864a == r6.f10864a) goto L12;
        return false;
    L12:
        if (this.f10865b == r6.f10865b) goto L15;
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
        return (((((((Integer.hashCode(this.f10864a) * 31) + Boolean.hashCode(this.f10865b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "ImageViewerPresentation(backgroundColor=" + this.f10864a + ", showProgress=" + this.f10865b + ", showViewer=" + this.c + ", allowTiledViewerDraw=" + this.d + ", contentTransition=" + this.e + ')';
    }
}
