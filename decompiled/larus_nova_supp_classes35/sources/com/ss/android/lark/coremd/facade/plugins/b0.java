package com.ss.android.lark.coremd.facade.plugins;

import android.content.Context;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public b0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(com.ss.android.lark.coremd.impl.parse.i r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Context r1 = r4.getContext();
        String r2 = ((v7b.g) r4.d).m;
        if (r2 != null) goto L6;
        r2 = BuildConfig.FLAVOR;
    L6:
        return new x9b.b(r1, r2, r4.getTheme());
    }
}
