package com.ss.android.lark.flow.threadwindow.plugin;

import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.c<y6b.c<?>> {
    public final /* synthetic */ FlowThreadWindowMsgTipsPlugin a;

    public final void b(boolean r1, int r2, int r3) {
    }

    public final void c() {
        wgb.b<y6b.c<?>> r0 = this.a.j;
        if (r0 == null) goto L6;
        int r1 = wgb.b.l;
        r0.m(false);
        return;
    }

    public b(FlowThreadWindowMsgTipsPlugin r1) {
        this.a = r1;
    }

    public final void a(List<? extends y6b.c<?>> r4) {
        Intrinsics.checkNotNullParameter(r4, "itemList");
        FlowThreadWindowMsgTipsPlugin r0 = this.a;
        if (r0.k == false) goto L7;
        wgb.b<y6b.c<?>> r1 = r0.j;
        if (r1 == null) goto L14;
        r1.i(r4, (t2b.a) r0.l.getValue());
        return;
    L14:
        return;
    L7:
        Log.i("FlowThreadWindowMsgTipsPlugin", "enable show message tips");
        FlowThreadWindowMsgTipsPlugin r2 = this.a;
        wgb.b<y6b.c<?>> r3 = r2.j;
        if (r3 == null) goto L10;
        r3.i = true;
    L10:
        r2.k = true;
        if (r3 == null) goto L16;
        r3.i(r4, (t2b.a) r2.l.getValue());
        return;
    }
}
