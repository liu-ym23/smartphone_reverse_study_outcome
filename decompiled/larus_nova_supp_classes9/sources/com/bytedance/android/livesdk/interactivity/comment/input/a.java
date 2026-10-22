package com.bytedance.android.livesdk.interactivity.comment.input;

import android.graphics.drawable.Drawable;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends b {
    public final com.bytedance.android.live.base.model.data.activityemoji.b f;

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b
    public final int a() {
        return 3;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b
    public final String getDesc() {
        String r0 = this.f.getName();
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    public a(Drawable r2, com.bytedance.android.live.base.model.data.activityemoji.b r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "spanDrawable");
        Intrinsics.checkNotNullParameter(r3, "activityEmoji");
        super(r2, r4, r5);
        this.f = r3;
    }
}
