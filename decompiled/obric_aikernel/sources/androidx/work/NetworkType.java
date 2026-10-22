package androidx.work;

import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final enum NetworkType extends Enum<NetworkType> {
    private static final /* synthetic */ NetworkType[] $VALUES = null;
    public static final NetworkType CONNECTED = null;
    public static final NetworkType METERED = null;
    public static final NetworkType NOT_REQUIRED = null;
    public static final NetworkType NOT_ROAMING = null;

    @RequiresApi(30)
    public static final NetworkType TEMPORARILY_UNMETERED = null;
    public static final NetworkType UNMETERED = null;

    private static final /* synthetic */ NetworkType[] $values() {
        return new NetworkType[]{NOT_REQUIRED, CONNECTED, UNMETERED, NOT_ROAMING, METERED, TEMPORARILY_UNMETERED};
    }

    static {
        NOT_REQUIRED = new NetworkType("NOT_REQUIRED", 0);
        CONNECTED = new NetworkType("CONNECTED", 1);
        UNMETERED = new NetworkType("UNMETERED", 2);
        NOT_ROAMING = new NetworkType("NOT_ROAMING", 3);
        METERED = new NetworkType("METERED", 4);
        TEMPORARILY_UNMETERED = new NetworkType("TEMPORARILY_UNMETERED", 5);
        $VALUES = $values();
    }

    private NetworkType(String r10, int r11) {
        super(r10, r11);
    }

    public static NetworkType valueOf(String r10) {
        return (NetworkType) Enum.valueOf(NetworkType.class, r10);
    }

    public static NetworkType[] values() {
        return (NetworkType[]) $VALUES.clone();
    }
}
