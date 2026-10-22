package com.bumptech.glide.manager;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class LifecycleLifecycle implements LifecycleObserver, j {
    private final Lifecycle lifecycle;
    private final Set<k> lifecycleListeners;

    LifecycleLifecycle(Lifecycle r2) {
        this.lifecycleListeners = new HashSet();
        this.lifecycle = r2;
        r2.addObserver(this);
    }

    @Override // com.bumptech.glide.manager.j
    public void addListener(k r3) {
        k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
        this.lifecycleListeners.add(r4);
        if (this.lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
        r4.g();
        return;
    L6:
        if (this.lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L8;
        r4.e();
        return;
    L8:
        r4.f();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner r5) {
        LifecycleOwner r6 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r5, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Iterator r0 = com.bumptech.glide.util.k.a(this.lifecycleListeners).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((k) ZeusTransformUtils.preCheckCast(r0.next(), k.class, "com.obric.memorydata.plugin")).g();
        goto L4
    L6:
        r6.getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner r3) {
        LifecycleOwner r4 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Iterator r2 = com.bumptech.glide.util.k.a(this.lifecycleListeners).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((k) ZeusTransformUtils.preCheckCast(r2.next(), k.class, "com.obric.memorydata.plugin")).e();
        goto L4
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner r3) {
        LifecycleOwner r4 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Iterator r2 = com.bumptech.glide.util.k.a(this.lifecycleListeners).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((k) ZeusTransformUtils.preCheckCast(r2.next(), k.class, "com.obric.memorydata.plugin")).f();
        goto L4
    }

    @Override // com.bumptech.glide.manager.j
    public void removeListener(k r3) {
        k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
        this.lifecycleListeners.remove(r4);
    }
}
