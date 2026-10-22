package com.ss.android.lark.chat.message.menu.v2.popup;

import android.content.Context;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public static final boolean b(zya.b r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        zya.d r0 = r3.j;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r3.g == false) goto L12;
        if (r1 == true) goto L12;
        return true;
    L12:
        return false;
    L5:
        if (r0.a() != true) goto L7;
        r1 = true;
        goto L9
    }

    public static final boolean a(zya.b r3, View r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "view");
        zya.d r0 = r3.j;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return false;
    L10:
        zya.d r6 = r3.j;
        if (r6 == null) goto L13;
        r6.b(r4, r5);
    L13:
        return true;
    L5:
        if (r0.c(r5) != true) goto L7;
        r1 = true;
        goto L8
    }

    public static final void c(b r2, Context r3, zya.b r4, int r5, int r6, Integer r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, Keys.API_PARAM_KEY_ACTION);
        Integer r0 = r4.d;
        Integer r1 = null;
        if (r0 == null) goto L5;
        Integer r9 = Integer.valueOf(UIUtils.getColor(r3, r0.intValue()));
    L7:
        if (r4.c == true) goto L15;
        if (r8 == true) goto L11;
        r1 = Integer.valueOf(r6);
        goto L15
    L11:
        if (r9 == null) goto L13;
        int r10 = r9.intValue();
    L14:
        r1 = Integer.valueOf(r10);
        goto L15
    L13:
        r10 = r5;
    L15:
        if (r8 == true) goto L17;
        r5 = r6;
    L19:
        if (r1 == null) goto L21;
        r2.setIconTint(r1.intValue());
    L21:
        r2.setTextColor(r5);
        if (r7 == null) goto L25;
        r2.setBgColor(r7.intValue());
        return;
    L25:
        return;
    L17:
        if (r9 == null) goto L19;
        r5 = r9.intValue();
        goto L19
    L5:
        r9 = null;
        goto L7
    }
}
