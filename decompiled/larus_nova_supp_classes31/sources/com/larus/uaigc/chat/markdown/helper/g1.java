package com.larus.uaigc.chat.markdown.helper;

import com.larus.platform.api.IVideoController;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class g1 implements Function2 {
    public final /* synthetic */ rd8.b a;

    public /* synthetic */ g1(rd8.b r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2, Object r3) {
        rd8.b r0 = this.a;
        String r4 = (String) r2;
        IVideoController r5 = (IVideoController) r3;
        if (r0 == null) goto L11;
        kh8.a r1 = r0.q3();
        if (r1 == null) goto L11;
        if (r5 == null) goto L8;
        Integer r6 = Integer.valueOf(r5.getCurrentPlaybackTime());
    L9:
        r1.e(r4, r6);
        goto L11
    L8:
        r6 = null;
    L11:
        return Unit.INSTANCE;
    }
}
