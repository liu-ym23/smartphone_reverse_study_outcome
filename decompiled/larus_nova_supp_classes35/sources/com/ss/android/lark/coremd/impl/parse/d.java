package com.ss.android.lark.coremd.impl.parse;

import android.content.Context;
import com.ss.android.lark.coremd.base.parse.p;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements com.ss.android.lark.coremd.base.parse.i, com.ss.android.lark.coremd.base.parse.b {
    public final /* synthetic */ com.ss.android.lark.coremd.base.parse.b c;
    public final Context d;
    public final p e;
    public final g f;
    public final com.ss.android.lark.coremd.base.parse.j g;
    public final List<com.ss.android.lark.coremd.base.parse.f> h;
    public final e i;

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b b(com.ss.android.lark.coremd.base.parse.b r2) {
        Intrinsics.checkNotNullParameter(r2, "that");
        return this.c.b(r2);
    }

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b clone() {
        return this.c.clone();
    }

    @Override // com.ss.android.lark.coremd.ext.j
    public final Map<Object, Object> getValues() {
        return this.c.getValues();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.m d() {
        return this.i;
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final p f() {
        return this.e;
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.n g() {
        return this.f;
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public Context getContext() {
        return this.d;
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.j getTheme() {
        return this.g;
    }

    public d(com.ss.android.lark.coremd.base.parse.b r2, Context r3, j r4, g r5, com.ss.android.lark.coremd.base.parse.j r6, List r7) {
        Intrinsics.checkNotNullParameter(r2, "markdownContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "spanFactory");
        Intrinsics.checkNotNullParameter(r5, "clickRegistry");
        Intrinsics.checkNotNullParameter(r6, "theme");
        Intrinsics.checkNotNullParameter(r7, "parseListeners");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = new e();
    }
}
