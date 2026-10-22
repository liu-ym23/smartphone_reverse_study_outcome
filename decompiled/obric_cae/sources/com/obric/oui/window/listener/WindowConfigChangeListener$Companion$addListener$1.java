package com.obric.oui.window.listener;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.h;
import androidx.lifecycle.l;
import androidx.lifecycle.v;
import bd.b;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class WindowConfigChangeListener$Companion$addListener$1 implements l {
    @v(h.a.ON_DESTROY)
    public final void onDestroy() {
        ConcurrentHashMap<Integer, ConcurrentLinkedQueue<WeakReference<Fragment>>> r8 = b.f3164d;
        if (r8.containsKey(0) == false) goto L6;
        r8.remove(0);
        return;
    }
}
