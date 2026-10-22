package t19;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ s.a a;
    public final /* synthetic */ CharSequence b;

    public /* synthetic */ q(s.a r1, CharSequence r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s.a r0 = this.a;
        CharSequence r1 = this.b;
        r0.getClass();
        u19.f r2 = s.b.get();
        u19.f r3 = r0.a;
        if (r2 == r3) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L11;
        r0.a.updateText(r1);
        return;
    L11:
        return;
    L5:
        if (r3.isShown() == false) goto L7;
        r4 = true;
        goto L8
    }
}
