package androidx.work;

/* JADX INFO: loaded from: classes.dex */
public final enum OutOfQuotaPolicy extends Enum<OutOfQuotaPolicy> {
    private static final /* synthetic */ OutOfQuotaPolicy[] $VALUES = null;
    public static final OutOfQuotaPolicy DROP_WORK_REQUEST = null;
    public static final OutOfQuotaPolicy RUN_AS_NON_EXPEDITED_WORK_REQUEST = null;

    private static final /* synthetic */ OutOfQuotaPolicy[] $values() {
        return new OutOfQuotaPolicy[]{RUN_AS_NON_EXPEDITED_WORK_REQUEST, DROP_WORK_REQUEST};
    }

    static {
        RUN_AS_NON_EXPEDITED_WORK_REQUEST = new OutOfQuotaPolicy("RUN_AS_NON_EXPEDITED_WORK_REQUEST", 0);
        DROP_WORK_REQUEST = new OutOfQuotaPolicy("DROP_WORK_REQUEST", 1);
        $VALUES = $values();
    }

    private OutOfQuotaPolicy(String r10, int r11) {
        super(r10, r11);
    }

    public static OutOfQuotaPolicy valueOf(String r10) {
        return (OutOfQuotaPolicy) Enum.valueOf(OutOfQuotaPolicy.class, r10);
    }

    public static OutOfQuotaPolicy[] values() {
        return (OutOfQuotaPolicy[]) $VALUES.clone();
    }
}
