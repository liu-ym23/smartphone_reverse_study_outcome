package u2b;

import com.ss.android.lark.chat.base.view.vo.message.StickerContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements y6b.d<StickerContentVO> {
    public p() {
    }

    @Override // y6b.d
    public final Message.Type a() {
        return Message.Type.STICKER;
    }

    @Override // y6b.d
    public final CharSequence b(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return d(r2);
    }

    @Override // y6b.d
    public final CharSequence d(f5b.b r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        Message r3 = r2.getMessage();
        if (r3 != null) goto L7;
        return UIHelper.getString(2131892241);
    L7:
        return com.ss.android.lark.chat.utils.n.a((StickerContent) r3.getContent());
    }

    @Override // y6b.d
    public final v5b.a c(v r2, f5b.b r3) {
        Intrinsics.checkNotNullParameter(r2, "containerOwner");
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        Message r4 = r3.getMessage();
        StickerContentVO r0 = new StickerContentVO((StickerContent) r4.getContent());
        r0.h = r4;
        return r0;
    }
}
