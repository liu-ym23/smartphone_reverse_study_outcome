package com.larus.bmhome.chat.component.bottom.floating.button;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.common_ui.view.NoSpaceTextView;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int b(NoSpaceTextView r1, CharSequence r2) {
        return (int) new Paint(r1.getPaint()).measureText(r2.toString());
    }

    public static View a(Context r5, CharSequence r6, CharSequence r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "leftTxt");
        View r8 = LayoutInflater.from(r5).inflate(2131562818, null);
        View r0 = r8.findViewById(2131372998);
        ImageView r1 = (ImageView) r0.findViewById(2131372999);
        NoSpaceTextView r2 = r0.findViewById(2131373000);
        NoSpaceTextView r3 = r0.findViewById(2131373001);
        View r4 = r0.findViewById(2131373002);
        r1.setImageResource(2131242393);
        r2.setText(r6);
        if (r7 != null) goto L5;
    L8:
        boolean r9 = true;
    L9:
        if (r9 == false) goto L11;
        Intrinsics.checkNotNull(r3);
        e1.o(r3);
        Intrinsics.checkNotNull(r2);
        int r10 = b(r2, r6) + i5.s0();
        Intrinsics.checkNotNull(r4);
        e1.o(r4);
    L12:
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(r10, i5.k0());
        r11.topMargin = i5.r0();
        r8.setLayoutParams(r11);
        Intrinsics.checkNotNull(r8);
        return r8;
    L11:
        r3.setText(r7);
        Intrinsics.checkNotNull(r2);
        int r12 = b(r2, r6);
        Intrinsics.checkNotNull(r3);
        r10 = (r12 + b(r3, r7)) + i5.e();
        goto L12
    L5:
        if (((String) r7).length() == 0) goto L8;
        r9 = false;
        goto L9
    }
}
