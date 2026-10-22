package com.bumptech.glide.load.data.a;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class a {
    a() {
    }

    public File a(String r1) {
        return new File(r1);
    }

    public boolean a(File r1) {
        return r1.exists();
    }

    public long b(File r1) {
        return r1.length();
    }
}
