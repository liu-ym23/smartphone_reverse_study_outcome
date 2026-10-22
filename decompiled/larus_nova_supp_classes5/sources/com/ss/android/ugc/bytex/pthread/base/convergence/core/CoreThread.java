package com.ss.android.ugc.bytex.pthread.base.convergence.core;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.convergence.helper.ThreadCleaner;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u00110\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/CoreThread;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/ICoreThread;", "group", "Ljava/lang/ThreadGroup;", "target", "Ljava/lang/Runnable;", DBDefinition.NAME, "", "stackSize", "", "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;J)V", "delegate", "Ljava/lang/Thread;", "originClassLoader", "Ljava/lang/ClassLoader;", "kotlin.jvm.PlatformType", "originUncaughtExceptionHandler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "associateDelegateThread", "", "getDelegateThread", "resetThread", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class CoreThread extends ICoreThread {
    private volatile Thread delegate;
    private ClassLoader originClassLoader;
    private Thread.UncaughtExceptionHandler originUncaughtExceptionHandler;

    /* JADX WARN: Multi-variable type inference failed */
    public CoreThread(ThreadGroup r1, Runnable r2, String r3, long r4) {
        super(r1, r2, r3, r4);
        this.originClassLoader = getContextClassLoader();
        this.originUncaughtExceptionHandler = getUncaughtExceptionHandler();
    }

    public void associateDelegateThread(Thread r1) {
        this.delegate = r1;
    }

    public Thread getDelegateThread() {
        return this.delegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void resetThread() {
        this.delegate = null;
        setContextClassLoader(this.originClassLoader);
        setUncaughtExceptionHandler(this.originUncaughtExceptionHandler);
        ThreadCleaner.INSTANCE.clearTls();
        if (isInterrupted() == false) goto L6;
        Thread.interrupted();
        return;
    }
}
