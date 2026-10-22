package com.obric.audio.enroll.ui.fragment;

import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.ui.VoicePrintEnrollActivity;
import com.obric.audio.enroll.vm.EnrollViewModel;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollingFragment$observe$2", f = "EnrollingFragment.kt", i = {0, 0}, l = {375}, m = "invokeSuspend", n = {"listener", "networkListener"}, s = {"L$0", "L$1"})
final class EnrollingFragment$observe$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ EnrollingFragment this$0;

    public EnrollingFragment$observe$2(EnrollingFragment r1, Continuation<? super EnrollingFragment$observe$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EnrollingFragment$observe$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r8) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 != 1) goto L6;
        Function1<? super Boolean, Unit> r3 = (Function1) this.L$1;
        z r4 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L10
        r4 = r4;
    L24:
        throw new KotlinNothingValueException();     // Catch: Throwable -> L10
    L10:
        th = th;
        Function1<? super Boolean, Unit> r5 = r3;
    L27:
        EnrollingFragment.b r6 = EnrollingFragment.b.a;     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter(r4, "listener");     // Catch: Throwable -> L29
        CopyOnWriteArraySet<Function1<Integer, Unit>> r7 = EnrollingFragment.b.b;     // Catch: Throwable -> L29
        r7.remove(r4);     // Catch: Throwable -> L29
        FLogger.a.i("EnrollingFragment", "removeListener size=" + r7.size());     // Catch: Throwable -> L29
        EnrollingFragment.c r9 = EnrollingFragment.c.a;     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter(r5, "listener");     // Catch: Throwable -> L29
        EnrollingFragment.c.b.remove(r5);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L32:
        return Unit.INSTANCE;
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r8);
        EnrollViewModel r10 = this.this$0.f;
        if (r10 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r10 = null;
    L16:
        if (r10.getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DORA_BT) goto L32;
        final EnrollingFragment r11 = this.this$0;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L29
        r4 = new z(r11);     // Catch: Throwable -> L29
        final AtomicBoolean r13 = new AtomicBoolean(false);     // Catch: Throwable -> L29
        final AtomicBoolean r14 = new AtomicBoolean(false);     // Catch: Throwable -> L29
        r5 = new a0(r13, r14, r11);     // Catch: Throwable -> L29
        EnrollingFragment.b.a.a(r4);     // Catch: Throwable -> L29
        EnrollingFragment.c.a.a(r11.requireContext().getApplicationContext(), r5);     // Catch: Throwable -> L29
        this.L$0 = r4;     // Catch: Throwable -> L26
        this.L$1 = r5;     // Catch: Throwable -> L26
        this.label = 1;     // Catch: Throwable -> L26
        if (DelayKt.awaitCancellation(this) != r1) goto L22;
        return r1;
    L22:
        r3 = r5;
        r4 = r4;
    L26:
        th = th;
        goto L27
    }
}
