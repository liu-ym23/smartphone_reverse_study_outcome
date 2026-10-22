package com.bytedance.android.monitorV2.lynx.impl.blank;

import com.lynx.tasm.behavior.v0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f3665c;

    public b(long r5, long r10, f r11) {
        Intrinsics.checkNotNullParameter(r11, "checkResult");
        this.f3663a = r5;
        this.f3664b = r10;
        this.f3665c = r11;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        long r5 = r11.f3663a;
        if (this.f3663a == r5) goto L12;
        return false;
    L12:
        if (this.f3664b == r11.f3664b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f3665c, r11.f3665c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = v0.a(Long.hashCode(this.f3663a) * 31, this.f3664b);
        return this.f3665c.hashCode() + r5;
    }

    public final String toString() {
        return "BlankCheck(detectElapse=" + this.f3663a + ", checkElapse=" + this.f3664b + ", checkResult=" + this.f3665c + ')';
    }
}
