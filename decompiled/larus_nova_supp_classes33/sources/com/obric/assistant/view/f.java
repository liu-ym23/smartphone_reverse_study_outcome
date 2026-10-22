package com.obric.assistant.view;

import android.widget.PopupWindow;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f implements PopupWindow.OnDismissListener {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ f(sba.g r1) {
        this.a = r1;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        Function0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }
}
