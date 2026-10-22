package p2;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.SoftReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static SoftReference<Handler> a;
    public static final Lazy b = null;
    public static final Lazy c = null;

    public static final class a implements Runnable {
        public final Runnable a;

        public final void a() {
            this.a.run();     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.bytedance.ai.applet.base.log.b r1 = com.bytedance.ai.applet.base.log.a.a;
            com.bytedance.ai.applet.base.log.a.b("SafeWrapper", "fail to execute runnable = " + this.a + " error = " + Log.getStackTraceString(e), null);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Runnable r10) {
            Intrinsics.checkNotNullParameter(r10, "target");
            this.a = r10;
        }
    }

    static {
        b = LazyKt.lazy(new p2.a());
        c = LazyKt.lazy(new b());
    }

    public static Handler a() {
        SoftReference<Handler> r0 = a;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        Handler r1 = r0.get();
        if (r1 == null) goto L7;
        return r1;
    L7:
        Handler r10 = new Handler(Looper.getMainLooper());
        a = new SoftReference(r10);
        return r10;
    }

    @JvmStatic
    public static final boolean b() {
        return Intrinsics.areEqual(a().getLooper(), Looper.myLooper());
    }

    @JvmStatic
    public static final void c(Runnable r10) {
        Intrinsics.checkNotNullParameter(r10, "runnable");
        Lazy r0 = c;
        if (Intrinsics.areEqual(((Handler) r0.getValue()).getLooper(), Looper.myLooper()) == false) goto L5;
        r10.run();
        return;
    L5:
        ((Handler) r0.getValue()).post(new a(r10));
    }

    @JvmStatic
    public static final void d(Runnable r10) {
        Intrinsics.checkNotNullParameter(r10, "runnable");
        if (Intrinsics.areEqual(a().getLooper(), Looper.myLooper()) == false) goto L5;
        r10.run();
        return;
    L5:
        a().post(new a(r10));
    }

    @JvmStatic
    public static final void e(Runnable r1, long r10) {
        Intrinsics.checkNotNullParameter(r1, "runnable");
        a().postDelayed(r1, r10);
    }
}
