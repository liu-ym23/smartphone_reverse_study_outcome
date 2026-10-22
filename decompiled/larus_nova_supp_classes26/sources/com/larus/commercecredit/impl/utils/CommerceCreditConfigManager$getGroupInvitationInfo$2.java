package com.larus.commercecredit.impl.utils;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import qz8.l;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInvitationInfo$2", f = "CommerceCreditConfigManager.kt", i = {}, l = {339, 348, 358}, m = "invokeSuspend", n = {}, s = {})
final class CommerceCreditConfigManager$getGroupInvitationInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $campaignKey;
    final /* synthetic */ Function1<l, Unit> $inviteActionCallback;
    final /* synthetic */ String $scene;
    int label;

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInvitationInfo$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInvitationInfo$2$1", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r7);
            Context r1 = AppHost.a.getApplication().getApplicationContext();
            s.j(s.a, r1, r1.getString(2131901294), null, false, 28);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInvitationInfo$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInvitationInfo$2$2", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ l $groupInvitationInfo;
        final /* synthetic */ Function1<l, Unit> $inviteActionCallback;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super l, Unit> r1, l r2, Continuation<? super AnonymousClass2> r3) {
            this.$inviteActionCallback = r1;
            this.$groupInvitationInfo = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$inviteActionCallback, this.$groupInvitationInfo, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L25;
            ResultKt.throwOnFailure(r7);
            this.$inviteActionCallback.invoke(this.$groupInvitationInfo);
            l r8 = this.$groupInvitationInfo;
            if (r8 == null) goto L21;
            String r9 = r8.c();
            boolean r0 = true;
            if (r9 != null) goto L9;
        L12:
            boolean r10 = true;
        L13:
            if (r10 == false) goto L23;
            String r11 = this.$groupInvitationInfo.d();
            if (r11 != null) goto L17;
        L20:
            if (r0 == false) goto L23;
        L17:
            if (r11.length() == 0) goto L20;
            r0 = false;
        L23:
            return Unit.INSTANCE;
        L9:
            if (r9.length() == 0) goto L12;
            r10 = false;
        L21:
            Context r1 = AppHost.a.getApplication().getApplicationContext();
            s.j(s.a, r1, r1.getString(2131901293), null, false, 28);
            goto L23
        L25:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommerceCreditConfigManager$getGroupInvitationInfo$2(String r1, String r2, Function1<? super l, Unit> r3, Continuation<? super CommerceCreditConfigManager$getGroupInvitationInfo$2> r4) {
        this.$scene = r1;
        this.$campaignKey = r2;
        this.$inviteActionCallback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CommerceCreditConfigManager$getGroupInvitationInfo$2(this.$scene, this.$campaignKey, this.$inviteActionCallback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.commercecredit.impl.utils.c] */
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
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r12);
    L30:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r12);
    L22:
        l r13 = (l) r12;
        FLogger r2 = FLogger.a;
        StringBuilder r5 = new StringBuilder("getGroupInvitationInfo: scene=");
        r5.append(this.$scene);
        r5.append(" campaignKey=");
        r5.append(this.$campaignKey);
        r5.append(" shareText=");
        if (r13 == null) goto L25;
        String r3 = r13.c();
    L26:
        r5.append(r3);
        r2.i("CommerceCreditConfigManager", r5.toString());
        MainCoroutineDispatcher r4 = Dispatchers.getMain();
        AnonymousClass2 r6 = new AnonymousClass2(this.$inviteActionCallback, r13, null);
        this.label = 3;
        if (BuildersKt.withContext(r4, r6, this) != r0) goto L30;
        return r0;
    L25:
        r3 = null;
        goto L26
    L11:
        ResultKt.throwOnFailure(r12);
    L17:
        FLogger.a.i("CommerceCreditConfigManager", "getGroupInfoFromRemote: no network scene=" + this.$scene + " campaignKey=" + this.$campaignKey);
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r12);
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L19;
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass1 r7 = new AnonymousClass1(null);
        this.label = 1;
        if (BuildersKt.withContext(r14, r7, this) != r0) goto L17;
        return r0;
    L19:
        final long r8 = System.currentTimeMillis();
        com.larus.commercecredit.impl.model.c r15 = com.larus.commercecredit.impl.model.c.a;
        final String r9 = this.$campaignKey;
        final String r10 = this.$scene;
        ?? r11 = new c(r10, r8, r9);
        this.label = 2;
        r12 = r15.h(r9, r11, this);
        if (r12 != r0) goto L22;
        return r0;
    }
}
