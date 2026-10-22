package com.ss.android.lark.chat.chatwindow.biz.plugin.core;

import com.ss.android.lark.chat.plugin.adapter.ChatPluginFactoryAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public final f a;
    public boolean b;
    public boolean c;
    public final ArrayList<d> d;
    public i7b.a e;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        i7b.a r1 = this.e;
        if (r1 != null) goto L9;
        return;
    L9:
        if (this.c == false) goto L11;
        return;
    L11:
        Iterator<d> r2 = this.d.iterator();
    L13:
        if (r2.hasNext() == false) goto L15;
        r2.next().c(r0, r1);
        goto L13
    L15:
        this.c = true;
    }

    public b(ChatPluginFactoryAdapter.b r2) {
        Intrinsics.checkNotNullParameter(r2, "factoryProvider");
        this.a = r2;
        this.d = new ArrayList(20);
    }
}
