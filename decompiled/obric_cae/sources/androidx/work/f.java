package androidx.work;

/* JADX INFO: loaded from: classes.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ f[] f2826a = null;

    static {
        f2826a = new f[]{new f("REPLACE", 0), new f("KEEP", 1), new f("UPDATE", 2), new f("CANCEL_AND_REENQUEUE", 3)};
    }

    public f(String r8, int r10) {
        super(r8, r10);
    }

    public static f valueOf(String r8) {
        return (f) Enum.valueOf(f.class, r8);
    }

    public static f[] values() {
        return (f[]) f2826a.clone();
    }
}
