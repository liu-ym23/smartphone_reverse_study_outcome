package com.bytedance.android.livesdk.interactivity.square.common.common;

import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l;
import com.bytedance.android.livesdk.interactivity.square.plugin.SquareModelSpanClickListener;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tb2.b;
import tb2.e;
import tb2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class CommonModelSpanClickListener implements l {
    public final Function2<View, e, Boolean> a;

    public CommonModelSpanClickListener() {
        CommonModelSpanClickListener$userSpanListener$1 r0 = CommonModelSpanClickListener$userSpanListener$1.INSTANCE;
        this.a = CommonModelSpanClickListener$schemaSpanListener$1.INSTANCE;
        CommonModelSpanClickListener$viewClickListener$1 r1 = CommonModelSpanClickListener$viewClickListener$1.INSTANCE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l
    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        ((SquareModelSpanClickListener) this).c.invoke(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l
    public final boolean b(View r2, b r3, ClickableSpan r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "span");
        if ((r3 instanceof g) == false) goto L6;
        return ((Boolean) ((SquareModelSpanClickListener) this).b.invoke(r2, r3)).booleanValue();
    L6:
        if ((r3 instanceof e) == true) goto L11;
        return false;
    L11:
        return ((Boolean) this.a.invoke(r2, r3)).booleanValue();
    }
}
