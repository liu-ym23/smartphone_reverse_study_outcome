package com.obric.assistant.ipc;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.larus.account.base.api.ILoginService;
import com.larus.bmhome.chat.component.bottom.core.speaker.l;
import com.larus.bmhome.chat.component.bottom.core.speaker.m;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aiagent.assistant.idl.IFlowSyncDataResultIDL;
import com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDLSPI;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.audio.service.IObricTtsService;
import com.obric.assistant.automic.IObricAutoMicService;
import com.obric.assistant.chat.IObricChatContextService;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.device.obricDeviceManagerDelegate;
import com.obric.assistant.session.singleton.d;
import com.obric.assistant.special_input.ObricSpecialInputServiceDelegate;
import com.obric.assistant.spi.audio.IObricContinuousTalkService;
import com.obric.assistant.state.api.multitask.ObricInteractionProjectionDelegate;
import com.obric.assistant.state.api.v2.ObricStateService;
import com.obric.assistant.voice.ContentScene;
import com.obric.audio.continuous_talk.c;
import com.obric.eventkit.eventstaskmanager.ActiveAgentEvent;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import com.obric.eventkit.eventstaskmanager.AppNotification;
import com.obric.eventkit.eventstaskmanager.NotificationEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import maa.e;
import org.json.JSONObject;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u0012\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010!\u001a\u00020\u00072\u0018\u0010\"\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#H\u0016J\b\u0010%\u001a\u00020\u0010H\u0016J\f\u0010&\u001a\u00020\u0005*\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/assistant/ipc/VoiceInteractionIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowVoiceInteractionIDLSPI;", "<init>", "()V", "TAG", "", "wakeupAssistant", "", "requestFrom", "requireSyncData", "callback", "Lcom/obric/aiagent/assistant/idl/IFlowSyncDataResultIDL;", "tryOpenClickTalk", EffectConfiguration.KEY_TYPE, "", "tryInterruptAssistant", "", "event", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "tryOpenMicToRecording", "getChatVContext", "Lcom/larus/ui/arch/context/external/VContext;", "closeContinuousTalk", "replayMessageTts", "messageId", "readContent", "content", "isInRealtimeCalling", "readContentByMessage", "message", "Lcom/obric/aiagent/assistant/idl/bean/IMMessage;", "updateScreenshotForAsr", "tosKey", "updateIntentExt", "ext", "", "", "isInteractionSessionStateListening", "toLogTail", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceInteractionIDLStub implements IFlowVoiceInteractionIDLSPI {
    private final String TAG;

    public IBinder asBinder() {
        return null;
    }

    private final b getChatVContext() {
        b r0 = IObricChatContextService.a.a(ObricChatContextServiceDelegate.b);
        FLogger r1 = FLogger.a;
        String r2 = this.TAG;
        StringBuilder r3 = new StringBuilder("query chat context: available=");
        if (r0 == null) goto L5;
        boolean r4 = true;
    L6:
        r3.append(r4);
        r1.i(r2, r3.toString());
        return r0;
    L5:
        r4 = false;
        goto L6
    }

    public boolean isInRealtimeCalling() {
        return ObricStateService.a.a();
    }

    public boolean isInteractionSessionStateListening() {
        boolean r0 = ObricInteractionProjectionDelegate.b.a(null).b();
        FLogger.a.i(this.TAG, "isInteractionSessionStateListening = " + r0);
        return r0;
    }

    public VoiceInteractionIDLStub() {
        this.TAG = "VoiceInteractionIDLStub";
    }

    public boolean closeContinuousTalk() {
        b r0 = getChatVContext();
        c r1 = null;
        if (r0 == null) goto L5;
        com.obric.audio.continuous_talk.b r2 = (com.obric.audio.continuous_talk.b) r0.getAbility(com.obric.audio.continuous_talk.b.class);
    L6:
        if (r0 == null) goto L8;
        r1 = (c) r0.getAbility(c.class);
    L8:
        c r3 = r1;
        IObricContinuousTalkService r4 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
        boolean r5 = false;
        if (r2 != null) goto L11;
    L13:
        boolean r6 = false;
    L14:
        if (r4 != null) goto L16;
    L18:
        boolean r10 = false;
    L19:
        FLogger r7 = FLogger.a;
        String r8 = this.TAG;
        StringBuilder r9 = new StringBuilder("closeContinuousTalk, isSpeaking=");
        r9.append(r6);
        r9.append(", isActive=");
        r9.append(r10);
        r9.append(", ctrlAbilityAvailable=");
        if (r3 == null) goto L22;
        boolean r11 = true;
    L23:
        r9.append(r11);
        r7.i(r8, r9.toString());
        if (r6 == false) goto L27;
        if (r3 == null) goto L27;
        c.a.a(r3, null, null, true, true, 3);
    L27:
        if (r6 == true) goto L29;
        if (r10 == true) goto L29;
    L32:
        if (r4 == null) goto L37;
        if (r4.isActive() != true) goto L37;
        r5 = true;
    L37:
        return !r5;
    L29:
        if (r4 != null) goto L31;
        return false;
    L31:
        r4.c();
        goto L32
    L22:
        r11 = false;
        goto L23
    L16:
        if (r4.isActive() != true) goto L18;
        r10 = true;
        goto L19
    L11:
        if (r2.m0() != true) goto L13;
        r6 = true;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    private final String toLogTail(String r3) {
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return "";
    L10:
        return "***" + StringsKt.takeLast(r3, 4);
    L5:
        r0 = false;
        goto L6
    }

    public void readContent(String r3) {
        Intrinsics.checkNotNullParameter(r3, "content");
        IObricTtsService r0 = (IObricTtsService) ServiceManager.get().getService(IObricTtsService.class);
        if (r0 == null) goto L6;
        r0.c(r3, 0);
        return;
    }

    public void readContentByMessage(IMMessage r49) {
        FLogger.a.i(this.TAG, "readContentByMessage, " + r49);
        if (r49 == null) goto L8;
        IObricTtsService r1 = (IObricTtsService) ServiceManager.get().getService(IObricTtsService.class);
        if (r1 == null) goto L9;
        String r4 = r49.getConversationId();
        String r19 = r49.getMessageId();
        String r18 = r49.getLocalMessageId();
        r1.e(new Message(r4, null, null, 0, 21, null, 0, false, null, r49.getContent(), null, null, null, r49.getExt(), r18, r19, 0, 0, false, null, null, null, null, null, null, 0, false, 0, r49.getReplyId(), null, false, null, null, 0, null, null, null, -268493330, 31, null), 0);
        return;
    L9:
        return;
    }

    public void replayMessageTts(String r3) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        IObricTtsService r0 = (IObricTtsService) ServiceManager.get().getService(IObricTtsService.class);
        if (r0 == null) goto L6;
        r0.b(r3, 0);
        return;
    }

    public void requireSyncData(IFlowSyncDataResultIDL r7) {
        String r0 = ILoginService.a.getAccountInfo().c;
        String r1 = obricDeviceManagerDelegate.b.getUuid();
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L8:
        String r2 = "";
    L9:
        int r3 = sna.f.a("voice_assistant_wakeup_status", -100);
        FLogger.a.i(this.TAG, "requireSyncData, uuid: " + toLogTail(r2) + ", wakeupStatus: " + r3);
        if (r7 == null) goto L13;
        r7.onSyncData(com.larus.utils.f.c(new Pair[]{TuplesKt.to("uuid", r2), TuplesKt.to("wakeup_status", Integer.valueOf(r3))}));
        return;
    L13:
        return;
    L5:
        if (TextUtils.isEmpty(r1) == true) goto L8;
        r2 = r0 + '-' + r1;
        goto L9
    }

    public boolean tryInterruptAssistant(AppEvent r5) {
        FLogger r0 = FLogger.a;
        r0.i(this.TAG, "tryInterruptAssistant, " + r5);
        if ((r5 instanceof NotificationEvent) == false) goto L9;
        r0.i(this.TAG, "tryInterruptAssistant, " + r5);
        IObricAutoMicService.a.getClass();
        IObricAutoMicService r1 = IObricAutoMicService.a.a();
        if (r1 == null) goto L11;
        r1.e(ContentScene.PRIORITY_NOTIFICATION, r5);
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    public void tryOpenClickTalk(int r5) {
        if (r5 != 4) goto L5;
        FLogger.a.i(this.TAG, "closeSpecialInputBeforeMicOn");
        ObricSpecialInputServiceDelegate.b.d();
    L5:
        b r0 = getChatVContext();
        if (r0 == null) goto L8;
        c r2 = (c) r0.getAbility(c.class);
    L9:
        if (r2 == null) goto L13;
        boolean r3 = true;
        if (r2.qO(r5) != true) goto L13;
    L14:
        if (r3 == false) goto L21;
        if (r0 == null) goto L17;
        e r1 = (e) r0.getAbility(e.class);
    L18:
        if (r1 == null) goto L22;
        e.a.b(r1, r5, null, 6);
        return;
    L22:
        return;
    L17:
        r1 = null;
        goto L18
    L21:
        return;
    L13:
        r3 = false;
        goto L14
    L8:
        r2 = null;
        goto L9
    }

    public boolean tryOpenMicToRecording(AppEvent r10) {
        FLogger r0 = FLogger.a;
        r0.i(this.TAG, "tryOpenMicToRecording, " + r10);
        if ((r10 instanceof NotificationEvent) == false) goto L14;
        AppNotification[] r1 = ((NotificationEvent) r10).getNotifications();
        String r2 = "notifications:";
        if (r1 == null) goto L9;
        int r5 = r1.length;
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L9;
        AppNotification r7 = r1[r6];
        r2 = r2 + r7.getTime() + ' ' + r7.getContent() + ", " + r7.getAppName();
        r6 = r6 + 1;
    L9:
        FLogger.a.i(this.TAG, "tryOpenMicToRecording, " + r2);
        IObricAutoMicService.a.getClass();
        IObricAutoMicService r3 = IObricAutoMicService.a.a();
        if (r3 != null) goto L12;
        return false;
    L12:
        return r3.d(ContentScene.PRIORITY_NOTIFICATION, true, r10);
    L14:
        if ((r10 instanceof ActiveAgentEvent) == false) goto L21;
        r0.i(this.TAG, "tryOpenMicToRecording, ActiveAgentEvent " + r10);
        IObricAutoMicService.a.getClass();
        IObricAutoMicService r4 = IObricAutoMicService.a.a();
        if (r4 != null) goto L18;
        return false;
    L18:
        return r4.d(ContentScene.AI_ACTIVE_ASK, true, r10);
    L21:
        return false;
    }

    public void updateIntentExt(Map<Object, Object> r6) {
        b r0 = getChatVContext();
        Map r1 = null;
        if (r0 == null) goto L5;
        com.obric.audio.continuous_talk.b r2 = (com.obric.audio.continuous_talk.b) r0.getAbility(com.obric.audio.continuous_talk.b.class);
    L6:
        boolean r3 = false;
        if (r2 != null) goto L9;
    L11:
        if (r3 == false) goto L16;
        if (r6 == null) goto L14;
        r1 = o.a(r6);
    L14:
        if (r1 == null) goto L16;
        FLogger.a.i(this.TAG, "updateIntentExt continuousTalkAbility is speaking: " + r6);
        r2.updateIntentExt(o.a(r6));
        return;
    L16:
        FLogger.a.i(this.TAG, "updateIntentExt continuousTalkAbility is not speaking: " + r6);
        return;
    L9:
        if (r2.m0() != true) goto L11;
        r3 = true;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public void updateScreenshotForAsr(String r8) {
        b r0 = getChatVContext();
        l r1 = null;
        if (r0 == null) goto L5;
        e r2 = (e) r0.getAbility(e.class);
    L6:
        if (r0 == null) goto L8;
        com.obric.audio.continuous_talk.b r3 = (com.obric.audio.continuous_talk.b) r0.getAbility(com.obric.audio.continuous_talk.b.class);
    L9:
        boolean r4 = false;
        if (r3 != null) goto L12;
    L14:
        boolean r6 = false;
    L15:
        if (r6 == false) goto L17;
        r3.updateScreenshotForAsr(r8);
        return;
    L17:
        if (r2 != null) goto L19;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == false) goto L24;
        r2.updateScreenshotForAsr(r8);
        return;
    L24:
        if (r0 == null) goto L26;
        m r7 = (m) r0.getAbility(m.class);
    L27:
        if (r0 == null) goto L29;
        r1 = (l) r0.getAbility(l.class);
    L29:
        if (r7 == null) goto L46;
        if (r1 != null) goto L32;
    L34:
        boolean r9 = false;
    L35:
        if (r9 == false) goto L47;
        if (r8 != null) goto L38;
    L39:
        r4 = true;
    L40:
        if (r4 == false) goto L42;
        return;
    L42:
        JSONObject r10 = new JSONObject();
        r10.put("image_url", r8);
        r10.put("update_nonstream_context_finish", true);
        JSONObject r11 = new JSONObject();
        r11.put("context_data", r10);
        String r12 = r11.toString();
        FLogger.a.d(this.TAG, "updateScreenshotForAsr, contextDataStr = " + r12);
        r7.updateScreenshotForAsr(r12);
        return;
    L38:
        if (r8.length() != 0) goto L40;
    L47:
        return;
    L32:
        if (r1.m0() != true) goto L34;
        r9 = true;
        goto L35
    L46:
        return;
    L26:
        r7 = null;
        goto L27
    L19:
        if (r2.x3() != true) goto L21;
        r5 = true;
        goto L22
    L12:
        if (r3.m0() != true) goto L14;
        r6 = true;
        goto L15
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public void wakeupAssistant(String r5) {
        d.a.getClass();
        FLogger r0 = FLogger.a;
        String r1 = d.b;
        r0.i(r1, "wakeupAssistant from " + r5);
    L17:
        th = move-exception;
        FLogger.a.e(d.b, "wakeupAssistant exception", th);
        return;
    L4:
        if (Intrinsics.areEqual("WAKEUP_SOURCE_ON_START_UP", r5) == true) goto L6;
    L8:
        Bundle r2 = new Bundle();     // Catch: Throwable -> L17
        if (o0.d(r5) == false) goto L12;
        r2.putString("REQUEST_FROM", r5);     // Catch: Throwable -> L17
    L12:
        if (Build.VERSION.SDK_INT < 23) goto L22;
        Method r6 = d.e();     // Catch: Throwable -> L17
        if (r6 == null) goto L23;
        r6.invoke(d.d(), new Object[]{r2, 8, null, null});     // Catch: Throwable -> L17
        return;
    L23:
        return;
    L22:
        return;
    L6:
        if (d.b() != null) goto L8;
        r0.w(r1, "VoiceInteractionService inactive, not wakeup assistant on startup");     // Catch: Throwable -> L17
    }
}
