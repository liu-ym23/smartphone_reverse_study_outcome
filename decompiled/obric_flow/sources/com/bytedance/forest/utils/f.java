package com.bytedance.forest.utils;

import com.bytedance.forest.model.w;
import com.lynx.tasm.ui.image.f0;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements com.bytedance.iesgurd.b, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f4622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4623b;

    public f(h r5) {
        this.f4622a = new WeakReference(r5);
        com.bytedance.forest.model.m r10 = r5.d.f4441q.getGeckoModel();
        this.f4623b = androidx.constraintlayout.motion.widget.a.m(r10.f4389a, '/', r10.f4390b);
    }

    @Override // com.bytedance.iesgurd.b
    public final void b(com.bytedance.iesgurd.c r5) {
        h r10 = (h) this.f4622a.get();
        if (r10 != null) goto L6;
        close();
        return;
    L6:
        w r11 = r10.d;
        com.bytedance.forest.model.m r12 = r11.f4441q.getGeckoModel();
        String r13 = r12.f4389a;
        String r14 = r5.f6594a;
        if (Intrinsics.areEqual(r14, r13) == false) goto L13;
        String r15 = r12.f4390b;
        String r16 = r5.f6595b;
        if (Intrinsics.areEqual(r16, r15) == false) goto L14;
        f0.h("MemoryManager", 60, "remove [" + r11.f4441q.getForest().getMemoryManager$forest_release().a(r11.f4441q.getCacheKey$forest_release()) + "] cause by gecko clean " + r14 + '/' + r16, false);
        close();
        return;
    L14:
        return;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        HashMap r5 = j.f4643c;
        monitor-enter(r5);
        CopyOnWriteArrayList r10 = (CopyOnWriteArrayList) r5.get(this.f4623b);     // Catch: Throwable -> L9
        monitor-exit(r5);
        if (r10 == null) goto L14;
        r10.remove(this);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
