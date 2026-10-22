package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements kotlinx.coroutines.flow.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f18868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f18869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f18870c;
    public final /* synthetic */ kotlinx.coroutines.flow.h d;

    public h(Ref.ObjectRef r5, CoroutineScope r10, i r11, kotlinx.coroutines.flow.h r12) {
        this.f18868a = r5;
        this.f18869b = r10;
        this.f18870c = r11;
        this.d = r12;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [T, kotlinx.coroutines.Job] */
    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r10, Continuation r11) {
        if ((r11 instanceof ChannelFlowTransformLatest$flowCollect$3$1$emit$1) == false) goto L7;
        ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r5 = (ChannelFlowTransformLatest$flowCollect$3$1$emit$1) r11;
        int r12 = r5.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        Job r16 = (Job) r5.L$2;
        r10 = r5.L$1;
        h this = (h) r5.L$0;
        ResultKt.throwOnFailure(r13);
    L19:
        Ref.ObjectRef r17 = this.f18868a;
        CoroutineStart r18 = CoroutineStart.UNDISPATCHED;
        kotlinx.coroutines.flow.h r19 = this.d;
        ChannelFlowTransformLatest$flowCollect$3$1$2 r20 = new ChannelFlowTransformLatest$flowCollect$3$1$2(this.f18870c, r19, r10, null);
        r17.element = BuildersKt.launch$default(this.f18869b, null, r18, r20, 1, null);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        Job r21 = (Job) this.f18868a.element;
        if (r21 == null) goto L19;
        r21.cancel(new ChildCancelledException());
        r5.L$0 = this;
        r5.L$1 = r10;
        r5.L$2 = r21;
        r5.label = 1;
        if (r21.join(r5) != r14) goto L19;
        return r14;
    L7:
        r5 = new ChannelFlowTransformLatest$flowCollect$3$1$emit$1(this, r11);
        goto L8
    }
}
