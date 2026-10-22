package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n {
    public final Context a;
    public final DataCenter b;
    public final com.bytedance.android.livesdk.interactivity.comment.highlight.b c;
    public final long d;
    public final long e;

    public final Context getContext() {
        return this.a;
    }

    public n(Context r2, DataCenter r3, com.bytedance.android.livesdk.interactivity.comment.highlight.b r4, long r5, long r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "highlightData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
    }
}
