package com.bytedance.android.annie.bridge.method.calendar;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
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

    public static int b(ContentResolver r18, Uri r19, ContentValues r20, String r21, String[] r22) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20, r21, r22};
        f06.b r11 = new f06.b();
        g06.a r10 = (g06.a) ApiHookConfig.b.get(240018);
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
        f06.d r23 = r16.preInvoke(240018, "android/content/ContentResolver", "update", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r23.a == true) goto L17;
        r0.add(r16);     // Catch: Exception -> L22
    L17:
        if (r23.a == false) goto L21;
        return ((Integer) r23.b).intValue();
    L21:
        return r18.update(r19, r20, r21, r22);
    L14:
        r14 = r17 + 1;
        r13 = r110;
        goto L8
    L15:
        r23 = new f06.d(false, null);
        goto L17
    L5:
        r12 = ApiHookConfig.d;
        goto L6
    }
}
