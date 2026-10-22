package com.ss.android.lark.chat.chatwindow.chat.message.actionimpl;

import android.content.Context;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import kotlin.jvm.internal.Intrinsics;
import mya.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements t {
    public final Context a;

    public final Context getContext() {
        return this.a;
    }

    public h(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void o(String r2, String r3, Integer r4, Boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "threadId");
        l1.a r0 = new l1.a();
        r0.e = r2;
        r0.o = true;
        if (r3 == null) goto L5;
        r0.l = r3;
    L5:
        if (r4 == null) goto L7;
        r0.f = r4.intValue();
    L7:
        if (r5 == null) goto L9;
        r0.b = r5.booleanValue();
    L9:
        l1 r6 = new l1(r0);
        Context r7 = this.a;
        Intrinsics.checkNotNull(r6);
        Boolean r8 = ReplyInThreadUtil.a;
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r6, "bundle");
        ReplyInThreadUtil.c(r7, r6, null);
    }
}
