package jq;

import ai.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f18421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18422b;

    public c(float r5, boolean r10) {
        this.f18421a = r5;
        this.f18422b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        float r11 = r10.f18421a;
        if (Float.compare(this.f18421a, r11) == 0) goto L12;
        return false;
    L12:
        if (this.f18422b == r10.f18422b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Float.hashCode(this.f18421a) * 31;
        return Boolean.hashCode(this.f18422b) + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("SpringBackValue(value=");
        r5.append(this.f18421a);
        r5.append(", isFinished=");
        return j0.r(r5, this.f18422b, ")");
    }
}
