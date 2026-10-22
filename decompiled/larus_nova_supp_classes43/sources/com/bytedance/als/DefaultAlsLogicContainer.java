package com.bytedance.als;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0003H\u0007J\b\u0010\u0007\u001a\u00020\u0003H\u0007J\b\u0010\b\u001a\u00020\u0003H\u0007J\b\u0010\t\u001a\u00020\u0003H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/als/DefaultAlsLogicContainer;", "Lcom/bytedance/als/a;", "Landroidx/lifecycle/LifecycleObserver;", "", "onActivityCreated", "onStart", "onResume", "onPause", "onStop", "onDestroyView", "als_release"}, k = 1, mv = {1, 4, 1})
public final class DefaultAlsLogicContainer extends a implements LifecycleObserver {
    public boolean a;

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        Iterator r1 = CollectionsKt.toList(null).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        a((LogicComponent) r1.next(), Lifecycle.State.STARTED);
        goto L4
    L6:
        Lifecycle.Event.Companion r10 = Lifecycle.Event.Companion;
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        Iterator r1 = CollectionsKt.toList(null).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        a((LogicComponent) r1.next(), Lifecycle.State.RESUMED);
        goto L4
    L6:
        Lifecycle.Event.Companion r10 = Lifecycle.Event.Companion;
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        Iterator r1 = CollectionsKt.toList(null).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        a((LogicComponent) r1.next(), Lifecycle.State.STARTED);
        goto L4
    L6:
        Lifecycle.Event.Companion r10 = Lifecycle.Event.Companion;
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        Iterator r1 = CollectionsKt.toList(null).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        a((LogicComponent) r1.next(), Lifecycle.State.CREATED);
        goto L4
    L6:
        Lifecycle.Event.Companion r10 = Lifecycle.Event.Companion;
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onActivityCreated() {
        if (this.a == false) goto L9;
        this.a = true;
        Iterator r0 = CollectionsKt.toList(null).iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        a((LogicComponent) r0.next(), Lifecycle.State.CREATED);
        goto L6
    L8:
        throw null;
    L9:
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroyView() {
        HashMap r0 = new HashMap();
        Iterator r10 = CollectionsKt.toList(null).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        LogicComponent<?> r11 = (LogicComponent) r10.next();
        a(r11, Lifecycle.State.DESTROYED);
        r0.put(r11.getClass(), MapsKt.toMap(r11.b.a));
        goto L4
    L6:
        int r12 = d6.a.a;
        Intrinsics.checkNotNullParameter(r0, "map");
        Lifecycle.Event.Companion r1 = Lifecycle.Event.Companion;
        throw null;
    }

    public final void a(LogicComponent<?> r10, Lifecycle.State r11) {
        int r12 = c.a[r11.ordinal()];
        if (r12 != 1) goto L5;
        Lifecycle.State r13 = r10.getLifecycle().getCurrentState();
        Lifecycle.State r0 = Lifecycle.State.CREATED;
        if (r13.compareTo(r0) >= 0) goto L46;
        r10.b();
        return;
    L46:
        if (r10.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) <= 0) goto L49;
        r10.e();
    L49:
        if (r10.getLifecycle().getCurrentState().compareTo(r0) <= 0) goto L59;
        r10.h();
        return;
    L59:
        return;
    L5:
        if (r12 != 2) goto L7;
        Lifecycle.State r14 = r10.getLifecycle().getCurrentState();
        Lifecycle.State r1 = Lifecycle.State.STARTED;
        if (r14.compareTo(r1) >= 0) goto L40;
        if (r10.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L38;
        r10.b();
    L38:
        r10.g();
        return;
    L40:
        if (r10.getLifecycle().getCurrentState().compareTo(r1) <= 0) goto L56;
        r10.e();
        return;
    L56:
        return;
    L7:
        if (r12 == 3) goto L25;
        if (r12 == 4) goto L12;
        return;
    L12:
        if (r10.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L15;
        r10.e();
    L15:
        if (r10.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) < 0) goto L18;
        r10.h();
    L18:
        if (r10.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) < 0) goto L52;
        r10.c();
        if ((!Intrinsics.areEqual(r10.i(), b.class)) == true) goto L23;
        return;
    L23:
        throw null;
    L52:
        return;
    L25:
        if (r10.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L27;
        return;
    L27:
        if (r10.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L30;
        r10.b();
    L30:
        if (r10.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) >= 0) goto L32;
        r10.g();
    L32:
        r10.f();
    }
}
