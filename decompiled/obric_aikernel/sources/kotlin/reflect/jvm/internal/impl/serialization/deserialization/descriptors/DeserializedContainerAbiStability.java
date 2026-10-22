package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

/* JADX INFO: loaded from: classes3.dex */
public final enum DeserializedContainerAbiStability extends Enum<DeserializedContainerAbiStability> {
    private static final /* synthetic */ DeserializedContainerAbiStability[] $VALUES = null;
    public static final DeserializedContainerAbiStability FIR_UNSTABLE = null;
    public static final DeserializedContainerAbiStability IR_UNSTABLE = null;
    public static final DeserializedContainerAbiStability STABLE = null;

    private static final /* synthetic */ DeserializedContainerAbiStability[] $values() {
        return new DeserializedContainerAbiStability[]{STABLE, FIR_UNSTABLE, IR_UNSTABLE};
    }

    static {
        STABLE = new DeserializedContainerAbiStability("STABLE", 0);
        FIR_UNSTABLE = new DeserializedContainerAbiStability("FIR_UNSTABLE", 1);
        IR_UNSTABLE = new DeserializedContainerAbiStability("IR_UNSTABLE", 2);
        $VALUES = $values();
    }

    private DeserializedContainerAbiStability(String r10, int r11) {
        super(r10, r11);
    }

    public static DeserializedContainerAbiStability valueOf(String r10) {
        return (DeserializedContainerAbiStability) Enum.valueOf(DeserializedContainerAbiStability.class, r10);
    }

    public static DeserializedContainerAbiStability[] values() {
        return (DeserializedContainerAbiStability[]) $VALUES.clone();
    }
}
