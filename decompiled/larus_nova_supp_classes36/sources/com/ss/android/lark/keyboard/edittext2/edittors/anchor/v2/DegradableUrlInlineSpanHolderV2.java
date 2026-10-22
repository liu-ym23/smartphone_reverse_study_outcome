package com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2;

import com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.UrlInlinePreviewConfig;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DegradableUrlInlineSpanHolderV2 extends com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.d {
    public static final /* synthetic */ int g = 0;
    public final boolean e;
    public final Lazy f;

    @Override // fob.b
    public final Object e() {
        return (com.ss.android.lark.widget.light.span.h) this.f.getValue();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.d
    public final void j() {
        a(new DegradableUrlInlineSpanHolderV2$prepareAnchorSpan$1(this));
    }

    public DegradableUrlInlineSpanHolderV2(hob.j r2, UrlInlinePreviewConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "anchorInfo");
        Intrinsics.checkNotNullParameter(r3, "urlPreviewConfig");
        super(r2, r3);
        this.e = Intrinsics.areEqual(((HashMap) r2.c).get("key::use::wide::character:regex"), Boolean.TRUE);
        this.f = LazyKt.lazy(new DegradableUrlInlineSpanHolderV2$extraSpan$2(this));
    }
}
