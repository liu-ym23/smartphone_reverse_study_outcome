package com.bytedance.ai.widget;

import java.lang.ref.WeakReference;
import java.util.ListIterator;
import kotlin.collections.ArrayDeque;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public final synchronized o a() {
        monitor-enter(this);
        ArrayDeque r5 = o.f3080k;     // Catch: Throwable -> L10
        ListIterator<E> r10 = r5.listIterator(r5.size());     // Catch: Throwable -> L10
    L5:
        if (r10.hasPrevious() == false) goto L14;
        o r11 = (o) ((WeakReference) r10.previous()).get();     // Catch: Throwable -> L10
        if (r11 != null) goto L12;
        r10.remove();     // Catch: Throwable -> L10
        goto L5
    L12:
        monitor-exit(this);
        return r11;
    L14:
        monitor-exit(this);
        return null;
    L10:
        th = move-exception;
        throw th;
    }
}
