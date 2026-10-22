package com.obric.sva.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ThreadUtil {

    public static class WorkHandlerHolder {
        public static Handler INSTANCE;
        public static Handler MD_INSTANCE;

        private static Handler getHandler() {
            PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("Work-thread");
            ThreadMethodProxy.start(r0);
            return new Handler(r0.getLooper());
        }

        private static Handler getMDHandler() {
            PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("MD-Work-thread");
            ThreadMethodProxy.start(r0);
            return new Handler(r0.getLooper());
        }

        static {
            INSTANCE = getHandler();
            MD_INSTANCE = getMDHandler();
        }

        private WorkHandlerHolder() {
        }
    }

    public ThreadUtil() {
    }

    public static Handler getMDWorkHandler() {
        return WorkHandlerHolder.MD_INSTANCE;
    }

    public static Handler getUiThreadHandler() {
        return HandlerHolder.sInstance;
    }

    public static Handler getWorkHandler() {
        return WorkHandlerHolder.INSTANCE;
    }

    public static void checkAndRunOnUiThread(Runnable r2) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r2.run();
        return;
    L5:
        postOnUiThread(r2);
    }

    public static void postOnUiThread(Runnable r1) {
        getUiThreadHandler().post(r1);
    }

    public static void postOnWorkThread(Runnable r1) {
        getWorkHandler().post(r1);
    }

    public static void removeCallbacksOnWorkThread(Runnable r1) {
        getWorkHandler().removeCallbacks(r1);
    }

    public static void postDelayedOnUiThread(Runnable r1, long r2) {
        getUiThreadHandler().postDelayed(r1, r2);
    }

    public static void postDelayedOnWorkThread(Runnable r1, long r2) {
        getWorkHandler().postDelayed(r1, r2);
    }
}
