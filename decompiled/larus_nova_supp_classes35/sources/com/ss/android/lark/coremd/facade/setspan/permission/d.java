package com.ss.android.lark.coremd.facade.setspan.permission;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.facade.bizext.IMThemeExtend;
import com.ss.android.lark.coremd.facade.bizext.theme.IMImageThemeData;
import com.ss.android.lark.coremd.impl.parse.i;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.processor.t;
import com.ss.android.lark.widget.light.span.NoPreviewPlaceHolderSpan;
import com.ss.android.lark.widget.span.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(String r15, int r16, int r17, final i r18, v9b.b r19, Function0 r20) {
        Intrinsics.checkNotNullParameter(r15, "noPreviewText");
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "permissionContextData");
        Intrinsics.checkNotNullParameter(r20, "clickAction");
        final j r4 = r18.getTheme();
        float r5 = ((Number) LarkThemeExtend.m.b(new ImageSpanPermissionCoordinator$noPreviewPlaceHolderSpan$leftMargin$1(r4))).floatValue();
        int r6 = ((Number) LarkContextExtend.s.b(new ImageSpanPermissionCoordinator$noPreviewPlaceHolderSpan$maxWidth$1(r18))).intValue();
        t.a r2 = r19.d;
        int r7 = UIUtils.dp2px(r18.getContext(), r5);
        if (r2 != null) goto L5;
    L7:
        boolean r9 = false;
    L9:
        if (r9 == false) goto L11;
        float r10 = r2.a;
        float r3 = r2.b;
        NoPreviewPlaceHolderSpan.b.a r13 = new NoPreviewPlaceHolderSpan.b.a();
        NoPreviewPlaceHolderSpan.DrawableSizeType r14 = NoPreviewPlaceHolderSpan.DrawableSizeType.DYNAMIC_SIZE;
        Intrinsics.checkNotNullParameter(r14, "sizeType");
        r13.d = r14;
        Intrinsics.checkNotNullParameter(r15, "tip");
        r13.a = r15;
        r13.c = r10;
        r13.b = r3;
        r13.e = r16;
        r13.f = r17;
        NoPreviewPlaceHolderSpan.c r0 = new NoPreviewPlaceHolderSpan.c(r7, 0, 0, 0);
        Intrinsics.checkNotNullParameter(r0, "margin");
        r13.h = r0;
        r13.g = r6;
        NoPreviewPlaceHolderSpan.b r1 = r13.a();
    L12:
        c r8 = new c(r20);
        NoPreviewPlaceHolderSpan r11 = new NoPreviewPlaceHolderSpan(r18.getContext(), r1);
        IMImageThemeData r12 = (IMImageThemeData) IMThemeExtend.s.b(new ImageSpanPermissionCoordinator$noPreviewPlaceHolderSpan$previewSpan$1$themeData$1(r4));
        int r21 = UIUtils.dp2px(r18.getContext(), r12.j());
        int r22 = UIUtils.dp2px(r18.getContext(), r12.h());
        ((g) r11).a = r21;
        ((g) r11).b = r22;
        return com.ss.android.lark.coremd.ext.b.a(r11, new Object[]{r8});
    L11:
        NoPreviewPlaceHolderSpan.b.a r23 = new NoPreviewPlaceHolderSpan.b.a();
        NoPreviewPlaceHolderSpan.DrawableSizeType r24 = NoPreviewPlaceHolderSpan.DrawableSizeType.FIX_SIZE;
        Intrinsics.checkNotNullParameter(r24, "sizeType");
        r23.d = r24;
        Intrinsics.checkNotNullParameter(r15, "tip");
        r23.a = r15;
        r23.c = UIHelper.dp2px(8.0f);
        r23.b = UIHelper.dp2px(1.0f);
        NoPreviewPlaceHolderSpan.c r25 = new NoPreviewPlaceHolderSpan.c(r7, 0, 0, 0);
        Intrinsics.checkNotNullParameter(r25, "margin");
        r23.h = r25;
        r23.g = r6;
        r1 = r23.a();
        goto L12
    L5:
        if (r2.c != true) goto L7;
        r9 = true;
        goto L9
    }
}
