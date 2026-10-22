package com.obric.assistant.session.lifecycle;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import bga.j;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import com.obric.assistant.common.utils.p;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.obric.assistant.session.singleton.SessionMaintainer;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueAudioScoState;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class BluetoothSoundEffectPlayer extends com.obric.assistant.session.lifecycle.a {
    public static final BluetoothSoundEffectPlayer b = null;
    public static final Lazy c = null;
    public static volatile boolean d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BlueAudioScoState.values().length];
            r0[BlueAudioScoState.CONNECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[BlueAudioScoState.DISCONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[BlueAudioScoState.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        b = new BluetoothSoundEffectPlayer();
        c = LazyKt.lazy(new b());
    }

    @Override // bga.i
    public final void onDestroy() {
        Lazy r0 = com.obric.assistant.utils.d.a;
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.BLUETOOTH_CONNECT") != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        return;
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L17;
        IBluetoothHeadSetAPI r2 = tha.c.a();
        if (r2 == null) goto L13;
        r2.stop();
    L13:
        IBluetoothHeadSetAPI r3 = tha.c.a();
        if (r3 == null) goto L18;
        r3.f((UUID) c.getValue());
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public BluetoothSoundEffectPlayer() {
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.assistant.session.lifecycle.c] */
    @Override // bga.i
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (Build.VERSION.SDK_INT < 23) goto L19;
        IBluetoothHeadSetAPI r0 = tha.c.a();
        boolean r1 = true;
        if (r0 == null) goto L7;
        boolean r4 = r0.start(r3);
    L8:
        if (r4 == true) goto L15;
        Lazy r5 = com.obric.assistant.utils.d.a;
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.BLUETOOTH_CONNECT") == 0) goto L13;
        r1 = false;
    L13:
        if (r1 == true) goto L15;
        return;
    L15:
        IBluetoothHeadSetAPI r6 = tha.c.a();
        if (r6 == null) goto L20;
        r6.o((UUID) c.getValue(), new c());
        return;
    L20:
        return;
    L7:
        r4 = true;
        goto L8
    }

    public static final Object d(BluetoothSoundEffectPlayer r8, Continuation r9) {
        r8.getClass();
        if ((r9 instanceof BluetoothSoundEffectPlayer$playToneInternal$1) == false) goto L7;
        BluetoothSoundEffectPlayer$playToneInternal$1 r0 = (BluetoothSoundEffectPlayer$playToneInternal$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r10);
    L52:
        if (ObricRealtimeCallServiceDelegate.b.a() == true) goto L57;
        FLogger r11 = FLogger.a;
        Lazy<String> r12 = SessionMaintainer.k;
        r11.w(SessionMaintainer.a.a(), "isMicInUse start ");
        Set r13 = p.a;
        AppHost.Companion r14 = AppHost.a;
        boolean r15 = p.f(r14.getApplication(), p.b(r14.getApplication()));
        r11.w(SessionMaintainer.a.a(), "isMicInUse end. value is " + r15 + ' ');
        if (r15 == true) goto L59;
        if (ILoginService.a.getAccountInfo().a == true) goto L57;
    L59:
        return Unit.INSTANCE;
    L57:
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_WAKE_UP);
        goto L59
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r10);
    L48:
        r0.label = 2;
        if (DelayKt.delay(100, r0) != r2) goto L52;
        return r2;
    L16:
        ResultKt.throwOnFailure(r10);
        FLogger r16 = FLogger.a;
        String r4 = r8.c();
        StringBuilder r5 = new StringBuilder("Really play tone ! wakeupSource ");
        r5.append(com.obric.assistant.session.lifecycle.a.b());
        r5.append("  sessionName ");
        ISessionMaintaining r6 = j.b();
        String r7 = "";
        if (r6 == null) goto L20;
        String r17 = r6.o();
        if (r17 == null) goto L20;
    L21:
        r5.append(r17);
        r5.append(" , NOTE: if it is BREATH , will not play !");
        r16.w(r4, r5.toString());
        if (com.obric.assistant.feedback.a.a() == false) goto L30;
        String r18 = r8.c();
        StringBuilder r19 = new StringBuilder("skip main wakeup feedback: reason=child_already_played requestFrom=");
        r19.append(com.obric.assistant.session.lifecycle.a.b());
        r19.append(" sessionName=");
        ISessionMaintaining r20 = j.b();
        if (r20 == null) goto L29;
        String r21 = r20.o();
        if (r21 == null) goto L29;
        r7 = r21;
    L29:
        r19.append(r7);
        r16.i(r18, r19.toString());
        return Unit.INSTANCE;
    L30:
        boolean r22 = false;
        if (Intrinsics.areEqual(com.obric.assistant.session.lifecycle.a.b(), IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == true) goto L33;
    L35:
        boolean r23 = false;
    L36:
        boolean r24 = Intrinsics.areEqual(com.obric.assistant.session.lifecycle.a.b(), IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC);
        IDoraOperation r25 = bga.f.a();
        if (r25 == null) goto L40;
        r22 = r25.c();
    L40:
        if (ILoginService.a.getAccountInfo().a == false) goto L52;
        if (r22 == true) goto L52;
        if (r23 == true) goto L52;
        if (r24 == false) goto L45;
        SoundEffectHelper.INSTANCE.playRelease();
        goto L48
    L45:
        WakeupSoundPlayer r26 = WakeupSoundPlayer.a;
        r0.label = 1;
        if (r26.b(r0) != r2) goto L48;
        return r2;
    L33:
        if (Intrinsics.areEqual(j.c(), "BREATH") == false) goto L35;
        r23 = true;
    L20:
        r17 = "";
    L7:
        r0 = new BluetoothSoundEffectPlayer$playToneInternal$1(r8, r9);
        goto L8
    }

    public final void e(boolean r8, boolean r9) {
        if (Intrinsics.areEqual(j.c(), "BREATH") == true) goto L7;
        if (r8 == false) goto L7;
        FLogger.a.w(c(), "playTone! WILL NOT playing , Because the bluetooth sco will connecting ....thus waiting for sco connected ...");
        d = true;
        return;
    L7:
        FLogger.a.w(c(), "playTone NOW  ♫♫♫");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new BluetoothSoundEffectPlayer$playTone$1(r9, null), 3, null);
        d = false;
    }
}
