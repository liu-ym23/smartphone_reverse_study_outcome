package com.bytedance.android.live.core.tetris.componentx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.ComponentManagerFactory$config$1;
import com.bytedance.android.live.core.tetris.IComponentManager;
import com.bytedance.android.live.core.tetris.componentx.component.ComponentCenter;
import com.bytedance.android.live.core.tetris.componentx.schedule.BatchTogetherConditionManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState;
import com.bytedance.android.live.core.tetris.componentx.schedule.ComponentSchedulingManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.InnerComponentListener;
import com.bytedance.android.live.core.tetris.componentx.schedule.j;
import com.bytedance.android.live.core.tetris.componentx.schedule.m;
import com.bytedance.android.live.core.tetris.componentx.schedule.q;
import com.bytedance.android.live.core.tetris.componentx.utils.ObservableLifecycleRegistry;
import com.bytedance.android.live.core.tetris.layer.core.ViewLayer;
import com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.delegate.ViewLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.layout.LayoutManager;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.apm.impl.protector.RunnableProtector;
import g70.e;
import g70.f;
import g70.g;
import j70.d;
import j70.h;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\fJ\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007J\b\u0010\t\u001a\u00020\u0005H\u0007J\b\u0010\n\u001a\u00020\u0005H\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/core/tetris/componentx/ComponentManager;", "Lcom/bytedance/android/live/core/tetris/IComponentManager;", "Lcom/bytedance/android/live/core/tetris/layer/core/delegate/a;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/LifecycleObserver;", "", "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "a", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComponentManager implements IComponentManager, com.bytedance.android.live.core.tetris.layer.core.delegate.a, LifecycleOwnerCompat, LifecycleObserver {
    public final String a;
    public final LinkedHashMap<a, i70.a> b;
    public final g70.a c;
    public final Lazy d;
    public final Lazy e;
    public ComponentCenter f;
    public ComponentSchedulingManager g;
    public InnerComponentListener h;
    public com.bytedance.android.live.core.tetris.layer.core.engine.a i;
    public com.bytedance.android.live.core.tetris.layer.core.engine.b j;
    public com.bytedance.android.live.core.tetris.layer.core.engine.c k;
    public final ObservableLifecycleRegistry l;
    public final f m;
    public int n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final com.bytedance.android.live.core.tetris.componentx.a r;

    public static final class a {
        public final f70.b a;
        public final LayerIndex b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            f70.b r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            LayerIndex r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "LayerKey(layerType=" + this.a + ", layerIndex=" + this.b + ")";
        }

        public a(f70.b r2, LayerIndex r3) {
            Intrinsics.checkNotNullParameter(r2, "layerType");
            Intrinsics.checkNotNullParameter(r3, "layerIndex");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ i70.a a;
        public final /* synthetic */ ComponentManager b;

        public b(i70.a r1, ComponentManager r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.e(this.a, true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Comparator<T> {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            i70.a r4 = (i70.a) r2;
            i70.a r5 = (i70.a) r3;
            return ComparisonsKt.compareValues(Integer.valueOf((r4.getLayerTypeV2().b * 1000) + r4.getLayerIndex().getIndex()), Integer.valueOf((r5.getLayerTypeV2().b * 1000) + r5.getLayerIndex().getIndex()));
        }
    }

    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void C8() {
        if (((Boolean) this.q.getValue()).booleanValue() == false) goto L14;
        com.bytedance.android.live.core.tetris.layer.core.engine.b r0 = this.j;
        if (r0 == null) goto L7;
        r0.a = true;
    L7:
        com.bytedance.android.live.core.tetris.layer.core.engine.a r1 = this.i;
        if (r1 == null) goto L10;
        r1.a = true;
    L10:
        com.bytedance.android.live.core.tetris.layer.core.engine.c r2 = this.k;
        if (r2 == null) goto L15;
        r2.b = true;
        return;
    L15:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        this.l.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        f r0 = this.m;
        String r1 = this.r.b();
        Intrinsics.checkNotNullParameter(r0, "$this$traceDestroy");
        Intrinsics.checkNotNullParameter(r1, "identifyId");
        r0.log("[" + r0.hashCode() + "]destroy component manager, identifyId is [" + r1 + ']');
        if (this.l.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        ComponentSchedulingManager r2 = this.g;
        if (r2 == null) goto L8;
        r2.g();
    L8:
        this.g = null;
        ComponentCenter r3 = this.f;
        if (r3 == null) goto L11;
        r3.h();
    L11:
        this.f = null;
        if (((Boolean) this.q.getValue()).booleanValue() == false) goto L22;
        com.bytedance.android.live.core.tetris.layer.core.engine.b r4 = this.j;
        if (r4 == null) goto L16;
        r4.a = true;
    L16:
        com.bytedance.android.live.core.tetris.layer.core.engine.a r5 = this.i;
        if (r5 == null) goto L19;
        r5.a = true;
    L19:
        com.bytedance.android.live.core.tetris.layer.core.engine.c r6 = this.k;
        if (r6 == null) goto L22;
        r6.b = true;
    L22:
        this.j = null;
        this.i = null;
        this.k = null;
        this.b.clear();
        this.l.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        if (this.l.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        this.l.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        this.l.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        this.l.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        if (this.l.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        this.l.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final com.bytedance.android.live.core.tetris.componentx.a config() {
        return this.r;
    }

    public final Lifecycle getLifecycleCompat() {
        return this.l;
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void release() {
        onDestroy();
    }

    public ComponentManager(ComponentManagerFactory$config$1 r14) {
        Intrinsics.checkNotNullParameter(r14, "config");
        this.r = r14;
        this.a = "ComponentManager";
        this.b = new LinkedHashMap();
        this.d = LazyKt.lazy(ComponentManager$globalElementCenter$2.INSTANCE);
        Lazy r0 = LazyKt.lazy(new ComponentManager$layoutManager$2(this));
        this.e = r0;
        ComponentManagerFactory$config$1.a r1 = r14.i;
        this.m = r1;
        this.o = LazyKt.lazy(ComponentManager$enableLayerOpt$2.INSTANCE);
        this.p = LazyKt.lazy(ComponentManager$enableLayerUpdateLoadOpt$2.INSTANCE);
        this.q = LazyKt.lazy(ComponentManager$enableLayerEngineStopOpt$2.INSTANCE);
        long r2 = System.currentTimeMillis();
        this.l = new ObservableLifecycleRegistry(this);
        ComponentManagerABHelper r4 = ComponentManagerABHelper.INSTANCE;
        if (r4.enableRoomSceneScheduler() == true) goto L5;
    L7:
        this.f = new ComponentCenter(r14, this.h);
        this.c = new g70.a(r14);
        e r5 = new e(r14);
        f70.a r11 = r14.f.a.e;
        this.j = new com.bytedance.android.live.core.tetris.layer.core.engine.b(r11, (LayoutManager) r0.getValue(), r5, this.f, r14);
        this.i = new com.bytedance.android.live.core.tetris.layer.core.engine.a(r5, this.f, r14);
        this.k = new com.bytedance.android.live.core.tetris.layer.core.engine.c(r11, r5, this.f);
        r14.a.getLifecycle().addObserver(this);
        LifecycleOwnerCompat.-CC.$default$getLifecycle(this).addObserver(r14.g.d());
        ComponentCenter r3 = this.f;
        if (r3 == null) goto L10;
        r3.i();
    L10:
        String r15 = r14.d;
        long r6 = System.currentTimeMillis() - r2;
        Intrinsics.checkNotNullParameter(r1, "$this$traceCreate");
        Intrinsics.checkNotNullParameter(r15, "identifyId");
        r1.log("[" + r1.hashCode() + "]create component manager, identifyId is [" + r15 + "], cost time is " + r6);
        return;
    L5:
        if (r4.enableRoomSceneMerge() == false) goto L7;
        this.h = new InnerComponentListener();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.live.core.tetris.layer.core.ViewLayer, com.bytedance.android.live.core.tetris.layer.view.staticlayout.StaticFullScreenViewLayer, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.live.core.tetris.IComponentManager, com.bytedance.android.live.core.tetris.layer.core.delegate.a
    public final void X7(h<? extends h70.b> r9) {
        Intrinsics.checkNotNullParameter(r9, "layerDescriptor");
        if (ComponentManagerABHelper.INSTANCE.enableFilterWhenLoadElement() == false) goto L27;
        g70.a r0 = this.c;
        Intrinsics.checkNotNullParameter(r9, "$this$toLayerDescriptor");
        r0.getClass();
        Intrinsics.checkNotNullParameter(r9, "descriptor");
        j70.f r1 = r9.C(r0.g);
        r0.a.getClass();
        Intrinsics.checkNotNullParameter(r9, "descriptor");
        if (WidgetService.getInstance().isLayerLoaded(r9.getClass().getCanonicalName()) == false) goto L8;
        g.a(r0.h, r1, r0.a.a);
    L26:
        r9 = null;
    L28:
        if (r9 != null) goto L30;
        return;
    L30:
        ComponentCenter r2 = this.f;
        if (r2 == null) goto L33;
        Intrinsics.checkNotNullParameter(r9, "$this$toLayerDescriptorList");
        LayerDescriptorList r3 = new LayerDescriptorList();
        r3.add(r9);
        r2.j(r3);
    L33:
        f r4 = this.m;
        h70.b r5 = this.r.getComponentContext();
        Intrinsics.checkNotNullParameter(r4, "$this$traceLoadDescriptor");
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        Intrinsics.checkNotNullParameter(r9, "descriptor");
        r4.log("[" + r4.hashCode() + "]load descriptor, element is " + r9.C(r5));
        a r6 = b(r9);
        LinkedHashMap<a, i70.a> r7 = this.b;
        i70.a r8 = r7.get(r6);
        if (r8 != null) goto L36;
        r8 = a(r6);
        c(r8.getLayerDelegate());
        r7.put(r6, r8);
    L36:
        i70.a r11 = r8;
        r11.F(r9);
        h70.b r12 = this.r.getComponentContext();
        f r13 = this.m;
        Intrinsics.checkNotNullParameter(r13, "$this$traceLoadLayerElement");
        Intrinsics.checkNotNullParameter(r12, "layerContext");
        Intrinsics.checkNotNullParameter(r11, "layer");
        Intrinsics.checkNotNullParameter(r9, "descriptor");
        r13.log("[" + r13.hashCode() + "]load layer element, layerType is " + r11.getLayerTypeV2() + ", layerIndex is " + r11.getLayerIndex() + ", element is " + r9.C(r12));
        if ((r11 instanceof i70.b) == false) goto L42;
        com.bytedance.android.live.core.tetris.layer.core.engine.a r14 = this.i;
        if (r14 == null) goto L82;
        r14.a((i70.b) r11, r9, r12);
        return;
    L82:
        return;
    L42:
        if ((r11 instanceof ViewLayer) == false) goto L68;
        com.bytedance.android.live.core.tetris.layer.core.engine.b r15 = this.j;
        if (r15 == 0) goto L84;
        ?? r16 = (ViewLayer) r11;
        Intrinsics.checkNotNullParameter(r16, "layer");
        Intrinsics.checkNotNullParameter(r9, "descriptor");
        Intrinsics.checkNotNullParameter(r12, "layerContext");
        if (r15.a == false) goto L49;
        return;
    L49:
        if (r16.f2(r9.C(r12)) != null) goto L85;
        ViewGroup r17 = r15.e.a(r16.getLayerTypeV2());
        if (r17.indexOfChild(r16) != (-1)) goto L53;
        r17.addView(r16, com.bytedance.android.live.core.tetris.layer.core.engine.b.b(r17, r16), new FrameLayout.LayoutParams(-1, -1));
    L53:
        Element<?> r18 = r15.a(r16, r9, r12);
        r16.R5(r18);
        r16.U5(r12);
        View r19 = r18.b;
        if (r19 != null) goto L56;
    L63:
        r15.f.c(r16, r12);
        com.bytedance.android.live.core.tetris.componentx.component.b r21 = r15.h;
        if (r21 == null) goto L66;
        r21.f(r18);
    L66:
        r16.S5(r18);
        return;
    L56:
        if (r19.getParent() != null) goto L63;
        ConstraintLayout.LayoutParams r22 = new ConstraintLayout.LayoutParams(-2, -2);
        if (((Boolean) r15.c.getValue()).booleanValue() == false) goto L61;
        r16.addView(r18.b, r22);
        goto L63
    L61:
        if (r9.a > r16.getChildCount()) goto L63;
        r16.addView(r18.b, r9.a, r22);
        goto L63
    L85:
        return;
    L84:
        return;
    L68:
        if ((r11 instanceof i70.c) == false) goto L87;
        com.bytedance.android.live.core.tetris.layer.core.engine.c r23 = this.k;
        if (r23 == null) goto L88;
        i70.c r24 = (i70.c) r11;
        Intrinsics.checkNotNullParameter(r24, "layer");
        Intrinsics.checkNotNullParameter(r9, "descriptor");
        Intrinsics.checkNotNullParameter(r12, "layerContext");
        if (r23.b == true) goto L90;
        Element<?> r25 = r23.a(r9, r24, r12);
        if (r25 == null) goto L91;
        com.bytedance.android.live.core.tetris.componentx.component.b r26 = r23.e;
        if (r26 == null) goto L80;
        r26.f(r25);
    L80:
        Intrinsics.checkNotNullParameter(r25, "element");
        r24.a.b(r25);
        return;
    L91:
        return;
    L90:
        return;
    L88:
        return;
    L87:
        return;
    L8:
        if (r0.b.a(r9) == false) goto L10;
        g.a(r0.h, r1, r0.b.d);
        goto L26
    L10:
        g70.a.c r27 = r0.d;
        r27.getClass();
        Intrinsics.checkNotNullParameter(r9, "descriptor");
        j70.f r28 = r9.C(r27.a);
        r70.a<h70.b> r29 = r27.b;
        if (r29 != null) goto L13;
    L15:
        boolean r31 = false;
    L16:
        if (r31 == false) goto L18;
        g.a(r0.h, r1, r0.d.c);
        goto L26
    L18:
        g70.a.C0233a r32 = r0.c;
        r32.getClass();
        Intrinsics.checkNotNullParameter(r9, "descriptor");
        if ((!r9.D(r32.a)) == false) goto L21;
        g.a(r0.h, r1, r0.c.b);
        goto L26
    L21:
        g70.a.b r33 = r0.f;
        if (r33 == null) goto L28;
        Pair<s70.b<h70.b>, s70.a<s70.b<h70.b>, h70.b>> r34 = r33.a(r9);
        if (r34 == null) goto L28;
        s70.a r35 = (s70.a) r34.getSecond();
        ArrayList r36 = new ArrayList();
        r36.add(r34.getFirst());
        Unit r37 = Unit.INSTANCE;
        r35.a(r36);
        g.a(r0.h, r1, r0.f.a);
        goto L26
    L13:
        if (r29.a(r28, r27.a) == false) goto L15;
        r31 = true;
        goto L16
    L27:
        Intrinsics.checkNotNullParameter(r9, "$this$toLayerDescriptor");
        goto L28
    }

    public final i70.a a(a r9) {
        Context r5 = this.r.getContext();
        h70.b r4 = this.r.getComponentContext();
        f70.b r2 = r9.a;
        LayerIndex r3 = r9.b;
        com.bytedance.android.live.core.tetris.layer.core.delegate.c<h70.b> r11 = this.r.c().a();
        Class<? extends LayerDelegate<? extends i70.a, ? extends h70.b>> r0 = null;
        if (r11 == null) goto L5;
        Class<? extends LayerDelegate<? extends i70.a, ? extends h70.b>> r12 = r11.a(r3, r4);
    L6:
        int r1 = com.bytedance.android.live.core.tetris.componentx.b.b[r3.ordinal()];
        if (r1 == 1) goto L21;
        if (r1 == 2) goto L16;
        if ((r12 instanceof Class) == true) goto L13;
        Class<? extends LayerDelegate<? extends i70.a, ? extends h70.b>> r6 = null;
    L14:
        i70.a r7 = new ViewLayer(r2, r3, r4, r5, r6);
    L26:
        if ((r7 instanceof ViewLayer) == false) goto L28;
        this.r.c().b();
        ViewLayer r13 = (ViewLayer) r7;
        r13.setLayoutListener$tetris_saasRelease((com.bytedance.android.live.core.tetris.layer.core.layout.b) this.d.getValue());
        r13.setGlobalElementCenter$tetris_saasRelease((com.bytedance.android.live.core.tetris.layer.core.layout.b) this.d.getValue());
    L28:
        f r14 = this.m;
        Intrinsics.checkNotNullParameter(r14, "$this$traceCreateLayer");
        Intrinsics.checkNotNullParameter(r7, "layer");
        r14.log("[" + r14.hashCode() + "]create new layer, layerType is " + r7.getLayerTypeV2() + ", layerIndex is " + r7.getLayerIndex() + ", layerClass is " + r7.getClass().getSimpleName());
        return r7;
    L13:
        r6 = r12;
        goto L14
    L16:
        if ((r12 instanceof Class) == true) goto L18;
        Class<? extends LayerDelegate<? extends i70.a, ? extends h70.b>> r8 = null;
    L19:
        r7 = new i70.c(r2, r3, r4, r5, r8);
        goto L26
    L18:
        r8 = r12;
        goto L19
    L21:
        if ((r12 instanceof Class) == false) goto L24;
        r0 = r12;
    L24:
        r7 = new i70.b(r2, r3, r4, r0);
        goto L26
    L5:
        r12 = null;
        goto L6
    }

    public final a b(h<h70.b> r4) {
        f70.b r0 = r4.L();
        LayerIndex r5 = r4.E(this.r.getComponentContext());
        int r1 = com.bytedance.android.live.core.tetris.componentx.b.a[r5.ordinal()];
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L11;
        return new a(r0, r5);
    L11:
        return new a(r0, LayerIndex.INDEX_XML);
    L9:
        return new a(f70.b.c, LayerIndex.INDEX_SERVICE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(LayerDelegate<? extends i70.a, ? extends h70.b> r4) {
        com.bytedance.android.live.core.tetris.layer.view.a.C0161a r0 = this.r.a().i();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r4.b = r0;
        if ((r4 instanceof o70.a) == false) goto L6;
        this.r.a().d().a((o70.a) r4);
    L6:
        if ((r4 instanceof ViewLayerDelegate) == false) goto L8;
        ViewLayerDelegate r1 = (ViewLayerDelegate) r4;
        Intrinsics.checkNotNullParameter(this, "elementLoader");
        r1.h = this;
        LayoutManager r2 = (LayoutManager) this.e.getValue();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.g = r2;
    L8:
        LifecycleOwnerCompat.-CC.$default$getLifecycle(this).addObserver(r4);
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void dd(LayerDescriptorList r3) {
        Intrinsics.checkNotNullParameter(r3, "descriptorList");
        L3(r3, true, true, false);
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void dl(j70.f r4) {
        Intrinsics.checkNotNullParameter(r4, "elementType");
        ComponentCenter r0 = this.f;
        if (r0 == null) goto L5;
        r0.k(r4);
    L5:
        Iterator<T> r1 = this.b.values().iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        Object r2 = r1.next();
        if (((i70.a) r2).f2(r4) == null) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L7;
    L15:
        i70.a r5 = (i70.a) r2;
        if (r5 == null) goto L24;
        f(r5, r4);
        return;
    L24:
        return;
    L11:
        r3 = false;
        goto L12
    L14:
        r2 = null;
        goto L15
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final Element<?> f2(j70.f r3) {
        Intrinsics.checkNotNullParameter(r3, "elementType");
        Iterator<T> r0 = this.b.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Element<?> r1 = ((i70.a) r0.next()).f2(r3);
        if (r1 == null) goto L4;
        return r1;
    L8:
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void rq(BatchTogetherConditionManager.BatchLoadConditionType r2) {
        ComponentSchedulingManager r0 = this.g;
        if (r0 == null) goto L8;
        ComponentBatchBaseLoadState r1 = r0.i;
        if (r1 == null) goto L9;
        r1.c(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void c5(com.bytedance.android.live.core.tetris.componentx.schedule.c r3, q r4) {
        Intrinsics.checkNotNullParameter(r3, "conditionConfig");
        ComponentSchedulingManager r0 = this.g;
        if (r0 == null) goto L6;
        r0.h(r3, new com.bytedance.android.live.core.tetris.componentx.c(this), r4);
        return;
    }

    public final void e(i70.a r6, boolean r7) {
        h70.b r0 = this.r.getComponentContext();
        f r1 = this.m;
        Intrinsics.checkNotNullParameter(r1, "$this$traceLoadLayer");
        Intrinsics.checkNotNullParameter(r0, "layerContext");
        Intrinsics.checkNotNullParameter(r6, "layer");
        if (r1.a() == false) goto L10;
        Set<d<h70.b>> r2 = r6.getDescriptorSet();
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r3.add(((d) r4.next()).C(r0));
        goto L6
    L8:
        List r5 = CollectionsKt.toList(r3);
        r1.log("[" + r1.hashCode() + "]load layer, layerType is " + r6.getLayerTypeV2() + ", layerIndex is " + r6.getLayerIndex() + ", size is " + r5.size() + ", elements is " + r5);
    L10:
        if ((r6 instanceof i70.b) == false) goto L15;
        com.bytedance.android.live.core.tetris.layer.core.engine.a r8 = this.i;
        if (r8 == null) goto L26;
        r8.b((i70.b) r6, r0, r7);
        return;
    L26:
        return;
    L15:
        if ((r6 instanceof ViewLayer) == false) goto L20;
        com.bytedance.android.live.core.tetris.layer.core.engine.b r9 = this.j;
        if (r9 == null) goto L28;
        r9.c((ViewLayer) r6, r0, r7);
        return;
    L28:
        return;
    L20:
        if ((r6 instanceof i70.c) == false) goto L30;
        com.bytedance.android.live.core.tetris.layer.core.engine.c r11 = this.k;
        if (r11 == null) goto L31;
        r11.b((i70.c) r6, r0, r7);
        return;
    L31:
        return;
    }

    public final void f(i70.a r4, j70.f r5) {
        if ((r4 instanceof i70.b) == false) goto L12;
        com.bytedance.android.live.core.tetris.layer.core.engine.a r0 = this.i;
        if (r0 == null) goto L40;
        i70.b r6 = (i70.b) r4;
        Intrinsics.checkNotNullParameter(r6, "layer");
        Intrinsics.checkNotNullParameter(r5, "elementType");
        Element<?> r2 = r6.f2(r5);
        if (r2 == null) goto L41;
        Intrinsics.checkNotNullParameter(r5, "elementType");
        r6.a.l(r5);
        com.bytedance.android.live.core.tetris.componentx.component.b r7 = r0.c;
        if (r7 == null) goto L42;
        r7.b(r2);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L12:
        if ((r4 instanceof ViewLayer) == false) goto L21;
        com.bytedance.android.live.core.tetris.layer.core.engine.b r1 = this.j;
        if (r1 == null) goto L44;
        ViewLayer r8 = (ViewLayer) r4;
        Intrinsics.checkNotNullParameter(r8, "layer");
        Intrinsics.checkNotNullParameter(r5, "elementType");
        Element<?> r3 = r8.f2(r5);
        if (r3 == null) goto L45;
        r8.V5(r5);
        com.bytedance.android.live.core.tetris.componentx.component.b r9 = r1.h;
        if (r9 == null) goto L46;
        r9.b(r3);
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L21:
        if ((r4 instanceof i70.c) == false) goto L48;
        com.bytedance.android.live.core.tetris.layer.core.engine.c r11 = this.k;
        if (r11 == null) goto L49;
        i70.c r12 = (i70.c) r4;
        Intrinsics.checkNotNullParameter(r12, "layer");
        Intrinsics.checkNotNullParameter(r5, "elementType");
        Element<?> r13 = r12.f2(r5);
        if (r13 == null) goto L50;
        Intrinsics.checkNotNullParameter(r5, "elementType");
        Element<?> r14 = r12.f2(r5);
        if (r14 == null) goto L36;
        r12.a.l(r5);
        View r15 = r14.b;
        if (r15 == null) goto L36;
        ViewParent r16 = r15.getParent();
        if ((r16 instanceof ViewGroup) == true) goto L33;
        r16 = null;
    L33:
        ViewGroup r17 = (ViewGroup) r16;
        if (r17 == null) goto L36;
        r17.removeView(r15);
    L36:
        com.bytedance.android.live.core.tetris.componentx.component.b r18 = r11.e;
        if (r18 == null) goto L51;
        r18.b(r13);
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final <T extends LayerDelegate<? extends i70.a, ? extends h70.b>> T o4(f70.b r6, LayerIndex r7) {
        Intrinsics.checkNotNullParameter(r6, "layerType");
        Intrinsics.checkNotNullParameter(r7, "layerIndex");
        if (r7 != LayerIndex.INDEX_XML) goto L5;
        return null;
    L5:
        if (r7 == LayerIndex.INDEX_SERVICE) goto L30;
        Iterator<T> r0 = this.b.values().iterator();
    L9:
        if (r0.hasNext() == false) goto L18;
        Object r2 = r0.next();
        i70.a r3 = (i70.a) r2;
        if (r3.getLayerIndex() == r7) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L9;
    L19:
        i70.a r5 = (i70.a) r2;
        if (r5 != null) goto L22;
        return null;
    L22:
        return (T) r5.getLayerDelegate();
    L13:
        if (Intrinsics.areEqual(r3.getLayerTypeV2(), r6) == false) goto L15;
        r4 = true;
        goto L16
    L18:
        r2 = null;
        goto L19
    L30:
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void q6(List<? extends j70.f> r8, Map<f70.b, List<j70.f>> r9) {
        Intrinsics.checkNotNullParameter(r8, "refreshFreeComponents");
        List<j70.f> r1 = null;
        if (r9 != null) goto L38;
        ComponentSchedulingManager r11 = this.g;
        if (r11 == null) goto L12;
        Iterator r12 = ((ArrayList) r11.c()).iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        j70.f r2 = (j70.f) r12.next();
        if (r8.contains(r2) == true) goto L8;
        ALogger.i(this.a, "unload name = " + r2.b + " ___  " + r2.a);
        dl(r2);
    L12:
        ComponentSchedulingManager r13 = this.g;
        if (r13 == null) goto L15;
        r13.g();
    L15:
        ComponentSchedulingManager r14 = this.g;
        if (r14 != null) goto L18;
        return;
    L18:
        if (r14.e == null) goto L37;
        Map<f70.b, LayerDescriptorList> r15 = r14.f;
        if (r15 == null) goto L37;
        if (r14.g == null) goto L37;
        Intrinsics.checkNotNull(r15);
        r14.e(r15);
        LinkedHashMap<Integer, m> r16 = r14.o;
        if (r16 == null) goto L37;
        Iterator<Map.Entry<Integer, m>> r17 = r16.entrySet().iterator();
    L27:
        if (r17.hasNext() == false) goto L37;
        Map.Entry<Integer, m> r3 = r17.next();
        ComponentSchedulingManager.b r4 = r14.g;
        if (r4 == null) goto L31;
        r4.a(r3.getKey().intValue(), r3.getValue(), true);
    L31:
        q r5 = r14.h;
        if (r5 == null) goto L27;
        if (r3 == null) goto L35;
        Integer r6 = r3.getKey();
    L36:
        r5.l(null, Integer.valueOf(r6.intValue()).toString());
        goto L27
    L35:
        r6 = null;
    L37:
        ALogger.i(r14.a, "reloadScheduling结束");
        return;
    L38:
        ComponentSchedulingManager r18 = this.g;
        if (r18 == null) goto L41;
        r1 = r18.c();
    L41:
        Iterator r19 = ((LinkedHashMap) r9).entrySet().iterator();
    L43:
        if (r19.hasNext() == false) goto L63;
        List r7 = (List) ((Map.Entry) r19.next()).getValue();
        if (r7 == null) goto L43;
        Iterator r21 = r7.iterator();
    L48:
        if (r21.hasNext() == false) goto L43;
        j70.f r22 = (j70.f) r21.next();
        if (r22 == null) goto L48;
        if (r1 == null) goto L48;
        if (r1.contains(r22) != true) goto L48;
        Intrinsics.checkNotNullParameter(r22, "elementType");
        ComponentCenter r23 = this.f;
        if (r23 == null) goto L57;
        r23.k(r22);
    L57:
        Iterator<T> r24 = this.b.values().iterator();
    L59:
        if (r24.hasNext() == false) goto L48;
        i70.a r25 = (i70.a) r24.next();
        if (r25.f2(r22) == null) goto L59;
        f(r25, r22);
        goto L59
    L63:
        ComponentSchedulingManager r26 = this.g;
        if (r26 == null) goto L68;
        LayerDescriptorList r27 = (LayerDescriptorList) ((LinkedHashMap) r26.d(r9)).get(mg2.e.c);
        if (r27 == null) goto L68;
        dd(r27);
    L68:
        ComponentSchedulingManager r28 = this.g;
        if (r28 == null) goto L103;
        LayerDescriptorList r29 = (LayerDescriptorList) ((LinkedHashMap) r28.d(r9)).get(mg2.e.e);
        if (r29 == null) goto L104;
        dd(r29);
        return;
    L104:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void L3(LayerDescriptorList r8, boolean r9, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "descriptorList");
        if (r12 == true) goto L6;
        r8 = this.c.a(r8);
    L6:
        ComponentCenter r13 = this.f;
        if (r13 == null) goto L9;
        r13.j(r8);
    L9:
        f r14 = this.m;
        h70.b r1 = this.r.getComponentContext();
        Intrinsics.checkNotNullParameter(r14, "$this$traceLoadDescriptors");
        Intrinsics.checkNotNullParameter(r1, "layerContext");
        Intrinsics.checkNotNullParameter(r8, "descriptorList");
        if (r14.a() == false) goto L16;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<h<? extends h70.b>> r5 = r8.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        h<? extends h70.b> r6 = r5.next();
        Intrinsics.checkNotNullParameter(r6, "$this$toLayerDescriptor");
        r0.add(r6.C(r1));
        goto L13
    L15:
        r14.log("[" + r14.hashCode() + "]load descriptors, size is " + r8.size() + ", elements is " + CollectionsKt.toList(r0));
    L17:
        LinkedHashMap<a, i70.a> r15 = new LinkedHashMap();
        Iterator<h<? extends h70.b>> r16 = r8.iterator();
    L19:
        if (r16.hasNext() == false) goto L25;
        h<h70.b> r2 = (h) r16.next();
        Intrinsics.checkNotNullParameter(r2, "$this$toLayerDescriptor");
        a r3 = b(r2);
        LinkedHashMap<a, i70.a> r4 = this.b;
        i70.a r7 = r4.get(r3);
        if (r7 != null) goto L23;
        r7 = a(r3);
        c(r7.getLayerDelegate());
        r4.put(r3, r7);
    L23:
        i70.a r17 = r7;
        r17.F(r2);
        r15.put(r3, r17);
        String r18 = d80.b.a;
        d80.b.a(r2.getClass().getSimpleName());
        goto L19
    L25:
        if (((Boolean) this.p.getValue()).booleanValue() == true) goto L28;
        r15 = this.b;
    L28:
        if (r9 == false) goto L30;
        List r19 = CollectionsKt.sortedWith(r15.values(), new c());
    L31:
        Iterator<T> r21 = r19.iterator();
    L33:
        if (r21.hasNext() == false) goto L39;
        i70.a r22 = (i70.a) r21.next();
        if (((Boolean) this.o.getValue()).booleanValue() == false) goto L38;
        if (r11 == false) goto L38;
        this.r.d().invoke(new b(r22, this));
    L38:
        e(r22, r11);
        goto L33
    L39:
        String r23 = d80.b.a;
        d80.b.b(String.valueOf(this.n));
        return;
    L30:
        r19 = r15.values();
        goto L31
    L16:
        r14.log("[" + r14.hashCode() + "]load descriptors, size is " + r8.size());
        goto L17
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void iS(com.bytedance.android.live.core.tetris.componentx.schedule.c r9, ComponentSchedulingManager.ScenInfo r11, Map r12, e0 r13, j r14, q r15) {
        Intrinsics.checkNotNullParameter(r9, "conditionConfig");
        Intrinsics.checkNotNullParameter(r11, "scene");
        Intrinsics.checkNotNullParameter(r12, "descriptorList");
        Intrinsics.checkNotNullParameter(r13, "layerContext");
        String r4 = d80.b.a;
        if (v.a() == false) goto L6;
        ((ArrayList) com.bytedance.android.livesdk.sharedpref.b.Q3.getValue()).clear();
    L6:
        this.g = new ComponentSchedulingManager();
        InnerComponentListener r5 = this.h;
        if (r5 == null) goto L9;
        Intrinsics.checkNotNullParameter(r13, "layerContext");
        r5.j = r13;
    L9:
        InnerComponentListener r3 = this.h;
        if (r3 == null) goto L12;
        ComponentSchedulingManager r6 = this.g;
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNullParameter(r6, "componentSchedulingManager");
        r3.b = r6;
    L12:
        ComponentSchedulingManager r7 = this.g;
        if (r7 == null) goto L15;
        Intrinsics.checkNotNullParameter(r13, "context");
        r7.m = r13;
    L15:
        ComponentSchedulingManager r16 = this.g;
        if (r16 == null) goto L26;
        r16.b = r14;
        ComponentSchedulingManager.SchedueType.Companion.getClass();
        Intrinsics.checkNotNullParameter("together", "key");
        ComponentSchedulingManager.SchedueType[] r17 = ComponentSchedulingManager.SchedueType.values();
        int r8 = r17.length;
        int r18 = 0;
    L18:
        if (r18 >= r8) goto L23;
        ComponentSchedulingManager.SchedueType r19 = r17[r18];
        if (Intrinsics.areEqual(r19.getKey(), "together") == true) goto L24;
        r18 = r18 + 1;
    L24:
        if (r19 == null) goto L26;
        r16.d = r19;
        goto L26
    L23:
        r19 = null;
    L26:
        ComponentSchedulingManager r110 = this.g;
        if (r110 == null) goto L29;
        Intrinsics.checkNotNullParameter(r11, "scene");
        r110.l = r11;
    L29:
        ComponentSchedulingManager r111 = this.g;
        if (r111 == null) goto L37;
        g70.a r112 = this.c;
        com.bytedance.android.live.core.tetris.componentx.c r113 = new com.bytedance.android.live.core.tetris.componentx.c(this);
        Intrinsics.checkNotNullParameter(r9, "conditionConfig");
        Intrinsics.checkNotNullParameter(r112, "descriptorFilter");
        Intrinsics.checkNotNullParameter(r12, "descriptorList");
        Intrinsics.checkNotNullParameter(r113, "loadNotify");
        r111.c = new com.bytedance.android.live.core.tetris.componentx.schedule.f(r111.b);
        r111.e = r112;
        r111.f = r12;
        r111.h = r15;
        r111.e(r12);
        if (r9.b == true) goto L38;
        r111.h(r9, r113, r15);
        return;
    L38:
        return;
    }
}
