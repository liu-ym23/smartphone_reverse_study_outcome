package j1;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class u extends android.support.v4.media.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f8542l = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f8543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.work.g f8545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<? extends androidx.work.w> f8546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f8547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f8548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<u> f8549i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8550j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m f8551k;

    static {
        f8542l = androidx.work.m.f("WorkContinuationImpl");
    }

    public u() {
        throw null;
    }

    public u(b0 r8, String r10, androidx.work.g r11, List<? extends androidx.work.w> r12) {
        this(r8, r10, r11, r12, 0);
    }

    public static boolean A(u r8, HashSet r10) {
        r10.addAll(r8.f8547g);
        HashSet r11 = B(r8);
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        if (r11.contains((String) r12.next()) == false) goto L4;
        return true;
    L8:
        List<u> r13 = r8.f8549i;
        if (r13 != null) goto L11;
    L18:
        r10.removeAll(r8.f8547g);
        return false;
    L11:
        if (r13.isEmpty() == true) goto L18;
        Iterator<u> r14 = r13.iterator();
    L14:
        if (r14.hasNext() == false) goto L18;
        if (A(r14.next(), r10) == false) goto L14;
        return true;
    }

    public static HashSet B(u r8) {
        HashSet r10 = new HashSet();
        List<u> r11 = r8.f8549i;
        if (r11 != null) goto L5;
    L10:
        return r10;
    L5:
        if (r11.isEmpty() == true) goto L10;
        Iterator<u> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r10.addAll(r12.next().f8547g);
        goto L8
    }

    public final androidx.work.p z() {
        if (this.f8550j == true) goto L5;
        m r8 = new m();
        this.f8543c.f8454d.a(new s1.f(this, r8));
        this.f8551k = r8;
    L7:
        return this.f8551k;
    L5:
        androidx.work.m.d().g(f8542l, "Already enqueued work ids (" + TextUtils.join(", ", this.f8547g) + ")");
        goto L7
    }

    public u(b0 r8, String r10, androidx.work.g r11, List r12, int r13) {
        this.f8543c = r8;
        this.f8544d = r10;
        this.f8545e = r11;
        this.f8546f = r12;
        this.f8549i = null;
        this.f8547g = new ArrayList(r12.size());
        this.f8548h = new ArrayList();
        int r14 = 0;
    L4:
        if (r14 >= r12.size()) goto L6;
        String r15 = ((androidx.work.w) r12.get(r14)).f2960a.toString();
        he.i.e(r15, "id.toString()");
        this.f8547g.add(r15);
        this.f8548h.add(r15);
        r14 = r14 + 1;
        goto L4
    }
}
