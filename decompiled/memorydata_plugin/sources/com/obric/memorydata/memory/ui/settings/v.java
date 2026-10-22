package com.obric.memorydata.memory.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000\u001a\u001c\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\tH\u0000\u001a\"\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¨\u0006\u000e"}, d2 = {"resolveShortcutMemoryConsentDecision", "Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentDecision;", "trigger", "Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryTrigger;", "aiVolumeConsentAccepted", "", "gestureConsentAccepted", "pendingConsentTypes", "", "Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentType;", "resolveReplacedShortcutConsentType", "currentConsentType", "incomingConsentType", "resolvePendingShortcutConsent", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class v {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11511a = null;

        static {
            int[] r0 = new int[ShortcutMemoryTrigger.values().length];
            r0[ShortcutMemoryTrigger.AI_VOLUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ShortcutMemoryTrigger.GESTURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ShortcutMemoryTrigger.OTHER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f11511a = r0;
        }
    }

    public static final ShortcutMemoryConsentType a(ShortcutMemoryConsentType r1, ShortcutMemoryConsentType r2) {
        Intrinsics.checkNotNullParameter(r2, "incomingConsentType");
        if (r1 == null) goto L10;
        if (r1 == r2) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L10;
        return r1;
    L6:
        r3 = false;
    L10:
        return null;
    }

    public static final ShortcutMemoryConsentType a(ShortcutMemoryTrigger r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "trigger");
        int r5 = a.f11511a[r2.ordinal()];
        if (r5 != 1) goto L5;
        if (r3 == false) goto L16;
        return null;
    L16:
        return ShortcutMemoryConsentType.AI_VOLUME;
    L5:
        if (r5 != 2) goto L7;
        if (r4 == false) goto L17;
        return null;
    L17:
        return ShortcutMemoryConsentType.GESTURE;
    L7:
        if (r5 != 3) goto L10;
        return null;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final u a(ShortcutMemoryTrigger r2, boolean r3, boolean r4, Set<? extends ShortcutMemoryConsentType> r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "trigger");
        Intrinsics.checkNotNullParameter(r6, "pendingConsentTypes");
        ShortcutMemoryConsentType r7 = a(r2, r3, r4);
        if (r7 != null) goto L8;
        Object r8 = u.b.f11509a;
    L5:
        Object r9 = ZeusTransformUtils.preCheckCast(r8, u.class, "com.obric.memorydata.plugin");
    L11:
        return (u) r9;
    L8:
        if (r6.contains(r7) == false) goto L10;
        r8 = u.a.f11508a;
        goto L5
    L10:
        r9 = ZeusTransformUtils.preCheckCast(new u.c(r7), u.class, "com.obric.memorydata.plugin");
        goto L11
    }
}
