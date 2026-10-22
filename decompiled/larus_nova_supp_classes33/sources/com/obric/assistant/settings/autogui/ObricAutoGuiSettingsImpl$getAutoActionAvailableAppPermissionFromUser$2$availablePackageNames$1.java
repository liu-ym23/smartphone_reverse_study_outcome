package com.obric.assistant.settings.autogui;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl$getAutoActionAvailableAppPermissionFromUser$2$availablePackageNames$1", f = "ObricAutoGuiSettingsImpl.kt", i = {}, l = {692}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAutoGuiSettingsImpl$getAutoActionAvailableAppPermissionFromUser$2$availablePackageNames$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
    final /* synthetic */ boolean $isClientOnly;
    int label;
    final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

    public ObricAutoGuiSettingsImpl$getAutoActionAvailableAppPermissionFromUser$2$availablePackageNames$1(boolean r1, ObricAutoGuiSettingsImpl r2, Continuation<? super ObricAutoGuiSettingsImpl$getAutoActionAvailableAppPermissionFromUser$2$availablePackageNames$1> r3) {
        this.$isClientOnly = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricAutoGuiSettingsImpl$getAutoActionAvailableAppPermissionFromUser$2$availablePackageNames$1(this.$isClientOnly, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L15:
        return (List) r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        if (this.$isClientOnly == false) goto L11;
        ObricAutoGuiSettingsImpl r5 = this.this$0;
        Context r2 = AppHost.a.getApplication().getApplicationContext();
        Set r3 = ObricAutoGuiSettingsImpl.i;
        return r5.p(r2);
    L11:
        ObricAutoGuiSettingsImpl r6 = this.this$0;
        this.label = 1;
        r4 = ObricAutoGuiSettingsImpl.k(r6, this);
        if (r4 != r0) goto L15;
        return r0;
    }
}
