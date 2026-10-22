package com.obric.assistant.cocreationreview;

import android.content.Context;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationFeedbackPanelFragment$openImageEditor$1$imagePath$1", f = "CocreationFeedbackPanelFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CocreationFeedbackPanelFragment$openImageEditor$1$imagePath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ b5 $current;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CocreationFeedbackPanelFragment this$0;

    public CocreationFeedbackPanelFragment$openImageEditor$1$imagePath$1(CocreationFeedbackPanelFragment r1, Context r2, b5 r3, Continuation<? super CocreationFeedbackPanelFragment$openImageEditor$1$imagePath$1> r4) {
        this.this$0 = r1;
        this.$context = r2;
        this.$current = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        CocreationFeedbackPanelFragment$openImageEditor$1$imagePath$1 r0 = new CocreationFeedbackPanelFragment$openImageEditor$1$imagePath$1(this.this$0, this.$context, this.$current, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        CocreationFeedbackPanelFragment r6 = this.this$0;
        Context r0 = this.$context;
        b5 r1 = this.$current;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L7
        Object r7 = Result.constructor-impl(CocreationFeedbackPanelFragment.U90(r6, r0, r1));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r7) == false) goto L17;
        return null;
    L17:
        return r7;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
