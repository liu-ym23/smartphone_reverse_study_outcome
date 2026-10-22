package com.ss.android.lark.keyboard.edittext2.mdeditor.biz;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.coremd.impl.parse.i;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.ss.android.lark.coremd.base.parse.a {
    public static final a b = null;

    static {
        b = new a();
    }

    public a() {
    }

    public final com.ss.android.lark.coremd.base.parse.a.b a(final i r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        int r0 = Integer.MAX_VALUE;
        if (r11 != 0) goto L5;
        int r1 = Integer.MAX_VALUE;
    L6:
        if (r12 == 0) goto L9;
        r0 = r12;
    L9:
        int r2 = ((Number) LarkContextExtend.s.b(new EditorImageSizeProvider$provideSizeForLoadImage$maxWidth$1(r10))).intValue();
        if (r2 > 0) goto L12;
        Resources r3 = r10.getContext().getResources();
        DisplayMetrics r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics());
        r2 = Math.min(r4.widthPixels, r4.heightPixels);
    L12:
        int r5 = MathKt.roundToInt(r2 * 0.4f);
        int r6 = MathKt.roundToInt(r5 * (r0 / r1));
        Log.d("EditorImageSizeProvider", "image maxWidth is " + r5 + " , maxHeight is " + r6);
        int r8 = UIUtils.dp2px(r10.getContext(), 80.0f);
        int[] r13 = ImageUtils.g(r11, r12, r5, r6, r8, r8);
        Intrinsics.checkNotNull(r13);
        return new com.ss.android.lark.coremd.base.parse.a.b(r13[0], r13[1]);
    L5:
        r1 = r11;
        goto L6
    }
}
