package com.ss.android.lark.coremd.impl.parse;

import android.content.Context;
import com.ss.android.lark.coremd.base.parse.p;
import com.ss.android.lark.coremd.base.parse.r;
import com.ss.android.lark.coremd.base.parse.u;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements r<s>, com.ss.android.lark.coremd.base.parse.i {
    public final /* synthetic */ com.ss.android.lark.coremd.base.parse.i c;
    public final s d;
    public final MarkdownSpanSetterImpl e;
    public final u f;
    public final com.ss.android.lark.coremd.base.parse.s g;

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

    @Override // com.ss.android.lark.coremd.base.parse.r, com.ss.android.lark.coremd.base.parse.o, com.ss.android.lark.coremd.base.parse.i
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

    @Override // com.ss.android.lark.coremd.base.parse.r
    public final MarkdownSpanSetterImpl a() {
        return this.e;
    }

    @Override // com.ss.android.lark.coremd.base.parse.r
    public final com.ss.android.lark.coremd.base.parse.s getEditable() {
        return this.g;
    }

    @Override // com.ss.android.lark.coremd.base.parse.o
    public final s getNode() {
        return this.d;
    }

    public k(d r2, s r3, MarkdownSpanSetterImpl r4, u r5, n r6) {
        Intrinsics.checkNotNullParameter(r2, "parseContext");
        Intrinsics.checkNotNullParameter(r3, "node");
        Intrinsics.checkNotNullParameter(r4, "spanSetter");
        Intrinsics.checkNotNullParameter(r5, "visitor");
        Intrinsics.checkNotNullParameter(r6, "editable");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
    }
}
