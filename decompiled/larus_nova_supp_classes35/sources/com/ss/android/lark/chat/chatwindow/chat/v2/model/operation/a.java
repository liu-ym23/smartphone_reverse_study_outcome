package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Function1<f5b.b, f5b.b> {
    public final String a;

    public final Object invoke(Object r4) {
        f5b.b r5 = (f5b.b) r4;
        if (r5 == null) goto L14;
        List<ReactionInfo> r0 = r5.getReactionInfoList();
        if (CollectionUtils.isNotEmpty(r0) == false) goto L14;
        Iterator<ReactionInfo> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L14;
        Map<String, ChatChatter> r2 = r1.next().getReactionChatters();
        if (CollectionUtils.isNotEmpty(r2) == false) goto L8;
        ChatChatter r3 = r2.get(this.a);
        if (r3 == null) goto L8;
        r3.setAlias(this.a);
    L14:
        return r5;
    }

    public a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        Intrinsics.checkNotNullParameter(r3, "nickname");
        this.a = r2;
    }
}
