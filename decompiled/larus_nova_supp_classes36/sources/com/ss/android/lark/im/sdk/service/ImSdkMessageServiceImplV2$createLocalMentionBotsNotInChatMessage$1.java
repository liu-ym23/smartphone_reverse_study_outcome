package com.ss.android.lark.im.sdk.service;

import com.bytedance.lark.pb.im.v1.CreateLocalMentionBotsNotInChatMessageResponse;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/im/sdk/service/MentionBotLocalMessageCreateResult;", "it", "Lcom/bytedance/lark/pb/im/v1/CreateLocalMentionBotsNotInChatMessageResponse;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class ImSdkMessageServiceImplV2$createLocalMentionBotsNotInChatMessage$1 extends Lambda implements Function1<CreateLocalMentionBotsNotInChatMessageResponse, MentionBotLocalMessageCreateResult> {
    public static final ImSdkMessageServiceImplV2$createLocalMentionBotsNotInChatMessage$1 INSTANCE = null;

    static {
        INSTANCE = new ImSdkMessageServiceImplV2$createLocalMentionBotsNotInChatMessage$1();
    }

    public ImSdkMessageServiceImplV2$createLocalMentionBotsNotInChatMessage$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((CreateLocalMentionBotsNotInChatMessageResponse) r1);
    }

    public final MentionBotLocalMessageCreateResult invoke(CreateLocalMentionBotsNotInChatMessageResponse r1) {
        return MentionBotLocalMessageCreateResult.a.a;
    }
}
