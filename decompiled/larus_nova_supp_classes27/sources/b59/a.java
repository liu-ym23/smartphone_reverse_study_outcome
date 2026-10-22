package b59;

import android.text.TextUtils;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.dora.api.IDoraService;
import com.larus.platform.service.AccountService;
import com.larus.utils.j0;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.SAMICoreCallBackListener;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.enums.SAMICoreTokenType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICorePostProcessLoudnessStrategyParameter;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import com.mammon.audiosdk.structures.SAMICoreTtsContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreTtsProcessParameter;
import com.mammon.audiosdk.structures.SAMICoreTtsResult;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantLoudnessStrategyParameter;
import com.mammon.audiosdk.structures.SAMICoreWebSocketConnectionEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import g49.d;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final String[] d = null;
    public final Set<b59.b> a;
    public final SAMICore b;
    public final C0002a c;

    /* JADX INFO: renamed from: b59.a$a, reason: collision with other inner class name */
    public class C0002a implements SAMICoreCallBackListener {
        public final /* synthetic */ a a;

        public C0002a(a r1) {
            this.a = r1;
        }

        public final void onMessageReceived(SAMICoreCallBackEventType r11, SAMICoreBlock r12) {
            d.d("Dlayer", "onMessageReceived: " + r11);
            if (r11 != SAMICoreCallBackEventType.TTS_Started) goto L13;
            Iterator r13 = ((CopyOnWriteArraySet) this.a.a).iterator();
        L6:
            if (r13.hasNext() == false) goto L9;
            ((b59.b) r13.next()).d(0);
            goto L6
        L9:
            if (r12.dataType != SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event) goto L11;
            SAMICoreServerEvent r14 = (SAMICoreServerEvent) r12.audioData[0];
            d.d("Dlayer", "event:" + r14.event + ", statusCode:" + r14.statusCode + ", statusText:" + r14.statusText + ", taskId:" + r14.taskId + ", messageId:" + r14.messageId);
            return;
        L11:
            d.b("Dlayer", "TTS_Started, data type not support: " + r12.dataType);
            return;
        L13:
            if (r11 != SAMICoreCallBackEventType.TTS_GetResulted) goto L32;
            SAMICoreDataType r15 = r12.dataType;
            if (r15 != SAMICoreDataType.SAMICoreDataType_AudioBin) goto L21;
            SAMICoreTtsResult r16 = (SAMICoreTtsResult) r12.audioData[0];
            d.d("Dlayer", "audio len " + r16.data.length);
            Iterator r17 = ((CopyOnWriteArraySet) this.a.a).iterator();
        L18:
            if (r17.hasNext() == false) goto L97;
            ((b59.b) r17.next()).c(r16.data);
            goto L18
        L97:
            return;
        L21:
            if (r15 != SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event) goto L30;
            SAMICoreServerEvent r18 = (SAMICoreServerEvent) r12.audioData[0];
            d.d("Dlayer", "event:" + r18.event + ", statusCode:" + r18.statusCode + ", statusText:" + r18.statusText + ", taskId:" + r18.taskId + ", messageId:" + r18.messageId + ", textMsg:" + r18.textMsg);
            if (r18.binaryData == null) goto L26;
            d.d("Dlayer", "serverEvent.binaryData is not null");
            return;
        L26:
            if (r18.textMsg != null) goto L28;
            return;
        L28:
            if (r18.event.equals("TTSSentenceEnd") == false) goto L85;
            d.d("Dlayer", "get ttsinfo " + r18.textMsg);
            return;
        L85:
            return;
        L30:
            d.b("Dlayer", "TTS_GetResulted, data type not support: " + r12.dataType);
            return;
        L32:
            if (r11 != SAMICoreCallBackEventType.TTS_Finished) goto L44;
            Iterator r110 = ((CopyOnWriteArraySet) this.a.a).iterator();
        L35:
            if (r110.hasNext() == false) goto L38;
            ((b59.b) r110.next()).d(1);
            goto L35
        L38:
            if (r12.dataType != SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event) goto L42;
            SAMICoreServerEvent r111 = (SAMICoreServerEvent) r12.audioData[0];
            d.d("Dlayer", "dwb event:" + r111.event + ", statusCode:" + r111.statusCode + ", statusText:" + r111.statusText + ", taskId:" + r111.taskId + ", messageId:" + r111.messageId);
            if (r111.textMsg == null) goto L88;
            d.d("Dlayer", "save audio to file:" + r111.textMsg);
            return;
        L88:
            return;
        L42:
            d.b("Dlayer", "TTS_Finished, data type not support: " + r12.dataType);
            return;
        L44:
            if (r11 != SAMICoreCallBackEventType.TTS_Player_Finished) goto L54;
            Iterator r112 = ((CopyOnWriteArraySet) this.a.a).iterator();
        L47:
            if (r112.hasNext() == false) goto L50;
            ((b59.b) r112.next()).d(3);
            goto L47
        L50:
            if (r12.dataType != SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event) goto L52;
            SAMICoreServerEvent r113 = (SAMICoreServerEvent) r12.audioData[0];
            d.d("Dlayer", "event:" + r113.event + ", statusCode:" + r113.statusCode + ", statusText:" + r113.statusText + ", taskId:" + r113.taskId + ", messageId:" + r113.messageId);
            return;
        L52:
            d.b("Dlayer", "TTS_Started, data type not support: " + r12.dataType);
            return;
        L54:
            if (r11 != SAMICoreCallBackEventType.TTS_Failed) goto L64;
            Iterator r114 = ((CopyOnWriteArraySet) this.a.a).iterator();
        L57:
            if (r114.hasNext() == false) goto L60;
            ((b59.b) r114.next()).d(2);
            goto L57
        L60:
            if (r12.dataType != SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event) goto L62;
            SAMICoreServerEvent r115 = (SAMICoreServerEvent) r12.audioData[0];
            d.d("Dlayer", "event:" + r115.event + ", statusCode:" + r115.statusCode + ", statusText:" + r115.statusText + ", taskId:" + r115.taskId + ", messageId:" + r115.messageId);
            return;
        L62:
            d.b("Dlayer", "TTS_Failed, data type not support: " + r12.dataType);
            return;
        L64:
            if (r11 == SAMICoreCallBackEventType.TTS_WebSocketStateChanged) goto L66;
            return;
        L66:
            if (r12.dataType != SAMICoreDataType.SAMICoreDataType_WebSocket_Connection_Event) goto L73;
            SAMICoreWebSocketConnectionEvent r116 = (SAMICoreWebSocketConnectionEvent) r12.audioData[0];
            d.d("Dlayer", "TTS_WebSocketStateChanged state: " + r116.state);
            if (r116.state != 2) goto L96;
            Iterator r117 = ((CopyOnWriteArraySet) this.a.a).iterator();
        L71:
            if (r117.hasNext() == false) goto L98;
            ((b59.b) r117.next()).d(4);
            goto L71
        L98:
            return;
        L96:
            return;
        L73:
            d.b("Dlayer", "TTS_WebSocketStateChanged, data type not support: " + r12.dataType);
        }
    }

    public static class b {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    static {
        d = new String[0];
    }

    public a() {
        this.a = new CopyOnWriteArraySet();
        this.b = new SAMICore();
        this.c = new C0002a(this);
    }

    public final void a(String r15, String r16, String r17, String r18) {
        int r5 = j0.a;     // Catch: Throwable -> L5
        String[] r0 = {j0.d(2131903793)};     // Catch: Throwable -> L5
    L7:
        String[] r6 = (String[]) r0.clone();
        this.b.setListener(this.c);
        SAMICoreTtsContextCreateParameter r7 = new SAMICoreTtsContextCreateParameter();
        r7.url = "wss://sami.bytedance.com/internal/api/v1/ws";
        r7.appKey = ((IDoraService) ServiceManager.get().getService(IDoraService.class)).d().g("dora_full_duplex");
        r7.tokenType = SAMICoreTokenType.TOKEN_TO_C_D;
        AccountService r1 = AccountService.a;
        if (r1.isLogin().booleanValue() == true) goto L56;
    L11:
        String r2 = null;
    L12:
        r7.token = r2;
        JSONObject r3 = new JSONObject();     // Catch: JSONException -> L48
        if (TextUtils.isEmpty(c78.a.a()) == true) goto L17;
        r3.put("x-use-ppe", "1");     // Catch: JSONException -> L48
        r3.put("x-tt-env", c78.a.a());     // Catch: JSONException -> L48
        String r4 = r3.toString();     // Catch: JSONException -> L48
    L18:
        r7.header = r4;
        r7.sampleRate = 24000;
        r7.format = "pcm";
        r7.enableNetTransportCompress = false;
        r7.bitRate = 64000;
        r7.extra = "{\"concurrent_num\":3,\"cache_config\":{\"use_offline_cache\":true}}";
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L32
        r8.put("flush_sentence", true);     // Catch: JSONException -> L32
        r8.put("phoneme_size", 20);     // Catch: JSONException -> L32
        r8.put("max_paragraph_phoneme_size", BaiduNaviStatus.WRONG_AK_PARAM);     // Catch: JSONException -> L32
        if (r6.length <= 0) goto L30;
        JSONArray r9 = new JSONArray();     // Catch: JSONException -> L32
        int r10 = r6.length;     // Catch: JSONException -> L32
        int r11 = 0;
    L22:
        if (r11 >= r10) goto L28;
        String r12 = r6[r11];     // Catch: JSONException -> L32
        if (TextUtils.isEmpty(r12) == true) goto L26;
        r9.put(r12);     // Catch: JSONException -> L32
    L26:
        r11 = r11 + 1;     // Catch: JSONException -> L32
        goto L22
    L28:
        if (r9.length() <= 0) goto L30;
        r8.put("context_texts", r9);     // Catch: JSONException -> L32
    L30:
        String r13 = r8.toString();     // Catch: JSONException -> L32
        d.d("Dlayer", "buildInternal success, internal=" + r13);     // Catch: JSONException -> L32
    L34:
        r7.internal = r13;
        r7.enableTextSeg = true;
        int r14 = this.b.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_Streaming_Playing_TTS_Online, r7);
        if (r14 == 0) goto L37;
        d.b("Dlayer", "create stream tts handle failed, ret:" + r14);
        return;
    L37:
        SAMICoreTtsProcessParameter r20 = new SAMICoreTtsProcessParameter();
        r20.speaker = r16;
        r20.text = r15;
        r20.enableConcurrency = true;
        r20.sampleRate = 24000;
        r20.enablePlaying = true;
        r20.enableSaveAudioToFile = false;
        r20.enableTextSeg = true;
        SAMICorePostProcessLoudnessStrategyParameter r21 = new SAMICorePostProcessLoudnessStrategyParameter();
        if (r17.isEmpty() == false) goto L40;
        ((SAMICoreVoiceAssistantLoudnessStrategyParameter) r21).metaData = "{\"audio_params\":{\"num_channel\":1,\"sample_rate\":24000},\"loudness\":{\"delta_loudness\":1.7901344299316406,\"integrated_loudness\":-18.9718132019043,\"loudness_range\":2.9000015258789062,\"lra_end\":-17.799999237060547,\"lra_start\":-20.700000762939453,\"max_mom_loud\":-13.786014556884766,\"max_short_term_loud\":-17.181678771972656},\"rms_stats\":{\"background_noise_left\":-115.4144515991211,\"dc_offset_left\":-0.000630962662398815,\"dynamic_range_left\":105.03616333007812,\"estimated_snr_left\":96.556396484375,\"left_right_diff\":0,\"left_total\":-18.858057022094727,\"minimum\":-300,\"normed_std_left\":-7.025766372680664,\"peak\":-1.0824939012527466,\"std_left\":-25.88382339477539},\"version\":\"1.4.2\"}";
    L41:
        ((SAMICoreVoiceAssistantLoudnessStrategyParameter) r21).deviceAiData = "{\"target_lufs\": " + r18 + "}";
        ((SAMICoreVoiceAssistantLoudnessStrategyParameter) r21).loudNormAlgoType = 1;
        SAMICoreProperty r22 = new SAMICoreProperty();
        SAMICorePropertyId r23 = SAMICorePropertyId.SAMICorePropertyId_PostProcess_Loudness_Strategy_Param;
        r22.id = r23;
        r22.type = SAMICoreDataType.SAMICoreDataType_PostProcess_LoudnessStrategy_Param;
        r22.dataObjectArray = new SAMICorePostProcessLoudnessStrategyParameter[]{r21};
        r22.dataArrayLen = 1;
        int r24 = this.b.SAMICoreSetProperty(r23, r22);
        if (r24 == 0) goto L44;
        d.b("Dlayer", "testPlayTts: SAMICoreSetProperty failed ret = " + r24);
        return;
    L44:
        SAMICoreBlock r25 = new SAMICoreBlock();
        r25.dataType = SAMICoreDataType.SAMICoreDataType_WebSocket_Tts;
        r25.audioData = new SAMICoreTtsProcessParameter[]{r20};
        r25.numberAudioData = 1;
        int r26 = this.b.SAMICoreProcess(r25, null);
        if (r26 == 0) goto L63;
        d.b("Dlayer", "get and play tts failed: " + r26);
        return;
    L63:
        return;
    L40:
        ((SAMICoreVoiceAssistantLoudnessStrategyParameter) r21).metaData = r17;
    L32:
        e = move-exception;
        d.c("Dlayer", "buildInternal failed, contextTexts=" + Arrays.toString(r6), e);
        r13 = "{\"flush_sentence\":true,\"phoneme_size\":20,\"max_paragraph_phoneme_size\":200}";
    L17:
        r4 = "";
        goto L18
    L56:
        JSONObject r27 = new JSONObject();     // Catch: JSONException -> L49
        r27.put("Passport-Auth", "session");     // Catch: JSONException -> L49
        r27.put("sdk-version", "2");     // Catch: JSONException -> L49
        r27.put("X-tt-Token", r1.getXTTToken());     // Catch: JSONException -> L49
        r2 = r27.toString();     // Catch: JSONException -> L49
    L5:
        th = move-exception;
        d.c("Dlayer", "getDefaultContextTexts failed", th);
        r0 = d;
        goto L7
    }
}
