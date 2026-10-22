package com.bytedance.ai.debugscene;

import com.bytedance.ai.applet.services.AppletAppManagerService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.debugscene.AIDebugManager$installAIPackagesWithVersionTagInMemory$2$1$1", f = "AIDebugManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AIDebugManager$installAIPackagesWithVersionTagInMemory$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Boolean, Boolean, String, Unit> $callback;
    final /* synthetic */ boolean $isAllowed;
    final /* synthetic */ String $packageName;
    final /* synthetic */ String $versionTag;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AIDebugManager$installAIPackagesWithVersionTagInMemory$2$1$1(String r1, String r10, Function3<? super Boolean, ? super Boolean, ? super String, Unit> r11, boolean r12, Continuation<? super AIDebugManager$installAIPackagesWithVersionTagInMemory$2$1$1> r13) {
        this.$packageName = r1;
        this.$versionTag = r10;
        this.$callback = r11;
        this.$isAllowed = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIDebugManager$installAIPackagesWithVersionTagInMemory$2$1$1(this.$packageName, this.$versionTag, this.$callback, this.$isAllowed, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r10);
        com.bytedance.ai.utils.g.a.i("AIManager", "terminate app before scan preview install callback. packageName: " + this.$packageName + ", versionTag: " + this.$versionTag);
        AppletAppManagerService r11 = AppletAppManagerService.INSTANCE;
        String r0 = this.$packageName;
        r11.getClass();
        AppletAppManagerService.f(r0);
        Function3<Boolean, Boolean, String, Unit> r12 = this.$callback;
        if (r12 == null) goto L8;
        r12.invoke(Boxing.boxBoolean(true), Boxing.boxBoolean(this.$isAllowed), null);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
