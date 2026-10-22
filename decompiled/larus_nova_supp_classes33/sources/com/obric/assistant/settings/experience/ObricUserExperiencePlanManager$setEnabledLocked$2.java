package com.obric.assistant.settings.experience;

import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/experience/ObricUserExperiencePlanManager$UpdateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.experience.ObricUserExperiencePlanManager$setEnabledLocked$2", f = "ObricUserExperiencePlanManager.kt", i = {0, 0, 1, 1}, l = {162, 163}, m = "invokeSuspend", n = {"accountUid", "modelDeferred", "accountUid", "voiceSucceeded"}, s = {"L$0", "L$1", "L$0", "Z$0"})
final class ObricUserExperiencePlanManager$setEnabledLocked$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ObricUserExperiencePlanManager$b>, Object> {
    final /* synthetic */ boolean $enabled;
    private /* synthetic */ Object L$0;
    Object L$1;
    boolean Z$0;
    int label;

    public ObricUserExperiencePlanManager$setEnabledLocked$2(boolean r1, Continuation<? super ObricUserExperiencePlanManager$setEnabledLocked$2> r2) {
        this.$enabled = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObricUserExperiencePlanManager$setEnabledLocked$2 r0 = new ObricUserExperiencePlanManager$setEnabledLocked$2(this.$enabled, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ObricUserExperiencePlanManager$b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        boolean r3 = this.Z$0;
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r5 = r19;
    L22:
        boolean r6 = ((Boolean) r5).booleanValue();
        ObricUserExperiencePlanManager r7 = ObricUserExperiencePlanManager.a;
        if (ObricUserExperiencePlanManager.c(r4) == false) goto L25;
        if (r3 == false) goto L29;
        if (r6 == false) goto L29;
        t1.a.z(this.$enabled);
    L33:
        ObricUserExperiencePlanManager.a r8 = ObricUserExperiencePlanManager.e();
        ObricUserExperiencePlanManager.d.setValue(r8);
        return new ObricUserExperiencePlanManager$b(r3, r6, r8);
    L29:
        if (r3 == false) goto L31;
        t1.a.i1(this.$enabled);
    L31:
        if (r6 == false) goto L33;
        t1.a.q0(this.$enabled);
        goto L33
    L25:
        return new ObricUserExperiencePlanManager$b(false, false, ObricUserExperiencePlanManager.d());
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Deferred r9 = (Deferred) this.L$1;
        String r10 = (String) this.L$0;
        ResultKt.throwOnFailure(r19);
        Deferred r11 = r9;
        Object r12 = r19;
    L18:
        boolean r13 = ((Boolean) r12).booleanValue();
        this.L$0 = r10;
        this.L$1 = null;
        this.Z$0 = r13;
        this.label = 2;
        r5 = r11.await(this);
        if (r5 != r1) goto L21;
        return r1;
    L21:
        r3 = r13;
        r4 = r10;
        goto L22
    L10:
        ResultKt.throwOnFailure(r19);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        ObricUserExperiencePlanManager r15 = ObricUserExperiencePlanManager.a;
        String r16 = ObricUserExperiencePlanManager.a();
        if (StringsKt.isBlank(r16) == true) goto L13;
        IObricNetworkService r17 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        Deferred r18 = BuildersKt.async$default(r14, Dispatchers.getIO(), null, new ObricUserExperiencePlanManager$setEnabledLocked$2$voiceDeferred$1(r17, this.$enabled, null), 2, null);
        r11 = BuildersKt.async$default(r14, Dispatchers.getIO(), null, new ObricUserExperiencePlanManager$setEnabledLocked$2$modelDeferred$1(r17, this.$enabled, null), 2, null);
        this.L$0 = r16;
        this.L$1 = r11;
        this.label = 1;
        r12 = r18.await(this);
        if (r12 != r1) goto L17;
        return r1;
    L17:
        r10 = r16;
        goto L18
    L13:
        return new ObricUserExperiencePlanManager$b(false, false, ObricUserExperiencePlanManager.d());
    }
}
