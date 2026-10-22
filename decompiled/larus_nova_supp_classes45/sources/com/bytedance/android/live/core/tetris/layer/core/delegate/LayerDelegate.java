package com.bytedance.android.live.core.tetris.layer.core.delegate;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import h70.b;
import i70.a;
import j70.d;
import j70.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\n\u001a\u00020\tH\u0017J\b\u0010\u000b\u001a\u00020\tH\u0017J\b\u0010\f\u001a\u00020\tH\u0017J\b\u0010\r\u001a\u00020\tH\u0017J\b\u0010\u000e\u001a\u00020\tH\u0017J\b\u0010\u000f\u001a\u00020\tH\u0017¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/delegate/LayerDelegate;", "Li70/a;", "T", "Lh70/b;", "C", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/LifecycleObserver;", "", "Lcom/bytedance/android/live/core/tetris/layer/core/data/b;", "", "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LayerDelegate<T extends i70.a, C extends h70.b> implements LifecycleOwnerCompat, LifecycleObserver, com.bytedance.android.live.core.tetris.layer.core.data.b {
    public T a;
    public com.bytedance.android.live.core.tetris.layer.core.data.b b;
    public C c;
    public final Map<f, Element<?>> d;
    public final Set<d<h70.b>> e;
    public final LifecycleRegistry f;

    public void c(Element<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
    }

    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public abstract void j(Element<?> r1);

    public abstract void k(Element<?> r1);

    public final T h() {
        T r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layer");
    L5:
        return r0;
    }

    public final C i() {
        C r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L5:
        return r0;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        this.f.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.f.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        this.f.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        this.f.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        this.f.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        this.f.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public LayerDelegate() {
        this.d = new LinkedHashMap();
        this.e = new LinkedHashSet();
        this.f = new LifecycleRegistry(this);
    }

    public final Lifecycle getLifecycleCompat() {
        return this.f;
    }

    public void b(Element<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "element");
        if (this.d.containsKey(r3.d) == false) goto L6;
        c(r3);
        getLifecycle().addObserver(r3);
        j(r3);
        return;
    }

    public void e(Element<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        getLifecycle().removeObserver(r2);
        r2.e();
        k(r2);
    }

    public final Element<?> f(f r2) {
        Intrinsics.checkNotNullParameter(r2, "elementType");
        return (Element) ((LinkedHashMap) this.d).get(r2);
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.data.b
    public final <T extends ViewModel> T getViewModel(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "modelClass");
        com.bytedance.android.live.core.tetris.layer.core.data.b r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("vmProvider");
    L6:
        return r0.getViewModel(r3);
    }

    public final void l(f r6) {
        Intrinsics.checkNotNullParameter(r6, "elementType");
        if (this.d.containsKey(r6) == false) goto L21;
        Element<?> r0 = f(r6);
        Intrinsics.checkNotNull(r0);
        e(r0);
        this.d.remove(r6);
        Iterator<T> r1 = this.e.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        Object r2 = r1.next();
        d r3 = (d) r2;
        C r4 = this.c;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L11:
        if (Intrinsics.areEqual(r3.C(r4), r6) == false) goto L6;
    L14:
        d r5 = (d) r2;
        if (r5 == null) goto L22;
        this.e.remove(r5);
        return;
    L22:
        return;
    L13:
        r2 = null;
        goto L14
    }

    public final <T> T g(f r3, Class<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "elementType");
        Intrinsics.checkNotNullParameter(r4, "clz");
        T r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layer");
    L5:
        Element<?> r5 = r0.f2(r3);
        if (r5 != null) goto L10;
        return null;
    L10:
        return (T) r5.f(r4);
    }
}
