package com.larus.ugc.feed.impl.component;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class s implements Function2 {
    public final /* synthetic */ CreationFeedComponent a;

    public /* synthetic */ s(CreationFeedComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        CreationFeedComponent r0 = this.a;
        int r5 = ((Integer) r3).intValue();
        int r1 = CreationFeedComponent.H;
        Intrinsics.checkNotNullParameter((RecyclerView.ViewHolder) r4, "<unused var>");
        r0.G3(r5);
        return Boolean.TRUE;
    }
}
