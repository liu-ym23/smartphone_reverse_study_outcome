package com.obric.oui.texteffects.render;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/texteffects/render/SpanMetrics;", "", "advances", "", "xCorrections", "", "([I[F)V", "getAdvances", "()[I", "getXCorrections", "()[F", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f14667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f14668b;

    public i(int[] r2, float[] r3) {
        Intrinsics.checkNotNullParameter(r2, "advances");
        Intrinsics.checkNotNullParameter(r3, "xCorrections");
        this.f14667a = r2;
        this.f14668b = r3;
    }

    public final int[] a() {
        return this.f14667a;
    }

    public final float[] b() {
        return this.f14668b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f14667a, r6.f14667a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f14668b, r6.f14668b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f14667a) * 31) + Arrays.hashCode(this.f14668b);
    }

    public String toString() {
        return "SpanMetrics(advances=" + Arrays.toString(this.f14667a) + ", xCorrections=" + Arrays.toString(this.f14668b) + ')';
    }
}
