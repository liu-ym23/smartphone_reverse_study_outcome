package com.larus.canvas.feature.component.input;

import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.input.CanvasInputComponent$initInput$1", f = "CanvasInputComponent.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasInputComponent$initInput$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ fy8.k $inputInitConfig;
    int label;
    final /* synthetic */ CanvasInputComponent this$0;

    /* JADX INFO: renamed from: com.larus.canvas.feature.component.input.CanvasInputComponent$initInput$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.component.input.CanvasInputComponent$initInput$1$1", f = "CanvasInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ fy8.k $inputInitConfig;
        int label;
        final /* synthetic */ CanvasInputComponent this$0;

        public AnonymousClass1(fy8.k r1, CanvasInputComponent r2, Continuation<? super AnonymousClass1> r3) {
            this.$inputInitConfig = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$inputInitConfig, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L28;
            ResultKt.throwOnFailure(r9);
            fy8.k r10 = this.$inputInitConfig;
            String r1 = r10.b;
            if (r1 == null) goto L15;
            CanvasInputComponent r0 = this.this$0;
            Pair<Integer, Integer> r2 = r10.d;
            boolean r3 = !r10.a;
            int r11 = CanvasInputComponent.t;
            ICoreInputAbility r4 = r0.Y2();
            if (r4 == null) goto L15;
            Integer r12 = null;
            if (r2 == null) goto L11;
            Integer r5 = (Integer) r2.getFirst();
        L12:
            if (r2 == null) goto L14;
            r12 = (Integer) r2.getSecond();
        L14:
            ICoreInputAbility.b.d(r4, r1, r3, r3, r5, r12, false, 32);
            goto L15
        L11:
            r5 = null;
        L15:
            Function0<Boolean> r13 = this.$inputInitConfig.e;
            if (r13 == null) goto L20;
            CanvasInputComponent r6 = this.this$0;
            int r7 = CanvasInputComponent.t;
            z8 r8 = r6.h3();
            if (r8 == null) goto L20;
            r8.v9(r13);
        L20:
            String r14 = this.$inputInitConfig.c;
            if (r14 == null) goto L26;
            CanvasInputComponent r15 = this.this$0;
            int r16 = CanvasInputComponent.t;
            ICoreInputAbility r17 = r15.Y2();
            if (r17 == null) goto L26;
            r17.M5(r14);
        L26:
            return Unit.INSTANCE;
        L28:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CanvasInputComponent$initInput$1(CanvasInputComponent r1, fy8.k r2, Continuation<? super CanvasInputComponent$initInput$1> r3) {
        this.this$0 = r1;
        this.$inputInitConfig = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CanvasInputComponent$initInput$1(this.this$0, this.$inputInitConfig, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CanvasInputComponent r8 = this.this$0;
        Lifecycle.State r2 = Lifecycle.State.RESUMED;
        AnonymousClass1 r3 = new AnonymousClass1(this.$inputInitConfig, r8, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.b(r8, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
