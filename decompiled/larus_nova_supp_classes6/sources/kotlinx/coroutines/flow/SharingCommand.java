package kotlinx.coroutines.flow;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/flow/SharingCommand;", "", "(Ljava/lang/String;I)V", "START", "STOP", "STOP_AND_RESET_REPLAY_CACHE", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum SharingCommand extends Enum<SharingCommand> {
    public static final SharingCommand START = null;
    public static final SharingCommand STOP = null;
    public static final SharingCommand STOP_AND_RESET_REPLAY_CACHE = null;
    public static final /* synthetic */ SharingCommand[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SharingCommand> getEntries() {
        return b;
    }

    public static SharingCommand valueOf(String r1) {
        return (SharingCommand) r27.a.a(SharingCommand.class, r1);
    }

    public static SharingCommand[] values() {
        return (SharingCommand[]) a.clone();
    }

    static {
        SharingCommand r0 = new SharingCommand("START", 0);
        START = r0;
        SharingCommand r1 = new SharingCommand("STOP", 1);
        STOP = r1;
        SharingCommand r3 = new SharingCommand("STOP_AND_RESET_REPLAY_CACHE", 2);
        STOP_AND_RESET_REPLAY_CACHE = r3;
        SharingCommand[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public SharingCommand(String r1, int r2) {
        super(r1, r2);
    }
}
