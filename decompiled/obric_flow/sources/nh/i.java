package nh;

import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f20260b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashSet f20261c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f20262a;

    static {
        f20260b = new i();
        f20261c = new HashSet();
    }

    public void a(d r5) {
        Iterator r10 = f20261c.iterator();
        if (r10.hasNext() == true) goto L9;
        i r11 = this.f20262a;
        if (r11 == null) goto L10;
        r11.a(r5);
        return;
    L10:
        return;
    L9:
        throw mn.h.c(r10);
    }
}
