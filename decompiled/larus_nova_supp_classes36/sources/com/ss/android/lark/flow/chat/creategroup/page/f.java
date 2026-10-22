package com.ss.android.lark.flow.chat.creategroup.page;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ FlowGroupCreateFragmentV2 a;

    public f(FlowGroupCreateFragmentV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        TextView r0 = this.a.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mConfirmBT");
        r0 = null;
    L5:
        Intrinsics.checkNotNull(r3);
        r0.setEnabled(r3.booleanValue());
    }
}
