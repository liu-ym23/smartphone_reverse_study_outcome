package v98;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ o(b1 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.invoke(Boolean.FALSE);
    }
}
