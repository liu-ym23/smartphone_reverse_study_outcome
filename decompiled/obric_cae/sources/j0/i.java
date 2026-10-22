package j0;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f8389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<k> f8390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f8391c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.lifecycle.h f8392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.lifecycle.k f8393b;

        public a(androidx.lifecycle.h r8, androidx.lifecycle.k r10) {
            this.f8392a = r8;
            this.f8393b = r10;
            r8.a(r10);
        }
    }

    public i(androidx.activity.d r8) {
        this.f8390b = new CopyOnWriteArrayList();
        this.f8391c = new HashMap();
        this.f8389a = r8;
    }

    public final void a(k r8) {
        this.f8390b.remove(r8);
        a r10 = (a) this.f8391c.remove(r8);
        if (r10 == null) goto L5;
        r10.f8392a.c(r10.f8393b);
        r10.f8393b = null;
    L5:
        this.f8389a.run();
    }
}
