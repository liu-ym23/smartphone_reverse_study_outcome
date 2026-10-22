package com.larus.doc.impl;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.floatchat.IFloatChatService;
import com.larus.ui.arch.component.external.api.receiver.Container;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocServiceImpl$integrateFloatChatFragment$withRemoteConv$1", f = "DocServiceImpl.kt", i = {}, l = {285, 290}, m = "invokeSuspend", n = {}, s = {})
final class DocServiceImpl$integrateFloatChatFragment$withRemoteConv$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ CompletableDeferred<Fragment> $deferred;
    final /* synthetic */ boolean $hasBottomTab;
    final /* synthetic */ Fragment $parentFragment;
    final /* synthetic */ String $sceneKey;
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

    public DocServiceImpl$integrateFloatChatFragment$withRemoteConv$1(String r1, Bundle r2, boolean r3, CompletableDeferred<Fragment> r4, String r5, Fragment r6, DocServiceImpl r7, Continuation<? super DocServiceImpl$integrateFloatChatFragment$withRemoteConv$1> r8) {
        this.$cvsId = r1;
        this.$bundle = r2;
        this.$hasBottomTab = r3;
        this.$deferred = r4;
        this.$sceneKey = r5;
        this.$parentFragment = r6;
        this.this$0 = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DocServiceImpl$integrateFloatChatFragment$withRemoteConv$1(this.$cvsId, this.$bundle, this.$hasBottomTab, this.$deferred, this.$sceneKey, this.$parentFragment, this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r13);
    L25:
        String r14 = (String) CollectionsKt.firstOrNull((List) r13);
        this.$bundle.putString("argConversationId", this.$cvsId);
        this.$bundle.putString("argBotId", r14);
        FLogger r15 = FLogger.a;
        r15.i("DocServiceImpl", "integrateFloatChatFragment, setBundle");
        IFloatChatService r5 = (IFloatChatService) ServiceManager.get().getService(IFloatChatService.class);
        r15.i("DocServiceImpl", "integrateFloatChatFragment, getService");
        final Bundle r6 = this.$bundle;
        boolean r7 = this.$hasBottomTab;
        final String r2 = this.$sceneKey;
        Fragment r3 = IFloatChatService.a.a(r5, r6, r7, null, null, new y1(r2, r6), 12);
        r15.i("DocServiceImpl", "integrateFloatChatFragment, create fragment finish");
        this.$deferred.complete(r3);
        r15.i("DocServiceImpl", "integrateFloatChatFragment, deferred.complete");
    L28:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
    L13:
        wc9.e r16 = (wc9.e) r13;
        if (r16 == null) goto L26;
        FLogger.a.i("DocServiceImpl", "integrateFloatChatFragment, contain remoteConv");
        Fragment r4 = com.larus.doc.impl.chat.a.b();
        if (r4 == null) goto L22;
        t1a.b r8 = s1a.a.g(r4);
        if (r8 == null) goto L22;
        j39.a r9 = (j39.a) r8.getAbility(j39.a.class);
        if (r9 == null) goto L22;
        r9.P1(r16);
    L22:
        String r17 = this.$cvsId;
        this.label = 2;
        r13 = ic8.n.b(r17, this);
        if (r13 != r0) goto L25;
        return r0;
    L26:
        FLogger.a.i("DocServiceImpl", "integrateFloatChatFragment, no remoteConv");
        DocServiceImpl.c(this.$parentFragment, this.$deferred, this.this$0, this.$bundle, this.$hasBottomTab, this.$sceneKey);
        goto L28
    L10:
        ResultKt.throwOnFailure(r13);
        IConversationRepoService r10 = RepoDispatcherDelegate.b.f();
        String r11 = this.$cvsId;
        this.label = 1;
        r13 = IConversationRepoService.a.c(r10, r11, false, null, this, 6);
        if (r13 != r0) goto L13;
        return r0;
    }
}
