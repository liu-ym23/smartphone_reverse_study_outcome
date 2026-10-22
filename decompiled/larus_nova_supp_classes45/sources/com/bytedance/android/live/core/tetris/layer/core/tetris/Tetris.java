package com.bytedance.android.live.core.tetris.layer.core.tetris;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.service.ServiceElement;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.ies.sdk.widgets.Widget;
import h70.b;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import is2.k;
import j70.e;
import j70.f;
import j70.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k70.c;
import k70.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t70.h;
import t70.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\b\u0012\u0004\u0012\u00028\u00000\u0007B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\t\u001a\u00020\bH\u0017J\b\u0010\n\u001a\u00020\bH\u0017J\b\u0010\u000b\u001a\u00020\bH\u0017J\b\u0010\f\u001a\u00020\bH\u0017J\b\u0010\r\u001a\u00020\bH\u0017J\b\u0010\u000e\u001a\u00020\bH\u0017¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "Lh70/b;", "T", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/LifecycleObserver;", "Lz70/a;", "Lt70/b;", "Ld70/a;", "", "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class Tetris<T extends b> implements LifecycleOwnerCompat, LifecycleObserver, z70.a, t70.b, d70.a<T> {
    public final List<Element<?>> a;
    public c b;
    public T c;
    public d d;
    public com.bytedance.android.live.core.tetris.layer.core.data.b e;
    public p70.b f;
    public final LifecycleRegistry g;
    public View h;
    public Map<String, String> i;
    public k j;
    public final HashMap<String, Function1<ViewGroup, Unit>> k;
    public final PropertyOwner<Integer> l;
    public final CompositeDisposable m;
    public f n;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Tetris a;

        public a(Tetris r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            if (((Integer) r1).intValue() <= 0) goto L6;
            this.a.O();
            return;
        }
    }

    public abstract View G(t70.k r1);

    public abstract void O();

    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public final void J() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Element<?> r1 = (Element) r0.next();
        d r2 = this.d;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("elementGroup");
    L8:
        r2.a(r1);
        getLifecycle().removeObserver(r1);
        r1.e();
        goto L4
    L9:
        Lifecycle.State r3 = getLifecycle().getCurrentState();
        int r4 = h.a[r3.ordinal()];
        if (r4 != 3) goto L12;
        onDestroy();
    L19:
        ((ArrayList) this.a).clear();
        return;
    L12:
        if (r4 != 4) goto L14;
        onStop();
        onDestroy();
        goto L19
    L14:
        if (r4 != 5) goto L19;
        onPause();
        onStop();
        onDestroy();
        goto L19
    }

    public final T K() {
        T r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L5:
        return r0;
    }

    public final View L() {
        View r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tetrisView");
    L5:
        return r0;
    }

    @Override // d70.a
    public final T getComponentContext() {
        T r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L5:
        return r0;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        this.g.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(this.l).subscribe(new a(this)), this.m);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.g.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.i = null;
        k r0 = this.j;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.m.clear();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        this.g.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        this.g.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        this.g.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        this.g.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public Tetris() {
        this.a = new ArrayList();
        this.g = new LifecycleRegistry(this);
        this.k = new HashMap();
        this.l = new PropertyOwner(1);
        this.m = new CompositeDisposable();
    }

    @Override // d70.a
    public final f getElementType() {
        return this.n;
    }

    public final Lifecycle getLifecycleCompat() {
        return this.g;
    }

    @Override // t70.b
    public final Map<String, String> w() {
        return this.i;
    }

    @Override // t70.a
    public final HashMap<String, Function1<ViewGroup, Unit>> x() {
        return this.k;
    }

    public final Element E(o r3) {
        Intrinsics.checkNotNullParameter(r3, "elementAttribute");
        c r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L5:
        Element<?> r1 = r0.a(f.c, r3);
        if ((r1 instanceof ServiceElement) == false) goto L13;
        ((ArrayList) this.a).add(r1);
        getLifecycle().addObserver(r1);
        d r4 = this.d;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("elementGroup");
    L10:
        r4.b(r1);
        return r1;
    L13:
        throw new IllegalStateException(r3 + " should be defined for ServiceElement.");
    }

    public void H(Element<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "element");
        ((ArrayList) this.a).remove(r3);
        d r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("elementGroup");
    L5:
        r0.b(r3);
        r3.e();
    }

    public final <T extends ViewModel> T M(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        com.bytedance.android.live.core.tetris.layer.core.data.b r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("vmProvider");
    L6:
        return r0.getViewModel(r3);
    }

    @Override // t70.a
    public final void h(int r2) {
        this.l.a(Integer.valueOf(r2));
    }

    @Override // d70.a
    public final void setComponentContext(T r1) {
        if (r1 == null) goto L5;
        this.c = r1;
        return;
    }

    @Override // d70.a
    public final void setElementType(f r1) {
        this.n = r1;
    }

    @Override // z70.a
    public final void setExtraInfo(Map<String, String> r2) {
        Map<String, String> r0 = this.i;
        if (r0 != null) goto L5;
        this.i = r2;
        return;
    L5:
        r0.putAll(r2);
    }

    public final Element F(o r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "elementAttribute");
        Intrinsics.checkNotNullParameter(r4, "elementView");
        c r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L5:
        Element<?> r5 = r0.a(f.c, r3);
        ((ArrayList) this.a).add(r5);
        Map<String, String> r1 = this.i;
        if (r1 == null) goto L8;
        r5.setExtraInfo(r1);
    L8:
        ViewGroup r6 = r4;
        if (r5.a == false) goto L18;
        T r2 = this.c;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L13:
        View r7 = r5.c(r2.getContext(), r4);
        if (r7 == null) goto L17;
        r4.addView(r7);
        r6 = r7;
        goto L18
    L17:
        throw new IllegalStateException("buildView here shouldn't be null.");
    L18:
        r5.b = r6;
        getLifecycle().addObserver(r5);
        d r8 = this.d;
        if (r8 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("elementGroup");
    L21:
        r8.b(r5);
        return r5;
    }

    public final void N(Element<?> r4, ViewGroup r5) {
        T r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L5:
        View r1 = r4.c(r0.getContext(), r5);
        if (r1 == null) goto L16;
        if (r1.getId() != (-1)) goto L10;
        r1.setId(ViewCompat.generateViewId());
    L10:
        r5.addView(r1);
        r4.b = r1;
        getLifecycle().addObserver(r4);
        d r6 = this.d;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("elementGroup");
    L13:
        r6.b(r4);
        z70.c.a("dsl template element added, func_id = " + r4.d.b);
        return;
    L16:
        throw new IllegalStateException("buildView here shouldn't be null.");
    }

    @Override // t70.b
    public final Element<?> b(a80.a<b> r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, KtvSubElement.CONTAINER);
        c r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L5:
        T r1 = this.c;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L8:
        Element<?> r2 = r0.a(r4.o(r1), r4.p());
        ((ArrayList) this.a).add(r2);
        Map<String, String> r6 = r4.a;
        if (r6 == null) goto L11;
        r2.setExtraInfo(r6);
    L11:
        N(r2, r5);
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t70.b
    public final Element c(j70.h r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "descriptor");
        Intrinsics.checkNotNullParameter(r5, KtvSubElement.CONTAINER);
        c r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L5:
        T r1 = this.c;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L8:
        Element<?> r6 = r0.a(r4.C(r1), (e) r4);
        N(r6, r5);
        return r6;
    }

    @Override // t70.b
    public final void y(Class<? extends Widget> r2, ViewGroup r3, boolean r4, Object[] r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "widgetClass");
        Intrinsics.checkNotNullParameter(r3, "elementView");
        i r0 = new i(r4, r6, r2);
        if (r5 == null) goto L5;
        r0.d(r5);
    L5:
        F(r0, r3);
    }
}
