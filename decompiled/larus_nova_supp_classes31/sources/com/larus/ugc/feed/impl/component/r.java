package com.larus.ugc.feed.impl.component;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class r implements Function2 {
    public final /* synthetic */ CreationFeedComponent a;

    public /* synthetic */ r(CreationFeedComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2, Object r3) {
        CreationFeedComponent r0 = this.a;
        ((Integer) r2).intValue();
        int r4 = CreationFeedComponent.H;
        Intrinsics.checkNotNullParameter((RecyclerView.ViewHolder) r3, "<unused var>");
        return Boolean.valueOf(r0.u);
    }
}
