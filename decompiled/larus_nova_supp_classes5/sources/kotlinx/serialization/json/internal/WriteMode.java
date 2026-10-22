package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\f\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lkotlinx/serialization/json/internal/WriteMode;", "", "begin", "", "end", "<init>", "(Ljava/lang/String;ICC)V", "OBJ", "LIST", "MAP", "POLY_OBJ", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum WriteMode extends Enum<WriteMode> {
    public static final WriteMode LIST = null;
    public static final WriteMode MAP = null;
    public static final WriteMode OBJ = null;
    public static final WriteMode POLY_OBJ = null;
    public static final /* synthetic */ WriteMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    public final char begin;
    public final char end;

    public static EnumEntries<WriteMode> getEntries() {
        return b;
    }

    static {
        WriteMode r0 = new WriteMode("OBJ", 0, '{', '}');
        OBJ = r0;
        WriteMode r1 = new WriteMode("LIST", 1, '[', ']');
        LIST = r1;
        WriteMode r5 = new WriteMode("MAP", 2, '{', '}');
        MAP = r5;
        WriteMode r3 = new WriteMode("POLY_OBJ", 3, '[', ']');
        POLY_OBJ = r3;
        WriteMode[] r4 = {r0, r1, r5, r3};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static WriteMode[] values() {
        return (WriteMode[]) a.clone();
    }

    public static WriteMode valueOf(String r1) {
        return (WriteMode) r27.a.a(WriteMode.class, r1);
    }

    public WriteMode(String r1, int r2, char r3, char r4) {
        super(r1, r2);
        this.begin = r3;
        this.end = r4;
    }
}
