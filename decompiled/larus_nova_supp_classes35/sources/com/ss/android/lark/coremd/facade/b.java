package com.ss.android.lark.coremd.facade;

import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.ext.g;
import com.ss.android.lark.coremd.facade.bizext.IMThemeExtend;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import t9b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final List<Float> a = null;

    static {
        Float r1 = Float.valueOf(1.0f);
        a = CollectionsKt.listOf(new Float[]{Float.valueOf(1.06f), r1, r1, r1, r1, r1});
    }

    public static final j a(Function2 r3) {
        e r0 = e.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r3, Keys.API_PARAM_KEY_ACTION);
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r3, Keys.API_PARAM_KEY_ACTION);
        j r1 = com.ss.android.lark.coremdbiz.facade.a.b();
        IMThemeExtend.a r2 = IMThemeExtend.s;
        g.a(r1, r2, r3);
        Intrinsics.checkNotNullParameter(r1, "<this>");
        g.a(r1, r2, IMMarkdownConfigKt$applyChatMessageHeadingStyle$1.INSTANCE);
        return r1;
    }
}
