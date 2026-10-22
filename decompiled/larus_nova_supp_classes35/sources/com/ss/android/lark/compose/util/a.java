package com.ss.android.lark.compose.util;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.rustclient.api.RustClientException;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final void a(Context r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "exception");
        if ((r2 instanceof RustClientException) == false) goto L5;
        RustClientException r3 = (RustClientException) r2;
    L6:
        if (r3 == null) goto L11;
        LarkError r4 = r3.getRustError();
        if (r4 == null) goto L11;
        String r5 = r4.display_message;
        if (r5 == null) goto L11;
    L13:
        if ((!StringsKt.isBlank(r5)) == false) goto L15;
        FlowToast.d(r1, r5);
        return;
    L15:
        FlowToast.c(r1, 2131892995);
        return;
    L11:
        r5 = BuildConfig.FLAVOR;
        goto L13
    L5:
        r3 = null;
        goto L6
    }
}
