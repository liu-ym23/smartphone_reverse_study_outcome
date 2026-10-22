package com.bytedance.android.live.profit.format.voicechat.model;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public final Context a;
    public final String b;
    public final String c;
    public final d d;
    public final long e;
    public final long f;

    public final Context getContext() {
        return this.a;
    }

    public e(Context r4, String r5, String r6, d r7, long r8) {
        long r0 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter(r6, "authorId");
        Intrinsics.checkNotNullParameter(r7, "startInfo");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r0;
    }
}
