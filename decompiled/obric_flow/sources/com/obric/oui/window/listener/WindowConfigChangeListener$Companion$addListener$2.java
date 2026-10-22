package com.obric.oui.window.listener;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/window/listener/WindowConfigChangeListener$Companion$addListener$2", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroy", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WindowConfigChangeListener$Companion$addListener$2 implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        ConcurrentLinkedQueue r5 = (ConcurrentLinkedQueue) WindowConfigChangeListener.d.get(0);
        if (r5 == null) goto L11;
        Iterator r10 = r5.iterator();
    L7:
        if (r10.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(((WeakReference) r10.next()).get(), null) == false) goto L7;
        r10.remove();
        goto L7
    L17:
        return;
    }
}
