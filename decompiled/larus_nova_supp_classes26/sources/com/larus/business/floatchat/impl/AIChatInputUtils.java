package com.larus.business.floatchat.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.ability.FloatChatWindowEventType;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.component.cvs.b0;
import com.larus.bmhome.chat.g4;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.floatchat.IFloatChatService;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.business.floatchat.api.AIChatInputConfig;
import com.larus.chat.ChatTitleBarIcon;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.im.service.r;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.receiver.Container;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import dw8.i;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.j;
import va8.f;
import va8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class AIChatInputUtils {
    public static final AIChatInputUtils a = null;

    public static final class a implements qy8.c {
        public final /* synthetic */ Fragment a;

        @Override // qy8.c
        public final boolean a() {
            return true;
        }

        @Override // qy8.c
        public final void b() {
        }

        public a(Fragment r1) {
            this.a = r1;
        }

        @Override // qy8.c
        public final void c(Fragment r10) {
            Intrinsics.checkNotNullParameter(r10, "chatFragment");
            k r11 = this.a.WF().getAbility(k.class);
            if (r11 == null) goto L6;
            r11.hn(new f(FloatChatWindowEventType.BackPress, null, null, null, null, false, 62));
            return;
        }
    }

    public static final class b implements g4 {
        public final /* synthetic */ boolean a;

        public final void a() {
        }

        public final void b() {
        }

        public final boolean c() {
            return false;
        }

        public final boolean d() {
            return true;
        }

        public final void e(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
        }

        public final CharSequence f() {
            return null;
        }

        public final CharSequence g() {
            return null;
        }

        public final boolean h() {
            return false;
        }

        public final boolean i() {
            return this.a;
        }

        public b(boolean r1) {
            this.a = r1;
        }

        public final boolean j(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            return false;
        }
    }

    public static final class c implements Function1<fp8.b, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ Container c;

        public c(String r1, Bundle r2, Container r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object invoke(Object r5) {
            fp8.b r6 = (t1a.c) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            fp8.b r7 = fp8.b.a(r6, this.a, this.b.getInt("bottom_tab_height", 0), 1);
            t1a.e r0 = s1a.d.a(this.c).p(Reflection.getOrCreateKotlinClass(fp8.b.class));
            if (r0 == null) goto L5;
            r0.a(new e(r7));
        L9:
            return Unit.INSTANCE;
        L5:
            x1a.b r8 = x1a.a.c;
            if (r8 == null) goto L9;
            r8.log(5, "ComponentArch", "updateData ignored: context destroyed for " + Reflection.getOrCreateKotlinClass(fp8.b.class).getQualifiedName());
            goto L9
        }
    }

    public static final class d implements Function1<rp8.a, rp8.a> {
        public final /* synthetic */ t1a.c a;

        public d(rp8.a r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            Intrinsics.checkNotNullParameter((t1a.c) r2, "it");
            return this.a;
        }
    }

    public static final class e implements Function1<fp8.b, fp8.b> {
        public final /* synthetic */ t1a.c a;

        public e(fp8.b r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            Intrinsics.checkNotNullParameter((t1a.c) r2, "it");
            return this.a;
        }
    }

    static {
        a = new AIChatInputUtils();
    }

    public AIChatInputUtils() {
    }

    public final Object d(Continuation<? super i> r9) {
        if ((r9 instanceof AIChatInputUtils$getMainConversationInfo$1) == false) goto L7;
        AIChatInputUtils$getMainConversationInfo$1 r0 = (AIChatInputUtils$getMainConversationInfo$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L46:
        String r11 = (String) r10;
        if (r11 != null) goto L49;
        r11 = "";
    L49:
        i r6 = new i(r5, r11);
        if (r6.b.length() <= 0) goto L52;
        r4 = true;
    L52:
        if (r4 == true) goto L54;
        return null;
    L54:
        return r6;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r10);
    L29:
        wc9.e r12 = (wc9.e) r10;
    L30:
        if (r12 == null) goto L55;
        String r7 = r12.a;
        if (r7 != null) goto L34;
        return null;
    L34:
        if (r7.length() <= 0) goto L36;
        boolean r8 = true;
    L37:
        if (r8 == true) goto L40;
        r7 = null;
    L40:
        if (r7 == null) goto L58;
        LocalSubConvHelper r13 = LocalSubConvHelper.a;
        r0.L$0 = r7;
        r0.label = 3;
        r10 = r13.f(r12, r0);
        if (r10 != r2) goto L45;
        return r2;
    L45:
        r5 = r7;
        goto L46
    L58:
        return null;
    L36:
        r8 = false;
        goto L37
    L55:
        return null;
    L17:
        ResultKt.throwOnFailure(r10);
    L23:
        r12 = (wc9.e) r10;
        goto L30
    L18:
        ResultKt.throwOnFailure(r10);
        if (com.larus.platform.exp.o.a() == false) goto L24;
        LocalSubConvHelper r14 = LocalSubConvHelper.a;
        String r15 = AccountService.a.getSecUserId();
        r0.label = 1;
        r10 = r14.c(r15, null, r0);
        if (r10 != r2) goto L23;
        return r2;
    L24:
        r0.label = 2;
        r10 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r10 != null) goto L27;
        r10 = RepoDispatcherDelegate.b.f().f(r0);
    L27:
        if (r10 != r2) goto L29;
        return r2;
    L7:
        r0 = new AIChatInputUtils$getMainConversationInfo$1(this, r9);
        goto L8
    }

    public final Object c(Context r26, String r27, Continuation<? super i> r28) {
        if ((r28 instanceof AIChatInputUtils$createNewConversationInfo$1) == false) goto L7;
        AIChatInputUtils$createNewConversationInfo$1 r2 = (AIChatInputUtils$createNewConversationInfo$1) r28;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = false;
        String r8 = "";
        if (r5 == 0) goto L23;
        if (r5 == 1) goto L22;
        if (r5 == 2) goto L21;
        if (r5 == 3) goto L19;
        if (r5 == 4) goto L18;
        if (r5 != 5) goto L17;
        BotModel r7 = (BotModel) r2.L$1;
        String r9 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L86:
        wc9.e r10 = (wc9.e) r1;
        if (r10 == null) goto L105;
        String r11 = r10.a;
        if (r11 == null) goto L105;
        if (r11.length() <= 0) goto L93;
        r6 = true;
    L93:
        if (r6 == true) goto L96;
        r11 = null;
    L96:
        if (r11 == null) goto L105;
        BotInfoCache.INSTANCE.put(r11, r7);
        LocalSubConvHelper r12 = LocalSubConvHelper.a;
        BotOnBoarding r13 = r7.getOnBoarding();
        if (r13 == null) goto L102;
        List r14 = r13.getMessageList();
        if (r14 == null) goto L102;
    L103:
        LocalSubConvHelper.j(r11, r14, true);
        return new i(r11, r9);
    L102:
        r14 = CollectionsKt.emptyList();
    L105:
        return null;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        String r15 = (String) r2.L$2;
        String r16 = (String) r2.L$1;
        Context r17 = (Context) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L58:
        BotModel r18 = (BotModel) r1;
        if (r18 != null) goto L62;
        FLogger.a.i("AIChatInputUtils", "createNewConversationInfo, getBotModel return null");
        return null;
    L62:
        if (r16 != null) goto L64;
    L67:
        boolean r19 = true;
    L68:
        if (r19 == false) goto L70;
        String r20 = UUID.randomUUID().toString();
    L71:
        Intrinsics.checkNotNull(r20);
        Integer r110 = Boxing.boxInt(1);
        r2.L$0 = r15;
        r2.L$1 = r18;
        r2.L$2 = null;
        r2.label = 5;
        j r21 = new j(IntrinsicsKt.intercepted(r2), 1);
        r21.C();
        if (AccountService.a.isEnterpriseAccount() == false) goto L74;
        int r111 = 2131908160;
    L75:
        if (r17 == null) goto L80;
        String r112 = r17.getString(r111);
        if (r112 == null) goto L80;
        r8 = r112;
    L80:
        r.a.a(com.larus.im.d.d(), r18, 3, r110, MapsKt.mapOf(new Pair[]{TuplesKt.to("attach_local_msg", "true"), TuplesKt.to("conv_name", r8), TuplesKt.to("reuse_local_conversation", "true"), TuplesKt.to("custom_suffix", r20)}), null, new com.larus.business.floatchat.impl.b(r21), 16);
        Object r22 = r21.B();
        if (r22 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L83;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L83:
        if (r22 != r4) goto L85;
        return r4;
    L85:
        r7 = r18;
        r9 = r15;
        r1 = r22;
        goto L86
    L74:
        r111 = 2131908104;
        goto L75
    L70:
        r20 = UUID.randomUUID() + '_' + r16;
        goto L71
    L64:
        if (r16.length() == 0) goto L67;
        r19 = false;
        goto L68
    L19:
        String r23 = (String) r2.L$1;
        Context r113 = (Context) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L20:
        r17 = r113;
        r16 = r23;
        String r24 = (String) CollectionsKt.firstOrNull((List) r1);
        if (r24 != null) goto L46;
        r24 = "";
    L46:
        if (r24.length() != 0) goto L48;
        boolean r25 = true;
    L49:
        if (r25 == false) goto L52;
        FLogger.a.i("AIChatInputUtils", "createNewConversationInfo, botId is empty");
        return null;
    L52:
        r2.L$0 = r17;
        r2.L$1 = r16;
        r2.L$2 = r24;
        r2.label = 4;
        j r29 = new j(IntrinsicsKt.intercepted(r2), 1);
        r29.C();
        com.larus.im.service.o.a.a(com.larus.im.d.a(), r24, false, "sub", new com.larus.business.floatchat.impl.c(r29), 8);
        Object r30 = r29.B();
        if (r30 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L55;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L55:
        if (r30 != r4) goto L57;
        return r4;
    L57:
        r15 = r24;
        r1 = r30;
        goto L58
    L48:
        r25 = false;
        goto L49
    L21:
        r23 = (String) r2.L$1;
        r113 = (Context) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L35:
        wc9.e r31 = (wc9.e) r1;
        if (r31 != null) goto L39;
        FLogger.a.i("AIChatInputUtils", "createNewConversationInfo, mainBotConversationInfo is null");
        return null;
    L39:
        String r32 = r31.a;
        r2.L$0 = r113;
        r2.L$1 = r23;
        r2.label = 3;
        r1 = ic8.n.b(r32, r2);
        if (r1 != r4) goto L20;
        return r4;
    L22:
        ResultKt.throwOnFailure(r1);
    L28:
        return r1;
    L23:
        ResultKt.throwOnFailure(r1);
        if (com.larus.platform.exp.o.a() == false) goto L29;
        r2.label = 1;
        r1 = d(r2);
        if (r1 != r4) goto L28;
        return r4;
    L29:
        r2.L$0 = r26;
        r23 = r27;
        r2.L$1 = r23;
        r2.label = 2;
        Object r114 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r114 != null) goto L32;
        r114 = RepoDispatcherDelegate.b.f().f(r2);
    L32:
        if (r114 != r4) goto L34;
        return r4;
    L34:
        Object r210 = r114;
        r113 = r26;
        r1 = r210;
    L7:
        r2 = new AIChatInputUtils$createNewConversationInfo$1(this, r28);
        goto L8
    }

    public static final Fragment e(String r19, final Bundle r20, boolean r21, final b0 r22, final AIChatInputConfig r23) {
        IFloatChatService r0 = (IFloatChatService) ServiceManager.get().getService(IFloatChatService.class);
        Boolean r7 = null;
        if (r0 != null) goto L6;
        FLogger.a.i("AIChatInputUtils", "integrateFloatChatFragment, floatChatService is null");
        return null;
    L6:
        if (r19 != null) goto L8;
        final String r2 = r20.getString("key_action_bar_scene", null);
    L9:
        xe8.a r1 = r0.a(r20, r21, ContainerFilter.AI_FLOAT_CHAT, 2131562730, new com.larus.business.floatchat.impl.a(r22, r23, r2, r20));
        boolean r3 = z2.a.r1();
        if ((r1 instanceof xe8.a) == false) goto L12;
        xe8.a r4 = r1;
    L13:
        if (r4 == null) goto L22;
        a r9 = new a(r1);
        if (r3 == false) goto L17;
        Set r5 = SetsKt.setOf(new ChatTitleBarIcon[]{ChatTitleBarIcon.COLLAPSE, ChatTitleBarIcon.TTS});
    L18:
        Set r14 = r5;
        b r15 = new b(r3);
        if (r23 == null) goto L21;
        r7 = r23.l;
    L21:
        r4.AY(new qy8.a(r9, null, null, null, false, r14, r15, r7, null, 25598));
        goto L22
    L17:
        r5 = SetsKt.emptySet();
    L22:
        return r1;
    L12:
        r4 = null;
        goto L13
    L8:
        r2 = r19;
        goto L9
    }

    public static Object f(AIFloatChatFragment r16, Bundle r17, AIChatInputConfig r18, AIFloatChatFragment.h r19, Continuation r20) {
        CompletableDeferred r9 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        LifecycleOwner r0 = (LifecycleOwner) r16.getViewLifecycleOwnerLiveData().getValue();
        if (r0 == null) goto L7;
        LifecycleCoroutineScope r1 = LifecycleOwnerKt.getLifecycleScope(r0);
        if (r1 == null) goto L7;
    L8:
        BuildersKt.launch$default(r1, null, null, new AIChatInputUtils$integrateFloatChatFragment$2(r17, null, false, r19, r18, r16, r9, null), 3, null);
        FLogger.a.i("AIChatInputUtils", "integrateFloatChatFragment finished");
        return r9.await(r20);
    L7:
        r1 = LifecycleOwnerKt.getLifecycleScope(r16);
        goto L8
    }

    public static final Object b(Bundle r6, String r7, boolean r8, b0 r9, AIChatInputConfig r10, Continuation r11) {
        if ((r11 instanceof AIChatInputUtils$integrateFloatChatFragment$withMainConv$1) == false) goto L7;
        AIChatInputUtils$integrateFloatChatFragment$withMainConv$1 r0 = (AIChatInputUtils$integrateFloatChatFragment$withMainConv$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = r0.Z$0;
        r10 = (AIChatInputConfig) r0.L$3;
        r9 = (b0) r0.L$2;
        r7 = (String) r0.L$1;
        r6 = (Bundle) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L17:
        i r13 = (i) r12;
        if (r13 == null) goto L20;
        String r5 = r13.a;
    L22:
        if (r5 != null) goto L24;
    L27:
        boolean r14 = true;
    L28:
        if (r14 == false) goto L31;
        FLogger.a.i("AIChatInputUtils", "integrateFloatChatFragment, mainConvId is empty");
        return null;
    L31:
        if (r13.b.length() == 0) goto L34;
        r4 = false;
    L34:
        if (r4 == false) goto L36;
        FLogger.a.i("AIChatInputUtils", "integrateFloatChatFragment, main botId is empty");
        return null;
    L36:
        r6.putString("argConversationId", r5);
        r6.putString("argBotId", r13.b);
        return e(r7, r6, r8, r9, r10);
    L24:
        if (r5.length() == 0) goto L27;
        r14 = false;
        goto L28
    L20:
        r5 = null;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        FLogger.a.i("AIChatInputUtils", "integrateFloatChatFragment, withMainConv");
        AIChatInputUtils r15 = a;
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.L$2 = r9;
        r0.L$3 = r10;
        r0.Z$0 = r8;
        r0.label = 1;
        r12 = r15.d(r0);
        if (r12 != r2) goto L17;
        return r2;
    L7:
        r0 = new AIChatInputUtils$integrateFloatChatFragment$withMainConv$1(r11);
        goto L8
    }

    public static final Object g(Bundle r6, Fragment r7, String r8, boolean r9, b0 r10, AIChatInputConfig r11, Continuation<? super Fragment> r12) {
        if ((r12 instanceof AIChatInputUtils$integrateFloatChatFragment$withNewConv$1) == false) goto L7;
        AIChatInputUtils$integrateFloatChatFragment$withNewConv$1 r0 = (AIChatInputUtils$integrateFloatChatFragment$withNewConv$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r5 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = r0.Z$0;
        r11 = (AIChatInputConfig) r0.L$3;
        r10 = (b0) r0.L$2;
        r8 = (String) r0.L$1;
        r6 = (Bundle) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L20:
        i r14 = (i) r13;
        if (r14 == null) goto L23;
        String r15 = r14.a;
    L24:
        FLogger.a.i("AIChatInputUtils", "integrateFloatChatFragment, localConvId = " + r15);
        if (r14 == null) goto L35;
        if (r15 != null) goto L28;
    L31:
        if (r5 == true) goto L35;
        r6.putString("argConversationId", r15);
        r6.putString("argBotId", r14.b);
        return e(r8, r6, r9, r10, r11);
    L28:
        if (r15.length() == 0) goto L31;
        r5 = false;
    L35:
        return null;
    L23:
        r15 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        FLogger.a.i("AIChatInputUtils", "integrateFloatChatFragment, withNewConv");
        String r16 = r6.getString("custom_suffix", null);
        if (r16 != null) goto L17;
        r16 = "";
    L17:
        AIChatInputUtils r4 = a;
        Context r17 = r7.getContext();
        r0.L$0 = r6;
        r0.L$1 = r8;
        r0.L$2 = r10;
        r0.L$3 = r11;
        r0.Z$0 = r9;
        r0.label = 1;
        r13 = r4.c(r17, r16, r0);
        if (r13 != r2) goto L20;
        return r2;
    L7:
        r0 = new AIChatInputUtils$integrateFloatChatFragment$withNewConv$1(r12);
        goto L8
    }

    public static final Object a(Bundle r16, Fragment r17, String r18, boolean r19, b0 r20, AIChatInputConfig r21, String r22, Continuation r23) {
        if ((r23 instanceof AIChatInputUtils$integrateFloatChatFragment$withExistingConv$1) == false) goto L7;
        AIChatInputUtils$integrateFloatChatFragment$withExistingConv$1 r1 = (AIChatInputUtils$integrateFloatChatFragment$withExistingConv$1) r23;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        AIChatInputUtils$integrateFloatChatFragment$withExistingConv$1 r7 = r1;
        Object r0 = r7.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r7.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        boolean r4 = r7.Z$0;
        String r5 = (String) r7.L$4;
        AIChatInputConfig r6 = (AIChatInputConfig) r7.L$3;
        b0 r9 = (b0) r7.L$2;
        String r10 = (String) r7.L$1;
        Bundle r11 = (Bundle) r7.L$0;
        ResultKt.throwOnFailure(r0);
    L34:
        String r12 = (String) CollectionsKt.firstOrNull((List) r0);
        r11.putString("argConversationId", r5);
        r11.putString("argBotId", r12);
        return e(r10, r11, r4, r9, r6);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
    L39:
        return r0;
    L17:
        boolean r13 = r7.Z$0;
        r5 = (String) r7.L$5;
        r6 = (AIChatInputConfig) r7.L$4;
        b0 r14 = (b0) r7.L$3;
        String r15 = (String) r7.L$2;
        Fragment r24 = (Fragment) r7.L$1;
        Bundle r110 = (Bundle) r7.L$0;
        ResultKt.throwOnFailure(r0);
        boolean r25 = r13;
        b0 r111 = r14;
        String r112 = r15;
        Fragment r113 = r24;
    L22:
        wc9.e r26 = (wc9.e) r0;
        if (r26 == null) goto L35;
        Integer r27 = r26.t;
        if (r27 != null) goto L28;
    L30:
        r7.L$0 = r110;
        r7.L$1 = r112;
        r7.L$2 = r111;
        r7.L$3 = r6;
        r7.L$4 = r5;
        r7.L$5 = null;
        r7.Z$0 = r25;
        r7.label = 3;
        r0 = ic8.n.b(r5, r7);
        if (r0 == r8) goto L42;
        r4 = r25;
        r11 = r110;
        r10 = r112;
        r9 = r111;
        goto L34
    L42:
        return r8;
    L28:
        if (r27.intValue() != 2) goto L30;
    L35:
        FLogger.a.i("AIChatInputUtils", "integrateFloatChatFragment, no existing conversation, fallback newConv");
        r7.L$0 = null;
        r7.L$1 = null;
        r7.L$2 = null;
        r7.L$3 = null;
        r7.L$4 = null;
        r7.L$5 = null;
        r7.label = 2;
        r0 = g(r110, r113, r112, r25, r111, r6, r7);
        if (r0 != r8) goto L39;
        return r8;
    L18:
        ResultKt.throwOnFailure(r0);
        FLogger.a.i("AIChatInputUtils", "integrateFloatChatFragment, withExistingConv " + r22);
        IConversationRepoService r28 = RepoDispatcherDelegate.b.f();
        r110 = r16;
        r7.L$0 = r110;
        r113 = r17;
        r7.L$1 = r113;
        r112 = r18;
        r7.L$2 = r112;
        r111 = r20;
        r7.L$3 = r111;
        r7.L$4 = r21;
        r7.L$5 = r22;
        r25 = r19;
        r7.Z$0 = r25;
        r7.label = 1;
        r0 = IConversationRepoService.a.c(r28, r22, false, null, r7, 6);
        if (r0 == r8) goto L41;
        r6 = r21;
        r5 = r22;
        goto L22
    L41:
        return r8;
    L7:
        r1 = new AIChatInputUtils$integrateFloatChatFragment$withExistingConv$1(r23);
        goto L8
    }
}
