package com.bytedance.android.live.core.tetris.widgets;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.o1;
import com.bytedance.android.live.core.tetris.layer.core.element.tetris.RecyclableTetrisElement;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.setting.LiveFragmentLeakConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements c {
    public static volatile h d;
    public final ConcurrentHashMap<Class, a> a;
    public final ConcurrentHashMap<Class, WeakReference<a>> b;
    public final boolean c;

    public static h c() {
        if (d != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public final void b() {
        if (LiveInfraSettingKeys.LIVE_COMPONENT_CACHE_DESTORY_EANBLE.getValue().booleanValue() == false) goto L6;
        com.bytedance.android.live.core.tetris.widgets.cache.c.g.a().c();
    L6:
        if (this.c == false) goto L14;
        Iterator<Map.Entry<Class, WeakReference<a>>> r0 = this.b.entrySet().iterator();
    L9:
        if (r0.hasNext() == false) goto L13;
        a r1 = r0.next().getValue().get();
        if (r1 == null) goto L9;
        r1.clearAfterDestroyed();
        goto L9
    L13:
        this.b.clear();
    L19:
        RecyclableTetrisElement.u.getClass();
        ((HashMap) RecyclableTetrisElement.t).clear();
        return;
    L14:
        Iterator<Map.Entry<Class, a>> r2 = this.a.entrySet().iterator();
    L16:
        if (r2.hasNext() == false) goto L18;
        r2.next().getValue().clearAfterDestroyed();
        goto L16
    L18:
        this.a.clear();
        goto L19
    }

    public h() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = ((LiveFragmentLeakConfig) o1.a.getValue()).getWidgetProviderSwitch();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.c
    public final <T extends a> T a(Class<T> r6) {
        LifecycleOwner r1 = null;
        if (this.c == false) goto L8;
        WeakReference<a> r0 = this.b.get(r6);
        if (r0 == null) goto L7;
        a r2 = r0.get();
    L9:
        boolean r3 = true;
        if (i60.c.a.getValue().booleanValue() == false) goto L20;
        if (r2 != null) goto L13;
    L19:
        r3 = false;
    L23:
        if (r2 == null) goto L27;
        if (r3 == false) goto L27;
        r2.clearAfterDestroyed();
        r2 = null;
    L27:
        if ((r2 instanceof LifecycleOwner) == false) goto L34;
        LifecycleOwner r4 = r2;
        if ((r4.getLifecycle() instanceof LifecycleRegistry) == false) goto L34;
        if (r4.getLifecycle().getObserverCount() <= 0) goto L33;
        r2.clearAfterDestroyed();
    L35:
        if (r1 == null) goto L49;
        return r1;
    L49:
        T r5 = r6.newInstance();     // Catch: InstantiationException -> L42 IllegalAccessException -> L45
        r5.setRecyclable();     // Catch: InstantiationException -> L42 IllegalAccessException -> L45
    L38:
        if (this.c == false) goto L40;
        this.b.put(r6, new WeakReference(r5));
    L41:
        return r5;
    L40:
        this.a.put(r6, r5);
    L45:
        e = move-exception;
        throw new RuntimeException(e);
    L42:
        e = move-exception;
        throw new RuntimeException(e);
    L33:
        r4.getLifecycle().markState(Lifecycle.State.INITIALIZED);
    L34:
        r1 = r2;
        goto L35
    L13:
        if (r2.isAlive() == true) goto L23;
        if ((r2 instanceof LiveRecyclableWidget) == false) goto L19;
        if (((LiveRecyclableWidget) r2).isAsyncLoading() == false) goto L19;
    L20:
        if (r2 == null) goto L19;
        if (r2.isAlive() == false) goto L19;
    L7:
        r2 = null;
        goto L9
    L8:
        r2 = (a) this.a.get(r6);
        goto L9
    }
}
