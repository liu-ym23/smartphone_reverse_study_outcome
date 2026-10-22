package k5;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f18615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class[] f18617c;
    public Method d;
    public WeakReference e;

    public g(Class r5, String r10, Class[] r11) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.checkNotNullParameter(r11, "paramTypes");
        this.f18615a = r5;
        this.f18616b = r10;
        this.f18617c = r11;
        this.e = new WeakReference(null);
    }

    public final Method a() {
        if (this.d != null) goto L9;
        Class r5 = this.f18615a;     // Catch: Throwable -> L6
        String r10 = this.f18616b;     // Catch: Throwable -> L6
        Class[] r11 = this.f18617c;     // Catch: Throwable -> L6
        this.d = r5.getDeclaredMethod(r10, (Class[]) Arrays.copyOf(r11, r11.length));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        mn.h.g("default_handle", th);
    L9:
        return this.d;
    }
}
