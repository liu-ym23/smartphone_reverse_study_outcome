package com.ss.ugc.effectplatform.repository;

import bytekn.foundation.utils.Transmitter;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.task.algorithm.FetchModelTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class AlgorithmRepository$fetchResourcesWithModelNames$1 implements e0.c {
    public long a;
    public final /* synthetic */ FetchModelTask b;
    public final /* synthetic */ IEffectPlatformBaseListener c;
    public final /* synthetic */ String[] d;

    public final void cancel() {
    }

    public final String getId() {
        return "";
    }

    public final int getLevel() {
        return 0;
    }

    public final String getTag() {
        return "fetchResourcesWithModelNames";
    }

    public final void pause() {
    }

    public final void run() {
        this.b.run();     // Catch: Exception -> L5
        Transmitter.a(new c(new AlgorithmRepository$fetchResourcesWithModelNames$1$run$2(this)));
        return;
    L5:
        e = move-exception;
        Transmitter.a(new c(new run.1(this, e)));
    }

    public final long getModifyTime() {
        return this.a;
    }

    public final void setModifyTime(long r1) {
        this.a = r1;
    }

    public AlgorithmRepository$fetchResourcesWithModelNames$1(FetchModelTask r1, IEffectPlatformBaseListener r2, String[] r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
