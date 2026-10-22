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
import com.ss.android.lark.utils.p;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BaseRichUrlIconStrategy implements b.a<dab.c> {
    public final Class<dab.c> a;

    public BaseRichUrlIconStrategy() {
        this.a = dab.c.class;
    }

    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b.a
    public Class<dab.c> getType() {
        return this.a;
    }

    public static int b(final r r2, dab.c r3) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "info");
        LarkLinkThemeData r0 = (LarkLinkThemeData) LarkThemeExtend.m.b(new BaseRichUrlIconStrategy$defaultGetColor$themeData$1(r2));
        int r1 = r0.j();
        if (r1 == 0) goto L6;
        return r1;
    L6:
        if (r3.d == true) goto L12;
        if (r3.b != 0) goto L12;
        return UIUtils.getColor(r2.getContext(), r0.h());
    L12:
        return r3.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b.a
    public final Spanned a(final r r24, dab.a r25) {
        dab.c r1 = (dab.c) r25;
        Intrinsics.checkNotNullParameter(r24, "visitContext");
        Intrinsics.checkNotNullParameter(r1, "info");
        LarkLinkThemeData r2 = (LarkLinkThemeData) LarkThemeExtend.m.b(new BaseRichUrlIconStrategy$onParse$1$themeData$1(r24));
        boolean r4 = true;
        if (r1.c.length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        Bitmap r5 = p.c(r24.getContext(), r1.a);
    L9:
        Paint r6 = new Paint();
        int r8 = c(r24, r1);
        if (r1.c.length() == 0) goto L13;
        r4 = false;
    L13:
        if (r4 == false) goto L16;
        if (r8 == 0) goto L16;
        r6.setColorFilter(new PorterDuffColorFilter(r8, PorterDuff.Mode.SRC_IN));
    L16:
        if (r5 != null) goto L18;
        r5 = p.c(r24.getContext(), 2131255013);
        r6.setColorFilter(new PorterDuffColorFilter(r8, PorterDuff.Mode.SRC_IN));
    L18:
        if (r5 == null) goto L20;
        Bitmap r7 = Bitmap.createBitmap(r5.getWidth(), r5.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(r7).drawBitmap(r5, 0.0f, 0.0f, r6);
    L21:
        Context r9 = r24.getContext();
        com.ss.android.lark.coremd.ext.c r10 = r2.j;
        KProperty<Object>[] r11 = LarkLinkThemeData.n;
        int r21 = UIUtils.dp2px(r9, ((Number) r10.getValue(r2, r11[3])).floatValue());
        int r22 = UIUtils.dp2px(r24.getContext(), ((Number) r2.k.getValue(r2, r11[4])).floatValue());
        int r16 = UIUtils.dp2px(r24.getContext(), r2.l());
        Context r12 = r24.getContext();
        String r13 = ((n) r24.getNode()).j;
        ncc.e.a r14 = new ncc.e.a(r13);
        r13.getClass();
        UIUtils.dp2px(r12, 3.0f);
        UIUtils.dp2px(r12, 3.0f);
        int r19 = r12.getResources().getColor(2131106614);
        int r20 = r12.getResources().getColor(2131106614);
        if (r7 != null) goto L24;
        Bitmap r15 = r5;
    L25:
        final ncc.e r17 = new ncc.e(r12, r14, BuildConfig.FLAVOR, r15, null, r16, r1.d, r1.b, r19, r20, r21, r22);
        SpannableStringBuilder r18 = new SpannableStringBuilder();
        r18.append("$");
        r18.setSpan(r17, 0, r18.length(), 33);
        r17.a(new cab.a(new BaseRichUrlIconStrategy$onParse$1$1(r24, r17)));
        return r18;
    L24:
        r15 = r7;
        goto L25
    L20:
        r7 = null;
        goto L21
    L8:
        Integer[] r23 = sbb.d.a;
        r5 = sbb.d.a(r1.c);
        goto L9
    L5:
        r3 = false;
        goto L6
    }

    public int c(r<n> r2, dab.c r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "info");
        return b(r2, r3);
    }
}
