package com.ss.android.lark.im.sdk.service;

import com.bytedance.lark.pb.im.v1.GetP2PChatsByChatterIdsResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "it", "Lcom/bytedance/lark/pb/im/v1/GetP2PChatsByChatterIdsResponse;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class ImSdkChatServiceImplV2$getOrCreateP2pChat$1$1 extends Lambda implements Function1<GetP2PChatsByChatterIdsResponse, Chat> {
    final /* synthetic */ String $chatterId;

    public ImSdkChatServiceImplV2$getOrCreateP2pChat$1$1(String r1) {
        this.$chatterId = r1;
        super(1);
    }

    public final Chat invoke(GetP2PChatsByChatterIdsResponse r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        Map r4 = r3.chatter_id2chat;
        if (r4.keySet().contains(this.$chatterId) == true) goto L5;
        return null;
    L5:
        return com.ss.android.lark.parser.internal.h.a((com.bytedance.lark.pb.basic.v1.Chat) r4.get(this.$chatterId), null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((GetP2PChatsByChatterIdsResponse) r1);
    }
}
