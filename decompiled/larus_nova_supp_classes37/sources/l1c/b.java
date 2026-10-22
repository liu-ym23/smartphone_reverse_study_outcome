package l1c;

import android.content.Context;
import android.os.Handler;
import com.google.gson.Gson;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends k1c.a<Map<String, ? extends Double>> implements e1c.b.a, y {
    public final Map<String, C0164b> d;
    public HashMap<String, Double> e;
    public Handler f;
    public com.ss.android.lark.storage.kv.repo.a g;

    public static final class a {
    }

    /* JADX INFO: renamed from: l1c.b$b, reason: collision with other inner class name */
    public static final class C0164b {
        public int a;
        public int b;
        public int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0164b) == true) goto L8;
            return false;
        L8:
            C0164b r6 = (C0164b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "(" + this.a + ", " + this.b + ", " + this.c + ')';
        }

        public C0164b() {
            this.a = 0;
            this.b = 0;
            this.c = 0;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void a() {
            b r0 = this.a;
            Iterator r2 = ((ConcurrentHashMap) r0.d).entrySet().iterator();
        L4:
            if (r2.hasNext() == false) goto L19;
            Map.Entry r3 = (Map.Entry) r2.next();
            HashMap<String, Double> r4 = r0.e;
            Object r5 = r3.getKey();
            if (((C0164b) r3.getValue()).b != 0) goto L8;
            double r6 = 0.0d;
        L9:
            r4.put((String) r5, Double.valueOf(r6));
            goto L4
        L8:
            r6 = ((double) ((C0164b) r3.getValue()).c) / (((double) ((C0164b) r3.getValue()).b) * 1.0d);
            goto L9
        L19:
            com.ss.android.lark.storage.kv.repo.c r7 = r0.g;     // Catch: Exception -> L15
            if (r7 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mUserStorage");     // Catch: Exception -> L15
            r7 = null;
        L13:
            r7.putString("user_task_hit_rate", new Gson().toJson(r0.e));     // Catch: Exception -> L15
        L17:
            Log.d("Detector/PreloadHitRateDetector", "saveTaskHitRate， save the config:" + r0.e + " / " + r0.d);
            return;
        L15:
            e = move-exception;
            Log.e("Detector/PreloadHitRateDetector", "save user_task_hit_rate error!", e, true);
            goto L17
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
    }

    static {
    }

    @Override // e1c.b.a
    public final void c(o1c.c<?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
    }

    @Override // o1c.c.a
    public final void e(o1c.c<?, ?> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "task");
    }

    @Override // o1c.c.a
    public final void g(o1c.c<?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
    }

    @Override // o1c.c.a
    public final void k(o1c.c r1, boolean r2, Map r3) {
        Intrinsics.checkNotNullParameter(r1, "task");
    }

    public b() {
        this.d = new ConcurrentHashMap();
        this.e = new HashMap();
    }

    @Override // k1c.a
    public final Map<String, ? extends Double> n() {
        return this.e;
    }

    @Override // e1c.b.a
    public final void d(o1c.c<?, ?> r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        C0164b r0 = (C0164b) ((ConcurrentHashMap) this.d).get(r3.getClass().getSimpleName());
        if (r0 != null) goto L5;
        r0 = new C0164b();
    L5:
        r0.a++;
        ((ConcurrentHashMap) this.d).put(r3.getClass().getSimpleName(), r0);
    }

    public final void f(y.a r2, y.a r3) {
        Intrinsics.checkNotNullParameter(r2, "oldState");
        Intrinsics.checkNotNullParameter(r3, "newState");
        if (r3.c == false) goto L5;
        return;
    L5:
        if (r2.c == false) goto L12;
        Handler r4 = this.f;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mWorkerHandler");
        r4 = null;
    L9:
        r4.post(new c(this));
        return;
    }

    @Override // k1c.a, k1c.b
    public final void j(Context r2, e1c.d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "manager");
        super.j(r2, r3);
        this.g = LarkKVStorage.p(new com.ss.android.lark.storage.a("core"), "preload_config", false);
        this.f = CoreThreadPool.newThreadHandler("Detector/PreloadHitRateDetector");
        AppLifecycle.a.a.c(this);
        boolean r4 = e1c.d.m;
        e1c.d r5 = e1c.d.b.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(this, "callback");
        r5.e.add(this);
        Handler r6 = this.f;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWorkerHandler");
        r6 = null;
    L5:
        r6.post(new l1c.c(this));
    }

    @Override // o1c.c.a
    public final void m(o1c.c r1, Map r2) {
        Intrinsics.checkNotNullParameter(r1, "task");
        C0164b r3 = (C0164b) ((ConcurrentHashMap) this.d).get(r1.getClass().getSimpleName());
        if (r3 == null) goto L6;
        r3.c++;
        return;
    }

    @Override // o1c.c.a
    public final void b(o1c.c<?, ?> r1, int r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r1, "task");
        C0164b r4 = (C0164b) ((ConcurrentHashMap) this.d).get(r1.getClass().getSimpleName());
        if (r4 == null) goto L6;
        r4.b += r2;
        return;
    }
}
