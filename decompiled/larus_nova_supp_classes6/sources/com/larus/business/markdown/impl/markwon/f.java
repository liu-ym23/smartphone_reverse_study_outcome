package com.larus.business.markdown.impl.markwon;

import android.view.View;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class f implements lsc.d {
    public final /* synthetic */ MarkwonStruct a;

    public /* synthetic */ f(MarkwonStruct r1) {
        this.a = r1;
    }

    public final void d(View r3, String r4) {
        MarkwonStruct r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "link");
        Function3 r1 = (Function3) r0.k.getValue();
        if (r1 == null) goto L6;
        r1.invoke(r3, r4, Boolean.FALSE);
        return;
    }
}
