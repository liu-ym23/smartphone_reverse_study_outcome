package com.ss.android.lark.keyboard.edittext2.edittors.anchor.widecharurl;

import com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.UrlInlinePreviewConfig;
import hob.j;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.d {
    public static final /* synthetic */ int e = 0;

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.d
    public final void j() {
        if (Intrinsics.areEqual(((HashMap) this.b.c).get("key::use::wide::character:regex"), Boolean.TRUE) == false) goto L6;
        a(new DegradableUrlInlineSpanHolder$preparePossibleAnchorSpan$1(this));
        return;
    }

    public b(j r2, UrlInlinePreviewConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "anchorInfo");
        Intrinsics.checkNotNullParameter(r3, "urlPreviewConfig");
        super(r2, r3);
    }
}
