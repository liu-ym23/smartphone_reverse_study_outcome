package com.obric.cae.smartNetwork.networkRateLimit;

import java.util.function.ToIntFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements ToIntFunction {
    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object r8) {
        return ((RateControlManager.UidRateControlInfo) r8).getRate();
    }
}
