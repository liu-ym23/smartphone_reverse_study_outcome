package c1;

import a3.f;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SoftReference f1102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f1103b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f1104c = null;

    static {
        f1103b = LazyKt.lazy(new f(2));
        f1104c = LazyKt.lazy(new f(3));
    }

    public static final void a(Runnable r5) {
        Intrinsics.checkNotNullParameter(r5, "runnable");
        Lazy r10 = f1104c;
        if (Intrinsics.areEqual(((Handler) r10.getValue()).getLooper(), Looper.myLooper()) == false) goto L6;
        r5.run();
        return;
    L6:
        ((Handler) r10.getValue()).post(new a(r5, 0));
    }

    public static final void b(Runnable r5) {
        Intrinsics.checkNotNullParameter(r5, "runnable");
        if (Intrinsics.areEqual(c().getLooper(), Looper.myLooper()) == false) goto L6;
        r5.run();
        return;
    L6:
        c().post(new a(r5, 0));
    }

    public static Handler c() {
        SoftReference r5 = f1102a;
        if (r5 == null) goto L7;
        Intrinsics.checkNotNull(r5);
        Handler r10 = (Handler) r5.get();
        if (r10 == null) goto L7;
        return r10;
    L7:
        Handler r11 = new Handler(Looper.getMainLooper());
        f1102a = new SoftReference(r11);
        return r11;
    }
}
