package com.ss.android.lark.framework.larkwidget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.asr.InlineAIAsrViewModel;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u001e\u0018\u0000 R2\u00020\u0001:\u0001RB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016J$\u0010&\u001a\u00020\u00002\b\b\u0001\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00162\b\b\u0002\u0010*\u001a\u00020+H\u0007J\u0010\u0010&\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0016H\u0007J\u001e\u0010,\u001a\u00020!2\u000e\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0.2\u0006\u00100\u001a\u00020/J\u0010\u0010,\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0016H\u0002J\b\u00101\u001a\u00020!H\u0002J\u0010\u00102\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0016H\u0007J\u001a\u00102\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u00162\b\b\u0002\u00103\u001a\u00020+H\u0003J \u00104\u001a\u00020!2\u0006\u0010)\u001a\u00020\u00162\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u000fH\u0002J\u0018\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u0016H\u0007J\u001c\u0010;\u001a\u0004\u0018\u0001H<\"\n\b\u0000\u0010<\u0018\u0001*\u00020/H\u0086\b¢\u0006\u0002\u0010=J'\u0010;\u001a\u0004\u0018\u0001H<\"\b\b\u0000\u0010<*\u00020/2\u000e\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0.¢\u0006\u0002\u0010>J\u0006\u0010?\u001a\u00020\u001aJ\u000e\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020\u001cJ\u000e\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020\u001aJ\u0006\u0010D\u001a\u00020+J\"\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020(2\u0006\u0010G\u001a\u00020(2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010M\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0016H\u0002J\u0010\u0010N\u001a\u00020!2\b\u0010O\u001a\u0004\u0018\u00010\u0018J\b\u0010P\u001a\u00020!H\u0002J\u0006\u0010Q\u001a\u00020!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006S"}, d2 = {"Lcom/ss/android/lark/framework/larkwidget/WidgetManager;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "hostContext", "Landroid/content/Context;", "hostLifecycle", "Landroidx/lifecycle/Lifecycle;", "hostFragmentManager", "Landroidx/fragment/app/FragmentManager;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "activityViewModelStoreOwner", "hostFragment", "rootView", "Landroid/view/View;", "asyncLayoutInflater", "Landroidx/asynclayoutinflater/view/AsyncLayoutInflater;", "syncLayoutInflater", "Landroid/view/LayoutInflater;", "widgets", "", "Lcom/ss/android/lark/framework/larkwidget/Widget;", "onWidgetLoadedListener", "Lcom/ss/android/lark/framework/larkwidget/OnWidgetLoadedListener;", "widgetSharedData", "Lcom/ss/android/lark/framework/larkwidget/WidgetSharedData;", "widgetExportManager", "Lcom/ss/android/lark/framework/larkwidget/WidgetExportManager;", "widgetContext", "com/ss/android/lark/framework/larkwidget/WidgetManager$widgetContext$1", "Lcom/ss/android/lark/framework/larkwidget/WidgetManager$widgetContext$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "load", "viewStubId", "", "widget", "asyncInflate", "", "registerWidgetExport", "clazz", "Ljava/lang/Class;", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "instance", "ensureWidgetExportManagerInitialize", "unload", "removeContentView", "continueLoadWidgetWithView", "containerViewGroup", "Landroid/view/ViewGroup;", "contentView", InlineAIAsrViewModel.REPLACE_BUTTON_KEY, "oldWidget", "newWidget", "getWidgetExport", "T", "()Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "(Ljava/lang/Class;)Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "getWidgetSharedData", "setWidgetExportManager", "exportManager", "setWidgetSharedData", "sharedData", "onBackPressed", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "notifyWidgetLoaded", "setOnWidgetLoadedListener", "listener", "assertMainThread", "dispose", "Companion", "lark-widget_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class WidgetManager extends Fragment {
    public static final /* synthetic */ int n = 0;
    public Context d;
    public Lifecycle e;
    public FragmentManager f;
    public ViewModelStoreOwner g;
    public Fragment h;
    public View i;
    public LayoutInflater j;
    public final List<Widget> k;
    public d l;
    public final c m;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Lifecycle.State.values().length];
            r0[Lifecycle.State.CREATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Lifecycle.State.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Lifecycle.State.RESUMED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements com.ss.android.lark.framework.larkwidget.b {
        public final /* synthetic */ WidgetManager a;

        @Override // com.ss.android.lark.framework.larkwidget.b
        public Activity getActivity() {
            return this.a.getActivity();
        }

        @Override // com.ss.android.lark.framework.larkwidget.b
        public Context getContext() {
            Context r0 = this.a.getContext();
            if (r0 != null) goto L13;
            Fragment r1 = this.a.h;
            if (r1 == null) goto L7;
            Context r2 = r1.getContext();
        L8:
            if (r2 != null) goto L14;
            Context r3 = this.a.d;
            if (r3 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("hostContext");
            return null;
        L15:
            return r3;
        L14:
            return r2;
        L7:
            r2 = null;
            goto L8
        L13:
            return r0;
        }

        @Override // com.ss.android.lark.framework.larkwidget.b
        public final Fragment getHostFragment() {
            return this.a.h;
        }

        public c(WidgetManager r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.framework.larkwidget.b
        public final <T extends com.ss.android.lark.framework.larkwidget.c> T b(Class<? extends com.ss.android.lark.framework.larkwidget.c> r2) {
            Intrinsics.checkNotNullParameter(r2, "clazz");
            return (T) this.a.U90(r2);
        }

        @Override // com.ss.android.lark.framework.larkwidget.b
        public void startActivity(Intent r2) {
            Intrinsics.checkNotNullParameter(r2, "intent");
            this.a.startActivity(r2);
        }

        @Override // com.ss.android.lark.framework.larkwidget.b
        public void startActivity(Intent r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "intent");
            this.a.startActivity(r2, r3);
        }

        @Override // com.ss.android.lark.framework.larkwidget.b
        public void startActivityForResult(Intent r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "intent");
            this.a.startActivityForResult(r2, r3);
        }

        @Override // com.ss.android.lark.framework.larkwidget.b
        public final <T extends ViewModel> T a(String r3, Class<T> r4, ViewModelProvider.Factory r5) {
            Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
            Intrinsics.checkNotNullParameter(r4, "clazz");
            Intrinsics.checkNotNullParameter(r5, "factory");
            ViewModelStoreOwner r1 = this.a.g;
            if (r1 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("viewModelStoreOwner");
            r1 = null;
        L6:
            return (T) new ViewModelProvider(r1, r5).get(r3, r4);
        }

        @Override // com.ss.android.lark.framework.larkwidget.b
        public void startActivityForResult(Intent r2, int r3, Bundle r4) {
            Intrinsics.checkNotNullParameter(r2, "intent");
            this.a.startActivityForResult(r2, r3, r4);
        }
    }

    static {
    }

    public /* synthetic */ WidgetManager(int r1) {
        this();
    }

    private WidgetManager() {
        this.k = new ArrayList();
        this.m = new c(this);
    }

    public static void S90() {
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Can't operate widget on non-main thread".toString());
    }

    public final void onDestroy() {
        super.onDestroy();
        ((ArrayList) this.k).clear();
        d r0 = this.l;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("widgetExportManager");
        r0 = null;
    L6:
        r0.a.clear();
        return;
    }

    public final void onDetach() {
        super.onDetach();
        Iterator r0 = ((ArrayList) this.k).iterator();
    L4:
        if (r0.hasNext() == false) goto L35;
        Widget r1 = (Widget) r0.next();
        if (r1.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L4;
        Intrinsics.checkNotNullParameter(r1, "widget");
        S90();
        Lifecycle r2 = this.e;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("hostLifecycle");
        r2 = null;
    L10:
        r2.removeObserver(r1.h);
        int r3 = b.a[r1.getLifecycle().getCurrentState().ordinal()];
        if (r3 != 1) goto L13;
        r1.onDestroy();
    L20:
        r1.a = null;
        ViewGroup r4 = r1.d;
        if (r4 == null) goto L23;
        r4.removeAllViews();
    L23:
        r1.d = null;
        ((ArrayList) this.k).remove(r1);
        Map<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c> r5 = r1.z0();
        if (r5 == null) goto L4;
        Iterator<Map.Entry<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c>> r6 = r5.entrySet().iterator();
    L27:
        if (r6.hasNext() == false) goto L4;
        Map.Entry<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c> r7 = r6.next();
        if (this.l != null) goto L31;
        this.l = new d();
    L31:
        d r8 = this.l;
        if (r8 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("widgetExportManager");
        r8 = null;
    L34:
        Class<? extends com.ss.android.lark.framework.larkwidget.c> r9 = r7.getKey();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "clazz");
        com.ss.android.lark.framework.larkwidget.c r10 = r8.a.remove(r9);
        goto L27
    L13:
        if (r3 != 2) goto L15;
        r1.onStop();
        r1.onDestroy();
        goto L20
    L15:
        if (r3 != 3) goto L20;
        r1.onPause();
        r1.onStop();
        r1.onDestroy();
        goto L20
    L35:
        ((ArrayList) this.k).clear();
    }

    public final <T extends com.ss.android.lark.framework.larkwidget.c> T U90(Class<? extends com.ss.android.lark.framework.larkwidget.c> r4) {
        Intrinsics.checkNotNullParameter(r4, "clazz");
        if (this.l != null) goto L5;
        this.l = new d();
    L5:
        d r1 = this.l;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("widgetExportManager");
        r1 = null;
    L8:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "clazz");
        T r5 = (T) r1.a.get(r4);
        if ((r5 instanceof com.ss.android.lark.framework.larkwidget.c) == true) goto L11;
        return null;
    L11:
        return r5;
    }

    public final void V90(Widget r7) {
        Map<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c> r8 = r7.z0();
        if (r8 == null) goto L22;
        Iterator<Map.Entry<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c>> r9 = r8.entrySet().iterator();
    L6:
        if (r9.hasNext() == false) goto L27;
        Map.Entry<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c> r0 = r9.next();
        if (this.l != null) goto L10;
        this.l = new d();
    L10:
        Class<? extends com.ss.android.lark.framework.larkwidget.c> r1 = r0.getKey();
        d r2 = this.l;
        d r3 = null;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("widgetExportManager");
        r2 = null;
    L13:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "clazz");
        if (r2.a.containsKey(r1) == true) goto L21;
        d r4 = this.l;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("widgetExportManager");
    L19:
        com.ss.android.lark.framework.larkwidget.c r5 = r0.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, "clazz");
        Intrinsics.checkNotNullParameter(r5, "instance");
        com.ss.android.lark.framework.larkwidget.c r6 = r3.a.put(r1, r5);
        goto L6
    L18:
        r3 = r4;
        goto L19
    L21:
        throw new RuntimeException("Duplicated widget export key: " + r1);
    L27:
        return;
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super.onConfigurationChanged(r3);
        S90();
        Iterator r0 = ((ArrayList) this.k).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Widget) r0.next()).y0(r3);
        goto L4
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Fragment r4 = this.h;
        if (r4 == null) goto L8;
        FragmentManager r5 = r4.getParentFragmentManager();
        if (r5 == null) goto L9;
        r5.registerFragmentLifecycleCallbacks(new AnonymousClass1(this), false);
        return;
    L9:
        return;
    }

    public final void T90(Widget r4, ViewGroup r5, View r6) {
        if (r4.d != null) goto L5;
        return;
    L5:
        r4.e = r6;
        ViewParent r0 = r6.getParent();
        Lifecycle r2 = null;
        if ((r0 instanceof ViewGroup) == false) goto L8;
        ViewGroup r1 = (ViewGroup) r0;
    L9:
        if (r1 != null) goto L11;
    L13:
        r5.addView(r6);
        ((ArrayList) this.k).add(r4);
        V90(r4);
        Lifecycle r7 = this.e;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("hostLifecycle");
    L17:
        r2.addObserver(r4.h);
        return;
    L16:
        r2 = r7;
        goto L17
    L11:
        if (Intrinsics.areEqual(r1, r5) == true) goto L13;
        r1.removeView(r6);
        goto L13
    L8:
        r1 = null;
        goto L9
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        S90();
        Iterator r0 = ((ArrayList) this.k).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Widget) r0.next()).w0(r3, r4, r5);
        goto L4
    }
}
