package com.obric.oui.texteffects.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/texteffects/core/GradientLayerSpec;", "", "colors", "", "positions", "", "followTextColor", "", "shiftFraction", "", "([I[FZF)V", "getColors", "()[I", "getFollowTextColor", "()Z", "getPositions", "()[F", "getShiftFraction", "()F", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f14629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f14630b;
    private final boolean c;
    private final float d;

    public p(int[] r2, float[] r3, boolean r4, float r5) {
        Intrinsics.checkNotNullParameter(r2, "colors");
        Intrinsics.checkNotNullParameter(r3, "positions");
        this.f14629a = r2;
        this.f14630b = r3;
        this.c = r4;
        this.d = r5;
    }

    public /* synthetic */ p(int[] r1, float[] r2, boolean r3, float r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = 0.0f;
    L8:
        this(r1, r2, r3, r4);
    }

    public final int[] a() {
        return this.f14629a;
    }

    public final float[] b() {
        return this.f14630b;
    }

    public final boolean c() {
        return this.c;
    }

    public final float d() {
        return this.d;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, p.class) == true) goto L9;
        return false;
    L9:
        if (Arrays.equals(this.f14629a, ((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.memorydata.plugin")).f14629a) == false) goto L21;
        if (Arrays.equals(this.f14630b, ((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.memorydata.plugin")).f14630b) == false) goto L21;
        if (this.c != ((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.memorydata.plugin")).c) goto L21;
        if (this.d != ((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.memorydata.plugin")).d) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == false) goto L21;
        return true;
    L17:
        r6 = false;
    L21:
        return false;
    }

    public int hashCode() {
        return (((((Arrays.hashCode(this.f14629a) * 31) + Arrays.hashCode(this.f14630b)) * 31) + Boolean.hashCode(this.c)) * 31) + Float.floatToRawIntBits(this.d);
    }

    public String toString() {
        return "GradientLayerSpec(colors=" + Arrays.toString(this.f14629a) + ", positions=" + Arrays.toString(this.f14630b) + ", followTextColor=" + this.c + ", shiftFraction=" + this.d + ')';
    }
}
