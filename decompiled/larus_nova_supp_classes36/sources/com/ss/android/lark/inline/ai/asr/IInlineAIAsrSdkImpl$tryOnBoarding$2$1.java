package com.ss.android.lark.inline.ai.asr;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class IInlineAIAsrSdkImpl$tryOnBoarding$2$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Ref.BooleanRef $canceled;

    public IInlineAIAsrSdkImpl$tryOnBoarding$2$1(Ref.BooleanRef r1) {
        this.$canceled = r1;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Throwable) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable r2) {
        this.$canceled.element = true;
    }
}
