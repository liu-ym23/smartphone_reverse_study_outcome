package androidx.lifecycle;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/CoroutineContext;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getLifecycle$lifecycle_common", "()Landroidx/lifecycle/Lifecycle;", "onStateChanged", "", AILabCheckPermissionTask.KEY_SOURCE, "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "register", "lifecycle-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    private final CoroutineContext coroutineContext;
    private final Lifecycle lifecycle;

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ LifecycleCoroutineScopeImpl this$0;

        AnonymousClass1(LifecycleCoroutineScopeImpl r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r5);
            al r6 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            if (this.this$0.getLifecycle$lifecycle_common().getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(Lifecycle.State.INITIALIZED, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L7;
            this.this$0.getLifecycle$lifecycle_common().addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(this.this$0, LifecycleObserver.class, "com.obric.memorydata.plugin"));
        L9:
            return Unit.INSTANCE;
        L7:
            ca.a(r6.getCoroutineContext(), null, 1, null);
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LifecycleCoroutineScopeImpl(Lifecycle r3, CoroutineContext r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "lifecycle");
        Intrinsics.checkNotNullParameter(r5, "coroutineContext");
        this.lifecycle = r3;
        this.coroutineContext = r5;
        if (getLifecycle$lifecycle_common().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
        ca.a(getCoroutineContext(), null, 1, null);
        return;
    }

    @Override // kotlinx.coroutines.al
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    public Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
        Intrinsics.checkNotNullParameter((LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin"), AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r4, "event");
        if (getLifecycle$lifecycle_common().getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(Lifecycle.State.DESTROYED, Enum.class, "com.obric.memorydata.plugin")) > 0) goto L6;
        getLifecycle$lifecycle_common().removeObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(this, LifecycleObserver.class, "com.obric.memorydata.plugin"));
        ca.a(getCoroutineContext(), null, 1, null);
        return;
    }

    public final void register() {
        i.a((al) ZeusTransformUtils.preCheckCast(this, al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b().a(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }
}
