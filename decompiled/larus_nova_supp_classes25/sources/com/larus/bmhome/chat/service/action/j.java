package com.larus.bmhome.chat.service.action;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ wc9.e a;
    public final /* synthetic */ wh8.a b;
    public final /* synthetic */ com.larus.bmhome.chat.api.i c;

    public final void cancel() {
        int r0 = com.larus.bmhome.chat.trace.i0.a;
        int r1 = c.a;
        wc9.e r2 = this.a;
        wh8.a r3 = this.b;
        com.larus.bmhome.chat.api.i r4 = this.c;
        JSONObject r5 = c.c(r2, r3, r4.d, r4.e, r4.c);
        by7.e r6 = this.c.b;
        Intrinsics.checkNotNullParameter(r5, "params");
        com.larus.bmhome.chat.trace.i0.a("cancel_edit_chat_name", r5, r6);
    }

    public j(wc9.e r1, wh8.a r2, com.larus.bmhome.chat.api.i r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
