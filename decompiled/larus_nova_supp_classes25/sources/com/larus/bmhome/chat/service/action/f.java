package com.larus.bmhome.chat.service.action;

import com.larus.bmhome.chat.model.ConversationListModel;
import com.larus.bmhome.chat.model.ConversationModel;
import com.larus.common_ui.dialog.p0;
import org.json.JSONObject;
import tx9.f3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements p0 {
    public final /* synthetic */ h a;

    public final void confirm() {
        ConversationModel r0 = this.a.a.b;
        ConversationListModel.a.getClass();
        r0.batchDelUserConv(ConversationListModel.q());
        JSONObject r1 = new JSONObject();
        r1.put("cell_type", "unadded_bot_list");
        f3.b(r1);
    }

    public f(h r1) {
        this.a = r1;
    }
}
