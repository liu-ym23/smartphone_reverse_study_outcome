package com.larus.dora.impl.core;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.bytedance.dora.wear.WearState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.api.IApmTrace;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraSimpleDevice;
import com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public class DoraLinkService extends Service {
    public static final /* synthetic */ int f = 0;
    public NotificationCompat.Builder a;
    public final kj4.a b;
    public final kj4.a c;
    public final a d;
    public final b e;

    public class a implements IDoraLinkCallback {
        public final /* synthetic */ DoraLinkService a;

        public final void onBtConnectStateChanged(DoraDevice r1, int r2, int r3) {
        }

        public final void onBtStateChanged(int r1, int r2) {
        }

        public final void onDeviceFound(DoraDevice r1) {
        }

        public final void onScanFailed(int r1) {
        }

        public a(DoraLinkService r1) {
            this.a = r1;
        }

        public final void onDoraLinkStateChanged(DoraDevice r5, int r6, int r7) {
            g49.d.d("DoraLinkService", "onDoraLinkStateChanged: " + r5 + ", " + r6 + ", " + r7);
            if (r7 != 2) goto L5;
            IApmTrace.a.d("connect_state", "DORA_CONNECT");
        L8:
            if (r7 == (-1)) goto L10;
        L12:
            if (r7 != 2) goto L14;
            boolean r8 = true;
        L15:
            NotificationManager r1 = (NotificationManager) this.a.getSystemService("notification");
            NotificationCompat.Builder r2 = this.a.a;
            if (r2 == null) goto L22;
            r2.setContentTitle(DoraLinkService.c(r5, Boolean.valueOf(r8)));
            DoraLinkService r9 = this.a;
            NotificationCompat.Builder r3 = r9.a;
            if (r8 == false) goto L20;
            int r10 = 2131901348;
        L21:
            r3.setContentText(r9.getString(r10));
            r1.notify(105, this.a.a.build());
            goto L22
        L20:
            r10 = 2131901349;
        L22:
            if (r7 != 2) goto L24;
            QuickNoteRepo.a.d();
            return;
        L24:
            if (r7 != 0) goto L28;
            QuickNoteRepo.a.getClass();
            QuickNoteRepo.e(DoraAdapterExtKt.h(kj4.a.g()));
            return;
        L28:
            return;
        L14:
            r8 = false;
            goto L15
        L10:
            if (DoraAdapterExtKt.j(kj4.a.g()).isEmpty() == false) goto L12;
            DoraLinkService r11 = this.a;
            int r12 = DoraLinkService.f;
            r11.d(13);
            goto L22
        L5:
            if (r7 != 0) goto L8;
            IApmTrace.a.d("connect_state", "DORA_DISCONNECT");
            goto L8
        }
    }

    public class b implements uk4.c {
        public final /* synthetic */ DoraLinkService a;

        public b(DoraLinkService r1) {
            this.a = r1;
        }

        public final void a(DoraDevice r1, WearState r2, WearState r3) {
            if (r2 == WearState.ON) goto L5;
            DoraLinkService r4 = this.a;
            DoraLinkService.a(r4, r4.getString(2131902770));
            return;
        L5:
            DoraLinkService r5 = this.a;
            DoraLinkService.a(r5, r5.getString(2131901348));
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r1) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        l0.c = SystemClock.elapsedRealtime();
        JSONObject r1 = new JSONObject();
    L9:
        e = move-exception;
        g49.d.c("DoraLinkService", "trace error !", e);
    L11:
        IApmTrace.a.f("dora_basic_monitor", r1, null, null);
        g49.d.d("DoraLinkService", "onCreate");
        int r2 = kj4.a.g().isReady();
        List r3 = DoraAdapterExtKt.j(kj4.a.g());
        if (r2 != 0) goto L14;
    L17:
        if (r3 != null) goto L19;
    L75:
        d(15);
        return;
    L19:
        if (r3.isEmpty() == true) goto L75;
        if (((IObricDoraService) ServiceManager.get().getService(IObricDoraService.class)) != null) goto L24;
    L27:
        boolean r4 = true;
    L28:
        if (r4 == false) goto L72;
        Intent r5 = getApplicationContext().getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (r5 != null) goto L32;
        r5 = new Intent();
    L32:
        int r6 = Build.VERSION.SDK_INT;
        int r7 = 201326592;
        if (r6 < 23) goto L35;
        int r9 = 201326592;
    L36:
        PendingIntent r8 = PendingIntent.getActivity(this, 0, r5, r9);
        int r10 = z59.a.a;
        AppHost.Companion r11 = AppHost.a;
        Intent r12 = r11.getApplication().getPackageManager().getLaunchIntentForPackage(r11.getApplication().getPackageName());
        if (r12 != null) goto L39;
        r12 = new Intent();
    L39:
        Application r13 = r11.getApplication();
        if (r6 >= 23) goto L43;
        r7 = 134217728;
    L43:
        PendingIntent.getActivity(r13, 0, r12, r7);
        if (r6 < 26) goto L46;
        NotificationChannel r14 = new NotificationChannel("LinkService", "link", 4);
        r14.enableLights(false);
        r14.setShowBadge(false);
        ((NotificationManager) r11.getApplication().getSystemService(NotificationManager.class)).createNotificationChannel(r14);
        NotificationCompat.Builder r15 = new NotificationCompat.Builder(r11.getApplication(), "LinkService");
    L47:
        DoraDevice r16 = DoraAdapterExtKt.h(kj4.a.g());
        if (r16 != null) goto L57;
        List r17 = DoraAdapterExtKt.j(kj4.a.g());
        if (r17 != null) goto L52;
    L55:
        r16 = null;
        goto L57
    L52:
        if (r17.isEmpty() == true) goto L55;
        r16 = (DoraDevice) ListProtector.get(r17, 0);
    L57:
        if (kj4.a.g().getDoraLinkState(r16) != 2) goto L59;
        boolean r18 = true;
    L60:
        NotificationCompat.Builder r20 = r15.setContentIntent(r8).setContentTitle(c(r16, Boolean.valueOf(r18)));
        if (r18 == false) goto L63;
        int r21 = 2131901348;
    L64:
        r20.setContentText(getString(r21)).setShowWhen(false).setSound(null).setAutoCancel(false).setSmallIcon(r11.b()).setOnlyAlertOnce(true).setSilent(true).setOngoing(true).setPriority(1);
        this.a = r15;
        Notification r22 = r15.build();
        if (r6 < 34) goto L67;
        startForeground(105, r22, 16);     // Catch: Throwable -> L69
    L77:
    L73:
        this.b.registerDoraLinkCallback(this.d);
        this.c.l(this.e);
        return;
    L67:
        startForeground(105, r22);     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        g49.d.c("DoraLinkService", "startForeground exception", th);
        d(16);
        return;
    L63:
        r21 = 2131901349;
        goto L64
    L59:
        r18 = false;
        goto L60
    L46:
        r15 = new NotificationCompat.Builder(r11.getApplication());
        goto L47
    L35:
        r9 = 134217728;
        goto L36
    L72:
        g49.d.d("DoraLinkService", "skip DoraLinkService foreground notification for obric device");
        goto L73
    L24:
        if (ObricFeatureServiceDelegate.b.b() == false) goto L27;
        r4 = false;
        goto L28
    L14:
        if (r2 == 3) goto L17;
        d(14);
        return;
    L4:
        if (AppHost.a.a().isAppBackground() == false) goto L6;
        String r23 = "background";
    L7:
        r1.put("type", "service_start");     // Catch: JSONException -> L9
        r1.put("app_state", r23);     // Catch: JSONException -> L9
        goto L11
    L6:
        r23 = "foreground";
        goto L7
    }

    public DoraLinkService() {
        this.b = kj4.a.g();
        this.c = kj4.a.g();
        this.d = new a(this);
        this.e = new b(this);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        g49.d.d("DoraLinkService", "onDestroy, try restart...");
        this.b.unregisterDoraLinkCallback(this.d);
        kj4.a r0 = this.c;
        b r1 = this.e;
        ((CopyOnWriteArraySet) r0.e.a).remove(r1);
        l0.c = 0;
    }

    public final void d(int r3) {
        z.c(r3);
        List r4 = DoraAdapterExtKt.j(kj4.a.g());
        g49.d.d("DoraLinkService", "shutdownService: " + r4.size());
        stopForeground(true);
        stopSelf();
        if (r4.isEmpty() == false) goto L6;
        ((NotificationManager) getSystemService("notification")).cancelAll();
        return;
    }

    public static void a(DoraLinkService r6, String r7) {
        if (r6.a != null) goto L5;
        g49.d.d("DoraLinkService", "notification builder is null, skip updateNotificationContent, isObricFeatureEnable=" + ObricFeatureServiceDelegate.b.a());
        return;
    L5:
        DoraDevice r0 = DoraAdapterExtKt.h(kj4.a.g());
        if (r0 != null) goto L8;
        g49.d.d("DoraLinkService", "cur dora device is null");
        return;
    L8:
        boolean r3 = true;
        if (kj4.a.g().getDoraLinkState(r0) != 2) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L14;
        return;
    L14:
        if (((IObricDoraService) ServiceManager.get().getService(IObricDoraService.class)) != null) goto L16;
    L19:
        if (r3 == false) goto L29;
        NotificationManager r2 = (NotificationManager) r6.getSystemService("notification");
        NotificationCompat.Builder r4 = r6.a;
        if (r4 == null) goto L28;
        r4.setContentTitle(c(r0, Boolean.valueOf(r1)));
        r6.a.setContentText(r7);
        r2.notify(105, r6.a.build());
        return;
    L28:
        return;
    L29:
        return;
    L16:
        if (ObricFeatureServiceDelegate.b.b() == false) goto L19;
        r3 = false;
        goto L19
    L11:
        r1 = false;
        goto L12
    }

    public static String b(Boolean r4, DoraDevice r5) {
        if (r5 != null) goto L11;
        if (r4.booleanValue() == false) goto L8;
        int r6 = com.larus.utils.j0.a;
        return com.larus.utils.j0.d(2131901350);
    L8:
        int r7 = com.larus.utils.j0.a;
        return com.larus.utils.j0.d(2131901351);
    L11:
        if (r5.vendorId != 4096) goto L19;
        if (r4.booleanValue() == true) goto L15;
        int r8 = com.larus.utils.j0.a;
        return com.larus.utils.j0.d(2131903115);
    L15:
        return AppHost.a.getApplication().getString(2131903109, new Object[]{o59.a.d(r5)});
    L19:
        if (ProductNameType.isDoraGSeriesType(r5.type) == false) goto L27;
        if (r4.booleanValue() == false) goto L24;
        int r9 = com.larus.utils.j0.a;
        return com.larus.utils.j0.d(2131902771);
    L24:
        int r10 = com.larus.utils.j0.a;
        return com.larus.utils.j0.d(2131902772);
    L27:
        if (r4.booleanValue() == false) goto L30;
        int r11 = com.larus.utils.j0.a;
        return com.larus.utils.j0.d(2131901350);
    L30:
        int r12 = com.larus.utils.j0.a;
        return com.larus.utils.j0.d(2131901351);
    }

    public static String c(DoraDevice r0, Boolean r1) {
        if (r0 != null) goto L9;
        com.larus.dora.impl.util.b0.a.getClass();
        DoraSimpleDevice r2 = com.larus.dora.impl.util.b0.l();
        if (r2 != null) goto L10;
        return "";
    L10:
        return b(r1, r2.toDevice());
    L9:
        return b(r1, r0);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r1, int r2, int r3) {
        if (r1 != null) goto L6;
        return 2;
    L6:
        return super.onStartCommand(r1, r2, r3);
    }
}
