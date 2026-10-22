package com.bytedance.android.live.revlink.impl.pk.feedview;

import com.bytedance.android.livesdkapi.view.IRenderView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class FeedPkWidget$lynxWidget$1 extends FunctionReferenceImpl implements Function0<Pair<? extends Integer, ? extends Integer>> {
    public FeedPkWidget$lynxWidget$1(FeedPkWidget r8) {
        super(0, r8, FeedPkWidget.class, "getPlayerWH", "getPlayerWH()Lkotlin/Pair;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final Pair<Integer, Integer> m810invoke() {
        com.bytedance.android.live.revlink.impl.pk.feedview.sei.c r0 = ((FeedPkWidget) ((CallableReference) this).receiver).d.i;
        r0.getClass();
        IRenderView r2 = r0.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.getWidth();
    L6:
        Integer r5 = Integer.valueOf(r4);
        IRenderView r1 = r0.b;
        if (r1 == null) goto L10;
        r3 = r1.getHeight();
    L10:
        return new Pair(r5, Integer.valueOf(r3));
    L5:
        r4 = 0;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m810invoke();
    }
}
