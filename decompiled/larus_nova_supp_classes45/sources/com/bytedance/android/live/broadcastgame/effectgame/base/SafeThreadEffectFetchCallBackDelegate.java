package com.bytedance.android.live.broadcastgame.effectgame.base;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class SafeThreadEffectFetchCallBackDelegate implements com.bytedance.android.live.broadcastgame.effectgame.base.a {
    public final Lazy a;
    public final com.bytedance.android.live.broadcastgame.effectgame.base.a b;

    public static final class a implements Runnable {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public SafeThreadEffectFetchCallBackDelegate(com.bytedance.android.live.broadcastgame.effectgame.base.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
        this.b = r2;
        this.a = LazyKt.lazy(SafeThreadEffectFetchCallBackDelegate$handler$2.INSTANCE);
    }

    public final void e(Function0<Unit> r3) {
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L5;
        ((Handler) this.a.getValue()).post(new a(r3));
        return;
    L5:
        r3.invoke();
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void c(final int r2, final Sticker r3) {
        Intrinsics.checkNotNullParameter(r3, "sticker");
        e(new SafeThreadEffectFetchCallBackDelegate$onStart$1(this, r2, r3));
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void d(final int r2, final Sticker r3, final ExceptionResult r4) {
        Intrinsics.checkNotNullParameter(r3, "sticker");
        e(new SafeThreadEffectFetchCallBackDelegate$onFail$1(this, r2, r3, r4));
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void a(final int r8, final boolean r9, final int r11, final Sticker r12) {
        Intrinsics.checkNotNullParameter(r12, "sticker");
        e(new SafeThreadEffectFetchCallBackDelegate$onSuccess$1(this, r8, r9, r11, r12));
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void b(final int r9, final int r11, final long r12, final Sticker r13) {
        Intrinsics.checkNotNullParameter(r13, "sticker");
        e(new SafeThreadEffectFetchCallBackDelegate$onProgress$1(this, r9, r11, r12, r13));
    }
}
