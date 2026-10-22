package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c0 {
    public final List<a> a;

    public interface a {
        void register();

        void unRegister();
    }

    public final void b() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).register();
        goto L4
    }

    public final void c() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).unRegister();
        goto L4
    }

    public c0() {
        this.a = new ArrayList();
    }

    public final void a(a r2) {
        ((ArrayList) this.a).add(r2);
    }
}
