package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class VoiceBubbleAreaUseCase$initObserver$1$1$1$4$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VoiceBubbleAreaUseCase this$0;

    public VoiceBubbleAreaUseCase$initObserver$1$1$1$4$3(VoiceBubbleAreaUseCase r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1336invoke() {
        VoiceImeWrapperUseCase.f(this.this$0.c, 0, false, 7);
        this.this$0.f().whenSwitch2Recognizing();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1336invoke();
        return Unit.INSTANCE;
    }
}
