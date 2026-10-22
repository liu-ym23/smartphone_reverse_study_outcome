package com.obric.assistant.omnidetailpage.blockview;

import android.view.View;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class y implements BaseResourceViewHolder.a {
    public final /* synthetic */ TaskHeaderView a;
    public final /* synthetic */ Function3<ifa.a, View, Integer, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public y(TaskHeaderView r1, Function3<? super ifa.a, ? super View, ? super Integer, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean b(String r1, View r2) {
        BaseResourceViewHolder.a.a.a(r1, r2);
        return false;
    }

    public final void a(String r2, int r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r4, "v");
        ifa.a r5 = this.a.d.get(r2);
        if (r5 == null) goto L6;
        this.b.invoke(r5, r4, Integer.valueOf(r3));
        return;
    }
}
