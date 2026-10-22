package com.obric.memorydata.memory.ui.list.contextawareness;

import androidx.paging.LoadState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetSearchPolicy;", "", "<init>", "()V", "decide", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetSearchAction;", "targetPosition", "", "itemCount", "isRefreshIdle", "", "appendState", "Landroidx/paging/LoadState;", "prependState", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f11282a = null;

    static {
        f11282a = new o();
    }

    private o() {
    }

    public final ContextAwarenessTargetSearchAction a(int r1, int r2, boolean r3, LoadState r4, LoadState r5) {
        Intrinsics.checkNotNullParameter(r4, "appendState");
        Intrinsics.checkNotNullParameter(r5, "prependState");
        if (r3 == false) goto L5;
        if (r1 < 0) goto L10;
        return ContextAwarenessTargetSearchAction.SCROLL_TO_TARGET;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, LoadState.NotLoading.class) == false) goto L29;
        if (ZeusTransformUtils.instanceOf(r5, LoadState.NotLoading.class) == false) goto L29;
        if (r4.getEndOfPaginationReached() == true) goto L17;
    L20:
        if (r2 != 0) goto L24;
        return ContextAwarenessTargetSearchAction.WAIT;
    L24:
        if (r4.getEndOfPaginationReached() == true) goto L27;
        return ContextAwarenessTargetSearchAction.LOAD_NEXT_PAGE;
    L27:
        return ContextAwarenessTargetSearchAction.LOAD_PREVIOUS_PAGE;
    L17:
        if (r5.getEndOfPaginationReached() == false) goto L20;
        return ContextAwarenessTargetSearchAction.COMPLETE_NOT_FOUND;
    L29:
        return ContextAwarenessTargetSearchAction.WAIT;
    L5:
        return ContextAwarenessTargetSearchAction.WAIT;
    }
}
