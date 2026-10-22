package com.larus.voicecall.impl.component.notify;

import android.graphics.Bitmap;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.IRtcNotificationService;
import com.larus.voicecall.impl.ui.t;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.notify.RealtimeNotifyComponent$refreshCallNotification$1", f = "RealtimeNotifyComponent.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeNotifyComponent$refreshCallNotification$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    int label;
    final /* synthetic */ RealtimeNotifyComponent this$0;

    public RealtimeNotifyComponent$refreshCallNotification$1(RealtimeNotifyComponent r1, String r2, Continuation<? super RealtimeNotifyComponent$refreshCallNotification$1> r3) {
        this.this$0 = r1;
        this.$reason = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RealtimeNotifyComponent$refreshCallNotification$1(this.this$0, this.$reason, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        Bitmap r3 = (Bitmap) r12;
        int r13 = t.a;
        FragmentActivity r14 = s1a.a.c(this.this$0).getActivity();
        RealtimeNotifyComponent r2 = this.this$0;
        int r4 = RealtimeNotifyComponent.w;
        String r5 = t.a(r14, ((h88.b) r2.p3()).k, ((h88.b) this.this$0.p3()).m);
        FLogger.a.d("RealtimeNotifyComponent", "refreshCallNotification, currentState:" + ((h88.b) this.this$0.p3()).k + ",content:" + r5);
        com.larus.voicecall.impl.notification.d r15 = com.larus.voicecall.impl.notification.d.a;
        String r9 = this.$reason;
        IRtcNotificationService.a r10 = new IRtcNotificationService.a(((h88.a) ((e3a.a) this.this$0.n.getValue())).c, r5, r3, t.b(((h88.b) this.this$0.p3()).k, ((h88.b) this.this$0.p3()).m), ((h88.b) this.this$0.p3()).m, true, ((h88.a) ((e3a.a) this.this$0.n.getValue())).k0, this.this$0.getContext());
        r15.getClass();
        com.larus.voicecall.impl.notification.d.f(r9, r10);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        RealtimeNotifyComponent r16 = this.this$0;
        this.label = 1;
        r12 = RealtimeNotifyComponent.h3(r16, this);
        if (r12 != r0) goto L11;
        return r0;
    }
}
