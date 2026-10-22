package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.lark_biz_feed_android.LarkFeedListViewObjectLiveQueryFieldType;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowError;
import com.bytedance.lark.lark_biz_feed_android.h0;
import com.bytedance.lark.lark_biz_feed_android.o;
import com.bytedance.lark.molten_livequery_wrapper.h;
import com.bytedance.lark.view_flow_wrapper.j;
import com.bytedance.lark.view_flow_wrapper.r;
import com.bytedance.lark.view_flow_wrapper.u;
import com.bytedance.lark.view_flow_wrapper.v;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LarkFeedListViewFlowWrapper extends r<h0> implements ILarkFeedListViewFlow, j {
    public final j i;
    public final Function1<Continuation<? super h0>, Object> j;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LarkFeedListViewObjectLiveQueryFieldType.values().length];
            r0[LarkFeedListViewObjectLiveQueryFieldType.FeedList.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public final void shutdown() {
        j r0 = this.i;
        if (r0 == null) goto L6;
        r0.shutdown();
        return;
    }

    public final Object b(Continuation<? super h0> r2) {
        return this.j.invoke(r2);
    }

    @Override // com.bytedance.lark.lark_biz_feed_android_wrapper.ILarkFeedListViewFlow
    public final <Inner> i1<Inner> subscribe(final ILarkFeedListViewFlow.c.e<Inner> r3) {
        Intrinsics.checkNotNullParameter(r3, "objectType");
        Function2<h0, Function1<? super Inner, ? extends Unit>, Unit> r0 = new AnonymousClass1(this, r3);
        Intrinsics.checkNotNullParameter(r3, "voType");
        Intrinsics.checkNotNullParameter(r0, "block");
        i1<Inner> r4 = e(r3, u.c.a, r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<Inner of com.bytedance.lark.view_flow_wrapper.MoltenFlowBase.withSubscription?>");
        return r4;
    }

    @Override // com.bytedance.lark.lark_biz_feed_android_wrapper.ILarkFeedListViewFlow
    public final <Item, KeyChange> i1<h<Item, KeyChange>> subscribe(final ILarkFeedListViewFlow.c.C0374c<Item, KeyChange> r3) {
        Intrinsics.checkNotNullParameter(r3, "liveQueryType");
        i1<h<Item, KeyChange>> r4 = e(r3, u.b.a, new AnonymousClass2(this, r3));
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<com.bytedance.lark.molten_livequery_wrapper.LiveList<Item of com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewFlowWrapper.subscribe, KeyChange of com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewFlowWrapper.subscribe>>");
        return r4;
    }

    @Override // com.bytedance.lark.lark_biz_feed_android_wrapper.ILarkFeedListViewFlow
    /* JADX INFO: renamed from: action-vFDjHp0 */
    public final Object mo1707actionvFDjHp0(final o r5, Continuation<? super com.bytedance.lark.view_flow_wrapper.d<? extends ViewFlowError>> r6) {
        if ((r6 instanceof LarkFeedListViewFlowWrapper$action$1) == false) goto L7;
        LarkFeedListViewFlowWrapper$action$1 r0 = (LarkFeedListViewFlowWrapper$action$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
        return ((com.bytedance.lark.view_flow_wrapper.d) r7).a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        Function2<h0, Function1<? super com.bytedance.lark.view_flow_wrapper.d<? extends ViewFlowError>, ? extends Unit>, Unit> r8 = new LarkFeedListViewFlowWrapper$action$2(r5);
        r0.label = 1;
        Object r9 = d(r5, r8, r0);
        if (r9 != r2) goto L18;
        return r2;
    L18:
        return r9;
    L7:
        r0 = new LarkFeedListViewFlowWrapper$action$1(this, r6);
        goto L8
    }

    public LarkFeedListViewFlowWrapper(v r2, ILarkFeedListViewFlow$Companion$of$1.a r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        Intrinsics.checkNotNullParameter(r4, "viewFlowProvider");
        super(r2);
        this.i = r3;
        this.j = r4;
    }
}
