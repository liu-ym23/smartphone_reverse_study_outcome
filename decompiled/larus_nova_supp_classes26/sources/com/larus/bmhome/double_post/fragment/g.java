package com.larus.bmhome.double_post.fragment;

import android.content.Context;
import com.larus.bmhome.video.Content;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class g implements Function1 {
    public final /* synthetic */ AwemeDoublePostFragment a;

    public /* synthetic */ g(AwemeDoublePostFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r7) {
        AwemeDoublePostFragment r0 = this.a;
        v r8 = (v) r7;
        int r1 = AwemeDoublePostFragment.A;
        int r2 = r8.a;
        List<Content> r9 = r8.b;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("awemeRefreshList: code = ");
        r4.append(r2);
        r4.append(", contentListSize = ");
        Content r5 = null;
        if (r9 == null) goto L5;
        Integer r6 = Integer.valueOf(r9.size());
    L6:
        r4.append(r6);
        r3.i("AwemeDoublePostFragment", r4.toString());
        if (r2 == (-2)) goto L23;
        if (r2 == (-1)) goto L21;
        if (r2 != 0) goto L30;
        if (r9 != null) goto L14;
        List<Content> r10 = CollectionsKt.emptyList();
    L16:
        if ((!r10.isEmpty()) == false) goto L18;
        r0.ba0(r10);
    L18:
        if (r9 == null) goto L20;
        r5 = (Content) CollectionsKt.lastOrNull(r9);
    L20:
        r0.r = r5;
        goto L30
    L14:
        r10 = r9;
    L30:
        return Unit.INSTANCE;
    L21:
        r0.i.H2();
        goto L30
    L23:
        if (r0.i.getItemCount() != 0) goto L25;
    L28:
        r0.i.loadMoreFail();
        goto L30
    L25:
        if (r0.i.K2() == true) goto L28;
        t19.s r11 = t19.s.a;
        Context r12 = r0.getContext();
        r11.getClass();
        t19.s.b(r12, 2131908080, false);
        goto L30
    L5:
        r6 = null;
        goto L6
    }
}
