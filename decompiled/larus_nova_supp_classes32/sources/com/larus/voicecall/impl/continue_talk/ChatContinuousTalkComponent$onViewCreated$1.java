package com.larus.voicecall.impl.continue_talk;

import com.larus.common_ui.widget.input.a;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$onViewCreated$1", f = "ChatContinuousTalkComponent.kt", i = {}, l = {1032}, m = "invokeSuspend", n = {}, s = {})
public final class ChatContinuousTalkComponent$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatContinuousTalkComponent this$0;

    /* JADX INFO: renamed from: com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$onViewCreated$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public final /* synthetic */ ChatContinuousTalkComponent a;

        /* JADX INFO: renamed from: com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$onViewCreated$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$onViewCreated$1$1$1", f = "ChatContinuousTalkComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ double $maxAmplitude;
            int label;
            final /* synthetic */ ChatContinuousTalkComponent this$0;

            public C00191(ChatContinuousTalkComponent r1, double r2, Continuation<? super C00191> r4) {
                this.this$0 = r1;
                this.$maxAmplitude = r2;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00191(this.this$0, this.$maxAmplitude, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r3);
                ChatContinuousTalkComponent r4 = this.this$0;
                int r0 = ChatContinuousTalkComponent.M;
                h2 r5 = r4.h3();
                float r1 = (float) this.$maxAmplitude;
                d19.g r6 = r5.d;
                if (r6 == null) goto L8;
                r6.setAudioAmplitude(r1);
            L8:
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(ChatContinuousTalkComponent r1) {
            this.a = r1;
        }

        public final Object a(byte[] r9, Continuation<? super Unit> r10) {
            if ((r10 instanceof ChatContinuousTalkComponent$onViewCreated$1$1$emit$1) == false) goto L7;
            ChatContinuousTalkComponent$onViewCreated$1$1$emit$1 r0 = (ChatContinuousTalkComponent$onViewCreated$1$1$emit$1) r10;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r11 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            ResultKt.throwOnFailure(r11);
        L34:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r11);
        L19:
            Iterator<T> r12 = ((ArrayList) r11).iterator();
            if (r12.hasNext() == true) goto L22;
            Double r13 = null;
        L27:
            if (r13 == null) goto L29;
            double r14 = r13.doubleValue();
        L30:
            MainCoroutineDispatcher r4 = Dispatchers.getMain();
            C00191 r5 = new C00191(this.a, r14, null);
            r0.label = 2;
            if (BuildersKt.withContext(r4, r5, r0) != r2) goto L34;
            return r2;
        L29:
            r14 = 0.0d;
            goto L30
        L22:
            double r6 = Math.abs(((Number) r12.next()).doubleValue());
        L24:
            if (r12.hasNext() == false) goto L26;
            r6 = Math.max(r6, Math.abs(((Number) r12.next()).doubleValue()));
            goto L24
        L26:
            r13 = Boxing.boxDouble(r6);
            goto L27
        L16:
            ResultKt.throwOnFailure(r11);
            int r15 = a.a;
            r0.label = 1;
            r11 = a.a(r9, 45, r0);
            if (r11 != r2) goto L19;
            return r2;
        L7:
            r0 = new ChatContinuousTalkComponent$onViewCreated$1$1$emit$1(this, r10);
            goto L8
        }

        public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return a((byte[]) r1, r2);
        }
    }

    public ChatContinuousTalkComponent$onViewCreated$1(ChatContinuousTalkComponent r1, Continuation<? super ChatContinuousTalkComponent$onViewCreated$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatContinuousTalkComponent$onViewCreated$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ChatContinuousTalkComponent r6 = this.this$0;
        int r2 = ChatContinuousTalkComponent.M;
        kotlinx.coroutines.flow.d1 r7 = r6.m3().getRecordData();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
