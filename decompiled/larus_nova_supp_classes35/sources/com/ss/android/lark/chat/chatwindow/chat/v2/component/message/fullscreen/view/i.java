package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements com.ss.android.lark.coremd.base.parse.g {
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c a;
    public final RichText b;
    public final boolean c;

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r3) {
        Intrinsics.checkNotNullParameter(r3, "registry");
        r3.a(eab.a.class, new b(this));
        r3.a(v7b.n.class, new c(this));
        r3.a(v7b.g.class, new d(this));
        r3.a(eab.g.class, new e(this));
        r3.a(eab.h.class, new f(this));
        r3.a(v7b.l.class, new g(this));
        r3.a(eab.f.class, new h(this));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void c(com.ss.android.lark.coremd.impl.parse.j.a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }

    public i(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c r2, RichText r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "clickContext");
        Intrinsics.checkNotNullParameter(r3, "richText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
