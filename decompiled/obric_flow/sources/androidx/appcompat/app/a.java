package androidx.appcompat.app;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f417b;

    public /* synthetic */ a(Context r5, int r10) {
        this.f416a = r10;
        this.f417b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f416a;
        Context r10 = this.f417b;
        switch(r5) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        AppCompatDelegate.b(r10);
        return;
    L6:
        AppCompatDelegate.a(r10);
    }
}
