package com.obric.common.oea.foundation.graphics.smoothcorner.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/Point;", "", "x", "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f7764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f7765b;

    public e(float r1, float r2) {
        this.f7764a = r1;
        this.f7765b = r2;
    }

    public final float a() {
        return this.f7764a;
    }

    public final float b() {
        return this.f7765b;
    }

    public final float c() {
        return this.f7764a;
    }

    public final float d() {
        return this.f7765b;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L11;
        e r4 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.memorydata.plugin");
        if (Float.compare(this.f7764a, r4.f7764a) == 0) goto L9;
        return false;
    L9:
        if (Float.compare(this.f7765b, r4.f7765b) == 0) goto L17;
        return false;
    L17:
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        return (Float.hashCode(this.f7764a) * 31) + Float.hashCode(this.f7765b);
    }

    public String toString() {
        return "Point(x=" + this.f7764a + ", y=" + this.f7765b + ")";
    }
}
