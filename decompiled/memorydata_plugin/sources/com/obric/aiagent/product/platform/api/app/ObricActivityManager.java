package com.obric.aiagent.product.platform.api.app;

import android.app.ActivityManager;
import android.app.a;
import android.content.Context;
import android.content.Intent;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aiagent.product.platform.impl.app.AssistantActivityManagerImpl;
import com.obric.aiagent.product.platform.impl.app.CommonObricActivityManager;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.ugc.aweme.framework.services.f;
import com.ss.android.ugc.aweme.framework.services.g;
import com.ss.android.ugc.aweme.framework.services.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/ObricActivityManager;", "", "<init>", "()V", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricActivityManager {
    public static final Companion Companion = null;
    public static final int FLAG_SM_TASK_NOT_TRIMMABLE = 16;
    private static final String TAG = "ObricActivityManager";
    private static IObricActivityManager instance;

    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\bH\u0017J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\bH\u0017J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0017J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0017¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u000eH\u0017J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J#\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0017¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u0014H\u0017J \u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010!\u001a\u00020\"H\u0017J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020$H\u0017J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020$H\u0017J \u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u000eH\u0017J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u000eH\u0017J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u000eH\u0017J\u001b\u0010-\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0017¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000200H\u0017J\u0010\u00101\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000200H\u0017J\u0010\u00102\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000203H\u0017J\u0010\u00104\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000203H\u0017J\u0010\u00105\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000200H\u0017J\u0010\u00106\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000200H\u0017J\u0010\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u000209H\u0017J\u0016\u0010:\u001a\u00020\u001e2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050<H\u0017J\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020?H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/ObricActivityManager$Companion;", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityManager;", "<init>", "()V", "TAG", "", "instance", "FLAG_SM_TASK_NOT_TRIMMABLE", "", "getAutoDisplayId", "getCurrentTaskInfo", "Landroid/app/ActivityManager$RunningTaskInfo;", "displayId", "isPackageVisibleOnDisplay", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isAutoActionTopActivityInSystemAnimation", "()Ljava/lang/Boolean;", "supportsAutoVirtualDisplayRecordSet", "beginAutoVirtualDisplayRecordSet", "", "userId", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAutoVirtualDisplayRecordSetListener;", "addAutoVirtualDisplayRecordPackages", ObricMemoryConstants.KEY_SESSION_ID, "packageNames", "", "(J[Ljava/lang/String;)Z", "endAutoVirtualDisplayRecordSet", "", "requestTopActivityAssistData", "requestId", "receiver", "Landroid/app/ITopActivityAssistDataReceiver;", "registerTaskStackListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricTaskStackListener;", "unregisterTaskStackListenerEx", "moveTaskToDisplay", "taskId", "isTop", "tryToMute", "shouldMute", "enableCallUser", "enable", "addDisablePackage", "([Ljava/lang/String;)V", "registerBackNavigationInVirtualDisplayListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricBackNavigationListener;", "unregisterBackNavigationInVirtualDisplayListenerEx", "registerObricDisplayInfoCallback", "Lcom/obric/aiagent/product/platform/api/app/ObricDisplayInfoCallback;", "unregisterObricDisplayInfoCallback", "registerBackNavigationListener", "unregisterBackNavigationListener", "forceStopPackageOfCaller", "context", "Landroid/content/Context;", "setMuteWhitelist", "whiteList", "", "addExtraTaskNotTrimFlag", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements IObricActivityManager {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public boolean addAutoVirtualDisplayRecordPackages(long r2, String[] r4) {
            Intrinsics.checkNotNullParameter(r4, "packageNames");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();     // Catch: Exception -> L7
            if (r0 == null) goto L12;
            return r0.addAutoVirtualDisplayRecordPackages(r2, r4);
        L12:
            return false;
        L7:
            e = move-exception;
            d.f5954a.b(ObricActivityManager.TAG, "addAutoVirtualDisplayRecordPackages failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            return false;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public void addDisablePackage(String[] r1) {
            Intrinsics.checkNotNullParameter(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.addDisablePackage(r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public void addExtraTaskNotTrimFlag(Intent r1) {
            Intrinsics.checkNotNullParameter(r1, MemorySourceLinkType.INTENT);
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.addExtraTaskNotTrimFlag(r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public long beginAutoVirtualDisplayRecordSet(int r3, int r4, ObricAutoVirtualDisplayRecordSetListener r5) {
            Intrinsics.checkNotNullParameter(r5, "listener");
            IObricActivityManager r2 = ObricActivityManager.access$getInstance$cp();     // Catch: Exception -> L7
            if (r2 == null) goto L12;
            return r2.beginAutoVirtualDisplayRecordSet(r3, r4, r5);
        L12:
            return 0;
        L7:
            e = move-exception;
            d.f5954a.b(ObricActivityManager.TAG, "beginAutoVirtualDisplayRecordSet failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            return 0;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public void enableCallUser(boolean r1) {
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.enableCallUser(r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public void endAutoVirtualDisplayRecordSet(long r2) {
            IObricActivityManager r1 = ObricActivityManager.access$getInstance$cp();     // Catch: Exception -> L6
            if (r1 == null) goto L11;
            r1.endAutoVirtualDisplayRecordSet(r2);     // Catch: Exception -> L6
            return;
        L11:
            return;
        L6:
            e = move-exception;
            d.f5954a.b(ObricActivityManager.TAG, "endAutoVirtualDisplayRecordSet failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public boolean forceStopPackageOfCaller(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            IObricActivityManager r3 = ObricActivityManager.access$getInstance$cp();
            if (r3 != null) goto L7;
            return false;
        L7:
            return r3.forceStopPackageOfCaller(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public int getAutoDisplayId() {
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getAutoDisplayId();
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public ActivityManager.RunningTaskInfo getCurrentTaskInfo(int r1) {
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            ActivityManager.RunningTaskInfo r2 = r0.getCurrentTaskInfo(r1);
            if (r2 == null) goto L6;
            return r2;
        L6:
            return null;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public Boolean isAutoActionTopActivityInSystemAnimation() {
            Object r1 = null;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
            Companion r5 = (Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            IObricActivityManager r6 = ObricActivityManager.access$getInstance$cp();     // Catch: Throwable -> L9
            if (r6 == null) goto L6;
            Boolean r7 = r6.isAutoActionTopActivityInSystemAnimation();     // Catch: Throwable -> L9
        L7:
            Object r8 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L9
        L11:
            Throwable r3 = Result.m1424exceptionOrNullimpl(r8);
            if (r3 != null) goto L14;
            r1 = r8;
        L16:
            return (Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.memorydata.plugin");
        L14:
            d.f5954a.b(ObricActivityManager.TAG, "isAutoActionTopActivityInSystemAnimation failed", r3);
            goto L16
        L6:
            r7 = null;
        L9:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L11
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public boolean isPackageVisibleOnDisplay(String r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isPackageVisibleOnDisplay(r1, r2);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public boolean moveTaskToDisplay(int r1, int r2, boolean r3) {
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.moveTaskToDisplay(r1, r2, r3);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public boolean registerBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerBackNavigationInVirtualDisplayListenerEx(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public boolean registerBackNavigationListener(ObricBackNavigationListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerBackNavigationListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public boolean registerObricDisplayInfoCallback(ObricDisplayInfoCallback r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerObricDisplayInfoCallback(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public boolean registerTaskStackListenerEx(ObricTaskStackListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerTaskStackListenerEx(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public boolean requestTopActivityAssistData(int r2, int r3, a r4) {
            a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "receiver");
            IObricActivityManager r5 = ObricActivityManager.access$getInstance$cp();
            if (r5 != null) goto L7;
            return false;
        L7:
            return r5.requestTopActivityAssistData(r2, r3, r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public void setMuteWhitelist(List<String> r2) {
            List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "whiteList");
            IObricActivityManager r3 = ObricActivityManager.access$getInstance$cp();
            if (r3 == null) goto L6;
            r3.setMuteWhitelist(r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public boolean supportsAutoVirtualDisplayRecordSet() {
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();     // Catch: Exception -> L7
            if (r0 == null) goto L12;
            return r0.supportsAutoVirtualDisplayRecordSet();
        L12:
            return false;
        L7:
            e = move-exception;
            d.f5954a.b(ObricActivityManager.TAG, "supportsAutoVirtualDisplayRecordSet failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            return false;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public void tryToMute(boolean r1) {
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.tryToMute(r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public boolean unregisterBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterBackNavigationInVirtualDisplayListenerEx(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public boolean unregisterBackNavigationListener(ObricBackNavigationListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterBackNavigationListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public boolean unregisterObricDisplayInfoCallback(ObricDisplayInfoCallback r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterObricDisplayInfoCallback(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public boolean unregisterTaskStackListenerEx(ObricTaskStackListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterTaskStackListenerEx(r1);
        }
    }

    static {
        Companion = new Companion(null);
    L10:
        th = move-exception;
        d.f5954a.b(TAG, "bind CommonActivityManager failed", th);
    L12:
        instance = (IObricActivityManager) ZeusTransformUtils.preCheckCast(f.a().a(IObricActivityManager.class, false), IObricActivityManager.class, "com.obric.memorydata.plugin");
        d.f5954a.b(TAG, "ObricActivityManager instance: " + instance);
        return;
    L4:
        if (com.obric.aiagent.product.a.a.f5964a.a() == false) goto L7;
        f r2 = f.a();     // Catch: Throwable -> L10
        Class<IObricActivityManager> r3 = IObricActivityManager.class;
        g r4 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$ObricActivityManager$nTpbrUkO8hfahbwnUrH36w8Y4A.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L6:
        r2.a(r3, r4);     // Catch: Throwable -> L10
        d.f5954a.b(TAG, "bind ActivityManager assistantApi= " + com.obric.aiagent.product.a.a.f5964a.a());     // Catch: Throwable -> L10
        goto L12
    L7:
        r2 = f.a();     // Catch: Throwable -> L10
        r3 = IObricActivityManager.class;
        r4 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$ObricActivityManager$x3yK_WygCB2nabTBtq3VgNCRp9Q.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        goto L6
    }

    public ObricActivityManager() {
    }

    private static final Object _init_$lambda$0() {
        return new AssistantActivityManagerImpl();
    }

    private static final Object _init_$lambda$1() {
        return new CommonObricActivityManager();
    }

    public static final /* synthetic */ IObricActivityManager access$getInstance$cp() {
        return instance;
    }

    @JvmStatic
    public static boolean addAutoVirtualDisplayRecordPackages(long r1, String[] r3) {
        return Companion.addAutoVirtualDisplayRecordPackages(r1, r3);
    }

    @JvmStatic
    public static void addDisablePackage(String[] r1) {
        Companion.addDisablePackage(r1);
    }

    @JvmStatic
    public static void addExtraTaskNotTrimFlag(Intent r1) {
        Companion.addExtraTaskNotTrimFlag(r1);
    }

    @JvmStatic
    public static long beginAutoVirtualDisplayRecordSet(int r1, int r2, ObricAutoVirtualDisplayRecordSetListener r3) {
        return Companion.beginAutoVirtualDisplayRecordSet(r1, r2, r3);
    }

    @JvmStatic
    public static void enableCallUser(boolean r1) {
        Companion.enableCallUser(r1);
    }

    @JvmStatic
    public static void endAutoVirtualDisplayRecordSet(long r1) {
        Companion.endAutoVirtualDisplayRecordSet(r1);
    }

    @JvmStatic
    public static boolean forceStopPackageOfCaller(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return Companion.forceStopPackageOfCaller(r3);
    }

    @JvmStatic
    public static int getAutoDisplayId() {
        return Companion.getAutoDisplayId();
    }

    @JvmStatic
    public static ActivityManager.RunningTaskInfo getCurrentTaskInfo(int r1) {
        return Companion.getCurrentTaskInfo(r1);
    }

    @JvmStatic
    public static Boolean isAutoActionTopActivityInSystemAnimation() {
        return Companion.isAutoActionTopActivityInSystemAnimation();
    }

    @JvmStatic
    public static boolean isPackageVisibleOnDisplay(String r1, int r2) {
        return Companion.isPackageVisibleOnDisplay(r1, r2);
    }

    /* JADX INFO: renamed from: lambda$nTpbrUkO8hfahbwnUr-H36w8Y4A, reason: not valid java name */
    public static /* synthetic */ Object m151lambda$nTpbrUkO8hfahbwnUrH36w8Y4A() {
        return _init_$lambda$0();
    }

    public static /* synthetic */ Object lambda$x3yK_WygCB2nabTBtq3VgNCRp9Q() {
        return _init_$lambda$1();
    }

    @JvmStatic
    public static boolean moveTaskToDisplay(int r1, int r2, boolean r3) {
        return Companion.moveTaskToDisplay(r1, r2, r3);
    }

    @JvmStatic
    public static boolean registerBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r1) {
        return Companion.registerBackNavigationInVirtualDisplayListenerEx(r1);
    }

    @JvmStatic
    public static boolean registerBackNavigationListener(ObricBackNavigationListener r1) {
        return Companion.registerBackNavigationListener(r1);
    }

    @JvmStatic
    public static boolean registerObricDisplayInfoCallback(ObricDisplayInfoCallback r1) {
        return Companion.registerObricDisplayInfoCallback(r1);
    }

    @JvmStatic
    public static boolean registerTaskStackListenerEx(ObricTaskStackListener r1) {
        return Companion.registerTaskStackListenerEx(r1);
    }

    @JvmStatic
    public static boolean requestTopActivityAssistData(int r2, int r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        return Companion.requestTopActivityAssistData(r2, r3, r5);
    }

    @JvmStatic
    public static void setMuteWhitelist(List<String> r2) {
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Companion.setMuteWhitelist(r3);
    }

    @JvmStatic
    public static boolean supportsAutoVirtualDisplayRecordSet() {
        return Companion.supportsAutoVirtualDisplayRecordSet();
    }

    @JvmStatic
    public static void tryToMute(boolean r1) {
        Companion.tryToMute(r1);
    }

    @JvmStatic
    public static boolean unregisterBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r1) {
        return Companion.unregisterBackNavigationInVirtualDisplayListenerEx(r1);
    }

    @JvmStatic
    public static boolean unregisterBackNavigationListener(ObricBackNavigationListener r1) {
        return Companion.unregisterBackNavigationListener(r1);
    }

    @JvmStatic
    public static boolean unregisterObricDisplayInfoCallback(ObricDisplayInfoCallback r1) {
        return Companion.unregisterObricDisplayInfoCallback(r1);
    }

    @JvmStatic
    public static boolean unregisterTaskStackListenerEx(ObricTaskStackListener r1) {
        return Companion.unregisterTaskStackListenerEx(r1);
    }
}
