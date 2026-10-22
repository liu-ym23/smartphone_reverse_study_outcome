package com.ss.android.lark.coremd.impl.parse;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements com.ss.android.lark.coremd.base.parse.b {
    public final Map<Object, Object> c;

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b clone() {
        a r0 = new a();
        r0.c.putAll(this.c);
        return r0;
    }

    public a() {
        this.c = new LinkedHashMap();
    }

    @Override // com.ss.android.lark.coremd.ext.j
    public final Map<Object, Object> getValues() {
        return this.c;
    }

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b b(com.ss.android.lark.coremd.base.parse.b r4) {
        Intrinsics.checkNotNullParameter(r4, "that");
        a r0 = new a();
        r0.c.putAll(this.c);
        r0.c.putAll(r4.getValues());
        return r0;
    }
}
