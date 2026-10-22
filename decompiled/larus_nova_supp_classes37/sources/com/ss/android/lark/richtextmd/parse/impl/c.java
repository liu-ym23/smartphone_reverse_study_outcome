package com.ss.android.lark.richtextmd.parse.impl;

import android.content.Context;
import com.ss.android.lark.coremd.utils.BISURelocator;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements b3c.b {
    public final Context a;
    public final RichTextElement b;
    public final BISURelocator c;
    public final RichTextExtraInfo d;
    public final b.C0130b e;
    public final /* synthetic */ Context f;
    public final /* synthetic */ b g;
    public final /* synthetic */ RichTextExtraInfo h;
    public final /* synthetic */ Map<String, RichTextElement> i;

    @Override // b3c.b
    public final RichTextExtraInfo b() {
        return this.d;
    }

    @Override // b3c.b
    public final b.C0130b c() {
        return this.e;
    }

    @Override // b3c.b
    public final BISURelocator d() {
        return this.c;
    }

    @Override // b3c.b
    public Context getContext() {
        return this.a;
    }

    @Override // b3c.b
    public final RichTextElement getElement() {
        return this.b;
    }

    @Override // b3c.b
    public final b3c.a a(RichTextElement.RichTextTag r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        return this.g.b.get(r2);
    }

    @Override // b3c.b
    public final c e(RichTextElement r8) {
        Intrinsics.checkNotNullParameter(r8, "child");
        b r4 = this.g;
        Context r2 = this.f;
        Map<String, RichTextElement> r6 = this.i;
        RichTextExtraInfo r5 = this.h;
        int r0 = b.f;
        r4.getClass();
        return new c(r2, r8, r4, r5, r6);
    }

    @Override // b3c.b
    public final RichTextElement getElementById(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        return this.i.get(r2);
    }

    public c(Context r1, RichTextElement r2, b r3, RichTextExtraInfo r4, Map r5) {
        this.f = r1;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.a = r1;
        this.b = r2;
        this.c = r3.d;
        this.d = r4;
        this.e = r3.e;
    }
}
