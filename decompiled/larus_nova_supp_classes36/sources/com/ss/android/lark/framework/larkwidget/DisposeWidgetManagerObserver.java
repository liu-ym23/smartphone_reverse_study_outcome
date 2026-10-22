package com.ss.android.lark.framework.larkwidget;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/framework/larkwidget/DisposeWidgetManagerObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "widgetManager", "Lcom/ss/android/lark/framework/larkwidget/WidgetManager;", "<init>", "(Lcom/ss/android/lark/framework/larkwidget/WidgetManager;)V", "onDestroy", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "lark-widget_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DisposeWidgetManagerObserver implements DefaultLifecycleObserver {
    public final WidgetManager a;

    public final /* synthetic */ void onCreate(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onCreate(this, r1);
    }

    public final /* synthetic */ void onPause(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onPause(this, r1);
    }

    public final /* synthetic */ void onResume(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onResume(this, r1);
    }

    public final /* synthetic */ void onStart(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStart(this, r1);
    }

    public final /* synthetic */ void onStop(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStop(this, r1);
    }

    public DisposeWidgetManagerObserver(WidgetManager r2) {
        Intrinsics.checkNotNullParameter(r2, "widgetManager");
        this.a = r2;
    }

    public final void onDestroy(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        r2.getLifecycle().removeObserver(this);
        WidgetManager r3 = this.a;
        if (r3.isDetached() == false) goto L5;
        return;
    L5:
        if (r3.isRemoving() == true) goto L13;
        FragmentManager r0 = r3.f;
        if (r0 == null) goto L12;
        r0.beginTransaction().remove(r3).commitNowAllowingStateLoss();
        return;
    L12:
        return;
    }
}
