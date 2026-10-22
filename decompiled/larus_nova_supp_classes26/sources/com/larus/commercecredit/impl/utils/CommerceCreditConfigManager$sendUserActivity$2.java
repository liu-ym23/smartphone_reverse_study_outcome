package com.larus.commercecredit.impl.utils;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import qz8.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$sendUserActivity$2", f = "CommerceCreditConfigManager.kt", i = {1}, l = {489, 499}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
public final class CommerceCreditConfigManager$sendUserActivity$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<q, Continuation<? super Unit>, Object> $callback;
    final /* synthetic */ String $scene;
    final /* synthetic */ DowngradeSource $source;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CommerceCreditConfigManager$sendUserActivity$2(String r1, DowngradeSource r2, Function2<? super q, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super CommerceCreditConfigManager$sendUserActivity$2> r4) {
        this.$scene = r1;
        this.$source = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CommerceCreditConfigManager$sendUserActivity$2(this.$scene, this.$source, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.commercecredit.impl.utils.f] */
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
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        q r2 = (q) this.L$0;
        ResultKt.throwOnFailure(r10);
    L23:
        q r11 = r2;
    L24:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("sendUserActivity success scene=");
        r4.append(this.$scene);
        r4.append(" activityTime=");
        Long r5 = null;
        if (r11 == null) goto L27;
        Long r6 = Boxing.boxLong(r11.a());
    L28:
        r4.append(r6);
        r4.append(" totalCreditNum=");
        if (r11 == null) goto L31;
        r5 = Boxing.boxLong(r11.b());
    L31:
        r4.append(r5);
        r3.i("CommerceCreditConfigManager", r4.toString());
        if (r11 == null) goto L35;
        com.larus.commercecredit.impl.model.c r7 = com.larus.commercecredit.impl.model.c.a;
        com.larus.commercecredit.impl.model.c.j(r11.b());
    L35:
        return Unit.INSTANCE;
    L27:
        r6 = null;
        goto L28
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L17:
        r11 = (q) r10;
        Function2<q, Continuation<? super Unit>, Object> r8 = this.$callback;
        if (r8 == null) goto L24;
        this.L$0 = r11;
        this.label = 2;
        if (r8.invoke(r11, this) != r0) goto L22;
        return r0;
    L22:
        r2 = r11;
        goto L23
    L10:
        ResultKt.throwOnFailure(r10);
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L14;
        FLogger.a.i("CommerceCreditConfigManager", "sendUserActivity: no network scene=" + this.$scene);
        return Unit.INSTANCE;
    L14:
        FLogger.a.i("CommerceCreditConfigManager", "sendUserActivity: scene=" + this.$scene + " source=" + this.$source);
        final long r9 = System.currentTimeMillis();
        com.larus.commercecredit.impl.model.c r12 = com.larus.commercecredit.impl.model.c.a;
        DowngradeSource r13 = this.$source;
        final String r14 = this.$scene;
        ?? r15 = new f(r14, r9);
        this.label = 1;
        r10 = r12.i(r13, r15, this);
        if (r10 != r0) goto L17;
        return r0;
    }
}
