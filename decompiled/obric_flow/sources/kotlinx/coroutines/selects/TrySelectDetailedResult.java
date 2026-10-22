package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "", "SUCCESSFUL", "REREGISTER", "CANCELLED", "ALREADY_SELECTED", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum TrySelectDetailedResult extends Enum<TrySelectDetailedResult> {
    public static final TrySelectDetailedResult ALREADY_SELECTED = null;
    public static final TrySelectDetailedResult CANCELLED = null;
    public static final TrySelectDetailedResult REREGISTER = null;
    public static final TrySelectDetailedResult SUCCESSFUL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TrySelectDetailedResult[] f18993a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f18994b = null;

    static {
        TrySelectDetailedResult r5 = new TrySelectDetailedResult("SUCCESSFUL", 0);
        SUCCESSFUL = r5;
        TrySelectDetailedResult r10 = new TrySelectDetailedResult("REREGISTER", 1);
        REREGISTER = r10;
        TrySelectDetailedResult r11 = new TrySelectDetailedResult("CANCELLED", 2);
        CANCELLED = r11;
        TrySelectDetailedResult r12 = new TrySelectDetailedResult("ALREADY_SELECTED", 3);
        ALREADY_SELECTED = r12;
        TrySelectDetailedResult[] r13 = {r5, r10, r11, r12};
        f18993a = r13;
        f18994b = EnumEntriesKt.enumEntries(r13);
    }

    public static EnumEntries<TrySelectDetailedResult> getEntries() {
        return f18994b;
    }

    public static TrySelectDetailedResult valueOf(String r5) {
        return (TrySelectDetailedResult) Enum.valueOf(TrySelectDetailedResult.class, r5);
    }

    public static TrySelectDetailedResult[] values() {
        return (TrySelectDetailedResult[]) f18993a.clone();
    }
}
