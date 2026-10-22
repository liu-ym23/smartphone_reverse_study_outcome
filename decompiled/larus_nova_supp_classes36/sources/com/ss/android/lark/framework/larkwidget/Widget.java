package com.ss.android.lark.framework.larkwidget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010)\u001a\u00020\u0012H&J\u000f\u0010*\u001a\u0004\u0018\u00010+H\u0017¢\u0006\u0002\u0010,J\u0012\u0010-\u001a\u0004\u0018\u00010\u001d2\u0006\u0010.\u001a\u00020\u0017H\u0016J\b\u00103\u001a\u000204H\u0017J\b\u00105\u001a\u000204H\u0017J\b\u00106\u001a\u000204H\u0017J\b\u00107\u001a\u000204H\u0017J\b\u00108\u001a\u000204H\u0017J\b\u00109\u001a\u000204H\u0017J\u001e\u0010:\u001a\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020=0<\u0012\u0004\u0012\u00020=\u0018\u00010;H\u0016J\u001c\u0010>\u001a\u0004\u0018\u0001H?\"\n\b\u0000\u0010?\u0018\u0001*\u00020=H\u0087\b¢\u0006\u0002\u0010@J)\u0010>\u001a\u0004\u0018\u0001H?\"\b\b\u0000\u0010?*\u00020=2\u000e\u0010A\u001a\n\u0012\u0006\b\u0001\u0012\u00020=0<H\u0017¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u0002042\u0006\u0010F\u001a\u00020+H\u0004J\u001a\u0010E\u001a\u0002042\u0006\u0010F\u001a\u00020+2\b\u0010G\u001a\u0004\u0018\u00010HH\u0004J\b\u0010I\u001a\u000204H\u0004J\b\u0010J\u001a\u00020\u0012H\u0016J\u0010\u0010K\u001a\u0002042\u0006\u0010L\u001a\u00020MH\u0004J\u0018\u0010N\u001a\u0002042\u0006\u0010L\u001a\u00020M2\u0006\u0010O\u001a\u00020PH\u0004J\u0016\u0010Q\u001a\u0002042\f\u0010R\u001a\b\u0012\u0004\u0012\u0002040SH\u0004J\u0016\u0010T\u001a\u0002042\f\u0010R\u001a\b\u0012\u0004\u0012\u0002040SH\u0004J!\u0010U\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020\u001d2\b\b\u0001\u0010V\u001a\u00020+H\u0004¢\u0006\u0002\u0010WJ\"\u0010X\u001a\b\u0012\u0004\u0012\u0002H?0Y\"\b\b\u0000\u0010?*\u00020\u001d2\b\b\u0001\u0010V\u001a\u00020+H\u0004J\n\u0010Z\u001a\u0004\u0018\u00010[H\u0004J\u0006\u0010\\\u001a\u00020[J\n\u0010]\u001a\u0004\u0018\u00010^H\u0004J\b\u0010_\u001a\u00020^H\u0004J\n\u0010`\u001a\u0004\u0018\u00010aH\u0004J\u0010\u0010b\u001a\u0002042\u0006\u0010c\u001a\u00020HH\u0004J\u001a\u0010b\u001a\u0002042\u0006\u0010c\u001a\u00020H2\b\u0010d\u001a\u0004\u0018\u00010eH\u0004J\u0018\u0010f\u001a\u0002042\u0006\u0010c\u001a\u00020H2\u0006\u0010g\u001a\u00020+H\u0004J\"\u0010f\u001a\u0002042\u0006\u0010c\u001a\u00020H2\u0006\u0010g\u001a\u00020+2\b\u0010d\u001a\u0004\u0018\u00010eH\u0004J%\u0010h\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<H\u0004¢\u0006\u0002\u0010jJ-\u0010h\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\u0006\u0010k\u001a\u00020l2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<H\u0004¢\u0006\u0002\u0010mJ-\u0010h\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<2\u0006\u0010n\u001a\u00020oH\u0004¢\u0006\u0002\u0010pJ5\u0010h\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\u0006\u0010k\u001a\u00020l2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<2\u0006\u0010n\u001a\u00020oH\u0004¢\u0006\u0002\u0010qJ%\u0010r\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<H\u0004¢\u0006\u0002\u0010jJ-\u0010r\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\u0006\u0010k\u001a\u00020l2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<H\u0004¢\u0006\u0002\u0010mJ-\u0010r\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<2\u0006\u0010n\u001a\u00020oH\u0004¢\u0006\u0002\u0010pJ5\u0010r\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\u0006\u0010k\u001a\u00020l2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<2\u0006\u0010n\u001a\u00020oH\u0004¢\u0006\u0002\u0010qJ\"\u0010s\u001a\u0002042\u0006\u0010g\u001a\u00020+2\u0006\u0010F\u001a\u00020+2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0010\u0010t\u001a\u0002042\u0006\u0010u\u001a\u00020vH\u0016J\u0011\u0010{\u001a\u00020\u0012*\u00020|H\u0000¢\u0006\u0002\b}R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u000200X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0014\u0010w\u001a\u00020x8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\by\u0010z¨\u0006~"}, d2 = {"Lcom/ss/android/lark/framework/larkwidget/Widget;", "Landroidx/lifecycle/LifecycleOwner;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "widgetContext", "Lcom/ss/android/lark/framework/larkwidget/WidgetContext;", "getWidgetContext$lark_widget_release", "()Lcom/ss/android/lark/framework/larkwidget/WidgetContext;", "setWidgetContext$lark_widget_release", "(Lcom/ss/android/lark/framework/larkwidget/WidgetContext;)V", "mainThreadHandler", "Landroid/os/Handler;", "getMainThreadHandler", "()Landroid/os/Handler;", "mainThreadHandler$delegate", "Lkotlin/Lazy;", "isActive", "", "()Z", "setActive", "(Z)V", "containerView", "Landroid/view/ViewGroup;", "getContainerView", "()Landroid/view/ViewGroup;", "setContainerView", "(Landroid/view/ViewGroup;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "widgetCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "hasView", "getLayoutResId", "", "()Ljava/lang/Integer;", "getLayoutView", "parent", "lifecycleObserver", "Landroidx/lifecycle/DefaultLifecycleObserver;", "getLifecycleObserver$lark_widget_release", "()Landroidx/lifecycle/DefaultLifecycleObserver;", "onCreate", "", "onStart", "onResume", "onPause", "onStop", "onDestroy", "provideWidgetExport", "", "Ljava/lang/Class;", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "getWidgetExport", "T", "()Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "clazz", "(Ljava/lang/Class;)Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "getSharedData", "Lcom/ss/android/lark/framework/larkwidget/WidgetSharedData;", "setResult", "resultCode", "data", "Landroid/content/Intent;", "finish", "onBackPressed", "post", "runnable", "Ljava/lang/Runnable;", "postDelayed", "delayMillis", "", "runSafely", "block", "Lkotlin/Function0;", "runSafelyOnUI", "findViewById", "id", "(I)Landroid/view/View;", "lazyFindView", "Lkotlin/Lazy;", "getHostContext", "Landroid/content/Context;", "requireHostContext", "getActivity", "Landroid/app/Activity;", "requireActivity", "getWidgetHostFragment", "Landroidx/fragment/app/Fragment;", "startActivity", "intent", "options", "Landroid/os/Bundle;", "startActivityForResult", "requestCode", "getViewModel", "Landroidx/lifecycle/ViewModel;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", TabAppInfo.IMAGE_JSON_KEY, "", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Ljava/lang/Class;Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModel;", "getActivityViewModel", "onActivityResult", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "isMainThread", "Ljava/lang/Thread;", "isMainThread$lark_widget_release", "lark-widget_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public abstract class Widget implements LifecycleOwner, CoroutineScope {
    public b a;
    public final Lazy b;
    public volatile boolean c;
    public ViewGroup d;
    public View e;
    public final CoroutineContext f;
    public LifecycleRegistry g;
    public final Widget$lifecycleObserver$1 h;

    public void onCreate() {
        this.c = true;
        LifecycleRegistry r0 = new LifecycleRegistry(this);
        this.g = r0;
        r0.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public void onDestroy() {
        this.c = false;
        LifecycleRegistry r1 = null;
        ((Handler) this.b.getValue()).removeCallbacksAndMessages(null);
        JobKt.cancel$default(getCoroutineContext(), null, 1, null);
        LifecycleRegistry r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
    L6:
        r1.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        return;
    L5:
        r1 = r0;
        goto L6
    }

    public Integer r0() {
        return null;
    }

    public void s0(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
    }

    public abstract boolean v0();

    public void w0(int r1, int r2, Intent r3) {
    }

    public void y0(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
    }

    public Map<Class<? extends c>, c> z0() {
        return null;
    }

    public final Context B0() {
        b r0 = this.a;
        if (r0 == null) goto L5;
        Context r1 = r0.getContext();
    L6:
        if (r1 == null) goto L9;
        return r1;
    L9:
        throw new IllegalArgumentException("Required value was null.".toString());
    L5:
        r1 = null;
        goto L6
    }

    public final Activity getActivity() {
        b r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getActivity();
    }

    public final Lifecycle getLifecycle() {
        LifecycleRegistry r0 = this.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        return null;
    L6:
        return r0;
    }

    public void onPause() {
        LifecycleRegistry r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        r0 = null;
    L5:
        r0.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    public void onResume() {
        LifecycleRegistry r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        r0 = null;
    L5:
        r0.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    public void onStart() {
        LifecycleRegistry r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        r0 = null;
    L5:
        r0.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    public void onStop() {
        LifecycleRegistry r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        r0 = null;
    L5:
        r0.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.ss.android.lark.framework.larkwidget.Widget$lifecycleObserver$1] */
    public Widget() {
        this.b = LazyKt.lazy(Widget$mainThreadHandler$2.INSTANCE);
        this.f = SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate());
        this.h = new Widget$lifecycleObserver$1(this);
    }

    public final Activity A0() {
        Activity r0 = getActivity();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final CoroutineContext getCoroutineContext() {
        return this.f;
    }

    public final void setResult(int r4) {
        b r0 = this.a;
        Activity r1 = null;
        if (r0 == null) goto L5;
        Context r2 = r0.getContext();
    L7:
        if ((r2 instanceof Activity) == false) goto L9;
        r1 = (Activity) r2;
    L9:
        if (r1 == null) goto L12;
        r1.setResult(r4);
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void startActivity(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        b r0 = this.a;
        if (r0 == null) goto L7;
        r0.startActivity(r2);
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public <T extends c> T u0(Class<? extends c> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        b r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.b(r2);
    }

    public final void setResult(int r4, Intent r5) {
        b r0 = this.a;
        Activity r1 = null;
        if (r0 == null) goto L5;
        Context r2 = r0.getContext();
    L7:
        if ((r2 instanceof Activity) == false) goto L9;
        r1 = (Activity) r2;
    L9:
        if (r1 == null) goto L12;
        r1.setResult(r4, r5);
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void startActivity(Intent r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        b r0 = this.a;
        if (r0 == null) goto L7;
        r0.startActivity(r2, r3);
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void startActivityForResult(Intent r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        b r0 = this.a;
        if (r0 == null) goto L7;
        r0.startActivityForResult(r2, r3);
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void startActivityForResult(Intent r2, int r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        b r0 = this.a;
        if (r0 == null) goto L7;
        r0.startActivityForResult(r2, r3, r4);
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final <T extends ViewModel> T t0(String r2, Class<T> r3, ViewModelProvider.Factory r4) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r4, "factory");
        b r0 = this.a;
        if (r0 == null) goto L7;
        return (T) r0.a(r2, r3, r4);
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
