package com.larus.doc.impl;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.floatchat.IFloatChatService;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.doc.sdk.api.IDocSdkBaseService;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.AccountService;
import com.larus.ui.arch.component.external.api.receiver.Container;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocServiceImpl$integrateFloatChatFragment$withLocalConv$1", f = "DocServiceImpl.kt", i = {1, 1}, l = {202, 206}, m = "invokeSuspend", n = {"localConv", "localConvId"}, s = {"L$0", "L$1"})
public final class DocServiceImpl$integrateFloatChatFragment$withLocalConv$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ CompletableDeferred<Fragment> $deferred;
    final /* synthetic */ boolean $hasBottomTab;
    final /* synthetic */ String $sceneKey;
    Object L$0;
    Object L$1;
    int label;

    public static final class a implements Function1<fp8.b, Unit> {
        public final /* synthetic */ Container a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Bundle c;

        public a(Container r1, String r2, Bundle r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object invoke(Object r6) {
            fp8.b r7 = (t1a.c) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            Container r0 = this.a;
            fp8.b r8 = fp8.b.a(r7, this.b, this.c.getInt("bottom_tab_height", 0), 1);
            t1a.e r1 = s1a.d.a(r0).p(Reflection.getOrCreateKotlinClass(fp8.b.class));
            if (r1 == null) goto L5;
            r1.a(new b(r8));
        L9:
            return Unit.INSTANCE;
        L5:
            x1a.b r9 = x1a.a.c;
            if (r9 == null) goto L9;
            r9.log(5, "ComponentArch", "updateData ignored: context destroyed for " + Reflection.getOrCreateKotlinClass(fp8.b.class).getQualifiedName());
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

    public DocServiceImpl$integrateFloatChatFragment$withLocalConv$1(CompletableDeferred<Fragment> r1, Bundle r2, boolean r3, String r4, Continuation<? super DocServiceImpl$integrateFloatChatFragment$withLocalConv$1> r5) {
        this.$deferred = r1;
        this.$bundle = r2;
        this.$hasBottomTab = r3;
        this.$sceneKey = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DocServiceImpl$integrateFloatChatFragment$withLocalConv$1(this.$deferred, this.$bundle, this.$hasBottomTab, this.$sceneKey, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r2 = "";
        boolean r5 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        String r3 = (String) this.L$1;
        wc9.e r4 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r8);
    L23:
        String r9 = (String) r8;
        if (r9 == null) goto L28;
        r2 = r9;
    L28:
        if (r3.length() != 0) goto L30;
        boolean r10 = true;
    L31:
        if (r10 == false) goto L33;
    L57:
        this.$deferred.complete(null);
        return Unit.INSTANCE;
    L33:
        if (r2.length() == 0) goto L36;
        r5 = false;
    L36:
        if (r5 == true) goto L57;
        BotModel r11 = (BotModel) BotInfoCache.INSTANCE.get(r3);
        IDocSdkBaseService r6 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r6 == null) goto L41;
        r6.setConversationId(r3);
    L41:
        Fragment r7 = com.larus.doc.impl.chat.a.b();
        if (r7 == null) goto L48;
        t1a.b r12 = s1a.a.g(r7);
        if (r12 == null) goto L48;
        j39.a r13 = (j39.a) r12.getAbility(j39.a.class);
        if (r13 == null) goto L48;
        r13.P1(r4);
    L48:
        Fragment r14 = com.larus.doc.impl.chat.a.b();
        if (r14 == null) goto L55;
        t1a.b r15 = s1a.a.g(r14);
        if (r15 == null) goto L55;
        j39.a r16 = (j39.a) r15.getAbility(j39.a.class);
        if (r16 == null) goto L55;
        r16.e1(r11);
    L55:
        this.$bundle.putString("argConversationId", r3);
        this.$bundle.putString("argBotId", r2);
        IFloatChatService r17 = (IFloatChatService) ServiceManager.get().getService(IFloatChatService.class);
        final Bundle r18 = this.$bundle;
        boolean r20 = this.$hasBottomTab;
        final String r21 = this.$sceneKey;
        this.$deferred.complete(IFloatChatService.a.a(r17, r18, r20, null, null, new w1(r21, r18), 12));
        return Unit.INSTANCE;
    L30:
        r10 = false;
        goto L31
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        r4 = (wc9.e) r8;
        if (r4 == null) goto L16;
        String r22 = r4.a;
    L17:
        if (r22 != null) goto L19;
        r22 = "";
    L19:
        LocalSubConvHelper r23 = LocalSubConvHelper.a;
        this.L$0 = r4;
        this.L$1 = r22;
        this.label = 2;
        Object r24 = r23.f(r4, this);
        if (r24 != r0) goto L22;
        return r0;
    L22:
        r3 = r22;
        r8 = r24;
        goto L23
    L16:
        r22 = null;
        goto L17
    L10:
        ResultKt.throwOnFailure(r8);
        LocalSubConvHelper r25 = LocalSubConvHelper.a;
        String r26 = AccountService.a.getSecUserId();
        this.label = 1;
        r8 = r25.c(r26, null, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
