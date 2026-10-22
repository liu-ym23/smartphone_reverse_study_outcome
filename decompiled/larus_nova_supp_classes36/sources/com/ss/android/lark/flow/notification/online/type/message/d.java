package com.ss.android.lark.flow.notification.online.type.message;

import android.text.TextUtils;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements AbstractNotification.b<Notice> {
    public d() {
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.b
    public final Notice a(Notice r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.extra == null) goto L9;
        return r2;
    L9:
        return null;
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.b
    public final int b(Notice r8) {
        Notice.Extra r0 = r8.extra;
        if (r0 != null) goto L6;
    L33:
        return 0;
    L6:
        if (r0.j != null) goto L9;
        return 0;
    L9:
        if (r8.shouldNotify == true) goto L33;
        int r1 = r8.state;
        if (r1 == 3) goto L13;
        if (r1 != 2) goto L33;
    L13:
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if ((!TextUtils.isEmpty(r8.extra.e)) == false) goto L30;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (r8.extra.d != Notice.Extra.ChatMode.THREAD_V2) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L30;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (r8.extra.k < 0) goto L30;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        int r9 = r8.state;
        if (r9 == 2) goto L27;
        if (r9 == 3) goto L27;
        boolean r10 = false;
    L28:
        if (r10 == false) goto L30;
        boolean r11 = true;
    L31:
        if (r11 == true) goto L33;
        return 1;
    L27:
        r10 = true;
        goto L28
    L18:
        r4 = false;
    L30:
        r11 = false;
        goto L31
    }
}
