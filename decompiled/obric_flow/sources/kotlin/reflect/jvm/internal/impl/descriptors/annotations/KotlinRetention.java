package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* JADX INFO: loaded from: classes3.dex */
public final enum KotlinRetention extends Enum<KotlinRetention> {
    private static final /* synthetic */ KotlinRetention[] $VALUES = null;
    public static final KotlinRetention BINARY = null;
    public static final KotlinRetention RUNTIME = null;
    public static final KotlinRetention SOURCE = null;

    private static final /* synthetic */ KotlinRetention[] $values() {
        return new KotlinRetention[]{RUNTIME, BINARY, SOURCE};
    }

    static {
        RUNTIME = new KotlinRetention("RUNTIME", 0);
        BINARY = new KotlinRetention("BINARY", 1);
        SOURCE = new KotlinRetention("SOURCE", 2);
        $VALUES = $values();
    }

    private KotlinRetention(String r5, int r10) {
        super(r5, r10);
    }

    public static KotlinRetention valueOf(String r5) {
        return (KotlinRetention) Enum.valueOf(KotlinRetention.class, r5);
    }

    public static KotlinRetention[] values() {
        return (KotlinRetention[]) $VALUES.clone();
    }
}
