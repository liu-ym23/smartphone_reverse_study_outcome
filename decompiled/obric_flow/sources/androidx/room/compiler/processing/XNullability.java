package androidx.room.compiler.processing;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/room/compiler/processing/XNullability;", "", "(Ljava/lang/String;I)V", "NULLABLE", "NONNULL", "UNKNOWN", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum XNullability extends Enum<XNullability> {
    private static final /* synthetic */ XNullability[] $VALUES = null;
    public static final XNullability NONNULL = null;
    public static final XNullability NULLABLE = null;
    public static final XNullability UNKNOWN = null;

    private static final /* synthetic */ XNullability[] $values() {
        return new XNullability[]{NULLABLE, NONNULL, UNKNOWN};
    }

    static {
        NULLABLE = new XNullability("NULLABLE", 0);
        NONNULL = new XNullability("NONNULL", 1);
        UNKNOWN = new XNullability("UNKNOWN", 2);
        $VALUES = $values();
    }

    private XNullability(String r5, int r10) {
        super(r5, r10);
    }

    public static XNullability valueOf(String r5) {
        return (XNullability) Enum.valueOf(XNullability.class, r5);
    }

    public static XNullability[] values() {
        return (XNullability[]) $VALUES.clone();
    }
}
