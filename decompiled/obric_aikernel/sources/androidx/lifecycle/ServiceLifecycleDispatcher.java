package androidx.lifecycle;

import android.os.Handler;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class ServiceLifecycleDispatcher {
    private final Handler handler;
    private DispatchRunnable lastDispatchRunnable;
    private final LifecycleRegistry registry;

    public static final class DispatchRunnable implements Runnable {
        private final Lifecycle.Event event;
        private final LifecycleRegistry registry;
        private boolean wasExecuted;

        public DispatchRunnable(LifecycleRegistry r10, Lifecycle.Event r11) {
            Intrinsics.checkNotNullParameter(r10, "registry");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_EVENT);
            this.registry = r10;
            this.event = r11;
        }

        public final Lifecycle.Event getEvent() {
            return this.event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wasExecuted == true) goto L6;
            this.registry.handleLifecycleEvent(this.event);
            this.wasExecuted = true;
            return;
        }
    }

    public ServiceLifecycleDispatcher(LifecycleOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "provider");
        this.registry = new LifecycleRegistry(r10);
        this.handler = new Handler();
    }

    private final void postDispatchRunnable(Lifecycle.Event r10) {
        DispatchRunnable r11 = this.lastDispatchRunnable;
        if (r11 == null) goto L5;
        r11.run();
    L5:
        DispatchRunnable r12 = new DispatchRunnable(this.registry, r10);
        this.lastDispatchRunnable = r12;
        Handler r13 = this.handler;
        Intrinsics.checkNotNull(r12);
        r13.postAtFrontOfQueue(r12);
    }

    public Lifecycle getLifecycle() {
        return this.registry;
    }

    public void onServicePreSuperOnBind() {
        postDispatchRunnable(Lifecycle.Event.ON_START);
    }

    public void onServicePreSuperOnCreate() {
        postDispatchRunnable(Lifecycle.Event.ON_CREATE);
    }

    public void onServicePreSuperOnDestroy() {
        postDispatchRunnable(Lifecycle.Event.ON_STOP);
        postDispatchRunnable(Lifecycle.Event.ON_DESTROY);
    }

    public void onServicePreSuperOnStart() {
        postDispatchRunnable(Lifecycle.Event.ON_START);
    }
}
