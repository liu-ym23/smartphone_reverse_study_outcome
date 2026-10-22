package com.bytedance.android.livesdk.gift.format;

import android.content.Context;
import com.bytedance.android.scope.o;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements tr.b, o {
    public WeakReference<GiftPlayerView> a;

    public a() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final GiftPlayerView j5(Context r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        GiftPlayerView r0 = new GiftPlayerView(r5, null, 6, 0);
        if (r6 == true) goto L5;
        this.a = new WeakReference(r0);
    L5:
        return r0;
    }
}
