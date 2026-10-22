package com.bytedance.android.live.liveinteract.component;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.component.api.IComponentService;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.component.data.ComponentGlobalDataContext;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.livesdk.config.wa0;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\fB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0003H\u0007J\b\u0010\u0007\u001a\u00020\u0003H\u0007J\b\u0010\b\u001a\u00020\u0003H\u0007J\b\u0010\t\u001a\u00020\u0003H\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/component/MultiComponentManager;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/LifecycleObserver;", "", "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiComponentManager implements LifecycleOwnerCompat, LifecycleObserver {
    public static final Lazy e = null;
    public LifecycleRegistry a;
    public final ConcurrentHashMap<Class<? extends IComponentService>, me0.a<? extends IComponentService>> b;
    public final CompositeDisposable c;
    public boolean d;

    public static final class a {
        public static MultiComponentManager a() {
            return (MultiComponentManager) MultiComponentManager.e.getValue();
        }
    }

    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    static {
        e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, MultiComponentManager$Companion$instance$2.INSTANCE);
    }

    public final void c() {
        LifecycleRegistry r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
    L5:
        r0.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        Iterator<me0.a<? extends IComponentService>> r1 = this.b.values().iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        me0.a<? extends IComponentService> r2 = r1.next();
        T r3 = r2.a;
        if (r3 == 0) goto L11;
        r2.b.getLifecycle().removeObserver(r3);
    L11:
        r2.a = null;
        goto L7
    L12:
        this.b.clear();
        this.c.clear();
    }

    public final Lifecycle getLifecycleCompat() {
        LifecycleRegistry r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
    L5:
        return r0;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        ALogger.d("MultiComponentManager", this + ":onCreate: ");
        LifecycleRegistry r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
    L5:
        r0.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        ALogger.d("MultiComponentManager", this + ":onDestroy: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        ALogger.d("MultiComponentManager", this + ":onPause: ");
        LifecycleRegistry r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
    L5:
        r0.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        ALogger.d("MultiComponentManager", this + ":onResume: ");
        LifecycleRegistry r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
    L5:
        r0.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        ALogger.d("MultiComponentManager", this + ":onStart: ");
        LifecycleRegistry r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
    L5:
        r0.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        ALogger.d("MultiComponentManager", this + ":onStop: ");
        LifecycleRegistry r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
    L5:
        r0.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    private MultiComponentManager() {
        this.b = new ConcurrentHashMap();
        this.c = new CompositeDisposable();
    }

    public /* synthetic */ MultiComponentManager(int r1) {
        this();
    }

    public final void b(Context r4) {
        if (((Boolean) wa0.a.getValue()).booleanValue() == false) goto L11;
        if (r4 == null) goto L11;
        if (this.d == true) goto L8;
    L10:
        ALogger.w("MultiComponentManager", "release call do nothing, mInit=" + this.d + " releaseContext=" + r4 + " contextInit=null");
        return;
    L8:
        if (Intrinsics.areEqual(r4, null) == false) goto L10;
        ALogger.i("MultiComponentManager", "release call");
        r4.toString();
        c();
        this.d = false;
        return;
    L11:
        c();
    }

    public final void a(LifecycleOwner r5, Context r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r6, "context");
        if (((Boolean) wa0.a.getValue()).booleanValue() == true) goto L5;
    L7:
        Pair r0 = d.a(MultiComponentManager$init$contextPair$1.INSTANCE);
        ComponentGlobalDataContext r2 = (ComponentGlobalDataContext) r0.getFirst();
        com.bytedance.live.datacontext.b.a(r2, ComponentGlobalDataContext.TAG);
        r2.setDataCenter(r7);
        this.c.add((Disposable) r0.getSecond());
        this.a = new LifecycleRegistry(this);
        r5.getLifecycle().addObserver(this);
        this.b.put(ILinkPanelService.class, new me0.b(this));
        int r8 = c.a;
        ac.a.call("modelx");
        fy2.a.g.b();
        HashMap r9 = new HashMap();
        if (k.f(IMiddlewareNetworkService.class) == null) goto L10;
        ((IMiddlewareNetworkService) k.f(IMiddlewareNetworkService.class)).injectProtoDecoders(r9);
    L10:
        this.d = true;
        ALogger.i("MultiComponentManager", "init complete " + r6);
        return;
    L5:
        if (this.d == false) goto L7;
        ALogger.i("MultiComponentManager", "release before init");
        c();
        this.d = false;
        goto L7
    }
}
