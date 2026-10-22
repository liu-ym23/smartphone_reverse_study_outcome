package com.obric.aiagent.product.platform.impl.app;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.app.IObricActivityManager;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0005H\u0016J\r\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\nH\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J#\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0016¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J \u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020!H\u0016J \u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\nH\u0016J\u001b\u0010*\u001a\u00020\u001b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0016¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020-H\u0016J\u0010\u0010/\u001a\u00020\n2\u0006\u0010\u0013\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\n2\u0006\u0010\u0013\u001a\u000200H\u0016J\u0010\u00102\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020-H\u0016J\u0010\u00103\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020-H\u0016J\u001f\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\f2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\n07H\u0082\bJ\u0010\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020:H\u0016J\u0016\u0010;\u001a\u00020\u001b2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0=H\u0016J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020@H\u0002¨\u0006C"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/CommonObricActivityManager;", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityManager;", "<init>", "()V", "getAutoDisplayId", "", "getCurrentTaskInfo", "Landroid/app/ActivityManager$RunningTaskInfo;", "displayId", "isPackageVisibleOnDisplay", "", "packageName", "", "isAutoActionTopActivityInSystemAnimation", "()Ljava/lang/Boolean;", "supportsAutoVirtualDisplayRecordSet", "beginAutoVirtualDisplayRecordSet", "", "userId", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAutoVirtualDisplayRecordSetListener;", "addAutoVirtualDisplayRecordPackages", "sessionId", "packageNames", "", "(J[Ljava/lang/String;)Z", "endAutoVirtualDisplayRecordSet", "", "requestTopActivityAssistData", "requestId", "receiver", "Landroid/app/ITopActivityAssistDataReceiver;", "registerTaskStackListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricTaskStackListener;", "unregisterTaskStackListenerEx", "moveTaskToDisplay", "taskId", "isTop", "tryToMute", "shouldMute", "enableCallUser", "enable", "addDisablePackage", "([Ljava/lang/String;)V", "registerBackNavigationInVirtualDisplayListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricBackNavigationListener;", "unregisterBackNavigationInVirtualDisplayListenerEx", "registerObricDisplayInfoCallback", "Lcom/obric/aiagent/product/platform/api/app/ObricDisplayInfoCallback;", "unregisterObricDisplayInfoCallback", "registerBackNavigationListener", "unregisterBackNavigationListener", "safeFrameworkBooleanCall", "methodName", "block", "Lkotlin/Function0;", "forceStopPackageOfCaller", "context", "Landroid/content/Context;", "setMuteWhitelist", "whiteList", "", "addExtraTaskNotTrimFlag", "intent", "Landroid/content/Intent;", "addExtraFlag", "Companion", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class CommonObricActivityManager implements IObricActivityManager {
    static {
    }

    public CommonObricActivityManager() {
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public final boolean a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Object r11 = r10.getSystemService("activity");     // Catch: Throwable -> L19
        if ((r11 instanceof ActivityManager) == false) goto L6;
        ActivityManager r12 = (ActivityManager) r11;     // Catch: Throwable -> L19
    L7:
        if (r12 != null) goto L10;
        ILogDepend.a.e("CommonActivityManager", "get ActivityManagerService failed");     // Catch: Throwable -> L19
        return false;
    L10:
        String r3 = IAppContext.a.getPackageName();     // Catch: Throwable -> L19
        if (r3.length() != 0) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L17;
        ILogDepend.a.e("CommonActivityManager", "packageName empty");     // Catch: Throwable -> L19
        return false;
    L17:
        Method r5 = r12.getClass().getDeclaredMethod("forceStopPackage", new Class[]{String.class});     // Catch: Throwable -> L19
        r5.setAccessible(true);     // Catch: Throwable -> L19
        ILogDepend.a.i("CommonActivityManager", "try forceStopPackage " + r3);     // Catch: Throwable -> L19
        r5.invoke(r12, new Object[]{r3});     // Catch: Throwable -> L19
        return true;
    L13:
        r4 = false;
        goto L14
    L6:
        r12 = null;
    L19:
        th = move-exception;
        ILogDepend.a.e("CommonActivityManager", "forceStopPackage exception", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public final void b(Intent r8) {
        Intrinsics.checkNotNullParameter(r8, "intent");
        ILogDepend.a.i("CommonActivityManager", "addExtraFlag");     // Catch: Throwable -> L5
        Object r9 = r8.getClass().getMethod("getSmtEx", new Class[0]).invoke(r8, new Object[0]);     // Catch: Throwable -> L5
        r9.getClass().getMethod("addSmFlags", new Class[]{Integer.TYPE}).invoke(r9, new Object[]{16});     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ILogDepend.a.e("CommonActivityManager", "addExtraFlag failed", th);
    }
}
