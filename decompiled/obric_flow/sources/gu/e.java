package gu;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f17233b;

    public /* synthetic */ e(f r5, int r10) {
        this.f17232a = r10;
        this.f17233b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f17232a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f17233b.getClass();
        return;
    L6:
        f r5 = this.f17233b;
        r5.f17246t.requestLayout();
        r5.requestLayout();
        return;
    L8:
        f.a(this.f17233b);
    }
}
