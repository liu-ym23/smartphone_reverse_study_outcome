package kotlinx.serialization;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"kotlinx/serialization/EncodeDefault$Mode", "", "Lkotlinx/serialization/EncodeDefault$Mode;", "ALWAYS", "NEVER", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum EncodeDefault$Mode extends Enum<EncodeDefault$Mode> {
    public static final EncodeDefault$Mode ALWAYS = null;
    public static final EncodeDefault$Mode NEVER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EncodeDefault$Mode[] f19214a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19215b = null;

    static {
        EncodeDefault$Mode r5 = new EncodeDefault$Mode("ALWAYS", 0);
        ALWAYS = r5;
        EncodeDefault$Mode r10 = new EncodeDefault$Mode("NEVER", 1);
        NEVER = r10;
        EncodeDefault$Mode[] r11 = {r5, r10};
        f19214a = r11;
        f19215b = EnumEntriesKt.enumEntries(r11);
    }

    public static EnumEntries<EncodeDefault$Mode> getEntries() {
        return f19215b;
    }

    public static EncodeDefault$Mode valueOf(String r5) {
        return (EncodeDefault$Mode) Enum.valueOf(EncodeDefault$Mode.class, r5);
    }

    public static EncodeDefault$Mode[] values() {
        return (EncodeDefault$Mode[]) f19214a.clone();
    }
}
