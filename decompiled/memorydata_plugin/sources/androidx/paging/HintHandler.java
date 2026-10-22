package androidx.paging;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.ad;
import kotlinx.coroutines.flow.ak;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/paging/HintHandler;", "", "()V", "lastAccessHint", "Landroidx/paging/ViewportHint$Access;", "getLastAccessHint", "()Landroidx/paging/ViewportHint$Access;", "state", "Landroidx/paging/HintHandler$State;", "forceSetHint", "", "loadType", "Landroidx/paging/LoadType;", "viewportHint", "Landroidx/paging/ViewportHint;", "hintFor", "Lkotlinx/coroutines/flow/Flow;", "processHint", "HintFlow", "State", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HintHandler {
    private final State state;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR(\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/paging/HintHandler$HintFlow;", "", "(Landroidx/paging/HintHandler;)V", "_flow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/paging/ViewportHint;", "flow", "Lkotlinx/coroutines/flow/Flow;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", EventBody.KEY_VALUE, "getValue", "()Landroidx/paging/ViewportHint;", "setValue", "(Landroidx/paging/ViewportHint;)V", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class HintFlow {
        private final ad<ViewportHint> _flow;
        final /* synthetic */ HintHandler this$0;
        private ViewportHint value;

        public HintFlow(HintHandler r5) {
            this.this$0 = r5;
            this._flow = ak.a(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        }

        public final i<ViewportHint> getFlow() {
            return (i) ZeusTransformUtils.preCheckCast(this._flow, i.class, "com.obric.memorydata.plugin");
        }

        public final ViewportHint getValue() {
            return this.value;
        }

        public final void setValue(ViewportHint r1) {
            this.value = r1;
            if (r1 == null) goto L6;
            this._flow.a(r1);
            return;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JP\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\f2>\u0010\u0018\u001a:\u0012\u0017\u0012\u00150\u0004R\u00020\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0012\u0012\u0017\u0012\u00150\u0004R\u00020\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00160\u0019R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0004R\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\n¨\u0006\u001c"}, d2 = {"Landroidx/paging/HintHandler$State;", "", "(Landroidx/paging/HintHandler;)V", "append", "Landroidx/paging/HintHandler$HintFlow;", "Landroidx/paging/HintHandler;", "appendFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/ViewportHint;", "getAppendFlow", "()Lkotlinx/coroutines/flow/Flow;", "<set-?>", "Landroidx/paging/ViewportHint$Access;", "lastAccessHint", "getLastAccessHint", "()Landroidx/paging/ViewportHint$Access;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "prepend", "prependFlow", "getPrependFlow", "modify", "", "accessHint", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class State {
        private final HintFlow append;
        private ViewportHint.Access lastAccessHint;
        private final ReentrantLock lock;
        private final HintFlow prepend;
        final /* synthetic */ HintHandler this$0;

        public State(HintHandler r2) {
            this.this$0 = r2;
            this.prepend = new HintFlow(r2);
            this.append = new HintFlow(r2);
            this.lock = new ReentrantLock();
        }

        public final i<ViewportHint> getAppendFlow() {
            return this.append.getFlow();
        }

        public final ViewportHint.Access getLastAccessHint() {
            return this.lastAccessHint;
        }

        public final i<ViewportHint> getPrependFlow() {
            return this.prepend.getFlow();
        }

        public final void modify(ViewportHint.Access r4, Function2<? super HintFlow, ? super HintFlow, Unit> r5) {
            Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "block");
            Lock r0 = (Lock) ZeusTransformUtils.preCheckCast(this.lock, Lock.class, "com.obric.memorydata.plugin");
            r0.lock();
            if (r4 != null) goto L11;
        L5:
            r6.invoke(this.prepend, this.append);     // Catch: Throwable -> L8
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L8
            r0.unlock();
            return;
        L8:
            th = move-exception;
            r0.unlock();
            throw th;
        L11:
            this.lastAccessHint = r4;     // Catch: Throwable -> L8
            goto L5
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[LoadType.values().length];
            r0[LoadType.PREPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LoadType.APPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public HintHandler() {
        this.state = new State(this);
    }

    public final void forceSetHint(final LoadType r3, final ViewportHint r4) {
        Intrinsics.checkNotNullParameter(r3, "loadType");
        Intrinsics.checkNotNullParameter(r4, "viewportHint");
        if (r3 != LoadType.PREPEND) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L13;
        this.state.modify(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r3, r4), Function2.class, "com.obric.memorydata.plugin"));
        return;
    L13:
        throw new IllegalArgumentException(("invalid load type for reset: " + r3).toString());
    L5:
        if (r3 == LoadType.APPEND) goto L8;
        r0 = false;
        goto L9
    }

    public final ViewportHint.Access getLastAccessHint() {
        return this.state.getLastAccessHint();
    }

    public final i<ViewportHint> hintFor(LoadType r2) {
        Intrinsics.checkNotNullParameter(r2, "loadType");
        int r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r3 == 1) goto L10;
        if (r3 != 2) goto L8;
        return this.state.getAppendFlow();
    L8:
        throw new IllegalArgumentException("invalid load type for hints");
    L10:
        return this.state.getPrependFlow();
    }

    public final void processHint(final ViewportHint r4) {
        Intrinsics.checkNotNullParameter(r4, "viewportHint");
        State r3 = this.state;
        if (ZeusTransformUtils.instanceOf(r4, ViewportHint.Access.class) == false) goto L5;
        ViewportHint.Access r0 = (ViewportHint.Access) ZeusTransformUtils.preCheckCast(r4, ViewportHint.Access.class, "com.obric.memorydata.plugin");
    L6:
        r3.modify(r0, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), Function2.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r0 = null;
        goto L6
    }
}
