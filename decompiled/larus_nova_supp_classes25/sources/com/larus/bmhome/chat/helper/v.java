package com.larus.bmhome.chat.helper;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ CocoSubConversationSettingMenuTrigger a;
    public final /* synthetic */ wc9.e b;

    public final void cancel() {
        int r0 = com.larus.bmhome.chat.trace.i0.a;
        CocoSubConversationSettingMenuTrigger r1 = this.a;
        JSONObject r2 = CocoSubConversationSettingMenuTrigger.c(this.b, r1.f);
        by7.e r3 = this.a.d;
        if ((r3 instanceof by7.e) == true) goto L6;
        r3 = null;
    L6:
        Intrinsics.checkNotNullParameter(r2, "params");
        com.larus.bmhome.chat.trace.i0.a("cancel_edit_chat_name", r2, r3);
    }

    public v(CocoSubConversationSettingMenuTrigger r1, wc9.e r2) {
        this.a = r1;
        this.b = r2;
    }
}
