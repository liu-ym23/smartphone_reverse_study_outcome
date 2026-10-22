package com.ss.android.lark.chat.message.menu.v2;

import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class i0 {
    public static /* synthetic */ void a(j0 r2, boolean r3, MessageActionType r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = null;
    L8:
        r2.d(r3, r4, false);
    }
}
