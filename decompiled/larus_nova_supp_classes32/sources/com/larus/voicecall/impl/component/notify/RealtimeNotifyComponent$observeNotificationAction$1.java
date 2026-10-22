package com.larus.voicecall.impl.component.notify;

import android.app.KeyguardManager;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "it", NameKeys.UnloadStrategy_No_Strategy}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.notify.RealtimeNotifyComponent$observeNotificationAction$1", f = "RealtimeNotifyComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeNotifyComponent$observeNotificationAction$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ RealtimeNotifyComponent this$0;

    public RealtimeNotifyComponent$observeNotificationAction$1(RealtimeNotifyComponent r1, Continuation<? super RealtimeNotifyComponent$observeNotificationAction$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        RealtimeNotifyComponent$observeNotificationAction$1 r0 = new RealtimeNotifyComponent$observeNotificationAction$1(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L54;
        ResultKt.throwOnFailure(r8);
        int r9 = this.I$0;
        String r0 = "lock_screen";
        Boolean r5 = null;
        if (r9 != 1) goto L7;
        FLogger.a.i("RealtimeNotifyComponent", "receive RtcNotificationAction.MUTE action");
        RealtimeNotifyComponent r10 = this.this$0;
        int r3 = RealtimeNotifyComponent.w;
        com.larus.voicecall.impl.component.core.a r11 = r10.m3();
        if (r11 == null) goto L34;
        r11.mute();
    L34:
        RealtimeNotifyComponent r12 = this.this$0;
        FragmentActivity r4 = s1a.a.c(r12).getActivity();
        if (r4 == null) goto L37;
        Object r2 = r4.getSystemService("keyguard");
    L39:
        if ((r2 instanceof KeyguardManager) == false) goto L41;
        KeyguardManager r6 = (KeyguardManager) r2;
    L42:
        if (r6 == null) goto L44;
        r5 = Boxing.boxBoolean(r6.isKeyguardLocked());
    L44:
        r12.t = r5;
        if (Intrinsics.areEqual(this.this$0.t, Boxing.boxBoolean(true)) == true) goto L48;
        r0 = "banner";
    L48:
        n3a.a r13 = (n3a.a) this.this$0.r.getValue();
        if (r13 == null) goto L52;
        r13.YU(r0);
    L52:
        return Unit.INSTANCE;
    L41:
        r6 = null;
        goto L42
    L37:
        r2 = null;
        goto L39
    L7:
        if (r9 != 2) goto L9;
        FLogger.a.i("RealtimeNotifyComponent", "receive RtcNotificationAction.UN_MUTE action");
        RealtimeNotifyComponent r14 = this.this$0;
        int r1 = RealtimeNotifyComponent.w;
        com.larus.voicecall.impl.component.core.a r15 = r14.m3();
        if (r15 == null) goto L52;
        r15.R1();
        goto L52
    L9:
        if (r9 != 3) goto L52;
        FLogger.a.i("RealtimeNotifyComponent", "receive RtcNotificationAction.HANG_UP action");
        RealtimeNotifyComponent r16 = this.this$0;
        FragmentActivity r7 = s1a.a.c(r16).getActivity();
        if (r7 == null) goto L14;
        Object r17 = r7.getSystemService("keyguard");
    L16:
        if ((r17 instanceof KeyguardManager) == false) goto L18;
        KeyguardManager r18 = (KeyguardManager) r17;
    L19:
        if (r18 == null) goto L21;
        r5 = Boxing.boxBoolean(r18.isKeyguardLocked());
    L21:
        r16.t = r5;
        e3a.b r19 = this.this$0.p3();
        if (Intrinsics.areEqual(this.this$0.t, Boxing.boxBoolean(true)) == true) goto L25;
        r0 = "banner";
    L25:
        ((h88.b) r19).o = r0;
        com.larus.voicecall.impl.component.window.b r20 = (com.larus.voicecall.impl.component.window.b) this.this$0.p.getValue();
        if (r20 == null) goto L52;
        r20.zg();
        goto L52
    L18:
        r18 = null;
        goto L19
    L14:
        r17 = null;
        goto L16
    L54:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
