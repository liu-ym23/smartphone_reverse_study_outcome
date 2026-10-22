package com.ss.android.lark.richtextmd.parse;

import b3c.d;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.richtextmd.parse.ext.b;
import com.ss.android.lark.richtextmd.parse.impl.RichTextTagHandlers;
import com.ss.android.lark.richtextmd.parse.impl.TableRichTextTagHandler;
import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/richtextmd/parse/DefaultRichTextToMarkdownConfig;", "Lcom/ss/android/lark/richtextmd/parse/ext/RichTextToMarkdownConfig;", "<init>", "()V", "configure", "", "generator", "Lcom/ss/android/lark/richtextmd/parse/base/RichTextToNodeGenerator;", "Companion", "richtext_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class DefaultRichTextToMarkdownConfig implements b {
    public static final a a = null;

    public static final class a extends DefaultRichTextToMarkdownConfig {
        public a(int r1) {
        }
    }

    static {
        a = new a(0);
    }

    public DefaultRichTextToMarkdownConfig() {
    }

    @Override // com.ss.android.lark.richtextmd.parse.ext.b
    public void a(d r3) {
        Intrinsics.checkNotNullParameter(r3, "generator");
        Lazy r0 = RichTextTagHandlers.a;
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.PARAGRAPH, (RichTextTagHandlers.s) RichTextTagHandlers.a.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.TEXT, (RichTextTagHandlers.t) RichTextTagHandlers.b.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.ANCHOR, (RichTextTagHandlers.AnchorTagHandler) RichTextTagHandlers.d.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.IMG, (RichTextTagHandlers.ImageTagHandler) RichTextTagHandlers.f.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.H1, (RichTextTagHandlers.g) RichTextTagHandlers.g.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.H2, (RichTextTagHandlers.h) RichTextTagHandlers.h.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.H3, (RichTextTagHandlers.i) RichTextTagHandlers.i.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.H4, (RichTextTagHandlers.j) RichTextTagHandlers.j.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.H5, (RichTextTagHandlers.k) RichTextTagHandlers.k.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.H6, (RichTextTagHandlers.l) RichTextTagHandlers.l.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.HR, (RichTextTagHandlers.m) RichTextTagHandlers.m.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.CODE, (RichTextTagHandlers.e) RichTextTagHandlers.r.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.CODE_BLOCK_V2, (RichTextTagHandlers.CodeBlockTagHandler) RichTextTagHandlers.s.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.UL, (RichTextTagHandlers.d) RichTextTagHandlers.o.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.OL, (RichTextTagHandlers.r) RichTextTagHandlers.p.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.LI, (RichTextTagHandlers.o) RichTextTagHandlers.q.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.QUOTE, (RichTextTagHandlers.c) RichTextTagHandlers.n.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.EMOTION, (RichTextTagHandlers.f) RichTextTagHandlers.c.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.AT, (RichTextTagHandlers.a) RichTextTagHandlers.e.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.AT_USER_GROUP, (RichTextTagHandlers.b) RichTextTagHandlers.t.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.TABLE, (TableRichTextTagHandler) RichTextTagHandlers.u.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.MEDIA, (RichTextTagHandlers.q) RichTextTagHandlers.w.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.MARKDOWN, (RichTextTagHandlers.p) RichTextTagHandlers.x.getValue());
    }
}
