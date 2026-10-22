package com.google.common.collect;

import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
public final class a2 extends l {
    @Override // com.google.common.collect.l, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Spliterator spliterator() {
        return Spliterators.spliterator(this, 17);
    }
}
