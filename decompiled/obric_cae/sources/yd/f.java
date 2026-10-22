package yd;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class f extends l6.a {
    public static final int f1(Iterable r8) {
        he.i.f(r8, "<this>");
        if ((r8 instanceof Collection) == true) goto L7;
        return 10;
    L7:
        return ((Collection) r8).size();
    }
}
