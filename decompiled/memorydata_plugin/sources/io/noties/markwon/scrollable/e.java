package io.noties.markwon.scrollable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lio/noties/markwon/scrollable/ScrollBarTheme;", "", "scrollBarWidth", "", "scrollBarHeight", "scrollBarPadding", "", "scrollBarColor", "(IIFI)V", "getScrollBarColor", "()I", "getScrollBarHeight", "getScrollBarPadding", "()F", "getScrollBarWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16680b;
    private final float c;
    private final int d;

    public e(int r1, int r2, float r3, int r4) {
        this.f16679a = r1;
        this.f16680b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final int a() {
        return this.f16679a;
    }

    public final int b() {
        return this.f16680b;
    }

    public final float c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
    L25:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == false) goto L24;
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (this.f16679a != r6.f16679a) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L24;
        if (this.f16680b != r6.f16680b) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == false) goto L24;
        if (Float.compare(this.c, r6.c) != 0) goto L24;
        if (this.d != r6.d) goto L21;
        boolean r4 = true;
    L22:
        if (r4 == false) goto L24;
    L21:
        r4 = false;
        goto L22
    L14:
        r1 = false;
        goto L15
    L9:
        r0 = false;
    L24:
        return false;
    }

    public int hashCode() {
        return (((((this.f16679a * 31) + this.f16680b) * 31) + Float.floatToIntBits(this.c)) * 31) + this.d;
    }

    public String toString() {
        return "ScrollBarTheme(scrollBarWidth=" + this.f16679a + ", scrollBarHeight=" + this.f16680b + ", scrollBarPadding=" + this.c + ", scrollBarColor=" + this.d + ")";
    }
}
