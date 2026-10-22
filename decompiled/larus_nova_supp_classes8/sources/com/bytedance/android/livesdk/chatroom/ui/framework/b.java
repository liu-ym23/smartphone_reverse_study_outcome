package com.bytedance.android.livesdk.chatroom.ui.framework;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ LoadState b;
        public final /* synthetic */ Function0 c;

        public a(Ref.BooleanRef r1, LoadState r2, Function0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r2) {
            LoadState r3 = (LoadState) r2;
            if (this.a.element == false) goto L5;
            return;
        L5:
            if (r3.getValue() < this.b.getValue()) goto L9;
            this.a.element = true;
            this.c.invoke();
            return;
        }
    }

    public static final Disposable a(com.bytedance.android.live.core.arch.mvvm.d<LoadState> r1, Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$runWithP0Begin");
        Intrinsics.checkNotNullParameter(r2, "callback");
        return g(r1, LoadState.P0_BEGIN, r2);
    }

    public static final Disposable b(com.bytedance.android.live.core.arch.mvvm.d<LoadState> r1, Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$runWithP0Loaded");
        Intrinsics.checkNotNullParameter(r2, "callback");
        return g(r1, LoadState.P0_END, r2);
    }

    public static final Disposable c(com.bytedance.android.live.core.arch.mvvm.d<LoadState> r1, Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$runWithP1Begin");
        Intrinsics.checkNotNullParameter(r2, "callback");
        return g(r1, LoadState.P1_BEGIN, r2);
    }

    public static final Disposable d(com.bytedance.android.live.core.arch.mvvm.d<LoadState> r1, Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$runWithP2Begin");
        Intrinsics.checkNotNullParameter(r2, "callback");
        return g(r1, LoadState.P2_BEGIN, r2);
    }

    public static final Disposable e(com.bytedance.android.live.core.arch.mvvm.d<LoadState> r1, Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$runWithP3Begin");
        Intrinsics.checkNotNullParameter(r2, "callback");
        return g(r1, LoadState.P3_BEGIN, r2);
    }

    public static final Disposable f(com.bytedance.android.live.core.arch.mvvm.d<LoadState> r1, Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$runWithP3Loaded");
        Intrinsics.checkNotNullParameter(r2, "callback");
        return g(r1, LoadState.P3_END, r2);
    }

    public static final Disposable g(com.bytedance.android.live.core.arch.mvvm.d<LoadState> r2, LoadState r3, Function0<Unit> r4) {
        if (((LoadState) r2.getValue()).getValue() < r3.getValue()) goto L6;
        r4.invoke();
        return null;
    L6:
        Ref.BooleanRef r0 = new Ref.BooleanRef();
        r0.element = false;
        return r2.subscribe(new a(r0, r3, r4));
    }
}
