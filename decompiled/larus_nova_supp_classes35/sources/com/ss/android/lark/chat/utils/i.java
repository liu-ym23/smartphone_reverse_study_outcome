package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.team.TeamUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i {
    static {
    }

    @JvmStatic
    public static final boolean a(y6b.c<?> r3, jdb.g r4, Chat r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "fgService");
        Intrinsics.checkNotNullParameter(r4, "fgService");
        if (r5 != null) goto L6;
    L14:
        boolean r6 = false;
    L15:
        if (r6 == true) goto L17;
    L19:
        boolean r7 = false;
    L20:
        if (r7 == false) goto L27;
        if (r3.v2 != null) goto L24;
        return false;
    L24:
        if (r3.j() == true) goto L31;
    L28:
        return true;
    L31:
        return false;
    L27:
        if (r3.v != null) goto L28;
        return false;
    L17:
        if (r4.isEnable("im.chat.pinned.msg") == false) goto L19;
        r7 = true;
        goto L20
    L6:
        if (r5.isSecret() == true) goto L14;
        TeamUtils.b(r5);
        if (r4.isEnable("im.chat.pinned.url") == false) goto L14;
        if (r5.isThread() == true) goto L14;
        if (r5.isOnCall() == true) goto L14;
        r6 = true;
        goto L15
    }
}
