package u2b;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.FolderContent;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements y6b.d<com.ss.android.lark.chat.base.view.vo.message.a> {
    public g() {
    }

    @Override // y6b.d
    public final Message.Type a() {
        return Message.Type.FOLDER;
    }

    @Override // y6b.d
    public final CharSequence b(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return d(r2);
    }

    @Override // y6b.d
    public final CharSequence d(f5b.b r3) {
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        return UIHelper.getString(2131891743) + ((FolderContent) r3.getMessage().getContent()).getName();
    }

    @Override // y6b.d
    public final v5b.a c(v r2, f5b.b r3) {
        Intrinsics.checkNotNullParameter(r2, "containerOwner");
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        Message r4 = r3.getMessage();
        com.ss.android.lark.chat.base.view.vo.message.a r0 = new com.ss.android.lark.chat.base.view.vo.message.a((FolderContent) r4.getContent());
        r0.n = r4.isSourceFileDelete();
        r0.o = r4.getSourceId();
        r0.p = r4.getSourceType();
        Message.FileDeletedStatus r5 = r4.getFileDeletedStatus();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.q = r5;
        return r0;
    }
}
