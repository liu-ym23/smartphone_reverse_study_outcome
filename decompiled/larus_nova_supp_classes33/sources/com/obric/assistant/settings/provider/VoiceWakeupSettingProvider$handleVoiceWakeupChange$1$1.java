package com.obric.assistant.settings.provider;

import android.content.Context;
import android.view.View;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.provider.VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1", f = "VoiceWakeupSettingProvider.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
final class VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $currentContext;
    final /* synthetic */ com.obric.assistant.settings.spi.b $host;
    final /* synthetic */ View $view;
    int label;

    public VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1(com.obric.assistant.settings.spi.b r1, View r2, Context r3, Continuation<? super VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1> r4) {
        this.$host = r1;
        this.$view = r2;
        this.$currentContext = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1(this.$host, this.$view, this.$currentContext, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r11v7, types: [com.obric.assistant.util.v0] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.obric.assistant.settings.provider.b2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.obric.assistant.settings.provider.c2, kotlin.jvm.functions.Function0] */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        if (((Boolean) r11).booleanValue() == false) goto L14;
        FLogger.a.d("VoiceWakeupSettingProvider", "VoiceWakeupSettingProvider: voice print exists, enabling voice wakeup");
        ObricEnrollInteropDelegate.b.f(true);
        this.$host.kW();
    L22:
        return Unit.INSTANCE;
    L14:
        FLogger r12 = FLogger.a;
        r12.d("VoiceWakeupSettingProvider", "VoiceWakeupSettingProvider: voice print not found, requesting device credential auth");
        int r2 = com.obric.assistant.util.y0.a;
        AppHost.Companion r3 = AppHost.a;
        final String r5 = r3.getApplication().getString(2131912072);
        final String r6 = r3.getApplication().getString(2131912071);
        View r4 = this.$view;
        final Context r7 = this.$currentContext;
        final com.obric.assistant.settings.spi.b r8 = this.$host;
        final ?? r9 = new b2(r7, r8);
        final ?? r10 = new c2(r8);
        final Function0 r13 = null;
        Intrinsics.checkNotNullParameter(r9, "onSucceeded");
        final ISessionAuthenticationService r14 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
        if (r14 != null) goto L17;
        r12.w("DeviceCredentialAuthHelper", "ISessionAuthenticationService not available");
        r10.invoke();
        goto L22
    L17:
        final ?? r15 = new com.obric.assistant.util.v0(r14, r5, r6, r9, r10, r13);
        if (r4 == null) goto L20;
        r4.post(new com.obric.assistant.util.w0(r15));
        goto L22
    L20:
        r15.invoke();
        goto L22
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineDispatcher r16 = Dispatchers.getIO();
        VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1$isVoicePrintExisted$1 r17 = new VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1$isVoicePrintExisted$1(null);
        this.label = 1;
        r11 = BuildersKt.withContext(r16, r17, this);
        if (r11 != r0) goto L12;
        return r0;
    }
}
