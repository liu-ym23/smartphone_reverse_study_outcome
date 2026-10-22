package androidx.activity;

import android.window.OnBackInvokedCallback;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f219a;

    public /* synthetic */ g(Runnable r10) {
        this.f219a = r10;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.f219a.run();
    }
}
