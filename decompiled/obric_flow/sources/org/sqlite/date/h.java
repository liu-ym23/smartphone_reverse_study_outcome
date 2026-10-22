package org.sqlite.date;

import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f21090a;

    public h(char r5) {
        this.f21090a = r5;
    }

    @Override // org.sqlite.date.l
    public final int a() {
        return 1;
    }

    @Override // org.sqlite.date.l
    public final void b(Calendar r5, StringBuffer r10) {
        r10.append(this.f21090a);
    }
}
