package e88;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ com.larus.audioplayer.impl.music.a a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ b(com.larus.audioplayer.impl.music.a r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.larus.audioplayer.impl.music.a r0 = this.a;
        boolean r1 = this.b;
        if (r0.d == false) goto L5;
        return;
    L5:
        if (r0.e == true) goto L10;
        r0.d(r1);
        return;
    }
}
