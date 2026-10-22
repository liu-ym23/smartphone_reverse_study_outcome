package com.ss.android.lark.feed.shared.page.binder2;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.shared.page.binder2.FeedCommonViewHolder$delayUpdate$1", f = "FeedCommonViewHolder.kt", i = {}, l = {267}, m = "invokeSuspend", n = {}, s = {})
final class FeedCommonViewHolder$delayUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.feed.export.feedcard.d $feedCardContext;
    final /* synthetic */ UIFeedCard $uiFeedCard;
    int label;
    final /* synthetic */ FeedCommonViewHolder this$0;

    public FeedCommonViewHolder$delayUpdate$1(FeedCommonViewHolder r1, com.ss.android.lark.feed.export.feedcard.d r2, UIFeedCard r3, Continuation<? super FeedCommonViewHolder$delayUpdate$1> r4) {
        this.this$0 = r1;
        this.$feedCardContext = r2;
        this.$uiFeedCard = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FeedCommonViewHolder$delayUpdate$1(this.this$0, this.$feedCardContext, this.$uiFeedCard, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        this.this$0.s.setSelected(false);
        FeedCommonViewHolder r7 = this.this$0;
        com.ss.android.lark.feed.export.feedcard.d r3 = this.$feedCardContext;
        UIFeedCard r4 = this.$uiFeedCard;
        r7.getClass();
        FragmentActivity r8 = r3.getHost().getActivity();
        if (r8 != null) goto L14;
    L18:
        r2 = false;
    L19:
        if (r2 == false) goto L26;
        if (com.ss.android.lark.feed.shared.fg.c.a() == false) goto L26;
        if (com.ss.android.lark.feed.shared.fg.c.a.isCurrentEnable("im.feed.priority.messagesync") == false) goto L26;
        int r9 = neb.c.a;
        ((neb.a) e0c.k.a(LarkContext.getApplication(), neb.a.class)).qe(r4.getId());
    L26:
        return Unit.INSTANCE;
    L14:
        if (com.ss.android.lark.base.embedded.b.b(r8) == true) goto L19;
        if (ForsetiConfig.a(r8) == false) goto L18;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(350, this) != r0) goto L11;
        return r0;
    }
}
