package com.larus.bmhome.chat;

import android.view.View;
import com.larus.bmhome.bot.dialog.BotNickNameEditDialog;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.model.repo.ChatSender;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x4 implements BotNickNameEditDialog.c {
    public final /* synthetic */ String a;
    public final /* synthetic */ View b;

    @Override // com.larus.bmhome.bot.dialog.BotNickNameEditDialog.c
    public final void onCancel() {
    }

    @Override // com.larus.bmhome.bot.dialog.BotNickNameEditDialog.c
    public final void a(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "nickName");
        Intrinsics.checkNotNullParameter(r9, "firstMessage");
        MarkdownResolver r10 = MarkdownResolver.a;
        String r2 = this.a;
        t1a.b r0 = ei9.c.a(this.b);
        if (r0 == null) goto L5;
        ChatPageContext r1 = (ChatPageContext) r0.a(ChatPageContext.class);
    L6:
        ChatPageContext r6 = r1;
        r10.getClass();
        RepoDispatcher.a.getClass();
        ChatSender r3 = RepoDispatcher.d.e;
        ChatSendUtils r11 = ChatSendUtils.a;
        Pair[] r4 = {TuplesKt.to("from_onboarding", "1")};
        r11.getClass();
        Map r5 = ChatSendUtils.p(r4);
        int r12 = ChatSender.j;
        r3.M(r9, r2, "change_user_nickname", r5, true, r6);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public x4(String r1, String r2, View r3) {
        this.a = r2;
        this.b = r3;
    }
}
