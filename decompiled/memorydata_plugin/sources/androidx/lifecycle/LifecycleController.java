package androidx.lifecycle;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0007J\u0011\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0082\bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/lifecycle/LifecycleController;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "minState", "Landroidx/lifecycle/Lifecycle$State;", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "parentJob", "Lkotlinx/coroutines/Job;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/Job;)V", "observer", "Landroidx/lifecycle/LifecycleEventObserver;", "finish", "", "handleDestroy", "lifecycle-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle r3, Lifecycle.State r4, DispatchQueue r5, bx r6) {
        final bx r7 = (bx) ZeusTransformUtils.wrapperContextForParams(r6, bx.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "lifecycle");
        Intrinsics.checkNotNullParameter(r4, "minState");
        Intrinsics.checkNotNullParameter(r5, "dispatchQueue");
        Intrinsics.checkNotNullParameter(r7, "parentJob");
        this.lifecycle = r3;
        this.minState = r4;
        this.dispatchQueue = r5;
        LifecycleEventObserver r8 = new $$Lambda$LifecycleController$zCMdnRfMc_5b_cZQVypK9Ba72E(this, r7);
        this.observer = r8;
        if (r3.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        bx.a.a(r7, null, 1, null);
        finish();
        return;
    L5:
        r3.addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(r8, LifecycleObserver.class, "com.obric.memorydata.plugin"));
    }

    private final void handleDestroy(bx r3) {
        bx.a.a((bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin"), null, 1, null);
        finish();
    }

    /* JADX INFO: renamed from: lambda$zCMdnRfMc_5b_-cZQVypK9Ba72E, reason: not valid java name */
    public static /* synthetic */ void m49lambda$zCMdnRfMc_5b_cZQVypK9Ba72E(LifecycleController r0, bx r1, LifecycleOwner r2, Lifecycle.Event r3) {
        observer$lambda$0(r0, r1, r2, r3);
    }

    private static final void observer$lambda$0(LifecycleController r2, bx r3, LifecycleOwner r4, Lifecycle.Event r5) {
        bx r6 = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
        LifecycleOwner r7 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r6, "$parentJob");
        Intrinsics.checkNotNullParameter(r7, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r5, "<anonymous parameter 1>");
        if (r7.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        bx.a.a(r6, null, 1, null);
        r2.finish();
        return;
    L5:
        int r8 = r7.getLifecycle().getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r2.minState, Enum.class, "com.obric.memorydata.plugin"));
        DispatchQueue r9 = r2.dispatchQueue;
        if (r8 >= 0) goto L8;
        r9.pause();
        return;
    L8:
        r9.resume();
    }

    public final void finish() {
        this.lifecycle.removeObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(this.observer, LifecycleObserver.class, "com.obric.memorydata.plugin"));
        this.dispatchQueue.finish();
    }
}
