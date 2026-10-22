package com.bytedance.android.livesdk.interactivity.comment.input;

import android.graphics.drawable.Drawable;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends b implements com.bytedance.android.livesdk.interactivity.api.e {
    public final int f;
    public final int g;
    public final com.bytedance.android.live.base.model.message.h h;

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b
    public final int a() {
        return 6;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b
    public final String getDesc() {
        String r0 = this.h.c();
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    public d(Drawable r2, com.bytedance.android.live.base.model.message.h r3, String r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "spanDrawable");
        Intrinsics.checkNotNullParameter(r3, "guideChatConf");
        Intrinsics.checkNotNullParameter(r4, "text");
        super(r2, r5, r6);
        this.h = r3;
        this.f = r4.length();
        String r7 = r3.c();
        if (r7 == null) goto L5;
        int r8 = r7.length();
    L6:
        this.g = r8;
        return;
    L5:
        r8 = 0;
        goto L6
    }
}
