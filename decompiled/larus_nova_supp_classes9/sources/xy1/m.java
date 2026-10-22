package xy1;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.entity.RiskAdviseSyncData;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends com.bytedance.android.livesdk.user.h<IBaseUser> {
    public final /* synthetic */ n a;

    public m(n r1) {
        this.a = r1;
    }

    public final void onError(Throwable r3) {
        super.onError(r3);
        n r4 = this.a;
        n.b(r4, r4.r);
    }

    public final void onNext(Object r3) {
        IBaseUser r4 = (IBaseUser) r3;
        n.b(this.a, RiskAdviseSyncData.PRIORITY);
    }

    public final void onSubscribe(Disposable r2) {
        this.a.o = r2;
    }
}
