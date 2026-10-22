package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.content.Context;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements a {
    public final Context a;

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.a
    public final HSImageView b() {
        return new HSImageView(this.a);
    }

    public final Context getContext() {
        return this.a;
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.a
    public final void a(HSImageView r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.setTag(null);
    }
}
