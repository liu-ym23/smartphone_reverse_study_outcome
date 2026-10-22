package com.bytedance.android.live.browser.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.provider.MediaStore;
import com.bytedance.android.live.core.log.ALogger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Locale;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l extends ContentObserver {
    public WeakReference<Context> a;
    public int b;

    public l() {
        super(null);
    }

    public static boolean b(String r7) {
        Locale r0 = Locale.ROOT;
        if (r7 == null) goto L13;
        String r8 = r7.toLowerCase(r0);
        String[] r1 = k.c;
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        if (StringsKt.contains$default(r8, r1[r3], false, 2, null) == true) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r6) {
        super.onChange(r6);
        WeakReference<Context> r7 = this.a;
        if (r7 == null) goto L36;
        Context r8 = r7.get();
        if (r8 == null) goto L50;
        Cursor r3 = null;
        r3 = a(r8.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"date_added", "_data"});     // Catch: Throwable -> L26 SQLException -> L28
        if (r3 == null) goto L51;
        int r9 = r3.getCount();     // Catch: Throwable -> L26 SQLException -> L28
        int r2 = this.b;     // Catch: Throwable -> L26 SQLException -> L28
        if (r2 != 0) goto L13;
        this.b = r9;     // Catch: Throwable -> L26 SQLException -> L28
    L15:
        this.b = r9;     // Catch: Throwable -> L26 SQLException -> L28
        if (r3.moveToFirst() == false) goto L41;
        String r11 = r3.getString(r3.getColumnIndex("_data"));     // Catch: Throwable -> L26 SQLException -> L28
        r3.getLong(r3.getColumnIndex("date_added"));     // Catch: Throwable -> L26 SQLException -> L28
        if (b(r11) == false) goto L41;
        Iterator<T> r0 = k.b.values().iterator();     // Catch: Throwable -> L26 SQLException -> L28
    L20:
        if (r0.hasNext() == false) goto L41;
        i r1 = (i) r0.next();     // Catch: Throwable -> L26 SQLException -> L28
        if (r1 == null) goto L20;
        r1.a(r11);     // Catch: Throwable -> L26 SQLException -> L28
        goto L20
    L41:
        r3.close();     // Catch: SQLException -> L38
        return;
    L54:
        return;
    L13:
        if (r2 < r9) goto L15;
    L51:
        return;
    L28:
        e = move-exception;
        ALogger.e("ScreenShotHelper", "handleContentObserverChange Error" + e.getMessage());     // Catch: Throwable -> L26
        if (r3 != null) goto L41;
        return;
    L26:
        th = move-exception;
        if (r3 != null) goto L39;
    L35:
        throw th;
    L39:
        r3.close();     // Catch: SQLException -> L37
        goto L35
    L50:
        return;
    }

    public static Cursor a(ContentResolver r17, Uri r18, String[] r19) {
        f06.c r14 = new f06.c();
        Object[] r15 = {r18, r19, null, null, "date_modified desc"};
        f06.b r16 = new f06.b();
        f06.d r0 = r14.b(240004, "android/content/ContentResolver", "query", r17, r15, "android.database.Cursor", r16);
        if (r0.a == false) goto L6;
        r14.a(240004, "android/content/ContentResolver", "query", r17, r15, null, r16, false);
        return (Cursor) r0.b;
    L6:
        Cursor r1 = r17.query(r18, r19, null, null, "date_modified desc");
        r14.a(240004, "android/content/ContentResolver", "query", r17, r15, r1, r16, true);
        return r1;
    }
}
