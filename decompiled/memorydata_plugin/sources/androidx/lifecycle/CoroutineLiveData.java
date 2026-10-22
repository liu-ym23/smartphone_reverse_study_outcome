package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012-\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0013\u001a\u00020\u000bH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u000bH\u0014J\b\u0010\u001d\u001a\u00020\u000bH\u0014R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Landroidx/lifecycle/CoroutineLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MediatorLiveData;", "context", "Lkotlin/coroutines/CoroutineContext;", "timeoutInMs", "", "block", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)V", "blockRunner", "Landroidx/lifecycle/BlockRunner;", "emittedSource", "Landroidx/lifecycle/EmittedSource;", "clearSource", "clearSource$lifecycle_livedata_ktx_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSource", "Lkotlinx/coroutines/DisposableHandle;", AILabCheckPermissionTask.KEY_SOURCE, "Landroidx/lifecycle/LiveData;", "emitSource$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActive", "onInactive", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    private BlockRunner<T> blockRunner;
    private EmittedSource emittedSource;

    public CoroutineLiveData(CoroutineContext r10, long r11, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> r13) {
        CoroutineContext r12 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r10, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r13, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r4, "block");
        z r14 = cu.a((bx) ZeusTransformUtils.preCheckCast(r12.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin"));
        this.blockRunner = new BlockRunner(this, r4, r11, am.a(ba.b().a().plus(r12).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(r14, CoroutineContext.class, "com.obric.memorydata.plugin"))), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ CoroutineLiveData(CoroutineContext r2, long r3, Function2 r5, int r6, DefaultConstructorMarker r7) {
        CoroutineContext r4 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r4 = (CoroutineContext) ZeusTransformUtils.preCheckCast(EmptyCoroutineContext.INSTANCE, CoroutineContext.class, "com.obric.memorydata.plugin");
    L6:
        if ((r6 & 2) == 0) goto L8;
        r3 = 5000;
    L8:
        this(r4, r3, r8);
    }

    public static final /* synthetic */ void access$setBlockRunner$p(CoroutineLiveData r0, BlockRunner r1) {
        r0.blockRunner = r1;
    }

    public final Object clearSource$lifecycle_livedata_ktx_release(Continuation<? super Unit> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, CoroutineLiveData$clearSource$1.class) == false) goto L7;
        CoroutineLiveData$clearSource$1 r0 = (CoroutineLiveData$clearSource$1) ZeusTransformUtils.preCheckCast(r7, CoroutineLiveData$clearSource$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        CoroutineLiveData<T> this = (CoroutineLiveData) ZeusTransformUtils.preCheckCast(r0.L$0, CoroutineLiveData.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L19:
        this.emittedSource = null;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        EmittedSource r9 = this.emittedSource;
        if (r9 == null) goto L19;
        r0.L$0 = this;
        r0.label = 1;
        if (r9.disposeNow(r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new CoroutineLiveData$clearSource$1(this, r7);
        goto L8
    }

    public final Object emitSource$lifecycle_livedata_ktx_release(LiveData<T> r8, Continuation<? super bc> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, CoroutineLiveData$emitSource$1.class) == false) goto L7;
        CoroutineLiveData$emitSource$1 r1 = (CoroutineLiveData$emitSource$1) ZeusTransformUtils.preCheckCast(r10, CoroutineLiveData$emitSource$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        CoroutineLiveData<T> this = (CoroutineLiveData) ZeusTransformUtils.preCheckCast(r1.L$0, CoroutineLiveData.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L22:
        EmittedSource r12 = (EmittedSource) ZeusTransformUtils.preCheckCast(r11, EmittedSource.class, "com.obric.memorydata.plugin");
        this.emittedSource = r12;
        return r12;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = (LiveData) ZeusTransformUtils.preCheckCast(r1.L$1, LiveData.class, "com.obric.memorydata.plugin");
        this = (CoroutineLiveData) ZeusTransformUtils.preCheckCast(r1.L$0, CoroutineLiveData.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L19:
        MediatorLiveData r13 = (MediatorLiveData) ZeusTransformUtils.preCheckCast(this, MediatorLiveData.class, "com.obric.memorydata.plugin");
        r1.L$0 = this;
        r1.L$1 = null;
        r1.label = 2;
        r11 = CoroutineLiveDataKt.addDisposableSource(r13, r8, r1);
        if (r11 != r3) goto L22;
        return r3;
    L16:
        ResultKt.throwOnFailure(r11);
        r1.L$0 = this;
        r1.L$1 = r8;
        r1.label = 1;
        if (clearSource$lifecycle_livedata_ktx_release(r1) != r3) goto L19;
        return r3;
    L7:
        r1 = new CoroutineLiveData$emitSource$1(this, r10);
        goto L8
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        BlockRunner<T> r0 = this.blockRunner;
        if (r0 == null) goto L6;
        r0.maybeRun();
        return;
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        BlockRunner<T> r0 = this.blockRunner;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }
}
