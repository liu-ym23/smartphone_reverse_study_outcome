package com.bytedance.android.anniex.lite.utils;

import android.net.Uri;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static volatile String a;

    public static final Long a(Uri r10, String r11, m16.b r12) {
        if (r10 != null) goto L5;
    L24:
        return null;
    L5:
        if (((Boolean) SwitchCenter.m0.getValue()).booleanValue() == true) goto L7;
        return null;
    L7:
        boolean r1 = false;
        if (r11 != null) goto L10;
    L12:
        boolean r13 = false;
    L13:
        if (r12 == null) goto L15;
        a r14 = (a) r12.c(a.class);
    L16:
        if (r14 == null) goto L18;
        r1 = true;
    L18:
        if (r13 == true) goto L21;
        if (r1 == false) goto L24;
    L21:
        if (SwitchCenter.a(r10) == false) goto L24;
        return Long.valueOf(((Number) SwitchCenter.n0.getValue()).longValue());
    L15:
        r14 = null;
        goto L16
    L10:
        if (Intrinsics.areEqual(a, r11) == false) goto L12;
        r13 = true;
        goto L13
    }
}
