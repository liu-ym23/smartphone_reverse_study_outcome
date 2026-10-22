package com.ss.android.lark.flow.feed.base;

import com.larksuite.arch.jack.d;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import com.ss.android.lark.feed.shared.page.s;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/larksuite/arch/jack/Event;", "Lcom/ss/android/lark/feed/shared/data/preview/FeedPreview;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.feed.base.MixedFeedDataController$observeStateFlow$1$1$1", f = "MixedFeedDataController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MixedFeedDataController$observeStateFlow$1$1$1 extends SuspendLambda implements Function2<d<? extends FeedPreview>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MixedFeedDataController<s> this$0;

    public MixedFeedDataController$observeStateFlow$1$1$1(MixedFeedDataController<s> r1, Continuation<? super MixedFeedDataController$observeStateFlow$1$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MixedFeedDataController$observeStateFlow$1$1$1 r0 = new MixedFeedDataController$observeStateFlow$1$1$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(d<? extends FeedPreview> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((d) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r4);
        d r5 = (d) this.L$0;
        if (r5 == null) goto L10;
        FeedPreview r6 = (FeedPreview) r5.a();
        if (r6 == null) goto L10;
        MixedFeedDataController<s> r0 = this.this$0;
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "observeStateFlow notifyItemChanged");
        r0.b.getAdapter().notifyItemChanged(r6);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
