package h58;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.audio.ainotes.notification.AiNoteService;
import com.larus.audio.e0;
import com.larus.common.apphost.AppHost;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static AiNoteService a;
    public static a b;
    public static boolean c;

    static {
    }

    public static Notification a(Context r17, String r19) {
        int r1 = e0.a;
        Intrinsics.checkNotNullParameter(r17, "context");
        if ((r17.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r2 = true;
    L6:
        String r5 = r17.getPackageName();
        if (e0.a() == true) goto L23;
        String r6 = Build.MANUFACTURER;
        if (r6 != null) goto L11;
    L13:
        boolean r7 = false;
    L14:
        if (r7 == true) goto L20;
        if (DeviceUtils.isVivo() == true) goto L20;
        if (DeviceUtils.isOppo() == true) goto L20;
    L22:
        boolean r8 = false;
    L24:
        if (r8 == false) goto L28;
        if (r2 == false) goto L27;
        int r9 = 2131562735;
    L31:
        RemoteViews r3 = new RemoteViews(r5, r9);
        int r10 = Build.VERSION.SDK_INT;
        if (r10 >= 31) goto L34;
    L36:
        if (r10 >= 31) goto L38;
    L40:
        AppHost.Companion r13 = AppHost.a;
        r3.setTextViewText(2131380593, r13.getApplication().getString(2131907351));
        r3.setTextViewText(2131388772, r13.getApplication().getString(2131907350));
        r3.setImageViewResource(2131382208, 2131238525);
        String r4 = r17.getPackageName();
        String r11 = Build.MANUFACTURER;
        if (r11 != null) goto L43;
    L45:
        boolean r16 = false;
    L46:
        if (r16 == false) goto L48;
    L51:
        if (r10 >= 31) goto L53;
        boolean r12 = true;
    L54:
        if (r12 == false) goto L58;
        if (r2 == false) goto L57;
        int r14 = 2131562735;
    L61:
        RemoteViews r15 = new RemoteViews(r4, r14);
        r15.setTextViewText(2131380593, r13.getApplication().getString(2131907351));
        r15.setTextViewText(2131388772, r13.getApplication().getString(2131907350));
        r15.setImageViewResource(2131382208, 2131238525);
        String r20 = "sslocal://flow/chat?is_from_outer=true&open_method=outer&bot_id=" + r19;
        Intent r21 = r13.getApplication().getPackageManager().getLaunchIntentForPackage(r13.getApplication().getPackageName());
        if (r21 != null) goto L64;
        r21 = new Intent();
    L64:
        r21.setAction("android.intent.action.VIEW");
        r21.setPackage(r13.getApplication().getPackageName());
        r21.setData(UriProtector.parse(r20).buildUpon().build());
        r21.setFlags(268468224);
        if (r10 < 23) goto L67;
        int r22 = 201326592;
    L68:
        PendingIntent r23 = PendingIntent.getActivity(r17, 0, r21, r22);
        NotificationCompat.Builder r24 = new NotificationCompat.Builder(r17, "ai_note_channel");
        if (r2 == false) goto L71;
        int r0 = 2131241713;
    L72:
        NotificationCompat.Builder r25 = r24.setSmallIcon(r0).setShowWhen(false).setSound(null).setVibrate(null).setContentTitle(r13.getApplication().getString(2131907351)).setContentText(r13.getApplication().getString(2131907350)).setAutoCancel(false).setOngoing(false).setPriority(1).setContentIntent(r23).setVisibility(1);
        if (e0.a() == true) goto L90;
        if (r11 != null) goto L76;
    L78:
        boolean r26 = false;
    L79:
        if (r26 == true) goto L90;
        if (DeviceUtils.isHuawei() == true) goto L90;
        if (DeviceUtils.isOppo() == true) goto L90;
        if (DeviceUtils.isVivo() == true) goto L90;
        if (DeviceUtils.isFlyme() == true) goto L90;
        boolean r27 = false;
    L91:
        if (r27 == false) goto L100;
        r25.setCustomContentView(r3);
        r25.setCustomBigContentView(r15);
        int r29 = j0.a;
        if (r2 == false) goto L95;
        int r30 = 2131103260;
    L96:
        r25.setColor(j0.a(r30));
        if (r10 < 26) goto L100;
        r25.setColorized(true);
        goto L100
    L95:
        r30 = 2131103261;
    L100:
        return r25.build();
    L76:
        if (StringsKt.equals(r11, "OnePlus", true) == false) goto L78;
        r26 = true;
    L90:
        r27 = true;
        goto L91
    L71:
        r0 = 2131241714;
        goto L72
    L67:
        r22 = 134217728;
        goto L68
    L57:
        r14 = 2131562736;
        goto L61
    L58:
        if (r2 == false) goto L60;
        r14 = 2131562734;
        goto L61
    L60:
        r14 = 2131562733;
    L53:
        r12 = false;
        goto L54
    L48:
        if (DeviceUtils.isOppo() == true) goto L51;
        if (DeviceUtils.isVivo() == false) goto L53;
    L43:
        if (StringsKt.equals(r11, "OnePlus", true) == false) goto L45;
        r16 = true;
        goto L46
    L38:
        if (DeviceUtils.isVivo() == false) goto L40;
        r3.setViewVisibility(2131377162, 8);
        goto L40
    L34:
        if (e0.a() == false) goto L36;
        r3.setViewLayoutMargin(2131382208, 4, 0.0f, 1);
        goto L36
    L27:
        r9 = 2131562736;
        goto L31
    L28:
        if (r2 == false) goto L30;
        r9 = 2131562734;
        goto L31
    L30:
        r9 = 2131562733;
    L20:
        if (Build.VERSION.SDK_INT >= 31) goto L22;
    L11:
        if (StringsKt.equals(r6, "OnePlus", true) == false) goto L13;
        r7 = true;
    L23:
        r8 = true;
        goto L24
    L5:
        r2 = false;
        goto L6
    }

    public static void b(String r3, String r4) {
        if (a != null) goto L6;
        b = new a(r3, r4);
        return;
    L6:
        if (c == true) goto L30;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L18
        if (Build.VERSION.SDK_INT < 34) goto L12;
        AiNoteService r6 = a;     // Catch: Throwable -> L18
        if (r6 == null) goto L15;
        r6.startForeground(104, a(AppHost.a.getApplication(), r3), 128);     // Catch: Throwable -> L18
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L18
    L20:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L24;
        FLogger.a.e("AiNoteServiceManager", "showForegroundNotification failed, " + r9.getMessage());
    L24:
        if (Result.isSuccess-impl(r8) == false) goto L31;
        Unit r10 = (Unit) r8;
        c = true;
        return;
    L31:
        return;
    L15:
        r7 = null;
        goto L16
    L12:
        AiNoteService r11 = a;     // Catch: Throwable -> L18
        if (r11 == null) goto L15;
        r11.startForeground(104, a(AppHost.a.getApplication(), r3));     // Catch: Throwable -> L18
        r7 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
