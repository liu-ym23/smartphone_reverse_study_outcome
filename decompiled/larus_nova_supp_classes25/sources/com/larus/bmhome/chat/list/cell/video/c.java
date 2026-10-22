package com.larus.bmhome.chat.list.cell.video;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.video.Content;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c implements Function3 {
    public final /* synthetic */ AwemePostListCell a;
    public final /* synthetic */ d b;

    public /* synthetic */ c(AwemePostListCell r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r12, Object r13, Object r14) {
        AwemePostListCell r0 = this.a;
        d r1 = this.b;
        Content r15 = (Content) r12;
        int r5 = ((Integer) r13).intValue();
        int r16 = ((Integer) r14).intValue();
        Intrinsics.checkNotNullParameter(r15, "data");
        RecyclerView r17 = ((BaseMessageListCell) r0).b;
        q0 r2 = null;
        if (r17 == null) goto L5;
        RecyclerView.Adapter r18 = r17.getAdapter();
    L7:
        if ((r18 instanceof q0) == false) goto L9;
        r2 = (q0) r18;
    L9:
        if (r2 == null) goto L12;
        int r19 = qr8.a.a;
        qr8.a.d(r15.getItemType(), r15.getItemId(), r15.getRequestId(), r5, r5 % r16, r1.a, true, r15.getRequestId(), 640);
    L12:
        return Unit.INSTANCE;
    L5:
        r18 = null;
        goto L7
    }
}
