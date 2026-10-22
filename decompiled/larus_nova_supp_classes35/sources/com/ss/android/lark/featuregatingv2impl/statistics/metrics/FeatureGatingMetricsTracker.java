package com.ss.android.lark.featuregatingv2impl.statistics.metrics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.featuregatingv2impl.handler.SettingsMetricsHandler;
import com.ss.android.lark.log.Log;
import idb.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import jdb.c;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import odb.b;
import se6.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeatureGatingMetricsTracker implements Application.ActivityLifecycleCallbacks {
    public static final FeatureGatingMetricsTracker a = null;
    public static final CopyOnWriteArrayList<odb.a> b = null;
    public static final ArrayList<b> c = null;
    public static long d;
    public static mdb.a e;
    public static volatile boolean f;
    public static final Object g = null;
    public static final Stack<String> h = null;
    public static final Stack<Fragment> i = null;
    public static final WeakHashMap<Fragment, String> j = null;
    public static final ExecutorService k = null;
    public static String l;
    public static final Set<String> m = null;

    public static final class a implements c {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // jdb.c
        public final void a(boolean r3) {
            Log.i("FeatureGatingMetricsTracker", "featureUpdateValue: " + r3);
        }
    }

    public FeatureGatingMetricsTracker() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    static {
        a = new FeatureGatingMetricsTracker();
        b = new CopyOnWriteArrayList();
        c = new ArrayList();
        g = new Object();
        h = new Stack();
        i = new Stack();
        j = new WeakHashMap();
        k = CoreThreadPool.getDefault().newSerialIODensityThreadPool("metrics_tracker");
        m = SetsKt.mutableSetOf(new String[]{"com.bumptech.glide.manager.SupportRequestManagerFragment", "com.ss.android.lark.main.app.fragment.phone.MainFragmentV2", "com.ss.android.lark.main.app.fragment.phone.MainContainerFragment", "com.ss.android.lark.forseti.node.ForsetiNodeFragment", "com.ss.android.lark.forseti.node.piece.ForsetiNodePiece$ForsetiNodePieceFragment", "com.ss.android.lark.forseti.chain.ForsetiChainFragment", "com.ss.android.lark.api.ui.ForsetiPlaceHolderFragment", "com.ss.android.lark.keyboard.plugin.tool.face.sticker.FacePageNewFragment2", "com.ss.android.lark.framework.larkwidget.WidgetManager", "com.ss.android.lark.keyboard.plugin.tool.face.FaceKBPlugin$EmojiPageNewFragmentNoHitPoint"});
    }

    public static void d() {
        if (f == false) goto L5;
        return;
    L5:
        Object r0 = g;
        monitor-enter(r0);
    L27:
        th = move-exception;
        throw th;
    L8:
        if (f == false) goto L11;
        monitor-exit(r0);
        return;
    L11:
        mdb.a r1 = SettingsMetricsHandler.i.j();     // Catch: Throwable -> L27
        e = r1;     // Catch: Throwable -> L27
        Application r2 = null;
        if (r1 == null) goto L19;
        ArrayList<String> r3 = r1.filterFragment;     // Catch: Throwable -> L27
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("filterFragment");     // Catch: Throwable -> L27
        r3 = null;
    L17:
        if (r3 == null) goto L19;
        m.addAll(r3);     // Catch: Throwable -> L27
    L19:
        IGetDataCallback<mdb.a> r4 = new FeatureGatingMetricsTracker$init$1$configUpdateCallback$1();     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r4, "callback");     // Catch: Throwable -> L27
        SettingsMetricsHandler.j = r4;     // Catch: Throwable -> L27
        f.a().addFeatureGatingUpdateListener("lark.fg.performance_metrics_enable", a.a, "_normal_fg");     // Catch: Throwable -> L27
        Context r5 = FeatureGatingModule.getDependency().getContext();     // Catch: Throwable -> L27
        if ((r5 instanceof Application) == false) goto L22;
        r2 = (Application) r5;     // Catch: Throwable -> L27
    L22:
        if (r2 == null) goto L24;
        r2.registerActivityLifecycleCallbacks(a);     // Catch: Throwable -> L27
    L24:
        f = true;     // Catch: Throwable -> L27
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r0);
    }

    public static double a(List r17) {
        if (CollectionUtils.isEmpty(r17) == false) goto L6;
        return 0.0d;
    L6:
        if (r17.size() != 1) goto L9;
        return 1.0d;
    L9:
        mdb.a r1 = e;
        if (r1 == null) goto L17;
        mdb.a.C0258a r2 = r1.slidingWindow;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("slidingWindow");
        r2 = null;
    L15:
        if (r2 == null) goto L17;
        int r3 = r2.b();
    L18:
        double r7 = 1000000;
        double r9 = r3;
        if (((((odb.a) CollectionsKt.last(r17)).c - ((odb.a) CollectionsKt.first(r17)).b) / r7) < r9) goto L21;
        int r4 = 0;
        double r5 = 0.0d;
        int r6 = 0;
    L24:
        if (r4 >= r17.size()) goto L29;
        double r11 = (((odb.a) ListProtector.get(r17, r4)).c - ((odb.a) ListProtector.get(r17, r6)).b) / r7;
        if (r11 > r9) goto L27;
        r4 = r4 + 1;
        goto L24
    L27:
        r5 = Math.max(((double) (r4 - r6)) / (r11 / ((double) 1000)), r5);
        r6 = r6 + 1;
        r9 = r9;
        goto L24
    L29:
        double r15 = r9;
        if (r4 <= r6) goto L36;
        double r10 = (((odb.a) ListProtector.get(r17, r4 - 1)).c - ((odb.a) ListProtector.get(r17, r6)).b) / r7;
        int r8 = r4 - r6;
        if (r10 <= r15) goto L34;
        double r0 = ((double) r8) / (r10 / ((double) 1000));
    L35:
        r5 = Math.max(r0, r5);
        goto L36
    L34:
        r0 = r8;
    L36:
        Log.d("FeatureGatingMetricsTracker", "calculateQPS: " + r5);
        return r5;
    L21:
        return r17.size();
    L17:
        r3 = 1000;
        goto L18
    }

    public static void b(odb.a r8) {
        Intrinsics.checkNotNullParameter(r8, "metrics");
        if (FeatureGatingModule.getDependency().Y().booleanValue() == false) goto L6;
        Log.d("FeatureGatingMetricsTracker", "collectMetrics disable");
        return;
    L6:
        d();
        Stack<String> r0 = h;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Fragment r3 = null;
        String r1 = r0.peek();     // Catch: Exception -> L9
    L10:
        String r2 = r1;
        if (r2 != null) goto L14;
        Log.d("FeatureGatingMetricsTracker", "current page: Boost");
        r2 = "Boost";
    L26:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r8.e = r2;
        r8.f = u.a();
        CopyOnWriteArrayList<odb.a> r4 = b;
        r4.add(r8);
        int r9 = r4.size();
        mdb.a r5 = e;
        if (r5 == null) goto L29;
        int r6 = r5.a();
    L30:
        if (r9 <= r6) goto L41;
        ArrayList r10 = new ArrayList(r4);
        r4.clear();
        if (CollectionUtils.isEmpty(r10) == true) goto L42;
        k.execute(new odb.f(r10));
        return;
    L42:
        return;
    L41:
        return;
    L29:
        r6 = 1000;
        goto L30
    L14:
        if (Intrinsics.areEqual("com.ss.android.lark.main.app.MainActivity", r2) == false) goto L22;
        Stack<Fragment> r7 = i;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        r3 = r7.peek();     // Catch: Exception -> L36
    L17:
        Fragment r11 = r3;
        String r12 = l;
        if (r11 == null) goto L20;
        r2 = c(r11);
        goto L22
    L20:
        if (r12 == null) goto L22;
        r2 = r12;
    L22:
        List r13 = StringsKt.split$default(r2, new String[]{"."}, false, 0, 6, null);
        if (r13.size() <= 2) goto L25;
        r2 = ((String) ListProtector.get(r13, r13.size() - 2)) + '.' + ((String) CollectionsKt.last(r13));
    L25:
        Log.d("FeatureGatingMetricsTracker", "current page: " + r2);
    L9:
        r1 = null;
        goto L10
    }

    public static String c(Fragment r1) {
        return f(r1, 0).getClass().getName();
    }

    public static boolean e(Fragment r1) {
        if (r1.isAdded() == true) goto L5;
    L9:
        return false;
    L5:
        if (r1.isRemoving() == true) goto L9;
        if (r1.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L9;
        return true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        String r4 = r3.getComponentName().getClassName();
        Log.d("FeatureGatingMetricsTracker", "pop page: " + r4);
        h.remove(r4);
        CopyOnWriteArrayList<odb.a> r0 = b;
        ArrayList r5 = new ArrayList(r0);
        r0.clear();
        if (CollectionUtils.isEmpty(r5) == true) goto L7;
        k.execute(new odb.f(r5));
        return;
    }

    public static Fragment f(Fragment r7, int r8) {
        if (r8 < 8) goto L33;
        return r7;
    L33:
        List r0 = r7.getChildFragmentManager().getFragments();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L7
    L9:
        Iterator r1 = CollectionsKt.asReversed(r0).iterator();
    L10:
        Object r4 = null;
        if (r1.hasNext() == false) goto L20;
        Object r2 = r1.next();
        Fragment r5 = (Fragment) r2;
        Intrinsics.checkNotNull(r5);
        if (e(r5) == true) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == false) goto L10;
    L21:
        Fragment r3 = (Fragment) r2;
        if (r3 != null) goto L30;
        Iterator r9 = CollectionsKt.asReversed(r0).iterator();
    L25:
        if (r9.hasNext() == false) goto L29;
        Object r10 = r9.next();
        Fragment r11 = (Fragment) r10;
        Intrinsics.checkNotNull(r11);
        if (e(r11) == false) goto L25;
        r4 = r10;
    L29:
        r3 = (Fragment) r4;
    L30:
        if (r3 != null) goto L32;
        return r7;
    L32:
        return f(r3, r8 + 1);
    L15:
        if (m.contains(r5.getClass().getName()) == true) goto L17;
        r6 = true;
        goto L18
    L20:
        r2 = null;
    L7:
        e = move-exception;
        Log.e("FeatureGatingMetricsTracker", "get child fragments failed, e: " + e);
        r0 = CollectionsKt.emptyList();
        goto L9
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        String r5 = r3.getComponentName().getClassName();
        Log.d("FeatureGatingMetricsTracker", "push page: " + r5);
        if (Intrinsics.areEqual("com.ss.android.lark.main.app.MainActivity", r5) == false) goto L12;
        Log.d("FeatureGatingMetricsTracker", "main activity created.");
        if ((r3 instanceof AppCompatActivity) == false) goto L7;
        AppCompatActivity r6 = (AppCompatActivity) r3;
    L8:
        if (r6 == null) goto L12;
        FragmentManager r7 = r6.getSupportFragmentManager();
        if (r7 == null) goto L12;
        r7.registerFragmentLifecycleCallbacks(new AnonymousClass1(), true);
        goto L12
    L7:
        r6 = null;
    L12:
        h.push(r5);
    }
}
