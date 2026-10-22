package com.larus.bmhome.chat.reddot;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements j {
    public final nf9.e a;

    @Override // com.larus.bmhome.chat.reddot.j
    public final String b() {
        nf9.e r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public a(nf9.e r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.chat.reddot.j
    public final void a(int r2) {
        nf9.e r0 = this.a;
        if (r0 == null) goto L6;
        r0.onUpdate(r2);
        return;
    }
}
