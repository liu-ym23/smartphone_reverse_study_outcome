package com.bytedance.salamander.anniex;

import com.bytedance.salamander.adapter.Lock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p {
    public static q a() {
        q r5 = q.e;
        if (r5 == null) goto L6;
        Intrinsics.checkNotNull(r5);
        return r5;
    L6:
        Lock r10 = q.d;
        r10.lock();
        if (q.e == null) goto L10;
        r10.unlock();
        q r11 = q.e;
        Intrinsics.checkNotNull(r11);
        return r11;
    L10:
        q.e = new q();
        r10.unlock();
        q r12 = q.e;
        Intrinsics.checkNotNull(r12);
        return r12;
    }
}
