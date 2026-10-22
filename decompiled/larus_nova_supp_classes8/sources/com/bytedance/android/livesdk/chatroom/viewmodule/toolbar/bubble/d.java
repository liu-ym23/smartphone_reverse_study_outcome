package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ BubbleController a;

    public d(BubbleController r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        g.b r6 = (g.b) r5;
        Iterator<T> r0 = this.a.a().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        T r1 = r0.next();
        if (((h) r1).T8().getId() != r6.b()) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        h r3 = (h) r1;
        if (r3 == null) goto L25;
        i r7 = r3.T8();
        if (r7 == null) goto L26;
        i.a r4 = r7.getCallback();
        if (r4 == null) goto L27;
        r4.b(r7);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }
}
