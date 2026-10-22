package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.utils.c5;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ m a;

    public p(m r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        StringBuilder r0 = new StringBuilder("[RadioSubtitleComponent] request error: ");
        String r1 = null;
        if (r5 == null) goto L5;
        Integer r2 = Integer.valueOf(c5.a(r5));
    L6:
        r0.append(r2);
        r0.append(',');
        if (r5 == null) goto L9;
        r1 = r5.getMessage();
    L9:
        r0.append(r1);
        ALogger.e("RadioStageContainerWidget", r0.toString());
        m r6 = this.a;
        if (r6.e == false) goto L13;
        return;
    L13:
        if (r6.d >= 3) goto L16;
        MainThreadPostUtils.c(new o(this), 2000);
        return;
    L16:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
