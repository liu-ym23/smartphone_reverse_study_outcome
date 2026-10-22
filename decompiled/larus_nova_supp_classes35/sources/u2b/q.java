package u2b;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q implements y6b.d<com.ss.android.lark.chat.base.view.vo.message.d> {
    public q() {
    }

    @Override // y6b.d
    public final CharSequence d(f5b.b r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return BuildConfig.FLAVOR;
    }

    @Override // y6b.d
    public final Message.Type a() {
        return Message.Type.SYSTEM;
    }

    @Override // y6b.d
    public final CharSequence b(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return BuildConfig.FLAVOR;
    }

    @Override // y6b.d
    public final v5b.a c(v r2, f5b.b r3) {
        Intrinsics.checkNotNullParameter(r2, "containerOwner");
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        return new com.ss.android.lark.chat.base.view.vo.message.d((SystemContent) r3.getMessage().getContent());
    }
}
