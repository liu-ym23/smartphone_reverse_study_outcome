package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0001H\u0002J4\u0010\r\u001a\u00020\u0004\"\b\b\u0000\u0010\u000e*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0010¨\u0006\u0012"}, d2 = {"Landroidx/paging/DistinctListsDiffDispatcher;", "", "()V", "dispatchChange", "", "callback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "startBoundary", "", "endBoundary", CommonConsts.APM_INNER_EVENT_COST_START, "end", "payload", "dispatchDiff", ExifInterface.GPS_DIRECTION_TRUE, "oldList", "Landroidx/paging/NullPaddedList;", "newList", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DistinctListsDiffDispatcher {
    public static final DistinctListsDiffDispatcher INSTANCE = null;

    static {
        INSTANCE = new DistinctListsDiffDispatcher();
    }

    private DistinctListsDiffDispatcher() {
    }

    private final void dispatchChange(ListUpdateCallback r2, int r3, int r4, int r5, int r6, Object r7) {
        ListUpdateCallback r1 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r2, ListUpdateCallback.class, "com.obric.memorydata.plugin");
        int r8 = r3 - r5;
        if (r8 <= 0) goto L5;
        r1.onChanged(r5, r8, r7);
    L5:
        int r9 = r6 - r4;
        if (r9 <= 0) goto L9;
        r1.onChanged(r4, r9, r7);
        return;
    }

    public final <T> void dispatchDiff(ListUpdateCallback r11, NullPaddedList<T> r12, NullPaddedList<T> r13) {
        ListUpdateCallback r14 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r11, ListUpdateCallback.class, "com.obric.memorydata.plugin");
        NullPaddedList r15 = (NullPaddedList) ZeusTransformUtils.wrapperContextForParams(r12, NullPaddedList.class, "com.obric.memorydata.plugin");
        NullPaddedList r16 = (NullPaddedList) ZeusTransformUtils.wrapperContextForParams(r13, NullPaddedList.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "callback");
        Intrinsics.checkNotNullParameter(r15, "oldList");
        Intrinsics.checkNotNullParameter(r16, "newList");
        int r0 = Math.max(r15.getPlaceholdersBefore(), r16.getPlaceholdersBefore());
        int r1 = Math.min(r15.getPlaceholdersBefore() + r15.getStorageCount(), r16.getPlaceholdersBefore() + r16.getStorageCount());
        int r2 = r1 - r0;
        if (r2 <= 0) goto L5;
        r14.onRemoved(r0, r2);
        r14.onInserted(r0, r2);
    L5:
        int r9 = Math.min(r0, r1);
        int r3 = Math.max(r0, r1);
        dispatchChange(r14, r9, r3, RangesKt.coerceAtMost(r15.getPlaceholdersBefore(), r16.getSize()), RangesKt.coerceAtMost(r15.getPlaceholdersBefore() + r15.getStorageCount(), r16.getSize()), DiffingChangePayload.ITEM_TO_PLACEHOLDER);
        dispatchChange(r14, r9, r3, RangesKt.coerceAtMost(r16.getPlaceholdersBefore(), r15.getSize()), RangesKt.coerceAtMost(r16.getPlaceholdersBefore() + r16.getStorageCount(), r15.getSize()), DiffingChangePayload.PLACEHOLDER_TO_ITEM);
        int r10 = r16.getSize() - r15.getSize();
        if (r10 <= 0) goto L8;
        r14.onInserted(r15.getSize(), r10);
        return;
    L8:
        if (r10 >= 0) goto L12;
        r14.onRemoved(r15.getSize() + r10, -r10);
        return;
    }
}
