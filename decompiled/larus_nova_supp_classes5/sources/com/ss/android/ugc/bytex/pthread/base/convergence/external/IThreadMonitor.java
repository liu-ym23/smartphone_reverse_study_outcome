package com.ss.android.ugc.bytex.pthread.base.convergence.external;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadMonitor;", "", "afterLooperPrepared", "", "thread", "Ljava/lang/Thread;", "onThreadExit", "onThreadRunning", "onThreadStart", EffectConfiguration.KEY_TYPE, "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IThreadMonitor {
    void afterLooperPrepared(Thread r1);

    void onThreadExit(Thread r1);

    void onThreadRunning(Thread r1);

    void onThreadStart(Thread r1, int r2);
}
