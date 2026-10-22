package com.obric.cae.smartNetwork.iplocateCountrycode;

import java.util.function.IntPredicate;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements IntPredicate {
    @Override // java.util.function.IntPredicate
    public final boolean test(int r8) {
        return Character.isLetterOrDigit(r8);
    }
}
