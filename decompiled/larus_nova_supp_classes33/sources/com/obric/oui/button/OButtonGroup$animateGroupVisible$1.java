package com.obric.oui.button;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OButtonGroup$animateGroupVisible$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $onFinished;

    public OButtonGroup$animateGroupVisible$1(Function0<Unit> r1) {
        this.$onFinished = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m247invoke() {
        Function0<Unit> r0 = this.$onFinished;
        if (r0 == null) goto L7;
        r0.invoke();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m247invoke();
        return Unit.INSTANCE;
    }
}
