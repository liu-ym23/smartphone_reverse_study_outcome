package com.obric.assistant.audio;

import com.google.gson.Gson;
import com.larus.bmhome.actionbar.util.h;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.tts.ITtsReaderInterceptor;
import com.larus.tts.TtsInterceptResult;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.audio.service.IObricTtsService;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.tts.TtsSilentInterceptor;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u000e\u001a\u00020\u000b*\u00020\u0007H\u0002J\f\u0010\u000f\u001a\u00020\u000b*\u00020\tH\u0002¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/audio/ObricTtsReaderInterceptor;", "Lcom/larus/tts/ITtsReaderInterceptor;", "<init>", "()V", "intercept", "Lcom/larus/tts/TtsInterceptResult;", "message", "Lcom/larus/im/bean/message/Message;", "scene", "Lcom/larus/tts/TtsScene;", "canHandle", NameKeys.UnloadStrategy_No_Strategy, "priority", NameKeys.UnloadStrategy_No_Strategy, "notFilteredByAutoReadTts", "isManualScene", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTtsReaderInterceptor implements ITtsReaderInterceptor {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TtsScene.values().length];
            r0[TtsScene.Manual_ActionView.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[TtsScene.Manual_LongPress.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[TtsScene.Manual_Selector.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[TtsScene.Manual_Other.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public ObricTtsReaderInterceptor() {
    }

    public final int priority() {
        return 120;
    }

    public final boolean a(Message r4, TtsScene r5) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "scene");
        if (ObricTtsControlDelegate.b.e() == false) goto L5;
        FLogger.a.i("ObricTtsReaderInterceptor", "[TTS_OBRIC][JUDGE_HANDLE] is tts check scene");
        boolean r6 = true;
    L6:
        FLogger.a.i("ObricTtsReaderInterceptor", "[TTS_OBRIC][JUDGE_HANDLE] canHandle = " + r6);
        return r6;
    L5:
        r6 = false;
        goto L6
    }

    public final TtsInterceptResult b(Message r12, TtsScene r13) {
        Intrinsics.checkNotNullParameter(r12, "message");
        Intrinsics.checkNotNullParameter(r13, "scene");
        FLogger r1 = FLogger.a;
        r1.i("ObricTtsReaderInterceptor", "[TTS_OBRIC][JUDGE_INTERCEPT] message = " + r12 + ", scene = " + r13);
        int r2 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r12, "message");
        boolean r0 = com.larus.im.bean.message.a.r0(r12);
        boolean r3 = com.larus.bmhome.chat.bean.d.f0(r12);
        boolean r4 = true;
        if (r0 == true) goto L7;
        if (r3 == true) goto L7;
        boolean r6 = false;
    L8:
        if (r6 == true) goto L10;
    L15:
        String r5 = null;
        if (r13 != TtsScene.Auto_UpdateMessage) goto L18;
    L19:
        com.larus.bmhome.actionbar.model.r r7 = h.a(r12);
        if (r7 == null) goto L27;
        Integer r8 = r7.a;
        if (r8 == null) goto L27;
        if (r8.intValue() != 11) goto L27;
        boolean r9 = true;
    L28:
        if (r9 == true) goto L37;
        Map r10 = r12.getExt();
        if (r10 == null) goto L32;
        String r11 = (String) r10.get("o_did");
    L34:
        if (Intrinsics.areEqual(r11, com.larus.platform.service.o.a.getDeviceId()) == true) goto L37;
        boolean r14 = false;
    L38:
        if (r14 == false) goto L40;
    L45:
        String r15 = com.larus.im.bean.message.a.O(r12);
        if (r15 != null) goto L48;
        r15 = NameKeys.UnloadStrategy_No_Strategy;
    L48:
        String r16 = StringsKt.trim(r15).toString();
        if (StringsKt.startsWith$default(r16, "(*", false, 2, null) == true) goto L51;
    L54:
        Map r17 = r12.getExt();
        if (r17 == null) goto L57;
        String r18 = (String) r17.get("is_obric_continuous_talk");
    L59:
        if (Intrinsics.areEqual(r18, "1") == true) goto L61;
    L64:
        Map r19 = r12.getExt();
        if (r19 == null) goto L67;
        String r20 = (String) r19.get("tts_not_supported");
    L69:
        if (Intrinsics.areEqual(r20, "1") == false) goto L84;
        int r21 = b.a[r13.ordinal()];
        if (r21 == 1) goto L76;
        if (r21 == 2) goto L76;
        if (r21 == 3) goto L76;
        if (r21 == 4) goto L76;
        r4 = false;
    L76:
        if (r4 == true) goto L78;
        IObricChatService r22 = (IObricChatService) ServiceManager.get().getService(IObricChatService.class);
        if (r22 == null) goto L82;
        r22.isContLockScreenQueryReply(r12);
    L82:
        r1.e("ObricTtsReaderInterceptor", "[TTS_OBRIC][DENY] msg ext tts_not_supported is 1, deny current msg, scene=" + r13 + ", msgId=" + r12.getMessageId());
        return TtsInterceptResult.Deny;
    L78:
        return TtsInterceptResult.Pass;
    L84:
        IObricChatService.a.getClass();
        IObricChatService r23 = IObricChatService.a.a();
        Map r110 = r12.getExt();
        if (r110 == null) goto L88;
        r5 = (String) r110.get("empty_response");
    L88:
        if (Intrinsics.areEqual(r5, "1") == false) goto L91;
        r1.e("ObricTtsReaderInterceptor", "[TTS_OBRIC][DENY] empty_response is 1, deny current msg");
        return TtsInterceptResult.Deny;
    L91:
        Gson r24 = TtsSilentInterceptor.a;
        if (TtsSilentInterceptor.a.a(r12) == false) goto L103;
        int r111 = b.a[r13.ordinal()];
        if (r111 == 1) goto L99;
        if (r111 == 2) goto L99;
        if (r111 == 3) goto L99;
        if (r111 == 4) goto L99;
        boolean r112 = false;
    L100:
        if (r112 == true) goto L103;
        r1.e("ObricTtsReaderInterceptor", "[TTS_OBRIC][DENY] , msg is silent, deny current msg");
        return TtsInterceptResult.Deny;
    L99:
        r112 = true;
    L103:
        if (r23 != null) goto L105;
    L107:
        boolean r113 = false;
    L108:
        if (r113 == true) goto L110;
    L114:
        IObricTtsService r114 = (IObricTtsService) ServiceManager.get().getService(IObricTtsService.class);
        if (r114 != null) goto L117;
    L119:
        boolean r115 = false;
    L120:
        IBluetoothHeadSetAPI r25 = tha.c.a();
        if (r25 != null) goto L123;
    L125:
        boolean r26 = false;
    L126:
        if (r26 == false) goto L134;
        if (r23 != null) goto L129;
    L131:
        boolean r116 = false;
    L132:
        if (r116 == false) goto L134;
    L135:
        r1.i("ObricTtsReaderInterceptor", "[TTS_OBRIC][JUDGE_INTERCEPT] isWakeUpScene = " + r115 + ", isBluetoothHeadsetOAutoOrComplex = " + r4);
        r1.i("ObricTtsReaderInterceptor", "[TTS_OBRIC][PASS], Obric did not care scene, pass");
        return TtsInterceptResult.Pass;
    L129:
        if (r23.c(r12) != true) goto L131;
        r116 = true;
    L134:
        r4 = false;
        goto L135
    L123:
        if (r25.a() != true) goto L125;
        r26 = true;
        goto L126
    L117:
        if (r114.d(r12) != true) goto L119;
        r115 = true;
        goto L120
    L110:
        if (ObricTtsControlDelegate.b.p() == false) goto L112;
        r1.i("ObricTtsReaderInterceptor", "[TTS_OBRIC][PASS] shouldNotPlayTts skip by ROM concurrent record optimize");
        goto L114
    L112:
        r1.e("ObricTtsReaderInterceptor", "[TTS_OBRIC][DENY] , shouldNotPlayTts is true, deny current msg");
        return TtsInterceptResult.Deny;
    L105:
        if (r23.r(r12) != true) goto L107;
        r113 = true;
        goto L108
    L67:
        r20 = null;
        goto L69
    L61:
        if (com.larus.bmhome.chat.bean.d.C0(r12) == false) goto L64;
        r1.i("ObricTtsReaderInterceptor", "[TTS_OBRIC][PASS] is_obric_continuous_talk=1 and isRegen, pass current msg, msgId=" + r12.getMessageId());
        return TtsInterceptResult.Pass;
    L57:
        r18 = null;
        goto L59
    L51:
        if (StringsKt.endsWith$default(r16, "*)", false, 2, null) == false) goto L54;
        r1.e("ObricTtsReaderInterceptor", "[TTS_OBRIC][DENY] msg content is italic status text, deny current msg");
        return TtsInterceptResult.Deny;
    L40:
        if (com.larus.im.bean.message.a.n0(r12) == false) goto L45;
        if (z2.a.autoReadTtsOptConfig().getEnableReceivedMessageFilter() == false) goto L45;
        r1.i("ObricTtsReaderInterceptor", "[TTS_OBRIC][TRY_AUTO_READ_RECEIVED_MESSAGE] tts not play");
        return TtsInterceptResult.Deny;
    L32:
        r11 = null;
    L37:
        r14 = true;
    L27:
        r9 = false;
        goto L28
    L18:
        if (z2.a.autoReadTtsOptConfig().getSkipTtsAutoReadCheckScene() == false) goto L45;
    L10:
        if (z2.a.startTtsWhenReceiveContent() == false) goto L12;
    L13:
        r1.i("ObricTtsReaderInterceptor", "[TTS_OBRIC][LOADING] " + r0 + ", " + r3 + ", localMsgId: " + r12.getLocalMessageId());
        return TtsInterceptResult.Deny;
    L12:
        if (com.larus.bmhome.chat.bean.d.L(r12) == false) goto L15;
    L7:
        r6 = true;
        goto L8
    }
}
