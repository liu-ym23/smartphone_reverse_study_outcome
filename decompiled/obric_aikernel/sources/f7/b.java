package f7;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8870a = null;

    static {
        f8870a = new b();
    }

    private b() {
    }

    private final void b(IBinder r10, Bundle r11) {
        Parcel r12 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(r12, "obtain()");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L5
        r12.writeParcelable(r11, 0);     // Catch: Throwable -> L5
        Object r14 = Result.m32constructorimpl(Boolean.valueOf(r10.transact(1001, r12, null, 1)));     // Catch: Throwable -> L5
    L7:
        Throwable r15 = Result.m35exceptionOrNullimpl(r14);
        if (r15 == null) goto L10;
        AIKLog.INSTANCE.e("TransactHandle", "postEvent err: " + r15);
    L10:
        r12.recycle();
        return;
    L5:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void a(IBinder r10, RequestParams r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "binder");
        Intrinsics.checkNotNullParameter(r11, "params");
        r11.setTargetComponent(2);
        r11.setEvent(r12);
        b(r10, r11.start());
    }
}
