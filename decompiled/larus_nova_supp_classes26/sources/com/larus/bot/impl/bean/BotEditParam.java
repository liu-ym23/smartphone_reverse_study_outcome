package com.larus.bot.impl.bean;

import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bM\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B³\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0012\u0012\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b#\u0010$J\u0006\u0010j\u001a\u00020kJ\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\t\u0010n\u001a\u00020\u0003HÆ\u0003J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\t\u0010r\u001a\u00020\nHÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010u\u001a\u00020\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010w\u001a\u00020\u0012HÆ\u0003J\u0010\u0010x\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010HJ\u0010\u0010y\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010HJ\u000b\u0010z\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010HJ\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010HJ\u001d\u0010~\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001bHÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¼\u0002\u0010\u0085\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u0086\u0001J\u0015\u0010\u0087\u0001\u001a\u00020\u00122\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010\u0089\u0001\u001a\u00030\u008a\u0001HÖ\u0001J\n\u0010\u008b\u0001\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010&\"\u0004\b2\u0010(R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010&\"\u0004\b@\u0010(R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010&\"\u0004\bB\u0010(R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\bL\u0010H\"\u0004\bM\u0010JR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\bR\u0010H\"\u0004\bS\u0010JR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010&\"\u0004\bU\u0010(R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\bV\u0010H\"\u0004\bW\u0010JR.\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010&\"\u0004\ba\u0010(R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010&\"\u0004\bc\u0010(R\u001c\u0010 \u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010&\"\u0004\be\u0010(R\u001c\u0010!\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010&\"\u0004\bg\u0010(R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010&\"\u0004\bi\u0010(¨\u0006\u008c\u0001"}, d2 = {"Lcom/larus/bot/impl/bean/BotEditParam;", "", "botId", "", "name", "description", "bio", "iconUrl", "iconUri", "modelType", "", "voice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "language", "Lcom/larus/bmhome/bot/bean/BotLanguage;", "avatarPrompt", "avatarPromptForEnrich", "hasUsedAutoFill", "", "enableWebSearch", "enableGenPic", "modelItem", "Lcom/larus/im/bean/bot/ModelItem;", "muted", "prologue", "suggestSwitch", "suggests", "Lkotlin/Triple;", "bgImage", "Lcom/larus/im/bean/bot/BgImage;", "userBotTypeStarlingKey", "userBotGenderStarlingKey", "originalUserImgUri", "originalAvatarImgUri", "originalBackgroundImgUri", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/larus/im/bean/bot/SpeakerVoice;Lcom/larus/bmhome/bot/bean/BotLanguage;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/ModelItem;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/Triple;Lcom/larus/im/bean/bot/BgImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBotId", "()Ljava/lang/String;", "setBotId", "(Ljava/lang/String;)V", "getName", "setName", "getDescription", "setDescription", "getBio", "setBio", "getIconUrl", "setIconUrl", "getIconUri", "setIconUri", "getModelType", "()J", "setModelType", "(J)V", "getVoice", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "setVoice", "(Lcom/larus/im/bean/bot/SpeakerVoice;)V", "getLanguage", "()Lcom/larus/bmhome/bot/bean/BotLanguage;", "setLanguage", "(Lcom/larus/bmhome/bot/bean/BotLanguage;)V", "getAvatarPrompt", "setAvatarPrompt", "getAvatarPromptForEnrich", "setAvatarPromptForEnrich", "getHasUsedAutoFill", "()Z", "setHasUsedAutoFill", "(Z)V", "getEnableWebSearch", "()Ljava/lang/Boolean;", "setEnableWebSearch", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEnableGenPic", "setEnableGenPic", "getModelItem", "()Lcom/larus/im/bean/bot/ModelItem;", "setModelItem", "(Lcom/larus/im/bean/bot/ModelItem;)V", "getMuted", "setMuted", "getPrologue", "setPrologue", "getSuggestSwitch", "setSuggestSwitch", "getSuggests", "()Lkotlin/Triple;", "setSuggests", "(Lkotlin/Triple;)V", "getBgImage", "()Lcom/larus/im/bean/bot/BgImage;", "setBgImage", "(Lcom/larus/im/bean/bot/BgImage;)V", "getUserBotTypeStarlingKey", "setUserBotTypeStarlingKey", "getUserBotGenderStarlingKey", "setUserBotGenderStarlingKey", "getOriginalUserImgUri", "setOriginalUserImgUri", "getOriginalAvatarImgUri", "setOriginalAvatarImgUri", "getOriginalBackgroundImgUri", "setOriginalBackgroundImgUri", "reset", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/larus/im/bean/bot/SpeakerVoice;Lcom/larus/bmhome/bot/bean/BotLanguage;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/ModelItem;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/Triple;Lcom/larus/im/bean/bot/BgImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bot/impl/bean/BotEditParam;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotEditParam {
    private String avatarPrompt;
    private String avatarPromptForEnrich;
    private BgImage bgImage;
    private String bio;
    private String botId;
    private String description;
    private Boolean enableGenPic;
    private Boolean enableWebSearch;
    private boolean hasUsedAutoFill;
    private String iconUri;
    private String iconUrl;
    private BotLanguage language;
    private ModelItem modelItem;
    private long modelType;
    private Boolean muted;
    private String name;
    private String originalAvatarImgUri;
    private String originalBackgroundImgUri;
    private String originalUserImgUri;
    private String prologue;
    private Boolean suggestSwitch;
    private Triple<String, String, String> suggests;
    private String userBotGenderStarlingKey;
    private String userBotTypeStarlingKey;
    private SpeakerVoice voice;

    public BotEditParam() {
        this(null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BotEditParam copy$default(BotEditParam r17, String r18, String r19, String r20, String r21, String r22, String r23, long r24, SpeakerVoice r26, BotLanguage r27, String r28, String r29, boolean r30, Boolean r31, Boolean r32, ModelItem r33, Boolean r34, String r35, Boolean r36, Triple r37, BgImage r38, String r39, String r40, String r41, String r42, String r43, int r44, Object r45) {
        if ((r44 & 1) == 0) goto L5;
        String r2 = r17.botId;
    L7:
        if ((r44 & 2) == 0) goto L9;
        String r3 = r17.name;
    L11:
        if ((r44 & 4) == 0) goto L13;
        String r4 = r17.description;
    L15:
        if ((r44 & 8) == 0) goto L17;
        String r5 = r17.bio;
    L19:
        if ((r44 & 16) == 0) goto L21;
        String r6 = r17.iconUrl;
    L23:
        if ((r44 & 32) == 0) goto L25;
        String r7 = r17.iconUri;
    L27:
        if ((r44 & 64) == 0) goto L29;
        long r8 = r17.modelType;
    L31:
        if ((r44 & 128) == 0) goto L33;
        SpeakerVoice r10 = r17.voice;
    L35:
        if ((r44 & 256) == 0) goto L37;
        BotLanguage r11 = r17.language;
    L39:
        if ((r44 & 512) == 0) goto L41;
        String r12 = r17.avatarPrompt;
    L43:
        if ((r44 & 1024) == 0) goto L45;
        String r13 = r17.avatarPromptForEnrich;
    L47:
        if ((r44 & 2048) == 0) goto L49;
        boolean r14 = r17.hasUsedAutoFill;
    L51:
        if ((r44 & 4096) == 0) goto L53;
        Boolean r15 = r17.enableWebSearch;
    L54:
        Boolean r310 = r15;
        if ((r44 & 8192) == 0) goto L57;
        Boolean r16 = r17.enableGenPic;
    L58:
        Boolean r311 = r16;
        if ((r44 & 16384) == 0) goto L61;
        ModelItem r110 = r17.modelItem;
    L62:
        ModelItem r312 = r110;
        if ((r44 & 32768) == 0) goto L65;
        Boolean r111 = r17.muted;
    L66:
        Boolean r313 = r111;
        if ((r44 & 65536) == 0) goto L69;
        String r112 = r17.prologue;
    L70:
        String r314 = r112;
        if ((r44 & 131072) == 0) goto L73;
        Boolean r113 = r17.suggestSwitch;
    L74:
        Boolean r315 = r113;
        if ((r44 & 262144) == 0) goto L77;
        Triple r114 = r17.suggests;
    L78:
        Triple r316 = r114;
        if ((r44 & 524288) == 0) goto L81;
        BgImage r115 = r17.bgImage;
    L82:
        BgImage r317 = r115;
        if ((r44 & 1048576) == 0) goto L85;
        String r116 = r17.userBotTypeStarlingKey;
    L86:
        String r318 = r116;
        if ((r44 & 2097152) == 0) goto L89;
        String r117 = r17.userBotGenderStarlingKey;
    L90:
        String r46 = r117;
        if ((r44 & 4194304) == 0) goto L93;
        String r118 = r17.originalUserImgUri;
    L94:
        String r47 = r118;
        if ((r44 & 8388608) == 0) goto L97;
        String r119 = r17.originalAvatarImgUri;
    L99:
        if ((r44 & 16777216) == 0) goto L101;
        String r1 = r17.originalBackgroundImgUri;
    L103:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r46, r47, r119, r1);
    L101:
        r1 = r43;
        goto L103
    L97:
        r119 = r42;
        goto L99
    L93:
        r118 = r41;
        goto L94
    L89:
        r117 = r40;
        goto L90
    L85:
        r116 = r39;
        goto L86
    L81:
        r115 = r38;
        goto L82
    L77:
        r114 = r37;
        goto L78
    L73:
        r113 = r36;
        goto L74
    L69:
        r112 = r35;
        goto L70
    L65:
        r111 = r34;
        goto L66
    L61:
        r110 = r33;
        goto L62
    L57:
        r16 = r32;
        goto L58
    L53:
        r15 = r31;
        goto L54
    L49:
        r14 = r30;
        goto L51
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r10 = r26;
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

    public final String component1() {
        return this.botId;
    }

    public final String component10() {
        return this.avatarPrompt;
    }

    public final String component11() {
        return this.avatarPromptForEnrich;
    }

    public final boolean component12() {
        return this.hasUsedAutoFill;
    }

    public final Boolean component13() {
        return this.enableWebSearch;
    }

    public final Boolean component14() {
        return this.enableGenPic;
    }

    public final ModelItem component15() {
        return this.modelItem;
    }

    public final Boolean component16() {
        return this.muted;
    }

    public final String component17() {
        return this.prologue;
    }

    public final Boolean component18() {
        return this.suggestSwitch;
    }

    public final Triple<String, String, String> component19() {
        return this.suggests;
    }

    public final String component2() {
        return this.name;
    }

    public final BgImage component20() {
        return this.bgImage;
    }

    public final String component21() {
        return this.userBotTypeStarlingKey;
    }

    public final String component22() {
        return this.userBotGenderStarlingKey;
    }

    public final String component23() {
        return this.originalUserImgUri;
    }

    public final String component24() {
        return this.originalAvatarImgUri;
    }

    public final String component25() {
        return this.originalBackgroundImgUri;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.bio;
    }

    public final String component5() {
        return this.iconUrl;
    }

    public final String component6() {
        return this.iconUri;
    }

    public final long component7() {
        return this.modelType;
    }

    public final SpeakerVoice component8() {
        return this.voice;
    }

    public final BotLanguage component9() {
        return this.language;
    }

    public final BotEditParam copy(String r30, String r31, String r32, String r33, String r34, String r35, long r36, SpeakerVoice r38, BotLanguage r39, String r40, String r41, boolean r42, Boolean r43, Boolean r44, ModelItem r45, Boolean r46, String r47, Boolean r48, Triple<String, String, String> r49, BgImage r50, String r51, String r52, String r53, String r54, String r55) {
        Intrinsics.checkNotNullParameter(r30, "botId");
        Intrinsics.checkNotNullParameter(r31, "name");
        Intrinsics.checkNotNullParameter(r32, "description");
        Intrinsics.checkNotNullParameter(r33, "bio");
        Intrinsics.checkNotNullParameter(r34, "iconUrl");
        Intrinsics.checkNotNullParameter(r35, "iconUri");
        Intrinsics.checkNotNullParameter(r40, "avatarPrompt");
        return new BotEditParam(r30, r31, r32, r33, r34, r35, r36, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof BotEditParam) == true) goto L8;
        return false;
    L8:
        BotEditParam r9 = (BotEditParam) r8;
        if (Intrinsics.areEqual(this.botId, r9.botId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r9.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r9.description) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bio, r9.bio) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconUrl, r9.iconUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconUri, r9.iconUri) == true) goto L27;
        return false;
    L27:
        if (this.modelType == r9.modelType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.voice, r9.voice) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.language, r9.language) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.avatarPrompt, r9.avatarPrompt) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.avatarPromptForEnrich, r9.avatarPromptForEnrich) == true) goto L42;
        return false;
    L42:
        if (this.hasUsedAutoFill == r9.hasUsedAutoFill) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.enableWebSearch, r9.enableWebSearch) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.enableGenPic, r9.enableGenPic) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.modelItem, r9.modelItem) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.muted, r9.muted) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.prologue, r9.prologue) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.suggestSwitch, r9.suggestSwitch) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.suggests, r9.suggests) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.bgImage, r9.bgImage) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.userBotTypeStarlingKey, r9.userBotTypeStarlingKey) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.userBotGenderStarlingKey, r9.userBotGenderStarlingKey) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.originalUserImgUri, r9.originalUserImgUri) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.originalAvatarImgUri, r9.originalAvatarImgUri) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.originalBackgroundImgUri, r9.originalBackgroundImgUri) == true) goto L83;
        return false;
    L83:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((this.botId.hashCode() * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.bio.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.iconUri.hashCode()) * 31;
        long r1 = this.modelType;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        SpeakerVoice r3 = this.voice;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (r2 + r5) * 31;
        BotLanguage r7 = this.language;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (((r6 + r8) * 31) + this.avatarPrompt.hashCode()) * 31;
        String r10 = this.avatarPromptForEnrich;
        if (r10 != null) goto L13;
        int r11 = 0;
    L14:
        int r12 = (r9 + r11) * 31;
        if (this.hasUsedAutoFill == false) goto L17;
        int r13 = 1231;
    L18:
        int r14 = (r12 + r13) * 31;
        Boolean r15 = this.enableWebSearch;
        if (r15 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (r14 + r16) * 31;
        Boolean r18 = this.enableGenPic;
        if (r18 != null) goto L25;
        int r19 = 0;
    L26:
        int r20 = (r17 + r19) * 31;
        ModelItem r21 = this.modelItem;
        if (r21 != null) goto L29;
        int r22 = 0;
    L30:
        int r23 = (r20 + r22) * 31;
        Boolean r24 = this.muted;
        if (r24 != null) goto L33;
        int r25 = 0;
    L34:
        int r26 = (r23 + r25) * 31;
        String r27 = this.prologue;
        if (r27 != null) goto L37;
        int r28 = 0;
    L38:
        int r29 = (r26 + r28) * 31;
        Boolean r30 = this.suggestSwitch;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r29 + r31) * 31;
        Triple<String, String, String> r33 = this.suggests;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r35 = (r32 + r34) * 31;
        BgImage r36 = this.bgImage;
        if (r36 != null) goto L49;
        int r37 = 0;
    L50:
        int r38 = (r35 + r37) * 31;
        String r39 = this.userBotTypeStarlingKey;
        if (r39 != null) goto L53;
        int r40 = 0;
    L54:
        int r41 = (r38 + r40) * 31;
        String r42 = this.userBotGenderStarlingKey;
        if (r42 != null) goto L57;
        int r43 = 0;
    L58:
        int r44 = (r41 + r43) * 31;
        String r45 = this.originalUserImgUri;
        if (r45 != null) goto L61;
        int r46 = 0;
    L62:
        int r47 = (r44 + r46) * 31;
        String r48 = this.originalAvatarImgUri;
        if (r48 != null) goto L65;
        int r49 = 0;
    L66:
        int r50 = (r47 + r49) * 31;
        String r51 = this.originalBackgroundImgUri;
        if (r51 == null) goto L71;
        r4 = r51.hashCode();
    L71:
        return r50 + r4;
    L65:
        r49 = r48.hashCode();
        goto L66
    L61:
        r46 = r45.hashCode();
        goto L62
    L57:
        r43 = r42.hashCode();
        goto L58
    L53:
        r40 = r39.hashCode();
        goto L54
    L49:
        r37 = r36.hashCode();
        goto L50
    L45:
        r34 = r33.hashCode();
        goto L46
    L41:
        r31 = r30.hashCode();
        goto L42
    L37:
        r28 = r27.hashCode();
        goto L38
    L33:
        r25 = r24.hashCode();
        goto L34
    L29:
        r22 = r21.hashCode();
        goto L30
    L25:
        r19 = r18.hashCode();
        goto L26
    L21:
        r16 = r15.hashCode();
        goto L22
    L17:
        r13 = 1237;
        goto L18
    L13:
        r11 = r10.hashCode();
        goto L14
    L9:
        r8 = r7.hashCode();
        goto L10
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public String toString() {
        return "BotEditParam(botId=" + this.botId + ", name=" + this.name + ", description=" + this.description + ", bio=" + this.bio + ", iconUrl=" + this.iconUrl + ", iconUri=" + this.iconUri + ", modelType=" + this.modelType + ", voice=" + this.voice + ", language=" + this.language + ", avatarPrompt=" + this.avatarPrompt + ", avatarPromptForEnrich=" + this.avatarPromptForEnrich + ", hasUsedAutoFill=" + this.hasUsedAutoFill + ", enableWebSearch=" + this.enableWebSearch + ", enableGenPic=" + this.enableGenPic + ", modelItem=" + this.modelItem + ", muted=" + this.muted + ", prologue=" + this.prologue + ", suggestSwitch=" + this.suggestSwitch + ", suggests=" + this.suggests + ", bgImage=" + this.bgImage + ", userBotTypeStarlingKey=" + this.userBotTypeStarlingKey + ", userBotGenderStarlingKey=" + this.userBotGenderStarlingKey + ", originalUserImgUri=" + this.originalUserImgUri + ", originalAvatarImgUri=" + this.originalAvatarImgUri + ", originalBackgroundImgUri=" + this.originalBackgroundImgUri + ')';
    }

    public final void reset() {
        this.botId = "";
        this.name = "";
        this.description = "";
        this.iconUrl = "";
        this.iconUri = "";
        this.modelType = 0;
        this.voice = null;
        this.language = null;
        this.hasUsedAutoFill = false;
        this.enableGenPic = null;
        this.enableWebSearch = null;
        this.modelItem = null;
        this.muted = null;
        this.prologue = null;
        this.suggestSwitch = null;
        this.suggests = null;
        this.bgImage = null;
        this.userBotTypeStarlingKey = null;
        this.userBotGenderStarlingKey = null;
        this.originalUserImgUri = null;
        this.originalAvatarImgUri = null;
        this.originalBackgroundImgUri = null;
    }

    public final String getAvatarPrompt() {
        return this.avatarPrompt;
    }

    public final String getAvatarPromptForEnrich() {
        return this.avatarPromptForEnrich;
    }

    public final BgImage getBgImage() {
        return this.bgImage;
    }

    public final String getBio() {
        return this.bio;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Boolean getEnableGenPic() {
        return this.enableGenPic;
    }

    public final Boolean getEnableWebSearch() {
        return this.enableWebSearch;
    }

    public final boolean getHasUsedAutoFill() {
        return this.hasUsedAutoFill;
    }

    public final String getIconUri() {
        return this.iconUri;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final BotLanguage getLanguage() {
        return this.language;
    }

    public final ModelItem getModelItem() {
        return this.modelItem;
    }

    public final long getModelType() {
        return this.modelType;
    }

    public final Boolean getMuted() {
        return this.muted;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOriginalAvatarImgUri() {
        return this.originalAvatarImgUri;
    }

    public final String getOriginalBackgroundImgUri() {
        return this.originalBackgroundImgUri;
    }

    public final String getOriginalUserImgUri() {
        return this.originalUserImgUri;
    }

    public final String getPrologue() {
        return this.prologue;
    }

    public final Boolean getSuggestSwitch() {
        return this.suggestSwitch;
    }

    public final Triple<String, String, String> getSuggests() {
        return this.suggests;
    }

    public final String getUserBotGenderStarlingKey() {
        return this.userBotGenderStarlingKey;
    }

    public final String getUserBotTypeStarlingKey() {
        return this.userBotTypeStarlingKey;
    }

    public final SpeakerVoice getVoice() {
        return this.voice;
    }

    public final void setAvatarPrompt(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.avatarPrompt = r2;
    }

    public final void setAvatarPromptForEnrich(String r1) {
        this.avatarPromptForEnrich = r1;
    }

    public final void setBgImage(BgImage r1) {
        this.bgImage = r1;
    }

    public final void setBio(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.bio = r2;
    }

    public final void setBotId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.botId = r2;
    }

    public final void setDescription(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.description = r2;
    }

    public final void setEnableGenPic(Boolean r1) {
        this.enableGenPic = r1;
    }

    public final void setEnableWebSearch(Boolean r1) {
        this.enableWebSearch = r1;
    }

    public final void setHasUsedAutoFill(boolean r1) {
        this.hasUsedAutoFill = r1;
    }

    public final void setIconUri(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.iconUri = r2;
    }

    public final void setIconUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.iconUrl = r2;
    }

    public final void setLanguage(BotLanguage r1) {
        this.language = r1;
    }

    public final void setModelItem(ModelItem r1) {
        this.modelItem = r1;
    }

    public final void setModelType(long r1) {
        this.modelType = r1;
    }

    public final void setMuted(Boolean r1) {
        this.muted = r1;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setOriginalAvatarImgUri(String r1) {
        this.originalAvatarImgUri = r1;
    }

    public final void setOriginalBackgroundImgUri(String r1) {
        this.originalBackgroundImgUri = r1;
    }

    public final void setOriginalUserImgUri(String r1) {
        this.originalUserImgUri = r1;
    }

    public final void setPrologue(String r1) {
        this.prologue = r1;
    }

    public final void setSuggestSwitch(Boolean r1) {
        this.suggestSwitch = r1;
    }

    public final void setSuggests(Triple<String, String, String> r1) {
        this.suggests = r1;
    }

    public final void setUserBotGenderStarlingKey(String r1) {
        this.userBotGenderStarlingKey = r1;
    }

    public final void setUserBotTypeStarlingKey(String r1) {
        this.userBotTypeStarlingKey = r1;
    }

    public final void setVoice(SpeakerVoice r1) {
        this.voice = r1;
    }

    public BotEditParam(String r10, String r11, String r12, String r13, String r14, String r15, long r16, SpeakerVoice r18, BotLanguage r19, String r20, String r21, boolean r22, Boolean r23, Boolean r24, ModelItem r25, Boolean r26, String r27, Boolean r28, Triple<String, String, String> r29, BgImage r30, String r31, String r32, String r33, String r34, String r35) {
        Intrinsics.checkNotNullParameter(r10, "botId");
        Intrinsics.checkNotNullParameter(r11, "name");
        Intrinsics.checkNotNullParameter(r12, "description");
        Intrinsics.checkNotNullParameter(r13, "bio");
        Intrinsics.checkNotNullParameter(r14, "iconUrl");
        Intrinsics.checkNotNullParameter(r15, "iconUri");
        Intrinsics.checkNotNullParameter(r20, "avatarPrompt");
        this.botId = r10;
        this.name = r11;
        this.description = r12;
        this.bio = r13;
        this.iconUrl = r14;
        this.iconUri = r15;
        this.modelType = r16;
        this.voice = r18;
        this.language = r19;
        this.avatarPrompt = r20;
        this.avatarPromptForEnrich = r21;
        this.hasUsedAutoFill = r22;
        this.enableWebSearch = r23;
        this.enableGenPic = r24;
        this.modelItem = r25;
        this.muted = r26;
        this.prologue = r27;
        this.suggestSwitch = r28;
        this.suggests = r29;
        this.bgImage = r30;
        this.userBotTypeStarlingKey = r31;
        this.userBotGenderStarlingKey = r32;
        this.originalUserImgUri = r33;
        this.originalAvatarImgUri = r34;
        this.originalBackgroundImgUri = r35;
    }

    public /* synthetic */ BotEditParam(String r27, String r28, String r29, String r30, String r31, String r32, long r33, SpeakerVoice r35, BotLanguage r36, String r37, String r38, boolean r39, Boolean r40, Boolean r41, ModelItem r42, Boolean r43, String r44, Boolean r45, Triple r46, BgImage r47, String r48, String r49, String r50, String r51, String r52, int r53, DefaultConstructorMarker r54) {
        String r2 = "";
        if ((r53 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r53 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r53 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r53 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r53 & 16) == 0) goto L21;
        String r6 = "";
    L23:
        if ((r53 & 32) == 0) goto L25;
        String r7 = "";
    L27:
        if ((r53 & 64) == 0) goto L29;
        long r8 = 0;
    L31:
        if ((r53 & 128) == 0) goto L33;
        SpeakerVoice r10 = null;
    L35:
        if ((r53 & 256) == 0) goto L37;
        BotLanguage r12 = null;
    L39:
        if ((r53 & 512) != 0) goto L43;
        r2 = r37;
    L43:
        if ((r53 & 1024) == 0) goto L45;
        String r13 = null;
    L47:
        if ((r53 & 2048) == 0) goto L49;
        boolean r14 = false;
    L51:
        if ((r53 & 4096) == 0) goto L53;
        Boolean r15 = null;
    L55:
        if ((r53 & 8192) == 0) goto L57;
        Boolean r11 = null;
    L58:
        Boolean r55 = r11;
        if ((r53 & 16384) == 0) goto L61;
        ModelItem r16 = null;
    L63:
        if ((r53 & 32768) == 0) goto L65;
        Boolean r17 = null;
    L67:
        if ((r53 & 65536) == 0) goto L69;
        String r18 = null;
    L71:
        if ((r53 & 131072) == 0) goto L73;
        Boolean r19 = null;
    L75:
        if ((r53 & 262144) == 0) goto L77;
        Triple r110 = null;
    L79:
        if ((r53 & 524288) == 0) goto L81;
        BgImage r20 = null;
    L83:
        if ((r53 & 1048576) == 0) goto L85;
        String r21 = null;
    L87:
        if ((r53 & 2097152) == 0) goto L89;
        String r22 = null;
    L91:
        if ((r53 & 4194304) == 0) goto L93;
        String r23 = null;
    L95:
        if ((r53 & 8388608) == 0) goto L97;
        String r24 = null;
    L99:
        if ((r53 & 16777216) == 0) goto L101;
        String r0 = null;
    L102:
        this(r1, r3, r4, r5, r6, r7, r8, r10, r12, r2, r13, r14, r15, r55, r16, r17, r18, r19, r110, r20, r21, r22, r23, r24, r0);
        return;
    L101:
        r0 = r52;
        goto L102
    L97:
        r24 = r51;
        goto L99
    L93:
        r23 = r50;
        goto L95
    L89:
        r22 = r49;
        goto L91
    L85:
        r21 = r48;
        goto L87
    L81:
        r20 = r47;
        goto L83
    L77:
        r110 = r46;
        goto L79
    L73:
        r19 = r45;
        goto L75
    L69:
        r18 = r44;
        goto L71
    L65:
        r17 = r43;
        goto L67
    L61:
        r16 = r42;
        goto L63
    L57:
        r11 = r41;
        goto L58
    L53:
        r15 = r40;
        goto L55
    L49:
        r14 = r39;
        goto L51
    L45:
        r13 = r38;
        goto L47
    L37:
        r12 = r36;
        goto L39
    L33:
        r10 = r35;
        goto L35
    L29:
        r8 = r33;
        goto L31
    L25:
        r7 = r32;
        goto L27
    L21:
        r6 = r31;
        goto L23
    L17:
        r5 = r30;
        goto L19
    L13:
        r4 = r29;
        goto L15
    L9:
        r3 = r28;
        goto L11
    L5:
        r1 = r27;
        goto L7
    }
}
