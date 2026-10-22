package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmRecordingNetworkMockEngine$launchEmit$job$1", f = "MmRecordingNetworkMockEngine.kt", i = {}, l = {221, 224, 226}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingNetworkMockEngine$launchEmit$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableSharedFlow<Object> $flow;
    final /* synthetic */ g.c $push;
    final /* synthetic */ g.b $pushKey;
    int label;
    final /* synthetic */ g this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmRecordingNetworkMockEngine$launchEmit$job$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmRecordingNetworkMockEngine$launchEmit$job$1$1", f = "MmRecordingNetworkMockEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
        /* synthetic */ int I$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass1 r0 = new AnonymousClass1(r3);
            r0.I$0 = ((Number) r2).intValue();
            return r0;
        }

        public final Object invoke(int r1, Continuation<? super Boolean> r2) {
            return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Number) r1).intValue(), (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            if (this.I$0 <= 0) goto L7;
            boolean r3 = true;
        L9:
            return Boxing.boxBoolean(r3);
        L7:
            r3 = false;
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MmRecordingNetworkMockEngine$launchEmit$job$1(MutableSharedFlow<Object> r1, g.c r2, g r3, g.b r4, Continuation<? super MmRecordingNetworkMockEngine$launchEmit$job$1> r5) {
        this.$flow = r1;
        this.$push = r2;
        this.this$0 = r3;
        this.$pushKey = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingNetworkMockEngine$launchEmit$job$1(this.$flow, this.$push, this.this$0, this.$pushKey, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r7);
    L18:
        this.$push.getClass();
    L19:
        MutableSharedFlow<Object> r8 = this.$flow;
        this.$push.getClass();
        this.label = 3;
        if (r8.emit(null, this) != r0) goto L22;
        return r0;
    L22:
        g r9 = this.this$0;
        String r2 = this.$pushKey.getType();
        String r3 = this.$pushKey.b;
        g.a r4 = g.h;
        r9.c(r2, r3, true, "mock push emitted");
        return Unit.INSTANCE;
    L6:
        if (r1 == 2) goto L11;
        if (r1 != 3) goto L10;
        ResultKt.throwOnFailure(r7);
        goto L22
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r7);
        goto L19
    L13:
        ResultKt.throwOnFailure(r7);
        if (((Number) this.$flow.getSubscriptionCount().getValue()).intValue() > 0) goto L18;
        i1 r10 = this.$flow.getSubscriptionCount();
        AnonymousClass1 r5 = new AnonymousClass1(null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.t(r10, r5, this) != r0) goto L18;
        return r0;
    }
}
