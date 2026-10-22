package h08;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ com.larksuite.component.universe_design.toast.c a;

    public /* synthetic */ o(com.larksuite.component.universe_design.toast.c r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.cancel();
    }
}
