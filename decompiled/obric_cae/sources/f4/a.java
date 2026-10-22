package f4;

/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ a[] f7322a = null;

    static {
        f7322a = new a[]{new a("Common", 0), new a("DataCollection", 1), new a("DataPackaging", 2), new a("DataUpload", 3)};
    }

    public a(String r8, int r10) {
        super(r8, r10);
    }

    public static a valueOf(String r8) {
        return (a) Enum.valueOf(a.class, r8);
    }

    public static a[] values() {
        return (a[]) f7322a.clone();
    }
}
