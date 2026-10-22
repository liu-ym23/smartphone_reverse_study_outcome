package z00;

import com.bytedance.android.live.broadcast.api.model.g1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.common.utility.Logger;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements Observer<g1> {
    public final /* synthetic */ k a;

    public final void onComplete() {
    }

    public j(k r1) {
        this.a = r1;
    }

    public final void onError(Throwable r2) {
        Logger.e("LiveDefaultCoverController", r2.toString());
    }

    public final void onNext(Object r5) {
        g1 r6 = (g1) r5;
        k r0 = this.a;
        r0.getClass();
        if (r6 == null) goto L17;
    L10:
        e = move-exception;
        Logger.e("LiveDefaultCoverController", e.toString());
        return;
    L6:
        if (((Boolean) ((BaseResponse) r6).data).booleanValue() != true) goto L8;
        Logger.d("LiveDefaultCoverController", "update room cover info");     // Catch: Exception -> L10
        u.l().sendLog("livesdk_cover_pass_audit", r0.m(), new Object[0]);     // Catch: Exception -> L10
    L13:
        return;
    L8:
        Logger.e("LiveDefaultCoverController", r6.toString());     // Catch: Exception -> L10
        goto L13
    }

    public final void onSubscribe(Disposable r2) {
        this.a.e.add(r2);
    }
}
