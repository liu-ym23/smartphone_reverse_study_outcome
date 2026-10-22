package com.ss.android.lark.coremd.facade.plugins;

import android.text.style.ForegroundColorSpan;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.facade.bizext.IMThemeExtend;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o0 extends com.ss.android.lark.coremdbiz.facade.plugins.a {
    public o0() {
    }

    @Override // com.ss.android.lark.coremdbiz.facade.plugins.a, com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(eab.a.class, new n0(this));
    }

    @Override // com.ss.android.lark.coremdbiz.facade.plugins.a, com.ss.android.lark.coremd.base.parse.g
    public final void c(com.ss.android.lark.coremd.impl.parse.j.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(eab.a.class, new m0(this));
    }

    public static final ForegroundColorSpan f(o0 r2, final com.ss.android.lark.coremd.impl.parse.i r3) {
        r2.getClass();
        return new ForegroundColorSpan(UIUtils.getColor(r3.getContext(), ((Number) IMThemeExtend.s.b(new IMAtPlugin$prepareSpanDefault$defaultColor$1(r3))).intValue()));
    }
}
