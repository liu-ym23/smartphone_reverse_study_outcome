package com.mammon.speechaudiosdk.kmp.param.va;

import com.lynx.tasm.event.LynxTouchEvent;
import com.mammon.speechaudiosdk.kmp.type.va.SpeechVoiceAssistantSessionRequestType;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0012\n\u0002\bi\b\u0086\b\u0018\u00002\u00020\u0001BÏ\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\t\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u0012\b\b\u0002\u0010#\u001a\u00020\t\u0012\b\b\u0002\u0010$\u001a\u00020\t\u0012\b\b\u0002\u0010%\u001a\u00020\u000e\u0012\b\b\u0002\u0010&\u001a\u00020\u000e\u0012\b\b\u0002\u0010'\u001a\u00020\u000e\u0012\b\b\u0002\u0010(\u001a\u00020\t\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010+\u001a\u00020\t\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010-\u001a\u00020\t\u0012\b\b\u0002\u0010.\u001a\u00020\t\u0012\b\b\u0002\u0010/\u001a\u00020\u000e\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u00101\u001a\u00020\t¢\u0006\u0004\b2\u00103J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010h\u001a\u00020\tHÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u000eHÆ\u0003J\t\u0010m\u001a\u00020\u000eHÆ\u0003J\t\u0010n\u001a\u00020\u000eHÆ\u0003J\t\u0010o\u001a\u00020\u000eHÆ\u0003J\t\u0010p\u001a\u00020\u000eHÆ\u0003J\t\u0010q\u001a\u00020\tHÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010t\u001a\u00020\tHÆ\u0003J\t\u0010u\u001a\u00020\tHÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010y\u001a\u00020\tHÆ\u0003J\t\u0010z\u001a\u00020\u001dHÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010~\u001a\u00020\tHÆ\u0003J\t\u0010\u007f\u001a\u00020\tHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\tHÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010*HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\tHÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u000eHÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\tHÆ\u0003JÒ\u0003\u0010\u008e\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010!\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020\t2\b\b\u0002\u0010#\u001a\u00020\t2\b\b\u0002\u0010$\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\t2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020\t2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010-\u001a\u00020\t2\b\b\u0002\u0010.\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u00020\u000e2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00101\u001a\u00020\tHÆ\u0001J\u0015\u0010\u008f\u0001\u001a\u00020\u000e2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0091\u0001\u001a\u00020\tHÖ\u0001J\n\u0010\u0092\u0001\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u00105R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u00105R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u00105R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010@R\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010@R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010@R\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010@R\u0011\u0010\u0013\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bE\u0010;R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u00105R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u00105R\u0011\u0010\u0016\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bH\u0010;R\u0011\u0010\u0017\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bI\u0010;R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u00105R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u00105R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u00105R\u0011\u0010\u001b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bM\u0010;R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u00105R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u00105R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u00105R\u0011\u0010!\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bS\u0010;R\u0011\u0010\"\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bT\u0010;R\u0011\u0010#\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bU\u0010;R\u0011\u0010$\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bV\u0010;R\u0011\u0010%\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bW\u0010@R\u0011\u0010&\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bX\u0010@R\u0011\u0010'\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010@R\u0011\u0010(\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010;R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0011\u0010+\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b]\u0010;R\u0013\u0010,\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u00105R\u0011\u0010-\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b_\u0010;R\u0011\u0010.\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b`\u0010;R\u0011\u0010/\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\ba\u0010@R\u0013\u00100\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u00105R\u0011\u00101\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bc\u0010;¨\u0006\u0093\u0001"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionStartSessionParam;", NameKeys.UnloadStrategy_No_Strategy, "taskId", NameKeys.UnloadStrategy_No_Strategy, "sessionId", "conversationId", "requestType", "Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionRequestType;", "business", NameKeys.UnloadStrategy_No_Strategy, "chat", "trace", "extra", "enableAudioInput", NameKeys.UnloadStrategy_No_Strategy, "enableUploadAudio", "enableTextReading", "enablePlayer", "enableRealtimeVoiceCall", "interruptType", "question", "reconnectQuestionId", "reconnectStatus", "triggerType", "updateUIContextPayload", "updatePersonalContextPayload", "uploadInfoPayload", "playerStatus", "volume", NameKeys.UnloadStrategy_No_Strategy, "sceneType", "imageId", "wakeupId", "imageType", "intentMode", "imageStatus", "highQuality", "enableTouch", "enableBurst", "enableAudioRecorder", "audioRecordChannels", "imgData", NameKeys.UnloadStrategy_No_Strategy, "imgDataLen", "updateAudioConfigPayload", "multimodalStatus", "vuiQueryMode", "enableOneShot", "wakeupWord", "wakeupAudioDurationMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionRequestType;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIZZZI[BILjava/lang/String;IIZLjava/lang/String;I)V", "getTaskId", "()Ljava/lang/String;", "getSessionId", "getConversationId", "getRequestType", "()Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionRequestType;", "getBusiness", "()I", "getChat", "getTrace", "getExtra", "getEnableAudioInput", "()Z", "getEnableUploadAudio", "getEnableTextReading", "getEnablePlayer", "getEnableRealtimeVoiceCall", "getInterruptType", "getQuestion", "getReconnectQuestionId", "getReconnectStatus", "getTriggerType", "getUpdateUIContextPayload", "getUpdatePersonalContextPayload", "getUploadInfoPayload", "getPlayerStatus", "getVolume", "()F", "getSceneType", "getImageId", "getWakeupId", "getImageType", "getIntentMode", "getImageStatus", "getHighQuality", "getEnableTouch", "getEnableBurst", "getEnableAudioRecorder", "getAudioRecordChannels", "getImgData", "()[B", "getImgDataLen", "getUpdateAudioConfigPayload", "getMultimodalStatus", "getVuiQueryMode", "getEnableOneShot", "getWakeupWord", "getWakeupAudioDurationMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "copy", "equals", "other", "hashCode", "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechVoiceAssistantSessionStartSessionParam {
    private final int audioRecordChannels;
    private final int business;
    private final String chat;
    private final String conversationId;
    private final boolean enableAudioInput;
    private final boolean enableAudioRecorder;
    private final boolean enableBurst;
    private final boolean enableOneShot;
    private final boolean enablePlayer;
    private final boolean enableRealtimeVoiceCall;
    private final boolean enableTextReading;
    private final boolean enableTouch;
    private final boolean enableUploadAudio;
    private final String extra;
    private final int highQuality;
    private final String imageId;
    private final int imageStatus;
    private final int imageType;
    private final byte[] imgData;
    private final int imgDataLen;
    private final int intentMode;
    private final int interruptType;
    private final int multimodalStatus;
    private final int playerStatus;
    private final String question;
    private final String reconnectQuestionId;
    private final int reconnectStatus;
    private final SpeechVoiceAssistantSessionRequestType requestType;
    private final String sceneType;
    private final String sessionId;
    private final String taskId;
    private final String trace;
    private final int triggerType;
    private final String updateAudioConfigPayload;
    private final String updatePersonalContextPayload;
    private final String updateUIContextPayload;
    private final String uploadInfoPayload;
    private final float volume;
    private final int vuiQueryMode;
    private final int wakeupAudioDurationMs;
    private final String wakeupId;
    private final String wakeupWord;

    public SpeechVoiceAssistantSessionStartSessionParam() {
        this(null, null, null, null, 0, null, null, null, false, false, false, false, false, 0, null, null, 0, 0, null, null, null, 0, 0.0f, null, null, null, 0, 0, 0, 0, false, false, false, 0, null, 0, null, 0, 0, false, null, 0, -1, 1023, null);
    }

    public static /* synthetic */ SpeechVoiceAssistantSessionStartSessionParam copy$default(SpeechVoiceAssistantSessionStartSessionParam r17, String r18, String r19, String r20, SpeechVoiceAssistantSessionRequestType r21, int r22, String r23, String r24, String r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30, int r31, String r32, String r33, int r34, int r35, String r36, String r37, String r38, int r39, float r40, String r41, String r42, String r43, int r44, int r45, int r46, int r47, boolean r48, boolean r49, boolean r50, int r51, byte[] r52, int r53, String r54, int r55, int r56, boolean r57, String r58, int r59, int r60, int r61, Object r62) {
        if ((r60 & 1) == 0) goto L5;
        String r3 = r17.taskId;
    L7:
        if ((r60 & 2) == 0) goto L9;
        String r4 = r17.sessionId;
    L11:
        if ((r60 & 4) == 0) goto L13;
        String r5 = r17.conversationId;
    L15:
        if ((r60 & 8) == 0) goto L17;
        SpeechVoiceAssistantSessionRequestType r6 = r17.requestType;
    L19:
        if ((r60 & 16) == 0) goto L21;
        int r7 = r17.business;
    L23:
        if ((r60 & 32) == 0) goto L25;
        String r8 = r17.chat;
    L27:
        if ((r60 & 64) == 0) goto L29;
        String r9 = r17.trace;
    L31:
        if ((r60 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L33;
        String r10 = r17.extra;
    L35:
        if ((r60 & 256) == 0) goto L37;
        boolean r11 = r17.enableAudioInput;
    L39:
        if ((r60 & 512) == 0) goto L41;
        boolean r12 = r17.enableUploadAudio;
    L43:
        if ((r60 & 1024) == 0) goto L45;
        boolean r13 = r17.enableTextReading;
    L47:
        if ((r60 & 2048) == 0) goto L49;
        boolean r14 = r17.enablePlayer;
    L51:
        if ((r60 & 4096) == 0) goto L53;
        boolean r15 = r17.enableRealtimeVoiceCall;
    L54:
        boolean r310 = r15;
        if ((r60 & 8192) == 0) goto L57;
        int r16 = r17.interruptType;
    L58:
        int r311 = r16;
        if ((r60 & 16384) == 0) goto L61;
        String r110 = r17.question;
    L62:
        String r312 = r110;
        if ((r60 & 32768) == 0) goto L65;
        String r111 = r17.reconnectQuestionId;
    L66:
        String r313 = r111;
        if ((r60 & 65536) == 0) goto L69;
        int r112 = r17.reconnectStatus;
    L70:
        int r314 = r112;
        if ((r60 & 131072) == 0) goto L73;
        int r113 = r17.triggerType;
    L74:
        int r315 = r113;
        if ((r60 & 262144) == 0) goto L77;
        String r114 = r17.updateUIContextPayload;
    L78:
        String r316 = r114;
        if ((r60 & 524288) == 0) goto L81;
        String r115 = r17.updatePersonalContextPayload;
    L82:
        String r317 = r115;
        if ((r60 & 1048576) == 0) goto L85;
        String r116 = r17.uploadInfoPayload;
    L86:
        String r318 = r116;
        if ((r60 & 2097152) == 0) goto L89;
        int r117 = r17.playerStatus;
    L90:
        int r319 = r117;
        if ((r60 & 4194304) == 0) goto L93;
        float r118 = r17.volume;
    L94:
        float r410 = r118;
        if ((r60 & 8388608) == 0) goto L97;
        String r119 = r17.sceneType;
    L98:
        String r411 = r119;
        if ((r60 & 16777216) == 0) goto L101;
        String r120 = r17.imageId;
    L102:
        String r412 = r120;
        if ((r60 & 33554432) == 0) goto L105;
        String r121 = r17.wakeupId;
    L106:
        String r413 = r121;
        if ((r60 & 67108864) == 0) goto L109;
        int r122 = r17.imageType;
    L110:
        int r414 = r122;
        if ((r60 & 134217728) == 0) goto L113;
        int r123 = r17.intentMode;
    L114:
        int r415 = r123;
        if ((r60 & 268435456) == 0) goto L117;
        int r124 = r17.imageStatus;
    L118:
        int r416 = r124;
        if ((r60 & 536870912) == 0) goto L121;
        int r125 = r17.highQuality;
    L122:
        int r417 = r125;
        if ((r60 & 1073741824) == 0) goto L125;
        boolean r126 = r17.enableTouch;
    L127:
        if ((r60 & Integer.MIN_VALUE) == 0) goto L129;
        boolean r1 = r17.enableBurst;
    L130:
        boolean r418 = r1;
        if ((r61 & 1) == 0) goto L133;
        boolean r2 = r17.enableAudioRecorder;
    L134:
        boolean r510 = r2;
        if ((r61 & 2) == 0) goto L137;
        int r63 = r17.audioRecordChannels;
    L138:
        int r511 = r63;
        if ((r61 & 4) == 0) goto L141;
        byte[] r64 = r17.imgData;
    L142:
        byte[] r512 = r64;
        if ((r61 & 8) == 0) goto L145;
        int r65 = r17.imgDataLen;
    L146:
        int r513 = r65;
        if ((r61 & 16) == 0) goto L149;
        String r66 = r17.updateAudioConfigPayload;
    L150:
        String r514 = r66;
        if ((r61 & 32) == 0) goto L153;
        int r67 = r17.multimodalStatus;
    L154:
        int r515 = r67;
        if ((r61 & 64) == 0) goto L157;
        int r68 = r17.vuiQueryMode;
    L158:
        int r516 = r68;
        if ((r61 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L161;
        boolean r69 = r17.enableOneShot;
    L162:
        boolean r517 = r69;
        if ((r61 & 256) == 0) goto L165;
        String r70 = r17.wakeupWord;
    L167:
        if ((r61 & 512) == 0) goto L169;
        int r71 = r17.wakeupAudioDurationMs;
    L171:
        return r17.copy(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r126, r418, r510, r511, r512, r513, r514, r515, r516, r517, r70, r71);
    L169:
        r71 = r59;
        goto L171
    L165:
        r70 = r58;
        goto L167
    L161:
        r69 = r57;
        goto L162
    L157:
        r68 = r56;
        goto L158
    L153:
        r67 = r55;
        goto L154
    L149:
        r66 = r54;
        goto L150
    L145:
        r65 = r53;
        goto L146
    L141:
        r64 = r52;
        goto L142
    L137:
        r63 = r51;
        goto L138
    L133:
        r2 = r50;
        goto L134
    L129:
        r1 = r49;
        goto L130
    L125:
        r126 = r48;
        goto L127
    L121:
        r125 = r47;
        goto L122
    L117:
        r124 = r46;
        goto L118
    L113:
        r123 = r45;
        goto L114
    L109:
        r122 = r44;
        goto L110
    L105:
        r121 = r43;
        goto L106
    L101:
        r120 = r42;
        goto L102
    L97:
        r119 = r41;
        goto L98
    L93:
        r118 = r40;
        goto L94
    L89:
        r117 = r39;
        goto L90
    L85:
        r116 = r38;
        goto L86
    L81:
        r115 = r37;
        goto L82
    L77:
        r114 = r36;
        goto L78
    L73:
        r113 = r35;
        goto L74
    L69:
        r112 = r34;
        goto L70
    L65:
        r111 = r33;
        goto L66
    L61:
        r110 = r32;
        goto L62
    L57:
        r16 = r31;
        goto L58
    L53:
        r15 = r30;
        goto L54
    L49:
        r14 = r29;
        goto L51
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r11 = r26;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r3 = r18;
        goto L7
    }

    public final String component1() {
        return this.taskId;
    }

    public final boolean component10() {
        return this.enableUploadAudio;
    }

    public final boolean component11() {
        return this.enableTextReading;
    }

    public final boolean component12() {
        return this.enablePlayer;
    }

    public final boolean component13() {
        return this.enableRealtimeVoiceCall;
    }

    public final int component14() {
        return this.interruptType;
    }

    public final String component15() {
        return this.question;
    }

    public final String component16() {
        return this.reconnectQuestionId;
    }

    public final int component17() {
        return this.reconnectStatus;
    }

    public final int component18() {
        return this.triggerType;
    }

    public final String component19() {
        return this.updateUIContextPayload;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final String component20() {
        return this.updatePersonalContextPayload;
    }

    public final String component21() {
        return this.uploadInfoPayload;
    }

    public final int component22() {
        return this.playerStatus;
    }

    public final float component23() {
        return this.volume;
    }

    public final String component24() {
        return this.sceneType;
    }

    public final String component25() {
        return this.imageId;
    }

    public final String component26() {
        return this.wakeupId;
    }

    public final int component27() {
        return this.imageType;
    }

    public final int component28() {
        return this.intentMode;
    }

    public final int component29() {
        return this.imageStatus;
    }

    public final String component3() {
        return this.conversationId;
    }

    public final int component30() {
        return this.highQuality;
    }

    public final boolean component31() {
        return this.enableTouch;
    }

    public final boolean component32() {
        return this.enableBurst;
    }

    public final boolean component33() {
        return this.enableAudioRecorder;
    }

    public final int component34() {
        return this.audioRecordChannels;
    }

    public final byte[] component35() {
        return this.imgData;
    }

    public final int component36() {
        return this.imgDataLen;
    }

    public final String component37() {
        return this.updateAudioConfigPayload;
    }

    public final int component38() {
        return this.multimodalStatus;
    }

    public final int component39() {
        return this.vuiQueryMode;
    }

    public final SpeechVoiceAssistantSessionRequestType component4() {
        return this.requestType;
    }

    public final boolean component40() {
        return this.enableOneShot;
    }

    public final String component41() {
        return this.wakeupWord;
    }

    public final int component42() {
        return this.wakeupAudioDurationMs;
    }

    public final int component5() {
        return this.business;
    }

    public final String component6() {
        return this.chat;
    }

    public final String component7() {
        return this.trace;
    }

    public final String component8() {
        return this.extra;
    }

    public final boolean component9() {
        return this.enableAudioInput;
    }

    public final SpeechVoiceAssistantSessionStartSessionParam copy(String r45, String r46, String r47, SpeechVoiceAssistantSessionRequestType r48, int r49, String r50, String r51, String r52, boolean r53, boolean r54, boolean r55, boolean r56, boolean r57, int r58, String r59, String r60, int r61, int r62, String r63, String r64, String r65, int r66, float r67, String r68, String r69, String r70, int r71, int r72, int r73, int r74, boolean r75, boolean r76, boolean r77, int r78, byte[] r79, int r80, String r81, int r82, int r83, boolean r84, String r85, int r86) {
        return new SpeechVoiceAssistantSessionStartSessionParam(r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SpeechVoiceAssistantSessionStartSessionParam) == true) goto L8;
        return false;
    L8:
        SpeechVoiceAssistantSessionStartSessionParam r6 = (SpeechVoiceAssistantSessionStartSessionParam) r5;
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sessionId, r6.sessionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L18;
        return false;
    L18:
        if (this.requestType == r6.requestType) goto L21;
        return false;
    L21:
        if (this.business == r6.business) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.chat, r6.chat) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.trace, r6.trace) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L33;
        return false;
    L33:
        if (this.enableAudioInput == r6.enableAudioInput) goto L36;
        return false;
    L36:
        if (this.enableUploadAudio == r6.enableUploadAudio) goto L39;
        return false;
    L39:
        if (this.enableTextReading == r6.enableTextReading) goto L42;
        return false;
    L42:
        if (this.enablePlayer == r6.enablePlayer) goto L45;
        return false;
    L45:
        if (this.enableRealtimeVoiceCall == r6.enableRealtimeVoiceCall) goto L48;
        return false;
    L48:
        if (this.interruptType == r6.interruptType) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.question, r6.question) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.reconnectQuestionId, r6.reconnectQuestionId) == true) goto L57;
        return false;
    L57:
        if (this.reconnectStatus == r6.reconnectStatus) goto L60;
        return false;
    L60:
        if (this.triggerType == r6.triggerType) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.updateUIContextPayload, r6.updateUIContextPayload) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.updatePersonalContextPayload, r6.updatePersonalContextPayload) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.uploadInfoPayload, r6.uploadInfoPayload) == true) goto L72;
        return false;
    L72:
        if (this.playerStatus == r6.playerStatus) goto L75;
        return false;
    L75:
        if (Float.compare(this.volume, r6.volume) == 0) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.sceneType, r6.sceneType) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.imageId, r6.imageId) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.wakeupId, r6.wakeupId) == true) goto L87;
        return false;
    L87:
        if (this.imageType == r6.imageType) goto L90;
        return false;
    L90:
        if (this.intentMode == r6.intentMode) goto L93;
        return false;
    L93:
        if (this.imageStatus == r6.imageStatus) goto L96;
        return false;
    L96:
        if (this.highQuality == r6.highQuality) goto L99;
        return false;
    L99:
        if (this.enableTouch == r6.enableTouch) goto L102;
        return false;
    L102:
        if (this.enableBurst == r6.enableBurst) goto L105;
        return false;
    L105:
        if (this.enableAudioRecorder == r6.enableAudioRecorder) goto L108;
        return false;
    L108:
        if (this.audioRecordChannels == r6.audioRecordChannels) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.imgData, r6.imgData) == true) goto L114;
        return false;
    L114:
        if (this.imgDataLen == r6.imgDataLen) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.updateAudioConfigPayload, r6.updateAudioConfigPayload) == true) goto L120;
        return false;
    L120:
        if (this.multimodalStatus == r6.multimodalStatus) goto L123;
        return false;
    L123:
        if (this.vuiQueryMode == r6.vuiQueryMode) goto L126;
        return false;
    L126:
        if (this.enableOneShot == r6.enableOneShot) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.wakeupWord, r6.wakeupWord) == true) goto L132;
        return false;
    L132:
        if (this.wakeupAudioDurationMs == r6.wakeupAudioDurationMs) goto L134;
        return false;
    L134:
        return true;
    }

    public int hashCode() {
        String r0 = this.taskId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.sessionId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.conversationId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        SpeechVoiceAssistantSessionRequestType r10 = this.requestType;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + this.business) * 31;
        String r13 = this.chat;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.trace;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.extra;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        int r22 = 1231;
        if (this.enableAudioInput == false) goto L33;
        int r23 = 1231;
    L34:
        int r24 = (r21 + r23) * 31;
        if (this.enableUploadAudio == false) goto L37;
        int r25 = 1231;
    L38:
        int r26 = (r24 + r25) * 31;
        if (this.enableTextReading == false) goto L41;
        int r27 = 1231;
    L42:
        int r28 = (r26 + r27) * 31;
        if (this.enablePlayer == false) goto L45;
        int r29 = 1231;
    L46:
        int r30 = (r28 + r29) * 31;
        if (this.enableRealtimeVoiceCall == false) goto L49;
        int r31 = 1231;
    L50:
        int r32 = (((r30 + r31) * 31) + this.interruptType) * 31;
        String r33 = this.question;
        if (r33 != null) goto L53;
        int r34 = 0;
    L54:
        int r35 = (r32 + r34) * 31;
        String r36 = this.reconnectQuestionId;
        if (r36 != null) goto L57;
        int r37 = 0;
    L58:
        int r38 = (((((r35 + r37) * 31) + this.reconnectStatus) * 31) + this.triggerType) * 31;
        String r39 = this.updateUIContextPayload;
        if (r39 != null) goto L61;
        int r40 = 0;
    L62:
        int r41 = (r38 + r40) * 31;
        String r42 = this.updatePersonalContextPayload;
        if (r42 != null) goto L65;
        int r43 = 0;
    L66:
        int r44 = (r41 + r43) * 31;
        String r45 = this.uploadInfoPayload;
        if (r45 != null) goto L69;
        int r46 = 0;
    L70:
        int r47 = (((((r44 + r46) * 31) + this.playerStatus) * 31) + Float.floatToIntBits(this.volume)) * 31;
        String r48 = this.sceneType;
        if (r48 != null) goto L73;
        int r49 = 0;
    L74:
        int r50 = (r47 + r49) * 31;
        String r51 = this.imageId;
        if (r51 != null) goto L77;
        int r52 = 0;
    L78:
        int r53 = (r50 + r52) * 31;
        String r54 = this.wakeupId;
        if (r54 != null) goto L81;
        int r55 = 0;
    L82:
        int r56 = (((((((((r53 + r55) * 31) + this.imageType) * 31) + this.intentMode) * 31) + this.imageStatus) * 31) + this.highQuality) * 31;
        if (this.enableTouch == false) goto L85;
        int r57 = 1231;
    L86:
        int r58 = (r56 + r57) * 31;
        if (this.enableBurst == false) goto L89;
        int r59 = 1231;
    L90:
        int r60 = (r58 + r59) * 31;
        if (this.enableAudioRecorder == false) goto L93;
        int r61 = 1231;
    L94:
        int r62 = (((r60 + r61) * 31) + this.audioRecordChannels) * 31;
        byte[] r63 = this.imgData;
        if (r63 != null) goto L97;
        int r64 = 0;
    L98:
        int r65 = (((r62 + r64) * 31) + this.imgDataLen) * 31;
        String r66 = this.updateAudioConfigPayload;
        if (r66 != null) goto L101;
        int r67 = 0;
    L102:
        int r68 = (((((r65 + r67) * 31) + this.multimodalStatus) * 31) + this.vuiQueryMode) * 31;
        if (this.enableOneShot == true) goto L106;
        r22 = 1237;
    L106:
        int r69 = (r68 + r22) * 31;
        String r70 = this.wakeupWord;
        if (r70 == null) goto L111;
        r1 = r70.hashCode();
    L111:
        return ((r69 + r1) * 31) + this.wakeupAudioDurationMs;
    L101:
        r67 = r66.hashCode();
        goto L102
    L97:
        r64 = Arrays.hashCode(r63);
        goto L98
    L93:
        r61 = 1237;
        goto L94
    L89:
        r59 = 1237;
        goto L90
    L85:
        r57 = 1237;
        goto L86
    L81:
        r55 = r54.hashCode();
        goto L82
    L77:
        r52 = r51.hashCode();
        goto L78
    L73:
        r49 = r48.hashCode();
        goto L74
    L69:
        r46 = r45.hashCode();
        goto L70
    L65:
        r43 = r42.hashCode();
        goto L66
    L61:
        r40 = r39.hashCode();
        goto L62
    L57:
        r37 = r36.hashCode();
        goto L58
    L53:
        r34 = r33.hashCode();
        goto L54
    L49:
        r31 = 1237;
        goto L50
    L45:
        r29 = 1237;
        goto L46
    L41:
        r27 = 1237;
        goto L42
    L37:
        r25 = 1237;
        goto L38
    L33:
        r23 = 1237;
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SpeechVoiceAssistantSessionStartSessionParam(taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", conversationId=" + this.conversationId + ", requestType=" + this.requestType + ", business=" + this.business + ", chat=" + this.chat + ", trace=" + this.trace + ", extra=" + this.extra + ", enableAudioInput=" + this.enableAudioInput + ", enableUploadAudio=" + this.enableUploadAudio + ", enableTextReading=" + this.enableTextReading + ", enablePlayer=" + this.enablePlayer + ", enableRealtimeVoiceCall=" + this.enableRealtimeVoiceCall + ", interruptType=" + this.interruptType + ", question=" + this.question + ", reconnectQuestionId=" + this.reconnectQuestionId + ", reconnectStatus=" + this.reconnectStatus + ", triggerType=" + this.triggerType + ", updateUIContextPayload=" + this.updateUIContextPayload + ", updatePersonalContextPayload=" + this.updatePersonalContextPayload + ", uploadInfoPayload=" + this.uploadInfoPayload + ", playerStatus=" + this.playerStatus + ", volume=" + this.volume + ", sceneType=" + this.sceneType + ", imageId=" + this.imageId + ", wakeupId=" + this.wakeupId + ", imageType=" + this.imageType + ", intentMode=" + this.intentMode + ", imageStatus=" + this.imageStatus + ", highQuality=" + this.highQuality + ", enableTouch=" + this.enableTouch + ", enableBurst=" + this.enableBurst + ", enableAudioRecorder=" + this.enableAudioRecorder + ", audioRecordChannels=" + this.audioRecordChannels + ", imgData=" + Arrays.toString(this.imgData) + ", imgDataLen=" + this.imgDataLen + ", updateAudioConfigPayload=" + this.updateAudioConfigPayload + ", multimodalStatus=" + this.multimodalStatus + ", vuiQueryMode=" + this.vuiQueryMode + ", enableOneShot=" + this.enableOneShot + ", wakeupWord=" + this.wakeupWord + ", wakeupAudioDurationMs=" + this.wakeupAudioDurationMs + ')';
    }

    public final int getAudioRecordChannels() {
        return this.audioRecordChannels;
    }

    public final int getBusiness() {
        return this.business;
    }

    public final String getChat() {
        return this.chat;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final boolean getEnableAudioInput() {
        return this.enableAudioInput;
    }

    public final boolean getEnableAudioRecorder() {
        return this.enableAudioRecorder;
    }

    public final boolean getEnableBurst() {
        return this.enableBurst;
    }

    public final boolean getEnableOneShot() {
        return this.enableOneShot;
    }

    public final boolean getEnablePlayer() {
        return this.enablePlayer;
    }

    public final boolean getEnableRealtimeVoiceCall() {
        return this.enableRealtimeVoiceCall;
    }

    public final boolean getEnableTextReading() {
        return this.enableTextReading;
    }

    public final boolean getEnableTouch() {
        return this.enableTouch;
    }

    public final boolean getEnableUploadAudio() {
        return this.enableUploadAudio;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final int getHighQuality() {
        return this.highQuality;
    }

    public final String getImageId() {
        return this.imageId;
    }

    public final int getImageStatus() {
        return this.imageStatus;
    }

    public final int getImageType() {
        return this.imageType;
    }

    public final byte[] getImgData() {
        return this.imgData;
    }

    public final int getImgDataLen() {
        return this.imgDataLen;
    }

    public final int getIntentMode() {
        return this.intentMode;
    }

    public final int getInterruptType() {
        return this.interruptType;
    }

    public final int getMultimodalStatus() {
        return this.multimodalStatus;
    }

    public final int getPlayerStatus() {
        return this.playerStatus;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final String getReconnectQuestionId() {
        return this.reconnectQuestionId;
    }

    public final int getReconnectStatus() {
        return this.reconnectStatus;
    }

    public final SpeechVoiceAssistantSessionRequestType getRequestType() {
        return this.requestType;
    }

    public final String getSceneType() {
        return this.sceneType;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTrace() {
        return this.trace;
    }

    public final int getTriggerType() {
        return this.triggerType;
    }

    public final String getUpdateAudioConfigPayload() {
        return this.updateAudioConfigPayload;
    }

    public final String getUpdatePersonalContextPayload() {
        return this.updatePersonalContextPayload;
    }

    public final String getUpdateUIContextPayload() {
        return this.updateUIContextPayload;
    }

    public final String getUploadInfoPayload() {
        return this.uploadInfoPayload;
    }

    public final float getVolume() {
        return this.volume;
    }

    public final int getVuiQueryMode() {
        return this.vuiQueryMode;
    }

    public final int getWakeupAudioDurationMs() {
        return this.wakeupAudioDurationMs;
    }

    public final String getWakeupId() {
        return this.wakeupId;
    }

    public final String getWakeupWord() {
        return this.wakeupWord;
    }

    public SpeechVoiceAssistantSessionStartSessionParam(String r3, String r4, String r5, SpeechVoiceAssistantSessionRequestType r6, int r7, String r8, String r9, String r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, int r16, String r17, String r18, int r19, int r20, String r21, String r22, String r23, int r24, float r25, String r26, String r27, String r28, int r29, int r30, int r31, int r32, boolean r33, boolean r34, boolean r35, int r36, byte[] r37, int r38, String r39, int r40, int r41, boolean r42, String r43, int r44) {
        this.taskId = r3;
        this.sessionId = r4;
        this.conversationId = r5;
        this.requestType = r6;
        this.business = r7;
        this.chat = r8;
        this.trace = r9;
        this.extra = r10;
        this.enableAudioInput = r11;
        this.enableUploadAudio = r12;
        this.enableTextReading = r13;
        this.enablePlayer = r14;
        this.enableRealtimeVoiceCall = r15;
        this.interruptType = r16;
        this.question = r17;
        this.reconnectQuestionId = r18;
        this.reconnectStatus = r19;
        this.triggerType = r20;
        this.updateUIContextPayload = r21;
        this.updatePersonalContextPayload = r22;
        this.uploadInfoPayload = r23;
        this.playerStatus = r24;
        this.volume = r25;
        this.sceneType = r26;
        this.imageId = r27;
        this.wakeupId = r28;
        this.imageType = r29;
        this.intentMode = r30;
        this.imageStatus = r31;
        this.highQuality = r32;
        this.enableTouch = r33;
        this.enableBurst = r34;
        this.enableAudioRecorder = r35;
        this.audioRecordChannels = r36;
        this.imgData = r37;
        this.imgDataLen = r38;
        this.updateAudioConfigPayload = r39;
        this.multimodalStatus = r40;
        this.vuiQueryMode = r41;
        this.enableOneShot = r42;
        this.wakeupWord = r43;
        this.wakeupAudioDurationMs = r44;
    }

    public /* synthetic */ SpeechVoiceAssistantSessionStartSessionParam(String r42, String r43, String r44, SpeechVoiceAssistantSessionRequestType r45, int r46, String r47, String r48, String r49, boolean r50, boolean r51, boolean r52, boolean r53, boolean r54, int r55, String r56, String r57, int r58, int r59, String r60, String r61, String r62, int r63, float r64, String r65, String r66, String r67, int r68, int r69, int r70, int r71, boolean r72, boolean r73, boolean r74, int r75, byte[] r76, int r77, String r78, int r79, int r80, boolean r81, String r82, int r83, int r84, int r85, DefaultConstructorMarker r86) {
        if ((r84 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r84 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r84 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r84 & 8) == 0) goto L17;
        SpeechVoiceAssistantSessionRequestType r6 = null;
    L19:
        if ((r84 & 16) == 0) goto L21;
        int r7 = 0;
    L23:
        if ((r84 & 32) == 0) goto L25;
        String r9 = null;
    L27:
        if ((r84 & 64) == 0) goto L29;
        String r10 = null;
    L31:
        if ((r84 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L33;
        String r11 = null;
    L35:
        if ((r84 & 256) == 0) goto L37;
        boolean r12 = false;
    L39:
        if ((r84 & 512) == 0) goto L41;
        boolean r13 = false;
    L43:
        if ((r84 & 1024) == 0) goto L45;
        boolean r14 = false;
    L47:
        if ((r84 & 2048) == 0) goto L49;
        boolean r15 = false;
    L51:
        if ((r84 & 4096) == 0) goto L53;
        boolean r3 = false;
    L55:
        if ((r84 & 8192) == 0) goto L57;
        int r8 = 0;
    L58:
        int r16 = r8;
        if ((r84 & 16384) == 0) goto L61;
        String r17 = null;
    L63:
        if ((r84 & 32768) == 0) goto L65;
        String r18 = null;
    L67:
        if ((r84 & 65536) == 0) goto L69;
        int r19 = 0;
    L71:
        if ((r84 & 131072) == 0) goto L73;
        int r110 = 0;
    L75:
        if ((r84 & 262144) == 0) goto L77;
        String r20 = null;
    L79:
        if ((r84 & 524288) == 0) goto L81;
        String r21 = null;
    L83:
        if ((r84 & 1048576) == 0) goto L85;
        String r22 = null;
    L87:
        if ((r84 & 2097152) == 0) goto L89;
        int r23 = 0;
    L91:
        if ((r84 & 4194304) == 0) goto L93;
        float r24 = 0.0f;
    L95:
        if ((r84 & 8388608) == 0) goto L97;
        String r25 = null;
    L99:
        if ((r84 & 16777216) == 0) goto L101;
        String r26 = null;
    L103:
        if ((r84 & 33554432) == 0) goto L105;
        String r27 = null;
    L107:
        if ((r84 & 67108864) == 0) goto L109;
        int r28 = 0;
    L111:
        if ((r84 & 134217728) == 0) goto L113;
        int r29 = 0;
    L115:
        if ((r84 & 268435456) == 0) goto L117;
        int r30 = 0;
    L119:
        if ((r84 & 536870912) == 0) goto L121;
        int r31 = 0;
    L123:
        if ((r84 & 1073741824) == 0) goto L125;
        boolean r32 = false;
    L127:
        if ((r84 & Integer.MIN_VALUE) == 0) goto L129;
        boolean r0 = false;
    L131:
        if ((r85 & 1) == 0) goto L133;
        boolean r33 = false;
    L135:
        if ((r85 & 2) == 0) goto L137;
        int r34 = 0;
    L139:
        if ((r85 & 4) == 0) goto L141;
        byte[] r35 = null;
    L143:
        if ((r85 & 8) == 0) goto L145;
        int r36 = 0;
    L147:
        if ((r85 & 16) == 0) goto L149;
        String r37 = null;
    L151:
        if ((r85 & 32) == 0) goto L153;
        int r38 = 0;
    L155:
        if ((r85 & 64) == 0) goto L157;
        int r39 = 0;
    L158:
        boolean r87 = r0;
        if ((r85 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L161;
        boolean r1 = false;
    L162:
        boolean r40 = r1;
        if ((r85 & 256) == 0) goto L165;
        String r41 = null;
    L167:
        if ((r85 & 512) == 0) goto L169;
        int r88 = 0;
    L170:
        this(r2, r4, r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r3, r16, r17, r18, r19, r110, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r87, r33, r34, r35, r36, r37, r38, r39, r40, r41, r88);
        return;
    L169:
        r88 = r83;
        goto L170
    L165:
        r41 = r82;
        goto L167
    L161:
        r1 = r81;
        goto L162
    L157:
        r39 = r80;
        goto L158
    L153:
        r38 = r79;
        goto L155
    L149:
        r37 = r78;
        goto L151
    L145:
        r36 = r77;
        goto L147
    L141:
        r35 = r76;
        goto L143
    L137:
        r34 = r75;
        goto L139
    L133:
        r33 = r74;
        goto L135
    L129:
        r0 = r73;
        goto L131
    L125:
        r32 = r72;
        goto L127
    L121:
        r31 = r71;
        goto L123
    L117:
        r30 = r70;
        goto L119
    L113:
        r29 = r69;
        goto L115
    L109:
        r28 = r68;
        goto L111
    L105:
        r27 = r67;
        goto L107
    L101:
        r26 = r66;
        goto L103
    L97:
        r25 = r65;
        goto L99
    L93:
        r24 = r64;
        goto L95
    L89:
        r23 = r63;
        goto L91
    L85:
        r22 = r62;
        goto L87
    L81:
        r21 = r61;
        goto L83
    L77:
        r20 = r60;
        goto L79
    L73:
        r110 = r59;
        goto L75
    L69:
        r19 = r58;
        goto L71
    L65:
        r18 = r57;
        goto L67
    L61:
        r17 = r56;
        goto L63
    L57:
        r8 = r55;
        goto L58
    L53:
        r3 = r54;
        goto L55
    L49:
        r15 = r53;
        goto L51
    L45:
        r14 = r52;
        goto L47
    L41:
        r13 = r51;
        goto L43
    L37:
        r12 = r50;
        goto L39
    L33:
        r11 = r49;
        goto L35
    L29:
        r10 = r48;
        goto L31
    L25:
        r9 = r47;
        goto L27
    L21:
        r7 = r46;
        goto L23
    L17:
        r6 = r45;
        goto L19
    L13:
        r5 = r44;
        goto L15
    L9:
        r4 = r43;
        goto L11
    L5:
        r2 = r42;
        goto L7
    }
}
