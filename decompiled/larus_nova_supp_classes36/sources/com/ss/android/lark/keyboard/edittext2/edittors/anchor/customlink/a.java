package com.ss.android.lark.keyboard.edittext2.edittors.anchor.customlink;

import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends fob.a<hob.a> {
    public a(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        super(r2);
    }

    @Override // fob.a
    public final boolean a(RichTextElement.AnchorProperty r2) {
        Intrinsics.checkNotNullParameter(r2, "property");
        return r2.isCustom();
    }

    @Override // fob.a
    public final hob.b b(RichTextElement.AnchorProperty r4) {
        Intrinsics.checkNotNullParameter(r4, "property");
        String r0 = r4.getDisplayTitle();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        String r3 = r4.getDisplayTitle();
    L20:
        String r5 = r4.getHref();
        Intrinsics.checkNotNull(r3);
        return new hob.a(r5, r3);
    L11:
        String r6 = r4.getContent();
        if (r6 != null) goto L14;
    L17:
        if (r1 == true) goto L19;
        r3 = r4.getContent();
        goto L20
    L19:
        r3 = r4.getHref();
        goto L20
    L14:
        if (r6.length() == 0) goto L17;
        r1 = false;
        goto L17
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
