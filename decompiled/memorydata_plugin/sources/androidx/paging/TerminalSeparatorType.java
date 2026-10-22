package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/paging/TerminalSeparatorType;", "", "(Ljava/lang/String;I)V", "FULLY_COMPLETE", "SOURCE_COMPLETE", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum TerminalSeparatorType extends Enum<TerminalSeparatorType> {
    private static final /* synthetic */ TerminalSeparatorType[] $VALUES = null;
    public static final TerminalSeparatorType FULLY_COMPLETE = null;
    public static final TerminalSeparatorType SOURCE_COMPLETE = null;

    private static final /* synthetic */ TerminalSeparatorType[] $values() {
        return new TerminalSeparatorType[]{FULLY_COMPLETE, SOURCE_COMPLETE};
    }

    static {
        FULLY_COMPLETE = new TerminalSeparatorType("FULLY_COMPLETE", 0);
        SOURCE_COMPLETE = new TerminalSeparatorType("SOURCE_COMPLETE", 1);
        $VALUES = $values();
    }

    private TerminalSeparatorType(String r1, int r2) {
        super(r1, r2);
    }

    public static TerminalSeparatorType valueOf(String r2) {
        return (TerminalSeparatorType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TerminalSeparatorType.class, r2), TerminalSeparatorType.class, "com.obric.memorydata.plugin");
    }

    public static TerminalSeparatorType[] values() {
        return (TerminalSeparatorType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TerminalSeparatorType[].class, "com.obric.memorydata.plugin");
    }
}
