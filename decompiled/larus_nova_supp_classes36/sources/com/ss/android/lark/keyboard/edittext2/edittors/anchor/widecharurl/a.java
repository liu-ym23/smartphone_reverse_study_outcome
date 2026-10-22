package com.ss.android.lark.keyboard.edittext2.edittors.anchor.widecharurl;

import android.text.Spannable;
import com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.UrlInlinePreviewConfig;
import com.ss.android.lark.widget.richtext.RichTextElement;
import fob.f;
import hob.j;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a implements fob.d<j> {
    public final UrlInlinePreviewConfig a;
    public final Class<j> b;

    @Override // fob.d
    public Class<j> getType() {
        return this.b;
    }

    public a(UrlInlinePreviewConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "urlPreviewConfig");
        this.a = r2;
        this.b = j.class;
    }

    @Override // fob.d
    public final fob.c<Spannable, List<f.b<j>>> a(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        return new d(this, r2);
    }

    @Override // fob.d
    public final fob.c<RichTextElement.AnchorProperty, j> b(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        return new com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.a(r2);
    }

    @Override // fob.d
    public final fob.b c(eob.a r2, hob.b r3) {
        j r4 = (j) r3;
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r4, "data");
        return new b(r4, this.a);
    }
}
