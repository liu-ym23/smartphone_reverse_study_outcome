package com.ss.android.lark.im.sdk.service;

import com.bytedance.lark.pb.im.v1.UpdateChatResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "kotlin.jvm.PlatformType", "it", "Lcom/bytedance/lark/pb/im/v1/UpdateChatResponse;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class ImSdkChatServiceImplV2$updateChat$1$1 extends Lambda implements Function1<UpdateChatResponse, Chat> {
    public static final ImSdkChatServiceImplV2$updateChat$1$1 INSTANCE = null;

    static {
        INSTANCE = new ImSdkChatServiceImplV2$updateChat$1$1();
    }

    public ImSdkChatServiceImplV2$updateChat$1$1() {
        super(1);
    }

    public final Chat invoke(UpdateChatResponse r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        return com.ss.android.lark.parser.internal.h.a((com.bytedance.lark.pb.basic.v1.Chat) r3.entity.chats.get(r3.chat_id), r3.entity.mail_setting);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((UpdateChatResponse) r1);
    }
}
