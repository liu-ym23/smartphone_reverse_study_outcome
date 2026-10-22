package com.obric.sva.sdk.notification;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.LogUtils;
import f06.b;
import f06.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/sva/sdk/notification/SvaNotificationListenerService;", "Landroid/service/notification/NotificationListenerService;", "<init>", "()V", "onNotificationPosted", "", "sbn", "Landroid/service/notification/StatusBarNotification;", "onNotificationRemoved", "onListenerConnected", "onListenerDisconnected", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SvaNotificationListenerService extends NotificationListenerService {
    public static final Companion Companion = null;
    private static final String TAG = "SvaNotificationListener";

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J \u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/sva/sdk/notification/SvaNotificationListenerService$Companion;", "", "<init>", "()V", "TAG", "", "requestRebind", "", "context", "Landroid/content/Context;", "logNotificationListenerPermission", "componentName", "Landroid/content/ComponentName;", "scene", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ void a(Context r0, ComponentName r1) {
            requestRebind$lambda$0(r0, r1);
        }

        @JvmStatic
        public final void requestRebind(final Context r9) {
            if (r9 != null) goto L6;
            LogUtils.w(SvaNotificationListenerService.TAG, "requestRebind failed, context is null", new Object[0]);
            return;
        L6:
            Context r3 = r9.getApplicationContext();
            if (r3 == null) goto L10;
            r9 = r3;
        L10:
            final ComponentName r4 = new ComponentName(r9, SvaNotificationListenerService.class);
            logNotificationListenerPermission(r9, r4, "beforeToggle");     // Catch: Throwable -> L15
            r9.getPackageManager().setComponentEnabledSetting(r4, 2, 1);     // Catch: Throwable -> L15
            r9.getPackageManager().setComponentEnabledSetting(r4, 1, 1);     // Catch: Throwable -> L15
            LogUtils.i(SvaNotificationListenerService.TAG, "requestRebind: toggle done for " + r4, new Object[0]);     // Catch: Throwable -> L15
            logNotificationListenerPermission(r9, r4, "afterToggle");     // Catch: Throwable -> L15
            if (Build.VERSION.SDK_INT < 24) goto L20;
            new Handler(Looper.getMainLooper()).postDelayed(new k(r9, r4), 1000);     // Catch: Throwable -> L15
            return;
        L20:
            return;
        L15:
            th = move-exception;
            LogUtils.w(SvaNotificationListenerService.TAG, "requestRebind failed", new Object[]{th});
        }

        private static String com_obric_sva_sdk_notification_SvaNotificationListenerService$Companion_android_provider_Settings$Secure_getString(ContentResolver r12, String r13) {
            c r8 = new c();
            Object[] r9 = {r12, r13};
            b r10 = new b();
            f06.d r11 = r8.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, "java.lang.String", r10);
            if (r11.a == false) goto L6;
            r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, null, r10, false);
            return (String) r11.b;
        L6:
            String r14 = Settings.Secure.getString(r12, r13);
            r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, r14, r10, true);
            return r14;
        }

        private static final void requestRebind$lambda$0(Context r6, ComponentName r7) {
            int r3 = r6.getPackageManager().getComponentEnabledSetting(r7);     // Catch: Throwable -> L5
            SvaNotificationListenerService.Companion.logNotificationListenerPermission(r6, r7, "beforeSystemRebind");     // Catch: Throwable -> L5
            NotificationListenerService.requestRebind(r7);     // Catch: Throwable -> L5
            LogUtils.i(SvaNotificationListenerService.TAG, "requestRebind: triggered system rebind for " + r7 + ", state: " + r3, new Object[0]);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.w(SvaNotificationListenerService.TAG, "system requestRebind failed", new Object[]{th});
        }

        private final void logNotificationListenerPermission(Context r12, ComponentName r13, String r14) {
            String r5 = com_obric_sva_sdk_notification_SvaNotificationListenerService$Companion_android_provider_Settings$Secure_getString(r12.getContentResolver(), "enabled_notification_listeners");     // Catch: Throwable -> L38
            if (r5 == null) goto L13;
            List r3 = StringsKt.split$default(r5, new String[]{":"}, false, 0, 6, null);     // Catch: Throwable -> L38
            if (r3 == null) goto L13;
            Collection r4 = new ArrayList();     // Catch: Throwable -> L38
            Iterator r6 = r3.iterator();     // Catch: Throwable -> L38
        L9:
            if (r6.hasNext() == false) goto L14;
            ComponentName r7 = ComponentName.unflattenFromString((String) r6.next());     // Catch: Throwable -> L38
            if (r7 == null) goto L9;
            r4.add(r7);     // Catch: Throwable -> L38
        L14:
            Collection r8 = r4;     // Catch: Throwable -> L38
            if ((r8 instanceof Collection) == true) goto L17;
        L19:
            Iterator r9 = r8.iterator();     // Catch: Throwable -> L38
        L21:
            if (r9.hasNext() == false) goto L18;
            if (Intrinsics.areEqual((ComponentName) r9.next(), r13) == false) goto L21;
            boolean r10 = true;
        L25:
            Collection r11 = r4;     // Catch: Throwable -> L38
            if ((r11 instanceof Collection) == true) goto L28;
        L30:
            Iterator r15 = r11.iterator();     // Catch: Throwable -> L38
        L32:
            if (r15.hasNext() == false) goto L29;
            if (Intrinsics.areEqual(((ComponentName) r15.next()).getPackageName(), r13.getPackageName()) == false) goto L32;
            boolean r16 = true;
        L36:
            LogUtils.i(SvaNotificationListenerService.TAG, "notification listener permission status, scene: " + r14 + ", packageGranted: " + r16 + ", componentGranted: " + r10 + ", componentState: " + r12.getPackageManager().getComponentEnabledSetting(r13), new Object[0]);     // Catch: Throwable -> L38
            return;
        L29:
            r16 = false;
            goto L36
        L28:
            if (r11.isEmpty() == false) goto L30;
        L18:
            r10 = false;
            goto L25
        L17:
            if (r8.isEmpty() == false) goto L19;
        L13:
            r4 = CollectionsKt.emptyList();     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            LogUtils.w(SvaNotificationListenerService.TAG, "log notification listener permission failed, scene: " + r14, new Object[]{th});
        }

        public static final /* synthetic */ void access$logNotificationListenerPermission(Companion r0, Context r1, ComponentName r2, String r3) {
            r0.logNotificationListenerPermission(r1, r2, r3);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final void requestRebind(Context r1) {
        Companion.requestRebind(r1);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerConnected() {
        super.onListenerConnected();
        LogUtils.i(TAG, "onListenerConnected", new Object[0]);
        Companion.access$logNotificationListenerPermission(Companion, this, new ComponentName(this, SvaNotificationListenerService.class), "onListenerConnected");
        SvaNotificationDispatchService$Dispatcher.INSTANCE.dispatchListenerConnected();
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerDisconnected() {
        super.onListenerDisconnected();
        LogUtils.i(TAG, "onListenerDisconnected", new Object[0]);
        SvaNotificationDispatchService$Dispatcher.INSTANCE.dispatchListenerDisconnected();
    }

    public SvaNotificationListenerService() {
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification r4) {
        super.onNotificationPosted(r4);
        StringBuilder r0 = new StringBuilder("onNotificationPosted: ");
        Long r1 = null;
        if (r4 == null) goto L5;
        String r2 = r4.getPackageName();
    L6:
        r0.append(r2);
        r0.append(", when: ");
        if (r4 == null) goto L9;
        r1 = Long.valueOf(r4.getPostTime());
    L9:
        r0.append(r1);
        LogUtils.i(TAG, r0.toString(), new Object[0]);
        SvaNotificationDispatchService$Dispatcher.INSTANCE.dispatchNotificationPosted(getApplicationContext(), r4);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification r4) {
        super.onNotificationRemoved(r4);
        StringBuilder r0 = new StringBuilder("onNotificationRemoved: ");
        Long r1 = null;
        if (r4 == null) goto L5;
        String r2 = r4.getPackageName();
    L6:
        r0.append(r2);
        r0.append(", when: ");
        if (r4 == null) goto L9;
        r1 = Long.valueOf(r4.getPostTime());
    L9:
        r0.append(r1);
        LogUtils.i(TAG, r0.toString(), new Object[0]);
        SvaNotificationDispatchService$Dispatcher.INSTANCE.dispatchNotificationRemoved(r4);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
