package com.ss.android.ugc.bytex.pthread.base.convergence.external;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadExecutePolicy;", "", "onThreadRelease", "", "thread", "Ljava/lang/Thread;", "onThreadStartUp", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IThreadExecutePolicy {
    void onThreadRelease(Thread r1);

    void onThreadStartUp(Thread r1);
}
