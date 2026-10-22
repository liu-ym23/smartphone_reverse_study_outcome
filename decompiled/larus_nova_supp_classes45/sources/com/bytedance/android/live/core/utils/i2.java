package com.bytedance.android.live.core.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i2 {
    public static Uri e(Uri r4, String r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        Set r0 = UriProtector.getQueryParameterNames(r4);
        if (r0 != null) goto L9;
        return r4;
    L9:
        if (r0.contains(r5) == true) goto L11;
        return r4;
    L11:
        Uri.Builder r1 = r4.buildUpon().clearQuery();
        Iterator r2 = r0.iterator();
    L13:
        if (r2.hasNext() == false) goto L18;
        String r3 = (String) r2.next();
        if (r3.equals(r5) == true) goto L13;
        r1.appendQueryParameter(r3, UriProtector.getQueryParameter(r4, r3));
        goto L13
    L18:
        return r1.build();
    }

    public static int c(Uri r1, String r2, int r3) {
        return CastIntegerProtector.parseInt(d(r1, r2, null));
    L5:
        return r3;
    }

    public static String d(Uri r0, String r1, String r2) {
        if (r0 != null) goto L8;
        return r2;
    L8:
        r2 = UriProtector.getQueryParameter(r0, r1);     // Catch: Exception -> L6
        return URLDecoder.decode(r2, "UTF-8");
    L7:
        return r2;
    }

    public static String b(Context r3, Uri r4, String r5, String[] r6) {
        String[] r1 = {"_data"};
        Cursor r2 = null;
        Cursor r7 = a(r3.getContentResolver(), r4, r1, r5, r6);     // Catch: Throwable -> L15
        if (r7 != null) goto L20;
    L12:
        if (r7 == null) goto L14;
        r7.close();
    L14:
        return null;
    L20:
    L10:
        Throwable th = th;
        r2 = r7;
    L17:
        if (r2 == null) goto L24;
        r2.close();
        throw th;
    L24:
        throw th;
    L6:
        if (r7.moveToFirst() == false) goto L12;
        String r8 = r7.getString(r7.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L10
        r7.close();
        return r8;
    L15:
        th = move-exception;
        th = th;
        goto L17
    }

    public static Cursor a(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r14, r15, r16, r17, null};
        f06.b r11 = new f06.b();
        f06.d r12 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r11);
        if (r12.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r11, false);
        return (Cursor) r12.b;
    L6:
        Cursor r18 = r13.query(r14, r15, r16, r17, null);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r18, r11, true);
        return r18;
    }
}
