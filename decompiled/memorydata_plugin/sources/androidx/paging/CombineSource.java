package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/paging/CombineSource;", "", "(Ljava/lang/String;I)V", "INITIAL", "RECEIVER", "OTHER", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum CombineSource extends Enum<CombineSource> {
    private static final /* synthetic */ CombineSource[] $VALUES = null;
    public static final CombineSource INITIAL = null;
    public static final CombineSource OTHER = null;
    public static final CombineSource RECEIVER = null;

    private static final /* synthetic */ CombineSource[] $values() {
        return new CombineSource[]{INITIAL, RECEIVER, OTHER};
    }

    static {
        INITIAL = new CombineSource("INITIAL", 0);
        RECEIVER = new CombineSource("RECEIVER", 1);
        OTHER = new CombineSource("OTHER", 2);
        $VALUES = $values();
    }

    private CombineSource(String r1, int r2) {
        super(r1, r2);
    }

    public static CombineSource valueOf(String r2) {
        return (CombineSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(CombineSource.class, r2), CombineSource.class, "com.obric.memorydata.plugin");
    }

    public static CombineSource[] values() {
        return (CombineSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CombineSource[].class, "com.obric.memorydata.plugin");
    }
}
