package com.obric.memorydata.memory.ui.detail;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$initView$2$1$1", f = "MemoryDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MemoryDetailActivity$initView$2$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $allSuccess;
    final /* synthetic */ String $eventString;
    int label;
    final /* synthetic */ MemoryDetailActivity this$0;

    MemoryDetailActivity$initView$2$1$1(MemoryDetailActivity r3, boolean r4, String r5, Continuation<? super MemoryDetailActivity$initView$2$1$1> r6) {
        MemoryDetailActivity r7 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r7;
        this.$allSuccess = r4;
        this.$eventString = r5;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryDetailActivity$initView$2$1$1(this.this$0, this.$allSuccess, this.$eventString, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MemoryDetailActivity$initView$2$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryDetailActivity$initView$2$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r7);
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.memorydata.plugin");
        if (this.$allSuccess == false) goto L7;
        String r6 = this.this$0.getString(ZeusTransformUtils.mapRes(R.string.memory_calendar_insert_success, TypedValues.Custom.S_STRING, "memory_calendar_insert_success"), new Object[]{this.$eventString});
    L8:
        Intrinsics.checkNotNull(r6);
        ba.a(r8, r6, 0, 4, null);
        return Unit.INSTANCE;
    L7:
        r6 = this.this$0.getString(ZeusTransformUtils.mapRes(R.string.memory_calendar_insert_fail, TypedValues.Custom.S_STRING, "memory_calendar_insert_fail"), new Object[]{this.$eventString});
        goto L8
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
