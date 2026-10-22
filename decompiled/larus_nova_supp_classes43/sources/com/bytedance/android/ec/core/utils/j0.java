package com.bytedance.android.ec.core.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.provider.MediaStore;
import com.byted.cast.sink.api.IServerListener;
import java.util.Iterator;
import java.util.Locale;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j0 extends ContentObserver {
    public Context a;
    public int b;

    public static final class a {
    }

    static {
    }

    public j0() {
        super(null);
    }

    public static boolean b(String r10) {
        Locale r0 = Locale.ROOT;
        if (r10 == null) goto L13;
        String r11 = r10.toLowerCase(r0);
        i0.f.getClass();
        String[] r1 = i0.d;
        int r12 = r1.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L11;
        if (StringsKt.contains$default(r11, r1[r13], false, 2, null) == true) goto L8;
        r13 = r13 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r10) {
        super.onChange(r10);
        Context r11 = this.a;
        if (r11 == null) goto L50;
        String[] r12 = {"date_added", "_data"};
        Cursor r13 = null;
        r13 = a(r11.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r12);     // Catch: Throwable -> L31 SQLException -> L35
        if (r13 == null) goto L51;
        int r14 = r13.getCount();     // Catch: Throwable -> L31 SQLException -> L35
        int r15 = this.b;     // Catch: Throwable -> L31 SQLException -> L35
        if (r15 != 0) goto L11;
        this.b = r14;     // Catch: Throwable -> L31 SQLException -> L35
    L13:
        this.b = r14;     // Catch: Throwable -> L31 SQLException -> L35
        if (r13.moveToFirst() == false) goto L42;
        String r16 = r13.getString(r13.getColumnIndex("_data"));     // Catch: Throwable -> L31 SQLException -> L35
        long r0 = r13.getLong(r13.getColumnIndex("date_added"));     // Catch: Throwable -> L31 SQLException -> L35
        long r17 = System.currentTimeMillis() - (r0 * ((long) IServerListener.WHAT_BYTELINK_SINK_ERROR));     // Catch: Throwable -> L31 SQLException -> L35
        if (r17 < 7000) goto L18;
    L20:
        boolean r1 = false;
    L21:
        if (r1 == false) goto L42;
        if (b(r16) == false) goto L42;
        Iterator<T> r18 = i0.b.values().iterator();     // Catch: Throwable -> L31 SQLException -> L35
    L25:
        if (r18.hasNext() == false) goto L42;
        b1 r19 = (b1) r18.next();     // Catch: Throwable -> L31 SQLException -> L35
        if (r19 == null) goto L25;
        r19.a(r16);     // Catch: Throwable -> L31 SQLException -> L35
        goto L25
    L18:
        if (r17 <= 0) goto L20;
        r1 = true;
    L42:
        r13.close();     // Catch: SQLException -> L39
        return;
    L53:
        return;
    L11:
        if (r15 < r14) goto L13;
    L51:
        return;
    L35:
        if (r13 != null) goto L42;
        return;
    L31:
        th = move-exception;
        if (r13 != null) goto L40;
    L34:
        throw th;
    L40:
        r13.close();     // Catch: SQLException -> L38
        goto L34
    }

    public static Cursor a(ContentResolver r17, Uri r18, String[] r19) {
        f06.c r14 = new f06.c();
        Object[] r15 = {r18, r19, null, null, "date_modified desc "};
        f06.b r16 = new f06.b();
        f06.d r0 = r14.b(240004, "android/content/ContentResolver", "query", r17, r15, "android.database.Cursor", r16);
        if (r0.a == false) goto L6;
        r14.a(240004, "android/content/ContentResolver", "query", r17, r15, null, r16, false);
        return (Cursor) r0.b;
    L6:
        Cursor r1 = r17.query(r18, r19, null, null, "date_modified desc ");
        r14.a(240004, "android/content/ContentResolver", "query", r17, r15, r1, r16, true);
        return r1;
    }
}
