package com.larus.bot.impl.feature.edit.feature.avatar;

import com.larus.bot.impl.databinding.LarusLayoutBotEditAvatarBinding;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
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
import kotlinx.coroutines.flow.i1;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.avatar.BotAvatarEditView$bindObservers$1", f = "BotAvatarEditView.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
final class BotAvatarEditView$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BotAvatarEditView this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ BotAvatarEditView a;

        public a(BotAvatarEditView r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object emit(Object r11, Continuation r12) {
            c r13 = (c) r11;
            final BotAvatarEditView r14 = this.a;
            LarusLayoutBotEditAvatarBinding r0 = r14.b;
            FLogger.a.i("BotAvatarEditView", "refreshUIState, isGenerating: " + r13.c);
            LottieAdapterView r1 = r0.b;
            if (r13.c == false) goto L5;
            int r2 = 0;
        L6:
            r1.setVisibility(r2);
            r0.a.setEnabled(!r13.c);
            if (r13.a == null) goto L9;
            int r3 = c7.b(120);
            com.larus.bot.impl.common.util.h.a(r0.e, r13.a, "bot_avatar_edit_refresh", r13.b, Integer.valueOf(r3), Integer.valueOf(r3), true, new r(r14));
        L11:
            return Unit.INSTANCE;
        L9:
            r0.e.setActualImageResource(2131240119);
            goto L11
        L5:
            r2 = 8;
            goto L6
        }
    }

    public BotAvatarEditView$bindObservers$1(BotAvatarEditView r1, Continuation<? super BotAvatarEditView$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotAvatarEditView$bindObservers$1(this.this$0, r3);
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
        i1<c> r6 = this.this$0.c.getUiState();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
