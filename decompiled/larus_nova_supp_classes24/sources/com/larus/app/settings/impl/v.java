package com.larus.app.settings.impl;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class v {
    public static final int a(int r1, Context r2) {
        Resources r3 = r2.getResources();
        return (int) ((r1 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }

    public static final boolean c(List r4, int r5) {
        if (r4 == null) goto L28;
        Iterator r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L15;
        Object r1 = r6.next();
        com.larus.uaigc.api.v r3 = (com.larus.uaigc.api.v) r1;
        if (r3 != null) goto L10;
    L12:
        boolean r7 = false;
    L13:
        if (r7 == false) goto L6;
    L16:
        com.larus.uaigc.api.v r2 = (com.larus.uaigc.api.v) r1;
        if (r2 != null) goto L20;
        return false;
    L20:
        if (r2.b() != 1) goto L29;
        return true;
    L29:
        return false;
    L10:
        if (r3.a() != r5) goto L12;
        r7 = true;
        goto L13
    L15:
        r1 = null;
        goto L16
    L28:
        return false;
    }

    public static final String d(Context r0, boolean r1) {
        if (r1 == false) goto L8;
        int r2 = c0.a;
        if (r0 == null) goto L12;
        String r3 = r0.getString(2131897446);
        if (r3 == null) goto L12;
        return r3;
    L12:
        return "";
    L8:
        int r4 = c0.a;
        if (r0 == null) goto L12;
        String r5 = r0.getString(2131897445);
        if (r5 == null) goto L12;
        return r5;
    }

    public static final void b(String r2, String r3, String r4) {
        by7.a r0 = new by7.a("popup_click");
        if (Intrinsics.areEqual(r2, "document") == false) goto L5;
        String r5 = "ai_watermark_office_doc";
    L6:
        r0.d("popup_type", r5);
        r0.d("click_from", r3);
        r0.d("to_status", r4);
        r0.d("current_page", "ai_watermark_setting_page");
        r0.d("enter_method", "setting");
        r0.b();
        return;
    L5:
        r5 = "ai_watermark_image_video";
        goto L6
    }
}
