package oga;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f implements a {
    public final /* synthetic */ Function0<Unit> a;

    @Override // oga.a
    public final void onDismissFailed() {
    }

    @Override // oga.a
    public final void onDismissSucceeded() {
        this.a.invoke();
    }

    public f(Function0<Unit> r1) {
        this.a = r1;
    }
}
