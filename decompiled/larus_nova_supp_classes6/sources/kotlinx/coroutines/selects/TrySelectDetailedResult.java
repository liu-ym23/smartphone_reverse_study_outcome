package kotlinx.coroutines.selects;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "", "(Ljava/lang/String;I)V", "SUCCESSFUL", "REREGISTER", "CANCELLED", "ALREADY_SELECTED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum TrySelectDetailedResult extends Enum<TrySelectDetailedResult> {
    public static final TrySelectDetailedResult ALREADY_SELECTED = null;
    public static final TrySelectDetailedResult CANCELLED = null;
    public static final TrySelectDetailedResult REREGISTER = null;
    public static final TrySelectDetailedResult SUCCESSFUL = null;
    public static final /* synthetic */ TrySelectDetailedResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TrySelectDetailedResult> getEntries() {
        return b;
    }

    public static TrySelectDetailedResult valueOf(String r1) {
        return (TrySelectDetailedResult) r27.a.a(TrySelectDetailedResult.class, r1);
    }

    public static TrySelectDetailedResult[] values() {
        return (TrySelectDetailedResult[]) a.clone();
    }

    static {
        TrySelectDetailedResult r0 = new TrySelectDetailedResult("SUCCESSFUL", 0);
        SUCCESSFUL = r0;
        TrySelectDetailedResult r1 = new TrySelectDetailedResult("REREGISTER", 1);
        REREGISTER = r1;
        TrySelectDetailedResult r3 = new TrySelectDetailedResult("CANCELLED", 2);
        CANCELLED = r3;
        TrySelectDetailedResult r5 = new TrySelectDetailedResult("ALREADY_SELECTED", 3);
        ALREADY_SELECTED = r5;
        TrySelectDetailedResult[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public TrySelectDetailedResult(String r1, int r2) {
        super(r1, r2);
    }
}
