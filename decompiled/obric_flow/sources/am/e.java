package am;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f325b;

    public e() {
        this.f324a = true;
        this.f325b = null;
    }

    public e(String r5) {
        if (r5 != null) goto L5;
        boolean r10 = true;
    L6:
        this.f324a = r10;
        this.f325b = r5;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public e(boolean r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "discriminator");
        this.f324a = r5;
        this.f325b = r10;
    }
}
