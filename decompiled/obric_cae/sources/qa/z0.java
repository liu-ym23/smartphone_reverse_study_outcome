package qa;

/* JADX INFO: loaded from: classes.dex */
public final class z0 extends c1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StringBuilder f11247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11248d;

    public z0(y0 r8) {
        super(r8);
        this.f11247c = new StringBuilder();
        this.f11248d = true;
    }

    @Override // qa.c1
    public final byte[] b(byte[] r8) {
        StringBuilder r10 = this.f11247c;
        byte[] r11 = t4.i(r10.toString());
        this.f10253b = r11;
        this.f11248d = true;
        r10.delete(0, r10.length());
        return r11;
    }

    @Override // qa.c1
    public final void c(byte[] r8) {
        String r10 = t4.c(r8);
        boolean r11 = this.f11248d;
        StringBuilder r12 = this.f11247c;
        if (r11 == false) goto L5;
        this.f11248d = false;
    L6:
        r12.append("{\"log\":\"");
        r12.append(r10);
        r12.append("\"}");
        return;
    L5:
        r12.append(",");
        goto L6
    }
}
