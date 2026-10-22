package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Callback a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Callback r1, Object r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Callback.-CC.$private$lambda$bind$0(this.a, this.b);
    }
}
