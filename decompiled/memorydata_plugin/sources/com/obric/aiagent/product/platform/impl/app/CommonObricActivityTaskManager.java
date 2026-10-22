package com.obric.aiagent.product.platform.impl.app;

import android.app.ActivityManager;
import android.app.IObricActivitySwitchListener;
import android.app.IObricAppSwitchListener;
import android.app.ObricActivityTaskManager;
import android.content.Context;
import android.os.Build;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager;
import com.obric.aiagent.product.platform.api.app.ObricActivitySwitchListener;
import com.obric.aiagent.product.platform.api.app.ObricAppSwitchListener;
import com.obric.aiagent.product.platform.api.app.ObricFocusListener;
import com.obric.aiagent.product.platform.api.app.ObricSystemAnimationListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/CommonObricActivityTaskManager;", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityTaskManager;", "<init>", "()V", "registerAppSwitchListener", "", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAppSwitchListener;", "unregisterAppSwitchListener", "registerActivitySwitchListener", "Lcom/obric/aiagent/product/platform/api/app/ObricActivitySwitchListener;", "unregisterActivitySwitchListener", "registerFocusListener", "Lcom/obric/aiagent/product/platform/api/app/ObricFocusListener;", "unregisterFocusListener", "registerSystemAnimationListener", "Lcom/obric/aiagent/product/platform/api/app/ObricSystemAnimationListener;", "unregisterSystemAnimationListener", "finishAndRemoveAllTask", "context", "Landroid/content/Context;", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CommonObricActivityTaskManager implements IObricActivityTaskManager {
    public static final Companion Companion = null;
    public static final String TAG = "CommonObricActivityTaskManager";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/CommonObricActivityTaskManager$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CommonObricActivityTaskManager() {
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean finishAndRemoveAllTask(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Object r7 = r6.getSystemService("activity");     // Catch: Throwable -> L20
        if (ZeusTransformUtils.instanceOf(r7, ActivityManager.class) == false) goto L6;
        ActivityManager r8 = (ActivityManager) ZeusTransformUtils.preCheckCast(r7, ActivityManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
    L7:
        if (r8 != null) goto L11;
        d.f5954a.d(CommonObricActivityManager.TAG, "get ActivityManagerService failed");     // Catch: Throwable -> L20
        return false;
    L11:
        if (Build.VERSION.SDK_INT < 21) goto L19;
        d.f5954a.b(TAG, "finishAndRemoveAllTask on Android 5.0+");     // Catch: Throwable -> L20
        List<ActivityManager.AppTask> r9 = r8.getAppTasks();     // Catch: Throwable -> L20
        Intrinsics.checkNotNullExpressionValue(r9, "getAppTasks(...)");     // Catch: Throwable -> L20
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L20
    L14:
        if (r10.hasNext() == false) goto L17;
        ((ActivityManager.AppTask) ZeusTransformUtils.preCheckCast(r10.next(), ActivityManager.AppTask.class, "com.obric.memorydata.plugin")).finishAndRemoveTask();     // Catch: Throwable -> L20
        goto L14
    L17:
        return true;
    L19:
        return false;
    L6:
        r8 = null;
    L20:
        th = move-exception;
        d.f5954a.b(TAG, "finishAndRemoveAllTask failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean registerActivitySwitchListener(ObricActivitySwitchListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r2 = r3.getObricStub();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.IObricActivitySwitchListener");     // Catch: Throwable -> L5
        return ObricActivityTaskManager.registerActivitySwitchListener((IObricActivitySwitchListener) ZeusTransformUtils.preCheckCast(r2, IObricActivitySwitchListener.class, "com.obric.memorydata.plugin"));
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "registerActivitySwitchListener failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean registerAppSwitchListener(ObricAppSwitchListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.IObricAppSwitchListener");
        return ObricActivityTaskManager.registerAppSwitchListener((IObricAppSwitchListener) ZeusTransformUtils.preCheckCast(r1, IObricAppSwitchListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean registerFocusListener(ObricFocusListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.ObricFocusListener");
        return ObricActivityTaskManager.registerFocusListener((android.app.ObricFocusListener) ZeusTransformUtils.preCheckCast(r1, android.app.ObricFocusListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean registerSystemAnimationListener(ObricSystemAnimationListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ObricActivityTaskManager.registerSystemAnimationListener(r3.getObricStub());     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "registerSystemAnimationListener failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean unregisterActivitySwitchListener(ObricActivitySwitchListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r2 = r3.getObricStub();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.IObricActivitySwitchListener");     // Catch: Throwable -> L5
        return ObricActivityTaskManager.unregisterActivitySwitchListener((IObricActivitySwitchListener) ZeusTransformUtils.preCheckCast(r2, IObricActivitySwitchListener.class, "com.obric.memorydata.plugin"));
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "unregisterActivitySwitchListener failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean unregisterAppSwitchListener(ObricAppSwitchListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.IObricAppSwitchListener");
        return ObricActivityTaskManager.unregisterAppSwitchListener((IObricAppSwitchListener) ZeusTransformUtils.preCheckCast(r1, IObricAppSwitchListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean unregisterFocusListener(ObricFocusListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.ObricFocusListener");
        return ObricActivityTaskManager.unregisterFocusListener((android.app.ObricFocusListener) ZeusTransformUtils.preCheckCast(r1, android.app.ObricFocusListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean unregisterSystemAnimationListener(ObricSystemAnimationListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ObricActivityTaskManager.unregisterSystemAnimationListener(r3.getObricStub());     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "unregisterSystemAnimationListener failed", th);
        return false;
    }
}
