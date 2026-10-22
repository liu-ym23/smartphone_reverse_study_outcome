package com.larus.bmhome.social.chat.layout.convertor;

import com.larus.bmhome.social.userchat.messagelist.model.IMessageContentConvertor;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/social/chat/layout/convertor/TextContentConvertor;", "Lcom/larus/bmhome/social/userchat/messagelist/model/IMessageContentConvertor;", "Lcom/larus/im/bean/message/TextContent;", "<init>", "()V", "convert", "Lkotlin/Pair;", "", "message", "Lcom/larus/im/bean/message/Message;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextContentConvertor implements IMessageContentConvertor<TextContent> {
    public TextContentConvertor() {
    }

    @Override // com.larus.bmhome.social.userchat.messagelist.model.IMessageContentConvertor
    public final Pair<Boolean, TextContent> a(Message r14) {
        Intrinsics.checkNotNullParameter(r14, "message");
        boolean r2 = true;
        if (r14.getContentType() != 1) goto L5;
    L15:
        String r0 = r14.getContent();
        if (r0 != null) goto L18;
    L20:
        r2 = false;
    L21:
        if (r2 == false) goto L23;
        Boolean r1 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        return TuplesKt.to(r1, r.b(r14));
    L23:
        return TuplesKt.to(Boolean.TRUE, new TextContent(r14.getContent(), null, null, null, null, null, null, null, 254, null));
    L18:
        if (StringsKt.startsWith$default(r0, "{", false, 2, null) != true) goto L20;
    L5:
        if (r14.getContentType() == 800) goto L15;
        if (r14.getContentType() == 71) goto L15;
        if (r14.getContentType() == 66) goto L15;
        if (r14.getContentType() == 1001) goto L15;
        if (r14.getContentType() == 2022) goto L15;
        return null;
    }
}
