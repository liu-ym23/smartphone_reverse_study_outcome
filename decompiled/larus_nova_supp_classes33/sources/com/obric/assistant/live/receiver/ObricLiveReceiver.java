package com.obric.assistant.live.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationManagerCompat;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.live.api.j;
import com.obric.assistant.settings.LockedUseAuthSettingItem;
import com.obric.assistant.settings.experience.ObricUserExperiencePlanActivity;
import com.obric.assistant.spi.keyguard.IKeyguardService$a;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.t1;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0014\u0010\f\u001a\u00020\r*\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/live/receiver/ObricLiveReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "context", "Landroid/content/Context;", "onReceive", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "markLaunchMethodFromIntent", "openSidecarAuthorizeActivity", "toObricStateAction", "Lcom/obric/assistant/live/oenum/ObricStateAction;", "liveStateCode", "", "printIntentExtra", "collapseNotificationPanelIfPossible", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLiveReceiver extends BroadcastReceiver {
    public static final CoroutineScope b = null;
    public static final CoroutineScope c = null;
    public static final Channel<rea.a> d = null;
    public Context a;

    public static final class a {
        public static boolean b() {
            boolean r0 = t1.a.i();
            boolean r1 = LockedUseAuthSettingItem.AUTO_GUI.isEnabled();
            ObricFloatChatPageData.a r2 = ObricFloatChatPageData.Companion;
            ObricFloatChatPageState r3 = (ObricFloatChatPageState) waa.a.b.getValue();
            r2.getClass();
            boolean r4 = r3 instanceof vda.d;
            boolean r5 = j.a.c(ObricInteractionScene.COMPLEX_TASK_SCENE);
            FLogger.a.i("ObricLiveReceiver", "shouldSkipComplexTaskSystemAuth: isCreateWhenDeviceLocked=" + r5 + ", isLockedScreenUseEnabled=" + r0 + ", isAutoGuiAllowedOnLockScreen=" + r1 + ", isFullScreen=" + r4);
            if (r0 == false) goto L8;
            if (r1 == false) goto L8;
            if (r4 == true) goto L8;
            if (r5 == false) goto L8;
            return true;
        L8:
            return false;
        }

        public a() {
        }

        public static final void a(Intent r12, String r13, Function0 r14) {
            CoroutineScope r0 = ObricLiveReceiver.b;
            if (r12.getBooleanExtra("is_complex_task_scene", false) == true) goto L5;
            FLogger.a.i("ObricLiveReceiver", "handleComplexTaskActionWithKeyguard: skip auth, action=" + r13 + ", isComplexTaskScene=" + r12.getBooleanExtra("is_complex_task_scene", false));
            r14.invoke();
            return;
        L5:
            boolean r1 = IKeyguardStateKt.getKeyguardState().isDeviceLocked();
            FLogger r2 = FLogger.a;
            r2.i("ObricLiveReceiver", "shouldRequestComplexTaskSystemAuth: isDeviceLocked=" + r1);
            if (r1 == true) goto L9;
            IKeyguardService$a.a(KeyguardService.a, new f(r13, r1, r14), false, false, false, false, null, 62);
            return;
        L9:
            if (b() == false) goto L11;
            r14.invoke();
            return;
        L11:
            j.a.i();
            r2.i("ObricLiveReceiver", "handleComplexTaskActionWithKeyguard: requestDismissKeyguard, action=".concat(r13));
            KeyguardService r4 = KeyguardService.a;
            g r5 = new g(r13, r14);
            sea.b.a.getClass();
            IKeyguardService$a.a(r4, r5, false, false, false, false, sea.b.d(r12), 30);
        }
    }

    static {
        new a();
        b = CoroutineScopeKt.CoroutineScope(w1.a(1, "obricStateActionSendScope").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        CoroutineScope r3 = CoroutineScopeKt.CoroutineScope(w1.a(1, "obricStateActionReceiveScope").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        c = r3;
        d = ChannelKt.Channel$default(0, null, null, 7, null);
        FLogger.a.i("ObricLiveReceiver", "init");
        BuildersKt.launch$default(r3, null, null, new ObricLiveReceiver$Companion$1(null), 3, null);
    }

    public ObricLiveReceiver() {
    }

    /* JADX WARN: Type inference failed for: r2v16, types: [com.obric.assistant.live.receiver.c, kotlin.jvm.functions.Function0] */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context r17, final Intent r18) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, MemorySourceLinkType.INTENT);
        if (this.a != null) goto L5;
        this.a = r17;
    L5:
        FLogger r3 = FLogger.a;
        r3.i("ObricLiveReceiver", "receive intent " + r18);
        String r4 = r18.getAction();
        if (r4 == null) goto L27;
        if (r4.hashCode() != 1811362639) goto L27;
        if (r4.equals("com.obric.assistant.notification.action.OPEN_VOICE_WAKEUP_IMPROVE_SETTINGS") == false) goto L27;
        com.obric.assistant.reporter.b.a("notification_center", null, 2);
        NotificationManagerCompat.from(r17).cancel(23070101);
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L15;
    L24:
        Intent r0 = new Intent(r17, ObricUserExperiencePlanActivity.class);
        r0.putExtra("extra_highlight_item_id", "voice_wakeup_audio_upload");
        r0.addFlags(872415232);
        r17.startActivity(r0);
        return;
    L15:
        if (ObricLiveServiceDelegate.b.a() == false) goto L24;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
        r3.i("ObricLiveReceiver", "collapseNotificationPanelIfPossible");     // Catch: Throwable -> L19
        j.a.collapseNotificationPanel();     // Catch: Throwable -> L19
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r5 = Result.exceptionOrNull-impl(r2);
        if (r5 == null) goto L24;
        FLogger.a.i("ObricLiveReceiver", "collapseNotificationPanelIfPossible failed, " + r5);
    L19:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
    L27:
        if (Intrinsics.areEqual(r18.getAction(), "com.obric.assistant.obric.live.pending.action") == false) goto L127;
        String r7 = r18.getStringExtra(WindowEvent.Params.LAUNCH_METHOD);
        if (r7 != null) goto L31;
    L36:
        Bundle r8 = r18.getExtras();
        if (r8 == null) goto L42;
        Iterator<String> r9 = r8.keySet().iterator();
    L40:
        if (r9.hasNext() == false) goto L43;
        String r10 = r9.next();
        Object r11 = r8.get(r10);
        FLogger.a.i("ObricLiveReceiver", "Key: " + r10 + ", Value: " + r11);
    L43:
        Bundle r12 = r18.getExtras();
        int r13 = -1;
        if (r12 == null) goto L46;
        r13 = r12.getInt("live_state", -1);
    L46:
        FLogger r14 = FLogger.a;
        r14.i("ObricLiveReceiver", "receive intent action " + r18.getAction() + " with liveState " + r13);
        Integer r15 = Integer.valueOf(r13);
        int r16 = r15.intValue();
        if (r16 != (-100)) goto L49;
    L55:
        boolean r19 = true;
    L56:
        if (r19 == true) goto L59;
        r15 = null;
    L59:
        if (r15 == null) goto L107;
        final int r20 = r15.intValue();
        if (r20 == (-1010)) goto L88;
        if (r20 == (-108)) goto L87;
        if (r20 == (-107)) goto L86;
        ?? r21 = new c(r20, r18);
        if (r18.getBooleanExtra("request_lock_screen_authentication", false) == true) goto L67;
        a.a(r18, "open_chat_or_virtual_screen", r21);
        return;
    L67:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == true) goto L70;
        r21.invoke();
        return;
    L70:
        if (r18.getBooleanExtra("is_complex_task_scene", false) == false) goto L75;
        if (a.b() == false) goto L75;
        r21.invoke();
        return;
    L75:
        if (r18.getBooleanExtra("is_complex_task_scene", false) == true) goto L84;
        boolean r22 = t1.a.i();
        ObricFloatChatPageData.a r23 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r24 = (ObricFloatChatPageState) waa.a.b.getValue();
        r23.getClass();
        boolean r25 = r24 instanceof vda.d;
        boolean r26 = j.a.c(ObricInteractionScene.DEFAULT);
        r14.i("ObricLiveReceiver", "shouldSkipDefaultSystemAuth: isCreateWhenDeviceLocked=" + r26 + ", isLockedScreenUseEnabled=" + r22 + ", isFullScreen=" + r25);
        if (r22 == false) goto L81;
        if (r25 == true) goto L81;
        if (r26 == false) goto L81;
        boolean r27 = true;
    L82:
        if (r27 == false) goto L84;
        r21.invoke();
        return;
    L81:
        r27 = false;
    L84:
        sea.g r28 = sea.g.a;
        sea.b.a.getClass();
        Bundle r29 = sea.b.d(r18);
        r28.getClass();
        sea.g.j(r29, r21);
        return;
    L86:
        a.a(r18, "open_virtual_screen", new com.obric.assistant.live.receiver.a(r18, r20));
        return;
    L87:
        a.a(r18, "open_sidecar_authorize", new b(r20, this, r17));
        return;
    L88:
        Bundle r30 = r18.getExtras();
        if (r30 != null) goto L91;
        return;
    L91:
        String r31 = r30.getString("content");
        if (r31 != null) goto L94;
        return;
    L94:
        String r32 = r30.getString("cvsId");
        if (r32 != null) goto L97;
        return;
    L97:
        String r33 = r30.getString("o_omni_task_id");
        if (r33 != null) goto L100;
        return;
    L100:
        String r34 = r30.getString("o_reference_msg_id");
        if (r34 != null) goto L103;
        return;
    L103:
        String r35 = r30.getString("o_complex_source_type");
        if (r35 != null) goto L106;
        return;
    L106:
        r14.d("ObricLiveReceiver", "code:" + r20 + " conversationId: " + r32);
        sea.g.a.getClass();
        sea.g.l(r32, r31, r33, r35, r34);
        return;
    L107:
        switch(r13) {
            case -1009: goto L112;
            case -1008: goto L111;
            case -1007: goto L110;
            default: goto L108;
        };
    L108:
        switch(r13) {
            case -106: goto L117;
            case -105: goto L116;
            case -104: goto L115;
            case -103: goto L114;
            case -102: goto L113;
            default: goto L109;
        };
    L109:
        rea.a r36 = new rea.a.f(r18);
    L119:
        if ((r36 instanceof rea.a.f) == false) goto L122;
        r14.i("ObricLiveReceiver", "receive intent action " + r18.getAction() + " with liveState " + r13 + ", but obricStateAction is NA");
        return;
    L122:
        BuildersKt.launch$default(b, null, null, new ObricLiveReceiver$onReceive$4$1(r36, null), 3, null);
        return;
    L113:
        r36 = new rea.a.b(r18);
        goto L119
    L114:
        r36 = new rea.a.C0069a(r18);
        goto L119
    L115:
        r36 = new rea.a.e(r18);
        goto L119
    L116:
        r36 = new rea.a.i(r18);
        goto L119
    L117:
        r36 = new rea.a.d(r18);
        goto L119
    L110:
        r36 = new rea.a.g(r18);
        goto L119
    L111:
        r36 = new rea.a.c(r18);
        goto L119
    L112:
        r36 = new rea.a.h(r18);
        goto L119
    L49:
        if (r16 == (-101)) goto L55;
        if (r16 == (-107)) goto L55;
        if (r16 == (-108)) goto L55;
        if (r16 == (-1010)) goto L55;
        r19 = false;
        goto L56
    L42:
        r3.i("ObricLiveReceiver", "Intent has no extras.");
        goto L43
    L31:
        if ((!StringsKt.isBlank(r7)) == true) goto L34;
        r7 = null;
    L34:
        if (r7 == null) goto L36;
        r3.i("ObricLiveReceiver", "markLaunchMethodFromIntent, launchMethod=".concat(r7));
        com.obric.assistant.reporter.b.a(r7, null, 6);
        goto L36
    }
}
