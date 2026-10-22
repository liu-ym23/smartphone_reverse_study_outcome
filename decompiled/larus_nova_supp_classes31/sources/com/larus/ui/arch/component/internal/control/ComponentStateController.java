package com.larus.ui.arch.component.internal.control;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.larus.ui.arch.component.internal.attach.Attachable;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u001d\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\b#J\b\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010'\u001a\u00020\u001aH\u0002J\u0015\u0010(\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\b)J\b\u0010*\u001a\u00020\u001aH\u0002J.\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u00100\u001a\u00020\rH\u0002J\u001a\u00101\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u00102\u001a\u00020\u001a2\b\u00103\u001a\u0004\u0018\u00010\u0005J\u000e\u00104\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u0005J\u000e\u00105\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0010J\u000e\u00106\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0010J$\u00107\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u00100\u001a\u00020\rJ\u000e\u00108\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0010J\u000e\u00109\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0010J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b¨\u0006<"}, d2 = {"Lcom/larus/ui/arch/component/internal/control/ComponentStateController;", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "context", "", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/Object;)V", "getContext$annotations", "()V", "getContext", "()Ljava/lang/Object;", "fragmentViewCreated", "", "componentList", "", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "value", "containerView", "getContainerView$annotations", "getContainerView", "onStateChanged", "", "source", "event", "Landroidx/lifecycle/Lifecycle$Event;", "onCreate", "onFragmentViewCreated", "view", "attachable", "Lcom/larus/ui/arch/component/internal/attach/Attachable;", "onFragmentViewCreated$component_release", "onStart", "onResume", "onPause", "onStop", "onFragmentViewDestroyed", "onFragmentViewDestroyed$component_release", "onDestroy", "handleLifecycleState", "dstState", "Landroidx/lifecycle/Lifecycle$State;", "component", "Lcom/larus/ui/arch/component/external/delegate/BaseComponentFeatureInternal;", "byLazy", "lazyHandleOnParentViewCreated", "attachToParent", "container", "setContainerView", "attachLazySlotComponent", "attachLazyComponent", "changeLazyComponentState", "attachComponent", "detachComponent", "getChildren", "Companion", "component_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ComponentStateController implements LifecycleEventObserver {
    public final LifecycleOwner a;
    public final Object b;
    public volatile boolean c;
    public final List<ComponentFeature> d;
    public Object e;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L35:
            r0[Lifecycle.Event.ON_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L47:
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L37:
            r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L39:
            r0[Lifecycle.Event.ON_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L29:
            r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L12:
            a = r0;
            int[] r1 = new int[Lifecycle.State.values().length];
            r1[Lifecycle.State.CREATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L43:
            r1[Lifecycle.State.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L31:
            r1[Lifecycle.State.RESUMED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L41:
            r1[Lifecycle.State.DESTROYED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L17:
            b = r1;
        }
    }

    static {
    }

    public final Lifecycle d() {
        return this.a.getLifecycle();
    }

    public final Object getContext() {
        return this.b;
    }

    public final void a(ComponentFeature r3) {
        Intrinsics.checkNotNullParameter(r3, "component");
        if (d().getCurrentState().compareTo(Lifecycle.State.DESTROYED) > 0) goto L5;
        return;
    L5:
        ((ArrayList) this.d).add(r3);
        r3.getClass();
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        ((BaseComponentFeatureInternal) r3).e = this;
        int r0 = y1a.a.a;
        y1a.a.a("ComponentStateController", "component: " + Reflection.getOrCreateKotlinClass(r3.getClass()).getSimpleName() + ", lifecycle " + this.a);
        r3.D2(this.a);
    }

    public final void b(Object r1) {
        this.e = r1;
        d().removeObserver(this);
        d().addObserver(this);
    }

    public ComponentStateController(LifecycleOwner r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
        this.d = new ArrayList();
    }

    public final void f(BaseComponentFeatureInternal r2, Attachable r3) {
        if (this.c == false) goto L7;
        if (r3 == null) goto L8;
        r2.v2(r3);
        y1a.a.a("ComponentStateController", "lazyHandleOnParentViewCreated");
        return;
    L8:
        return;
    }

    public final void onStateChanged(LifecycleOwner r4, Lifecycle.Event r5) {
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = y1a.a.a;
        y1a.a.a("ComponentStateController", "onStateChanged " + r5 + ", " + Reflection.getOrCreateKotlinClass(r4.getClass()).getSimpleName());
        switch(b.a[r5.ordinal()]) {
            case 1: goto L26;
            case 2: goto L22;
            case 3: goto L18;
            case 4: goto L14;
            case 5: goto L10;
            case 6: goto L5;
            default: goto L37;
        };
    L5:
        Iterator r6 = ((ArrayList) this.d).iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        e(Lifecycle.State.DESTROYED, (ComponentFeature) r6.next(), null, false);
        goto L7
    L9:
        ((ArrayList) this.d).clear();
        d().removeObserver(this);
        this.e = null;
        return;
    L10:
        Iterator r7 = ((ArrayList) this.d).iterator();
    L12:
        if (r7.hasNext() == false) goto L38;
        e(Lifecycle.State.CREATED, (ComponentFeature) r7.next(), null, false);
        goto L12
    L38:
        return;
    L14:
        Iterator r8 = ((ArrayList) this.d).iterator();
    L16:
        if (r8.hasNext() == false) goto L39;
        e(Lifecycle.State.STARTED, (ComponentFeature) r8.next(), null, false);
        goto L16
    L39:
        return;
    L18:
        Iterator r9 = ((ArrayList) this.d).iterator();
    L20:
        if (r9.hasNext() == false) goto L40;
        e(Lifecycle.State.RESUMED, (ComponentFeature) r9.next(), null, false);
        goto L20
    L40:
        return;
    L22:
        Iterator r10 = ((ArrayList) this.d).iterator();
    L24:
        if (r10.hasNext() == false) goto L41;
        e(Lifecycle.State.STARTED, (ComponentFeature) r10.next(), null, false);
        goto L24
    L41:
        return;
    L26:
        Iterator r11 = ((ArrayList) this.d).iterator();
    L28:
        if (r11.hasNext() == false) goto L42;
        e(Lifecycle.State.CREATED, (ComponentFeature) r11.next(), null, false);
        goto L28
    L42:
        return;
    }

    public final void c(ComponentFeature r3, Attachable r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "component");
        if (((ArrayList) this.d).contains(r3) == true) goto L5;
        return;
    L5:
        if (r3.getLifecycle().getCurrentState() == d().getCurrentState()) goto L9;
        e(d().getCurrentState(), r3, r4, r5);
        return;
    }

    public final void e(Lifecycle.State r2, BaseComponentFeatureInternal r3, Attachable r4, boolean r5) {
        int r6 = b.b[r2.ordinal()];
        if (r6 != 1) goto L5;
        Lifecycle.State r7 = r3.getLifecycle().getCurrentState();
        Lifecycle.State r0 = Lifecycle.State.CREATED;
        if (r7.compareTo(r0) < 0) goto L71;
        if (r5 == false) goto L79;
        f(r3, r4);
    L79:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) <= 0) goto L82;
        r3.w2();
    L82:
        if (r3.getLifecycle().getCurrentState().compareTo(r0) > 0) goto L84;
        return;
    L84:
        if (r3.d == true) goto L104;
        r3.a.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        r3.onStop();
        return;
    L104:
        return;
    L71:
        if (r3.d == true) goto L74;
        r3.onCreate();
        r3.a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    L74:
        if (r5 == false) goto L98;
        f(r3, r4);
        return;
    L98:
        return;
    L5:
        if (r6 != 2) goto L7;
        Lifecycle.State r8 = r3.getLifecycle().getCurrentState();
        Lifecycle.State r1 = Lifecycle.State.STARTED;
        if (r8.compareTo(r1) >= 0) goto L64;
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) < 0) goto L54;
    L57:
        if (r5 == false) goto L60;
        f(r3, r4);
    L60:
        if (r3.d == true) goto L103;
        r3.onStart();
        r3.a.handleLifecycleEvent(Lifecycle.Event.ON_START);
        return;
    L103:
        return;
    L54:
        if (r3.d == true) goto L57;
        r3.onCreate();
        r3.a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        goto L57
    L64:
        if (r3.getLifecycle().getCurrentState().compareTo(r1) <= 0) goto L96;
        if (r5 == false) goto L67;
        f(r3, r4);
    L67:
        r3.w2();
        return;
    L96:
        return;
    L7:
        if (r6 == 3) goto L28;
        if (r6 == 4) goto L13;
        if (r5 == false) goto L88;
        f(r3, r4);
        return;
    L88:
        return;
    L13:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L16;
        r3.w2();
    L16:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) < 0) goto L22;
        if (r3.d == true) goto L22;
        r3.a.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        r3.onStop();
    L22:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L24;
        return;
    L24:
        if (r3.d == true) goto L101;
        r3.a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        r3.getViewModelStore().clear();
        r3.onDestroy();
        return;
    L101:
        return;
    L28:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L30;
        if (r5 == false) goto L93;
        f(r3, r4);
        return;
    L93:
        return;
    L30:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) < 0) goto L32;
    L35:
        if (r5 == false) goto L38;
        f(r3, r4);
    L38:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) >= 0) goto L44;
        if (r3.d == true) goto L44;
        r3.onStart();
        r3.a.handleLifecycleEvent(Lifecycle.Event.ON_START);
    L44:
        if (r3.d == true) goto L102;
        r3.onResume();
        r3.a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        return;
    L102:
        return;
    L32:
        if (r3.d == true) goto L35;
        r3.onCreate();
        r3.a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        goto L35
    }
}
