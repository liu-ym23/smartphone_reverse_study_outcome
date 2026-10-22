package com.ss.android.lark.coremd.impl.parse;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.coremd.base.parse.t;
import com.ss.android.lark.coremd.base.parse.u;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements u, f0 {
    public final Map<Class<?>, t<s>> a;
    public final d b;
    public final MarkdownSpanSetterImpl c;
    public boolean d;
    public final SpannableStringBuilder e;

    public static final class a {
        public final Map<Class<?>, t<s>> a;

        public a() {
            this.a = new LinkedHashMap();
        }

        public final a a(Class r2, t r3) {
            Intrinsics.checkNotNullParameter(r2, "node");
            Intrinsics.checkNotNullParameter(r3, "nodeHandler");
            this.a.put(r2, r3);
            return this;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.ss.android.lark.coremd.base.parse.u
    public final void b() {
        this.d = true;
    }

    @Override // com.ss.android.lark.coremd.base.parse.u, v7b.f0
    public final void a(s r10) {
        Intrinsics.checkNotNullParameter(r10, "node");
        if (this.d == false) goto L5;
        return;
    L5:
        List<com.ss.android.lark.coremd.base.parse.f> r0 = this.b.h;
        t<s> r1 = this.a.get(r10.getClass());
        n r7 = new n(r10, this.e, this.c, this.b);
        k r8 = new k(this.b, r10, this.c, this, r7);
        List<com.ss.android.lark.coremd.base.parse.f> r2 = r0;
        Iterator<T> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((com.ss.android.lark.coremd.base.parse.f) r3.next()).f(r8);
        goto L7
    L9:
        if (r1 == null) goto L11;
        r1.a(r8);
    L12:
        Iterator<T> r11 = r2.iterator();
    L14:
        if (r11.hasNext() == false) goto L16;
        ((com.ss.android.lark.coremd.base.parse.f) r11.next()).d(r8);
        goto L14
    L16:
        return;
    L11:
        c(r10);
        goto L12
    }

    @Override // com.ss.android.lark.coremd.base.parse.u
    public final void c(s r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        s r3 = r2.e;
    L3:
        if (r3 == null) goto L8;
        s r0 = r3.h;
        r3.c(this);
        if (this.d == true) goto L6;
        r3 = r0;
        goto L3
    L6:
        return;
    }

    public l(Map<Class<?>, t<s>> r3, d r4) {
        Intrinsics.checkNotNullParameter(r3, "visitHandlers");
        Intrinsics.checkNotNullParameter(r4, "parseContext");
        this.a = r3;
        this.b = r4;
        this.c = new MarkdownSpanSetterImpl(r4);
        SpannableStringBuilder r5 = new SpannableStringBuilder();
        r5.setSpan(r4.i, 0, 0, 18);
        this.e = r5;
    }
}
