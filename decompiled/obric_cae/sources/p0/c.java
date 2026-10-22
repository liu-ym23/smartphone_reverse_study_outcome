package p0;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f9913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9915d;

    public c() {
        if (defpackage.c.f3208m != null) goto L6;
        defpackage.c.f3208m = new defpackage.c();
        return;
    }

    public final int a(int r8) {
        if (r8 < this.f9915d) goto L7;
        return 0;
    L7:
        return this.f9913b.getShort(this.f9914c + r8);
    }
}
