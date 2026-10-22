package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.sdk.refactor.observer.ExecuteType;
import com.bytedance.lark.sdk.refactor.state.StateUpdateType;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class w implements te6.b {
    public final c3c.d.b a;

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

    public final void onComplete() {
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    @Inject
    public w(c3c.d.b r2) {
        Intrinsics.checkNotNullParameter(r2, "perfBoostDispatcher");
        this.a = r2;
    }

    public final void onError(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        String r4 = "RustSdk make online failed error :+" + r3.getMessage();
        c3c.d.b r0 = this.a;
        new ErrorResult(r4);
        r0.onError();
    }

    public final void onNext(Object r3) {
        te6.a r4 = (te6.a) r3;
        Intrinsics.checkNotNullParameter(r4, "t");
        if (r4.a != StateUpdateType.MAKE_ONLINE) goto L19;
        ExecuteType r5 = r4.b;
        int r6 = a.a[r5.ordinal()];
        if (r6 != 1) goto L8;
        Log.d("RustSDK", "MakeOnlineObserver onNext BEFORE_EXECUTE");
        this.a.d();
        return;
    L8:
        if (r6 != 2) goto L10;
        Log.d("RustSDK", "MakeOnlineObserver onNext EXECUTE_SUCCESS");
        this.a.c();
        return;
    L10:
        if (r6 != 3) goto L13;
        Log.d("RustSDK", "MakeOnlineObserver onNext EXECUTE_FAILED");
        c3c.d.b r7 = this.a;
        new ErrorResult("RustSdk make online failed");
        r7.onError();
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
