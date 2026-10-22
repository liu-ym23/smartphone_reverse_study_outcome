package x;

import i0.d;
import java.util.ArrayList;
import java.util.HashSet;
import n.h;

/* JADX INFO: loaded from: classes.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f13358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h<T, ArrayList<T>> f13359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<T> f13360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<T> f13361d;

    public a() {
        this.f13358a = new d(10);
        this.f13359b = new h();
        this.f13360c = new ArrayList();
        this.f13361d = new HashSet();
    }

    public final void a(T r8, ArrayList<T> r10, HashSet<T> r11) {
        if (r10.contains(r8) == false) goto L6;
        return;
    L6:
        if (r11.contains(r8) == true) goto L15;
        r11.add(r8);
        ArrayList<T> r12 = this.f13359b.getOrDefault(r8, null);
        if (r12 == null) goto L12;
        int r13 = r12.size();
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L12;
        a(r12.get(r14), r10, r11);
        r14 = r14 + 1;
    L12:
        r11.remove(r8);
        r10.add(r8);
        return;
    L15:
        throw new RuntimeException("This graph contains cyclic dependencies");
    }
}
