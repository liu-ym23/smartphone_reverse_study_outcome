package com.bytedance.android.live.core.tetris.layer.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.IComponentManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.BatchTogetherConditionManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.ComponentSchedulingManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.c;
import com.bytedance.android.live.core.tetris.componentx.schedule.j;
import com.bytedance.android.live.core.tetris.componentx.schedule.q;
import com.bytedance.android.live.core.tetris.layer.core.ViewLayer;
import com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.delegate.ViewLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.ElementBuilderMap;
import com.bytedance.android.live.core.tetris.layer.core.engine.ServiceLayerEngine;
import com.bytedance.android.live.core.tetris.layer.core.engine.ViewLayerEngine;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.tetris.layer.core.layout.LayoutManager;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.apm.impl.protector.RunnableProtector;
import j70.f;
import j70.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007J\b\u0010\t\u001a\u00020\u0005H\u0007J\b\u0010\n\u001a\u00020\u0005H\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/view/LayerManager;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/live/core/tetris/layer/core/delegate/a;", "Lcom/bytedance/android/live/core/tetris/IComponentManager;", "", "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LayerManager implements LifecycleObserver, LifecycleOwnerCompat, com.bytedance.android.live.core.tetris.layer.core.delegate.a, IComponentManager {
    public final Lazy a;
    public final Lazy b;
    public ServiceLayerEngine c;
    public ViewLayerEngine d;
    public final List<i70.a> e;
    public com.bytedance.android.live.core.tetris.layer.view.a f;
    public boolean g;
    public final Context h;
    public final LifecycleRegistry i;
    public DataCenter j;
    public final Lazy k;
    public final FrameLayout l;
    public final LifecycleOwner m;

    public static final class a implements Runnable {
        public final /* synthetic */ i70.a a;
        public final /* synthetic */ LayerManager b;

        public a(i70.a r1, LayerManager r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LayerManager r0 = this.b;     // Catch: Throwable -> L9
            ServiceLayerEngine r1 = r0.c;     // Catch: Throwable -> L9
            if (r1 == null) goto L12;
            i70.a r2 = this.a;     // Catch: Throwable -> L9
            com.bytedance.android.live.core.tetris.layer.view.a r3 = r0.f;     // Catch: Throwable -> L9
            if (r3 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("layerConfig");     // Catch: Throwable -> L9
        L7:
            r1.b(r2, r3.a(), true);     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ i70.a a;
        public final /* synthetic */ LayerManager b;

        public b(i70.a r1, LayerManager r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LayerManager r0 = this.b;     // Catch: Throwable -> L9
            ViewLayerEngine r1 = r0.d;     // Catch: Throwable -> L9
            if (r1 == null) goto L12;
            i70.a r2 = this.a;     // Catch: Throwable -> L9
            com.bytedance.android.live.core.tetris.layer.view.a r3 = r0.f;     // Catch: Throwable -> L9
            if (r3 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("layerConfig");     // Catch: Throwable -> L9
        L7:
            r1.d(r2, r3.a(), true);     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void C8() {
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void c5(c r1, q r2) {
        Intrinsics.checkNotNullParameter(r1, "conditionConfig");
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final com.bytedance.android.live.core.tetris.componentx.a config() {
        return null;
    }

    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void iS(c r1, ComponentSchedulingManager.ScenInfo r2, Map r3, e0 r4, j r5, q r6) {
        Intrinsics.checkNotNullParameter(r1, "conditionConfig");
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "descriptorList");
        Intrinsics.checkNotNullParameter(r4, "layerContext");
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void q6(List<? extends f> r1, Map<f70.b, List<f>> r2) {
        Intrinsics.checkNotNullParameter(r1, "refreshFreeComponents");
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void rq(BatchTogetherConditionManager.BatchLoadConditionType r1) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        this.i.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        if (this.i.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        this.c = null;
        ViewLayerEngine r1 = this.d;
        if (r1 == null) goto L8;
        r1.e = null;
    L8:
        this.d = null;
        this.j = null;
        ((ArrayList) this.e).clear();
        this.i.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        if (this.i.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        this.i.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        this.i.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        this.i.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        if (this.i.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        this.i.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public final Lifecycle getLifecycleCompat() {
        return this.i;
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void release() {
        onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.live.core.tetris.layer.core.ViewLayer, com.bytedance.android.live.core.tetris.layer.view.staticlayout.StaticFullScreenViewLayer, java.lang.Object] */
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
    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.a
    public final void X7(h<? extends h70.b> r13) {
        Intrinsics.checkNotNullParameter(r13, "layerDescriptor");
        int r1 = q70.c.a;
        Context r6 = this.h;
        com.bytedance.android.live.core.tetris.layer.view.a r2 = this.f;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerConfig");
    L5:
        h70.b r5 = r2.a();
        com.bytedance.android.live.core.tetris.layer.view.a r3 = this.f;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("layerConfig");
    L8:
        com.bytedance.android.live.core.tetris.layer.core.delegate.c<h70.b> r4 = r3.a;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("layerDelegateConfig");
    L11:
        List<i70.a> r7 = this.e;
        com.bytedance.android.live.core.tetris.layer.view.a r8 = this.f;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("layerConfig");
    L14:
        r70.a<h70.b> r9 = r8.f;
        Intrinsics.checkNotNullParameter(r13, "layerDescriptor");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        Intrinsics.checkNotNullParameter(r4, "layerDelegateConfig");
        Intrinsics.checkNotNullParameter(r7, "layers");
        i70.a r11 = null;
        r11 = null;
        Object r12 = null;
        if (r13.D(r5) == true) goto L17;
    L40:
        if (r11 == null) goto L78;
        a(r11.getLayerDelegate());
        if ((r11 instanceof i70.b) == false) goto L50;
        ServiceLayerEngine r0 = this.c;
        if (r0 == null) goto L79;
        i70.b r14 = (i70.b) r11;
        com.bytedance.android.live.core.tetris.layer.view.a r15 = this.f;
        if (r15 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("layerConfig");
    L48:
        r0.a(r14, r13, r15.a());
        return;
    L79:
        return;
    L50:
        if ((r11 instanceof ViewLayer) == false) goto L81;
        ?? r16 = (ViewLayer) r11;
        r16.setLayoutListener$tetris_saasRelease((com.bytedance.android.live.core.tetris.layer.core.layout.b) this.a.getValue());
        r16.setGlobalElementCenter$tetris_saasRelease((com.bytedance.android.live.core.tetris.layer.core.layout.b) this.a.getValue());
        ViewLayerEngine r17 = this.d;
        if (r17 == 0) goto L82;
        com.bytedance.android.live.core.tetris.layer.view.a r18 = this.f;
        if (r18 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("layerConfig");
    L56:
        h70.b r19 = r18.a();
        Intrinsics.checkNotNullParameter(r16, "layer");
        Intrinsics.checkNotNullParameter(r13, "descriptor");
        Intrinsics.checkNotNullParameter(r19, "layerContext");
        if (r16.f2(r13.C(r19)) == null) goto L59;
        return;
    L59:
        if (r17.h.indexOfChild(r16) != (-1)) goto L61;
        r17.h.addView(r16, r17.b(r16), new FrameLayout.LayoutParams(-1, -1));
    L61:
        Element<?> r21 = r17.a(r16, r13, r19);
        r16.R5(r21);
        r16.U5(r19);
        View r22 = r21.b;
        if (r22 != null) goto L64;
    L71:
        r17.f.c(r16, r17.j.a());
        r16.S5(r21);
        return;
    L64:
        if (r22.getParent() != null) goto L71;
        ConstraintLayout.LayoutParams r23 = new ConstraintLayout.LayoutParams(-2, -2);
        if (((Boolean) r17.c.getValue()).booleanValue() == false) goto L69;
        r16.addView(r21.b, r23);
        goto L71
    L69:
        if (r13.a > r16.getChildCount()) goto L71;
        r16.addView(r21.b, r13.a, r23);
        goto L71
    L82:
        return;
    L81:
        return;
    L78:
        return;
    L17:
        if (r9 != null) goto L19;
    L21:
        LayerIndex r24 = r13.E(r5);
        ArrayList r110 = (ArrayList) r7;
        Iterator r25 = r110.iterator();
    L23:
        if (r25.hasNext() == false) goto L30;
        Object r26 = r25.next();
        if (((i70.a) r26).getLayerIndex() != r24) goto L27;
        boolean r111 = true;
    L28:
        if (r111 == false) goto L23;
        r12 = r26;
        goto L30
    L27:
        r111 = false;
    L30:
        r11 = (i70.a) r12;
        if (r11 != null) goto L37;
        Class<? extends LayerDelegate<? extends i70.a, ? extends h70.b>> r27 = r4.a(r24, r5);
        if (r24 != LayerIndex.INDEX_SERVICE) goto L35;
        i70.a r28 = new i70.b(f70.b.c, r24, r5, r27);
    L36:
        r110.add(r28);
        r11 = r28;
        goto L37
    L35:
        r28 = new ViewLayer(f70.b.c, r24, r5, r6, r27);
    L37:
        r11.F(r13);
        if (r110.size() <= 1) goto L40;
        CollectionsKt.sortWith(r110, new q70.a());
        goto L40
    L19:
        if (r9.a(r13.C(r5), r5) != true) goto L21;
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(LayerDelegate<? extends i70.a, ? extends h70.b> r4) {
        com.bytedance.android.live.core.tetris.layer.view.a r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerConfig");
    L5:
        com.bytedance.android.live.core.tetris.layer.view.a.C0161a r1 = r0.k;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r4.b = r1;
        if ((r4 instanceof o70.a) == false) goto L15;
        com.bytedance.android.live.core.tetris.layer.view.a r2 = this.f;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("layerConfig");
    L10:
        LayerEventDispatcher r3 = r2.d;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("layerEventDispatcher");
    L13:
        r3.a((o70.a) r4);
    L15:
        if ((r4 instanceof ViewLayerDelegate) == false) goto L17;
        ViewLayerDelegate r5 = (ViewLayerDelegate) r4;
        LayoutManager r6 = (LayoutManager) this.b.getValue();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.g = r6;
        Intrinsics.checkNotNullParameter(this, "elementLoader");
        r5.h = this;
    L17:
        LifecycleOwnerCompat.-CC.$default$getLifecycle(this).addObserver(r4);
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void dd(LayerDescriptorList r3) {
        Intrinsics.checkNotNullParameter(r3, "descriptorList");
        L3(r3, true, true, false);
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void dl(f r5) {
        Intrinsics.checkNotNullParameter(r5, "elementType");
        Iterator r1 = ((ArrayList) this.e).iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        if (((i70.a) r2).f2(r5) == null) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        i70.a r4 = (i70.a) r2;
        if (r4 != null) goto L15;
        return;
    L15:
        if ((r4 instanceof i70.b) == false) goto L20;
        if (this.c == null) goto L31;
        i70.b r6 = (i70.b) r4;
        Intrinsics.checkNotNullParameter(r6, "layer");
        Intrinsics.checkNotNullParameter(r5, "elementType");
        Intrinsics.checkNotNullParameter(r5, "elementType");
        r6.a.l(r5);
        return;
    L31:
        return;
    L20:
        if ((r4 instanceof ViewLayer) == true) goto L22;
        return;
    L22:
        if (this.d == null) goto L34;
        ViewLayer r7 = (ViewLayer) r4;
        Intrinsics.checkNotNullParameter(r7, "layer");
        Intrinsics.checkNotNullParameter(r5, "elementType");
        r7.V5(r5);
        return;
    L34:
        return;
    L8:
        r3 = false;
        goto L9
    L11:
        r2 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final Element<?> f2(f r3) {
        Intrinsics.checkNotNullParameter(r3, "elementType");
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Element<?> r1 = ((i70.a) r0.next()).f2(r3);
        if (r1 == null) goto L4;
        return r1;
    L8:
        return null;
    }

    public LayerManager(FrameLayout r2, LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r2, "masterView");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        this.l = r2;
        this.m = r3;
        this.a = LazyKt.lazy(LayerManager$globalElementCenter$2.INSTANCE);
        this.b = LazyKt.lazy(new LayerManager$layoutManager$2(this));
        this.e = new ArrayList();
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
        this.h = r2.getContext();
        this.i = new LifecycleRegistry(this);
        r3.getLifecycle().addObserver(this);
        this.k = LazyKt.lazy(LayerManager$enableLayerOpt$2.INSTANCE);
    }

    public final void b(com.bytedance.android.live.core.tetris.layer.view.a r11, DataCenter r12) {
        Intrinsics.checkNotNullParameter(r11, "layerConfig");
        if (this.g == false) goto L5;
        return;
    L5:
        this.f = r11;
        this.j = r12;
        ElementBuilderMap r1 = r11.b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("elementBuilderMap");
    L8:
        this.c = new ServiceLayerEngine(r1, r11.a(), r11);
        LayoutManager r5 = (LayoutManager) this.b.getValue();
        ElementBuilderMap r6 = r11.b;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("elementBuilderMap");
    L11:
        ViewLayerEngine r0 = new ViewLayerEngine(r5, r6, this.l, r11.a(), r11);
        this.d = r0;
        r0.e = r12;
        this.g = true;
    }

    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final <T extends LayerDelegate<? extends i70.a, ? extends h70.b>> T o4(f70.b r4, LayerIndex r5) {
        Intrinsics.checkNotNullParameter(r4, "layerType");
        Intrinsics.checkNotNullParameter(r5, "layerIndex");
        Iterator<T> r6 = this.e.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        Object r0 = r6.next();
        if (((i70.a) r0).getLayerIndex() != r5) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        i70.a r1 = (i70.a) r0;
        if (r1 != null) goto L15;
        return null;
    L15:
        return (T) r1.getLayerDelegate();
    L8:
        r2 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }

    /* JADX WARN: Type inference failed for: r9v14, types: [T extends h70.b, h70.b, java.lang.Object] */
    @Override // com.bytedance.android.live.core.tetris.IComponentManager
    public final void L3(LayerDescriptorList r25, boolean r26, boolean r27, boolean r28) {
        Intrinsics.checkNotNullParameter(r25, "descriptorList");
        ArrayList r4 = new ArrayList();
        Iterator r5 = r25.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        h r6 = (h) r5.next();
        if (WidgetService.getInstance().isLayerLoaded(r6.getClass().getCanonicalName()) == false) goto L4;
        r4.add(r6);
        goto L4
    L9:
        if (r4.size() == 0) goto L11;
        r25.removeAll(r4);
    L11:
        com.bytedance.android.live.core.tetris.layer.view.a r7 = this.f;
        String r8 = "layerConfig";
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("layerConfig");
    L14:
        LayerEventDispatcher r9 = r7.d;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("layerEventDispatcher");
    L17:
        com.bytedance.android.live.core.tetris.layer.view.a r11 = this.f;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("layerConfig");
    L20:
        LinkedHashMap r12 = (LinkedHashMap) r11.h;
        Iterator r13 = r12.values().iterator();
    L22:
        if (r13.hasNext() == false) goto L27;
        s70.a r14 = (s70.a) r13.next();
        com.bytedance.android.live.core.tetris.layer.view.a r15 = this.f;
        if (r15 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("layerConfig");
    L26:
        ?? r16 = r15.a();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r14.a = r16;
        goto L22
    L27:
        int r17 = q70.c.a;
        com.bytedance.android.live.core.tetris.layer.view.a r18 = this.f;
        if (r18 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("layerConfig");
    L30:
        r70.b<h70.b> r19 = r18.e;
        com.bytedance.android.live.core.tetris.layer.view.a r21 = this.f;
        if (r21 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("layerConfig");
    L33:
        h70.b r22 = r21.a();
        Context r110 = this.h;
        com.bytedance.android.live.core.tetris.layer.view.a r23 = this.f;
        if (r23 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("layerConfig");
    L36:
        com.bytedance.android.live.core.tetris.layer.core.delegate.c<h70.b> r111 = r23.a;
        if (r111 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("layerDelegateConfig");
    L39:
        List<i70.a> r112 = this.e;
        com.bytedance.android.live.core.tetris.layer.view.a r113 = this.f;
        if (r113 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("layerConfig");
    L42:
        r113.getClass();
        com.bytedance.android.live.core.tetris.layer.view.a r114 = this.f;
        if (r114 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("layerConfig");
    L45:
        r70.a<h70.b> r115 = r114.f;
        Intrinsics.checkNotNullParameter(r25, "descriptorList");
        Intrinsics.checkNotNullParameter(r22, "layerContext");
        Intrinsics.checkNotNullParameter(r110, "context");
        Intrinsics.checkNotNullParameter(r111, "layerDelegateConfig");
        Intrinsics.checkNotNullParameter(r112, "layers");
        LinkedHashMap r3 = new LinkedHashMap();
        ArrayList r116 = (ArrayList) r112;
        Iterator r24 = r116.iterator();
    L47:
        if (r24.hasNext() == false) goto L50;
        i70.a r117 = (i70.a) r24.next();
        r3.put(r117.getLayerIndex(), r117);
        goto L47
    L50:
        if ((!r12.isEmpty()) != true) goto L52;
        boolean r118 = true;
    L54:
        if (r118 == false) goto L56;
        LinkedHashMap r119 = new LinkedHashMap();
    L57:
        if (r19 == null) goto L59;
        List<f> r29 = r19.a(r22);
    L60:
        Iterator r1 = r25.iterator();
    L62:
        if (r1.hasNext() == false) goto L112;
        h r31 = (h) r1.next();
        if (r31 == null) goto L111;
        Iterator r210 = r1;
        f r2 = r31.C(r22);
        if (r29 == null) goto L70;
        if (r29.contains(r2) == true) goto L70;
    L75:
        r9 = r9;
        r8 = r8;
        List<f> r211 = r29;
        r119 = r119;
        r116 = r116;
        r115 = r115;
        r111 = r111;
    L109:
        r1 = r210;
        r29 = r211;
        r116 = r116;
        r119 = r119;
        r9 = r9;
        r115 = r115;
        r8 = r8;
        r111 = r111;
    L70:
        if (r31.D(r22) == false) goto L75;
        if (r115 != null) goto L74;
    L76:
        String r120 = d80.b.a;
        d80.b.a(r31.getClass().getSimpleName());
        r211 = r29;
        LayerIndex r32 = r31.E(r22);
        if (r3.containsKey(r32) == true) goto L83;
        Class<? extends LayerDelegate<? extends i70.a, ? extends h70.b>> r33 = r111.a(r32, r22);
        if (r32 != LayerIndex.INDEX_SERVICE) goto L81;
        i70.a r121 = new i70.b(f70.b.c, r32, r22, r33);
        h r34 = r31;
    L82:
        r3.put(r32, r121);
    L84:
        if (r118 == true) goto L86;
    L105:
        boolean r35 = false;
    L106:
        if (r35 == true) goto L108;
        r121.F(r34);
        goto L109
    L108:
        int r36 = h70.a.a;
        ALogger.i("Layer", r2 + " should be pending.");
        goto L109
    L86:
        if ((r34 instanceof s70.b) == false) goto L105;
        s70.b r37 = (s70.b) r34;
        if (r37.A(r22) == false) goto L105;
        Set r38 = r12.entrySet();
        if (r38 == null) goto L105;
        Iterator r39 = r38.iterator();
        r35 = false;
    L93:
        if (r39.hasNext() == false) goto L106;
        Map.Entry r122 = (Map.Entry) r39.next();
        if (((Class) r122.getKey()).isAssignableFrom(r37.getClass()) == false) goto L93;
        if (r119 == null) goto L101;
        Object r41 = r122.getKey();
        Object r123 = r119.get(r41);
        if (r123 != null) goto L100;
        r123 = new ArrayList();
        r119.put(r41, r123);
    L100:
        ArrayList r124 = (ArrayList) r123;
    L102:
        if (r124 == null) goto L104;
        r124.add(r37);
    L104:
        r35 = true;
        goto L93
    L101:
        r124 = null;
        goto L102
    L81:
        r34 = r31;
        r121 = new ViewLayer(f70.b.c, r32, r22, r110, r33);
        goto L82
    L83:
        r8 = r8;
        r34 = r31;
        r119 = r119;
        r116 = r116;
        r115 = r115;
        r111 = r111;
        Object r42 = r3.get(r32);
        Intrinsics.checkNotNull(r42);
        r121 = (i70.a) r42;
        goto L84
    L74:
        if (r115.a(r2, r22) == false) goto L76;
    L111:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptor<com.bytedance.android.live.core.tetris.layer.LayerContext>");
    L112:
        LayerEventDispatcher r125 = r9;
        String r212 = r8;
        LinkedHashMap r43 = r119;
        ArrayList r0 = r116;
        Iterator r44 = r3.values().iterator();
    L114:
        if (r44.hasNext() == false) goto L118;
        i70.a r45 = (i70.a) r44.next();
        if (r0.contains(r45) == true) goto L114;
        r0.add(r45);
        goto L114
    L118:
        if (r26 == false) goto L120;
        ArrayList r126 = r0;
    L121:
        if (r126 != null) goto L123;
    L125:
        if (r43 == null) goto L135;
        Iterator r46 = r43.entrySet().iterator();
    L128:
        if (r46.hasNext() == false) goto L135;
        Map.Entry r47 = (Map.Entry) r46.next();
        Class r48 = (Class) r47.getKey();
        ArrayList r49 = (ArrayList) r47.getValue();
        s70.a r51 = (s70.a) r12.get(r48);
        if (r51 == null) goto L128;
        if (r49 == null) goto L134;
        r51.a(r49);
        goto L128
    L134:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.bytedance.android.live.core.tetris.layer.core.pending.PendingFlag<com.bytedance.android.live.core.tetris.layer.LayerContext>> /* = java.util.ArrayList<com.bytedance.android.live.core.tetris.layer.core.pending.PendingFlag<com.bytedance.android.live.core.tetris.layer.LayerContext>> */");
    L135:
        Iterator r52 = ((ArrayList) this.e).iterator();
    L137:
        if (r52.hasNext() == false) goto L164;
        i70.a r53 = (i70.a) r52.next();
        a(r53.getLayerDelegate());
        if ((r53 instanceof i70.b) == true) goto L141;
        if ((r53 instanceof ViewLayer) == false) goto L137;
        ViewLayer r54 = (ViewLayer) r53;
        r54.setLayoutListener$tetris_saasRelease((com.bytedance.android.live.core.tetris.layer.core.layout.b) this.a.getValue());
        r54.setGlobalElementCenter$tetris_saasRelease((com.bytedance.android.live.core.tetris.layer.core.layout.b) this.a.getValue());
        if (((Boolean) this.k.getValue()).booleanValue() == false) goto L158;
        if (r27 == false) goto L158;
        i0.e(c50.b.b(this.j), new b(r53, this));
    L158:
        ViewLayerEngine r55 = this.d;
        if (r55 == null) goto L137;
        com.bytedance.android.live.core.tetris.layer.view.a r56 = this.f;
        if (r56 != null) goto L163;
        Intrinsics.throwUninitializedPropertyAccessException(r212);
    L163:
        r55.c(r54, r56.a(), r27);
        goto L137
    L141:
        if (((Boolean) this.k.getValue()).booleanValue() == false) goto L145;
        boolean r57 = r27;
        if (r57 == true) goto L144;
    L146:
        ServiceLayerEngine r58 = this.c;
        if (r58 == null) goto L137;
        i70.b r59 = (i70.b) r53;
        com.bytedance.android.live.core.tetris.layer.view.a r61 = this.f;
        if (r61 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException(r212);
    L151:
        r58.c(r59, r61.a(), r57);
        goto L137
    L144:
        i0.e(c50.b.b(this.j), new a(r53, this));
        goto L137
    L145:
        r57 = r27;
        goto L146
    L164:
        LifecycleOwnerCompat.-CC.$default$getLifecycle(this).addObserver(r125);
        return;
    L123:
        if (r126.size() <= 1) goto L125;
        CollectionsKt.sortWith(r126, new q70.b());
        goto L125
    L120:
        r126 = null;
        goto L121
    L59:
        r29 = null;
        goto L60
    L56:
        r119 = null;
        goto L57
    L52:
        r118 = false;
        goto L54
    }
}
