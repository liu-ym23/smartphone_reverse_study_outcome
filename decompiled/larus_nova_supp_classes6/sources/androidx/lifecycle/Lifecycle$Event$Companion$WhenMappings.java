package androidx.lifecycle;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public /* synthetic */ class Lifecycle$Event$Companion$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

    static {
        int[] r0 = new int[Lifecycle.State.values().length];
        r0[Lifecycle.State.CREATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
    L15:
        r0[Lifecycle.State.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
    L23:
        r0[Lifecycle.State.RESUMED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
    L17:
        r0[Lifecycle.State.DESTROYED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
    L19:
        r0[Lifecycle.State.INITIALIZED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
    L8:
        $EnumSwitchMapping$0 = r0;
    }
}
