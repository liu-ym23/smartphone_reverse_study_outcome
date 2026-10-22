package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.sdk.refactor.observer.ExecuteType;
import com.bytedance.lark.sdk.refactor.state.StateUpdateType;
import com.ss.android.lark.log.Log;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class v implements te6.b {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ExecuteType.values().length];
            r0[ExecuteType.BEFORE_EXECUTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ExecuteType.EXECUTE_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ExecuteType.EXECUTE_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    @Inject
    public v() {
    }

    public final void onComplete() {
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onNext(Object r3) {
        te6.a r4 = (te6.a) r3;
        Intrinsics.checkNotNullParameter(r4, "t");
        if (r4.a != StateUpdateType.INIT_SDK) goto L18;
        ExecuteType r5 = r4.b;
        int r6 = a.a[r5.ordinal()];
        if (r6 != 1) goto L8;
        Log.d("RustSDK", "InitRustObserver onNext ExecuteMethodEvent = BEFORE_EXECUTE");
        com.ss.android.lark.sdk.i.c.a();
        return;
    L8:
        if (r6 != 2) goto L10;
    L14:
        Log.d("RustSDK", "InitRustObserver onNext ExecuteMethodEvent = EXECUTE_FINISH");
        com.ss.android.lark.sdk.i.c.b();
        return;
    L10:
        if (r6 == 3) goto L14;
        throw new NoWhenBranchMatchedException();
    }
}
