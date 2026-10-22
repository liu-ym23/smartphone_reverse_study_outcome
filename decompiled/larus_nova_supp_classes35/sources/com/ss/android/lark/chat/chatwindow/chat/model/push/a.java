package com.ss.android.lark.chat.chatwindow.chat.model.push;

import com.larksuite.framework.utils.AndroidThrottle;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements AndroidThrottle.d<Chat> {
    public Chat a;

    public a() {
    }

    public final void clear() {
        this.a = null;
    }

    public final Collection<Chat> a() {
        ArrayList r0 = new ArrayList();
        Chat r1 = this.a;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        return r0;
    }

    public final int size() {
        if (this.a == null) goto L5;
        return 1;
    L5:
        return 0;
    }

    public final void put(Object r1) {
        Chat r2 = (Chat) r1;
        if (r2 == null) goto L7;
        this.a = r2;
        return;
    }
}
