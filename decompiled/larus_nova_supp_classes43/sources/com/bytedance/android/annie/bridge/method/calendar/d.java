package com.bytedance.android.annie.bridge.method.calendar;

import android.content.ContentResolver;
import android.net.Uri;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(ContentResolver r18, Uri r19, String r20, String[] r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20, r21};
        f06.b r11 = new f06.b();
        g06.a r10 = (g06.a) ApiHookConfig.b.get(240019);
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
        f06.d r22 = r16.preInvoke(240019, "android/content/ContentResolver", "delete", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r22.a == true) goto L17;
        r0.add(r16);     // Catch: Exception -> L22
    L17:
        if (r22.a == false) goto L21;
        return ((Integer) r22.b).intValue();
    L21:
        return r18.delete(r19, r20, r21);
    L14:
        r14 = r17 + 1;
        r13 = r110;
        goto L8
    L15:
        r22 = new f06.d(false, null);
        goto L17
    L5:
        r12 = ApiHookConfig.d;
        goto L6
    }
}
