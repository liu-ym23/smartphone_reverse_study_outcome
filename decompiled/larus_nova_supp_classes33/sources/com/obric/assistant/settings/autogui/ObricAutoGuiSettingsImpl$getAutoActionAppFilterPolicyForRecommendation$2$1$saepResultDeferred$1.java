package com.obric.assistant.settings.autogui;

import android.content.Context;
import com.obric.assistant.AutoGuiAppScopeConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/autogui/ObricSaepRestrictedPackageReader$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1$saepResultDeferred$1", f = "ObricAutoGuiSettingsImpl.kt", i = {}, l = {428}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1$saepResultDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ObricSaepRestrictedPackageReader.a>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ AutoGuiAppScopeConfig $appScopeConfig;
    int label;

    public ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1$saepResultDeferred$1(AutoGuiAppScopeConfig r1, Context r2, Continuation<? super ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1$saepResultDeferred$1> r3) {
        this.$appScopeConfig = r1;
        this.$appContext = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1$saepResultDeferred$1(this.$appScopeConfig, this.$appContext, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ObricSaepRestrictedPackageReader.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L16:
        return (ObricSaepRestrictedPackageReader.a) r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        if (this.$appScopeConfig.getEnableSaepRestrictedPackages() == false) goto L15;
        ObricSaepRestrictedPackageReader r6 = ObricSaepRestrictedPackageReader.a;
        Context r2 = this.$appContext;
        Intrinsics.checkNotNull(r2);
        this.label = 1;
        r5 = r6.query(r2, this);
        if (r5 != r0) goto L16;
        return r0;
    L15:
        return new ObricSaepRestrictedPackageReader.a(SetsKt.emptySet(), SetsKt.emptySet(), true, ObricSaepRestrictedPackageReader.Source.DISABLED_OR_UNSUPPORTED);
    }
}
