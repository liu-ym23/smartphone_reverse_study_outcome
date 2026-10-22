package kotlin.io.path;

import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.8")
@ExperimentalPathApi
public final enum CopyActionResult extends Enum<CopyActionResult> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CopyActionResult[] $VALUES = null;
    public static final CopyActionResult CONTINUE = null;
    public static final CopyActionResult SKIP_SUBTREE = null;
    public static final CopyActionResult TERMINATE = null;

    private static final /* synthetic */ CopyActionResult[] $values() {
        return new CopyActionResult[]{CONTINUE, SKIP_SUBTREE, TERMINATE};
    }

    static {
        CONTINUE = new CopyActionResult("CONTINUE", 0);
        SKIP_SUBTREE = new CopyActionResult("SKIP_SUBTREE", 1);
        TERMINATE = new CopyActionResult("TERMINATE", 2);
        CopyActionResult[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = EnumEntriesKt.enumEntries(r10);
    }

    private CopyActionResult(String r10, int r11) {
        super(r10, r11);
    }

    public static EnumEntries<CopyActionResult> getEntries() {
        return $ENTRIES;
    }

    public static CopyActionResult valueOf(String r10) {
        return (CopyActionResult) Enum.valueOf(CopyActionResult.class, r10);
    }

    public static CopyActionResult[] values() {
        return (CopyActionResult[]) $VALUES.clone();
    }
}
