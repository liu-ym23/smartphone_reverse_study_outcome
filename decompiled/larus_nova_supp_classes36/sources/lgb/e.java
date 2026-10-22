package lgb;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.flow.chat.message.downgrade.data.LarkDowngradeTodoContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements y6b.d<mgb.b> {
    public e() {
    }

    public final Message.Type a() {
        return Message.Type.TODO;
    }

    public final CharSequence b(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return d(r2);
    }

    public final CharSequence d(f5b.b r3) {
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        Content r4 = r3.getMessage().getContent();
        String r1 = null;
        if ((r4 instanceof LarkDowngradeTodoContent) == false) goto L5;
        LarkDowngradeTodoContent r5 = (LarkDowngradeTodoContent) r4;
    L6:
        if (r5 == null) goto L8;
        r1 = r5.getTitle();
    L8:
        if (r1 != null) goto L11;
        return "";
    L11:
        return r1;
    L5:
        r5 = null;
        goto L6
    }

    public final v5b.a c(v r2, f5b.b r3) {
        Intrinsics.checkNotNullParameter(r2, "containerOwner");
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        Content r4 = r3.getMessage().getContent();
        if ((r4 instanceof LarkDowngradeTodoContent) == false) goto L5;
        LarkDowngradeTodoContent r5 = (LarkDowngradeTodoContent) r4;
    L6:
        if (r5 != null) goto L9;
        return null;
    L9:
        return new mgb.b(r5);
    L5:
        r5 = null;
        goto L6
    }
}
