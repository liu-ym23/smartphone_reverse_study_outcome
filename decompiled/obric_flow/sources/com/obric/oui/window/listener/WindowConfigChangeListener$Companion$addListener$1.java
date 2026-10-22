package com.obric.oui.window.listener;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/window/listener/WindowConfigChangeListener$Companion$addListener$1", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroy", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WindowConfigChangeListener$Companion$addListener$1 implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        ConcurrentHashMap r5 = WindowConfigChangeListener.d;
        if (r5.containsKey(0) == false) goto L6;
        r5.remove(0);
        return;
    }
}
