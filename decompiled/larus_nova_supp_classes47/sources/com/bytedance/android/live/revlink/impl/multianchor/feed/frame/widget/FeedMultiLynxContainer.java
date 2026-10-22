package com.bytedance.android.live.revlink.impl.multianchor.feed.frame.widget;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import f31.k;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedMultiLynxContainer {
    public final Lazy a;
    public boolean b;
    public final Context c;
    public final FrameLayout d;
    public final MutableLiveData<List<k>> e;

    public FeedMultiLynxContainer(Context r2, FrameLayout r3, MutableLiveData<List<k>> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "windowStatus");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = LazyKt.lazy(new FeedMultiLynxContainer$component$2(this));
    }
}
