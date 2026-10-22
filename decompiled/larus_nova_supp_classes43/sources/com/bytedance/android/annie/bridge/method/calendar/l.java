package com.bytedance.android.annie.bridge.method.calendar;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.provider.CalendarContract;
import com.bytedance.android.annie.bridge.method.abs.CreateCalendarEventResultModel;
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
public final class l<V> implements Callable {
    public final /* synthetic */ f0 a;
    public final /* synthetic */ ContentResolver b;

    public l(f0 r1, ContentResolver r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.util.concurrent.Callable
    public final CreateCalendarEventResultModel.Code call() {
        int r0 = e.a;
        f0 r1 = this.a;
        ContentResolver r10 = this.b;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r10, "contentResolver");
        Long r11 = null;
        Cursor r12 = e.a(r10, CalendarContract.Calendars.CONTENT_URI, new String[]{"_id", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "calendar_displayName", "account_name", "account_type", "visible", "ownerAccount"}, null, null);
        if (r12 == null) goto L14;
        Cursor r13 = r12;
        List r14 = SequencesKt.toList(SequencesKt.sequence(new CalendarUpdateReducer$getCalendars$1$1(r13, null)));     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r13, null);
        if (r14 == null) goto L14;
    L15:
        List r15 = r14;
        Iterator r16 = r15.iterator();
    L17:
        if (r16.hasNext() == false) goto L21;
        Object r17 = r16.next();
        if (ArraysKt.contains(t.a, ((b) r17).d) == false) goto L17;
    L22:
        b r18 = (b) r17;
        if (r18 != null) goto L42;
        Iterator r19 = r15.iterator();
    L26:
        if (r19.hasNext() == false) goto L40;
        Object r20 = r19.next();
        b r21 = (b) r20;
        String r22 = r21.d;
        String[] r23 = t.a;
        if (Intrinsics.areEqual(r22, "com.smartisan.localcalendar") == false) goto L31;
        boolean r24 = Intrinsics.areEqual(r21.g, "Local");
    L38:
        if (r24 == false) goto L26;
    L41:
        r18 = (b) r20;
        goto L42
    L31:
        if (Intrinsics.areEqual(r22, "My calendar") == true) goto L33;
    L37:
        r24 = false;
        goto L38
    L33:
        if (Intrinsics.areEqual(r21.e, "My calendar") == false) goto L37;
        if (Intrinsics.areEqual(r21.g, "My calendar") == false) goto L37;
        r24 = true;
        goto L38
    L40:
        r20 = null;
    L42:
        if (r18 == null) goto L132;
        ContentValues r25 = new ContentValues();
        r25.put("calendar_id", Long.valueOf(r18.a));
        r25.put("eventTimezone", TimeZone.getDefault().getID());
        Long r26 = r1.i();
        if (r26 == null) goto L47;
        r25.put("dtstart", Long.valueOf(r26.longValue()));
    L47:
        Long r27 = r1.c();
        if (r27 == null) goto L50;
        r25.put("dtend", Long.valueOf(r27.longValue()));
    L50:
        String r28 = r1.j();
        String r29 = "";
        if (r28 != null) goto L53;
        r28 = "";
    L53:
        r25.put("title", r28);
        String r30 = r1.e();
        if (r30 != null) goto L56;
        r30 = "";
    L56:
        r25.put("description", r30);
        String r31 = r1.getIdentifier();
        if (r31 != null) goto L59;
        r31 = "";
    L59:
        r25.put("sync_data1", r31);
        Boolean r32 = r1.b();
        if (r32 == null) goto L62;
        boolean r33 = r32.booleanValue();
    L63:
        r25.put("allDay", Boolean.valueOf(r33));
        String r34 = r1.d();
        if (r34 != null) goto L66;
        r34 = "";
    L66:
        r25.put("eventLocation", r34);
        String r35 = r1.k();
        if (r35 == null) goto L70;
        r29 = r35;
    L70:
        r25.put("sync_data3", r29);
        if (r1.f() == null) goto L80;
        if (r1.h() == null) goto L80;
        Integer r36 = r1.f();
        Intrinsics.checkNotNull(r36);
        if (r36.intValue() < 1) goto L80;
        Integer r37 = r1.h();
        Intrinsics.checkNotNull(r37);
        if (r37.intValue() < 1) goto L80;
        Long r38 = r1.c();
        Intrinsics.checkNotNull(r38);
        long r39 = r38.longValue();
        Long r40 = r1.i();
        Intrinsics.checkNotNull(r40);
        r25.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, "P" + ((r39 - r40.longValue()) / ((long) 60000)) + 'M');
        r25.put("rrule", "FREQ=" + r1.g() + ";COUNT=" + r1.f() + ";INTERVAL=" + r1.h());
    L80:
        if (e.b(r10, q.a(CalendarContract.Events.CONTENT_URI), r25, "sync_data1=?", new String[]{r1.getIdentifier()}) <= 0) goto L114;
        Integer r41 = r1.a();
        if (r41 == null) goto L137;
        if (r41.intValue() < 0) goto L136;
        Cursor r42 = e.a(r10, CalendarContract.Events.CONTENT_URI, new String[]{"_id"}, "sync_data1=?", new String[]{r1.getIdentifier()});
        Cursor r43 = r42;     // Catch: Throwable -> L106
        if (r43 != null) goto L89;
    L91:
        boolean r44 = false;
    L92:
        if (r44 == false) goto L95;
        long r45 = r43.getLong(0);     // Catch: Throwable -> L106
    L96:
        CloseableKt.closeFinally(r42, null);
        if (r45 < 0) goto L133;
        ContentValues r46 = new ContentValues();
        r46.put("event_id", Long.valueOf(r45));
        Integer r47 = r1.a();
        if (r47 == null) goto L102;
        r11 = Long.valueOf(((long) r47.intValue()) / ((long) 60000));
    L102:
        r46.put("minutes", r11);
        r46.put("method", 1);
        if (e.b(r10, CalendarContract.Reminders.CONTENT_URI, r46, "event_id=?", new String[]{String.valueOf(r45)}) <= 0) goto L135;
        return CreateCalendarEventResultModel.Code.Success;
    L135:
        return CreateCalendarEventResultModel.Code.Failed;
    L133:
        return CreateCalendarEventResultModel.Code.Failed;
    L95:
        r45 = -1;
        goto L96
    L89:
        if (r43.moveToNext() != true) goto L91;
        r44 = true;
    L106:
        th = move-exception;
        throw th;     // Catch: Throwable -> L108
    L108:
        th = move-exception;
        CloseableKt.closeFinally(r42, th);
        throw th;
    L136:
        return CreateCalendarEventResultModel.Code.InvalidParam;
    L137:
        return CreateCalendarEventResultModel.Code.Success;
    L114:
        return CreateCalendarEventResultModel.Code.Failed;
    L62:
        r33 = false;
        goto L63
    L132:
        return CreateCalendarEventResultModel.Code.Failed;
    L21:
        r17 = null;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    L14:
        r14 = CollectionsKt.emptyList();
        goto L15
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
