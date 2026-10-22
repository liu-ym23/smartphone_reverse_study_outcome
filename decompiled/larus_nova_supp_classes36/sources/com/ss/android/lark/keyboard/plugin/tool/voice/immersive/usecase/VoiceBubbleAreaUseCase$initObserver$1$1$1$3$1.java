package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class VoiceBubbleAreaUseCase$initObserver$1$1$1$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isAsrDefaultEnable;
    final /* synthetic */ AppCompatTextView $tipsReleaseSend;
    final /* synthetic */ VoiceBubbleAreaUseCase this$0;

    public VoiceBubbleAreaUseCase$initObserver$1$1$1$3$1(boolean r1, AppCompatTextView r2, Context r3, VoiceBubbleAreaUseCase r4) {
        this.$isAsrDefaultEnable = r1;
        this.$tipsReleaseSend = r2;
        this.$context = r3;
        this.this$0 = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1333invoke() {
        if (this.$isAsrDefaultEnable == false) goto L5;
        this.$tipsReleaseSend.setText(this.$context.getString(2131890971));
        AppCompatTextView r0 = this.$tipsReleaseSend;
        Intrinsics.checkNotNull(r0);
        r0.setVisibility(0);
        this.this$0.d.n().setVisibility(8);
        return;
    L5:
        this.this$0.d.n().setText(this.$context.getString(2131890971));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1333invoke();
        return Unit.INSTANCE;
    }
}
