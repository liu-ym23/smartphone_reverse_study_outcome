package s2b;

import android.view.View;
import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q implements g2b.c {
    public final int a;
    public a1 b;
    public final com.ss.android.lark.chat.chatwindow.chat.a c;

    @Override // g2b.c
    public final int b() {
        com.ss.android.lark.chat.chatwindow.chat.a r0 = this.c;
        if (r0 != null) goto L5;
        return -1;
    L5:
        int r1 = r0.getItemCount() - 1;
    L6:
        if (r1 < 0) goto L23;
        y6b.c r2 = (y6b.c) this.c.getItem(r1);
        a1 r3 = this.b;
        if (r3 == null) goto L10;
        int r4 = r3.c(r2);
    L11:
        int r5 = this.a;
        if (r4 == r5) goto L13;
        MessageFoldDetail r6 = r2.G;
        if (r6 == null) goto L22;
        if (r5 < r6.getRootMessagePosition()) goto L22;
        if (this.a > r2.G.getLastMessagePosition()) goto L22;
        Log.i("MsgPosFinder", "getTargetItemPosition: find target position " + this.a + " in fold interval , return position " + r4);
        return r1;
    L22:
        r1 = r1 - 1;
        goto L6
    L13:
        return r1;
    L10:
        r4 = r2.n;
        goto L11
    L23:
        return -1;
    }

    @Override // g2b.c
    public final View a(View r1) {
        return com.ss.android.lark.chat.utils.p.a(r1);
    }

    public q(com.ss.android.lark.chat.chatwindow.chat.a r1, int r2) {
        this.a = r2;
        this.c = r1;
    }
}
