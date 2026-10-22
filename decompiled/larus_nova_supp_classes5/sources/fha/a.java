package fha;

import androidx.lifecycle.LiveData;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.bmhome.utils.i;
import com.larus.im.bean.message.Message;
import com.larus.im.d;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.AssistantAliveReason;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandPriority;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.assistant.state.api.v2.core.bean.ObricTtsInfo;
import com.obric.assistant.state.impl.v2.core.ObricStateDispatcher;
import com.obric.assistant.state.impl.v2.core.g;
import com.obric.assistant.state.impl.v2.power.ObricPowerManager;
import com.obric.assistant.state.impl.v2.utils.e;
import com.obric.assistant.state.impl.v2.utils.f;
import com.obric.assistant.state.impl.v2.wakelock.ObricWakelockManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import p68.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public final Object a;
    public ObricTtsInfo b;
    public PlayStateEnum c;
    public final Map<String, Object> d;
    public final b e;
    public final C0016a f;

    /* JADX INFO: renamed from: fha.a$a, reason: collision with other inner class name */
    public static final class C0016a implements o78.b {
        public final /* synthetic */ a a;

        public C0016a(a r1) {
            this.a = r1;
        }

        public final void c(String r1, Map r2) {
            o78.b.a.a(r1);
        }

        public final void a(String r8, GlobalAudioStateEnum r9, Map<String, String> r10) {
            Intrinsics.checkNotNullParameter(r8, "scene");
            Intrinsics.checkNotNullParameter(r9, "playbackState");
            FLogger r0 = FLogger.a;
            this.a.getClass();
            r0.i("[AudioPlayStateHandler]", "onPlaybackStateChanged: scene=" + r8 + ", playbackState=" + r9 + ", bizExtra=" + r10);
            boolean r1 = true;
            if (a.a[r9.ordinal()] != 1) goto L11;
            if (f.a == true) goto L8;
            CoroutineScope r11 = ObricPowerManager.a;
            ObricPowerManager.c(AssistantAliveReason.GLOBAL_AUDIO_IN_PROGRESS);
        L8:
            if (Intrinsics.areEqual(r8, "tts_im") == false) goto L56;
            a.a(this.a, r10);
            return;
        L56:
            return;
        L11:
            if (Intrinsics.areEqual(r8, "tts_im") == false) goto L52;
            a r12 = this.a;
            r12.getClass();
            String r4 = null;
            if (r10 == null) goto L22;
            String r5 = r10.get("message_id");
            if (r5 == null) goto L22;
            if (r5.length() <= 0) goto L19;
            boolean r6 = true;
        L20:
            if (r6 == false) goto L22;
        L23:
            if (r10 == null) goto L32;
            String r13 = r10.get("conversation_id");
            if (r13 == null) goto L32;
            if (r13.length() > 0) goto L30;
            r1 = false;
        L30:
            if (r1 == false) goto L32;
            r4 = r13;
        L32:
            r0.i("[AudioPlayStateHandler]", "handleTtsFinishFromBizExtra, messageId=" + r5 + ", conversationId=" + r4);
            if (r5 == null) goto L52;
            Object r14 = r12.a;
            monitor-enter(r14);
        L48:
            th = move-exception;
            throw th;
        L38:
            if (Intrinsics.areEqual(r12.b.getMsgId(), r5) == false) goto L40;
            r12.d(PlayStateEnum.PLAY_STATE_STOPPED);     // Catch: Throwable -> L48
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L48
            monitor-exit(r14);
            goto L52
        L40:
            if (r12.d.remove(r5) == null) goto L42;
            r0.i("[AudioPlayStateHandler]", "cancelPendingTtsStartLocked, messageId=".concat(r5));     // Catch: Throwable -> L48
        L42:
            r0.i("[AudioPlayStateHandler]", "handleTtsFinishFromBizExtra ignored, messageId=" + r5 + " differs from current msgId=" + r12.b.getMsgId());     // Catch: Throwable -> L48
            monitor-exit(r14);
            goto L52
        L19:
            r6 = false;
        L22:
            r5 = null;
        L52:
            if (f.a == true) goto L58;
            CoroutineScope r16 = ObricPowerManager.a;
            ObricPowerManager.f(AssistantAliveReason.GLOBAL_AUDIO_IN_PROGRESS);
            return;
        }

        public final void b(String r5, Integer r6, Integer r7) {
            Intrinsics.checkNotNullParameter(r5, "scene");
            FLogger r0 = FLogger.a;
            this.a.getClass();
            r0.i("[AudioPlayStateHandler]", "onError: scene=" + r5 + ", code=" + r6 + ", internalCode=" + r7);
            if (Intrinsics.areEqual(r5, "tts_im") == false) goto L13;
            a r8 = this.a;
            Object r9 = r8.a;
            monitor-enter(r9);
            r0.i("[AudioPlayStateHandler]", "handleTtsFailed, currentTtsInfo: " + r8.b);     // Catch: Throwable -> L9
            r8.d(PlayStateEnum.PLAY_STATE_FAIL);     // Catch: Throwable -> L9
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L9
            monitor-exit(r9);
        L9:
            th = move-exception;
            throw th;
        L13:
            if (f.a == true) goto L18;
            CoroutineScope r11 = ObricPowerManager.a;
            ObricPowerManager.f(AssistantAliveReason.GLOBAL_AUDIO_IN_PROGRESS);
            return;
        }

        public final void d(String r2, String r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            Intrinsics.checkNotNullParameter(r3, "uniId");
            FLogger r5 = FLogger.a;
            this.a.getClass();
            r5.i("[AudioPlayStateHandler]", "onPlayTriggered: scene=" + r2);
        }
    }

    public static final class b implements c {
        public final /* synthetic */ a a;

        public final void c(int r1) {
        }

        public final void e(String r1) {
        }

        public final void f(byte[] r1) {
        }

        public b(a r1) {
            this.a = r1;
        }

        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "meetingId");
            Intrinsics.checkNotNullParameter(r3, "meetingId");
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.d("[AudioPlayStateHandler]", "IRecordingStatusListener onRecordingStart");
            if (f.a == true) goto L6;
            CoroutineScope r5 = ObricPowerManager.a;
            ObricPowerManager.c(AssistantAliveReason.AI_NOTE_IN_PROGRESS);
            return;
        }

        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "meetingId");
        }

        public final void d(int r2, String r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.d("[AudioPlayStateHandler]", "IRecordingStatusListener onRecordingStop");
            if (f.a == true) goto L6;
            CoroutineScope r5 = ObricPowerManager.a;
            ObricPowerManager.f(AssistantAliveReason.AI_NOTE_IN_PROGRESS);
            return;
        }
    }

    public final void e() {
        String r0 = this.b.getCvsId();
        if (r0 == null) goto L16;
        FLogger.a.i("[AudioPlayStateHandler]", "dispatchTtsPlayingLocked, cvsId: ".concat(r0));
        if (h(this.b) == true) goto L8;
        hha.a r1 = g.a;
        ObricIslandStateType r2 = ObricIslandStateType.TTS_PLAYING;
        ObricInteractionScene r4 = this.b.getScene();
        ObricIslandPriority r5 = ObricIslandPriority.LOW;
        String r6 = this.b.getMsgId();
        LinkedHashMap r8 = new LinkedHashMap();
        r8.putAll(this.b.getExt());
        Unit r3 = Unit.INSTANCE;
        g.a(new ObricState(r2, r0, r4, r5, r6, null, r8, 32, null));
    L8:
        if (i.g(r0) == true) goto L10;
        return;
    L10:
        if (f.a == true) goto L12;
        ObricWakelockManager r7 = ObricWakelockManager.a;
        ObricWakelockManager.LockReason r9 = ObricWakelockManager.LockReason.TTS_PLAYING;
        r7.getClass();
        ObricWakelockManager.a(r9);
        CoroutineScope r10 = ObricPowerManager.a;
        ObricPowerManager.c(AssistantAliveReason.MSG_TTS_IN_PROGRESS);
    L12:
        PlayStateEnum r11 = this.c;
        PlayStateEnum r12 = PlayStateEnum.PLAY_STATE_PLAYING;
        if (r11 == r12) goto L18;
        ObricStateDispatcher.a.b(this.b, r12.getState());
        this.c = r12;
        return;
    L18:
        return;
    }

    public final void f() {
        String r0 = this.b.getCvsId();
        if (r0 != null) goto L5;
        return;
    L5:
        if (i.g(r0) == false) goto L9;
        PlayStateEnum r1 = PlayStateEnum.PLAY_STATE_PREPARE;
        this.c = r1;
        ObricStateDispatcher.a.b(this.b, r1.getState());
        return;
    }

    public a() {
        this.a = new Object();
        this.b = new ObricTtsInfo(null, null, null, null, null, 28, null);
        this.c = PlayStateEnum.PLAY_STATE_STOPPED;
        this.d = new LinkedHashMap();
        this.e = new b(this);
        this.f = new C0016a(this);
    }

    public static boolean h(ObricTtsInfo r5) {
        Message r0 = r5.getMessage();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L17;
        Message r3 = r5.getMessage();
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L17;
        r1 = true;
        goto L17
    L12:
        if (com.obric.assistant.oauto.f.c(r3) == true) goto L14;
        r4 = true;
    L17:
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("needBlockTtsState, ret: ");
        r7.append(r1);
        r7.append(", ttsInfo: ");
        r7.append(r5);
        r7.append(", isComplexTaskMessage = ");
        Message r8 = r5.getMessage();
        Boolean r9 = null;
        if (r8 == null) goto L20;
        Boolean r10 = Boolean.valueOf(e.a(r8));
    L21:
        r7.append(r10);
        r7.append(", isComplexTaskSummary = ");
        Message r11 = r5.getMessage();
        if (r11 == null) goto L24;
        r9 = Boolean.valueOf(com.obric.assistant.oauto.f.c(r11));
    L24:
        r7.append(r9);
        r6.d("[AudioPlayStateHandler]", r7.toString());
        return r1;
    L20:
        r10 = null;
        goto L21
    L5:
        if (e.a(r0) != true) goto L7;
        r2 = true;
        goto L8
    }

    public static String i(Message r1) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(String.valueOf(r1.getExt()));     // Catch: Throwable -> L4
    L6:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L11;
        r2 = "ext_to_string_failed:".concat(r3.getClass().getSimpleName());
    L11:
        return (String) r2;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final void b(String r6) {
        Iterator r0 = ((LinkedHashMap) this.d).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = (String) ((Map.Entry) r0.next()).getKey();
        if (Intrinsics.areEqual(r1, r6) == true) goto L4;
        r0.remove();
        FLogger.a.i("[AudioPlayStateHandler]", "cancelOtherPendingTtsStartsLocked, messageId=" + r6 + ", pendingMsgId=" + r1);
        goto L4
    }

    public final void d(PlayStateEnum r14) {
        String r0 = this.b.getCvsId();
        if (r0 == null) goto L15;
        FLogger.a.i("[AudioPlayStateHandler]", "dispatchTtsEndLocked, cvsId: ".concat(r0));
        if (h(this.b) == true) goto L8;
        hha.a r1 = g.a;
        ObricIslandStateType r2 = ObricIslandStateType.TTS_END;
        ObricInteractionScene r4 = this.b.getScene();
        ObricIslandPriority r5 = ObricIslandPriority.LOW;
        String r6 = this.b.getMsgId();
        LinkedHashMap r8 = new LinkedHashMap();
        r8.putAll(this.b.getExt());
        Unit r3 = Unit.INSTANCE;
        g.a(new ObricState(r2, r0, r4, r5, r6, null, r8, 32, null));
    L8:
        if (i.g(r0) == false) goto L15;
        if (this.c == r14) goto L13;
        ObricStateDispatcher.a.b(this.b, r14.getState());
        this.c = r14;
    L13:
        if (f.a == true) goto L15;
        CoroutineScope r7 = ObricPowerManager.a;
        ObricPowerManager.f(AssistantAliveReason.MSG_TTS_IN_PROGRESS);
        ObricWakelockManager.d(ObricWakelockManager.a, ObricWakelockManager.LockReason.TTS_PLAYING);
    L15:
        FLogger.a.i("[AudioPlayStateHandler]", "reset currentTtsInfo, endState: " + r14 + ", currentTtsInfo: " + this.b);
        this.b = new ObricTtsInfo(null, null, null, null, null, 28, null);
    }

    public final void g(String r13) {
        ObricTtsInfo r0 = this.b;
        String r11 = r0.getCvsId();
        if (r11 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r0.getMsgId(), r13) == false) goto L9;
        return;
    L9:
        if (h(r0) == false) goto L11;
        return;
    L11:
        FLogger.a.i("[AudioPlayStateHandler]", "finishPreviousTtsIfNeeded, sending TTS_END for previous tts: " + r0 + ", newMsgId: " + r13);
        hha.a r14 = g.a;
        ObricIslandStateType r2 = ObricIslandStateType.TTS_END;
        ObricInteractionScene r4 = r0.getScene();
        ObricIslandPriority r5 = ObricIslandPriority.LOW;
        String r6 = r0.getMsgId();
        LinkedHashMap r8 = new LinkedHashMap();
        r8.putAll(r0.getExt());
        Unit r15 = Unit.INSTANCE;
        g.a(new ObricState(r2, r11, r4, r5, r6, null, r8, 32, null));
        if (i.g(r11) == false) goto L20;
        PlayStateEnum r16 = this.c;
        PlayStateEnum r1 = PlayStateEnum.PLAY_STATE_STOPPED;
        if (r16 == r1) goto L17;
        ObricStateDispatcher.a.b(r0, r1.getState());
        this.c = r1;
    L17:
        if (f.a == true) goto L21;
        CoroutineScope r17 = ObricPowerManager.a;
        ObricPowerManager.f(AssistantAliveReason.MSG_TTS_IN_PROGRESS);
        return;
    L21:
        return;
    }

    public final void j(String r10) {
        IAuthModelService r0 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r0 == null) goto L9;
        LiveData r1 = r0.y();
        if (r1 == null) goto L9;
        wc9.e r2 = (wc9.e) r1.getValue();
        if (r2 == null) goto L9;
        String r3 = r2.a;
    L10:
        g(r10);
        this.b = new ObricTtsInfo(r3, r10, ObricInteractionScene.DEFAULT, null, null, 24, null);
        FLogger.a.i("[AudioPlayStateHandler]", "setTtsStartForUnknownMsg, msgId: " + r10 + ", " + this.b);
        f();
        e();
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final void k(Message r12) {
        FLogger r0 = FLogger.a;
        r0.i("[AudioPlayStateHandler]", "setTtsStart, msgId: " + r12.getMessageId() + ", localMsgId: " + r12.getLocalMessageId() + ", content: " + r12.getContent() + ", ext: " + i(r12));
        g(r12.getMessageId());
        String r5 = r12.getConversationId();
        String r6 = r12.getMessageId();
        boolean r1 = e.a(r12);
        boolean r7 = true;
        if (com.larus.im.bean.message.a.C0(r12) == true) goto L5;
    L7:
        boolean r4 = false;
    L9:
        if (com.obric.assistant.oauto.f.b(r12) == false) goto L11;
    L14:
        r0.d("[AudioPlayStateHandler]", "handleTtsSceneFromMessage, isComplexTaskMessage: " + r1 + ", isComplexTaskAskUserMessage: " + r7 + ", isDoubaoThinkingMessage: " + r4 + ", ext: " + i(r12));
        if (r1 == false) goto L18;
        ObricInteractionScene r2 = ObricInteractionScene.COMPLEX_TASK_SCENE;
    L17:
        ObricInteractionScene r8 = r2;
        LinkedHashMap r9 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Map r3 = r12.getExt();
        if (r3 == null) goto L24;
        String r10 = (String) r3.get("o_is_mic_on");
    L26:
        if (Intrinsics.areEqual(r10, "1") == false) goto L28;
        r9.put("is_from_continuous_intents", "1");
    L28:
        Unit r11 = Unit.INSTANCE;
        this.b = new ObricTtsInfo(r5, r6, r8, r12, r9);
        f();
        e();
        return;
    L24:
        r10 = null;
        goto L26
    L18:
        if (r4 == false) goto L20;
        r2 = ObricInteractionScene.DEEP_THINK_SCENE;
        goto L17
    L20:
        r2 = ObricInteractionScene.DEFAULT;
        goto L17
    L11:
        if (Intrinsics.areEqual(r12.getMessageId(), "unknown") == true) goto L14;
        r7 = false;
        goto L14
    L5:
        if (e.a(r12) == true) goto L7;
        r4 = true;
        goto L9
    }

    public static final void a(a r6, Map r7) {
        r6.getClass();
        boolean r1 = true;
        String r3 = null;
        if (r7 == null) goto L12;
        String r4 = (String) r7.get("message_id");
        if (r4 == null) goto L12;
        if (r4.length() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
    L13:
        if (r7 == null) goto L22;
        String r8 = (String) r7.get("conversation_id");
        if (r8 == null) goto L22;
        if (r8.length() > 0) goto L20;
        r1 = false;
    L20:
        if (r1 == false) goto L22;
        r3 = r8;
    L22:
        FLogger r9 = FLogger.a;
        r9.i("[AudioPlayStateHandler]", "handleTtsStartFromBizExtra, messageId=" + r4 + ", conversationId=" + r3);
        if (r4 == null) goto L50;
        Object r2 = r6.a;
        monitor-enter(r2);
        Object r10 = new Object();     // Catch: Throwable -> L43
        r6.b(r4);     // Catch: Throwable -> L43
        r6.d.put(r4, r10);     // Catch: Throwable -> L43
        monitor-exit(r2);
        Object r11 = r6.a;
        monitor-enter(r11);
    L40:
        th = move-exception;
        throw th;
    L32:
        if (r6.b.getMsgId() != null) goto L34;
    L36:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L40
        monitor-exit(r11);
        d.e().m(r4, new fha.b(r6, r4, r10));
        return;
    L34:
        if (Intrinsics.areEqual(r6.b.getMsgId(), r4) == true) goto L36;
        r9.i("[AudioPlayStateHandler]", "handleTtsStartFromBizExtra, new messageId=" + r4 + " differs from current msgId=" + r6.b.getMsgId() + ", dispatching end for current");     // Catch: Throwable -> L40
        r6.d(PlayStateEnum.PLAY_STATE_STOPPED);     // Catch: Throwable -> L40
    L43:
        th = move-exception;
        throw th;
    L50:
        return;
    L9:
        r5 = false;
    L12:
        r4 = null;
        goto L13
    }

    public final boolean c(String r3, Object r4) {
        if (((LinkedHashMap) this.d).get(r3) == r4) goto L6;
        FLogger.a.i("[AudioPlayStateHandler]", "consumePendingTtsStartLocked ignored, messageId=" + r3);
        return false;
    L6:
        this.d.remove(r3);
        return true;
    }
}
