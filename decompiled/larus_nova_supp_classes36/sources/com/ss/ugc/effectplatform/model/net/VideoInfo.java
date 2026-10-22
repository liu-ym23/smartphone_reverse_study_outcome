package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.image.api.Target;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0095\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u000f\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u00108R\u0014\u0010%\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u00109R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010:R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010;R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010:R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010<R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010:R\u0016\u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010:R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010<R\u0016\u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010:R \u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010<R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010;R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010<R\u0014\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010:R\u0014\u0010.\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/VideoInfo;", "", "Id", "", "Height", "", "Width", "Duration", "Ratio", "HasWatermark", "", "Cover", "Lcom/ss/ugc/effectplatform/model/net/UrlStruct;", "OriginCover", "BitrateInfos", "", "Lcom/ss/ugc/effectplatform/model/net/BitrateStruct;", "DynamicCover", "PlayAddrH264", "PlayAddr", "DownloadAddr", "PlayAddrLowbr", "NewDownloadAddr", "DownloadSuffixLogoAddr", "PlayAddrH265", "CodecType", "UIAlikeDownloadAddr", "CaptionDownloadAddr", "ContentType", "ControlInfo", "Lcom/ss/ugc/effectplatform/model/net/VideoControlStruct;", "CdnUrlExpired", "", "IsLongVideo", "VideoModel", "AnimatedCover", "NeedSetToken", "AiCover", "CoverTsp", "", "MiscDownloadAddrs", "", "IsCallBack", "PlayAddrByteVC1", "BigThumbs", "Lcom/ss/ugc/effectplatform/model/net/BigThumb;", "meta", "UseStaticCover", "OptimizedCover", "HorizontalType", "FakeHorizontalInfo", "Lcom/ss/ugc/effectplatform/model/net/FakeHorizontalStruct;", "TrailerStartTime", "MiscDownloadAddrsStr", "BlurCover", "ResetCover", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/lang/Integer;Lcom/ss/ugc/effectplatform/model/net/VideoControlStruct;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/lang/Boolean;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/lang/Double;Ljava/util/Map;Ljava/lang/Boolean;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/lang/Integer;Lcom/ss/ugc/effectplatform/model/net/FakeHorizontalStruct;Ljava/lang/Double;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;)V", "Ljava/lang/Long;", "Ljava/lang/Integer;", "Ljava/lang/Double;", "Ljava/lang/Boolean;", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class VideoInfo {
    public UrlStruct AiCover;
    public UrlStruct AnimatedCover;
    public List<BigThumb> BigThumbs;
    public List<BitrateStruct> BitrateInfos;
    public UrlStruct BlurCover;
    public UrlStruct CaptionDownloadAddr;
    public Long CdnUrlExpired;
    public String CodecType;
    public Integer ContentType;
    public VideoControlStruct ControlInfo;
    public UrlStruct Cover;
    public Double CoverTsp;
    public UrlStruct DownloadAddr;
    public UrlStruct DownloadSuffixLogoAddr;
    public Integer Duration;
    public UrlStruct DynamicCover;
    public FakeHorizontalStruct FakeHorizontalInfo;
    public Boolean HasWatermark;
    public Integer Height;
    public Integer HorizontalType;
    public String Id;
    public Boolean IsCallBack;
    public Integer IsLongVideo;
    public Map<String, UrlStruct> MiscDownloadAddrs;
    public String MiscDownloadAddrsStr;
    public Boolean NeedSetToken;
    public UrlStruct NewDownloadAddr;
    public UrlStruct OptimizedCover;
    public UrlStruct OriginCover;
    public UrlStruct PlayAddr;
    public UrlStruct PlayAddrByteVC1;
    public UrlStruct PlayAddrH264;
    public UrlStruct PlayAddrH265;
    public UrlStruct PlayAddrLowbr;
    public String Ratio;
    public UrlStruct ResetCover;
    public Double TrailerStartTime;
    public UrlStruct UIAlikeDownloadAddr;
    public Boolean UseStaticCover;
    public String VideoModel;
    public Integer Width;
    public String meta;

    public VideoInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1023, null);
    }

    public VideoInfo(String r3, Integer r4, Integer r5, Integer r6, String r7, Boolean r8, UrlStruct r9, UrlStruct r10, List<BitrateStruct> r11, UrlStruct r12, UrlStruct r13, UrlStruct r14, UrlStruct r15, UrlStruct r16, UrlStruct r17, UrlStruct r18, UrlStruct r19, String r20, UrlStruct r21, UrlStruct r22, Integer r23, VideoControlStruct r24, Long r25, Integer r26, String r27, UrlStruct r28, Boolean r29, UrlStruct r30, Double r31, Map<String, UrlStruct> r32, Boolean r33, UrlStruct r34, List<BigThumb> r35, String r36, Boolean r37, UrlStruct r38, Integer r39, FakeHorizontalStruct r40, Double r41, String r42, UrlStruct r43, UrlStruct r44) {
        this.Id = r3;
        this.Height = r4;
        this.Width = r5;
        this.Duration = r6;
        this.Ratio = r7;
        this.HasWatermark = r8;
        this.Cover = r9;
        this.OriginCover = r10;
        this.BitrateInfos = r11;
        this.DynamicCover = r12;
        this.PlayAddrH264 = r13;
        this.PlayAddr = r14;
        this.DownloadAddr = r15;
        this.PlayAddrLowbr = r16;
        this.NewDownloadAddr = r17;
        this.DownloadSuffixLogoAddr = r18;
        this.PlayAddrH265 = r19;
        this.CodecType = r20;
        this.UIAlikeDownloadAddr = r21;
        this.CaptionDownloadAddr = r22;
        this.ContentType = r23;
        this.ControlInfo = r24;
        this.CdnUrlExpired = r25;
        this.IsLongVideo = r26;
        this.VideoModel = r27;
        this.AnimatedCover = r28;
        this.NeedSetToken = r29;
        this.AiCover = r30;
        this.CoverTsp = r31;
        this.MiscDownloadAddrs = r32;
        this.IsCallBack = r33;
        this.PlayAddrByteVC1 = r34;
        this.BigThumbs = r35;
        this.meta = r36;
        this.UseStaticCover = r37;
        this.OptimizedCover = r38;
        this.HorizontalType = r39;
        this.FakeHorizontalInfo = r40;
        this.TrailerStartTime = r41;
        this.MiscDownloadAddrsStr = r42;
        this.BlurCover = r43;
        this.ResetCover = r44;
    }

    public /* synthetic */ VideoInfo(String r42, Integer r43, Integer r44, Integer r45, String r46, Boolean r47, UrlStruct r48, UrlStruct r49, List r50, UrlStruct r51, UrlStruct r52, UrlStruct r53, UrlStruct r54, UrlStruct r55, UrlStruct r56, UrlStruct r57, UrlStruct r58, String r59, UrlStruct r60, UrlStruct r61, Integer r62, VideoControlStruct r63, Long r64, Integer r65, String r66, UrlStruct r67, Boolean r68, UrlStruct r69, Double r70, Map r71, Boolean r72, UrlStruct r73, List r74, String r75, Boolean r76, UrlStruct r77, Integer r78, FakeHorizontalStruct r79, Double r80, String r81, UrlStruct r82, UrlStruct r83, int r84, int r85, DefaultConstructorMarker r86) {
        if ((r84 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r84 & 2) == 0) goto L9;
        Integer r4 = null;
    L11:
        if ((r84 & 4) == 0) goto L13;
        Integer r5 = null;
    L15:
        if ((r84 & 8) == 0) goto L17;
        Integer r6 = null;
    L19:
        if ((r84 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r84 & 32) == 0) goto L25;
        Boolean r8 = null;
    L27:
        if ((r84 & 64) == 0) goto L29;
        UrlStruct r9 = null;
    L31:
        if ((r84 & 128) == 0) goto L33;
        UrlStruct r10 = null;
    L35:
        if ((r84 & 256) == 0) goto L37;
        List r11 = null;
    L39:
        if ((r84 & 512) == 0) goto L41;
        UrlStruct r12 = null;
    L43:
        if ((r84 & 1024) == 0) goto L45;
        UrlStruct r13 = null;
    L47:
        if ((r84 & 2048) == 0) goto L49;
        UrlStruct r14 = null;
    L51:
        if ((r84 & 4096) == 0) goto L53;
        UrlStruct r15 = null;
    L55:
        if ((r84 & 8192) == 0) goto L57;
        UrlStruct r3 = null;
    L58:
        UrlStruct r16 = r3;
        if ((r84 & 16384) == 0) goto L61;
        UrlStruct r17 = null;
    L63:
        if ((r84 & 32768) == 0) goto L65;
        UrlStruct r18 = null;
    L67:
        if ((r84 & 65536) == 0) goto L69;
        UrlStruct r19 = null;
    L71:
        if ((r84 & 131072) == 0) goto L73;
        String r110 = null;
    L75:
        if ((r84 & 262144) == 0) goto L77;
        UrlStruct r20 = null;
    L79:
        if ((r84 & 524288) == 0) goto L81;
        UrlStruct r21 = null;
    L83:
        if ((r84 & 1048576) == 0) goto L85;
        Integer r22 = null;
    L87:
        if ((r84 & 2097152) == 0) goto L89;
        VideoControlStruct r23 = null;
    L91:
        if ((r84 & 4194304) == 0) goto L93;
        Long r24 = null;
    L95:
        if ((r84 & 8388608) == 0) goto L97;
        Integer r25 = null;
    L99:
        if ((r84 & 16777216) == 0) goto L101;
        String r26 = null;
    L103:
        if ((r84 & 33554432) == 0) goto L105;
        UrlStruct r27 = null;
    L107:
        if ((r84 & 67108864) == 0) goto L109;
        Boolean r28 = null;
    L111:
        if ((r84 & 134217728) == 0) goto L113;
        UrlStruct r29 = null;
    L115:
        if ((r84 & 268435456) == 0) goto L117;
        Double r30 = null;
    L119:
        if ((r84 & 536870912) == 0) goto L121;
        Map r31 = null;
    L123:
        if ((r84 & 1073741824) == 0) goto L125;
        Boolean r32 = null;
    L127:
        if ((r84 & Target.SIZE_ORIGINAL) == 0) goto L129;
        UrlStruct r0 = null;
    L131:
        if ((r85 & 1) == 0) goto L133;
        List r33 = null;
    L135:
        if ((r85 & 2) == 0) goto L137;
        String r34 = null;
    L139:
        if ((r85 & 4) == 0) goto L141;
        Boolean r35 = null;
    L143:
        if ((r85 & 8) == 0) goto L145;
        UrlStruct r36 = null;
    L147:
        if ((r85 & 16) == 0) goto L149;
        Integer r37 = null;
    L151:
        if ((r85 & 32) == 0) goto L153;
        FakeHorizontalStruct r38 = null;
    L155:
        if ((r85 & 64) == 0) goto L157;
        Double r39 = null;
    L158:
        UrlStruct r87 = r0;
        if ((r85 & 128) == 0) goto L161;
        String r1 = null;
    L162:
        String r40 = r1;
        if ((r85 & 256) == 0) goto L165;
        UrlStruct r41 = null;
    L167:
        if ((r85 & 512) == 0) goto L169;
        UrlStruct r88 = null;
    L170:
        this(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r87, r33, r34, r35, r36, r37, r38, r39, r40, r41, r88);
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
        r3 = r55;
        goto L58
    L53:
        r15 = r54;
        goto L55
    L49:
        r14 = r53;
        goto L51
    L45:
        r13 = r52;
        goto L47
    L41:
        r12 = r51;
        goto L43
    L37:
        r11 = r50;
        goto L39
    L33:
        r10 = r49;
        goto L35
    L29:
        r9 = r48;
        goto L31
    L25:
        r8 = r47;
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
