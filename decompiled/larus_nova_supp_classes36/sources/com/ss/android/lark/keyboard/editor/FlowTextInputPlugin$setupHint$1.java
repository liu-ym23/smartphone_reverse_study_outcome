package com.ss.android.lark.keyboard.editor;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class FlowTextInputPlugin$setupHint$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CharSequence $hint;
    final /* synthetic */ int $hintColor;
    final /* synthetic */ i this$0;

    public FlowTextInputPlugin$setupHint$1(int r1, i r2, CharSequence r3) {
        this.$hintColor = r1;
        this.$hint = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1055invoke() {
        if (this.$hintColor == 0) goto L6;
        int r0 = i.a;
        throw null;
    L6:
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1055invoke();
        return Unit.INSTANCE;
    }
}
