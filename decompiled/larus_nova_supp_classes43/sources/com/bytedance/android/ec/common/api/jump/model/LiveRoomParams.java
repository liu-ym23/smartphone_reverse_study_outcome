package com.bytedance.android.ec.common.api.jump.model;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.ec.model.response.n1;
import com.bytedance.android.shopping.anchorv3.utils.n;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bd\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0088\u0001B\u009f\u0002\u0012\u0006\u0010*\u001a\u00020\u0005\u0012\u0006\u0010+\u001a\u00020\u0005\u0012\u0006\u0010,\u001a\u00020\u0005\u0012\u0006\u0010-\u001a\u00020\u0005\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014\u0012\u0006\u0010/\u001a\u00020\u0005\u0012\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0007\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014\u0012\f\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0014\u0012\b\b\u0002\u00108\u001a\u00020\u0005\u0012\b\b\u0002\u00109\u001a\u00020\u0005\u0012\b\b\u0002\u0010:\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u000e\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u0014\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0014\u0012\u0006\u0010?\u001a\u00020\u001f¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bJ\b\u0010\r\u001a\u00020\u0007H\u0016J\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bJ\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0014HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u0014HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0014HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u0014HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0014HÆ\u0003J\t\u0010)\u001a\u00020\u001fHÆ\u0003J¿\u0002\u0010@\u001a\u00020\u00002\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u00052\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\b\b\u0002\u0010/\u001a\u00020\u00052\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b2\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u00020\t0\u00142\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00142\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\u00142\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00142\b\b\u0002\u00108\u001a\u00020\u00052\b\b\u0002\u00109\u001a\u00020\u00052\b\b\u0002\u0010:\u001a\u00020\u00052\u0014\b\u0002\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b2\u0010\b\u0002\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u00142\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00142\b\b\u0002\u0010?\u001a\u00020\u001fHÆ\u0001J\t\u0010A\u001a\u00020\u0005HÖ\u0001J\t\u0010B\u001a\u00020\u001fHÖ\u0001J\u0013\u0010D\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010\u000eHÖ\u0003R\u001d\u0010I\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010*\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b*\u0010J\u001a\u0004\bK\u0010HR\u0017\u0010+\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b+\u0010J\u001a\u0004\bL\u0010HR\u0017\u0010,\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b,\u0010J\u001a\u0004\bM\u0010HR\u0017\u0010-\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b-\u0010J\u001a\u0004\bN\u0010HR\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148\u0006¢\u0006\f\n\u0004\b.\u0010O\u001a\u0004\bP\u0010QR\u0017\u0010/\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b/\u0010J\u001a\u0004\bR\u0010HR#\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b8\u0006¢\u0006\f\n\u0004\b0\u0010S\u001a\u0004\bT\u0010UR#\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b8\u0006¢\u0006\f\n\u0004\b1\u0010S\u001a\u0004\bV\u0010UR\u0019\u00102\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b2\u0010W\u001a\u0004\bX\u0010YR\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148\u0006¢\u0006\f\n\u0004\b3\u0010O\u001a\u0004\bZ\u0010QR\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\t0\u00148\u0006¢\u0006\f\n\u0004\b4\u0010O\u001a\u0004\b[\u0010QR\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00148\u0006¢\u0006\f\n\u0004\b5\u0010O\u001a\u0004\b\\\u0010QR\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\u00148\u0006¢\u0006\f\n\u0004\b6\u0010O\u001a\u0004\b6\u0010QR\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00148\u0006¢\u0006\f\n\u0004\b7\u0010O\u001a\u0004\b]\u0010QR\u0017\u00108\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b8\u0010J\u001a\u0004\b^\u0010HR\u0017\u00109\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b9\u0010J\u001a\u0004\b_\u0010HR\u0017\u0010:\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b:\u0010J\u001a\u0004\b`\u0010HR#\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b8\u0006¢\u0006\f\n\u0004\b;\u0010S\u001a\u0004\ba\u0010UR\u001f\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u00148\u0006¢\u0006\f\n\u0004\b<\u0010O\u001a\u0004\bb\u0010QR\u0019\u0010=\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b=\u0010W\u001a\u0004\bc\u0010YR\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00148\u0006¢\u0006\f\n\u0004\b>\u0010O\u001a\u0004\bd\u0010QR\u0017\u0010?\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b?\u0010e\u001a\u0004\b?\u0010fR\u0011\u0010h\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bg\u0010HR\u0011\u0010j\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bi\u0010HR\u0013\u0010l\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\bk\u0010HR\u0011\u0010n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bm\u0010HR\u0011\u0010p\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bo\u0010HR\u0011\u0010r\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bq\u0010HR\u0013\u0010t\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\bs\u0010HR\u0013\u0010v\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\bu\u0010HR\u0013\u0010x\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\bw\u0010HR\u0013\u0010z\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\by\u0010HR\u0013\u0010|\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b{\u0010HR\u0013\u0010~\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b}\u0010HR\u0014\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u007f\u0010HR\u0015\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010HR\u0015\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010HR\u0016\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u001f8F¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001¨\u0006\u0089\u0001"}, d2 = {"Lcom/bytedance/android/ec/common/api/jump/model/LiveRoomParams;", "Lcom/bytedance/android/ec/common/api/jump/model/a;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/common/api/jump/model/d;", "Lcom/bytedance/android/ec/common/api/jump/model/c;", "", "getSourcePage", "Lorg/json/JSONObject;", "entranceInfo", "", "isDisplayRoom", "", "getEcomLiveParamsEventParams", "addToCartEntranceInfo", "", "generaInitialData", "component1", "component2", "component3", "component4", "Lkotlin/Function0;", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "", "component12", "component13", "", "component14", "component15", "component16", "component17", "component18", "Lcom/bytedance/android/ec/model/response/n1;", "component19", "component20", "component21", "component22", BdpAwemeConstant.KEY_ROOM_ID, "roomUniqueKey", "authorId", "secAuthorId", "screenType", "ecomSceneId", "reportParams", "ecomLiveParams", "passThroughLogData", "hourlyPurchaseShopId", "shouldShowAddressNotice", "hasShowNoticeInShop", "isHourArrivedRoom", "roomType", "displayRoomId", "displayAnchorId", "displaySecAnchorId", "displayReportParams", "roomInfo", "multiRoomData", "instantType", "isShowCart", "copy", "toString", "hashCode", "other", "equals", "searchParams$delegate", "Lkotlin/Lazy;", "getSearchParams", "()Ljava/lang/String;", "searchParams", "Ljava/lang/String;", "getRoomId", "getRoomUniqueKey", "getAuthorId", "getSecAuthorId", "Lkotlin/jvm/functions/Function0;", "getScreenType", "()Lkotlin/jvm/functions/Function0;", "getEcomSceneId", "Ljava/util/Map;", "getReportParams", "()Ljava/util/Map;", "getEcomLiveParams", "Lorg/json/JSONObject;", "getPassThroughLogData", "()Lorg/json/JSONObject;", "getHourlyPurchaseShopId", "getShouldShowAddressNotice", "getHasShowNoticeInShop", "getRoomType", "getDisplayRoomId", "getDisplayAnchorId", "getDisplaySecAnchorId", "getDisplayReportParams", "getRoomInfo", "getMultiRoomData", "getInstantType", "I", "()I", "getFollowStatus", "followStatus", "getDisplayFollowStatus", "displayFollowStatus", "getGroupId", "groupId", "getEnterFromMerge", "enterFromMerge", "getEnterMethod", "enterMethod", "getActionType", "actionType", "getRequestId", "requestId", "getLiveRecommendInfo", "liveRecommendInfo", "getSearchId", "searchId", "getSearchType", "searchType", "getLiveTrackerParams", "liveTrackerParams", "getCreativeId", "creativeId", "getLogExtra", "logExtra", "isOtherChannel", "getAwemeAdType", "awemeAdType", "isEcomNew", "()Ljava/lang/Integer;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function0;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function0;I)V", "a", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomParams extends com.bytedance.android.ec.common.api.jump.model.a implements Serializable, d, c {
    private final String authorId;
    private final String displayAnchorId;
    private final Map<String, String> displayReportParams;
    private final String displayRoomId;
    private final String displaySecAnchorId;
    private final Map<String, String> ecomLiveParams;
    private final String ecomSceneId;
    private final Function0<Unit> hasShowNoticeInShop;
    private final Function0<String> hourlyPurchaseShopId;
    private final Function0<Integer> instantType;
    private final Function0<Boolean> isHourArrivedRoom;
    private final int isShowCart;
    private final JSONObject multiRoomData;
    private final JSONObject passThroughLogData;
    private final Map<String, String> reportParams;
    private final String roomId;
    private final Function0<n1> roomInfo;
    private final Function0<Integer> roomType;
    private final String roomUniqueKey;
    private final Function0<String> screenType;
    private final Lazy searchParams$delegate;
    private final String secAuthorId;
    private final Function0<Boolean> shouldShowAddressNotice;

    public static final class a implements com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0115a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final Function0<String> e;
        public final String f;
        public final Map<String, String> g;
        public final Map<String, String> h;
        public final JSONObject i;
        public final Function0<String> j;
        public final Function0<Boolean> k;
        public final Function0<Unit> l;
        public final Function0<Boolean> m;
        public final Function0<Integer> n;
        public final String o;
        public final String p;
        public final String q;
        public final Map<String, String> r;
        public final Function0<n1> s;
        public final JSONObject t;
        public final Function0<Integer> u;
        public final int v;

        @Override // com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0115a
        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r27) {
            Intrinsics.checkNotNullParameter(r27, "modelClass");
            if (Intrinsics.areEqual(r27, Reflection.getOrCreateKotlinClass(LiveRoomParams.class)) == false) goto L7;
            return new LiveRoomParams(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v);
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r27).newInstance();
        }

        public a(String r17, String r18, String r19, String r20, Map r21, Map r22) {
            LiveRoomParams$Factory$1 r10 = LiveRoomParams$Factory$1.INSTANCE;
            LiveRoomParams$Factory$2 r11 = LiveRoomParams$Factory$2.INSTANCE;
            LiveRoomParams$Factory$3 r12 = LiveRoomParams$Factory$3.INSTANCE;
            LiveRoomParams$Factory$4 r13 = LiveRoomParams$Factory$4.INSTANCE;
            LiveRoomParams$Factory$5 r14 = LiveRoomParams$Factory$5.INSTANCE;
            LiveRoomParams$Factory$6 r15 = LiveRoomParams$Factory$6.INSTANCE;
            LiveRoomParams$Factory$7 r16 = LiveRoomParams$Factory$7.INSTANCE;
            LiveRoomParams$Factory$8 r110 = LiveRoomParams$Factory$8.INSTANCE;
            Intrinsics.checkNotNullParameter(r17, BdpAwemeConstant.KEY_ROOM_ID);
            Intrinsics.checkNotNullParameter("", "roomUniqueKey");
            Intrinsics.checkNotNullParameter(r18, "authorId");
            Intrinsics.checkNotNullParameter(r19, "secAuthorId");
            Intrinsics.checkNotNullParameter(r10, "screenType");
            Intrinsics.checkNotNullParameter(r20, "ecomSceneId");
            Intrinsics.checkNotNullParameter(r21, "reportParams");
            Intrinsics.checkNotNullParameter(r22, "ecomLiveParams");
            Intrinsics.checkNotNullParameter(r11, "hourlyPurchaseShopId");
            Intrinsics.checkNotNullParameter(r12, "shouldShowAddressNotice");
            Intrinsics.checkNotNullParameter(r13, "hasShowNoticeInShop");
            Intrinsics.checkNotNullParameter(r14, "isHourArrivedRoom");
            Intrinsics.checkNotNullParameter(r15, "roomType");
            Intrinsics.checkNotNullParameter(r17, "displayRoomId");
            Intrinsics.checkNotNullParameter(r18, "displayAnchorId");
            Intrinsics.checkNotNullParameter(r19, "displaySecAnchorId");
            Intrinsics.checkNotNullParameter(r21, "displayReportParams");
            Intrinsics.checkNotNullParameter(r16, "roomInfo");
            Intrinsics.checkNotNullParameter(r110, "instantType");
            this.a = r17;
            this.b = "";
            this.c = r18;
            this.d = r19;
            this.e = r10;
            this.f = r20;
            this.g = r21;
            this.h = r22;
            this.i = null;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
            this.n = r15;
            this.o = r17;
            this.p = r18;
            this.q = r19;
            this.r = r21;
            this.s = r16;
            this.t = null;
            this.u = r110;
            this.v = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveRoomParams copy$default(LiveRoomParams r17, String r18, String r19, String r20, String r21, Function0 r22, String r23, Map r24, Map r25, JSONObject r26, Function0 r27, Function0 r28, Function0 r29, Function0 r30, Function0 r31, String r32, String r33, String r34, Map r35, Function0 r36, JSONObject r37, Function0 r38, int r39, int r40, Object r41) {
        if ((r40 & 1) == 0) goto L5;
        String r10 = r17.roomId;
    L7:
        if ((r40 & 2) == 0) goto L9;
        String r11 = r17.roomUniqueKey;
    L11:
        if ((r40 & 4) == 0) goto L13;
        String r12 = r17.authorId;
    L15:
        if ((r40 & 8) == 0) goto L17;
        String r13 = r17.secAuthorId;
    L19:
        if ((r40 & 16) == 0) goto L21;
        Function0 r14 = r17.screenType;
    L23:
        if ((r40 & 32) == 0) goto L25;
        String r15 = r17.ecomSceneId;
    L27:
        if ((r40 & 64) == 0) goto L29;
        Map r16 = r17.reportParams;
    L31:
        if ((r40 & 128) == 0) goto L33;
        Map r42 = r17.ecomLiveParams;
    L35:
        if ((r40 & 256) == 0) goto L37;
        JSONObject r110 = r17.passThroughLogData;
    L39:
        if ((r40 & 512) == 0) goto L41;
        Function0 r111 = r17.hourlyPurchaseShopId;
    L43:
        if ((r40 & 1024) == 0) goto L45;
        Function0 r112 = r17.shouldShowAddressNotice;
    L47:
        if ((r40 & 2048) == 0) goto L49;
        Function0 r113 = r17.hasShowNoticeInShop;
    L51:
        if ((r40 & 4096) == 0) goto L53;
        Function0 r114 = r17.isHourArrivedRoom;
    L55:
        if ((r40 & 8192) == 0) goto L57;
        Function0 r115 = r17.roomType;
    L58:
        Function0 r310 = r115;
        if ((r40 & 16384) == 0) goto L61;
        String r116 = r17.displayRoomId;
    L62:
        String r311 = r116;
        if ((r40 & 32768) == 0) goto L65;
        String r117 = r17.displayAnchorId;
    L66:
        String r312 = r117;
        if ((r40 & 65536) == 0) goto L69;
        String r118 = r17.displaySecAnchorId;
    L70:
        String r313 = r118;
        if ((r40 & 131072) == 0) goto L73;
        Map r119 = r17.displayReportParams;
    L74:
        Map r314 = r119;
        if ((r40 & 262144) == 0) goto L77;
        Function0 r120 = r17.roomInfo;
    L78:
        Function0 r315 = r120;
        if ((r40 & 524288) == 0) goto L81;
        JSONObject r121 = r17.multiRoomData;
    L82:
        JSONObject r316 = r121;
        if ((r40 & 1048576) == 0) goto L85;
        Function0 r122 = r17.instantType;
    L87:
        if ((r40 & 2097152) == 0) goto L89;
        int r1 = r17.isShowCart;
    L91:
        return r17.copy(r10, r11, r12, r13, r14, r15, r16, r42, r110, r111, r112, r113, r114, r310, r311, r312, r313, r314, r315, r316, r122, r1);
    L89:
        r1 = r39;
        goto L91
    L85:
        r122 = r38;
        goto L87
    L81:
        r121 = r37;
        goto L82
    L77:
        r120 = r36;
        goto L78
    L73:
        r119 = r35;
        goto L74
    L69:
        r118 = r34;
        goto L70
    L65:
        r117 = r33;
        goto L66
    L61:
        r116 = r32;
        goto L62
    L57:
        r115 = r31;
        goto L58
    L53:
        r114 = r30;
        goto L55
    L49:
        r113 = r29;
        goto L51
    L45:
        r112 = r28;
        goto L47
    L41:
        r111 = r27;
        goto L43
    L37:
        r110 = r26;
        goto L39
    L33:
        r42 = r25;
        goto L35
    L29:
        r16 = r24;
        goto L31
    L25:
        r15 = r23;
        goto L27
    L21:
        r14 = r22;
        goto L23
    L17:
        r13 = r21;
        goto L19
    L13:
        r12 = r20;
        goto L15
    L9:
        r11 = r19;
        goto L11
    L5:
        r10 = r18;
        goto L7
    }

    public final String component1() {
        return this.roomId;
    }

    public final Function0<String> component10() {
        return this.hourlyPurchaseShopId;
    }

    public final Function0<Boolean> component11() {
        return this.shouldShowAddressNotice;
    }

    public final Function0<Unit> component12() {
        return this.hasShowNoticeInShop;
    }

    public final Function0<Boolean> component13() {
        return this.isHourArrivedRoom;
    }

    public final Function0<Integer> component14() {
        return this.roomType;
    }

    public final String component15() {
        return this.displayRoomId;
    }

    public final String component16() {
        return this.displayAnchorId;
    }

    public final String component17() {
        return this.displaySecAnchorId;
    }

    public final Map<String, String> component18() {
        return this.displayReportParams;
    }

    public final Function0<n1> component19() {
        return this.roomInfo;
    }

    public final String component2() {
        return this.roomUniqueKey;
    }

    public final JSONObject component20() {
        return this.multiRoomData;
    }

    public final Function0<Integer> component21() {
        return this.instantType;
    }

    public final int component22() {
        return this.isShowCart;
    }

    public final String component3() {
        return this.authorId;
    }

    public final String component4() {
        return this.secAuthorId;
    }

    public final Function0<String> component5() {
        return this.screenType;
    }

    public final String component6() {
        return this.ecomSceneId;
    }

    public final Map<String, String> component7() {
        return this.reportParams;
    }

    public final Map<String, String> component8() {
        return this.ecomLiveParams;
    }

    public final JSONObject component9() {
        return this.passThroughLogData;
    }

    public final LiveRoomParams copy(String r26, String r27, String r28, String r29, Function0<String> r30, String r31, Map<String, String> r32, Map<String, String> r33, JSONObject r34, Function0<String> r35, Function0<Boolean> r36, Function0<Unit> r37, Function0<Boolean> r38, Function0<Integer> r39, String r40, String r41, String r42, Map<String, String> r43, Function0<n1> r44, JSONObject r45, Function0<Integer> r46, int r47) {
        Intrinsics.checkNotNullParameter(r26, BdpAwemeConstant.KEY_ROOM_ID);
        Intrinsics.checkNotNullParameter(r27, "roomUniqueKey");
        Intrinsics.checkNotNullParameter(r28, "authorId");
        Intrinsics.checkNotNullParameter(r29, "secAuthorId");
        Intrinsics.checkNotNullParameter(r30, "screenType");
        Intrinsics.checkNotNullParameter(r31, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r32, "reportParams");
        Intrinsics.checkNotNullParameter(r33, "ecomLiveParams");
        Intrinsics.checkNotNullParameter(r35, "hourlyPurchaseShopId");
        Intrinsics.checkNotNullParameter(r36, "shouldShowAddressNotice");
        Intrinsics.checkNotNullParameter(r37, "hasShowNoticeInShop");
        Intrinsics.checkNotNullParameter(r38, "isHourArrivedRoom");
        Intrinsics.checkNotNullParameter(r39, "roomType");
        Intrinsics.checkNotNullParameter(r40, "displayRoomId");
        Intrinsics.checkNotNullParameter(r41, "displayAnchorId");
        Intrinsics.checkNotNullParameter(r42, "displaySecAnchorId");
        Intrinsics.checkNotNullParameter(r43, "displayReportParams");
        Intrinsics.checkNotNullParameter(r44, "roomInfo");
        Intrinsics.checkNotNullParameter(r46, "instantType");
        return new LiveRoomParams(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof LiveRoomParams) == false) goto L50;
        LiveRoomParams r11 = (LiveRoomParams) r10;
        if (Intrinsics.areEqual(this.roomId, r11.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.roomUniqueKey, r11.roomUniqueKey) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.authorId, r11.authorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secAuthorId, r11.secAuthorId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.screenType, r11.screenType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.ecomSceneId, r11.ecomSceneId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reportParams, r11.reportParams) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.ecomLiveParams, r11.ecomLiveParams) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.passThroughLogData, r11.passThroughLogData) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.hourlyPurchaseShopId, r11.hourlyPurchaseShopId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.shouldShowAddressNotice, r11.shouldShowAddressNotice) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.hasShowNoticeInShop, r11.hasShowNoticeInShop) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isHourArrivedRoom, r11.isHourArrivedRoom) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.roomType, r11.roomType) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.displayRoomId, r11.displayRoomId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.displayAnchorId, r11.displayAnchorId) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.displaySecAnchorId, r11.displaySecAnchorId) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.displayReportParams, r11.displayReportParams) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.roomInfo, r11.roomInfo) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.multiRoomData, r11.multiRoomData) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.instantType, r11.instantType) == true) goto L48;
        return false;
    L48:
        if (this.isShowCart == r11.isShowCart) goto L76;
        return false;
    L76:
        return true;
    L50:
        return false;
    }

    public final Map<String, Object> generaInitialData() {
        Pair[] r0 = new Pair[7];
        r0[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, this.roomId);
        r0[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, this.authorId);
        r0[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SEC_AUTHOR_ID, this.secAuthorId);
        r0[3] = TuplesKt.to("is_followed", getFollowStatus());
        Map r1 = MapsKt.toMutableMap(this.ecomLiveParams);
        JSONObject r10 = this.passThroughLogData;
        String r11 = null;
        if (r10 == null) goto L5;
        String r12 = r10.toString();
    L6:
        String r13 = "";
        if (r12 != null) goto L9;
        r12 = "";
    L9:
        r1.put("pass_through_log_data", r12);
        JSONObject r14 = this.multiRoomData;
        if (r14 == null) goto L12;
        r11 = r14.toString();
    L12:
        if (r11 == null) goto L15;
        r13 = r11;
    L15:
        r1.put("multi_room_data", r13);
        Unit r15 = Unit.INSTANCE;
        r0[4] = TuplesKt.to("ecom_live_params", r1);
        r0[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_SCENE_ID, this.ecomSceneId);
        r0[6] = TuplesKt.to("report_params", this.reportParams);
        return MapsKt.mutableMapOf(r0);
    L5:
        r12 = null;
        goto L6
    }

    public final String getSearchParams() {
        return (String) this.searchParams$delegate.getValue();
    }

    public int hashCode() {
        String r0 = this.roomId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.roomUniqueKey;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.authorId;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.secAuthorId;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        Function0<String> r21 = this.screenType;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        String r24 = this.ecomSceneId;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (r23 + r25) * 31;
        Map<String, String> r27 = this.reportParams;
        if (r27 == null) goto L29;
        int r28 = r27.hashCode();
    L30:
        int r29 = (r26 + r28) * 31;
        Map<String, String> r30 = this.ecomLiveParams;
        if (r30 == null) goto L33;
        int r31 = r30.hashCode();
    L34:
        int r32 = (r29 + r31) * 31;
        JSONObject r33 = this.passThroughLogData;
        if (r33 == null) goto L37;
        int r34 = r33.hashCode();
    L38:
        int r35 = (r32 + r34) * 31;
        Function0<String> r36 = this.hourlyPurchaseShopId;
        if (r36 == null) goto L41;
        int r37 = r36.hashCode();
    L42:
        int r38 = (r35 + r37) * 31;
        Function0<Boolean> r39 = this.shouldShowAddressNotice;
        if (r39 == null) goto L45;
        int r40 = r39.hashCode();
    L46:
        int r41 = (r38 + r40) * 31;
        Function0<Unit> r42 = this.hasShowNoticeInShop;
        if (r42 == null) goto L49;
        int r43 = r42.hashCode();
    L50:
        int r44 = (r41 + r43) * 31;
        Function0<Boolean> r45 = this.isHourArrivedRoom;
        if (r45 == null) goto L53;
        int r46 = r45.hashCode();
    L54:
        int r47 = (r44 + r46) * 31;
        Function0<Integer> r48 = this.roomType;
        if (r48 == null) goto L57;
        int r49 = r48.hashCode();
    L58:
        int r50 = (r47 + r49) * 31;
        String r51 = this.displayRoomId;
        if (r51 == null) goto L61;
        int r52 = r51.hashCode();
    L62:
        int r53 = (r50 + r52) * 31;
        String r54 = this.displayAnchorId;
        if (r54 == null) goto L65;
        int r55 = r54.hashCode();
    L66:
        int r56 = (r53 + r55) * 31;
        String r57 = this.displaySecAnchorId;
        if (r57 == null) goto L69;
        int r58 = r57.hashCode();
    L70:
        int r59 = (r56 + r58) * 31;
        Map<String, String> r60 = this.displayReportParams;
        if (r60 == null) goto L73;
        int r61 = r60.hashCode();
    L74:
        int r62 = (r59 + r61) * 31;
        Function0<n1> r63 = this.roomInfo;
        if (r63 == null) goto L77;
        int r64 = r63.hashCode();
    L78:
        int r65 = (r62 + r64) * 31;
        JSONObject r66 = this.multiRoomData;
        if (r66 == null) goto L81;
        int r67 = r66.hashCode();
    L82:
        int r68 = (r65 + r67) * 31;
        Function0<Integer> r69 = this.instantType;
        if (r69 == null) goto L86;
        r1 = r69.hashCode();
    L86:
        return ((r68 + r1) * 31) + this.isShowCart;
    L81:
        r67 = 0;
        goto L82
    L77:
        r64 = 0;
        goto L78
    L73:
        r61 = 0;
        goto L74
    L69:
        r58 = 0;
        goto L70
    L65:
        r55 = 0;
        goto L66
    L61:
        r52 = 0;
        goto L62
    L57:
        r49 = 0;
        goto L58
    L53:
        r46 = 0;
        goto L54
    L49:
        r43 = 0;
        goto L50
    L45:
        r40 = 0;
        goto L46
    L41:
        r37 = 0;
        goto L42
    L37:
        r34 = 0;
        goto L38
    L33:
        r31 = 0;
        goto L34
    L29:
        r28 = 0;
        goto L30
    L25:
        r25 = 0;
        goto L26
    L21:
        r22 = 0;
        goto L22
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "LiveRoomParams(roomId=" + this.roomId + ", roomUniqueKey=" + this.roomUniqueKey + ", authorId=" + this.authorId + ", secAuthorId=" + this.secAuthorId + ", screenType=" + this.screenType + ", ecomSceneId=" + this.ecomSceneId + ", reportParams=" + this.reportParams + ", ecomLiveParams=" + this.ecomLiveParams + ", passThroughLogData=" + this.passThroughLogData + ", hourlyPurchaseShopId=" + this.hourlyPurchaseShopId + ", shouldShowAddressNotice=" + this.shouldShowAddressNotice + ", hasShowNoticeInShop=" + this.hasShowNoticeInShop + ", isHourArrivedRoom=" + this.isHourArrivedRoom + ", roomType=" + this.roomType + ", displayRoomId=" + this.displayRoomId + ", displayAnchorId=" + this.displayAnchorId + ", displaySecAnchorId=" + this.displaySecAnchorId + ", displayReportParams=" + this.displayReportParams + ", roomInfo=" + this.roomInfo + ", multiRoomData=" + this.multiRoomData + ", instantType=" + this.instantType + ", isShowCart=" + this.isShowCart + ")";
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.c
    public JSONObject addToCartEntranceInfo() {
        JSONObject r10 = new JSONObject();
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, getEnterFromMerge());     // Catch: Exception -> L21
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, getEnterMethod());     // Catch: Exception -> L21
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "live");     // Catch: Exception -> L21
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_CARRIER_TYPE, "live_add_to_cart");     // Catch: Exception -> L21
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, this.roomId);     // Catch: Exception -> L21
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_ANCHOR_ID, this.authorId);     // Catch: Exception -> L21
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_FOLLOW_STATUS, getFollowStatus());     // Catch: Exception -> L21
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_REQUEST_ID, getRequestId());     // Catch: Exception -> L21
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_GROUP_ID, getGroupId());     // Catch: Exception -> L21
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM_MERGE, getEnterFromMerge());     // Catch: Exception -> L21
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_ENTER_METHOD, getEnterMethod());     // Catch: Exception -> L21
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_ACTION_TYPE, getActionType());     // Catch: Exception -> L21
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID, getCreativeId());     // Catch: Exception -> L21
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_IS_OTHER_CHANNE, isOtherChannel());     // Catch: Exception -> L21
        r10.putOpt("live_tracker_params", getLiveTrackerParams());     // Catch: Exception -> L21
        r10.putOpt("add_cart_source", "live");     // Catch: Exception -> L21
        String r0 = this.reportParams.get(com.bytedance.android.ec.core.event.a.KEY_SEARCH_PARAM);     // Catch: Exception -> L21
        if (r0 == null) goto L6;
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_SEARCH_PARAM, r0);     // Catch: Exception -> L21
    L7:
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, getLogExtra());     // Catch: Exception -> L21
        JSONObject r1 = this.passThroughLogData;     // Catch: Exception -> L21
        if (r1 == null) goto L15;
        Iterator<String> r11 = r1.keys();     // Catch: Exception -> L21
    L11:
        if (r11.hasNext() == false) goto L15;
        String r12 = r11.next();     // Catch: Exception -> L21
        Object r13 = r1.opt(r12);     // Catch: Exception -> L21
        if (r13 == null) goto L11;
        r10.putOpt(r12, r13.toString());     // Catch: Exception -> L21
    L15:
        r10.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_SCENE_ID, this.ecomSceneId);     // Catch: Exception -> L21
        r10.put("display_room_id", this.displayRoomId);     // Catch: Exception -> L21
        r10.put("display_anchor_id", this.displayAnchorId);     // Catch: Exception -> L21
        r10.put("display_sec_anchor_id", this.displaySecAnchorId);     // Catch: Exception -> L21
        r10.put("display_follow_status", getDisplayFollowStatus());     // Catch: Exception -> L21
        n1 r14 = (n1) this.roomInfo.invoke();     // Catch: Exception -> L21
        if (r14 == null) goto L23;
        List r15 = r14.a();     // Catch: Exception -> L21
        if (r15 == null) goto L23;
        int r16 = n.a;     // Catch: Exception -> L21
        r10.put("ecom_linkmic_room_ids", n.a.a.toJson(r15));     // Catch: Exception -> L21
    L23:
        return r10;
    L6:
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_SEARCH_PARAM, getSearchParams());     // Catch: Exception -> L21
    L21:
        e = move-exception;
        ye.a.b(e);
        goto L23
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.d
    public JSONObject entranceInfo() {
        JSONObject r0 = new JSONObject();
        LiveRoomParams r1 = (LiveRoomParams) getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r1 == null) goto L45;
        Map<String, String> r10 = r1.reportParams;
        if (r10 == null) goto L45;
        Iterator<Map.Entry<String, String>> r11 = r10.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L45;
        Map.Entry<String, String> r12 = r11.next();
        r0.put(r12.getKey(), r12.getValue());     // Catch: Exception -> L12
    L12:
        e = move-exception;
        ye.a.b(e);
    L45:
        r0.put(com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM, "live");     // Catch: Exception -> L20
        if (r1 == null) goto L17;
        String r13 = r1.getSourcePage();     // Catch: Exception -> L20
    L18:
        r0.put("category_name", r13);     // Catch: Exception -> L20
    L22:
        Iterator<Map.Entry<String, String>> r14 = getEcomLiveParamsEventParams().entrySet().iterator();
    L24:
        if (r14.hasNext() == false) goto L43;
        Map.Entry<String, String> r15 = r14.next();
        r0.put(r15.getKey(), r15.getValue());     // Catch: Exception -> L28
    L28:
        e = move-exception;
        ye.a.b(e);
        goto L24
    L43:
        r0.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_SCENE_ID, this.ecomSceneId);     // Catch: Exception -> L36
        r0.put("display_room_id", this.displayRoomId);     // Catch: Exception -> L36
        r0.put("display_anchor_id", this.displayAnchorId);     // Catch: Exception -> L36
        r0.put("display_sec_anchor_id", this.displaySecAnchorId);     // Catch: Exception -> L36
        r0.put("display_follow_status", getDisplayFollowStatus());     // Catch: Exception -> L36
        n1 r16 = (n1) this.roomInfo.invoke();     // Catch: Exception -> L36
        if (r16 == null) goto L38;
        List r17 = r16.a();     // Catch: Exception -> L36
        if (r17 == null) goto L38;
        int r18 = n.a;     // Catch: Exception -> L36
        r0.put("ecom_linkmic_room_ids", n.a.a.toJson(r17));     // Catch: Exception -> L36
    L38:
        return r0;
    L36:
        e = move-exception;
        ye.a.b(e);
        goto L38
    L17:
        r13 = null;
    L20:
        e = move-exception;
        ye.a.b(e);
        goto L22
    }

    public final String getActionType() {
        String r0 = this.reportParams.get(com.bytedance.android.ec.core.event.a.KEY_ACTION_TYPE);
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String getAwemeAdType() {
        return this.reportParams.get("aweme_ad_type");
    }

    public final String getCreativeId() {
        return this.reportParams.get(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID);
    }

    public final String getDisplayFollowStatus() {
        String r0 = this.displayReportParams.get(com.bytedance.android.ec.core.event.a.KEY_FOLLOW_STATUS);
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final Map<String, String> getEcomLiveParamsEventParams() {
        HashMap r0 = new HashMap(this.ecomLiveParams);
        r0.remove("jump_schema");
        r0.remove("pass_through_log_data");
        r0.remove("multi_room_data");
        r0.remove("single_room_data");
        return r0;
    }

    public final String getEnterFromMerge() {
        String r0 = this.reportParams.get(com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM_MERGE);
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String getEnterMethod() {
        String r0 = this.reportParams.get(com.bytedance.android.ec.core.event.a.KEY_ENTER_METHOD);
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String getFollowStatus() {
        String r0 = this.reportParams.get(com.bytedance.android.ec.core.event.a.KEY_FOLLOW_STATUS);
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String getGroupId() {
        return this.reportParams.get(com.bytedance.android.ec.core.event.a.KEY_GROUP_ID);
    }

    public final String getLiveRecommendInfo() {
        return this.reportParams.get("live_recommend_info");
    }

    public final String getLiveTrackerParams() {
        return this.reportParams.get("live_tracker_params");
    }

    public final String getLogExtra() {
        return this.reportParams.get(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA);
    }

    public final String getRequestId() {
        return this.reportParams.get(com.bytedance.android.ec.core.event.a.KEY_REQUEST_ID);
    }

    public final String getSearchId() {
        return this.reportParams.get(com.bytedance.android.ec.core.event.a.KEY_SEARCH_ID);
    }

    public final String getSearchType() {
        return this.reportParams.get(com.bytedance.android.ec.core.event.a.KEY_SEARCH_TYPE);
    }

    public final String getSourcePage() {
        return getEnterFromMerge() + "_temai_" + getEnterMethod();
    }

    public final boolean isDisplayRoom() {
        return Intrinsics.areEqual(this.roomId, this.displayRoomId);
    }

    public final Integer isEcomNew() {
        String r0 = this.reportParams.get("is_ecom_new");
        if (r0 != null) goto L7;
        return null;
    L7:
        return StringsKt.toIntOrNull(r0);
    }

    public final String isOtherChannel() {
        return this.reportParams.get(com.bytedance.android.ec.core.event.a.KEY_IS_OTHER_CHANNE);
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getDisplayAnchorId() {
        return this.displayAnchorId;
    }

    public final Map<String, String> getDisplayReportParams() {
        return this.displayReportParams;
    }

    public final String getDisplayRoomId() {
        return this.displayRoomId;
    }

    public final String getDisplaySecAnchorId() {
        return this.displaySecAnchorId;
    }

    public final Map<String, String> getEcomLiveParams() {
        return this.ecomLiveParams;
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final Function0<Unit> getHasShowNoticeInShop() {
        return this.hasShowNoticeInShop;
    }

    public final Function0<String> getHourlyPurchaseShopId() {
        return this.hourlyPurchaseShopId;
    }

    public final Function0<Integer> getInstantType() {
        return this.instantType;
    }

    public final JSONObject getMultiRoomData() {
        return this.multiRoomData;
    }

    public final JSONObject getPassThroughLogData() {
        return this.passThroughLogData;
    }

    public final Map<String, String> getReportParams() {
        return this.reportParams;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final Function0<n1> getRoomInfo() {
        return this.roomInfo;
    }

    public final Function0<Integer> getRoomType() {
        return this.roomType;
    }

    public final String getRoomUniqueKey() {
        return this.roomUniqueKey;
    }

    public final Function0<String> getScreenType() {
        return this.screenType;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final Function0<Boolean> getShouldShowAddressNotice() {
        return this.shouldShowAddressNotice;
    }

    public final Function0<Boolean> isHourArrivedRoom() {
        return this.isHourArrivedRoom;
    }

    public final int isShowCart() {
        return this.isShowCart;
    }

    public LiveRoomParams(String r17, String r18, String r19, String r20, Function0<String> r21, String r22, Map<String, String> r23, Map<String, String> r24, JSONObject r25, Function0<String> r26, Function0<Boolean> r27, Function0<Unit> r28, Function0<Boolean> r29, Function0<Integer> r30, String r31, String r32, String r33, Map<String, String> r34, Function0<n1> r35, JSONObject r36, Function0<Integer> r37, int r38) {
        Intrinsics.checkNotNullParameter(r17, BdpAwemeConstant.KEY_ROOM_ID);
        Intrinsics.checkNotNullParameter(r18, "roomUniqueKey");
        Intrinsics.checkNotNullParameter(r19, "authorId");
        Intrinsics.checkNotNullParameter(r20, "secAuthorId");
        Intrinsics.checkNotNullParameter(r21, "screenType");
        Intrinsics.checkNotNullParameter(r22, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r23, "reportParams");
        Intrinsics.checkNotNullParameter(r24, "ecomLiveParams");
        Intrinsics.checkNotNullParameter(r26, "hourlyPurchaseShopId");
        Intrinsics.checkNotNullParameter(r27, "shouldShowAddressNotice");
        Intrinsics.checkNotNullParameter(r28, "hasShowNoticeInShop");
        Intrinsics.checkNotNullParameter(r29, "isHourArrivedRoom");
        Intrinsics.checkNotNullParameter(r30, "roomType");
        Intrinsics.checkNotNullParameter(r31, "displayRoomId");
        Intrinsics.checkNotNullParameter(r32, "displayAnchorId");
        Intrinsics.checkNotNullParameter(r33, "displaySecAnchorId");
        Intrinsics.checkNotNullParameter(r34, "displayReportParams");
        Intrinsics.checkNotNullParameter(r35, "roomInfo");
        Intrinsics.checkNotNullParameter(r37, "instantType");
        this.roomId = r17;
        this.roomUniqueKey = r18;
        this.authorId = r19;
        this.secAuthorId = r20;
        this.screenType = r21;
        this.ecomSceneId = r22;
        this.reportParams = r23;
        this.ecomLiveParams = r24;
        this.passThroughLogData = r25;
        this.hourlyPurchaseShopId = r26;
        this.shouldShowAddressNotice = r27;
        this.hasShowNoticeInShop = r28;
        this.isHourArrivedRoom = r29;
        this.roomType = r30;
        this.displayRoomId = r31;
        this.displayAnchorId = r32;
        this.displaySecAnchorId = r33;
        this.displayReportParams = r34;
        this.roomInfo = r35;
        this.multiRoomData = r36;
        this.instantType = r37;
        this.isShowCart = r38;
        this.searchParams$delegate = LazyKt.lazy(new LiveRoomParams$searchParams$2(this));
    }

    public /* synthetic */ LiveRoomParams(String r26, String r27, String r28, String r29, Function0 r30, String r31, Map r32, Map r33, JSONObject r34, Function0 r35, Function0 r36, Function0 r37, Function0 r38, Function0 r39, String r40, String r41, String r42, Map r43, Function0 r44, JSONObject r45, Function0 r46, int r47, int r48, DefaultConstructorMarker r49) {
        if ((r48 & 256) == 0) goto L5;
        JSONObject r11 = null;
    L7:
        if ((r48 & 16384) == 0) goto L9;
        String r17 = r26;
    L11:
        if ((32768 & r48) == 0) goto L13;
        String r18 = r28;
    L15:
        if ((65536 & r48) == 0) goto L17;
        String r19 = r29;
    L19:
        if ((131072 & r48) == 0) goto L21;
        Map r20 = r32;
    L23:
        if ((r48 & 1048576) == 0) goto L25;
        Function0 r23 = AnonymousClass1.INSTANCE;
    L26:
        this(r26, r27, r28, r29, r30, r31, r32, r33, r11, r35, r36, r37, r38, r39, r17, r18, r19, r20, r44, r45, r23, r47);
        return;
    L25:
        r23 = r46;
        goto L26
    L21:
        r20 = r43;
        goto L23
    L17:
        r19 = r42;
        goto L19
    L13:
        r18 = r41;
        goto L15
    L9:
        r17 = r40;
        goto L11
    L5:
        r11 = r34;
        goto L7
    }
}
