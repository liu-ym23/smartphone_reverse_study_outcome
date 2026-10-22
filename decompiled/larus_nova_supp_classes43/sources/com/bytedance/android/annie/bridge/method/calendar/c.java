package com.bytedance.android.annie.bridge.method.calendar;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Integer b(long r10, ContentResolver r11) {
        Cursor r12 = a(r11, CalendarContract.Reminders.CONTENT_URI, new String[]{"minutes"}, "event_id=?", new String[]{String.valueOf(r10)});
        if (r12 == null) goto L17;
        Cursor r13 = r12;
        Cursor r0 = r13;     // Catch: Throwable -> L12
        if (r0.moveToNext() == false) goto L9;
        Integer r14 = Integer.valueOf(r0.getInt(0));     // Catch: Throwable -> L12
    L10:
        CloseableKt.closeFinally(r13, null);
        return r14;
    L9:
        r14 = null;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    L17:
        return null;
    }

    public static Cursor a(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17) {
        f06.c r10 = new f06.c();
        Object[] r11 = {r14, r15, r16, r17, null};
        f06.b r12 = new f06.b();
        f06.d r18 = r10.b(240004, "android/content/ContentResolver", "query", r13, r11, "android.database.Cursor", r12);
        if (r18.a == false) goto L6;
        r10.a(240004, "android/content/ContentResolver", "query", r13, r11, null, r12, false);
        return (Cursor) r18.b;
    L6:
        Cursor r19 = r13.query(r14, r15, r16, r17, null);
        r10.a(240004, "android/content/ContentResolver", "query", r13, r11, r19, r12, true);
        return r19;
    }
}
