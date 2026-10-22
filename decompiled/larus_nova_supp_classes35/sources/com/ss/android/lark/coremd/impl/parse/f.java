package com.ss.android.lark.coremd.impl.parse;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import com.ss.android.lark.coremd.base.parse.p;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements com.ss.android.lark.coremd.base.parse.n.a<s>, com.ss.android.lark.coremd.base.parse.i {
    public final /* synthetic */ com.ss.android.lark.coremd.base.parse.i c;
    public final s d;
    public final Context e;
    public final int f;
    public final int g;
    public final View h;
    public final Layout i;

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

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.j getTheme() {
        return this.c.getTheme();
    }

    @Override // com.ss.android.lark.coremd.ext.j
    public final Map<Object, Object> getValues() {
        return this.c.getValues();
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.a, com.ss.android.lark.coremd.base.parse.i
    public Context getContext() {
        return this.e;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.a
    public final int getEnd() {
        return this.g;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.a
    public final Layout getLayout() {
        return this.i;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.a
    public final s getNode() {
        return this.d;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.a
    public final int getStart() {
        return this.f;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.a
    public final View getView() {
        return this.h;
    }

    public f(com.ss.android.lark.coremd.base.parse.i r2, s r3, Context r4, int r5, int r6, View r7, Layout r8) {
        Intrinsics.checkNotNullParameter(r2, "parseContext");
        Intrinsics.checkNotNullParameter(r3, "node");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "layout");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
    }
}
