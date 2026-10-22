package com.ss.android.lark.forwardv3;

import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class x {
    public static final boolean a(SearchBaseInfo r3, ForwardV3ViewModel r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        Integer r0 = (Integer) r4.getSelectMode().getValue();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.intValue() == 1) goto L8;
        return false;
    L8:
        if (r3.isSelected() == true) goto L18;
        Map r5 = (Map) r4.getSelectedItem().getValue();
        if (r5 == null) goto L12;
        int r6 = r5.size();
    L14:
        if (r6 < 10) goto L19;
        return true;
    L19:
        return false;
    L12:
        r6 = 0;
        goto L14
    L18:
        return false;
    }

    public static final boolean b(SearchBaseInfo r1, ForwardV3ViewModel r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        if (c(r1, r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (r2.isExternalTargetDisabledByMessageCount(r1) == true) goto L10;
        if (a(r1, r2) == true) goto L10;
        return false;
    }

    public static final boolean c(SearchBaseInfo r1, ForwardV3ViewModel r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        if (r2.disable(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2.customDisable(r1) == true) goto L8;
        return false;
    }
}
