package com.larus.platform.spi;

import com.larus.audio.asr.a0;
import com.larus.audio.asr.y;
import com.larus.audio.b;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.EditPos;
import com.larus.voice_setting.voice.base.ProfileInfoBaseFragment;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import sr9.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016JV\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u00052\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0090\u0001\u0010\u001e\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0016\u0010\u001f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\n\u0018\u00010 2#\u0010\"\u001a\u001f\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\n\u0018\u00010 25\u0010'\u001a1\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u00110*¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\n\u0018\u00010(2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016Jo\u0010\u0015\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00122\b\u00100\u001a\u0004\u0018\u00010\u00122\b\u00101\u001a\u0004\u0018\u00010\u00122\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u00122\u0006\u00106\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010)2\u0006\u00108\u001a\u00020)H\u0016¢\u0006\u0002\u00109J\u0012\u0010:\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010;\u001a\u00020\u0005*\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u000e\u0010?\u001a\u00020\u0005*\u0004\u0018\u00010<H\u0016J\b\u0010@\u001a\u00020AH\u0016Jo\u0010\u0015\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00122\b\u00100\u001a\u0004\u0018\u00010\u00122\b\u00101\u001a\u0004\u0018\u00010\u00122\u0006\u0010B\u001a\u00020C2\u0006\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u00122\u0006\u00106\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010)2\u0006\u0010D\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010EJ\"\u0010F\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00122\b\u0010G\u001a\u0004\u0018\u00010\u00122\u0006\u0010H\u001a\u00020\u0005H\u0016J\u0012\u0010I\u001a\u00020\n2\b\u0010J\u001a\u0004\u0018\u00010-H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006K"}, d2 = {"Lcom/larus/platform/spi/AIChatAudioServiceNoop;", "Lcom/larus/platform/spi/IAIChatAudioService;", "<init>", "()V", "isAsrSpeakerPressed", "", "()Z", "setAsrSpeakerPressed", "(Z)V", "initInterruptParams", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "ttsSwitch", "Landroidx/lifecycle/LiveData;", "fragment", "Landroidx/fragment/app/Fragment;", "conversationId", "", "setCurrentConversationId", "cancel", "start", "taskId", "msgId", "isFirstSpeak", "ext", "", "forceEnableTts", "voiceStyleInfo", "Lcom/larus/audio/bean/VoiceStyleInfo;", "onResult", "onAudioData", "Lkotlin/Function1;", "", "onSuccess", "Lcom/larus/audio/AsrSuccessResult;", "Lkotlin/ParameterName;", "name", "result", "onFail", "Lkotlin/Function4;", "", "", "errorCode", "onSentenceStream", "Lcom/larus/audio/asr/AsrStreamSentenceCallback;", "msg", "Lcom/larus/im/bean/message/Message;", "path", "asrLanguage", "extraConfig", "Lorg/json/JSONObject;", "isSocial", "botId", "saveAudioFile", "duration", "startTimeStamp", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ZLjava/lang/String;ZLjava/lang/Long;J)V", "isTtsAllowInSocialScene", "enableModifyTts", "Lcom/larus/im/bean/bot/SpeakerVoice;", "botEditPos", "Lcom/larus/platform/model/EditPos;", "isSelfCreatedVoice", "createPublicVoiceListFragment", "Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "config", "Lcom/larus/audio/asr/AsrRequestExtraConfig;", "bizScene", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/audio/asr/AsrRequestExtraConfig;ZLjava/lang/String;ZLjava/lang/Long;Ljava/lang/String;)V", "stopAsrStream", "localMessageId", "ttsEnable", "setAsrStreamSentenceCallback", "callback", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AIChatAudioServiceNoop implements IAIChatAudioService {
    public AIChatAudioServiceNoop() {
    }

    @Override // com.larus.platform.spi.IAIChatAudioService
    public final void a() {
    }

    @Override // com.larus.platform.spi.IAIChatAudioService
    public final void b(String r1) {
    }

    @Override // com.larus.platform.spi.IAIChatAudioService
    public final void cancel() {
    }

    @Override // com.larus.platform.spi.IAIChatAudioService
    public final boolean m(SpeakerVoice r1, EditPos r2) {
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatAudioService
    public final void n(String r1, String r2, String r3, String r4, y r5, boolean r6, String r7, boolean r8, Long r9) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter("ai_doc", "bizScene");
    }

    @Override // com.larus.platform.spi.IAIChatAudioService
    public final void o(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
    }

    @Override // com.larus.platform.spi.IAIChatAudioService
    public final boolean p(SpeakerVoice r1) {
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatAudioService
    public final void q(String r1, Function1<? super byte[], Unit> r2, Function1<? super b, Unit> r3, Function4<? super String, ? super String, ? super Long, ? super Integer, Unit> r4, a0 r5) {
    }

    @Override // com.larus.platform.spi.IAIChatAudioService
    public final ProfileInfoBaseFragment l() {
        return new v();
    }
}
