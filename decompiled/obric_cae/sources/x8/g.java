package x8;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile g f13708a;

    public g() {
    }

    public static ArrayList a(String r8) {
        ArrayList r10 = new ArrayList();
        if (r5.f.b(r8) == false) goto L5;
        return r10;
    L5:
        String[] r11 = r8.split(",");
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        String r14 = r11[r13];
        if (r5.f.b(r14) == true) goto L10;
        r10.add(r14.trim());
    L10:
        r13 = r13 + 1;
        goto L6
    L11:
        return r10;
    }
}
