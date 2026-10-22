package com.bytedance.android.livesdk.interactivity.comment.input;

import android.graphics.drawable.Drawable;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends b {
    public final int f;
    public final com.bytedance.android.livesdk.interactivity.api.emoji.a g;

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b
    public final int a() {
        return 5;
    }

    public final String c() {
        List<String> r0 = this.g.e();
        if (r0 == null) goto L7;
        String r1 = CollectionsKt.joinToString$default(r0, BuildConfig.FLAVOR, null, null, 0, null, null, 62, null);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return getDesc();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b
    public final String getDesc() {
        String r0 = this.g.d();
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.b
    public int getType() {
        return this.f;
    }

    public c(Drawable r2, com.bytedance.android.livesdk.interactivity.api.emoji.a r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "spanDrawable");
        Intrinsics.checkNotNullParameter(r3, "fusionEmoji");
        super(r2, r4, r5);
        this.g = r3;
        this.f = 1;
    }
}
