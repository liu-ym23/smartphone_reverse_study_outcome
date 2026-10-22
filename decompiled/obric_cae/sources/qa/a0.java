package qa;

/* JADX INFO: loaded from: classes.dex */
public final class a0 extends d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10202b;

    public /* synthetic */ a0(int r8) {
        this.f10202b = r8;
    }

    @Override // qa.d0
    public final byte[] a(byte[] r8) {
        switch(this.f10202b) {
            case 0: goto L5;
            default: goto L11;
        };
    L5:
        return r8;
    L11:
        return t4.s(r8);
    L8:
        th = move-exception;
        th.printStackTrace();
        return new byte[0];
    }

    public a0(b0 r8) {
        this.f10202b = 1;
        super(r8);
    }
}
