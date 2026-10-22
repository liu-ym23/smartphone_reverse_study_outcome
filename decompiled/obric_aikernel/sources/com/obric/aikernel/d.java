package com.obric.aikernel;

import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final RequestParams a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        RequestParams r11 = new RequestParams(null, null, 3, null);
        r11.setEvent(4);
        r11.setTargetComponent(1);
        r11.getBackend().putString(IdlKeys.Args_BindResumeSource, b(r10));
        return r11;
    }

    public static final String b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        if ((!StringsKt.isBlank(r10)) == true) goto L6;
        r10 = null;
    L6:
        if (r10 != null) goto L9;
        return "unknown";
    L9:
        return r10;
    }

    public static final boolean c(boolean r10) {
        return !r10;
    }
}
