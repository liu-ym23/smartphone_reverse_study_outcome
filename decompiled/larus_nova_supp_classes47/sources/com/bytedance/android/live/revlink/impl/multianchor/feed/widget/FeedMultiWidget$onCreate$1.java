package com.bytedance.android.live.revlink.impl.multianchor.feed.widget;

import k31.h;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class FeedMultiWidget$onCreate$1 extends FunctionReferenceImpl implements Function0<Pair<? extends Integer, ? extends Integer>> {
    public FeedMultiWidget$onCreate$1(FeedMultiWidget r8) {
        super(0, r8, FeedMultiWidget.class, "getPlayerWH", "getPlayerWH()Lkotlin/Pair;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final Pair<Integer, Integer> m673invoke() {
        h r0 = ((FeedMultiWidget) ((CallableReference) this).receiver).p.c;
        if (r0 == null) goto L6;
        return TuplesKt.to(Integer.valueOf(r0.a), Integer.valueOf(r0.b));
    L6:
        return TuplesKt.to(0, 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m673invoke();
    }
}
