package com.bytedance.android.live.broadcastgame.opengame.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.opengame.h;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.live.datacontext.k;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenGameTestHelper implements h {
    public final Lazy a;
    public OpenGameTestFloatBall b;
    public View c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ OpenGameTestHelper a;

        public a(OpenGameTestHelper r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Integer r4 = (Integer) r3;
            OpenGameTestHelper r5 = this.a;
            View r0 = r5.c;
            if (r5.b != null) goto L22;
            if (r0 == null) goto L7;
            OpenGameTestFloatBall r1 = (OpenGameTestFloatBall) r0.findViewById(2131388361);
        L8:
            r5.b = r1;
            AnchorGameContext.Companion.getClass();
            AnchorGameContext r2 = AnchorGameContext.a.a();
            if (r2 == null) goto L18;
            k<Boolean> r6 = r2.getOpenGameTestFloatBall();
            if (r6 == null) goto L19;
            PublishSubject r7 = r6.onEvent();
            if (r7 == null) goto L20;
            Disposable r8 = r7.subscribe(new b(r5));
            if (r8 == null) goto L21;
            RxUtilKt.c(r8, (CompositeDisposable) r5.a.getValue());
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        L18:
            return;
        L7:
            r1 = null;
            goto L8
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.h
    public final void release() {
        ((CompositeDisposable) this.a.getValue()).clear();
        OpenGameTestFloatBall r0 = this.b;
        if (r0 == null) goto L6;
        r0.setGone();
        return;
    }

    public OpenGameTestHelper() {
        this.a = LazyKt.lazy(OpenGameTestHelper$compositeDisposable$2.INSTANCE);
    }

    public final void a(ViewGroup r2, Context r3) {
        if (r2 == null) goto L15;
        if (r3 == null) goto L20;
        this.c = LayoutInflater.from(r3).inflate(2131567115, r2);
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r4 = AnchorGameContext.a.a();
        if (r4 == null) goto L16;
        k<Integer> r5 = r4.getInitGameTestFloatBall();
        if (r5 == null) goto L17;
        PublishSubject r6 = r5.onEvent();
        if (r6 == null) goto L18;
        Disposable r7 = r6.subscribe(new a(this));
        if (r7 == null) goto L19;
        RxUtilKt.c(r7, (CompositeDisposable) this.a.getValue());
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L20:
        return;
    }
}
