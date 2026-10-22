package com.obric.memorydata.ability.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/ability/helper/MemoryGeoFenceParams;", "", "longitude", "", "latitude", "radius", "", "listener", "Lcom/obric/memorydata/ability/helper/MemoryGeoFenceListener;", "<init>", "(DDFLcom/obric/memorydata/ability/helper/MemoryGeoFenceListener;)V", "getLongitude", "()D", "getLatitude", "getRadius", "()F", "getListener", "()Lcom/obric/memorydata/ability/helper/MemoryGeoFenceListener;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f8300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f8301b;
    private final float c;
    private final b d;

    public c(double r3, double r5, float r7, b r8) {
        b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r8, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "listener");
        this.f8300a = r3;
        this.f8301b = r5;
        this.c = r7;
        this.d = r9;
    }

    public final double a() {
        return this.f8300a;
    }

    public final double b() {
        return this.f8301b;
    }

    public final float c() {
        return this.c;
    }

    public final b d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
        return false;
    L8:
        c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.memorydata.plugin");
        if (Double.compare(this.f8300a, r10.f8300a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f8301b, r10.f8301b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r10.c) == 0) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Double.hashCode(this.f8300a) * 31) + Double.hashCode(this.f8301b)) * 31) + Float.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "MemoryGeoFenceParams(longitude=" + this.f8300a + ", latitude=" + this.f8301b + ", radius=" + this.c + ", listener=" + this.d + ')';
    }
}
