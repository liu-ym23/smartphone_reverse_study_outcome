package com.obric.oui.blur;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0006\u0010\u001d\u001a\u00020\u0000J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u0000J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\r\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%J\t\u0010&\u001a\u00020'HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006("}, d2 = {"Lcom/obric/oui/blur/BlurConfig;", "", "blurRadius", "", "direction", "", "alpha", "curveType", "endPoint", "(FIFIF)V", "getAlpha", "()F", "setAlpha", "(F)V", "getBlurRadius", "setBlurRadius", "getCurveType", "()I", "setCurveType", "(I)V", "getDirection", "setDirection", "getEndPoint", "setEndPoint", "component1", "component2", "component3", "component4", "component5", "copy", "deepCopy", "equals", "", "other", "hashCode", "toCore", "Lcom/obric/oui/blur/BlurConfigCore;", "toCore$OUI_standardRelease", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f13342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13343b;
    private float c;
    private int d;
    private float e;

    public a() {
        this(0.0f, 0, 0.0f, 0, 0.0f, 31, null);
    }

    public a(float r1, int r2, float r3, int r4, float r5) {
        this.f13342a = r1;
        this.f13343b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public /* synthetic */ a(float r4, int r5, float r6, int r7, float r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L5;
        r4 = 0.0f;
    L5:
        int r0 = 0;
        if ((r9 & 2) == 0) goto L8;
        int r11 = 0;
    L9:
        float r1 = 1.0f;
        if ((r9 & 4) == 0) goto L12;
        float r2 = 1.0f;
    L14:
        if ((r9 & 8) != 0) goto L18;
        r0 = r7;
    L18:
        if ((r9 & 16) != 0) goto L21;
        r1 = r8;
    L21:
        this(r4, r11, r2, r0, r1);
        return;
    L12:
        r2 = r6;
        goto L14
    L8:
        r11 = r5;
        goto L9
    }

    public final float a() {
        return this.f13342a;
    }

    public final void a(float r1) {
        this.f13342a = r1;
    }

    public final void a(int r1) {
        this.f13343b = r1;
    }

    public final int b() {
        return this.f13343b;
    }

    public final float c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final float e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(Float.valueOf(this.f13342a), Float.valueOf(r6.f13342a)) == true) goto L12;
        return false;
    L12:
        if (this.f13343b == r6.f13343b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.c), Float.valueOf(r6.c)) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Float.valueOf(this.e), Float.valueOf(r6.e)) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final b f() {
        return new b(this.f13342a, this.f13343b, this.c, this.d, this.e);
    }

    public int hashCode() {
        return (((((((Float.hashCode(this.f13342a) * 31) + Integer.hashCode(this.f13343b)) * 31) + Float.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Float.hashCode(this.e);
    }

    public String toString() {
        return "BlurConfig(blurRadius=" + this.f13342a + ", direction=" + this.f13343b + ", alpha=" + this.c + ", curveType=" + this.d + ", endPoint=" + this.e + ')';
    }
}
