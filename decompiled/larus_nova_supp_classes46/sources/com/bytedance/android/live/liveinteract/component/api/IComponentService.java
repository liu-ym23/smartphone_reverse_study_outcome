package com.bytedance.android.live.liveinteract.component.api;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0017J\b\u0010\u0004\u001a\u00020\u0002H\u0017J\b\u0010\u0005\u001a\u00020\u0002H\u0017J\b\u0010\u0006\u001a\u00020\u0002H\u0017J\b\u0010\u0007\u001a\u00020\u0002H\u0017J\b\u0010\b\u001a\u00020\u0002H\u0017¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/component/api/IComponentService;", "Landroidx/lifecycle/LifecycleObserver;", "", "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IComponentService extends LifecycleObserver {

    public static final class a {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public static void onCreate(IComponentService r1) {
            ALogger.d("IComponentService", r1 + ":onCreate: ");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public static void onDestroy(IComponentService r1) {
            ALogger.d("IComponentService", r1 + ":onDestroy: ");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public static void onPause(IComponentService r1) {
            ALogger.d("IComponentService", r1 + ":onPause: ");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public static void onResume(IComponentService r1) {
            ALogger.d("IComponentService", r1 + ":onResume: ");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public static void onStart(IComponentService r1) {
            ALogger.d("IComponentService", r1 + ":onStart: ");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public static void onStop(IComponentService r1) {
            ALogger.d("IComponentService", r1 + ":onStop: ");
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate();

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy();

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume();

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart();

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop();
}
