package com.obric.memorydata.personalcontext.util.video;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/video/ColorHistogram;", "", "red", "", "green", "blue", "<init>", "([F[F[F)V", "getRed", "()[F", "getGreen", "getBlue", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f12382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f12383b;
    private final float[] c;

    public a(float[] r2, float[] r3, float[] r4) {
        Intrinsics.checkNotNullParameter(r2, "red");
        Intrinsics.checkNotNullParameter(r3, "green");
        Intrinsics.checkNotNullParameter(r4, "blue");
        this.f12382a = r2;
        this.f12383b = r3;
        this.c = r4;
    }

    public final float[] a() {
        return this.f12382a;
    }

    public final float[] b() {
        return this.f12383b;
    }

    public final float[] c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12382a, r6.f12382a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f12383b, r6.f12383b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.f12382a) * 31) + Arrays.hashCode(this.f12383b)) * 31) + Arrays.hashCode(this.c);
    }

    public String toString() {
        return "ColorHistogram(red=" + Arrays.toString(this.f12382a) + ", green=" + Arrays.toString(this.f12383b) + ", blue=" + Arrays.toString(this.c) + ')';
    }
}
