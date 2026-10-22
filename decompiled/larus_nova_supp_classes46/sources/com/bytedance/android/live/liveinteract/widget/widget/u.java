package com.bytedance.android.live.liveinteract.widget.widget;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.multilink.impl.LinkMultiControlWidget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ LinkUserFollowGuideDialog a;

    public u(LinkUserFollowGuideDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.widget.widget.LinkUserFollowGuideDialog] */
    public final void accept(Object r4) {
        ApiServerException r5 = (Throwable) r4;
        if ((r5 instanceof ApiServerException) == false) goto L8;
        gd0.u r0 = this.a.f;
        String r6 = r5.getPrompt();
        if (r6 != null) goto L7;
        r6 = "";
    L7:
        ((LinkMultiControlWidget.a) r0).getClass();
        f2.c(r6, 0);
        return;
    L8:
        ?? r7 = this.a;
        gd0.u r1 = r7.f;
        String r8 = r7.getContext().getString(2131917622);
        ((LinkMultiControlWidget.a) r1).getClass();
        f2.c(r8, 0);
    }
}
