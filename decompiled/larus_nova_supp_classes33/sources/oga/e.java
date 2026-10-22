package oga;

import android.os.Handler;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e implements a {
    public final /* synthetic */ Handler a;
    public final /* synthetic */ Function0<Unit> b;
    public final /* synthetic */ Function0<Unit> c;

    @Override // oga.a
    public final void onDismissFailed() {
        Handler r0 = this.a;
        if (r0 == null) goto L5;
        final Function0<Unit> r1 = this.c;
        r0.post(new c(r1));
        return;
    L5:
        this.c.invoke();
    }

    @Override // oga.a
    public final void onDismissSucceeded() {
        Handler r0 = this.a;
        if (r0 == null) goto L5;
        final Function0<Unit> r1 = this.b;
        r0.post(new d(r1));
        return;
    L5:
        this.b.invoke();
    }

    public e(Handler r1, Function0<Unit> r2, Function0<Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
