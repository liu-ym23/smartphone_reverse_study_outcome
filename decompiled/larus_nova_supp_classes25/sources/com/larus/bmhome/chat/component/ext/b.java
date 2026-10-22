package com.larus.bmhome.chat.component.ext;

import com.larus.bmhome.chat.trace.ChatMessageTrace;
import com.larus.common_ui.dialog.u;
import com.larus.im.bean.message.Message;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements u {
    public final /* synthetic */ List<Message> a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Integer c;
    public final /* synthetic */ JSONObject d;

    public final void cancel() {
        ChatMessageTrace r0 = ChatMessageTrace.a;
        ChatMessageTrace.d(this.a, this.b, this.c, false, "cancel_btn_click", this.d);
    }

    public b(List<Message> r1, String r2, Integer r3, JSONObject r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
