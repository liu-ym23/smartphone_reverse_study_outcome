package kotlinx.serialization.json;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/json/DecodeSequenceMode;", "", "(Ljava/lang/String;I)V", "WHITESPACE_SEPARATED", "ARRAY_WRAPPED", "AUTO_DETECT", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum DecodeSequenceMode extends Enum<DecodeSequenceMode> {
    private static final /* synthetic */ DecodeSequenceMode[] $VALUES = null;
    public static final DecodeSequenceMode ARRAY_WRAPPED = null;
    public static final DecodeSequenceMode AUTO_DETECT = null;
    public static final DecodeSequenceMode WHITESPACE_SEPARATED = null;

    private static final /* synthetic */ DecodeSequenceMode[] $values() {
        return new DecodeSequenceMode[]{WHITESPACE_SEPARATED, ARRAY_WRAPPED, AUTO_DETECT};
    }

    static {
        WHITESPACE_SEPARATED = new DecodeSequenceMode("WHITESPACE_SEPARATED", 0);
        ARRAY_WRAPPED = new DecodeSequenceMode("ARRAY_WRAPPED", 1);
        AUTO_DETECT = new DecodeSequenceMode("AUTO_DETECT", 2);
        $VALUES = $values();
    }

    private DecodeSequenceMode(String r1, int r2) {
        super(r1, r2);
    }

    public static DecodeSequenceMode valueOf(String r2) {
        return (DecodeSequenceMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(DecodeSequenceMode.class, r2), DecodeSequenceMode.class, "com.obric.memorydata.plugin");
    }

    public static DecodeSequenceMode[] values() {
        return (DecodeSequenceMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DecodeSequenceMode[].class, "com.obric.memorydata.plugin");
    }
}
