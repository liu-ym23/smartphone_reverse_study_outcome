package r91;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends com.bytedance.android.live.room.navi.userinfo_p.flipper.core.a {
    public static Disposable b;
    public static final d c = null;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r2) {
            String r3 = (String) r2;
            d r4 = d.c;
            r4.getClass();
            Disposable r0 = d.b;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            r4.f();
        }
    }

    static {
        c = new d();
    }

    @Override // w91.a
    public final Disposable execute() {
        Disposable r0 = b;
        if (r0 != null) goto L5;
    L9:
        Disposable r1 = Observable.just("").delay(5000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(a.a);
        b = r1;
        return r1;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L9;
        return r0;
    }

    public d() {
    }
}
