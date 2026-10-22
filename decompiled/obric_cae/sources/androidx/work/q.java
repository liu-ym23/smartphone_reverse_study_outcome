package androidx.work;

/* JADX INFO: loaded from: classes.dex */
public final enum q extends Enum<q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f2942a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f2943b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ q[] f2944m = null;

    static {
        q r8 = new q("RUN_AS_NON_EXPEDITED_WORK_REQUEST", 0);
        f2942a = r8;
        q r10 = new q("DROP_WORK_REQUEST", 1);
        f2943b = r10;
        f2944m = new q[]{r8, r10};
    }

    public q(String r8, int r10) {
        super(r8, r10);
    }

    public static q valueOf(String r8) {
        return (q) Enum.valueOf(q.class, r8);
    }

    public static q[] values() {
        return (q[]) f2944m.clone();
    }
}
