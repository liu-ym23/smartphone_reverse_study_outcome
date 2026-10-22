package n4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<b> f11238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r4.e f11239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f11240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f11242g;

    public d(String r10, int r11, String r12, List<b> r13, r4.e r14) {
        if (r10 == null) goto L17;
        if (r11 < 200) goto L15;
        if (r12 == null) goto L13;
        if (r13 == null) goto L11;
        this.f11236a = r10;
        this.f11237b = r11;
        this.f11238c = Collections.unmodifiableList(new ArrayList(r13));
        this.f11239d = r14;
        return;
    L11:
        throw new IllegalArgumentException("headers == null");
    L13:
        throw new IllegalArgumentException("reason == null");
    L15:
        throw new IllegalArgumentException("Invalid status code: " + r11);
    L17:
        throw new IllegalArgumentException("url == null");
    }

    public r4.e a() {
        return this.f11239d;
    }

    public Object b() {
        return this.f11240e;
    }

    public b c(String r10) {
        if (r10 == null) goto L13;
        List<b> r11 = this.f11238c;
        if (r11 == null) goto L13;
        Iterator<b> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        b r13 = r12.next();
        if (r10.equalsIgnoreCase(r13.a()) == false) goto L9;
        return r13;
    L13:
        return null;
    }

    public List<b> d() {
        return this.f11238c;
    }

    public int e() {
        return this.f11237b;
    }

    public String f() {
        return this.f11241f;
    }

    public String g() {
        return this.f11236a;
    }

    public List<b> h(String r10) {
        ArrayList r11 = null;
        if (r10 == null) goto L15;
        List<b> r12 = this.f11238c;
        if (r12 == null) goto L15;
        Iterator<b> r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L15;
        b r14 = r13.next();
        if (r10.equalsIgnoreCase(r14.a()) == false) goto L9;
        if (r11 != null) goto L14;
        r11 = new ArrayList();
    L14:
        r11.add(r14);
    L15:
        return r11;
    }

    public boolean i() {
        int r10 = this.f11237b;
        if (r10 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r10 >= 300) goto L7;
        return true;
    }

    public String j() {
        return this.f11242g;
    }

    public void k(Object r10) {
        this.f11240e = r10;
    }

    public void l(String r10) {
        this.f11241f = r10;
    }
}
