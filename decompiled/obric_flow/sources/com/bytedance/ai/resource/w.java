package com.bytedance.ai.resource;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f2761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f2762b;

    public w(m0 r5) {
        AtomicBoolean r10 = new AtomicBoolean(false);
        Intrinsics.checkNotNullParameter(r5, "deferred");
        Intrinsics.checkNotNullParameter(r10, "timeoutHandled");
        this.f2761a = r5;
        this.f2762b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r10 = (w) r5;
        m0 r11 = r10.f2761a;
        if (Intrinsics.areEqual(this.f2761a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2762b, r10.f2762b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f2761a.hashCode() * 31;
        return this.f2762b.hashCode() + r5;
    }

    public final String toString() {
        return "InitializationAttempt(deferred=" + this.f2761a + ", timeoutHandled=" + this.f2762b + ')';
    }
}
