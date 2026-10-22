package com.tencent.wcdb.database;

import java.util.LinkedHashSet;
import java.util.Locale;
import net.zetetic.database.sqlcipher.SQLiteDatabaseConfiguration;

/* JADX INFO: loaded from: classes6.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15851b;
    public String c;
    public int d;
    public int e;
    public Locale f;
    public boolean g;
    public boolean h;
    public int i;
    public boolean j;
    public boolean k;
    public final LinkedHashSet<com.tencent.wcdb.extension.a> l;

    public f(f r2) {
        this.l = new LinkedHashSet();
        if (r2 == null) goto L7;
        this.f15850a = r2.f15850a;
        this.f15851b = r2.f15851b;
        a(r2);
        return;
    L7:
        throw new IllegalArgumentException("other must not be null.");
    }

    public f(String r2, int r3) {
        this.l = new LinkedHashSet();
        if (r2 == null) goto L11;
        this.f15850a = r2;
        this.f15851b = r2;
        this.d = r3;
        this.i = 2;
        this.e = 25;
        this.f = Locale.getDefault();
        if ((r3 & 256) == 0) goto L7;
        String r4 = "vfslog";
    L8:
        this.c = r4;
        return;
    L7:
        r4 = null;
        goto L8
    L11:
        throw new IllegalArgumentException("path must not be null.");
    }

    public void a(f r3) {
        if (r3 == null) goto L10;
        if (this.f15850a.equals(r3.f15850a) == false) goto L8;
        this.d = r3.d;
        this.e = r3.e;
        this.f = r3.f;
        this.g = r3.g;
        this.h = r3.h;
        this.j = r3.j;
        this.k = r3.k;
        this.i = r3.i;
        this.c = r3.c;
        this.l.clear();
        this.l.addAll(r3.l);
        return;
    L8:
        throw new IllegalArgumentException("other configuration must refer to the same database.");
    L10:
        throw new IllegalArgumentException("other must not be null.");
    }

    public boolean a() {
        return this.f15850a.equalsIgnoreCase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH);
    }
}
