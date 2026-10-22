package com.larus.bmhome.chat.detail.code.preview;

import android.widget.ProgressBar;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.mainbot.impl.databinding.LarusFragmentCodeBlockDetailBinding;
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
@DebugMetadata(c = "com.larus.bmhome.chat.detail.code.preview.CodeBlockDetailPreviewComponent$startLoading$1", f = "CodeBlockDetailPreviewComponent.kt", i = {0, 0, 1, 2}, l = {DoraCallStateCode.ENV_OBSERVE_AUTO_TIMER_HEARTBEAT, 193, 197}, m = "invokeSuspend", n = {"$this$launch", "progress", "$this$launch", "$this$launch"}, s = {"L$0", "F$0", "L$0", "L$0"})
final class CodeBlockDetailPreviewComponent$startLoading$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    float F$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CodeBlockDetailPreviewComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.detail.code.preview.CodeBlockDetailPreviewComponent$startLoading$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.detail.code.preview.CodeBlockDetailPreviewComponent$startLoading$1$1", f = "CodeBlockDetailPreviewComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $progress;
        int label;
        final /* synthetic */ CodeBlockDetailPreviewComponent this$0;

        public AnonymousClass1(CodeBlockDetailPreviewComponent r1, float r2, Continuation<? super AnonymousClass1> r3) {
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
            CodeBlockDetailPreviewComponent r4 = this.this$0;
            int r0 = CodeBlockDetailPreviewComponent.B;
            LarusFragmentCodeBlockDetailBinding r5 = r4.d0();
            if (r5 == null) goto L10;
            ProgressBar r6 = r5.p;
            if (r6 == null) goto L10;
            r6.setProgress((int) (100 * this.$progress));
        L10:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.detail.code.preview.CodeBlockDetailPreviewComponent$startLoading$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.detail.code.preview.CodeBlockDetailPreviewComponent$startLoading$1$2", f = "CodeBlockDetailPreviewComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CodeBlockDetailPreviewComponent this$0;

        public AnonymousClass2(CodeBlockDetailPreviewComponent r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
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
            this.this$0.Rj();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CodeBlockDetailPreviewComponent$startLoading$1(CodeBlockDetailPreviewComponent r1, Continuation<? super CodeBlockDetailPreviewComponent$startLoading$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CodeBlockDetailPreviewComponent$startLoading$1 r0 = new CodeBlockDetailPreviewComponent$startLoading$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x009c -> B:14:0x0042). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r14);
        CoroutineScope r15 = r2;
    L13:
        CodeBlockDetailPreviewComponent$startLoading$1 r3 = this;
    L14:
        long r7 = System.currentTimeMillis();
        CodeBlockDetailPreviewComponent r9 = r3.this$0;
        float r8 = RangesKt.coerceIn((r7 - r9.r) / r9.s, 0.0f, 0.9f);
        MainCoroutineDispatcher r10 = Dispatchers.getMain();
        AnonymousClass1 r11 = new AnonymousClass1(r3.this$0, r8, null);
        r3.L$0 = r15;
        r3.F$0 = r8;
        r3.label = 1;
        if (BuildersKt.withContext(r10, r11, r3) != r0) goto L17;
        return r0;
    L17:
        CoroutineScope r12 = r15;
        CodeBlockDetailPreviewComponent$startLoading$1 r16 = r3;
        float r4 = r8;
    L19:
        if (r4 < 0.9f) goto L23;
        CoroutineScopeKt.cancel$default(r12, null, 1, null);
        MainCoroutineDispatcher r5 = Dispatchers.getMain();
        AnonymousClass2 r13 = new AnonymousClass2(r16.this$0, null);
        r16.L$0 = r12;
        r16.label = 2;
        if (BuildersKt.withContext(r5, r13, r16) != r0) goto L23;
        return r0;
    L23:
        CoroutineScope r6 = r12;
    L24:
        r16.L$0 = r6;
        r16.label = 3;
        if (DelayKt.delay(1000, r16) != r0) goto L27;
        return r0;
    L27:
        CoroutineScope r17 = r6;
        r3 = r16;
        r15 = r17;
        goto L14
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r6 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r14);
        r16 = this;
        goto L24
    L11:
        r4 = this.F$0;
        r12 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r14);
        r16 = this;
        goto L19
    L12:
        ResultKt.throwOnFailure(r14);
        r15 = (CoroutineScope) this.L$0;
        goto L13
    }
}
