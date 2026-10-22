package com.larus.audio.tts.notification;

import android.app.Application;
import android.content.ServiceConnection;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import m58.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.tts.notification.FlowTtsMediaSessionManager$releaseMediaSession$1", f = "FlowTtsMediaSessionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowTtsMediaSessionManager$releaseMediaSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FlowTtsMediaSessionManager this$0;

    public FlowTtsMediaSessionManager$releaseMediaSession$1(FlowTtsMediaSessionManager r1, Continuation<? super FlowTtsMediaSessionManager$releaseMediaSession$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new FlowTtsMediaSessionManager$releaseMediaSession$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r4);
        this.this$0.d.clear();
        g r5 = this.this$0.a;
        if (r5 == null) goto L7;
        r5.stopService();
    L7:
        FlowTtsMediaSessionManager r6 = this.this$0;
        r6.a = null;
        m58.b r1 = h.k;
        if (r1 == null) goto L10;
        Application r2 = r1.getApplication();
    L11:
        ServiceConnection r3 = r6.c;
        if (r3 == null) goto L17;
        if (r2 != null) goto L21;
    L15:
        r6.c = null;
        goto L17
    L21:
        r2.unbindService(r3);     // Catch: Exception -> L20
    L17:
        return Unit.INSTANCE;
    L10:
        r2 = null;
        goto L11
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
