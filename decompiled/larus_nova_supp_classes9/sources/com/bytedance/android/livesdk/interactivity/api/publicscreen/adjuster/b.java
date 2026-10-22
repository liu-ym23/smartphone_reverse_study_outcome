package com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import zg1.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final float a = 0.0f;
    public static final int b = 0;

    static {
        s1.j(2131168673);
        a = s1.e(150.0f);
        b = UtilityKotlinExtentionsKt.i(80);
    }

    @JvmStatic
    public static final void a(DataCenter r2, z0 r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3.a != 0) goto L17;
        Object r5 = r3.b;
        if ((r5 instanceof Integer) == false) goto L18;
        if (r5 == null) goto L16;
        int r6 = (r4 - ((int) (((Integer) r5).intValue() + s1.e(26.0f)))) + 0;
        if (r6 >= s1.e(90.0f)) goto L10;
        r6 = (int) s1.e(90.0f);
    L10:
        PageUIContext r7 = PageUIContext.Companion.getContext(r2);
        if (r7 == null) goto L19;
        m<Integer> r8 = r7.getRequestPkHeightIncludeMarginDefault();
        if (r8 == null) goto L20;
        r8.setValue(Integer.valueOf(r6));
        return;
    L20:
        return;
    L19:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L18:
        return;
    }
}
