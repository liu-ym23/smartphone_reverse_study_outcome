package com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2;

import android.text.Spannable;
import com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.UrlInlinePreviewConfig;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a implements fob.d<hob.j> {
    public final UrlInlinePreviewConfig a;
    public final Class<hob.j> b;

    public a() {
        int r0 = UrlInlinePreviewConfig.b;
        UrlInlinePreviewConfig r1 = UrlInlinePreviewConfig.a.a();
        Intrinsics.checkNotNullParameter(r1, "urlPreviewConfig");
        this.a = r1;
        this.b = hob.j.class;
    }

    @Override // fob.d
    public Class<hob.j> getType() {
        return this.b;
    }

    @Override // fob.d
    public final fob.c<Spannable, List<fob.f.b<hob.j>>> a(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        return new m(this, r2);
    }

    @Override // fob.d
    public final fob.c<RichTextElement.AnchorProperty, hob.j> b(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        return new d(r2);
    }

    @Override // fob.d
    public final fob.b c(eob.a r2, hob.b r3) {
        hob.j r4 = (hob.j) r3;
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r4, "data");
        return new DegradableUrlInlineSpanHolderV2(r4, this.a);
    }
}
