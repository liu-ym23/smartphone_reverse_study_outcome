package com.obric.oui.window.listener;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.h;
import androidx.lifecycle.l;
import androidx.lifecycle.v;
import bd.b;
import he.i;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class WindowConfigChangeListener$Companion$addListener$2 implements l {
    @v(h.a.ON_DESTROY)
    public final void onDestroy() {
        ConcurrentLinkedQueue<WeakReference<Fragment>> r8 = b.f3164d.get(0);
        if (r8 == null) goto L10;
        Iterator<WeakReference<Fragment>> r10 = r8.iterator();
        i.e(r10, "it.iterator()");
    L6:
        if (r10.hasNext() == false) goto L16;
        if (i.a(r10.next().get(), null) == false) goto L6;
        r10.remove();
        goto L6
    L16:
        return;
    }
}
