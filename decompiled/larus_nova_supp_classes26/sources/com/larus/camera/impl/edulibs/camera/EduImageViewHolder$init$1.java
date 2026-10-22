package com.larus.camera.impl.edulibs.camera;

import com.larus.camera.impl.edulibs.camera.internal.EduQuestionSearchLogic;
import com.larus.camera.impl.edulibs.camera.internal.e;
import com.larus.camera.impl.edulibs.camera.internal.view.EduClipRectAnimateView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import nx8.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.edulibs.camera.EduImageViewHolder$init$1", f = "EduImageViewHolder.kt", i = {}, l = {501}, m = "invokeSuspend", n = {}, s = {})
final class EduImageViewHolder$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ c this$0;

    /* JADX INFO: renamed from: com.larus.camera.impl.edulibs.camera.EduImageViewHolder$init$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/camera/impl/edulibs/camera/internal/ServerRequestState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.edulibs.camera.EduImageViewHolder$init$1$1", f = "EduImageViewHolder.kt", i = {}, l = {508}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<e, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ c this$0;

        public AnonymousClass1(c r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(e r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((e) r1, (Continuation) r2);
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
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L25:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            e r7 = (e) this.L$0;
            boolean r3 = r7 instanceof e.a;
            this.this$0.f.setEnabled(r3);
            if (r3 == true) goto L11;
            c r8 = this.this$0;
            if (r8.d.a.c == false) goto L23;
            EduClipRectAnimateView r9 = r8.g;
            if (r9 == null) goto L23;
            r9.setVisibility(0);
        L23:
            this.this$0.f.p(0.0f, 0.0f);
            goto L25
        L11:
            if (Intrinsics.areEqual(this.this$0.d.a, i.e.d) == true) goto L13;
        L15:
            c r2 = this.this$0;
            kx8.c r10 = ((e.a) r7).a;
            this.label = 1;
            if (c.r(r2, r10, this) != r0) goto L25;
            return r0;
        L13:
            if (this.this$0.k() == true) goto L15;
            EduQuestionSearchLogic r4 = this.this$0.d;
            i.f r5 = i.f.d;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r4.a = r5;
            goto L15
        }
    }

    public EduImageViewHolder$init$1(c r1, Continuation<? super EduImageViewHolder$init$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EduImageViewHolder$init$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        c r7 = this.this$0;
        StateFlowImpl r2 = r7.d.g;
        AnonymousClass1 r3 = new AnonymousClass1(r7, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r2, r3, this) != r0) goto L12;
        return r0;
    }
}
