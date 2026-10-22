package com.obric.cae.smartNetwork.netAccel;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object r8, Object r10) {
        return FlowSched.a((FlowSched.NetworkLoad) r8, (FlowSched.NetworkLoad) r10);
    }
}
