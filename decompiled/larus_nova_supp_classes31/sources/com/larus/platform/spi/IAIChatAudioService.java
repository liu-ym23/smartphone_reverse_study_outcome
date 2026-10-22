package com.larus.platform.spi;

import com.larus.audio.asr.a0;
import com.larus.audio.asr.y;
import com.larus.audio.b;
import com.larus.doc.impl.audio.DocAudioComponent;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.EditPos;
import com.larus.voice_setting.voice.base.ProfileInfoBaseFragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import f39.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u0000 I2\u00020\u0001:\u0001IJ.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0012\u001a\u00020\bH&JZ\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\u009a\u0001\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\b\u0018\u00010\u001e2%\b\u0002\u0010 \u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b\u0018\u00010\u001e27\b\u0002\u0010%\u001a1\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110(¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\b\u0018\u00010&2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+H&J\u007f\u0010\u0013\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u00020\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u00104\u001a\u00020\u00032\n\b\u0002\u00105\u001a\u0004\u0018\u00010'2\b\b\u0002\u00106\u001a\u00020'H&¢\u0006\u0002\u00107J\u0012\u00108\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0018\u00109\u001a\u00020\u0003*\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<H&J\u000e\u0010=\u001a\u00020\u0003*\u0004\u0018\u00010:H&J\b\u0010>\u001a\u00020?H&J{\u0010\u0013\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00102\u0006\u0010@\u001a\u00020A2\b\b\u0002\u00102\u001a\u00020\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u00104\u001a\u00020\u00032\n\b\u0002\u00105\u001a\u0004\u0018\u00010'2\u0006\u0010B\u001a\u00020\u0010H&¢\u0006\u0002\u0010CJ$\u0010D\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00102\b\u0010E\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010F\u001a\u00020\u0003H&J\u0012\u0010G\u001a\u00020\b2\b\u0010H\u001a\u0004\u0018\u00010+H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006J"}, d2 = {"Lcom/larus/platform/spi/IAIChatAudioService;", "", "isAsrSpeakerPressed", "", "()Z", "setAsrSpeakerPressed", "(Z)V", "initInterruptParams", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "ttsSwitch", "Landroidx/lifecycle/LiveData;", "fragment", "Landroidx/fragment/app/Fragment;", "conversationId", "", "setCurrentConversationId", "cancel", "start", "taskId", "msgId", "isFirstSpeak", "ext", "", "forceEnableTts", "voiceStyleInfo", "Lcom/larus/audio/bean/VoiceStyleInfo;", "onResult", "onAudioData", "Lkotlin/Function1;", "", "onSuccess", "Lcom/larus/audio/AsrSuccessResult;", "Lkotlin/ParameterName;", "name", "result", "onFail", "Lkotlin/Function4;", "", "", "errorCode", "onSentenceStream", "Lcom/larus/audio/asr/AsrStreamSentenceCallback;", "msg", "Lcom/larus/im/bean/message/Message;", "path", "asrLanguage", "extraConfig", "Lorg/json/JSONObject;", "isSocial", "botId", "saveAudioFile", "duration", "startTimeStamp", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ZLjava/lang/String;ZLjava/lang/Long;J)V", "isTtsAllowInSocialScene", "enableModifyTts", "Lcom/larus/im/bean/bot/SpeakerVoice;", "botEditPos", "Lcom/larus/platform/model/EditPos;", "isSelfCreatedVoice", "createPublicVoiceListFragment", "Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "config", "Lcom/larus/audio/asr/AsrRequestExtraConfig;", "bizScene", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/audio/asr/AsrRequestExtraConfig;ZLjava/lang/String;ZLjava/lang/Long;Ljava/lang/String;)V", "stopAsrStream", "localMessageId", "ttsEnable", "setAsrStreamSentenceCallback", "callback", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IAIChatAudioService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\b\u001a\u00020\t*\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0001J/\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J\u000f\u0010\u0016\u001a\u00020\t*\u0004\u0018\u00010\nH\u0096\u0001J\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u0091\u0001\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0016\u0010\u001a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b25\u0010\"\u001a1\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110%¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0005\u0018\u00010#2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0001J\u0013\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010(H\u0096\u0001J\u0013\u0010+\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0001JW\u0010,\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010-\u001a\u0004\u0018\u00010\u00152\u0006\u0010.\u001a\u00020\t2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u0001002\u0006\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u000103H\u0096\u0001Jp\u0010,\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\b\u00106\u001a\u0004\u0018\u00010\u00152\b\u00107\u001a\u0004\u0018\u00010\u00152\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\t2\b\u0010;\u001a\u0004\u0018\u00010\u00152\u0006\u0010<\u001a\u00020\t2\b\u0010=\u001a\u0004\u0018\u00010$2\u0006\u0010>\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0002\u0010?Jp\u0010,\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\b\u00106\u001a\u0004\u0018\u00010\u00152\b\u00107\u001a\u0004\u0018\u00010\u00152\u0006\u0010@\u001a\u00020A2\u0006\u0010:\u001a\u00020\t2\b\u0010;\u001a\u0004\u0018\u00010\u00152\u0006\u0010<\u001a\u00020\t2\b\u0010=\u001a\u0004\u0018\u00010$2\u0006\u0010B\u001a\u00020$H\u0096\u0001¢\u0006\u0002\u0010CJ#\u0010D\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00152\b\u0010E\u001a\u0004\u0018\u00010\u00152\u0006\u0010F\u001a\u00020\tH\u0096\u0001R\u0018\u0010G\u001a\u00020\tX\u0096\u000f¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006K"}, d2 = {"Lcom/larus/platform/spi/IAIChatAudioService$Companion;", "Lcom/larus/platform/spi/IAIChatAudioService;", "<init>", "()V", "cancel", "", "createPublicVoiceListFragment", "Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "enableModifyTts", "", "Lcom/larus/im/bean/bot/SpeakerVoice;", "botEditPos", "Lcom/larus/platform/model/EditPos;", "initInterruptParams", "owner", "Landroidx/lifecycle/LifecycleOwner;", "ttsSwitch", "Landroidx/lifecycle/LiveData;", "fragment", "Landroidx/fragment/app/Fragment;", "conversationId", "", "isSelfCreatedVoice", "isTtsAllowInSocialScene", "onResult", "taskId", "onAudioData", "Lkotlin/Function1;", "", "onSuccess", "Lcom/larus/audio/AsrSuccessResult;", "Lkotlin/ParameterName;", "name", "result", "onFail", "Lkotlin/Function4;", "", "", "errorCode", "onSentenceStream", "Lcom/larus/audio/asr/AsrStreamSentenceCallback;", "setAsrStreamSentenceCallback", "callback", "setCurrentConversationId", "start", "msgId", "isFirstSpeak", "ext", "", "forceEnableTts", "voiceStyleInfo", "Lcom/larus/audio/bean/VoiceStyleInfo;", "msg", "Lcom/larus/im/bean/message/Message;", "path", "asrLanguage", "config", "Lcom/larus/audio/asr/AsrRequestExtraConfig;", "isSocial", "botId", "saveAudioFile", "duration", "bizScene", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/audio/asr/AsrRequestExtraConfig;ZLjava/lang/String;ZLjava/lang/Long;Ljava/lang/String;)V", "extraConfig", "Lorg/json/JSONObject;", "startTimeStamp", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ZLjava/lang/String;ZLjava/lang/Long;J)V", "stopAsrStream", "localMessageId", "ttsEnable", "isAsrSpeakerPressed", "()Z", "setAsrSpeakerPressed", "(Z)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements IAIChatAudioService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IAIChatAudioService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.platform.spi.IAIChatAudioService
        public final void a() {
            this.b.a();
        }

        @Override // com.larus.platform.spi.IAIChatAudioService
        public final void b(String r2) {
            this.b.b(r2);
        }

        @Override // com.larus.platform.spi.IAIChatAudioService
        public final void cancel() {
            this.b.cancel();
        }

        @Override // com.larus.platform.spi.IAIChatAudioService
        public final ProfileInfoBaseFragment l() {
            return this.b.l();
        }

        @Override // com.larus.platform.spi.IAIChatAudioService
        public final boolean m(SpeakerVoice r2, EditPos r3) {
            return this.b.m(r2, r3);
        }

        @Override // com.larus.platform.spi.IAIChatAudioService
        public final void n(String r12, String r13, String r14, String r15, y r16, boolean r17, String r18, boolean r19, Long r20) {
            Intrinsics.checkNotNullParameter(r12, "taskId");
            Intrinsics.checkNotNullParameter(r13, "conversationId");
            Intrinsics.checkNotNullParameter(r16, "config");
            Intrinsics.checkNotNullParameter("ai_doc", "bizScene");
            this.b.n(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        @Override // com.larus.platform.spi.IAIChatAudioService
        public final void o(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            this.b.o(r2, r3);
        }

        @Override // com.larus.platform.spi.IAIChatAudioService
        public final boolean p(SpeakerVoice r2) {
            return this.b.p(r2);
        }

        @Override // com.larus.platform.spi.IAIChatAudioService
        public final void q(String r7, Function1<? super byte[], Unit> r8, Function1<? super b, Unit> r9, Function4<? super String, ? super String, ? super Long, ? super Integer, Unit> r10, a0 r11) {
            this.b.q(r7, r8, r9, r10, r11);
        }

        private Companion() {
            IAIChatAudioService r0 = (IAIChatAudioService) ServiceManager.get().getService(IAIChatAudioService.class);
            if (r0 != null) goto L5;
            r0 = new AIChatAudioServiceNoop();
        L5:
            this.b = r0;
        }
    }

    public static final class a {
        public static /* synthetic */ void a(Companion r6, c r7, DocAudioComponent.b r8, int r9) {
            if ((r9 & 8) == 0) goto L6;
            r7 = null;
        L6:
            if ((r9 & 16) == 0) goto L8;
            DocAudioComponent.b r5 = null;
        L9:
            r6.q(null, null, null, r7, r5);
            return;
        L8:
            r5 = r8;
            goto L9
        }
    }

    static {
        a = Companion.c;
    }

    void a();

    void b(String r1);

    void cancel();

    ProfileInfoBaseFragment l();

    boolean m(SpeakerVoice r1, EditPos r2);

    void n(String r1, String r2, String r3, String r4, y r5, boolean r6, String r7, boolean r8, Long r9);

    void o(String r1, boolean r2);

    boolean p(SpeakerVoice r1);

    void q(String r1, Function1<? super byte[], Unit> r2, Function1<? super b, Unit> r3, Function4<? super String, ? super String, ? super Long, ? super Integer, Unit> r4, a0 r5);
}
