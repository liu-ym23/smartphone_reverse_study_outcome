package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class LifecycleDispatcher {
    public static final LifecycleDispatcher INSTANCE = null;
    private static final AtomicBoolean initialized = null;

    @VisibleForTesting
    public static final class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        public DispatcherActivityCallback() {
        }

        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r10, Bundle r11) {
            Intrinsics.checkNotNullParameter(r10, "activity");
            ReportFragment.Companion.injectIfNeededIn(r10);
        }
    }

    static {
        INSTANCE = new LifecycleDispatcher();
        initialized = new AtomicBoolean(false);
    }

    private LifecycleDispatcher() {
    }

    @JvmStatic
    public static final void init(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (initialized.getAndSet(true) == false) goto L5;
        return;
    L5:
        Context r11 = r10.getApplicationContext();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.app.Application");
        ((Application) r11).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
    }
}
