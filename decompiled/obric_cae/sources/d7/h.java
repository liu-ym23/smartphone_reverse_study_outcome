package d7;

import java.util.ArrayList;
import java.util.Collections;
import we.v;
import we.w;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f6861b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f6862a;

    public static void a(v.b r8) {
        ArrayList r10 = new ArrayList();
        int r11 = f6861b;
        if (r11 != 1) goto L5;
        w r12 = w.f13322o;
    L11:
        r10.add(r12);
    L12:
        f6861b = 4;
        r10.add(w.f13320m);
        r8.a(Collections.unmodifiableList(r10));
        return;
    L5:
        if (r11 != 2) goto L7;
    L9:
        r12 = w.f13321n;
        goto L11
    L7:
        if (r11 == 3) goto L12;
        r10.add(w.f13322o);
        goto L9
    }
}
