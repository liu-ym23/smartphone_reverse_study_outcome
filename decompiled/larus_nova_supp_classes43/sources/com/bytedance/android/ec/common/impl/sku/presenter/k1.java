package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import android.widget.LinearLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k1<T> implements Observer {
    public final /* synthetic */ l1 a;

    public k1(l1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        Integer r11 = (Integer) r10;
        l1 r12 = this.a;
        LinearLayout r0 = r12.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L5:
        int r1 = r0.getChildCount();
        int r13 = 0;
    L6:
        if (r13 >= r1) goto L14;
        LinearLayout r14 = r12.g;
        if (r14 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L10:
        View r15 = r14.getChildAt(r13);
        if ((r15 instanceof com.bytedance.android.ec.common.impl.sku.view.h) == false) goto L13;
        com.bytedance.android.ec.common.impl.sku.view.h r16 = (com.bytedance.android.ec.common.impl.sku.view.h) r15;
        r16.setSelectedStatus(r16.getSelectedStatus());
    L13:
        r13 = r13 + 1;
        goto L6
    }
}
