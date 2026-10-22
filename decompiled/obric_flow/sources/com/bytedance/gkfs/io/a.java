package com.bytedance.gkfs.io;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f4852b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4853a;

    static {
        f4852b = new a(-1);
    }

    public a(int r5) {
        this.f4853a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof a) == true) goto L6;
        return false;
    L6:
        if (this.f4853a == ((a) r5).f4853a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f4853a;
    }

    public final String toString() {
        return androidx.constraintlayout.motion.widget.a.s(new StringBuilder("BlockIdentifier(value="), this.f4853a, ")");
    }
}
