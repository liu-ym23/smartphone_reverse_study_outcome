package com.larus.voicecall.impl.notification;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.IBinder;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.common.utility.DeviceUtils;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.g;
import com.larus.platform.service.z2;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.IRtcNotificationService;
import com.larus.voicecall.impl.ui.RealtimeCallActivity;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.event.LynxTouchEvent;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements IRtcNotificationService {
    public static final d a = null;
    public static final MutableSharedFlow<Integer> b = null;
    public static b c;
    public static a d;
    public static Function0<Unit> e;
    public static boolean f;

    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r3) {
            Intrinsics.checkNotNullParameter(r3, EasyGoDbTable.Server.NAME);
            d.f = false;
            FLogger.a.i("RTCServiceManager", "bindForegroundService onServiceDisconnected");
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r6, IBinder r7) {
            Intrinsics.checkNotNullParameter(r6, "className");
            Intrinsics.checkNotNullParameter(r7, "service");
            FLogger.a.i("RTCServiceManager", "bindForegroundService onServiceConnected");
            d r8 = d.a;
            r8.getClass();
            if (z2.a.Z2() == false) goto L11;
            if ((r7 instanceof RealtimeCallRTCMicAndPlaybackService.b) == false) goto L7;
            RealtimeCallRTCMicAndPlaybackService.b r9 = (RealtimeCallRTCMicAndPlaybackService.b) r7;
        L8:
            if (r9 == null) goto L16;
            b r10 = r9.a;
        L17:
            d.c = r10;
            if (r10 == null) goto L25;
            Service r11 = r10.getService();
            r8.getClass();
            int r12 = Build.VERSION.SDK_INT;
            if (r12 < 26) goto L25;
            NotificationChannel r0 = new NotificationChannel("call_channel", "realtimeCall", 4);
            r0.setLockscreenVisibility(1);
            if (r12 < 34) goto L24;
            r0.setBypassDnd(true);
            r0.setShowBadge(true);
        L24:
            r0.enableVibration(false);
            r0.setSound(null, null);
            ((NotificationManager) r11.getSystemService(NotificationManager.class)).createNotificationChannel(r0);
        L25:
            Function0<Unit> r13 = d.e;
            if (r13 == null) goto L28;
            r13.invoke();
        L28:
            d.e = null;
            return;
        L16:
            r10 = null;
            goto L17
        L7:
            r9 = null;
            goto L8
        L11:
            if ((r7 instanceof RTCService.b) == false) goto L13;
            RTCService.b r14 = (RTCService.b) r7;
        L14:
            if (r14 == null) goto L16;
            r10 = r14.a;
            goto L17
        L13:
            r14 = null;
            goto L14
        }
    }

    public d() {
    }

    static {
        a = new d();
        MutableSharedFlow<Integer> r0 = e.a;
        b = e.a;
    }

    @Override // com.larus.voicecall.api.IRtcNotificationService
    public final MutableSharedFlow a() {
        return b;
    }

    public static void b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("bindForegroundService, reason: ");
        r1.append(r7);
        r1.append(", rtcService is null: ");
        boolean r3 = false;
        if (c != null) goto L5;
        boolean r8 = true;
    L6:
        r1.append(r8);
        r0.i("RTCServiceManager", r1.toString());
        IObricChatUIService r9 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r9 != null) goto L9;
    L11:
        if (r3 == false) goto L16;
        if (ObricAsrDelegate.b.a() == false) goto L16;
        return;
    L16:
        if (c != null) goto L32;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L23
        a r11 = new a();     // Catch: Throwable -> L23
        AppHost.Companion r4 = AppHost.a;     // Catch: Throwable -> L23
        Application r5 = r4.getApplication();     // Catch: Throwable -> L23
        Application r6 = r4.getApplication();     // Catch: Throwable -> L23
        a.getClass();     // Catch: Throwable -> L23
        if (z2.a.Z2() == false) goto L20;
        Class r12 = RealtimeCallRTCMicAndPlaybackService.class;
    L21:
        r5.bindService(new Intent(r6, r12), r11, 1);     // Catch: Throwable -> L23
        r0.i("RTCServiceManager", "bindForegroundService start bind service");     // Catch: Throwable -> L23
        d = r11;     // Catch: Throwable -> L23
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L26:
        if (Result.exceptionOrNull-impl(r13) == null) goto L28;
        FLogger.a.e("RTCServiceManager", "bindForegroundService failed");
    L28:
        Result.box-impl(r13);
        return;
    L20:
        r12 = RTCService.class;
    L23:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L32:
        return;
    L9:
        if (r9.n() == true) goto L11;
        r3 = true;
        goto L11
    L5:
        r8 = false;
        goto L6
    }

    public static void d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("dismissForegroundNotification, ");
        r1.append(r4);
        r1.append(", rtcService null: ");
        if (c != null) goto L5;
        boolean r5 = true;
    L6:
        r1.append(r5);
        r1.append(", connection null: ");
        if (d != null) goto L9;
        boolean r6 = true;
    L10:
        r1.append(r6);
        r1.append(", notification show: ");
        r1.append(f);
        r0.i("RTCServiceManager", r1.toString());
        if (Build.VERSION.SDK_INT < 24) goto L17;
        b r7 = c;
        if (r7 == null) goto L22;
        Service r8 = r7.getService();
        if (r8 == null) goto L22;
        r8.stopForeground(1);
    L22:
        f = false;
        return;
    L17:
        b r9 = c;
        if (r9 == null) goto L22;
        Service r10 = r9.getService();
        if (r10 == null) goto L22;
        r10.stopForeground(true);
        goto L22
    L9:
        r6 = false;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    public static void e(String r9) {
        FLogger.a.i("RTCServiceManager", "handleAction: " + r9);
        if (r9 == null) goto L23;
        int r0 = r9.hashCode();
        if (r0 == (-295947265)) goto L19;
        if (r0 == 3363353) goto L16;
        if (r0 == 692880776) goto L12;
        return;
    L12:
        if (r9.equals("hang_up") == false) goto L28;
        MutableSharedFlow<Integer> r10 = e.a;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new RtcNotificationActionManager$handleHangupAction$1(null), 3, null);
        return;
    L28:
        return;
    L16:
        if (r9.equals("mute") == false) goto L25;
        MutableSharedFlow<Integer> r11 = e.a;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new RtcNotificationActionManager$handleMuteAction$1(null), 3, null);
        return;
    L25:
        return;
    L19:
        if (r9.equals("un_mute") == false) goto L29;
        MutableSharedFlow<Integer> r12 = e.a;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new RtcNotificationActionManager$handleUnMuteAction$1(null), 3, null);
        return;
    L29:
        return;
    }

    public static void h(String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("unbindForegroundService, ");
        r1.append(r6);
        r1.append(", rtcService null: ");
        boolean r3 = false;
        if (c != null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r1.append(", connection null: ");
        if (d != null) goto L9;
        r3 = true;
    L9:
        r1.append(r3);
        r1.append(", notification show: ");
        r1.append(f);
        r0.i("RTCServiceManager", r1.toString());
        d(r6);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L19
        a r8 = d;     // Catch: Throwable -> L19
        if (r8 == null) goto L13;
        AppHost.a.getApplication().unbindService(r8);     // Catch: Throwable -> L19
        d = null;     // Catch: Throwable -> L19
    L13:
        AppHost.Companion r4 = AppHost.a;     // Catch: Throwable -> L19
        Application r5 = r4.getApplication();     // Catch: Throwable -> L19
        a.getClass();     // Catch: Throwable -> L19
        if (z2.a.Z2() == false) goto L16;
        Class r9 = RealtimeCallRTCMicAndPlaybackService.class;
    L17:
        Intent r10 = new Intent(r5, r9);     // Catch: Throwable -> L19
        r4.getApplication().stopService(r10);     // Catch: Throwable -> L19
        c = null;     // Catch: Throwable -> L19
        r0.i("RTCServiceManager", "unbindForegroundService");     // Catch: Throwable -> L19
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L22:
        if (Result.exceptionOrNull-impl(r11) == null) goto L27;
        FLogger.a.e("RTCServiceManager", "unbindForegroundService failed");
        return;
    L27:
        return;
    L16:
        r9 = RTCService.class;
    L19:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L5:
        r2 = false;
        goto L6
    }

    public static void f(final String r5, final IRtcNotificationService.a r6) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        Intrinsics.checkNotNullParameter(r6, LynxResourceModule.DATA_KEY);
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("showForegroundNotification, rtcService null: ");
        boolean r4 = false;
        if (c != null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r1.append(", connection null: ");
        if (d != null) goto L9;
        boolean r3 = true;
    L10:
        r1.append(r3);
        r1.append(", notification show: ");
        r1.append(f);
        r0.i("RTCServiceManager", r1.toString());
        IObricChatUIService r7 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r7 != null) goto L13;
    L15:
        if (r4 == false) goto L20;
        if (ObricAsrDelegate.b.a() == false) goto L20;
        return;
    L20:
        if (c != null) goto L23;
        e = new c(r5, r6);
        return;
    L23:
        if (f == false) goto L44;
        AppHost.Companion r8 = AppHost.a;
        NotificationManagerCompat r9 = NotificationManagerCompat.from(r8.getApplication());
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L27
        d r11 = a;     // Catch: Throwable -> L27
        r11.getClass();     // Catch: Throwable -> L27
        r9.notify(101, c(r8.getApplication(), r6, true, r5 + "_update"));     // Catch: Throwable -> L27
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L49;
        g.a.ensureNotReachHere(r13, "notificationManager notify failed");
        return;
    L49:
        return;
    L27:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L44:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L34
        a.getClass();     // Catch: Throwable -> L34
        g(r5, r6);     // Catch: Throwable -> L34
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L36:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L40;
        FLogger.a.e("RTCServiceManager", "showForegroundNotification failed, " + r17.getMessage());
    L40:
        if (Result.isSuccess-impl(r16) == false) goto L42;
        Unit r18 = (Unit) r16;
        f = true;
    L42:
        Result.box-impl(r16);
        return;
    L34:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L13:
        if (r7.n() == true) goto L15;
        r4 = true;
        goto L15
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public static void g(String r6, IRtcNotificationService.a r7) {
        z2 r0 = z2.a;
        boolean r1 = r0.x0();
        if (r1 == false) goto L5;
    L6:
        if (r1 == true) goto L8;
    L18:
        b r2 = c;
        if (r2 == null) goto L27;
        Service r3 = r2.getService();
        if (r3 == null) goto L28;
        r3.startForeground(101, c(AppHost.a.getApplication(), r7, true, r6));
        return;
    L28:
        return;
    L27:
        return;
    L8:
        if (Build.VERSION.SDK_INT < 30) goto L18;
    L9:
        b r4 = c;
        if (r4 == null) goto L24;
        Service r5 = r4.getService();
        if (r5 == null) goto L25;
        Notification r8 = c(AppHost.a.getApplication(), r7, true, r6);
        if (r0.Z2() == false) goto L16;
        int r9 = 130;
    L17:
        r5.startForeground(101, r8, r9);
        return;
    L16:
        r9 = LynxTouchEvent.kPseudoStateFocusTransition;
        goto L17
    L25:
        return;
    L24:
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 34) goto L9;
        goto L6
    }

    public static Notification c(Context r33, IRtcNotificationService.a r34, boolean r35, String r36) {
        Intrinsics.checkNotNullParameter(r33, "context");
        Intrinsics.checkNotNullParameter(r34, "rtcData");
        Intrinsics.checkNotNullParameter(r36, "reason");
        FLogger.a.i("RTCServiceManager", "buildNotification, " + r36 + ", enableRoute: " + r35);
        boolean r3 = com.larus.voicecall.impl.notification.a.c(r33);
        String r4 = r33.getPackageName();
        if (com.larus.voicecall.impl.notification.a.d() == false) goto L5;
    L14:
        boolean r5 = true;
    L16:
        if (r5 == false) goto L20;
        if (r3 == false) goto L19;
        int r6 = 2131562767;
    L23:
        RemoteViews r10 = new RemoteViews(r4, r6);
        int r9 = Build.VERSION.SDK_INT;
        if (r9 < 31) goto L32;
        if (com.larus.voicecall.impl.notification.a.d() == false) goto L32;
        if (com.larus.voicecall.impl.notification.a.b() < 8) goto L30;
        r10.setViewVisibility(2131382208, 8);
        goto L32
    L30:
        r10.setViewLayoutMargin(2131382208, 4, 0.0f, 1);
    L32:
        if (r9 >= 31) goto L34;
    L36:
        r10.setTextViewText(2131380593, r34.a);
        r10.setTextViewText(2131388772, r34.b);
        Bitmap r7 = r34.c;
        if (r7 == null) goto L39;
        r10.setImageViewBitmap(2131382208, r7);
    L40:
        Integer r8 = r34.d;
        if (r8 == null) goto L43;
        r10.setImageViewResource(2131377162, r8.intValue());
        r10.setViewVisibility(2131377162, 0);
    L45:
        if (r34.f == false) goto L55;
        int r11 = j0.a;
        if (r34.e == false) goto L49;
        int r12 = 2131910874;
    L50:
        r10.setTextViewText(2131380531, j0.d(r12));
        if (r34.e == false) goto L53;
        PendingIntent r13 = e.a("un_mute");
    L54:
        r10.setOnClickPendingIntent(2131380531, r13);
        int r14 = 2131380593;
        int r15 = 8;
        int r16 = 2131382208;
    L56:
        r10.setOnClickPendingIntent(2131374194, e.a("hang_up"));
        String r17 = r33.getPackageName();
        if (com.larus.voicecall.impl.notification.a.e() == false) goto L59;
    L62:
        if (r9 >= 31) goto L64;
        boolean r18 = true;
    L65:
        if (r18 == false) goto L69;
        if (r3 == false) goto L68;
        int r19 = 2131562767;
    L72:
        RemoteViews r20 = new RemoteViews(r17, r19);
        if (r9 >= 31) goto L75;
    L79:
        r20.setTextViewText(r14, r34.a);
        r20.setTextViewText(2131388772, r34.b);
        Bitmap r21 = r34.c;
        if (r21 == null) goto L82;
        r20.setImageViewBitmap(r16, r21);
    L83:
        Integer r22 = r34.d;
        if (r22 == null) goto L86;
        r20.setImageViewResource(2131377162, r22.intValue());
        r20.setViewVisibility(2131377162, 0);
    L88:
        if (r34.f == false) goto L98;
        int r23 = j0.a;
        if (r34.e == false) goto L92;
        int r24 = 2131910874;
    L93:
        r20.setTextViewText(2131380531, j0.d(r24));
        if (r34.e == false) goto L96;
        PendingIntent r25 = e.a("un_mute");
    L97:
        r20.setOnClickPendingIntent(2131380531, r25);
    L99:
        r20.setOnClickPendingIntent(2131374194, e.a("hang_up"));
        IObricRealtimeCallExtService r26 = (IObricRealtimeCallExtService) ServiceManager.get().getService(IObricRealtimeCallExtService.class);
        if (r26 == null) goto L105;
        PendingIntent r27 = r26.getNotificationPendingIntent(r33, r34.g, r34.h);
        if (r27 == null) goto L105;
        boolean r28 = false;
    L120:
        NotificationCompat.Builder r29 = new NotificationCompat.Builder(r33, "call_channel");
        if (r3 == false) goto L123;
        int r0 = 2131241893;
    L124:
        NotificationCompat.Builder r1 = r29.setSmallIcon(r0).setShowWhen(r28).setSound(null).setVibrate(null).setContentTitle(r34.a).setContentText(r34.b).setAutoCancel(r28).setOngoing(r28).setPriority(1).setVisibility(1);
        if (z2.a.enableRealtimeCallGroup() == false) goto L127;
        r1.setGroup("realtime_call_group");
        r1.setGroupAlertBehavior(1);
    L127:
        NotificationCompat.Builder r2 = r1.setAutoCancel(true);
        if (r35 == false) goto L130;
        r2.setContentIntent(r27);
    L130:
        a.getClass();
        if (com.larus.voicecall.impl.notification.a.d() == false) goto L133;
    L144:
        boolean r30 = true;
    L145:
        if (r30 == false) goto L153;
        r2.setCustomContentView(r10);
        r2.setCustomBigContentView(r20);
        int r31 = j0.a;
        if (r3 == false) goto L149;
        int r32 = 2131103260;
    L150:
        r2.setColor(j0.a(r32));
        if (r9 < 26) goto L164;
        r2.setColorized(true);
    L164:
        return r2.build();
    L149:
        r32 = 2131103261;
        goto L150
    L153:
        Bitmap r37 = r34.c;
        if (r37 == null) goto L157;
        r2.setLargeIcon(r37);
    L157:
        if (r34.f == true) goto L159;
    L162:
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r38 = j0.a;
        r2.addAction(0, j0.d(2131905489), e.a("hang_up"));
        goto L164
    L159:
        if (r34.e == false) goto L161;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r39 = j0.a;
        r2.addAction(0, j0.d(2131910874), e.a("un_mute"));
        goto L162
    L161:
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r40 = j0.a;
        r2.addAction(0, j0.d(2131908041), e.a("mute"));
        goto L162
    L133:
        if (com.larus.voicecall.impl.notification.a.e() == true) goto L144;
        if (DeviceUtils.isHuawei() == true) goto L144;
        if (DeviceUtils.isOppo() == true) goto L144;
        if (DeviceUtils.isVivo() == true) goto L144;
        if (DeviceUtils.isFlyme() == true) goto L144;
        r30 = false;
        goto L145
    L123:
        r0 = 2131241894;
    L105:
        boolean r41 = r34.g;
        Context r42 = r34.h;
        if ((r42 instanceof Activity) == false) goto L108;
        Activity r43 = (Activity) r42;
    L109:
        if (r43 != null) goto L111;
        r43 = AppHost.a.a().getCurrentActivity();
    L111:
        if (r41 == false) goto L114;
        if (r43 == null) goto L114;
        Class<?> r44 = r43.getClass();
    L115:
        Intent r45 = new Intent(r33, r44);
        r45.setFlags(603979776);
        if (r9 < 23) goto L118;
        int r46 = 201326592;
    L119:
        r28 = false;
        r27 = PendingIntent.getActivity(r33, 0, r45, r46);
        goto L120
    L118:
        r46 = 134217728;
    L114:
        r44 = RealtimeCallActivity.class;
        goto L115
    L108:
        r43 = null;
        goto L109
    L96:
        r25 = e.a("mute");
        goto L97
    L92:
        r24 = 2131908041;
        goto L93
    L98:
        r20.setViewVisibility(2131380531, r15);
        r20.setViewPadding(2131374194, 0, i5.Y(), i5.r0(), i5.h());
        goto L99
    L86:
        r20.setViewVisibility(2131377162, r15);
        goto L88
    L82:
        r20.setImageViewResource(r16, 2131240119);
        goto L83
    L75:
        if (com.larus.voicecall.impl.notification.a.d() == false) goto L79;
        if (com.larus.voicecall.impl.notification.a.b() < r15) goto L79;
        r20.setViewVisibility(r16, r15);
        goto L79
    L68:
        r19 = 2131562768;
        goto L72
    L69:
        if (r3 == false) goto L71;
        r19 = 2131562766;
        goto L72
    L71:
        r19 = 2131562765;
    L64:
        r18 = false;
        goto L65
    L59:
        if (DeviceUtils.isOppo() == true) goto L62;
        if (DeviceUtils.isVivo() == false) goto L64;
    L53:
        r13 = e.a("mute");
        goto L54
    L49:
        r12 = 2131908041;
        goto L50
    L55:
        r10.setViewVisibility(2131380531, 8);
        r14 = 2131380593;
        r15 = 8;
        r16 = 2131382208;
        r10.setViewPadding(2131374194, 0, i5.Y(), i5.r0(), i5.h());
        goto L56
    L43:
        r10.setViewVisibility(2131377162, 8);
        goto L45
    L39:
        r10.setImageViewResource(2131382208, 2131240119);
        goto L40
    L34:
        if (DeviceUtils.isVivo() == false) goto L36;
        r10.setViewVisibility(2131365063, 8);
        r10.setViewVisibility(2131377162, 8);
        goto L36
    L19:
        r6 = 2131562768;
        goto L23
    L20:
        if (r3 == false) goto L22;
        r6 = 2131562766;
        goto L23
    L22:
        r6 = 2131562765;
        goto L23
    L5:
        if (com.larus.voicecall.impl.notification.a.e() == true) goto L11;
        if (DeviceUtils.isVivo() == true) goto L11;
        if (DeviceUtils.isOppo() == true) goto L11;
    L13:
        r5 = false;
    L11:
        if (Build.VERSION.SDK_INT >= 31) goto L13;
        goto L13
    }
}
