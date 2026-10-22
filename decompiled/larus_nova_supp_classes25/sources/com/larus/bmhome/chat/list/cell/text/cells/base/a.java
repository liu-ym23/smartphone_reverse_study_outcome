package com.larus.bmhome.chat.list.cell.text.cells.base;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class a extends xc8.b {
    public final c e;

    public c i() {
        return this.e;
    }

    public a(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        super(r4);
        this.e = new c(null, 0, 0, 63);
    }

    @Override // xc8.b
    public boolean c(wq8.a r5) {
        Intrinsics.checkNotNullParameter(r5, "newItem");
        if (Intrinsics.areEqual(getClass(), r5.getClass()) == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(getMessage().getLocalMessageId(), r5.getMessage().getLocalMessageId()) == true) goto L7;
        return false;
    L7:
        if ((r5 instanceof a) == false) goto L14;
        a r6 = (a) r5;
        if (i().a != r6.i().a) goto L14;
        if (i().b != r6.i().b) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L20;
        return true;
    L20:
        return false;
    L14:
        r7 = false;
        goto L15
    }
}
