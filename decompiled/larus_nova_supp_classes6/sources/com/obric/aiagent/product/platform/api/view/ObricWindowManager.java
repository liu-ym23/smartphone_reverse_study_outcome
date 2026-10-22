package com.obric.aiagent.product.platform.api.view;

import android.os.IBinder;
import android.view.Window;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import iaa.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ObricWindowManager {
    public static final Companion a = null;
    public static final IObricWindowManager b = null;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH\u0017J\b\u0010\f\u001a\u00020\rH\u0017J\b\u0010\u000e\u001a\u00020\rH\u0017J\b\u0010\u000f\u001a\u00020\rH\u0017J\b\u0010\u0010\u001a\u00020\rH\u0017J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J0\u0010\u0015\u001a\u00020\r2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u0016H\u0017J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u001aH\u0017J\u0018\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u001aH\u0017J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/aiagent/product/platform/api/view/ObricWindowManager$Companion;", "Lcom/obric/aiagent/product/platform/api/view/IObricWindowManager;", "<init>", "()V", "TAG", "", "instance", "takeScreenshot", "Landroid/graphics/Bitmap;", "includePackages", "", "excludePackages", "isAutoActionRunning", "", "isAutoImeReady", "focusedWindowIsSecure", "isInputMethodShown", "registerInputMethodListener", "listener", "Lcom/obric/aiagent/product/platform/api/inputmethod/ObricInputMethodListener;", "unregisterInputMethodListener", "takeSurfaceControlScreenshot", "", "registerWindowGestureListener", "token", "Landroid/os/IBinder;", "Lcom/obric/aiagent/product/platform/api/view/ObricWindowGestureListener;", "unregisterWindowGestureListener", "setAssistantWindowInKeyguardMode", "window", "Landroid/view/Window;", "showGlobalActions", "context", "Landroid/content/Context;", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion implements IObricWindowManager {
        private Companion() {
        }

        public /* synthetic */ Companion(int r1) {
            this();
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        @JvmStatic
        public final boolean c(Window r2) {
            Intrinsics.checkNotNullParameter(r2, "window");
            IObricWindowManager r0 = ObricWindowManager.b;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.c(r2);
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        @JvmStatic
        public final boolean a(IBinder r2, ObricWindowGestureListener r3) {
            Intrinsics.checkNotNullParameter(r2, "token");
            Intrinsics.checkNotNullParameter(r3, "listener");
            IObricWindowManager r0 = ObricWindowManager.b;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.a(r2, r3);
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        @JvmStatic
        public final boolean b(IBinder r2, ObricWindowGestureListener r3) {
            Intrinsics.checkNotNullParameter(r2, "token");
            Intrinsics.checkNotNullParameter(r3, "listener");
            IObricWindowManager r0 = ObricWindowManager.b;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.b(r2, r3);
        }
    }

    static {
        a = new Companion(0);
        b.a.getClass();     // Catch: Throwable -> L8
        if (b.d() == false) goto L6;
        ServiceManager.get().bind(IObricWindowManager.class, new SingletonProvider(new c()));     // Catch: Throwable -> L8
    L12:
    L10:
        IObricWindowManager r1 = (IObricWindowManager) ServiceManager.get().getService(IObricWindowManager.class, false);
        b = r1;
        ILogDepend.a.i("ObricWindowManager", "ObricWindowManager instance: " + r1);
        return;
    L6:
        ServiceManager.get().bind(IObricWindowManager.class, new SingletonProvider(new d()));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        ILogDepend.a.e("ObricWindowManager", "bind ObricWindowManager failed", th);
        goto L10
    }
}
