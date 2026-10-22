package u2b;

import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements y6b.d<MediaContentVO> {
    public k() {
    }

    @Override // y6b.d
    public final Message.Type a() {
        return Message.Type.MEDIA;
    }

    @Override // y6b.d
    public final CharSequence b(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return d(r2);
    }

    @Override // y6b.d
    public final CharSequence d(f5b.b r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return UIHelper.getString(2131891923);
    }

    @Override // y6b.d
    public final v5b.a c(v r2, f5b.b r3) {
        Intrinsics.checkNotNullParameter(r2, "containerOwner");
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        Message r4 = r3.getMessage();
        MediaContentVO r0 = new MediaContentVO((MediaContent) r4.getContent());
        r0.p = r4.isSourceFileDelete();
        r0.n = r4.getSourceId();
        r0.o = r4.getSourceType();
        Message.FileDeletedStatus r5 = r4.getFileDeletedStatus();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.q = r5;
        return r0;
    }
}
