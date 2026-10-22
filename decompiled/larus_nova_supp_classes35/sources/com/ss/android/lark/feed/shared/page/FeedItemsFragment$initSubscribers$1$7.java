package com.ss.android.lark.feed.shared.page;

import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "event", "Lcom/larksuite/arch/jack/Event;", "Lcom/ss/android/lark/feed/shared/data/preview/FeedPreview;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.shared.page.FeedItemsFragment$initSubscribers$1$7", f = "FeedItemsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FeedItemsFragment$initSubscribers$1$7 extends SuspendLambda implements Function2<com.larksuite.arch.jack.d<? extends FeedPreview>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedItemsFragment this$0;

    public FeedItemsFragment$initSubscribers$1$7(FeedItemsFragment r1, Continuation<? super FeedItemsFragment$initSubscribers$1$7> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FeedItemsFragment$initSubscribers$1$7 r0 = new FeedItemsFragment$initSubscribers$1$7(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.larksuite.arch.jack.d<? extends FeedPreview> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larksuite.arch.jack.d) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        com.larksuite.arch.jack.d r5 = (com.larksuite.arch.jack.d) this.L$0;
        if (r5 == null) goto L12;
        FeedPreview r6 = (FeedPreview) r5.a();
        if (r6 == null) goto L12;
        FragmentActivity r0 = this.this$0.getActivity();
        if (r0 == null) goto L12;
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r6, "feedPreview");
        new UDDialogBuilder(r0).message(UIHelper.getString(2131890574)).addActionButton(2131391777, UIHelper.getString(2131890581), g.a).show();
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
