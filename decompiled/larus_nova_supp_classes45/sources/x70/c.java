package x70;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.WeakReference;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final b a;
    public final d b;
    public final Handler c;

    public class a implements Handler.Callback {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r5) {
            C0296c r6 = (C0296c) r5.obj;
            ViewGroup r0 = r6.d;
            if (d80.d.b.booleanValue() == false) goto L8;
            WeakReference<ViewGroup> r1 = r6.c;
            if (r1 == null) goto L8;
            r0 = r1.get();
        L8:
            if (r6.f != null) goto L10;
            r6.f = this.a.a.inflate(r6.e, r0, false);
        L10:
            View r2 = r6.f;
            if (r2 == null) goto L13;
            r6.g.a(r2, r6.e);
        L13:
            d r3 = this.a.b;
            r3.getClass();
            r6.g = null;
            r6.a = null;
            r6.b = null;
            r6.c = null;
            r6.d = null;
            r6.e = 0;
            r6.f = null;
            r3.w.release(r6);
            return true;
        }
    }

    public static class b extends LayoutInflater {
        public static final String[] a = null;

        static {
            a = new String[]{"android.widget.", "android.webkit.", "android.app."};
        }

        public b(Context r1) {
            super(r1);
        }

        @Override // android.view.LayoutInflater
        public final LayoutInflater cloneInContext(Context r2) {
            return new b(r2);
        }

        @Override // android.view.LayoutInflater
        public final View onCreateView(String r5, AttributeSet r6) throws ClassNotFoundException {
            String[] r0 = a;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L10;
            View r3 = createView(r5, r0[r2], r6);     // Catch: ClassNotFoundException -> L11
            if (r3 == null) goto L8;
            return r3;
        L8:
            r2 = r2 + 1;
            goto L3
        L10:
            return super.onCreateView(r5, r6);
        }
    }

    /* JADX INFO: renamed from: x70.c$c, reason: collision with other inner class name */
    public static class C0296c {
        public c a;
        public WeakReference<c> b;
        public WeakReference<ViewGroup> c;
        public ViewGroup d;
        public int e;
        public View f;
        public e g;

        public C0296c() {
        }
    }

    public static final class d extends PthreadThreadV2 {
        public static final d x = null;
        public final ArrayBlockingQueue<C0296c> v;
        public final Pools.SynchronizedPool<C0296c> w;

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Thread, x70.c$d] */
        static {
            ?? r0 = new d();
            x = r0;
            ThreadMethodProxy.start(r0);
        }

        public d() {
            super("LiveAsyncLayoutInflater$InflateThread");
            this.v = new ArrayBlockingQueue(10);
            this.w = new Pools.SynchronizedPool(10);
        }

        public final void l() {
        L3:
            if (d80.d.b.booleanValue() == false) goto L42;
            C0296c r0 = this.v.take();     // Catch: Throwable -> L57
            if (r0 == null) goto L20;
            WeakReference<c> r2 = r0.b;     // Catch: Exception -> L19
            if (r2 == null) goto L20;
            if (r2.get() == null) goto L20;
            if (r0.b.get().a == null) goto L20;
            if ((r0.b.get().a.getContext() instanceof LifecycleOwner) == false) goto L20;
            Lifecycle r3 = r0.b.get().a.getContext().getLifecycle();     // Catch: Exception -> L19
            if (r3 == null) goto L20;
            if (r3.getCurrentState() == Lifecycle.State.DESTROYED) goto L3;
        L20:
            if (r0 != null) goto L59;
        L34:
            if (r0 == null) goto L3;
            WeakReference<c> r4 = r0.b;
            if (r4 == null) goto L3;
            if (r4.get() == null) goto L3;
            if (r0.b.get().c == null) goto L3;
            Message.obtain(r0.b.get().c, 0, r0).sendToTarget();
            goto L3
        L59:
            WeakReference<c> r5 = r0.b;     // Catch: RuntimeException -> L33
            if (r5 == null) goto L34;
            if (r5.get() == null) goto L34;
            if (r0.b.get().a == null) goto L34;
            WeakReference<ViewGroup> r6 = r0.c;     // Catch: RuntimeException -> L33
            if (r6 == null) goto L30;
            ViewGroup r7 = r6.get();     // Catch: RuntimeException -> L33
        L31:
            r0.f = r0.b.get().a.inflate(r0.e, r7, false);     // Catch: RuntimeException -> L33
            goto L34
        L30:
            r7 = null;
            goto L31
        L42:
            C0296c r1 = this.v.take();     // Catch: Throwable -> L57
            if (r1 == null) goto L65;
            c r8 = r1.a;
            if (r8 == null) goto L65;
            b r9 = r8.a;
            if (r9 == null) goto L65;
            if ((r9.getContext() instanceof LifecycleOwner) == false) goto L65;
            Lifecycle r11 = r1.a.a.getContext().getLifecycle();
            if (r11 == null) goto L65;
            if (r11.getCurrentState() == Lifecycle.State.DESTROYED) goto L3;
        L65:
            r1.f = r1.a.a.inflate(r1.e, r1.d, false);     // Catch: RuntimeException -> L58
        L56:
            Message.obtain(r1.a.c, 0, r1).sendToTarget();
            goto L3
        }

        public final void run() {
            l();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public interface e {
        void a(View r1, int r2);
    }

    public c(Context r3) {
        a r0 = new a(this);
        this.a = new b(r3);
        this.b = d.x;
        this.c = new Handler(r0);
    }

    public final void a(int r3, ViewGroup r4, e r5) {
        if (r5 == null) goto L14;
        C0296c r0 = (C0296c) this.b.w.acquire();
        if (r0 != null) goto L7;
        r0 = new C0296c();
    L7:
        if (d80.d.b.booleanValue() == false) goto L9;
        r0.b = new WeakReference(this);
        r0.c = new WeakReference(r4);
    L10:
        r0.e = r3;
        r0.g = r5;
        d r6 = this.b;
        r6.getClass();
        r6.v.put(r0);     // Catch: InterruptedException -> L15
        return;
    L18:
        return;
    L9:
        r0.a = this;
        r0.d = r4;
        goto L10
    L14:
        throw new NullPointerException("callback argument may not be null!");
    }
}
