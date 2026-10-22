package com.larus.uaigc.createpage.component.digitalavatar;

import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.f0;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$openDigitalAvatarMenu$2$1", f = "DigitalAvatarComponent.kt", i = {0}, l = {416}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class DigitalAvatarComponent$openDigitalAvatarMenu$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $digitalAvatarId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DigitalAvatarComponent this$0;

    public DigitalAvatarComponent$openDigitalAvatarMenu$2$1(DigitalAvatarComponent r1, String r2, Continuation<? super DigitalAvatarComponent$openDigitalAvatarMenu$2$1> r3) {
        this.this$0 = r1;
        this.$digitalAvatarId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DigitalAvatarComponent$openDigitalAvatarMenu$2$1 r0 = new DigitalAvatarComponent$openDigitalAvatarMenu$2$1(this.this$0, this.$digitalAvatarId, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r13);
    L13:
        if (CoroutineScopeKt.isActive(r2) == false) goto L23;
        DigitalAvatarComponent r14 = this.this$0;
        String r3 = this.$digitalAvatarId;
        Triple<Integer, Integer, Integer> r4 = r14.B;
        if (r4 == null) goto L17;
        int r5 = ((Number) r4.getFirst()).intValue();
    L18:
        if (r4 == null) goto L20;
        int r6 = ((Number) r4.getSecond()).intValue();
    L21:
        CommonDialog.a r7 = new CommonDialog.a();
        AppHost.Companion r8 = AppHost.a;
        r7.i(r8.getApplication().getString(2131908849));
        r7.g(r8.getApplication().getString(2131907682) + r8.getApplication().getResources().getQuantityString(2131755212, r5, new Object[]{Integer.valueOf(r5)}) + r8.getApplication().getResources().getQuantityString(2131755213, r6, new Object[]{Integer.valueOf(r6)}));
        f0 r9 = new f0(null, Integer.valueOf(ContextCompat.getColor(r14.getContext(), 2131102625)), null, 5);
        Intrinsics.checkNotNullParameter(r9, "commonDialogTextStyleConfig");
        r7.D = r9;
        f0 r10 = new f0(null, Integer.valueOf(ContextCompat.getColor(r14.getContext(), v19.c.b(2130972082, r14.getContext(), 2131103146))), null, 5);
        Intrinsics.checkNotNullParameter(r10, "commonDialogTextStyleConfig");
        r7.E = r10;
        r7.h(ContextCompat.getColor(r14.getContext(), v19.c.b(2130972082, r14.getContext(), 2131103146)));
        CommonDialog.a.f(r7, new q(r14, r3), r8.getApplication().getString(2131907681), false, 12);
        CommonDialog.a.e(r7, new r(), r8.getApplication().getString(2131907680), 4);
        CommonDialog r11 = r7.a();
        Intrinsics.checkNotNullParameter(r14, "<this>");
        DigitalAvatarComponent.Y2(r11, com.larus.ui.arch.component.internal.attach.a.b(r14, r14).getChildFragmentManager());
        goto L23
    L20:
        r6 = 0;
        goto L21
    L17:
        r5 = 0;
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        DigitalAvatarComponent r12 = this.this$0;
        this.L$0 = r15;
        this.label = 1;
        if (DigitalAvatarComponent.p3(r12, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r15;
        goto L13
    }
}
