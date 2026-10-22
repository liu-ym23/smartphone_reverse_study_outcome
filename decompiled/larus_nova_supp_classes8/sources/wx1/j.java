package wx1;

import com.bytedance.android.gamecp.host_api.model.user.IUser;
import com.bytedance.android.gamecp.host_api.model.user.User;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements SingleObserver<IUser> {
    public final /* synthetic */ g.b a;
    public final /* synthetic */ IUser b;

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onSuccess(Object r4) {
        IUser r5 = (IUser) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        PublishSubject<IUser> r0 = this.a.a.c;
        if (r0 == null) goto L5;
        r0.onNext(r5);
    L5:
        PublishSubject<IUser> r1 = this.a.a.c;
        if (r1 == null) goto L8;
        r1.onComplete();
    L8:
        this.a.a.c = null;
        hw.d r2 = new hw.d();
        r2.a = this.b;
        xr.f r3 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r3 == null) goto L11;
        r3.u(r2);
    L11:
        PublishProcessor<hw.c> r6 = this.a.a.d;
        IUser.Status r7 = IUser.Status.Login;
        r6.onNext(new hw.c(this.b));
        this.a.a.f(r5);
    }

    public j(g.b r1, User r2) {
        this.a = r1;
        this.b = r2;
    }
}
