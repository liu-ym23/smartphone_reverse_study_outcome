package y2;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<n4.b> f13673d;

    public c(String r10, String r11) {
        this.f13670a = r10;
        this.f13671b = r11;
        this.f13672c = 0;
        this.f13673d = null;
    }

    public c(String r10, String r11, List<n4.b> r12) {
        this.f13670a = r10;
        this.f13671b = r11;
        this.f13672c = 0;
        this.f13673d = r12;
    }

    public int a() {
        return this.f13672c;
    }

    public List<n4.b> b() {
        return this.f13673d;
    }

    public String c() {
        return this.f13671b;
    }

    public String d() {
        return this.f13670a;
    }

    public void e(int r10) {
        this.f13672c = r10;
    }
}
