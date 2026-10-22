package com.tom_roush.fontbox.g.a;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class e implements b {
    public e() {
    }

    public abstract String[] a();

    @Override // com.tom_roush.fontbox.g.a.b
    public List<File> b() {
        ArrayList r0 = new ArrayList();
        String[] r5 = a();
        if (r5 == null) goto L13;
        int r1 = r5.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L13;
        File r4 = new File(r5[r2]);
        if (r4.exists() == false) goto L12;
        if (r4.canRead() == false) goto L12;
        r0.add(r4);     // Catch: SecurityException -> L14
    L12:
        r2 = r2 + 1;
    L13:
        return r0;
    }
}
