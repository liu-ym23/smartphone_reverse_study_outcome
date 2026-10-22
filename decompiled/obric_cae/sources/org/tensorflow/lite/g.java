package org.tensorflow.lite;

/* JADX INFO: loaded from: classes2.dex */
public final enum g extends Enum<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f9845a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ g[] f9846b = null;

    static {
        g r8 = new g("APPLICATION", 0);
        f9845a = r8;
        f9846b = new g[]{r8, new g("SYSTEM", 1)};
    }

    public g(String r8, int r10) {
        super(r8, r10);
    }

    public static g valueOf(String r8) {
        return (g) Enum.valueOf(g.class, r8);
    }

    public static g[] values() {
        return (g[]) f9846b.clone();
    }
}
