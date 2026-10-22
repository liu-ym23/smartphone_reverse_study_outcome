package com.ss.android.lark.keyboard.edittext2.mdeditor.plugins;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.k;
import com.ss.android.lark.coremd.base.parse.q;
import com.ss.android.lark.coremd.base.theme.LinkThemeData;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h<T extends s> implements q {
    public h() {
    }

    public final Object a(com.ss.android.lark.coremd.impl.parse.i r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        LinkThemeData r0 = k.b.g(r3.getTheme());
        return new g.a(UIUtils.getColor(r3.getContext(), r0.h()));
    }
}
