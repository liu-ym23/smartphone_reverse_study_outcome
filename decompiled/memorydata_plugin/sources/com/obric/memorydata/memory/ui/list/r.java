package com.obric.memorydata.memory.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ \u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ%\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryContainerPagePolicy;", "", "<init>", "()V", "LEGACY_SCREEN_MEMORY", "", "LEGACY_AUDIO_MEMORY", "bottomNavigationTabs", "", "Lcom/obric/memorydata/memory/ui/list/MemoryContainerTab;", "contextAwarenessConfigured", "", "autoMemoryTaskAvailable", "tabForBottomNavigationIndex", "index", "", "bottomNavigationIndex", "tab", "(Lcom/obric/memorydata/memory/ui/list/MemoryContainerTab;ZZ)Ljava/lang/Integer;", "resolveTargetName", "targetName", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f11329a = null;

    static {
        f11329a = new r();
    }

    private r() {
    }

    public final MemoryContainerTab a(int r1, boolean r2, boolean r3) {
        return (MemoryContainerTab) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(a(r2, r3), r1), MemoryContainerTab.class, "com.obric.memorydata.plugin");
    }

    public final MemoryContainerTab a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "targetName");
        if (Intrinsics.areEqual(r5, "SCREEN_MEMORY") == true) goto L15;
        if (Intrinsics.areEqual(r5, "AUDIO_MEMORY") == true) goto L15;
        MemoryContainerTab[] r4 = MemoryContainerTab.values();
        int r0 = 0;
        int r1 = r4.length;
    L8:
        if (r0 >= r1) goto L13;
        MemoryContainerTab r2 = r4[r0];
        if (Intrinsics.areEqual(r2.name(), r5) == true) goto L19;
        r0 = r0 + 1;
        goto L8
    L19:
        return r2;
    L13:
        return null;
    L15:
        return MemoryContainerTab.CONTEXT_AWARENESS;
    }

    public final Integer a(MemoryContainerTab r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        Integer r1 = Integer.valueOf(a(r3, r4).indexOf(r2));
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == true) goto L10;
        return null;
    L10:
        return r1;
    L5:
        r5 = false;
        goto L6
    }

    public final List<MemoryContainerTab> a(boolean r3, boolean r4) {
        List<MemoryContainerTab> r2 = CollectionsKt.mutableListOf(new MemoryContainerTab[]{MemoryContainerTab.GLOBAL_MEMORY, MemoryContainerTab.PERSONAL_MEMORY});
        if (r3 == false) goto L5;
        ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).add(MemoryContainerTab.CONTEXT_AWARENESS);
    L5:
        if (r4 == false) goto L7;
        ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).add(MemoryContainerTab.AUTO_MEMORY_TASK);
    L7:
        return r2;
    }
}
