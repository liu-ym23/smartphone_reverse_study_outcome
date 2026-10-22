package com.bytedance.android.ec.common.impl.view;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/common/impl/view/FixedDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FixedDialog extends BottomSheetDialog {
    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        Window r11 = getWindow();
        if (r11 == null) goto L5;
        r11.setLayout(-1, -1);
    L5:
        Window r12 = getWindow();
        if (r12 == null) goto L9;
        r12.setSoftInputMode(48);
        return;
    }

    public FixedDialog(Context r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
    }
}
