package onb;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.vmsdk.worker.JsWorker;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements nnb.c.b, pnb.d {
    public final nnb.c a;
    public final AtomicInteger b;
    public final List<c> c;
    public pnb.b d;
    public final Handler e;
    public final onb.c f;
    public final d g;
    public final d h;

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ g b;

        public final void a() {
            onb.b r0 = this.b.g.create();
            r0.b(this.a);
            g r1 = this.b;
            List<c> r2 = r1.c;
            monitor-enter(r2);
            ArrayList r3 = new ArrayList(r1.c);     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            Iterator r4 = r3.iterator();
        L8:
            if (r4.hasNext() == false) goto L10;
            ((c) r4.next()).b(r0);
            goto L8
        L10:
            rnb.c.a("RNBridge->JSBridgeConnector", "responseFromJs responseId: " + r0.a());
            return;
        L12:
            th = move-exception;
            throw th;
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

        public a(g r1, String r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ g b;

        public final void a() {
            onb.b r0 = this.b.h.create();
            r0.b(this.a);
            g r1 = this.b;
            List<c> r2 = r1.c;
            monitor-enter(r2);
            ArrayList r3 = new ArrayList(r1.c);     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            Iterator r4 = r3.iterator();
        L8:
            if (r4.hasNext() == false) goto L10;
            ((c) r4.next()).b(r0);
            goto L8
        L10:
            rnb.c.a("RNBridge->JSBridgeConnector", "responseFromDocs responseId: " + r0.a());
            return;
        L12:
            th = move-exception;
            throw th;
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

        public b(g r1, String r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public interface c<T extends onb.b> {
        void a();

        void b(T r1);

        void disconnect();
    }

    public final void d() {
        if (this.b.get() != 1) goto L11;
        this.b.set(2);
        final nnb.c r0 = this.a;
        r0.getClass();
        rnb.c.c("BridgeEngine", "start() called with: listener = [" + this + "]");
        com.ss.android.lark.jsruntime.vmsdk.j r1 = r0.a;
        if (r1 == null) goto L13;
        tnb.e r2 = new nnb.a(r0, this);
        Intrinsics.checkNotNullParameter(r2, "callback");
        rnb.c.c("VMSDK_VMSDKEngine", "addReadyListener() called with: callback = " + r2 + " isReady:" + r1.f);
        ((ArrayList) r1.e).add(r2);
        if (r1.f == false) goto L12;
        r2.onReady();
        return;
    L12:
        return;
    L13:
        return;
    }

    public final void e() {
        com.ss.android.lark.jsruntime.vmsdk.j r0 = this.a.a;
        if (r0 == null) goto L9;
        rnb.c.c("VMSDK_VMSDKEngine", "terminate: ");
        JsWorker r1 = r0.c;
        if (r1 == null) goto L7;
        r1.terminate();
    L7:
        r0.c = null;
        r0.j = false;
        ((ArrayList) r0.g).clear();
        ((ArrayList) r0.h).clear();
        ((ArrayList) r0.i).clear();
        ((ArrayList) r0.e).clear();
        r0.f = false;
    L9:
        if (this.b.get() != 3) goto L24;
        pnb.b r2 = this.a.b;
        if (pnb.c.c == false) goto L13;
        r2.getClass();
        rnb.c.a("bridge_connector", "unRegisterDataChangeListener: listener size=" + ((CopyOnWriteArraySet) r2.c).size());
    L13:
        pnb.b.a r3 = r2.b;
        int r4 = pnb.b.a.b;
        r3.getClass();
        r3.sendMessage(Message.obtain(r3, 2, this));
        List<c> r5 = this.c;
        monitor-enter(r5);
        ArrayList r6 = new ArrayList(this.c);     // Catch: Throwable -> L21
        monitor-exit(r5);     // Catch: Throwable -> L21
        Iterator r7 = r6.iterator();
    L19:
        if (r7.hasNext() == false) goto L24;
        ((c) r7.next()).disconnect();
    L21:
        th = move-exception;
        throw th;
    L24:
        this.f.destroy();
        this.b.set(1);
    }

    @Override // pnb.d
    public final void a(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        this.f.submit(new a(this, r3));
    }

    @Override // pnb.d
    public final void b(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        this.f.submit(new b(this, r3));
    }

    public final void c(c r3) {
        List<c> r0 = this.c;
        monitor-enter(r0);
        if (r3 != null) goto L13;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        if (((ArrayList) this.c).contains(r3) == true) goto L8;
        ((ArrayList) this.c).add(r3);     // Catch: Throwable -> L10
        goto L8
    }

    public final void f(c r3) {
        List<c> r0 = this.c;
        monitor-enter(r0);
        ((ArrayList) this.c).remove(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public g(nnb.c r3, n r4, d r5, d r6) {
        this.b = new AtomicInteger(1);
        this.c = new ArrayList();
        this.e = new Handler(Looper.getMainLooper());
        this.a = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
    }
}
