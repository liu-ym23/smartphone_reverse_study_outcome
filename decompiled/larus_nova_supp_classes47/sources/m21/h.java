package m21;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends q46.b<Object> {
    public final CompositeDisposable b;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            BaseResponse r3 = (BaseResponse) r2;
            Intrinsics.checkNotNullParameter(r3, "response");
            return (IBaseUser) r3.data;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Function1 r0 = this.a;
            r0.invoke((IBaseUser) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public final void detachView() {
        ((q46.b) this).a = null;
        this.b.clear();
    }

    public h() {
        this.b = new CompositeDisposable();
    }

    public final void c0(String r2, Function1<? super IBaseUser, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onSuccess");
        com.bytedance.android.livesdk.revenue.service.user.a r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        Single r4 = r0.r(r2);
        if (r4 == null) goto L17;
        Single r5 = r4.map(a.a);
        if (r5 == null) goto L18;
        Single r6 = r5.subscribeOn(Schedulers.io());
        if (r6 == null) goto L19;
        Single r7 = r6.observeOn(AndroidSchedulers.mainThread());
        if (r7 == null) goto L20;
        Disposable r8 = r7.subscribe(new b(r3), c.a);
        if (r8 == null) goto L21;
        RxUtilKt.c(r8, this.b);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }
}
