package com.mammon.speechaudiosdk.kmp.param.va;

import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.mammon.speechaudiosdk.kmp.param.SpeechAudioConfigParam;
import com.mammon.speechaudiosdk.kmp.type.SpeechAudioTokenType;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\bK\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000e\u0012\b\b\u0002\u0010 \u001a\u00020\u000e\u0012\b\b\u0002\u0010!\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010#\u0012\b\b\u0002\u0010$\u001a\u00020\u000e\u0012\b\b\u0002\u0010%\u001a\u00020\u000e¢\u0006\u0004\b&\u0010'J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u000eHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u000eHÆ\u0003J\t\u0010Y\u001a\u00020\u000eHÆ\u0003J\t\u0010Z\u001a\u00020\u000eHÆ\u0003J\t\u0010[\u001a\u00020\u000eHÆ\u0003J\t\u0010\\\u001a\u00020\u000eHÆ\u0003J\t\u0010]\u001a\u00020\u0018HÆ\u0003J\t\u0010^\u001a\u00020\u000eHÆ\u0003J\t\u0010_\u001a\u00020\u000eHÆ\u0003J\t\u0010`\u001a\u00020\u000eHÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u001eHÆ\u0003J\t\u0010c\u001a\u00020\u000eHÆ\u0003J\t\u0010d\u001a\u00020\u000eHÆ\u0003J\t\u0010e\u001a\u00020\u000eHÆ\u0003J\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010#HÆ\u0003J\t\u0010g\u001a\u00020\u000eHÆ\u0003J\t\u0010h\u001a\u00020\u000eHÆ\u0003JÉ\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000eHÆ\u0001J\u0013\u0010j\u001a\u00020\u001e2\b\u0010k\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010l\u001a\u00020\u000eHÖ\u0001J\t\u0010m\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010+R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010+R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010+R\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u00104R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u00104R\u0011\u0010\u0014\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u00104R\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u00104R\u0011\u0010\u0016\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u00104R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0019\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u00104R\u0011\u0010\u001a\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u00104R\u0011\u0010\u001b\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u00104R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010+R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010\u001f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u00104R\u0011\u0010 \u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u00104R\u0011\u0010!\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u00104R\u0019\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010$\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u00104R\u0011\u0010%\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bK\u00104¨\u0006n"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionAsrContextParam;", NameKeys.UnloadStrategy_No_Strategy, "audioConfig", "Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioConfigParam;", LynxEventReporter.PROP_NAME_URL, NameKeys.UnloadStrategy_No_Strategy, "appKey", "header", "taskId", "sessionId", "tokenType", "Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioTokenType;", "token", "connectTimeout", NameKeys.UnloadStrategy_No_Strategy, "language", "extra", "model", "sosSilenceTimeout", "eosSilenceTimeout", "sentenceMaxTime", "enablePunctuation", "enableSpeakerDiarization", "timestamp", NameKeys.UnloadStrategy_No_Strategy, "enableAudioCache", "audioCacheSize", "enableRemoveFirstAudioData", "businessInfo", "enableSpeechRejection", NameKeys.UnloadStrategy_No_Strategy, "audioSrc", "retryMode", "retryCount", "retryIntervalTimeMs", NameKeys.UnloadStrategy_No_Strategy, "maxBufferCount", "finishWaitTimeout", "<init>", "(Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioConfigParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioTokenType;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIJIIILjava/lang/String;ZIIILjava/util/List;II)V", "getAudioConfig", "()Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioConfigParam;", "getUrl", "()Ljava/lang/String;", "getAppKey", "getHeader", "getTaskId", "getSessionId", "getTokenType", "()Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioTokenType;", "getToken", "getConnectTimeout", "()I", "getLanguage", "getExtra", "getModel", "getSosSilenceTimeout", "getEosSilenceTimeout", "getSentenceMaxTime", "getEnablePunctuation", "getEnableSpeakerDiarization", "getTimestamp", "()J", "getEnableAudioCache", "getAudioCacheSize", "getEnableRemoveFirstAudioData", "getBusinessInfo", "getEnableSpeechRejection", "()Z", "getAudioSrc", "getRetryMode", "getRetryCount", "getRetryIntervalTimeMs", "()Ljava/util/List;", "getMaxBufferCount", "getFinishWaitTimeout", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "equals", "other", "hashCode", "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechVoiceAssistantSessionAsrContextParam {
    private final String appKey;
    private final int audioCacheSize;
    private final SpeechAudioConfigParam audioConfig;
    private final int audioSrc;
    private final String businessInfo;
    private final int connectTimeout;
    private final int enableAudioCache;
    private final int enablePunctuation;
    private final int enableRemoveFirstAudioData;
    private final int enableSpeakerDiarization;
    private final boolean enableSpeechRejection;
    private final int eosSilenceTimeout;
    private final String extra;
    private final int finishWaitTimeout;
    private final String header;
    private final String language;
    private final int maxBufferCount;
    private final String model;
    private final int retryCount;
    private final List<Integer> retryIntervalTimeMs;
    private final int retryMode;
    private final int sentenceMaxTime;
    private final String sessionId;
    private final int sosSilenceTimeout;
    private final String taskId;
    private final long timestamp;
    private final String token;
    private final SpeechAudioTokenType tokenType;
    private final String url;

    public SpeechVoiceAssistantSessionAsrContextParam() {
        this(null, null, null, null, null, null, null, null, 0, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, false, 0, 0, 0, null, 0, 0, 536870911, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpeechVoiceAssistantSessionAsrContextParam copy$default(SpeechVoiceAssistantSessionAsrContextParam r17, SpeechAudioConfigParam r18, String r19, String r20, String r21, String r22, String r23, SpeechAudioTokenType r24, String r25, int r26, String r27, String r28, String r29, int r30, int r31, int r32, int r33, int r34, long r35, int r37, int r38, int r39, String r40, boolean r41, int r42, int r43, int r44, List r45, int r46, int r47, int r48, Object r49) {
        if ((r48 & 1) == 0) goto L5;
        SpeechAudioConfigParam r2 = r17.audioConfig;
    L7:
        if ((r48 & 2) == 0) goto L9;
        String r3 = r17.url;
    L11:
        if ((r48 & 4) == 0) goto L13;
        String r4 = r17.appKey;
    L15:
        if ((r48 & 8) == 0) goto L17;
        String r5 = r17.header;
    L19:
        if ((r48 & 16) == 0) goto L21;
        String r6 = r17.taskId;
    L23:
        if ((r48 & 32) == 0) goto L25;
        String r7 = r17.sessionId;
    L27:
        if ((r48 & 64) == 0) goto L29;
        SpeechAudioTokenType r8 = r17.tokenType;
    L31:
        if ((r48 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L33;
        String r9 = r17.token;
    L35:
        if ((r48 & 256) == 0) goto L37;
        int r10 = r17.connectTimeout;
    L39:
        if ((r48 & 512) == 0) goto L41;
        String r11 = r17.language;
    L43:
        if ((r48 & 1024) == 0) goto L45;
        String r12 = r17.extra;
    L47:
        if ((r48 & 2048) == 0) goto L49;
        String r13 = r17.model;
    L51:
        if ((r48 & 4096) == 0) goto L53;
        int r14 = r17.sosSilenceTimeout;
    L55:
        if ((r48 & 8192) == 0) goto L57;
        int r15 = r17.eosSilenceTimeout;
    L58:
        int r36 = r15;
        if ((r48 & 16384) == 0) goto L61;
        int r16 = r17.sentenceMaxTime;
    L62:
        int r310 = r16;
        if ((r48 & 32768) == 0) goto L65;
        int r110 = r17.enablePunctuation;
    L66:
        int r311 = r110;
        if ((r48 & 65536) == 0) goto L69;
        int r111 = r17.enableSpeakerDiarization;
    L70:
        int r312 = r14;
        int r313 = r111;
        if ((r48 & 131072) == 0) goto L73;
        long r112 = r17.timestamp;
    L74:
        long r314 = r112;
        if ((r48 & 262144) == 0) goto L77;
        int r113 = r17.enableAudioCache;
    L79:
        if ((524288 & r48) == 0) goto L81;
        int r114 = r17.audioCacheSize;
    L82:
        int r315 = r114;
        if ((r48 & 1048576) == 0) goto L85;
        int r115 = r17.enableRemoveFirstAudioData;
    L86:
        int r316 = r115;
        if ((r48 & 2097152) == 0) goto L89;
        String r116 = r17.businessInfo;
    L90:
        String r410 = r116;
        if ((r48 & 4194304) == 0) goto L93;
        boolean r117 = r17.enableSpeechRejection;
    L94:
        boolean r411 = r117;
        if ((r48 & 8388608) == 0) goto L97;
        int r118 = r17.audioSrc;
    L98:
        int r412 = r118;
        if ((r48 & 16777216) == 0) goto L101;
        int r119 = r17.retryMode;
    L102:
        int r413 = r119;
        if ((r48 & 33554432) == 0) goto L105;
        int r120 = r17.retryCount;
    L106:
        int r414 = r120;
        if ((r48 & 67108864) == 0) goto L109;
        List r121 = r17.retryIntervalTimeMs;
    L110:
        List r415 = r121;
        if ((r48 & 134217728) == 0) goto L113;
        int r122 = r17.maxBufferCount;
    L115:
        if ((r48 & 268435456) == 0) goto L117;
        int r1 = r17.finishWaitTimeout;
    L119:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r312, r36, r310, r311, r313, r314, r113, r315, r316, r410, r411, r412, r413, r414, r415, r122, r1);
    L117:
        r1 = r47;
        goto L119
    L113:
        r122 = r46;
        goto L115
    L109:
        r121 = r45;
        goto L110
    L105:
        r120 = r44;
        goto L106
    L101:
        r119 = r43;
        goto L102
    L97:
        r118 = r42;
        goto L98
    L93:
        r117 = r41;
        goto L94
    L89:
        r116 = r40;
        goto L90
    L85:
        r115 = r39;
        goto L86
    L81:
        r114 = r38;
        goto L82
    L77:
        r113 = r37;
        goto L79
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final SpeechAudioConfigParam component1() {
        return this.audioConfig;
    }

    public final String component10() {
        return this.language;
    }

    public final String component11() {
        return this.extra;
    }

    public final String component12() {
        return this.model;
    }

    public final int component13() {
        return this.sosSilenceTimeout;
    }

    public final int component14() {
        return this.eosSilenceTimeout;
    }

    public final int component15() {
        return this.sentenceMaxTime;
    }

    public final int component16() {
        return this.enablePunctuation;
    }

    public final int component17() {
        return this.enableSpeakerDiarization;
    }

    public final long component18() {
        return this.timestamp;
    }

    public final int component19() {
        return this.enableAudioCache;
    }

    public final String component2() {
        return this.url;
    }

    public final int component20() {
        return this.audioCacheSize;
    }

    public final int component21() {
        return this.enableRemoveFirstAudioData;
    }

    public final String component22() {
        return this.businessInfo;
    }

    public final boolean component23() {
        return this.enableSpeechRejection;
    }

    public final int component24() {
        return this.audioSrc;
    }

    public final int component25() {
        return this.retryMode;
    }

    public final int component26() {
        return this.retryCount;
    }

    public final List<Integer> component27() {
        return this.retryIntervalTimeMs;
    }

    public final int component28() {
        return this.maxBufferCount;
    }

    public final int component29() {
        return this.finishWaitTimeout;
    }

    public final String component3() {
        return this.appKey;
    }

    public final String component4() {
        return this.header;
    }

    public final String component5() {
        return this.taskId;
    }

    public final String component6() {
        return this.sessionId;
    }

    public final SpeechAudioTokenType component7() {
        return this.tokenType;
    }

    public final String component8() {
        return this.token;
    }

    public final int component9() {
        return this.connectTimeout;
    }

    public final SpeechVoiceAssistantSessionAsrContextParam copy(SpeechAudioConfigParam r34, String r35, String r36, String r37, String r38, String r39, SpeechAudioTokenType r40, String r41, int r42, String r43, String r44, String r45, int r46, int r47, int r48, int r49, int r50, long r51, int r53, int r54, int r55, String r56, boolean r57, int r58, int r59, int r60, List<Integer> r61, int r62, int r63) {
        Intrinsics.checkNotNullParameter(r34, "audioConfig");
        return new SpeechVoiceAssistantSessionAsrContextParam(r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SpeechVoiceAssistantSessionAsrContextParam) == true) goto L8;
        return false;
    L8:
        SpeechVoiceAssistantSessionAsrContextParam r9 = (SpeechVoiceAssistantSessionAsrContextParam) r8;
        if (Intrinsics.areEqual(this.audioConfig, r9.audioConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r9.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appKey, r9.appKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.header, r9.header) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.taskId, r9.taskId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sessionId, r9.sessionId) == true) goto L27;
        return false;
    L27:
        if (this.tokenType == r9.tokenType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.token, r9.token) == true) goto L33;
        return false;
    L33:
        if (this.connectTimeout == r9.connectTimeout) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.language, r9.language) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.extra, r9.extra) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.model, r9.model) == true) goto L45;
        return false;
    L45:
        if (this.sosSilenceTimeout == r9.sosSilenceTimeout) goto L48;
        return false;
    L48:
        if (this.eosSilenceTimeout == r9.eosSilenceTimeout) goto L51;
        return false;
    L51:
        if (this.sentenceMaxTime == r9.sentenceMaxTime) goto L54;
        return false;
    L54:
        if (this.enablePunctuation == r9.enablePunctuation) goto L57;
        return false;
    L57:
        if (this.enableSpeakerDiarization == r9.enableSpeakerDiarization) goto L60;
        return false;
    L60:
        if (this.timestamp == r9.timestamp) goto L63;
        return false;
    L63:
        if (this.enableAudioCache == r9.enableAudioCache) goto L66;
        return false;
    L66:
        if (this.audioCacheSize == r9.audioCacheSize) goto L69;
        return false;
    L69:
        if (this.enableRemoveFirstAudioData == r9.enableRemoveFirstAudioData) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.businessInfo, r9.businessInfo) == true) goto L75;
        return false;
    L75:
        if (this.enableSpeechRejection == r9.enableSpeechRejection) goto L78;
        return false;
    L78:
        if (this.audioSrc == r9.audioSrc) goto L81;
        return false;
    L81:
        if (this.retryMode == r9.retryMode) goto L84;
        return false;
    L84:
        if (this.retryCount == r9.retryCount) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.retryIntervalTimeMs, r9.retryIntervalTimeMs) == true) goto L90;
        return false;
    L90:
        if (this.maxBufferCount == r9.maxBufferCount) goto L93;
        return false;
    L93:
        if (this.finishWaitTimeout == r9.finishWaitTimeout) goto L95;
        return false;
    L95:
        return true;
    }

    public int hashCode() {
        int r0 = this.audioConfig.hashCode() * 31;
        String r1 = this.url;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.appKey;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.header;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.taskId;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.sessionId;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        SpeechAudioTokenType r17 = this.tokenType;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.token;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (((r19 + r21) * 31) + this.connectTimeout) * 31;
        String r23 = this.language;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.extra;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.model;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (((((((((((r28 + r30) * 31) + this.sosSilenceTimeout) * 31) + this.eosSilenceTimeout) * 31) + this.sentenceMaxTime) * 31) + this.enablePunctuation) * 31) + this.enableSpeakerDiarization) * 31;
        long r32 = this.timestamp;
        int r33 = (((((((r31 + ((int) (r32 ^ (r32 >>> 32)))) * 31) + this.enableAudioCache) * 31) + this.audioCacheSize) * 31) + this.enableRemoveFirstAudioData) * 31;
        String r34 = this.businessInfo;
        if (r34 != null) goto L45;
        int r35 = 0;
    L46:
        int r36 = (r33 + r35) * 31;
        if (this.enableSpeechRejection == false) goto L49;
        int r37 = 1231;
    L50:
        int r38 = (((((((r36 + r37) * 31) + this.audioSrc) * 31) + this.retryMode) * 31) + this.retryCount) * 31;
        List<Integer> r39 = this.retryIntervalTimeMs;
        if (r39 == null) goto L55;
        r2 = r39.hashCode();
    L55:
        return ((((r38 + r2) * 31) + this.maxBufferCount) * 31) + this.finishWaitTimeout;
    L49:
        r37 = 1237;
        goto L50
    L45:
        r35 = r34.hashCode();
        goto L46
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SpeechVoiceAssistantSessionAsrContextParam(audioConfig=" + this.audioConfig + ", url=" + this.url + ", appKey=" + this.appKey + ", header=" + this.header + ", taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", tokenType=" + this.tokenType + ", token=" + this.token + ", connectTimeout=" + this.connectTimeout + ", language=" + this.language + ", extra=" + this.extra + ", model=" + this.model + ", sosSilenceTimeout=" + this.sosSilenceTimeout + ", eosSilenceTimeout=" + this.eosSilenceTimeout + ", sentenceMaxTime=" + this.sentenceMaxTime + ", enablePunctuation=" + this.enablePunctuation + ", enableSpeakerDiarization=" + this.enableSpeakerDiarization + ", timestamp=" + this.timestamp + ", enableAudioCache=" + this.enableAudioCache + ", audioCacheSize=" + this.audioCacheSize + ", enableRemoveFirstAudioData=" + this.enableRemoveFirstAudioData + ", businessInfo=" + this.businessInfo + ", enableSpeechRejection=" + this.enableSpeechRejection + ", audioSrc=" + this.audioSrc + ", retryMode=" + this.retryMode + ", retryCount=" + this.retryCount + ", retryIntervalTimeMs=" + this.retryIntervalTimeMs + ", maxBufferCount=" + this.maxBufferCount + ", finishWaitTimeout=" + this.finishWaitTimeout + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final int getAudioCacheSize() {
        return this.audioCacheSize;
    }

    public final SpeechAudioConfigParam getAudioConfig() {
        return this.audioConfig;
    }

    public final int getAudioSrc() {
        return this.audioSrc;
    }

    public final String getBusinessInfo() {
        return this.businessInfo;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final int getEnableAudioCache() {
        return this.enableAudioCache;
    }

    public final int getEnablePunctuation() {
        return this.enablePunctuation;
    }

    public final int getEnableRemoveFirstAudioData() {
        return this.enableRemoveFirstAudioData;
    }

    public final int getEnableSpeakerDiarization() {
        return this.enableSpeakerDiarization;
    }

    public final boolean getEnableSpeechRejection() {
        return this.enableSpeechRejection;
    }

    public final int getEosSilenceTimeout() {
        return this.eosSilenceTimeout;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final int getFinishWaitTimeout() {
        return this.finishWaitTimeout;
    }

    public final String getHeader() {
        return this.header;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final int getMaxBufferCount() {
        return this.maxBufferCount;
    }

    public final String getModel() {
        return this.model;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final List<Integer> getRetryIntervalTimeMs() {
        return this.retryIntervalTimeMs;
    }

    public final int getRetryMode() {
        return this.retryMode;
    }

    public final int getSentenceMaxTime() {
        return this.sentenceMaxTime;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getSosSilenceTimeout() {
        return this.sosSilenceTimeout;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getToken() {
        return this.token;
    }

    public final SpeechAudioTokenType getTokenType() {
        return this.tokenType;
    }

    public final String getUrl() {
        return this.url;
    }

    public SpeechVoiceAssistantSessionAsrContextParam(SpeechAudioConfigParam r4, String r5, String r6, String r7, String r8, String r9, SpeechAudioTokenType r10, String r11, int r12, String r13, String r14, String r15, int r16, int r17, int r18, int r19, int r20, long r21, int r23, int r24, int r25, String r26, boolean r27, int r28, int r29, int r30, List<Integer> r31, int r32, int r33) {
        Intrinsics.checkNotNullParameter(r4, "audioConfig");
        this.audioConfig = r4;
        this.url = r5;
        this.appKey = r6;
        this.header = r7;
        this.taskId = r8;
        this.sessionId = r9;
        this.tokenType = r10;
        this.token = r11;
        this.connectTimeout = r12;
        this.language = r13;
        this.extra = r14;
        this.model = r15;
        this.sosSilenceTimeout = r16;
        this.eosSilenceTimeout = r17;
        this.sentenceMaxTime = r18;
        this.enablePunctuation = r19;
        this.enableSpeakerDiarization = r20;
        this.timestamp = r21;
        this.enableAudioCache = r23;
        this.audioCacheSize = r24;
        this.enableRemoveFirstAudioData = r25;
        this.businessInfo = r26;
        this.enableSpeechRejection = r27;
        this.audioSrc = r28;
        this.retryMode = r29;
        this.retryCount = r30;
        this.retryIntervalTimeMs = r31;
        this.maxBufferCount = r32;
        this.finishWaitTimeout = r33;
    }

    public /* synthetic */ SpeechVoiceAssistantSessionAsrContextParam(SpeechAudioConfigParam r32, String r33, String r34, String r35, String r36, String r37, SpeechAudioTokenType r38, String r39, int r40, String r41, String r42, String r43, int r44, int r45, int r46, int r47, int r48, long r49, int r51, int r52, int r53, String r54, boolean r55, int r56, int r57, int r58, List r59, int r60, int r61, int r62, DefaultConstructorMarker r63) {
        if ((r62 & 1) == 0) goto L5;
        SpeechAudioConfigParam r1 = new SpeechAudioConfigParam(null, 0, 0, 0, false, false, 63, null);
    L7:
        if ((r62 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r62 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r62 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r62 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r62 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r62 & 64) == 0) goto L29;
        SpeechAudioTokenType r8 = null;
    L31:
        if ((r62 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r62 & 256) == 0) goto L37;
        int r10 = 0;
    L39:
        if ((r62 & 512) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r62 & 1024) == 0) goto L45;
        String r13 = null;
    L47:
        if ((r62 & 2048) == 0) goto L49;
        String r14 = null;
    L51:
        if ((r62 & 4096) == 0) goto L53;
        int r15 = 0;
    L55:
        if ((r62 & 8192) == 0) goto L57;
        int r3 = 0;
    L59:
        if ((r62 & 16384) == 0) goto L61;
        int r11 = 0;
    L63:
        if ((r62 & 32768) == 0) goto L65;
        int r16 = 0;
    L67:
        if ((r62 & 65536) == 0) goto L69;
        int r17 = 0;
    L71:
        if ((r62 & 131072) == 0) goto L73;
        long r18 = 0;
    L75:
        if ((r62 & 262144) == 0) goto L77;
        int r20 = 0;
    L79:
        if ((r62 & 524288) == 0) goto L81;
        int r21 = 0;
    L83:
        if ((r62 & 1048576) == 0) goto L85;
        int r22 = 0;
    L87:
        if ((r62 & 2097152) == 0) goto L89;
        String r23 = null;
    L91:
        if ((r62 & 4194304) == 0) goto L93;
        boolean r24 = false;
    L95:
        if ((r62 & 8388608) == 0) goto L97;
        int r25 = 0;
    L99:
        if ((r62 & 16777216) == 0) goto L101;
        int r26 = 0;
    L103:
        if ((r62 & 33554432) == 0) goto L105;
        int r27 = 0;
    L107:
        if ((r62 & 67108864) == 0) goto L109;
        List r28 = null;
    L111:
        if ((r62 & 134217728) == 0) goto L113;
        int r29 = 0;
    L115:
        if ((r62 & 268435456) == 0) goto L117;
        int r0 = 0;
    L118:
        this(r1, r2, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r3, r11, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r0);
        return;
    L117:
        r0 = r61;
        goto L118
    L113:
        r29 = r60;
        goto L115
    L109:
        r28 = r59;
        goto L111
    L105:
        r27 = r58;
        goto L107
    L101:
        r26 = r57;
        goto L103
    L97:
        r25 = r56;
        goto L99
    L93:
        r24 = r55;
        goto L95
    L89:
        r23 = r54;
        goto L91
    L85:
        r22 = r53;
        goto L87
    L81:
        r21 = r52;
        goto L83
    L77:
        r20 = r51;
        goto L79
    L73:
        r18 = r49;
        goto L75
    L69:
        r17 = r48;
        goto L71
    L65:
        r16 = r47;
        goto L67
    L61:
        r11 = r46;
        goto L63
    L57:
        r3 = r45;
        goto L59
    L53:
        r15 = r44;
        goto L55
    L49:
        r14 = r43;
        goto L51
    L45:
        r13 = r42;
        goto L47
    L41:
        r12 = r41;
        goto L43
    L37:
        r10 = r40;
        goto L39
    L33:
        r9 = r39;
        goto L35
    L29:
        r8 = r38;
        goto L31
    L25:
        r7 = r37;
        goto L27
    L21:
        r6 = r36;
        goto L23
    L17:
        r5 = r35;
        goto L19
    L13:
        r4 = r34;
        goto L15
    L9:
        r2 = r33;
        goto L11
    L5:
        r1 = r32;
        goto L7
    }
}
