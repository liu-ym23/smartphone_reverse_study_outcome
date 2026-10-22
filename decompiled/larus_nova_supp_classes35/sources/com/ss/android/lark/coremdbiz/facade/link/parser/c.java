package com.ss.android.lark.coremdbiz.facade.link.parser;

import android.text.Spanned;
import com.ss.android.lark.coremd.base.parse.r;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements b {
    public final Map<Class<? extends dab.a>, b.a<dab.a>> a;

    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b
    public final void a() {
        ((LinkedHashMap) this.a).clear();
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public c() {
        this.a = new LinkedHashMap();
    }

    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b
    public final void c(b.a<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "strategy");
        this.a.put((Class<? extends dab.a>) r3.getType(), (b.a<dab.a>) r3);
    }

    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b
    public final Spanned b(r<n> r3, dab.a r4) {
        Intrinsics.checkNotNullParameter(r3, "visitContext");
        Intrinsics.checkNotNullParameter(r4, "info");
        Class<?> r0 = r4.getClass();
        b.a r1 = (b.a) ((LinkedHashMap) this.a).get(r0);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.a(r3, r4);
    }
}
