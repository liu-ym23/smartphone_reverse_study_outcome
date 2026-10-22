package com.ss.android.lark.chat.cot.detail;

import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.biz.im.api.k0;
import com.ss.android.lark.chat.entity.message.CotContent;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o implements k0 {
    public final /* synthetic */ CotDetailSheet a;

    public o(CotDetailSheet r1) {
        this.a = r1;
    }

    public final /* synthetic */ void b(PushMessageReadStates r1) {
    }

    public final /* synthetic */ void f(PushMessageReactions r1) {
    }

    public final void a(g1 r5) {
        Intrinsics.checkNotNullParameter(r5, "dto");
        MessageInfo r6 = r5.a;
        if (r6 == null) goto L20;
        Message r7 = r6.getMessage();
        if (r7 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r7.getId(), this.a.c) == true) goto L10;
        return;
    L10:
        CotContent r0 = r7.getCotContent();
        if (r0 != null) goto L14;
        return;
    L14:
        if (this.a.t == false) goto L16;
        return;
    L16:
        com.ss.android.lark.chat.cot.f.c("detail_push", "hit message push, messageId=" + r7.getId() + ", cid=" + r7.getcId() + ", chatId=" + r7.getChatId() + ", " + com.ss.android.lark.chat.cot.f.d(r0));
        if (this.a.r.tryEmit(r0) == true) goto L21;
        com.ss.android.lark.chat.cot.f.e("detail_push", "drop cot push because flow is closed or has no buffer, messageId=" + r7.getId() + ", cotId=" + r0.getCotId());
        return;
    L21:
        return;
    }
}
