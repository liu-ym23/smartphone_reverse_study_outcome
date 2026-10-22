package com.larus.bmhome.double_post.fragment;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.bmhome.video.Content;
import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class b implements Function2 {
    public final /* synthetic */ AwemeDoublePostFragment a;

    public /* synthetic */ b(AwemeDoublePostFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r13, Object r14) {
        AwemeDoublePostFragment r0 = this.a;
        int r4 = ((Integer) r13).intValue();
        RecyclerView.ViewHolder r15 = (RecyclerView.ViewHolder) r14;
        int r16 = AwemeDoublePostFragment.A;
        Intrinsics.checkNotNullParameter(r15, "viewHolder");
        Content r17 = (Content) r0.i.A2(r4);
        boolean r1 = false;
        if (r17 == null) goto L20;
        r17.setHasExposed(true);
        StaggeredGridLayoutManager.LayoutParams r18 = r15.itemView.getLayoutParams();
        if ((r18 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L8;
        StaggeredGridLayoutManager.LayoutParams r19 = r18;
    L9:
        if (r19 == null) goto L11;
        int r5 = r19.getSpanIndex();
    L12:
        int r110 = qr8.a.a;
        Integer r111 = r17.getItemType();
        String r2 = r17.getItemId();
        String r3 = r17.getRequestId();
        Message r6 = r0.t;
        Integer r7 = r17.getImprIndex();
        Message r112 = r0.t;
        if (r112 != null) goto L15;
    L17:
        boolean r8 = false;
    L18:
        qr8.a.c(r111, r2, r3, r4, r5, r6, r7, r8, true, r0.u);
        r1 = true;
        goto L20
    L15:
        if (com.larus.bmhome.chat.bean.d.W(r112) != true) goto L17;
        r8 = true;
        goto L18
    L11:
        r5 = 0;
        goto L12
    L8:
        r19 = null;
    L20:
        return Boolean.valueOf(r1);
    }
}
