package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/serialization/json/DecodeSequenceMode;", "", "WHITESPACE_SEPARATED", "ARRAY_WRAPPED", "AUTO_DETECT", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum DecodeSequenceMode extends Enum<DecodeSequenceMode> {
    public static final DecodeSequenceMode ARRAY_WRAPPED = null;
    public static final DecodeSequenceMode AUTO_DETECT = null;
    public static final DecodeSequenceMode WHITESPACE_SEPARATED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DecodeSequenceMode[] f19382a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19383b = null;

    static {
        DecodeSequenceMode r5 = new DecodeSequenceMode("WHITESPACE_SEPARATED", 0);
        WHITESPACE_SEPARATED = r5;
        DecodeSequenceMode r10 = new DecodeSequenceMode("ARRAY_WRAPPED", 1);
        ARRAY_WRAPPED = r10;
        DecodeSequenceMode r11 = new DecodeSequenceMode("AUTO_DETECT", 2);
        AUTO_DETECT = r11;
        DecodeSequenceMode[] r12 = {r5, r10, r11};
        f19382a = r12;
        f19383b = EnumEntriesKt.enumEntries(r12);
    }

    public static EnumEntries<DecodeSequenceMode> getEntries() {
        return f19383b;
    }

    public static DecodeSequenceMode valueOf(String r5) {
        return (DecodeSequenceMode) Enum.valueOf(DecodeSequenceMode.class, r5);
    }

    public static DecodeSequenceMode[] values() {
        return (DecodeSequenceMode[]) f19382a.clone();
    }
}
