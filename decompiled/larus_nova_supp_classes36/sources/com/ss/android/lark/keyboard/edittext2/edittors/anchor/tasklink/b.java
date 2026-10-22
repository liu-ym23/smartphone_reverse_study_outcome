package com.ss.android.lark.keyboard.edittext2.edittors.anchor.tasklink;

import android.text.Spannable;
import com.ss.android.lark.widget.richtext.RichTextElement;
import fob.d;
import fob.f;
import hob.i;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements d<i> {
    public static final b a = null;
    public static final Class<i> b = null;

    public b() {
    }

    static {
        a = new b();
        b = i.class;
    }

    @Override // fob.d
    public Class<i> getType() {
        return b;
    }

    @Override // fob.d
    public final fob.c<Spannable, List<f.b<i>>> a(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        return new c(this, r2);
    }

    @Override // fob.d
    public final fob.c<RichTextElement.AnchorProperty, i> b(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        return new a(r2);
    }

    @Override // fob.d
    public final fob.b c(eob.a r2, hob.b r3) {
        i r4 = (i) r3;
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r4, "data");
        return new TaskLinkSpanHolder(r4);
    }
}
