package com.larus.doc.impl;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.doc.sdk.api.IDocSdkBaseService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocServiceImpl$integrateFloatChatFragment$2", f = "DocServiceImpl.kt", i = {1, 1, 1, 1, 2, 2, 2, 2}, l = {335, 351, 354}, m = "invokeSuspend", n = {"bindedMsgId", "remoteConvId", "artifactMetaId", "artifactVersionId", "bindedMsgId", "remoteConvId", "artifactMetaId", "artifactVersionId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
final class DocServiceImpl$integrateFloatChatFragment$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ CompletableDeferred<Fragment> $deferred;
    final /* synthetic */ String $docId;
    final /* synthetic */ boolean $hasBottomTab;
    final /* synthetic */ Fragment $parentFragment;
    final /* synthetic */ int $resourceType;
    final /* synthetic */ String $sceneKey;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ DocServiceImpl this$0;

    public DocServiceImpl$integrateFloatChatFragment$2(Fragment r1, CompletableDeferred<Fragment> r2, DocServiceImpl r3, Bundle r4, boolean r5, String r6, String r7, int r8, Continuation<? super DocServiceImpl$integrateFloatChatFragment$2> r9) {
        this.$parentFragment = r1;
        this.$deferred = r2;
        this.this$0 = r3;
        this.$bundle = r4;
        this.$hasBottomTab = r5;
        this.$sceneKey = r6;
        this.$docId = r7;
        this.$resourceType = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new DocServiceImpl$integrateFloatChatFragment$2(this.$parentFragment, this.$deferred, this.this$0, this.$bundle, this.$hasBottomTab, this.$sceneKey, this.$docId, this.$resourceType, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r9 = "";
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        String r1 = (String) this.L$3;
        String r2 = (String) this.L$2;
        String r3 = (String) this.L$1;
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r18);
        String r14 = r1;
        Object r5 = r18;
    L74:
        List r6 = (List) r5;
        if (r6 == null) goto L77;
        String r8 = (String) CollectionsKt.firstOrNull(r6);
    L78:
        Fragment r10 = com.larus.doc.impl.chat.a.a();
        if (r10 == null) goto L90;
        t1a.b r11 = s1a.a.g(r10);
        if (r11 == null) goto L90;
        com.larus.bmhome.chat.component.cvs.y r12 = r11.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r12 == null) goto L90;
        if (r3 != null) goto L86;
        String r13 = "";
    L87:
        if (r8 != null) goto L89;
        r8 = "";
    L89:
        r12.updateConversationId(r13, r8);
        goto L90
    L86:
        r13 = r3;
    L90:
        Fragment r15 = com.larus.doc.impl.chat.a.a();
        if (r15 == null) goto L97;
        t1a.b r16 = s1a.a.g(r15);
        if (r16 == null) goto L97;
        va8.l0 r17 = r16.getAbility(va8.l0.class);
        if (r17 == null) goto L97;
        r17.setConversationId(r3);
    L97:
        Fragment r20 = com.larus.doc.impl.chat.a.a();
        if (r20 == null) goto L105;
        t1a.b r21 = s1a.a.g(r20);
        if (r21 == null) goto L105;
        va8.g0 r22 = r21.getAbility(va8.g0.class);
        if (r22 == null) goto L105;
        r22.setConversationId(r3);
    L105:
        if (com.larus.utils.o0.d(r2) == false) goto L123;
        Fragment r23 = com.larus.doc.impl.chat.a.a();
        if (r23 == null) goto L116;
        t1a.b r24 = s1a.a.g(r23);
        if (r24 == null) goto L116;
        g39.a r25 = r24.getAbility(g39.a.class);
        if (r25 == null) goto L116;
        if (r2 != null) goto L114;
        String r26 = "";
    L115:
        r25.F8(r26, null, null, null);
        goto L116
    L114:
        r26 = r2;
    L116:
        IDocSdkBaseService r27 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r27 == null) goto L123;
        if (r2 != null) goto L120;
        String r28 = "";
    L121:
        r27.setArtifactMetaId(r28);
        goto L123
    L120:
        r28 = r2;
    L123:
        if (com.larus.utils.o0.d(r14) == false) goto L134;
        Fragment r30 = com.larus.doc.impl.chat.a.a();
        if (r30 == null) goto L134;
        t1a.b r31 = s1a.a.g(r30);
        if (r31 == null) goto L134;
        va8.l0 r32 = r31.getAbility(va8.l0.class);
        if (r32 == null) goto L134;
        if (r14 != null) goto L132;
        String r33 = "";
    L133:
        r32.o9(r33);
        goto L134
    L132:
        r33 = r14;
    L134:
        Fragment r34 = com.larus.doc.impl.chat.a.b();
        if (r34 == null) goto L141;
        t1a.b r35 = s1a.a.g(r34);
        if (r35 == null) goto L141;
        g39.a r36 = r35.getAbility(g39.a.class);
        if (r36 == null) goto L141;
        r36.F8(r2, r14, r3, r4);
    L141:
        IDocSdkBaseService r37 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r37 == null) goto L148;
        if (r3 == null) goto L146;
        r9 = r3;
    L146:
        r37.setConversationId(r9);
    L148:
        return Unit.INSTANCE;
    L77:
        r8 = null;
        goto L78
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        String r38 = (String) this.L$3;
        r2 = (String) this.L$2;
        r3 = (String) this.L$1;
        r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r18);
        r14 = r38;
        Object r40 = r18;
    L61:
        wc9.e r41 = (wc9.e) r40;
        if (r41 == null) goto L105;
        Fragment r42 = com.larus.doc.impl.chat.a.b();
        if (r42 == null) goto L70;
        t1a.b r43 = s1a.a.g(r42);
        if (r43 == null) goto L70;
        j39.a r44 = (j39.a) r43.getAbility(j39.a.class);
        if (r44 == null) goto L70;
        r44.P1(r41);
    L70:
        if (r3 == null) goto L77;
        this.L$0 = r4;
        this.L$1 = r3;
        this.L$2 = r2;
        this.L$3 = r14;
        this.label = 3;
        r5 = ic8.n.b(r3, this);
        if (r5 != r7) goto L74;
        return r7;
    L11:
        ResultKt.throwOnFailure(r18);
        Object r45 = r18;
    L15:
        dm9.a.b r46 = (dm9.a) r45;
        if ((r46 instanceof dm9.a.b) == false) goto L148;
        dm9.a.b r47 = r46;
        h39.h r48 = (h39.h) r47.a.getData();
        if (r48 == null) goto L26;
        h39.a r50 = r48.a();
        if (r50 == null) goto L26;
        h39.e r51 = r50.a();
        if (r51 == null) goto L26;
        h39.i r52 = r51.b();
        if (r52 == null) goto L26;
        String r110 = r52.a();
    L27:
        h39.h r53 = (h39.h) r47.a.getData();
        if (r53 == null) goto L36;
        h39.a r54 = r53.a();
        if (r54 == null) goto L36;
        h39.e r55 = r54.a();
        if (r55 == null) goto L36;
        h39.i r56 = r55.b();
        if (r56 == null) goto L36;
        String r111 = r56.b();
    L37:
        h39.h r57 = (h39.h) r47.a.getData();
        if (r57 == null) goto L42;
        h39.a r58 = r57.a();
        if (r58 == null) goto L42;
        String r112 = r58.b();
    L43:
        h39.h r60 = (h39.h) r47.a.getData();
        if (r60 == null) goto L50;
        h39.a r61 = r60.a();
        if (r61 == null) goto L50;
        h39.e r62 = r61.a();
        if (r62 == null) goto L50;
        r14 = r62.a();
    L51:
        FLogger.a.i("DocServiceImpl", "integrateFloatChatFragment, GetSubConversationRequest success, remoteConvId = " + r111 + ", artifactMetaId = " + r112);
        if (com.larus.utils.o0.d(r111) == false) goto L148;
        IConversationRepoService r63 = RepoDispatcherDelegate.b.f();
        if (r111 != null) goto L56;
        String r64 = "";
    L57:
        this.L$0 = r110;
        this.L$1 = r111;
        this.L$2 = r112;
        this.L$3 = r14;
        this.label = 2;
        r40 = IConversationRepoService.a.c(r63, r64, false, null, this, 6);
        if (r40 != r7) goto L60;
        return r7;
    L60:
        r4 = r110;
        r3 = r111;
        r2 = r112;
        goto L61
    L56:
        r64 = r111;
    L50:
        r14 = null;
    L42:
        r112 = null;
    L36:
        r111 = null;
    L26:
        r110 = null;
        goto L27
    L12:
        ResultKt.throwOnFailure(r18);
        DocServiceImpl.c(this.$parentFragment, this.$deferred, this.this$0, this.$bundle, this.$hasBottomTab, this.$sceneKey);
        FLogger.a.i("DocServiceImpl", "integrateFloatChatFragment, useRemoteConv begin");
        DocumentApi.a r65 = DocumentApi.a;
        DocServiceImpl$integrateFloatChatFragment$2$resp$1 r66 = new DocServiceImpl$integrateFloatChatFragment$2$resp$1(this.$docId, this.$resourceType, this.$bundle, null);
        this.label = 1;
        r65.getClass();
        r45 = DocumentApi.a.a(r66, this);
        if (r45 != r7) goto L15;
        return r7;
    }
}
