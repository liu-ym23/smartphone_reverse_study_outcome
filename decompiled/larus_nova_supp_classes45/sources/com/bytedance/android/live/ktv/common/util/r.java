package com.bytedance.android.live.ktv.common.util;

import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r {
    public final d0 a;
    public final com.bytedance.android.live.pushstream.d b;
    public final int c;
    public final int d;

    private final Context getContext() {
        d0 r0 = this.a;
        if (r0 == null) goto L9;
        d0.a r1 = r0.getBuilder();
        if (r1 == null) goto L9;
        Context r2 = r1.getContext();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return s1.getContext();
    }

    public final void a() {
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r1 = ILiveWrappedLivePusher.a.b();
        if (r1 == null) goto L12;
        Context r2 = getContext();
        int r3 = this.c;
        int r4 = this.d;
        d0 r0 = this.a;
        if (r0 == null) goto L9;
        d0.a r5 = r0.getBuilder();
        if (r5 == null) goto L9;
        int r6 = r5.z();
    L10:
        r1.newShortVideoPushManager(r2, r3, r4, r6, new q());
        return;
    L9:
        r6 = 25;
        goto L10
    }

    public r(com.bytedance.android.live.pushstream.d r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "liveStream");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = r2.A();
    }
}
