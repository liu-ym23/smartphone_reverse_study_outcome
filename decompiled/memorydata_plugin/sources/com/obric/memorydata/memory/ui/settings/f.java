package com.obric.memorydata.memory.ui.settings;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/GlobalMemoryBannerPolicy;", "", "<init>", "()V", "orderedKinds", "", "Lcom/obric/memorydata/memory/ui/settings/GlobalMemoryBannerKind;", "includeKeyMemory", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f11469a = null;

    static {
        f11469a = new f();
    }

    private f() {
    }

    public final List<GlobalMemoryBannerKind> a(boolean r2) {
        List r1 = CollectionsKt.createListBuilder();
        r1.add(GlobalMemoryBannerKind.ASSISTANT);
        r1.add(GlobalMemoryBannerKind.AUTO_MEMORY);
        r1.add(GlobalMemoryBannerKind.MEMORY_QA);
        if (r2 == false) goto L6;
        r1.add(GlobalMemoryBannerKind.KEY_MEMORY);
    L6:
        return CollectionsKt.build(r1);
    }
}
