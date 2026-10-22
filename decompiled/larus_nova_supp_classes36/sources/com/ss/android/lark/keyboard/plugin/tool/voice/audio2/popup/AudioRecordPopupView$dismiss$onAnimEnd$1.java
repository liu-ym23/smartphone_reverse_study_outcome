package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioRecordPopupView$dismiss$onAnimEnd$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ AudioRecordPopupView this$0;

    public AudioRecordPopupView$dismiss$onAnimEnd$1(AudioRecordPopupView r1, Function0<Unit> r2) {
        this.this$0 = r1;
        this.$onDismiss = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final Unit m1218invoke() {
        this.this$0.Y5();
        this.this$0.b = false;
        Function0<Unit> r0 = this.$onDismiss;
        if (r0 == null) goto L5;
        r0.invoke();
        return Unit.INSTANCE;
    L5:
        return null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1218invoke();
    }
}
