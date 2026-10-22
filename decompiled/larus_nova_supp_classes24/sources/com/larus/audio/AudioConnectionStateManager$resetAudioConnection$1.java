package com.larus.audio;

import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.audiov3.connection.ISamiConnectionPool;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.structures.SAMICoreConnectPoolContextParameter;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import m58.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.AudioConnectionStateManager$resetAudioConnection$1", f = "AudioConnectionStateManager.kt", i = {}, l = {359}, m = "invokeSuspend", n = {}, s = {})
public final class AudioConnectionStateManager$resetAudioConnection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $forceCloseFrontier;
    int label;

    public AudioConnectionStateManager$resetAudioConnection$1(boolean r1, Continuation<? super AudioConnectionStateManager$resetAudioConnection$1> r2) {
        this.$forceCloseFrontier = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AudioConnectionStateManager$resetAudioConnection$1(this.$forceCloseFrontier, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L28:
        AudioConnectionStateManager.a.getClass();
        AudioConnectionStateManager.f();
        FLogger.a.i("AudioConnectionStateManager", "resetAudioConnection");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        x58.a r8 = h.a;
        ((ISamiConnectionPool) ServiceManager.get().getService(ISamiConnectionPool.class)).disconnect();
        pd6.b r9 = pd6.c.a;
        ww5.a r10 = pd6.c.a(Reflection.getOrCreateKotlinClass(ww5.a.class));
        if (r10 == null) goto L11;
        r10.O1();
    L11:
        u1 r11 = u1.a;
        if (u1.d == false) goto L20;
        FLogger.a.i("SAMIReport", "destroyConnectPoolImmediately");
        f r12 = f.a;
        if (f.b() == false) goto L19;
        Iterator r13 = u1.e().iterator();
    L17:
        if (r13.hasNext() == false) goto L19;
        String r4 = (String) r13.next();
        SAMICoreConnectPoolContextParameter r5 = new SAMICoreConnectPoolContextParameter();
        r5.business = r4;
        SAMICore.RemoveConnectPoolClient(r5);
    L19:
        u1.d = false;
        f r14 = f.a;
        f.a().clear();
    L20:
        AudioConnectionStateManager.a.getClass();
        if (AudioConnectionStateManager.d() == false) goto L23;
    L24:
        u1 r15 = u1.a;
        FLogger.a.i("AudioConnectionStateManager", "CloseFrontierClient");
        SAMICore.CloseFrontierClient();
        u1.e = false;
    L25:
        u1 r16 = u1.a;
        u1.g();
        u1.f();
        this.label = 1;
        if (DelayKt.delay(LKUIToast.DURATION_SHORT, this) != r0) goto L28;
        return r0;
    L23:
        if (this.$forceCloseFrontier == false) goto L25;
        goto L24
    }
}
