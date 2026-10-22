package com.larus.doc.impl;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.floatchat.IFloatChatService;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.doc.sdk.api.IDocSdkBaseService;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.platform.service.AccountService;
import com.larus.ui.arch.component.external.api.receiver.Container;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocServiceImpl$integrateFloatChatFragment$withLocalConv$2$1$1", f = "DocServiceImpl.kt", i = {1, 2, 2}, l = {241, 242, 247}, m = "invokeSuspend", n = {"botId", "botId", "botModel"}, s = {"L$0", "L$0", "L$4"})
public final class DocServiceImpl$integrateFloatChatFragment$withLocalConv$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ CompletableDeferred<Fragment> $deferred;
    final /* synthetic */ boolean $hasBottomTab;
    final /* synthetic */ Fragment $parentFragment;
    final /* synthetic */ String $sceneKey;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    final /* synthetic */ DocServiceImpl this$0;

    public static final class a implements Function1<fp8.b, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ Container c;

        public a(String r1, Bundle r2, Container r3) {
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
            r0.a(new b(r7));
        L9:
            return Unit.INSTANCE;
        L5:
            x1a.b r8 = x1a.a.c;
            if (r8 == null) goto L9;
            r8.log(5, "ComponentArch", "updateData ignored: context destroyed for " + Reflection.getOrCreateKotlinClass(fp8.b.class).getQualifiedName());
            goto L9
        }
    }

    public static final class b implements Function1<fp8.b, fp8.b> {
        public final /* synthetic */ t1a.c a;

        public b(fp8.b r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            Intrinsics.checkNotNullParameter((t1a.c) r2, "it");
            return this.a;
        }
    }

    public DocServiceImpl$integrateFloatChatFragment$withLocalConv$2$1$1(String r1, DocServiceImpl r2, Bundle r3, Fragment r4, boolean r5, CompletableDeferred<Fragment> r6, String r7, Continuation<? super DocServiceImpl$integrateFloatChatFragment$withLocalConv$2$1$1> r8) {
        this.$cvsId = r1;
        this.this$0 = r2;
        this.$bundle = r3;
        this.$parentFragment = r4;
        this.$hasBottomTab = r5;
        this.$deferred = r6;
        this.$sceneKey = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DocServiceImpl$integrateFloatChatFragment$withLocalConv$2$1$1(this.$cvsId, this.this$0, this.$bundle, this.$parentFragment, this.$hasBottomTab, this.$deferred, this.$sceneKey, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L13;
        if (r2 == 1) goto L12;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        boolean r3 = this.Z$0;
        BotModel r4 = (BotModel) this.L$4;
        String r5 = (String) this.L$3;
        CompletableDeferred<Fragment> r6 = (CompletableDeferred) this.L$2;
        Bundle r8 = (Bundle) this.L$1;
        String r9 = (String) this.L$0;
        ResultKt.throwOnFailure(r20);
        final String r7 = r5;
        CompletableDeferred<Fragment> r0 = r6;
        final Bundle r10 = r8;
        Object r11 = r20;
        boolean r12 = r3;
    L41:
        wc9.e r13 = (wc9.e) r11;
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("integrateFloatChatFragment, localConvId = ");
        if (r13 == null) goto L44;
        String r16 = r13.a;
    L45:
        r15.append(r16);
        r14.i("DocServiceImpl", r15.toString());
        IDocSdkBaseService r17 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r17 == null) goto L52;
        if (r13 == null) goto L50;
        String r18 = r13.a;
        if (r18 == null) goto L50;
    L51:
        r17.setConversationId(r18);
    L50:
        r18 = "";
    L52:
        Fragment r21 = com.larus.doc.impl.chat.a.b();
        if (r21 == null) goto L59;
        t1a.b r22 = s1a.a.g(r21);
        if (r22 == null) goto L59;
        j39.a r23 = (j39.a) r22.getAbility(j39.a.class);
        if (r23 == null) goto L59;
        r23.P1(r13);
    L59:
        Fragment r24 = com.larus.doc.impl.chat.a.b();
        if (r24 == null) goto L66;
        t1a.b r25 = s1a.a.g(r24);
        if (r25 == null) goto L66;
        j39.a r26 = (j39.a) r25.getAbility(j39.a.class);
        if (r26 == null) goto L66;
        r26.e1(r4);
    L66:
        if (r13 == null) goto L68;
        String r27 = r13.a;
    L69:
        r10.putString("argConversationId", r27);
        r10.putString("argBotId", r9);
        Fragment r28 = IFloatChatService.a.a((IFloatChatService) ServiceManager.get().getService(IFloatChatService.class), r10, r12, null, null, new x1(r7, r10), 12);
        BotInfoCache r30 = BotInfoCache.INSTANCE;
        if (r13 == null) goto L72;
        String r31 = r13.a;
    L73:
        if (r31 != null) goto L75;
        r31 = r6;
    L75:
        r30.put(r31, r4);
        LocalSubConvHelper r32 = LocalSubConvHelper.a;
        if (r13 == null) goto L78;
        String r33 = r13.a;
    L79:
        if (r33 != null) goto L81;
        String r34 = r6;
    L82:
        BotOnBoarding r35 = r4.getOnBoarding();
        if (r35 == null) goto L86;
        List r36 = r35.getMessageList();
        if (r36 == null) goto L86;
    L87:
        LocalSubConvHelper.j(r34, r36, true);
        r0.complete(r28);
    L89:
        return Unit.INSTANCE;
    L86:
        r36 = CollectionsKt.emptyList();
        goto L87
    L81:
        r34 = r33;
        goto L82
    L78:
        r33 = null;
        goto L79
    L72:
        r31 = null;
        goto L73
    L68:
        r27 = null;
        goto L69
    L44:
        r16 = null;
        goto L45
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        String r37 = (String) this.L$0;
        ResultKt.throwOnFailure(r20);
        Object r38 = r20;
    L11:
        r9 = r37;
        r4 = (BotModel) r38;
        if (r4 == null) goto L89;
        Bundle r40 = this.$bundle;
        DocServiceImpl r110 = this.this$0;
        Fragment r111 = this.$parentFragment;
        boolean r112 = this.$hasBottomTab;
        CompletableDeferred<Fragment> r113 = this.$deferred;
        String r114 = this.$sceneKey;
        String r41 = UUID.randomUUID() + '_' + r40.getString("custom_suffix", null);
        Context r42 = r111.getContext();
        Integer r43 = Boxing.boxInt(1);
        this.L$0 = r9;
        this.L$1 = r40;
        this.L$2 = r113;
        this.L$3 = r114;
        this.L$4 = r4;
        this.Z$0 = r112;
        this.label = 3;
        int r115 = DocServiceImpl.c;
        r110.getClass();
        kotlinx.coroutines.j r116 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r116.C();
        if (AccountService.a.isEnterpriseAccount() == false) goto L30;
        int r117 = 2131908160;
    L31:
        if (r42 == null) goto L34;
        String r44 = r42.getString(r117);
        if (r44 == null) goto L34;
    L35:
        r7 = r114;
        com.larus.im.service.r.a.a(com.larus.im.d.d(), r4, 3, r43, MapsKt.mapOf(new Pair[]{TuplesKt.to("attach_local_msg", "true"), TuplesKt.to("conv_name", r44), TuplesKt.to("custom_suffix", r41)}), null, new u1(r116), 16);
        r11 = r116.B();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L38;
        DebugProbesKt.probeCoroutineSuspended(this);
    L38:
        if (r11 != r1) goto L40;
        return r1;
    L40:
        r12 = r112;
        r0 = r113;
        r10 = r40;
    L34:
        r44 = "";
        goto L35
    L30:
        r117 = 2131908104;
        goto L31
    L12:
        ResultKt.throwOnFailure(r20);
        Object r45 = r20;
    L16:
        r37 = (String) CollectionsKt.firstOrNull((List) r45);
        DocServiceImpl r46 = this.this$0;
        if (r37 != null) goto L19;
        String r118 = "";
    L20:
        this.L$0 = r37;
        this.label = 2;
        int r47 = DocServiceImpl.c;
        r46.getClass();
        kotlinx.coroutines.j r48 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r48.C();
        com.larus.im.service.o.a.a(com.larus.im.d.a(), r118, false, "sub", new v1(r48), 8);
        r38 = r48.B();
        if (r38 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        DebugProbesKt.probeCoroutineSuspended(this);
    L23:
        if (r38 != r1) goto L11;
        return r1;
    L19:
        r118 = r37;
        goto L20
    L13:
        ResultKt.throwOnFailure(r20);
        String r50 = this.$cvsId;
        this.label = 1;
        r45 = ic8.n.b(r50, this);
        if (r45 != r1) goto L16;
        return r1;
    }
}
