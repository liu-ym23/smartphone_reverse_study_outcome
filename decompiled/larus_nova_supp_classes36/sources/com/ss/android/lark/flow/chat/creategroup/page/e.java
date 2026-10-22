package com.ss.android.lark.flow.chat.creategroup.page;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ FlowGroupCreateFragmentV2 a;

    public e(FlowGroupCreateFragmentV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Integer r7 = (Integer) r6;
        String r0 = UIUtils.getString(this.a.getContext(), 2131889999);
        TextView r2 = null;
        if (r7.intValue() > 0) goto L12;
        TextView r8 = this.a.i;
        if (r8 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mConfirmBT");
        r8 = null;
    L7:
        r8.setText(r0);
        TextView r9 = this.a.i;
        if (r9 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mConfirmBT");
    L11:
        r2.setEnabled(false);
        return;
    L10:
        r2 = r9;
        goto L11
    L12:
        TextView r1 = this.a.i;
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mConfirmBT");
        r1 = null;
    L15:
        r1.setText(r0 + " (" + r7 + ')');
        TextView r10 = this.a.i;
        if (r10 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mConfirmBT");
    L19:
        r2.setEnabled(true);
        return;
    L18:
        r2 = r10;
        goto L19
    }
}
