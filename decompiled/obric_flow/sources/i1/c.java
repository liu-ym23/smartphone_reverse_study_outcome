package i1;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f17482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f17483b;

    public c(Context r5, String... r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "keys");
        this.f17482a = r10;
        this.f17483b = new WeakReference(r5);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        if (Intrinsics.areEqual((Context) this.f17483b.get(), (Context) r10.f17483b.get()) == true) goto L11;
    L13:
        return false;
    L11:
        if (Arrays.equals(this.f17482a, r10.f17482a) == false) goto L13;
        return true;
    }

    public final int hashCode() {
        Context r5 = (Context) this.f17483b.get();
        if (r5 == null) goto L5;
        int r10 = r5.hashCode();
    L7:
        return (r10 * 31) + Arrays.hashCode(this.f17482a);
    L5:
        r10 = 0;
        goto L7
    }
}
