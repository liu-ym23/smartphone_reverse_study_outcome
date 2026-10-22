package d8a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements k7a.a.InterfaceC0095a {
    public final /* synthetic */ e.a a;

    public d(l7a.e r1) {
        this.a = r1;
    }

    @Override // k7a.a.InterfaceC0095a
    public final void a(byte[] r4, Throwable r5) {
        l7a.k r0 = ((l7a.e) this.a).a;
        if (r5 != null) goto L5;
        boolean r1 = true;
    L7:
        if (r5 == null) goto L9;
        String r6 = r5.getMessage();
    L10:
        r0.b(r1, r4, null, r6);
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r1 = false;
        goto L7
    }
}
