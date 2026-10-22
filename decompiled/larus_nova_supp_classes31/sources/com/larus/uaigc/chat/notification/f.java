package com.larus.uaigc.chat.notification;

import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.common.utility.DeviceUtils;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.g;
import com.larus.uaigc.helper.d0;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public static CreationService a;
    public static d b;
    public static boolean c;
    public static final Set<Integer> d = null;

    static {
        d = new LinkedHashSet();
    }

    public static void d() {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        CreationService r0 = a;
        if (r0 == null) goto L10;
        r0.stopForeground(1);
    L10:
        c = false;
        d.clear();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        AppHost.Companion r2 = AppHost.a;     // Catch: Throwable -> L13
        Intent r3 = new Intent(r2.getApplication(), CreationService.class);     // Catch: Throwable -> L13
        r2.getApplication().stopService(r3);     // Catch: Throwable -> L13
        a = null;     // Catch: Throwable -> L13
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L16:
        if (Result.exceptionOrNull-impl(r4) == null) goto L21;
        FLogger.a.e("CreationNotificationManager", "unbindForegroundService failed");
        return;
    L21:
        return;
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L7:
        CreationService r6 = a;
        if (r6 == null) goto L10;
        r6.stopForeground(true);
        goto L10
    }

    public static void b(int r2) {
        d.remove(Integer.valueOf(r2));
        NotificationManagerCompat r0 = NotificationManagerCompat.from(AppHost.a.getApplication());
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        r0.cancel(r2);     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (Result.exceptionOrNull-impl(r3) == null) goto L13;
        FLogger.a.e("CreationNotificationManager", "notificationManager cancel failed");
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static void c(k r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        d.add(Integer.valueOf(r4.a));
        if (a != null) goto L6;
        b = new d(r4);
        return;
    L6:
        if (c == false) goto L29;
        e(r4);
        return;
    L29:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        if (Build.VERSION.SDK_INT < 34) goto L13;
        CreationService r1 = a;     // Catch: Throwable -> L19
        if (r1 == null) goto L16;
        r1.startForeground(107, a(AppHost.a.getApplication(), r4), 128);     // Catch: Throwable -> L19
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L19
    L21:
        Throwable r2 = Result.exceptionOrNull-impl(r6);
        if (r2 == null) goto L25;
        FLogger.a.e("CreationNotificationManager", "showForegroundNotification failed, " + r2.getMessage());
    L25:
        if (Result.isSuccess-impl(r6) == false) goto L27;
        Unit r3 = (Unit) r6;
        c = true;
    L27:
        Result.box-impl(r6);
        return;
    L16:
        r5 = null;
        goto L17
    L13:
        CreationService r7 = a;     // Catch: Throwable -> L19
        if (r7 == null) goto L16;
        r7.startForeground(107, a(AppHost.a.getApplication(), r4));     // Catch: Throwable -> L19
        r5 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    public static void e(k r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        AppHost.Companion r0 = AppHost.a;
        NotificationManagerCompat r1 = NotificationManagerCompat.from(r0.getApplication());
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        r1.notify(r3.a, a(r0.getApplication(), r3));     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L13;
        g.a.ensureNotReachHere(r5, "notificationManager notify failed");
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static Notification a(Context r27, k r28) {
        int r2 = d0.a;
        Intrinsics.checkNotNullParameter(r27, "context");
        if ((r27.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r3 = true;
    L6:
        String r6 = r27.getPackageName();
        if (d0.a() == true) goto L23;
        String r7 = Build.MANUFACTURER;
        if (r7 != null) goto L11;
    L13:
        boolean r8 = false;
    L14:
        if (r8 == true) goto L20;
        if (DeviceUtils.isVivo() == true) goto L20;
        if (DeviceUtils.isOppo() == true) goto L20;
    L22:
        boolean r9 = false;
    L25:
        if (r9 == false) goto L29;
        if (r3 == false) goto L28;
        int r10 = 2131562795;
    L32:
        RemoteViews r4 = new RemoteViews(r6, r10);
        int r11 = Build.VERSION.SDK_INT;
        if (r11 >= 31) goto L35;
    L37:
        r4.setChronometer(2131365715, r28.d, "%s", true);
        r4.setTextViewText(2131388772, r28.b);
        r4.setTextViewText(2131367794, r28.c);
        r4.setProgressBar(2131383287, 100, r28.e, false);
        r4.setImageViewResource(2131382208, 2131241144);
        if (r11 < 31) goto L42;
        if (DeviceUtils.isVivo() == false) goto L42;
    L44:
        r4.setViewVisibility(2131383289, 8);
    L45:
        String r12 = r27.getPackageName();
        String r13 = Build.MANUFACTURER;
        if (r13 != null) goto L48;
    L50:
        boolean r21 = false;
    L51:
        if (r21 == false) goto L53;
    L56:
        if (r11 >= 31) goto L58;
        boolean r14 = true;
    L59:
        if (r14 == false) goto L63;
        if (r3 == false) goto L62;
        int r15 = 2131562795;
    L66:
        RemoteViews r16 = new RemoteViews(r12, r15);
        r16.setTextViewText(2131388772, r28.b);
        r16.setTextViewText(2131367794, r28.c);
        r16.setChronometer(2131365715, r28.d, null, true);
        r16.setProgressBar(2131383287, 100, r28.e, false);
        if (r28.g == false) goto L69;
        r16.setViewVisibility(2131383289, 0);
    L70:
        r16.setImageViewResource(2131382208, 2131241144);
        IFlowSdkDepend r17 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r17 == null) goto L73;
        r17.P();
        PendingIntent r18 = ChatServiceImpl.a.d(r28.f);
    L74:
        NotificationCompat.Builder r19 = new NotificationCompat.Builder(r27, "ugc_creation_channel");
        AppHost.Companion r0 = AppHost.a;
        NotificationCompat.Builder r20 = r19.setSmallIcon(r0.b()).setShowWhen(false).setSound(null).setVibrate(null).setContentTitle(r28.b).setContentText(r28.c).setAutoCancel(false).setOngoing(false).setPriority(1).setContentIntent(r18);
        Bundle r22 = r28.h;
        Intent r23 = new Intent(r0.getApplication(), CreationService.class);
        r23.setAction("delete");
        if (r22 == null) goto L77;
        r23.putExtras(r22);
    L77:
        Application r1 = r0.getApplication();
        if (r11 < 23) goto L80;
        int r24 = 201326592;
    L81:
        NotificationCompat.Builder r5 = r20.setDeleteIntent(PendingIntent.getService(r1, 99, r23, r24)).setVisibility(1);
        if (d0.a() == true) goto L99;
        if (r13 != null) goto L85;
    L87:
        boolean r25 = false;
    L88:
        if (r25 == true) goto L99;
        if (DeviceUtils.isHuawei() == true) goto L99;
        if (DeviceUtils.isOppo() == true) goto L99;
        if (DeviceUtils.isVivo() == true) goto L99;
        if (DeviceUtils.isFlyme() == true) goto L99;
        boolean r26 = false;
    L100:
        if (r26 == false) goto L109;
        r5.setCustomContentView(r4);
        r5.setCustomBigContentView(r16);
        int r29 = j0.a;
        if (r3 == false) goto L104;
        int r30 = 2131102638;
    L105:
        r5.setColor(j0.a(r30));
        if (r11 < 26) goto L112;
        r5.setColorized(true);
    L112:
        return r5.build();
    L104:
        r30 = 2131102639;
        goto L105
    L109:
        if (r28.g == false) goto L112;
        r5.setProgress(100, r28.e, false);
        goto L112
    L85:
        if (StringsKt.equals(r13, "OnePlus", true) == false) goto L87;
        r25 = true;
    L99:
        r26 = true;
        goto L100
    L80:
        r24 = 134217728;
        goto L81
    L73:
        r18 = null;
        goto L74
    L69:
        r16.setViewVisibility(2131383289, 8);
        goto L70
    L62:
        r15 = 2131562796;
        goto L66
    L63:
        if (r3 == false) goto L65;
        r15 = 2131562793;
        goto L66
    L65:
        r15 = 2131562794;
    L58:
        r14 = false;
        goto L59
    L53:
        if (DeviceUtils.isOppo() == true) goto L56;
        if (DeviceUtils.isVivo() == false) goto L58;
    L48:
        if (StringsKt.equals(r13, "OnePlus", true) == false) goto L50;
        r21 = true;
    L42:
        if (r28.g == false) goto L44;
        r4.setViewVisibility(2131383289, 0);
        goto L45
    L35:
        if (d0.a() == false) goto L37;
        r4.setViewLayoutMargin(2131382208, 4, 0.0f, 1);
        goto L37
    L28:
        r10 = 2131562796;
        goto L32
    L29:
        if (r3 == false) goto L31;
        r10 = 2131562793;
        goto L32
    L31:
        r10 = 2131562794;
    L20:
        if (Build.VERSION.SDK_INT >= 31) goto L22;
    L11:
        if (StringsKt.equals(r7, "OnePlus", true) == false) goto L13;
        r8 = true;
    L23:
        r9 = true;
        goto L25
    L5:
        r3 = false;
        goto L6
    }
}
