package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.event.ImeState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/keyboard/event/IEventContext;", "from", "Lcom/ss/android/lark/keyboard/event/ImeState;", "to", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class ImmersiveVoiceEntryView$initKeyboardEvent$1 extends Lambda implements Function3<com.ss.android.lark.keyboard.event.g, ImeState, ImeState, Unit> {
    final /* synthetic */ v this$0;

    public ImmersiveVoiceEntryView$initKeyboardEvent$1(v r1) {
        this.this$0 = r1;
        super(3);
    }

    public final void invoke(com.ss.android.lark.keyboard.event.g r2, ImeState r3, ImeState r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$selectTransform");
        Intrinsics.checkNotNullParameter(r3, "from");
        Intrinsics.checkNotNullParameter(r4, "to");
        if (r3 == ImeState.NONE) goto L5;
        return;
    L5:
        if (r4 != ImeState.PANEL) goto L7;
    L9:
        this.this$0.getClass();
        throw null;
    L7:
        if (r4 == ImeState.IME) goto L9;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((com.ss.android.lark.keyboard.event.g) r1, (ImeState) r2, (ImeState) r3);
        return Unit.INSTANCE;
    }
}
