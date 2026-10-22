package com.larus.bmhome.double_post.fragment;

import com.larus.bmhome.double_post.adapter.AwemeRecommendAdapter;
import com.larus.bmhome.video.Content;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ AwemeDoublePostFragment a;

    public /* synthetic */ h(AwemeDoublePostFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r11) {
        AwemeDoublePostFragment r0 = this.a;
        v r12 = (v) r11;
        int r1 = AwemeDoublePostFragment.A;
        int r2 = r12.a;
        List<Content> r13 = r12.b;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("awemeLoadMoreList: code = ");
        r4.append(r2);
        r4.append(", contentListSize = ");
        Content r5 = null;
        if (r13 == null) goto L5;
        Integer r6 = Integer.valueOf(r13.size());
    L6:
        r4.append(r6);
        r3.i("AwemeDoublePostFragment", r4.toString());
        if (r2 == (-1)) goto L42;
        if (r2 == 0) goto L10;
        r0.i.loadMoreFail();
    L44:
        return Unit.INSTANCE;
    L10:
        AwemeRecommendAdapter r7 = r0.i;
        if (r13 != null) goto L13;
        r7.getClass();
    L28:
        boolean r8 = true;
    L29:
        if (r8 == false) goto L31;
        r0.i.O2();
        goto L44
    L31:
        r0.i.P2();
        if (r0.j == true) goto L51;
        AwemeRecommendAdapter r9 = r0.i;
        if (r13 != null) goto L37;
        List<Content> r10 = CollectionsKt.emptyList();
    L38:
        r9.y2(r10);
        if (r13 == null) goto L41;
        r5 = (Content) CollectionsKt.lastOrNull(r13);
    L41:
        r0.r = r5;
        goto L44
    L37:
        r10 = r13;
        goto L38
    L51:
        return Unit.INSTANCE;
    L13:
        ArrayList r14 = (ArrayList) ((FPagingAdapter) r7).b;
        r8 = false;
        if (r14.isEmpty() == true) goto L29;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L18:
        if (r16.hasNext() == false) goto L20;
        r15.add(((Content) r16.next()).getItemId());
        goto L18
    L20:
        HashSet r17 = CollectionsKt.toHashSet(r15);
        Iterator<Content> r18 = r13.iterator();
        int r19 = 0;
    L22:
        if (r18.hasNext() == false) goto L27;
        Content r20 = r18.next();
        if (r17.contains(r20.getItemId()) == false) goto L22;
        r19 = r19 + 1;
        FLogger.a.i("AwemeRecommendAdapter", "isLoadMoreAllRepeatContent: repeatCount(" + r19 + "),itemId(" + r20.getItemId() + ") is repeated, requestId(" + r20.getRequestId() + "))");
        goto L22
    L27:
        if (r19 != r13.size()) goto L29;
    L42:
        r0.i.H2();
        goto L44
    L5:
        r6 = null;
        goto L6
    }
}
