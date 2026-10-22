package com.bytedance.ies.bullet.base.utils.logger;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5262b;

    public c(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        this.f5261a = r5;
        this.f5262b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        String r11 = r10.f5261a;
        if (Intrinsics.areEqual(this.f5261a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5262b, r10.f5262b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f5261a.hashCode() * 31;
        return this.f5262b.hashCode() + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Stage(name=");
        r5.append(this.f5261a);
        r5.append(", sessionId=");
        return j0.p(r5, this.f5262b, ')');
    }
}
