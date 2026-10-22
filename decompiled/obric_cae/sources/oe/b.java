package oe;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f9786a = 0;

    static {
        ThreadLocal[] r8 = new ThreadLocal[4];
        int r10 = 0;
    L3:
        if (r10 >= 4) goto L5;
        r8[r10] = new ThreadLocal();
        r10 = r10 + 1;
        goto L3
    }
}
