package com.obric.memorydata.memory.ui.settings.contextawareness;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"isGlobalSourceEnabled", "", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsSnapshot;", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessGlobalSource;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class g {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11452a = null;

        static {
            int[] r0 = new int[ContextAwarenessGlobalSource.values().length];
            r0[ContextAwarenessGlobalSource.MOTION_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ContextAwarenessGlobalSource.LOCATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ContextAwarenessGlobalSource.NOTIFICATION_CONTENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ContextAwarenessGlobalSource.DEVICE_STATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f11452a = r0;
        }
    }

    public static final /* synthetic */ boolean a(i r0, ContextAwarenessGlobalSource r1) {
        return b(r0, r1);
    }

    private static final boolean b(i r1, ContextAwarenessGlobalSource r2) {
        int r3 = a.f11452a[r2.ordinal()];
        if (r3 == 1) goto L16;
        if (r3 == 2) goto L19;
        if (r3 == 3) goto L18;
        if (r3 != 4) goto L12;
        return r1.j();
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return r1.i();
    L19:
        return r1.h();
    L16:
        return r1.g();
    }
}
