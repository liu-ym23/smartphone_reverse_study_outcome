package com.obric.assistant.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.format.DateFormat;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.larus.nova.NovaApplication;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.live.receiver.ObricLiveReceiver;
import com.obric.assistant.spi.notification.IObricNotificationIslandService;
import com.obric.assistant.t1;
import gd9.i;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0007\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006!"}, d2 = {"Lcom/obric/assistant/notification/ObricNotificationIslandService;", "Lcom/obric/assistant/spi/notification/IObricNotificationIslandService;", "<init>", "()V", "hasPendingVoiceWakeupImproveNotification", "", "appBackgroundListener", "com/obric/assistant/notification/ObricNotificationIslandService$appBackgroundListener$1", "Lcom/obric/assistant/notification/ObricNotificationIslandService$appBackgroundListener$1;", "getKeepAlarmList", "", "", "onVoiceWakeupSessionGenerated", "", "tryShowVoiceWakeupImproveNotification", "from", "shouldQueueVoiceWakeupImproveNotification", "shouldShowVoiceWakeupImproveNotification", "buildVoiceWakeupImproveNotification", "Landroid/app/Notification;", "context", "Landroid/content/Context;", "buildVoiceWakeupImproveRemoteViews", "Landroid/widget/RemoteViews;", "buildReceiverPendingIntent", "Landroid/app/PendingIntent;", "action", "requestCode", "", "ensureNotificationChannel", "hasShownVoiceWakeupImproveNotification", "markVoiceWakeupImproveNotificationShown", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricNotificationIslandService implements IObricNotificationIslandService {
    public volatile boolean a;

    public static final class a {
    }

    public static final class b implements gd9.b {
        public final /* synthetic */ ObricNotificationIslandService a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppForeground() {
        }

        public final void onAppBackground() {
            FLogger r0 = FLogger.a;
            r0.i("ObricNotificationIsland", "onAppBackground pending=" + this.a.a);
            ObricNotificationIslandService r1 = this.a;
            if (r1.a == true) goto L5;
            r0.i("ObricNotificationIsland", "shouldShowVoiceWakeupImproveNotification disabled: no pending notification");
        L11:
            boolean r3 = false;
        L13:
            if (r3 == true) goto L15;
            r0.i("ObricNotificationIsland", "skip voice wakeup improve notification from=onAppBackground");
            return;
        L15:
            i r4 = com.larus.im.b.a;
            Intrinsics.checkNotNull(r4);
            NovaApplication r5 = r4.getApplication();
            r5.getClass();
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L28
            Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L28
            if (Build.VERSION.SDK_INT < 26) goto L23;
            Object r7 = r5.getSystemService("notification");     // Catch: Throwable -> L28
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.app.NotificationManager");     // Catch: Throwable -> L28
            NotificationManager r8 = (NotificationManager) r7;     // Catch: Throwable -> L28
            if (r8.getNotificationChannel("obric_voice_wakeup_improve_channel") != null) goto L23;
            r8.createNotificationChannel(new NotificationChannel("obric_voice_wakeup_improve_channel", r5.getString(2131912277), 4));     // Catch: Throwable -> L28
        L23:
            NotificationManagerCompat r9 = NotificationManagerCompat.from(r5);     // Catch: Throwable -> L28
            if (r9.areNotificationsEnabled() == true) goto L26;
            r0.i("ObricNotificationIsland", "tryShowVoiceWakeupImproveNotification notifications disabled");     // Catch: Throwable -> L28
            return;
        L26:
            r9.notify(23070101, ObricNotificationIslandService.c(r5));     // Catch: Throwable -> L28
            r1.a = false;     // Catch: Throwable -> L28
            t1.a.J1();     // Catch: Throwable -> L28
            r0.i("ObricNotificationIsland", "show voice wakeup improve notification from=onAppBackground");     // Catch: Throwable -> L28
            Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
        L30:
            Throwable r10 = Result.exceptionOrNull-impl(r2);
            if (r10 == null) goto L37;
            FLogger.a.e("ObricNotificationIsland", "show voice wakeup improve notification failed", r10);
            return;
        L37:
            return;
        L28:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r2 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L30
        L5:
            t1 r12 = t1.a;
            if (r12.x0() == false) goto L9;
            r0.i("ObricNotificationIsland", "shouldShowVoiceWakeupImproveNotification disabled: switch already on");
            r1.a = false;
            goto L11
        L9:
            if (r12.K0() == false) goto L12;
            r0.i("ObricNotificationIsland", "shouldShowVoiceWakeupImproveNotification disabled: already shown");
            r1.a = false;
            goto L11
        L12:
            i r13 = com.larus.im.b.a;
            Intrinsics.checkNotNull(r13);
            r3 = r13.a().e;
            r0.i("ObricNotificationIsland", "shouldShowVoiceWakeupImproveNotification isAppBackground=" + r3);
            goto L13
        }

        public b(ObricNotificationIslandService r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.obric.assistant.spi.notification.IObricNotificationIslandService
    public final void b() {
        t1 r0 = t1.a;
        if (r0.x0() == false) goto L6;
        FLogger.a.i("ObricNotificationIsland", "shouldQueueVoiceWakeupImproveNotification disabled: switch already on");
    L8:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L12;
        return;
    L12:
        this.a = true;
        FLogger.a.i("ObricNotificationIsland", "queue voice wakeup improve notification");
        return;
    L6:
        if (r0.K0() == false) goto L9;
        FLogger.a.i("ObricNotificationIsland", "shouldQueueVoiceWakeupImproveNotification disabled: already shown");
        goto L8
    L9:
        r1 = true;
        goto L10
    }

    public ObricNotificationIslandService() {
        b r0 = new b(this);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        i r2 = com.larus.im.b.a;     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L5
        r2.a().b(r0);     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L13;
        FLogger.a.e("ObricNotificationIsland", "register app background listener failed", r4);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.obric.assistant.spi.notification.IObricNotificationIslandService
    public final List<String> a() {
        if (Intrinsics.areEqual(t9a.b.a().d(), "Genesis-R") == false) goto L7;
        return CollectionsKt.listOf("obric_gr_island_channel");
    L7:
        return CollectionsKt.emptyList();
    }

    public static Notification c(Context r2) {
        return new NotificationCompat.Builder(r2, "obric_voice_wakeup_improve_channel").setSmallIcon(2131244522).setCategory("recommendation").setPriority(1).setAutoCancel(true).setOnlyAlertOnce(true).setShowWhen(false).setCustomContentView(d(r2)).setCustomBigContentView(d(r2)).build();
    }

    public static RemoteViews d(Context r5) {
        String r0 = DateFormat.getTimeFormat(r5).format(new Date());
        Intent r1 = new Intent(r5, ObricLiveReceiver.class);
        r1.setAction("com.obric.assistant.notification.action.OPEN_VOICE_WAKEUP_IMPROVE_SETTINGS");
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r2 = 67108864;
    L6:
        PendingIntent r3 = PendingIntent.getBroadcast(r5, 1, r1, r2 | 134217728);
        RemoteViews r4 = new RemoteViews(r5.getPackageName(), 2131564038);
        r4.setTextViewText(2131381228, r5.getString(2131912279));
        r4.setTextViewText(2131381226, r5.getString(2131912278));
        r4.setTextViewText(2131381227, r0);
        r4.setOnClickPendingIntent(2131381225, r3);
        return r4;
    L5:
        r2 = 0;
        goto L6
    }
}
