package com.obric.oui.window.listener;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.obric.oui.window.bean.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/window/listener/WindowConfigChangeListener;", "Landroidx/lifecycle/ViewModel;", "()V", "mData", "Lcom/obric/oui/window/listener/NextLiveData;", "Lcom/obric/oui/window/bean/WindowSizeWithPageSize;", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WindowConfigChangeListener extends ViewModel {
    private static final long CONFIG_REFRESH_DELAY_TIME = 100;
    public static final a Companion = null;
    private static final String TAG = "Window";
    private static ConcurrentHashMap<Integer, Pair<Configuration, Integer>> mConfigDiffMap;
    private static ConcurrentHashMap<Integer, ConcurrentLinkedQueue<WeakReference<Fragment>>> mFragmentMap;
    private static Configuration mLastConfig;
    private NextLiveData<f> mData;

    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010!\u001a\u00020\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015H\u0007J\u001e\u0010\"\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J(\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0007J2\u0010)\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020*2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\n0\bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/oui/window/listener/WindowConfigChangeListener$Companion;", "", "()V", "CONFIG_REFRESH_DELAY_TIME", "", "TAG", "", "mConfigDiffMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Landroid/content/res/Configuration;", "mFragmentMap", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "mLastConfig", "addListener", "Landroidx/lifecycle/Observer;", "Lcom/obric/oui/window/bean/WindowSizeWithPageSize;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "listener", "Lcom/obric/oui/window/interfaces/OnWindowConfigChangeListener;", "getCurrentConfigLiveData", "Lcom/obric/oui/window/listener/NextLiveData;", "lifecycleOwner", "isMainThread", "", "observeByObserverOnMainThread", "", "observer", "observeOnMainThread", "removeListenerByObserver", "removeObserverOnMainThread", "setConfig", "context", "Landroid/app/Activity;", "config", "currentWindowWidth", "currentWindowHeight", "setConfigInternal", "Landroidx/fragment/app/FragmentActivity;", "decorViewWidth", "decorViewHeight", "forceUseDecorSize", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final void a(FragmentActivity r5, Configuration r6, int r7, int r8, boolean r9) {
            final FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r5, FragmentActivity.class, "com.obric.memorydata.plugin");
            int r10 = r4.hashCode();     // Catch: Exception -> L8
            if (WindowConfigChangeListener.access$getMConfigDiffMap$cp().containsKey(Integer.valueOf(r10)) == true) goto L6;
            r4.getLifecycle().addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(new WindowConfigChangeListener$Companion$setConfigInternal$1(r4), LifecycleObserver.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L8
        L6:
            ((Map) ZeusTransformUtils.preCheckCast(WindowConfigChangeListener.access$getMConfigDiffMap$cp(), Map.class, "com.obric.memorydata.plugin")).put(Integer.valueOf(r10), new Pair(r6, Integer.valueOf(r7)));     // Catch: Exception -> L8
        L10:
            com.obric.oui.window.d.a r11 = com.obric.oui.window.d.a.f14897a;
            r11.a((Activity) ZeusTransformUtils.preCheckCast(r4, Activity.class, "com.obric.memorydata.plugin"), r7, r8, r9);
            if (ZeusTransformUtils.instanceOf(r4, Activity.class) == false) goto L13;
            Activity r12 = (Activity) ZeusTransformUtils.preCheckCast(r4, Activity.class, "com.obric.memorydata.plugin");
        L14:
            if (r12 == null) goto L17;
            r11.a(r12, r7, r8);
        L17:
            r11.a();
            NextLiveData<f> r13 = WindowConfigChangeListener.Companion.a((LifecycleOwner) ZeusTransformUtils.preCheckCast(r4, LifecycleOwner.class, "com.obric.memorydata.plugin"));
            if (r13 == null) goto L21;
            r13.postValue(new f(r11.b(), r11.c()));
        L21:
            ConcurrentLinkedQueue r14 = (ConcurrentLinkedQueue) ZeusTransformUtils.preCheckCast(WindowConfigChangeListener.access$getMFragmentMap$cp().get(Integer.valueOf(r4.hashCode())), ConcurrentLinkedQueue.class, "com.obric.memorydata.plugin");
            if (r14 == null) goto L34;
            Iterator r15 = r14.iterator();
        L26:
            if (r15.hasNext() == false) goto L34;
            Fragment r16 = (Fragment) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r15.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), Fragment.class, "com.obric.memorydata.plugin");
            if (r16 == null) goto L26;
            NextLiveData<f> r17 = WindowConfigChangeListener.Companion.a((LifecycleOwner) ZeusTransformUtils.preCheckCast(r16, LifecycleOwner.class, "com.obric.memorydata.plugin"));
            if (r17 == null) goto L26;
            r17.postValue(new f(r11.b(), r11.c()));
        L34:
            com.obric.oui.window.a.f14878a.a(true);
            return;
        L13:
            r12 = null;
        L8:
            e = move-exception;
            Log.e(WindowConfigChangeListener.TAG, Intrinsics.stringPlus("setToConfig error:", e.getMessage()));
            goto L10
        }

        private final void a(LifecycleOwner r9, Observer<f> r10) {
            LifecycleOwner r11 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r9, LifecycleOwner.class, "com.obric.memorydata.plugin");
            Observer<? super f> r12 = (Observer) ZeusTransformUtils.wrapperContextForParams(r10, Observer.class, "com.obric.memorydata.plugin");
            if (a() == false) goto L8;
            NextLiveData<f> r8 = a(r11);
            if (r8 == null) goto L11;
            r8.observe(r11, r12);
            return;
        L11:
            return;
        L8:
            Lifecycle r13 = r11.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(r13, "owner.lifecycle");
            i.a((al) ZeusTransformUtils.preCheckCast(LifecycleKt.getCoroutineScope(r13), al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1(r11, r12, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        }

        private static final void a(com.obric.oui.window.c.a r2, f r3) {
            com.obric.oui.window.c.a r4 = (com.obric.oui.window.c.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.oui.window.c.a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "$listener");
            Intrinsics.checkNotNullExpressionValue(r3, "it");
            r4.a(r3);
        }

        public static final /* synthetic */ void a(a r6, FragmentActivity r7, Configuration r8, int r9, int r10, boolean r11) {
            r6.a((FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r7, FragmentActivity.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
        }

        static /* synthetic */ void a(a r6, FragmentActivity r7, Configuration r8, int r9, int r10, boolean r11, int r12, Object r13) {
            FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r7, FragmentActivity.class, "com.obric.memorydata.plugin");
            if ((r12 & 16) == 0) goto L5;
            r11 = false;
        L5:
            r6.a(r1, r8, r9, r10, r11);
        }

        private final boolean a() {
            return Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
        }

        private final Observer<f> b(LifecycleOwner r3, com.obric.oui.window.c.a r4) {
            LifecycleOwner r5 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
            final com.obric.oui.window.c.a r6 = (com.obric.oui.window.c.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.oui.window.c.a.class, "com.obric.memorydata.plugin");
            Observer<f> r0 = new $$Lambda$WindowConfigChangeListener$a$bSeu8AUs4iipwwRzoir7tpNHVPM(r6);
            a(r5, r0);
            return r0;
        }

        private final void b(Observer<f> r9, LifecycleOwner r10) {
            Observer<? super f> r11 = (Observer) ZeusTransformUtils.wrapperContextForParams(r9, Observer.class, "com.obric.memorydata.plugin");
            LifecycleOwner r12 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r10, LifecycleOwner.class, "com.obric.memorydata.plugin");
            if (a() == false) goto L8;
            NextLiveData<f> r8 = a(r12);
            if (r8 == null) goto L11;
            r8.removeObserver(r11);
            return;
        L11:
            return;
        L8:
            Lifecycle r13 = r12.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(r13, "owner.lifecycle");
            i.a((al) ZeusTransformUtils.preCheckCast(LifecycleKt.getCoroutineScope(r13), al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new WindowConfigChangeListener$Companion$removeObserverOnMainThread$1(r12, r11, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        }

        public static /* synthetic */ void lambda$bSeu8AUs4iipwwRzoir7tpNHVPM(com.obric.oui.window.c.a r0, f r1) {
            a(r0, r1);
        }

        @JvmStatic
        public final Observer<f> a(LifecycleOwner r6, com.obric.oui.window.c.a r7) {
            final LifecycleOwner r8 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r6, LifecycleOwner.class, "com.obric.memorydata.plugin");
            com.obric.oui.window.c.a r9 = (com.obric.oui.window.c.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.oui.window.c.a.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L28;
            if (r9 == null) goto L28;
            if (ZeusTransformUtils.instanceOf(r8, Fragment.class) == false) goto L27;
            FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Fragment) ZeusTransformUtils.preCheckCast(r8, Fragment.class, "com.obric.memorydata.plugin")).getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L11;
            final int r1 = r0.hashCode();
        L13:
            if (WindowConfigChangeListener.access$getMFragmentMap$cp().get(Integer.valueOf(r1)) != null) goto L21;
            ((Map) ZeusTransformUtils.preCheckCast(WindowConfigChangeListener.access$getMFragmentMap$cp(), Map.class, "com.obric.memorydata.plugin")).put(Integer.valueOf(r1), new ConcurrentLinkedQueue());
            FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Fragment) ZeusTransformUtils.preCheckCast(r8, Fragment.class, "com.obric.memorydata.plugin")).getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L21;
            Lifecycle r3 = r2.getLifecycle();
            if (r3 == null) goto L21;
            r3.addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(new WindowConfigChangeListener$Companion$addListener$1(r1), LifecycleObserver.class, "com.obric.memorydata.plugin"));
        L21:
            ConcurrentLinkedQueue r4 = (ConcurrentLinkedQueue) ZeusTransformUtils.preCheckCast(WindowConfigChangeListener.access$getMFragmentMap$cp().get(Integer.valueOf(r1)), ConcurrentLinkedQueue.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L25;
            r4.add(new WeakReference(r8));
        L25:
            ((Fragment) ZeusTransformUtils.preCheckCast(r8, Fragment.class, "com.obric.memorydata.plugin")).getLifecycle().addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(new WindowConfigChangeListener$Companion$addListener$2(r1, r8), LifecycleObserver.class, "com.obric.memorydata.plugin"));
            goto L27
        L11:
            r1 = 0;
        L27:
            return b(r8, r9);
        L28:
            Log.e(WindowConfigChangeListener.TAG, "cannot add WindowConfigChangeListener:context,owner or listener = nul");
            return null;
        }

        @JvmStatic
        public final NextLiveData<f> a(LifecycleOwner r5) {
            LifecycleOwner r4 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r5, LifecycleOwner.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
            if (ZeusTransformUtils.instanceOf(r4, Fragment.class) == false) goto L12;
            FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Fragment) ZeusTransformUtils.preCheckCast(r4, Fragment.class, "com.obric.memorydata.plugin")).getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L20;
            Application r7 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L21;
            ViewModelProvider r2 = new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin"), (ViewModelProvider.Factory) ZeusTransformUtils.preCheckCast(ViewModelProvider.AndroidViewModelFactory.getInstance(r7), ViewModelProvider.Factory.class, "com.obric.memorydata.plugin"));
        L17:
            ViewModel r8 = r2.get(WindowConfigChangeListener.class);
            Intrinsics.checkNotNullExpressionValue(r8, "ViewModelProvider(\n     …angeListener::class.java]");
            return WindowConfigChangeListener.access$getMData$p((WindowConfigChangeListener) ZeusTransformUtils.preCheckCast(r8, WindowConfigChangeListener.class, "com.obric.memorydata.plugin"));
        L21:
            return null;
        L20:
            return null;
        L12:
            if (ZeusTransformUtils.instanceOf(r4, FragmentActivity.class) == false) goto L19;
            Application r9 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((FragmentActivity) ZeusTransformUtils.preCheckCast(r4, FragmentActivity.class, "com.obric.memorydata.plugin")).getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
            if (r9 == null) goto L22;
            r2 = new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin"), (ViewModelProvider.Factory) ZeusTransformUtils.preCheckCast(ViewModelProvider.AndroidViewModelFactory.getInstance(r9), ViewModelProvider.Factory.class, "com.obric.memorydata.plugin"));
            goto L17
        L22:
            return null;
        L19:
            return null;
        }

        @JvmStatic
        public final void a(Activity r10, Configuration r11, int r12, int r13) {
            Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r11, "config");
            if (ZeusTransformUtils.instanceOf(r2, FragmentActivity.class) == true) goto L6;
            Log.e(WindowConfigChangeListener.TAG, "current activity is not FragmentActivity:" + r2 + ",do not set config");
            return;
        L6:
            Lifecycle r9 = ((FragmentActivity) ZeusTransformUtils.preCheckCast(r2, FragmentActivity.class, "com.obric.memorydata.plugin")).getLifecycle();
            Intrinsics.checkNotNullExpressionValue(r9, "context.lifecycle");
            i.a((al) ZeusTransformUtils.preCheckCast(LifecycleKt.getCoroutineScope(r9), al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new WindowConfigChangeListener$Companion$setConfig$1(r2, r11, r12, r13, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        }

        @JvmStatic
        public final void a(Observer<f> r3, LifecycleOwner r4) {
            Observer<f> r5 = (Observer) ZeusTransformUtils.wrapperContextForParams(r3, Observer.class, "com.obric.memorydata.plugin");
            LifecycleOwner r6 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L8;
            if (r5 == null) goto L8;
            b(r5, r6);
            return;
        L8:
            Log.e(WindowConfigChangeListener.TAG, "cannot remove WindowConfigChangeListener:context or observer = nul");
        }
    }

    static {
        Companion = new a(null);
        mConfigDiffMap = new ConcurrentHashMap();
        mFragmentMap = new ConcurrentHashMap();
    }

    public WindowConfigChangeListener() {
        this.mData = new NextLiveData();
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMConfigDiffMap$cp() {
        return mConfigDiffMap;
    }

    public static final /* synthetic */ NextLiveData access$getMData$p(WindowConfigChangeListener r0) {
        return r0.mData;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMFragmentMap$cp() {
        return mFragmentMap;
    }

    @JvmStatic
    public static final Observer<f> addListener(LifecycleOwner r2, com.obric.oui.window.c.a r3) {
        LifecycleOwner r4 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r2, LifecycleOwner.class, "com.obric.memorydata.plugin");
        com.obric.oui.window.c.a r5 = (com.obric.oui.window.c.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.window.c.a.class, "com.obric.memorydata.plugin");
        return Companion.a(r4, r5);
    }

    @JvmStatic
    public static final NextLiveData<f> getCurrentConfigLiveData(LifecycleOwner r2) {
        LifecycleOwner r3 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r2, LifecycleOwner.class, "com.obric.memorydata.plugin");
        return Companion.a(r3);
    }

    @JvmStatic
    public static final void removeListenerByObserver(Observer<f> r2, LifecycleOwner r3) {
        Observer<f> r4 = (Observer) ZeusTransformUtils.wrapperContextForParams(r2, Observer.class, "com.obric.memorydata.plugin");
        LifecycleOwner r5 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Companion.a(r4, r5);
    }

    @JvmStatic
    public static final void setConfig(Activity r2, Configuration r3, int r4, int r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        Companion.a(r6, r3, r4, r5);
    }
}
