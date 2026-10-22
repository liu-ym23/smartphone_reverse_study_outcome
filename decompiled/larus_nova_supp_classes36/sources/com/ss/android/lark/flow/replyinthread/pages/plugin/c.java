package com.ss.android.lark.flow.replyinthread.pages.plugin;

import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.c<y6b.c<?>> {
    public final /* synthetic */ ReplyInThreadMsgTipsPlugin a;

    public final void b(boolean r1, int r2, int r3) {
    }

    public final void c() {
        wgb.b<y6b.c<?>> r0 = this.a.j;
        if (r0 == null) goto L6;
        int r1 = wgb.b.l;
        r0.m(false);
        return;
    }

    public c(ReplyInThreadMsgTipsPlugin r1) {
        this.a = r1;
    }

    public final void a(List<? extends y6b.c<?>> r4) {
        Intrinsics.checkNotNullParameter(r4, "itemList");
        ReplyInThreadMsgTipsPlugin r0 = this.a;
        if (r0.l == false) goto L7;
        wgb.b<y6b.c<?>> r1 = r0.j;
        if (r1 == null) goto L14;
        r1.i(r4, (z2c.a) r0.k.getValue());
        return;
    L14:
        return;
    L7:
        Log.i("ReplyInThreadMsgTipsPlugin", "enable show message tips");
        ReplyInThreadMsgTipsPlugin r2 = this.a;
        wgb.b<y6b.c<?>> r3 = r2.j;
        if (r3 == null) goto L10;
        r3.i = true;
    L10:
        r2.l = true;
        if (r3 == null) goto L16;
        r3.i(r4, (z2c.a) r2.k.getValue());
        return;
    }
}
