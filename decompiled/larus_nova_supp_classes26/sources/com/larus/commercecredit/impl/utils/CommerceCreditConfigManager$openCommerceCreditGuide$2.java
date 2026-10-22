package com.larus.commercecredit.impl.utils;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.keva.Keva;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$openCommerceCreditGuide$2", f = "CommerceCreditConfigManager.kt", i = {}, l = {247, 262}, m = "invokeSuspend", n = {}, s = {})
final class CommerceCreditConfigManager$openCommerceCreditGuide$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<qz8.k, Unit> $openAction;
    final /* synthetic */ DowngradeSource $source;
    int label;

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$openCommerceCreditGuide$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$openCommerceCreditGuide$2$1", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ qz8.k $creditTip;
        final /* synthetic */ Function1<qz8.k, Unit> $openAction;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super qz8.k, Unit> r1, qz8.k r2, Continuation<? super AnonymousClass1> r3) {
            this.$openAction = r1;
            this.$creditTip = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$openAction, this.$creditTip, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$openAction.invoke(this.$creditTip);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommerceCreditConfigManager$openCommerceCreditGuide$2(DowngradeSource r1, Function1<? super qz8.k, Unit> r2, Continuation<? super CommerceCreditConfigManager$openCommerceCreditGuide$2> r3) {
        this.$source = r1;
        this.$openAction = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CommerceCreditConfigManager$openCommerceCreditGuide$2(this.$source, this.$openAction, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.commercecredit.impl.utils.e] */
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L52:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L17:
        qz8.k r10 = (qz8.k) r9;
        FLogger r2 = FLogger.a;
        StringBuilder r5 = new StringBuilder("openCreditTipFromRemote: isFirstVisit=");
        if (r10 == null) goto L20;
        Boolean r7 = Boxing.boxBoolean(r10.b());
    L21:
        r5.append(r7);
        r5.append(" title=");
        if (r10 == null) goto L26;
        qz8.e r8 = r10.a();
        if (r8 == null) goto L26;
        String r11 = r8.h();
    L27:
        r5.append(r11);
        r5.append(" desc=");
        if (r10 == null) goto L32;
        qz8.e r12 = r10.a();
        if (r12 == null) goto L32;
        String r13 = r12.d();
    L33:
        r5.append(r13);
        r2.i("CommerceCreditConfigManager", r5.toString());
        if (r10 != null) goto L36;
    L38:
        boolean r3 = false;
    L40:
        if (r3 == false) goto L44;
        com.larus.commercecredit.impl.model.c r14 = com.larus.commercecredit.impl.model.c.a;
        Keva r15 = com.larus.commercecredit.impl.model.c.c();
        if (r15 == null) goto L52;
        r15.storeBoolean("credit_tip_show_status", true);
        goto L52
    L44:
        if (r10 == null) goto L52;
        com.larus.commercecredit.impl.model.c r4 = com.larus.commercecredit.impl.model.c.a;
        Keva r6 = com.larus.commercecredit.impl.model.c.c();
        if (r6 == null) goto L48;
        r6.storeBoolean("credit_tip_show_status", true);
    L48:
        MainCoroutineDispatcher r16 = Dispatchers.getMain();
        AnonymousClass1 r17 = new AnonymousClass1(this.$openAction, r10, null);
        this.label = 2;
        if (BuildersKt.withContext(r16, r17, this) != r0) goto L52;
        return r0;
    L36:
        if (r10.b() == true) goto L38;
        r3 = true;
    L32:
        r13 = null;
    L26:
        r11 = null;
        goto L27
    L20:
        r7 = null;
        goto L21
    L10:
        ResultKt.throwOnFailure(r9);
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication().getApplicationContext()) == true) goto L14;
        FLogger.a.i("CommerceCreditConfigManager", "openCreditTipFromRemote: no network");
        return Unit.INSTANCE;
    L14:
        final long r18 = System.currentTimeMillis();
        com.larus.commercecredit.impl.model.c r19 = com.larus.commercecredit.impl.model.c.a;
        DowngradeSource r20 = this.$source;
        ?? r21 = new e(r18);
        this.label = 1;
        r9 = r19.f(r20, r21, this);
        if (r9 != r0) goto L17;
        return r0;
    }
}
