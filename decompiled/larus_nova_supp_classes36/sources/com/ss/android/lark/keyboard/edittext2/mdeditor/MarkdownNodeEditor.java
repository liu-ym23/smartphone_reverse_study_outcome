package com.ss.android.lark.keyboard.edittext2.mdeditor;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.coremd.base.parse.b;
import com.ss.android.lark.coremd.base.parse.f;
import com.ss.android.lark.coremd.base.parse.g;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.ext.l;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.keyboard.edittext2.base.c;
import com.ss.android.lark.keyboard.edittext2.base.d;
import com.ss.android.lark.keyboard.edittext2.mdeditor.plugins.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t9b.e;
import v7b.n;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MarkdownNodeEditor extends BaseFunctionEditor<s> implements c {
    public static final a g = null;
    public b c;
    public List<? extends g> d;
    public List<? extends f> e;
    public j f;

    public static final class a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a<MarkdownNodeEditor> {
        public final /* synthetic */ d a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a
        public final Class<MarkdownNodeEditor> a() {
            return this.a.a;
        }

        public a() {
            this.a = new d(MarkdownNodeEditor.class);
        }
    }

    static {
        g = new a();
    }

    public final Function1<n, CharSequence> U() {
        return new MarkdownNodeEditor$asLinkParser$1(this);
    }

    public MarkdownNodeEditor() {
        this.c = new com.ss.android.lark.coremd.impl.parse.a();
        Intrinsics.checkNotNullParameter(t9b.d.a, "<this>");
        this.d = CollectionsKt.listOf(i.a);
        this.e = new ArrayList();
        e r0 = e.a;
        this.f = com.ss.android.lark.keyboard.edittext2.mdeditor.config.a.b();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor, com.ss.android.lark.keyboard.edittext2.base.a
    public final void G(com.ss.android.lark.keyboard.edittext2.base.a r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        MarkdownNodeEditor r3 = (MarkdownNodeEditor) r2;
        this.d = r3.d;
        this.c = r3.c;
        this.e = r3.e;
        this.f = r3.f;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void S(SpannableStringBuilder r4, s r5, int r6) {
        s r7 = r5;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r7, "data");
        b r0 = this.c.b(com.ss.android.lark.coremd.base.parse.c.a(LarkContextExtend.s, new MarkdownNodeEditor$onInsert$context$1(this)));
        t9b.b r1 = t9b.b.a;
        com.ss.android.lark.coremd.impl.parse.b.a r2 = t9b.b.a(context());
        l.b(r2, this.d);
        r2.c(this.f);
        l.a(r2, this.e);
        Spannable r8 = (Spannable) r2.a(r7, r0);
        List<String> r3 = com.ss.android.lark.keyboard.edittext2.utils.b.a;
        com.ss.android.lark.keyboard.edittext2.utils.b.d(r8, 0, r8.length());
        r4.insert(r6, r8);
    }
}
