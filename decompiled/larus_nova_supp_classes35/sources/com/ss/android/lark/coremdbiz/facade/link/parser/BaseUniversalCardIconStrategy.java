package com.ss.android.lark.coremdbiz.facade.link.parser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.r;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkLinkThemeData;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.p;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BaseUniversalCardIconStrategy implements b.a<dab.d> {
    public final Class<dab.d> a;

    public BaseUniversalCardIconStrategy() {
        this.a = dab.d.class;
    }

    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b.a
    public Class<dab.d> getType() {
        return this.a;
    }

    public static int b(final r r1, dab.d r2) {
        Intrinsics.checkNotNullParameter(r1, "ctx");
        Intrinsics.checkNotNullParameter(r2, "info");
        LarkLinkThemeData r3 = (LarkLinkThemeData) LarkThemeExtend.m.b(new BaseUniversalCardIconStrategy$defaultGetColor$themeData$1(r1));
        int r0 = r3.j();
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return UIUtils.getColor(r1.getContext(), r3.h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b.a
    public final Spanned a(r r19, dab.a r20) {
        dab.d r1 = (dab.d) r20;
        Intrinsics.checkNotNullParameter(r19, "visitContext");
        Intrinsics.checkNotNullParameter(r1, "info");
        Paint r2 = new Paint();
        int r3 = c(r19, r1);
        r2.setColorFilter(new PorterDuffColorFilter(r3, PorterDuff.Mode.SRC_IN));
        Bitmap r4 = p.c(r19.getContext(), 2131255013);
        r2.setColorFilter(new PorterDuffColorFilter(r3, PorterDuff.Mode.SRC_IN));
        if (r4 == null) goto L5;
        Bitmap r5 = Bitmap.createBitmap(r4.getWidth(), r4.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(r5).drawBitmap(r4, 0.0f, 0.0f, r2);
    L6:
        int r11 = (int) UIHelper.sp2px(14.0f);
        Context r6 = r19.getContext();
        String r0 = ((n) r19.getNode()).j;
        ncc.e.a r7 = new ncc.e.a(r0);
        r0.getClass();
        int r16 = UIUtils.dp2px(r6, 3.0f);
        int r17 = UIUtils.dp2px(r6, 3.0f);
        int r14 = r6.getResources().getColor(2131106614);
        int r15 = r6.getResources().getColor(2131106614);
        if (r5 != null) goto L9;
        Bitmap r9 = r4;
    L10:
        ncc.e r8 = new ncc.e(r6, r7, BuildConfig.FLAVOR, r9, null, r11, false, 0, r14, r15, r16, r17);
        SpannableStringBuilder r10 = new SpannableStringBuilder();
        r10.append("$");
        r10.setSpan(r8, 0, r10.length(), 33);
        return r10;
    L9:
        r9 = r5;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public int c(r<n> r2, dab.d r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "info");
        return b(r2, r3);
    }
}
