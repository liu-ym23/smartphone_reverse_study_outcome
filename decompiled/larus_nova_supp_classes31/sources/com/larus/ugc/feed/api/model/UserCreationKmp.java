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
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ~2\u00060\u0001j\u0002`\u0002:\u0002}~BÑ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!BÃ\u0001\b\u0010\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b \u0010%J\u000b\u0010X\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010Y\u001a\u00020\u0006HÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010\\\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010^\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010b\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010HJ\u0010\u0010d\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010e\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u001fHÆ\u0003JØ\u0001\u0010i\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÆ\u0001¢\u0006\u0002\u0010jJ\u0006\u0010k\u001a\u00020\u0006J\u0013\u0010l\u001a\u00020\u00162\b\u0010m\u001a\u0004\u0018\u00010nHÖ\u0003J\t\u0010o\u001a\u00020\u0006HÖ\u0001J\t\u0010p\u001a\u00020\u0004HÖ\u0001J\u0016\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u0006J%\u0010v\u001a\u00020r2\u0006\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020{H\u0001¢\u0006\u0002\b|R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010'\u001a\u0004\b+\u0010,R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00100\u0012\u0004\b-\u0010'\u001a\u0004\b.\u0010/R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00100\u0012\u0004\b1\u0010'\u001a\u0004\b2\u0010/R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010'\u001a\u0004\b4\u00105R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00109\u0012\u0004\b6\u0010'\u001a\u0004\b7\u00108R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010'\u001a\u0004\b;\u0010<R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010'\u001a\u0004\b>\u0010?R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010'\u001a\u0004\bA\u0010)R \u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00100\u0012\u0004\bB\u0010'\u001a\u0004\bC\u0010/R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010'\u001a\u0004\bE\u0010FR \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010I\u0012\u0004\bG\u0010'\u001a\u0004\b\u0015\u0010HR \u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00109\u0012\u0004\bJ\u0010'\u001a\u0004\bK\u00108R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010'\u001a\u0004\bM\u0010NR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010'\u001a\u0004\bP\u0010QR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010'\u001a\u0004\bS\u0010TR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bU\u0010'\u001a\u0004\bV\u0010W¨\u0006\u007f"}, d2 = {"Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "creationId", "", "userCreationType", "", "status", "privateStatus", "content", "Lcom/larus/ugc/feed/api/model/UserCreationContentKmp;", "usageCount", "", "authorInfo", "Lcom/larus/ugc/feed/api/model/AuthorInfoKmp;", "dynamicInfo", "Lcom/larus/ugc/feed/api/model/CreationDynamicInfoKmp;", "creationTraceInfo", "contentSource", "communityInfo", "Lcom/larus/ugc/feed/api/model/CreationCommunityInfoKmp;", "isFavorite", "", "createTime", "clientTrackParams", "Lcom/larus/ugc/feed/api/model/UserCreationTrackParamsKmp;", "refContent", "Lcom/larus/ugc/feed/api/model/UserCreationRefContentKmp;", "publishExtra", "Lcom/larus/ugc/feed/api/model/CreationPublishExtraKmp;", "awemeAnchor", "Lcom/larus/ugc/feed/api/model/AwemeAnchorKmp;", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Lcom/larus/ugc/feed/api/model/UserCreationContentKmp;Ljava/lang/Long;Lcom/larus/ugc/feed/api/model/AuthorInfoKmp;Lcom/larus/ugc/feed/api/model/CreationDynamicInfoKmp;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/ugc/feed/api/model/CreationCommunityInfoKmp;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/larus/ugc/feed/api/model/UserCreationTrackParamsKmp;Lcom/larus/ugc/feed/api/model/UserCreationRefContentKmp;Lcom/larus/ugc/feed/api/model/CreationPublishExtraKmp;Lcom/larus/ugc/feed/api/model/AwemeAnchorKmp;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Lcom/larus/ugc/feed/api/model/UserCreationContentKmp;Ljava/lang/Long;Lcom/larus/ugc/feed/api/model/AuthorInfoKmp;Lcom/larus/ugc/feed/api/model/CreationDynamicInfoKmp;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/ugc/feed/api/model/CreationCommunityInfoKmp;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/larus/ugc/feed/api/model/UserCreationTrackParamsKmp;Lcom/larus/ugc/feed/api/model/UserCreationRefContentKmp;Lcom/larus/ugc/feed/api/model/CreationPublishExtraKmp;Lcom/larus/ugc/feed/api/model/AwemeAnchorKmp;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCreationId$annotations", "()V", "getCreationId", "()Ljava/lang/String;", "getUserCreationType$annotations", "getUserCreationType", "()I", "getStatus$annotations", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPrivateStatus$annotations", "getPrivateStatus", "getContent$annotations", "getContent", "()Lcom/larus/ugc/feed/api/model/UserCreationContentKmp;", "getUsageCount$annotations", "getUsageCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAuthorInfo$annotations", "getAuthorInfo", "()Lcom/larus/ugc/feed/api/model/AuthorInfoKmp;", "getDynamicInfo$annotations", "getDynamicInfo", "()Lcom/larus/ugc/feed/api/model/CreationDynamicInfoKmp;", "getCreationTraceInfo$annotations", "getCreationTraceInfo", "getContentSource$annotations", "getContentSource", "getCommunityInfo$annotations", "getCommunityInfo", "()Lcom/larus/ugc/feed/api/model/CreationCommunityInfoKmp;", "isFavorite$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCreateTime$annotations", "getCreateTime", "getClientTrackParams$annotations", "getClientTrackParams", "()Lcom/larus/ugc/feed/api/model/UserCreationTrackParamsKmp;", "getRefContent$annotations", "getRefContent", "()Lcom/larus/ugc/feed/api/model/UserCreationRefContentKmp;", "getPublishExtra$annotations", "getPublishExtra", "()Lcom/larus/ugc/feed/api/model/CreationPublishExtraKmp;", "getAwemeAnchor$annotations", "getAwemeAnchor", "()Lcom/larus/ugc/feed/api/model/AwemeAnchorKmp;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Lcom/larus/ugc/feed/api/model/UserCreationContentKmp;Ljava/lang/Long;Lcom/larus/ugc/feed/api/model/AuthorInfoKmp;Lcom/larus/ugc/feed/api/model/CreationDynamicInfoKmp;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/ugc/feed/api/model/CreationCommunityInfoKmp;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/larus/ugc/feed/api/model/UserCreationTrackParamsKmp;Lcom/larus/ugc/feed/api/model/UserCreationRefContentKmp;Lcom/larus/ugc/feed/api/model/CreationPublishExtraKmp;Lcom/larus/ugc/feed/api/model/AwemeAnchorKmp;)Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class UserCreationKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<UserCreationKmp> CREATOR = null;
    public static final b Companion = null;
    private final AuthorInfoKmp authorInfo;
    private final AwemeAnchorKmp awemeAnchor;
    private final UserCreationTrackParamsKmp clientTrackParams;
    private final CreationCommunityInfoKmp communityInfo;
    private final UserCreationContentKmp content;
    private final Integer contentSource;
    private final Long createTime;
    private final String creationId;
    private final String creationTraceInfo;
    private final CreationDynamicInfoKmp dynamicInfo;
    private final Boolean isFavorite;
    private final Integer privateStatus;
    private final CreationPublishExtraKmp publishExtra;
    private final UserCreationRefContentKmp refContent;
    private final Integer status;
    private final Long usageCount;
    private final int userCreationType;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationKmp> {
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
            g2 r1 = new g2("com.larus.ugc.feed.api.model.UserCreationKmp", r0, 17);
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
            return new d[]{kuc.a.d(r1), r2, kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(UserCreationContentKmp.a.a), kuc.a.d(r3), kuc.a.d(AuthorInfoKmp.a.a), kuc.a.d(CreationDynamicInfoKmp.a.a), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(CreationCommunityInfoKmp.a.a), kuc.a.d(i.a), kuc.a.d(r3), kuc.a.d(UserCreationTrackParamsKmp.a.a), kuc.a.d(UserCreationRefContentKmp.a.a), kuc.a.d(CreationPublishExtraKmp.a.a), kuc.a.d(AwemeAnchorKmp.a.a)};
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
            UserCreationContentKmp r8 = (UserCreationContentKmp) r0.decodeNullableSerializableElement(r1, 4, UserCreationContentKmp.a.a, null);
            g1 r10 = g1.a;
            Long r12 = (Long) r0.decodeNullableSerializableElement(r1, 5, r10, null);
            AuthorInfoKmp r9 = (AuthorInfoKmp) r0.decodeNullableSerializableElement(r1, 6, AuthorInfoKmp.a.a, null);
            CreationDynamicInfoKmp r13 = (CreationDynamicInfoKmp) r0.decodeNullableSerializableElement(r1, 7, CreationDynamicInfoKmp.a.a, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 8, r2, null);
            Integer r6 = (Integer) r0.decodeNullableSerializableElement(r1, 9, r7, null);
            CreationCommunityInfoKmp r14 = (CreationCommunityInfoKmp) r0.decodeNullableSerializableElement(r1, 10, CreationCommunityInfoKmp.a.a, null);
            Boolean r16 = (Boolean) r0.decodeNullableSerializableElement(r1, 11, i.a, null);
            Long r17 = (Long) r0.decodeNullableSerializableElement(r1, 12, r10, null);
            Boolean r19 = r16;
            UserCreationTrackParamsKmp r18 = (UserCreationTrackParamsKmp) r0.decodeNullableSerializableElement(r1, 13, UserCreationTrackParamsKmp.a.a, null);
            UserCreationRefContentKmp r20 = (UserCreationRefContentKmp) r0.decodeNullableSerializableElement(r1, 14, UserCreationRefContentKmp.a.a, null);
            CreationPublishExtraKmp r23 = (CreationPublishExtraKmp) r0.decodeNullableSerializableElement(r1, 15, CreationPublishExtraKmp.a.a, null);
            AwemeAnchorKmp r24 = (AwemeAnchorKmp) r0.decodeNullableSerializableElement(r1, 16, AwemeAnchorKmp.a.a, null);
            AuthorInfoKmp r110 = r9;
            Long r21 = r17;
            Integer r111 = r15;
            UserCreationRefContentKmp r22 = r20;
            Integer r112 = r6;
            int r25 = r4;
            CreationDynamicInfoKmp r113 = r13;
            Long r114 = r12;
            UserCreationContentKmp r115 = r8;
            String r26 = r5;
            String r116 = r3;
            UserCreationTrackParamsKmp r27 = r18;
            CreationCommunityInfoKmp r117 = r14;
            int r28 = 131071;
        L43:
            r0.endStructure(r1);
            return new UserCreationKmp(r28, r26, r25, r111, r11, r115, r114, r110, r113, r116, r112, r117, r19, r21, r27, r22, r23, r24, null);
        L5:
            AuthorInfoKmp r29 = null;
            Integer r30 = null;
            Long r31 = null;
            UserCreationRefContentKmp r32 = null;
            UserCreationContentKmp r33 = null;
            CreationDynamicInfoKmp r34 = null;
            Long r118 = null;
            AwemeAnchorKmp r119 = null;
            CreationCommunityInfoKmp r120 = null;
            Boolean r121 = null;
            CreationPublishExtraKmp r122 = null;
            UserCreationTrackParamsKmp r123 = null;
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
            AwemeAnchorKmp r310 = (AwemeAnchorKmp) r0.decodeNullableSerializableElement(r1, 16, AwemeAnchorKmp.a.a, r119);
        L17:
            r30 = r30;
            int r42 = r41;
            Integer r213 = r212;
            String r214 = r35;
            r119 = r310;
        L37:
            AuthorInfoKmp r215 = r29;
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
            r122 = (CreationPublishExtraKmp) r0.decodeNullableSerializableElement(r1, 15, CreationPublishExtraKmp.a.a, r122);
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
            r32 = (UserCreationRefContentKmp) r0.decodeNullableSerializableElement(r1, 14, UserCreationRefContentKmp.a.a, r32);
            r41 = r45 | 16384;
            goto L17
        L14:
            int r46 = r38;
            r310 = r119;
            r123 = (UserCreationTrackParamsKmp) r0.decodeNullableSerializableElement(r1, 13, UserCreationTrackParamsKmp.a.a, r123);
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
            r120 = (CreationCommunityInfoKmp) r0.decodeNullableSerializableElement(r1, 10, CreationCommunityInfoKmp.a.a, r120);
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
            r34 = (CreationDynamicInfoKmp) r0.decodeNullableSerializableElement(r1, 7, CreationDynamicInfoKmp.a.a, r34);
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
            r29 = (AuthorInfoKmp) r0.decodeNullableSerializableElement(r1, 6, AuthorInfoKmp.a.a, r29);
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
            r33 = (UserCreationContentKmp) r0.decodeNullableSerializableElement(r1, 4, UserCreationContentKmp.a.a, r33);
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
            AwemeAnchorKmp r314 = r119;
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

        public final void serialize(muc.f r2, Object r3) {
            UserCreationKmp r4 = (UserCreationKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            UserCreationKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreationKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationKmp createFromParcel(Parcel r22) {
            Intrinsics.checkNotNullParameter(r22, "parcel");
            String r3 = r22.readString();
            int r4 = r22.readInt();
            AwemeAnchorKmp r5 = null;
            if (r22.readInt() != 0) goto L5;
            Integer r6 = null;
        L7:
            if (r22.readInt() != 0) goto L9;
            Integer r7 = null;
        L11:
            if (r22.readInt() != 0) goto L13;
            UserCreationContentKmp r2 = null;
        L14:
            UserCreationContentKmp r8 = r2;
            if (r22.readInt() != 0) goto L17;
            Long r9 = null;
        L19:
            if (r22.readInt() != 0) goto L21;
            AuthorInfoKmp r10 = null;
        L22:
            AuthorInfoKmp r11 = r10;
            if (r22.readInt() != 0) goto L25;
            CreationDynamicInfoKmp r12 = null;
        L26:
            CreationDynamicInfoKmp r13 = r12;
            String r14 = r22.readString();
            if (r22.readInt() != 0) goto L29;
            Integer r15 = null;
        L31:
            if (r22.readInt() != 0) goto L33;
            CreationCommunityInfoKmp r16 = null;
        L34:
            CreationCommunityInfoKmp r17 = r16;
            if (r22.readInt() != 0) goto L38;
            Boolean r18 = null;
        L43:
            if (r22.readInt() != 0) goto L45;
            Long r19 = null;
        L47:
            if (r22.readInt() != 0) goto L49;
            UserCreationTrackParamsKmp r20 = null;
        L50:
            UserCreationTrackParamsKmp r110 = r20;
            if (r22.readInt() != 0) goto L53;
            UserCreationRefContentKmp r21 = null;
        L54:
            UserCreationRefContentKmp r111 = r21;
            if (r22.readInt() != 0) goto L57;
            CreationPublishExtraKmp r23 = null;
        L58:
            CreationPublishExtraKmp r24 = r23;
            if (r22.readInt() == 0) goto L63;
            r5 = AwemeAnchorKmp.CREATOR.createFromParcel(r22);
        L63:
            return new UserCreationKmp(r3, r4, r6, r7, r8, r9, r11, r13, r14, r15, r17, r18, r19, r110, r111, r24, r5);
        L57:
            r23 = CreationPublishExtraKmp.CREATOR.createFromParcel(r22);
            goto L58
        L53:
            r21 = UserCreationRefContentKmp.CREATOR.createFromParcel(r22);
            goto L54
        L49:
            r20 = UserCreationTrackParamsKmp.CREATOR.createFromParcel(r22);
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
            r16 = CreationCommunityInfoKmp.CREATOR.createFromParcel(r22);
            goto L34
        L29:
            r15 = Integer.valueOf(r22.readInt());
            goto L31
        L25:
            r12 = CreationDynamicInfoKmp.CREATOR.createFromParcel(r22);
            goto L26
        L21:
            r10 = AuthorInfoKmp.CREATOR.createFromParcel(r22);
            goto L22
        L17:
            r9 = Long.valueOf(r22.readLong());
            goto L19
        L13:
            r2 = UserCreationContentKmp.CREATOR.createFromParcel(r22);
            goto L14
        L9:
            r7 = Integer.valueOf(r22.readInt());
            goto L11
        L5:
            r6 = Integer.valueOf(r22.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationKmp[] newArray(int r1) {
            return new UserCreationKmp[r1];
        }
    }

    public UserCreationKmp() {
        this(null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ UserCreationKmp copy$default(UserCreationKmp r17, String r18, int r19, Integer r20, Integer r21, UserCreationContentKmp r22, Long r23, AuthorInfoKmp r24, CreationDynamicInfoKmp r25, String r26, Integer r27, CreationCommunityInfoKmp r28, Boolean r29, Long r30, UserCreationTrackParamsKmp r31, UserCreationRefContentKmp r32, CreationPublishExtraKmp r33, AwemeAnchorKmp r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        String r2 = r17.creationId;
    L7:
        if ((r35 & 2) == 0) goto L9;
        int r3 = r17.userCreationType;
    L11:
        if ((r35 & 4) == 0) goto L13;
        Integer r4 = r17.status;
    L15:
        if ((r35 & 8) == 0) goto L17;
        Integer r5 = r17.privateStatus;
    L19:
        if ((r35 & 16) == 0) goto L21;
        UserCreationContentKmp r6 = r17.content;
    L23:
        if ((r35 & 32) == 0) goto L25;
        Long r7 = r17.usageCount;
    L27:
        if ((r35 & 64) == 0) goto L29;
        AuthorInfoKmp r8 = r17.authorInfo;
    L31:
        if ((r35 & 128) == 0) goto L33;
        CreationDynamicInfoKmp r9 = r17.dynamicInfo;
    L35:
        if ((r35 & 256) == 0) goto L37;
        String r10 = r17.creationTraceInfo;
    L39:
        if ((r35 & 512) == 0) goto L41;
        Integer r11 = r17.contentSource;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        CreationCommunityInfoKmp r12 = r17.communityInfo;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        Boolean r13 = r17.isFavorite;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        Long r14 = r17.createTime;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        UserCreationTrackParamsKmp r15 = r17.clientTrackParams;
    L58:
        UserCreationTrackParamsKmp r37 = r15;
        if ((r35 & 16384) == 0) goto L61;
        UserCreationRefContentKmp r16 = r17.refContent;
    L62:
        UserCreationRefContentKmp r38 = r16;
        if ((r35 & 32768) == 0) goto L65;
        CreationPublishExtraKmp r110 = r17.publishExtra;
    L67:
        if ((r35 & 65536) == 0) goto L69;
        AwemeAnchorKmp r1 = r17.awemeAnchor;
    L71:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r38, r110, r1);
    L69:
        r1 = r34;
        goto L71
    L65:
        r110 = r33;
        goto L67
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

    @SerialName("author_info")
    public static /* synthetic */ void getAuthorInfo$annotations() {
    }

    @SerialName("aweme_anchor")
    public static /* synthetic */ void getAwemeAnchor$annotations() {
    }

    @SerialName("client_track_params")
    public static /* synthetic */ void getClientTrackParams$annotations() {
    }

    @SerialName("community_info")
    public static /* synthetic */ void getCommunityInfo$annotations() {
    }

    @SerialName("content")
    public static /* synthetic */ void getContent$annotations() {
    }

    @SerialName("content_source")
    public static /* synthetic */ void getContentSource$annotations() {
    }

    @SerialName("create_time")
    public static /* synthetic */ void getCreateTime$annotations() {
    }

    @SerialName("creation_id")
    public static /* synthetic */ void getCreationId$annotations() {
    }

    @SerialName("creation_trace_info")
    public static /* synthetic */ void getCreationTraceInfo$annotations() {
    }

    @SerialName("dynamic_info")
    public static /* synthetic */ void getDynamicInfo$annotations() {
    }

    @SerialName("private_status")
    public static /* synthetic */ void getPrivateStatus$annotations() {
    }

    @SerialName("publish_extra")
    public static /* synthetic */ void getPublishExtra$annotations() {
    }

    @SerialName("ref_content")
    public static /* synthetic */ void getRefContent$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("usage_count")
    public static /* synthetic */ void getUsageCount$annotations() {
    }

    @SerialName("creation_type")
    public static /* synthetic */ void getUserCreationType$annotations() {
    }

    @SerialName("is_favorite")
    public static /* synthetic */ void isFavorite$annotations() {
    }

    public final String component1() {
        return this.creationId;
    }

    public final Integer component10() {
        return this.contentSource;
    }

    public final CreationCommunityInfoKmp component11() {
        return this.communityInfo;
    }

    public final Boolean component12() {
        return this.isFavorite;
    }

    public final Long component13() {
        return this.createTime;
    }

    public final UserCreationTrackParamsKmp component14() {
        return this.clientTrackParams;
    }

    public final UserCreationRefContentKmp component15() {
        return this.refContent;
    }

    public final CreationPublishExtraKmp component16() {
        return this.publishExtra;
    }

    public final AwemeAnchorKmp component17() {
        return this.awemeAnchor;
    }

    public final int component2() {
        return this.userCreationType;
    }

    public final Integer component3() {
        return this.status;
    }

    public final Integer component4() {
        return this.privateStatus;
    }

    public final UserCreationContentKmp component5() {
        return this.content;
    }

    public final Long component6() {
        return this.usageCount;
    }

    public final AuthorInfoKmp component7() {
        return this.authorInfo;
    }

    public final CreationDynamicInfoKmp component8() {
        return this.dynamicInfo;
    }

    public final String component9() {
        return this.creationTraceInfo;
    }

    public final UserCreationKmp copy(String r20, int r21, Integer r22, Integer r23, UserCreationContentKmp r24, Long r25, AuthorInfoKmp r26, CreationDynamicInfoKmp r27, String r28, Integer r29, CreationCommunityInfoKmp r30, Boolean r31, Long r32, UserCreationTrackParamsKmp r33, UserCreationRefContentKmp r34, CreationPublishExtraKmp r35, AwemeAnchorKmp r36) {
        return new UserCreationKmp(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationKmp) == true) goto L8;
        return false;
    L8:
        UserCreationKmp r6 = (UserCreationKmp) r5;
        if (Intrinsics.areEqual(this.creationId, r6.creationId) == true) goto L12;
        return false;
    L12:
        if (this.userCreationType == r6.userCreationType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.privateStatus, r6.privateStatus) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.usageCount, r6.usageCount) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.authorInfo, r6.authorInfo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.dynamicInfo, r6.dynamicInfo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.creationTraceInfo, r6.creationTraceInfo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.contentSource, r6.contentSource) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.communityInfo, r6.communityInfo) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.isFavorite, r6.isFavorite) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.createTime, r6.createTime) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.clientTrackParams, r6.clientTrackParams) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.refContent, r6.refContent) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.publishExtra, r6.publishExtra) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.awemeAnchor, r6.awemeAnchor) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        String r0 = this.creationId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.userCreationType) * 31;
        Integer r4 = this.status;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.privateStatus;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        UserCreationContentKmp r10 = this.content;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.usageCount;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        AuthorInfoKmp r16 = this.authorInfo;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        CreationDynamicInfoKmp r19 = this.dynamicInfo;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.creationTraceInfo;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.contentSource;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        CreationCommunityInfoKmp r28 = this.communityInfo;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Boolean r31 = this.isFavorite;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Long r34 = this.createTime;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        UserCreationTrackParamsKmp r37 = this.clientTrackParams;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        UserCreationRefContentKmp r40 = this.refContent;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        CreationPublishExtraKmp r43 = this.publishExtra;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        AwemeAnchorKmp r46 = this.awemeAnchor;
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

    public String toString() {
        return "UserCreationKmp(creationId=" + this.creationId + ", userCreationType=" + this.userCreationType + ", status=" + this.status + ", privateStatus=" + this.privateStatus + ", content=" + this.content + ", usageCount=" + this.usageCount + ", authorInfo=" + this.authorInfo + ", dynamicInfo=" + this.dynamicInfo + ", creationTraceInfo=" + this.creationTraceInfo + ", contentSource=" + this.contentSource + ", communityInfo=" + this.communityInfo + ", isFavorite=" + this.isFavorite + ", createTime=" + this.createTime + ", clientTrackParams=" + this.clientTrackParams + ", refContent=" + this.refContent + ", publishExtra=" + this.publishExtra + ", awemeAnchor=" + this.awemeAnchor + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        r6.writeString(this.creationId);
        r6.writeInt(this.userCreationType);
        Integer r0 = this.status;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L6:
        Integer r1 = this.privateStatus;
        if (r1 != null) goto L9;
        r6.writeInt(0);
    L10:
        UserCreationContentKmp r2 = this.content;
        if (r2 != null) goto L13;
        r6.writeInt(0);
    L14:
        Long r3 = this.usageCount;
        if (r3 != null) goto L17;
        r6.writeInt(0);
    L18:
        AuthorInfoKmp r4 = this.authorInfo;
        if (r4 != null) goto L21;
        r6.writeInt(0);
    L22:
        CreationDynamicInfoKmp r5 = this.dynamicInfo;
        if (r5 != null) goto L25;
        r6.writeInt(0);
    L26:
        r6.writeString(this.creationTraceInfo);
        Integer r8 = this.contentSource;
        if (r8 != null) goto L29;
        r6.writeInt(0);
    L30:
        CreationCommunityInfoKmp r9 = this.communityInfo;
        if (r9 != null) goto L33;
        r6.writeInt(0);
    L34:
        Boolean r10 = this.isFavorite;
        if (r10 != null) goto L37;
        r6.writeInt(0);
    L38:
        Long r11 = this.createTime;
        if (r11 != null) goto L41;
        r6.writeInt(0);
    L42:
        UserCreationTrackParamsKmp r12 = this.clientTrackParams;
        if (r12 != null) goto L45;
        r6.writeInt(0);
    L46:
        UserCreationRefContentKmp r13 = this.refContent;
        if (r13 != null) goto L49;
        r6.writeInt(0);
    L50:
        CreationPublishExtraKmp r14 = this.publishExtra;
        if (r14 != null) goto L53;
        r6.writeInt(0);
    L54:
        AwemeAnchorKmp r15 = this.awemeAnchor;
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
        $stable = 8;
        CREATOR = new c();
    }

    public final AuthorInfoKmp getAuthorInfo() {
        return this.authorInfo;
    }

    public final AwemeAnchorKmp getAwemeAnchor() {
        return this.awemeAnchor;
    }

    public final UserCreationTrackParamsKmp getClientTrackParams() {
        return this.clientTrackParams;
    }

    public final CreationCommunityInfoKmp getCommunityInfo() {
        return this.communityInfo;
    }

    public final UserCreationContentKmp getContent() {
        return this.content;
    }

    public final Integer getContentSource() {
        return this.contentSource;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final String getCreationId() {
        return this.creationId;
    }

    public final String getCreationTraceInfo() {
        return this.creationTraceInfo;
    }

    public final CreationDynamicInfoKmp getDynamicInfo() {
        return this.dynamicInfo;
    }

    public final Integer getPrivateStatus() {
        return this.privateStatus;
    }

    public final CreationPublishExtraKmp getPublishExtra() {
        return this.publishExtra;
    }

    public final UserCreationRefContentKmp getRefContent() {
        return this.refContent;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Long getUsageCount() {
        return this.usageCount;
    }

    public final int getUserCreationType() {
        return this.userCreationType;
    }

    public final Boolean isFavorite() {
        return this.isFavorite;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(UserCreationKmp r18, muc.d r19, f r20) {
        boolean r5 = true;
        if (r19.shouldEncodeElementDefault(r20, 0) == false) goto L6;
    L4:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        r19.encodeNullableSerializableElement(r20, 0, v2.a, r18.creationId);
    L12:
        if (r19.shouldEncodeElementDefault(r20, 1) == false) goto L15;
    L13:
        boolean r6 = true;
    L18:
        if (r6 == false) goto L21;
        r19.encodeIntElement(r20, 1, r18.userCreationType);
    L21:
        if (r19.shouldEncodeElementDefault(r20, 2) == false) goto L23;
    L22:
        boolean r7 = true;
    L30:
        if (r7 == false) goto L33;
        r19.encodeNullableSerializableElement(r20, 2, w0.a, r18.status);
    L33:
        if (r19.shouldEncodeElementDefault(r20, 3) == false) goto L35;
    L34:
        boolean r8 = true;
    L42:
        if (r8 == false) goto L45;
        r19.encodeNullableSerializableElement(r20, 3, w0.a, r18.privateStatus);
    L45:
        if (r19.shouldEncodeElementDefault(r20, 4) == false) goto L48;
    L46:
        boolean r9 = true;
    L51:
        if (r9 == false) goto L54;
        r19.encodeNullableSerializableElement(r20, 4, UserCreationContentKmp.a.a, r18.content);
    L54:
        if (r19.shouldEncodeElementDefault(r20, 5) == false) goto L57;
    L55:
        boolean r10 = true;
    L60:
        if (r10 == false) goto L63;
        r19.encodeNullableSerializableElement(r20, 5, g1.a, r18.usageCount);
    L63:
        if (r19.shouldEncodeElementDefault(r20, 6) == false) goto L66;
    L64:
        boolean r11 = true;
    L69:
        if (r11 == false) goto L72;
        r19.encodeNullableSerializableElement(r20, 6, AuthorInfoKmp.a.a, r18.authorInfo);
    L72:
        if (r19.shouldEncodeElementDefault(r20, 7) == false) goto L75;
    L73:
        boolean r12 = true;
    L78:
        if (r12 == false) goto L81;
        r19.encodeNullableSerializableElement(r20, 7, CreationDynamicInfoKmp.a.a, r18.dynamicInfo);
    L81:
        if (r19.shouldEncodeElementDefault(r20, 8) == false) goto L84;
    L82:
        boolean r13 = true;
    L87:
        if (r13 == false) goto L90;
        r19.encodeNullableSerializableElement(r20, 8, v2.a, r18.creationTraceInfo);
    L90:
        if (r19.shouldEncodeElementDefault(r20, 9) == false) goto L93;
    L91:
        boolean r14 = true;
    L96:
        if (r14 == false) goto L99;
        r19.encodeNullableSerializableElement(r20, 9, w0.a, r18.contentSource);
    L99:
        if (r19.shouldEncodeElementDefault(r20, 10) == false) goto L102;
    L100:
        boolean r15 = true;
    L105:
        if (r15 == false) goto L108;
        r19.encodeNullableSerializableElement(r20, 10, CreationCommunityInfoKmp.a.a, r18.communityInfo);
    L108:
        if (r19.shouldEncodeElementDefault(r20, 11) == false) goto L111;
    L109:
        boolean r16 = true;
    L114:
        if (r16 == false) goto L117;
        r19.encodeNullableSerializableElement(r20, 11, i.a, r18.isFavorite);
    L117:
        if (r19.shouldEncodeElementDefault(r20, 12) == false) goto L120;
    L118:
        boolean r17 = true;
    L123:
        if (r17 == false) goto L126;
        r19.encodeNullableSerializableElement(r20, 12, g1.a, r18.createTime);
    L126:
        if (r19.shouldEncodeElementDefault(r20, 13) == false) goto L129;
    L127:
        boolean r3 = true;
    L132:
        if (r3 == false) goto L135;
        r19.encodeNullableSerializableElement(r20, 13, UserCreationTrackParamsKmp.a.a, r18.clientTrackParams);
    L135:
        if (r19.shouldEncodeElementDefault(r20, 14) == false) goto L138;
    L136:
        boolean r21 = true;
    L141:
        if (r21 == false) goto L144;
        r19.encodeNullableSerializableElement(r20, 14, UserCreationRefContentKmp.a.a, r18.refContent);
    L144:
        if (r19.shouldEncodeElementDefault(r20, 15) == false) goto L147;
    L145:
        boolean r22 = true;
    L150:
        if (r22 == false) goto L153;
        r19.encodeNullableSerializableElement(r20, 15, CreationPublishExtraKmp.a.a, r18.publishExtra);
    L153:
        if (r19.shouldEncodeElementDefault(r20, 16) == false) goto L156;
    L159:
        if (r5 == false) goto L162;
        r19.encodeNullableSerializableElement(r20, 16, AwemeAnchorKmp.a.a, r18.awemeAnchor);
        return;
    L162:
        return;
    L156:
        if (r18.awemeAnchor != null) goto L159;
        r5 = false;
        goto L159
    L147:
        if (r18.publishExtra != null) goto L145;
        r22 = false;
        goto L150
    L138:
        if (r18.refContent != null) goto L136;
        r21 = false;
        goto L141
    L129:
        if (Intrinsics.areEqual(r18.clientTrackParams, new UserCreationTrackParamsKmp(null, null, null, null, null, null, null, 127, null)) == false) goto L127;
        r3 = false;
        goto L132
    L120:
        if (r18.createTime != null) goto L118;
        r17 = false;
        goto L123
    L111:
        if (r18.isFavorite != null) goto L109;
        r16 = false;
        goto L114
    L102:
        if (r18.communityInfo != null) goto L100;
        r15 = false;
        goto L105
    L93:
        if (r18.contentSource != null) goto L91;
        r14 = false;
        goto L96
    L84:
        if (r18.creationTraceInfo != null) goto L82;
        r13 = false;
        goto L87
    L75:
        if (r18.dynamicInfo != null) goto L73;
        r12 = false;
        goto L78
    L66:
        if (r18.authorInfo != null) goto L64;
        r11 = false;
        goto L69
    L57:
        if (r18.usageCount != null) goto L55;
        r10 = false;
        goto L60
    L48:
        if (r18.content != null) goto L46;
        r9 = false;
        goto L51
    L35:
        Integer r23 = r18.privateStatus;
        if (r23 == null) goto L34;
        if (r23.intValue() != 0) goto L34;
        r8 = false;
        goto L42
    L23:
        Integer r24 = r18.status;
        if (r24 == null) goto L22;
        if (r24.intValue() != 0) goto L22;
        r7 = false;
        goto L30
    L15:
        if (r18.userCreationType != 0) goto L13;
        r6 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r18.creationId, "") == false) goto L4;
        r4 = false;
        goto L9
    }

    public UserCreationKmp(String r3, int r4, Integer r5, Integer r6, UserCreationContentKmp r7, Long r8, AuthorInfoKmp r9, CreationDynamicInfoKmp r10, String r11, Integer r12, CreationCommunityInfoKmp r13, Boolean r14, Long r15, UserCreationTrackParamsKmp r16, UserCreationRefContentKmp r17, CreationPublishExtraKmp r18, AwemeAnchorKmp r19) {
        this.creationId = r3;
        this.userCreationType = r4;
        this.status = r5;
        this.privateStatus = r6;
        this.content = r7;
        this.usageCount = r8;
        this.authorInfo = r9;
        this.dynamicInfo = r10;
        this.creationTraceInfo = r11;
        this.contentSource = r12;
        this.communityInfo = r13;
        this.isFavorite = r14;
        this.createTime = r15;
        this.clientTrackParams = r16;
        this.refContent = r17;
        this.publishExtra = r18;
        this.awemeAnchor = r19;
    }

    public UserCreationKmp(int r14, String r15, int r16, Integer r17, Integer r18, UserCreationContentKmp r19, Long r20, AuthorInfoKmp r21, CreationDynamicInfoKmp r22, String r23, Integer r24, CreationCommunityInfoKmp r25, Boolean r26, Long r27, UserCreationTrackParamsKmp r28, UserCreationRefContentKmp r29, CreationPublishExtraKmp r30, AwemeAnchorKmp r31, q2 r32) {
        if ((r14 & 0) == 0) goto L5;
        b2.b(r14, 0, a.b);
        throw null;
    L5:
        if ((r14 & 1) != 0) goto L7;
        String r2 = "";
    L8:
        this.creationId = r2;
        if ((r14 & 2) != 0) goto L11;
        this.userCreationType = 0;
    L13:
        if ((r14 & 4) != 0) goto L15;
        this.status = 0;
    L17:
        if ((r14 & 8) != 0) goto L19;
        this.privateStatus = 0;
    L21:
        if ((r14 & 16) != 0) goto L23;
        this.content = null;
    L25:
        if ((r14 & 32) != 0) goto L27;
        this.usageCount = null;
    L29:
        if ((r14 & 64) != 0) goto L31;
        this.authorInfo = null;
    L33:
        if ((r14 & 128) != 0) goto L35;
        this.dynamicInfo = null;
    L37:
        if ((r14 & 256) != 0) goto L39;
        this.creationTraceInfo = null;
    L41:
        if ((r14 & 512) != 0) goto L43;
        this.contentSource = null;
    L45:
        if ((r14 & 1024) != 0) goto L47;
        this.communityInfo = null;
    L49:
        if ((r14 & 2048) != 0) goto L51;
        this.isFavorite = null;
    L53:
        if ((r14 & 4096) != 0) goto L55;
        this.createTime = null;
    L57:
        if ((r14 & 8192) != 0) goto L59;
        UserCreationTrackParamsKmp r3 = new UserCreationTrackParamsKmp(null, null, null, null, null, null, null, 127, null);
    L60:
        this.clientTrackParams = r3;
        if ((r14 & 16384) != 0) goto L63;
        this.refContent = null;
    L65:
        if ((32768 & r14) != 0) goto L67;
        this.publishExtra = null;
    L69:
        if ((r14 & 65536) != 0) goto L71;
        this.awemeAnchor = null;
        return;
    L71:
        this.awemeAnchor = r31;
        return;
    L67:
        this.publishExtra = r30;
        goto L69
    L63:
        this.refContent = r29;
        goto L65
    L59:
        r3 = r28;
        goto L60
    L55:
        this.createTime = r27;
        goto L57
    L51:
        this.isFavorite = r26;
        goto L53
    L47:
        this.communityInfo = r25;
        goto L49
    L43:
        this.contentSource = r24;
        goto L45
    L39:
        this.creationTraceInfo = r23;
        goto L41
    L35:
        this.dynamicInfo = r22;
        goto L37
    L31:
        this.authorInfo = r21;
        goto L33
    L27:
        this.usageCount = r20;
        goto L29
    L23:
        this.content = r19;
        goto L25
    L19:
        this.privateStatus = r18;
        goto L21
    L15:
        this.status = r17;
        goto L17
    L11:
        this.userCreationType = r16;
        goto L13
    L7:
        r2 = r15;
        goto L8
    }

    public /* synthetic */ UserCreationKmp(String r26, int r27, Integer r28, Integer r29, UserCreationContentKmp r30, Long r31, AuthorInfoKmp r32, CreationDynamicInfoKmp r33, String r34, Integer r35, CreationCommunityInfoKmp r36, Boolean r37, Long r38, UserCreationTrackParamsKmp r39, UserCreationRefContentKmp r40, CreationPublishExtraKmp r41, AwemeAnchorKmp r42, int r43, DefaultConstructorMarker r44) {
        if ((r43 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r43 & 2) == 0) goto L9;
        int r2 = 0;
    L11:
        if ((r43 & 4) == 0) goto L13;
        Integer r4 = 0;
    L15:
        if ((r43 & 8) == 0) goto L17;
        Integer r3 = 0;
    L19:
        if ((r43 & 16) == 0) goto L21;
        UserCreationContentKmp r5 = null;
    L23:
        if ((r43 & 32) == 0) goto L25;
        Long r7 = null;
    L27:
        if ((r43 & 64) == 0) goto L29;
        AuthorInfoKmp r8 = null;
    L31:
        if ((r43 & 128) == 0) goto L33;
        CreationDynamicInfoKmp r9 = null;
    L35:
        if ((r43 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r43 & 512) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r43 & 1024) == 0) goto L45;
        CreationCommunityInfoKmp r12 = null;
    L47:
        if ((r43 & 2048) == 0) goto L49;
        Boolean r13 = null;
    L51:
        if ((r43 & 4096) == 0) goto L53;
        Long r14 = null;
    L55:
        if ((r43 & 8192) == 0) goto L57;
        UserCreationTrackParamsKmp r15 = new UserCreationTrackParamsKmp(null, null, null, null, null, null, null, 127, null);
    L59:
        if ((r43 & 16384) == 0) goto L61;
        UserCreationRefContentKmp r6 = null;
    L63:
        if ((r43 & 32768) == 0) goto L65;
        CreationPublishExtraKmp r16 = null;
    L67:
        if ((r43 & 65536) == 0) goto L69;
        AwemeAnchorKmp r0 = null;
    L70:
        this(r1, r2, r4, r3, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r6, r16, r0);
        return;
    L69:
        r0 = r42;
        goto L70
    L65:
        r16 = r41;
        goto L67
    L61:
        r6 = r40;
        goto L63
    L57:
        r15 = r39;
        goto L59
    L53:
        r14 = r38;
        goto L55
    L49:
        r13 = r37;
        goto L51
    L45:
        r12 = r36;
        goto L47
    L41:
        r11 = r35;
        goto L43
    L37:
        r10 = r34;
        goto L39
    L33:
        r9 = r33;
        goto L35
    L29:
        r8 = r32;
        goto L31
    L25:
        r7 = r31;
        goto L27
    L21:
        r5 = r30;
        goto L23
    L17:
        r3 = r29;
        goto L19
    L13:
        r4 = r28;
        goto L15
    L9:
        r2 = r27;
        goto L11
    L5:
        r1 = r26;
        goto L7
    }
}
