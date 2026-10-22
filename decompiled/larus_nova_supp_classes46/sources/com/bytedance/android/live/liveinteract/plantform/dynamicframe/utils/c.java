package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import android.net.Uri;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.utils.w0;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public c() {
    }

    static {
    }

    public static String a(String r5, int r6, int r7) {
        if ((r7 & 2) == 0) goto L5;
        r6 = -1;
    L5:
        Intrinsics.checkNotNullParameter(r5, "lynxUrl");
        Uri r8 = UriProtector.parse(r5);
        Uri.Builder r9 = r8.buildUpon();
        w0.a();
        String r1 = UriProtector.getQueryParameter(r8, "business_type");
        boolean r2 = true;
        if (r1 != null) goto L8;
    L12:
        r9.appendQueryParameter("business_type", "livelinkmic");
    L13:
        String r10 = UriProtector.getQueryParameter(r8, "business_group");
        if (r10 != null) goto L16;
    L20:
        r9.appendQueryParameter("business_group", "livelinkmic");
    L21:
        r9.appendQueryParameter("show_from", String.valueOf(r6));
        if (FoldScreenUtils.f() == false) goto L24;
        String r11 = "1";
    L25:
        r9.appendQueryParameter("is_android_fold", r11);
        return r9.build().toString();
    L24:
        r11 = "0";
        goto L25
    L16:
        if (r10.length() == 0) goto L19;
        r2 = false;
    L19:
        if (r2 == false) goto L21;
    L8:
        if (r1.length() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
    L10:
        r3 = false;
        goto L11
    }

    public static String b(String r5, Long r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "lynxUrl");
        Uri.Builder r9 = UriProtector.parse(r5).buildUpon();
        if (r6 == null) goto L15;
        r6.longValue();
        if (r6.longValue() <= 0) goto L7;
        r9.appendQueryParameter("multilink_room_id", String.valueOf(r6.longValue()));
    L7:
        if (r7 == false) goto L9;
        String r10 = "1";
    L10:
        r9.appendQueryParameter("multilink_is_feed", r10);
        if (r8 != null) goto L13;
        String r11 = "";
    L14:
        r9.appendQueryParameter("multilink_enter_from", r11);
        goto L15
    L13:
        r11 = r8;
        goto L14
    L9:
        r10 = "0";
    L15:
        if (r8 == null) goto L26;
        if (r8.length() <= 0) goto L19;
        boolean r12 = true;
    L20:
        if (r12 == true) goto L23;
        r8 = null;
    L23:
        if (r8 == null) goto L26;
        r9.appendQueryParameter("enter_from", r8);
        goto L26
    L19:
        r12 = false;
    L26:
        return r9.build().toString();
    }
}
