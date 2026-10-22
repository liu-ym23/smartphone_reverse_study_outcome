package com.bytedance.android.live.livepkaudience.widget;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import io.reactivex.functions.Consumer;
import uf2.b1;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;

    public f(LinkPkInteractAudienceGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Integer r3 = (Integer) r2;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.intValue() != 0) goto L23;
        com.bytedance.android.live.livepkaudience.rtc.a r4 = this.a.e;
        if (r4 == null) goto L24;
        Integer r0 = r4.u;
        if (r0 == null) goto L25;
        r0.intValue();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r1 = ILiveWrappedLivePusher.a.b();
        if (r1 == null) goto L14;
        b1 r5 = r1.newTEBundle();
    L15:
        if (r5 == null) goto L17;
        r5.b();
    L17:
        d0 r6 = r4.b;
        if (r6 == null) goto L20;
        r6.S();
    L20:
        if (r5 == null) goto L26;
        r5.release();
        return;
    L26:
        return;
    L14:
        r5 = null;
        goto L15
    L25:
        return;
    L24:
        return;
    }
}
