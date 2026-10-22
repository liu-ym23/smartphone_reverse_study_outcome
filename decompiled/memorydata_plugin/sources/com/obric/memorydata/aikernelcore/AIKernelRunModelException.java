package com.obric.memorydata.aikernelcore;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/aikernelcore/AIKernelRunModelException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "delayTime", "", "<init>", "(J)V", "getDelayTime", "()J", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIKernelRunModelException extends Exception {
    private final long delayTime;

    public AIKernelRunModelException(long r1) {
        this.delayTime = r1;
    }

    public final long getDelayTime() {
        return this.delayTime;
    }
}
