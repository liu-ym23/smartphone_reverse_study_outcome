package com.larus.ugc.feed.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\bO\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u0080\u00012\u00060\u0001j\u0002`\u0002:\u0003\u007f\u0080\u0001B\u008b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001c\u0010\u001dB÷\u0001\b\u0010\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001c\u0010!J\t\u0010U\u001a\u00020\u0004HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010>J\u000b\u0010`\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010>J\u000b\u0010e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0094\u0002\u0010k\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010lJ\u0006\u0010m\u001a\u00020\tJ\u0013\u0010n\u001a\u00020\u00102\b\u0010o\u001a\u0004\u0018\u00010pHÖ\u0003J\t\u0010q\u001a\u00020\tHÖ\u0001J\t\u0010r\u001a\u00020\u0004HÖ\u0001J\u0016\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\tJ%\u0010x\u001a\u00020t2\u0006\u0010y\u001a\u00020\u00002\u0006\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020}H\u0001¢\u0006\u0002\b~R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010#\u001a\u0004\b'\u0010%R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010#\u001a\u0004\b)\u0010%R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010#\u001a\u0004\b+\u0010%R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010/\u0012\u0004\b,\u0010#\u001a\u0004\b-\u0010.R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010#\u001a\u0004\b1\u0010%R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010#\u001a\u0004\b3\u0010%R&\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b4\u0010#\u001a\u0004\b5\u0010%\"\u0004\b6\u00107R&\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u0010#\u001a\u0004\b9\u0010%\"\u0004\b:\u00107R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010#\u001a\u0004\b<\u0010%R \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010?\u0012\u0004\b=\u0010#\u001a\u0004\b\u000f\u0010>R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010#\u001a\u0004\bA\u0010%R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010#\u001a\u0004\bC\u0010%R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010#\u001a\u0004\bE\u0010%R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010#\u001a\u0004\bG\u0010%R \u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010?\u0012\u0004\bH\u0010#\u001a\u0004\b\u0015\u0010>R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010#\u001a\u0004\bJ\u0010%R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010#\u001a\u0004\bL\u0010%R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010#\u001a\u0004\bN\u0010%R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010#\u001a\u0004\bP\u0010%R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bQ\u0010#\u001a\u0004\bR\u0010%R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bS\u0010#\u001a\u0004\bT\u0010%¨\u0006\u0081\u0001"}, d2 = {"Lcom/larus/ugc/feed/api/model/CreationFeedTrackParamsKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "currentPage", "", "recommendFrom", "botId", "conversationId", "actionBarTemplateId", "", "chatType", "enterFrom", "previousPage", "enterMethod", "aiCreationRecommendFrom", "isChatDoublePage", "", "currentPageKey", "templatePageType", "anchorCreationId", "douyinGid", "isFromAnchor", "promptType", "promptFrom", "visualSize", "tagCode", "wcbItemId", "recoRequestId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCurrentPage$annotations", "()V", "getCurrentPage", "()Ljava/lang/String;", "getRecommendFrom$annotations", "getRecommendFrom", "getBotId$annotations", "getBotId", "getConversationId$annotations", "getConversationId", "getActionBarTemplateId$annotations", "getActionBarTemplateId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getChatType$annotations", "getChatType", "getEnterFrom$annotations", "getEnterFrom", "getPreviousPage$annotations", "getPreviousPage", "setPreviousPage", "(Ljava/lang/String;)V", "getEnterMethod$annotations", "getEnterMethod", "setEnterMethod", "getAiCreationRecommendFrom$annotations", "getAiCreationRecommendFrom", "isChatDoublePage$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCurrentPageKey$annotations", "getCurrentPageKey", "getTemplatePageType$annotations", "getTemplatePageType", "getAnchorCreationId$annotations", "getAnchorCreationId", "getDouyinGid$annotations", "getDouyinGid", "isFromAnchor$annotations", "getPromptType$annotations", "getPromptType", "getPromptFrom$annotations", "getPromptFrom", "getVisualSize$annotations", "getVisualSize", "getTagCode$annotations", "getTagCode", "getWcbItemId$annotations", "getWcbItemId", "getRecoRequestId$annotations", "getRecoRequestId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/ugc/feed/api/model/CreationFeedTrackParamsKmp;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class CreationFeedTrackParamsKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<CreationFeedTrackParamsKmp> CREATOR = null;
    public static final b Companion = null;
    private final Integer actionBarTemplateId;
    private final String aiCreationRecommendFrom;
    private final String anchorCreationId;
    private final String botId;
    private final String chatType;
    private final String conversationId;
    private final String currentPage;
    private final String currentPageKey;
    private final String douyinGid;
    private final String enterFrom;
    private String enterMethod;
    private final Boolean isChatDoublePage;
    private final Boolean isFromAnchor;
    private String previousPage;
    private final String promptFrom;
    private final String promptType;
    private final String recoRequestId;
    private final String recommendFrom;
    private final String tagCode;
    private final String templatePageType;
    private final String visualSize;
    private final String wcbItemId;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreationFeedTrackParamsKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.CreationFeedTrackParamsKmp", r0, 22);
            r1.j("current_page", false);
            r1.j("recommend_from", true);
            r1.j("bot_id", true);
            r1.j("conversation_id", true);
            r1.j("action_bar_template_id", true);
            r1.j("chat_type", true);
            r1.j("enter_from", true);
            r1.j("previous_page", true);
            r1.j("enter_method", true);
            r1.j("ai_creation_recommend_from", true);
            r1.j("is_chat_double_page", true);
            r1.j("current_page_key", true);
            r1.j("template_page_type", true);
            r1.j("anchor_creation_id", true);
            r1.j("douyin_gid", true);
            r1.j("is_from_anchor", true);
            r1.j("prompt_type", true);
            r1.j("prompt_from", true);
            r1.j("visual_size", true);
            r1.j("tag_code", true);
            r1.j("wcb_item_id", true);
            r1.j("reco_request_id", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            i r2 = i.a;
            return new d[]{r1, kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(w0.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r50) {
            Intrinsics.checkNotNullParameter(r50, "decoder");
            g2 r1 = b;
            muc.c r0 = r50.beginStructure(r1);
            if (r0.decodeSequentially() == false) goto L5;
            String r2 = r0.decodeStringElement(r1, 0);
            v2 r9 = v2.a;
            String r10 = (String) r0.decodeNullableSerializableElement(r1, 1, r9, null);
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 2, r9, null);
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 3, r9, null);
            Integer r12 = (Integer) r0.decodeNullableSerializableElement(r1, 4, w0.a, null);
            String r13 = (String) r0.decodeNullableSerializableElement(r1, 5, r9, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 6, r9, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 7, r9, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 8, r9, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 9, r9, null);
            i r15 = i.a;
            Boolean r6 = (Boolean) r0.decodeNullableSerializableElement(r1, 10, r15, null);
            String r11 = (String) r0.decodeNullableSerializableElement(r1, 11, r9, null);
            String r16 = (String) r0.decodeNullableSerializableElement(r1, 12, r9, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 13, r9, null);
            String r18 = (String) r0.decodeNullableSerializableElement(r1, 14, r9, null);
            Boolean r19 = (Boolean) r0.decodeNullableSerializableElement(r1, 15, r15, null);
            String r110 = (String) r0.decodeNullableSerializableElement(r1, 16, r9, null);
            String r20 = (String) r0.decodeNullableSerializableElement(r1, 17, r9, null);
            String r21 = (String) r0.decodeNullableSerializableElement(r1, 18, r9, null);
            String r22 = (String) r0.decodeNullableSerializableElement(r1, 19, r9, null);
            String r33 = (String) r0.decodeNullableSerializableElement(r1, 20, r9, null);
            String r23 = r8;
            String r34 = (String) r0.decodeNullableSerializableElement(r1, 21, r9, null);
            String r29 = r110;
            String r32 = r22;
            String r31 = r21;
            String r30 = r20;
            Boolean r28 = r19;
            String r27 = r18;
            String r111 = r3;
            String r24 = r4;
            String r25 = r5;
            String r112 = r7;
            Integer r113 = r12;
            String r114 = r13;
            String r115 = r2;
            int r116 = 4194303;
            String r26 = r17;
            Boolean r210 = r6;
            String r117 = r14;
            String r118 = r10;
            String r211 = r16;
            String r212 = r11;
        L53:
            r0.endStructure(r1);
            return new CreationFeedTrackParamsKmp(r116, r115, r118, r112, r117, r113, r114, r111, r24, r23, r25, r210, r212, r211, r26, r27, r28, r29, r30, r31, r32, r33, r34, null);
        L5:
            String r35 = null;
            String r36 = null;
            String r37 = null;
            String r38 = null;
            String r39 = null;
            Integer r46 = null;
            String r40 = null;
            String r41 = null;
            Boolean r119 = null;
            Boolean r120 = null;
            String r121 = null;
            String r122 = null;
            String r213 = null;
            String r214 = null;
            String r310 = null;
            String r311 = null;
            String r312 = null;
            String r42 = null;
            String r43 = null;
            String r44 = null;
            String r45 = null;
            String r47 = null;
            int r123 = 0;
            boolean r48 = true;
        L6:
            if (r48 == false) goto L52;
            int r124 = r0.decodeElementIndex(r1);
            switch(r124) {
                case -1: goto L50;
                case 0: goto L48;
                case 1: goto L46;
                case 2: goto L44;
                case 3: goto L43;
                case 4: goto L41;
                case 5: goto L38;
                case 6: goto L36;
                case 7: goto L35;
                case 8: goto L34;
                case 9: goto L33;
                case 10: goto L31;
                case 11: goto L28;
                case 12: goto L26;
                case 13: goto L24;
                case 14: goto L23;
                case 15: goto L21;
                case 16: goto L19;
                case 17: goto L17;
                case 18: goto L15;
                case 19: goto L14;
                case 20: goto L12;
                case 21: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r124);
        L33:
            int r49 = r123 | 512;
            r43 = r43;
            String r51 = (String) r0.decodeNullableSerializableElement(r1, 9, v2.a, r45);
            r47 = r47;
        L40:
            String r52 = r51;
            r312 = r312;
        L42:
            r123 = r49;
            r214 = r214;
            r310 = r310;
            Integer r313 = r46;
            r45 = r52;
        L51:
            r45 = r45;
            r42 = r42;
            r38 = r38;
            r214 = r214;
            r46 = r313;
            r312 = r312;
            r43 = r43;
            r47 = r47;
            r311 = r311;
            r36 = r36;
            r35 = r35;
            r310 = r310;
            goto L6
        L34:
            r123 = r123 | 256;
            r311 = (String) r0.decodeNullableSerializableElement(r1, 8, v2.a, r311);
            r313 = r46;
        L49:
            r213 = r213;
            goto L51
        L35:
            r311 = r311;
            int r53 = r123 | 128;
            r43 = r43;
            r47 = (String) r0.decodeNullableSerializableElement(r1, 7, v2.a, r47);
        L39:
            r49 = r53;
            r51 = r45;
            goto L40
        L36:
            r47 = r47;
            r51 = r45;
            r43 = (String) r0.decodeNullableSerializableElement(r1, 6, v2.a, r43);
            r49 = r123 | 64;
            goto L40
        L38:
            r311 = r311;
            r47 = r47;
            r43 = r43;
            r312 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r312);
            r53 = r123 | 32;
            goto L39
        L41:
            r35 = r35;
            r36 = r36;
            r38 = r38;
            Integer r410 = r46;
            r311 = r311;
            r42 = r42;
            r43 = r43;
            r47 = r47;
            r312 = r312;
            r46 = (Integer) r0.decodeNullableSerializableElement(r1, 4, w0.a, r410);
            r52 = r45;
            r49 = r123 | 16;
            goto L42
        L43:
            String r54 = r310;
            r313 = r46;
            int r125 = r123 | 8;
            r310 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r54);
        L45:
            r214 = r214;
        L47:
            r123 = r125;
            goto L51
        L44:
            String r55 = r310;
            r313 = r46;
            r310 = r55;
            r214 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r214);
            r125 = r123 | 4;
            goto L45
        L46:
            r35 = r35;
            r36 = r36;
            r38 = r38;
            r310 = r310;
            r311 = r311;
            r312 = r312;
            r43 = r43;
            r45 = r45;
            r47 = r47;
            r313 = r46;
            r42 = r42;
            r214 = r214;
            r213 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r213);
            r125 = r123 | 2;
            goto L47
        L48:
            r311 = r311;
            r313 = r46;
            r44 = r0.decodeStringElement(r1, 0);
            r123 = r123 | 1;
            goto L49
        L50:
            r35 = r35;
            r36 = r36;
            r38 = r38;
            r214 = r214;
            r310 = r310;
            r311 = r311;
            r312 = r312;
            r43 = r43;
            r45 = r45;
            r47 = r47;
            r313 = r46;
            r42 = r42;
            r48 = false;
            goto L51
        L11:
            int r126 = 2097152;
            r38 = (String) r0.decodeNullableSerializableElement(r1, 21, v2.a, r38);
        L13:
            int r56 = r126 | r123;
            String r127 = r42;
        L30:
            r123 = r56;
            String r57 = r127;
        L32:
            r42 = r57;
            r38 = r38;
            r46 = r46;
            goto L6
        L12:
            r38 = r38;
            r42 = (String) r0.decodeNullableSerializableElement(r1, 20, v2.a, r42);
            r126 = 1048576;
            goto L13
        L14:
            r41 = (String) r0.decodeNullableSerializableElement(r1, 19, v2.a, r41);
            int r128 = 524288;
        L22:
            int r129 = r128 | r123;
        L29:
            int r411 = r129;
            r127 = r42;
            r56 = r411;
            goto L30
        L15:
            r39 = (String) r0.decodeNullableSerializableElement(r1, 18, v2.a, r39);
            r128 = 262144;
            goto L22
        L17:
            r38 = r38;
            r46 = r46;
            r42 = r42;
            r35 = (String) r0.decodeNullableSerializableElement(r1, 17, v2.a, r35);
            r128 = 131072;
            goto L22
        L19:
            r38 = r38;
            r46 = r46;
            r42 = r42;
            r121 = (String) r0.decodeNullableSerializableElement(r1, 16, v2.a, r121);
            r128 = 65536;
            goto L22
        L21:
            r38 = r38;
            r46 = r46;
            r42 = r42;
            r120 = (Boolean) r0.decodeNullableSerializableElement(r1, 15, i.a, r120);
            r128 = 32768;
            goto L22
        L23:
            r38 = r38;
            r46 = r46;
            r42 = r42;
            r36 = (String) r0.decodeNullableSerializableElement(r1, 14, v2.a, r36);
            r129 = r123 | 16384;
            goto L29
        L24:
            r38 = r38;
            r46 = r46;
            r42 = r42;
            r122 = (String) r0.decodeNullableSerializableElement(r1, 13, v2.a, r122);
            r129 = r123 | 8192;
            goto L29
        L26:
            r38 = r38;
            r46 = r46;
            r42 = r42;
            r37 = (String) r0.decodeNullableSerializableElement(r1, 12, v2.a, r37);
            r129 = r123 | 4096;
            goto L29
        L28:
            r38 = r38;
            r46 = r46;
            r42 = r42;
            r40 = (String) r0.decodeNullableSerializableElement(r1, 11, v2.a, r40);
            r129 = r123 | 2048;
            goto L29
        L31:
            r38 = r38;
            r46 = r46;
            r57 = r42;
            r123 = r123 | 1024;
            r119 = (Boolean) r0.decodeNullableSerializableElement(r1, 10, i.a, r119);
            goto L32
        L52:
            String r314 = r36;
            String r58 = r213;
            String r215 = r214;
            String r216 = r310;
            r211 = r37;
            r25 = r45;
            r31 = r39;
            r212 = r40;
            r210 = r119;
            r28 = r120;
            r29 = r121;
            r113 = r46;
            r114 = r312;
            r111 = r43;
            r24 = r47;
            r23 = r311;
            r30 = r35;
            r115 = r44;
            r118 = r58;
            r33 = r42;
            r32 = r41;
            r116 = r123;
            r34 = r38;
            r117 = r216;
            r27 = r314;
            r26 = r122;
            r112 = r215;
            goto L53
        }

        public final void serialize(muc.f r2, Object r3) {
            CreationFeedTrackParamsKmp r4 = (CreationFeedTrackParamsKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            CreationFeedTrackParamsKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CreationFeedTrackParamsKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<CreationFeedTrackParamsKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationFeedTrackParamsKmp createFromParcel(Parcel r29) {
            Intrinsics.checkNotNullParameter(r29, "parcel");
            String r3 = r29.readString();
            String r4 = r29.readString();
            String r5 = r29.readString();
            String r6 = r29.readString();
            if (r29.readInt() != 0) goto L5;
            Integer r8 = null;
        L6:
            String r9 = r29.readString();
            String r10 = r29.readString();
            String r11 = r29.readString();
            String r12 = r29.readString();
            String r13 = r29.readString();
            boolean r14 = false;
            if (r29.readInt() != 0) goto L10;
            Boolean r16 = null;
        L14:
            String r17 = r29.readString();
            String r18 = r29.readString();
            String r25 = r29.readString();
            String r26 = r29.readString();
            if (r29.readInt() != 0) goto L18;
            Boolean r27 = null;
        L22:
            return new CreationFeedTrackParamsKmp(r3, r4, r5, r6, r8, r9, r10, r11, r12, r13, r16, r17, r18, r25, r26, r27, r29.readString(), r29.readString(), r29.readString(), r29.readString(), r29.readString(), r29.readString());
        L18:
            if (r29.readInt() == 0) goto L20;
            r14 = true;
        L20:
            r27 = Boolean.valueOf(r14);
            goto L22
        L10:
            if (r29.readInt() == 0) goto L12;
            boolean r2 = true;
        L13:
            r16 = Boolean.valueOf(r2);
            goto L14
        L12:
            r2 = false;
            goto L13
        L5:
            r8 = Integer.valueOf(r29.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CreationFeedTrackParamsKmp[] newArray(int r1) {
            return new CreationFeedTrackParamsKmp[r1];
        }
    }

    public static /* synthetic */ CreationFeedTrackParamsKmp copy$default(CreationFeedTrackParamsKmp r17, String r18, String r19, String r20, String r21, Integer r22, String r23, String r24, String r25, String r26, String r27, Boolean r28, String r29, String r30, String r31, String r32, Boolean r33, String r34, String r35, String r36, String r37, String r38, String r39, int r40, Object r41) {
        if ((r40 & 1) == 0) goto L5;
        String r2 = r17.currentPage;
    L7:
        if ((r40 & 2) == 0) goto L9;
        String r3 = r17.recommendFrom;
    L11:
        if ((r40 & 4) == 0) goto L13;
        String r4 = r17.botId;
    L15:
        if ((r40 & 8) == 0) goto L17;
        String r5 = r17.conversationId;
    L19:
        if ((r40 & 16) == 0) goto L21;
        Integer r6 = r17.actionBarTemplateId;
    L23:
        if ((r40 & 32) == 0) goto L25;
        String r7 = r17.chatType;
    L27:
        if ((r40 & 64) == 0) goto L29;
        String r8 = r17.enterFrom;
    L31:
        if ((r40 & 128) == 0) goto L33;
        String r9 = r17.previousPage;
    L35:
        if ((r40 & 256) == 0) goto L37;
        String r10 = r17.enterMethod;
    L39:
        if ((r40 & 512) == 0) goto L41;
        String r11 = r17.aiCreationRecommendFrom;
    L43:
        if ((r40 & 1024) == 0) goto L45;
        Boolean r12 = r17.isChatDoublePage;
    L47:
        if ((r40 & 2048) == 0) goto L49;
        String r13 = r17.currentPageKey;
    L51:
        if ((r40 & 4096) == 0) goto L53;
        String r14 = r17.templatePageType;
    L55:
        if ((r40 & 8192) == 0) goto L57;
        String r15 = r17.anchorCreationId;
    L58:
        String r310 = r15;
        if ((r40 & 16384) == 0) goto L61;
        String r16 = r17.douyinGid;
    L62:
        String r311 = r16;
        if ((r40 & 32768) == 0) goto L65;
        Boolean r110 = r17.isFromAnchor;
    L66:
        Boolean r312 = r110;
        if ((r40 & 65536) == 0) goto L69;
        String r111 = r17.promptType;
    L70:
        String r313 = r111;
        if ((r40 & 131072) == 0) goto L73;
        String r112 = r17.promptFrom;
    L74:
        String r314 = r112;
        if ((r40 & 262144) == 0) goto L77;
        String r113 = r17.visualSize;
    L78:
        String r315 = r113;
        if ((r40 & 524288) == 0) goto L81;
        String r114 = r17.tagCode;
    L82:
        String r316 = r114;
        if ((r40 & 1048576) == 0) goto L85;
        String r115 = r17.wcbItemId;
    L87:
        if ((r40 & 2097152) == 0) goto L89;
        String r1 = r17.recoRequestId;
    L91:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r115, r1);
    L89:
        r1 = r39;
        goto L91
    L85:
        r115 = r38;
        goto L87
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
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

    @SerialName("action_bar_template_id")
    public static /* synthetic */ void getActionBarTemplateId$annotations() {
    }

    @SerialName("ai_creation_recommend_from")
    public static /* synthetic */ void getAiCreationRecommendFrom$annotations() {
    }

    @SerialName("anchor_creation_id")
    public static /* synthetic */ void getAnchorCreationId$annotations() {
    }

    @SerialName("bot_id")
    public static /* synthetic */ void getBotId$annotations() {
    }

    @SerialName("chat_type")
    public static /* synthetic */ void getChatType$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("current_page")
    public static /* synthetic */ void getCurrentPage$annotations() {
    }

    @SerialName("current_page_key")
    public static /* synthetic */ void getCurrentPageKey$annotations() {
    }

    @SerialName("douyin_gid")
    public static /* synthetic */ void getDouyinGid$annotations() {
    }

    @SerialName("enter_from")
    public static /* synthetic */ void getEnterFrom$annotations() {
    }

    @SerialName("enter_method")
    public static /* synthetic */ void getEnterMethod$annotations() {
    }

    @SerialName("previous_page")
    public static /* synthetic */ void getPreviousPage$annotations() {
    }

    @SerialName("prompt_from")
    public static /* synthetic */ void getPromptFrom$annotations() {
    }

    @SerialName("prompt_type")
    public static /* synthetic */ void getPromptType$annotations() {
    }

    @SerialName("reco_request_id")
    public static /* synthetic */ void getRecoRequestId$annotations() {
    }

    @SerialName("recommend_from")
    public static /* synthetic */ void getRecommendFrom$annotations() {
    }

    @SerialName("tag_code")
    public static /* synthetic */ void getTagCode$annotations() {
    }

    @SerialName("template_page_type")
    public static /* synthetic */ void getTemplatePageType$annotations() {
    }

    @SerialName("visual_size")
    public static /* synthetic */ void getVisualSize$annotations() {
    }

    @SerialName("wcb_item_id")
    public static /* synthetic */ void getWcbItemId$annotations() {
    }

    @SerialName("is_chat_double_page")
    public static /* synthetic */ void isChatDoublePage$annotations() {
    }

    @SerialName("is_from_anchor")
    public static /* synthetic */ void isFromAnchor$annotations() {
    }

    public final String component1() {
        return this.currentPage;
    }

    public final String component10() {
        return this.aiCreationRecommendFrom;
    }

    public final Boolean component11() {
        return this.isChatDoublePage;
    }

    public final String component12() {
        return this.currentPageKey;
    }

    public final String component13() {
        return this.templatePageType;
    }

    public final String component14() {
        return this.anchorCreationId;
    }

    public final String component15() {
        return this.douyinGid;
    }

    public final Boolean component16() {
        return this.isFromAnchor;
    }

    public final String component17() {
        return this.promptType;
    }

    public final String component18() {
        return this.promptFrom;
    }

    public final String component19() {
        return this.visualSize;
    }

    public final String component2() {
        return this.recommendFrom;
    }

    public final String component20() {
        return this.tagCode;
    }

    public final String component21() {
        return this.wcbItemId;
    }

    public final String component22() {
        return this.recoRequestId;
    }

    public final String component3() {
        return this.botId;
    }

    public final String component4() {
        return this.conversationId;
    }

    public final Integer component5() {
        return this.actionBarTemplateId;
    }

    public final String component6() {
        return this.chatType;
    }

    public final String component7() {
        return this.enterFrom;
    }

    public final String component8() {
        return this.previousPage;
    }

    public final String component9() {
        return this.enterMethod;
    }

    public final CreationFeedTrackParamsKmp copy(String r26, String r27, String r28, String r29, Integer r30, String r31, String r32, String r33, String r34, String r35, Boolean r36, String r37, String r38, String r39, String r40, Boolean r41, String r42, String r43, String r44, String r45, String r46, String r47) {
        Intrinsics.checkNotNullParameter(r26, "currentPage");
        return new CreationFeedTrackParamsKmp(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationFeedTrackParamsKmp) == true) goto L8;
        return false;
    L8:
        CreationFeedTrackParamsKmp r6 = (CreationFeedTrackParamsKmp) r5;
        if (Intrinsics.areEqual(this.currentPage, r6.currentPage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recommendFrom, r6.recommendFrom) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.actionBarTemplateId, r6.actionBarTemplateId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.chatType, r6.chatType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.enterFrom, r6.enterFrom) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.previousPage, r6.previousPage) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.enterMethod, r6.enterMethod) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.aiCreationRecommendFrom, r6.aiCreationRecommendFrom) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.isChatDoublePage, r6.isChatDoublePage) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.currentPageKey, r6.currentPageKey) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.templatePageType, r6.templatePageType) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.anchorCreationId, r6.anchorCreationId) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.douyinGid, r6.douyinGid) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.isFromAnchor, r6.isFromAnchor) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.promptType, r6.promptType) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.promptFrom, r6.promptFrom) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.visualSize, r6.visualSize) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.tagCode, r6.tagCode) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.wcbItemId, r6.wcbItemId) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.recoRequestId, r6.recoRequestId) == true) goto L74;
        return false;
    L74:
        return true;
    }

    public int hashCode() {
        int r0 = this.currentPage.hashCode() * 31;
        String r1 = this.recommendFrom;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.botId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.conversationId;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.actionBarTemplateId;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.chatType;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.enterFrom;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.previousPage;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.enterMethod;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.aiCreationRecommendFrom;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        Boolean r29 = this.isChatDoublePage;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        String r32 = this.currentPageKey;
        if (r32 != null) goto L45;
        int r33 = 0;
    L46:
        int r34 = (r31 + r33) * 31;
        String r35 = this.templatePageType;
        if (r35 != null) goto L49;
        int r36 = 0;
    L50:
        int r37 = (r34 + r36) * 31;
        String r38 = this.anchorCreationId;
        if (r38 != null) goto L53;
        int r39 = 0;
    L54:
        int r40 = (r37 + r39) * 31;
        String r41 = this.douyinGid;
        if (r41 != null) goto L57;
        int r42 = 0;
    L58:
        int r43 = (r40 + r42) * 31;
        Boolean r44 = this.isFromAnchor;
        if (r44 != null) goto L61;
        int r45 = 0;
    L62:
        int r46 = (r43 + r45) * 31;
        String r47 = this.promptType;
        if (r47 != null) goto L65;
        int r48 = 0;
    L66:
        int r49 = (r46 + r48) * 31;
        String r50 = this.promptFrom;
        if (r50 != null) goto L69;
        int r51 = 0;
    L70:
        int r52 = (r49 + r51) * 31;
        String r53 = this.visualSize;
        if (r53 != null) goto L73;
        int r54 = 0;
    L74:
        int r55 = (r52 + r54) * 31;
        String r56 = this.tagCode;
        if (r56 != null) goto L77;
        int r57 = 0;
    L78:
        int r58 = (r55 + r57) * 31;
        String r59 = this.wcbItemId;
        if (r59 != null) goto L81;
        int r60 = 0;
    L82:
        int r61 = (r58 + r60) * 31;
        String r62 = this.recoRequestId;
        if (r62 == null) goto L87;
        r2 = r62.hashCode();
    L87:
        return r61 + r2;
    L81:
        r60 = r59.hashCode();
        goto L82
    L77:
        r57 = r56.hashCode();
        goto L78
    L73:
        r54 = r53.hashCode();
        goto L74
    L69:
        r51 = r50.hashCode();
        goto L70
    L65:
        r48 = r47.hashCode();
        goto L66
    L61:
        r45 = r44.hashCode();
        goto L62
    L57:
        r42 = r41.hashCode();
        goto L58
    L53:
        r39 = r38.hashCode();
        goto L54
    L49:
        r36 = r35.hashCode();
        goto L50
    L45:
        r33 = r32.hashCode();
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
        return "CreationFeedTrackParamsKmp(currentPage=" + this.currentPage + ", recommendFrom=" + this.recommendFrom + ", botId=" + this.botId + ", conversationId=" + this.conversationId + ", actionBarTemplateId=" + this.actionBarTemplateId + ", chatType=" + this.chatType + ", enterFrom=" + this.enterFrom + ", previousPage=" + this.previousPage + ", enterMethod=" + this.enterMethod + ", aiCreationRecommendFrom=" + this.aiCreationRecommendFrom + ", isChatDoublePage=" + this.isChatDoublePage + ", currentPageKey=" + this.currentPageKey + ", templatePageType=" + this.templatePageType + ", anchorCreationId=" + this.anchorCreationId + ", douyinGid=" + this.douyinGid + ", isFromAnchor=" + this.isFromAnchor + ", promptType=" + this.promptType + ", promptFrom=" + this.promptFrom + ", visualSize=" + this.visualSize + ", tagCode=" + this.tagCode + ", wcbItemId=" + this.wcbItemId + ", recoRequestId=" + this.recoRequestId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.currentPage);
        r3.writeString(this.recommendFrom);
        r3.writeString(this.botId);
        r3.writeString(this.conversationId);
        Integer r5 = this.actionBarTemplateId;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.chatType);
        r3.writeString(this.enterFrom);
        r3.writeString(this.previousPage);
        r3.writeString(this.enterMethod);
        r3.writeString(this.aiCreationRecommendFrom);
        Boolean r6 = this.isChatDoublePage;
        if (r6 != null) goto L9;
        r3.writeInt(0);
    L10:
        r3.writeString(this.currentPageKey);
        r3.writeString(this.templatePageType);
        r3.writeString(this.anchorCreationId);
        r3.writeString(this.douyinGid);
        Boolean r7 = this.isFromAnchor;
        if (r7 != null) goto L13;
        r3.writeInt(0);
    L14:
        r3.writeString(this.promptType);
        r3.writeString(this.promptFrom);
        r3.writeString(this.visualSize);
        r3.writeString(this.tagCode);
        r3.writeString(this.wcbItemId);
        r3.writeString(this.recoRequestId);
        return;
    L13:
        r3.writeInt(1);
        r3.writeInt(r7.booleanValue() ? 1 : 0);
        goto L14
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.intValue());
        goto L6
    }

    static {
        Companion = new b();
        $stable = 8;
        CREATOR = new c();
    }

    public final Integer getActionBarTemplateId() {
        return this.actionBarTemplateId;
    }

    public final String getAiCreationRecommendFrom() {
        return this.aiCreationRecommendFrom;
    }

    public final String getAnchorCreationId() {
        return this.anchorCreationId;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getChatType() {
        return this.chatType;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getCurrentPage() {
        return this.currentPage;
    }

    public final String getCurrentPageKey() {
        return this.currentPageKey;
    }

    public final String getDouyinGid() {
        return this.douyinGid;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getPromptFrom() {
        return this.promptFrom;
    }

    public final String getPromptType() {
        return this.promptType;
    }

    public final String getRecoRequestId() {
        return this.recoRequestId;
    }

    public final String getRecommendFrom() {
        return this.recommendFrom;
    }

    public final String getTagCode() {
        return this.tagCode;
    }

    public final String getTemplatePageType() {
        return this.templatePageType;
    }

    public final String getVisualSize() {
        return this.visualSize;
    }

    public final String getWcbItemId() {
        return this.wcbItemId;
    }

    public final Boolean isChatDoublePage() {
        return this.isChatDoublePage;
    }

    public final Boolean isFromAnchor() {
        return this.isFromAnchor;
    }

    public final void setEnterMethod(String r1) {
        this.enterMethod = r1;
    }

    public final void setPreviousPage(String r1) {
        this.previousPage = r1;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(CreationFeedTrackParamsKmp r5, muc.d r6, f r7) {
        boolean r1 = false;
        r6.encodeStringElement(r7, 0, r5.currentPage);
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L6;
    L4:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 1, v2.a, r5.recommendFrom);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L15;
    L13:
        boolean r3 = true;
    L18:
        if (r3 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 2, v2.a, r5.botId);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L24;
    L22:
        boolean r4 = true;
    L27:
        if (r4 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 3, v2.a, r5.conversationId);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L33;
    L31:
        boolean r8 = true;
    L36:
        if (r8 == false) goto L39;
        r6.encodeNullableSerializableElement(r7, 4, w0.a, r5.actionBarTemplateId);
    L39:
        if (r6.shouldEncodeElementDefault(r7, 5) == false) goto L42;
    L40:
        boolean r9 = true;
    L45:
        if (r9 == false) goto L48;
        r6.encodeNullableSerializableElement(r7, 5, v2.a, r5.chatType);
    L48:
        if (r6.shouldEncodeElementDefault(r7, 6) == false) goto L51;
    L49:
        boolean r10 = true;
    L54:
        if (r10 == false) goto L57;
        r6.encodeNullableSerializableElement(r7, 6, v2.a, r5.enterFrom);
    L57:
        if (r6.shouldEncodeElementDefault(r7, 7) == false) goto L60;
    L58:
        boolean r11 = true;
    L63:
        if (r11 == false) goto L66;
        r6.encodeNullableSerializableElement(r7, 7, v2.a, r5.previousPage);
    L66:
        if (r6.shouldEncodeElementDefault(r7, 8) == false) goto L69;
    L67:
        boolean r12 = true;
    L72:
        if (r12 == false) goto L75;
        r6.encodeNullableSerializableElement(r7, 8, v2.a, r5.enterMethod);
    L75:
        if (r6.shouldEncodeElementDefault(r7, 9) == false) goto L78;
    L76:
        boolean r13 = true;
    L81:
        if (r13 == false) goto L84;
        r6.encodeNullableSerializableElement(r7, 9, v2.a, r5.aiCreationRecommendFrom);
    L84:
        if (r6.shouldEncodeElementDefault(r7, 10) == false) goto L87;
    L85:
        boolean r14 = true;
    L90:
        if (r14 == false) goto L93;
        r6.encodeNullableSerializableElement(r7, 10, i.a, r5.isChatDoublePage);
    L93:
        if (r6.shouldEncodeElementDefault(r7, 11) == false) goto L96;
    L94:
        boolean r15 = true;
    L99:
        if (r15 == false) goto L102;
        r6.encodeNullableSerializableElement(r7, 11, v2.a, r5.currentPageKey);
    L102:
        if (r6.shouldEncodeElementDefault(r7, 12) == false) goto L105;
    L103:
        boolean r16 = true;
    L108:
        if (r16 == false) goto L111;
        r6.encodeNullableSerializableElement(r7, 12, v2.a, r5.templatePageType);
    L111:
        if (r6.shouldEncodeElementDefault(r7, 13) == false) goto L114;
    L112:
        boolean r17 = true;
    L117:
        if (r17 == false) goto L120;
        r6.encodeNullableSerializableElement(r7, 13, v2.a, r5.anchorCreationId);
    L120:
        if (r6.shouldEncodeElementDefault(r7, 14) == false) goto L123;
    L121:
        boolean r18 = true;
    L126:
        if (r18 == false) goto L129;
        r6.encodeNullableSerializableElement(r7, 14, v2.a, r5.douyinGid);
    L129:
        if (r6.shouldEncodeElementDefault(r7, 15) == false) goto L132;
    L130:
        boolean r19 = true;
    L135:
        if (r19 == false) goto L138;
        r6.encodeNullableSerializableElement(r7, 15, i.a, r5.isFromAnchor);
    L138:
        if (r6.shouldEncodeElementDefault(r7, 16) == false) goto L141;
    L139:
        boolean r20 = true;
    L144:
        if (r20 == false) goto L147;
        r6.encodeNullableSerializableElement(r7, 16, v2.a, r5.promptType);
    L147:
        if (r6.shouldEncodeElementDefault(r7, 17) == false) goto L150;
    L148:
        boolean r21 = true;
    L153:
        if (r21 == false) goto L156;
        r6.encodeNullableSerializableElement(r7, 17, v2.a, r5.promptFrom);
    L156:
        if (r6.shouldEncodeElementDefault(r7, 18) == false) goto L159;
    L157:
        boolean r22 = true;
    L162:
        if (r22 == false) goto L165;
        r6.encodeNullableSerializableElement(r7, 18, v2.a, r5.visualSize);
    L165:
        if (r6.shouldEncodeElementDefault(r7, 19) == false) goto L168;
    L166:
        boolean r23 = true;
    L171:
        if (r23 == false) goto L174;
        r6.encodeNullableSerializableElement(r7, 19, v2.a, r5.tagCode);
    L174:
        if (r6.shouldEncodeElementDefault(r7, 20) == false) goto L177;
    L175:
        boolean r24 = true;
    L180:
        if (r24 == false) goto L183;
        r6.encodeNullableSerializableElement(r7, 20, v2.a, r5.wcbItemId);
    L183:
        if (r6.shouldEncodeElementDefault(r7, 21) == false) goto L186;
    L184:
        r1 = true;
    L188:
        if (r1 == false) goto L191;
        r6.encodeNullableSerializableElement(r7, 21, v2.a, r5.recoRequestId);
        return;
    L191:
        return;
    L186:
        if (r5.recoRequestId == null) goto L188;
    L177:
        if (r5.wcbItemId != null) goto L175;
        r24 = false;
        goto L180
    L168:
        if (r5.tagCode != null) goto L166;
        r23 = false;
        goto L171
    L159:
        if (r5.visualSize != null) goto L157;
        r22 = false;
        goto L162
    L150:
        if (r5.promptFrom != null) goto L148;
        r21 = false;
        goto L153
    L141:
        if (r5.promptType != null) goto L139;
        r20 = false;
        goto L144
    L132:
        if (Intrinsics.areEqual(r5.isFromAnchor, Boolean.FALSE) == false) goto L130;
        r19 = false;
        goto L135
    L123:
        if (r5.douyinGid != null) goto L121;
        r18 = false;
        goto L126
    L114:
        if (r5.anchorCreationId != null) goto L112;
        r17 = false;
        goto L117
    L105:
        if (r5.templatePageType != null) goto L103;
        r16 = false;
        goto L108
    L96:
        if (r5.currentPageKey != null) goto L94;
        r15 = false;
        goto L99
    L87:
        if (Intrinsics.areEqual(r5.isChatDoublePage, Boolean.FALSE) == false) goto L85;
        r14 = false;
        goto L90
    L78:
        if (r5.aiCreationRecommendFrom != null) goto L76;
        r13 = false;
        goto L81
    L69:
        if (r5.enterMethod != null) goto L67;
        r12 = false;
        goto L72
    L60:
        if (r5.previousPage != null) goto L58;
        r11 = false;
        goto L63
    L51:
        if (r5.enterFrom != null) goto L49;
        r10 = false;
        goto L54
    L42:
        if (r5.chatType != null) goto L40;
        r9 = false;
        goto L45
    L33:
        if (r5.actionBarTemplateId != null) goto L31;
        r8 = false;
        goto L36
    L24:
        if (r5.conversationId != null) goto L22;
        r4 = false;
        goto L27
    L15:
        if (r5.botId != null) goto L13;
        r3 = false;
        goto L18
    L6:
        if (r5.recommendFrom != null) goto L4;
        r2 = false;
        goto L9
    }

    public CreationFeedTrackParamsKmp(String r4, String r5, String r6, String r7, Integer r8, String r9, String r10, String r11, String r12, String r13, Boolean r14, String r15, String r16, String r17, String r18, Boolean r19, String r20, String r21, String r22, String r23, String r24, String r25) {
        Intrinsics.checkNotNullParameter(r4, "currentPage");
        this.currentPage = r4;
        this.recommendFrom = r5;
        this.botId = r6;
        this.conversationId = r7;
        this.actionBarTemplateId = r8;
        this.chatType = r9;
        this.enterFrom = r10;
        this.previousPage = r11;
        this.enterMethod = r12;
        this.aiCreationRecommendFrom = r13;
        this.isChatDoublePage = r14;
        this.currentPageKey = r15;
        this.templatePageType = r16;
        this.anchorCreationId = r17;
        this.douyinGid = r18;
        this.isFromAnchor = r19;
        this.promptType = r20;
        this.promptFrom = r21;
        this.visualSize = r22;
        this.tagCode = r23;
        this.wcbItemId = r24;
        this.recoRequestId = r25;
    }

    public CreationFeedTrackParamsKmp(int r6, String r7, String r8, String r9, String r10, Integer r11, String r12, String r13, String r14, String r15, String r16, Boolean r17, String r18, String r19, String r20, String r21, Boolean r22, String r23, String r24, String r25, String r26, String r27, String r28, q2 r29) {
        if (1 != (r6 & 1)) goto L89;
        this.currentPage = r7;
        if ((r6 & 2) != 0) goto L7;
        this.recommendFrom = null;
    L9:
        if ((r6 & 4) != 0) goto L11;
        this.botId = null;
    L13:
        if ((r6 & 8) != 0) goto L15;
        this.conversationId = null;
    L17:
        if ((r6 & 16) != 0) goto L19;
        this.actionBarTemplateId = null;
    L21:
        if ((r6 & 32) != 0) goto L23;
        this.chatType = null;
    L25:
        if ((r6 & 64) != 0) goto L27;
        this.enterFrom = null;
    L29:
        if ((r6 & 128) != 0) goto L31;
        this.previousPage = null;
    L33:
        if ((r6 & 256) != 0) goto L35;
        this.enterMethod = null;
    L37:
        if ((r6 & 512) != 0) goto L39;
        this.aiCreationRecommendFrom = null;
    L41:
        if ((r6 & 1024) != 0) goto L43;
        Boolean r2 = Boolean.FALSE;
    L44:
        this.isChatDoublePage = r2;
        if ((r6 & 2048) != 0) goto L47;
        this.currentPageKey = null;
    L49:
        if ((r6 & 4096) != 0) goto L51;
        this.templatePageType = null;
    L53:
        if ((r6 & 8192) != 0) goto L55;
        this.anchorCreationId = null;
    L57:
        if ((r6 & 16384) != 0) goto L59;
        this.douyinGid = null;
    L61:
        if ((32768 & r6) != 0) goto L63;
        Boolean r3 = Boolean.FALSE;
    L64:
        this.isFromAnchor = r3;
        if ((65536 & r6) != 0) goto L67;
        this.promptType = null;
    L69:
        if ((131072 & r6) != 0) goto L71;
        this.promptFrom = null;
    L73:
        if ((262144 & r6) != 0) goto L75;
        this.visualSize = null;
    L77:
        if ((524288 & r6) != 0) goto L79;
        this.tagCode = null;
    L81:
        if ((1048576 & r6) != 0) goto L83;
        this.wcbItemId = null;
    L85:
        if ((r6 & 2097152) != 0) goto L87;
        this.recoRequestId = null;
        return;
    L87:
        this.recoRequestId = r28;
        return;
    L83:
        this.wcbItemId = r27;
        goto L85
    L79:
        this.tagCode = r26;
        goto L81
    L75:
        this.visualSize = r25;
        goto L77
    L71:
        this.promptFrom = r24;
        goto L73
    L67:
        this.promptType = r23;
        goto L69
    L63:
        r3 = r22;
        goto L64
    L59:
        this.douyinGid = r21;
        goto L61
    L55:
        this.anchorCreationId = r20;
        goto L57
    L51:
        this.templatePageType = r19;
        goto L53
    L47:
        this.currentPageKey = r18;
        goto L49
    L43:
        r2 = r17;
        goto L44
    L39:
        this.aiCreationRecommendFrom = r16;
        goto L41
    L35:
        this.enterMethod = r15;
        goto L37
    L31:
        this.previousPage = r14;
        goto L33
    L27:
        this.enterFrom = r13;
        goto L29
    L23:
        this.chatType = r12;
        goto L25
    L19:
        this.actionBarTemplateId = r11;
        goto L21
    L15:
        this.conversationId = r10;
        goto L17
    L11:
        this.botId = r9;
        goto L13
    L7:
        this.recommendFrom = r8;
        goto L9
    L89:
        b2.b(r6, 1, a.b);
        throw null;
    }

    public /* synthetic */ CreationFeedTrackParamsKmp(String r24, String r25, String r26, String r27, Integer r28, String r29, String r30, String r31, String r32, String r33, Boolean r34, String r35, String r36, String r37, String r38, Boolean r39, String r40, String r41, String r42, String r43, String r44, String r45, int r46, DefaultConstructorMarker r47) {
        String r2 = null;
        if ((r46 & 2) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r46 & 4) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r46 & 8) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r46 & 16) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r46 & 32) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r46 & 64) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r46 & 128) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r46 & 256) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r46 & 512) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r46 & 1024) == 0) goto L41;
        Boolean r11 = Boolean.FALSE;
    L43:
        if ((r46 & 2048) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r46 & 4096) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r46 & 8192) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r46 & 16384) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r46 & 32768) == 0) goto L61;
        Boolean r16 = Boolean.FALSE;
    L63:
        if ((r46 & 65536) == 0) goto L65;
        String r17 = null;
    L67:
        if ((r46 & 131072) == 0) goto L69;
        String r18 = null;
    L71:
        if ((r46 & 262144) == 0) goto L73;
        String r19 = null;
    L75:
        if ((r46 & 524288) == 0) goto L77;
        String r20 = null;
    L79:
        if ((r46 & 1048576) == 0) goto L81;
        String r21 = null;
    L83:
        if ((r46 & 2097152) != 0) goto L86;
        r2 = r45;
    L86:
        this(r24, r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r2);
        return;
    L81:
        r21 = r44;
        goto L83
    L77:
        r20 = r43;
        goto L79
    L73:
        r19 = r42;
        goto L75
    L69:
        r18 = r41;
        goto L71
    L65:
        r17 = r40;
        goto L67
    L61:
        r16 = r39;
        goto L63
    L57:
        r15 = r38;
        goto L59
    L53:
        r14 = r37;
        goto L55
    L49:
        r13 = r36;
        goto L51
    L45:
        r12 = r35;
        goto L47
    L41:
        r11 = r34;
        goto L43
    L37:
        r10 = r33;
        goto L39
    L33:
        r9 = r32;
        goto L35
    L29:
        r8 = r31;
        goto L31
    L25:
        r7 = r30;
        goto L27
    L21:
        r6 = r29;
        goto L23
    L17:
        r5 = r28;
        goto L19
    L13:
        r4 = r27;
        goto L15
    L9:
        r3 = r26;
        goto L11
    L5:
        r1 = r25;
        goto L7
    }
}
