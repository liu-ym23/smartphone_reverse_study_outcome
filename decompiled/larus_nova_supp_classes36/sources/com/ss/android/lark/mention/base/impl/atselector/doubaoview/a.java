package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(BaseAtBean r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "doubaoChatterId");
        if (r3.getType() != 8) goto L5;
        return true;
    L5:
        if (r4.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
    L12:
        return false;
    L10:
        if (Intrinsics.areEqual(r3.getId(), r4) == false) goto L12;
        return true;
    L7:
        r0 = false;
        goto L8
    }
}
