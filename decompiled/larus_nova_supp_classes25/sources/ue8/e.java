package ue8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ f.a a;

    public /* synthetic */ e(f.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.invalidate();
    }
}
