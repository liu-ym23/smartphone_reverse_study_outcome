package t2b;

import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.log.Log;
import java.util.Objects;
import y6b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements com.ss.android.lark.chatwindow.view.tip.a.b<c> {
    public a() {
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a.b
    public final int b(c r6) {
        c r7 = r6;
        MessageFoldDetail r0 = r7.G;
        if (r0 == null) goto L6;
        return (int) Math.max(r7.p, r0.getLastMessageBadgeCount());
    L6:
        return r7.p;
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a.b
    public final boolean a(MessageInfo r6, c r7) {
        c r8 = r7;
        if (Objects.equals(r8.c, r6.getId()) == true) goto L16;
        MessageFoldDetail r0 = r8.G;
        if (r0 == null) goto L11;
        int r9 = r8.n;
        int r1 = (int) r0.getLastMessagePosition();
        int r3 = r6.getMessage().getPosition();
        if (r9 > r3) goto L11;
        if (r3 > r1) goto L11;
        Log.i("ChatBadgeProvider", "isMessageInFoldInterval: message: " + r6.getMessage().getId() + "pos: " + r6.getMessage().getPosition() + " is in fold interval: [" + r9 + "," + r1 + "]");
        boolean r10 = true;
    L12:
        if (r10 == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        r10 = false;
        goto L12
    L16:
        return true;
    }
}
