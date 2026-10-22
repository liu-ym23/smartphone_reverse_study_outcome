package com.bytedance.bdinstall;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdinstall.util.Singleton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    private static String getFirstItemKey(Map r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
    L13:
        return null;
    L5:
        if (r4.size() == 0) goto L13;
        Set r5 = r4.keySet();
        if (r5 == null) goto L13;
        if (r5.size() <= 0) goto L13;
        return (String) ZeusTransformUtils.preCheckCast(r5.iterator().next(), String.class, "com.obric.memorydata.plugin");
    }

    public static Handler getHandler(String r3) {
        if (r3 == null) goto L5;
        Handler r0 = (Handler) ZeusTransformUtils.preCheckCast(sHandlerMap.get(r3), Handler.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L13;
        Looper r1 = getLooper(r3);
        if (r1 == null) goto L11;
        Handler r2 = new Handler(r1);
        sHandlerMap.put(r3, r2);
        return r2;
    L11:
        DrLog.e("getLooper return null");
        return r0;
    L13:
        return r0;
    L5:
        return (Handler) ZeusTransformUtils.preCheckCast(HANDLER.get(new Object[0]), Handler.class, "com.obric.memorydata.plugin");
    }

    private static ExecutorService getIOExecutor(String r3) {
        if (r3 != null) goto L6;
        ExecutorService r4 = sDefaultIOExecutor.get(new Object[0]);
    L9:
        return (ExecutorService) ZeusTransformUtils.preCheckCast(r4, ExecutorService.class, "com.obric.memorydata.plugin");
    L6:
        ExecutorService r5 = (ExecutorService) ZeusTransformUtils.preCheckCast(sIOExecutorMap.get(r3), ExecutorService.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L10;
        r4 = sDefaultIOExecutor.get(new Object[0]);
        goto L9
    L10:
        return r5;
    }

    public static Looper getLooper(String r3) {
        if (r3 != null) goto L6;
        Looper r4 = sDefaultLooper.get(new Object[0]);
    L9:
        return (Looper) ZeusTransformUtils.preCheckCast(r4, Looper.class, "com.obric.memorydata.plugin");
    L6:
        Looper r5 = (Looper) ZeusTransformUtils.preCheckCast(sLooperMap.get(r3), Looper.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L10;
        r4 = sDefaultLooper.get(new Object[0]);
        goto L9
    L10:
        return r5;
    }

    private static Executor getNetExecutor(String r3) {
        if (r3 != null) goto L6;
        Executor r4 = sDefaultNetExecutor.get(new Object[0]);
    L9:
        return (Executor) ZeusTransformUtils.preCheckCast(r4, Executor.class, "com.obric.memorydata.plugin");
    L6:
        Executor r5 = (Executor) ZeusTransformUtils.preCheckCast(sNetExecutorMap.get(r3), Executor.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L10;
        r4 = sDefaultNetExecutor.get(new Object[0]);
        goto L9
    L10:
        return r5;
    }

    public static void runOnFirstHandlerThread(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        runOnHandlerThread(getFirstItemKey(sHandlerMap), r3);
    }

    public static void runOnHandlerThread(String r3, Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        if (Looper.myLooper() != getLooper(r3)) goto L5;
        r5.run();
        return;
    L5:
        Handler r6 = getHandler(r3);
        if (r6 != null) goto L8;
        r6 = (Handler) ZeusTransformUtils.preCheckCast(HANDLER.get(new Object[0]), Handler.class, "com.obric.memorydata.plugin");
    L8:
        r6.post(r5);
    }

    public static void runOnIOExecutor(String r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        getIOExecutor(r2).execute(r4);
    }

    public static void runOnNetExecutor(String r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        getNetExecutor(r2).execute(r4);
    }

    static void setExecutor(String r2, ExecutorOptions r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Executor r0 = r3.networkExecutor;
        if (r0 == null) goto L7;
        sNetExecutorMap.put(r2, r0);
    L7:
        ExecutorService r1 = r3.ioExecutor;
        if (r1 == null) goto L10;
        sIOExecutorMap.put(r2, r1);
    L10:
        Looper r4 = r3.workLooper;
        if (r4 == null) goto L14;
        sLooperMap.put(r2, r4);
        return;
    }

    public static <T> Future<T> submitToFirstIOExecutor(Callable<T> r2) {
        Callable r3 = (Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.memorydata.plugin");
        return submitToIOExecutor(getFirstItemKey(sIOExecutorMap), r3);
    }

    public static <T> Future<T> submitToIOExecutor(String r2, Callable<T> r3) {
        Callable<T> r4 = (Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.memorydata.plugin");
        return getIOExecutor(r2).submit(r4);
    }
}
