package com.obric.aiagent.product.platform.api.app;

import android.content.Context;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import iaa.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import x9a.c;
import x9a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ObricActivityTaskManager {
    public static final Companion a = null;
    public static final IObricActivityTaskManager b = null;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0017J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0017J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0010H\u0017J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0010H\u0017J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0013H\u0017J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0013H\u0017J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/ObricActivityTaskManager$Companion;", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityTaskManager;", "<init>", "()V", "TAG", "", "instance", "registerAppSwitchListener", "", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAppSwitchListener;", "unregisterAppSwitchListener", "registerActivitySwitchListener", "Lcom/obric/aiagent/product/platform/api/app/ObricActivitySwitchListener;", "unregisterActivitySwitchListener", "registerFocusListener", "Lcom/obric/aiagent/product/platform/api/app/ObricFocusListener;", "unregisterFocusListener", "registerSystemAnimationListener", "Lcom/obric/aiagent/product/platform/api/app/ObricSystemAnimationListener;", "unregisterSystemAnimationListener", "finishAndRemoveAllTask", "context", "Landroid/content/Context;", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion implements IObricActivityTaskManager {
        private Companion() {
        }

        public /* synthetic */ Companion(int r1) {
            this();
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        @JvmStatic
        public final boolean a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.b;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.a(r2);
        }
    }

    static {
        a = new Companion(0);
        b.a.getClass();     // Catch: Throwable -> L8
        if (b.d() == false) goto L6;
        ServiceManager.get().bind(IObricActivityTaskManager.class, new SingletonProvider(new c()));     // Catch: Throwable -> L8
    L12:
    L10:
        b = (IObricActivityTaskManager) ServiceManager.get().getService(IObricActivityTaskManager.class, false);
        return;
    L6:
        ServiceManager.get().bind(IObricActivityTaskManager.class, new SingletonProvider(new d()));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        ILogDepend.a.e("ObricActivityTaskManager", "bind ObricActivityTaskManager failed", th);
        goto L10
    }
}
