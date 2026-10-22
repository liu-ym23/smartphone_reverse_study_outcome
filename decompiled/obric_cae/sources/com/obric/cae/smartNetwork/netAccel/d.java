package com.obric.cae.smartNetwork.netAccel;

import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5776a;

    public /* synthetic */ d(int r8) {
        this.f5776a = r8;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r8) {
        switch(this.f5776a) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return AppTrafficCollect.WiFiThroughputListener.b((Integer) r8);
    L8:
        return MultiNetInfo.b((Integer) r8);
    }
}
