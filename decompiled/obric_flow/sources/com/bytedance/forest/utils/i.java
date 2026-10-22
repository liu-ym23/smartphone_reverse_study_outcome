package com.bytedance.forest.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements com.bytedance.iesgurd.b {
    @Override // com.bytedance.iesgurd.b
    public final void b(com.bytedance.iesgurd.c r5) {
        String r10 = androidx.constraintlayout.motion.widget.a.m(r5.f6594a, '/', r5.f6595b);
        HashMap r11 = j.f4643c;
        monitor-enter(r11);
        CopyOnWriteArrayList r12 = (CopyOnWriteArrayList) r11.remove(r10);     // Catch: Throwable -> L12
        monitor-exit(r11);
        if (r12 == null) goto L11;
        Iterator r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L18;
        ((f) r13.next()).b(r5);
        goto L9
    L18:
        return;
    L11:
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
