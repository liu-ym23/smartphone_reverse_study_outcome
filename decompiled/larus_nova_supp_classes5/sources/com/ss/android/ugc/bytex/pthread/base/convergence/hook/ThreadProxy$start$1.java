package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "currentThread", "Ljava/lang/Thread;", "invoke"}, k = 3, mv = {1, 1, 13})
public final class ThreadProxy$start$1 extends Lambda implements Function1<Thread, Unit> {
    final /* synthetic */ ThreadProxy this$0;

    public ThreadProxy$start$1(ThreadProxy r1) {
        this.this$0 = r1;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Thread) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Thread r3) {
        ThreadProxy.access$getMRunState$p(this.this$0).set(2);
        ThreadProxy.access$checkAttachThread(this.this$0, r3);
        ThreadProxy.access$setMAttachThread$p(this.this$0, r3);
        Runnable r4 = ThreadProxy.access$getMDelegate$p(this.this$0);
        if ((ThreadProxy.access$getMThreadType$p(this.this$0) & 10) != 0) goto L9;
        IRunnableWrapperCreator r0 = SuperThreadPool.INSTANCE.getWrapperCreator();
        if (r0 == null) goto L9;
        Runnable r1 = r0.wrap(r4, ThreadProxy.access$getMThreadType$p(this.this$0));
        if (r1 == null) goto L9;
        r4 = r1;
    L9:
        r4.run();
    }
}
