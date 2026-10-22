package r91;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends com.bytedance.android.live.room.navi.userinfo_p.flipper.core.a {
    public Disposable b;
    public Disposable c;
    public Disposable d;
    public final DataCenter e;

    public static final class a {
    }

    /* JADX INFO: renamed from: r91.b$b, reason: collision with other inner class name */
    public static final class C0311b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0311b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            ALogger.d("DiggNextTabExecutor", "reset digg task");
            this.a.h();
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.g();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            String r2 = (String) r1;
            this.a.g();
            this.a.f();
        }
    }

    static {
    }

    public final void g() {
        Disposable r0 = this.b;
        Disposable r1 = null;
        if (r0 != null) goto L5;
    L10:
        Disposable r2 = this.c;
        if (r2 != null) goto L13;
    L18:
        Disposable r3 = this.d;
        if (r3 != null) goto L21;
        return;
    L21:
        if ((!r3.isDisposed()) == false) goto L23;
        r1 = r3;
    L23:
        if (r1 == null) goto L27;
        r1.dispose();
        return;
    L27:
        return;
    L13:
        if ((!r2.isDisposed()) == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L18;
        r2.dispose();
        goto L18
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.dispose();
        goto L10
    }

    public final void h() {
        ALogger.d("DiggNextTabExecutor", "start next tab task by digg");
        Disposable r0 = this.d;
        if (r0 != null) goto L5;
    L10:
        this.d = Observable.just("").delay(2000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this));
        return;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.dispose();
        goto L10
    }

    @Override // w91.a
    public final Disposable execute() {
        g();
        h();
        INavigationProxyService r0 = (INavigationProxyService) k.f(INavigationProxyService.class);
        if (r0 == null) goto L13;
        l81.d r1 = r0.getDiggContext(this.e);
        if (r1 == null) goto L13;
        m<Long> r2 = r1.a();
        if (r2 == null) goto L13;
        Observable r3 = r2.a();
        if (r3 == null) goto L13;
        Observable r4 = r3.compose(RxUtil.rxSchedulerHelper());
        if (r4 == null) goto L13;
        Disposable r5 = r4.subscribe(new C0311b(this));
    L14:
        this.c = r5;
        Disposable r6 = Disposables.fromAction(new c(this));
        this.b = r6;
        return r6;
    L13:
        r5 = null;
        goto L14
    }

    public b(DataCenter r1) {
        this.e = r1;
    }
}
