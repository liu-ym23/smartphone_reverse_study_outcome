package androidx.paging;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/paging/RecordingCallback;", "Landroidx/paging/PagedList$Callback;", "()V", Constants.KEY_LIST, "", "", "dispatchRecordingTo", "", "other", "onChanged", "position", CommonConsts.COUNT_TYPE, "onInserted", "onRemoved", "Companion", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RecordingCallback extends PagedList.Callback {
    private static final int Changed = 0;
    public static final Companion Companion = null;
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private final List<Integer> list;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/paging/RecordingCallback$Companion;", "", "()V", "Changed", "", "Inserted", "Removed", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    public RecordingCallback() {
        this.list = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public final void dispatchRecordingTo(PagedList.Callback r8) {
        Intrinsics.checkNotNullParameter(r8, "other");
        IntProgression r0 = RangesKt.step((IntProgression) ZeusTransformUtils.preCheckCast(RangesKt.until(0, this.list.size()), IntProgression.class, "com.obric.memorydata.plugin"), 3);
        int r1 = r0.getFirst();
        int r3 = r0.getLast();
        int r2 = r0.getStep();
        if (r2 <= 0) goto L5;
        if (r1 > r3) goto L5;
    L7:
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(this.list.get(r1), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r4 != 0) goto L10;
        r8.onChanged(((Number) ZeusTransformUtils.preCheckCast(this.list.get(r1 + 1), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(this.list.get(r1 + 2), Number.class, "com.obric.memorydata.plugin")).intValue());
    L18:
        if (r1 == r3) goto L20;
        r1 = r1 + r2;
    L20:
        this.list.clear();
        return;
    L10:
        if (r4 != 1) goto L12;
        r8.onInserted(((Number) ZeusTransformUtils.preCheckCast(this.list.get(r1 + 1), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(this.list.get(r1 + 2), Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L18
    L12:
        if (r4 != 2) goto L15;
        r8.onRemoved(((Number) ZeusTransformUtils.preCheckCast(this.list.get(r1 + 1), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(this.list.get(r1 + 2), Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L18
    L15:
        throw new IllegalStateException("Unexpected recording value");
    L5:
        if (r2 >= 0) goto L20;
        if (r3 > r1) goto L20;
        goto L20
    }

    @Override // androidx.paging.PagedList.Callback
    public void onChanged(int r3, int r4) {
        this.list.add(0);
        this.list.add(Integer.valueOf(r3));
        this.list.add(Integer.valueOf(r4));
    }

    @Override // androidx.paging.PagedList.Callback
    public void onInserted(int r3, int r4) {
        this.list.add(1);
        this.list.add(Integer.valueOf(r3));
        this.list.add(Integer.valueOf(r4));
    }

    @Override // androidx.paging.PagedList.Callback
    public void onRemoved(int r3, int r4) {
        this.list.add(2);
        this.list.add(Integer.valueOf(r3));
        this.list.add(Integer.valueOf(r4));
    }
}
