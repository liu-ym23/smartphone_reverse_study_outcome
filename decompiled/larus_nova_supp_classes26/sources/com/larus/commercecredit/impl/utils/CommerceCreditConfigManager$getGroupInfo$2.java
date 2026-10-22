package com.larus.commercecredit.impl.utils;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInfo$2", f = "CommerceCreditConfigManager.kt", i = {0, 2}, l = {289, 296, 307, 322}, m = "invokeSuspend", n = {"localCampaignInfo", "localCampaignInfo"}, s = {"L$0", "L$0"})
public final class CommerceCreditConfigManager$getGroupInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<qz8.d, qz8.d, Boolean, Unit> $callback;
    final /* synthetic */ String $campaignKey;
    final /* synthetic */ boolean $isSupportFromLocal;
    final /* synthetic */ String $scene;
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInfo$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInfo$2$1", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<qz8.d, qz8.d, Boolean, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<qz8.d> $localCampaignInfo;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function3<? super qz8.d, ? super qz8.d, ? super Boolean, Unit> r1, Ref.ObjectRef<qz8.d> r2, Continuation<? super AnonymousClass1> r3) {
            this.$callback = r1;
            this.$localCampaignInfo = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$callback, this.$localCampaignInfo, r4);
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
            Function3<qz8.d, qz8.d, Boolean, Unit> r5 = this.$callback;
            if (r5 == null) goto L10;
            r5.invoke(this.$localCampaignInfo.element, null, Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        L10:
            return null;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInfo$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInfo$2$2", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<qz8.d, qz8.d, Boolean, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<qz8.d> $localCampaignInfo;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function3<? super qz8.d, ? super qz8.d, ? super Boolean, Unit> r1, Ref.ObjectRef<qz8.d> r2, Continuation<? super AnonymousClass2> r3) {
            this.$callback = r1;
            this.$localCampaignInfo = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$callback, this.$localCampaignInfo, r4);
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
            Function3<qz8.d, qz8.d, Boolean, Unit> r8 = this.$callback;
            if (r8 == null) goto L10;
            r8.invoke(this.$localCampaignInfo.element, null, Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L10:
            return null;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInfo$2$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInfo$2$3", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<qz8.d, qz8.d, Boolean, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<qz8.d> $localCampaignInfo;
        final /* synthetic */ qz8.d $remoteCampaignInfo;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function3<? super qz8.d, ? super qz8.d, ? super Boolean, Unit> r1, Ref.ObjectRef<qz8.d> r2, qz8.d r3, Continuation<? super AnonymousClass3> r4) {
            this.$callback = r1;
            this.$localCampaignInfo = r2;
            this.$remoteCampaignInfo = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass3(this.$callback, this.$localCampaignInfo, this.$remoteCampaignInfo, r5);
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
            Function3<qz8.d, qz8.d, Boolean, Unit> r5 = this.$callback;
            if (r5 == null) goto L7;
            r5.invoke(this.$localCampaignInfo.element, this.$remoteCampaignInfo, Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommerceCreditConfigManager$getGroupInfo$2(boolean r1, String r2, String r3, Function3<? super qz8.d, ? super qz8.d, ? super Boolean, Unit> r4, Continuation<? super CommerceCreditConfigManager$getGroupInfo$2> r5) {
        this.$isSupportFromLocal = r1;
        this.$campaignKey = r2;
        this.$scene = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CommerceCreditConfigManager$getGroupInfo$2(this.$isSupportFromLocal, this.$campaignKey, this.$scene, this.$callback, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.larus.commercecredit.impl.utils.b] */
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
    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        ResultKt.throwOnFailure(r23);
    L77:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        Ref.ObjectRef r3 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r23);
        Object r5 = r23;
    L53:
        qz8.d r6 = (qz8.d) r5;
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("getGroupInfoFromRemote: scene=");
        r8.append(this.$scene);
        r8.append(" campaignKey=");
        r8.append(this.$campaignKey);
        r8.append(" title=");
        if (r6 == null) goto L58;
        qz8.b r9 = r6.a();
        if (r9 == null) goto L58;
        String r10 = r9.h();
    L59:
        r8.append(r10);
        r8.append(' ');
        if (r6 == null) goto L64;
        qz8.b r4 = r6.a();
        if (r4 == null) goto L64;
        String r11 = r4.i();
    L65:
        r8.append(r11);
        r8.append(" desc=");
        if (r6 == null) goto L70;
        qz8.b r12 = r6.a();
        if (r12 == null) goto L70;
        String r13 = r12.e();
    L71:
        r8.append(r13);
        r7.i("CommerceCreditConfigManager", r8.toString());
        if (r6 == null) goto L77;
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass3 r15 = new AnonymousClass3(this.$callback, r3, r6, null);
        this.L$0 = null;
        this.label = 4;
        if (BuildersKt.withContext(r14, r15, this) != r1) goto L77;
        return r1;
    L70:
        r13 = null;
    L64:
        r11 = null;
    L58:
        r10 = null;
        goto L59
    L12:
        ResultKt.throwOnFailure(r23);
    L48:
        FLogger.a.i("CommerceCreditConfigManager", "getGroupInfoFromRemote: no network scene=" + this.$scene + " campaignKey=" + this.$campaignKey);
        return Unit.INSTANCE;
    L13:
        r3 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r23);
    L44:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L50;
        MainCoroutineDispatcher r16 = Dispatchers.getMain();
        AnonymousClass2 r17 = new AnonymousClass2(this.$callback, r3, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r16, r17, this) != r1) goto L48;
        return r1;
    L50:
        final long r19 = System.currentTimeMillis();
        com.larus.commercecredit.impl.model.c r18 = com.larus.commercecredit.impl.model.c.a;
        final String r20 = this.$campaignKey;
        final String r21 = this.$scene;
        final Ref.ObjectRef r110 = r3;
        ?? r22 = new b(r110, r21, r19, r20);
        this.L$0 = r3;
        this.label = 3;
        r5 = r18.g(r20, r22, this);
        if (r5 != r1) goto L53;
        return r1;
    L14:
        ResultKt.throwOnFailure(r23);
        r3 = new Ref.ObjectRef();
        if (this.$isSupportFromLocal == false) goto L44;
        com.larus.commercecredit.impl.model.c r111 = com.larus.commercecredit.impl.model.c.a;
        String r112 = this.$campaignKey;
        Intrinsics.checkNotNullParameter(r112, "campaignKey");
        FLogger r113 = FLogger.a;
        r113.i("CommerceCreditRepo", "getGroupInfoFromLocal start, campaignKey: " + r112);
        Gson r114 = com.larus.commercecredit.impl.model.c.b();
        Keva r24 = com.larus.commercecredit.impl.model.c.c();
        if (r24 == null) goto L19;
        String r25 = r24.getString("group_info_" + r112, "");
    L20:
        qz8.d r26 = (qz8.d) GsonProtectorUtils.fromJson(r114, r25, qz8.d.class);
        r113.i("CommerceCreditRepo", "getGroupInfoFromLocal end");
        r3.element = r26;
        StringBuilder r27 = new StringBuilder("getGroupInfoFromLocal: scene=");
        r27.append(this.$scene);
        r27.append(" campaignKey=");
        r27.append(this.$campaignKey);
        r27.append(" isSupportFromLocal=true title=");
        qz8.d r28 = (qz8.d) r3.element;
        if (r28 == null) goto L25;
        qz8.b r29 = r28.a();
        if (r29 == null) goto L25;
        String r30 = r29.h();
    L26:
        r27.append(r30);
        r27.append(' ');
        qz8.d r31 = (qz8.d) r3.element;
        if (r31 == null) goto L31;
        qz8.b r32 = r31.a();
        if (r32 == null) goto L31;
        String r33 = r32.i();
    L32:
        r27.append(r33);
        r27.append(" desc=");
        qz8.d r34 = (qz8.d) r3.element;
        if (r34 == null) goto L37;
        qz8.b r35 = r34.a();
        if (r35 == null) goto L37;
        String r36 = r35.e();
    L38:
        r27.append(r36);
        r113.i("CommerceCreditConfigManager", r27.toString());
        if (r3.element == null) goto L44;
        MainCoroutineDispatcher r37 = Dispatchers.getMain();
        AnonymousClass1 r38 = new AnonymousClass1(this.$callback, r3, null);
        this.L$0 = r3;
        this.label = 1;
        if (BuildersKt.withContext(r37, r38, this) != r1) goto L44;
        return r1;
    L37:
        r36 = null;
    L31:
        r33 = null;
    L25:
        r30 = null;
        goto L26
    L19:
        r25 = null;
        goto L20
    }
}
