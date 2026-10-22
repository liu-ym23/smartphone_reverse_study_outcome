package com.larus.dora.impl.dynamic;

import android.content.Context;
import com.bytedance.dora.device.DoraDevice;
import com.larus.avlink.api.IDoraAVLinkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.DoraFunctionIntroductionFragment$setupButton$1$1", f = "DoraFunctionIntroductionFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraFunctionIntroductionFragment$setupButton$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c59.b $action;
    int label;
    final /* synthetic */ DoraFunctionIntroductionFragment this$0;

    public DoraFunctionIntroductionFragment$setupButton$1$1(c59.b r1, DoraFunctionIntroductionFragment r2, Continuation<? super DoraFunctionIntroductionFragment$setupButton$1$1> r3) {
        this.$action = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraFunctionIntroductionFragment$setupButton$1$1(this.$action, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r5);
        Map<String, Object> r6 = this.$action.a();
        String r1 = null;
        if (r6 == null) goto L7;
        Object r7 = r6.get("tts");
    L9:
        if ((r7 instanceof Map) == false) goto L29;
        Lazy r8 = c59.s.a;
        c59.t r9 = (c59.t) c59.s.c(this.$action.a().get("tts"), c59.t.class);
        DoraDevice r0 = kj4.a.g().c();
        if (kj4.a.g().getDoraLinkState(r0) == 2) goto L14;
        t19.s r10 = t19.s.a;
        Context r2 = this.this$0.getContext();
        r10.getClass();
        t19.s.s(r2, 2131903181);
        return Unit.INSTANCE;
    L14:
        if (r0 == null) goto L29;
        if (o59.a.r(r0) == false) goto L22;
        IDoraAVLinkService r3 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r3 == null) goto L29;
        if (r9 == null) goto L21;
        r1 = r9.b();
    L21:
        r3.C(r1, "dora_function_introduction", Boxing.boxInt(3));
        goto L29
    L22:
        IDoraAVLinkService r4 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r4 == null) goto L29;
        if (r9 == null) goto L26;
        String r11 = r9.b();
    L27:
        r4.C(r11, "dora_function_introduction", null);
        goto L29
    L26:
        r11 = null;
    L29:
        return Unit.INSTANCE;
    L7:
        r7 = null;
        goto L9
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
