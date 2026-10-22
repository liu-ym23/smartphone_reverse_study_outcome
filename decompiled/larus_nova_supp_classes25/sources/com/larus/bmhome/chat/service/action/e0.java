package com.larus.bmhome.chat.service.action;

import android.view.View;
import com.larus.bmhome.chat.model.ConversationModel;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.OmniMoveConversationToProjectResponse;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import tx9.p3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e0 implements IIMCallback<OmniMoveConversationToProjectResponse> {
    public final /* synthetic */ String a;
    public final /* synthetic */ z b;
    public final /* synthetic */ wh8.a c;
    public final /* synthetic */ String d;
    public final /* synthetic */ View e;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        FLogger.a.e("MoveToProjectActionHandler", "move conversation failed code=" + r5.getCode() + " msg=" + r5.getTips());
        com.larus.bmhome.chat.api.i r6 = this.b.a.a;
        p3.i(r6.c, this.d, this.a, "fail_not_support", r6.b);
        final View r7 = this.e;
        final z r0 = this.b;
        r7.post(new c0(r0, r7));
    }

    public final void onSuccess(Object r7) {
        Intrinsics.checkNotNullParameter((OmniMoveConversationToProjectResponse) r7, "result");
        FLogger r8 = FLogger.a;
        r8.i("MoveToProjectActionHandler", "move conversation success projectId=" + this.a);
        z r0 = this.b;
        wh8.a r2 = this.c;
        r0.getClass();
        wc9.e r3 = r2.a;
        if (r3 != null) goto L6;
    L15:
        com.larus.bmhome.chat.api.i r9 = this.b.a.a;
        p3.i(r9.c, this.d, this.a, "success", r9.b);
        View r10 = this.e;
        final z r1 = this.b;
        final wh8.a r4 = this.c;
        r10.post(new d0(r1, r4));
        return;
    L6:
        if (ic8.n.z(r3) == false) goto L15;
        r8.i("MoveToProjectActionHandler", "unpin after move conversationId=" + r3.a);
        ConversationModel r11 = r0.a.b;
        BotModel r5 = r2.b;
        if (r5 == null) goto L11;
        String r6 = r5.getBotId();
    L12:
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        r11.changePinStatusConversation(r6, r3, false);
        goto L15
    L11:
        r6 = null;
        goto L12
    }

    public e0(String r1, z r2, wh8.a r3, String r4, View r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
