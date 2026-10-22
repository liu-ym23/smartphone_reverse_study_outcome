package com.bytedance.ai.view.input;

import android.view.View;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.view.input.ChatInput$setupStatusChangedEvent$1", f = "ChatInput.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
final class ChatInput$setupStatusChangedEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatInput this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ChatInput a;

        /* JADX INFO: renamed from: com.bytedance.ai.view.input.ChatInput$setupStatusChangedEvent$1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0052a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[FloatingChatStatus.values().length];
                r0[FloatingChatStatus.READY_TO_INPUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[FloatingChatStatus.READY_TO_SPEAK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[FloatingChatStatus.READY_TO_SEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public a(ChatInput r1) {
            this.a = r1;
        }

        public final Object emit(Object r10, Continuation r11) {
            int r12 = C0052a.a[((FloatingChatStatus) r10).ordinal()];
            if (r12 != 1) goto L5;
            ChatInput.b6(this.a).setVisibility(0);
            ChatInput.c6(this.a).setVisibility(8);
            View r13 = this.a.g;
            if (r13 == null) goto L30;
            r13.setVisibility(8);
        L30:
            View r14 = this.a.h;
            if (r14 == null) goto L33;
            r14.setVisibility(0);
        L33:
            View r15 = this.a.i;
            if (r15 == null) goto L37;
            r15.setVisibility(8);
        L37:
            return Unit.INSTANCE;
        L5:
            if (r12 != 2) goto L7;
            this.a.hideKeyboard();
            ChatInput.b6(this.a).setVisibility(8);
            ChatInput.c6(this.a).setVisibility(0);
            View r16 = this.a.g;
            if (r16 == null) goto L21;
            r16.setVisibility(0);
        L21:
            View r17 = this.a.h;
            if (r17 == null) goto L24;
            r17.setVisibility(8);
        L24:
            View r18 = this.a.i;
            if (r18 == null) goto L37;
            r18.setVisibility(8);
            goto L37
        L7:
            if (r12 != 3) goto L37;
            ChatInput.b6(this.a).setVisibility(0);
            ChatInput.c6(this.a).setVisibility(8);
            View r19 = this.a.g;
            if (r19 == null) goto L12;
            r19.setVisibility(8);
        L12:
            View r20 = this.a.h;
            if (r20 == null) goto L15;
            r20.setVisibility(8);
        L15:
            View r21 = this.a.i;
            if (r21 == null) goto L37;
            r21.setVisibility(0);
            goto L37
        }
    }

    public ChatInput$setupStatusChangedEvent$1(ChatInput r1, Continuation<? super ChatInput$setupStatusChangedEvent$1> r10) {
        this.this$0 = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ChatInput$setupStatusChangedEvent$1(this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r10);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Function0<z0<FloatingChatStatus>> r11 = this.this$0.getChatStatus();
        if (r11 == null) goto L18;
        z0 r12 = (z0) r11.invoke();
        if (r12 == null) goto L18;
        a r13 = new a(this.this$0);
        this.label = 1;
        if (r12.collect(r13, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
