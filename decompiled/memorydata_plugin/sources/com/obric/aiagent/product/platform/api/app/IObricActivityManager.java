package com.obric.aiagent.product.platform.api.app;

import android.app.ActivityManager;
import android.app.a;
import android.content.Context;
import android.content.Intent;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0003H&J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\bH&J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J#\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H&¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u000fH&J \u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u001fH&J \u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\bH&J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\bH&J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\bH&J\u001b\u0010(\u001a\u00020\u00192\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H&¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020+H&J\u0010\u0010,\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020+H&J\u0010\u0010-\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020.H&J\u0010\u0010/\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020.H&J\u0010\u00100\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020+H&J\u0010\u00101\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020+H&J\u0010\u00102\u001a\u00020\b2\u0006\u00103\u001a\u000204H&J\u0016\u00105\u001a\u00020\u00192\f\u00106\u001a\b\u0012\u0004\u0012\u00020\n07H\u0016J\u0010\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020:H&¨\u0006;"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/IObricActivityManager;", "", "getAutoDisplayId", "", "getCurrentTaskInfo", "Landroid/app/ActivityManager$RunningTaskInfo;", "displayId", "isPackageVisibleOnDisplay", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "isAutoActionTopActivityInSystemAnimation", "()Ljava/lang/Boolean;", "supportsAutoVirtualDisplayRecordSet", "beginAutoVirtualDisplayRecordSet", "", "userId", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAutoVirtualDisplayRecordSetListener;", "addAutoVirtualDisplayRecordPackages", ObricMemoryConstants.KEY_SESSION_ID, "packageNames", "", "(J[Ljava/lang/String;)Z", "endAutoVirtualDisplayRecordSet", "", "requestTopActivityAssistData", "requestId", "receiver", "Landroid/app/ITopActivityAssistDataReceiver;", "registerTaskStackListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricTaskStackListener;", "unregisterTaskStackListenerEx", "moveTaskToDisplay", "taskId", "isTop", "tryToMute", "shouldMute", "enableCallUser", "enable", "addDisablePackage", "([Ljava/lang/String;)V", "registerBackNavigationInVirtualDisplayListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricBackNavigationListener;", "unregisterBackNavigationInVirtualDisplayListenerEx", "registerObricDisplayInfoCallback", "Lcom/obric/aiagent/product/platform/api/app/ObricDisplayInfoCallback;", "unregisterObricDisplayInfoCallback", "registerBackNavigationListener", "unregisterBackNavigationListener", "forceStopPackageOfCaller", "context", "Landroid/content/Context;", "setMuteWhitelist", "whiteList", "", "addExtraTaskNotTrimFlag", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IObricActivityManager {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void setMuteWhitelist(IObricActivityManager r2, List<String> r3) {
            IObricActivityManager r4 = (IObricActivityManager) ZeusTransformUtils.wrapperContextForParams(r2, IObricActivityManager.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), "whiteList");
        }
    }

    boolean addAutoVirtualDisplayRecordPackages(long r1, String[] r3);

    void addDisablePackage(String[] r1);

    void addExtraTaskNotTrimFlag(Intent r1);

    long beginAutoVirtualDisplayRecordSet(int r1, int r2, ObricAutoVirtualDisplayRecordSetListener r3);

    void enableCallUser(boolean r1);

    void endAutoVirtualDisplayRecordSet(long r1);

    boolean forceStopPackageOfCaller(Context r1);

    int getAutoDisplayId();

    ActivityManager.RunningTaskInfo getCurrentTaskInfo(int r1);

    Boolean isAutoActionTopActivityInSystemAnimation();

    boolean isPackageVisibleOnDisplay(String r1, int r2);

    boolean moveTaskToDisplay(int r1, int r2, boolean r3);

    boolean registerBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r1);

    boolean registerBackNavigationListener(ObricBackNavigationListener r1);

    boolean registerObricDisplayInfoCallback(ObricDisplayInfoCallback r1);

    boolean registerTaskStackListenerEx(ObricTaskStackListener r1);

    boolean requestTopActivityAssistData(int r1, int r2, a r3);

    void setMuteWhitelist(List<String> r1);

    boolean supportsAutoVirtualDisplayRecordSet();

    void tryToMute(boolean r1);

    boolean unregisterBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r1);

    boolean unregisterBackNavigationListener(ObricBackNavigationListener r1);

    boolean unregisterObricDisplayInfoCallback(ObricDisplayInfoCallback r1);

    boolean unregisterTaskStackListenerEx(ObricTaskStackListener r1);
}
