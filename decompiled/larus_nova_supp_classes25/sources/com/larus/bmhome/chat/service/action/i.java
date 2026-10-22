package com.larus.bmhome.chat.service.action;

import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.ConversationModel;
import com.larus.common_ui.dialog.y0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i implements y0 {
    public final /* synthetic */ k a;
    public final /* synthetic */ wc9.e b;
    public final /* synthetic */ wh8.a c;
    public final /* synthetic */ com.larus.bmhome.chat.api.i d;

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, ChatDraftItem.TYPE_TEXT);
        ConversationModel r0 = this.a.a.b;
        wc9.e r1 = this.b;
        if (r1 == null) goto L6;
        String r2 = r1.a;
        if (r2 == null) goto L6;
    L7:
        r0.updateConversationName(r2, r5);
        int r6 = com.larus.bmhome.chat.trace.i0.a;
        int r7 = c.a;
        wc9.e r8 = this.b;
        wh8.a r3 = this.c;
        com.larus.bmhome.chat.api.i r4 = this.d;
        JSONObject r9 = c.c(r8, r3, r4.d, r4.e, r4.c);
        by7.e r10 = this.d.b;
        Intrinsics.checkNotNullParameter(r9, "params");
        com.larus.bmhome.chat.trace.i0.a("edit_chat_name", r9, r10);
        return;
    L6:
        r2 = "";
        goto L7
    }

    public i(k r1, wc9.e r2, wh8.a r3, com.larus.bmhome.chat.api.i r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
