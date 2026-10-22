package com.obric.memorydata.memory.ui.settings;

import com.obric.aiproactive.api.ProactiveShortcutCompletion;
import com.obric.aiproactive.api.ProactiveShortcutState;
import com.obric.memorydata.memory.utils.PinnedShortcutState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0000¨\u0006\u0010"}, d2 = {"resolveProactiveShortcutUserRequestAction", "Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutUserRequestAction;", "isEnterprise", "", "pinnedState", "Lcom/obric/memorydata/memory/utils/PinnedShortcutState;", "resolveProactiveShortcutPolicyAction", "Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutPolicyAction;", "featureEnabled", "userDisabled", "mapProactiveShortcutState", "Lcom/obric/aiproactive/api/ProactiveShortcutState;", "shouldPersistProactiveShortcutUserDisabled", "resolveProactiveShortcutCompletion", "Lcom/obric/aiproactive/api/ProactiveShortcutCompletion;", "state", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class t {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11507a = null;

        static {
            int[] r0 = new int[PinnedShortcutState.values().length];
            r0[PinnedShortcutState.ACTIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PinnedShortcutState.DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PinnedShortcutState.ABSENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PinnedShortcutState.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f11507a = r0;
        }
    }

    public static final ProactiveShortcutCompletion a(ProactiveShortcutState r1) {
        Intrinsics.checkNotNullParameter(r1, "state");
        if (r1 != ProactiveShortcutState.ACTIVE) goto L6;
        return ProactiveShortcutCompletion.PINNED;
    L6:
        return ProactiveShortcutCompletion.NOT_PINNED;
    }

    public static final ProactiveShortcutPolicyAction a(boolean r1, boolean r2, boolean r3, PinnedShortcutState r4) {
        Intrinsics.checkNotNullParameter(r4, "pinnedState");
        if (r1 == true) goto L25;
        if (r2 == false) goto L25;
        if (r3 == true) goto L8;
        int r5 = a.f11507a[r4.ordinal()];
        if (r5 == 1) goto L23;
        if (r5 == 2) goto L27;
        if (r5 == 3) goto L26;
        if (r5 == 4) goto L26;
        throw new NoWhenBranchMatchedException();
    L26:
        return ProactiveShortcutPolicyAction.NO_OP;
    L27:
        return ProactiveShortcutPolicyAction.ENABLE_DISABLED;
    L23:
        return ProactiveShortcutPolicyAction.REFRESH_ACTIVE;
    L8:
        return ProactiveShortcutPolicyAction.NO_OP;
    L25:
        return ProactiveShortcutPolicyAction.DISABLE;
    }

    public static final ProactiveShortcutUserRequestAction a(boolean r1, PinnedShortcutState r2) {
        Intrinsics.checkNotNullParameter(r2, "pinnedState");
        if (r1 == true) goto L5;
        int r3 = a.f11507a[r2.ordinal()];
        if (r3 == 1) goto L20;
        if (r3 == 2) goto L23;
        if (r3 == 3) goto L22;
        if (r3 != 4) goto L16;
        return ProactiveShortcutUserRequestAction.FAIL;
    L16:
        throw new NoWhenBranchMatchedException();
    L22:
        return ProactiveShortcutUserRequestAction.REQUEST_PIN;
    L23:
        return ProactiveShortcutUserRequestAction.ENABLE_DISABLED;
    L20:
        return ProactiveShortcutUserRequestAction.REFRESH_ACTIVE;
    L5:
        return ProactiveShortcutUserRequestAction.RESTRICT;
    }

    public static final boolean a(PinnedShortcutState r1) {
        Intrinsics.checkNotNullParameter(r1, "pinnedState");
        if (r1 != PinnedShortcutState.DISABLED) goto L5;
    L8:
        return true;
    L5:
        if (r1 == PinnedShortcutState.ABSENT) goto L8;
        return false;
    }

    public static final ProactiveShortcutState b(boolean r1, PinnedShortcutState r2) {
        Intrinsics.checkNotNullParameter(r2, "pinnedState");
        if (r1 == true) goto L5;
        int r3 = a.f11507a[r2.ordinal()];
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L21;
        if (r3 == 3) goto L21;
        if (r3 != 4) goto L16;
        return ProactiveShortcutState.UNKNOWN;
    L16:
        throw new NoWhenBranchMatchedException();
    L21:
        return ProactiveShortcutState.INACTIVE;
    L19:
        return ProactiveShortcutState.ACTIVE;
    L5:
        return ProactiveShortcutState.RESTRICTED;
    }
}
