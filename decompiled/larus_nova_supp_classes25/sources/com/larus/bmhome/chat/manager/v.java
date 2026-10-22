package com.larus.bmhome.chat.manager;

import com.larus.bmhome.chat.model.ConversationListModel;
import com.larus.bmhome.chat.model.ConversationModel;
import org.json.JSONObject;
import tx9.f3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ ConversationModel a;

    public final void confirm() {
        ConversationModel r0 = this.a;
        if (r0 == null) goto L5;
        ConversationListModel.a.getClass();
        r0.batchDelUserConv(ConversationListModel.q());
    L5:
        JSONObject r1 = new JSONObject();
        r1.put("cell_type", "unadded_bot_list");
        f3.b(r1);
    }

    public v(ConversationModel r1) {
        this.a = r1;
    }
}
