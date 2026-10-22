package com.bytedance.android.livesdk.interactivity.comment.input;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends b implements com.bytedance.android.livesdk.interactivity.api.e {
    public final String f;

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b
    public final int a() {
        return 7;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b
    public final String getDesc() {
        return this.f;
    }

    public e(Drawable r2, String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "spanDrawable");
        Intrinsics.checkNotNullParameter(r3, "text");
        super(r2, r4, r5);
        this.f = r3;
    }
}
