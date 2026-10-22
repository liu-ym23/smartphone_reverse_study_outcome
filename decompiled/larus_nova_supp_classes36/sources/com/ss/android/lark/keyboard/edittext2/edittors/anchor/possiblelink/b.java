package com.ss.android.lark.keyboard.edittext2.edittors.anchor.possiblelink;

import android.text.Spannable;
import com.ss.android.lark.widget.richtext.RichTextElement;
import fob.c;
import fob.d;
import fob.e;
import fob.f;
import hob.h;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements d<h> {
    public static final b a = null;
    public static final Class<h> b = null;

    public b() {
    }

    static {
        a = new b();
        b = h.class;
    }

    @Override // fob.d
    public Class<h> getType() {
        return b;
    }

    @Override // fob.d
    public final c<Spannable, List<f.b<h>>> a(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        int r3 = f.b;
        return new e();
    }

    @Override // fob.d
    public final c<RichTextElement.AnchorProperty, h> b(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        return new a(r2);
    }

    @Override // fob.d
    public final fob.b c(eob.a r2, hob.b r3) {
        h r4 = (h) r3;
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r4, "data");
        return new PossibleLinkSpanHolder(r4);
    }
}
