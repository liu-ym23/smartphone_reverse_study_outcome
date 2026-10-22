package com.ss.android.lark.keyboard.edittext2.edittors.inlinecode;

import android.content.Context;
import com.ss.android.lark.widget.span.InlineCodeCenterSpan;
import com.ss.android.lark.widget.span.InlineCodeInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EditorInlineCodeCenterSpan extends InlineCodeCenterSpan {
    public final Context g;
    public final Lazy h;
    public final Lazy i;

    public EditorInlineCodeCenterSpan(Context r2, final InlineCodeInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "spanInfo");
        super(r2, r3);
        this.g = r2;
        LazyThreadSafetyMode r4 = LazyThreadSafetyMode.NONE;
        this.h = LazyKt.lazy(r4, new EditorInlineCodeCenterSpan$startSpan$2(this, r3));
        this.i = LazyKt.lazy(r4, new EditorInlineCodeCenterSpan$endSpan$2(this, r3));
    }
}
