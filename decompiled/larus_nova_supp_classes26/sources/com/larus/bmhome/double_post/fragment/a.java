package com.larus.bmhome.double_post.fragment;

import com.larus.bmhome.video.Content;
import com.larus.common_ui.paging.FPagingAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ AwemeDoublePostFragment a;

    public /* synthetic */ a(AwemeDoublePostFragment r1) {
        this.a = r1;
    }

    public final Object invoke() {
        AwemeDoublePostFragment r0 = this.a;
        int r1 = AwemeDoublePostFragment.A;
        List r2 = CollectionsKt.toMutableList(((FPagingAdapter) r0.i).b);
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        String r5 = ((Content) r4.next()).getItemId();
        if (r5 == null) goto L4;
        r3.add(r5);
        goto L4
    L8:
        return r3;
    }
}
