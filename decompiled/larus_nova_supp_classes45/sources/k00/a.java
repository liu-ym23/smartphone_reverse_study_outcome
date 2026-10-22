package k00;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcast.api.model.l1;
import com.google.gson.Gson;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements ObservableOnSubscribe {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final void subscribe(ObservableEmitter<l1> r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Gson r1 = GsonHelper.get();     // Catch: Throwable -> L5
        com.bytedance.android.livesdk.sharedpref.e<String> r2 = e.a;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl((l1) r1.fromJson((String) e.a.getValue(), l1.class));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = null;
    L10:
        l1 r5 = (l1) r3;
        if (r5 == null) goto L13;
        r4.onNext(r5);
        r4.onComplete();
        return;
    L13:
        com.bytedance.android.livesdk.sharedpref.e<String> r6 = e.a;
        r4.onComplete();
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
