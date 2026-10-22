package com.larus.dora.impl.device_v2;

import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device_v2.DoraDeviceBindFragment$setupPage$1$1", f = "DoraDeviceBindFragment.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
final class DoraDeviceBindFragment$setupPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c59.c0 $pageInfo;
    int label;
    final /* synthetic */ DoraDeviceBindFragment this$0;

    public DoraDeviceBindFragment$setupPage$1$1(DoraDeviceBindFragment r1, c59.c0 r2, Continuation<? super DoraDeviceBindFragment$setupPage$1$1> r3) {
        this.this$0 = r1;
        this.$pageInfo = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraDeviceBindFragment$setupPage$1$1(this.this$0, this.$pageInfo, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.larus.dora.impl.device_v2.s] */
    /* JADX WARN: Type inference failed for: r9v10, types: [com.larus.dora.impl.device_v2.t] */
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
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        DoraDeviceBindFragment.a.C0058a r10 = (DoraDeviceBindFragment.a.C0058a) r9;
        final DoraDeviceBindFragment r2 = this.this$0;
        DoraDeviceBindFragment.c r3 = r2.g;
        if (r3 == 0) goto L58;
        TextView r4 = r3.e();
        String r5 = "";
        if (r10 == null) goto L20;
        c59.t r6 = r10.e();
        if (r6 == null) goto L20;
        String r7 = c59.p.b(r6);
        if (r7 == null) goto L20;
    L21:
        r4.setText(r7);
        TextView r8 = r3.b();
        if (r10 == null) goto L28;
        c59.t r11 = r10.c();
        if (r11 == null) goto L28;
        String r12 = c59.p.b(r11);
        if (r12 == null) goto L28;
    L29:
        r8.setText(r12);
        if (r10 == null) goto L37;
        c59.h r13 = r10.a();
        if (r13 == null) goto L37;
        c59.t r14 = r13.b();
        if (r14 == null) goto L37;
        String r15 = c59.p.b(r14);
        if (r15 == null) goto L37;
    L38:
        r3.h(r15);
        if (r10 == null) goto L41;
        final c59.h r16 = r10.b();
    L42:
        if (r16 == null) goto L49;
        c59.t r17 = r16.b();
        if (r17 == null) goto L49;
        String r18 = c59.p.b(r17);
        if (r18 == null) goto L49;
        r5 = r18;
    L49:
        r3.a(r5);
        r3.g(new s(r2));
        SimpleDraweeView r20 = r3.d();
        if (r10 == null) goto L52;
        c59.u r21 = r10.d();
    L53:
        c59.p.e(r20, r21, null, r2.o, 2);
        if (r16 != null) goto L56;
        e1.q(r3.f());
        r3.f().setEnabled(false);
        goto L58
    L56:
        e1.x(r3.f());
        r3.f().setEnabled(true);
        r3.i(new t(r2, r16));
        goto L58
    L52:
        r21 = null;
        goto L53
    L41:
        r16 = null;
    L37:
        r15 = "";
    L28:
        r12 = "";
    L20:
        r7 = "";
    L58:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        CoroutineDispatcher r22 = Dispatchers.getIO();
        DoraDeviceBindFragment$setupPage$1$1$bindDevicePageConfig$1 r23 = new DoraDeviceBindFragment$setupPage$1$1$bindDevicePageConfig$1(this.$pageInfo, null);
        this.label = 1;
        r9 = BuildersKt.withContext(r22, r23, this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
