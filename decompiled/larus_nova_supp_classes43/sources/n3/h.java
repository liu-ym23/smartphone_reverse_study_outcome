package n3;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.bytedance.ai.bridge.calendar.AbsGetCalendarObjectsMethodIDL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public static String b(Cursor r1, int r10) {
        if (r1.isNull(r10) == false) goto L6;
        return null;
    L6:
        return r1.getString(r10);
    }

    public static List c(Context r10, long r11) {
        ArrayList r0 = new ArrayList();
        String[] r12 = {String.valueOf(r11)};
        Cursor r13 = a(r10.getContentResolver(), CalendarContract.Reminders.CONTENT_URI, new String[]{"minutes", "method"}, "event_id = ?", r12, null);
        if (r13 == null) goto L16;
        Cursor r14 = r13;
        Cursor r15 = r14;     // Catch: Throwable -> L11
    L7:
        if (r15.moveToNext() == false) goto L9;
        r0.add(new i.c(r15.getInt(0), r15.getInt(1)));     // Catch: Throwable -> L11
        goto L7
    L9:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r14, null);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L16:
        return r0;
    }

    public static i.b e(Cursor r39, Context r40) {
        long r10 = r39.getLong(r39.getColumnIndexOrThrow("_id"));
        String r11 = r39.getString(r39.getColumnIndexOrThrow("title"));
        String r13 = b(r39, r39.getColumnIndexOrThrow("rrule"));
        long r12 = r39.getLong(r39.getColumnIndexOrThrow("dtstart"));
        long r14 = r39.getLong(r39.getColumnIndexOrThrow("dtend"));
        int r15 = r39.getInt(r39.getColumnIndexOrThrow("eventStatus"));
        String r16 = "_id";
        long r1 = r39.getLong(r39.getColumnIndexOrThrow("original_id"));
        String r17 = "eventStatus";
        String r18 = "originalInstanceTime";
        String r19 = "dtend";
        long r20 = r39.getLong(r39.getColumnIndexOrThrow("originalInstanceTime"));
        com.bytedance.ai.utils.g.a.d("LocalCalendarAdapter", r11 + " eventId: " + r10 + ", rrule: " + r13 + ", start: " + r12 + ", end: " + r14 + ", status: " + r15 + ", originalID: " + r1 + ", originalTime: " + r20);
        if (r13 != null) goto L5;
    L8:
        boolean r21 = true;
    L10:
        if (r21 == true) goto L32;
        ArrayList r22 = new ArrayList();
        Cursor r110 = a(r40.getContentResolver(), CalendarContract.Events.CONTENT_URI, new String[]{"_id", "originalInstanceTime", "title", "description", "dtstart", "dtend", com.bytedance.android.ec.core.event.a.KEY_DURATION, "eventStatus", "eventLocation", "eventTimezone", "allDay"}, "original_id=?", new String[]{String.valueOf(r10)}, null);
        if (r110 == null) goto L30;
        Cursor r111 = r110;
        Cursor r112 = r111;     // Catch: Throwable -> L24
    L16:
        if (r112.moveToNext() == false) goto L22;
        String r0 = r16;
        long r23 = r112.getLong(r112.getColumnIndexOrThrow(r0));     // Catch: Throwable -> L24
        String r24 = r13;
        long r25 = r112.getLong(r112.getColumnIndexOrThrow(r18));     // Catch: Throwable -> L24
        String r26 = r112.getString(r112.getColumnIndexOrThrow("title"));     // Catch: Throwable -> L24
        String r27 = b(r112, r112.getColumnIndexOrThrow("description"));     // Catch: Throwable -> L24
        String r28 = b(r112, r112.getColumnIndexOrThrow("eventLocation"));     // Catch: Throwable -> L24
        long r30 = r112.getLong(r112.getColumnIndexOrThrow("dtstart"));     // Catch: Throwable -> L24
        String r113 = r19;
        String r114 = r18;
        long r32 = r112.getLong(r112.getColumnIndexOrThrow(r113));     // Catch: Throwable -> L24
        long r37 = r10;
        if (r112.getInt(r112.getColumnIndexOrThrow("allDay")) != 1) goto L20;
        boolean r29 = true;
    L21:
        String r31 = r17;
        r22.add(new i.a(r25, r26, r27, r28, r112.getString(r112.getColumnIndexOrThrow("eventTimezone")), r29, r30, r32, r112.getInt(r112.getColumnIndexOrThrow(r31)), b(r112, r112.getColumnIndexOrThrow(com.bytedance.android.ec.core.event.a.KEY_DURATION)), c(r40, r23)));     // Catch: Throwable -> L24
        r17 = r31;
        r18 = r114;
        r16 = r0;
        r10 = r37;
        r19 = r113;
        r13 = r24;
        goto L16
    L20:
        r29 = false;
        goto L21
    L22:
        long r38 = r10;
        String r210 = r13;
        String r115 = r19;
        Unit r33 = Unit.INSTANCE;     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r111, null);
    L31:
        List r211 = r22;
    L33:
        String r34 = r39.getString(r39.getColumnIndexOrThrow("title"));
        String r35 = b(r39, r39.getColumnIndexOrThrow("description"));
        String r36 = b(r39, r39.getColumnIndexOrThrow("eventLocation"));
        long r116 = r39.getLong(r39.getColumnIndexOrThrow("dtstart"));
        long r117 = r39.getLong(r39.getColumnIndexOrThrow(r115));
        if (r39.getInt(r39.getColumnIndexOrThrow("allDay")) != 1) goto L36;
        boolean r118 = true;
    L37:
        long r41 = r38;
        return new i.b(r41, r34, r35, r116, r117, r36, r39.getString(r39.getColumnIndexOrThrow("eventTimezone")), c(r40, r41), r118, r210, b(r39, r39.getColumnIndexOrThrow("rdate")), b(r39, r39.getColumnIndexOrThrow(com.bytedance.android.ec.core.event.a.KEY_DURATION)), r211);
    L36:
        r118 = false;
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r111, th);
        throw th;
    L30:
        r38 = r10;
        r210 = r13;
        r115 = r19;
        goto L31
    L32:
        r38 = r10;
        r210 = r13;
        r115 = r19;
        r40 = r40;
        r211 = CollectionsKt.emptyList();
        goto L33
    L5:
        if (r13.length() == 0) goto L8;
        r21 = false;
        goto L10
    }

    public static ArrayList d(Context r39, Long r40, Long r41) {
        Intrinsics.checkNotNullParameter(r39, "context");
        ArrayList r1 = new ArrayList();
        ArrayList r10 = new ArrayList();
        Uri r11 = CalendarContract.Events.CONTENT_URI;
        String[] r12 = {"_id", "title", "description", "dtstart", "dtend", com.bytedance.android.ec.core.event.a.KEY_DURATION, "eventLocation", "eventTimezone", "allDay", "rrule", "rdate", com.bytedance.android.ec.core.event.a.KEY_DURATION, "eventStatus", "originalInstanceTime", "original_id"};
        StringBuilder r13 = new StringBuilder("(original_id IS NULL)");
        if (r40 == null) goto L6;
        if (r41 == null) goto L6;
        r13.append(" AND ((dtstart >= ? AND dtend <= ?) OR (dtstart >= ? AND rrule IS NOT NULL))");
        String[] r14 = {r40.toString(), r41.toString(), r40.toString()};
    L10:
        String[] r15 = r14;
    L12:
        Cursor r16 = a(r39.getContentResolver(), r11, r12, r13.toString(), r15, "dtstart ASC");
        if (r16 == null) goto L27;
        Cursor r17 = r16;
        Cursor r18 = r17;     // Catch: Throwable -> L21
    L17:
        if (r18.moveToNext() == false) goto L19;
        r10.add(e(r18, r39));     // Catch: Throwable -> L21
        goto L17
    L19:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r17, null);
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);
        throw th;
    L27:
        Iterator r19 = r10.iterator();
    L29:
        if (r19.hasNext() == false) goto L163;
        i.b r20 = (i.b) r19.next();
        SimpleDateFormat r21 = i.a;
        Intrinsics.checkNotNullParameter(r20, "event");
        StringBuilder r22 = new StringBuilder("BEGIN:VCALENDAR\r\nVERSION:2.0\r\nPRODID:-//Android Calendar Export//EN\r\nBEGIN:VEVENT\r\n");
        String r23 = "UID:";
        StringBuilder r24 = new StringBuilder("UID:");
        r24.append(r20.a);
        String r25 = "@android.local\r\n";
        r24.append("@android.local\r\n");
        r22.append(r24.toString());
        r22.append("DTSTAMP:" + i.a.format(new Date()) + "\r\n");
        long r110 = i.b(r20.i, r20.d, r20.e, r20.l);
        String r111 = "DTEND";
        String r26 = "DTSTART";
        if (r20.i == false) goto L33;
        SimpleDateFormat r27 = i.b;
        String r28 = r27.format(new Date(r20.d));
        String r29 = r27.format(new Date(r110));
        r22.append("DTSTART;VALUE=DATE:" + r28 + "\r\n");
        r22.append("DTEND;VALUE=DATE:" + r29 + "\r\n");
    L34:
        String r30 = "SUMMARY:";
        r22.append("SUMMARY:" + i.a(r20.b) + "\r\n");
        String r31 = r20.c;
        if (r31 != null) goto L37;
    L40:
        boolean r32 = true;
    L41:
        String r33 = "DESCRIPTION:";
        if (r32 == true) goto L44;
        r22.append("DESCRIPTION:" + i.a(r20.c) + "\r\n");
    L44:
        String r34 = r20.f;
        if (r34 != null) goto L47;
    L50:
        boolean r35 = true;
    L51:
        String r112 = "LOCATION:";
        if (r35 == true) goto L54;
        r22.append("LOCATION:" + i.a(r20.f) + "\r\n");
    L54:
        String r36 = r20.l;
        if (r36 != null) goto L57;
    L60:
        boolean r37 = true;
    L61:
        String r113 = "DURATION:";
        if (r37 == true) goto L64;
        r22.append("DURATION:" + i.a(r20.l) + "\r\n");
    L64:
        String r38 = r20.j;
        if (r38 != null) goto L67;
    L70:
        boolean r42 = true;
    L71:
        if (r42 == true) goto L73;
        r22.append("RRULE:" + r20.j + "\r\n");
    L73:
        String r43 = r20.k;
        if (r43 != null) goto L76;
    L79:
        boolean r44 = true;
    L80:
        if (r44 == true) goto L82;
        r22.append("RDATE" + r20.k + "\r\n");
    L82:
        List<i.a> r45 = r20.m;
        ArrayList r114 = new ArrayList();
        Iterator r46 = r45.iterator();
    L84:
        if (r46.hasNext() == false) goto L92;
        ArrayList r115 = r1;
        Object r47 = r46.next();
        Iterator r116 = r46;
        String r210 = r112;
        if (((i.a) r47).i != 2) goto L88;
        boolean r48 = true;
    L89:
        if (r48 == false) goto L91;
        r114.add(r47);
    L91:
        r1 = r115;
        r46 = r116;
        r112 = r210;
        goto L84
    L88:
        r48 = false;
        goto L89
    L92:
        ArrayList r117 = r1;
        String r211 = r112;
        Iterator r49 = r114.iterator();
    L94:
        if (r49.hasNext() == false) goto L96;
        r22.append("EXDATE:" + i.a.format(new Date(((i.a) r49.next()).a)) + "\r\n");
        r49 = r49;
        r26 = r26;
        r33 = r33;
        goto L94
    L96:
        String r212 = r26;
        String r213 = r33;
        Iterator r50 = r20.h.iterator();
    L97:
        String r51 = "END:VALARM\r\n";
        String r52 = "M\r\n";
        String r118 = r113;
        if (r50.hasNext() == false) goto L107;
        i.c r53 = (i.c) r50.next();
        Iterator r214 = r50;
        int r54 = r53.b;
        String r215 = r111;
        if (r54 != 2) goto L102;
        String r55 = "EMAIL";
    L106:
        r22.append("BEGIN:VALARM\r\n");
        r22.append("ACTION:" + r55 + "\r\n");
        r22.append("DESCRIPTION:Reminder\r\n");
        r22.append("TRIGGER:-PT" + Math.abs(r53.a) + "M\r\n");
        r22.append("END:VALARM\r\n");
        r113 = r118;
        r50 = r214;
        r111 = r215;
        goto L97
    L102:
        if (r54 == 3) goto L104;
        r55 = "DISPLAY";
        goto L106
    L104:
        r55 = "SMS";
        goto L106
    L107:
        String r216 = r111;
        String r56 = "END:VEVENT\r\n";
        r22.append("END:VEVENT\r\n");
        if ((!r20.m.isEmpty()) == false) goto L162;
        Iterator r57 = r20.m.iterator();
    L111:
        if (r57.hasNext() == false) goto L162;
        i.a r119 = (i.a) r57.next();
        SimpleDateFormat r217 = i.a;
        Iterator r218 = r57;
        String r219 = r56;
        if (r119.i == 2) goto L160;
        r22.append("BEGIN:VEVENT\r\n");
        StringBuilder r58 = new StringBuilder(r23);
        String r59 = r51;
        String r220 = r52;
        r58.append(r20.a);
        r58.append(r25);
        r22.append(r58.toString());
        r22.append("RECURRENCE-ID" + i.d(r119.a, r20.g) + "\r\n");
        r22.append(r30 + i.a(r119.b) + "\r\n");
        long r60 = i.b(r119.f, r119.g, r119.h, r119.j);
        if (r119.f == false) goto L117;
        SimpleDateFormat r61 = i.b;
        String r62 = r61.format(new Date(r119.g));
        String r63 = r61.format(new Date(r60));
        r22.append("DTSTART;VALUE=DATE:" + r62 + "\r\n");
        r22.append("DTEND;VALUE=DATE:" + r63 + "\r\n");
        String r64 = r216;
    L118:
        String r65 = r119.j;
        if (r65 != null) goto L121;
    L124:
        boolean r66 = true;
    L125:
        if (r66 == true) goto L127;
        String r67 = r118;
        r22.append(r67 + r119.j + "\r\n");
    L128:
        String r68 = r119.c;
        if (r68 != null) goto L131;
    L134:
        boolean r69 = true;
    L135:
        if (r69 == true) goto L137;
        String r70 = r213;
        r22.append(r70 + i.a(r119.c) + "\r\n");
    L138:
        String r71 = r119.d;
        if (r71 != null) goto L141;
    L144:
        boolean r72 = true;
    L145:
        if (r72 == true) goto L147;
        String r73 = r211;
        r22.append(r73 + i.a(r119.d) + "\r\n");
    L148:
        Iterator r74 = r119.k.iterator();
    L150:
        if (r74.hasNext() == false) goto L159;
        i.c r75 = (i.c) r74.next();
        r22.append("BEGIN:VALARM\r\n");
        int r120 = r75.b;
        Iterator r121 = r74;
        if (r120 != 2) goto L154;
        String r122 = "EMAIL";
    L158:
        r22.append("ACTION:" + r122 + "\r\n");
        r22.append("TRIGGER:-PT" + Math.abs(r75.a) + r220);
        r22.append(r59);
        r74 = r121;
        goto L150
    L154:
        if (r120 == 3) goto L156;
        r122 = "DISPLAY";
        goto L158
    L156:
        r122 = "SMS";
        goto L158
    L159:
        r56 = r219;
        r52 = r220;
        r22.append(r56);
    L161:
        r118 = r67;
        r213 = r70;
        r216 = r64;
        r211 = r73;
        r23 = r23;
        r30 = r30;
        r25 = r25;
        r51 = r59;
        r57 = r218;
        goto L111
    L147:
        r73 = r211;
        goto L148
    L141:
        if (StringsKt.isBlank(r71) == true) goto L144;
        r72 = false;
        goto L145
    L137:
        r70 = r213;
        goto L138
    L131:
        if (StringsKt.isBlank(r68) == true) goto L134;
        r69 = false;
        goto L135
    L127:
        r67 = r118;
        goto L128
    L121:
        if (StringsKt.isBlank(r65) == true) goto L124;
        r66 = false;
        goto L125
    L117:
        r22.append(r212 + i.d(r119.g, r20.g) + "\r\n");
        r64 = r216;
        r22.append(r64 + i.d(r60, r20.g) + "\r\n");
        goto L118
    L160:
        r59 = r51;
        r67 = r118;
        r73 = r211;
        r70 = r213;
        r64 = r216;
        r56 = r219;
    L162:
        r22.append("END:VCALENDAR\r\n");
        String r76 = r22.toString();
        r1 = r117;
        r1.add(new AbsGetCalendarObjectsMethodIDL.CalendarEvent(String.valueOf(r20.a), "local://event/" + r20.a, r76, null, 8, null));
        r19 = r19;
        goto L29
    L76:
        if (StringsKt.isBlank(r43) == true) goto L79;
        r44 = false;
        goto L80
    L67:
        if (StringsKt.isBlank(r38) == true) goto L70;
        r42 = false;
        goto L71
    L57:
        if (StringsKt.isBlank(r36) == true) goto L60;
        r37 = false;
        goto L61
    L47:
        if (StringsKt.isBlank(r34) == true) goto L50;
        r35 = false;
        goto L51
    L37:
        if (StringsKt.isBlank(r31) == true) goto L40;
        r32 = false;
        goto L41
    L33:
        r22.append("DTSTART" + i.d(r20.d, r20.g) + "\r\n");
        r22.append("DTEND" + i.d(r110, r20.g) + "\r\n");
        goto L34
    L163:
        return r1;
    L6:
        if (r40 == null) goto L8;
        r13.append(" AND ((dtstart >= ?))");
        r14 = new String[]{r40.toString()};
        goto L10
    L8:
        if (r41 == null) goto L11;
        r13.append(" AND ((dtstart >= ? AND dtend <= ?) OR (dtstart >= ? AND rrule IS NOT NULL))");
        r14 = new String[]{r41.toString(), r41.toString(), r41.toString()};
        goto L10
    L11:
        r15 = null;
        goto L12
    }

    public static Cursor a(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17, String r18) {
        f06.c r10 = new f06.c();
        Object[] r11 = {r14, r15, r16, r17, r18};
        f06.b r12 = new f06.b();
        f06.d r19 = r10.b(240004, "android/content/ContentResolver", "query", r13, r11, "android.database.Cursor", r12);
        if (r19.a == false) goto L6;
        r10.a(240004, "android/content/ContentResolver", "query", r13, r11, null, r12, false);
        return (Cursor) r19.b;
    L6:
        Cursor r110 = r13.query(r14, r15, r16, r17, r18);
        r10.a(240004, "android/content/ContentResolver", "query", r13, r11, r110, r12, true);
        return r110;
    }
}
