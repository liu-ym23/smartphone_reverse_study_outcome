package com.bytedance.android.livesdk.drawer.history;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ LoadingViewHolder a;

    public h(LoadingViewHolder r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L5;
        LoadingViewHolder r4 = this.a;
        r4.a.setVisibility(0);
        r4.a.b();
        return;
    L5:
        LoadingViewHolder r5 = this.a;
        r5.a.setVisibility(8);
        r5.a.c();
    }
}
