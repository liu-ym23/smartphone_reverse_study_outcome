package com.larus.bmhome.social.chat.layout.convertor;

import com.larus.bmhome.social.userchat.messagelist.model.IMessageContentConvertor;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/social/chat/layout/convertor/UserImageContentConvertor;", "Lcom/larus/bmhome/social/userchat/messagelist/model/IMessageContentConvertor;", "Lcom/larus/im/bean/message/Image;", "<init>", "()V", "convert", "Lkotlin/Pair;", "", "message", "Lcom/larus/im/bean/message/Message;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserImageContentConvertor implements IMessageContentConvertor<Image> {
    public UserImageContentConvertor() {
    }

    @Override // com.larus.bmhome.social.userchat.messagelist.model.IMessageContentConvertor
    public final Pair<Boolean, Image> a(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        if (r5.getContentType() == 6) goto L5;
        return null;
    L5:
        String r1 = r5.getContent();
        if (r1 != null) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual(new JSONObject(r1).optString("src"), "user-sent") == true) goto L14;
        return null;
    L14:
        return TuplesKt.to(Boolean.TRUE, HttpExtKt.f.fromJson(r5.getContent(), Image.class));
    L16:
        return null;
    }
}
