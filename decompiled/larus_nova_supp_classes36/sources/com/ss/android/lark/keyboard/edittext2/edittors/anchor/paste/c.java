package com.ss.android.lark.keyboard.edittext2.edittors.anchor.paste;

import android.text.Spannable;
import com.ss.android.lark.widget.richtext.RichTextElement;
import fob.d;
import fob.e;
import fob.f;
import hob.j;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements d<j> {
    public static final c a = null;
    public static final Class<j> b = null;

    public c() {
    }

    static {
        a = new c();
        b = j.class;
    }

    @Override // fob.d
    public Class<j> getType() {
        return b;
    }

    @Override // fob.d
    public final fob.c<Spannable, List<f.b<j>>> a(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        int r3 = f.b;
        return new e();
    }

    @Override // fob.d
    public final fob.c<RichTextElement.AnchorProperty, j> b(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        return new a(r2);
    }

    @Override // fob.d
    public final fob.b c(eob.a r2, hob.b r3) {
        j r4 = (j) r3;
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r4, "data");
        return new b(r4);
    }
}
