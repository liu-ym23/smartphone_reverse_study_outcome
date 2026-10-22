package com.bytedance.android.livesdk.interactivity.comment.share;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r3) {
        ApiServerException r4 = (Throwable) r3;
        if ((r4 instanceof ApiServerException) == false) goto L13;
        ApiServerException r5 = r4;
        String r0 = r5.getPrompt();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        f2.c(r5.getPrompt(), 0);
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
    L13:
        f2.b(2131923435, 0);
    }
}
