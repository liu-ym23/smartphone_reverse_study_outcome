package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0015R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0019"}, d2 = {"Landroidx/paging/MutableLoadStateCollection;", "", "()V", "append", "Landroidx/paging/LoadState;", "getAppend", "()Landroidx/paging/LoadState;", "setAppend", "(Landroidx/paging/LoadState;)V", "prepend", "getPrepend", "setPrepend", "refresh", "getRefresh", "setRefresh", "get", "loadType", "Landroidx/paging/LoadType;", "set", "", "states", "Landroidx/paging/LoadStates;", "type", "state", "snapshot", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableLoadStateCollection {
    private LoadState append;
    private LoadState prepend;
    private LoadState refresh;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[LoadType.values().length];
            r0[LoadType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[LoadType.APPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[LoadType.PREPEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public MutableLoadStateCollection() {
        this.refresh = (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin");
        this.prepend = (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin");
        this.append = (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin");
    }

    public final LoadState get(LoadType r2) {
        Intrinsics.checkNotNullParameter(r2, "loadType");
        int r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r3 == 1) goto L13;
        if (r3 == 2) goto L15;
        if (r3 != 3) goto L10;
        return this.prepend;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return this.append;
    L13:
        return this.refresh;
    }

    public final LoadState getAppend() {
        return this.append;
    }

    public final LoadState getPrepend() {
        return this.prepend;
    }

    public final LoadState getRefresh() {
        return this.refresh;
    }

    public final void set(LoadStates r2) {
        Intrinsics.checkNotNullParameter(r2, "states");
        this.refresh = r2.getRefresh();
        this.append = r2.getAppend();
        this.prepend = r2.getPrepend();
    }

    public final void set(LoadType r2, LoadState r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "state");
        int r4 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r4 != 1) goto L5;
        this.refresh = r3;
        return;
    L5:
        if (r4 != 2) goto L7;
        this.append = r3;
        return;
    L7:
        if (r4 != 3) goto L10;
        this.prepend = r3;
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void setAppend(LoadState r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.append = r2;
    }

    public final void setPrepend(LoadState r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.prepend = r2;
    }

    public final void setRefresh(LoadState r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.refresh = r2;
    }

    public final LoadStates snapshot() {
        return new LoadStates(this.refresh, this.prepend, this.append);
    }
}
