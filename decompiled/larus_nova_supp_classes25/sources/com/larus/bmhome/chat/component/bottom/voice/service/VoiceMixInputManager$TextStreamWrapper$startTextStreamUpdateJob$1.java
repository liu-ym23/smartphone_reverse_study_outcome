package com.larus.bmhome.chat.component.bottom.voice.service;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.voice.d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.service.VoiceMixInputManager$TextStreamWrapper$startTextStreamUpdateJob$1", f = "VoiceMixInputManager.kt", i = {}, l = {355}, m = "invokeSuspend", n = {}, s = {})
final class VoiceMixInputManager$TextStreamWrapper$startTextStreamUpdateJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VoiceMixInputManager.TextStreamWrapper this$0;

    public VoiceMixInputManager$TextStreamWrapper$startTextStreamUpdateJob$1(VoiceMixInputManager.TextStreamWrapper r1, Continuation<? super VoiceMixInputManager$TextStreamWrapper$startTextStreamUpdateJob$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VoiceMixInputManager$TextStreamWrapper$startTextStreamUpdateJob$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
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
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L35:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        if ((this.this$0.f + this.this$0.e).length() != 0) goto L11;
        boolean r13 = true;
    L12:
        if (r13 == true) goto L14;
        VoiceMixInputManager.TextStreamWrapper r14 = this.this$0;
        if (r14.h == true) goto L18;
        String r3 = r14.f;
        String r4 = r3 + r14.e + 8239;
        SpannableString r5 = new SpannableString(r4);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L26
        r5.setSpan(new ForegroundColorSpan(r14.a.getResources().getColor(v19.c.b(2130972081, r14.a, 2131103143))), RangesKt.coerceAtLeast(r5.length() - 6, r3.length()), RangesKt.coerceAtLeast(r5.length() - 1, r3.length()), 17);     // Catch: Throwable -> L26
        r19.b r7 = r14.i;     // Catch: Throwable -> L26
        if (r7 == null) goto L23;
        r5.setSpan(r7, RangesKt.coerceAtLeast(r5.length() - 1, r3.length()), r5.length(), 17);     // Catch: Throwable -> L26
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L24:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L26
    L28:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L31;
        int r11 = d0.d;
        d0.a.a("renderStreamText error " + r10.getMessage() + " textContext=" + r3 + " textStream=" + r4);
    L31:
        boolean r15 = this.this$0.h;
        this.label = 1;
        if (r14.a(r5, r15, false) != r0) goto L35;
        return r0;
    L23:
        r8 = null;
    L26:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L18:
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L11:
        r13 = false;
        goto L12
    }
}
