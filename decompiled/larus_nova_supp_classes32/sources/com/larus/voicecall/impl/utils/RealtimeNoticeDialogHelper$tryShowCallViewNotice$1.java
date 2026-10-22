package com.larus.voicecall.impl.utils;

import android.app.Application;
import android.content.Context;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.utils.t0;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import lq9.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.utils.RealtimeNoticeDialogHelper$tryShowCallViewNotice$1", f = "RealtimeNoticeDialogHelper.kt", i = {0}, l = {91}, m = "invokeSuspend", n = {"config"}, s = {"L$0"})
public final class RealtimeNoticeDialogHelper$tryShowCallViewNotice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public RealtimeNoticeDialogHelper$tryShowCallViewNotice$1(Continuation<? super RealtimeNoticeDialogHelper$tryShowCallViewNotice$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new RealtimeNoticeDialogHelper$tryShowCallViewNotice$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        lq9.s r2 = (lq9.s) this.L$0;
        ResultKt.throwOnFailure(r8);
    L18:
        lq9.s r9 = r2;
    L19:
        AppHost.Companion r3 = AppHost.a;
        String r4 = r3.getApplication().getResources().getString(2131900528);
        t19.s r5 = t19.s.a;
        Application r6 = r3.getApplication();
        Integer r10 = Boxing.boxInt(r9.b() * 1000);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r4, "text");
        Context r7 = t19.s.f(r6);
        if (r7 == null) goto L23;
        t0.e(new t19.j(r4, r7, r10));
    L23:
        ((Keva) RealtimeNoticeDialogHelper.a.getValue()).storeBoolean("KEY_IS_FIRST_SHOW_CALL_VIDEO_NOTICE", false);
        RealtimeNoticeDialogHelper.b = null;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        RealtimeCallUtil.a.getClass();
        r9 = ((b0) RealtimeCallUtil.N.getValue()).a();
        if (r9 == null) goto L11;
        long r11 = ((long) r9.a()) * 1000;
        if (r11 <= 0) goto L19;
        this.L$0 = r9;
        this.label = 1;
        if (DelayKt.delay(r11, this) != r0) goto L17;
        return r0;
    L17:
        r2 = r9;
        goto L18
    L11:
        return Unit.INSTANCE;
    }
}
