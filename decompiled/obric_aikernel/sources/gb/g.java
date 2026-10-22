package gb;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f9070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f9071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9074e;

    public g(List<String> r10, List<String> r11) {
        this.f9070a = new ArrayList();
        this.f9071b = new ArrayList();
        this.f9072c = -1;
        this.f9073d = -1;
        if (r10 != null) goto L5;
    L7:
        if (r11 == null) goto L12;
        if (r11.isEmpty() == true) goto L12;
        this.f9070a.addAll(r11);
    L12:
        if (this.f9071b.isEmpty() == true) goto L14;
        int r12 = 1;
    L15:
        this.f9074e = r12;
        return;
    L14:
        r12 = 2;
        goto L15
    L5:
        if (r10.isEmpty() == true) goto L7;
        this.f9071b.addAll(r10);
        goto L7
    }

    public g a() {
        g r10 = new g(this.f9071b, this.f9070a);
        r10.f9074e = this.f9074e;
        r10.f9073d = this.f9073d;
        r10.f9072c = this.f9072c;
        return r10;
    }

    public boolean b() {
        if (this.f9074e == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String c() {
        int r10 = this.f9074e;
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L9;
        return null;
    L9:
        if (this.f9072c >= 0) goto L11;
        this.f9072c = 0;
    L11:
        List<String> r11 = this.f9070a;
        int r12 = this.f9072c;
    L13:
        return r11.get(r12 % r11.size());
    L15:
        if (this.f9073d >= 0) goto L17;
        this.f9073d = 0;
    L17:
        r11 = this.f9071b;
        r12 = this.f9073d;
        goto L13
    }

    public void d() {
        if (b() == false) goto L13;
        if (this.f9071b.isEmpty() == true) goto L13;
        if (this.f9073d >= (this.f9071b.size() - 1)) goto L9;
    L10:
        this.f9073d++;
        return;
    L9:
        if (this.f9070a.isEmpty() == true) goto L10;
    L13:
        if (this.f9070a.isEmpty() == true) goto L16;
        this.f9072c++;
        this.f9074e = 2;
        return;
    }

    public boolean e() {
        if (this.f9070a.isEmpty() == false) goto L5;
        return false;
    L5:
        if (this.f9074e == 2) goto L11;
        this.f9074e = 2;
        return true;
    L11:
        return false;
    }
}
