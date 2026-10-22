package com.bytedance.android.ec.core.imagex.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bytedance.android.ec.core.imagex.ImageExperiments;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static Drawable a;
    public static Drawable b;
    public static Drawable c;

    public d() {
    }

    static {
    }

    public static Drawable b(Context r10, int r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r11 < 98) goto L19;
        Drawable r12 = a;
        if (r12 != null) goto L54;
        Context r13 = r10.getApplicationContext();
        if (r13 == null) goto L50;
        Resources r14 = r13.getResources();
        if (r14 == null) goto L51;
        Drawable r15 = r14.getDrawable(2131234552);
        if (r15 == null) goto L52;
        a = r15;
    L53:
        return r15;
    L52:
        return null;
    L51:
        return null;
    L50:
        return null;
    L54:
        return r12;
    L19:
        if (r11 < 60) goto L30;
        if (r11 >= 98) goto L30;
        r12 = b;
        if (r12 != null) goto L54;
        Context r16 = r10.getApplicationContext();
        if (r16 == null) goto L55;
        Resources r17 = r16.getResources();
        if (r17 == null) goto L56;
        r15 = r17.getDrawable(2131234553);
        if (r15 == null) goto L57;
        b = r15;
        goto L53
    L57:
        return null;
    L56:
        return null;
    L55:
        return null;
    L30:
        if (r11 <= 0) goto L41;
        if (r11 >= 60) goto L41;
        r12 = c;
        if (r12 != null) goto L54;
        Context r18 = r10.getApplicationContext();
        if (r18 == null) goto L58;
        Resources r19 = r18.getResources();
        if (r19 == null) goto L59;
        r15 = r19.getDrawable(2131234554);
        if (r15 == null) goto L60;
        c = r15;
        goto L53
    L60:
        return null;
    L59:
        return null;
    L58:
        return null;
    L41:
        r12 = a;
        if (r12 != null) goto L54;
        Context r20 = r10.getApplicationContext();
        if (r20 == null) goto L61;
        Resources r21 = r20.getResources();
        if (r21 == null) goto L62;
        r15 = r21.getDrawable(2131234552);
        if (r15 == null) goto L63;
        a = r15;
        goto L53
    L63:
        return null;
    L62:
        return null;
    L61:
        return null;
    }

    public static boolean a(Uri r10, com.bytedance.android.ec.core.imagex.r r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = null;
    L8:
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.o.getValue()).booleanValue() == true) goto L12;
    L14:
        return false;
    L12:
        if ((r11 instanceof com.bytedance.android.ec.core.imagex.u) == false) goto L14;
        return ((com.bytedance.android.ec.core.imagex.u) r11).j(r10);
    }
}
