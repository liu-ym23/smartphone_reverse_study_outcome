package org.apache.commons.lang3.time;

import java.util.Calendar;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f20970b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f20971c = null;
    public static final h d = null;

    static {
        f20970b = new h("(Z|(?:[+-]\\d{2}))");
        f20971c = new h("(Z|(?:[+-]\\d{2}\\d{2}))");
        d = new h("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");
    }

    public h(String r5) {
        this.f20973a = Pattern.compile(r5);
    }

    @Override // org.apache.commons.lang3.time.j
    public final void c(String r5, Calendar r10) {
        r10.setTimeZone(o.a(r5));
    }
}
