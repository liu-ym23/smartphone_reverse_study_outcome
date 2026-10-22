package com.bytedance.salamander.anniex;

import com.bytedance.salamander.adapter.Lock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    public static a0 a() {
        if (a0.f7242b != null) goto L8;
        Lock r5 = a0.f7243c;
        r5.lock();
        if (a0.f7242b == null) goto L7;
        r5.unlock();
        goto L8
    L7:
        a0.f7242b = new a0();
        r5.unlock();
    L8:
        a0 r10 = a0.f7242b;
        Intrinsics.checkNotNull(r10);
        return r10;
    }
}
