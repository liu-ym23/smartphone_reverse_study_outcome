package com.bytedance.android.livesdk.interactivity.chatchannel.toolbar;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements Action {
    public final /* synthetic */ ChatChannelWidgetManager a;
    public final /* synthetic */ f b;

    public e(ChatChannelWidgetManager r1, f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        s22.e r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.removeListener(this.b);
        return;
    }
}
