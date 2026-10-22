package r91;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends com.bytedance.android.live.room.navi.userinfo_p.flipper.core.a {
    public final long b;
    public Disposable c;

    /* JADX INFO: renamed from: r91.a$a, reason: collision with other inner class name */
    public static final class C0310a<T> implements Consumer {
        public final /* synthetic */ a a;

        public C0310a(a r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            String r2 = (String) r1;
            Disposable r3 = this.a.c;
            if (r3 == null) goto L5;
            r3.dispose();
        L5:
            this.a.f();
        }
    }

    @Override // w91.a
    public final Disposable execute() {
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = Observable.just("").delay(this.b, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0310a(this));
        this.c = r1;
        return r1;
    }

    public a() {
        this.b = 5000;
    }
}
