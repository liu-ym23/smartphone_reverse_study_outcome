package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/paging/LoadType;", "", "(Ljava/lang/String;I)V", "REFRESH", "PREPEND", "APPEND", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum LoadType extends Enum<LoadType> {
    private static final /* synthetic */ LoadType[] $VALUES = null;
    public static final LoadType APPEND = null;
    public static final LoadType PREPEND = null;
    public static final LoadType REFRESH = null;

    private static final /* synthetic */ LoadType[] $values() {
        return new LoadType[]{REFRESH, PREPEND, APPEND};
    }

    static {
        REFRESH = new LoadType("REFRESH", 0);
        PREPEND = new LoadType("PREPEND", 1);
        APPEND = new LoadType("APPEND", 2);
        $VALUES = $values();
    }

    private LoadType(String r1, int r2) {
        super(r1, r2);
    }

    public static LoadType valueOf(String r2) {
        return (LoadType) ZeusTransformUtils.preCheckCast(Enum.valueOf(LoadType.class, r2), LoadType.class, "com.obric.memorydata.plugin");
    }

    public static LoadType[] values() {
        return (LoadType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LoadType[].class, "com.obric.memorydata.plugin");
    }
}
