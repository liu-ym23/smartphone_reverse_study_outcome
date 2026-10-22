package com.obric.aiagent.product.platform.api.app;

import android.content.Context;
import android.content.Intent;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import iaa.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import x9a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ObricActivityManager {
    public static final Companion a = null;
    public static final IObricActivityManager b = null;

    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\bH\u0017J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\bH\u0017J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0017J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0017¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u000eH\u0017J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J#\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0017¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u0014H\u0017J \u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010!\u001a\u00020\"H\u0017J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020$H\u0017J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020$H\u0017J \u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u000eH\u0017J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u000eH\u0017J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u000eH\u0017J\u001b\u0010-\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0017¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000200H\u0017J\u0010\u00101\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000200H\u0017J\u0010\u00102\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000203H\u0017J\u0010\u00104\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000203H\u0017J\u0010\u00105\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000200H\u0017J\u0010\u00106\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000200H\u0017J\u0010\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u000209H\u0017J\u0016\u0010:\u001a\u00020\u001e2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050<H\u0017J\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020?H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/ObricActivityManager$Companion;", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityManager;", "<init>", "()V", "TAG", "", "instance", "FLAG_SM_TASK_NOT_TRIMMABLE", "", "getAutoDisplayId", "getCurrentTaskInfo", "Landroid/app/ActivityManager$RunningTaskInfo;", "displayId", "isPackageVisibleOnDisplay", "", "packageName", "isAutoActionTopActivityInSystemAnimation", "()Ljava/lang/Boolean;", "supportsAutoVirtualDisplayRecordSet", "beginAutoVirtualDisplayRecordSet", "", "userId", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAutoVirtualDisplayRecordSetListener;", "addAutoVirtualDisplayRecordPackages", "sessionId", "packageNames", "", "(J[Ljava/lang/String;)Z", "endAutoVirtualDisplayRecordSet", "", "requestTopActivityAssistData", "requestId", "receiver", "Landroid/app/ITopActivityAssistDataReceiver;", "registerTaskStackListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricTaskStackListener;", "unregisterTaskStackListenerEx", "moveTaskToDisplay", "taskId", "isTop", "tryToMute", "shouldMute", "enableCallUser", "enable", "addDisablePackage", "([Ljava/lang/String;)V", "registerBackNavigationInVirtualDisplayListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricBackNavigationListener;", "unregisterBackNavigationInVirtualDisplayListenerEx", "registerObricDisplayInfoCallback", "Lcom/obric/aiagent/product/platform/api/app/ObricDisplayInfoCallback;", "unregisterObricDisplayInfoCallback", "registerBackNavigationListener", "unregisterBackNavigationListener", "forceStopPackageOfCaller", "context", "Landroid/content/Context;", "setMuteWhitelist", "whiteList", "", "addExtraTaskNotTrimFlag", "intent", "Landroid/content/Intent;", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion implements IObricActivityManager {
        private Companion() {
        }

        public /* synthetic */ Companion(int r1) {
            this();
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public final boolean a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            IObricActivityManager r0 = ObricActivityManager.b;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.a(r2);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public final void b(Intent r2) {
            Intrinsics.checkNotNullParameter(r2, "intent");
            IObricActivityManager r0 = ObricActivityManager.b;
            if (r0 == null) goto L6;
            r0.b(r2);
            return;
        }
    }

    static {
        a = new Companion(0);
        b.a.getClass();     // Catch: Throwable -> L9
        if (b.d() == false) goto L6;
        ServiceManager.get().bind(IObricActivityManager.class, new SingletonProvider(new a()));     // Catch: Throwable -> L9
    L7:
        ILogDepend.a.i("ObricActivityManager", "bind ActivityManager assistantApi= " + b.d());     // Catch: Throwable -> L9
    L11:
        IObricActivityManager r1 = (IObricActivityManager) ServiceManager.get().getService(IObricActivityManager.class, false);
        b = r1;
        ILogDepend.a.i("ObricActivityManager", "ObricActivityManager instance: " + r1);
        return;
    L6:
        ServiceManager.get().bind(IObricActivityManager.class, new SingletonProvider(new x9a.b()));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        ILogDepend.a.e("ObricActivityManager", "bind CommonActivityManager failed", th);
        goto L11
    }
}
