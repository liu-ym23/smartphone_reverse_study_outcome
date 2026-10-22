package com.ss.android.lark.coremd.base.parse;

import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final <T extends com.ss.android.lark.coremd.ext.f> b a(com.ss.android.lark.coremd.ext.h<T> r1, Function2<? super T, ? super b, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "contextProvider");
        Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
        com.ss.android.lark.coremd.impl.parse.a r0 = new com.ss.android.lark.coremd.impl.parse.a();
        com.ss.android.lark.coremd.ext.g.a(r0, r1, r2);
        return r0;
    }
}
