package androidx.room.parser;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/room/parser/FtsVersion;", "", "(Ljava/lang/String;I)V", "FTS3", "FTS4", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum FtsVersion extends Enum<FtsVersion> {
    private static final /* synthetic */ FtsVersion[] $VALUES = null;
    public static final FtsVersion FTS3 = null;
    public static final FtsVersion FTS4 = null;

    private static final /* synthetic */ FtsVersion[] $values() {
        return new FtsVersion[]{FTS3, FTS4};
    }

    static {
        FTS3 = new FtsVersion("FTS3", 0);
        FTS4 = new FtsVersion("FTS4", 1);
        $VALUES = $values();
    }

    private FtsVersion(String r5, int r10) {
        super(r5, r10);
    }

    public static FtsVersion valueOf(String r5) {
        return (FtsVersion) Enum.valueOf(FtsVersion.class, r5);
    }

    public static FtsVersion[] values() {
        return (FtsVersion[]) $VALUES.clone();
    }
}
