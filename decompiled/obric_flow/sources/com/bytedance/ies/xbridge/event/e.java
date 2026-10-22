package com.bytedance.ies.xbridge.event;

import com.lynx.tasm.behavior.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x0 f6333c;

    public e(String r5, long r10, x0 r11) {
        Intrinsics.checkNotNullParameter(r5, "containerID");
        this.f6331a = r5;
        this.f6332b = r10;
        this.f6333c = r11;
    }

    public final boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        String r10 = this.f6331a;
        String r11 = ((e) r5).f6331a;
        if (Intrinsics.areEqual(r10, r11) == false) goto L15;
        if (r10.length() <= 0) goto L15;
        return true;
    L15:
        if (Intrinsics.areEqual(r10, r11) == false) goto L17;
        Intrinsics.areEqual(null, null);
    L17:
        return false;
    }

    public final int hashCode() {
        return this.f6331a.hashCode();
    }
}
