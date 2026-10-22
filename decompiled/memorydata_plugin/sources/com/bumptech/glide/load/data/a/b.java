package com.bumptech.glide.load.data.a;

import android.net.Uri;
import com.obric.aikernel.sdk.ext.Params;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static boolean a(int r1, int r2) {
        if (r1 == Integer.MIN_VALUE) goto L10;
        if (r2 == Integer.MIN_VALUE) goto L10;
        if (r1 > 512) goto L10;
        if (r2 > 384) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean a(Uri r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (Params.CONTENT.equals(r2.getScheme()) == false) goto L8;
        if ("media".equals(r2.getAuthority()) == false) goto L8;
        return true;
    }

    public static boolean b(Uri r1) {
        if (a(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.getPathSegments().contains("picker") == false) goto L7;
        return true;
    }

    public static boolean c(Uri r1) {
        if (a(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (e(r1) == false) goto L7;
        return true;
    }

    public static boolean d(Uri r1) {
        if (a(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (e(r1) == true) goto L7;
        return true;
    }

    private static boolean e(Uri r1) {
        return r1.getPathSegments().contains("video");
    }
}
