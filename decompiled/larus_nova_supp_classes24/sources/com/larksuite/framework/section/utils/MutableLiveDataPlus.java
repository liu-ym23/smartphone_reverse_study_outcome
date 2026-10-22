package com.larksuite.framework.section.utils;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u000fB\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0006J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00028\u0000H\u0007¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larksuite/framework/section/utils/MutableLiveDataPlus;", "T", "Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", "value", "(Ljava/lang/Object;)V", "NOT_SET", "", "mPendingData", "mPostValueRunnable", "Ljava/lang/Runnable;", "setValueIfChanged", "", "postValueIfChanged", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MutableLiveDataPlus<T> extends MutableLiveData<T> {
    public static final Lazy<Handler> d = null;
    public final Object a;
    public volatile Object b;
    public final b c;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MutableLiveDataPlus<T> a;

        public b(MutableLiveDataPlus<T> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MutableLiveDataPlus<T> r0 = this.a;     // Catch: Throwable -> L10
            Object r1 = r0.a;     // Catch: Throwable -> L10
            monitor-enter(r1);     // Catch: Throwable -> L10
            Object r2 = r0.b;     // Catch: Throwable -> L7
            r0.b = r0.a;     // Catch: Throwable -> L7
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L10
            this.a.b((T) r2);     // Catch: Throwable -> L10
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    static {
        d = LazyKt.lazy(MutableLiveDataPlus$Companion$uiHandler$2.INSTANCE);
    }

    public MutableLiveDataPlus() {
        Object r0 = new Object();
        this.a = r0;
        this.b = r0;
        this.c = new b(this);
    }

    public MutableLiveDataPlus(T r1) {
        super(r1);
        Object r2 = new Object();
        this.a = r2;
        this.b = r2;
        this.c = new b(this);
    }

    public final void a(T r4) {
        Object r0 = this.a;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.b != this.a) goto L7;
        boolean r1 = true;
    L8:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Any");     // Catch: Throwable -> L14
        this.b = r4;     // Catch: Throwable -> L14
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
        if (r1 == true) goto L12;
        return;
    L12:
        ((Handler) d.getValue()).post(this.c);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void b(T r2) {
        Object r0 = getValue();
        if (r0 != null) goto L5;
    L7:
        super.setValue(r2);
        return;
    L5:
        if (Intrinsics.areEqual(r0, r2) == false) goto L7;
    }
}
