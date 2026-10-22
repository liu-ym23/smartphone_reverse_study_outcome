package wx1;

import com.bytedance.android.gamecp.host_api.model.user.IUser;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements SingleObserver<IUser> {
    public final /* synthetic */ g.a a;

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public f(g.a r1) {
        this.a = r1;
    }

    public final void onSuccess(Object r2) {
        IUser r3 = (IUser) r2;
        Intrinsics.checkNotNullParameter(r3, "iUser");
        this.a.a.f(r3);
    }
}
