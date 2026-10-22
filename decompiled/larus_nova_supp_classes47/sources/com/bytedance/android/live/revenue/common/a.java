package com.bytedance.android.live.revenue.common;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.android.livesdk.revenue.sti.IRevIconModel;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a<S> implements IRevIconModel<S>, xr2.c<S> {
    public int a;
    public int b;
    public final S c;
    public final int d;
    public final C0082a<S> e;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.common.a$a, reason: collision with other inner class name */
    public static final class C0082a<S> implements xr2.c<S> {
        public xr2.c<S> a;

        public C0082a() {
        }

        public final void activateIcon() {
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L5:
            r0.activateIcon();
        }

        public final void changeTempWidth() {
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L5:
            r0.changeTempWidth();
        }

        public Context getContext() {
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L6:
            return r0.getContext();
        }

        public final Observable<Long> getCountDownObservable() {
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L6:
            return r0.getCountDownObservable();
        }

        public final Long getCountDownSec() {
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L6:
            return r0.getCountDownSec();
        }

        public final S getCurrentState() {
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L6:
            return (S) r0.getCurrentState();
        }

        public final xr2.h getCurrentView() {
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L6:
            return r0.getCurrentView();
        }

        public final void showNormalState() {
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L5:
            r0.showNormalState();
        }

        public final boolean bindModel(Disposable r3) {
            Intrinsics.checkNotNullParameter(r3, "$this$bindModel");
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L6:
            return r0.bindModel(r3);
        }

        public final boolean bindState(Disposable r3) {
            Intrinsics.checkNotNullParameter(r3, "$this$bindState");
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L6:
            return r0.bindState(r3);
        }

        public final <T extends xr2.h> T createIconTemplate(Class<T> r3) {
            Intrinsics.checkNotNullParameter(r3, "templateClass");
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L6:
            return (T) r0.createIconTemplate(r3);
        }

        public final void f(String r3) {
            Intrinsics.checkNotNullParameter(r3, "txt");
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L5:
            r0.f(r3);
        }

        public final long getTempShowTime(int r3) {
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L6:
            return r0.getTempShowTime(r3);
        }

        public final IRevIconModel.a inflateEntryView(int r3) {
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L6:
            return r0.inflateEntryView(r3);
        }

        public final void moveToState(S r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L5:
            r0.moveToState(r3);
        }

        public final int registerShowTempState(int r3, long r4) {
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L6:
            return r0.registerShowTempState(r3, r4);
        }

        public final ImageView imageViewOf(int r3, float r4, float r5) {
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L6:
            return r0.imageViewOf(r3, r4, r5);
        }

        public final void startCountDown(long r7, S r9, Long r10, Function1<? super Long, String> r12) {
            xr2.c<S> r0 = this.a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("inst");
        L5:
            r0.startCountDown(r7, r9, r10, r12);
        }
    }

    public final void activateIcon() {
        this.e.activateIcon();
    }

    public final boolean bindModel(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$bindModel");
        return this.e.bindModel(r2);
    }

    public final boolean bindState(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$bindState");
        return this.e.bindState(r2);
    }

    public final void changeTempWidth() {
        this.e.changeTempWidth();
    }

    public final <T extends xr2.h> T createIconTemplate(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "templateClass");
        return (T) this.e.createIconTemplate(r2);
    }

    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "txt");
        this.e.f(r2);
    }

    public abstract void g();

    public Context getContext() {
        return this.e.getContext();
    }

    public final Observable<Long> getCountDownObservable() {
        return this.e.getCountDownObservable();
    }

    public final Long getCountDownSec() {
        return this.e.getCountDownSec();
    }

    public final S getCurrentState() {
        return this.e.getCurrentState();
    }

    public final xr2.h getCurrentView() {
        return this.e.getCurrentView();
    }

    public final long getTempShowTime(int r3) {
        return this.e.getTempShowTime(r3);
    }

    @Deprecated(message = "计划删除，请勿新增使用")
    public final ImageView imageViewOf(int r2, float r3, float r4) {
        return this.e.imageViewOf(r2, r3, r4);
    }

    public final IRevIconModel.a inflateEntryView(int r2) {
        return this.e.inflateEntryView(r2);
    }

    public final void moveToState(S r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.e.moveToState(r2);
    }

    public void onAppear() {
    }

    public void onDestroy() {
    }

    public void onHideTempState() {
    }

    public void onShowTempState(int r1) {
    }

    public final int registerShowTempState(int r2, long r3) {
        return this.e.registerShowTempState(r2, r3);
    }

    public final void showNormalState() {
        this.e.showNormalState();
    }

    public final void startCountDown(long r7, S r9, Long r10, Function1<? super Long, String> r12) {
        this.e.startCountDown(r7, r9, r10, r12);
    }

    public final int getIconHeight() {
        return this.b;
    }

    public final int getIconWidth() {
        return this.a;
    }

    public final S getInitialState() {
        return this.c;
    }

    public final int getTypeId() {
        return this.d;
    }

    public final void d(com.bytedance.android.livesdk.revenue.service.sti.d r3) {
        Intrinsics.checkNotNullParameter(r3, "service");
        C0082a<S> r0 = this.e;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "serviceInstance");
        r0.a = r3;
        g();
    }

    public final void setIconHeight(int r1) {
        this.b = r1;
    }

    public final void setIconWidth(int r1) {
        this.a = r1;
    }

    public a(S r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "initialState");
        C0082a<S> r0 = new C0082a();
        this.c = r2;
        this.d = r3;
        this.e = r0;
        int r4 = (int) i.a(36.0f);
        this.a = r4;
        this.b = r4;
    }

    public void a(IRevIconModel.a r3, IRevIconModel.EntryEvent r4) {
        Intrinsics.checkNotNullParameter(r3, "entryView");
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r3, "entryView");
        Intrinsics.checkNotNullParameter(r4, "event");
    }
}
