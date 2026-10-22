package com.bytedance.ai.applet.render.core.relax;

import com.relax.embedding.module.NativeModuleCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NativeModuleCallback f1790b;

    public a(String r5, NativeModuleCallback r10) {
        Intrinsics.checkNotNullParameter(r5, "message");
        this.f1789a = r5;
        this.f1790b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        String r11 = r10.f1789a;
        if (Intrinsics.areEqual(this.f1789a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1790b, r10.f1790b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f1789a.hashCode() * 31;
        NativeModuleCallback r10 = this.f1790b;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return r5 + r11;
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public final String toString() {
        return "RelaxDataContext(message=" + this.f1789a + ", callback=" + this.f1790b + ')';
    }
}
