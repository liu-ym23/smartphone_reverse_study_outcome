package com.bytedance.ai.debugscene;

import android.os.Handler;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u0 extends com.lynx.tasm.q1 {
    public final /* synthetic */ w0.a a;
    public final /* synthetic */ LynxView b;

    public final void onLoadSuccess() {
        final w0.a r0 = this.a;
        Handler r1 = r0.h;
        final LynxView r10 = this.b;
        r1.post(new t0(r0, r10));
    }

    public final void onReceivedError(final LynxError r10) {
        boolean r0 = false;
        if (r10 != null) goto L5;
    L7:
        if (r0 == false) goto L10;
        final w0.a r1 = this.a;
        Handler r11 = r1.h;
        final LynxView r12 = this.b;
        r11.post(new s0(r1, r12, r10));
        return;
    L10:
        return;
    L5:
        if (r10.isFatal() != true) goto L7;
        r0 = true;
        goto L7
    }

    public u0(w0.a r1, LynxView r10) {
        this.a = r1;
        this.b = r10;
    }
}
