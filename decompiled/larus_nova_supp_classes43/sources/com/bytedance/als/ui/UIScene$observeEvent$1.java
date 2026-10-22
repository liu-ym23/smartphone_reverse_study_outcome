package com.bytedance.als.ui;

import com.bytedance.als.ui.state.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\b\b\u0002\u0010\u0003*\u00020\u0001\"\b\b\u0003\u0010\u0004*\u00020\u00012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"K", "", "V", "STATE", "ACTION", "Lcom/bytedance/als/ui/state/f;", "uiEvent", "", "invoke", "(Lcom/bytedance/als/ui/state/f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class UIScene$observeEvent$1 extends Lambda implements Function1<f<Object>, Unit> {
    final /* synthetic */ Function1 $observer;

    public UIScene$observeEvent$1(Function1 r1) {
        this.$observer = r1;
        super(1);
    }

    public final void invoke(f<Object> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.a == true) goto L9;
        r10.a = true;
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((f) r1);
        return Unit.INSTANCE;
    }
}
