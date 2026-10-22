package com.bytedance.android.annie.bridge.method.calendar;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Uri a(ContentResolver r18, Uri r19, ContentValues r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20};
        f06.b r11 = new f06.b();
        g06.a r10 = (g06.a) ApiHookConfig.b.get(240017);
        if (r10 == null) goto L5;
        f06.a[] r12 = r10.i;
    L6:
        f06.a[] r15 = r12;
        int r13 = r15.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L15;
        f06.a r16 = r15[r14];
        int r17 = r14;
        int r110 = r13;
        f06.d r21 = r16.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
        if (r21.a == true) goto L17;
        r0.add(r16);     // Catch: Exception -> L22
    L17:
        if (r21.a == false) goto L21;
        return (Uri) r21.b;
    L21:
        return r18.insert(r19, r20);
    L14:
        r14 = r17 + 1;
        r13 = r110;
        goto L8
    L15:
        r21 = new f06.d(false, null);
        goto L17
    L5:
        r12 = ApiHookConfig.d;
        goto L6
    }

    public static Cursor b(ContentResolver r12, Uri r13, String[] r14) {
        f06.c r10 = new f06.c();
        Object[] r11 = {r13, r14, null, null, null};
        f06.b r15 = new f06.b();
        f06.d r16 = r10.b(240004, "android/content/ContentResolver", "query", r12, r11, "android.database.Cursor", r15);
        if (r16.a == false) goto L6;
        r10.a(240004, "android/content/ContentResolver", "query", r12, r11, null, r15, false);
        return (Cursor) r16.b;
    L6:
        Cursor r17 = r12.query(r13, r14, null, null, null);
        r10.a(240004, "android/content/ContentResolver", "query", r12, r11, r17, r15, true);
        return r17;
    }
}
