package com.obric.miniapp.alarm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.DateTimePatternGenerator;
import android.icu.text.RelativeDateTimeFormatter;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d0 implements b0 {
    public static final d0 b = null;
    public static final Lazy c = null;
    public static final NotificationManager d = null;

    public d0() {
    }

    @Override // com.obric.miniapp.alarm.b0
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
    }

    static {
        b = new d0();
        c = LazyKt.lazy(new c0());
        Object r0 = AppHost.a.getApplication().getSystemService("notification");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.NotificationManager");
        d = (NotificationManager) r0;
    }

    @Override // com.obric.miniapp.alarm.b0
    public final void c() {
        NotificationManager r0 = d;
        NotificationChannel r2 = r0.getNotificationChannel("alarm_channel");
        if (r2 != null) goto L5;
    L17:
        NotificationChannel r3 = new NotificationChannel("alarm_channel", "闹钟提醒", 4);
        r3.setDescription("闹钟提醒通知");
        r3.enableVibration(true);
        r3.enableLights(true);
        r3.setShowBadge(true);
        r0.createNotificationChannel(r3);
        return;
    L5:
        if (Intrinsics.areEqual(r2.getName(), "闹钟提醒") == false) goto L17;
        if (r2.getImportance() != 4) goto L17;
        if (Intrinsics.areEqual(r2.getDescription(), "闹钟提醒通知") == false) goto L17;
        if (r2.shouldVibrate() == false) goto L17;
        if (r2.shouldShowLights() == false) goto L17;
        if (r2.canShowBadge() == false) goto L17;
    }

    @Override // com.obric.miniapp.alarm.b0
    public final void a(a r15) {
        Intrinsics.checkNotNullParameter(r15, "alarm");
        if (Build.VERSION.SDK_INT < 26) goto L5;
        c();
    L5:
        Lazy r1 = m0.a;
        AppHost.Companion r2 = AppHost.a;
        PendingIntent r3 = m0.c(r15, r2.getApplication());
        Bitmap r4 = BitmapFactory.decodeResource(r2.getApplication().getResources(), 2131237731);     // Catch: Exception -> L8
    L10:
        String r5 = r15.c;
        if (StringsKt.isBlank(r5) == false) goto L46;
        w r6 = r15.d;
        if (w.c == false) goto L33;
        Object r7 = r6.a;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.time.Instant");
        Instant r8 = (Instant) r7;
        Instant r9 = Instant.now();
        ZoneId r10 = ZoneId.systemDefault();
        boolean r11 = w.b;
        if (r11 == false) goto L17;
        LocalDate r12 = LocalDate.ofInstant(r8, r10);
    L18:
        if (r11 == false) goto L20;
        LocalDate r13 = LocalDate.ofInstant(r9, r10);
    L21:
        int r14 = r13.until(r12).getDays();
        if (r14 == 0) goto L31;
        if (r14 == 1) goto L30;
        if (r14 == 2) goto L29;
        Map<Locale, DateTimeFormatter> r16 = t.a;
        Locale r17 = AppHost.a.getApplication().getResources().getConfiguration().getLocales().get(0);
        LinkedHashMap r18 = (LinkedHashMap) t.a;
        Object r19 = r18.get(r17);
        if (r19 != null) goto L28;
        r19 = DateTimeFormatter.ofPattern(DateTimePatternGenerator.getInstance(r17).getBestPattern("MMMd"));
        r18.put(r17, r19);
    L28:
        String r20 = ((DateTimeFormatter) r19).format(MonthDay.from(r12));
    L32:
        Intrinsics.checkNotNull(r20);
    L41:
        String r21 = r15.j.get("startTime");
        String r22 = r15.j.get("endTime");
        if (r21 == null) goto L45;
        if (r22 == null) goto L45;
        r5 = r20 + ' ' + r21 + " - " + r22;
    L45:
        r5 = r20 + ' ' + new SimpleDateFormat("HH:mm", Locale.getDefault()).format(r15.d);
        goto L46
    L29:
        Map<Locale, DateTimeFormatter> r23 = t.a;
        r20 = RelativeDateTimeFormatter.getInstance().format(RelativeDateTimeFormatter.Direction.NEXT_2, RelativeDateTimeFormatter.AbsoluteUnit.DAY);
        goto L32
    L30:
        Map<Locale, DateTimeFormatter> r24 = t.a;
        r20 = RelativeDateTimeFormatter.getInstance().format(RelativeDateTimeFormatter.Direction.NEXT, RelativeDateTimeFormatter.AbsoluteUnit.DAY);
        goto L32
    L31:
        Map<Locale, DateTimeFormatter> r25 = t.a;
        r20 = RelativeDateTimeFormatter.getInstance().format(RelativeDateTimeFormatter.Direction.THIS, RelativeDateTimeFormatter.AbsoluteUnit.DAY);
        goto L32
    L20:
        r13 = r9.atZone(r10).toLocalDate();
        goto L21
    L17:
        r12 = r8.atZone(r10).toLocalDate();
        goto L18
    L33:
        Object r26 = r6.a;
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type java.util.Date");
        Date r27 = (Date) r26;
        Calendar r28 = Calendar.getInstance();
        Calendar r29 = Calendar.getInstance();
        r29.setTime(r27);
        r28.set(11, 0);
        r28.set(12, 0);
        r28.set(13, 0);
        r28.set(14, 0);
        r29.set(11, 0);
        r29.set(12, 0);
        r29.set(13, 0);
        r29.set(14, 0);
        int r30 = (int) ((r29.getTimeInMillis() - r28.getTimeInMillis()) / ((long) 86400000));
        if (r30 == 0) goto L40;
        if (r30 == 1) goto L39;
        if (r30 == 2) goto L38;
        r20 = new SimpleDateFormat("MM月dd日", Locale.getDefault()).format(r27);
        Intrinsics.checkNotNull(r20);
        goto L41
    L38:
        r20 = "后天";
        goto L41
    L39:
        r20 = "明天";
        goto L41
    L40:
        r20 = "今天";
    L46:
        Notification r31 = new NotificationCompat.Builder(AppHost.a.getApplication(), "alarm_channel").setContentTitle(r15.b).setContentText(r5).setLargeIcon(r4).setSmallIcon(2131237731).setPriority(1).setCategory("alarm").setAutoCancel(true).setContentIntent(r3).setVibrate(new long[]{0, 500, 200, 500}).build();
        NotificationManager r32 = d;
        AlarmManager.a.getClass();
        int r33 = ((AtomicInteger) AlarmManager.f.getValue()).incrementAndGet();
        BuildersKt.launch$default(AlarmManager.b, null, null, new AlarmManager$notificationId$1$1(r33, null), 3, null);
        r32.notify("AlarmManager", r33, r31);
        Lazy r34 = AlarmTtsNotificationDispatcher.a;
        Intrinsics.checkNotNullParameter(r15, "alarm");
        AlarmTtsNotificationDispatcher.c.tryEmit(r15);
        return;
    L8:
        e = move-exception;
        FLogger.a.e("NotificationAlarmUtils", "无法解码大图标，使用应用默认图标", e);
        AppHost.Companion r35 = AppHost.a;
        r4 = BitmapFactory.decodeResource(r35.getApplication().getResources(), r35.b());
        goto L10
    }
}
