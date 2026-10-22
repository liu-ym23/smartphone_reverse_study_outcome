package com.lynx.tasm.ui.image;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n extends PthreadHandlerThreadV2 {
    public static volatile n g;
    public List<Runnable> c;
    public List<Runnable> d;
    public Handler e;
    public Handler f;

    public class a implements Runnable {
        public final /* synthetic */ n a;

        public final void a() {
            n r0 = this.a;
            r0.getClass();
            r0.f = new Handler(r0.getLooper());
            r0.e = new Handler(Looper.myLooper());
            List<Runnable> r1 = r0.c;
            if (r1 != null) goto L5;
        L11:
            List<Runnable> r2 = r0.d;
            if (r2 != null) goto L14;
            return;
        L14:
            if (r2.isEmpty() == true) goto L24;
            Iterator<Runnable> r3 = r0.d.iterator();
        L17:
            if (r3.hasNext() == false) goto L19;
            Runnable r4 = r3.next();
            r0.f.post(r4);
            goto L17
        L19:
            ((LinkedList) r0.d).clear();
            return;
        L24:
            return;
        L5:
            if (r1.isEmpty() == true) goto L11;
            Iterator<Runnable> r5 = r0.c.iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            Runnable r6 = r5.next();
            r0.e.post(r6);
            goto L8
        L10:
            ((LinkedList) r0.c).clear();
            goto L11
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

        public a(n r1) {
            this.a = r1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n() {
        super("Lynx_image");
        ThreadMethodProxy.start(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLooperPrepared() {
        super/*android.os.HandlerThread*/.onLooperPrepared();
        new Handler(Looper.getMainLooper()).post(new a(this));
    }
}
