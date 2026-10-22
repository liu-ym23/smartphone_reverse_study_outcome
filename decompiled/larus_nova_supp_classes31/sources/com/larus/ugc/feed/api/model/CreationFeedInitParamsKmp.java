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
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\bV\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u008b\u00012\u00060\u0001j\u0002`\u0002:\u0004\u008a\u0001\u008b\u0001B\u0091\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b \u0010!Bù\u0001\b\u0010\u0012\u0006\u0010\"\u001a\u00020\f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b \u0010%J\t\u0010^\u001a\u00020\u0004HÆ\u0003J\t\u0010_\u001a\u00020\u0004HÆ\u0003J\t\u0010`\u001a\u00020\u0007HÆ\u0003J\t\u0010a\u001a\u00020\u0004HÆ\u0003J\t\u0010b\u001a\u00020\nHÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010d\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010e\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\t\u0010f\u001a\u00020\u0004HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\t\u0010i\u001a\u00020\u0004HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010k\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010l\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\t\u0010m\u001a\u00020\u0004HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010o\u001a\u00020\u0004HÆ\u0003J\t\u0010p\u001a\u00020\u0004HÆ\u0003J\t\u0010q\u001a\u00020\u0004HÆ\u0003J\u0010\u0010r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010s\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010XJ\u0010\u0010t\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010u\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010XJ\u0098\u0002\u0010v\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010wJ\u0006\u0010x\u001a\u00020\fJ\u0013\u0010y\u001a\u00020\u00042\b\u0010z\u001a\u0004\u0018\u00010{HÖ\u0003J\t\u0010|\u001a\u00020\fHÖ\u0001J\t\u0010}\u001a\u00020\u0007HÖ\u0001J\u0019\u0010~\u001a\u00020\u007f2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020\fJ,\u0010\u0083\u0001\u001a\u00020\u007f2\u0007\u0010\u0084\u0001\u001a\u00020\u00002\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0001¢\u0006\u0003\b\u0089\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010'\u001a\u0004\b+\u0010)R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010'\u001a\u0004\b-\u0010.R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010'\u001a\u0004\b0\u0010)R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010'\u001a\u0004\b2\u00103R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\b4\u0010'\u001a\u0004\b5\u00106R \u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\b8\u0010'\u001a\u0004\b9\u00106R \u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\b:\u0010'\u001a\u0004\b;\u00106R\u001c\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010'\u001a\u0004\b=\u0010)R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010'\u001a\u0004\b?\u0010@R \u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bA\u0010'\u001a\u0004\bB\u00106R\u001c\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010'\u001a\u0004\b\u0013\u0010)R \u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bD\u0010'\u001a\u0004\bE\u00106R \u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bF\u0010'\u001a\u0004\bG\u00106R \u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bH\u0010'\u001a\u0004\bI\u00106R\u001c\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u0010'\u001a\u0004\bK\u0010)R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010'\u001a\u0004\bM\u0010.R\u001c\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bN\u0010'\u001a\u0004\bO\u0010)R\u001c\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bP\u0010'\u001a\u0004\bQ\u0010)R\u001c\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010'\u001a\u0004\bS\u0010)R \u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bT\u0010'\u001a\u0004\bU\u00106R \u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010Y\u0012\u0004\bV\u0010'\u001a\u0004\bW\u0010XR \u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bZ\u0010'\u001a\u0004\b[\u00106R \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010Y\u0012\u0004\b\\\u0010'\u001a\u0004\b]\u0010X¨\u0006\u008c\u0001"}, d2 = {"Lcom/larus/ugc/feed/api/model/CreationFeedInitParamsKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "forceRefreshIgnoreCache", "", "disableInitialAutoRefreshOnce", "fpsTrackerTag", "", "disablePullRefresh", "trackParams", "Lcom/larus/ugc/feed/api/model/CreationFeedTrackParamsKmp;", "creationFeedType", "", "bottomPadding", "topPadding", "disableEndView", "currentTabItemInfo", "Lcom/larus/ugc/feed/api/model/TabItemInfoKmp;", "forceSpanCount", "isGridLayoutManager", "itemGapSpacing", "marginLeft", "marginRight", "showUserInfo", "creationRecommendType", "openNewChatPageOnSend", "needFocusHelper", "enableGapHandling", "loadMoreDistance", "needAddReplicaEntrance", "creationDoSameLandingType", "creationSendMessageFromDetail", "<init>", "(ZZLjava/lang/String;ZLcom/larus/ugc/feed/api/model/CreationFeedTrackParamsKmp;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/larus/ugc/feed/api/model/TabItemInfoKmp;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;ZZZLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZZLjava/lang/String;ZLcom/larus/ugc/feed/api/model/CreationFeedTrackParamsKmp;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/larus/ugc/feed/api/model/TabItemInfoKmp;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;ZZZLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getForceRefreshIgnoreCache$annotations", "()V", "getForceRefreshIgnoreCache", "()Z", "getDisableInitialAutoRefreshOnce$annotations", "getDisableInitialAutoRefreshOnce", "getFpsTrackerTag$annotations", "getFpsTrackerTag", "()Ljava/lang/String;", "getDisablePullRefresh$annotations", "getDisablePullRefresh", "getTrackParams$annotations", "getTrackParams", "()Lcom/larus/ugc/feed/api/model/CreationFeedTrackParamsKmp;", "getCreationFeedType$annotations", "getCreationFeedType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBottomPadding$annotations", "getBottomPadding", "getTopPadding$annotations", "getTopPadding", "getDisableEndView$annotations", "getDisableEndView", "getCurrentTabItemInfo$annotations", "getCurrentTabItemInfo", "()Lcom/larus/ugc/feed/api/model/TabItemInfoKmp;", "getForceSpanCount$annotations", "getForceSpanCount", "isGridLayoutManager$annotations", "getItemGapSpacing$annotations", "getItemGapSpacing", "getMarginLeft$annotations", "getMarginLeft", "getMarginRight$annotations", "getMarginRight", "getShowUserInfo$annotations", "getShowUserInfo", "getCreationRecommendType$annotations", "getCreationRecommendType", "getOpenNewChatPageOnSend$annotations", "getOpenNewChatPageOnSend", "getNeedFocusHelper$annotations", "getNeedFocusHelper", "getEnableGapHandling$annotations", "getEnableGapHandling", "getLoadMoreDistance$annotations", "getLoadMoreDistance", "getNeedAddReplicaEntrance$annotations", "getNeedAddReplicaEntrance", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCreationDoSameLandingType$annotations", "getCreationDoSameLandingType", "getCreationSendMessageFromDetail$annotations", "getCreationSendMessageFromDetail", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(ZZLjava/lang/String;ZLcom/larus/ugc/feed/api/model/CreationFeedTrackParamsKmp;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/larus/ugc/feed/api/model/TabItemInfoKmp;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;ZZZLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/larus/ugc/feed/api/model/CreationFeedInitParamsKmp;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class CreationFeedInitParamsKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<CreationFeedInitParamsKmp> CREATOR = null;
    public static final b Companion = null;
    private final Integer bottomPadding;
    private final Integer creationDoSameLandingType;
    private final Integer creationFeedType;
    private final String creationRecommendType;
    private final Boolean creationSendMessageFromDetail;
    private final TabItemInfoKmp currentTabItemInfo;
    private final boolean disableEndView;
    private final boolean disableInitialAutoRefreshOnce;
    private final boolean disablePullRefresh;
    private final boolean enableGapHandling;
    private final boolean forceRefreshIgnoreCache;
    private final Integer forceSpanCount;
    private final String fpsTrackerTag;
    private final boolean isGridLayoutManager;
    private final Integer itemGapSpacing;
    private final Integer loadMoreDistance;
    private final Integer marginLeft;
    private final Integer marginRight;
    private final Boolean needAddReplicaEntrance;
    private final boolean needFocusHelper;
    private final boolean openNewChatPageOnSend;
    private final boolean showUserInfo;
    private final Integer topPadding;
    private final CreationFeedTrackParamsKmp trackParams;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreationFeedInitParamsKmp> {
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
            g2 r1 = new g2("com.larus.ugc.feed.api.model.CreationFeedInitParamsKmp", r0, 24);
            r1.j("force_refresh_ignore_cache", true);
            r1.j("disable_initial_auto_refresh_once", true);
            r1.j("fps_tracker_tag", true);
            r1.j("disable_pull_refresh", true);
            r1.j("track_params", true);
            r1.j("creation_feed_type", true);
            r1.j("bottom_padding", true);
            r1.j("top_padding", true);
            r1.j("disable_end_view", true);
            r1.j("current_tab_item_info", true);
            r1.j("force_span_count", true);
            r1.j("is_grid_layout_manager", true);
            r1.j("item_gap_spacing", true);
            r1.j("margin_left", true);
            r1.j("margin_right", true);
            r1.j("show_user_info", true);
            r1.j("creation_recommend_type", true);
            r1.j("open_new_chat_page_on_send", true);
            r1.j("need_focus_helper", true);
            r1.j("enable_gap_handling", true);
            r1.j("load_more_distance", true);
            r1.j("need_add_replica_entrance", true);
            r1.j("creation_do_same_landing_type", true);
            r1.j("creation_send_message_from_detail", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            i r1 = i.a;
            v2 r2 = v2.a;
            w0 r3 = w0.a;
            return new d[]{r1, r1, r2, r1, CreationFeedTrackParamsKmp.a.a, kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r3), r1, kuc.a.d(TabItemInfoKmp.a.a), kuc.a.d(r3), r1, kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r3), r1, kuc.a.d(r2), r1, r1, r1, kuc.a.d(r3), kuc.a.d(r1), kuc.a.d(r3), kuc.a.d(r1)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r51) {
            Intrinsics.checkNotNullParameter(r51, "decoder");
            g2 r1 = b;
            muc.c r0 = r51.beginStructure(r1);
            if (r0.decodeSequentially() == false) goto L5;
            boolean r2 = r0.decodeBooleanElement(r1, 0);
            boolean r9 = r0.decodeBooleanElement(r1, 1);
            String r10 = r0.decodeStringElement(r1, 2);
            boolean r12 = r0.decodeBooleanElement(r1, 3);
            CreationFeedTrackParamsKmp r7 = (CreationFeedTrackParamsKmp) r0.decodeSerializableElement(r1, 4, CreationFeedTrackParamsKmp.a.a, null);
            w0 r13 = w0.a;
            Integer r14 = (Integer) r0.decodeNullableSerializableElement(r1, 5, r13, null);
            Integer r15 = (Integer) r0.decodeNullableSerializableElement(r1, 6, r13, null);
            Integer r3 = (Integer) r0.decodeNullableSerializableElement(r1, 7, r13, null);
            boolean r8 = r0.decodeBooleanElement(r1, 8);
            TabItemInfoKmp r4 = (TabItemInfoKmp) r0.decodeNullableSerializableElement(r1, 9, TabItemInfoKmp.a.a, null);
            Integer r5 = (Integer) r0.decodeNullableSerializableElement(r1, 10, r13, null);
            boolean r11 = r0.decodeBooleanElement(r1, 11);
            Integer r6 = (Integer) r0.decodeNullableSerializableElement(r1, 12, r13, null);
            Integer r16 = (Integer) r0.decodeNullableSerializableElement(r1, 13, r13, null);
            Integer r17 = (Integer) r0.decodeNullableSerializableElement(r1, 14, r13, null);
            boolean r18 = r0.decodeBooleanElement(r1, 15);
            String r19 = (String) r0.decodeNullableSerializableElement(r1, 16, v2.a, null);
            boolean r20 = r0.decodeBooleanElement(r1, 17);
            boolean r110 = r0.decodeBooleanElement(r1, 18);
            boolean r21 = r0.decodeBooleanElement(r1, 19);
            Integer r22 = (Integer) r0.decodeNullableSerializableElement(r1, 20, r13, null);
            i r23 = i.a;
            Boolean r24 = (Boolean) r0.decodeNullableSerializableElement(r1, 21, r23, null);
            Integer r25 = (Integer) r0.decodeNullableSerializableElement(r1, 22, r13, null);
            Boolean r39 = (Boolean) r0.decodeNullableSerializableElement(r1, 23, r23, null);
            Integer r38 = r25;
            boolean r31 = r18;
            boolean r34 = r110;
            boolean r27 = r11;
            boolean r35 = r21;
            String r32 = r19;
            Integer r36 = r22;
            String r111 = r10;
            Integer r30 = r17;
            Integer r29 = r16;
            Integer r28 = r6;
            boolean r112 = r2;
            boolean r33 = r20;
            Boolean r37 = r24;
            boolean r113 = r9;
            TabItemInfoKmp r26 = r4;
            Integer r210 = r5;
            CreationFeedTrackParamsKmp r211 = r7;
            boolean r212 = r8;
            boolean r114 = r12;
            Integer r213 = r15;
            Integer r214 = r3;
            int r115 = 16777215;
            Integer r215 = r14;
        L47:
            r0.endStructure(r1);
            return new CreationFeedInitParamsKmp(r115, r112, r113, r111, r114, r211, r215, r213, r214, r212, r26, r210, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, null);
        L5:
            String r40 = null;
            Boolean r41 = null;
            Integer r42 = null;
            Integer r43 = null;
            Integer r44 = null;
            TabItemInfoKmp r45 = null;
            Integer r46 = null;
            Integer r47 = null;
            Integer r116 = null;
            Boolean r117 = null;
            Integer r118 = null;
            Integer r119 = null;
            Integer r120 = null;
            CreationFeedTrackParamsKmp r216 = null;
            String r310 = null;
            int r121 = 0;
            boolean r311 = false;
            boolean r312 = false;
            boolean r48 = false;
            boolean r49 = false;
            boolean r410 = false;
            boolean r411 = false;
            boolean r412 = false;
            boolean r413 = false;
            boolean r414 = false;
            boolean r415 = true;
        L6:
            if (r415 == false) goto L46;
            Integer r416 = r118;
            int r122 = r0.decodeElementIndex(r1);
            switch(r122) {
                case -1: goto L44;
                case 0: goto L42;
                case 1: goto L41;
                case 2: goto L39;
                case 3: goto L38;
                case 4: goto L37;
                case 5: goto L35;
                case 6: goto L33;
                case 7: goto L32;
                case 8: goto L30;
                case 9: goto L29;
                case 10: goto L28;
                case 11: goto L27;
                case 12: goto L26;
                case 13: goto L25;
                case 14: goto L24;
                case 15: goto L23;
                case 16: goto L21;
                case 17: goto L18;
                case 18: goto L17;
                case 19: goto L16;
                case 20: goto L14;
                case 21: goto L13;
                case 22: goto L12;
                case 23: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r122);
        L35:
            r41 = r41;
            r42 = r42;
            r121 = r121 | 32;
            r216 = r216;
            r416 = (Integer) r0.decodeNullableSerializableElement(r1, 5, w0.a, r416);
        L43:
            r118 = r416;
            r41 = r41;
        L45:
            r216 = r216;
            r42 = r42;
            goto L6
        L37:
            r41 = r41;
            r42 = r42;
            CreationFeedTrackParamsKmp r50 = r216;
            r416 = r416;
            r216 = (CreationFeedTrackParamsKmp) r0.decodeSerializableElement(r1, 4, CreationFeedTrackParamsKmp.a.a, r50);
            r121 = r121 | 16;
            goto L43
        L38:
            r414 = r0.decodeBooleanElement(r1, 3);
            r121 = r121 | 8;
            goto L43
        L39:
            r310 = r0.decodeStringElement(r1, 2);
            r121 = r121 | 4;
            goto L43
        L41:
            r41 = r41;
            r42 = r42;
            r216 = r216;
            r416 = r416;
            r411 = r0.decodeBooleanElement(r1, 1);
            r121 = r121 | 2;
            goto L43
        L42:
            r41 = r41;
            r42 = r42;
            r216 = r216;
            r416 = r416;
            r121 = r121 | 1;
            r48 = r0.decodeBooleanElement(r1, 0);
            goto L43
        L44:
            r42 = r42;
            r216 = r216;
            r118 = r416;
            r41 = r41;
            r415 = false;
            goto L45
        L11:
            r41 = (Boolean) r0.decodeNullableSerializableElement(r1, 23, i.a, r41);
            int r123 = 8388608;
        L22:
            r121 = r121 | r123;
        L31:
            Boolean r313 = r41;
            r119 = r119;
        L34:
            r41 = r313;
            r118 = r416;
            goto L6
        L12:
            r44 = (Integer) r0.decodeNullableSerializableElement(r1, 22, w0.a, r44);
            r123 = 4194304;
            goto L22
        L13:
            r117 = (Boolean) r0.decodeNullableSerializableElement(r1, 21, i.a, r117);
            r123 = 2097152;
            goto L22
        L14:
            r47 = (Integer) r0.decodeNullableSerializableElement(r1, 20, w0.a, r47);
            r123 = 1048576;
            goto L22
        L16:
            r311 = r0.decodeBooleanElement(r1, 19);
            int r124 = 524288;
        L19:
            r121 = r121 | r124;
            goto L31
        L17:
            r412 = r0.decodeBooleanElement(r1, 18);
            r124 = 262144;
            goto L19
        L18:
            r410 = r0.decodeBooleanElement(r1, 17);
            r124 = 131072;
            goto L19
        L21:
            r119 = r119;
            r40 = (String) r0.decodeNullableSerializableElement(r1, 16, v2.a, r40);
            r123 = 65536;
            goto L22
        L23:
            r119 = r119;
            r312 = r0.decodeBooleanElement(r1, 15);
            r121 = r121 | 32768;
            goto L31
        L24:
            r119 = r119;
            r116 = (Integer) r0.decodeNullableSerializableElement(r1, 14, w0.a, r116);
            r121 = r121 | 16384;
            goto L31
        L25:
            r119 = r119;
            r120 = (Integer) r0.decodeNullableSerializableElement(r1, 13, w0.a, r120);
            r121 = r121 | 8192;
            goto L31
        L26:
            r119 = r119;
            r42 = (Integer) r0.decodeNullableSerializableElement(r1, 12, w0.a, r42);
            r121 = r121 | 4096;
            goto L31
        L27:
            r119 = r119;
            r413 = r0.decodeBooleanElement(r1, 11);
            r121 = r121 | 2048;
            goto L31
        L28:
            r119 = r119;
            r43 = (Integer) r0.decodeNullableSerializableElement(r1, 10, w0.a, r43);
            r121 = r121 | 1024;
            goto L31
        L29:
            r119 = r119;
            r45 = (TabItemInfoKmp) r0.decodeNullableSerializableElement(r1, 9, TabItemInfoKmp.a.a, r45);
            r121 = r121 | 512;
            goto L31
        L30:
            r119 = r119;
            r49 = r0.decodeBooleanElement(r1, 8);
            r121 = r121 | 256;
            goto L31
        L32:
            r119 = r119;
            r46 = (Integer) r0.decodeNullableSerializableElement(r1, 7, w0.a, r46);
            r121 = r121 | 128;
            goto L31
        L33:
            r313 = r41;
            r119 = (Integer) r0.decodeNullableSerializableElement(r1, 6, w0.a, r119);
            r121 = r121 | 64;
            goto L34
        L46:
            Integer r314 = r42;
            r211 = r216;
            r210 = r43;
            r26 = r45;
            r214 = r46;
            r36 = r47;
            r30 = r116;
            r213 = r119;
            r215 = r118;
            r28 = r314;
            r35 = r311;
            r31 = r312;
            r111 = r310;
            r112 = r48;
            r212 = r49;
            r33 = r410;
            r113 = r411;
            r34 = r412;
            r27 = r413;
            r114 = r414;
            r38 = r44;
            r37 = r117;
            r29 = r120;
            r39 = r41;
            r32 = r40;
            r115 = r121;
            goto L47
        }

        public final void serialize(muc.f r2, Object r3) {
            CreationFeedInitParamsKmp r4 = (CreationFeedInitParamsKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            CreationFeedInitParamsKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CreationFeedInitParamsKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<CreationFeedInitParamsKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationFeedInitParamsKmp createFromParcel(Parcel r30) {
            Intrinsics.checkNotNullParameter(r30, "parcel");
            boolean r3 = false;
            if (r30.readInt() == 0) goto L5;
            boolean r5 = true;
        L7:
            if (r30.readInt() == 0) goto L9;
            boolean r6 = true;
        L10:
            String r7 = r30.readString();
            if (r30.readInt() == 0) goto L13;
            boolean r8 = true;
        L14:
            CreationFeedTrackParamsKmp r9 = CreationFeedTrackParamsKmp.CREATOR.createFromParcel(r30);
            if (r30.readInt() != 0) goto L17;
            Integer r11 = null;
        L19:
            if (r30.readInt() != 0) goto L21;
            Integer r12 = null;
        L23:
            if (r30.readInt() != 0) goto L25;
            Integer r13 = null;
        L27:
            if (r30.readInt() == 0) goto L29;
            boolean r14 = true;
        L31:
            if (r30.readInt() != 0) goto L33;
            TabItemInfoKmp r2 = null;
        L34:
            TabItemInfoKmp r15 = r2;
            if (r30.readInt() != 0) goto L37;
            Integer r16 = null;
        L39:
            if (r30.readInt() == 0) goto L41;
            boolean r17 = true;
        L43:
            if (r30.readInt() != 0) goto L45;
            Integer r18 = null;
        L47:
            if (r30.readInt() != 0) goto L49;
            Integer r19 = null;
        L51:
            if (r30.readInt() != 0) goto L53;
            Integer r20 = null;
        L55:
            if (r30.readInt() == 0) goto L57;
            boolean r21 = true;
        L58:
            String r22 = r30.readString();
            if (r30.readInt() == 0) goto L61;
            boolean r23 = true;
        L63:
            if (r30.readInt() == 0) goto L65;
            boolean r24 = true;
        L67:
            if (r30.readInt() == 0) goto L69;
            boolean r25 = true;
        L71:
            if (r30.readInt() != 0) goto L73;
            Integer r26 = null;
        L75:
            if (r30.readInt() != 0) goto L78;
            Boolean r27 = null;
        L83:
            if (r30.readInt() != 0) goto L85;
            Integer r28 = null;
        L87:
            if (r30.readInt() != 0) goto L90;
            Boolean r0 = null;
        L94:
            return new CreationFeedInitParamsKmp(r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r0);
        L90:
            if (r30.readInt() == 0) goto L92;
            r3 = true;
        L92:
            r0 = Boolean.valueOf(r3);
            goto L94
        L85:
            r28 = Integer.valueOf(r30.readInt());
            goto L87
        L78:
            if (r30.readInt() == 0) goto L80;
            boolean r4 = true;
        L81:
            r27 = Boolean.valueOf(r4);
            goto L83
        L80:
            r4 = false;
            goto L81
        L73:
            r26 = Integer.valueOf(r30.readInt());
            goto L75
        L69:
            r25 = false;
            goto L71
        L65:
            r24 = false;
            goto L67
        L61:
            r23 = false;
            goto L63
        L57:
            r21 = false;
            goto L58
        L53:
            r20 = Integer.valueOf(r30.readInt());
            goto L55
        L49:
            r19 = Integer.valueOf(r30.readInt());
            goto L51
        L45:
            r18 = Integer.valueOf(r30.readInt());
            goto L47
        L41:
            r17 = false;
            goto L43
        L37:
            r16 = Integer.valueOf(r30.readInt());
            goto L39
        L33:
            r2 = TabItemInfoKmp.CREATOR.createFromParcel(r30);
            goto L34
        L29:
            r14 = false;
            goto L31
        L25:
            r13 = Integer.valueOf(r30.readInt());
            goto L27
        L21:
            r12 = Integer.valueOf(r30.readInt());
            goto L23
        L17:
            r11 = Integer.valueOf(r30.readInt());
            goto L19
        L13:
            r8 = false;
            goto L14
        L9:
            r6 = false;
            goto L10
        L5:
            r5 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CreationFeedInitParamsKmp[] newArray(int r1) {
            return new CreationFeedInitParamsKmp[r1];
        }
    }

    public CreationFeedInitParamsKmp() {
        this(false, false, null, false, null, null, null, null, false, null, null, false, null, null, null, false, null, false, false, false, null, null, null, null, 16777215, null);
    }

    public static /* synthetic */ CreationFeedInitParamsKmp copy$default(CreationFeedInitParamsKmp r17, boolean r18, boolean r19, String r20, boolean r21, CreationFeedTrackParamsKmp r22, Integer r23, Integer r24, Integer r25, boolean r26, TabItemInfoKmp r27, Integer r28, boolean r29, Integer r30, Integer r31, Integer r32, boolean r33, String r34, boolean r35, boolean r36, boolean r37, Integer r38, Boolean r39, Integer r40, Boolean r41, int r42, Object r43) {
        if ((r42 & 1) == 0) goto L5;
        boolean r2 = r17.forceRefreshIgnoreCache;
    L7:
        if ((r42 & 2) == 0) goto L9;
        boolean r3 = r17.disableInitialAutoRefreshOnce;
    L11:
        if ((r42 & 4) == 0) goto L13;
        String r4 = r17.fpsTrackerTag;
    L15:
        if ((r42 & 8) == 0) goto L17;
        boolean r5 = r17.disablePullRefresh;
    L19:
        if ((r42 & 16) == 0) goto L21;
        CreationFeedTrackParamsKmp r6 = r17.trackParams;
    L23:
        if ((r42 & 32) == 0) goto L25;
        Integer r7 = r17.creationFeedType;
    L27:
        if ((r42 & 64) == 0) goto L29;
        Integer r8 = r17.bottomPadding;
    L31:
        if ((r42 & 128) == 0) goto L33;
        Integer r9 = r17.topPadding;
    L35:
        if ((r42 & 256) == 0) goto L37;
        boolean r10 = r17.disableEndView;
    L39:
        if ((r42 & 512) == 0) goto L41;
        TabItemInfoKmp r11 = r17.currentTabItemInfo;
    L43:
        if ((r42 & 1024) == 0) goto L45;
        Integer r12 = r17.forceSpanCount;
    L47:
        if ((r42 & 2048) == 0) goto L49;
        boolean r13 = r17.isGridLayoutManager;
    L51:
        if ((r42 & 4096) == 0) goto L53;
        Integer r14 = r17.itemGapSpacing;
    L55:
        if ((r42 & 8192) == 0) goto L57;
        Integer r15 = r17.marginLeft;
    L58:
        Integer r310 = r15;
        if ((r42 & 16384) == 0) goto L61;
        Integer r16 = r17.marginRight;
    L62:
        Integer r311 = r16;
        if ((r42 & 32768) == 0) goto L65;
        boolean r110 = r17.showUserInfo;
    L66:
        boolean r312 = r110;
        if ((r42 & 65536) == 0) goto L69;
        String r111 = r17.creationRecommendType;
    L70:
        String r313 = r111;
        if ((r42 & 131072) == 0) goto L73;
        boolean r112 = r17.openNewChatPageOnSend;
    L74:
        boolean r314 = r112;
        if ((r42 & 262144) == 0) goto L77;
        boolean r113 = r17.needFocusHelper;
    L78:
        boolean r315 = r113;
        if ((r42 & 524288) == 0) goto L81;
        boolean r114 = r17.enableGapHandling;
    L82:
        boolean r316 = r114;
        if ((r42 & 1048576) == 0) goto L85;
        Integer r115 = r17.loadMoreDistance;
    L86:
        Integer r317 = r115;
        if ((r42 & 2097152) == 0) goto L89;
        Boolean r116 = r17.needAddReplicaEntrance;
    L90:
        Boolean r318 = r116;
        if ((r42 & 4194304) == 0) goto L93;
        Integer r117 = r17.creationDoSameLandingType;
    L95:
        if ((r42 & 8388608) == 0) goto L97;
        Boolean r1 = r17.creationSendMessageFromDetail;
    L99:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r117, r1);
    L97:
        r1 = r41;
        goto L99
    L93:
        r117 = r40;
        goto L95
    L89:
        r116 = r39;
        goto L90
    L85:
        r115 = r38;
        goto L86
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

    @SerialName("bottom_padding")
    public static /* synthetic */ void getBottomPadding$annotations() {
    }

    @SerialName("creation_do_same_landing_type")
    public static /* synthetic */ void getCreationDoSameLandingType$annotations() {
    }

    @SerialName("creation_feed_type")
    public static /* synthetic */ void getCreationFeedType$annotations() {
    }

    @SerialName("creation_recommend_type")
    public static /* synthetic */ void getCreationRecommendType$annotations() {
    }

    @SerialName("creation_send_message_from_detail")
    public static /* synthetic */ void getCreationSendMessageFromDetail$annotations() {
    }

    @SerialName("current_tab_item_info")
    public static /* synthetic */ void getCurrentTabItemInfo$annotations() {
    }

    @SerialName("disable_end_view")
    public static /* synthetic */ void getDisableEndView$annotations() {
    }

    @SerialName("disable_initial_auto_refresh_once")
    public static /* synthetic */ void getDisableInitialAutoRefreshOnce$annotations() {
    }

    @SerialName("disable_pull_refresh")
    public static /* synthetic */ void getDisablePullRefresh$annotations() {
    }

    @SerialName("enable_gap_handling")
    public static /* synthetic */ void getEnableGapHandling$annotations() {
    }

    @SerialName("force_refresh_ignore_cache")
    public static /* synthetic */ void getForceRefreshIgnoreCache$annotations() {
    }

    @SerialName("force_span_count")
    public static /* synthetic */ void getForceSpanCount$annotations() {
    }

    @SerialName("fps_tracker_tag")
    public static /* synthetic */ void getFpsTrackerTag$annotations() {
    }

    @SerialName("item_gap_spacing")
    public static /* synthetic */ void getItemGapSpacing$annotations() {
    }

    @SerialName("load_more_distance")
    public static /* synthetic */ void getLoadMoreDistance$annotations() {
    }

    @SerialName("margin_left")
    public static /* synthetic */ void getMarginLeft$annotations() {
    }

    @SerialName("margin_right")
    public static /* synthetic */ void getMarginRight$annotations() {
    }

    @SerialName("need_add_replica_entrance")
    public static /* synthetic */ void getNeedAddReplicaEntrance$annotations() {
    }

    @SerialName("need_focus_helper")
    public static /* synthetic */ void getNeedFocusHelper$annotations() {
    }

    @SerialName("open_new_chat_page_on_send")
    public static /* synthetic */ void getOpenNewChatPageOnSend$annotations() {
    }

    @SerialName("show_user_info")
    public static /* synthetic */ void getShowUserInfo$annotations() {
    }

    @SerialName("top_padding")
    public static /* synthetic */ void getTopPadding$annotations() {
    }

    @SerialName("track_params")
    public static /* synthetic */ void getTrackParams$annotations() {
    }

    @SerialName("is_grid_layout_manager")
    public static /* synthetic */ void isGridLayoutManager$annotations() {
    }

    public final boolean component1() {
        return this.forceRefreshIgnoreCache;
    }

    public final TabItemInfoKmp component10() {
        return this.currentTabItemInfo;
    }

    public final Integer component11() {
        return this.forceSpanCount;
    }

    public final boolean component12() {
        return this.isGridLayoutManager;
    }

    public final Integer component13() {
        return this.itemGapSpacing;
    }

    public final Integer component14() {
        return this.marginLeft;
    }

    public final Integer component15() {
        return this.marginRight;
    }

    public final boolean component16() {
        return this.showUserInfo;
    }

    public final String component17() {
        return this.creationRecommendType;
    }

    public final boolean component18() {
        return this.openNewChatPageOnSend;
    }

    public final boolean component19() {
        return this.needFocusHelper;
    }

    public final boolean component2() {
        return this.disableInitialAutoRefreshOnce;
    }

    public final boolean component20() {
        return this.enableGapHandling;
    }

    public final Integer component21() {
        return this.loadMoreDistance;
    }

    public final Boolean component22() {
        return this.needAddReplicaEntrance;
    }

    public final Integer component23() {
        return this.creationDoSameLandingType;
    }

    public final Boolean component24() {
        return this.creationSendMessageFromDetail;
    }

    public final String component3() {
        return this.fpsTrackerTag;
    }

    public final boolean component4() {
        return this.disablePullRefresh;
    }

    public final CreationFeedTrackParamsKmp component5() {
        return this.trackParams;
    }

    public final Integer component6() {
        return this.creationFeedType;
    }

    public final Integer component7() {
        return this.bottomPadding;
    }

    public final Integer component8() {
        return this.topPadding;
    }

    public final boolean component9() {
        return this.disableEndView;
    }

    public final CreationFeedInitParamsKmp copy(boolean r27, boolean r28, String r29, boolean r30, CreationFeedTrackParamsKmp r31, Integer r32, Integer r33, Integer r34, boolean r35, TabItemInfoKmp r36, Integer r37, boolean r38, Integer r39, Integer r40, Integer r41, boolean r42, String r43, boolean r44, boolean r45, boolean r46, Integer r47, Boolean r48, Integer r49, Boolean r50) {
        Intrinsics.checkNotNullParameter(r29, "fpsTrackerTag");
        Intrinsics.checkNotNullParameter(r31, "trackParams");
        return new CreationFeedInitParamsKmp(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationFeedInitParamsKmp) == true) goto L8;
        return false;
    L8:
        CreationFeedInitParamsKmp r6 = (CreationFeedInitParamsKmp) r5;
        if (this.forceRefreshIgnoreCache == r6.forceRefreshIgnoreCache) goto L12;
        return false;
    L12:
        if (this.disableInitialAutoRefreshOnce == r6.disableInitialAutoRefreshOnce) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fpsTrackerTag, r6.fpsTrackerTag) == true) goto L18;
        return false;
    L18:
        if (this.disablePullRefresh == r6.disablePullRefresh) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.trackParams, r6.trackParams) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.creationFeedType, r6.creationFeedType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.bottomPadding, r6.bottomPadding) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.topPadding, r6.topPadding) == true) goto L33;
        return false;
    L33:
        if (this.disableEndView == r6.disableEndView) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.currentTabItemInfo, r6.currentTabItemInfo) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.forceSpanCount, r6.forceSpanCount) == true) goto L42;
        return false;
    L42:
        if (this.isGridLayoutManager == r6.isGridLayoutManager) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.itemGapSpacing, r6.itemGapSpacing) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.marginLeft, r6.marginLeft) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.marginRight, r6.marginRight) == true) goto L54;
        return false;
    L54:
        if (this.showUserInfo == r6.showUserInfo) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.creationRecommendType, r6.creationRecommendType) == true) goto L60;
        return false;
    L60:
        if (this.openNewChatPageOnSend == r6.openNewChatPageOnSend) goto L63;
        return false;
    L63:
        if (this.needFocusHelper == r6.needFocusHelper) goto L66;
        return false;
    L66:
        if (this.enableGapHandling == r6.enableGapHandling) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.loadMoreDistance, r6.loadMoreDistance) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.needAddReplicaEntrance, r6.needAddReplicaEntrance) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.creationDoSameLandingType, r6.creationDoSameLandingType) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.creationSendMessageFromDetail, r6.creationSendMessageFromDetail) == true) goto L80;
        return false;
    L80:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.forceRefreshIgnoreCache == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.disableInitialAutoRefreshOnce == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (((r2 + r3) * 31) + this.fpsTrackerTag.hashCode()) * 31;
        if (this.disablePullRefresh == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (((r4 + r5) * 31) + this.trackParams.hashCode()) * 31;
        Integer r7 = this.creationFeedType;
        int r8 = 0;
        if (r7 != null) goto L17;
        int r9 = 0;
    L18:
        int r10 = (r6 + r9) * 31;
        Integer r11 = this.bottomPadding;
        if (r11 != null) goto L21;
        int r12 = 0;
    L22:
        int r13 = (r10 + r12) * 31;
        Integer r14 = this.topPadding;
        if (r14 != null) goto L25;
        int r15 = 0;
    L26:
        int r16 = (r13 + r15) * 31;
        if (this.disableEndView == false) goto L29;
        int r17 = 1231;
    L30:
        int r18 = (r16 + r17) * 31;
        TabItemInfoKmp r19 = this.currentTabItemInfo;
        if (r19 != null) goto L33;
        int r20 = 0;
    L34:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.forceSpanCount;
        if (r22 != null) goto L37;
        int r23 = 0;
    L38:
        int r24 = (r21 + r23) * 31;
        if (this.isGridLayoutManager == false) goto L41;
        int r25 = 1231;
    L42:
        int r26 = (r24 + r25) * 31;
        Integer r27 = this.itemGapSpacing;
        if (r27 != null) goto L45;
        int r28 = 0;
    L46:
        int r29 = (r26 + r28) * 31;
        Integer r30 = this.marginLeft;
        if (r30 != null) goto L49;
        int r31 = 0;
    L50:
        int r32 = (r29 + r31) * 31;
        Integer r33 = this.marginRight;
        if (r33 != null) goto L53;
        int r34 = 0;
    L54:
        int r35 = (r32 + r34) * 31;
        if (this.showUserInfo == false) goto L57;
        int r36 = 1231;
    L58:
        int r37 = (r35 + r36) * 31;
        String r38 = this.creationRecommendType;
        if (r38 != null) goto L61;
        int r39 = 0;
    L62:
        int r40 = (r37 + r39) * 31;
        if (this.openNewChatPageOnSend == false) goto L65;
        int r41 = 1231;
    L66:
        int r42 = (r40 + r41) * 31;
        if (this.needFocusHelper == false) goto L69;
        int r43 = 1231;
    L70:
        int r44 = (r42 + r43) * 31;
        if (this.enableGapHandling == true) goto L74;
        r1 = 1237;
    L74:
        int r45 = (r44 + r1) * 31;
        Integer r46 = this.loadMoreDistance;
        if (r46 != null) goto L77;
        int r47 = 0;
    L78:
        int r48 = (r45 + r47) * 31;
        Boolean r49 = this.needAddReplicaEntrance;
        if (r49 != null) goto L81;
        int r50 = 0;
    L82:
        int r51 = (r48 + r50) * 31;
        Integer r52 = this.creationDoSameLandingType;
        if (r52 != null) goto L85;
        int r53 = 0;
    L86:
        int r54 = (r51 + r53) * 31;
        Boolean r55 = this.creationSendMessageFromDetail;
        if (r55 == null) goto L91;
        r8 = r55.hashCode();
    L91:
        return r54 + r8;
    L85:
        r53 = r52.hashCode();
        goto L86
    L81:
        r50 = r49.hashCode();
        goto L82
    L77:
        r47 = r46.hashCode();
        goto L78
    L69:
        r43 = 1237;
        goto L70
    L65:
        r41 = 1237;
        goto L66
    L61:
        r39 = r38.hashCode();
        goto L62
    L57:
        r36 = 1237;
        goto L58
    L53:
        r34 = r33.hashCode();
        goto L54
    L49:
        r31 = r30.hashCode();
        goto L50
    L45:
        r28 = r27.hashCode();
        goto L46
    L41:
        r25 = 1237;
        goto L42
    L37:
        r23 = r22.hashCode();
        goto L38
    L33:
        r20 = r19.hashCode();
        goto L34
    L29:
        r17 = 1237;
        goto L30
    L25:
        r15 = r14.hashCode();
        goto L26
    L21:
        r12 = r11.hashCode();
        goto L22
    L17:
        r9 = r7.hashCode();
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "CreationFeedInitParamsKmp(forceRefreshIgnoreCache=" + this.forceRefreshIgnoreCache + ", disableInitialAutoRefreshOnce=" + this.disableInitialAutoRefreshOnce + ", fpsTrackerTag=" + this.fpsTrackerTag + ", disablePullRefresh=" + this.disablePullRefresh + ", trackParams=" + this.trackParams + ", creationFeedType=" + this.creationFeedType + ", bottomPadding=" + this.bottomPadding + ", topPadding=" + this.topPadding + ", disableEndView=" + this.disableEndView + ", currentTabItemInfo=" + this.currentTabItemInfo + ", forceSpanCount=" + this.forceSpanCount + ", isGridLayoutManager=" + this.isGridLayoutManager + ", itemGapSpacing=" + this.itemGapSpacing + ", marginLeft=" + this.marginLeft + ", marginRight=" + this.marginRight + ", showUserInfo=" + this.showUserInfo + ", creationRecommendType=" + this.creationRecommendType + ", openNewChatPageOnSend=" + this.openNewChatPageOnSend + ", needFocusHelper=" + this.needFocusHelper + ", enableGapHandling=" + this.enableGapHandling + ", loadMoreDistance=" + this.loadMoreDistance + ", needAddReplicaEntrance=" + this.needAddReplicaEntrance + ", creationDoSameLandingType=" + this.creationDoSameLandingType + ", creationSendMessageFromDetail=" + this.creationSendMessageFromDetail + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        r4.writeInt(this.forceRefreshIgnoreCache ? 1 : 0);
        r4.writeInt(this.disableInitialAutoRefreshOnce ? 1 : 0);
        r4.writeString(this.fpsTrackerTag);
        r4.writeInt(this.disablePullRefresh ? 1 : 0);
        this.trackParams.writeToParcel(r4, r5);
        Integer r0 = this.creationFeedType;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        Integer r1 = this.bottomPadding;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        Integer r2 = this.topPadding;
        if (r2 != null) goto L13;
        r4.writeInt(0);
    L14:
        r4.writeInt(this.disableEndView ? 1 : 0);
        TabItemInfoKmp r3 = this.currentTabItemInfo;
        if (r3 != null) goto L17;
        r4.writeInt(0);
    L18:
        Integer r6 = this.forceSpanCount;
        if (r6 != null) goto L21;
        r4.writeInt(0);
    L22:
        r4.writeInt(this.isGridLayoutManager ? 1 : 0);
        Integer r7 = this.itemGapSpacing;
        if (r7 != null) goto L25;
        r4.writeInt(0);
    L26:
        Integer r8 = this.marginLeft;
        if (r8 != null) goto L29;
        r4.writeInt(0);
    L30:
        Integer r9 = this.marginRight;
        if (r9 != null) goto L33;
        r4.writeInt(0);
    L34:
        r4.writeInt(this.showUserInfo ? 1 : 0);
        r4.writeString(this.creationRecommendType);
        r4.writeInt(this.openNewChatPageOnSend ? 1 : 0);
        r4.writeInt(this.needFocusHelper ? 1 : 0);
        r4.writeInt(this.enableGapHandling ? 1 : 0);
        Integer r10 = this.loadMoreDistance;
        if (r10 != null) goto L37;
        r4.writeInt(0);
    L38:
        Boolean r11 = this.needAddReplicaEntrance;
        if (r11 != null) goto L41;
        r4.writeInt(0);
    L42:
        Integer r12 = this.creationDoSameLandingType;
        if (r12 != null) goto L45;
        r4.writeInt(0);
    L46:
        Boolean r13 = this.creationSendMessageFromDetail;
        if (r13 != null) goto L49;
        r4.writeInt(0);
        return;
    L49:
        r4.writeInt(1);
        r4.writeInt(r13.booleanValue() ? 1 : 0);
        return;
    L45:
        r4.writeInt(1);
        r4.writeInt(r12.intValue());
        goto L46
    L41:
        r4.writeInt(1);
        r4.writeInt(r11.booleanValue() ? 1 : 0);
        goto L42
    L37:
        r4.writeInt(1);
        r4.writeInt(r10.intValue());
        goto L38
    L33:
        r4.writeInt(1);
        r4.writeInt(r9.intValue());
        goto L34
    L29:
        r4.writeInt(1);
        r4.writeInt(r8.intValue());
        goto L30
    L25:
        r4.writeInt(1);
        r4.writeInt(r7.intValue());
        goto L26
    L21:
        r4.writeInt(1);
        r4.writeInt(r6.intValue());
        goto L22
    L17:
        r4.writeInt(1);
        r3.writeToParcel(r4, r5);
        goto L18
    L13:
        r4.writeInt(1);
        r4.writeInt(r2.intValue());
        goto L14
    L9:
        r4.writeInt(1);
        r4.writeInt(r1.intValue());
        goto L10
    L5:
        r4.writeInt(1);
        r4.writeInt(r0.intValue());
        goto L6
    }

    static {
        Companion = new b();
        $stable = 8;
        CREATOR = new c();
    }

    public final Integer getBottomPadding() {
        return this.bottomPadding;
    }

    public final Integer getCreationDoSameLandingType() {
        return this.creationDoSameLandingType;
    }

    public final Integer getCreationFeedType() {
        return this.creationFeedType;
    }

    public final String getCreationRecommendType() {
        return this.creationRecommendType;
    }

    public final Boolean getCreationSendMessageFromDetail() {
        return this.creationSendMessageFromDetail;
    }

    public final TabItemInfoKmp getCurrentTabItemInfo() {
        return this.currentTabItemInfo;
    }

    public final boolean getDisableEndView() {
        return this.disableEndView;
    }

    public final boolean getDisableInitialAutoRefreshOnce() {
        return this.disableInitialAutoRefreshOnce;
    }

    public final boolean getDisablePullRefresh() {
        return this.disablePullRefresh;
    }

    public final boolean getEnableGapHandling() {
        return this.enableGapHandling;
    }

    public final boolean getForceRefreshIgnoreCache() {
        return this.forceRefreshIgnoreCache;
    }

    public final Integer getForceSpanCount() {
        return this.forceSpanCount;
    }

    public final String getFpsTrackerTag() {
        return this.fpsTrackerTag;
    }

    public final Integer getItemGapSpacing() {
        return this.itemGapSpacing;
    }

    public final Integer getLoadMoreDistance() {
        return this.loadMoreDistance;
    }

    public final Integer getMarginLeft() {
        return this.marginLeft;
    }

    public final Integer getMarginRight() {
        return this.marginRight;
    }

    public final Boolean getNeedAddReplicaEntrance() {
        return this.needAddReplicaEntrance;
    }

    public final boolean getNeedFocusHelper() {
        return this.needFocusHelper;
    }

    public final boolean getOpenNewChatPageOnSend() {
        return this.openNewChatPageOnSend;
    }

    public final boolean getShowUserInfo() {
        return this.showUserInfo;
    }

    public final Integer getTopPadding() {
        return this.topPadding;
    }

    public final CreationFeedTrackParamsKmp getTrackParams() {
        return this.trackParams;
    }

    public final boolean isGridLayoutManager() {
        return this.isGridLayoutManager;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(CreationFeedInitParamsKmp r32, muc.d r33, f r34) {
        if (r33.shouldEncodeElementDefault(r34, 0) == false) goto L6;
    L4:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        r33.encodeBooleanElement(r34, 0, r32.forceRefreshIgnoreCache);
    L12:
        if (r33.shouldEncodeElementDefault(r34, 1) == false) goto L15;
    L13:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L21;
        r33.encodeBooleanElement(r34, 1, r32.disableInitialAutoRefreshOnce);
    L21:
        if (r33.shouldEncodeElementDefault(r34, 2) == false) goto L24;
    L22:
        boolean r6 = true;
    L27:
        if (r6 == false) goto L30;
        r33.encodeStringElement(r34, 2, r32.fpsTrackerTag);
    L30:
        if (r33.shouldEncodeElementDefault(r34, 3) == false) goto L33;
    L31:
        boolean r7 = true;
    L36:
        if (r7 == false) goto L39;
        r33.encodeBooleanElement(r34, 3, r32.disablePullRefresh);
    L39:
        if (r33.shouldEncodeElementDefault(r34, 4) == false) goto L42;
    L40:
        boolean r3 = true;
    L45:
        if (r3 == false) goto L48;
        r33.encodeSerializableElement(r34, 4, CreationFeedTrackParamsKmp.a.a, r32.trackParams);
    L48:
        if (r33.shouldEncodeElementDefault(r34, 5) == false) goto L51;
    L49:
        boolean r8 = true;
    L54:
        if (r8 == false) goto L57;
        r33.encodeNullableSerializableElement(r34, 5, w0.a, r32.creationFeedType);
    L57:
        if (r33.shouldEncodeElementDefault(r34, 6) == false) goto L60;
    L58:
        boolean r9 = true;
    L63:
        if (r9 == false) goto L66;
        r33.encodeNullableSerializableElement(r34, 6, w0.a, r32.bottomPadding);
    L66:
        if (r33.shouldEncodeElementDefault(r34, 7) == false) goto L69;
    L67:
        boolean r10 = true;
    L72:
        if (r10 == false) goto L75;
        r33.encodeNullableSerializableElement(r34, 7, w0.a, r32.topPadding);
    L75:
        if (r33.shouldEncodeElementDefault(r34, 8) == false) goto L78;
    L76:
        boolean r11 = true;
    L81:
        if (r11 == false) goto L84;
        r33.encodeBooleanElement(r34, 8, r32.disableEndView);
    L84:
        if (r33.shouldEncodeElementDefault(r34, 9) == false) goto L87;
    L85:
        boolean r12 = true;
    L90:
        if (r12 == false) goto L93;
        r33.encodeNullableSerializableElement(r34, 9, TabItemInfoKmp.a.a, r32.currentTabItemInfo);
    L93:
        if (r33.shouldEncodeElementDefault(r34, 10) == false) goto L96;
    L94:
        boolean r13 = true;
    L99:
        if (r13 == false) goto L102;
        r33.encodeNullableSerializableElement(r34, 10, w0.a, r32.forceSpanCount);
    L102:
        if (r33.shouldEncodeElementDefault(r34, 11) == false) goto L105;
    L103:
        boolean r14 = true;
    L108:
        if (r14 == false) goto L111;
        r33.encodeBooleanElement(r34, 11, r32.isGridLayoutManager);
    L111:
        if (r33.shouldEncodeElementDefault(r34, 12) == false) goto L114;
    L112:
        boolean r15 = true;
    L117:
        if (r15 == false) goto L120;
        r33.encodeNullableSerializableElement(r34, 12, w0.a, r32.itemGapSpacing);
    L120:
        if (r33.shouldEncodeElementDefault(r34, 13) == false) goto L123;
    L121:
        boolean r16 = true;
    L126:
        if (r16 == false) goto L129;
        r33.encodeNullableSerializableElement(r34, 13, w0.a, r32.marginLeft);
    L129:
        if (r33.shouldEncodeElementDefault(r34, 14) == false) goto L132;
    L130:
        boolean r17 = true;
    L135:
        if (r17 == false) goto L138;
        r33.encodeNullableSerializableElement(r34, 14, w0.a, r32.marginRight);
    L138:
        if (r33.shouldEncodeElementDefault(r34, 15) == false) goto L141;
    L139:
        boolean r18 = true;
    L144:
        if (r18 == false) goto L147;
        r33.encodeBooleanElement(r34, 15, r32.showUserInfo);
    L147:
        if (r33.shouldEncodeElementDefault(r34, 16) == false) goto L150;
    L148:
        boolean r19 = true;
    L153:
        if (r19 == false) goto L156;
        r33.encodeNullableSerializableElement(r34, 16, v2.a, r32.creationRecommendType);
    L156:
        if (r33.shouldEncodeElementDefault(r34, 17) == false) goto L159;
    L157:
        boolean r20 = true;
    L162:
        if (r20 == false) goto L165;
        r33.encodeBooleanElement(r34, 17, r32.openNewChatPageOnSend);
    L165:
        if (r33.shouldEncodeElementDefault(r34, 18) == false) goto L168;
    L166:
        boolean r21 = true;
    L171:
        if (r21 == false) goto L174;
        r33.encodeBooleanElement(r34, 18, r32.needFocusHelper);
    L174:
        if (r33.shouldEncodeElementDefault(r34, 19) == false) goto L177;
    L175:
        boolean r22 = true;
    L180:
        if (r22 == false) goto L183;
        r33.encodeBooleanElement(r34, 19, r32.enableGapHandling);
    L183:
        if (r33.shouldEncodeElementDefault(r34, 20) == false) goto L186;
    L184:
        boolean r23 = true;
    L189:
        if (r23 == false) goto L192;
        r33.encodeNullableSerializableElement(r34, 20, w0.a, r32.loadMoreDistance);
    L192:
        if (r33.shouldEncodeElementDefault(r34, 21) == false) goto L195;
    L193:
        boolean r24 = true;
    L198:
        if (r24 == false) goto L201;
        r33.encodeNullableSerializableElement(r34, 21, i.a, r32.needAddReplicaEntrance);
    L201:
        if (r33.shouldEncodeElementDefault(r34, 22) == false) goto L204;
    L202:
        boolean r25 = true;
    L207:
        if (r25 == false) goto L210;
        r33.encodeNullableSerializableElement(r34, 22, w0.a, r32.creationDoSameLandingType);
    L210:
        if (r33.shouldEncodeElementDefault(r34, 23) == false) goto L213;
    L211:
        boolean r26 = true;
    L216:
        if (r26 == false) goto L219;
        r33.encodeNullableSerializableElement(r34, 23, i.a, r32.creationSendMessageFromDetail);
        return;
    L219:
        return;
    L213:
        if (Intrinsics.areEqual(r32.creationSendMessageFromDetail, Boolean.FALSE) == false) goto L211;
        r26 = false;
        goto L216
    L204:
        if (r32.creationDoSameLandingType != null) goto L202;
        r25 = false;
        goto L207
    L195:
        if (Intrinsics.areEqual(r32.needAddReplicaEntrance, Boolean.FALSE) == false) goto L193;
        r24 = false;
        goto L198
    L186:
        if (r32.loadMoreDistance != null) goto L184;
        r23 = false;
        goto L189
    L177:
        if (r32.enableGapHandling == true) goto L175;
        r22 = false;
        goto L180
    L168:
        if (r32.needFocusHelper == true) goto L166;
        r21 = false;
        goto L171
    L159:
        if (r32.openNewChatPageOnSend != true) goto L157;
        r20 = false;
        goto L162
    L150:
        if (r32.creationRecommendType != null) goto L148;
        r19 = false;
        goto L153
    L141:
        if (r32.showUserInfo != true) goto L139;
        r18 = false;
        goto L144
    L132:
        if (r32.marginRight != null) goto L130;
        r17 = false;
        goto L135
    L123:
        if (r32.marginLeft != null) goto L121;
        r16 = false;
        goto L126
    L114:
        if (r32.itemGapSpacing != null) goto L112;
        r15 = false;
        goto L117
    L105:
        if (r32.isGridLayoutManager == true) goto L103;
        r14 = false;
        goto L108
    L96:
        if (r32.forceSpanCount != null) goto L94;
        r13 = false;
        goto L99
    L87:
        if (r32.currentTabItemInfo != null) goto L85;
        r12 = false;
        goto L90
    L78:
        if (r32.disableEndView == true) goto L76;
        r11 = false;
        goto L81
    L69:
        if (r32.topPadding != null) goto L67;
        r10 = false;
        goto L72
    L60:
        if (r32.bottomPadding != null) goto L58;
        r9 = false;
        goto L63
    L51:
        if (r32.creationFeedType != null) goto L49;
        r8 = false;
        goto L54
    L42:
        if (Intrinsics.areEqual(r32.trackParams, new CreationFeedTrackParamsKmp("", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194302, null)) == false) goto L40;
        r3 = false;
        goto L45
    L33:
        if (r32.disablePullRefresh == true) goto L31;
        r7 = false;
        goto L36
    L24:
        if (Intrinsics.areEqual(r32.fpsTrackerTag, "") == false) goto L22;
        r6 = false;
        goto L27
    L15:
        if (r32.disableInitialAutoRefreshOnce == true) goto L13;
        r5 = false;
        goto L18
    L6:
        if (r32.forceRefreshIgnoreCache == true) goto L4;
        r4 = false;
        goto L9
    }

    public CreationFeedInitParamsKmp(boolean r5, boolean r6, String r7, boolean r8, CreationFeedTrackParamsKmp r9, Integer r10, Integer r11, Integer r12, boolean r13, TabItemInfoKmp r14, Integer r15, boolean r16, Integer r17, Integer r18, Integer r19, boolean r20, String r21, boolean r22, boolean r23, boolean r24, Integer r25, Boolean r26, Integer r27, Boolean r28) {
        Intrinsics.checkNotNullParameter(r7, "fpsTrackerTag");
        Intrinsics.checkNotNullParameter(r9, "trackParams");
        this.forceRefreshIgnoreCache = r5;
        this.disableInitialAutoRefreshOnce = r6;
        this.fpsTrackerTag = r7;
        this.disablePullRefresh = r8;
        this.trackParams = r9;
        this.creationFeedType = r10;
        this.bottomPadding = r11;
        this.topPadding = r12;
        this.disableEndView = r13;
        this.currentTabItemInfo = r14;
        this.forceSpanCount = r15;
        this.isGridLayoutManager = r16;
        this.itemGapSpacing = r17;
        this.marginLeft = r18;
        this.marginRight = r19;
        this.showUserInfo = r20;
        this.creationRecommendType = r21;
        this.openNewChatPageOnSend = r22;
        this.needFocusHelper = r23;
        this.enableGapHandling = r24;
        this.loadMoreDistance = r25;
        this.needAddReplicaEntrance = r26;
        this.creationDoSameLandingType = r27;
        this.creationSendMessageFromDetail = r28;
    }

    public CreationFeedInitParamsKmp(int r31, boolean r32, boolean r33, String r34, boolean r35, CreationFeedTrackParamsKmp r36, Integer r37, Integer r38, Integer r39, boolean r40, TabItemInfoKmp r41, Integer r42, boolean r43, Integer r44, Integer r45, Integer r46, boolean r47, String r48, boolean r49, boolean r50, boolean r51, Integer r52, Boolean r53, Integer r54, Boolean r55, q2 r56) {
        if ((r31 & 0) == 0) goto L5;
        b2.b(r31, 0, a.b);
        throw null;
    L5:
        if ((r31 & 1) != 0) goto L7;
        this.forceRefreshIgnoreCache = false;
    L9:
        if ((r31 & 2) != 0) goto L11;
        this.disableInitialAutoRefreshOnce = false;
    L13:
        if ((r31 & 4) != 0) goto L15;
        String r2 = "";
    L16:
        this.fpsTrackerTag = r2;
        if ((r31 & 8) != 0) goto L19;
        this.disablePullRefresh = false;
    L21:
        if ((r31 & 16) != 0) goto L23;
        CreationFeedTrackParamsKmp r3 = new CreationFeedTrackParamsKmp("", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194302, null);
    L24:
        this.trackParams = r3;
        if ((r31 & 32) != 0) goto L27;
        this.creationFeedType = null;
    L29:
        if ((r31 & 64) != 0) goto L31;
        this.bottomPadding = null;
    L33:
        if ((r31 & 128) != 0) goto L35;
        this.topPadding = null;
    L37:
        if ((r31 & 256) != 0) goto L39;
        this.disableEndView = false;
    L41:
        if ((r31 & 512) != 0) goto L43;
        this.currentTabItemInfo = null;
    L45:
        if ((r31 & 1024) != 0) goto L47;
        this.forceSpanCount = null;
    L49:
        if ((r31 & 2048) != 0) goto L51;
        this.isGridLayoutManager = false;
    L53:
        if ((r31 & 4096) != 0) goto L55;
        this.itemGapSpacing = null;
    L57:
        if ((r31 & 8192) != 0) goto L59;
        this.marginLeft = null;
    L61:
        if ((r31 & 16384) != 0) goto L63;
        this.marginRight = null;
    L65:
        if ((32768 & r31) != 0) goto L67;
        this.showUserInfo = true;
    L69:
        if ((65536 & r31) != 0) goto L71;
        this.creationRecommendType = null;
    L73:
        if ((131072 & r31) != 0) goto L75;
        this.openNewChatPageOnSend = true;
    L77:
        if ((262144 & r31) != 0) goto L79;
        this.needFocusHelper = false;
    L81:
        if ((524288 & r31) != 0) goto L83;
        this.enableGapHandling = false;
    L85:
        if ((1048576 & r31) != 0) goto L87;
        this.loadMoreDistance = null;
    L89:
        if ((2097152 & r31) != 0) goto L91;
        Boolean r4 = Boolean.FALSE;
    L92:
        this.needAddReplicaEntrance = r4;
        if ((4194304 & r31) != 0) goto L95;
        this.creationDoSameLandingType = null;
    L97:
        if ((r31 & 8388608) != 0) goto L99;
        Boolean r1 = Boolean.FALSE;
    L100:
        this.creationSendMessageFromDetail = r1;
        return;
    L99:
        r1 = r55;
        goto L100
    L95:
        this.creationDoSameLandingType = r54;
        goto L97
    L91:
        r4 = r53;
        goto L92
    L87:
        this.loadMoreDistance = r52;
        goto L89
    L83:
        this.enableGapHandling = r51;
        goto L85
    L79:
        this.needFocusHelper = r50;
        goto L81
    L75:
        this.openNewChatPageOnSend = r49;
        goto L77
    L71:
        this.creationRecommendType = r48;
        goto L73
    L67:
        this.showUserInfo = r47;
        goto L69
    L63:
        this.marginRight = r46;
        goto L65
    L59:
        this.marginLeft = r45;
        goto L61
    L55:
        this.itemGapSpacing = r44;
        goto L57
    L51:
        this.isGridLayoutManager = r43;
        goto L53
    L47:
        this.forceSpanCount = r42;
        goto L49
    L43:
        this.currentTabItemInfo = r41;
        goto L45
    L39:
        this.disableEndView = r40;
        goto L41
    L35:
        this.topPadding = r39;
        goto L37
    L31:
        this.bottomPadding = r38;
        goto L33
    L27:
        this.creationFeedType = r37;
        goto L29
    L23:
        r3 = r36;
        goto L24
    L19:
        this.disablePullRefresh = r35;
        goto L21
    L15:
        r2 = r34;
        goto L16
    L11:
        this.disableInitialAutoRefreshOnce = r33;
        goto L13
    L7:
        this.forceRefreshIgnoreCache = r32;
        goto L9
    }

    public /* synthetic */ CreationFeedInitParamsKmp(boolean r33, boolean r34, String r35, boolean r36, CreationFeedTrackParamsKmp r37, Integer r38, Integer r39, Integer r40, boolean r41, TabItemInfoKmp r42, Integer r43, boolean r44, Integer r45, Integer r46, Integer r47, boolean r48, String r49, boolean r50, boolean r51, boolean r52, Integer r53, Boolean r54, Integer r55, Boolean r56, int r57, DefaultConstructorMarker r58) {
        if ((r57 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r57 & 2) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r57 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r57 & 8) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r57 & 16) == 0) goto L21;
        CreationFeedTrackParamsKmp r6 = new CreationFeedTrackParamsKmp("", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194302, null);
    L23:
        if ((r57 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r57 & 64) == 0) goto L29;
        Integer r9 = null;
    L31:
        if ((r57 & 128) == 0) goto L33;
        Integer r10 = null;
    L35:
        if ((r57 & 256) == 0) goto L37;
        boolean r11 = false;
    L39:
        if ((r57 & 512) == 0) goto L41;
        TabItemInfoKmp r12 = null;
    L43:
        if ((r57 & 1024) == 0) goto L45;
        Integer r13 = null;
    L47:
        if ((r57 & 2048) == 0) goto L49;
        boolean r14 = false;
    L51:
        if ((r57 & 4096) == 0) goto L53;
        Integer r15 = null;
    L55:
        if ((r57 & 8192) == 0) goto L57;
        Integer r2 = null;
    L59:
        if ((r57 & 16384) == 0) goto L61;
        Integer r8 = null;
    L62:
        boolean r17 = true;
        if ((r57 & 32768) == 0) goto L65;
        boolean r16 = true;
    L67:
        if ((r57 & 65536) == 0) goto L69;
        String r18 = null;
    L71:
        if ((r57 & 131072) != 0) goto L75;
        r17 = r50;
    L75:
        if ((r57 & 262144) == 0) goto L77;
        boolean r19 = false;
    L79:
        if ((r57 & 524288) == 0) goto L81;
        boolean r20 = false;
    L83:
        if ((r57 & 1048576) == 0) goto L85;
        Integer r21 = null;
    L87:
        if ((r57 & 2097152) == 0) goto L89;
        Boolean r22 = Boolean.FALSE;
    L91:
        if ((r57 & 4194304) == 0) goto L93;
        Integer r23 = null;
    L95:
        if ((r57 & 8388608) == 0) goto L97;
        Boolean r0 = Boolean.FALSE;
    L98:
        this(r1, r3, r4, r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r2, r8, r16, r18, r17, r19, r20, r21, r22, r23, r0);
        return;
    L97:
        r0 = r56;
        goto L98
    L93:
        r23 = r55;
        goto L95
    L89:
        r22 = r54;
        goto L91
    L85:
        r21 = r53;
        goto L87
    L81:
        r20 = r52;
        goto L83
    L77:
        r19 = r51;
        goto L79
    L69:
        r18 = r49;
        goto L71
    L65:
        r16 = r48;
        goto L67
    L61:
        r8 = r47;
        goto L62
    L57:
        r2 = r46;
        goto L59
    L53:
        r15 = r45;
        goto L55
    L49:
        r14 = r44;
        goto L51
    L45:
        r13 = r43;
        goto L47
    L41:
        r12 = r42;
        goto L43
    L37:
        r11 = r41;
        goto L39
    L33:
        r10 = r40;
        goto L35
    L29:
        r9 = r39;
        goto L31
    L25:
        r7 = r38;
        goto L27
    L21:
        r6 = r37;
        goto L23
    L17:
        r5 = r36;
        goto L19
    L13:
        r4 = r35;
        goto L15
    L9:
        r3 = r34;
        goto L11
    L5:
        r1 = r33;
        goto L7
    }
}
