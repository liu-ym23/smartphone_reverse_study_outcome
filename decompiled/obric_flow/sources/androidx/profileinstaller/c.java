package androidx.profileinstaller;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f563b;

    public /* synthetic */ c(Context r5, int r10) {
        this.f562a = r10;
        this.f563b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f562a;
        Context r10 = this.f563b;
        switch(r5) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ProfileInstallerInitializer.b(r10);
        return;
    L6:
        ProfileInstallerInitializer.c(r10);
    }
}
