package o;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f20370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f20371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f20372c;
    public final String d;
    public final String e;

    public d(ArrayList r5, char r10, double r11, String r12, String r13) {
        this.f20370a = r5;
        this.f20371b = r10;
        this.f20372c = r11;
        this.d = r12;
        this.e = r13;
    }

    public static int a(String r5, char r10, String r11) {
        int r12 = androidx.constraintlayout.motion.widget.a.c(r10 * 31, 31, r5);
        return r11.hashCode() + r12;
    }

    public final int hashCode() {
        String r5 = this.e;
        String r10 = this.d;
        return a(r5, this.f20371b, r10);
    }
}
