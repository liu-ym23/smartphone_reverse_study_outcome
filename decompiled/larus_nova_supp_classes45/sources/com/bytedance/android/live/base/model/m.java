package com.bytedance.android.live.base.model;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m {
    @Deprecated(message = "Do not use unless necessary")
    public static final vh7.e a(vh7.c r1, Class r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$callCastToWithoutTypeChecking");
        Intrinsics.checkNotNullParameter(r2, "type");
        return r1.castToOrNull(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "该扩展方法极易误用，请确认实际需求后使用替代方案：若要在 FlexModel 和 ModelExtension 之间转换，请使用其castTo方法；其他情况请使用 Kotlin 的 as 关键字。")
    public static final <T> T b(Object r5, Class<? extends T> r6) {
        Intrinsics.checkNotNullParameter(r6, "clazz");
        if (r5 != 0) goto L6;
        return null;
    L6:
        if (r6.isInstance(r5) == false) goto L9;
        return r5;
    L9:
        if (vh7.c.class.isAssignableFrom(r6) == true) goto L16;
        if (vh7.e.class.isAssignableFrom(r6) == true) goto L16;
        LocalTestManager.a(new Class[]{wy.a.class});
        return null;
    L16:
        if ((r5 instanceof vh7.e) == false) goto L22;
        Object r7 = ((vh7.e) r5).getFlexInstance();
        if (r7 == null) goto L21;
        vh7.c r8 = (vh7.c) r7;
    L24:
        if (vh7.e.class.isAssignableFrom(r6) == false) goto L29;
        boolean r1 = r8.getClass().isAssignableFrom(r6);
        LocalTestManager.a(new Class[]{wy.a.class});
        if (r1 == true) goto L28;
        return null;
    L28:
        return (T) a(r8, r6);
    L29:
        boolean r9 = Intrinsics.areEqual(r8.getClass(), r6);
        LocalTestManager.a(new Class[]{wy.a.class});
        if (r9 == true) goto L32;
        return null;
    L32:
        return (T) r8;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<*>");
    L22:
        r8 = (vh7.c) r5;
        goto L24
    }
}
