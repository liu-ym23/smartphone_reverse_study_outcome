package com.bytedance.android.live.core.utils.rxutils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.utils.rxutils.rxlifecycle.LifecycleEvent;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.internal.util.ExceptionHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class RxUtil {
    static final Scheduler LIVE_MAIN_THREAD_P5_SCHEDULER = null;
    public static final Object __ = null;
    private static Consumer<Object> noOp;
    private static Consumer<Throwable> noOpThrowable;

    public static /* synthetic */ ObservableSource a(Observable r0) {
        return lambda$bindUntilEvent$2(r0);
    }

    public static /* synthetic */ void b(Throwable r0) {
        lambda$static$0(r0);
    }

    public static /* synthetic */ void c(Object r0) {
        lambda$static$1(r0);
    }

    private static /* synthetic */ ObservableSource lambda$bindUntilEvent$2(Observable r0) {
        return r0;
    }

    private static /* synthetic */ void lambda$static$1(Object r0) throws Exception {
    }

    static {
        LIVE_MAIN_THREAD_P5_SCHEDULER = new q80.b(new Handler(Looper.getMainLooper()));
        noOpThrowable = new p();
        noOp = new q();
        __ = new Object();
    }

    public static <T> IoToUiTransformer<T> rxSchedulerHelper() {
        return new IoToUiTransformer();
    }

    private RxUtil() {
    }

    public static Scheduler getLiveMainThreadP4Scheduler() {
        return i.a;
    }

    public static Scheduler getLiveMainThreadP5Scheduler() {
        return LIVE_MAIN_THREAD_P5_SCHEDULER;
    }

    public static Consumer<Object> getNoOp() {
        return noOp;
    }

    public static Consumer<Throwable> getNoOpThrowable() {
        return noOpThrowable;
    }

    public static <T> ObservableTransformer<T, T> bindUntilDestroy(Activity r1) {
        return bindUntilEvent(r1, LifecycleEvent.DESTROY);
    }

    private static /* synthetic */ void lambda$static$0(Throwable r2) throws Exception {
        LocalTestManager.a(new Class[]{wy.a.class});
    }

    public static void run(Action r0) {
        r0.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static l rxRetryHelper(int r2) {
        return rxRetryHelper(r2, 500);
    }

    public static <T> ObservableTransformer<T, T> bindUntilDestroy(Fragment r1) {
        return bindUntilEvent(r1, LifecycleEvent.DESTROY);
    }

    public static <T> void accept(Consumer<T> r0, T r1) {
        r0.accept(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static <T, R> R apply(Function<T, R> r0, T r1) {
        return (R) r0.apply(r1);
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static <T> ObservableTransformer<T, T> bindUntilEvent(Activity r1, LifecycleEvent r2) {
        if ((r1 instanceof AppCompatActivity) == false) goto L11;
        o80.a<LifecycleEvent> r3 = o80.a.a(((AppCompatActivity) r1).getSupportFragmentManager());
        if (r2 == null) goto L9;
        return new p80.b(r3.a, r2);
    L9:
        throw new NullPointerException("event == null");
    L11:
        return new o();
    }

    public static l rxRetryHelper(int r1, long r2) {
        return new l(r1, r2);
    }

    public static <T> ObservableTransformer<T, T> bindUntilEvent(Fragment r1, LifecycleEvent r2) {
        o80.a<LifecycleEvent> r3 = o80.a.a(r1.getChildFragmentManager());
        if (r2 == null) goto L7;
        return new p80.b(r3.a, r2);
    L7:
        throw new NullPointerException("event == null");
    }

    public static <T, U, R> R apply(BiFunction<T, U, R> r0, T r1, U r2) {
        return (R) r0.apply(r1, r2);
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static <T1, T2, T3, R> R apply(Function3<T1, T2, T3, R> r0, T1 r1, T2 r2, T3 r3) {
        return (R) r0.apply(r1, r2, r3);
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static <T1, T2, T3, T4, R> R apply(Function4<T1, T2, T3, T4, R> r0, T1 r1, T2 r2, T3 r3, T4 r4) {
        return (R) r0.apply(r1, r2, r3, r4);
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }
}
