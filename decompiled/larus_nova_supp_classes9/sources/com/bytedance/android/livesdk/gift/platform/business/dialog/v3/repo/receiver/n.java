package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements Disposable {
    public boolean a;
    public final /* synthetic */ b0 b;
    public final /* synthetic */ b0 c;

    public final void dispose() {
        b0 r0 = this.b;
        if (r0 == null) goto L7;
        Function0<Unit> r1 = r0.b;
        if (r1 == null) goto L7;
        Unit r2 = (Unit) r1.invoke();
    L7:
        b0 r3 = this.c;
        if (r3 == null) goto L12;
        Function0<Unit> r4 = r3.b;
        if (r4 == null) goto L12;
        Unit r5 = (Unit) r4.invoke();
    L12:
        this.a = true;
    }

    public final boolean isDisposed() {
        return this.a;
    }

    public n(b0 r1, b0 r2) {
        this.b = r1;
        this.c = r2;
    }
}
