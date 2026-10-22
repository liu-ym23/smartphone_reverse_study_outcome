package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J&\u0010\u0012\u001a\u00020\u00132\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0015H\u0087\bø\u0001\u0000J\u0015\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0019J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u001d\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u001eJ\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"Landroidx/paging/LoadStates;", "", "refresh", "Landroidx/paging/LoadState;", "prepend", "append", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;)V", "getAppend", "()Landroidx/paging/LoadState;", "getPrepend", "getRefresh", "component1", "component2", "component3", "copy", "equals", "", "other", "forEach", "", "op", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "get", "loadType", "get$paging_common", "hashCode", "", "modifyState", "newState", "modifyState$paging_common", "toString", "", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LoadStates {
    public static final Companion Companion = null;
    private static final LoadStates IDLE = null;
    private final LoadState append;
    private final LoadState prepend;
    private final LoadState refresh;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/LoadStates$Companion;", "", "()V", "IDLE", "Landroidx/paging/LoadStates;", "getIDLE", "()Landroidx/paging/LoadStates;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final LoadStates getIDLE() {
            return LoadStates.access$getIDLE$cp();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[LoadType.values().length];
            r0[LoadType.APPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[LoadType.PREPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[LoadType.REFRESH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
        IDLE = new LoadStates((LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin"), (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin"), (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin"));
    }

    public LoadStates(LoadState r2, LoadState r3, LoadState r4) {
        Intrinsics.checkNotNullParameter(r2, "refresh");
        Intrinsics.checkNotNullParameter(r3, "prepend");
        Intrinsics.checkNotNullParameter(r4, "append");
        this.refresh = r2;
        this.prepend = r3;
        this.append = r4;
    }

    public static final /* synthetic */ LoadStates access$getIDLE$cp() {
        return IDLE;
    }

    public static /* synthetic */ LoadStates copy$default(LoadStates r0, LoadState r1, LoadState r2, LoadState r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.refresh;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.prepend;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.append;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final LoadState component1() {
        return this.refresh;
    }

    public final LoadState component2() {
        return this.prepend;
    }

    public final LoadState component3() {
        return this.append;
    }

    public final LoadStates copy(LoadState r1, LoadState r2, LoadState r3) {
        Intrinsics.checkNotNullParameter(r1, "refresh");
        Intrinsics.checkNotNullParameter(r2, "prepend");
        Intrinsics.checkNotNullParameter(r3, "append");
        return new LoadStates(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LoadStates.class) == true) goto L8;
        return false;
    L8:
        LoadStates r6 = (LoadStates) ZeusTransformUtils.preCheckCast(r5, LoadStates.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.refresh, r6.refresh) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.prepend, r6.prepend) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.append, r6.append) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final void forEach(Function2<? super LoadType, ? super LoadState, Unit> r3) {
        Function2 r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "op");
        r4.invoke(LoadType.REFRESH, getRefresh());
        r4.invoke(LoadType.PREPEND, getPrepend());
        r4.invoke(LoadType.APPEND, getAppend());
    }

    public final LoadState get$paging_common(LoadType r2) {
        Intrinsics.checkNotNullParameter(r2, "loadType");
        int r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r3 == 1) goto L13;
        if (r3 == 2) goto L15;
        if (r3 != 3) goto L10;
        return this.refresh;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return this.prepend;
    L13:
        return this.append;
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

    public int hashCode() {
        return (((this.refresh.hashCode() * 31) + this.prepend.hashCode()) * 31) + this.append.hashCode();
    }

    public final LoadStates modifyState$paging_common(LoadType r8, LoadState r9) {
        Intrinsics.checkNotNullParameter(r8, "loadType");
        Intrinsics.checkNotNullParameter(r9, "newState");
        int r10 = WhenMappings.$EnumSwitchMapping$0[r8.ordinal()];
        if (r10 != 1) goto L5;
        LoadState r1 = null;
        LoadState r2 = null;
        int r4 = 3;
        Object r5 = null;
        LoadState r3 = r9;
    L14:
        return copy$default(this, r1, r2, r3, r4, r5);
    L5:
        if (r10 != 2) goto L7;
        r1 = null;
        r3 = null;
        r4 = 5;
        r5 = null;
        r2 = r9;
        goto L14
    L7:
        if (r10 != 3) goto L10;
        return copy$default(this, r9, null, null, 6, null);
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public String toString() {
        return "LoadStates(refresh=" + this.refresh + ", prepend=" + this.prepend + ", append=" + this.append + ')';
    }
}
