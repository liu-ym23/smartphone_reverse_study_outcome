package n4a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y0 extends b1 {
    public final StringBuilder c;
    public boolean d;

    public y0(x0 r1) {
        super(r1);
        this.c = new StringBuilder();
        this.d = true;
    }

    @Override // n4a.b1
    public final byte[] b(byte[] r4) {
        byte[] r5 = f5.j(this.c.toString());
        this.b = r5;
        this.d = true;
        StringBuilder r0 = this.c;
        r0.delete(0, r0.length());
        return r5;
    }

    @Override // n4a.b1
    public final void c(byte[] r3) {
        String r4 = f5.d(r3);
        if (this.d == false) goto L5;
        this.d = false;
    L6:
        StringBuilder r0 = this.c;
        r0.append("{\"log\":\"");
        r0.append(r4);
        r0.append("\"}");
        return;
    L5:
        this.c.append(",");
        goto L6
    }
}
