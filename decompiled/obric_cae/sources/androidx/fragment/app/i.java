package androidx.fragment.app;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1972a;

    public i(ArrayList r8) {
        this.f1972a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a0.b(this.f1972a, 4);
    }
}
