package c;

import com.zte.miboard.cards.express.data.SimpleResultBean;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes.dex */
public final class k implements mt.u {
    @Override // mt.u
    public final void onComplete() {
        m.i("ExpressNetwork", "getExpressVerifyCode onCompleted: ");
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        m.i("ExpressNetwork", "getExpressVerifyCode onError: " + r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        m.i("ExpressNetwork", "getExpressVerifyCode res: " + ((SimpleResultBean) r5).getResult());
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
    }
}
