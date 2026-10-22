package bd;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> extends t<T> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Handler f3155n = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3156l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashMap f3157m;

    /* JADX INFO: renamed from: bd.a$a, reason: collision with other inner class name */
    public class RunnableC0036a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f3158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f3159b;

        public RunnableC0036a(a r8, Object r10) {
            this.f3159b = r8;
            this.f3158a = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            this.f3159b.i(this.f3158a);
        }
    }

    public class b<R> implements u<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u<R> f3161b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f3162c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f3163d;

        public b(a r8, int r10, u r11) {
            this.f3163d = r8;
            this.f3160a = r10;
            this.f3161b = r11;
            this.f3162c = false;
        }

        @Override // androidx.lifecycle.u
        public final void a(R r8) {
            if (this.f3162c == true) goto L7;
            int r10 = this.f3163d.f3156l;
            if (this.f3160a < r10) goto L7;
            return;
        L7:
            this.f3161b.a(r8);
        }
    }

    static {
        f3155n = new Handler(Looper.getMainLooper());
    }

    public a() {
        this.f3156l = -1;
        this.f3157m = new HashMap();
    }

    @Override // androidx.lifecycle.LiveData
    public final void d(u<? super T> r8) {
        HashMap r10 = this.f3157m;
        if (r10.containsKey(r8) == true) goto L7;
        b r11 = new b(this, this.f3156l, r8);
        r10.put(r8, r11);
        super.d(r11);
        return;
    }

    @Override // androidx.lifecycle.t, androidx.lifecycle.LiveData
    public final void g(T r8) {
        f3155n.post(new RunnableC0036a(this, r8));
    }

    @Override // androidx.lifecycle.LiveData
    public final void h(u<? super T> r8) {
        HashMap r10 = this.f3157m;
        b r11 = (b) r10.remove(r8);
        if (r11 == null) goto L7;
        super.h(r11);
        return;
    L7:
        if ((r8 instanceof b) == false) goto L21;
        Iterator r12 = r10.entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (r8.equals(r13.getValue()) == false) goto L10;
        u r14 = (u) r13.getKey();
        super.h(r8);
    L15:
        if (r14 == null) goto L22;
        r10.remove(r14);
        return;
    L22:
        return;
    L14:
        r14 = null;
        goto L15
    }

    @Override // androidx.lifecycle.t, androidx.lifecycle.LiveData
    public final void i(T r8) {
        this.f3156l++;
        super.i(r8);
    }
}
