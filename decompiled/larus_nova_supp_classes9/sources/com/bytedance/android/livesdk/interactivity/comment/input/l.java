package com.bytedance.android.livesdk.interactivity.comment.input;

import android.content.Context;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import gd0.r;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ VideoCommentPreviewFragment a;

    public l(VideoCommentPreviewFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Context r0 = this.a.getContext();
        ExceptionUtils.handleException(r0, (Throwable) r2);
        r r3 = this.a.g;
        if (r3 == null) goto L6;
        r3.a();
        return;
    }
}
