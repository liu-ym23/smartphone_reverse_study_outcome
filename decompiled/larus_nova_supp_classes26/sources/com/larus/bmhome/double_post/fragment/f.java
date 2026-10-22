package com.larus.bmhome.double_post.fragment;

import com.larus.bmhome.video.Content;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ AwemeDoublePostFragment a;

    public /* synthetic */ f(AwemeDoublePostFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        AwemeDoublePostFragment r0 = this.a;
        v r7 = (v) r6;
        int r1 = AwemeDoublePostFragment.A;
        int r2 = r7.a;
        List<Content> r8 = r7.b;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("AwemeDoublePostViewModel awemeContentList: code = ");
        r4.append(r2);
        r4.append(", contentListSize = ");
        if (r8 == null) goto L5;
        Integer r5 = Integer.valueOf(r8.size());
    L6:
        r4.append(r5);
        r4.append(", listAdapter.itemCount = ");
        r4.append(r0.i.getItemCount());
        r3.i("AwemeDoublePostFragment", r4.toString());
        if (r2 != (-2)) goto L9;
        r0.i.loadMoreFail();
    L23:
        return Unit.INSTANCE;
    L9:
        if (r2 == (-1)) goto L20;
        if (r2 != 0) goto L23;
        if (r8 != null) goto L15;
        r8 = CollectionsKt.emptyList();
    L15:
        if (r8.isEmpty() == true) goto L17;
    L19:
        r0.i.P2();
        r0.i.E2(r8);
        goto L23
    L17:
        if (r0.i.getItemCount() != 0) goto L19;
        r0.i.O2();
        goto L23
    L20:
        r0.i.H2();
        goto L23
    L5:
        r5 = null;
        goto L6
    }
}
