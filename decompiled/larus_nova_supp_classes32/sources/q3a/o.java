package q3a;

import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o {
    public final CopyOnWriteArrayList<p> a;
    public final ExecutorService b;
    public final AtomicBoolean c;

    public static final class a {
    }

    static {
    }

    public o() {
        this.a = new CopyOnWriteArrayList();
        this.b = PThreadExecutorsUtils.newSingleThreadExecutor(new h());
        this.c = new AtomicBoolean(false);
    }

    public final void a(p r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (this.c.get() == true) goto L6;
        this.a.addIfAbsent(r4);
        FLogger.a.d("CameraEventDispatcher", "Added listener: " + r4.getClass().getSimpleName() + ", total: " + this.a.size());
        return;
    }

    public final void b(final r3a.i r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        if (this.c.get() == false) goto L5;
        return;
    L5:
        FLogger.a.e("CameraEventDispatcher", "Dispatching error: " + r4.a + " - " + r4.b);
        c("dispatchError", new q3a.a(r4));
    }

    public final void e(final r3a.j r4) {
        Intrinsics.checkNotNullParameter(r4, "frame");
        if (this.c.get() == false) goto L5;
        return;
    L5:
        FLogger.a.i("CameraEventDispatcher", "Dispatching frame captured: textureId=" + r4.a);
        if (z2.a.enableCameraFrameSyncDispatch() == false) goto L11;
        Function1<? super p, Unit> r0 = new n(r4);
        if (this.c.get() == true) goto L14;
        d("onFrameCaptured", r0);
        return;
    L14:
        return;
    L11:
        c("onFrameCaptured", new b(r4));
    }

    public final void c(final String r3, final Function1<? super p, Unit> r4) {
        if (this.c.get() == false) goto L5;
        return;
    L5:
        this.b.submit(new j(this, r3, r4));
    }

    public final void d(String r8, Function1<? super p, Unit> r9) {
        if (this.c.get() == false) goto L17;
        return;
    L17:
        Iterator<T> r1 = this.a.iterator();     // Catch: Exception -> L14
    L6:
        if (r1.hasNext() == false) goto L25;
        p r2 = (p) r1.next();     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L11
        r9.invoke(r2);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        FLogger.a.e("CameraEventDispatcher", "Error in listener=" + r2.o() + '.' + r8, e);     // Catch: Exception -> L14
        goto L6
    L25:
        return;
    L14:
        e = move-exception;
        FLogger.a.e("CameraEventDispatcher", "Error dispatching event=" + r8, e);
    }
}
