package com.obric.aiagent.product.platform.impl.app;

import android.app.ActivityManager;
import android.content.Context;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/CommonObricActivityTaskManager;", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityTaskManager;", "<init>", "()V", "registerAppSwitchListener", "", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAppSwitchListener;", "unregisterAppSwitchListener", "registerActivitySwitchListener", "Lcom/obric/aiagent/product/platform/api/app/ObricActivitySwitchListener;", "unregisterActivitySwitchListener", "registerFocusListener", "Lcom/obric/aiagent/product/platform/api/app/ObricFocusListener;", "unregisterFocusListener", "registerSystemAnimationListener", "Lcom/obric/aiagent/product/platform/api/app/ObricSystemAnimationListener;", "unregisterSystemAnimationListener", "finishAndRemoveAllTask", "context", "Landroid/content/Context;", "Companion", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class CommonObricActivityTaskManager implements IObricActivityTaskManager {
    static {
    }

    public CommonObricActivityTaskManager() {
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public final boolean a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r6 = r5.getSystemService("activity");     // Catch: Throwable -> L17
        if ((r6 instanceof ActivityManager) == false) goto L6;
        ActivityManager r7 = (ActivityManager) r6;     // Catch: Throwable -> L17
    L7:
        if (r7 != null) goto L10;
        ILogDepend.a.e("CommonActivityManager", "get ActivityManagerService failed");     // Catch: Throwable -> L17
        return false;
    L10:
        ILogDepend.a.i("CommonObricActivityTaskManager", "finishAndRemoveAllTask on Android 5.0+");     // Catch: Throwable -> L17
        Iterator<T> r8 = r7.getAppTasks().iterator();     // Catch: Throwable -> L17
    L12:
        if (r8.hasNext() == false) goto L15;
        ((ActivityManager.AppTask) r8.next()).finishAndRemoveTask();     // Catch: Throwable -> L17
        goto L12
    L15:
        return true;
    L6:
        r7 = null;
    L17:
        th = move-exception;
        ILogDepend.a.e("CommonObricActivityTaskManager", "finishAndRemoveAllTask failed", th);
        return false;
    }
}
