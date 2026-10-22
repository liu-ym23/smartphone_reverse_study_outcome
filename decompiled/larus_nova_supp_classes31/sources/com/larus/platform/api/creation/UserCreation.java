package com.larus.platform.api.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.UserCreationPrivateStatus;
import com.larus.platform.api.UserCreationStatus;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bK\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u009d\u00012\u00060\u0001j\u0002`\u0002:\u0004\u009c\u0001\u009d\u0001BÑ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!BÃ\u0001\b\u0010\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b \u0010%J\u0006\u0010e\u001a\u00020\u0016J\u0006\u0010f\u001a\u00020\u0016J\u0006\u0010g\u001a\u00020\u0016J\u0006\u0010h\u001a\u00020\u0016J\b\u0010i\u001a\u0004\u0018\u00010\u0004J\u0006\u0010j\u001a\u00020\u0004J\u0006\u0010k\u001a\u00020\u0004J\u0006\u0010l\u001a\u00020\u0004J\u0006\u0010m\u001a\u00020\u0004J\u0006\u0010n\u001a\u00020\u0004J\b\u0010o\u001a\u0004\u0018\u00010pJ\u0006\u0010q\u001a\u00020\u0004J\u0006\u0010r\u001a\u00020\u0004J\b\u0010s\u001a\u0004\u0018\u00010pJ\u0006\u0010t\u001a\u00020\u0016J\u0010\u0010u\u001a\u0004\u0018\u00010\u00042\u0006\u0010v\u001a\u00020\u0016J\u000b\u0010w\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010x\u001a\u00020\u0006HÆ\u0003J\u0010\u0010y\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010z\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010{\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010|\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010=J\u000b\u0010}\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010OJ\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010=J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001fHÆ\u0003JÚ\u0001\u0010\u0088\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÆ\u0001¢\u0006\u0003\u0010\u0089\u0001J\u0007\u0010\u008a\u0001\u001a\u00020\u0006J\u0016\u0010\u008b\u0001\u001a\u00020\u00162\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001HÖ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0006HÖ\u0001J\n\u0010\u008f\u0001\u001a\u00020\u0004HÖ\u0001J\u001b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u0094\u0001\u001a\u00020\u0006J-\u0010\u0095\u0001\u001a\u00030\u0091\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u00002\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0001¢\u0006\u0003\b\u009b\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010'\u001a\u0004\b+\u0010,R(\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u00102\u0012\u0004\b-\u0010'\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u00102\u0012\u0004\b3\u0010'\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R&\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010'\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010>\u0012\u0004\b;\u0010'\u001a\u0004\b<\u0010=R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010'\u001a\u0004\b@\u0010AR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010'\u001a\u0004\bC\u0010DR&\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bE\u0010'\u001a\u0004\bF\u0010)\"\u0004\bG\u0010HR \u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00102\u0012\u0004\bI\u0010'\u001a\u0004\bJ\u0010/R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010'\u001a\u0004\bL\u0010MR \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010P\u0012\u0004\bN\u0010'\u001a\u0004\b\u0015\u0010OR \u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010>\u0012\u0004\bQ\u0010'\u001a\u0004\bR\u0010=R&\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bS\u0010'\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bX\u0010'\u001a\u0004\bY\u0010ZR&\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b[\u0010'\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R&\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b`\u0010'\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d¨\u0006\u009e\u0001"}, d2 = {"Lcom/larus/platform/api/creation/UserCreation;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "creationId", "", "userCreationType", "", "status", "privateStatus", "content", "Lcom/larus/platform/api/creation/UserCreationContent;", "usageCount", "", "authorInfo", "Lcom/larus/platform/api/creation/AuthorInfo;", "dynamicInfo", "Lcom/larus/platform/api/creation/CreationDynamicInfo;", "creationTraceInfo", "contentSource", "communityInfo", "Lcom/larus/platform/api/creation/CreationCommunityInfo;", "isFavorite", "", "createTime", "clientTrackParams", "Lcom/larus/platform/api/creation/UserCreationTrackParams;", "refContent", "Lcom/larus/platform/api/creation/UserCreationRefContent;", "publishExtra", "Lcom/larus/platform/api/creation/CreationPublishExtra;", "awemeAnchor", "Lcom/larus/platform/api/creation/AwemeAnchor;", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Lcom/larus/platform/api/creation/UserCreationContent;Ljava/lang/Long;Lcom/larus/platform/api/creation/AuthorInfo;Lcom/larus/platform/api/creation/CreationDynamicInfo;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/platform/api/creation/CreationCommunityInfo;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/larus/platform/api/creation/UserCreationTrackParams;Lcom/larus/platform/api/creation/UserCreationRefContent;Lcom/larus/platform/api/creation/CreationPublishExtra;Lcom/larus/platform/api/creation/AwemeAnchor;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Lcom/larus/platform/api/creation/UserCreationContent;Ljava/lang/Long;Lcom/larus/platform/api/creation/AuthorInfo;Lcom/larus/platform/api/creation/CreationDynamicInfo;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/platform/api/creation/CreationCommunityInfo;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/larus/platform/api/creation/UserCreationTrackParams;Lcom/larus/platform/api/creation/UserCreationRefContent;Lcom/larus/platform/api/creation/CreationPublishExtra;Lcom/larus/platform/api/creation/AwemeAnchor;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCreationId$annotations", "()V", "getCreationId", "()Ljava/lang/String;", "getUserCreationType$annotations", "getUserCreationType", "()I", "getStatus$annotations", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPrivateStatus$annotations", "getPrivateStatus", "setPrivateStatus", "getContent$annotations", "getContent", "()Lcom/larus/platform/api/creation/UserCreationContent;", "setContent", "(Lcom/larus/platform/api/creation/UserCreationContent;)V", "getUsageCount$annotations", "getUsageCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAuthorInfo$annotations", "getAuthorInfo", "()Lcom/larus/platform/api/creation/AuthorInfo;", "getDynamicInfo$annotations", "getDynamicInfo", "()Lcom/larus/platform/api/creation/CreationDynamicInfo;", "getCreationTraceInfo$annotations", "getCreationTraceInfo", "setCreationTraceInfo", "(Ljava/lang/String;)V", "getContentSource$annotations", "getContentSource", "getCommunityInfo$annotations", "getCommunityInfo", "()Lcom/larus/platform/api/creation/CreationCommunityInfo;", "isFavorite$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCreateTime$annotations", "getCreateTime", "getClientTrackParams$annotations", "getClientTrackParams", "()Lcom/larus/platform/api/creation/UserCreationTrackParams;", "setClientTrackParams", "(Lcom/larus/platform/api/creation/UserCreationTrackParams;)V", "getRefContent$annotations", "getRefContent", "()Lcom/larus/platform/api/creation/UserCreationRefContent;", "getPublishExtra$annotations", "getPublishExtra", "()Lcom/larus/platform/api/creation/CreationPublishExtra;", "setPublishExtra", "(Lcom/larus/platform/api/creation/CreationPublishExtra;)V", "getAwemeAnchor$annotations", "getAwemeAnchor", "()Lcom/larus/platform/api/creation/AwemeAnchor;", "setAwemeAnchor", "(Lcom/larus/platform/api/creation/AwemeAnchor;)V", "isPublicReference", "isHasCaption", "checkCustomPositionValid", "hasMultiRefImage", "getRefImageUrl", "getPrompt", "getImageUrl", "getThumbImageUrl", "getThumbRawImageUrl", "getOriginImageUrl", "getOriginImage", "Lcom/larus/platform/api/Image;", "getPreviewImageUrl", "getDisplayContent", "getPreviewImageInfo", "canShowQuickMenu", "getTagType", "hasAvatar", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Lcom/larus/platform/api/creation/UserCreationContent;Ljava/lang/Long;Lcom/larus/platform/api/creation/AuthorInfo;Lcom/larus/platform/api/creation/CreationDynamicInfo;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/platform/api/creation/CreationCommunityInfo;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/larus/platform/api/creation/UserCreationTrackParams;Lcom/larus/platform/api/creation/UserCreationRefContent;Lcom/larus/platform/api/creation/CreationPublishExtra;Lcom/larus/platform/api/creation/AwemeAnchor;)Lcom/larus/platform/api/creation/UserCreation;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class UserCreation implements Parcelable {
    public static final Parcelable.Creator<UserCreation> CREATOR = null;
    public static final b Companion = null;
    public final String a;
    public final int b;
    public final Integer c;
    public Integer d;
    public final UserCreationContent e;
    public final Long f;
    public final AuthorInfo g;
    public final CreationDynamicInfo h;
    public String i;
    public final Integer j;
    public final CreationCommunityInfo k;
    public final Boolean l;
    public final Long m;
    public UserCreationTrackParams n;
    public final UserCreationRefContent o;
    public CreationPublishExtra p;
    public final AwemeAnchor q;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreation> {
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
            g2 r1 = new g2("com.larus.platform.api.creation.UserCreation", r0, 17);
            r1.j("creation_id", true);
            r1.j("creation_type", true);
            r1.j("status", true);
            r1.j("private_status", true);
            r1.j("content", true);
            r1.j("usage_count", true);
            r1.j("author_info", true);
            r1.j("dynamic_info", true);
            r1.j("creation_trace_info", true);
            r1.j("content_source", true);
            r1.j("community_info", true);
            r1.j("is_favorite", true);
            r1.j("create_time", true);
            r1.j("client_track_params", true);
            r1.j("ref_content", true);
            r1.j("publish_extra", true);
            r1.j("aweme_anchor", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            w0 r2 = w0.a;
            g1 r3 = g1.a;
            return new d[]{kuc.a.d(r1), r2, kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(UserCreationContent.a.a), kuc.a.d(r3), kuc.a.d(AuthorInfo.a.a), kuc.a.d(CreationDynamicInfo.a.a), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(CreationCommunityInfo.a.a), kuc.a.d(i.a), kuc.a.d(r3), kuc.a.d(UserCreationTrackParams.a.a), kuc.a.d(UserCreationRefContent.a.a), kuc.a.d(CreationPublishExtra.a.a), kuc.a.d(AwemeAnchor.a.a)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r36) {
            Intrinsics.checkNotNullParameter(r36, "decoder");
            g2 r1 = b;
            muc.c r0 = r36.beginStructure(r1);
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            int r4 = r0.decodeIntElement(r1, 1);
            w0 r7 = w0.a;
            Integer r15 = (Integer) r0.decodeNullableSerializableElement(r1, 2, r7, null);
            Integer r11 = (Integer) r0.decodeNullableSerializableElement(r1, 3, r7, null);
            UserCreationContent r8 = (UserCreationContent) r0.decodeNullableSerializableElement(r1, 4, UserCreationContent.a.a, null);
            g1 r10 = g1.a;
            Long r12 = (Long) r0.decodeNullableSerializableElement(r1, 5, r10, null);
            AuthorInfo r9 = (AuthorInfo) r0.decodeNullableSerializableElement(r1, 6, AuthorInfo.a.a, null);
            CreationDynamicInfo r13 = (CreationDynamicInfo) r0.decodeNullableSerializableElement(r1, 7, CreationDynamicInfo.a.a, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 8, r2, null);
            Integer r6 = (Integer) r0.decodeNullableSerializableElement(r1, 9, r7, null);
            CreationCommunityInfo r14 = (CreationCommunityInfo) r0.decodeNullableSerializableElement(r1, 10, CreationCommunityInfo.a.a, null);
            Boolean r16 = (Boolean) r0.decodeNullableSerializableElement(r1, 11, i.a, null);
            Long r17 = (Long) r0.decodeNullableSerializableElement(r1, 12, r10, null);
            Boolean r19 = r16;
            UserCreationTrackParams r18 = (UserCreationTrackParams) r0.decodeNullableSerializableElement(r1, 13, UserCreationTrackParams.a.a, null);
            UserCreationRefContent r20 = (UserCreationRefContent) r0.decodeNullableSerializableElement(r1, 14, UserCreationRefContent.a.a, null);
            CreationPublishExtra r23 = (CreationPublishExtra) r0.decodeNullableSerializableElement(r1, 15, CreationPublishExtra.a.a, null);
            AwemeAnchor r24 = (AwemeAnchor) r0.decodeNullableSerializableElement(r1, 16, AwemeAnchor.a.a, null);
            AuthorInfo r110 = r9;
            Long r21 = r17;
            Integer r111 = r15;
            UserCreationRefContent r22 = r20;
            Integer r112 = r6;
            int r25 = r4;
            CreationDynamicInfo r113 = r13;
            Long r114 = r12;
            UserCreationContent r115 = r8;
            String r26 = r5;
            String r116 = r3;
            UserCreationTrackParams r27 = r18;
            CreationCommunityInfo r117 = r14;
            int r28 = 131071;
        L43:
            r0.endStructure(r1);
            return new UserCreation(r28, r26, r25, r111, r11, r115, r114, r110, r113, r116, r112, r117, r19, r21, r27, r22, r23, r24);
        L5:
            AuthorInfo r29 = null;
            Integer r30 = null;
            Long r31 = null;
            UserCreationRefContent r32 = null;
            UserCreationContent r33 = null;
            CreationDynamicInfo r34 = null;
            Long r118 = null;
            AwemeAnchor r119 = null;
            CreationCommunityInfo r120 = null;
            Boolean r121 = null;
            CreationPublishExtra r122 = null;
            UserCreationTrackParams r123 = null;
            String r210 = null;
            Integer r211 = null;
            Integer r212 = null;
            String r35 = null;
            int r37 = 0;
            int r38 = 0;
            boolean r39 = true;
        L6:
            if (r39 == false) goto L42;
            int r40 = r0.decodeElementIndex(r1);
            switch(r40) {
                case -1: goto L40;
                case 0: goto L38;
                case 1: goto L35;
                case 2: goto L32;
                case 3: goto L31;
                case 4: goto L29;
                case 5: goto L28;
                case 6: goto L27;
                case 7: goto L25;
                case 8: goto L22;
                case 9: goto L20;
                case 10: goto L19;
                case 11: goto L18;
                case 12: goto L16;
                case 13: goto L14;
                case 14: goto L13;
                case 15: goto L12;
                case 16: goto L11;
                default: goto L10;
            };
        L11:
            int r41 = 65536 | r38;
            AwemeAnchor r310 = (AwemeAnchor) r0.decodeNullableSerializableElement(r1, 16, AwemeAnchor.a.a, r119);
        L17:
            r30 = r30;
            int r42 = r41;
            Integer r213 = r212;
            String r214 = r35;
            r119 = r310;
        L37:
            AuthorInfo r215 = r29;
            r38 = r42;
            Integer r43 = r211;
            r30 = r30;
            r37 = r37;
            String r216 = r214;
        L39:
            r211 = r43;
            r212 = r213;
            r29 = r215;
            r35 = r216;
            goto L6
        L12:
            r122 = (CreationPublishExtra) r0.decodeNullableSerializableElement(r1, 15, CreationPublishExtra.a.a, r122);
            int r44 = 32768 | r38;
        L21:
            r30 = r30;
        L23:
            r35 = r35;
        L30:
            r42 = r44;
            r213 = r212;
        L36:
            r214 = r35;
            r119 = r119;
            goto L37
        L13:
            int r45 = r38;
            r310 = r119;
            r32 = (UserCreationRefContent) r0.decodeNullableSerializableElement(r1, 14, UserCreationRefContent.a.a, r32);
            r41 = r45 | 16384;
            goto L17
        L14:
            int r46 = r38;
            r310 = r119;
            r123 = (UserCreationTrackParams) r0.decodeNullableSerializableElement(r1, 13, UserCreationTrackParams.a.a, r123);
            r41 = r46 | 8192;
            goto L17
        L16:
            r37 = r37;
            int r47 = r38;
            r310 = r119;
            r118 = (Long) r0.decodeNullableSerializableElement(r1, 12, g1.a, r118);
            r41 = r47 | 4096;
            goto L17
        L18:
            r121 = (Boolean) r0.decodeNullableSerializableElement(r1, 11, i.a, r121);
            r44 = r38 | 2048;
            goto L21
        L19:
            r120 = (CreationCommunityInfo) r0.decodeNullableSerializableElement(r1, 10, CreationCommunityInfo.a.a, r120);
            r44 = r38 | 1024;
            goto L21
        L20:
            r30 = (Integer) r0.decodeNullableSerializableElement(r1, 9, w0.a, r30);
            r44 = r38 | 512;
            goto L21
        L22:
            r37 = r37;
            int r48 = r38;
            r119 = r119;
            r30 = r30;
            r35 = (String) r0.decodeNullableSerializableElement(r1, 8, v2.a, r35);
            r44 = r48 | 256;
            goto L23
        L25:
            r34 = (CreationDynamicInfo) r0.decodeNullableSerializableElement(r1, 7, CreationDynamicInfo.a.a, r34);
            int r49 = r38 | 128;
        L26:
            r213 = r212;
        L33:
            r42 = r49;
            r29 = r29;
            goto L36
        L27:
            r30 = r30;
            r37 = r37;
            int r50 = r38;
            r119 = r119;
            r35 = r35;
            r29 = (AuthorInfo) r0.decodeNullableSerializableElement(r1, 6, AuthorInfo.a.a, r29);
            r44 = r50 | 64;
            goto L30
        L28:
            r31 = (Long) r0.decodeNullableSerializableElement(r1, 5, g1.a, r31);
            r49 = r38 | 32;
            goto L26
        L29:
            r30 = r30;
            r37 = r37;
            int r51 = r38;
            r119 = r119;
            r35 = r35;
            r33 = (UserCreationContent) r0.decodeNullableSerializableElement(r1, 4, UserCreationContent.a.a, r33);
            r44 = r51 | 16;
            goto L30
        L31:
            r212 = (Integer) r0.decodeNullableSerializableElement(r1, 3, w0.a, r212);
            r49 = r38 | 8;
            goto L26
        L32:
            r29 = r29;
            r30 = r30;
            r37 = r37;
            int r52 = r38;
            r119 = r119;
            r35 = r35;
            r213 = r212;
            r211 = (Integer) r0.decodeNullableSerializableElement(r1, 2, w0.a, r211);
            r49 = r52 | 4;
            goto L33
        L35:
            r30 = r30;
            r213 = r212;
            int r53 = r38;
            r119 = r119;
            r35 = r35;
            r42 = r53 | 2;
            r37 = r0.decodeIntElement(r1, 1);
            r29 = r29;
            goto L36
        L38:
            r215 = r29;
            Integer r217 = r30;
            int r311 = r37;
            r213 = r212;
            int r54 = r38;
            int r55 = r54 | 1;
            r37 = r311;
            r210 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r210);
            r30 = r217;
            r216 = r35;
            r119 = r119;
            r38 = r55;
            r43 = r211;
            goto L39
        L40:
            int r312 = r37;
            r29 = r29;
            r119 = r119;
            r39 = false;
            r210 = r210;
            r38 = r38;
            r37 = r312;
            goto L6
        L10:
            throw new UnknownFieldException(r40);
        L42:
            int r313 = r37;
            String r56 = r210;
            int r57 = r38;
            AwemeAnchor r314 = r119;
            r22 = r32;
            r21 = r118;
            r116 = r35;
            r117 = r120;
            r19 = r121;
            r23 = r122;
            r27 = r123;
            r111 = r211;
            r11 = r212;
            r110 = r29;
            r112 = r30;
            r24 = r314;
            r114 = r31;
            r28 = r57;
            r115 = r33;
            r113 = r34;
            r25 = r313;
            r26 = r56;
            goto L43
        }

        public final void serialize(muc.f r9, Object r10) {
            UserCreation r11 = (UserCreation) r10;
            Intrinsics.checkNotNullParameter(r9, "encoder");
            Intrinsics.checkNotNullParameter(r11, "value");
            g2 r0 = b;
            muc.d r12 = r9.beginStructure(r0);
            b r1 = UserCreation.Companion;
            boolean r2 = false;
            if (r12.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r12.encodeNullableSerializableElement(r0, 0, v2.a, r11.a);
        L12:
            if (r12.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r12.encodeIntElement(r0, 1, r11.b);
        L21:
            if (r12.shouldEncodeElementDefault(r0, 2) == true) goto L28;
            Integer r5 = r11.c;
            if (r5 == null) goto L28;
            if (r5.intValue() != 0) goto L28;
            boolean r6 = false;
        L30:
            if (r6 == false) goto L33;
            r12.encodeNullableSerializableElement(r0, 2, w0.a, r11.c);
        L33:
            if (r12.shouldEncodeElementDefault(r0, 3) == true) goto L40;
            Integer r7 = r11.d;
            if (r7 == null) goto L40;
            if (r7.intValue() != 0) goto L40;
            boolean r8 = false;
        L42:
            if (r8 == false) goto L45;
            r12.encodeNullableSerializableElement(r0, 3, w0.a, r11.d);
        L45:
            if (r12.shouldEncodeElementDefault(r0, 4) == false) goto L48;
        L49:
            boolean r13 = true;
        L51:
            if (r13 == false) goto L54;
            r12.encodeNullableSerializableElement(r0, 4, UserCreationContent.a.a, r11.e);
        L54:
            if (r12.shouldEncodeElementDefault(r0, 5) == false) goto L57;
        L58:
            boolean r14 = true;
        L60:
            if (r14 == false) goto L63;
            r12.encodeNullableSerializableElement(r0, 5, g1.a, r11.f);
        L63:
            if (r12.shouldEncodeElementDefault(r0, 6) == false) goto L66;
        L67:
            boolean r15 = true;
        L69:
            if (r15 == false) goto L72;
            r12.encodeNullableSerializableElement(r0, 6, AuthorInfo.a.a, r11.g);
        L72:
            if (r12.shouldEncodeElementDefault(r0, 7) == false) goto L75;
        L76:
            boolean r16 = true;
        L78:
            if (r16 == false) goto L81;
            r12.encodeNullableSerializableElement(r0, 7, CreationDynamicInfo.a.a, r11.h);
        L81:
            if (r12.shouldEncodeElementDefault(r0, 8) == false) goto L84;
        L85:
            boolean r17 = true;
        L87:
            if (r17 == false) goto L90;
            r12.encodeNullableSerializableElement(r0, 8, v2.a, r11.i);
        L90:
            if (r12.shouldEncodeElementDefault(r0, 9) == false) goto L93;
        L94:
            boolean r18 = true;
        L96:
            if (r18 == false) goto L99;
            r12.encodeNullableSerializableElement(r0, 9, w0.a, r11.j);
        L99:
            if (r12.shouldEncodeElementDefault(r0, 10) == false) goto L102;
        L103:
            boolean r19 = true;
        L105:
            if (r19 == false) goto L108;
            r12.encodeNullableSerializableElement(r0, 10, CreationCommunityInfo.a.a, r11.k);
        L108:
            if (r12.shouldEncodeElementDefault(r0, 11) == false) goto L111;
        L112:
            boolean r20 = true;
        L114:
            if (r20 == false) goto L117;
            r12.encodeNullableSerializableElement(r0, 11, i.a, r11.l);
        L117:
            if (r12.shouldEncodeElementDefault(r0, 12) == false) goto L120;
        L121:
            boolean r21 = true;
        L123:
            if (r21 == false) goto L126;
            r12.encodeNullableSerializableElement(r0, 12, g1.a, r11.m);
        L126:
            if (r12.shouldEncodeElementDefault(r0, 13) == false) goto L129;
        L130:
            boolean r22 = true;
        L132:
            if (r22 == false) goto L135;
            r12.encodeNullableSerializableElement(r0, 13, UserCreationTrackParams.a.a, r11.n);
        L135:
            if (r12.shouldEncodeElementDefault(r0, 14) == false) goto L138;
        L139:
            boolean r23 = true;
        L141:
            if (r23 == false) goto L144;
            r12.encodeNullableSerializableElement(r0, 14, UserCreationRefContent.a.a, r11.o);
        L144:
            if (r12.shouldEncodeElementDefault(r0, 15) == false) goto L147;
        L148:
            boolean r24 = true;
        L150:
            if (r24 == false) goto L153;
            r12.encodeNullableSerializableElement(r0, 15, CreationPublishExtra.a.a, r11.p);
        L153:
            if (r12.shouldEncodeElementDefault(r0, 16) == false) goto L156;
        L157:
            r2 = true;
        L158:
            if (r2 == false) goto L160;
            r12.encodeNullableSerializableElement(r0, 16, AwemeAnchor.a.a, r11.q);
        L160:
            r12.endStructure(r0);
            return;
        L156:
            if (r11.q == null) goto L158;
        L147:
            if (r11.p != null) goto L148;
            r24 = false;
            goto L150
        L138:
            if (r11.o != null) goto L139;
            r23 = false;
            goto L141
        L129:
            if (Intrinsics.areEqual(r11.n, new UserCreationTrackParams(null, null, 127)) == false) goto L130;
            r22 = false;
            goto L132
        L120:
            if (r11.m != null) goto L121;
            r21 = false;
            goto L123
        L111:
            if (r11.l != null) goto L112;
            r20 = false;
            goto L114
        L102:
            if (r11.k != null) goto L103;
            r19 = false;
            goto L105
        L93:
            if (r11.j != null) goto L94;
            r18 = false;
            goto L96
        L84:
            if (r11.i != null) goto L85;
            r17 = false;
            goto L87
        L75:
            if (r11.h != null) goto L76;
            r16 = false;
            goto L78
        L66:
            if (r11.g != null) goto L67;
            r15 = false;
            goto L69
        L57:
            if (r11.f != null) goto L58;
            r14 = false;
            goto L60
        L48:
            if (r11.e != null) goto L49;
            r13 = false;
        L40:
            r8 = true;
        L28:
            r6 = true;
            goto L30
        L15:
            if (r11.b != 0) goto L16;
            r4 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r11.a, "") == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreation> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreation> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreation createFromParcel(Parcel r22) {
            Intrinsics.checkNotNullParameter(r22, "parcel");
            String r3 = r22.readString();
            int r4 = r22.readInt();
            AwemeAnchor r5 = null;
            if (r22.readInt() != 0) goto L5;
            Integer r6 = null;
        L7:
            if (r22.readInt() != 0) goto L9;
            Integer r7 = null;
        L11:
            if (r22.readInt() != 0) goto L13;
            UserCreationContent r2 = null;
        L14:
            UserCreationContent r8 = r2;
            if (r22.readInt() != 0) goto L17;
            Long r9 = null;
        L19:
            if (r22.readInt() != 0) goto L21;
            AuthorInfo r10 = null;
        L22:
            AuthorInfo r11 = r10;
            if (r22.readInt() != 0) goto L25;
            CreationDynamicInfo r12 = null;
        L26:
            CreationDynamicInfo r13 = r12;
            String r14 = r22.readString();
            if (r22.readInt() != 0) goto L29;
            Integer r15 = null;
        L31:
            if (r22.readInt() != 0) goto L33;
            CreationCommunityInfo r16 = null;
        L34:
            CreationCommunityInfo r17 = r16;
            if (r22.readInt() != 0) goto L38;
            Boolean r18 = null;
        L43:
            if (r22.readInt() != 0) goto L45;
            Long r19 = null;
        L47:
            if (r22.readInt() != 0) goto L49;
            UserCreationTrackParams r20 = null;
        L50:
            UserCreationTrackParams r110 = r20;
            if (r22.readInt() != 0) goto L53;
            UserCreationRefContent r21 = null;
        L54:
            UserCreationRefContent r111 = r21;
            if (r22.readInt() != 0) goto L57;
            CreationPublishExtra r23 = null;
        L58:
            CreationPublishExtra r24 = r23;
            if (r22.readInt() == 0) goto L63;
            r5 = AwemeAnchor.CREATOR.createFromParcel(r22);
        L63:
            return new UserCreation(r3, r4, r6, r7, r8, r9, r11, r13, r14, r15, r17, r18, r19, r110, r111, r24, r5);
        L57:
            r23 = CreationPublishExtra.CREATOR.createFromParcel(r22);
            goto L58
        L53:
            r21 = UserCreationRefContent.CREATOR.createFromParcel(r22);
            goto L54
        L49:
            r20 = UserCreationTrackParams.CREATOR.createFromParcel(r22);
            goto L50
        L45:
            r19 = Long.valueOf(r22.readLong());
            goto L47
        L38:
            if (r22.readInt() == 0) goto L40;
            boolean r25 = true;
        L41:
            r18 = Boolean.valueOf(r25);
            goto L43
        L40:
            r25 = false;
            goto L41
        L33:
            r16 = CreationCommunityInfo.CREATOR.createFromParcel(r22);
            goto L34
        L29:
            r15 = Integer.valueOf(r22.readInt());
            goto L31
        L25:
            r12 = CreationDynamicInfo.CREATOR.createFromParcel(r22);
            goto L26
        L21:
            r10 = AuthorInfo.CREATOR.createFromParcel(r22);
            goto L22
        L17:
            r9 = Long.valueOf(r22.readLong());
            goto L19
        L13:
            r2 = UserCreationContent.CREATOR.createFromParcel(r22);
            goto L14
        L9:
            r7 = Integer.valueOf(r22.readInt());
            goto L11
        L5:
            r6 = Integer.valueOf(r22.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreation[] newArray(int r1) {
            return new UserCreation[r1];
        }
    }

    public UserCreation() {
        this(null, 0, null, null, 131071);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreation) == true) goto L8;
        return false;
    L8:
        UserCreation r6 = (UserCreation) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        Integer r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        UserCreationContent r10 = this.e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        AuthorInfo r16 = this.g;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        CreationDynamicInfo r19 = this.h;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.i;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.j;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        CreationCommunityInfo r28 = this.k;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Boolean r31 = this.l;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Long r34 = this.m;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        UserCreationTrackParams r37 = this.n;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        UserCreationRefContent r40 = this.o;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        CreationPublishExtra r43 = this.p;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        AwemeAnchor r46 = this.q;
        if (r46 == null) goto L67;
        r1 = r46.hashCode();
    L67:
        return r45 + r1;
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
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

    public final String toString() {
        return "UserCreation(creationId=" + this.a + ", userCreationType=" + this.b + ", status=" + this.c + ", privateStatus=" + this.d + ", content=" + this.e + ", usageCount=" + this.f + ", authorInfo=" + this.g + ", dynamicInfo=" + this.h + ", creationTraceInfo=" + this.i + ", contentSource=" + this.j + ", communityInfo=" + this.k + ", isFavorite=" + this.l + ", createTime=" + this.m + ", clientTrackParams=" + this.n + ", refContent=" + this.o + ", publishExtra=" + this.p + ", awemeAnchor=" + this.q + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        r6.writeString(this.a);
        r6.writeInt(this.b);
        Integer r0 = this.c;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L6:
        Integer r1 = this.d;
        if (r1 != null) goto L9;
        r6.writeInt(0);
    L10:
        UserCreationContent r2 = this.e;
        if (r2 != null) goto L13;
        r6.writeInt(0);
    L14:
        Long r3 = this.f;
        if (r3 != null) goto L17;
        r6.writeInt(0);
    L18:
        AuthorInfo r4 = this.g;
        if (r4 != null) goto L21;
        r6.writeInt(0);
    L22:
        CreationDynamicInfo r5 = this.h;
        if (r5 != null) goto L25;
        r6.writeInt(0);
    L26:
        r6.writeString(this.i);
        Integer r8 = this.j;
        if (r8 != null) goto L29;
        r6.writeInt(0);
    L30:
        CreationCommunityInfo r9 = this.k;
        if (r9 != null) goto L33;
        r6.writeInt(0);
    L34:
        Boolean r10 = this.l;
        if (r10 != null) goto L37;
        r6.writeInt(0);
    L38:
        Long r11 = this.m;
        if (r11 != null) goto L41;
        r6.writeInt(0);
    L42:
        UserCreationTrackParams r12 = this.n;
        if (r12 != null) goto L45;
        r6.writeInt(0);
    L46:
        UserCreationRefContent r13 = this.o;
        if (r13 != null) goto L49;
        r6.writeInt(0);
    L50:
        CreationPublishExtra r14 = this.p;
        if (r14 != null) goto L53;
        r6.writeInt(0);
    L54:
        AwemeAnchor r15 = this.q;
        if (r15 != null) goto L57;
        r6.writeInt(0);
        return;
    L57:
        r6.writeInt(1);
        r15.writeToParcel(r6, r7);
        return;
    L53:
        r6.writeInt(1);
        r14.writeToParcel(r6, r7);
        goto L54
    L49:
        r6.writeInt(1);
        r13.writeToParcel(r6, r7);
        goto L50
    L45:
        r6.writeInt(1);
        r12.writeToParcel(r6, r7);
        goto L46
    L41:
        r6.writeInt(1);
        r6.writeLong(r11.longValue());
        goto L42
    L37:
        r6.writeInt(1);
        r6.writeInt(r10.booleanValue() ? 1 : 0);
        goto L38
    L33:
        r6.writeInt(1);
        r9.writeToParcel(r6, r7);
        goto L34
    L29:
        r6.writeInt(1);
        r6.writeInt(r8.intValue());
        goto L30
    L25:
        r6.writeInt(1);
        r5.writeToParcel(r6, r7);
        goto L26
    L21:
        r6.writeInt(1);
        r4.writeToParcel(r6, r7);
        goto L22
    L17:
        r6.writeInt(1);
        r6.writeLong(r3.longValue());
        goto L18
    L13:
        r6.writeInt(1);
        r2.writeToParcel(r6, r7);
        goto L14
    L9:
        r6.writeInt(1);
        r6.writeInt(r1.intValue());
        goto L10
    L5:
        r6.writeInt(1);
        r6.writeInt(r0.intValue());
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public final boolean D() {
        CreationPublishExtra r0 = this.p;
        if (r0 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r0.b, Boolean.TRUE);
    }

    public final boolean a() {
        CreationDynamicInfo r0 = this.h;
        if (r0 == null) goto L7;
        TplInfo r1 = r0.e;
        if (r1 == null) goto L7;
        String r2 = r1.a;
    L9:
        return Intrinsics.areEqual(r2, TplType.MENU);
    L7:
        r2 = null;
        goto L9
    }

    public final boolean b() {
        CreationDynamicInfo r0 = this.h;
        if (r0 == null) goto L28;
        Integer r2 = r0.b;
        if (r2 == null) goto L28;
        if (r0.a == null) goto L28;
        if (r2 == null) goto L10;
        int r3 = r2.intValue();
    L11:
        if (r3 < 0) goto L28;
        Integer r4 = r0.a;
        if (r4 == null) goto L15;
        int r5 = r4.intValue();
    L16:
        if (r5 < 0) goto L28;
        Integer r6 = r0.b;
        if (r6 == null) goto L20;
        int r7 = r6.intValue();
    L21:
        Integer r1 = r0.a;
        if (r1 == null) goto L24;
        int r8 = r1.intValue();
    L25:
        if (r7 < r8) goto L28;
        return true;
    L24:
        r8 = 0;
        goto L25
    L20:
        r7 = 0;
        goto L21
    L15:
        r5 = 0;
        goto L16
    L10:
        r3 = 0;
    L28:
        return false;
    }

    public final String d() {
        String r1 = null;
        switch(this.b) {
            case 1: goto L29;
            case 2: goto L22;
            case 3: goto L4;
            case 4: goto L14;
            case 5: goto L22;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            default: goto L4;
        };
    L4:
        UserCreationContent r0 = this.e;
        if (r0 != null) goto L37;
        return "";
    L37:
        UserCreationUserAvatar r2 = r0.c;
        if (r2 == null) goto L48;
        String r3 = r2.b;
        if (r3 != null) goto L47;
        return "";
    L47:
        return r3;
    L48:
        return "";
    L7:
        UserCreationContent r4 = this.e;
        if (r4 == null) goto L12;
        VideoUserContent r5 = r4.e;
        if (r5 == null) goto L12;
        r1 = r5.c;
    L12:
        if (r1 != null) goto L42;
        return "";
    L42:
        return r1;
    L14:
        UserCreationContent r6 = this.e;
        if (r6 == null) goto L19;
        AiBeautifyUserContent r7 = r6.d;
        if (r7 == null) goto L19;
        r1 = r7.c;
    L19:
        if (r1 != null) goto L42;
        return "";
    L22:
        UserCreationContent r8 = this.e;
        if (r8 == null) goto L43;
        UserCreationImage r9 = r8.a;
        if (r9 == null) goto L44;
        r3 = r9.b;
        if (r3 != null) goto L47;
        return "";
    L44:
        return "";
    L43:
        return "";
    L29:
        UserCreationContent r10 = this.e;
        if (r10 == null) goto L45;
        UserCreationMusic r11 = r10.b;
        if (r11 == null) goto L46;
        r3 = r11.c;
        if (r3 != null) goto L47;
        return "";
    L46:
        return "";
    L45:
        return "";
    }

    public final String e() {
        switch(this.b) {
            case 1: goto L51;
            case 2: goto L38;
            case 3: goto L27;
            case 4: goto L16;
            case 5: goto L38;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L5;
            default: goto L51;
        };
    L5:
        UserCreationContent r0 = this.e;
        if (r0 == null) goto L52;
        VideoUserContent r1 = r0.e;
        if (r1 == null) goto L53;
        ImageInfo r2 = r1.b;
        if (r2 == null) goto L54;
        Image r3 = r2.c;
        if (r3 == null) goto L55;
        String r4 = r3.a;
        if (r4 != null) goto L50;
        return "";
    L50:
        return r4;
    L55:
        return "";
    L54:
        return "";
    L53:
        return "";
    L52:
        return "";
    L16:
        UserCreationContent r5 = this.e;
        if (r5 == null) goto L56;
        AiBeautifyUserContent r6 = r5.d;
        if (r6 == null) goto L57;
        ImageInfo r7 = r6.a;
        if (r7 == null) goto L58;
        Image r8 = r7.c;
        if (r8 == null) goto L59;
        r4 = r8.a;
        if (r4 != null) goto L50;
        return "";
    L59:
        return "";
    L58:
        return "";
    L57:
        return "";
    L56:
        return "";
    L27:
        UserCreationContent r9 = this.e;
        if (r9 == null) goto L60;
        UserCreationUserAvatar r10 = r9.c;
        if (r10 == null) goto L61;
        ImageInfo r11 = r10.a;
        if (r11 == null) goto L62;
        Image r12 = r11.c;
        if (r12 == null) goto L63;
        r4 = r12.a;
        if (r4 != null) goto L50;
        return "";
    L63:
        return "";
    L62:
        return "";
    L61:
        return "";
    L60:
        return "";
    L38:
        UserCreationContent r13 = this.e;
        if (r13 == null) goto L64;
        UserCreationImage r14 = r13.a;
        if (r14 == null) goto L65;
        ImageInfo r15 = r14.a;
        if (r15 == null) goto L66;
        Image r16 = r15.c;
        if (r16 == null) goto L67;
        r4 = r16.a;
        if (r4 != null) goto L50;
        return "";
    L67:
        return "";
    L66:
        return "";
    L65:
        return "";
    L64:
        return "";
    L51:
        return "";
    }

    public final Image g() {
        int r0 = this.b;
        if (r0 != 2) goto L5;
    L25:
        UserCreationContent r1 = this.e;
        if (r1 == null) goto L41;
        UserCreationImage r2 = r1.a;
        if (r2 == null) goto L42;
        ImageInfo r3 = r2.a;
        if (r3 != null) goto L32;
        return null;
    L32:
        return r3.a;
    L42:
        return null;
    L41:
        return null;
    L5:
        if (r0 != 3) goto L7;
        UserCreationContent r4 = this.e;
        if (r4 == null) goto L37;
        UserCreationUserAvatar r5 = r4.c;
        if (r5 == null) goto L38;
        ImageInfo r6 = r5.a;
        if (r6 != null) goto L40;
        return null;
    L40:
        return r6.a;
    L38:
        return null;
    L37:
        return null;
    L7:
        if (r0 != 4) goto L9;
        UserCreationContent r7 = this.e;
        if (r7 == null) goto L33;
        AiBeautifyUserContent r8 = r7.d;
        if (r8 == null) goto L34;
        ImageInfo r9 = r8.a;
        if (r9 != null) goto L36;
        return null;
    L36:
        return r9.a;
    L34:
        return null;
    L33:
        return null;
    L9:
        if (r0 == 5) goto L25;
        return null;
    }

    public final String h() {
        int r0 = this.b;
        if (r0 != 2) goto L5;
    L33:
        UserCreationContent r1 = this.e;
        if (r1 == null) goto L54;
        UserCreationImage r2 = r1.a;
        if (r2 == null) goto L55;
        ImageInfo r3 = r2.a;
        if (r3 == null) goto L56;
        Image r4 = r3.a;
        if (r4 == null) goto L57;
        String r5 = r4.a;
        if (r5 != null) goto L45;
        return "";
    L45:
        return r5;
    L57:
        return "";
    L56:
        return "";
    L55:
        return "";
    L54:
        return "";
    L5:
        if (r0 != 3) goto L7;
        UserCreationContent r6 = this.e;
        if (r6 == null) goto L50;
        UserCreationUserAvatar r7 = r6.c;
        if (r7 == null) goto L51;
        ImageInfo r8 = r7.a;
        if (r8 == null) goto L52;
        Image r9 = r8.a;
        if (r9 == null) goto L53;
        r5 = r9.a;
        if (r5 != null) goto L45;
        return "";
    L53:
        return "";
    L52:
        return "";
    L51:
        return "";
    L50:
        return "";
    L7:
        if (r0 != 4) goto L9;
        UserCreationContent r10 = this.e;
        if (r10 == null) goto L46;
        AiBeautifyUserContent r11 = r10.d;
        if (r11 == null) goto L47;
        ImageInfo r12 = r11.a;
        if (r12 == null) goto L48;
        Image r13 = r12.a;
        if (r13 == null) goto L49;
        r5 = r13.a;
        if (r5 != null) goto L45;
        return "";
    L49:
        return "";
    L48:
        return "";
    L47:
        return "";
    L46:
        return "";
    L9:
        if (r0 == 5) goto L33;
        return "";
    }

    public final Image i() {
        int r0 = this.b;
        if (r0 != 2) goto L5;
    L22:
        UserCreationContent r1 = this.e;
        if (r1 == null) goto L38;
        UserCreationImage r2 = r1.a;
        if (r2 == null) goto L39;
        ImageInfo r3 = r2.a;
        if (r3 != null) goto L29;
        return null;
    L29:
        return r3.c;
    L39:
        return null;
    L38:
        return null;
    L5:
        if (r0 != 4) goto L7;
        UserCreationContent r4 = this.e;
        if (r4 == null) goto L34;
        AiBeautifyUserContent r5 = r4.d;
        if (r5 == null) goto L35;
        ImageInfo r6 = r5.a;
        if (r6 != null) goto L37;
        return null;
    L37:
        return r6.c;
    L35:
        return null;
    L34:
        return null;
    L7:
        if (r0 == 5) goto L22;
        UserCreationContent r7 = this.e;
        if (r7 == null) goto L30;
        UserCreationUserAvatar r8 = r7.c;
        if (r8 == null) goto L31;
        ImageInfo r9 = r8.a;
        if (r9 != null) goto L33;
        return null;
    L33:
        return r9.c;
    L31:
        return null;
    L30:
        return null;
    }

    public final String j() {
        int r0 = this.b;
        boolean r2 = false;
        String r4 = null;
        if (r0 != 2) goto L5;
    L83:
        UserCreationContent r1 = this.e;
        if (r1 == null) goto L92;
        UserCreationImage r3 = r1.a;
        if (r3 == null) goto L92;
        ImageInfo r5 = r3.a;
        if (r5 == null) goto L92;
        Image r6 = r5.c;
        if (r6 == null) goto L92;
        r4 = r6.a;
    L92:
        if (r4 != null) goto L94;
    L95:
        r2 = true;
    L96:
        if (r2 == true) goto L108;
        UserCreationContent r7 = this.e;
        if (r7 == null) goto L137;
        UserCreationImage r8 = r7.a;
        if (r8 == null) goto L138;
        ImageInfo r9 = r8.a;
        if (r9 == null) goto L139;
        Image r10 = r9.c;
        if (r10 == null) goto L140;
        String r11 = r10.a;
        if (r11 != null) goto L120;
        return "";
    L120:
        return r11;
    L140:
        return "";
    L139:
        return "";
    L138:
        return "";
    L137:
        return "";
    L108:
        UserCreationContent r12 = this.e;
        if (r12 == null) goto L141;
        UserCreationImage r13 = r12.a;
        if (r13 == null) goto L142;
        ImageInfo r14 = r13.a;
        if (r14 == null) goto L143;
        Image r15 = r14.a;
        if (r15 == null) goto L144;
        r11 = r15.a;
        if (r11 != null) goto L120;
        return "";
    L144:
        return "";
    L143:
        return "";
    L142:
        return "";
    L141:
        return "";
    L94:
        if (r4.length() != 0) goto L96;
    L5:
        if (r0 != 3) goto L7;
        UserCreationContent r16 = this.e;
        if (r16 == null) goto L56;
        UserCreationUserAvatar r17 = r16.c;
        if (r17 == null) goto L56;
        ImageInfo r18 = r17.a;
        if (r18 == null) goto L56;
        Image r19 = r18.c;
        if (r19 == null) goto L56;
        r4 = r19.a;
    L56:
        if (r4 != null) goto L58;
    L59:
        r2 = true;
    L60:
        if (r2 == true) goto L72;
        UserCreationContent r20 = this.e;
        if (r20 == null) goto L129;
        UserCreationUserAvatar r21 = r20.c;
        if (r21 == null) goto L130;
        ImageInfo r22 = r21.a;
        if (r22 == null) goto L131;
        Image r23 = r22.c;
        if (r23 == null) goto L132;
        r11 = r23.a;
        if (r11 != null) goto L120;
        return "";
    L132:
        return "";
    L131:
        return "";
    L130:
        return "";
    L129:
        return "";
    L72:
        UserCreationContent r24 = this.e;
        if (r24 == null) goto L133;
        UserCreationUserAvatar r25 = r24.c;
        if (r25 == null) goto L134;
        ImageInfo r26 = r25.a;
        if (r26 == null) goto L135;
        Image r27 = r26.a;
        if (r27 == null) goto L136;
        r11 = r27.a;
        if (r11 != null) goto L120;
        return "";
    L136:
        return "";
    L135:
        return "";
    L134:
        return "";
    L133:
        return "";
    L58:
        if (r4.length() != 0) goto L60;
    L7:
        if (r0 != 4) goto L9;
        UserCreationContent r28 = this.e;
        if (r28 == null) goto L20;
        AiBeautifyUserContent r29 = r28.d;
        if (r29 == null) goto L20;
        ImageInfo r30 = r29.a;
        if (r30 == null) goto L20;
        Image r31 = r30.c;
        if (r31 == null) goto L20;
        r4 = r31.a;
    L20:
        if (r4 != null) goto L22;
    L23:
        r2 = true;
    L24:
        if (r2 == true) goto L36;
        UserCreationContent r32 = this.e;
        if (r32 == null) goto L121;
        AiBeautifyUserContent r33 = r32.d;
        if (r33 == null) goto L122;
        ImageInfo r34 = r33.a;
        if (r34 == null) goto L123;
        Image r35 = r34.c;
        if (r35 == null) goto L124;
        r11 = r35.a;
        if (r11 != null) goto L120;
        return "";
    L124:
        return "";
    L123:
        return "";
    L122:
        return "";
    L121:
        return "";
    L36:
        UserCreationContent r36 = this.e;
        if (r36 == null) goto L125;
        AiBeautifyUserContent r37 = r36.d;
        if (r37 == null) goto L126;
        ImageInfo r38 = r37.a;
        if (r38 == null) goto L127;
        Image r39 = r38.a;
        if (r39 == null) goto L128;
        r11 = r39.a;
        if (r11 != null) goto L120;
        return "";
    L128:
        return "";
    L127:
        return "";
    L126:
        return "";
    L125:
        return "";
    L22:
        if (r4.length() != 0) goto L24;
    L9:
        if (r0 == 5) goto L83;
        return "";
    }

    public final String k() {
        switch(this.b) {
            case 1: goto L35;
            case 2: goto L26;
            case 3: goto L19;
            case 4: goto L12;
            case 5: goto L26;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L5;
            default: goto L35;
        };
    L5:
        UserCreationContent r0 = this.e;
        if (r0 == null) goto L36;
        VideoUserContent r1 = r0.e;
        if (r1 == null) goto L37;
        String r2 = r1.d;
        if (r2 != null) goto L34;
        return "";
    L34:
        return r2;
    L37:
        return "";
    L36:
        return "";
    L12:
        UserCreationContent r3 = this.e;
        if (r3 == null) goto L38;
        AiBeautifyUserContent r4 = r3.d;
        if (r4 == null) goto L39;
        r2 = r4.d;
        if (r2 != null) goto L34;
        return "";
    L39:
        return "";
    L38:
        return "";
    L19:
        UserCreationContent r5 = this.e;
        if (r5 == null) goto L40;
        UserCreationUserAvatar r6 = r5.c;
        if (r6 == null) goto L41;
        r2 = r6.c;
        if (r2 != null) goto L34;
        return "";
    L41:
        return "";
    L40:
        return "";
    L26:
        UserCreationContent r7 = this.e;
        if (r7 == null) goto L42;
        UserCreationImage r8 = r7.a;
        if (r8 == null) goto L43;
        r2 = r8.c;
        if (r2 != null) goto L34;
        return "";
    L43:
        return "";
    L42:
        return "";
    L35:
        return "";
    }

    public final String o() {
        UserCreationRefContent r0 = this.o;
        if (r0 == null) goto L10;
        List<ImageInfo> r1 = r0.a();
        if (r1 == null) goto L10;
        ImageInfo r2 = (ImageInfo) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L10;
        Image r3 = r2.c;
        if (r3 == null) goto L10;
    L18:
        if (r3 != null) goto L20;
        return null;
    L20:
        return r3.a;
    L10:
        UserCreationRefContent r4 = this.o;
        if (r4 == null) goto L17;
        List<ImageInfo> r5 = r4.a();
        if (r5 == null) goto L17;
        ImageInfo r6 = (ImageInfo) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L17;
        r3 = r6.a;
    L17:
        r3 = null;
        goto L18
    }

    public final String r() {
        int r0 = this.b;
        if (r0 != 2) goto L5;
    L30:
        UserCreationContent r1 = this.e;
        if (r1 == null) goto L51;
        UserCreationImage r2 = r1.a;
        if (r2 == null) goto L52;
        ImageInfo r3 = r2.a;
        if (r3 == null) goto L53;
        Image r4 = r3.b;
        if (r4 == null) goto L54;
        String r5 = r4.a;
        if (r5 != null) goto L42;
        return "";
    L42:
        return r5;
    L54:
        return "";
    L53:
        return "";
    L52:
        return "";
    L51:
        return "";
    L5:
        if (r0 != 4) goto L7;
        UserCreationContent r6 = this.e;
        if (r6 == null) goto L47;
        AiBeautifyUserContent r7 = r6.d;
        if (r7 == null) goto L48;
        ImageInfo r8 = r7.a;
        if (r8 == null) goto L49;
        Image r9 = r8.b;
        if (r9 == null) goto L50;
        r5 = r9.a;
        if (r5 != null) goto L42;
        return "";
    L50:
        return "";
    L49:
        return "";
    L48:
        return "";
    L47:
        return "";
    L7:
        if (r0 == 5) goto L30;
        UserCreationContent r10 = this.e;
        if (r10 == null) goto L43;
        UserCreationUserAvatar r11 = r10.c;
        if (r11 == null) goto L44;
        ImageInfo r12 = r11.a;
        if (r12 == null) goto L45;
        Image r13 = r12.b;
        if (r13 == null) goto L46;
        r5 = r13.a;
        if (r5 != null) goto L42;
        return "";
    L46:
        return "";
    L45:
        return "";
    L44:
        return "";
    L43:
        return "";
    }

    public final String s() {
        int r0 = this.b;
        if (r0 != 2) goto L5;
    L30:
        UserCreationContent r1 = this.e;
        if (r1 == null) goto L51;
        UserCreationImage r2 = r1.a;
        if (r2 == null) goto L52;
        ImageInfo r3 = r2.a;
        if (r3 == null) goto L53;
        Image r4 = r3.j;
        if (r4 == null) goto L54;
        String r5 = r4.a;
        if (r5 != null) goto L42;
        return "";
    L42:
        return r5;
    L54:
        return "";
    L53:
        return "";
    L52:
        return "";
    L51:
        return "";
    L5:
        if (r0 != 4) goto L7;
        UserCreationContent r6 = this.e;
        if (r6 == null) goto L47;
        AiBeautifyUserContent r7 = r6.d;
        if (r7 == null) goto L48;
        ImageInfo r8 = r7.a;
        if (r8 == null) goto L49;
        Image r9 = r8.j;
        if (r9 == null) goto L50;
        r5 = r9.a;
        if (r5 != null) goto L42;
        return "";
    L50:
        return "";
    L49:
        return "";
    L48:
        return "";
    L47:
        return "";
    L7:
        if (r0 == 5) goto L30;
        UserCreationContent r10 = this.e;
        if (r10 == null) goto L43;
        UserCreationUserAvatar r11 = r10.c;
        if (r11 == null) goto L44;
        ImageInfo r12 = r11.a;
        if (r12 == null) goto L45;
        Image r13 = r12.j;
        if (r13 == null) goto L46;
        r5 = r13.a;
        if (r5 != null) goto L42;
        return "";
    L46:
        return "";
    L45:
        return "";
    L44:
        return "";
    L43:
        return "";
    }

    public final boolean t() {
        UserCreationRefContent r0 = this.o;
        if (r0 == null) goto L10;
        List<ImageInfo> r1 = r0.a();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.size() <= 1) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final boolean z() {
        CreationPublishExtra r0 = this.p;
        if (r0 == null) goto L13;
        String r1 = r0.c;
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 != true) goto L15;
        return true;
    L15:
        return false;
    L9:
        r2 = false;
        goto L10
    L13:
        return false;
    }

    public final String q(boolean r2) {
        if (r2 == false) goto L11;
        CreationDynamicInfo r3 = this.h;
        if (r3 == null) goto L19;
        TplInfo r4 = r3.e;
        if (r4 == null) goto L20;
        TplDetail r5 = r4.c;
        if (r5 != null) goto L22;
        return null;
    L22:
        return r5.b;
    L20:
        return null;
    L19:
        return null;
    L11:
        CreationDynamicInfo r6 = this.h;
        if (r6 == null) goto L23;
        TplInfo r7 = r6.e;
        if (r7 == null) goto L24;
        TplDetail r8 = r7.b;
        if (r8 != null) goto L18;
        return null;
    L18:
        return r8.b;
    L24:
        return null;
    L23:
        return null;
    }

    public /* synthetic */ UserCreation(String r21, int r22, Integer r23, UserCreationContent r24, int r25) {
        if ((r25 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r25 & 2) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r25 & 4) == 0) goto L13;
        Integer r5 = 0;
    L15:
        if ((r25 & 8) == 0) goto L17;
        Integer r1 = 0;
    L19:
        if ((r25 & 16) == 0) goto L21;
        UserCreationContent r7 = null;
    L23:
        if ((r25 & 8192) == 0) goto L25;
        UserCreationTrackParams r16 = new UserCreationTrackParams(null, null, 127);
    L26:
        this(r3, r4, r5, r1, r7, null, null, null, null, null, null, null, null, r16, null, null, null);
        return;
    L25:
        r16 = null;
        goto L26
    L21:
        r7 = r24;
        goto L23
    L17:
        r1 = null;
        goto L19
    L13:
        r5 = r23;
        goto L15
    L9:
        r4 = r22;
        goto L11
    L5:
        r3 = r21;
        goto L7
    }

    public static UserCreation c(UserCreation r22, Integer r23, UserCreationContent r24, Long r25, String r26, CreationCommunityInfo r27, UserCreationTrackParams r28, int r29) {
        AwemeAnchor r3 = null;
        if ((r29 & 1) == 0) goto L5;
        String r5 = r22.a;
    L7:
        if ((r29 & 2) == 0) goto L9;
        int r6 = r22.b;
    L11:
        if ((r29 & 4) == 0) goto L13;
        Integer r7 = r22.c;
    L15:
        if ((r29 & 8) == 0) goto L17;
        Integer r8 = r22.d;
    L19:
        if ((r29 & 16) == 0) goto L21;
        UserCreationContent r9 = r22.e;
    L23:
        if ((r29 & 32) == 0) goto L25;
        Long r10 = r22.f;
    L27:
        if ((r29 & 64) == 0) goto L29;
        AuthorInfo r11 = r22.g;
    L31:
        if ((r29 & 128) == 0) goto L33;
        CreationDynamicInfo r12 = r22.h;
    L35:
        if ((r29 & 256) == 0) goto L37;
        String r13 = r22.i;
    L39:
        if ((r29 & 512) == 0) goto L41;
        Integer r14 = r22.j;
    L43:
        if ((r29 & 1024) == 0) goto L45;
        CreationCommunityInfo r15 = r22.k;
    L47:
        if ((r29 & 2048) == 0) goto L49;
        Boolean r16 = r22.l;
    L51:
        if ((r29 & 4096) == 0) goto L53;
        Long r17 = r22.m;
    L55:
        if ((r29 & 8192) == 0) goto L57;
        UserCreationTrackParams r18 = r22.n;
    L59:
        if ((r29 & 16384) == 0) goto L61;
        UserCreationRefContent r19 = r22.o;
    L63:
        if ((32768 & r29) == 0) goto L65;
        CreationPublishExtra r20 = r22.p;
    L67:
        if ((r29 & 65536) == 0) goto L69;
        r3 = r22.q;
    L69:
        r22.getClass();
        return new UserCreation(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r3);
    L65:
        r20 = null;
        goto L67
    L61:
        r19 = null;
        goto L63
    L57:
        r18 = r28;
        goto L59
    L53:
        r17 = null;
        goto L55
    L49:
        r16 = null;
        goto L51
    L45:
        r15 = r27;
        goto L47
    L41:
        r14 = null;
        goto L43
    L37:
        r13 = r26;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = r25;
        goto L27
    L21:
        r9 = r24;
        goto L23
    L17:
        r8 = r23;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = 0;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public UserCreation(String r3, @UserCreationType int r4, @UserCreationStatus Integer r5, @UserCreationPrivateStatus Integer r6, UserCreationContent r7, Long r8, AuthorInfo r9, CreationDynamicInfo r10, String r11, @CreateCreationSource Integer r12, CreationCommunityInfo r13, Boolean r14, Long r15, UserCreationTrackParams r16, UserCreationRefContent r17, CreationPublishExtra r18, AwemeAnchor r19) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
    }

    public UserCreation(int r7, String r8, int r9, Integer r10, Integer r11, UserCreationContent r12, Long r13, AuthorInfo r14, CreationDynamicInfo r15, String r16, Integer r17, CreationCommunityInfo r18, Boolean r19, Long r20, UserCreationTrackParams r21, UserCreationRefContent r22, CreationPublishExtra r23, AwemeAnchor r24) {
        if ((r7 & 0) == 0) goto L5;
        b2.b(r7, 0, a.b);
        throw null;
    L5:
        if ((r7 & 1) != 0) goto L7;
        String r2 = "";
    L8:
        this.a = r2;
        if ((r7 & 2) != 0) goto L11;
        this.b = 0;
    L13:
        if ((r7 & 4) != 0) goto L15;
        this.c = 0;
    L17:
        if ((r7 & 8) != 0) goto L19;
        this.d = 0;
    L21:
        if ((r7 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r7 & 32) != 0) goto L27;
        this.f = null;
    L29:
        if ((r7 & 64) != 0) goto L31;
        this.g = null;
    L33:
        if ((r7 & 128) != 0) goto L35;
        this.h = null;
    L37:
        if ((r7 & 256) != 0) goto L39;
        this.i = null;
    L41:
        if ((r7 & 512) != 0) goto L43;
        this.j = null;
    L45:
        if ((r7 & 1024) != 0) goto L47;
        this.k = null;
    L49:
        if ((r7 & 2048) != 0) goto L51;
        this.l = null;
    L53:
        if ((r7 & 4096) != 0) goto L55;
        this.m = null;
    L57:
        if ((r7 & 8192) != 0) goto L59;
        UserCreationTrackParams r3 = new UserCreationTrackParams(null, null, 127);
    L60:
        this.n = r3;
        if ((r7 & 16384) != 0) goto L63;
        this.o = null;
    L65:
        if ((32768 & r7) != 0) goto L67;
        this.p = null;
    L69:
        if ((r7 & 65536) != 0) goto L71;
        this.q = null;
        return;
    L71:
        this.q = r24;
        return;
    L67:
        this.p = r23;
        goto L69
    L63:
        this.o = r22;
        goto L65
    L59:
        r3 = r21;
        goto L60
    L55:
        this.m = r20;
        goto L57
    L51:
        this.l = r19;
        goto L53
    L47:
        this.k = r18;
        goto L49
    L43:
        this.j = r17;
        goto L45
    L39:
        this.i = r16;
        goto L41
    L35:
        this.h = r15;
        goto L37
    L31:
        this.g = r14;
        goto L33
    L27:
        this.f = r13;
        goto L29
    L23:
        this.e = r12;
        goto L25
    L19:
        this.d = r11;
        goto L21
    L15:
        this.c = r10;
        goto L17
    L11:
        this.b = r9;
        goto L13
    L7:
        r2 = r8;
        goto L8
    }
}
