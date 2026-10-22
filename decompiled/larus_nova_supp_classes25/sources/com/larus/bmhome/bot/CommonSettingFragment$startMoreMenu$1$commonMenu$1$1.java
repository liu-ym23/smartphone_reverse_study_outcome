package com.larus.bmhome.bot;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$startMoreMenu$1$commonMenu$1$1", f = "CommonSettingFragment.kt", i = {}, l = {1103}, m = "invokeSuspend", n = {}, s = {})
final class CommonSettingFragment$startMoreMenu$1$commonMenu$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CommonSettingFragment this$0;

    public CommonSettingFragment$startMoreMenu$1$commonMenu$1$1(CommonSettingFragment r1, Continuation<? super CommonSettingFragment$startMoreMenu$1$commonMenu$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommonSettingFragment$startMoreMenu$1$commonMenu$1$1(this.this$0, r3);
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
        boolean r2 = true;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L24
    L18:
        if (((Boolean) r5).booleanValue() == true) goto L21;
    L20:
        r2 = false;
    L21:
        if (r2 == true) goto L26;
        t19.s r6 = t19.s.a;     // Catch: Throwable -> L24
        Context r3 = this.this$0.getContext();     // Catch: Throwable -> L24
        r6.getClass();     // Catch: Throwable -> L24
        t19.s.b(r3, 2131901132, false);     // Catch: Throwable -> L24
    L26:
        this.this$0.F = false;
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L24
        if (r7 == null) goto L20;
        FlowAppletServiceImpl r8 = r7.g0();     // Catch: Throwable -> L24
        if (r8 == null) goto L20;
        Context r4 = this.this$0.requireContext();     // Catch: Throwable -> L24
        this.label = 1;     // Catch: Throwable -> L24
        r5 = r8.b(r4, this);     // Catch: Throwable -> L24
        if (r5 != r0) goto L18;
        return r0;
    L24:
        th = move-exception;
        this.this$0.F = false;
        throw th;
    }
}
