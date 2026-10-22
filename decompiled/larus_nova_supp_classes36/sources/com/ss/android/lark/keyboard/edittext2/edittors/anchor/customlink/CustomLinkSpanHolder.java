package com.ss.android.lark.keyboard.edittext2.edittors.anchor.customlink;

import com.ss.android.lark.widget.light.span.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CustomLinkSpanHolder extends fob.b<hob.a> {
    public final hob.a b;
    public final Lazy c;

    @Override // fob.b
    public final Object e() {
        return (h) this.c.getValue();
    }

    public CustomLinkSpanHolder(hob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorInfo");
        this.b = r2;
        a(new AnonymousClass1(this));
        this.c = LazyKt.lazy(CustomLinkSpanHolder$extraSpan$2.INSTANCE);
    }
}
