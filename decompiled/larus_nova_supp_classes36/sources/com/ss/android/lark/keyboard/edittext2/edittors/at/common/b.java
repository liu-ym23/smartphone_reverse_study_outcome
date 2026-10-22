package com.ss.android.lark.keyboard.edittext2.edittors.at.common;

import com.ss.android.lark.keyboard.edittext2.edittors.at.c;
import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class b implements c<hob.c> {
    public final Class<hob.c> a;
    public com.ss.android.lark.keyboard.edittext2.base.b b;

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final com.ss.android.lark.keyboard.edittext2.base.b getTarget() {
        com.ss.android.lark.keyboard.edittext2.base.b r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("target");
        return null;
    }

    public b() {
        this.a = hob.c.class;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public Class<hob.c> getType() {
        return this.a;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void A(com.ss.android.lark.keyboard.edittext2.base.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void G(com.ss.android.lark.keyboard.edittext2.base.a r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        Intrinsics.checkNotNullParameter(r2, "origin");
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public com.ss.android.lark.keyboard.edittext2.edittors.at.a<hob.c> c(com.ss.android.lark.keyboard.edittext2.edittors.a r2, hob.c r3) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r3, "data");
        return new InitCommonAtSpanHolder(r2, r3);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public fob.c.a<hob.c> k(com.ss.android.lark.keyboard.edittext2.edittors.a r2, RichTextElement.AtProperty r3) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r3, "property");
        int r4 = hob.c.k;
        return new fob.c.a(true, hob.c.a.a(r3));
    }
}
