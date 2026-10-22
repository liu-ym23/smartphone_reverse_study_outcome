package androidx.lifecycle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ ComputableLiveData a;

    public /* synthetic */ b(ComputableLiveData r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComputableLiveData.b(this.a);
    }
}
