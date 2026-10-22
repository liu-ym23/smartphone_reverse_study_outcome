package com.larus.dora.impl.device.manage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0012H\u0007J\b\u0010\u0019\u001a\u00020\u0012H\u0007J\b\u0010\u001a\u001a\u00020\u0012H\u0007J\b\u0010\u001b\u001a\u00020\u0012H\u0007J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\u001f\u001a\u00020\u0012H\u0017J\u0018\u0010 \u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H'J\b\u0010!\u001a\u00020\u0012H\u0017J\b\u0010\"\u001a\u00020\u0012H\u0017J\b\u0010#\u001a\u00020\u0012H\u0017J\b\u0010$\u001a\u00020\u0012H\u0017J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0017J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\b\u0010)\u001a\u00020*H\u0007J\b\u0010+\u001a\u00020*H\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\t\u0010\u0007R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006-"}, d2 = {"Lcom/larus/dora/impl/device/manage/LifecycleUIComponent;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "lifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "getLifecycleRegistry", "lifecycleRegistry$delegate", "Lkotlin/Lazy;", "_rootView", "Landroid/view/View;", "rootView", "getRootView", "()Landroid/view/View;", "performOnCreate", "", "performCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "performOnStart", "performOnStop", "performOnDestroy", "requestRefresh", "performDeviceSwitch", "event", "Lcom/larus/dora/impl/device/manage/DeviceSwitchEvent;", "onCreate", "onCreateAndSetupView", "onStart", "onStop", "onDestroy", "onRefreshRequested", "onBind", "data", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "onDeviceSwitch", "isDestroyed", "", "checkLifecycleAlive", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class LifecycleUIComponent implements LifecycleOwner {
    public static final /* synthetic */ int c = 0;
    public final Lazy a;
    public View b;

    public static final class a {
    }

    static {
    }

    public void b(p0 r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    public abstract View c(LayoutInflater r1, ViewGroup r2);

    public void e(com.larus.dora.impl.device.manage.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    /* JADX INFO: renamed from: getLifecycle, reason: collision with other method in class */
    public final LifecycleRegistry m62getLifecycle() {
        return (LifecycleRegistry) this.a.getValue();
    }

    public LifecycleUIComponent() {
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new y0(this));
    }

    public final boolean a() {
        if (m62getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        boolean r0 = true;
    L7:
        return !r0;
    L5:
        r0 = false;
        goto L7
    }

    public final void g() {
        if (a() == true) goto L5;
        return;
    L5:
        if (m62getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L9;
        onStop();
        return;
    }

    public void onDestroy() {
        m62getLifecycle().setCurrentState(Lifecycle.State.DESTROYED);
        this.b = null;
    }

    public void onStart() {
        m62getLifecycle().setCurrentState(Lifecycle.State.STARTED);
    }

    public void onStop() {
        m62getLifecycle().setCurrentState(Lifecycle.State.CREATED);
    }

    public final /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return m62getLifecycle();
    }

    public final View f(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "container");
        if (a() == true) goto L5;
        g49.d.c("LifecycleUIComponent", "performCreateView() called after DESTROYED", new RuntimeException());
    L5:
        View r6 = c(r4, r5);
        this.b = r6;
        return r6;
    }
}
