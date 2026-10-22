package com.bytedance.android.anniex.utils;

import android.net.Uri;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.salamander.anniex.AnnieXSL;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Uri r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        AnnieXSL.a r0 = AnnieXSL.Companion;
        String r10 = r1.toString();
        r0.getClass();
        if (AnnieXSL.a.a(r10) == false) goto L8;
        AnnieXRuntime.b().getClass();
        AnnieXRuntime.b().getClass();
        return;
    }
}
