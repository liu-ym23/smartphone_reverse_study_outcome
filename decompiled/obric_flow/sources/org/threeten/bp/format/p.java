package org.threeten.bp.format;

import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f21233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f21234c;

    public p(int r5) {
        this.f21233b = new HashMap();
        this.f21234c = new HashMap();
        this.f21232a = r5;
    }

    public final void a(String r5) {
        int r10 = r5.length();
        HashMap r11 = this.f21234c;
        HashMap r12 = this.f21233b;
        int r13 = this.f21232a;
        if (r10 != r13) goto L5;
        r12.put(r5, null);
        r11.put(r5.toLowerCase(Locale.ENGLISH), null);
        return;
    L5:
        if (r10 <= r13) goto L12;
        String r14 = r5.substring(0, r13);
        p r15 = (p) r12.get(r14);
        if (r15 != null) goto L9;
        r15 = new p(r10);
        r12.put(r14, r15);
        r11.put(r14.toLowerCase(Locale.ENGLISH), r15);
    L9:
        r15.a(r5);
        return;
    }
}
