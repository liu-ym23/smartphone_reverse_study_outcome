package com.larus.voicecall.impl.subtitle;

import com.larus.audio.call.subtitle.SubtitleAction;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout$initObservers$1", f = "RealtimeCallSubtitleLayout.kt", i = {}, l = {277}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallSubtitleLayout$initObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCallSubtitleLayout this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ RealtimeCallSubtitleLayout a;

        /* JADX INFO: renamed from: com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout$initObservers$1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0021a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[SubtitleAction.values().length];
                r0[SubtitleAction.UPDATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r0[SubtitleAction.DELETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r0[SubtitleAction.NEW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[SubtitleAction.PLACEHOLDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r0[SubtitleAction.REFRESH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r0[SubtitleAction.LISTENING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r0[SubtitleAction.WAIT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                a = r0;
            }
        }

        public a(RealtimeCallSubtitleLayout r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v22, types: [android.view.ViewGroup, com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout] */
        /* JADX WARN: Type inference failed for: r4v32, types: [android.view.ViewGroup, com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout] */
        public final Object emit(Object r4, Continuation r5) {
            final y0 r6 = (y0) r4;
            if (r6 == null) goto L5;
            SubtitleAction r7 = r6.a;
        L6:
            f2a.c r0 = com.larus.voicecall.impl.utils.t.a.b(this.a.k + " receive new action");
            r0.e(new s(r6));
            f2a.c.c(r0, "initObservers", 13);
            if (r7 != null) goto L9;
            int r8 = -1;
        L11:
            switch(r8) {
                case 1: goto L44;
                case 2: goto L40;
                case 3: goto L36;
                case 4: goto L30;
                case 5: goto L22;
                case 6: goto L17;
                case 7: goto L13;
                default: goto L48;
            };
        L13:
            RealtimeCallSubtitleLayout r9 = this.a;
            if (r9.d == true) goto L51;
            com.larus.utils.e1.o(r9.a.c);
            ?? r10 = this.a;
            r10.a.e.setText(r10.getContext().getString(2131900627));
            com.larus.utils.e1.x(this.a.a.e);
        L50:
            return Unit.INSTANCE;
        L51:
            return Unit.INSTANCE;
        L17:
            RealtimeCallSubtitleLayout r11 = this.a;
            if (r11.d == true) goto L52;
            com.larus.utils.e1.o(r11.a.c);
            ?? r12 = this.a;
            r12.a.e.setText(r12.getContext().getString(2131898446));
            com.larus.utils.e1.x(this.a.a.e);
            goto L50
        L52:
            return Unit.INSTANCE;
        L30:
            RealtimeCallSubtitleAdapter r13 = this.a.c;
            if (r13 == null) goto L33;
            r13.insert();
        L33:
            RealtimeCallSubtitleLayout r14 = this.a;
            if (r14.d == false) goto L50;
            r14.U5(false);
            goto L50
        L36:
            RealtimeCallSubtitleLayout.R5(this.a);
            RealtimeCallSubtitleAdapter r15 = this.a.c;
            if (r15 == null) goto L39;
            r15.insert();
        L39:
            this.a.U5(false);
            goto L50
        L40:
            RealtimeCallSubtitleLayout.R5(this.a);
            RealtimeCallSubtitleAdapter r16 = this.a.c;
            if (r16 == null) goto L43;
            r16.delete(r6.b);
        L43:
            this.a.U5(true);
            RealtimeCallSubtitleLayout.S5(this.a);
            goto L50
        L44:
            RealtimeCallSubtitleLayout.R5(this.a);
            RealtimeCallSubtitleAdapter r17 = this.a.c;
            if (r17 == null) goto L47;
            r17.update(r6.b);
        L47:
            this.a.U5(true);
            goto L50
        L48:
            com.larus.utils.e1.o(this.a.a.e);
            goto L50
        L22:
            if (this.a.a.c.isComputingLayout() == false) goto L24;
        L29:
            RealtimeCallSubtitleLayout.S5(this.a);
            goto L50
        L24:
            if (r6.d == false) goto L26;
            RealtimeCallSubtitleLayout.R5(this.a);
        L26:
            RealtimeCallSubtitleAdapter r18 = this.a.c;
            if (r18 == null) goto L29;
            r18.notifyDataSetChanged();
            goto L29
        L9:
            r8 = C0021a.a[r7.ordinal()];
            goto L11
        L5:
            r7 = null;
            goto L6
        }
    }

    public RealtimeCallSubtitleLayout$initObservers$1(RealtimeCallSubtitleLayout r1, Continuation<? super RealtimeCallSubtitleLayout$initObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallSubtitleLayout$initObservers$1(this.this$0, r3);
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
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        RealtimeCallSubtitleLayout r6 = this.this$0;
        q0 r2 = r6.b;
        if (r2 == null) goto L18;
        MutableSharedFlow r3 = r2.i;
        if (r3 == null) goto L18;
        a r4 = new a(r6);
        this.label = 1;
        if (r3.collect(r4, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
