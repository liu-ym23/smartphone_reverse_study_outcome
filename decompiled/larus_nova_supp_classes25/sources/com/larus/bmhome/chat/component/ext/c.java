package com.larus.bmhome.chat.component.ext;

import com.larus.bmhome.chat.trace.ChatMessageTrace;
import com.larus.bmhome.double_post.fragment.r;
import com.larus.common_ui.dialog.u;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements u {
    public final /* synthetic */ Function0<Unit> a;
    public final /* synthetic */ List<Message> b;
    public final /* synthetic */ String c;
    public final /* synthetic */ JSONObject d;

    public final void cancel() {
        Function0<Unit> r0 = this.a;
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        ChatMessageTrace r1 = ChatMessageTrace.a;
        ChatMessageTrace.d(this.b, this.c, null, false, "cancel_btn_click", this.d);
    }

    public c(r r1, List r2, String r3, JSONObject r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
