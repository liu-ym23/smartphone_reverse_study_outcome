package com.ss.android.lark.coremd.facade.bizext.image;

import android.content.Context;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.base.parse.o;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremd.facade.bizext.IMThemeExtend;
import com.ss.android.lark.coremd.facade.bizext.theme.IMImageThemeData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements a {
    public static final b b = null;

    static {
        b = new b();
    }

    public b() {
    }

    @Override // com.ss.android.lark.coremd.facade.bizext.image.a
    public final a.b a(int r18, int r19, final o r20) {
        Intrinsics.checkNotNullParameter(r20, "parseContext");
        Context r1 = r20.getContext();
        final j r2 = r20.getTheme();
        IMThemeExtend.a r3 = IMThemeExtend.s;
        final IMImageThemeData r4 = (IMImageThemeData) r3.b(new IMImageSizeInterceptorImpl$obtainMaxImageWidth$themeData$1(r2));
        final Context r5 = r20.getContext();
        final int r6 = ((Number) IMContextExtend.A.b(new IMImageSizeInterceptorImpl$obtainMaxImageWidth$maxImageWidth$1(r20))).intValue();
        int r7 = ((Number) r3.b(new IMImageSizeInterceptorImpl$obtainMaxImageWidth$1(r5, r6, r4, r20))).intValue();
        int r8 = UIUtils.dp2px(r1, 240.0f);
        float r9 = DeviceUtils.getScreenDensity(r1);
        int r10 = (int) (r18 * r9);
        int r11 = (int) (r19 * r9);
        int r12 = UIHelper.dp2px(40.0f);
        if (r10 != 0) goto L5;
        r10 = UIUtils.dp2px(r1, 80.0f);
    L5:
        if (r11 != 0) goto L7;
        int r13 = UIUtils.dp2px(r1, 80.0f);
    L9:
        if (r10 != 0) goto L11;
    L17:
        boolean r15 = false;
    L18:
        Log.i("IMImageSizeCoordinator", "imageWidth:" + r10 + ", imageHeight:" + r13 + ", isLargeImage:" + r15);
        if (r15 == false) goto L21;
        int r14 = UIHelper.dp2px(150.0f);
        int r0 = UIHelper.dp2px(240.0f);
        int r16 = (int) (((r13 * 1.0f) / r10) * r14);
        int r17 = r14;
        int r110 = r17;
    L32:
        return new a.b(r17, r16, r110, r0, r15);
    L21:
        if (r10 > r7) goto L23;
        if (r13 > r8) goto L23;
    L24:
        if (r10 >= r12) goto L26;
        int r21 = r12;
    L27:
        if (r13 < r12) goto L30;
        r12 = r13;
    L30:
        r110 = r21;
        r16 = r13;
        r17 = r10;
        r0 = r12;
        goto L32
    L26:
        r21 = r10;
    L23:
        int[] r22 = ImageUtils.g(r10, r13, r7, r8, 1, 1);
        r10 = r22[0];
        r13 = r22[1];
        goto L24
    L11:
        if ((r13 / r10) < 3) goto L17;
        if (r10 <= UIHelper.dp2px(200.0f)) goto L17;
        if (r7 <= UIHelper.dp2px(150.0f)) goto L17;
        r15 = true;
        goto L18
    L7:
        r13 = r11;
        goto L9
    }
}
