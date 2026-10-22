package com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2;

import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.a {
    public d(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        super(r2);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.a, fob.a
    public final /* bridge */ /* synthetic */ hob.b b(RichTextElement.AnchorProperty r1) {
        return c(r1);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.a
    public final hob.j c(RichTextElement.AnchorProperty r4) {
        Intrinsics.checkNotNullParameter(r4, "property");
        hob.j r0 = super.c(r4);
        if (r4.getScene() != RichTextElement.AnchorProperty.Scene.COPY_PASTE_TEXT) goto L5;
        Map<String, Object> r5 = r0.c;
        HashMap r6 = (HashMap) r5;
        r6.put("key::use::wide::character:regex", Boolean.TRUE);
    L5:
        return r0;
    }
}
