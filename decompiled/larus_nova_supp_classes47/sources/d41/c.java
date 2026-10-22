package d41;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public int a;
    public Disposable b;
    public final String c;
    public final d d;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ int a;

        public a(int r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            long r0 = ((Number) r5).longValue();
            return Long.valueOf(((long) this.a) - r0);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            c r0 = this.a;
            r0.a = (int) r6.longValue();
            if (r6.longValue() > 0) goto L8;
            Disposable r7 = this.a.b;
            if (r7 == null) goto L7;
            r7.dispose();
        L7:
            c r8 = this.a;
            r8.b = null;
            jy0.b.a(r8.c, "time count down end");
        L8:
            c r9 = this.a;
            r9.d.g(r9.c, r9.a);
        }
    }

    /* JADX INFO: renamed from: d41.c$c, reason: collision with other inner class name */
    public static final class C0232c<T> implements Consumer {
        public final /* synthetic */ c a;

        public C0232c(c r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            jy0.b.a(this.a.c, "time count down error " + r5.getMessage());
            r5.printStackTrace();
        }
    }

    public final void a() {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = null;
    }

    public final void c() {
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        this.b = null;
        this.a = 0;
        this.d.g(this.c, 0);
    }

    public final void b(long r7) {
        if (r7 > 0) goto L5;
        return;
    L5:
        long r2 = WebcastRedirectException.UNKNOWN;
        int r5 = (int) (r7 / r2);
        int r8 = (int) (r7 % r2);
        int r9 = r5 + 1;
        this.a = r9;
        Disposable r3 = this.b;
        if (r3 == null) goto L8;
        r3.dispose();
    L8:
        this.b = du2.a.b(0, 1, TimeUnit.SECONDS).take(r9).delay(r8, TimeUnit.MILLISECONDS).map(new a(r5)).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new C0232c(this));
        this.d.g(this.c, this.a);
    }

    public c(String r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.c = r2;
        this.d = r3;
    }
}
