package com.larus.drive.sdk.impl.service;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.service.DriveChatServiceDelegate$withRemoteConv$1", f = "DriveChatServiceDelegate.kt", i = {}, l = {80, 82}, m = "invokeSuspend", n = {}, s = {})
final class DriveChatServiceDelegate$withRemoteConv$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ CompletableDeferred<Fragment> $deferred;
    final /* synthetic */ boolean $hasBottomTab;
    final /* synthetic */ Fragment $parentFragment;
    int label;
    final /* synthetic */ DriveChatServiceDelegate this$0;

    public DriveChatServiceDelegate$withRemoteConv$1(String r1, Bundle r2, CompletableDeferred<Fragment> r3, DriveChatServiceDelegate r4, boolean r5, Fragment r6, Continuation<? super DriveChatServiceDelegate$withRemoteConv$1> r7) {
        this.$cvsId = r1;
        this.$bundle = r2;
        this.$deferred = r3;
        this.this$0 = r4;
        this.$hasBottomTab = r5;
        this.$parentFragment = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new DriveChatServiceDelegate$withRemoteConv$1(this.$cvsId, this.$bundle, this.$deferred, this.this$0, this.$hasBottomTab, this.$parentFragment, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L18:
        String r12 = (String) CollectionsKt.firstOrNull((List) r11);
        this.$bundle.putString("argConversationId", this.$cvsId);
        this.$bundle.putString("argBotId", r12);
        Boxing.boxBoolean(this.$deferred.complete(DriveChatServiceDelegate.b(this.this$0, this.$bundle, this.$hasBottomTab)));
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L14:
        if (((wc9.e) r11) == null) goto L19;
        String r13 = this.$cvsId;
        this.label = 2;
        r11 = ic8.n.b(r13, this);
        if (r11 != r0) goto L18;
        return r0;
    L19:
        DriveChatServiceDelegate r14 = this.this$0;
        CompletableDeferred<Fragment> r2 = this.$deferred;
        Fragment r3 = this.$parentFragment;
        Bundle r4 = this.$bundle;
        boolean r5 = this.$hasBottomTab;
        int r6 = DriveChatServiceDelegate.a;
        r14.c(r2, r3, r4, r5);
        goto L21
    L10:
        ResultKt.throwOnFailure(r11);
        IConversationRepoService r7 = RepoDispatcherDelegate.b.f();
        String r8 = this.$cvsId;
        this.label = 1;
        r11 = IConversationRepoService.a.c(r7, r8, false, null, this, 6);
        if (r11 != r0) goto L14;
        return r0;
    }
}
