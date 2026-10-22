package ey0;

import com.bytedance.live.datacontext.h;
import com.bytedance.live.datacontext.i;
import io.reactivex.disposables.Disposable;
import io.reactivex.k;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements k<Object> {
    public final /* synthetic */ Continuation a;
    public final /* synthetic */ h b;

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onComplete() {
        Continuation r0 = this.a;
        CancellationException r1 = new CancellationException("DataContext is cleared");
        Result.Companion r2 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(r1)));
    }

    public final void onError(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        Continuation r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(r3)));
    }

    public final void onSuccess(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
        b.a(this.a, r2);
    }

    public d(SafeContinuation r1, i r2) {
        this.a = r1;
        this.b = r2;
    }
}
