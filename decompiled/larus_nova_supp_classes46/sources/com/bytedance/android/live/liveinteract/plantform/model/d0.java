package com.bytedance.android.live.liveinteract.plantform.model;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0 {
    public static final Spannable a(c0 r5, Spannable r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "$this$wrapperText");
        Intrinsics.checkNotNullParameter(r6, "eventInfo");
        Intrinsics.checkNotNullParameter(r7, "placeholder");
        Intrinsics.checkNotNullParameter(r5, "$this$needPlaceHolder");
        boolean r2 = true;
        if (r5.getEventInfoType() != 2) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
    L40:
        return r6;
    L10:
        if (r7.length() != 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L40;
        if (r6.length() != 0) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == true) goto L21;
        SpannableStringBuilder r4 = new SpannableStringBuilder();
        Intrinsics.checkNotNullParameter(r5, "$this$isEcom");
        if (r5.getEventInfoType() != 5) goto L25;
    L28:
        boolean r8 = true;
    L30:
        if (r8 == true) goto L38;
        Intrinsics.checkNotNullParameter(r5, "$this$isRecommend");
        if (r5.getEventInfoType() == 8) goto L35;
        r2 = false;
    L35:
        if (r2 == true) goto L38;
        r4.append(r7 + " | ");
        r4.append(r6);
    L39:
        return r4;
    L38:
        r4.append(r6);
        r4.append(" | " + r7);
        goto L39
    L25:
        if (r5.getEventInfoType() == 6) goto L28;
        r8 = false;
        goto L30
    L21:
        return new SpannableString(r7);
    L18:
        r3 = false;
        goto L19
    L12:
        r1 = false;
        goto L13
    L5:
        if (r5.getEventInfoType() == 4) goto L7;
        r0 = true;
        goto L8
    }
}
