package com.obric.miniapp.view;

import com.bytedance.ai.model.AppletRuntimeManager;
import java.util.Map;
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
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.view.MiniAppBaseActivity$launchApplet$1$1$1$3", f = "MiniAppBaseActivity.kt", i = {}, l = {596}, m = "invokeSuspend", n = {}, s = {})
public final class MiniAppBaseActivity$launchApplet$1$1$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $checkUpdate;
    final /* synthetic */ boolean $hasNewVersion;
    final /* synthetic */ Map<String, Object> $pageData;
    int label;
    final /* synthetic */ MiniAppBaseActivity this$0;

    public MiniAppBaseActivity$launchApplet$1$1$1$3(boolean r1, boolean r2, MiniAppBaseActivity r3, Map<String, Object> r4, Continuation<? super MiniAppBaseActivity$launchApplet$1$1$1$3> r5) {
        this.$checkUpdate = r1;
        this.$hasNewVersion = r2;
        this.this$0 = r3;
        this.$pageData = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MiniAppBaseActivity$launchApplet$1$1$1$3(this.$checkUpdate, this.$hasNewVersion, this.this$0, this.$pageData, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        if (this.$checkUpdate == true) goto L11;
    L18:
        AppletRuntimeManager.INSTANCE.k(this.$pageData, new n());
        goto L20
    L11:
        if (this.$hasNewVersion == false) goto L18;
        MiniAppBaseActivity r6 = this.this$0;
        this.label = 1;
        int r2 = MiniAppBaseActivity.r;
        r6.getClass();
        Object r7 = BuildersKt.withContext(Dispatchers.getMain(), new MiniAppBaseActivity$showUpdateDialog$2(r6, null), this);
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        r7 = Unit.INSTANCE;
    L16:
        if (r7 != r0) goto L20;
        return r0;
    }
}
