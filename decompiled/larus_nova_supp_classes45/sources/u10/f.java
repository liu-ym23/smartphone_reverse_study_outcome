package u10;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements ObservableOnSubscribe {
    public final /* synthetic */ LiveCall a;

    public f(c r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<HttpResponse> r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r3.onNext((HttpResponse) this.a.execute());     // Catch: Exception -> L5
    L10:
        r3.onComplete();
        return;
    L5:
        e = move-exception;
        if (r3.isDisposed() == true) goto L9;
        r3.onError(e);
        goto L10
    L9:
        ALogger.d("OpenNetworkExecutor", e.getMessage());
        goto L10
    }
}
