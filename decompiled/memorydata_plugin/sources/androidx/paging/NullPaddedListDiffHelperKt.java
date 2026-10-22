package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000\u001a:\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a,\u0010\r\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\f\u001a\u00020\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¨\u0006\u0010"}, d2 = {"computeDiff", "Landroidx/paging/NullPaddedDiffResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/NullPaddedList;", "newList", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "dispatchDiff", "", "callback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "diffResult", "transformAnchorIndex", "", "oldPosition", "paging-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NullPaddedListDiffHelperKt {
    public static final <T> NullPaddedDiffResult computeDiff(NullPaddedList<T> r8, NullPaddedList<T> r9, final DiffUtil.ItemCallback<T> r10) {
        final NullPaddedList r11 = (NullPaddedList) ZeusTransformUtils.wrapperContextForParams(r8, NullPaddedList.class, "com.obric.memorydata.plugin");
        final NullPaddedList r4 = (NullPaddedList) ZeusTransformUtils.wrapperContextForParams(r9, NullPaddedList.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r4, "newList");
        Intrinsics.checkNotNullParameter(r10, "diffCallback");
        final int r6 = r11.getStorageCount();
        final int r7 = r4.getStorageCount();
        DiffUtil.Callback r12 = (DiffUtil.Callback) ZeusTransformUtils.preCheckCast(new NullPaddedListDiffHelperKt$computeDiff$diffResult$1(r11, r4, r10, r6, r7), DiffUtil.Callback.class, "com.obric.memorydata.plugin");
        boolean r13 = true;
        DiffUtil.DiffResult r14 = DiffUtil.calculateDiff(r12, true);
        Intrinsics.checkNotNullExpressionValue(r14, "NullPaddedList<T>.comput…    },\n        true\n    )");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r11.getStorageCount()), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L5;
    L7:
        Iterator<T> r16 = r15.iterator();
    L9:
        if (r16.hasNext() == false) goto L6;
        if (r14.convertOldPositionToNew(((IntIterator) ZeusTransformUtils.preCheckCast(r16, IntIterator.class, "com.obric.memorydata.plugin")).nextInt()) == (-1)) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L9;
    L16:
        return new NullPaddedDiffResult(r14, r13);
    L13:
        r2 = false;
    L6:
        r13 = false;
        goto L16
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    public static final <T> void dispatchDiff(NullPaddedList<T> r2, ListUpdateCallback r3, NullPaddedList<T> r4, NullPaddedDiffResult r5) {
        NullPaddedList<T> r6 = (NullPaddedList) ZeusTransformUtils.wrapperContextForParams(r2, NullPaddedList.class, "com.obric.memorydata.plugin");
        ListUpdateCallback r7 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r3, ListUpdateCallback.class, "com.obric.memorydata.plugin");
        NullPaddedList<T> r8 = (NullPaddedList) ZeusTransformUtils.wrapperContextForParams(r4, NullPaddedList.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "callback");
        Intrinsics.checkNotNullParameter(r8, "newList");
        Intrinsics.checkNotNullParameter(r5, "diffResult");
        if (r5.getHasOverlap() == false) goto L5;
        OverlappingListsDiffDispatcher.INSTANCE.dispatchDiff(r6, r8, r7, r5);
        return;
    L5:
        DistinctListsDiffDispatcher.INSTANCE.dispatchDiff(r7, r6, r8);
    }

    public static final int transformAnchorIndex(NullPaddedList<?> r8, NullPaddedDiffResult r9, NullPaddedList<?> r10, int r11) {
        NullPaddedList r12 = (NullPaddedList) ZeusTransformUtils.wrapperContextForParams(r8, NullPaddedList.class, "com.obric.memorydata.plugin");
        NullPaddedList r13 = (NullPaddedList) ZeusTransformUtils.wrapperContextForParams(r10, NullPaddedList.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r9, "diffResult");
        Intrinsics.checkNotNullParameter(r13, "newList");
        if (r9.getHasOverlap() == false) goto L5;
        int r0 = r11 - r12.getPlaceholdersBefore();
        int r3 = r12.getStorageCount();
        if (r0 < 0) goto L10;
        if (r0 >= r3) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L5;
        int r5 = 0;
    L14:
        if (r5 >= 30) goto L5;
        int r6 = r5 / 2;
        if ((r5 % 2) != 1) goto L18;
        int r7 = -1;
    L19:
        int r14 = (r6 * r7) + r0;
        if (r14 < 0) goto L28;
        if (r14 >= r12.getStorageCount()) goto L28;
        int r15 = r9.getDiff().convertOldPositionToNew(r14);
        if (r15 == (-1)) goto L28;
        return r15 + r13.getPlaceholdersBefore();
    L28:
        r5 = r5 + 1;
        goto L14
    L18:
        r7 = 1;
    L10:
        r4 = false;
    L5:
        return RangesKt.coerceIn(r11, (ClosedRange) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r13.getSize()), ClosedRange.class, "com.obric.memorydata.plugin"));
    }
}
