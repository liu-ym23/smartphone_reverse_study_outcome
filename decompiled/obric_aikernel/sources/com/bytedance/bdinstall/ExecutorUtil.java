package com.bytedance.bdinstall;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdinstall.util.Singleton;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class ExecutorUtil {
    private static final Singleton<Handler> HANDLER = null;
    private static final Singleton<ExecutorService> sDefaultIOExecutor = null;
    private static final Singleton<Looper> sDefaultLooper = null;
    private static final Singleton<Executor> sDefaultNetExecutor = null;
    private static Map<String, Handler> sHandlerMap;
    private static Map<String, ExecutorService> sIOExecutorMap;
    private static Map<String, Looper> sLooperMap;
    private static Map<String, Executor> sNetExecutorMap;

    static {
        sNetExecutorMap = new ConcurrentHashMap(4);
        sIOExecutorMap = new ConcurrentHashMap(4);
        sLooperMap = new ConcurrentHashMap(4);
        sHandlerMap = new ConcurrentHashMap(4);
        sDefaultNetExecutor = new AnonymousClass1();
        sDefaultIOExecutor = new AnonymousClass2();
        sDefaultLooper = new AnonymousClass3();
        HANDLER = new AnonymousClass4();
    }

    public ExecutorUtil() {
    }

    static /* synthetic */ Singleton access$000() {
        return sDefaultLooper;
    }

    public static Handler getFirstHandler() {
        return getHandler(getFirstItemKey(sHandlerMap));
    }

    private static String getFirstItemKey(Map r10) {
        if (r10 != null) goto L5;
    L13:
        return null;
    L5:
        if (r10.size() == 0) goto L13;
        Set r11 = r10.keySet();
        if (r11 == null) goto L13;
        if (r11.size() <= 0) goto L13;
        return (String) r11.iterator().next();
    }

    public static Handler getHandler(String r10) {
        if (r10 == null) goto L4;
        Handler r11 = sHandlerMap.get(r10);
        if (r11 != null) goto L12;
        Looper r12 = getLooper(r10);
        if (r12 == null) goto L10;
        Handler r13 = new Handler(r12);
        sHandlerMap.put(r10, r13);
        return r13;
    L10:
        DrLog.e("getLooper return null");
        return r11;
    L12:
        return r11;
    L4:
        return HANDLER.get(new Object[0]);
    }

    private static ExecutorService getIOExecutor(String r10) {
        if (r10 != null) goto L6;
        ExecutorService r11 = sDefaultIOExecutor.get(new Object[0]);
    L9:
        return r11;
    L6:
        ExecutorService r12 = sIOExecutorMap.get(r10);
        if (r12 != null) goto L10;
        r11 = sDefaultIOExecutor.get(new Object[0]);
        goto L9
    L10:
        return r12;
    }

    public static Looper getLooper(String r10) {
        if (r10 != null) goto L6;
        Looper r11 = sDefaultLooper.get(new Object[0]);
    L9:
        return r11;
    L6:
        Looper r12 = sLooperMap.get(r10);
        if (r12 != null) goto L10;
        r11 = sDefaultLooper.get(new Object[0]);
        goto L9
    L10:
        return r12;
    }

    private static Executor getNetExecutor(String r10) {
        if (r10 != null) goto L6;
        Executor r11 = sDefaultNetExecutor.get(new Object[0]);
    L9:
        return r11;
    L6:
        Executor r12 = sNetExecutorMap.get(r10);
        if (r12 != null) goto L10;
        r11 = sDefaultNetExecutor.get(new Object[0]);
        goto L9
    L10:
        return r12;
    }

    public static void runOnFirstHandlerThread(Runnable r10) {
        runOnHandlerThread(getFirstItemKey(sHandlerMap), r10);
    }

    public static void runOnHandlerThread(String r10, Runnable r11) {
        if (Looper.myLooper() != getLooper(r10)) goto L5;
        r11.run();
        return;
    L5:
        Handler r12 = getHandler(r10);
        if (r12 != null) goto L8;
        r12 = HANDLER.get(new Object[0]);
    L8:
        r12.post(r11);
    }

    public static void runOnIOExecutor(String r10, Runnable r11) {
        getIOExecutor(r10).execute(r11);
    }

    public static void runOnNetExecutor(String r10, Runnable r11) {
        getNetExecutor(r10).execute(r11);
    }

    static void setExecutor(String r10, ExecutorOptions r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        Executor r12 = r11.networkExecutor;
        if (r12 == null) goto L7;
        sNetExecutorMap.put(r10, r12);
    L7:
        ExecutorService r13 = r11.ioExecutor;
        if (r13 == null) goto L10;
        sIOExecutorMap.put(r10, r13);
    L10:
        Looper r14 = r11.workLooper;
        if (r14 == null) goto L14;
        sLooperMap.put(r10, r14);
        return;
    }

    public static <T> Future<T> submitToFirstIOExecutor(Callable<T> r10) {
        return submitToIOExecutor(getFirstItemKey(sIOExecutorMap), r10);
    }

    public static <T> Future<T> submitToIOExecutor(String r10, Callable<T> r11) {
        return getIOExecutor(r10).submit(r11);
    }
}
