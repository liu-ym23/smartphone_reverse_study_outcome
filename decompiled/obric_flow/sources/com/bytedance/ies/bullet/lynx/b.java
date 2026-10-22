package com.bytedance.ies.bullet.lynx;

import android.content.Context;
import javax.xml.transform.Transformer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5599c;
    public final float d;
    public final float e;
    public final Transformer f;

    public b(Context r5, String r10, String r11, float r12, float r13, Transformer r14) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f5597a = r5;
        this.f5598b = r10;
        this.f5599c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        Context r11 = r10.f5597a;
        if (Intrinsics.areEqual(this.f5597a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5598b, r10.f5598b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f5599c, r10.f5599c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r10.d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r10.e) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f5597a.hashCode() * 31;
        int r10 = 0;
        String r11 = this.f5598b;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.f5599c;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = androidx.constraintlayout.motion.widget.a.b(this.e, androidx.constraintlayout.motion.widget.a.b(this.d, (r13 + r15) * 31, 31), 31);
        Transformer r17 = this.f;
        if (r17 == null) goto L15;
        r10 = r17.hashCode();
    L15:
        return r16 + r10;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "LynxImageInfo(context=" + this.f5597a + ", cacheKey=" + this.f5598b + ", src=" + this.f5599c + ", width=" + this.d + ", height=" + this.e + ", transformer=" + this.f + ')';
    }
}
