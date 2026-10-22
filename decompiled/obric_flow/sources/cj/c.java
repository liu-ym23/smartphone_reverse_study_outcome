package cj;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f1193b;

    public /* synthetic */ c() {
        this.f1192a = 0;
    }

    public c(Object r5) {
        this.f1192a = 1;
        if (r5 != null) goto L5;
        WeakReference r10 = null;
    L6:
        this.f1193b = r10;
        return;
    L5:
        r10 = new WeakReference(r5);
        goto L6
    }
}
