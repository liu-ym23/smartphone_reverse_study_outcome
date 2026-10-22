package com.larus.common_ui.dbx.component;

import android.widget.ImageButton;
import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d extends ImageButton {
    public Function0<Unit> a;

    @Override // android.view.View
    public final boolean performClick() {
        Function0<Unit> r0 = this.a;
        if (r0 == null) goto L6;
        r0.invoke();
    L6:
        if (super.performClick() == true) goto L10;
        if (r0 != null) goto L10;
        return false;
    L10:
        return true;
    }

    public d(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
