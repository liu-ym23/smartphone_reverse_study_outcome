package com.obric.oui.window.d;

import android.graphics.Rect;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\u0013\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0006\u0010\u001b\u001a\u00020\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/window/model/Bounds;", "", "rect", "Landroid/graphics/Rect;", "(Landroid/graphics/Rect;)V", "left", "", "top", "right", "bottom", "(IIII)V", "getBottom", "()I", "height", "getHeight", "isEmpty", "", "()Z", "isZero", "getLeft", "getRight", "getTop", "width", "getWidth", "equals", "other", "hashCode", "toRect", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14900b;
    private final int c;
    private final int d;

    public b(int r1, int r2, int r3, int r4) {
        this.f14899a = r1;
        this.f14900b = r2;
        this.c = r3;
        this.d = r4;
    }

    public b(Rect r4) {
        Intrinsics.checkNotNullParameter(r4, "rect");
        this(r4.left, r4.top, r4.right, r4.bottom);
    }

    public final Rect a() {
        return new Rect(this.f14899a, this.f14900b, this.c, this.d);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 != null) goto L8;
        Class<?> r3 = null;
    L10:
        if (Intrinsics.areEqual(r2, r3) == true) goto L12;
        return false;
    L12:
        Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.oui.window.model.Bounds");
        b r4 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
        if (this.f14899a == ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).f14899a) goto L16;
        return false;
    L16:
        if (this.f14900b == ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).f14900b) goto L19;
        return false;
    L19:
        if (this.c == ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).c) goto L22;
        return false;
    L22:
        if (this.d == ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).d) goto L24;
        return false;
    L24:
        return true;
    L8:
        r3 = r7.getClass();
        goto L10
    }

    public int hashCode() {
        return (((((this.f14899a * 31) + this.f14900b) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        return b.class.getSimpleName() + " { [" + this.f14899a + ',' + this.f14900b + ',' + this.c + ',' + this.d + "] }";
    }
}
