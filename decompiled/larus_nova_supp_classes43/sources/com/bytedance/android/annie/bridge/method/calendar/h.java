package com.bytedance.android.annie.bridge.method.calendar;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.bytedance.android.annie.bridge.method.abs.CreateCalendarEventResultModel;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.ec.core.utils.FontWeight;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import e7.f0;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h<V> implements Callable {
    public final /* synthetic */ f0 a;
    public final /* synthetic */ ContentResolver b;

    public h(f0 r1, ContentResolver r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.util.concurrent.Callable
    public final CreateCalendarEventResultModel.Code call() {
        int r0 = a.a;
        f0 r10 = this.a;
        ContentResolver r11 = this.b;
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "contentResolver");
        String r1 = r10.j();
        if (r1 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        Integer r13 = null;
        if (r12 == true) goto L35;
        Cursor r14 = a.b(r11, CalendarContract.Calendars.CONTENT_URI, new String[]{"_id", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME});
        Cursor r15 = r14;     // Catch: Throwable -> L29
        if (r15 != null) goto L16;
        CloseableKt.closeFinally(r14, null);
    L22:
        long r16 = -1;
    L24:
        if (r16 != (-1)) goto L80;
        TimeZone r17 = TimeZone.getDefault();
        ContentValues r18 = new ContentValues();
        r18.put(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, r1);
        r18.put("account_name", r1);
        r18.put("account_type", "LOCAL");
        r18.put("calendar_displayName", r1);
        r18.put("visible", 1);
        r18.put("calendar_color", -16776961);
        r18.put("calendar_access_level", Integer.valueOf(FontWeight.WEIGHT_700));
        r18.put("sync_events", 1);
        r18.put("calendar_timezone", r17.getID());
        r18.put("ownerAccount", r1);
        r18.put("canOrganizerRespond", 0);
        Uri r19 = a.a(r11, CalendarContract.Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", r1).appendQueryParameter("account_type", "LOCAL").build(), r18);
        if (r19 != null) goto L28;
        r16 = -1;
        goto L80
    L28:
        r16 = ContentUris.parseId(r19);
    L80:
        if (r16 == (-1)) goto L151;
        ContentValues r20 = new ContentValues();
        r20.put("calendar_id", Long.valueOf(r16));
        r20.put("eventTimezone", TimeZone.getDefault().getID());
        Long r21 = r10.i();
        if (r21 == null) goto L85;
        Long r22 = Long.valueOf(r21.longValue());
    L86:
        r20.put("dtstart", r22);
        Long r23 = r10.c();
        if (r23 == null) goto L89;
        Long r24 = Long.valueOf(r23.longValue());
    L90:
        r20.put("dtend", r24);
        r20.put("title", r10.j());
        r20.put("description", r10.e());
        r20.put("sync_data1", r10.getIdentifier());
        r20.put("allDay", r10.b());
        r20.put("eventLocation", r10.d());
        r20.put("sync_data3", r10.k());
        Integer r25 = r10.f();
        if (r25 != null) goto L93;
    L132:
        Uri r26 = a.a(r11, q.a(CalendarContract.Events.CONTENT_URI), r20);     // Catch: Exception -> L105
    L107:
        b8.a r27 = b8.a.a;
        b8.a.a(new b8.b("[CalendarCreateReducer]", LogLevel.INFO, null, "create calendar " + r16 + " insert, uri:" + r26, 4), true);
        if (r26 == null) goto L127;
        Integer r28 = r10.a();
        if (r28 == null) goto L155;
        if (r28.intValue() < 0) goto L154;
        ContentValues r29 = new ContentValues();
        String r30 = r26.getLastPathSegment();
        if (r30 == null) goto L116;
        Long r31 = Long.valueOf(CastLongProtector.parseLong(r30));
    L117:
        r29.put("event_id", r31);
        Integer r32 = r10.a();
        if (r32 == null) goto L120;
        r13 = Integer.valueOf(r32.intValue() / 60000);
    L120:
        r29.put("minutes", r13);
        r29.put("method", 1);
        if (a.a(r11, CalendarContract.Reminders.CONTENT_URI, r29) != null) goto L153;
        return CreateCalendarEventResultModel.Code.Failed;
    L153:
        return CreateCalendarEventResultModel.Code.Success;
    L116:
        r31 = null;
        goto L117
    L154:
        return CreateCalendarEventResultModel.Code.InvalidParam;
    L155:
        return CreateCalendarEventResultModel.Code.Success;
    L127:
        return CreateCalendarEventResultModel.Code.Failed;
    L105:
        e = move-exception;
        b8.a r33 = b8.a.a;
        b8.a.a(new b8.b("[CalendarCreateReducer]", LogLevel.ERROR, e, null, 8), true);
        r26 = null;
        goto L107
    L93:
        if (r25.intValue() < 1) goto L132;
        r20.put("rrule", "FREQ=" + r10.g() + ";COUNT=" + r10.f() + ";INTERVAL=" + r10.h());
        Long r34 = r10.c();
        if (r34 == null) goto L97;
        Long r35 = Long.valueOf(r34.longValue());
    L98:
        Intrinsics.checkNotNull(r35);
        long r36 = r35.longValue();
        Long r37 = r10.i();
        if (r37 == null) goto L101;
        Long r38 = Long.valueOf(r37.longValue());
    L102:
        Intrinsics.checkNotNull(r38);
        r20.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, "P" + ((r36 - r38.longValue()) / ((long) 60000)) + 'M');
        goto L132
    L101:
        r38 = null;
        goto L102
    L97:
        r35 = null;
        goto L98
    L89:
        r24 = null;
        goto L90
    L85:
        r22 = null;
        goto L86
    L151:
        return CreateCalendarEventResultModel.Code.Failed;
    L16:
        if (r15.moveToNext() == false) goto L21;
        if (Intrinsics.areEqual(r15.getString(1), r1) == false) goto L16;
        r16 = r15.getLong(0);     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r14, null);
        goto L24
    L21:
        CloseableKt.closeFinally(r14, null);
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L35:
        Cursor r39 = a.b(r11, CalendarContract.Calendars.CONTENT_URI, new String[]{"_id", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "calendar_displayName", "account_name", "account_type", "visible", "ownerAccount", "calendar_access_level"});
        if (r39 == null) goto L48;
        Cursor r40 = r39;
        List r41 = SequencesKt.toList(SequencesKt.sequence(new CalendarCreateReducer$getCalendars$1$1(r40, null)));     // Catch: Throwable -> L42
        CloseableKt.closeFinally(r40, null);
        if (r41 == null) goto L48;
    L49:
        List r42 = r41;
        Iterator r43 = r42.iterator();
    L51:
        if (r43.hasNext() == false) goto L55;
        Object r44 = r43.next();
        if (ArraysKt.contains(t.a, ((b) r44).d) == false) goto L51;
    L56:
        b r45 = (b) r44;
        if (r45 != null) goto L76;
        Iterator r46 = r42.iterator();
    L60:
        if (r46.hasNext() == false) goto L74;
        Object r47 = r46.next();
        b r48 = (b) r47;
        String r110 = r48.d;
        String[] r111 = t.a;
        if (Intrinsics.areEqual(r110, "com.smartisan.localcalendar") == false) goto L65;
        boolean r49 = Intrinsics.areEqual(r48.g, "Local");
    L72:
        if (r49 == false) goto L60;
    L75:
        r45 = (b) r47;
        goto L76
    L65:
        if (Intrinsics.areEqual(r110, "My calendar") == true) goto L67;
    L71:
        r49 = false;
        goto L72
    L67:
        if (Intrinsics.areEqual(r48.e, "My calendar") == false) goto L71;
        if (Intrinsics.areEqual(r48.g, "My calendar") == false) goto L71;
        r49 = true;
        goto L72
    L74:
        r47 = null;
    L76:
        if (r45 == null) goto L150;
        r16 = r45.a;
        goto L80
    L150:
        return CreateCalendarEventResultModel.Code.Failed;
    L55:
        r44 = null;
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        CloseableKt.closeFinally(r40, th);
        throw th;
    L48:
        r41 = CollectionsKt.emptyList();
        goto L49
    L5:
        if (r1.length() == 0) goto L8;
        r12 = false;
        goto L9
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
