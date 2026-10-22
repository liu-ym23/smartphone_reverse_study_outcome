package com.larus.commercecredit.impl.utils;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import qz8.g;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getAllCreditInfo$2", f = "CommerceCreditConfigManager.kt", i = {0, 2}, l = {175, 181, 192, 208}, m = "invokeSuspend", n = {"localCreditConfig", "localCreditConfig"}, s = {"L$0", "L$0"})
final class CommerceCreditConfigManager$getAllCreditInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<g, g, Boolean, Unit> $callback;
    final /* synthetic */ boolean $isSupportFromLocal;
    final /* synthetic */ boolean $needTasks;
    final /* synthetic */ String $newScene;
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getAllCreditInfo$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getAllCreditInfo$2$1", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<g, g, Boolean, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<g> $localCreditConfig;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function3<? super g, ? super g, ? super Boolean, Unit> r1, Ref.ObjectRef<g> r2, Continuation<? super AnonymousClass1> r3) {
            this.$callback = r1;
            this.$localCreditConfig = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$callback, this.$localCreditConfig, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L9;
            ResultKt.throwOnFailure(r4);
            Function3<g, g, Boolean, Unit> r5 = this.$callback;
            if (r5 == null) goto L10;
            r5.invoke(this.$localCreditConfig.element, null, Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        L10:
            return null;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getAllCreditInfo$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getAllCreditInfo$2$2", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<g, g, Boolean, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<g> $localCreditConfig;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function3<? super g, ? super g, ? super Boolean, Unit> r1, Ref.ObjectRef<g> r2, Continuation<? super AnonymousClass2> r3) {
            this.$callback = r1;
            this.$localCreditConfig = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$callback, this.$localCreditConfig, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L9;
            ResultKt.throwOnFailure(r7);
            Context r1 = AppHost.a.getApplication().getApplicationContext();
            s.j(s.a, r1, r1.getString(2131907052), null, false, 28);
            Function3<g, g, Boolean, Unit> r8 = this.$callback;
            if (r8 == null) goto L10;
            r8.invoke(this.$localCreditConfig.element, null, Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L10:
            return null;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getAllCreditInfo$2$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getAllCreditInfo$2$3", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<g, g, Boolean, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<g> $localCreditConfig;
        final /* synthetic */ g $remoteCreditConfig;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function3<? super g, ? super g, ? super Boolean, Unit> r1, Ref.ObjectRef<g> r2, g r3, Continuation<? super AnonymousClass3> r4) {
            this.$callback = r1;
            this.$localCreditConfig = r2;
            this.$remoteCreditConfig = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass3(this.$callback, this.$localCreditConfig, this.$remoteCreditConfig, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r4);
            Function3<g, g, Boolean, Unit> r5 = this.$callback;
            if (r5 == null) goto L7;
            r5.invoke(this.$localCreditConfig.element, this.$remoteCreditConfig, Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommerceCreditConfigManager$getAllCreditInfo$2(boolean r1, String r2, boolean r3, Function3<? super g, ? super g, ? super Boolean, Unit> r4, Continuation<? super CommerceCreditConfigManager$getAllCreditInfo$2> r5) {
        this.$isSupportFromLocal = r1;
        this.$newScene = r2;
        this.$needTasks = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CommerceCreditConfigManager$getAllCreditInfo$2(this.$isSupportFromLocal, this.$newScene, this.$needTasks, this.$callback, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v3, types: [com.larus.commercecredit.impl.utils.a] */
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
    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        ResultKt.throwOnFailure(r19);
    L57:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        Ref.ObjectRef r3 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r5 = r19;
    L41:
        g r6 = (g) r5;
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("getAllCreditInfoFromRemote: scene=");
        r8.append(this.$newScene);
        r8.append(" needTasks=");
        r8.append(this.$needTasks);
        r8.append(" isSupportFromLocal=");
        r8.append(this.$isSupportFromLocal);
        r8.append(" creditValue=");
        if (r6 == null) goto L46;
        qz8.f r4 = r6.a();
        if (r4 == null) goto L46;
        Long r9 = r4.f();
    L47:
        r8.append(r9);
        r8.append(" creditTasks=");
        if (r6 == null) goto L52;
        List<qz8.j> r10 = r6.c();
        if (r10 == null) goto L52;
        Integer r11 = Boxing.boxInt(r10.size());
    L53:
        r8.append(r11);
        r7.i("CommerceCreditConfigManager", r8.toString());
        MainCoroutineDispatcher r12 = Dispatchers.getMain();
        AnonymousClass3 r13 = new AnonymousClass3(this.$callback, r3, r6, null);
        this.L$0 = null;
        this.label = 4;
        if (BuildersKt.withContext(r12, r13, this) != r1) goto L57;
        return r1;
    L52:
        r11 = null;
    L46:
        r9 = null;
        goto L47
    L12:
        ResultKt.throwOnFailure(r19);
    L36:
        FLogger.a.i("CommerceCreditConfigManager", "getAllCreditInfoFromRemote: no network scene=" + this.$newScene + " needTasks=" + this.$needTasks + " isSupportFromLocal=" + this.$isSupportFromLocal);
        return Unit.INSTANCE;
    L13:
        r3 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r19);
    L32:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L38;
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass2 r15 = new AnonymousClass2(this.$callback, r3, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r14, r15, this) != r1) goto L36;
        return r1;
    L38:
        final long r16 = System.currentTimeMillis();
        com.larus.commercecredit.impl.model.c r17 = com.larus.commercecredit.impl.model.c.a;
        final boolean r18 = this.$needTasks;
        final String r110 = this.$newScene;
        final Ref.ObjectRef r111 = r3;
        ?? r112 = new a(r111, r110, r16, r18);
        this.L$0 = r3;
        this.label = 3;
        r5 = r17.e(r18, r112, this);
        if (r5 != r1) goto L41;
        return r1;
    L14:
        ResultKt.throwOnFailure(r19);
        r3 = new Ref.ObjectRef();
        if (this.$isSupportFromLocal == false) goto L32;
        com.larus.commercecredit.impl.model.c r113 = com.larus.commercecredit.impl.model.c.a;
        r3.element = com.larus.commercecredit.impl.model.c.a();
        FLogger r114 = FLogger.a;
        StringBuilder r115 = new StringBuilder("getAllCreditInfoFromLocal: scene=");
        r115.append(this.$newScene);
        r115.append(" needTasks=");
        r115.append(this.$needTasks);
        r115.append(" isSupportFromLocal=true creditValue=");
        g r116 = (g) r3.element;
        if (r116 == null) goto L21;
        qz8.f r117 = r116.a();
        if (r117 == null) goto L21;
        Long r118 = r117.f();
    L22:
        r115.append(r118);
        r115.append(" creditTasks=");
        g r119 = (g) r3.element;
        if (r119 == null) goto L27;
        List<qz8.j> r120 = r119.c();
        if (r120 == null) goto L27;
        Integer r121 = Boxing.boxInt(r120.size());
    L28:
        r115.append(r121);
        r114.i("CommerceCreditConfigManager", r115.toString());
        MainCoroutineDispatcher r122 = Dispatchers.getMain();
        AnonymousClass1 r123 = new AnonymousClass1(this.$callback, r3, null);
        this.L$0 = r3;
        this.label = 1;
        if (BuildersKt.withContext(r122, r123, this) != r1) goto L32;
        return r1;
    L27:
        r121 = null;
    L21:
        r118 = null;
        goto L22
    }
}
