package com.larus.bmhome.double_post.fragment;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.video.Content;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class n implements Function2 {
    public final /* synthetic */ AwemeDoublePostFragment a;

    public /* synthetic */ n(AwemeDoublePostFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        AwemeDoublePostFragment r0 = this.a;
        int r5 = ((Integer) r3).intValue();
        int r1 = AwemeDoublePostFragment.A;
        Intrinsics.checkNotNullParameter((RecyclerView.ViewHolder) r4, "<unused var>");
        Content r6 = (Content) r0.i.A2(r5);
        if (r6 == null) goto L7;
        boolean r7 = true;
        if (ip8.d.a(r6) != true) goto L7;
    L9:
        return Boolean.valueOf(r7);
    L7:
        r7 = false;
        goto L9
    }
}
