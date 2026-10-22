package com.ss.android.lark.richtextmd.parse.plugins;

import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkLinkThemeData;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import v7b.b0;
import v7b.q;
import v7b.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements com.ss.android.lark.coremd.base.parse.g {
    public static final Regex d = null;
    public final iec.g a;
    public final int b;
    public final float c;

    /* JADX INFO: renamed from: com.ss.android.lark.richtextmd.parse.plugins.a$a, reason: collision with other inner class name */
    public static final class C0131a {
    }

    static {
        d = new Regex("!\\[[^\\]\\n]*\\]\\([^\\n)]*\\)");
    }

    public a(iec.g r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a = r2;
        this.b = 30;
        this.c = 14.0f;
    }

    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(b0.class, new h(this));
        r3.a(eab.e.class, new i(this));
        r3.a(eab.a.class, new j());
        r3.a(eab.c.class, new k(this));
        r3.a(v7b.n.class, new l(this));
        r3.a(v7b.l.class, new m(this));
        r3.a(eab.f.class, new n(this));
        r3.a(v7b.g.class, new o(this));
        r3.a(eab.h.class, new p(this));
        r3.a(v.class, new c(this));
        r3.a(v7b.h.class, new d(this));
        r3.a(q.class, new e(this));
        r3.a(eab.b.class, new f());
        r3.a(v7b.d.class, new g(this));
    }

    public final void b(com.ss.android.lark.coremd.impl.parse.g r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }

    public final void c(com.ss.android.lark.coremd.impl.parse.j.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(v7b.h.class, new b());
    }

    public final void d(final com.ss.android.lark.coremd.impl.parse.c r6) {
        Intrinsics.checkNotNullParameter(r6, "registry");
        LarkLinkThemeData r0 = (LarkLinkThemeData) LarkThemeExtend.m.b(new RichTextDigestParsePlugin$configure$themeData$1(r6));
        int r1 = this.a.e.d;
        r0.i.setValue(r0, LarkLinkThemeData.n[2], Integer.valueOf(r1));
        r0.n(this.c);
        r0.k().c(com.ss.android.lark.coremdbiz.facade.link.parser.a.b);
        r0.k().c(com.ss.android.lark.coremdbiz.facade.link.parser.d.b);
        r6.b.add(new RichTextDigestParsePlugin$configure$1(this));
    }
}
