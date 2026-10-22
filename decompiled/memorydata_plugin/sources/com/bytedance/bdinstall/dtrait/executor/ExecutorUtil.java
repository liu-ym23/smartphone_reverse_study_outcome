package com.bytedance.bdinstall.dtrait.executor;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdinstall.dtrait.Singleton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class ExecutorUtil {
    private static final int CORE_THREAD = 0;
    private static final Singleton<Handler> HANDLER = null;
    private static final Singleton<ExecutorService> sDefaultDtraitExecutor = null;
    private static final Singleton<ExecutorService> sDefaultDtraitLoaderExecutor = null;
    private static final Singleton<ExecutorService> sDefaultIOExecutor = null;
    private static final Singleton<Looper> sDefaultLooper = null;
    private static final Singleton<Executor> sDefaultNetExecutor = null;
    private static ExecutorService sDtraitExecutor;
    private static ExecutorService sDtraitLoaderExecutor;
    private static ExecutorService sIoExecutor;
    private static Executor sNetworkExecutor;
    private static Looper sWorkLooper;

    static {
        CORE_THREAD = Runtime.getRuntime().availableProcessors();
        sDefaultNetExecutor = new AnonymousClass1();
        sDefaultIOExecutor = new AnonymousClass2();
        sDefaultDtraitExecutor = new AnonymousClass3();
        sDefaultDtraitLoaderExecutor = new AnonymousClass4();
        sDefaultLooper = new AnonymousClass5();
        HANDLER = new AnonymousClass6();
    }

    public ExecutorUtil() {
    }

    static /* synthetic */ int access$000() {
        return CORE_THREAD;
    }

    static /* synthetic */ Singleton access$100() {
        return sDefaultLooper;
    }

    private static ExecutorService getDtraitExecutor() {
        ExecutorService r0 = sDtraitExecutor;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (ExecutorService) ZeusTransformUtils.preCheckCast(sDefaultDtraitExecutor.get(new Object[0]), ExecutorService.class, "com.obric.memorydata.plugin");
    }

    public static ExecutorService getDtraitLoaderExecutor() {
        ExecutorService r0 = sDtraitLoaderExecutor;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (ExecutorService) ZeusTransformUtils.preCheckCast(sDefaultDtraitLoaderExecutor.get(new Object[0]), ExecutorService.class, "com.obric.memorydata.plugin");
    }

    public static Handler getHandler() {
        return (Handler) ZeusTransformUtils.preCheckCast(HANDLER.get(new Object[0]), Handler.class, "com.obric.memorydata.plugin");
    }

    public static ExecutorService getIOExecutor() {
        ExecutorService r0 = sIoExecutor;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (ExecutorService) ZeusTransformUtils.preCheckCast(sDefaultIOExecutor.get(new Object[0]), ExecutorService.class, "com.obric.memorydata.plugin");
    }

    public static Looper getLooper() {
        Looper r0 = sWorkLooper;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (Looper) ZeusTransformUtils.preCheckCast(sDefaultLooper.get(new Object[0]), Looper.class, "com.obric.memorydata.plugin");
    }

    public static Executor getNetExecutor() {
        Executor r0 = sNetworkExecutor;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (Executor) ZeusTransformUtils.preCheckCast(sDefaultNetExecutor.get(new Object[0]), Executor.class, "com.obric.memorydata.plugin");
    }

    public static void runHandlerPostDelayed(Runnable r2, long r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        getHandler().postDelayed(r4, r3);
    }

    public static void runOnHandlerThread(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        getHandler().post(r3);
    }

    public static void runOnIOExecutor(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        getIOExecutor().execute(r3);
    }

    public static void runOnNetExecutor(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        getNetExecutor().execute(r3);
    }

    public static void setExecutor(ExecutorOptions r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.networkExecutor == null) goto L8;
        sNetworkExecutor = r1.networkExecutor;
    L8:
        if (r1.ioExecutor == null) goto L11;
        sIoExecutor = r1.ioExecutor;
    L11:
        if (r1.workLooper == null) goto L14;
        sWorkLooper = r1.workLooper;
    L14:
        if (r1.sDtraitExecutor == null) goto L17;
        sDtraitExecutor = r1.sDtraitExecutor;
    L17:
        if (r1.sDtraitLoaderExecutor == null) goto L20;
        sDtraitLoaderExecutor = r1.sDtraitLoaderExecutor;
        return;
    }

    public static void shutdown() {
        ((ExecutorService) ZeusTransformUtils.preCheckCast(sDefaultIOExecutor.get(new Object[0]), ExecutorService.class, "com.obric.memorydata.plugin")).shutdown();
    }

    public static <T> Future<T> submitToDtraitExecutor(Callable<T> r2) {
        Callable<T> r3 = (Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.memorydata.plugin");
        return getDtraitExecutor().submit(r3);
    }

    public static <T> Future<T> submitToIOExecutor(Callable<T> r2) {
        Callable<T> r3 = (Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.memorydata.plugin");
        return getIOExecutor().submit(r3);
    }
}
