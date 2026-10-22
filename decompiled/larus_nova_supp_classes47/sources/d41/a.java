package d41;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public int a;
    public boolean b;
    public Disposable c;
    public final String d;
    public final d41.b e;

    /* JADX INFO: renamed from: d41.a$a, reason: collision with other inner class name */
    public static final class C0231a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            a r6 = this.a;
            int r0 = r6.a + 1;
            r6.a = r0;
            String r1 = r6.d;
            if (r6.b == false) goto L6;
            r6.e.e(r1, r0);
            return;
        }
    }

    static {
    }

    public final void a() {
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.c = null;
        this.a = -1;
        this.b = false;
    }

    public final void b(long r4) {
        if (r4 >= 0) goto L5;
        return;
    L5:
        this.a = (int) r4;
        Disposable r5 = this.c;
        if (r5 == null) goto L8;
        r5.dispose();
    L8:
        this.c = du2.a.d(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        String r6 = this.d;
        int r7 = this.a;
        if (this.b == false) goto L12;
        this.e.e(r6, r7);
        return;
    }

    public final void update(long r2) {
        int r3 = (int) r2;
        this.a = r3;
        this.b = true;
        String r4 = this.d;
        this.e.e(r4, r3);
    }

    public a(String r2, d41.b r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.d = r2;
        this.e = r3;
        this.a = -1;
    }
}
