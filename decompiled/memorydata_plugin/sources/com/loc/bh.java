package com.loc;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class bh extends bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5353b;

    public bh(String r1, bl r2) {
        super(r2);
        this.f5352a = 30;
        this.f5353b = r1;
    }

    private static int a(String r3) {
        File r1 = new File(r3);     // Catch: Throwable -> L8
        if (r1.exists() == true) goto L6;
        return 0;
    L6:
        return r1.list().length;
    L8:
        th = move-exception;
        q.b(th, "fus", "gfn");
        return 0;
    }

    @Override // com.loc.bl
    public final boolean a() {
        if (a(this.f5353b) >= this.f5352a) goto L6;
        return false;
    L6:
        return true;
    }
}
