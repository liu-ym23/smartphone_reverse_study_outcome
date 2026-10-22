package com.bytedance.iesgurd;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6595b;

    public c(String r5, String r10) {
        this.f6594a = r5;
        this.f6595b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof c) == false) goto L10;
        c r10 = (c) r5;
        String r11 = r10.f6594a;
        if (Intrinsics.areEqual(this.f6594a, r11) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f6595b, r10.f6595b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r5 = 0;
        String r10 = this.f6594a;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = r11 * 31;
        String r13 = this.f6595b;
        if (r13 == null) goto L10;
        r5 = r13.hashCode();
    L10:
        return r12 + r5;
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("IESGurdObserverCleanInfo(accessKey=");
        r5.append(this.f6594a);
        r5.append(", channel=");
        return j0.q(r5, this.f6595b, ")");
    }
}
