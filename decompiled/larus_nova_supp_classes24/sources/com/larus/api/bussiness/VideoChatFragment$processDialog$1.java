package com.larus.api.bussiness;

import com.bytedance.keva.Keva;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.api.bussiness.VideoChatFragment$processDialog$1", f = "VideoChatFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VideoChatFragment$processDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VideoChatFragment this$0;

    public VideoChatFragment$processDialog$1(VideoChatFragment r1, Continuation<? super VideoChatFragment$processDialog$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VideoChatFragment$processDialog$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r15);
        final VideoChatFragment r16 = this.this$0;
        if (r16.e == true) goto L8;
        Function1 r2 = new c(r16);
        Keva r17 = a.a;
        long r4 = r17.getLong("last_remind_timestamp", -1);
        boolean r3 = r17.getBoolean("have_enter_specific_cycle_day", false);
        long r6 = r17.getLong("have_show_times", 0);
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new VideoChatFragment$needShowAuthorizationDialog$1(r2, r3, r4, r6, null), 3, null);
    L8:
        this.this$0.l = true;
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
