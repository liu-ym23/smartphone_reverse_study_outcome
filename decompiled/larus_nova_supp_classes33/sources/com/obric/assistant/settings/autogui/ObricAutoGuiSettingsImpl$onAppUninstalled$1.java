package com.obric.assistant.settings.autogui;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.settings.IObricAutoBlacklistSettingsNotifier;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl$onAppUninstalled$1", f = "ObricAutoGuiSettingsImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAutoGuiSettingsImpl$onAppUninstalled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $packageName;
    int label;
    final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

    public ObricAutoGuiSettingsImpl$onAppUninstalled$1(ObricAutoGuiSettingsImpl r1, String r2, Continuation<? super ObricAutoGuiSettingsImpl$onAppUninstalled$1> r3) {
        this.this$0 = r1;
        this.$packageName = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricAutoGuiSettingsImpl$onAppUninstalled$1(this.this$0, this.$packageName, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L35;
        ResultKt.throwOnFailure(r6);
        ObricAutoGuiSettingsImpl r7 = this.this$0;
        String r0 = this.$packageName;
        if (r7.a != null) goto L8;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "removeKevaValueForPackage: keva not initialized, skip " + r0);
    L33:
        return Unit.INSTANCE;
    L8:
        if (ObricAutoGuiSettingsImpl.i.contains(r0) == true) goto L33;
        Keva r1 = r7.a;
        Keva r3 = null;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r1 = null;
    L14:
        if (r1.contains(r0) == true) goto L36;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "removeKevaValueForPackage: no entry for " + r0);
        goto L33
    L36:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L22
        Keva r8 = r7.a;     // Catch: Throwable -> L22
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("keva");     // Catch: Throwable -> L22
    L20:
        r3.erase(r0);     // Catch: Throwable -> L22
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L25:
        if (Result.isSuccess-impl(r9) == false) goto L29;
        Unit r4 = (Unit) r9;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "removeKevaValueForPackage: erased " + r0);
        IObricAutoBlacklistSettingsNotifier r5 = (IObricAutoBlacklistSettingsNotifier) ServiceManager.get().getService(IObricAutoBlacklistSettingsNotifier.class);
        if (r5 == null) goto L29;
        r5.a();
    L29:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L33;
        FLogger.a.w("ObricAutoGuiSettingsImpl", "removeKevaValueForPackage: erase " + r0 + " failed", r10);
        goto L33
    L19:
        r3 = r8;
    L22:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L35:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
