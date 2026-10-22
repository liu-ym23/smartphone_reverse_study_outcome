package com.obric.aiagent.product.platform.impl.app;

import android.app.ActivityManager;
import android.app.AssistantActivityManager;
import android.app.AssistantDisplayInfoCallback;
import android.app.AssistantTaskStackListener;
import android.app.IAssistantBackNavigationListener;
import android.content.AssistantIntentController;
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
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u000f\u0010\r\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000eJ \u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J#\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001cH\u0016¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020!H\u0016J \u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\nH\u0016J\u001b\u0010*\u001a\u00020\u001f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u001cH\u0016¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020-H\u0016J\u0010\u0010/\u001a\u00020\n2\u0006\u0010\u0017\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\n2\u0006\u0010\u0017\u001a\u000200H\u0016J\u0010\u00102\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020-H\u0016J\u0010\u00103\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020-H\u0016J\u001f\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\f2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\n07H\u0082\bJ\u0010\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020:H\u0016J\u0016\u0010;\u001a\u00020\u001f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0=H\u0016J\u0010\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020@H\u0016¨\u0006B"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/AssistantActivityManagerImpl;", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityManager;", "<init>", "()V", "getAutoDisplayId", "", "getCurrentTaskInfo", "Landroid/app/ActivityManager$RunningTaskInfo;", "displayId", "isPackageVisibleOnDisplay", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "isAutoActionTopActivityInSystemAnimation", "()Ljava/lang/Boolean;", "requestTopActivityAssistData", "requestId", "receiver", "Landroid/app/ITopActivityAssistDataReceiver;", "supportsAutoVirtualDisplayRecordSet", "beginAutoVirtualDisplayRecordSet", "", "userId", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAutoVirtualDisplayRecordSetListener;", "addAutoVirtualDisplayRecordPackages", ObricMemoryConstants.KEY_SESSION_ID, "packageNames", "", "(J[Ljava/lang/String;)Z", "endAutoVirtualDisplayRecordSet", "", "registerTaskStackListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricTaskStackListener;", "unregisterTaskStackListenerEx", "moveTaskToDisplay", "taskId", "isTop", "tryToMute", "shouldMute", "enableCallUser", "enable", "addDisablePackage", "([Ljava/lang/String;)V", "registerBackNavigationInVirtualDisplayListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricBackNavigationListener;", "unregisterBackNavigationInVirtualDisplayListenerEx", "registerObricDisplayInfoCallback", "Lcom/obric/aiagent/product/platform/api/app/ObricDisplayInfoCallback;", "unregisterObricDisplayInfoCallback", "registerBackNavigationListener", "unregisterBackNavigationListener", "safeFrameworkBooleanCall", "methodName", "block", "Lkotlin/Function0;", "forceStopPackageOfCaller", "context", "Landroid/content/Context;", "setMuteWhitelist", "whiteList", "", "addExtraTaskNotTrimFlag", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AssistantActivityManagerImpl implements IObricActivityManager {
    public static final Companion Companion = null;
    public static final String TAG = "AssistantActivityManagerImpl";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/AssistantActivityManagerImpl$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public AssistantActivityManagerImpl() {
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
        return AssistantAutoVirtualDisplayRecordSetFramework.INSTANCE.add(r1, r3);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void addDisablePackage(String[] r1) {
        Intrinsics.checkNotNullParameter(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);
        AssistantActivityManager.addDisablePackage(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void addExtraTaskNotTrimFlag(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        AssistantIntentController.setAssistantFlags(r3, 16);     // Catch: Throwable -> L5
        d.f5954a.b(TAG, "addExtraTaskNotTrimFlag called");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "addExtraTaskNotTrimFlag exception", th);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public long beginAutoVirtualDisplayRecordSet(int r1, int r2, ObricAutoVirtualDisplayRecordSetListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        return AssistantAutoVirtualDisplayRecordSetFramework.INSTANCE.begin(r1, r2, r3);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void enableCallUser(boolean r1) {
        AssistantActivityManager.enableCallUser(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void endAutoVirtualDisplayRecordSet(long r1) {
        AssistantAutoVirtualDisplayRecordSetFramework.INSTANCE.end(r1);
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
        return AssistantActivityManager.getAutoDisplayId();
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public ActivityManager.RunningTaskInfo getCurrentTaskInfo(int r1) {
        return AssistantActivityManager.getCurrentTaskInfo(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public Boolean isAutoActionTopActivityInSystemAnimation() {
        return null;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean isPackageVisibleOnDisplay(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return AssistantActivityManager.isPackageVisibleOnDisplay(r1, r2);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean moveTaskToDisplay(int r1, int r2, boolean r3) {
        return AssistantActivityManager.moveTaskToDisplay(r1, r2, r3);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getAssistantStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.IAssistantBackNavigationListener");
        return AssistantActivityManager.registerBackNavigationInVirtualDisplayListenerEx((IAssistantBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IAssistantBackNavigationListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerBackNavigationListener(ObricBackNavigationListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getAssistantStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.IAssistantBackNavigationListener");
        return AssistantActivityManager.registerBackNavigationListener((IAssistantBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IAssistantBackNavigationListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerObricDisplayInfoCallback(ObricDisplayInfoCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r2 = r3.getAssistantStub();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.AssistantDisplayInfoCallback");     // Catch: Throwable -> L5
        return AssistantActivityManager.registerAssistantDisplayInfoCallback((AssistantDisplayInfoCallback) ZeusTransformUtils.preCheckCast(r2, AssistantDisplayInfoCallback.class, "com.obric.memorydata.plugin"));
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "registerObricDisplayInfoCallback failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerTaskStackListenerEx(ObricTaskStackListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getAssistantStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.AssistantTaskStackListener");
        return AssistantActivityManager.registerTaskStackListenerEx((AssistantTaskStackListener) ZeusTransformUtils.preCheckCast(r1, AssistantTaskStackListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean requestTopActivityAssistData(int r9, int r10, android.app.a r11) {
        android.app.a r8 = (android.app.a) ZeusTransformUtils.wrapperContextForParams(r11, android.app.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "receiver");
        Method r1 = AssistantActivityManager.class.getMethod("requestTopActivityAssistData", new Class[]{Integer.TYPE, Integer.TYPE, android.app.a.class});     // Catch: Throwable -> L9
        Object[] r2 = {Integer.valueOf(r9), Integer.valueOf(r10), r8};     // Catch: Throwable -> L9
        Boolean r12 = null;
        Object r13 = r1.invoke(null, r2);     // Catch: Throwable -> L9
        if (ZeusTransformUtils.instanceOf(r13, Boolean.class) == false) goto L6;
        r12 = (Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L6:
        if (r12 == null) goto L14;
        return r12.booleanValue();
    L14:
        return false;
    L9:
        th = move-exception;
        d.f5954a.b(TAG, "requestTopActivityAssistData failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void setMuteWhitelist(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "whiteList");
        AssistantActivityManager.setMuteWhitelist(r4);     // Catch: Throwable -> L5
        d.f5954a.b(TAG, "setMuteWhitelist called");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "setMuteWhitelist exception", th);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean supportsAutoVirtualDisplayRecordSet() {
        return AssistantAutoVirtualDisplayRecordSetFramework.INSTANCE.isSupported();
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void tryToMute(boolean r1) {
        AssistantActivityManager.tryToMute(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getAssistantStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.IAssistantBackNavigationListener");
        return AssistantActivityManager.unregisterBackNavigationInVirtualDisplayListenerEx((IAssistantBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IAssistantBackNavigationListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterBackNavigationListener(ObricBackNavigationListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getAssistantStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.IAssistantBackNavigationListener");
        return AssistantActivityManager.unregisterBackNavigationListener((IAssistantBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IAssistantBackNavigationListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterObricDisplayInfoCallback(ObricDisplayInfoCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r2 = r3.getAssistantStub();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.AssistantDisplayInfoCallback");     // Catch: Throwable -> L5
        return AssistantActivityManager.unregisterAssistantDisplayInfoCallback((AssistantDisplayInfoCallback) ZeusTransformUtils.preCheckCast(r2, AssistantDisplayInfoCallback.class, "com.obric.memorydata.plugin"));
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "unregisterObricDisplayInfoCallback failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterTaskStackListenerEx(ObricTaskStackListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getAssistantStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.AssistantTaskStackListener");
        return AssistantActivityManager.unregisterTaskStackListenerEx((AssistantTaskStackListener) ZeusTransformUtils.preCheckCast(r1, AssistantTaskStackListener.class, "com.obric.memorydata.plugin"));
    }
}
