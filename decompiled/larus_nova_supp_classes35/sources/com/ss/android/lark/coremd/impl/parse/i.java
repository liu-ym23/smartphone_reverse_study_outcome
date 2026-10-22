package com.ss.android.lark.coremd.impl.parse;

import android.content.Context;
import com.ss.android.lark.coremd.base.parse.o;
import com.ss.android.lark.coremd.base.parse.p;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i<T extends s> implements o<T>, com.ss.android.lark.coremd.base.parse.i {
    public final com.ss.android.lark.coremd.base.parse.i c;
    public final T d;

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b b(com.ss.android.lark.coremd.base.parse.b r2) {
        Intrinsics.checkNotNullParameter(r2, "that");
        return this.c.b(r2);
    }

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b clone() {
        return this.c.clone();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.m d() {
        return this.c.d();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final p f() {
        return this.c.f();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.n g() {
        return this.c.g();
    }

    @Override // com.ss.android.lark.coremd.base.parse.o, com.ss.android.lark.coremd.base.parse.i
    public Context getContext() {
        return this.c.getContext();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.j getTheme() {
        return this.c.getTheme();
    }

    @Override // com.ss.android.lark.coremd.ext.j
    public final Map<Object, Object> getValues() {
        return this.c.getValues();
    }

    public final m c() {
        int r0 = m.b;
        return m.a.a(this, this.d);
    }

    @Override // com.ss.android.lark.coremd.base.parse.o
    public final T getNode() {
        return this.d;
    }

    public i(com.ss.android.lark.coremd.base.parse.i r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "parseContext");
        Intrinsics.checkNotNullParameter(r3, "node");
        this.c = r2;
        this.d = r3;
    }
}
