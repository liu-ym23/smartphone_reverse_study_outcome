package d4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<String> f6750e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<r4.a> f6751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<String> f6752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f6753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r3.c f6754d;

    static {
        f6750e = Collections.singletonList("AppLogCache");
    }

    public a(r3.c r8) {
        this.f6751a = new LinkedList();
        this.f6752b = new LinkedList();
        this.f6753c = 1000;
        this.f6754d = r8;
    }

    public final int a(ArrayList<r4.a> r8) {
        LinkedList<r4.a> r10 = this.f6751a;
        monitor-enter(r10);
        int r11 = this.f6751a.size();     // Catch: Throwable -> L13
        r8.addAll(this.f6751a);     // Catch: Throwable -> L13
        Iterator<r4.a> r12 = this.f6751a.iterator();     // Catch: Throwable -> L13
    L6:
        if (r12.hasNext() == false) goto L10;
        r4.a r13 = r12.next();     // Catch: Throwable -> L13
        if (r13.C <= 0) goto L6;
        l6.a.P0(this.f6754d.f11417y, i4.a.f8142r, r13);     // Catch: Throwable -> L13
        goto L6
    L10:
        this.f6751a.clear();     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return r11;
    L13:
        th = move-exception;
        throw th;
    }
}
