package com.obric.oui.window.listener;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import ga.f;
import ha.a;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/obric/oui/window/listener/WindowConfigChangeListener;", "Landroidx/lifecycle/ViewModel;", "Lcom/obric/oui/window/listener/NextLiveData;", "Lga/f;", "mData", "Lcom/obric/oui/window/listener/NextLiveData;", "<init>", "()V", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowConfigChangeListener extends ViewModel {
    private static final long CONFIG_REFRESH_DELAY_TIME = 100;
    public static final Companion Companion = null;
    private static final String TAG = "Window";
    private static ConcurrentHashMap<Integer, Pair<Configuration, Integer>> mConfigDiffMap;
    private static ConcurrentHashMap<Integer, ConcurrentLinkedQueue<WeakReference<Fragment>>> mFragmentMap;
    private static Configuration mLastConfig;
    private NextLiveData<f> mData;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ void a(Companion r10, FragmentActivity r11, Configuration r12, int r13, int r14, boolean r15) {
            r10.j(r11, r12, r13, r14, r15);
        }

        private final boolean d() {
            return Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
        }

        private final void e(LifecycleOwner r10, Observer<f> r11) {
            if (d() == false) goto L7;
            NextLiveData<f> r12 = c(r10);
            if (r12 == null) goto L9;
            r12.observe(r10, r11);
            return;
        L9:
            return;
        L7:
            Lifecycle r13 = r10.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(r13, "owner.lifecycle");
            h.d(LifecycleKt.getCoroutineScope(r13), z0.c(), null, new WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1(r10, r11, null), 2, null);
        }

        private final Observer<f> f(LifecycleOwner r10, final a r11) {
            Observer<f> r12 = new WindowConfigChangeListener$Companion$observeOnMainThread$observer$1(r11);
            e(r10, r12);
            return r12;
        }

        private final void h(Observer<f> r10, LifecycleOwner r11) {
            if (d() == false) goto L7;
            NextLiveData<f> r12 = c(r11);
            if (r12 == null) goto L9;
            r12.removeObserver(r10);
            return;
        L9:
            return;
        L7:
            Lifecycle r13 = r11.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(r13, "owner.lifecycle");
            h.d(LifecycleKt.getCoroutineScope(r13), z0.c(), null, new WindowConfigChangeListener$Companion$removeObserverOnMainThread$1(r11, r10, null), 2, null);
        }

        private final void j(final FragmentActivity r10, Configuration r11, int r12, int r13, boolean r14) {
            int r15 = r10.hashCode();     // Catch: Exception -> L7
            if (WindowConfigChangeListener.access$getMConfigDiffMap$cp().containsKey(Integer.valueOf(r15)) == true) goto L5;
            r10.getLifecycle().addObserver(new WindowConfigChangeListener$Companion$setConfigInternal$1(r10));     // Catch: Exception -> L7
        L5:
            WindowConfigChangeListener.access$getMConfigDiffMap$cp().put(Integer.valueOf(r15), new Pair(r11, Integer.valueOf(r12)));     // Catch: Exception -> L7
        L9:
            ia.a r16 = ia.a.f9451f;
            r16.h(r10, r12, r13, r14);
            if ((r10 instanceof Activity) == true) goto L12;
            FragmentActivity r17 = null;
        L13:
            if (r17 == null) goto L15;
            r16.a(r17, r12, r13);
        L15:
            r16.g();
            NextLiveData<f> r18 = WindowConfigChangeListener.Companion.c(r10);
            if (r18 == null) goto L18;
            r18.postValue(new f(r16.d(), r16.c()));
        L18:
            ConcurrentLinkedQueue r19 = (ConcurrentLinkedQueue) WindowConfigChangeListener.access$getMFragmentMap$cp().get(Integer.valueOf(r10.hashCode()));
            if (r19 == null) goto L28;
            Iterator r20 = r19.iterator();
        L22:
            if (r20.hasNext() == false) goto L28;
            Fragment r21 = (Fragment) ((WeakReference) r20.next()).get();
            if (r21 == null) goto L22;
            Companion r22 = WindowConfigChangeListener.Companion;
            Intrinsics.checkNotNullExpressionValue(r21, "it");
            NextLiveData<f> r23 = r22.c(r21);
            if (r23 == null) goto L22;
            r23.postValue(new f(r16.d(), r16.c()));
        L28:
            fa.a.f8880a.d(true);
            return;
        L12:
            r17 = r10;
        L7:
            e = move-exception;
            Log.e(WindowConfigChangeListener.TAG, "setToConfig error:" + e.getMessage());
            goto L9
        }

        static /* synthetic */ void k(Companion r10, FragmentActivity r11, Configuration r12, int r13, int r14, boolean r15, int r16, Object r17) {
            if ((r16 & 16) == 0) goto L5;
            r15 = false;
        L5:
            r10.j(r11, r12, r13, r14, r15);
        }

        @JvmStatic
        public final Observer<f> b(final LifecycleOwner r10, a r11) {
            if (r10 == null) goto L24;
            if (r11 == null) goto L24;
            if ((r10 instanceof Fragment) == false) goto L23;
            Fragment r12 = (Fragment) r10;
            FragmentActivity r13 = r12.getActivity();
            if (r13 != null) goto L10;
            final int r14 = 0;
        L12:
            if (WindowConfigChangeListener.access$getMFragmentMap$cp().get(Integer.valueOf(r14)) != null) goto L18;
            WindowConfigChangeListener.access$getMFragmentMap$cp().put(Integer.valueOf(r14), new ConcurrentLinkedQueue());
            FragmentActivity r15 = r12.getActivity();
            if (r15 == null) goto L18;
            Lifecycle r16 = r15.getLifecycle();
            if (r16 == null) goto L18;
            r16.addObserver(new WindowConfigChangeListener$Companion$addListener$1(r14));
        L18:
            ConcurrentLinkedQueue r17 = (ConcurrentLinkedQueue) WindowConfigChangeListener.access$getMFragmentMap$cp().get(Integer.valueOf(r14));
            if (r17 == null) goto L21;
            r17.add(new WeakReference(r10));
        L21:
            r12.getLifecycle().addObserver(new WindowConfigChangeListener$Companion$addListener$2(r14, r10));
            goto L23
        L10:
            r14 = r13.hashCode();
        L23:
            return f(r10, r11);
        L24:
            Log.e(WindowConfigChangeListener.TAG, "cannot add WindowConfigChangeListener:context,owner or listener = nul");
            return null;
        }

        @JvmStatic
        public final NextLiveData<f> c(LifecycleOwner r10) {
            Intrinsics.checkNotNullParameter(r10, "lifecycleOwner");
            if ((r10 instanceof Fragment) == false) goto L10;
            FragmentActivity r11 = ((Fragment) r10).getActivity();
            if (r11 == null) goto L16;
            Application r12 = r11.getApplication();
            if (r12 == null) goto L17;
            ViewModelProvider r13 = new ViewModelProvider((ViewModelStoreOwner) r10, ViewModelProvider.AndroidViewModelFactory.getInstance(r12));
        L15:
            return WindowConfigChangeListener.access$getMData$p((WindowConfigChangeListener) r13.get(WindowConfigChangeListener.class));
        L17:
            return null;
        L16:
            return null;
        L10:
            if ((r10 instanceof FragmentActivity) == false) goto L18;
            Application r14 = ((FragmentActivity) r10).getApplication();
            if (r14 == null) goto L19;
            r13 = new ViewModelProvider((ViewModelStoreOwner) r10, ViewModelProvider.AndroidViewModelFactory.getInstance(r14));
            goto L15
        L19:
            return null;
        L18:
            return null;
        }

        @JvmStatic
        public final void g(Observer<f> r10, LifecycleOwner r11) {
            if (r11 == null) goto L7;
            if (r10 == null) goto L7;
            h(r10, r11);
            return;
        L7:
            Log.e(WindowConfigChangeListener.TAG, "cannot remove WindowConfigChangeListener:context or observer = nul");
        }

        @JvmStatic
        @SuppressLint({"LongLogTag"})
        public final void i(Activity r11, Configuration r12, int r13, int r14) {
            Intrinsics.checkNotNullParameter(r11, "context");
            Intrinsics.checkNotNullParameter(r12, "config");
            if ((r11 instanceof FragmentActivity) == true) goto L6;
            Log.e(WindowConfigChangeListener.TAG, "current activity is not FragmentActivity:" + r11 + ",do not set config");
            return;
        L6:
            Lifecycle r10 = ((FragmentActivity) r11).getLifecycle();
            Intrinsics.checkNotNullExpressionValue(r10, "context.lifecycle");
            h.d(LifecycleKt.getCoroutineScope(r10), z0.a(), null, new WindowConfigChangeListener$Companion$setConfig$1(r11, r12, r13, r14, null), 2, null);
        }
    }

    static {
        Companion = new Companion(null);
        mConfigDiffMap = new ConcurrentHashMap();
        mFragmentMap = new ConcurrentHashMap();
    }

    public WindowConfigChangeListener() {
        this.mData = new NextLiveData();
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMConfigDiffMap$cp() {
        return mConfigDiffMap;
    }

    public static final /* synthetic */ NextLiveData access$getMData$p(WindowConfigChangeListener r10) {
        return r10.mData;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMFragmentMap$cp() {
        return mFragmentMap;
    }

    public static final /* synthetic */ void access$setMConfigDiffMap$cp(ConcurrentHashMap r10) {
        mConfigDiffMap = r10;
    }

    public static final /* synthetic */ void access$setMData$p(WindowConfigChangeListener r10, NextLiveData r11) {
        r10.mData = r11;
    }

    public static final /* synthetic */ void access$setMFragmentMap$cp(ConcurrentHashMap r10) {
        mFragmentMap = r10;
    }

    @JvmStatic
    public static final Observer<f> addListener(LifecycleOwner r10, a r11) {
        return Companion.b(r10, r11);
    }

    @JvmStatic
    public static final NextLiveData<f> getCurrentConfigLiveData(LifecycleOwner r10) {
        return Companion.c(r10);
    }

    @JvmStatic
    public static final void removeListenerByObserver(Observer<f> r10, LifecycleOwner r11) {
        Companion.g(r10, r11);
    }

    @JvmStatic
    @SuppressLint({"LongLogTag"})
    public static final void setConfig(Activity r10, Configuration r11, int r12, int r13) {
        Companion.i(r10, r11, r12, r13);
    }
}
