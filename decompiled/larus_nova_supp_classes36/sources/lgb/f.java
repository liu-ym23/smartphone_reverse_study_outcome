package lgb;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.flow.chat.message.downgrade.data.LarkDowngradeVideoChatContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements y6b.d<mgb.c> {
    public f() {
    }

    public final Message.Type a() {
        return Message.Type.VIDEO_CHAT;
    }

    public final CharSequence b(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return d(r2);
    }

    public final CharSequence d(f5b.b r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return ((LarkDowngradeVideoChatContent) r2.getMessage().getContent()).getTitle();
    }

    public final v5b.a c(v r2, f5b.b r3) {
        Intrinsics.checkNotNullParameter(r2, "containerOwner");
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        return new mgb.c((LarkDowngradeVideoChatContent) r3.getMessage().getContent());
    }
}
