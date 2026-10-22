package com.larus.bmhome.chat.deepresearch.component;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepresearch.component.DeepReSearchContentComponent$startPodcastTimeoutTask$1", f = "DeepReSearchContentComponent.kt", i = {}, l = {357, 362}, m = "invokeSuspend", n = {}, s = {})
final class DeepReSearchContentComponent$startPodcastTimeoutTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $timeout;
    final /* synthetic */ Function0<Unit> $timeoutCallback;
    int label;
    final /* synthetic */ DeepReSearchContentComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.deepresearch.component.DeepReSearchContentComponent$startPodcastTimeoutTask$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.deepresearch.component.DeepReSearchContentComponent$startPodcastTimeoutTask$1$1", f = "DeepReSearchContentComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $timeoutCallback;
        int label;

        public AnonymousClass1(Function0<Unit> r1, Continuation<? super AnonymousClass1> r2) {
            this.$timeoutCallback = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$timeoutCallback, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$timeoutCallback.invoke();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DeepReSearchContentComponent$startPodcastTimeoutTask$1(int r1, DeepReSearchContentComponent r2, Function0<Unit> r3, Continuation<? super DeepReSearchContentComponent$startPodcastTimeoutTask$1> r4) {
        this.$timeout = r1;
        this.this$0 = r2;
        this.$timeoutCallback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DeepReSearchContentComponent$startPodcastTimeoutTask$1(this.$timeout, this.this$0, this.$timeoutCallback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L19:
        this.this$0.q = null;
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L13:
        Job r13 = this.this$0.F;
        if (r13 == null) goto L16;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
    L16:
        this.this$0.D = false;
        FLogger r14 = FLogger.a;
        Map<String, Long> r2 = DeepReSearchContentComponent.M;
        r14.e("DeepSearchContent", "on podcast generate timeout. timeoutDuration=" + this.$timeout);
        DeepReSearchContentComponent r15 = this.this$0;
        r15.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r15), Dispatchers.getIO(), null, new DeepReSearchContentComponent$mobGenerateTimeout$1(r15, null), 2, null);
        MainCoroutineDispatcher r16 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.$timeoutCallback, null);
        this.label = 2;
        if (BuildersKt.withContext(r16, r3, this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r12);
        long r5 = this.$timeout;
        this.label = 1;
        if (DelayKt.delay(r5, this) != r0) goto L13;
        return r0;
    }
}
