package w6;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected String f13397h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    protected v6.a f13398i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f13399j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected boolean f13400k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected boolean f13401l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected boolean f13402m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected boolean f13403n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List<String> f13404o;

    public a(String r10, long r11, boolean r12, String r13, @NonNull v6.a r14, HashMap<String, String> r15) {
        super(r11, r12, r13, r15);
        this.f13399j = true;
        this.f13400k = true;
        this.f13401l = true;
        this.f13402m = false;
        this.f13403n = false;
        this.f13397h = r10;
        this.f13398i = r14;
    }

    @NonNull
    public v6.a j() {
        return this.f13398i;
    }

    public String k() {
        return this.f13397h;
    }

    public List<String> l() {
        return this.f13404o;
    }

    public boolean m() {
        return this.f13400k;
    }

    public boolean n() {
        return this.f13402m;
    }

    public boolean o() {
        return this.f13403n;
    }

    public boolean p() {
        return this.f13401l;
    }

    public boolean q() {
        return this.f13399j;
    }

    public void r(boolean r10) {
        this.f13400k = r10;
    }

    public void s(boolean r10) {
        this.f13402m = r10;
    }

    public void t(boolean r10) {
        this.f13403n = r10;
    }

    public void u(List<String> r10) {
        this.f13404o = r10;
    }
}
