package com.ss.android.lark.flow.feed.utils;

import android.content.Context;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r1, int r2, Integer r3) {
        String r4 = UIHelper.getString(r2);
        Intrinsics.checkNotNullParameter(r4, "content");
        if (r1 == null) goto L8;
        if (r3 != null) goto L6;
        FlowToast.d(r1, r4);
        return;
    L6:
        FlowToast.e(r1, r4, r3.intValue());
        return;
    }
}
