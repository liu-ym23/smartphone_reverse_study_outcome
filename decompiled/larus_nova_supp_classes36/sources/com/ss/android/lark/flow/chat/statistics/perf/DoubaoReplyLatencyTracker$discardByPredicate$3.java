package com.ss.android.lark.flow.chat.statistics.perf;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/flow/chat/statistics/perf/DoubaoReplyLatencyTracker$Trace;", "Lkotlin/jvm/internal/EnhancedNullability;", "invoke", "(Lcom/ss/android/lark/flow/chat/statistics/perf/DoubaoReplyLatencyTracker$Trace;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DoubaoReplyLatencyTracker$discardByPredicate$3 extends Lambda implements Function1<a.b, Boolean> {
    final /* synthetic */ Function1<a.b, Boolean> $pred;

    /* JADX WARN: Multi-variable type inference failed */
    public DoubaoReplyLatencyTracker$discardByPredicate$3(Function1<? super a.b, Boolean> r1) {
        this.$pred = r1;
        super(1);
    }

    public final Boolean invoke(a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Boolean) this.$pred.invoke(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((a.b) r1);
    }
}
