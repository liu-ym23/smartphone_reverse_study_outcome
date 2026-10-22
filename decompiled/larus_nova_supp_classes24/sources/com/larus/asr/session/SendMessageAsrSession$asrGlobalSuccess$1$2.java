package com.larus.asr.session;

import android.app.Application;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.asr.session.SendMessageAsrSession$asrGlobalSuccess$1$2", f = "SendMessageAsrSession.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SendMessageAsrSession$asrGlobalSuccess$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $alterSnapshot;
    final /* synthetic */ boolean $resultIntercepted;
    final /* synthetic */ boolean $successIntercepted;
    int label;

    public SendMessageAsrSession$asrGlobalSuccess$1$2(boolean r1, boolean r2, boolean r3, Continuation<? super SendMessageAsrSession$asrGlobalSuccess$1$2> r4) {
        this.$alterSnapshot = r1;
        this.$resultIntercepted = r2;
        this.$successIntercepted = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SendMessageAsrSession$asrGlobalSuccess$1$2(this.$alterSnapshot, this.$resultIntercepted, this.$successIntercepted, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r3);
        if (this.$alterSnapshot == true) goto L7;
        t19.s r4 = t19.s.a;
        Application r1 = AppHost.a.getApplication();
        r4.getClass();
        t19.s.s(r1, 2131899943);
    L13:
        return Unit.INSTANCE;
    L7:
        if (this.$resultIntercepted == true) goto L13;
        if (this.$successIntercepted == true) goto L13;
        t19.s r5 = t19.s.a;
        Application r2 = AppHost.a.getApplication();
        r5.getClass();
        t19.s.s(r2, 2131899943);
        goto L13
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
