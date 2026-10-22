package com.larus.drive.sdk.impl.service;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.larus.drive.sdk.impl.service.DriveChatServiceDelegate$withLocalConv$1", f = "DriveChatServiceDelegate.kt", i = {1}, l = {54, 56}, m = "invokeSuspend", n = {"localConvId"}, s = {"L$0"})
public final class DriveChatServiceDelegate$withLocalConv$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ CompletableDeferred<Fragment> $deferred;
    final /* synthetic */ boolean $hasBottomTab;
    final /* synthetic */ Fragment $parentFragment;
    Object L$0;
    int label;
    final /* synthetic */ DriveChatServiceDelegate this$0;

    public DriveChatServiceDelegate$withLocalConv$1(Fragment r1, CompletableDeferred<Fragment> r2, Bundle r3, DriveChatServiceDelegate r4, boolean r5, Continuation<? super DriveChatServiceDelegate$withLocalConv$1> r6) {
        this.$parentFragment = r1;
        this.$deferred = r2;
        this.$bundle = r3;
        this.this$0 = r4;
        this.$hasBottomTab = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DriveChatServiceDelegate$withLocalConv$1(this.$parentFragment, this.$deferred, this.$bundle, this.this$0, this.$hasBottomTab, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r7);
    L21:
        String r8 = (String) r7;
        if (r2 != null) goto L24;
    L27:
        boolean r3 = true;
    L28:
        if (r3 == true) goto L38;
        if (r8 != null) goto L31;
    L34:
        if (r4 == true) goto L38;
        this.$bundle.putString("argConversationId", r2);
        this.$bundle.putString("argBotId", r8);
        this.$deferred.complete(DriveChatServiceDelegate.b(this.this$0, this.$bundle, this.$hasBottomTab));
        return Unit.INSTANCE;
    L31:
        if (r8.length() == 0) goto L34;
        r4 = false;
    L38:
        this.$deferred.complete(null);
        return Unit.INSTANCE;
    L24:
        if (r2.length() == 0) goto L27;
        r3 = false;
        goto L28
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        wc9.e r9 = (wc9.e) r7;
        if (r9 == null) goto L16;
        String r5 = r9.a;
    L17:
        LocalSubConvHelper r6 = LocalSubConvHelper.a;
        this.L$0 = r5;
        this.label = 2;
        r7 = r6.f(r9, this);
        if (r7 != r0) goto L20;
        return r0;
    L20:
        r2 = r5;
        goto L21
    L16:
        r5 = null;
        goto L17
    L10:
        ResultKt.throwOnFailure(r7);
        DriveLocalConversationHelper r10 = DriveLocalConversationHelper.a;
        Context r11 = this.$parentFragment.getContext();
        Integer r12 = Boxing.boxInt(1);
        this.label = 1;
        r7 = DriveLocalConversationHelper.b(r11, r12, this);
        if (r7 != r0) goto L13;
        return r0;
    }
}
