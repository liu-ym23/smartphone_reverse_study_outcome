package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.content.Context;
import android.text.TextUtils;
import com.ss.ttvideoengine.TTVideoEngine;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q implements nic.f {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ String b;

    public q(Function1 r1) {
        this.a = r1;
        this.b = null;
    }

    public final TTVideoEngine b(Context r2, tic.a r3, nic.e r4) {
        TTVideoEngine r5 = new TTVideoEngine(r2, 0);
        r5.setIntOption(17, 1);
        r5.setIntOption(160, 1);
        r5.setIntOption(7, 1);
        r5.setIntOption(510, 1);
        r5.setIntOption(198, 1);
        r5.setAsyncInit(true, 0);
        fq1.d.a().getColorWeakModelEffectInfo();
        this.a.invoke(r5);
        if (TextUtils.isEmpty(this.b) == true) goto L5;
        String r6 = this.b;
        Intrinsics.checkNotNull(r6);
        r5.setDirectURL(r6);
    L5:
        int r7 = r.a;
        Intrinsics.checkNotNullParameter(r5, "engine");
        r5.setLoadControl(new s());
        return r5;
    }
}
