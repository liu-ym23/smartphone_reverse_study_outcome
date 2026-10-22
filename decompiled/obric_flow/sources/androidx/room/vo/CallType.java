package androidx.room.vo;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/room/vo/CallType;", "", "(Ljava/lang/String;I)V", "FIELD", "METHOD", "CONSTRUCTOR", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum CallType extends Enum<CallType> {
    private static final /* synthetic */ CallType[] $VALUES = null;
    public static final CallType CONSTRUCTOR = null;
    public static final CallType FIELD = null;
    public static final CallType METHOD = null;

    private static final /* synthetic */ CallType[] $values() {
        return new CallType[]{FIELD, METHOD, CONSTRUCTOR};
    }

    static {
        FIELD = new CallType("FIELD", 0);
        METHOD = new CallType("METHOD", 1);
        CONSTRUCTOR = new CallType("CONSTRUCTOR", 2);
        $VALUES = $values();
    }

    private CallType(String r5, int r10) {
        super(r5, r10);
    }

    public static CallType valueOf(String r5) {
        return (CallType) Enum.valueOf(CallType.class, r5);
    }

    public static CallType[] values() {
        return (CallType[]) $VALUES.clone();
    }
}
