package com.ss.android.lark.flow.feed.sidebar.adapter;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "canLoadMore", ""}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.feed.sidebar.adapter.FeedSidebarAdapterWrapper$dataDelegate$2$1$onUserReadyAttached$1$1$2", f = "FeedSidebarAdapterWrapper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FeedSidebarAdapterWrapper$dataDelegate$2$1$onUserReadyAttached$1$1$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ FeedSidebarAdapterWrapper $this_with;
    /* synthetic */ boolean Z$0;
    int label;

    public FeedSidebarAdapterWrapper$dataDelegate$2$1$onUserReadyAttached$1$1$2(FeedSidebarAdapterWrapper r1, Continuation<? super FeedSidebarAdapterWrapper$dataDelegate$2$1$onUserReadyAttached$1$1$2> r2) {
        this.$this_with = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FeedSidebarAdapterWrapper$dataDelegate$2$1$onUserReadyAttached$1$1$2 r0 = new FeedSidebarAdapterWrapper$dataDelegate$2$1$onUserReadyAttached$1$1$2(this.$this_with, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        boolean r5 = this.Z$0;
        com.ss.android.lark.flow.feed.utils.b.d("FeedSidebarAdapterWrapper", "observe canLoadMoreState, canLoadMore=" + r5);
        FeedSidebarAdapter r0 = this.$this_with.b();
        if (r0.H != r5) goto L7;
        r0.O2("setCanLoadMoreSkipped", "canLoadMore=" + r5);
    L12:
        return Unit.INSTANCE;
    L7:
        r0.H = r5;
        r0.O2("setCanLoadMore", "canLoadMore=" + r5);
        if (r5 == true) goto L10;
        r0.U2("can load more is false");
    L10:
        r0.L2();
        r0.Q2();
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
