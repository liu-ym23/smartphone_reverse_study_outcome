package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemorySourceIconProvider;", "", "<init>", "()V", "iconSpec", "Lcom/obric/memorydata/memory/ui/list/MemorySourceIconSpec;", "productType", "", MemoryInfoSectionEditActivity.KIND_SCENE, "Lcom/obric/memorydata/memory/ui/list/MemorySourceIconScene;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ae f11174a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11175a = null;

        static {
            int[] r0 = new int[MemorySourceIconScene.values().length];
            r0[MemorySourceIconScene.LIST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MemorySourceIconScene.DETAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f11175a = r0;
        }
    }

    static {
        f11174a = new ae();
    }

    private ae() {
    }

    public final af a(int r3, MemorySourceIconScene r4) {
        Intrinsics.checkNotNullParameter(r4, MemoryInfoSectionEditActivity.KIND_SCENE);
        if (r3 == 20) goto L6;
        return null;
    L6:
        int r2 = a.f11175a[r4.ordinal()];
        if (r2 == 1) goto L14;
        if (r2 != 2) goto L12;
        return new af(ZeusTransformUtils.mapRes(R.drawable.ic_memory_source_glasses_detail, "drawable", "ic_memory_source_glasses_detail"), "memory_source_glasses_detail", false);
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        return new af(ZeusTransformUtils.mapRes(R.drawable.ic_memory_source_glasses_list, "drawable", "ic_memory_source_glasses_list"), "memory_source_glasses_list", false);
    }
}
