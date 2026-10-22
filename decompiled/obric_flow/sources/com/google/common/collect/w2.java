package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w2 extends z2 implements Map.Entry {
    public abstract Map.Entry b();

    public boolean equals(Object r5) {
        return b().equals(r5);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return b().getKey();
    }

    public Object getValue() {
        return b().getValue();
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return b().hashCode();
    }

    public Object setValue(Object r5) {
        return b().setValue(r5);
    }
}
