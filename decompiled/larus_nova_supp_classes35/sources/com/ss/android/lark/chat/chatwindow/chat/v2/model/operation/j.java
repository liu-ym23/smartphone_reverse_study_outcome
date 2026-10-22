package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Pin;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements Function1<f5b.b, f5b.b> {
    public final String a;
    public final String b;
    public final String c;

    public final Object invoke(Object r5) {
        f5b.b r6 = (f5b.b) r5;
        if (r6 == null) goto L27;
        List<ReactionInfo> r0 = r6.getReactionInfoList();
        if (CollectionUtils.isNotEmpty(r0) == false) goto L14;
        Iterator<ReactionInfo> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L14;
        Map<String, ChatChatter> r2 = r1.next().getReactionChatters();
        if (CollectionUtils.isNotEmpty(r2) == false) goto L8;
        ChatChatter r3 = r2.get(this.b);
        if (r3 == null) goto L8;
        r3.setNickName(this.c);
    L14:
        ChatChatter r4 = r6.getMessageSender();
        if (r4 != null) goto L17;
    L19:
        Pin r7 = r6.getPin();
        if (r7 == null) goto L27;
        if (Intrinsics.areEqual(r7.getOperatorId(), this.b) == false) goto L27;
        ChatChatter r8 = ImSdkService.d().He(this.a, this.b);
        if (r8 == null) goto L26;
        r8.setNickName(this.c);
    L26:
        r7.setOperatorDisplayName(com.ss.android.lark.chat.utils.m.b(r8, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, true));
        goto L27
    L17:
        if (Intrinsics.areEqual(r4.getId(), this.b) == false) goto L19;
        r4.setNickName(this.c);
    L27:
        return r6;
    }

    public j(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "chatterId");
        Intrinsics.checkNotNullParameter(r4, "nickname");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
