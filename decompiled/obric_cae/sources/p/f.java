package p;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9888b;

    public f() {
        this.f9888b = new int[10];
    }

    public final void a() {
        this.f9887a = 0;
        Arrays.fill((int[]) this.f9888b, 0);
    }

    public final int b() {
        if ((this.f9887a & 128) != 0) goto L7;
        return 65535;
    L7:
        return ((int[]) this.f9888b)[7];
    }

    public final void c(f r8) {
        int r10 = 0;
    L4:
        if (r10 >= 10) goto L13;
        boolean r11 = true;
        if (((1 << r10) & r8.f9887a) != 0) goto L9;
        r11 = false;
    L9:
        if (r11 == false) goto L12;
        e(r10, ((int[]) r8.f9888b)[r10]);
    L12:
        r10 = r10 + 1;
        goto L4
    }

    public final boolean d(Object r8) {
        int r10 = this.f9887a;
        Object[] r11 = (Object[]) this.f9888b;
        if (r10 >= r11.length) goto L6;
        r11[r10] = r8;
        this.f9887a = r10 + 1;
        return true;
    L6:
        return false;
    }

    public final void e(int r8, int r10) {
        if (r8 < 0) goto L8;
        int[] r11 = (int[]) this.f9888b;
        if (r8 >= r11.length) goto L9;
        this.f9887a = (1 << r8) | this.f9887a;
        r11[r8] = r10;
        return;
    L9:
        return;
    }

    public f(int r8) {
        this.f9888b = new Object[256];
    }

    public f(int r8, ArrayList r10) {
        this.f9887a = r8;
        this.f9888b = r10;
    }
}
