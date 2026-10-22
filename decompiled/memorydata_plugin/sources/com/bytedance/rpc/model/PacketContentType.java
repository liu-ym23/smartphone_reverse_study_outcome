package com.bytedance.rpc.model;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.entity.app.EntityType;
import com.tom_roush.pdfbox.pdmodel.a.d.d;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.threeten.bp.chrono.HijrahDate;

/* JADX INFO: loaded from: classes2.dex */
public final enum PacketContentType extends Enum<PacketContentType> {
    private static final /* synthetic */ PacketContentType[] $VALUES = null;

    @SerializedName("67")
    public static final PacketContentType AggregatedMsg = null;

    @SerializedName(BDLocationException.ERROR_BEACON_ADVERTISING)
    public static final PacketContentType App = null;

    @SerializedName("3")
    public static final PacketContentType Audio = null;

    @SerializedName("9999")
    public static final PacketContentType Block = null;

    @SerializedName("10030")
    public static final PacketContentType BlockArtifact = null;

    @SerializedName("10054")
    public static final PacketContentType BlockAuthIdentity = null;

    @SerializedName("10008")
    public static final PacketContentType BlockCode = null;

    @SerializedName("2074")
    public static final PacketContentType BlockCreation = null;

    @SerializedName("10018")
    public static final PacketContentType BlockCreationLoading = null;

    @SerializedName("10057")
    public static final PacketContentType BlockCredit = null;

    @SerializedName("10027")
    public static final PacketContentType BlockImageAnalysis = null;

    @SerializedName("10101")
    public static final PacketContentType BlockLoading = null;

    @SerializedName("10055")
    public static final PacketContentType BlockMemoryTag = null;

    @SerializedName("10056")
    public static final PacketContentType BlockReference = null;

    @SerializedName("10011")
    public static final PacketContentType BlockResearch = null;

    @SerializedName("10001")
    public static final PacketContentType BlockResearchCard = null;

    @SerializedName("10026")
    public static final PacketContentType BlockRoutePlan = null;

    @SerializedName("10025")
    public static final PacketContentType BlockSearchQueryResult = null;

    @SerializedName("10050")
    public static final PacketContentType BlockSearchRichMedia = null;

    @SerializedName("10015")
    public static final PacketContentType BlockSupertaskCard = null;

    @SerializedName("10040")
    public static final PacketContentType BlockThinking = null;

    @SerializedName("10053")
    public static final PacketContentType BlockTips = null;

    @SerializedName("10013")
    public static final PacketContentType BlockWebpage = null;

    @SerializedName("51")
    public static final PacketContentType BotCard = null;

    @SerializedName(BDLocationException.ERROR_BYTE_SCAN_RESULT_IS_EMPTY)
    public static final PacketContentType Card = null;

    @SerializedName("1005")
    public static final PacketContentType Command = null;

    @SerializedName("2022")
    public static final PacketContentType CreationMulti = null;

    @SerializedName("61")
    public static final PacketContentType DeepSearchCard = null;

    @SerializedName("1007")
    public static final PacketContentType EmptyResponse = null;

    @SerializedName("9")
    public static final PacketContentType File = null;

    @SerializedName("2")
    public static final PacketContentType Image = null;

    @SerializedName("6")
    public static final PacketContentType Link = null;

    @SerializedName("10006")
    public static final PacketContentType LinkReader = null;

    @SerializedName("1006")
    public static final PacketContentType LoadingTip = null;

    @SerializedName("10009")
    public static final PacketContentType LocalLife = null;

    @SerializedName("1009")
    public static final PacketContentType LyricsToSongLyric = null;

    @SerializedName("1008")
    public static final PacketContentType LyricsToSongMusic = null;

    @SerializedName("1010")
    public static final PacketContentType LyricsToSongsMusic = null;

    @SerializedName(BDLocationException.ERROR_JSON_CONVERT)
    public static final PacketContentType MultiContent = null;

    @SerializedName("7")
    public static final PacketContentType Music = null;

    @SerializedName("20")
    public static final PacketContentType Nested = null;

    @SerializedName("201")
    public static final PacketContentType OutputMultiStream = null;

    @SerializedName(BDLocationException.SUCCESS)
    public static final PacketContentType OutputSearchResult = null;

    @SerializedName("300")
    public static final PacketContentType SearchIntentionResult = null;

    @SerializedName("10004")
    public static final PacketContentType SearchQuery = null;

    @SerializedName("10005")
    public static final PacketContentType SearchResult = null;

    @SerializedName("1001")
    public static final PacketContentType Suggest = null;

    @SerializedName("1011")
    public static final PacketContentType SuggestSp = null;

    @SerializedName("1012")
    public static final PacketContentType Toast = null;

    @SerializedName("1")
    public static final PacketContentType Txt = null;

    @SerializedName("21")
    public static final PacketContentType VLMData = null;

    @SerializedName("1004")
    public static final PacketContentType Verbose = null;

    @SerializedName("4")
    public static final PacketContentType Video = null;

    @SerializedName("2021")
    public static final PacketContentType VideoGeneration = null;

    @SerializedName(BDLocationException.ERROR_NO_BYTE_IMPL)
    public static final PacketContentType Widget = null;
    private final int value;

    static {
        Txt = new PacketContentType("Txt", 0, 1);
        Image = new PacketContentType("Image", 1, 2);
        Audio = new PacketContentType("Audio", 2, 3);
        Video = new PacketContentType("Video", 3, 4);
        Link = new PacketContentType(i.L, 4, 6);
        Music = new PacketContentType("Music", 5, 7);
        File = new PacketContentType("File", 6, 9);
        Nested = new PacketContentType("Nested", 7, 20);
        VLMData = new PacketContentType("VLMData", 8, 21);
        Card = new PacketContentType("Card", 9, 50);
        BotCard = new PacketContentType("BotCard", 10, 51);
        Widget = new PacketContentType("Widget", 11, 52);
        DeepSearchCard = new PacketContentType("DeepSearchCard", 12, 61);
        MultiContent = new PacketContentType("MultiContent", 13, 66);
        AggregatedMsg = new PacketContentType("AggregatedMsg", 14, 67);
        App = new PacketContentType("App", 15, 100);
        OutputSearchResult = new PacketContentType("OutputSearchResult", 16, 200);
        OutputMultiStream = new PacketContentType("OutputMultiStream", 17, 201);
        SearchIntentionResult = new PacketContentType("SearchIntentionResult", 18, 300);
        Suggest = new PacketContentType("Suggest", 19, 1001);
        Verbose = new PacketContentType("Verbose", 20, 1004);
        Command = new PacketContentType("Command", 21, 1005);
        LoadingTip = new PacketContentType("LoadingTip", 22, 1006);
        EmptyResponse = new PacketContentType("EmptyResponse", 23, 1007);
        LyricsToSongMusic = new PacketContentType("LyricsToSongMusic", 24, 1008);
        LyricsToSongLyric = new PacketContentType("LyricsToSongLyric", 25, 1009);
        LyricsToSongsMusic = new PacketContentType("LyricsToSongsMusic", 26, 1010);
        SuggestSp = new PacketContentType("SuggestSp", 27, 1011);
        Toast = new PacketContentType("Toast", 28, 1012);
        VideoGeneration = new PacketContentType("VideoGeneration", 29, 2021);
        CreationMulti = new PacketContentType("CreationMulti", 30, 2022);
        Block = new PacketContentType(d.i, 31, HijrahDate.MAX_VALUE_OF_ERA);
        BlockCreation = new PacketContentType("BlockCreation", 32, 2074);
        BlockResearchCard = new PacketContentType("BlockResearchCard", 33, 10001);
        SearchQuery = new PacketContentType("SearchQuery", 34, 10004);
        SearchResult = new PacketContentType("SearchResult", 35, 10005);
        LinkReader = new PacketContentType("LinkReader", 36, 10006);
        BlockCode = new PacketContentType("BlockCode", 37, com.obric.capabilitykit.entity.meta.MetaType.IDENTIFY_CARD_NUMBER);
        LocalLife = new PacketContentType("LocalLife", 38, com.obric.capabilitykit.entity.meta.MetaType.PERSON_NAME);
        BlockResearch = new PacketContentType("BlockResearch", 39, com.obric.capabilitykit.entity.meta.MetaType.TEXT);
        BlockWebpage = new PacketContentType("BlockWebpage", 40, com.obric.capabilitykit.entity.meta.MetaType.TRACKING_NUMBER);
        BlockSupertaskCard = new PacketContentType("BlockSupertaskCard", 41, com.obric.capabilitykit.entity.meta.MetaType._MEDIA);
        BlockCreationLoading = new PacketContentType("BlockCreationLoading", 42, com.obric.capabilitykit.entity.meta.MetaType.INSTANT_MESSAGING);
        BlockSearchQueryResult = new PacketContentType("BlockSearchQueryResult", 43, 10025);
        BlockRoutePlan = new PacketContentType("BlockRoutePlan", 44, 10026);
        BlockImageAnalysis = new PacketContentType("BlockImageAnalysis", 45, 10027);
        BlockArtifact = new PacketContentType("BlockArtifact", 46, 10030);
        BlockThinking = new PacketContentType("BlockThinking", 47, 10040);
        BlockSearchRichMedia = new PacketContentType("BlockSearchRichMedia", 48, 10050);
        BlockTips = new PacketContentType("BlockTips", 49, 10053);
        BlockAuthIdentity = new PacketContentType("BlockAuthIdentity", 50, 10054);
        BlockMemoryTag = new PacketContentType("BlockMemoryTag", 51, 10055);
        BlockReference = new PacketContentType("BlockReference", 52, 10056);
        BlockCredit = new PacketContentType("BlockCredit", 53, 10057);
        BlockLoading = new PacketContentType("BlockLoading", 54, EntityType.MEMORY_INFO_DOCUMENTS);
        $VALUES = new PacketContentType[]{Txt, Image, Audio, Video, Link, Music, File, Nested, VLMData, Card, BotCard, Widget, DeepSearchCard, MultiContent, AggregatedMsg, App, OutputSearchResult, OutputMultiStream, SearchIntentionResult, Suggest, Verbose, Command, LoadingTip, EmptyResponse, LyricsToSongMusic, LyricsToSongLyric, LyricsToSongsMusic, SuggestSp, Toast, VideoGeneration, CreationMulti, Block, BlockCreation, BlockResearchCard, SearchQuery, SearchResult, LinkReader, BlockCode, LocalLife, BlockResearch, BlockWebpage, BlockSupertaskCard, BlockCreationLoading, BlockSearchQueryResult, BlockRoutePlan, BlockImageAnalysis, BlockArtifact, BlockThinking, BlockSearchRichMedia, BlockTips, BlockAuthIdentity, BlockMemoryTag, BlockReference, BlockCredit, BlockLoading};
    }

    private PacketContentType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static PacketContentType findByValue(int r1) {
        if (r1 == 1) goto L148;
        if (r1 == 2) goto L146;
        if (r1 == 3) goto L144;
        if (r1 == 4) goto L142;
        if (r1 == 6) goto L140;
        if (r1 == 7) goto L138;
        if (r1 == 20) goto L136;
        if (r1 == 21) goto L134;
        if (r1 == 66) goto L132;
        if (r1 == 67) goto L130;
        if (r1 == 200) goto L128;
        if (r1 == 201) goto L126;
        if (r1 == 2021) goto L124;
        if (r1 == 2022) goto L122;
        if (r1 == 10008) goto L120;
        if (r1 == 10009) goto L118;
        switch(r1) {
            case 9: goto L116;
            case 61: goto L114;
            case 100: goto L112;
            case 300: goto L110;
            case 1001: goto L108;
            case 1004: goto L106;
            case 1005: goto L104;
            case 1006: goto L102;
            case 1007: goto L100;
            case 1008: goto L98;
            case 1009: goto L96;
            case 1010: goto L94;
            case 1011: goto L92;
            case 1012: goto L90;
            case 2074: goto L88;
            case 9999: goto L86;
            case 10001: goto L84;
            case 10011: goto L82;
            case 10013: goto L80;
            case 10015: goto L78;
            case 10018: goto L76;
            case 10025: goto L74;
            case 10026: goto L72;
            case 10027: goto L70;
            case 10030: goto L68;
            case 10040: goto L66;
            case 10050: goto L64;
            case 10053: goto L62;
            case 10054: goto L60;
            case 10055: goto L58;
            case 10056: goto L56;
            case 10057: goto L54;
            case 10101: goto L52;
            default: goto L35;
        };
    L35:
        switch(r1) {
            case 50: goto L50;
            case 51: goto L48;
            case 52: goto L46;
            default: goto L36;
        };
    L36:
        switch(r1) {
            case 10004: goto L44;
            case 10005: goto L42;
            case 10006: goto L40;
            default: goto L37;
        };
    L37:
        return null;
    L40:
        return LinkReader;
    L42:
        return SearchResult;
    L44:
        return SearchQuery;
    L46:
        return Widget;
    L48:
        return BotCard;
    L50:
        return Card;
    L52:
        return BlockLoading;
    L54:
        return BlockCredit;
    L56:
        return BlockReference;
    L58:
        return BlockMemoryTag;
    L60:
        return BlockAuthIdentity;
    L62:
        return BlockTips;
    L64:
        return BlockSearchRichMedia;
    L66:
        return BlockThinking;
    L68:
        return BlockArtifact;
    L70:
        return BlockImageAnalysis;
    L72:
        return BlockRoutePlan;
    L74:
        return BlockSearchQueryResult;
    L76:
        return BlockCreationLoading;
    L78:
        return BlockSupertaskCard;
    L80:
        return BlockWebpage;
    L82:
        return BlockResearch;
    L84:
        return BlockResearchCard;
    L86:
        return Block;
    L88:
        return BlockCreation;
    L90:
        return Toast;
    L92:
        return SuggestSp;
    L94:
        return LyricsToSongsMusic;
    L96:
        return LyricsToSongLyric;
    L98:
        return LyricsToSongMusic;
    L100:
        return EmptyResponse;
    L102:
        return LoadingTip;
    L104:
        return Command;
    L106:
        return Verbose;
    L108:
        return Suggest;
    L110:
        return SearchIntentionResult;
    L112:
        return App;
    L114:
        return DeepSearchCard;
    L116:
        return File;
    L118:
        return LocalLife;
    L120:
        return BlockCode;
    L122:
        return CreationMulti;
    L124:
        return VideoGeneration;
    L126:
        return OutputMultiStream;
    L128:
        return OutputSearchResult;
    L130:
        return AggregatedMsg;
    L132:
        return MultiContent;
    L134:
        return VLMData;
    L136:
        return Nested;
    L138:
        return Music;
    L140:
        return Link;
    L142:
        return Video;
    L144:
        return Audio;
    L146:
        return Image;
    L148:
        return Txt;
    }

    public static PacketContentType valueOf(String r2) {
        return (PacketContentType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PacketContentType.class, r2), PacketContentType.class, "com.obric.memorydata.plugin");
    }

    public static PacketContentType[] values() {
        return (PacketContentType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PacketContentType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
