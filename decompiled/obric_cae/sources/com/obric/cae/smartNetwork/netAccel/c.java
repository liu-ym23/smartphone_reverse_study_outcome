package com.obric.cae.smartNetwork.netAccel;

import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5775a;

    public /* synthetic */ c(int r8) {
        this.f5775a = r8;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r8) {
        switch(this.f5775a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L10;
        };
    L6:
        return FlowSched.UidSocketStats.a((String) r8);
    L8:
        return AppTrafficCollect.WiFiThroughputListener.a((Integer) r8);
    L10:
        return MultiNetInfo.c((Integer) r8);
    }
}
