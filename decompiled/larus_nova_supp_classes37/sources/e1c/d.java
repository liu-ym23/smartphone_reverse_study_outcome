package e1c;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.chat.model.preload.v2.AudioResourceLoadTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements e1c.b, e1c.b.a {
    public static final boolean m = false;
    public final Map<String, o1c.c<?, ?>> a;
    public final Map<Class<o1c.c<?, ?>>, o1c.c<?, ?>> b;
    public final Map<String, Class<o1c.c<?, ?>>> c;
    public final HashMap<Class<k1c.b<Object>>, k1c.b<Object>> d;
    public final ArrayList<e1c.b.a> e;
    public final e1c.a f;
    public final n1c.a g;
    public final n1c.a h;
    public final List<Runnable> i;
    public final AtomicBoolean j;
    public Handler k;
    public Context l;

    public static final class a {
    }

    public static final class b {
        public static final d a = null;

        static {
            a = new d();
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ d a;
        public final /* synthetic */ o1c.c<?, ?> b;

        public c(d r1, o1c.c<?, ?> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Map<String, o1c.c<?, ?>> r0 = this.a.a;
            HashMap r1 = (HashMap) r0;
            r1.put(this.b.getTaskId(), this.b);
            Map<Class<o1c.c<?, ?>>, o1c.c<?, ?>> r2 = this.a.b;
            ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
            r3.put(this.b.getClass(), this.b);
            Map<String, Class<o1c.c<?, ?>>> r4 = this.a.c;
            ConcurrentHashMap r5 = (ConcurrentHashMap) r4;
            r5.put(this.b.getTaskId(), this.b.getClass());
            this.b.J0(this.a.f);
            this.b.K(this.a);
            if (e1c.c.c.get() == false) goto L5;
            List<g1c.b<?>> r6 = CollectionsKt.plus(CollectionsKt.plus(this.b.p0().a, this.b.w0().a), this.b.C1().a);
        L6:
            d r7 = this.a;
            Iterator<T> r8 = r6.iterator();
        L8:
            if (r8.hasNext() == false) goto L19;
            g1c.b<Object> r9 = (g1c.b) r8.next();
            Class<? extends k1c.b<Object>> r10 = r9.b();
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.Class<com.ss.android.lark.preload.v2.detector.IDetector<kotlin.Any?>>");
            k1c.b<Object> r11 = r7.d.get(r10);
            if (r11 != null) goto L17;
            r11 = r10.newInstance();
            if (r11 == null) goto L17;
            Context r12 = r7.l;
            if (r12 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            r12 = null;
        L16:
            r11.j(r12, r7);
        L17:
            if (r11 == null) goto L8;
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.ss.android.lark.preload.v2.condition.ICondition<kotlin.Any?>");
            r11.h(r9);
            r7.d.put((Class<k1c.b<Object>>) r10, r11);
            goto L8
        L19:
            this.a.d(this.b);
            return;
        L5:
            r6 = this.b.p0().a;
            goto L6
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

    /* JADX INFO: renamed from: e1c.d$d, reason: collision with other inner class name */
    public static final class RunnableC0136d implements Runnable {
        public final /* synthetic */ Set<g1c.b<?>> a;
        public final /* synthetic */ d b;

        /* JADX WARN: Multi-variable type inference failed */
        public RunnableC0136d(Set<? extends g1c.b<?>> r1, d r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<g1c.b<?>> r0 = this.a.iterator();     // Catch: Throwable -> L16
        L4:
            if (r0.hasNext() == false) goto L8;
            if (r0.next().a() == false) goto L4;
            boolean r1 = true;
        L9:
            Handler r2 = this.b.k;     // Catch: Throwable -> L16
            if (r2 == null) goto L12;
            r2.removeMessages(3);     // Catch: Throwable -> L16
        L12:
            Handler r3 = this.b.k;     // Catch: Throwable -> L16
            if (r3 == null) goto L19;
            d.o(r3, 2, Boolean.valueOf(r1), 50);     // Catch: Throwable -> L16
            return;
        L19:
            return;
        L8:
            r1 = false;
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L26;
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ Set<g1c.b<?>> a;
        public final /* synthetic */ d b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Set<? extends g1c.b<?>> r1, d r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<g1c.b<?>> r0 = this.a.iterator();     // Catch: Throwable -> L16
        L4:
            if (r0.hasNext() == false) goto L8;
            if (r0.next().a() == false) goto L4;
            boolean r1 = true;
        L9:
            Handler r2 = this.b.k;     // Catch: Throwable -> L16
            if (r2 == null) goto L12;
            r2.removeMessages(2);     // Catch: Throwable -> L16
        L12:
            Handler r3 = this.b.k;     // Catch: Throwable -> L16
            if (r3 == null) goto L19;
            d.o(r3, 3, Boolean.valueOf(r1), 50);     // Catch: Throwable -> L16
            return;
        L19:
            return;
        L8:
            r1 = false;
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L26;
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ Set<g1c.b<?>> a;
        public final /* synthetic */ d b;

        /* JADX WARN: Multi-variable type inference failed */
        public f(Set<? extends g1c.b<?>> r1, d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Set<g1c.b<?>> r0 = this.a;
            d r1 = this.b;
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            g1c.b r3 = (g1c.b) r2.next();
            Iterator r4 = ((HashMap) r1.a).values().iterator();
        L7:
            if (r4.hasNext() == false) goto L4;
            r3.e((o1c.c) r4.next());
            goto L7
        L9:
            Handler r5 = this.b.k;
            if (r5 == null) goto L15;
            d.o(r5, 1, this.a, 100);
            return;
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
        m = Log.isLoggable("PreloadTaskManager", 2);
    }

    public d() {
        this.a = new HashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new HashMap();
        this.e = new ArrayList();
        this.f = new e1c.a();
        int r0 = n1c.a.h;
        this.g = n1c.a.C0168a.a(1, Math.max(r0 * 8, 64));
        this.h = n1c.a.C0168a.a(1, r0);
        this.i = new ArrayList();
        this.j = new AtomicBoolean(false);
    }

    @Override // e1c.b
    public final void a(Set<? extends g1c.b<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "conditions");
        Handler r0 = this.k;
        if (r0 == null) goto L6;
        r0.post(new e(r3, this));
        return;
    }

    @Override // e1c.b.a
    public final void c(o1c.c<?, ?> r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e1c.b.a) r0.next()).c(r3);
        goto L4
    L6:
        com.ss.android.lark.log.Log.i("PreloadTaskManager", "onTaskDisabled:".concat(r3.getClass().getSimpleName()));
    }

    @Override // e1c.b.a
    public final void d(o1c.c<?, ?> r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e1c.b.a) r0.next()).d(r3);
        goto L4
    L6:
        com.ss.android.lark.log.Log.i("PreloadTaskManager", "onTaskAdded:" + r3.getClass().getSimpleName() + '_' + r3.getTaskId());
    }

    @Override // e1c.b
    public final void f(Set<? extends g1c.b<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "conditions");
        Handler r0 = this.k;
        if (r0 == null) goto L6;
        r0.post(new f(r3, this));
        return;
    }

    @Override // o1c.c.a
    public final void g(o1c.c<?, ?> r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e1c.b.a) r0.next()).g(r3);
        goto L4
    L6:
        com.ss.android.lark.log.Log.i("PreloadTaskManager", "onTaskCleared:".concat(r3.getClass().getSimpleName()));
    }

    @Override // e1c.b
    public final void h(Set<? extends g1c.b<?>> r5) {
        Intrinsics.checkNotNullParameter(r5, "conditions");
        Handler r0 = this.k;
        if (r0 == null) goto L6;
        o(r0, 4, r5, 50);
        return;
    }

    @Override // e1c.b
    public final void i(Set<? extends g1c.b<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "conditions");
        Handler r0 = this.k;
        if (r0 == null) goto L6;
        r0.post(new RunnableC0136d(r3, this));
        return;
    }

    public final String j(o1c.c<?, ?> r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        Handler r0 = this.k;
        if (r0 == null) goto L6;
        r0.post(new c(this, r3));
    L6:
        return r3.getTaskId();
    }

    @Override // o1c.c.a
    public final void e(o1c.c<?, ?> r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "task");
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e1c.b.a) r0.next()).e(r3, r4);
        goto L4
    L6:
        com.ss.android.lark.log.Log.i("PreloadTaskManager", "onTaskPreExecuted:" + r3.getClass().getSimpleName() + '_' + r3.getTaskId());
    }

    @Override // o1c.c.a
    public final void m(o1c.c r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "task");
        Iterator<e1c.b.a> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().m(r3, r4);
        goto L4
    L6:
        com.ss.android.lark.log.Log.i("PreloadTaskManager", "onHitCache:".concat(r3.getClass().getSimpleName()));
    }

    public final Object n(Class r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "taskClass");
        o1c.c r4 = (o1c.c) ((ConcurrentHashMap) this.b).get(r2);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.j(r3);
    }

    @Override // o1c.c.a
    public final void b(o1c.c<?, ?> r3, int r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "task");
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e1c.b.a) r0.next()).b(r3, r4, r5);
        goto L4
    L6:
        com.ss.android.lark.log.Log.i("PreloadTaskManager", "onTaskPostExecuted:" + r3.getClass().getSimpleName() + '_' + r3.getTaskId());
    }

    @Override // o1c.c.a
    public final void k(o1c.c r3, boolean r4, Map r5) {
        Intrinsics.checkNotNullParameter(r3, "task");
        Iterator<e1c.b.a> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().k(r3, r4, r5);
        goto L4
    L6:
        com.ss.android.lark.log.Log.i("PreloadTaskManager", "onGetCache:".concat(r3.getClass().getSimpleName()));
    }

    public final void l(Class r3, AudioResourceLoadTask.b r4, IGetDataCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "taskClass");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        o1c.c r1 = (o1c.c) ((ConcurrentHashMap) this.b).get(r3);
        r0.element = r1;
        if (r1 != null) goto L5;
        Object r6 = r3.newInstance();
        r0.element = r6;
        j((o1c.c) r6);
    L5:
        this.g.execute(new e1c.e(r0, r4, r5));
    }

    public static void o(Handler r0, int r1, Object r2, long r3) {
        r0.removeMessages(r1);
        r0.sendMessageDelayed(Message.obtain(r0, r1, r2), r3);
    }
}
