package z2c;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import kotlin.jvm.internal.Intrinsics;
import y6b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements com.ss.android.lark.chatwindow.view.tip.a.b<c<?>> {
    public a() {
    }

    public final int b(Object r2) {
        c r3 = (c) r2;
        if (r3 != null) goto L5;
    L8:
        return -1;
    L5:
        if (r3.isPreMessage() == true) goto L8;
        return r3.X2;
    }

    public final boolean a(MessageInfo r1, Object r2) {
        c r3 = (c) r2;
        if (r1 == null) goto L7;
        if (r3 == null) goto L7;
        return Intrinsics.areEqual(r1.getId(), r3.c);
    L7:
        return false;
    }
}
