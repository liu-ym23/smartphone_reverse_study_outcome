package androidx.paging;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000e\u001a\u00020\t2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bJ*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0002J$\u0010\u0016\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J-\u0010\u001a\u001a\u00020\t2#\u0010\u0016\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00050\bH\u0002J\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u001a\u0010#\u001a\u00020\t2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bJ\u0018\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\u0018J\u001e\u0010$\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u0011R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006("}, d2 = {"Landroidx/paging/MutableCombinedLoadStateCollection;", "", "()V", "_stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/paging/CombinedLoadStates;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "addListener", "listener", "computeHelperState", "Landroidx/paging/LoadState;", "previousState", "sourceRefreshState", "sourceState", "remoteState", "computeNewState", "newSource", "Landroidx/paging/LoadStates;", "newRemote", "dispatchNewState", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "currState", "get", "type", "Landroidx/paging/LoadType;", "remote", "", "removeListener", "set", "sourceLoadStates", "remoteLoadStates", "state", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableCombinedLoadStateCollection {
    private final ae<CombinedLoadStates> _stateFlow;
    private final CopyOnWriteArrayList<Function1<CombinedLoadStates, Unit>> listeners;
    private final ar<CombinedLoadStates> stateFlow;

    public MutableCombinedLoadStateCollection() {
        this.listeners = new CopyOnWriteArrayList();
        ae<CombinedLoadStates> r0 = at.a(null);
        this._stateFlow = r0;
        this.stateFlow = k.a(r0);
    }

    public static final /* synthetic */ CombinedLoadStates access$computeNewState(MutableCombinedLoadStateCollection r0, CombinedLoadStates r1, LoadStates r2, LoadStates r3) {
        return r0.computeNewState(r1, r2, r3);
    }

    private final LoadState computeHelperState(LoadState r1, LoadState r2, LoadState r3, LoadState r4) {
        if (r4 != null) goto L5;
        return r3;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, LoadState.Loading.class) == false) goto L14;
        if (ZeusTransformUtils.instanceOf(r2, LoadState.NotLoading.class) == false) goto L12;
        if (ZeusTransformUtils.instanceOf(r4, LoadState.NotLoading.class) == true) goto L14;
    L12:
        if (ZeusTransformUtils.instanceOf(r4, LoadState.Error.class) == true) goto L14;
        return r1;
    L14:
        return r4;
    }

    private final CombinedLoadStates computeNewState(CombinedLoadStates r13, LoadStates r14, LoadStates r15) {
        if (r13 == null) goto L6;
        LoadState r1 = r13.getRefresh();
        if (r1 == null) goto L6;
    L7:
        LoadState r2 = r14.getRefresh();
        LoadState r3 = r14.getRefresh();
        LoadState r4 = null;
        if (r15 == null) goto L10;
        LoadState r5 = r15.getRefresh();
    L11:
        LoadState r7 = computeHelperState(r1, r2, r3, r5);
        if (r13 == null) goto L15;
        LoadState r6 = r13.getPrepend();
        if (r6 == null) goto L15;
    L16:
        LoadState r8 = r14.getRefresh();
        LoadState r9 = r14.getPrepend();
        if (r15 == null) goto L19;
        LoadState r10 = r15.getPrepend();
    L20:
        LoadState r11 = computeHelperState(r6, r8, r9, r10);
        if (r13 == null) goto L24;
        LoadState r16 = r13.getAppend();
        if (r16 == null) goto L24;
    L25:
        LoadState r0 = r14.getRefresh();
        LoadState r12 = r14.getAppend();
        if (r15 == null) goto L29;
        r4 = r15.getAppend();
    L29:
        return new CombinedLoadStates(r7, r11, computeHelperState(r16, r0, r12, r4), r14, r15);
    L24:
        r16 = (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin");
        goto L25
    L19:
        r10 = null;
    L15:
        r6 = (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin");
        goto L16
    L10:
        r5 = null;
    L6:
        r1 = (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin");
        goto L7
    }

    private final void dispatchNewState(Function1<? super CombinedLoadStates, CombinedLoadStates> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        ae<CombinedLoadStates> r0 = this._stateFlow;
    L3:
        CombinedLoadStates r2 = r0.c();
        CombinedLoadStates r3 = (CombinedLoadStates) ZeusTransformUtils.preCheckCast(r2, CombinedLoadStates.class, "com.obric.memorydata.plugin");
        CombinedLoadStates r4 = (CombinedLoadStates) ZeusTransformUtils.preCheckCast(r8.invoke(r3), CombinedLoadStates.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r3, r4) == true) goto L17;
        if (r0.a(r2, r4) == false) goto L3;
        if (r4 == null) goto L12;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(this.listeners, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r6.hasNext() == false) goto L18;
        ((Function1) ZeusTransformUtils.preCheckCast(r6.next(), Function1.class, "com.obric.memorydata.plugin")).invoke(r4);
        goto L10
    L18:
        return;
    L12:
        return;
    }

    public final void addListener(Function1<? super CombinedLoadStates, Unit> r3) {
        Function1<CombinedLoadStates, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.listeners.add(r4);
        CombinedLoadStates r2 = (CombinedLoadStates) ZeusTransformUtils.preCheckCast(this._stateFlow.c(), CombinedLoadStates.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r4.invoke(r2);
        return;
    }

    public final LoadState get(LoadType r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        CombinedLoadStates r2 = (CombinedLoadStates) ZeusTransformUtils.preCheckCast(this._stateFlow.c(), CombinedLoadStates.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L6;
        if (r2 == null) goto L8;
        LoadStates r5 = r2.getMediator();
    L9:
        if (r5 != null) goto L11;
        return null;
    L11:
        return r5.get$paging_common(r3);
    L8:
        r5 = null;
        goto L9
    L6:
        if (r2 == null) goto L8;
        r5 = r2.getSource();
        goto L9
    }

    public final ar<CombinedLoadStates> getStateFlow() {
        return this.stateFlow;
    }

    public final void removeListener(Function1<? super CombinedLoadStates, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.listeners.remove(r4);
    }

    public final void set(final LoadStates r2, final LoadStates r3) {
        Intrinsics.checkNotNullParameter(r2, "sourceLoadStates");
        dispatchNewState((Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r2, r3), Function1.class, "com.obric.memorydata.plugin"));
    }

    public final void set(final LoadType r2, final boolean r3, final LoadState r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r4, "state");
        dispatchNewState((Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r3, r2, r4, this), Function1.class, "com.obric.memorydata.plugin"));
    }
}
