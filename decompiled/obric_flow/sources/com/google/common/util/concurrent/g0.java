package com.google.common.util.concurrent;

import com.google.common.collect.p7;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        p7.q(3, "initialArraySize");
        return new ArrayList(3);
    }
}
