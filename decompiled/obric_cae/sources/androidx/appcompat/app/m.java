package androidx.appcompat.app;

import android.window.OnBackInvokedCallback;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f661b;

    public /* synthetic */ m(Object r8, int r10) {
        this.f660a = r10;
        this.f661b = r8;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        int r8 = this.f660a;
        Object r10 = this.f661b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        ((AppCompatDelegateImpl) r10).U();
        return;
    L7:
        ((Runnable) r10).run();
    }
}
