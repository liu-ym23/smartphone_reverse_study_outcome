package com.obric.assistant.settings.autogui;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsImpl$LauncherPackageSnapshot;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2$launcherPackagesDeferred$1", f = "ObricAutoGuiSettingsImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2$launcherPackagesDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ObricAutoGuiSettingsImpl$g>, Object> {
    final /* synthetic */ Context $appContext;
    int label;
    final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

    public ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2$launcherPackagesDeferred$1(ObricAutoGuiSettingsImpl r1, Context r2, Continuation<? super ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2$launcherPackagesDeferred$1> r3) {
        this.this$0 = r1;
        this.$appContext = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2$launcherPackagesDeferred$1(this.this$0, this.$appContext, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ObricAutoGuiSettingsImpl$g> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r5);
        ObricAutoGuiSettingsImpl r6 = this.this$0;
        Context r0 = this.$appContext;
        Intrinsics.checkNotNull(r0);
        Set r1 = ObricAutoGuiSettingsImpl.i;
        r6.getClass();
        if (ObricAutoGuiSettingsImpl.m() == true) goto L14;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherPackageSnapshot, no package permission, incomplete");
        return new ObricAutoGuiSettingsImpl$g(SetsKt.emptySet(), false);
    L14:
        return new ObricAutoGuiSettingsImpl$g(CollectionsKt.toSet(r6.p(r0)), true);
    L9:
        e = move-exception;
        FLogger.a.w("ObricAutoGuiSettingsImpl", "getLauncherPackageSnapshot, query failed", e);
        return new ObricAutoGuiSettingsImpl$g(SetsKt.emptySet(), false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
