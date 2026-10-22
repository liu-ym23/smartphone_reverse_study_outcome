package com.bytedance.android.live.core.tetris.layer.core.element;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.componentx.component.b;
import com.bytedance.android.live.core.tetris.componentx.utils.ObservableLifecycleRegistry;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import j70.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p70.d;
import v70.c;
import z70.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005J\b\u0010\u0007\u001a\u00020\u0006H\u0017J\b\u0010\b\u001a\u00020\u0006H\u0017J\b\u0010\t\u001a\u00020\u0006H\u0017J\b\u0010\n\u001a\u00020\u0006H\u0017J\b\u0010\u000b\u001a\u00020\u0006H\u0017J\b\u0010\f\u001a\u00020\u0006H\u0017¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/Element;", "", "Content", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/LifecycleObserver;", "Lz70/a;", "", "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class Element<Content> implements LifecycleOwnerCompat, LifecycleObserver, a {
    public boolean a;
    public View b;
    public b c;
    public f d;
    public f e;
    public Content f;
    public Map<String, String> g;
    public LayerEventDispatcher h;
    public p70.b i;
    public final ObservableLifecycleRegistry j;
    public final h70.b k;

    public abstract View c(Context r1, ViewGroup r2);

    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public abstract Content i();

    public abstract o70.a j();

    public void k() {
    }

    public abstract void onViewCreated(View r1);

    public final c h() {
        View r0 = this.b;
        if (r0 != null) goto L6;
        return null;
    L6:
        Intrinsics.checkNotNull(r0);
        return new c(r0);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        this.j.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        onViewCreated(this.b);
        LayerEventDispatcher r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "element");
        r0.a(j());
        this.f = i();
        ALogger.i("【widget】", "onContentReady " + this + " -> " + this.f);
        Content r1 = this.f;
        if (r1 != null) goto L8;
    L24:
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L8:
        if ((r1 instanceof d) == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L24;
        Iterator<T> r2 = ((d) r1).ud().iterator();
    L14:
        if (r2.hasNext() == false) goto L24;
        p70.c r3 = (p70.c) r2.next();
        p70.b r4 = this.i;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("processorChains");
    L18:
        p70.a r5 = r4.a(r3.b());
        if (r5 == null) goto L14;
        Intrinsics.checkNotNullParameter(r3, "p");
        if (((ArrayList) r5.a).contains(r3) == true) goto L14;
        ((ArrayList) r5.a).add(r3);
        goto L14
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.j.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        this.j.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        this.j.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        this.j.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        this.j.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public final void e() {
        k();
        Lifecycle.State r0 = getLifecycle().getCurrentState();
        int r1 = k70.a.a[r0.ordinal()];
        if (r1 != 3) goto L5;
        onDestroy();
    L12:
        LayerEventDispatcher r2 = this.h;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
    L15:
        r2.getClass();
        Intrinsics.checkNotNullParameter(this, "element");
        o70.a r3 = j();
        if (r3 == null) goto L23;
        Iterator<T> r4 = r3.Mg().iterator();
    L19:
        if (r4.hasNext() == false) goto L29;
        Class r5 = (Class) r4.next();
        HashSet<o70.a> r6 = r2.a.get(r5);
        if (r6 == null) goto L19;
        r6.remove(r3);
        goto L19
    L29:
        return;
    L23:
        return;
    L5:
        if (r1 != 4) goto L7;
        onStop();
        onDestroy();
        goto L12
    L7:
        if (r1 != 5) goto L12;
        onPause();
        onStop();
        onDestroy();
        goto L12
    }

    public Lifecycle g() {
        return this.j;
    }

    public final Lifecycle getLifecycleCompat() {
        return this.j;
    }

    public Element(h70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        this.k = r2;
        this.a = true;
        f r3 = f.c;
        f r4 = f.c;
        this.d = r4;
        this.e = r4;
        this.j = new ObservableLifecycleRegistry(this);
    }

    public final <T> T f(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "clz");
        T r0 = this.f;
        if (r0 != null) goto L5;
    L10:
        return null;
    L5:
        if (r4.isAssignableFrom(r0.getClass()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        return r0;
    }

    @Override // z70.a
    public final void setExtraInfo(Map<String, String> r2) {
        Map<String, String> r0 = this.g;
        if (r0 != null) goto L5;
        this.g = r2;
        return;
    L5:
        r0.putAll(r2);
    }
}
