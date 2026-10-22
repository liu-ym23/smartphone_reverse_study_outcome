package com.obric.assistant.interaction.impl.window.behaviors;

import android.app.NotificationManager;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import com.bytedance.ai.api.AppletService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.IBehavior;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0002J\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/ClearNotificationBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "init", "", "onWindowShow", "onWindowHide", "clearAllNotifications", "tryToKeepAlarms", "notificationManager", "Landroid/app/NotificationManager;", "keepAlarmList", "", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClearNotificationBehavior implements IBehavior {
    public static final Companion Companion = null;
    private static final String TAG = "ClearNotificationBehavior";

    static {
        Companion = new Companion(null);
    }

    public ClearNotificationBehavior() {
    }

    public void init() {
    }

    public void onWindowHide() {
    }

    private final void clearAllNotifications() {
        Object r0 = AppHost.a.getApplication().getSystemService("notification");
        List<String> r2 = null;
        if ((r0 instanceof NotificationManager) == false) goto L5;
        NotificationManager r1 = (NotificationManager) r0;
    L6:
        if (r1 == null) goto L14;
        AppletService r3 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r3 == null) goto L10;
        r2 = r3.d();
    L10:
        if (r2 != null) goto L12;
        r1.cancelAll();
        return;
    L12:
        tryToKeepAlarms(r1, r2);
        return;
    L14:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void onWindowShow() {
        FLogger.a.i(TAG, "onWindowShow, clearAllNotifications");
        clearAllNotifications();
    }

    public void onAppBackground() {
        IBehavior.DefaultImpls.onAppBackground(this);
    }

    public void onAppForeground() {
        IBehavior.DefaultImpls.onAppForeground(this);
    }

    public void onWindowDismiss() {
        IBehavior.DefaultImpls.onWindowDismiss(this);
    }

    public void onWindowPreDismiss() {
        IBehavior.DefaultImpls.onWindowPreDismiss(this);
    }

    public void onWindowPreHide() {
        IBehavior.DefaultImpls.onWindowPreHide(this);
    }

    public void onWindowPreOpenClear() {
        IBehavior.DefaultImpls.onWindowPreOpenClear(this);
    }

    public void onWindowPreShow() {
        IBehavior.DefaultImpls.onWindowPreShow(this);
    }

    public void onWindowPreloaded() {
        IBehavior.DefaultImpls.onWindowPreloaded(this);
    }

    private final void tryToKeepAlarms(NotificationManager r6, List<String> r7) {
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        r6.cancelAll();
        return;
    L6:
        if ((!r7.isEmpty()) == false) goto L13;
        StatusBarNotification[] r0 = r6.getActiveNotifications();
        Intrinsics.checkNotNull(r0);
        int r1 = r0.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L19;
        StatusBarNotification r3 = r0[r2];
        if (r7.contains(r3.getNotification().getChannelId()) == true) goto L12;
        r6.cancel(r3.getId());
    L12:
        r2 = r2 + 1;
        goto L8
    L19:
        return;
    L13:
        r6.cancelAll();
    }

    public void onScreenRotationChanged(int r1, int r2) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r1, r2);
    }
}
