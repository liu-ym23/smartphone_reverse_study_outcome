package com.obric.miniapp.calendar.compatibility;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final EventEntity b(EventEntity r7, Context r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "context");
        if (r8.getPackageManager().checkPermission("android.permission.READ_CALENDAR", r8.getPackageName()) == 0) goto L5;
        return r7;
    L5:
        Long r0 = r7.a;
        EventEntity r1 = null;
        if (r0 == null) goto L25;
        Cursor r2 = a(r8.getContentResolver(), ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, r0.longValue()), EventEntity.w0, null, null);
        if (r2 == null) goto L21;
        Cursor r3 = r2;
        Cursor r4 = r3;     // Catch: Throwable -> L16
        if (r4.moveToFirst() == false) goto L14;
        EventEntity r5 = EventEntity.a.a(r4);     // Catch: Throwable -> L16
    L15:
        CloseableKt.closeFinally(r3, null);
    L22:
        if (r5 == null) goto L25;
        return r5;
    L14:
        r5 = null;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L21:
        r5 = null;
    L25:
        Long r6 = r7.c;
        if (r6 == null) goto L41;
        Cursor r9 = a(r8.getContentResolver(), CalendarContract.Events.CONTENT_URI, EventEntity.w0, "_sync_id = ?", new String[]{String.valueOf(r6.longValue())});
        if (r9 == null) goto L41;
        Cursor r10 = r9;
        Cursor r11 = r10;     // Catch: Throwable -> L36
        if (r11.moveToFirst() == false) goto L34;
        EventEntity r12 = EventEntity.a.a(r11);     // Catch: Throwable -> L36
    L35:
        CloseableKt.closeFinally(r10, null);
        r1 = r12;
        goto L41
    L34:
        r12 = null;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L41:
        if (r1 != null) goto L44;
        return r7;
    L44:
        return r1;
    }

    public static Cursor a(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r14, r15, r16, r17, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, null);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }
}
