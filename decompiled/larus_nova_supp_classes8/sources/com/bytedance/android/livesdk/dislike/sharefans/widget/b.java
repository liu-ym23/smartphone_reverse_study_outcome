package com.bytedance.android.livesdk.dislike.sharefans.widget;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r4) {
        ApiServerException r5 = (Throwable) r4;
        if (r5 != null) goto L6;
        return;
    L6:
        if ((r5 instanceof ApiServerException) == false) goto L10;
        ApiServerException r0 = r5;
        if (TextUtils.isEmpty(r0.getPrompt()) == true) goto L10;
        f2.c(r0.getPrompt(), 0);
    L10:
        f2.b(2131922495, 0);
        ALogger.e("ShareFansWidget", "share failed, error: " + r5.getMessage());
    }
}
