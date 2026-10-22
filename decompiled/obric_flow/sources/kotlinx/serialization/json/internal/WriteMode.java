package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\f\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lkotlinx/serialization/json/internal/WriteMode;", "", "", "begin", "C", "end", "OBJ", "LIST", "MAP", "POLY_OBJ", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum WriteMode extends Enum<WriteMode> {
    public static final WriteMode LIST = null;
    public static final WriteMode MAP = null;
    public static final WriteMode OBJ = null;
    public static final WriteMode POLY_OBJ = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WriteMode[] f19414a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19415b = null;

    @JvmField
    public final char begin;

    @JvmField
    public final char end;

    static {
        WriteMode r5 = new WriteMode("OBJ", 0, '{', '}');
        OBJ = r5;
        WriteMode r10 = new WriteMode("LIST", 1, '[', ']');
        LIST = r10;
        WriteMode r11 = new WriteMode("MAP", 2, '{', '}');
        MAP = r11;
        WriteMode r12 = new WriteMode("POLY_OBJ", 3, '[', ']');
        POLY_OBJ = r12;
        WriteMode[] r13 = {r5, r10, r11, r12};
        f19414a = r13;
        f19415b = EnumEntriesKt.enumEntries(r13);
    }

    public WriteMode(String r5, int r10, char r11, char r12) {
        super(r5, r10);
        this.begin = r11;
        this.end = r12;
    }

    public static EnumEntries<WriteMode> getEntries() {
        return f19415b;
    }

    public static WriteMode valueOf(String r5) {
        return (WriteMode) Enum.valueOf(WriteMode.class, r5);
    }

    public static WriteMode[] values() {
        return (WriteMode[]) f19414a.clone();
    }
}
