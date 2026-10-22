package com.bytedance.android.live.revlink.link.utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.revenue.platform.api.core.rx.h;
import com.bytedance.revenue.platform.api.core.rx.p;
import d51.c;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class UtilsKt {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        public final void accept(T r1) {
            this.a.invoke();
        }
    }

    public static final <T> Observable<T> a(Observable<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$defaultNetworkSchedule");
        int r0 = p.a;
        return r1.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public static final <T> T b(List<? extends T> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$getOrNull");
        if (r2 >= 0) goto L5;
        return null;
    L5:
        if (r2 < r1.size()) goto L8;
        return null;
    L8:
        return (T) ListProtector.get(r1, r2);
    }

    public static final Disposable c(final NextLiveData r4, final Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$observer");
        Intrinsics.checkNotNullParameter(r5, "onChange");
        final Observer r0 = new UtilsKt$observer$observer$1(r5);
        r4.observeForever(r0);
        c r6 = c.A0;
        r6.getClass();
        if (((Boolean) c.p0.getValue(r6, c.a[66])).booleanValue() == false) goto L7;
        Object r7 = r4.getValue();
        if (r7 == null) goto L7;
        r0.onChanged(r7);
    L7:
        int r8 = h.a;
        return h.a(new UtilsKt$observer$1(r4, r0));
    }

    public static final <T> Disposable d(final LiveData<T> r1, final Function1<? super T, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribe");
        Intrinsics.checkNotNullParameter(r2, "onChange");
        final com.ss.android.ugc.aweme.compat.nullable.Observer<T> r0 = new UtilsKt$subscribe$observer$2(r2);
        r1.observeForever(r0);
        int r3 = h.a;
        return h.a(new UtilsKt$subscribe$2(r1, r0));
    }

    public static final <T> Disposable f(final LiveData<T> r1, final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribeUnit");
        Intrinsics.checkNotNullParameter(r2, "onChange");
        final com.ss.android.ugc.aweme.compat.nullable.Observer<T> r0 = new UtilsKt$subscribeUnit$observer$1(r2);
        r1.observeForever(r0);
        int r3 = h.a;
        return h.a(new UtilsKt$subscribeUnit$2(r1, r0));
    }

    public static final <T> Disposable g(PublishSubject<T> r1, Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribeUnit");
        Intrinsics.checkNotNullParameter(r2, "onChange");
        return r1.subscribe(new a(r2));
    }

    public static Disposable h(NextLiveData r1, final Function0 r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribeUnit");
        Intrinsics.checkNotNullParameter(r2, "onChange");
        return e(r1, false, new UtilsKt$subscribeUnit$1(r2));
    }

    public static final <T> Disposable i(NextLiveData<T> r1, Function1<? super T, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribeWithNotify");
        Intrinsics.checkNotNullParameter(r2, "onChange");
        return c(r1, r2);
    }

    public static final <T> Disposable j(NextLiveData<T> r1, final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribeWithNotifyUnit");
        Intrinsics.checkNotNullParameter(r2, "onChange");
        return c(r1, new UtilsKt$subscribeWithNotifyUnit$1(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Disposable e(final MutableLiveData<T> r1, boolean r2, final Function1<? super T, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribe");
        Intrinsics.checkNotNullParameter(r3, "onChange");
        final com.ss.android.ugc.aweme.compat.nullable.Observer<T> r0 = new UtilsKt$subscribe$observer$1(r3);
        r1.observeForever(r0);
        if (r2 == false) goto L7;
        Object r4 = r1.getValue();
        if (r4 == null) goto L7;
        r0.onChanged(r4);
    L7:
        int r5 = h.a;
        return h.a(new UtilsKt$subscribe$1(r1, r0));
    }
}
