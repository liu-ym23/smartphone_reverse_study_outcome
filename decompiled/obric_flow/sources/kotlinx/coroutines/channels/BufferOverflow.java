package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/channels/BufferOverflow;", "", "SUSPEND", "DROP_OLDEST", "DROP_LATEST", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum BufferOverflow extends Enum<BufferOverflow> {
    public static final BufferOverflow DROP_LATEST = null;
    public static final BufferOverflow DROP_OLDEST = null;
    public static final BufferOverflow SUSPEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BufferOverflow[] f18775a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f18776b = null;

    static {
        BufferOverflow r5 = new BufferOverflow("SUSPEND", 0);
        SUSPEND = r5;
        BufferOverflow r10 = new BufferOverflow("DROP_OLDEST", 1);
        DROP_OLDEST = r10;
        BufferOverflow r11 = new BufferOverflow("DROP_LATEST", 2);
        DROP_LATEST = r11;
        BufferOverflow[] r12 = {r5, r10, r11};
        f18775a = r12;
        f18776b = EnumEntriesKt.enumEntries(r12);
    }

    public static EnumEntries<BufferOverflow> getEntries() {
        return f18776b;
    }

    public static BufferOverflow valueOf(String r5) {
        return (BufferOverflow) Enum.valueOf(BufferOverflow.class, r5);
    }

    public static BufferOverflow[] values() {
        return (BufferOverflow[]) f18775a.clone();
    }
}
