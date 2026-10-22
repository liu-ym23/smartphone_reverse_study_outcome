package com.ss.android.lark.flow.feed.sidebar.adapter;

import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.List;
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
@DebugMetadata(c = "com.ss.android.lark.flow.feed.sidebar.adapter.FeedSidebarAdapterWrapper$dataDelegate$2$1$onUserReadyAttached$1$1$1", f = "FeedSidebarAdapterWrapper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FeedSidebarAdapterWrapper$dataDelegate$2$1$onUserReadyAttached$1$1$1 extends SuspendLambda implements Function2<com.larksuite.arch.jack.d<? extends FeedPreview>, Continuation<? super Unit>, Object> {
    final /* synthetic */ FeedSidebarAdapterWrapper $this_with;
    /* synthetic */ Object L$0;
    int label;

    public FeedSidebarAdapterWrapper$dataDelegate$2$1$onUserReadyAttached$1$1$1(FeedSidebarAdapterWrapper r1, Continuation<? super FeedSidebarAdapterWrapper$dataDelegate$2$1$onUserReadyAttached$1$1$1> r2) {
        this.$this_with = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FeedSidebarAdapterWrapper$dataDelegate$2$1$onUserReadyAttached$1$1$1 r0 = new FeedSidebarAdapterWrapper$dataDelegate$2$1$onUserReadyAttached$1$1$1(this.$this_with, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.larksuite.arch.jack.d<? extends FeedPreview> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larksuite.arch.jack.d) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r3);
        com.larksuite.arch.jack.d r4 = (com.larksuite.arch.jack.d) this.L$0;
        if (r4 == null) goto L15;
        FeedPreview r5 = (FeedPreview) r4.a();
        if (r5 == null) goto L15;
        FeedSidebarAdapterWrapper r0 = this.$this_with;
        List r1 = r0.b().getItems();
        if (r1 == null) goto L11;
        int r6 = r1.indexOf(r5);
    L12:
        if (r6 < 0) goto L15;
        r0.b().notifyItemChanged(r6);
        goto L15
    L11:
        r6 = -1;
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
