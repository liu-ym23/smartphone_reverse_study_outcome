package com.larus.dora.impl.dynamic;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.ailab.keywords.DoraWakeupKeyword;
import com.larus.dora.impl.device.ailab.keywords.DoraWakeupKeywordsHandler;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.DoraFunctionIntroductionFragment$setupButton$1$3$1$1$confirm$1", f = "DoraFunctionIntroductionFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraFunctionIntroductionFragment$setupButton$1$3$1$1$confirm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isOwenEnabled;
    final /* synthetic */ boolean $isOwenKeyword;
    final /* synthetic */ boolean $isVoiceWakeEnabled;
    final /* synthetic */ DoraFunctionIntroductionFragment.a.C0059a $owenActionData;
    final /* synthetic */ DoraWakeupKeyword $owenKeyword;
    int label;

    public DoraFunctionIntroductionFragment$setupButton$1$3$1$1$confirm$1(boolean r1, DoraFunctionIntroductionFragment.a.C0059a r2, boolean r3, boolean r4, DoraWakeupKeyword r5, Continuation<? super DoraFunctionIntroductionFragment$setupButton$1$3$1$1$confirm$1> r6) {
        this.$isVoiceWakeEnabled = r1;
        this.$owenActionData = r2;
        this.$isOwenEnabled = r3;
        this.$isOwenKeyword = r4;
        this.$owenKeyword = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DoraFunctionIntroductionFragment$setupButton$1$3$1$1$confirm$1(this.$isVoiceWakeEnabled, this.$owenActionData, this.$isOwenEnabled, this.$isOwenKeyword, this.$owenKeyword, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L44;
        ResultKt.throwOnFailure(r4);
        String r0 = "";
        if (this.$isVoiceWakeEnabled == true) goto L19;
        if (DoraAdapterExtKt.M(kj4.a.g(), true) == 0) goto L19;
        t19.s r5 = t19.s.a;
        Application r1 = AppHost.a.getApplication();
        DoraFunctionIntroductionFragment.a.C0059a r2 = this.$owenActionData;
        if (r2 == null) goto L16;
        c59.t r3 = r2.b();
        if (r3 == null) goto L16;
        String r6 = c59.p.b(r3);
        if (r6 == null) goto L16;
        r0 = r6;
    L16:
        r5.getClass();
        t19.s.c(r1, r0);
        return Unit.INSTANCE;
    L19:
        if (this.$isOwenEnabled == true) goto L42;
        if (this.$isOwenKeyword == false) goto L42;
        DoraWakeupKeyword r7 = this.$owenKeyword;
        if (r7 == null) goto L40;
        String r8 = r7.getKeyword();
        if (r8 == null) goto L40;
        if (DoraWakeupKeywordsHandler.d(r8, true) == true) goto L42;
        t19.s r9 = t19.s.a;
        Application r10 = AppHost.a.getApplication();
        DoraFunctionIntroductionFragment.a.C0059a r11 = this.$owenActionData;
        if (r11 == null) goto L37;
        c59.t r12 = r11.b();
        if (r12 == null) goto L37;
        String r13 = c59.p.b(r12);
        if (r13 == null) goto L37;
        r0 = r13;
    L37:
        r9.getClass();
        t19.s.c(r10, r0);
        return Unit.INSTANCE;
    L40:
        return Unit.INSTANCE;
    L42:
        return Unit.INSTANCE;
    L44:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
