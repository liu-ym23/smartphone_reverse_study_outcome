package com.bytedance.android.livesdk.drawer.drawerlynx;

import com.bytedance.android.livesdkapi.depend.model.live.VerticalTypeInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0014\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\"\u0010#\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0014\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\"\u0010%\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0014\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R$\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR$\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR$\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR$\u00103\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0014\u001a\u0004\b=\u0010\u0015\"\u0004\b>\u0010\u0017R$\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010M\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010\u0004\u001a\u0004\bN\u0010\u0006\"\u0004\bO\u0010\bR\"\u0010P\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010\u0014\u001a\u0004\bP\u0010\u0015\"\u0004\bQ\u0010\u0017R\"\u0010R\u001a\u00020F8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006X"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/drawerlynx/e;", "", "", "originEnterFrom", "Ljava/lang/String;", "getOriginEnterFrom", "()Ljava/lang/String;", "setOriginEnterFrom", "(Ljava/lang/String;)V", "enterFrom", "getEnterFrom", "setEnterFrom", "originEnterMethod", "getOriginEnterMethod", "setOriginEnterMethod", "enterMethod", "getEnterMethod", "setEnterMethod", "", "isFromMatchRoom", "Z", "()Z", "setFromMatchRoom", "(Z)V", "roomId", "getRoomId", "setRoomId", "shouldShowFollowDefaultTab", "getShouldShowFollowDefaultTab", "setShouldShowFollowDefaultTab", "needPersonalRecommend", "getNeedPersonalRecommend", "setNeedPersonalRecommend", "isPad", "setPad", "isLandScape", "setLandScape", "isFromNearbyTv", "setFromNearbyTv", "cityCode", "getCityCode", "setCityCode", "cityName", "getCityName", "setCityName", "nearbyCityCode", "getNearbyCityCode", "setNearbyCityCode", "viewdRoomDetails", "getViewdRoomDetails", "setViewdRoomDetails", "viewdHistory", "getViewdHistory", "setViewdHistory", "Lcom/bytedance/android/livesdkapi/depend/model/live/VerticalTypeInfo;", "verticalTypeInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/VerticalTypeInfo;", "getVerticalTypeInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/VerticalTypeInfo;", "setVerticalTypeInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/VerticalTypeInfo;)V", "isVSSepcial", "setVSSepcial", "", "insertRoomReason", "Ljava/lang/Integer;", "getInsertRoomReason", "()Ljava/lang/Integer;", "setInsertRoomReason", "(Ljava/lang/Integer;)V", "", "defaultTabId", "Ljava/lang/Long;", "getDefaultTabId", "()Ljava/lang/Long;", "setDefaultTabId", "(Ljava/lang/Long;)V", "coverContentCategory", "getCoverContentCategory", "setCoverContentCategory", "isPreload", "setPreload", "initTime", "J", "getInitTime", "()J", "setInitTime", "(J)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("city_code")
    private String cityCode;

    @SerializedName("city_name")
    private String cityName;

    @SerializedName("cover_content_category")
    private String coverContentCategory;

    @SerializedName("default_tab_id")
    private Long defaultTabId;

    @SerializedName("enter_from")
    private String enterFrom;

    @SerializedName("enter_method")
    private String enterMethod;

    @SerializedName("init_timestamp")
    private long initTime;

    @SerializedName("insert_room_reason")
    private Integer insertRoomReason;

    @SerializedName("is_from_match_room")
    private boolean isFromMatchRoom;

    @SerializedName("is_from_nearby_tv")
    private boolean isFromNearbyTv;

    @SerializedName("is_landscape")
    private boolean isLandScape;

    @SerializedName("is_pad")
    private boolean isPad;

    @SerializedName("smart_client_preload")
    private boolean isPreload;

    @SerializedName("has_vs_program_entrance")
    private boolean isVSSepcial;

    @SerializedName("nearby_city_code")
    private String nearbyCityCode;

    @SerializedName("is_personal_recommend_switch_on")
    private boolean needPersonalRecommend;

    @SerializedName("origin_enter_from")
    private String originEnterFrom;

    @SerializedName("origin_enter_method")
    private String originEnterMethod;

    @SerializedName("room_id")
    private String roomId;

    @SerializedName("should_show_follow_default_tab")
    private boolean shouldShowFollowDefaultTab;

    @SerializedName("vertical_type_info")
    private VerticalTypeInfo verticalTypeInfo;

    @SerializedName("viewed_history")
    private String viewdHistory;

    @SerializedName("viewed_room_details")
    private String viewdRoomDetails;

    public e() {
        this(null, null, null, null, false, null, false, false, false, false, false, null, null, null, null, null, null, false, null, null, null, false, 0);
    }

    public e(String r4, String r5, String r6, String r7, boolean r8, String r9, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, String r15, String r16, String r17, String r18, String r19, VerticalTypeInfo r20, boolean r21, Integer r22, Long r23, String r24, boolean r25, long r26) {
        this.originEnterFrom = r4;
        this.enterFrom = r5;
        this.originEnterMethod = r6;
        this.enterMethod = r7;
        this.isFromMatchRoom = r8;
        this.roomId = r9;
        this.shouldShowFollowDefaultTab = r10;
        this.needPersonalRecommend = r11;
        this.isPad = r12;
        this.isLandScape = r13;
        this.isFromNearbyTv = r14;
        this.cityCode = r15;
        this.cityName = r16;
        this.nearbyCityCode = r17;
        this.viewdRoomDetails = r18;
        this.viewdHistory = r19;
        this.verticalTypeInfo = r20;
        this.isVSSepcial = r21;
        this.insertRoomReason = r22;
        this.defaultTabId = r23;
        this.coverContentCategory = r24;
        this.isPreload = r25;
        this.initTime = r26;
    }
}
