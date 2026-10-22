package com.ss.android.ugc.bytex.pthread.base.convergence.core;

import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.executor.IThreadNameTransformer;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadWorker;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.ThreadLifecycleObserver;
import com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityProvider;
import com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityRunnable;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/ThreadWorker;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadWorker;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityRunnable;", "delegate", "Ljava/lang/Thread;", "skipSetPriority", "", "exitListener", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/IThreadExitListener;", EffectConfiguration.KEY_TYPE, "", "callback", "Lkotlin/Function1;", "", "(Ljava/lang/Thread;ZLcom/ss/android/ugc/bytex/pthread/base/convergence/core/IThreadExitListener;ILkotlin/jvm/functions/Function1;)V", "getDelegate", "priorityAffinity", "run", "setPriorityEnable", "enable", "Companion", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class ThreadWorker implements IThreadWorker, PriorityRunnable {
    private static final int ASSOCIATE_TYPE = 5;
    public static final Companion Companion = null;
    private final Function1<Thread, Unit> callback;
    private final Thread delegate;
    private final IThreadExitListener exitListener;
    private boolean skipSetPriority;
    private final int type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/ThreadWorker$Companion;", "", "()V", "ASSOCIATE_TYPE", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ThreadWorker(Thread r1, boolean r2, IThreadExitListener r3, int r4, Function1<? super Thread, Unit> r5) {
        this.delegate = r1;
        this.skipSetPriority = r2;
        this.exitListener = r3;
        this.type = r4;
        this.callback = r5;
    }

    public /* synthetic */ ThreadWorker(Thread r7, boolean r8, IThreadExitListener r9, int r10, Function1 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        boolean r2 = false;
    L6:
        this(r7, r2, r9, r10, r11);
        return;
    L5:
        r2 = r8;
        goto L6
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadWorker
    public Thread getDelegate() {
        return this.delegate;
    }

    public int priorityAffinity() {
        Thread r0 = this.delegate;
        if ((r0 instanceof PriorityProvider) == true) goto L5;
        r0 = null;
    L5:
        PriorityProvider r1 = (PriorityProvider) r0;
        if (r1 != null) goto L10;
        return 6;
    L10:
        return r1.priorityAffinity();
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread r0 = Thread.currentThread();
        if (r0 == null) goto L32;
        Thread r1 = (ICoreThread) r0;
    L28:
        th = move-exception;
        r1.resetThread();
        this.exitListener.onThreadExit();
        throw th;
    L6:
        if ((this.type & 5) <= 0) goto L8;
        r1.associateDelegateThread(this.delegate);     // Catch: Throwable -> L28
    L8:
        SuperThreadPool r2 = SuperThreadPool.INSTANCE;     // Catch: Throwable -> L28
        ThreadLifecycleObserver r3 = r2.getThreadLifecycleObserver();     // Catch: Throwable -> L28
        int r4 = this.delegate.getPriority();     // Catch: Throwable -> L28
        IThreadNameTransformer r5 = r2.getThreadNameTransformer();     // Catch: Throwable -> L28
        if (r5 == null) goto L13;
        String r6 = r5.transform(this.delegate.getName());     // Catch: Throwable -> L28
        if (r6 == null) goto L13;
    L14:
        r1.setName(r6);     // Catch: Throwable -> L28
        if (this.skipSetPriority == false) goto L17;
    L21:
        if (r3 == null) goto L23;
        r3.onAttach(r1, this.delegate);     // Catch: Throwable -> L28
    L23:
        this.callback.invoke(r1);     // Catch: Throwable -> L28
        if (r3 == null) goto L26;
        r3.onDetach(r1, this.delegate);     // Catch: Throwable -> L28
    L26:
        r1.resetThread();
        this.exitListener.onThreadExit();
        return;
    L17:
        if (r2.getEnablePriority() == false) goto L21;
        if (r1.getPriority() == r4) goto L21;
        r1.setPriority(r4);     // Catch: Throwable -> L28
    L13:
        r6 = this.delegate.getName();     // Catch: Throwable -> L28
        goto L14
    L32:
        throw new TypeCastException("null cannot be cast to non-null type com.ss.android.ugc.bytex.pthread.base.convergence.core.ICoreThread");
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadWorker
    public void setPriorityEnable(boolean r1) {
        this.skipSetPriority = !r1;
    }
}
