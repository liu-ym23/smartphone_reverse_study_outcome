package com.obric.assistant.settings.autogui;

import android.content.Context;
import com.obric.assistant.AutoGuiAppScopeConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsImpl$SystemSettingsAppScopeInputs;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2", f = "ObricAutoGuiSettingsImpl.kt", i = {0, 0, 0, 1, 1, 2}, l = {773, 774, 775, 776}, m = "invokeSuspend", n = {"cloudPolicyDeferred", "deviceConfigDeferred", "saepResultDeferred", "deviceConfigDeferred", "saepResultDeferred", "saepResultDeferred"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
public final class ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ObricAutoGuiSettingsImpl$h>, Object> {
    final /* synthetic */ ObricAutoGuiSettingsImpl$b $accountScope;
    final /* synthetic */ Context $appContext;
    final /* synthetic */ AutoGuiAppScopeConfig $appScopeConfig;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

    public ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2(ObricAutoGuiSettingsImpl r1, Context r2, ObricAutoGuiSettingsImpl$b r3, AutoGuiAppScopeConfig r4, Continuation<? super ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2> r5) {
        this.this$0 = r1;
        this.$appContext = r2;
        this.$accountScope = r3;
        this.$appScopeConfig = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2 r6 = new ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2(this.this$0, this.$appContext, this.$accountScope, this.$appScopeConfig, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ObricAutoGuiSettingsImpl$h> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        final o0.a r3 = (o0.a) this.L$2;
        final ObricAutoGuiSettingsImpl$d r4 = (ObricAutoGuiSettingsImpl$d) this.L$1;
        ObricAutoGuiSettingsImpl$g r5 = (ObricAutoGuiSettingsImpl$g) this.L$0;
        ResultKt.throwOnFailure(r18);
        final ObricAutoGuiSettingsImpl$g r6 = r5;
        Object r7 = r18;
    L30:
        final ObricSaepRestrictedPackageReader.a r8 = (ObricSaepRestrictedPackageReader.a) r7;
        return new ObricAutoGuiSettingsImpl$h(r6, r4, r3, r8);
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r4 = (ObricAutoGuiSettingsImpl$d) this.L$2;
        ObricAutoGuiSettingsImpl$g r9 = (ObricAutoGuiSettingsImpl$g) this.L$1;
        Deferred r10 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r18);
        Deferred r11 = r10;
        r6 = r9;
        Object r12 = r18;
    L26:
        o0.a r13 = (o0.a) r12;
        this.L$0 = r6;
        this.L$1 = r4;
        this.L$2 = r13;
        this.label = 4;
        r7 = r11.await(this);
        if (r7 != r1) goto L29;
        return r1;
    L29:
        r3 = r13;
        goto L30
    L12:
        ObricAutoGuiSettingsImpl$g r14 = (ObricAutoGuiSettingsImpl$g) this.L$2;
        Deferred r15 = (Deferred) this.L$1;
        Deferred r16 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r18);
        Deferred r17 = r16;
        r11 = r15;
        Object r19 = r18;
    L22:
        ObricAutoGuiSettingsImpl$d r20 = (ObricAutoGuiSettingsImpl$d) r19;
        this.L$0 = r11;
        this.L$1 = r14;
        this.L$2 = r20;
        this.label = 3;
        r12 = r17.await(this);
        if (r12 != r1) goto L25;
        return r1;
    L25:
        r6 = r14;
        r4 = r20;
        goto L26
    L13:
        Deferred r21 = (Deferred) this.L$2;
        Deferred r22 = (Deferred) this.L$1;
        Deferred r23 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r18);
        Deferred r110 = r23;
        r17 = r22;
        Object r24 = r18;
    L18:
        ObricAutoGuiSettingsImpl$g r25 = (ObricAutoGuiSettingsImpl$g) r24;
        this.L$0 = r17;
        this.L$1 = r21;
        this.L$2 = r25;
        this.label = 2;
        r19 = r110.await(this);
        if (r19 != r1) goto L21;
        return r1;
    L21:
        r11 = r21;
        r14 = r25;
        goto L22
    L14:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r26 = (CoroutineScope) this.L$0;
        Deferred r111 = BuildersKt.async$default(r26, Dispatchers.getIO(), null, new ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2$launcherPackagesDeferred$1(this.this$0, this.$appContext, null), 2, null);
        r110 = BuildersKt.async$default(r26, Dispatchers.getIO(), null, new ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2$cloudPolicyDeferred$1(this.this$0, this.$accountScope, null), 2, null);
        Deferred r112 = BuildersKt.async$default(r26, Dispatchers.getIO(), null, new ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2$deviceConfigDeferred$1(null), 2, null);
        Deferred r27 = BuildersKt.async$default(r26, Dispatchers.getIO(), null, new ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2$saepResultDeferred$1(this.$appScopeConfig, this.$appContext, null), 2, null);
        this.L$0 = r110;
        this.L$1 = r112;
        this.L$2 = r27;
        this.label = 1;
        r24 = r111.await(this);
        if (r24 != r1) goto L17;
        return r1;
    L17:
        r17 = r112;
        r21 = r27;
        goto L18
    }
}
