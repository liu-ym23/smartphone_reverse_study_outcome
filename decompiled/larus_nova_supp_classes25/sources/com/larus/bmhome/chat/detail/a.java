package com.larus.bmhome.chat.detail;

import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.z;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class a implements i {
    public Message a;
    public String b;
    public String c;

    @Override // com.larus.bmhome.chat.detail.i
    public final void v() {
    }

    @Override // com.larus.bmhome.chat.detail.i
    public final String c() {
        Message r0 = this.a;
        if (r0 == null) goto L7;
        Map r1 = r0.getExt();
        if (r1 == null) goto L7;
        return (String) r1.get("deep_research_id");
    L7:
        return null;
    }

    public a() {
        this.b = "";
        this.c = "";
    }

    @Override // com.larus.bmhome.chat.detail.i
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // com.larus.bmhome.chat.detail.i
    public final void j(Message r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.chat.detail.i
    public final void setConversationId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    @Override // com.larus.bmhome.chat.detail.i
    public final void d(by7.e r23, BotModel r24, String r25, long r26, CustomMarkdownTextView r28, String r29, int r30, boolean r31, String r32, AbstractCommonDetailFragment.c r33) {
        Intrinsics.checkNotNullParameter(r29, "clickFrom");
        z r1 = ILegacyChatUiServiceDelegate.b.F8();
        if (r1 == null) goto L6;
        z.a.a(r1, r23, r24, r25, r26, r28, this.a, r29, null, null, false, r30, r31, r32, r33, true, null, null, null, 492416);
        return;
    }
}
