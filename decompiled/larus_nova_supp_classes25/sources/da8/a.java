package da8;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.common.utility.DeviceUtils;
import com.larus.avlink.n1;
import com.larus.avlink.simulInterpret.notification.TranslationNotificationBroadcastReceiver;
import com.larus.avlink.simulInterpret.page.view.SimultaneousInterpretActivity;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.j0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ha8.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final a a = null;
    public static String b;
    public static String c;

    public a() {
    }

    static {
        a = new a();
        b = "";
        c = "";
    }

    public static boolean d() {
        if (com.larus.voicecall.impl.notification.a.d() == false) goto L5;
    L14:
        return true;
    L5:
        if (com.larus.voicecall.impl.notification.a.e() == true) goto L14;
        if (DeviceUtils.isHuawei() == true) goto L14;
        if (DeviceUtils.isOppo() == true) goto L14;
        if (DeviceUtils.isFlyme() == true) goto L14;
        return false;
    }

    public static PendingIntent b(Context r3) {
        Intent r0 = new Intent(r3, SimultaneousInterpretActivity.class);
        r0.setFlags(805306368);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r1 = 201326592;
    L6:
        PendingIntent r4 = PendingIntent.getActivity(r3, 0, r0, r1);
        Intrinsics.checkNotNull(r4);
        return r4;
    L5:
        r1 = 134217728;
        goto L6
    }

    public static void a(Context r12, String r13) {
        boolean r0 = com.larus.voicecall.impl.notification.a.c(r12);
        boolean r7 = true;
        if (d() == false) goto L48;
        RemoteViews r1 = new RemoteViews(r12.getPackageName(), 2131563312);
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 == null) goto L11;
        DeviceService r9 = r8.device();
        if (r9 == null) goto L11;
        if (r9.b0() != true) goto L11;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L15;
        r1.setViewVisibility(2131387061, 8);
    L17:
        if (r13 != null) goto L19;
        com.larus.avlink.simulInterpret.page.model.a r11 = com.larus.avlink.simulInterpret.page.model.a.e;
        com.larus.avlink.simulInterpret.page.model.a r14 = com.larus.avlink.simulInterpret.page.model.a.C0026a.b(d.d());
        if (r14 == null) goto L32;
        String r15 = r14.c;
    L33:
        r1.setTextViewText(2131389352, r15);
    L35:
        if (r0 == false) goto L37;
        r1.setTextColor(2131389352, r12.getResources().getColor(2131103298));
        r1.setTextColor(2131388772, r12.getResources().getColor(2131103298));
    L38:
        NotificationCompat.Builder r16 = new NotificationCompat.Builder(r12, "translation_channel").setSmallIcon(2131241663).setContentText(r13).setShowWhen(false).setSound(null).setVibrate(null).setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setPriority(1).setOngoing(true).setOnlyAlertOnce(true).setVisibility(1).setAutoCancel(false).setContentIntent(b(r12));
        a.getClass();
        if (d() == false) goto L47;
        r16.setCustomContentView(r1);
        r16.setCustomBigContentView(r1);
        int r2 = j0.a;
        if (r0 == false) goto L43;
        int r3 = 2131103260;
    L44:
        r16.setColor(j0.a(r3));
        if (Build.VERSION.SDK_INT < 26) goto L47;
        r16.setColorized(true);
        goto L47
    L43:
        r3 = 2131103261;
    L47:
        NotificationManagerCompat.from(r12).notify(12345, r16.build());
        return;
    L37:
        r1.setTextColor(2131389352, r12.getResources().getColor(2131103292));
        r1.setTextColor(2131388772, r12.getResources().getColor(2131103292));
        goto L38
    L32:
        r15 = null;
        goto L33
    L19:
        if (r13.length() != 0) goto L21;
        boolean r17 = true;
    L22:
        if (r17 == false) goto L28;
        com.larus.avlink.simulInterpret.page.model.a r18 = com.larus.avlink.simulInterpret.page.model.a.e;
        com.larus.avlink.simulInterpret.page.model.a r19 = com.larus.avlink.simulInterpret.page.model.a.C0026a.b(d.d());
        if (r19 == null) goto L26;
        String r20 = r19.c;
    L27:
        r1.setTextViewText(2131389352, r20);
        goto L35
    L26:
        r20 = null;
        goto L27
    L28:
        r1.setTextViewText(2131389352, r13);
        goto L35
    L21:
        r17 = false;
        goto L22
    L15:
        boolean r21 = d.a;
        r1.setViewVisibility(2131387061, 8);
    L11:
        r10 = false;
        goto L13
    L48:
        NotificationCompat.Builder r110 = new NotificationCompat.Builder(r12, "translation_channel").setSmallIcon(2131241663).setContentTitle(r12.getString(2131902976)).setContentText("").setShowWhen(false).setSound(null).setVibrate(null).setPriority(1).setOngoing(true).setOnlyAlertOnce(true).setVisibility(1).setAutoCancel(false).setContentIntent(b(r12));
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L55;
        DeviceService r5 = r4.device();
        if (r5 == null) goto L55;
        if (r5.M() != true) goto L55;
    L56:
        if (r7 == false) goto L58;
        boolean r6 = d.a;
    L58:
        a r22 = a;
        Intrinsics.checkNotNull(r110);
        r22.getClass();
        int r23 = j0.a;
        String r24 = j0.d(2131903967);
        Intent r25 = new Intent(r12, TranslationNotificationBroadcastReceiver.class);
        r25.setAction("com.larus.dora.translation.end.si.click");
        if (Build.VERSION.SDK_INT < 23) goto L61;
        int r26 = 201326592;
    L62:
        r110.addAction(0, r24, PendingIntent.getBroadcast(r12, 0, r25, r26));
        NotificationManagerCompat.from(r12).notify(12345, r110.build());
        return;
    L61:
        r26 = 134217728;
    L55:
        r7 = false;
        goto L56
    }

    public static void c(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "sentenceId");
        Intrinsics.checkNotNullParameter(r4, "sentenceContent");
        if (d() == true) goto L5;
        return;
    L5:
        n1.d("TranslationNotificationManager", "sentenceId is " + r3 + ", sentenceContent is " + r4);
        if (Intrinsics.areEqual(r3, b) == false) goto L8;
        c += r4;
    L9:
        a(r2, c);
        return;
    L8:
        b = r3;
        c = r4;
        goto L9
    }
}
