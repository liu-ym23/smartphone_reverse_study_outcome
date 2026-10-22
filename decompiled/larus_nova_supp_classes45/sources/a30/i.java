package a30;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements ca0.h {
    public final /* synthetic */ e a;

    public i(e r1) {
        this.a = r1;
    }

    @Override // ca0.h
    public final void onResult(int r3) {
        jy0.b.d("SetEffectComposerMethod", "removeComposer success, result = " + r3);
        this.a.finishWithSuccess();
    }
}
