package a30;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements ca0.h {
    public final /* synthetic */ e a;

    public g(e r1) {
        this.a = r1;
    }

    @Override // ca0.h
    public final void onResult(int r3) {
        jy0.b.d("SetEffectComposerMethod", "appendComposer success, result = " + r3);
        this.a.finishWithSuccess();
    }
}
