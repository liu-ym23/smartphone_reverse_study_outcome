package com.bytedance.android.livesdk.interactivity.like;

import android.content.Context;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements h80.a<Throwable>, Consumer<Throwable> {
    public final /* synthetic */ DigAccessibilityWidget a;

    public b(DigAccessibilityWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        Context r0 = ((Widget) this.a).context;
        if (r0 == null) goto L6;
        ExceptionUtils.handleException(r0, r3);
        return;
    }
}
