package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes.dex */
@MainThread
@SourceDebugExtension({"SMAP\nLifecycleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n1#1,70:1\n57#1,3:71\n57#1,3:74\n*S KotlinDebug\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n49#1:71,3\n36#1:74,3\n*E\n"})
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle r10, Lifecycle.State r11, DispatchQueue r12, final v1 r13) {
        Intrinsics.checkNotNullParameter(r10, "lifecycle");
        Intrinsics.checkNotNullParameter(r11, "minState");
        Intrinsics.checkNotNullParameter(r12, "dispatchQueue");
        Intrinsics.checkNotNullParameter(r13, "parentJob");
        this.lifecycle = r10;
        this.minState = r11;
        this.dispatchQueue = r12;
        LifecycleEventObserver r14 = new d(this, r13);
        this.observer = r14;
        if (r10.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        v1.a.a(r13, null, 1, null);
        finish();
        return;
    L5:
        r10.addObserver(r14);
    }

    public static /* synthetic */ void a(LifecycleController r10, v1 r11, LifecycleOwner r12, Lifecycle.Event r13) {
        observer$lambda$0(r10, r11, r12, r13);
    }

    private final void handleDestroy(v1 r10) {
        v1.a.a(r10, null, 1, null);
        finish();
    }

    private static final void observer$lambda$0(LifecycleController r10, v1 r11, LifecycleOwner r12, Lifecycle.Event r13) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$parentJob");
        Intrinsics.checkNotNullParameter(r12, "source");
        Intrinsics.checkNotNullParameter(r13, "<anonymous parameter 1>");
        if (r12.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        v1.a.a(r11, null, 1, null);
        r10.finish();
        return;
    L5:
        int r14 = r12.getLifecycle().getCurrentState().compareTo(r10.minState);
        DispatchQueue r15 = r10.dispatchQueue;
        if (r14 >= 0) goto L8;
        r15.pause();
        return;
    L8:
        r15.resume();
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
