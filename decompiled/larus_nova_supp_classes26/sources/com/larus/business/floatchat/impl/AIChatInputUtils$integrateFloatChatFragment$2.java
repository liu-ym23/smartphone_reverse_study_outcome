package com.larus.business.floatchat.impl;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.cvs.b0;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.business.floatchat.api.AIChatInputConfig;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.floatchat.impl.AIChatInputUtils$integrateFloatChatFragment$2", f = "AIChatInputUtils.kt", i = {}, l = {218, 220, 223, 224}, m = "invokeSuspend", n = {}, s = {})
final class AIChatInputUtils$integrateFloatChatFragment$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ b0 $conversationDeletedAbility;
    final /* synthetic */ CompletableDeferred<Fragment> $deferred;
    final /* synthetic */ boolean $hasBottomTab;
    final /* synthetic */ AIChatInputConfig $initialInputConfig;
    final /* synthetic */ Fragment $parentFragment;
    final /* synthetic */ String $sceneKey;
    private /* synthetic */ Object L$0;
    int label;

    public AIChatInputUtils$integrateFloatChatFragment$2(Bundle r1, String r2, boolean r3, b0 r4, AIChatInputConfig r5, Fragment r6, CompletableDeferred<Fragment> r7, Continuation<? super AIChatInputUtils$integrateFloatChatFragment$2> r8) {
        this.$bundle = r1;
        this.$sceneKey = r2;
        this.$hasBottomTab = r3;
        this.$conversationDeletedAbility = r4;
        this.$initialInputConfig = r5;
        this.$parentFragment = r6;
        this.$deferred = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        AIChatInputUtils$integrateFloatChatFragment$2 r9 = new AIChatInputUtils$integrateFloatChatFragment$2(this.$bundle, this.$sceneKey, this.$hasBottomTab, this.$conversationDeletedAbility, this.$initialInputConfig, this.$parentFragment, this.$deferred, r12);
        r9.L$0 = r11;
        return r9;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r5 = true;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L12;
        if (r1 != 4) goto L11;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L74
        Object r0 = r17;
    L71:
        Fragment r2 = (Fragment) r0;     // Catch: Throwable -> L74
    L72:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L74
    L76:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 != null) goto L79;
        Object r12 = r3;
    L80:
        CompletableDeferred<Fragment> r6 = this.$deferred;
        AIChatInputUtils r7 = AIChatInputUtils.a;
        r6.complete((Fragment) r12);
        return Unit.INSTANCE;
    L79:
        FLogger.a.e("AIChatInputUtils", "integrateFloatChatFragment failed", r4);
        r12 = null;
        goto L80
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L74
        Object r8 = r17;
    L63:
        r2 = (Fragment) r8;     // Catch: Throwable -> L74
        goto L72
    L13:
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L74
        Object r9 = r17;
    L54:
        r2 = (Fragment) r9;     // Catch: Throwable -> L74
        goto L72
    L14:
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L74
        Object r11 = r17;
    L47:
        r2 = (Fragment) r11;     // Catch: Throwable -> L74
        goto L72
    L16:
        ResultKt.throwOnFailure(r17);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        Bundle r14 = this.$bundle;
        String r15 = this.$sceneKey;
        boolean r16 = this.$hasBottomTab;
        b0 r18 = this.$conversationDeletedAbility;
        AIChatInputConfig r19 = this.$initialInputConfig;
        Fragment r110 = this.$parentFragment;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L74
        String r112 = r14.getString(MusicAppletPage.KEY_CONVERSATION_ID, null);     // Catch: Throwable -> L74
        boolean r113 = r14.getBoolean("use_main_conv", true);     // Catch: Throwable -> L74
        FLogger r20 = FLogger.a;     // Catch: Throwable -> L74
        StringBuilder r21 = new StringBuilder("integrateFloatChatFragment, targetConversationId = ");     // Catch: Throwable -> L74
        r21.append(r112);     // Catch: Throwable -> L74
        r21.append(", useMainConv = ");     // Catch: Throwable -> L74
        if (r113 == false) goto L20;
        boolean r22 = true;
    L21:
        r21.append(r22);     // Catch: Throwable -> L74
        r20.i("AIChatInputUtils", r21.toString());     // Catch: Throwable -> L74
        if (o0.d(r112) == false) goto L55;
        AuthModelDelegate r23 = AuthModelDelegate.b;     // Catch: Throwable -> L74
        e r24 = (e) r23.y().getValue();     // Catch: Throwable -> L74
        if (r24 == null) goto L26;
        String r25 = r24.a;     // Catch: Throwable -> L74
    L27:
        e r26 = (e) r23.u().getValue();     // Catch: Throwable -> L74
        if (r26 == null) goto L30;
        String r27 = r26.a;     // Catch: Throwable -> L74
    L32:
        if (Intrinsics.areEqual(r112, r25) == false) goto L34;
    L39:
        boolean r28 = true;
    L40:
        if (r28 == false) goto L48;
        if (r16 == false) goto L43;
        boolean r29 = true;
    L44:
        this.label = 1;     // Catch: Throwable -> L74
        r11 = AIChatInputUtils.b(r14, r15, r29, r18, r19, this);     // Catch: Throwable -> L74
        if (r11 != r10) goto L47;
        return r10;
    L43:
        r29 = false;
        goto L44
    L48:
        if (r16 == true) goto L51;
        r5 = false;
    L51:
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L74
        this.label = 2;     // Catch: Throwable -> L74
        r9 = AIChatInputUtils.a(r14, r110, r15, r5, r18, r19, r112, this);     // Catch: Throwable -> L74
        if (r9 != r10) goto L54;
        return r10;
    L34:
        if (com.larus.platform.exp.o.a() == true) goto L36;
    L38:
        r28 = false;
        goto L40
    L36:
        if (Intrinsics.areEqual(r112, r27) == false) goto L38;
    L30:
        r27 = null;
        goto L32
    L26:
        r25 = null;
        goto L27
    L55:
        if (r113 == false) goto L65;
        if (r16 == false) goto L59;
        boolean r30 = true;
    L60:
        this.label = 3;     // Catch: Throwable -> L74
        r8 = AIChatInputUtils.b(r14, r15, r30, r18, r19, this);     // Catch: Throwable -> L74
        if (r8 != r10) goto L63;
        return r10;
    L59:
        r30 = false;
        goto L60
    L65:
        if (r16 == false) goto L67;
        boolean r31 = true;
    L68:
        this.label = 4;     // Catch: Throwable -> L74
        r0 = AIChatInputUtils.g(r14, r110, r15, r31, r18, r19, this);     // Catch: Throwable -> L74
        if (r0 != r10) goto L71;
        return r10;
    L67:
        r31 = false;
        goto L68
    L20:
        r22 = false;
    L74:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L76
    }
}
