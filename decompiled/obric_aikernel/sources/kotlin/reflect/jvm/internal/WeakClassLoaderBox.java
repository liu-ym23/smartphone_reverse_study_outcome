package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class WeakClassLoaderBox {
    private final int identityHashCode;
    private final WeakReference<ClassLoader> ref;
    private ClassLoader temporaryStrongRef;

    public WeakClassLoaderBox(ClassLoader r10) {
        Intrinsics.checkNotNullParameter(r10, "classLoader");
        this.ref = new WeakReference(r10);
        this.identityHashCode = System.identityHashCode(r10);
        this.temporaryStrongRef = r10;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof WeakClassLoaderBox) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.ref.get() != ((WeakClassLoaderBox) r10).ref.get()) goto L7;
        return true;
    }

    public int hashCode() {
        return this.identityHashCode;
    }

    public final void setTemporaryStrongRef(ClassLoader r10) {
        this.temporaryStrongRef = r10;
    }

    public String toString() {
        ClassLoader r10 = this.ref.get();
        if (r10 == null) goto L6;
        String r11 = r10.toString();
        if (r11 == null) goto L6;
        return r11;
    L6:
        return "<null>";
    }
}
