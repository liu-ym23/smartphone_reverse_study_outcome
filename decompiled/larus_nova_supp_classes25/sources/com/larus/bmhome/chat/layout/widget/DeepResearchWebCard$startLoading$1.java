package com.larus.bmhome.chat.layout.widget;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.widget.DeepResearchWebCard$startLoading$1", f = "DeepResearchWebCard.kt", i = {0, 0, 1}, l = {213, 219}, m = "invokeSuspend", n = {"$this$launch", "progress", "$this$launch"}, s = {"L$0", "F$0", "L$0"})
public final class DeepResearchWebCard$startLoading$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    float F$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeepResearchWebCard this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.layout.widget.DeepResearchWebCard$startLoading$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.layout.widget.DeepResearchWebCard$startLoading$1$1", f = "DeepResearchWebCard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $progress;
        int label;
        final /* synthetic */ DeepResearchWebCard this$0;

        public AnonymousClass1(DeepResearchWebCard r1, float r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$progress = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$progress, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r3);
            DeepResearchWebProgressBar r4 = DeepResearchWebCard.R5(this.this$0).d;
            if ((r4 instanceof DeepResearchWebProgressBar) == true) goto L8;
            r4 = null;
        L8:
            if (r4 == null) goto L13;
            r4.setProgress(this.$progress);
            return Unit.INSTANCE;
        L13:
            return null;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DeepResearchWebCard$startLoading$1(DeepResearchWebCard r1, Continuation<? super DeepResearchWebCard$startLoading$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DeepResearchWebCard$startLoading$1 r0 = new DeepResearchWebCard$startLoading$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0079 -> B:12:0x0037). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r13);
        CoroutineScope r14 = r2;
    L11:
        DeepResearchWebCard$startLoading$1 r3 = this;
    L12:
        long r6 = System.currentTimeMillis();
        DeepResearchWebCard r8 = r3.this$0;
        float r7 = RangesKt.coerceIn((r6 - r8.d) / r8.e, 0.0f, 0.9f);
        MainCoroutineDispatcher r9 = Dispatchers.getMain();
        AnonymousClass1 r10 = new AnonymousClass1(r3.this$0, r7, null);
        r3.L$0 = r14;
        r3.F$0 = r7;
        r3.label = 1;
        if (BuildersKt.withContext(r9, r10, r3) != r0) goto L15;
        return r0;
    L15:
        DeepResearchWebCard$startLoading$1 r11 = r3;
        float r4 = r7;
    L17:
        if (r4 < 0.9f) goto L19;
        CoroutineScopeKt.cancel$default(r14, null, 1, null);
    L19:
        r11.L$0 = r14;
        r11.label = 2;
        if (DelayKt.delay(1000, r11) != r0) goto L22;
        return r0;
    L22:
        r3 = r11;
        goto L12
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r4 = this.F$0;
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r13);
        r14 = r12;
        r11 = this;
        goto L17
    L10:
        ResultKt.throwOnFailure(r13);
        r14 = (CoroutineScope) this.L$0;
        goto L11
    }
}
