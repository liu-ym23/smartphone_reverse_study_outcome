package com.bytedance.android.live.broadcastgame.opengame.test;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.opengame.k;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.config.ad1;
import com.bytedance.android.livesdk.config.ge0;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements k {
    public d a;
    public WeakReference<Context> b;
    public WeakReference<ViewGroup> c;
    public final CompositeDisposable d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            c r0 = this.a;
            boolean r7 = ((Boolean) r6).booleanValue();
            if (r0.a != null) goto L17;
            WeakReference<Context> r2 = r0.b;
            if (r2 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("contextWeakRef");
        L7:
            Context r3 = r2.get();
            if (r3 == null) goto L32;
            WeakReference<ViewGroup> r4 = r0.c;
            if (r4 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("containerViewWeakRef");
        L13:
            ViewGroup r5 = r4.get();
            if (r5 == null) goto L33;
            r0.a = new d(r3, r5);
            goto L17
        L33:
            return;
        L32:
            return;
        L17:
            d r1 = r0.a;
            if (r1 == null) goto L31;
            if (r7 == true) goto L21;
        L23:
            if (r7 == false) goto L25;
            r1.setVisibility(0);
            r1.c();
            Disposable r8 = Observable.interval(((ad1) ge0.a.getValue()).c(), TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r1));
            r1.a = r8;
            Unit r9 = Unit.INSTANCE;
            Intrinsics.checkNotNullParameter(r8, "$this$autoDispose");
            r1.p.a(r8);
        L29:
            r1.getVisibility();
            return;
        L25:
            r1.setVisibility(8);
            Disposable r11 = r1.a;
            if (r11 == null) goto L28;
            r11.dispose();
        L28:
            r1.a = null;
            goto L29
        L21:
            if (r1.getVisibility() != 0) goto L23;
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.k
    public final void release() {
        d r0 = this.a;
        if (r0 == null) goto L8;
        Disposable r1 = r0.a;
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        r0.a = null;
        r0.p.b();
    L8:
        this.d.clear();
    }

    public c() {
        this.d = new CompositeDisposable();
    }

    public final void a(ViewGroup r2, Context r3) {
        this.b = new WeakReference(r3);
        this.c = new WeakReference(r2);
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r4 = AnchorGameContext.a.a();
        if (r4 == null) goto L12;
        m<Boolean> r5 = r4.getOpenGamePerfPanel();
        if (r5 == null) goto L13;
        Observable r6 = r5.a();
        if (r6 == null) goto L14;
        Disposable r7 = r6.subscribe(new a(this), b.a);
        if (r7 == null) goto L15;
        RxUtilKt.c(r7, this.d);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
