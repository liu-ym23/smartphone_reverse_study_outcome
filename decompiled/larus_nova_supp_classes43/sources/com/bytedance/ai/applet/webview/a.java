package com.bytedance.ai.applet.webview;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.ai.applet.webview.a$a, reason: collision with other inner class name */
    public static final class C0019a {
    }

    static {
    }

    public a() {
    }

    public static int a(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r10 = {r21, null, null};
        f06.b r13 = new f06.b();
        g06.a r11 = (g06.a) ApiHookConfig.b.get(240019);
        if (r11 == null) goto L5;
        f06.a[] r12 = r11.i;
    L6:
        f06.a[] r14 = r12;
        int r15 = r14.length;
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L15;
        f06.a r17 = r14[r16];
        int r18 = r16;
        int r19 = r15;
        f06.a[] r110 = r14;
        d r22 = r17.preInvoke(240019, "android/content/ContentResolver", "delete", r20, r10, "int", r13);     // Catch: Exception -> L22
        if (r22.a == true) goto L17;
        r1.add(r17);     // Catch: Exception -> L22
    L17:
        if (r22.a == false) goto L21;
        return ((Integer) r22.b).intValue();
    L21:
        return r20.delete(r21, null, null);
    L14:
        r16 = r18 + 1;
        r15 = r19;
        r14 = r110;
        goto L8
    L15:
        r22 = new d(false, null);
        goto L17
    L5:
        r12 = ApiHookConfig.d;
        goto L6
    }

    public static Uri b(ContentResolver r18, Uri r19, ContentValues r20) {
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
        d r21 = r16.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
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
        r21 = new d(false, null);
        goto L17
    L5:
        r12 = ApiHookConfig.d;
        goto L6
    }
}
