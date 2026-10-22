package com.larus.bmhome.chat.cell.slot;

import android.content.Context;
import android.widget.TextView;
import com.bytedance.router.SmartRouter;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h implements IIMCallback<wc9.e> {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        if (this.c == true) goto L5;
    L7:
        int r4 = 2131908080;
    L8:
        t19.s r0 = t19.s.a;
        Context r1 = this.a.getContext();
        r0.getClass();
        t19.s.s(r1, r4);
        return;
    L5:
        if (r3.getCode() != 712013001) goto L7;
        r4 = 2131906588;
        goto L8
    }

    public final void onSuccess(Object r4) {
        wc9.e r5 = (wc9.e) r4;
        if (r5 == null) goto L11;
        Integer r6 = r5.t;
        if (r6 != null) goto L8;
    L10:
        com.bytedance.router.i r7 = SmartRouter.buildRoute(this.a.getContext(), "//flow/chat_page");
        String r0 = this.b;
        r7.c.putExtra("argConversationId", r0);
        r7.d();
        return;
    L8:
        if (r6.intValue() != 2) goto L10;
    L11:
        t19.s r8 = t19.s.a;
        Context r1 = this.a.getContext();
        r8.getClass();
        t19.s.s(r1, 2131906588);
    }

    public h(TextView r1, String r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
