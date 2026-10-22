package com.ss.android.lark.flow.feed.base;

import com.larksuite.arch.jack.d;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/larksuite/arch/jack/Event;", ""}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.feed.base.MixedFeedDataController$observeStateFlow$1$1$3", f = "MixedFeedDataController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MixedFeedDataController$observeStateFlow$1$1$3 extends SuspendLambda implements Function2<d<? extends String>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MixedFeedDataController<s> this$0;

    public MixedFeedDataController$observeStateFlow$1$1$3(MixedFeedDataController<s> r1, Continuation<? super MixedFeedDataController$observeStateFlow$1$1$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MixedFeedDataController$observeStateFlow$1$1$3 r0 = new MixedFeedDataController$observeStateFlow$1$1$3(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(d<String> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((d) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        d r4 = (d) this.L$0;
        if (r4 == null) goto L10;
        String r5 = (String) r4.a();
        if (r5 == null) goto L10;
        MixedFeedDataController<s> r0 = this.this$0;
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "refresh hint item, feed id:".concat(r5));
        r0.b.getAdapter().notifyDataSetChanged();
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
