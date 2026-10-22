package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f1544b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f1545c = null;
    public static final m d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1546a;

    static {
        f1544b = new m(0);
        f1545c = new m(1);
        d = new m(2);
    }

    public /* synthetic */ m(int r5) {
        this.f1546a = r5;
    }

    public final boolean a(DataSource r5) {
        switch(this.f1546a) {
            case 0: goto L16;
            case 1: goto L10;
            default: goto L5;
        };
    L16:
        return false;
    L5:
        if (r5 != DataSource.REMOTE) goto L7;
        return true;
    L7:
        return false;
    L10:
        if (r5 != DataSource.DATA_DISK_CACHE) goto L12;
    L14:
        return false;
    L12:
        if (r5 == DataSource.MEMORY_CACHE) goto L14;
        return true;
    }
}
