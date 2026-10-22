package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import android.text.SpannableString;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/text/SpannableString;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryFragment$subscribeRichContent$3$1$parsedMarkdown$1", f = "MmSummaryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmSummaryFragment$subscribeRichContent$3$1$parsedMarkdown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SpannableString>, Object> {
    final /* synthetic */ String $richContent;
    int label;

    public MmSummaryFragment$subscribeRichContent$3$1$parsedMarkdown$1(String r1, Continuation<? super MmSummaryFragment$subscribeRichContent$3$1$parsedMarkdown$1> r2) {
        this.$richContent = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmSummaryFragment$subscribeRichContent$3$1$parsedMarkdown$1(this.$richContent, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super SpannableString> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        yvb.b r3 = new yvb.b();
        r3.a(this.$richContent);
        return new SpannableString(r3.c);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
