package com.bytedance.android.ec.core.anchorv3;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.facebook.common.executors.HandlerExecutorServiceImpl;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PdpMessageOptImageHelper {
    public static final Lazy e = null;
    public static final a f = null;
    public static final b g = null;
    public volatile Boolean a;
    public final Handler b;
    public final List<Runnable> c;
    public final c d;

    public static final class a extends HandlerExecutorServiceImpl {

        /* JADX INFO: renamed from: com.bytedance.android.ec.core.anchorv3.PdpMessageOptImageHelper$a$a, reason: collision with other inner class name */
        public static final class RunnableC0125a implements Runnable {
            public final /* synthetic */ Runnable a;

            public RunnableC0125a(Runnable r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Runnable r0 = this.a;     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.run();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public a(Handler r1) {
            super(r1);
        }

        public final void execute(Runnable r10) {
            Lazy r0 = UIUtils.a;
            UIUtils.c().postAtFrontOfQueue(new RunnableC0125a(r10));
        }
    }

    public static final class b {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.concurrent.Executor] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6 */
        public static void a(Object r1, Executor r10) {
            Intrinsics.checkNotNullParameter(r1, "controller");
            if ((r1 instanceof com.bytedance.android.ecom.arch.slice.render.widget.fresco.h) == false) goto L11;
            com.bytedance.android.ecom.arch.slice.render.widget.fresco.h r11 = (com.bytedance.android.ecom.arch.slice.render.widget.fresco.h) r1;     // Catch: Exception -> L17
            ?? r12 = r10;
            if (r10 != null) goto L8;
            r12 = PdpMessageOptImageHelper.f;     // Catch: Exception -> L17
        L8:
            if (r12 == 0) goto L10;
            r11.b = r12;     // Catch: Exception -> L17
            return;
        L10:
            r11.getClass();     // Catch: Exception -> L17
            return;
        L11:
            Field r0 = (Field) PdpMessageOptImageHelper.e.getValue();     // Catch: Exception -> L17
            Object r13 = r10;
            if (r0 == null) goto L21;
            if (r10 != null) goto L15;
            r13 = PdpMessageOptImageHelper.f;     // Catch: Exception -> L17
        L15:
            r0.set(r1, r13);     // Catch: Exception -> L17
            return;
        L21:
            return;
        }
    }

    public static final class c extends HandlerExecutorServiceImpl {
        public final /* synthetic */ PdpMessageOptImageHelper a;

        public final void execute(Runnable r10) {
            if (r10 == null) goto L17;
            Lazy r0 = UIUtils.a;
            if (UIUtils.d() == false) goto L6;
            r10.run();
            return;
        L6:
            List<Runnable> r1 = this.a.c;
            monitor-enter(r1);
        L14:
            th = move-exception;
            throw th;
        L9:
            if (Intrinsics.areEqual(this.a.a, Boolean.TRUE) == false) goto L11;
            ((ArrayList) this.a.c).add(r10);     // Catch: Throwable -> L14
        L12:
            monitor-exit(r1);
            return;
        L11:
            this.a.b.postAtFrontOfQueue(r10);     // Catch: Throwable -> L14
            goto L12
        }

        public c(PdpMessageOptImageHelper r1, Handler r10) {
            this.a = r1;
            super(r10);
        }
    }

    static {
        g = new b();
        e = LazyKt.lazy(PdpMessageOptImageHelper$Companion$fieldUIExecutor$2.INSTANCE);
        Lazy r1 = UIUtils.a;
        f = new a(UIUtils.c());
    }

    public final boolean a() {
        if (((ArrayList) this.c).size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b() {
        boolean r0 = PdpMessageOpt.a;
        PdpMessageOpt.e("pending image size=" + ((ArrayList) this.c).size());
        List<Runnable> r1 = this.c;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (a() == false) goto L7;
        ArrayList r10 = new ArrayList(this.c);     // Catch: Throwable -> L16
        ((ArrayList) this.c).clear();     // Catch: Throwable -> L16
    L8:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r1);
        if (r10 == null) goto L15;
        Iterator r12 = r10.iterator();
    L13:
        if (r12.hasNext() == false) goto L22;
        ((Runnable) r12.next()).run();
        goto L13
    L22:
        return;
    L15:
        return;
    L7:
        r10 = null;
        goto L8
    }

    public PdpMessageOptImageHelper() {
        Handler r0 = new Handler(Looper.getMainLooper());
        this.b = r0;
        this.c = new ArrayList();
        this.d = new c(this, r0);
    }
}
