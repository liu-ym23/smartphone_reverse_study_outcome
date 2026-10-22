package com.ss.android.lark.keyboard.edittext2.edittors.anchor.possiblelink;

import com.ss.android.lark.widget.richtext.RichTextElement;
import hob.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends fob.a<h> {
    public a(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        super(r2);
    }

    @Override // fob.a
    public final boolean a(RichTextElement.AnchorProperty r2) {
        Intrinsics.checkNotNullParameter(r2, "property");
        if (r2.getScene() != RichTextElement.AnchorProperty.Scene.COPY_PASTE_TEXT) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // fob.a
    public final hob.b b(RichTextElement.AnchorProperty r2) {
        Intrinsics.checkNotNullParameter(r2, "property");
        return new h(r2.getHref());
    }
}
