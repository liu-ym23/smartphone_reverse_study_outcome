package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.content.Context;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.sheet.v2.OSheetTitleBar;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t2 {
    public static final q2 a(Context r7, String r8, final Function0<Unit> r9, final Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "title");
        Intrinsics.checkNotNullParameter(r9, "onClose");
        Intrinsics.checkNotNullParameter(r10, "onConfirm");
        OSheetTitleBar r0 = new OSheetTitleBar(r7, null, 6, 0);
        r0.setShowLeftBack(false);
        r0.setTitleText(r8);
        r0.getMTitleView().setTextSize(16.0f);
        com.larus.utils.e1.d(r0.d(r7, r0.getMLeftContainer(), 2131245980, r7.getColorStateList(2131105420), 2131912815), new r2(r9));
        OIconButtonFloating r11 = r0.e(r7, r0.getMRightContainer(), 2131245981, r7.getColorStateList(2131105292), 2131912801);
        com.larus.utils.e1.d(r11, new s2(r10));
        return new q2(r0, r11);
    }
}
