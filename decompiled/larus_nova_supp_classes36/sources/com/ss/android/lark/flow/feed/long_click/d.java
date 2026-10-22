package com.ss.android.lark.flow.feed.long_click;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ FlowFeedDialogBuilder a;

    public d(FlowFeedDialogBuilder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Function0<Unit> r2 = this.a.f;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dismiss");
        r2 = null;
    L5:
        r2.invoke();
    }
}
