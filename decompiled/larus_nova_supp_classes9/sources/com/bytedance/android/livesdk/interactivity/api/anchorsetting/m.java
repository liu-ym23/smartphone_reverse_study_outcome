package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m<T> implements Consumer {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final void accept(Object r3) {
        CustomApiServerException r4 = (Throwable) r3;
        Intrinsics.checkNotNullParameter(r4, "$this$prompt");
        if ((r4 instanceof CustomApiServerException) == false) goto L9;
        CustomApiServerException r5 = r4;
        String r0 = r5.getPrompt();
        if (r0 == null) goto L9;
        if ((!StringsKt.isBlank(r0)) != true) goto L9;
        String r6 = r5.getPrompt();
    L10:
        f2.c(r6, 0);
        return;
    L9:
        r6 = null;
        goto L10
    }
}
