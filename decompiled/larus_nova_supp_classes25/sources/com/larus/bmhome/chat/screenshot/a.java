package com.larus.bmhome.chat.screenshot;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import f06.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final String[] a = null;
    public static final String[] b = null;

    static {
        a = new String[]{"_id", "_display_name", "date_modified", "date_added", "mime_type", "_size", "width", "height", "relative_path", "_data"};
        b = new String[]{"_id", "_display_name", "date_modified", "date_added", "mime_type", "_size", "width", "height", "_data"};
    }

    public static Bundle c() {
        Bundle r0 = new Bundle();
        if (Build.VERSION.SDK_INT < 29) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0.putString("android:query-arg-sql-selection", null);
        r0.putStringArray("android:query-arg-sql-selection-args", null);
        r0.putString("android:query-arg-sql-sort-order", "_id DESC");
    L8:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public static Cursor a(ContentResolver r15, Uri r16, String[] r17, Bundle r18) {
        f06.c r11 = new f06.c();
        Object[] r12 = {r16, r17, r18, null};
        f06.b r14 = new f06.b();
        d r9 = r11.b(240004, "android/content/ContentResolver", "query", r15, r12, "android.database.Cursor", r14);
        if (r9.a == false) goto L6;
        r11.a(240004, "android/content/ContentResolver", "query", r15, r12, null, r14, false);
        return (Cursor) r9.b;
    L6:
        Cursor r10 = r15.query(r16, r17, r18, null);
        r11.a(240004, "android/content/ContentResolver", "query", r15, r12, r10, r14, true);
        return r10;
    }

    public static Cursor b(ContentResolver r12, Uri r13, String[] r14, String r15) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, null, null, r15};
        f06.b r10 = new f06.b();
        d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r16 = r12.query(r13, r14, null, null, r15);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r16, r10, true);
        return r16;
    }
}
