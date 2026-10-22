package androidx.lifecycle;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public /* synthetic */ class Lifecycle$Event$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

    static {
        int[] r0 = new int[Lifecycle.Event.values().length];
        r0[Lifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
    L21:
        r0[Lifecycle.Event.ON_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
    L31:
        r0[Lifecycle.Event.ON_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
    L23:
        r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
    L25:
        r0[Lifecycle.Event.ON_RESUME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
    L19:
        r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
    L27:
        r0[Lifecycle.Event.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
    L10:
        $EnumSwitchMapping$0 = r0;
    }
}
