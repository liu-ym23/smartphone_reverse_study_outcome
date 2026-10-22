package z4;

import android.os.Looper;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import x4.t;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f14206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Type, b> f14207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<d, Object> f14208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f14209e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f14210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f14211b;

        public a(c r8, Object r10) {
            this.f14211b = r8;
            this.f14210a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f14211b.a(this.f14210a);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f14212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentHashMap<z4.a, Object> f14213b;

        public b() {
            this.f14213b = new ConcurrentHashMap();
        }
    }

    public c() {
        this.f14205a = new Object();
        this.f14206b = new Object();
        this.f14207c = new ConcurrentHashMap();
        this.f14208d = new ConcurrentHashMap();
        this.f14209e = null;
    }

    public final <Event> void a(Event r8) {
        if (Looper.myLooper() == t.d(this.f14209e)) goto L6;
        String r10 = this.f14209e;
        t.e(new a(this, r8), r10);
        return;
    L6:
        Object r11 = this.f14205a;
        monitor-enter(r11);
        b r12 = this.f14207c.get(r8.getClass());     // Catch: Throwable -> L19
        if (r12 != null) goto L11;
        r12 = new b();     // Catch: Throwable -> L19
        this.f14207c.put(r8.getClass(), r12);     // Catch: Throwable -> L19
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L19
        r12.f14212a = r8;
        Iterator<z4.a> r13 = r12.f14213b.keySet().iterator();
    L14:
        if (r13.hasNext() == false) goto L18;
        z4.a r14 = r13.next();
        if (r14 == null) goto L14;
        r14.a(r8);
        goto L14
    L18:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <EVENT> void b(boolean r8, z4.a<EVENT> r10) {
        Type r11 = ((ParameterizedType) r10.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        Object r12 = this.f14205a;
        monitor-enter(r12);
        b r13 = this.f14207c.get(r11);     // Catch: Throwable -> L14
        if (r13 != null) goto L7;
        r13 = new b();     // Catch: Throwable -> L14
        this.f14207c.put(r11, r13);     // Catch: Throwable -> L14
    L7:
        Object r14 = this.f14206b;     // Catch: Throwable -> L14
        r13.f14213b.put(r10, r14);     // Catch: Throwable -> L14
        this.f14208d.put((d) r10, this.f14206b);     // Catch: Throwable -> L14
        if (r8 == false) goto L12;
        Object r15 = r13.f14212a;     // Catch: Throwable -> L14
        if (r15 == null) goto L12;
        String r16 = this.f14209e;     // Catch: Throwable -> L14
        t.e(new z4.b(r13, r10, r15), r16);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r12);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
