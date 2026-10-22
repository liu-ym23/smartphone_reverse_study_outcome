package com.ss.android.lark.flow.feed.sidebar.human;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "nextCanLoadMore", ""}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.feed.sidebar.human.OfficeSidebarHumanFeedController$attachViewModelListeners$1$1$2", f = "OfficeSidebarHumanFeedController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OfficeSidebarHumanFeedController$attachViewModelListeners$1$1$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ OfficeSidebarHumanFeedController $this_with;
    /* synthetic */ boolean Z$0;
    int label;

    public OfficeSidebarHumanFeedController$attachViewModelListeners$1$1$2(OfficeSidebarHumanFeedController r1, Continuation<? super OfficeSidebarHumanFeedController$attachViewModelListeners$1$1$2> r2) {
        this.$this_with = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        OfficeSidebarHumanFeedController$attachViewModelListeners$1$1$2 r0 = new OfficeSidebarHumanFeedController$attachViewModelListeners$1$1$2(this.$this_with, r4);
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
        OfficeSidebarHumanFeedController r0 = this.$this_with;
        if (r0.q != r5) goto L8;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "canLoadMore unchanged=" + this.$this_with.q);
        return Unit.INSTANCE;
    L8:
        r0.q = r5;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "canLoadMore changed=" + this.$this_with.q);
        OfficeSidebarHumanFeedController.s(this.$this_with, CollectionsKt.emptyList());
        OfficeSidebarHumanFeedController r6 = this.$this_with;
        if (r6.s == false) goto L11;
        r6.y();
    L11:
        this.$this_with.p();
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
