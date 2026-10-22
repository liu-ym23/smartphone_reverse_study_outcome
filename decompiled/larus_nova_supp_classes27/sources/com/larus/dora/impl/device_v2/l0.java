package com.larus.dora.impl.device_v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.dora.annotation.ProductNameType;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.dynamic.widget.CenterSelectedRecyclerView;
import com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar;
import com.larus.dora.impl.util.DoraImageType;
import com.larus.dora.impl.util.DoraResourceUtil;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l0 {
    public l0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static View b(Context r8, CenterSelectedRecyclerView r9, HistoryDeviceNavigationBar.HistoryDeviceAdapter r10, boolean r11, z49.c r12, int r13) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "recyclerView");
        Intrinsics.checkNotNullParameter(r10, "adapter");
        Intrinsics.checkNotNullParameter(r12, "device");
        View r14 = LayoutInflater.from(r8).inflate(2131562577, r9, false);
        TextView r4 = (TextView) r14.findViewById(2131368928);
        SimpleDraweeView r5 = r14.findViewById(2131368921);
        View r6 = r14.findViewById(2131367728);
        int r15 = com.larus.dora.impl.util.o.a;
        String r1 = com.larus.dora.impl.util.o.b(r12.b(), r12.c());
        Integer r16 = r12.f();
        if (r16 == null) goto L5;
        int r2 = r16.intValue();
    L6:
        Integer r17 = r12.d();
        if (r17 == null) goto L9;
        r17.intValue();
    L9:
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNull(r6);
        a(r1, r2, r11, r4, r5, r6, r13);
        r14.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        Intrinsics.checkNotNull(r14);
        return r14;
    L5:
        r2 = 0;
        goto L6
    }

    public static void a(String r1, int r2, boolean r3, TextView r4, SimpleDraweeView r5, View r6, int r7) {
        Intrinsics.checkNotNullParameter(r1, "title");
        Intrinsics.checkNotNullParameter(r4, "titleText");
        Intrinsics.checkNotNullParameter(r5, "deviceIcon");
        Intrinsics.checkNotNullParameter(r6, "container");
        r4.setText(r1);
        DoraSKU r8 = DoraSKU.a.b(DoraSKU.Companion, Integer.valueOf(r2));
        if (r7 >= 2) goto L5;
        r5.setVisibility(8);
        r6.setBackgroundColor(0);
    L6:
        r6.setSelected(r3);
        if (r3 == false) goto L9;
        e1.x(r4);
        return;
    L9:
        e1.o(r4);
        return;
    L5:
        r5.setVisibility(0);
        r6.setBackgroundResource(2131247646);
        DoraResourceUtil r9 = DoraResourceUtil.a;
        DoraImageType r10 = DoraImageType.ICON_DORA_MANAGE_NAV_BAR;
        DoraSKU r11 = n1.e(r8);
        boolean r12 = v19.h.a;
        r5.setImageBitmap(DoraResourceUtil.e(r10.fileName(r11, v19.h.a(null), Integer.valueOf(ProductNameType.DORA_LITE.id))));
        goto L6
    }
}
