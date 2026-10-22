package com.larus.common_ui.dialog;

import android.widget.TextView;
import com.larus.common_res.common_ui.databinding.LarusLayoutBottomSheetHeaderV2Binding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t {
    public final LarusLayoutBottomSheetHeaderV2Binding a;

    public t(LarusLayoutBottomSheetHeaderV2Binding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        this.a = r2;
    }

    public final void a(CharSequence r2) {
        TextView r0 = this.a.d;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.setText(r2);
    }
}
