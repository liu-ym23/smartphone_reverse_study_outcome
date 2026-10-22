package rgc;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public static final Object a = null;
    public static final ConcurrentHashMap<Type, ConcurrentHashMap<d, Object>> b = null;
    public static final Handler c = null;

    public static class a implements Runnable {
        public final /* synthetic */ LifecycleOwner a;
        public final /* synthetic */ d b;

        @Override // java.lang.Runnable
        public final void run() {
            c.b(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LifecycleOwner r1, d r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public interface d<T> {
        void a(T r1);
    }

    static {
        a = new Object();
        b = new ConcurrentHashMap();
        c = new Handler(Looper.getMainLooper());
    }

    public static <Event> void a(Event r2) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        c.post(new c(r2));
        return;
    L6:
        ConcurrentHashMap<d, Object> r0 = b.get(r2.getClass());
        if (r0 == null) goto L14;
        Iterator<d> r1 = r0.keySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L20;
        d r3 = r1.next();
        if (r3 == null) goto L10;
        r3.a(r2);
        goto L10
    L20:
        return;
    }

    public static <EVENT> void b(LifecycleOwner r3, d<EVENT> r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L8;
        c.post(new a(r3, r4));
        return;
    L8:
        Type r0 = ((ParameterizedType) r4.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        ConcurrentHashMap<Type, ConcurrentHashMap<d, Object>> r1 = b;
        ConcurrentHashMap<d, Object> r2 = r1.get(r0);
        if (r2 != null) goto L11;
        r2 = new ConcurrentHashMap();
        r1.put(r0, r2);
    L11:
        r2.put(r4, a);
        if (r3 == null) goto L15;
        r3.getLifecycle().addObserver(new b(r2, r4, r0));
        return;
    }
}
