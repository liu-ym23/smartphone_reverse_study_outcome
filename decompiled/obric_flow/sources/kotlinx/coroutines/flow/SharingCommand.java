package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/flow/SharingCommand;", "", "START", "STOP", "STOP_AND_RESET_REPLAY_CACHE", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SharingCommand extends Enum<SharingCommand> {
    public static final SharingCommand START = null;
    public static final SharingCommand STOP = null;
    public static final SharingCommand STOP_AND_RESET_REPLAY_CACHE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SharingCommand[] f18827a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f18828b = null;

    static {
        SharingCommand r5 = new SharingCommand("START", 0);
        START = r5;
        SharingCommand r10 = new SharingCommand("STOP", 1);
        STOP = r10;
        SharingCommand r11 = new SharingCommand("STOP_AND_RESET_REPLAY_CACHE", 2);
        STOP_AND_RESET_REPLAY_CACHE = r11;
        SharingCommand[] r12 = {r5, r10, r11};
        f18827a = r12;
        f18828b = EnumEntriesKt.enumEntries(r12);
    }

    public static EnumEntries<SharingCommand> getEntries() {
        return f18828b;
    }

    public static SharingCommand valueOf(String r5) {
        return (SharingCommand) Enum.valueOf(SharingCommand.class, r5);
    }

    public static SharingCommand[] values() {
        return (SharingCommand[]) f18827a.clone();
    }
}
