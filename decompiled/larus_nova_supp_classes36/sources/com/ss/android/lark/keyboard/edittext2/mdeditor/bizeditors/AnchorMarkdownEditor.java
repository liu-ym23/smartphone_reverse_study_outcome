package com.ss.android.lark.keyboard.edittext2.mdeditor.bizeditors;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.ss.android.lark.coremdbiz.facade.link.LinkType;
import com.ss.android.lark.keyboard.edittext2.mdeditor.MarkdownNodeEditor;
import hob.h;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AnchorMarkdownEditor extends eob.a {
    public AnchorMarkdownEditor() {
    }

    @Override // eob.a, com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final /* bridge */ /* synthetic */ void S(SpannableStringBuilder r1, hob.b r2, int r3) {
        W(r1, r2, r3);
    }

    @Override // eob.a
    public final void W(SpannableStringBuilder r3, hob.b r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "data");
        String r6 = r4.a;
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = LinkType.UrlInline;
        if ((r4 instanceof hob.a) == false) goto L6;
        r6 = ((hob.a) r4).d;
        r0.element = LinkType.CustomLink;
    L8:
        final n r1 = new n(r4.a, r6);
        LarkLinkExtend.f.b(new AnchorMarkdownEditor$onInsert$1(r1, r0));
        ((MarkdownNodeEditor) q(MarkdownNodeEditor.g)).R(r1, r3);
        return;
    L6:
        if ((r4 instanceof h) == false) goto L8;
        r0.element = LinkType.PossibleLink;
        goto L8
    }
}
