package com.obric.aiagent.product.platform.impl.app;

import android.app.ActivityManager;
import android.app.IObricBackNavigationListener;
import android.app.ObricActivityManager;
import android.content.Context;
import android.content.Intent;
import com.obric.aiagent.platform.a.a;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.platform.api.app.IObricActivityManager;
import com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener;
import com.obric.aiagent.product.platform.api.app.ObricBackNavigationListener;
import com.obric.aiagent.product.platform.api.app.ObricDisplayInfoCallback;
import com.obric.aiagent.product.platform.api.app.ObricTaskStackListener;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0005H\u0016J\r\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\nH\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J#\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0016¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J \u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020!H\u0016J \u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\nH\u0016J\u001b\u0010*\u001a\u00020\u001b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0016¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020-H\u0016J\u0010\u0010/\u001a\u00020\n2\u0006\u0010\u0013\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\n2\u0006\u0010\u0013\u001a\u000200H\u0016J\u0010\u00102\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020-H\u0016J\u0010\u00103\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020-H\u0016J\u001f\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\f2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\n07H\u0082\bJ\u0010\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020:H\u0016J\u0016\u0010;\u001a\u00020\u001b2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0=H\u0016J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020@H\u0002¨\u0006C"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/CommonObricActivityManager;", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityManager;", "<init>", "()V", "getAutoDisplayId", "", "getCurrentTaskInfo", "Landroid/app/ActivityManager$RunningTaskInfo;", "displayId", "isPackageVisibleOnDisplay", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "isAutoActionTopActivityInSystemAnimation", "()Ljava/lang/Boolean;", "supportsAutoVirtualDisplayRecordSet", "beginAutoVirtualDisplayRecordSet", "", "userId", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAutoVirtualDisplayRecordSetListener;", "addAutoVirtualDisplayRecordPackages", ObricMemoryConstants.KEY_SESSION_ID, "packageNames", "", "(J[Ljava/lang/String;)Z", "endAutoVirtualDisplayRecordSet", "", "requestTopActivityAssistData", "requestId", "receiver", "Landroid/app/ITopActivityAssistDataReceiver;", "registerTaskStackListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricTaskStackListener;", "unregisterTaskStackListenerEx", "moveTaskToDisplay", "taskId", "isTop", "tryToMute", "shouldMute", "enableCallUser", "enable", "addDisablePackage", "([Ljava/lang/String;)V", "registerBackNavigationInVirtualDisplayListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricBackNavigationListener;", "unregisterBackNavigationInVirtualDisplayListenerEx", "registerObricDisplayInfoCallback", "Lcom/obric/aiagent/product/platform/api/app/ObricDisplayInfoCallback;", "unregisterObricDisplayInfoCallback", "registerBackNavigationListener", "unregisterBackNavigationListener", "safeFrameworkBooleanCall", "methodName", "block", "Lkotlin/Function0;", "forceStopPackageOfCaller", "context", "Landroid/content/Context;", "setMuteWhitelist", "whiteList", "", "addExtraTaskNotTrimFlag", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "addExtraFlag", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CommonObricActivityManager implements IObricActivityManager {
    public static final Companion Companion = null;
    public static final String TAG = "CommonActivityManager";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/CommonObricActivityManager$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public CommonObricActivityManager() {
    }

    private final void addExtraFlag(Intent r7) {
        d.f5954a.b(TAG, "addExtraFlag");     // Catch: Throwable -> L5
        Object r8 = r7.getClass().getMethod("getSmtEx", new Class[0]).invoke(r7, new Object[0]);     // Catch: Throwable -> L5
        r8.getClass().getMethod("addSmFlags", new Class[]{Integer.TYPE}).invoke(r8, new Object[]{16});     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "addExtraFlag failed", th);
    }

    private final boolean safeFrameworkBooleanCall(String r2, Function0<Boolean> r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin")).invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        d.f5954a.b(TAG, r2 + " failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean addAutoVirtualDisplayRecordPackages(long r1, String[] r3) {
        Intrinsics.checkNotNullParameter(r3, "packageNames");
        return ObricAutoVirtualDisplayRecordSetFramework.INSTANCE.add(r1, r3);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void addDisablePackage(String[] r1) {
        Intrinsics.checkNotNullParameter(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);
        ObricActivityManager.addDisablePackage(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void addExtraTaskNotTrimFlag(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
        addExtraFlag(r2);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public long beginAutoVirtualDisplayRecordSet(int r1, int r2, ObricAutoVirtualDisplayRecordSetListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        return ObricAutoVirtualDisplayRecordSetFramework.INSTANCE.begin(r1, r2, r3);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void enableCallUser(boolean r1) {
        ObricActivityManager.enableCallUser(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void endAutoVirtualDisplayRecordSet(long r1) {
        ObricAutoVirtualDisplayRecordSetFramework.INSTANCE.end(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean forceStopPackageOfCaller(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        Object r10 = r9.getSystemService("activity");     // Catch: Throwable -> L19
        if (ZeusTransformUtils.instanceOf(r10, ActivityManager.class) == false) goto L6;
        ActivityManager r11 = (ActivityManager) ZeusTransformUtils.preCheckCast(r10, ActivityManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
    L7:
        if (r11 != null) goto L10;
        d.f5954a.d(TAG, "get ActivityManagerService failed");     // Catch: Throwable -> L19
        return false;
    L10:
        String r2 = a.f5948a.b();     // Catch: Throwable -> L19
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L17;
        d.f5954a.d(TAG, "packageName empty");     // Catch: Throwable -> L19
        return false;
    L17:
        Method r3 = r11.getClass().getDeclaredMethod("forceStopPackage", new Class[]{String.class});     // Catch: Throwable -> L19
        r3.setAccessible(true);     // Catch: Throwable -> L19
        d.f5954a.b(TAG, "try forceStopPackage " + r2);     // Catch: Throwable -> L19
        r3.invoke(r11, new Object[]{r2});     // Catch: Throwable -> L19
        return true;
    L13:
        r1 = false;
        goto L14
    L6:
        r11 = null;
    L19:
        th = move-exception;
        d.f5954a.b(TAG, "forceStopPackage exception", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public int getAutoDisplayId() {
        return ObricActivityManager.getAutoDisplayId();
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public ActivityManager.RunningTaskInfo getCurrentTaskInfo(int r1) {
        return ObricActivityManager.getCurrentTaskInfo(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public Boolean isAutoActionTopActivityInSystemAnimation() {
        return Boolean.valueOf(ObricActivityManager.isAutoActionTopActivityInSystemAnimation());
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean isPackageVisibleOnDisplay(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return ObricActivityManager.isPackageVisibleOnDisplay(r1, r2);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean moveTaskToDisplay(int r1, int r2, boolean r3) {
        return ObricActivityManager.moveTaskToDisplay(r1, r2, r3);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.IObricBackNavigationListener");
        return ObricActivityManager.registerBackNavigationInVirtualDisplayListenerEx((IObricBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IObricBackNavigationListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerBackNavigationListener(ObricBackNavigationListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.IObricBackNavigationListener");
        return ObricActivityManager.registerBackNavigationListener((IObricBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IObricBackNavigationListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerObricDisplayInfoCallback(ObricDisplayInfoCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r2 = r3.getObricStub();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.ObricDisplayInfoCallback");     // Catch: Throwable -> L5
        return ObricActivityManager.registerObricDisplayInfoCallback((android.app.ObricDisplayInfoCallback) ZeusTransformUtils.preCheckCast(r2, android.app.ObricDisplayInfoCallback.class, "com.obric.memorydata.plugin"));
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "registerObricDisplayInfoCallback failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerTaskStackListenerEx(ObricTaskStackListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.ObricTaskStackListener");
        return ObricActivityManager.registerTaskStackListenerEx((android.app.ObricTaskStackListener) ZeusTransformUtils.preCheckCast(r1, android.app.ObricTaskStackListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean requestTopActivityAssistData(int r2, int r3, android.app.a r4) {
        android.app.a r1 = (android.app.a) ZeusTransformUtils.wrapperContextForParams(r4, android.app.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "receiver");
        return ObricActivityManager.requestTopActivityAssistData(r2, r3, r1);
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "requestTopActivityAssistData failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void setMuteWhitelist(List<String> r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "whiteList");
        ObricActivityManager.setMuteWhitelist(r2);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "setMuteWhitelist failed", th);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean supportsAutoVirtualDisplayRecordSet() {
        return ObricAutoVirtualDisplayRecordSetFramework.INSTANCE.isSupported();
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void tryToMute(boolean r1) {
        ObricActivityManager.tryToMute(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.IObricBackNavigationListener");
        return ObricActivityManager.unregisterBackNavigationInVirtualDisplayListenerEx((IObricBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IObricBackNavigationListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterBackNavigationListener(ObricBackNavigationListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.IObricBackNavigationListener");
        return ObricActivityManager.unregisterBackNavigationListener((IObricBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IObricBackNavigationListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterObricDisplayInfoCallback(ObricDisplayInfoCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r2 = r3.getObricStub();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.ObricDisplayInfoCallback");     // Catch: Throwable -> L5
        return ObricActivityManager.unregisterObricDisplayInfoCallback((android.app.ObricDisplayInfoCallback) ZeusTransformUtils.preCheckCast(r2, android.app.ObricDisplayInfoCallback.class, "com.obric.memorydata.plugin"));
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "unregisterObricDisplayInfoCallback failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterTaskStackListenerEx(ObricTaskStackListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.ObricTaskStackListener");
        return ObricActivityManager.unregisterTaskStackListenerEx((android.app.ObricTaskStackListener) ZeusTransformUtils.preCheckCast(r1, android.app.ObricTaskStackListener.class, "com.obric.memorydata.plugin"));
    }
}
