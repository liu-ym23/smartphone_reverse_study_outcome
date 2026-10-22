package com.obric.memorydata.recommend.ui.list;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toListType", "Lcom/obric/memorydata/recommend/ui/list/MemoryListItemType;", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "recommend_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class g {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12708a = null;

        static {
            int[] r0 = new int[MemoryItemType.values().length];
            r0[MemoryItemType.MEMORY_CATEGORY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MemoryItemType.MEMORY_ENTITY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MemoryItemType.PORTRAIT_ENTITY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MemoryItemType.TODO_ENTITY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f12708a = r0;
        }
    }

    public static final MemoryListItemType a(f r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        MemoryItemType r2 = r1.getType();
        int r3 = a.f12708a[r2.ordinal()];
        if (r3 == 1) goto L16;
        if (r3 == 2) goto L19;
        if (r3 == 3) goto L18;
        if (r3 != 4) goto L12;
        return MemoryListItemType.TYPE_TODO;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return MemoryListItemType.TYPE_PORTRAIT;
    L19:
        return MemoryListItemType.TYPE_DATA;
    L16:
        return MemoryListItemType.TYPE_TIME;
    }
}
