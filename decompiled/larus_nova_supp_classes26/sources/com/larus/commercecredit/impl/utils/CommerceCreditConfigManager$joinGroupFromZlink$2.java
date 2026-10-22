package com.larus.commercecredit.impl.utils;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.minor.api.IMinorService;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineScope;
import qz8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$joinGroupFromZlink$2", f = "CommerceCreditConfigManager.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {})
public final class CommerceCreditConfigManager$joinGroupFromZlink$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $scene;
    final /* synthetic */ String $text;
    Object L$0;
    Object L$1;
    int label;

    public CommerceCreditConfigManager$joinGroupFromZlink$2(String r1, String r2, Continuation<? super CommerceCreditConfigManager$joinGroupFromZlink$2> r3) {
        this.$text = r1;
        this.$scene = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CommerceCreditConfigManager$joinGroupFromZlink$2(this.$text, this.$scene, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.larus.commercecredit.impl.utils.d] */
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
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r2 = (String) this.L$1;
        m r3 = (m) this.L$0;
        ResultKt.throwOnFailure(r14);
    L95:
        FLogger.a.i("CommerceCreditConfigManager", "joinGroupFromZlink final from server scene=" + r2 + " res=" + ((String) r14));
        CommerceCreditConfigManager.b.set(false);
    L98:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        String r4 = this.$text;
        final String r8 = "";
        if (r4 == null) goto L27;
        String r9 = this.$scene;
        CommerceCreditConfigManager r10 = CommerceCreditConfigManager.a;
        Regex r11 = new Regex("(?<=invite_code=)[^&\\s]+");
        Regex r12 = new Regex("(?<=campaign_key=)[^&\\s]+");
        MatchResult r13 = Regex.find$default(r11, r4, 0, 2, null);
        if (r13 == null) goto L14;
        String r16 = r13.getValue();
        if (r16 == null) goto L14;
    L15:
        MatchResult r5 = Regex.find$default(r12, r4, 0, 2, null);
        if (r5 == null) goto L19;
        String r6 = r5.getValue();
        if (r6 == null) goto L19;
    L20:
        m r17 = new m(r16, r6);
        FLogger.a.i("CommerceCreditConfigManager", "joinGroupFromZlink parseInviteCodeAndCampaignKey scene=" + r9 + " inviteCode=" + r17.b() + " campaignKey=" + r17.a());
        if (o0.d(r17.b()) == true) goto L23;
    L25:
        r15.element = r17;
        goto L27
    L23:
        if (o0.d(r17.a()) == false) goto L25;
        i.b(r17);
    L19:
        r6 = "";
    L14:
        r16 = "";
    L27:
        if (AccountService.a.isLogin().booleanValue() == true) goto L31;
        FLogger.a.i("CommerceCreditConfigManager", "joinGroupFromZlink: not login scene=" + this.$scene);
        return Unit.INSTANCE;
    L31:
        if (IMinorService.a.a() == false) goto L35;
        FLogger.a.i("CommerceCreditConfigManager", "joinGroupFromZlink: minor mode scene=" + this.$scene);
        return Unit.INSTANCE;
    L35:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L38;
        FLogger.a.i("CommerceCreditConfigManager", "joinGroupFromZlink: no network with scene=" + this.$scene);
        return Unit.INSTANCE;
    L38:
        m r7 = (m) r15.element;
        if (r7 == null) goto L41;
        String r18 = r7.b();
    L42:
        if (r18 != null) goto L44;
    L47:
        boolean r19 = true;
    L48:
        if (r19 == true) goto L60;
        m r20 = (m) r15.element;
        if (r20 == null) goto L52;
        String r21 = r20.a();
    L53:
        if (r21 != null) goto L55;
    L58:
        boolean r22 = true;
    L59:
        if (r22 == true) goto L60;
    L68:
        m r110 = (m) r15.element;
        if (r110 == null) goto L98;
        final String r23 = this.$scene;
        String r24 = r110.b();
        if (r24 != null) goto L73;
        r24 = "";
    L73:
        String r25 = r110.a();
        if (r25 == null) goto L78;
        r8 = r25;
    L78:
        if (r24.length() != 0) goto L80;
        boolean r26 = true;
    L81:
        if (r26 == false) goto L83;
    L96:
        FLogger.a.i("CommerceCreditConfigManager", "joinGroupFromZlink scene=" + r23 + " inviteCode=" + r24 + " campaignKey=" + r8);
        goto L98
    L83:
        if (r8.length() != 0) goto L85;
        boolean r27 = true;
    L86:
        if (r27 == true) goto L96;
        if (CommerceCreditConfigManager.b.compareAndSet(false, true) == true) goto L91;
        FLogger.a.i("CommerceCreditConfigManager", "joinGroupFromZlink: request already in progress, skip duplicate scene=" + r23);
        goto L98
    L91:
        final long r28 = System.currentTimeMillis();
        com.larus.commercecredit.impl.model.c r29 = com.larus.commercecredit.impl.model.c.a;
        ?? r111 = new d(r23, r28, r8);
        this.L$0 = r110;
        this.L$1 = r23;
        this.label = 1;
        r14 = r29.d(r24, r8, r111, this);
        if (r14 != r0) goto L94;
        return r0;
    L94:
        r2 = r23;
        goto L95
    L85:
        r27 = false;
        goto L86
    L80:
        r26 = false;
        goto L81
    L55:
        if (r21.length() == 0) goto L58;
        r22 = false;
        goto L59
    L52:
        r21 = null;
    L60:
        Keva r30 = i.a();
        if (r30 == null) goto L63;
        String r31 = r30.getString("zlink_invite_info", "");
    L64:
        m r32 = (m) GsonProtectorUtils.fromJson((Gson) i.a.getValue(), r31, m.class);
        if (r32 != null) goto L67;
        r32 = new m(null, null);
    L67:
        r15.element = r32;
        goto L68
    L63:
        r31 = null;
        goto L64
    L44:
        if (r18.length() == 0) goto L47;
        r19 = false;
        goto L48
    L41:
        r18 = null;
        goto L42
    }
}
