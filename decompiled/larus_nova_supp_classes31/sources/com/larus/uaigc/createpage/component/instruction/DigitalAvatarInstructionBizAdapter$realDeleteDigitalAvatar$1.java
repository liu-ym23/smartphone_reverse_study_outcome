package com.larus.uaigc.createpage.component.instruction;

import android.app.Application;
import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.uaigc.avatar.api.DigitalAvatarApi;
import com.larus.uaigc.service.ICreationAvatarService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.DigitalAvatarInstructionBizAdapter$realDeleteDigitalAvatar$1", f = "DigitalAvatarInstructionBizAdapter.kt", i = {}, l = {566}, m = "invokeSuspend", n = {}, s = {})
final class DigitalAvatarInstructionBizAdapter$realDeleteDigitalAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $digitalAvatarId;
    int label;
    final /* synthetic */ DigitalAvatarInstructionBizAdapter this$0;

    public DigitalAvatarInstructionBizAdapter$realDeleteDigitalAvatar$1(DigitalAvatarInstructionBizAdapter r1, String r2, Continuation<? super DigitalAvatarInstructionBizAdapter$realDeleteDigitalAvatar$1> r3) {
        this.this$0 = r1;
        this.$digitalAvatarId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DigitalAvatarInstructionBizAdapter$realDeleteDigitalAvatar$1(this.this$0, this.$digitalAvatarId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        dm9.a.b r7 = (dm9.a) r6;
        if ((r7 instanceof dm9.a.b) == false) goto L24;
        FLogger.a.i("DigitalAvatarInstructionBizAdapter", "delete digital avatar success");
        if (r7.a.getCode() != 710019209) goto L16;
        t19.s r8 = t19.s.a;
        Application r2 = AppHost.a.getApplication();
        r8.getClass();
        t19.s.b(r2, 2131908804, false);
    L29:
        return Unit.INSTANCE;
    L16:
        vp8.j r9 = this.this$0.i;
        if (r9 == null) goto L19;
        r9.A1();
    L19:
        vp8.j r10 = this.this$0.i;
        if (r10 == null) goto L22;
        r10.a();
    L22:
        ICreationAvatarService.Companion r11 = ICreationAvatarService.a;
        r11.P();
        r11.F();
        t19.s r12 = t19.s.a;
        Context r3 = DigitalAvatarInstructionBizAdapter.C(this.this$0);
        r12.getClass();
        t19.s.o(r3, 2131907685, false);
        goto L29
    L24:
        if ((r7 instanceof dm9.a.a) == false) goto L31;
        FLogger.a.i("DigitalAvatarInstructionBizAdapter", "delete digital avatar fail errorInfo is " + ((dm9.a.a) r7).c);
        t19.s r13 = t19.s.a;
        Context r4 = DigitalAvatarInstructionBizAdapter.C(this.this$0);
        r13.getClass();
        t19.s.b(r4, 2131900187, false);
        ys8.a r14 = (ys8.a) ((vp8.g) this.this$0).c.getValue();
        if (r14 == null) goto L29;
        r14.A1();
        goto L29
    L31:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        DigitalAvatarApi.a r15 = DigitalAvatarApi.a;
        DigitalAvatarInstructionBizAdapter$realDeleteDigitalAvatar$1$result$1 r5 = new DigitalAvatarInstructionBizAdapter$realDeleteDigitalAvatar$1$result$1(this.$digitalAvatarId, null);
        this.label = 1;
        r15.getClass();
        r6 = DigitalAvatarApi.a.a("/alice/profile/avatar/delete", r5, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
