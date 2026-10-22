package com.ss.android.lark.keyboard.edittext2.edittors.anchor.paste;

import com.ss.android.lark.widget.richtext.RichTextElement;
import hob.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends fob.a<j> {
    public a(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        super(r2);
    }

    @Override // fob.a
    public final boolean a(RichTextElement.AnchorProperty r4) {
        Intrinsics.checkNotNullParameter(r4, "property");
        if (r4.getHref().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L13:
        return false;
    L8:
        if (r4.getContent().length() <= 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L13;
        return true;
    L10:
        r5 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    @Override // fob.a
    public final hob.b b(RichTextElement.AnchorProperty r3) {
        Intrinsics.checkNotNullParameter(r3, "property");
        j r0 = new j(r3.getHref());
        String r4 = r3.getContent();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.e = r4;
        return r0;
    }
}
