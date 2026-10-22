package com.bytedance.android.live.broadcast.rts;

import com.bytedance.rts.foundation.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<no name provided>", "", "duration", "", "tabKey", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class PanelAnchorStatusPanelKt$AnchorStatusPanel$1$startSuggestAreaTimer$1 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ e $fallbackSuggestArea;
    final /* synthetic */ Function1 $onReceiveBizMessage;
    final /* synthetic */ Ref.ObjectRef $panelSuggestTimer;
    final /* synthetic */ Function1 $setSuggestUIState;

    public PanelAnchorStatusPanelKt$AnchorStatusPanel$1$startSuggestAreaTimer$1(Ref.ObjectRef r1, Function1 r2, e r3, Function1 r4) {
        this.$panelSuggestTimer = r1;
        this.$setSuggestUIState = r2;
        this.$fallbackSuggestArea = r3;
        this.$onReceiveBizMessage = r4;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Number) r1).intValue(), (String) r2);
        return Unit.INSTANCE;
    }

    public final void invoke(int r3, final String r4) {
        Intrinsics.checkNotNullParameter(r4, "tabKey");
        Object r0 = this.$panelSuggestTimer.element;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        u.b(r0);
        this.$panelSuggestTimer.element = null;
    L5:
        Ref.ObjectRef r1 = this.$panelSuggestTimer;
        r1.element = u.d(new AnonymousClass1(this, r4), r3 * 1000);
    }
}
