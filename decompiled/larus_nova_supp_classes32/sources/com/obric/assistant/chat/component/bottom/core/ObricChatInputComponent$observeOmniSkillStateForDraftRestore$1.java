package com.obric.assistant.chat.component.bottom.core;

import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.chat.component.bottom.core.mention.ObricMentionInputController;
import com.obric.assistant.special_input.t0;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;
import paa.c;
import paa.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.component.bottom.core.ObricChatInputComponent$observeOmniSkillStateForDraftRestore$1", f = "ObricChatInputComponent.kt", i = {}, l = {458}, m = "invokeSuspend", n = {}, s = {})
final class ObricChatInputComponent$observeOmniSkillStateForDraftRestore$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricChatInputComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ObricChatInputComponent a;

        public a(ObricChatInputComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            t0 r3 = (t0) r1;
            if (r3.c == false) goto L19;
            if (r3.f == false) goto L19;
            ObricMentionInputController r4 = this.a.A;
            if (r4 == null) goto L19;
            if (r4.j == false) goto L19;
            c r5 = r4.c;
            if (r5 == null) goto L14;
            List<e> r6 = r5.Zm();
        L15:
            if (r6 != null) goto L17;
            r6 = CollectionsKt.emptyList();
        L17:
            r4.m(r6);
            r4.l(r6);
            goto L19
        L14:
            r6 = null;
        L19:
            return Unit.INSTANCE;
        }
    }

    public ObricChatInputComponent$observeOmniSkillStateForDraftRestore$1(ObricChatInputComponent r1, Continuation<? super ObricChatInputComponent$observeOmniSkillStateForDraftRestore$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricChatInputComponent$observeOmniSkillStateForDraftRestore$1(this.this$0, r3);
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
        b1 r6 = com.obric.assistant.special_input.j.a;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
