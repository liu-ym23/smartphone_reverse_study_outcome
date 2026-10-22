package kotlinx.serialization.json.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\f\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lkotlinx/serialization/json/internal/WriteMode;", "", "begin", "", "end", "(Ljava/lang/String;ICC)V", "OBJ", "LIST", "MAP", "POLY_OBJ", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum WriteMode extends Enum<WriteMode> {
    private static final /* synthetic */ WriteMode[] $VALUES = null;
    public static final WriteMode LIST = null;
    public static final WriteMode MAP = null;
    public static final WriteMode OBJ = null;
    public static final WriteMode POLY_OBJ = null;
    public final char begin;
    public final char end;

    private static final /* synthetic */ WriteMode[] $values() {
        return new WriteMode[]{OBJ, LIST, MAP, POLY_OBJ};
    }

    static {
        OBJ = new WriteMode("OBJ", 0, '{', '}');
        LIST = new WriteMode("LIST", 1, '[', ']');
        MAP = new WriteMode("MAP", 2, '{', '}');
        POLY_OBJ = new WriteMode("POLY_OBJ", 3, '[', ']');
        $VALUES = $values();
    }

    private WriteMode(String r1, int r2, char r3, char r4) {
        super(r1, r2);
        this.begin = r3;
        this.end = r4;
    }

    public static WriteMode valueOf(String r2) {
        return (WriteMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(WriteMode.class, r2), WriteMode.class, "com.obric.memorydata.plugin");
    }

    public static WriteMode[] values() {
        return (WriteMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WriteMode[].class, "com.obric.memorydata.plugin");
    }
}
