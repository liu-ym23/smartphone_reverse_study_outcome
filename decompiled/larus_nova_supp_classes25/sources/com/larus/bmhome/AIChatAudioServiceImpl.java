package com.larus.bmhome;

import android.os.SystemClock;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.b;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.EditPos;
import com.larus.platform.spi.IAIChatAudioService;
import com.larus.voice_setting.voice.base.ProfileInfoBaseFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016JV\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u00052\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016Jr\u0010\u001f\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0016\u0010 \u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020\u000b\u0018\u00010!2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000b\u0018\u00010!2&\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u000b\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016Jo\u0010\u0016\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010\u00132\b\u0010.\u001a\u0004\u0018\u00010\u00132\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u00132\u0006\u00103\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u00010'2\u0006\u00105\u001a\u00020'H\u0016¢\u0006\u0002\u00106J\u0012\u00107\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u00108\u001a\u00020\u0005*\u0004\u0018\u000109H\u0016J\u0018\u0010:\u001a\u00020\u0005*\u0004\u0018\u0001092\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010=\u001a\u00020>H\u0016Jo\u0010\u0016\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010\u00132\b\u0010.\u001a\u0004\u0018\u00010\u00132\u0006\u0010?\u001a\u00020@2\u0006\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u00132\u0006\u00103\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u00010'2\u0006\u0010A\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010BJ\"\u0010C\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00132\b\u0010D\u001a\u0004\u0018\u00010\u00132\u0006\u0010E\u001a\u00020\u0005H\u0016J\u0012\u0010F\u001a\u00020\u000b2\b\u0010G\u001a\u0004\u0018\u00010*H\u0016R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006H"}, d2 = {"Lcom/larus/bmhome/AIChatAudioServiceImpl;", "Lcom/larus/platform/spi/IAIChatAudioService;", "<init>", "()V", "value", "", "isAsrSpeakerPressed", "()Z", "setAsrSpeakerPressed", "(Z)V", "initInterruptParams", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "ttsSwitch", "Landroidx/lifecycle/LiveData;", "fragment", "Landroidx/fragment/app/Fragment;", "conversationId", "", "setCurrentConversationId", "cancel", "start", "taskId", "msgId", "isFirstSpeak", "ext", "", "forceEnableTts", "voiceStyleInfo", "Lcom/larus/audio/bean/VoiceStyleInfo;", "onResult", "onAudioData", "Lkotlin/Function1;", "", "onSuccess", "Lcom/larus/audio/AsrSuccessResult;", "onFail", "Lkotlin/Function4;", "", "", "onSentenceStream", "Lcom/larus/audio/asr/AsrStreamSentenceCallback;", "msg", "Lcom/larus/im/bean/message/Message;", "path", "asrLanguage", "extraConfig", "Lorg/json/JSONObject;", "isSocial", "botId", "saveAudioFile", "duration", "startTimeStamp", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ZLjava/lang/String;ZLjava/lang/Long;J)V", "isTtsAllowInSocialScene", "isSelfCreatedVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "enableModifyTts", "botEditPos", "Lcom/larus/platform/model/EditPos;", "createPublicVoiceListFragment", "Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "config", "Lcom/larus/audio/asr/AsrRequestExtraConfig;", "bizScene", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/audio/asr/AsrRequestExtraConfig;ZLjava/lang/String;ZLjava/lang/Long;Ljava/lang/String;)V", "stopAsrStream", "localMessageId", "ttsEnable", "setAsrStreamSentenceCallback", "callback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AIChatAudioServiceImpl implements IAIChatAudioService {
    public AIChatAudioServiceImpl() {
    }

    public final void a() {
        AudioServiceDelegate.a.x().a();
    }

    public final void cancel() {
        AudioServiceDelegate.a.i0().cancel("social", true);
    }

    public final ProfileInfoBaseFragment l() {
        return p2a.s.b.l();
    }

    public final void b(String r2) {
        AudioServiceDelegate.a.i0().b(r2);
    }

    public final boolean p(SpeakerVoice r1) {
        return lq9.g0.b(r1);
    }

    public final boolean m(SpeakerVoice r1, EditPos r2) {
        return lq9.g0.a(r1, r2);
    }

    public final void o(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        AudioServiceDelegate.a.x().g(r3, null, r4);
    }

    public final void q(String r11, Function1<? super byte[], Unit> r12, Function1<? super b, Unit> r13, Function4<? super String, ? super String, ? super Long, ? super Integer, Unit> r14, com.larus.audio.asr.a0 r15) {
        com.larus.audio.o0.a.a(AudioServiceDelegate.a.h0(), r11, r12, null, r13, r14, null, r15, 36);
    }

    public final void n(String r17, String r18, String r19, String r20, com.larus.audio.asr.y r21, boolean r22, String r23, boolean r24, Long r25) {
        Intrinsics.checkNotNullParameter(r17, "taskId");
        Intrinsics.checkNotNullParameter(r18, "conversationId");
        Intrinsics.checkNotNullParameter(r21, "config");
        Intrinsics.checkNotNullParameter("ai_doc", "bizScene");
        AudioServiceDelegate.a.h0().g(r17, r18, r19, r20, r21, r22, r23, r24, r25, null, SystemClock.elapsedRealtime(), new com.larus.audio.n0(), null);
    }
}
