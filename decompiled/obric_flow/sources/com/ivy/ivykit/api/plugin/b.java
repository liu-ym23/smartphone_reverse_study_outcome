package com.ivy.ivykit.api.plugin;

import com.lynx.tasm.behavior.v0;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9481c;
    public final String d;
    public final a e;

    public b(String r5, long r10, String r11, String r12, a r13) {
        Intrinsics.checkNotNullParameter(r5, "response");
        Intrinsics.checkNotNullParameter(r11, "resFrom");
        this.f9479a = r5;
        this.f9480b = r10;
        this.f9481c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        String r5 = r11.f9479a;
        if (Intrinsics.areEqual(this.f9479a, r5) == true) goto L12;
        return false;
    L12:
        if (this.f9480b == r11.f9480b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f9481c, r11.f9481c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(v0.a(this.f9479a.hashCode() * 31, this.f9480b), 31, this.f9481c);
        int r10 = 0;
        String r11 = this.d;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        a r14 = this.e;
        if (r14 == null) goto L11;
        r10 = Arrays.hashCode(r14.f9478a);
    L11:
        return r13 + r10;
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppletResponse(response=" + this.f9479a + ", version=" + this.f9480b + ", resFrom=" + this.f9481c + ", filePath=" + this.d + ", byteArray=" + this.e + ")";
    }
}
