package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.ss.android.lark.notification.export.entity.Notice;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class t0 {
    static {
    }

    @JvmStatic
    public static final boolean a(Notice r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "chatId");
        if (r4.isFromBackgroundUser == false) goto L5;
        return true;
    L5:
        Notice.Extra r0 = r4.extra;
        if (r0.d != Notice.Extra.ChatMode.THREAD_V2) goto L8;
    L11:
        return true;
    L8:
        if (TextUtils.isEmpty(r0.e) == false) goto L11;
        return !TextUtils.equals(r4.extra.a, r5);
    }

    @JvmStatic
    public static final boolean b(Notice r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "threadId");
        if (r4.isFromBackgroundUser == false) goto L5;
        return true;
    L5:
        Notice.Extra r0 = r4.extra;
        if (r0.d != Notice.Extra.ChatMode.THREAD_V2) goto L16;
        if (TextUtils.isEmpty(r0.e) == false) goto L10;
    L14:
        return true;
    L10:
        if (TextUtils.isEmpty(r5) == true) goto L14;
        boolean r6 = TextUtils.equals(r4.extra.e, r5);
    L13:
        return !r6;
    L16:
        if (TextUtils.isEmpty(r0.e) == true) goto L18;
        r6 = TextUtils.equals(r4.extra.e, r5);
        goto L13
    L18:
        return true;
    }

    @JvmStatic
    public static final boolean c(Notice r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "chatId");
        if (r4.isFromBackgroundUser == false) goto L5;
        return true;
    L5:
        Notice.Extra r0 = r4.extra;
        if (r0.d == Notice.Extra.ChatMode.THREAD_V2) goto L8;
    L19:
        return true;
    L8:
        if (TextUtils.isEmpty(r0.a) == true) goto L15;
        if (TextUtils.isEmpty(r5) == true) goto L15;
        boolean r6 = TextUtils.equals(r4.extra.a, r5);
    L13:
        return !r6;
    L15:
        if (r4.type == 2) goto L19;
        Notice.Extra r7 = r4.extra;
        if (r7.k != (-1)) goto L19;
        r6 = TextUtils.equals(r7.a, r5);
        goto L13
    }
}
