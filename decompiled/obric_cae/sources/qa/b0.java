package qa;

/* JADX INFO: loaded from: classes.dex */
public final class b0 extends d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10229b;

    public b0() {
        this.f10229b = 1;
    }

    @Override // qa.d0
    public final byte[] a(byte[] r8) {
        switch(this.f10229b) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return t4.i(t4.c(r8).concat("||1"));
    L8:
        return l4.a(r8);
    }

    public /* synthetic */ b0(d0 r8, int r10) {
        this.f10229b = r10;
        super(r8);
    }
}
