package org.koin.core.definition;

import kotlin.jvm.internal.Intrinsics;
import org.koin.core.instance.e;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uu.a f21010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f21011b;

    public c(uu.a r5, e r10) {
        Intrinsics.checkNotNullParameter(r5, "module");
        Intrinsics.checkNotNullParameter(r10, "factory");
        this.f21010a = r5;
        this.f21011b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        uu.a r11 = r10.f21010a;
        if (Intrinsics.areEqual(this.f21010a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f21011b, r10.f21011b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f21010a.f22468b.hashCode() * 31;
        return this.f21011b.f21015a.hashCode() + r5;
    }

    public final String toString() {
        return "KoinDefinition(module=" + this.f21010a + ", factory=" + this.f21011b + ')';
    }
}
