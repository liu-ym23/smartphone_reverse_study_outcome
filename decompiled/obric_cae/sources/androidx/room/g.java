package androidx.room;

/* JADX INFO: loaded from: classes.dex */
public final enum g extends Enum<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ g[] f2619a = null;

    static {
        f2619a = new g[]{new g("ASC", 0), new g("DESC", 1)};
    }

    public g(String r8, int r10) {
        super(r8, r10);
    }

    public static g valueOf(String r8) {
        return (g) Enum.valueOf(g.class, r8);
    }

    public static g[] values() {
        return (g[]) f2619a.clone();
    }
}
