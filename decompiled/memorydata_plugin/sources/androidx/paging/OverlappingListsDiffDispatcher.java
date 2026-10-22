package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher;", "", "()V", "dispatchDiff", "", ExifInterface.GPS_DIRECTION_TRUE, "oldList", "Landroidx/paging/NullPaddedList;", "newList", "callback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "diffResult", "Landroidx/paging/NullPaddedDiffResult;", "PlaceholderUsingUpdateCallback", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OverlappingListsDiffDispatcher {
    public static final OverlappingListsDiffDispatcher INSTANCE = null;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\b\u0002\u0018\u0000 \"*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\"B)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\"\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\r\u0010!\u001a\u00020\t*\u00020\tH\u0082\bR\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher$PlaceholderUsingUpdateCallback;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/ListUpdateCallback;", "oldList", "Landroidx/paging/NullPaddedList;", "newList", "callback", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;Landroidx/recyclerview/widget/ListUpdateCallback;)V", "placeholdersAfter", "", "placeholdersAfterState", "placeholdersBefore", "placeholdersBeforeState", "storageCount", "dispatchInsertAsPlaceholderAfter", "", "position", CommonConsts.COUNT_TYPE, "dispatchInsertAsPlaceholderBefore", "dispatchRemovalAsPlaceholdersAfter", "dispatchRemovalAsPlaceholdersBefore", "fixLeadingPlaceholders", "", "fixPlaceholders", "fixTrailingPlaceholders", "onChanged", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "offsetForDispatch", "Companion", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class PlaceholderUsingUpdateCallback<T> implements ListUpdateCallback {
        public static final Companion Companion = null;
        private static final int UNUSED = 1;
        private static final int USED_FOR_ADDITION = 3;
        private static final int USED_FOR_REMOVAL = 2;
        private final ListUpdateCallback callback;
        private final NullPaddedList<T> newList;
        private final NullPaddedList<T> oldList;
        private int placeholdersAfter;
        private int placeholdersAfterState;
        private int placeholdersBefore;
        private int placeholdersBeforeState;
        private int storageCount;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher$PlaceholderUsingUpdateCallback$Companion;", "", "()V", "UNUSED", "", "USED_FOR_ADDITION", "USED_FOR_REMOVAL", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public PlaceholderUsingUpdateCallback(NullPaddedList<T> r3, NullPaddedList<T> r4, ListUpdateCallback r5) {
            NullPaddedList<T> r6 = (NullPaddedList) ZeusTransformUtils.wrapperContextForParams(r3, NullPaddedList.class, "com.obric.memorydata.plugin");
            NullPaddedList<T> r7 = (NullPaddedList) ZeusTransformUtils.wrapperContextForParams(r4, NullPaddedList.class, "com.obric.memorydata.plugin");
            ListUpdateCallback r8 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r5, ListUpdateCallback.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "oldList");
            Intrinsics.checkNotNullParameter(r7, "newList");
            Intrinsics.checkNotNullParameter(r8, "callback");
            this.oldList = r6;
            this.newList = r7;
            this.callback = r8;
            this.placeholdersBefore = r6.getPlaceholdersBefore();
            this.placeholdersAfter = r6.getPlaceholdersAfter();
            this.storageCount = r6.getStorageCount();
            this.placeholdersBeforeState = 1;
            this.placeholdersAfterState = 1;
        }

        private final boolean dispatchInsertAsPlaceholderAfter(int r5, int r6) {
            if (r5 >= this.storageCount) goto L6;
            return false;
        L6:
            if (this.placeholdersAfterState != 2) goto L8;
            return false;
        L8:
            int r0 = Math.min(r6, this.placeholdersAfter);
            if (r0 <= 0) goto L11;
            this.placeholdersAfterState = 3;
            this.callback.onChanged(this.placeholdersBefore + r5, r0, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
            this.placeholdersAfter -= r0;
        L11:
            int r7 = r6 - r0;
            if (r7 <= 0) goto L16;
            this.callback.onInserted((r5 + r0) + this.placeholdersBefore, r7);
            return true;
        L16:
            return true;
        }

        private final boolean dispatchInsertAsPlaceholderBefore(int r5, int r6) {
            if (r5 <= 0) goto L6;
            return false;
        L6:
            if (this.placeholdersBeforeState != 2) goto L8;
            return false;
        L8:
            int r7 = Math.min(r6, this.placeholdersBefore);
            if (r7 <= 0) goto L11;
            this.placeholdersBeforeState = 3;
            this.callback.onChanged((0 - r7) + this.placeholdersBefore, r7, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
            this.placeholdersBefore -= r7;
        L11:
            int r8 = r6 - r7;
            if (r8 <= 0) goto L16;
            this.callback.onInserted(this.placeholdersBefore + 0, r8);
            return true;
        L16:
            return true;
        }

        private final boolean dispatchRemovalAsPlaceholdersAfter(int r5, int r6) {
            if ((r5 + r6) >= this.storageCount) goto L6;
            return false;
        L6:
            if (this.placeholdersAfterState != 3) goto L8;
            return false;
        L8:
            int r0 = RangesKt.coerceAtLeast(Math.min(this.newList.getPlaceholdersAfter() - this.placeholdersAfter, r6), 0);
            int r7 = r6 - r0;
            if (r0 <= 0) goto L11;
            this.placeholdersAfterState = 2;
            this.callback.onChanged(this.placeholdersBefore + r5, r0, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
            this.placeholdersAfter += r0;
        L11:
            if (r7 <= 0) goto L15;
            this.callback.onRemoved((r5 + r0) + this.placeholdersBefore, r7);
            return true;
        L15:
            return true;
        }

        private final boolean dispatchRemovalAsPlaceholdersBefore(int r4, int r5) {
            if (r4 <= 0) goto L6;
            return false;
        L6:
            if (this.placeholdersBeforeState != 3) goto L8;
            return false;
        L8:
            int r6 = RangesKt.coerceAtLeast(Math.min(this.newList.getPlaceholdersBefore() - this.placeholdersBefore, r5), 0);
            int r7 = r5 - r6;
            if (r7 <= 0) goto L11;
            this.callback.onRemoved(this.placeholdersBefore + 0, r7);
        L11:
            if (r6 <= 0) goto L15;
            this.placeholdersBeforeState = 2;
            this.callback.onChanged(this.placeholdersBefore + 0, r6, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
            this.placeholdersBefore += r6;
            return true;
        L15:
            return true;
        }

        private final void fixLeadingPlaceholders() {
            int r0 = Math.min(this.oldList.getPlaceholdersBefore(), this.placeholdersBefore);
            int r1 = this.newList.getPlaceholdersBefore() - this.placeholdersBefore;
            if (r1 <= 0) goto L7;
            if (r0 <= 0) goto L6;
            this.callback.onChanged(0, r0, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
        L6:
            this.callback.onInserted(0, r1);
        L11:
            this.placeholdersBefore = this.newList.getPlaceholdersBefore();
            return;
        L7:
            if (r1 >= 0) goto L11;
            this.callback.onRemoved(0, -r1);
            int r2 = r0 + r1;
            if (r2 <= 0) goto L11;
            this.callback.onChanged(0, r2, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
            goto L11
        }

        private final void fixTrailingPlaceholders() {
            int r0 = Math.min(this.oldList.getPlaceholdersAfter(), this.placeholdersAfter);
            int r1 = this.newList.getPlaceholdersAfter();
            int r2 = this.placeholdersAfter;
            int r3 = r1 - r2;
            int r4 = (this.placeholdersBefore + this.storageCount) + r2;
            int r5 = r4 - r0;
            if (r5 == (this.oldList.getSize() - r0)) goto L5;
            boolean r6 = true;
        L6:
            if (r3 <= 0) goto L8;
            this.callback.onInserted(r4, r3);
        L10:
            if (r0 <= 0) goto L13;
            if (r6 == false) goto L13;
            this.callback.onChanged(r5, r0, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
        L13:
            this.placeholdersAfter = this.newList.getPlaceholdersAfter();
            return;
        L8:
            if (r3 >= 0) goto L10;
            this.callback.onRemoved(r4 + r3, -r3);
            r0 = r0 + r3;
            goto L10
        L5:
            r6 = false;
            goto L6
        }

        private final int offsetForDispatch(int r1) {
            return r1 + this.placeholdersBefore;
        }

        public final void fixPlaceholders() {
            fixLeadingPlaceholders();
            fixTrailingPlaceholders();
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int r2, int r3, Object r4) {
            this.callback.onChanged(r2 + this.placeholdersBefore, r3, r4);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int r3, int r4) {
            if (dispatchInsertAsPlaceholderAfter(r3, r4) == false) goto L5;
        L7:
            this.storageCount += r4;
            return;
        L5:
            if (dispatchInsertAsPlaceholderBefore(r3, r4) == true) goto L7;
            this.callback.onInserted(r3 + this.placeholdersBefore, r4);
            goto L7
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int r2, int r3) {
            ListUpdateCallback r0 = this.callback;
            int r1 = this.placeholdersBefore;
            r0.onMoved(r2 + r1, r3 + r1);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int r3, int r4) {
            if (dispatchRemovalAsPlaceholdersAfter(r3, r4) == false) goto L5;
        L7:
            this.storageCount -= r4;
            return;
        L5:
            if (dispatchRemovalAsPlaceholdersBefore(r3, r4) == true) goto L7;
            this.callback.onRemoved(r3 + this.placeholdersBefore, r4);
            goto L7
        }
    }

    static {
        INSTANCE = new OverlappingListsDiffDispatcher();
    }

    private OverlappingListsDiffDispatcher() {
    }

    public final <T> void dispatchDiff(NullPaddedList<T> r2, NullPaddedList<T> r3, ListUpdateCallback r4, NullPaddedDiffResult r5) {
        NullPaddedList r1 = (NullPaddedList) ZeusTransformUtils.wrapperContextForParams(r2, NullPaddedList.class, "com.obric.memorydata.plugin");
        NullPaddedList r6 = (NullPaddedList) ZeusTransformUtils.wrapperContextForParams(r3, NullPaddedList.class, "com.obric.memorydata.plugin");
        ListUpdateCallback r7 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r4, ListUpdateCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "oldList");
        Intrinsics.checkNotNullParameter(r6, "newList");
        Intrinsics.checkNotNullParameter(r7, "callback");
        Intrinsics.checkNotNullParameter(r5, "diffResult");
        PlaceholderUsingUpdateCallback r8 = new PlaceholderUsingUpdateCallback(r1, r6, r7);
        r5.getDiff().dispatchUpdatesTo((ListUpdateCallback) ZeusTransformUtils.preCheckCast(r8, ListUpdateCallback.class, "com.obric.memorydata.plugin"));
        r8.fixPlaceholders();
    }
}
