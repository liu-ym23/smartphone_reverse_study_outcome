package androidx.paging;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J-\u0010\u0014\u001a\u00020\u00152\u001e\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u0017H\u0000¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001e"}, d2 = {"Landroidx/paging/CombinedLoadStates;", "", "refresh", "Landroidx/paging/LoadState;", "prepend", "append", AILabCheckPermissionTask.KEY_SOURCE, "Landroidx/paging/LoadStates;", "mediator", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "getAppend", "()Landroidx/paging/LoadState;", "getMediator", "()Landroidx/paging/LoadStates;", "getPrepend", "getRefresh", "getSource", "equals", "", "other", "forEach", "", "op", "Lkotlin/Function3;", "Landroidx/paging/LoadType;", "forEach$paging_common", "hashCode", "", "toString", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CombinedLoadStates {
    private final LoadState append;
    private final LoadStates mediator;
    private final LoadState prepend;
    private final LoadState refresh;
    private final LoadStates source;

    public CombinedLoadStates(LoadState r2, LoadState r3, LoadState r4, LoadStates r5, LoadStates r6) {
        Intrinsics.checkNotNullParameter(r2, "refresh");
        Intrinsics.checkNotNullParameter(r3, "prepend");
        Intrinsics.checkNotNullParameter(r4, "append");
        Intrinsics.checkNotNullParameter(r5, AILabCheckPermissionTask.KEY_SOURCE);
        this.refresh = r2;
        this.prepend = r3;
        this.append = r4;
        this.source = r5;
        this.mediator = r6;
    }

    public /* synthetic */ CombinedLoadStates(LoadState r7, LoadState r8, LoadState r9, LoadStates r10, LoadStates r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 == null) goto L8;
        Class<?> r3 = r7.getClass();
    L10:
        if (Intrinsics.areEqual(r2, r3) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type androidx.paging.CombinedLoadStates");
        CombinedLoadStates r4 = (CombinedLoadStates) ZeusTransformUtils.preCheckCast(r7, CombinedLoadStates.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.refresh, ((CombinedLoadStates) ZeusTransformUtils.preCheckCast(r7, CombinedLoadStates.class, "com.obric.memorydata.plugin")).refresh) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.prepend, ((CombinedLoadStates) ZeusTransformUtils.preCheckCast(r7, CombinedLoadStates.class, "com.obric.memorydata.plugin")).prepend) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.append, ((CombinedLoadStates) ZeusTransformUtils.preCheckCast(r7, CombinedLoadStates.class, "com.obric.memorydata.plugin")).append) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.source, ((CombinedLoadStates) ZeusTransformUtils.preCheckCast(r7, CombinedLoadStates.class, "com.obric.memorydata.plugin")).source) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.mediator, ((CombinedLoadStates) ZeusTransformUtils.preCheckCast(r7, CombinedLoadStates.class, "com.obric.memorydata.plugin")).mediator) == true) goto L27;
        return false;
    L27:
        return true;
    L8:
        r3 = null;
        goto L10
    }

    public final void forEach$paging_common(Function3<? super LoadType, ? super Boolean, ? super LoadState, Unit> r5) {
        Function3 r6 = (Function3) ZeusTransformUtils.wrapperContextForParams(r5, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "op");
        LoadStates r0 = this.source;
        r6.invoke(LoadType.REFRESH, false, r0.getRefresh());
        r6.invoke(LoadType.PREPEND, false, r0.getPrepend());
        r6.invoke(LoadType.APPEND, false, r0.getAppend());
        LoadStates r4 = this.mediator;
        if (r4 == null) goto L6;
        r6.invoke(LoadType.REFRESH, true, r4.getRefresh());
        r6.invoke(LoadType.PREPEND, true, r4.getPrepend());
        r6.invoke(LoadType.APPEND, true, r4.getAppend());
        return;
    }

    public final LoadState getAppend() {
        return this.append;
    }

    public final LoadStates getMediator() {
        return this.mediator;
    }

    public final LoadState getPrepend() {
        return this.prepend;
    }

    public final LoadState getRefresh() {
        return this.refresh;
    }

    public final LoadStates getSource() {
        return this.source;
    }

    public int hashCode() {
        int r0 = ((((((this.refresh.hashCode() * 31) + this.prepend.hashCode()) * 31) + this.append.hashCode()) * 31) + this.source.hashCode()) * 31;
        LoadStates r2 = this.mediator;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r0 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public String toString() {
        return "CombinedLoadStates(refresh=" + this.refresh + ", prepend=" + this.prepend + ", append=" + this.append + ", source=" + this.source + ", mediator=" + this.mediator + ')';
    }
}
