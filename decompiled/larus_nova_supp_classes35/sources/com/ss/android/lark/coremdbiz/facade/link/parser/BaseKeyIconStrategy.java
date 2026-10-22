package com.ss.android.lark.coremdbiz.facade.link.parser;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import androidx.appcompat.content.res.AppCompatResources;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.r;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkLinkThemeData;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import sz7.q;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BaseKeyIconStrategy implements b.a<dab.b> {
    public final Class<dab.b> a;

    public BaseKeyIconStrategy() {
        this.a = dab.b.class;
    }

    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b.a
    public Class<dab.b> getType() {
        return this.a;
    }

    public static int b(final r r3, dab.b r4) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        Intrinsics.checkNotNullParameter(r4, "info");
        LarkLinkThemeData r0 = (LarkLinkThemeData) LarkThemeExtend.m.b(new BaseKeyIconStrategy$defaultGetColor$themeData$1(r3));
        int r1 = r0.j();
        if (r4.e == true) goto L9;
        if (r1 == 0) goto L8;
        return r1;
    L8:
        return UIUtils.getColor(r3.getContext(), r0.h());
    L9:
        return r4.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b.a
    public final Spanned a(final r r19, dab.a r20) {
        dab.b r1 = (dab.b) r20;
        Intrinsics.checkNotNullParameter(r19, "visitContext");
        Intrinsics.checkNotNullParameter(r1, "info");
        LarkThemeExtend.a r2 = LarkThemeExtend.m;
        final LarkLinkThemeData r3 = (LarkLinkThemeData) r2.b(new BaseKeyIconStrategy$onParse$1$themeData$1(r19));
        int r4 = ((Number) r2.b(new BaseKeyIconStrategy$onParse$1$iconSize$1(r19, r3))).intValue();
        if (r1.b == 0) goto L5;
        Drawable r5 = AppCompatResources.getDrawable(r19.getContext(), r1.b);
    L6:
        Drawable r9 = r5;
        q r12 = new q(r19.getContext(), false);
        int r6 = c(r19, r1);
        if (r9 == null) goto L10;
        r9.setTint(r6);
    L10:
        if (r1.a.length() != 0) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
        r12.b(r1.f, r4, r4, r9, !r1.c, Integer.valueOf(r6));
    L16:
        Context r8 = r19.getContext();
        com.ss.android.lark.coremd.ext.c r10 = r3.j;
        KProperty<Object>[] r11 = LarkLinkThemeData.n;
        int r16 = UIUtils.dp2px(r8, ((Number) r10.getValue(r3, r11[3])).floatValue());
        int r13 = UIUtils.dp2px(r19.getContext(), ((Number) r3.k.getValue(r3, r11[4])).floatValue());
        Context r14 = r19.getContext();
        String r15 = ((n) r19.getNode()).j;
        ncc.e.a r17 = new ncc.e.a(r15);
        r15.getClass();
        UIUtils.dp2px(r14, 3.0f);
        UIUtils.dp2px(r14, 3.0f);
        final ncc.e r18 = new ncc.e(r14, r17, BuildConfig.FLAVOR, null, r12, r4, r1.e, r1.d, r14.getResources().getColor(2131106614), r14.getResources().getColor(2131106614), r16, r13);
        SpannableStringBuilder r21 = new SpannableStringBuilder();
        r21.append("$");
        r21.setSpan(r18, 0, r21.length(), 33);
        r18.a(new cab.a(new BaseKeyIconStrategy$onParse$1$1(r19, r18)));
        return r21;
    L15:
        q.d(r12, r1.a, null, r4, r4, r9, !r1.c, Integer.valueOf(r6));
        goto L16
    L12:
        r7 = false;
        goto L13
    L5:
        r5 = null;
        goto L6
    }

    public int c(r<n> r2, dab.b r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "info");
        return b(r2, r3);
    }
}
