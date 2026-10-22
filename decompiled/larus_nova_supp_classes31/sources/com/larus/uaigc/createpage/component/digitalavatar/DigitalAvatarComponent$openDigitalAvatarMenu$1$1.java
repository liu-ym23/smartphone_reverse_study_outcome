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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$openDigitalAvatarMenu$1$1", f = "DigitalAvatarComponent.kt", i = {0}, l = {366}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class DigitalAvatarComponent$openDigitalAvatarMenu$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DigitalAvatarComponent this$0;

    public DigitalAvatarComponent$openDigitalAvatarMenu$1$1(DigitalAvatarComponent r1, Continuation<? super DigitalAvatarComponent$openDigitalAvatarMenu$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DigitalAvatarComponent$openDigitalAvatarMenu$1$1 r0 = new DigitalAvatarComponent$openDigitalAvatarMenu$1$1(this.this$0, r4);
        r0.L$0 = r3;
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
    L12:
        Triple<Integer, Integer, Integer> r14 = this.this$0.B;
        if (r14 == null) goto L15;
        int r15 = ((Number) r14.getSecond()).intValue();
    L17:
        if (CoroutineScopeKt.isActive(r2) == false) goto L28;
        if (r15 < 0) goto L28;
        DigitalAvatarComponent r16 = this.this$0;
        Triple<Integer, Integer, Integer> r3 = r16.B;
        if (r3 == null) goto L22;
        int r4 = ((Number) r3.getFirst()).intValue();
    L23:
        if (r3 == null) goto L25;
        int r5 = ((Number) r3.getSecond()).intValue();
    L26:
        CommonDialog.a r6 = new CommonDialog.a();
        AppHost.Companion r7 = AppHost.a;
        r6.i(r7.getApplication().getString(2131908848));
        r6.g(r7.getApplication().getString(2131907682) + r7.getApplication().getResources().getQuantityString(2131755212, r4, new Object[]{Integer.valueOf(r4)}) + r7.getApplication().getResources().getQuantityString(2131755213, r5, new Object[]{Integer.valueOf(r5)}));
        f0 r8 = new f0(null, Integer.valueOf(ContextCompat.getColor(r16.getContext(), 2131102625)), null, 5);
        Intrinsics.checkNotNullParameter(r8, "commonDialogTextStyleConfig");
        r6.D = r8;
        f0 r9 = new f0(null, Integer.valueOf(ContextCompat.getColor(r16.getContext(), v19.c.b(2130972082, r16.getContext(), 2131103146))), null, 5);
        Intrinsics.checkNotNullParameter(r9, "commonDialogTextStyleConfig");
        r6.E = r9;
        r6.h(ContextCompat.getColor(r16.getContext(), v19.c.b(2130972082, r16.getContext(), 2131103146)));
        CommonDialog.a.f(r6, new t(r5, r16), r7.getApplication().getString(2131908847), false, 12);
        CommonDialog.a.e(r6, new u(), r7.getApplication().getString(2131907680), 4);
        CommonDialog r10 = r6.a();
        Intrinsics.checkNotNullParameter(r16, "<this>");
        DigitalAvatarComponent.Y2(r10, com.larus.ui.arch.component.internal.attach.a.b(r16, r16).getChildFragmentManager());
        goto L28
    L25:
        r5 = 0;
        goto L26
    L22:
        r4 = 0;
    L28:
        return Unit.INSTANCE;
    L15:
        r15 = 0;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CoroutineScope r17 = (CoroutineScope) this.L$0;
        DigitalAvatarComponent r11 = this.this$0;
        this.L$0 = r17;
        this.label = 1;
        if (DigitalAvatarComponent.p3(r11, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r17;
        goto L12
    }
}
