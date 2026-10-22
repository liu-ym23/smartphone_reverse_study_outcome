package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1446a;

    public /* synthetic */ b(int r5) {
        this.f1446a = r5;
    }

    public final int a(Object r5) {
        switch(this.f1446a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return ((int[]) r5).length;
    L7:
        return ((byte[]) r5).length;
    }

    public final int b() {
        switch(this.f1446a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return 4;
    L6:
        return 1;
    }

    public final String c() {
        switch(this.f1446a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return "IntegerArrayPool";
    L6:
        return "ByteArrayPool";
    }
}
