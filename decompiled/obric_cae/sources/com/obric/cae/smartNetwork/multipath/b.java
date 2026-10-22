package com.obric.cae.smartNetwork.multipath;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object r8, Object r10) {
        return MPAJitterEvaluate.c((MPAJitterEvaluate.Result) r8, (MPAJitterEvaluate.Result) r10);
    }
}
