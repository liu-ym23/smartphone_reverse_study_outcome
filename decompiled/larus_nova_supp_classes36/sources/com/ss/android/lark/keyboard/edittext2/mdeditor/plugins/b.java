package com.ss.android.lark.keyboard.edittext2.mdeditor.plugins;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.q;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b<T extends s> implements q {
    public b() {
    }

    public final Object a(final com.ss.android.lark.coremd.impl.parse.i r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        int r0 = ((Number) LarkThemeExtend.m.b(new EditorAtPlugin$configureSpanFactory$1$atColor$1(r3))).intValue();
        return new a.C0146a(UIUtils.getColor(r3.getContext(), r0));
    }
}
