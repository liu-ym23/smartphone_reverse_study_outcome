package dc2;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements ylc.c {
    public final PropertyOwner<a<T>> a;
    public long b;
    public ylc.c c;
    public final Observable<T> d;
    public final Observable<b<T>> e;
    public final String f;

    public static final class a<T> {
        public final long a;
        public final String b;
        public final T c;

        /* JADX INFO: renamed from: dc2.c$a$a, reason: collision with other inner class name */
        public static final class C0226a {
        }

        static {
        }

        public a(long r2, String r4, T r5) {
            Intrinsics.checkNotNullParameter(r4, "bizLogId");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public static final class b<T> {
        public final long a;
        public final T b;

        public b(long r2, T r4) {
            Intrinsics.checkNotNullParameter(r4, "value");
            this.a = r2;
            this.b = r4;
        }
    }

    /* JADX INFO: renamed from: dc2.c$c, reason: collision with other inner class name */
    public static final class C0227c<T> implements Predicate {
        public static final C0227c a = null;

        static {
            a = new C0227c();
        }

        public C0227c() {
        }

        public final boolean test(Object r2) {
            a r3 = (a) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (r3.c == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class d<T, R> implements Function {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object apply(Object r2) {
            a r3 = (a) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3.c;
        }
    }

    public static final class e<T> implements Predicate {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final boolean test(Object r2) {
            a r3 = (a) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (r3.c == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class f<T, R> implements Function {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object apply(Object r4) {
            a r5 = (a) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            long r1 = r5.a;
            T r6 = r5.c;
            Intrinsics.checkNotNull(r6);
            return new b(r1, r6);
        }
    }

    public static final class g<T> implements Predicate {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final boolean test(Object r2) {
            a r3 = (a) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (r3.c == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class h<T, R> implements Function {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final Object apply(Object r4) {
            a r5 = (a) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            long r1 = r5.a;
            T r6 = r5.c;
            Intrinsics.checkNotNull(r6);
            return new b(r1, r6);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ dc2.f a;
        public final /* synthetic */ long b;

        public i(dc2.f r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Disposable r6 = (Disposable) r5;
            dc2.f r7 = this.a;
            long r0 = this.b;
            r7.c = false;
            r7.a = System.currentTimeMillis();
            r7.b = r0;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ dc2.f a;

        public j(dc2.f r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            a r9 = (a) r8;
            dc2.f r0 = this.a;
            long r1 = r9.a;
            String r4 = r9.b;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r4, "bizLogId");
            if (r0.c == true) goto L7;
            r0.a(true, false, Long.valueOf(r1), r4, null);
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ dc2.f a;

        public k(dc2.f r1) {
            this.a = r1;
        }

        public final void accept(Object r13) {
            Throwable r5 = (Throwable) r13;
            if ((r5 instanceof TimeoutException) == false) goto L8;
            dc2.f r6 = this.a;
            if (r6.c == true) goto L18;
            r6.a(false, true, null, null, null);
            return;
        L18:
            return;
        L8:
            dc2.f r0 = this.a;
            if (r5 != null) goto L12;
            r0.getClass();
            return;
        L12:
            if (r0.c == true) goto L19;
            r0.a(false, false, null, null, r5);
            return;
        }
    }

    public static final class l<T, R> implements Function {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final Object apply(Object r2) {
            a r3 = (a) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            T r4 = r3.c;
            Intrinsics.checkNotNull(r4);
            return r4;
        }
    }

    public static final class m<T> implements Predicate {
        public final /* synthetic */ long a;

        public m(long r1) {
            this.a = r1;
        }

        public final boolean test(Object r5) {
            a r6 = (a) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            if (r6.c != null) goto L5;
        L7:
            return false;
        L5:
            if (r6.a < this.a) goto L7;
            return true;
        }
    }

    public static final class n<T> implements Predicate {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final boolean test(Object r2) {
            a r3 = (a) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (r3.c == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class o<T> implements Predicate {
        public final /* synthetic */ long a;

        public o(long r1) {
            this.a = r1;
        }

        public final boolean test(Object r5) {
            a r6 = (a) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            if (r6.c != null) goto L5;
        L7:
            return false;
        L5:
            if (r6.a < this.a) goto L7;
            return true;
        }
    }

    public final Observable<b<T>> b() {
        return this.a.filter(e.a).observeOn(AndroidSchedulers.mainThread()).map(f.a);
    }

    public final T c() {
        PropertyOwner<a<T>> r0 = this.a;
        r0.getClass();
        return ((a) r0.a).c;
    }

    public final void onClear() {
        this.a.onComplete();
    }

    public c(String r6) {
        Intrinsics.checkNotNullParameter(r6, "key");
        this.f = r6;
        PropertyOwner<a<T>> r7 = new PropertyOwner(new a(0, BuildConfig.FLAVOR, null));
        this.a = r7;
        this.d = com.bytedance.android.live.core.arch.mvvm.f.b(r7).filter(C0227c.a).observeOn(AndroidSchedulers.mainThread()).map(d.a);
        this.e = com.bytedance.android.live.core.arch.mvvm.f.b(r7).filter(g.a).observeOn(AndroidSchedulers.mainThread()).map(h.a);
    }

    public final void a(com.ss.ugc.live.sdk.message.wrsc.data.a r6) {
        Intrinsics.checkNotNullParameter(r6, "roomDataSync");
        Object r0 = r6.e;
        if (r0 != null) goto L18;
        String r1 = r6.g;
        Map<String, Class<?>> r2 = dc2.a.a;
        Intrinsics.checkNotNullParameter(r1, "key");
        Class r3 = (Class) ((HashMap) dc2.a.a).get(r1);
        if (r3 == null) goto L18;
        am3.c r4 = jc1.k.n(IMiddlewareNetworkService.class).getProtoDecoder(r3);     // Catch: Throwable -> L20
        if (r4 == null) goto L18;
        am3.g r5 = new am3.g();     // Catch: Throwable -> L20
        ByteString r7 = r6.d;     // Catch: Throwable -> L20
        if (r7 == null) goto L13;
        byte[] r8 = r7.toByteArray();     // Catch: Throwable -> L20
        if (r8 == null) goto L13;
    L14:
        r5.k(new am3.b(r8));     // Catch: Throwable -> L20
        Object r9 = r4.decode(r5);     // Catch: Throwable -> L20
        if ((r9 instanceof Object) == true) goto L17;
        r0 = null;
        goto L18
    L17:
        r0 = r9;
    L13:
        r8 = new byte[0];     // Catch: Throwable -> L20
    L18:
        this.a.a(new a(r6.a, r6.c, r0));
    }

    public final Observable<T> d(long r5, long r7) {
        if (r7 > 0) goto L5;
        Observable r8 = this.a.filter(new m(r5));
    L10:
        dc2.f r9 = new dc2.f(this.f, this.b);
        return r8.doOnSubscribe(new i(r9, r5)).doOnNext(new j(r9)).doOnError(new k(r9)).map(l.a).observeOn(AndroidSchedulers.mainThread());
    L5:
        T r0 = c();
        PropertyOwner<a<T>> r1 = this.a;
        r1.getClass();
        if (((a) r1.a).a < r5) goto L9;
        if (r0 == null) goto L9;
        r8 = com.bytedance.android.live.core.arch.mvvm.f.b(this.a).filter(n.a);
    L9:
        r8 = this.a.filter(new o(r5)).timeout(r7, TimeUnit.MILLISECONDS);
        goto L10
    }
}
