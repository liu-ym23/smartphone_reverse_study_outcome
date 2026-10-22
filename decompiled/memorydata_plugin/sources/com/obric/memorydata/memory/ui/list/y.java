package com.obric.memorydata.memory.ui.list;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\n¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListPageTrackingPolicy;", "", "<init>", "()V", "shouldTrackContextSelection", "", "currentTab", "Lcom/obric/memorydata/memory/ui/list/MemoryContainerTab;", "selectedTab", "resolveTab", "Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "containerTab", "targetMemoryTab", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f11339a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11340a = null;

        static {
            int[] r0 = new int[MemoryContainerTab.values().length];
            r0[MemoryContainerTab.CONTEXT_AWARENESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MemoryContainerTab.PERSONAL_MEMORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MemoryContainerTab.GLOBAL_MEMORY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MemoryContainerTab.AUTO_MEMORY_TASK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f11340a = r0;
        }
    }

    static {
        f11339a = new y();
    }

    private y() {
    }

    public final MemoryTab a(MemoryContainerTab r1, MemoryTab r2) {
        Intrinsics.checkNotNullParameter(r1, "containerTab");
        if (r2 == null) goto L5;
        return r2;
    L5:
        int r0 = a.f11340a[r1.ordinal()];
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L20;
        if (r0 == 4) goto L20;
        throw new NoWhenBranchMatchedException();
    L20:
        return MemoryTab.COLLECT;
    L21:
        return MemoryTab.PROFILE;
    L19:
        return MemoryTab.OBSERVATION;
    }
}
