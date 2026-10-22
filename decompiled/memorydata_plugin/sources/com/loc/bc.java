package com.loc;

/* JADX INFO: loaded from: classes3.dex */
public final class bc extends bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f5348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5349b;

    public bc() {
        this.f5348a = new StringBuilder();
        this.f5349b = true;
    }

    public bc(bf r1) {
        super(r1);
        this.f5348a = new StringBuilder();
        this.f5349b = true;
    }

    @Override // com.loc.bf
    public final byte[] a(byte[] r3) {
        byte[] r4 = fx.a(this.f5348a.toString());
        this.d = r4;
        this.f5349b = true;
        StringBuilder r2 = this.f5348a;
        r2.delete(0, r2.length());
        return r4;
    }

    @Override // com.loc.bf
    public final void b(byte[] r3) {
        String r4 = fx.a(r3);
        if (this.f5349b == false) goto L5;
        this.f5349b = false;
    L6:
        this.f5348a.append("{\"log\":\"").append(r4).append("\"}");
        return;
    L5:
        this.f5348a.append(",");
        goto L6
    }
}
