package u2b;

import com.ss.android.lark.chat.base.view.vo.message.ShareGroupChatContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements y6b.d<ShareGroupChatContentVO> {
    public n() {
    }

    @Override // y6b.d
    public final Message.Type a() {
        return Message.Type.SHARE_GROUP_CHAT;
    }

    @Override // y6b.d
    public final CharSequence b(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return d(r2);
    }

    @Override // y6b.d
    public final CharSequence d(f5b.b r3) {
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        ShareGroupChatContent r4 = (ShareGroupChatContent) r3.getMessage().getContent();
        if (r4.getChat() == null) goto L5;
        Chat r5 = r4.getChat();
        Intrinsics.checkNotNull(r5);
        String r6 = UIHelper.mustacheFormat(2131892219, "chat_name", r5.getName());
        Intrinsics.checkNotNull(r6);
        return r6;
    L5:
        return BuildConfig.FLAVOR;
    }

    @Override // y6b.d
    public final v5b.a c(v r2, f5b.b r3) {
        Intrinsics.checkNotNullParameter(r2, "containerOwner");
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        return new ShareGroupChatContentVO((ShareGroupChatContent) r3.getMessage().getContent());
    }
}
