package com.bytedance.android.live.core.feed;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface FeedApi {
    public static final String DEFAULT_APPOINTMENT_API = "webcast/appointment/feed/";
    public static final String DEFAULT_FEED_API = "/webcast/feed/";
    public static final String DEFAULT_VS_FEED_API = "/webcast/feed/?content_type=7";
    public static final int FEED_CONTENT_TYPE = 0;
    public static final int FEED_CONTENT_TYPE_LIVE_AND_FOLLOW = 2;
    public static final int FOLLOW_APPEND_RECO_CONTENT_TYPE = 5;
    public static final int FOLLOW_CONTENT_TYPE = 3;
    public static final int FOLLOW_SKY_CONTENT_TYPE = 1;
    public static final String IS_DRAW_KEY = "is_draw";
    public static final String IS_FROM_DRAW = "inner_from_drawer";
    public static final String NEED_MAP_KEY = "need_map";
    public static final int PULL_TYPE_LOAD_MORE = 2;
    public static final int PULL_TYPE_REFRESH = 1;
    public static final String SHOW_TYPE = "show_type";
    public static final String SOURCE_KEY = "source_key";

    public static final enum Style extends Enum<Style> {
        public static final Style BIG_CARD = null;
        public static final Style MORE_TAB = null;
        public static final Style RANK = null;
        public static final Style SMALL_CARD = null;
        public static final Style SMALL_CARD_BANNER = null;
        public static final Style TOB_DATA_PROVIDER = null;
        public static final /* synthetic */ Style[] a = null;
        int styleValue;

        static {
            Style r0 = new Style("BIG_CARD", 0, 1);
            BIG_CARD = r0;
            Style r1 = new Style("SMALL_CARD", 1, 2);
            SMALL_CARD = r1;
            Style r4 = new Style("SMALL_CARD_BANNER", 2, 5);
            SMALL_CARD_BANNER = r4;
            Style r6 = new Style("MORE_TAB", 3, 6);
            MORE_TAB = r6;
            Style r8 = new Style("TOB_DATA_PROVIDER", 4, 7);
            TOB_DATA_PROVIDER = r8;
            Style r11 = new Style("RANK", 5, 8);
            RANK = r11;
            a = new Style[]{r0, r1, r4, r6, r8, r11};
        }

        public static Style[] values() {
            return (Style[]) a.clone();
        }

        public int getStyleValue() {
            return this.styleValue;
        }

        public static Style valueOf(String r1) {
            return (Style) r27.a.a(Style.class, r1);
        }

        public Style(String r1, int r2, int r3) {
            super(r1, r2);
            this.styleValue = r3;
        }
    }

    @PbRequest(FileUtils.FEED_CACHE)
    @GET
    Observable<BaseListResponse<FeedItem, FeedExtra>> drawerFeed(@Url String r1, @Query("max_time") long r2, @Query("enter_source") String r4, @QueryMap Map<String, Object> r5);

    @PbRequest(FileUtils.FEED_CACHE)
    @GET(DEFAULT_FEED_API)
    Observable<BaseListResponse<FeedItem, FeedExtra>> feed(@Query(IS_DRAW_KEY) int r1, @Query(NEED_MAP_KEY) long r2, @Query(SOURCE_KEY) String r4, @Query("user_id") String r5, @Query("toplist_impr_gids") String r6, @Query("enter_source") String r7, @Query("enter_from_merge") String r8, @Query("enter_method") String r9);

    @PbRequest(FileUtils.FEED_CACHE)
    @GET(DEFAULT_FEED_API)
    Observable<BaseListResponse<FeedItem, FeedExtra>> feed(@Query(IS_DRAW_KEY) long r1, @Query("draw_room_id") long r3, @Query("max_time") long r5, @Query(NEED_MAP_KEY) long r7, @Query(SOURCE_KEY) String r9, @Query("action_type") String r11, @Query("enter_source") String r12, @Query("aggregate_banner_id") long r13, @Query(IS_FROM_DRAW) long r14, @Query("similar_room_id") long r16, @Query("with_aggregate_column") boolean r18);

    @PbRequest(FileUtils.FEED_CACHE)
    @GET(DEFAULT_FEED_API)
    Observable<BaseListResponse<FeedItem, FeedExtra>> feed(@Query("custom_count") long r1, @Query("max_time") long r3, @Query(NEED_MAP_KEY) long r5, @Query(SOURCE_KEY) String r7, @Query("enter_source") String r8);

    @PbRequest(FileUtils.FEED_CACHE)
    @GET(DEFAULT_FEED_API)
    Observable<BaseListResponse<FeedItem, FeedExtra>> feed(@Query("max_time") long r1, @Query(NEED_MAP_KEY) long r3, @Query(SOURCE_KEY) String r5, @Query("enter_source") String r6);

    @PbRequest(FileUtils.FEED_CACHE)
    @GET
    Observable<BaseListResponse<FeedItem, FeedExtra>> feed(@Url String r1, @Query("max_time") long r2, @Query("req_from") String r4, @Query(IS_DRAW_KEY) long r5, @Query("draw_room_id") long r7, @Query("draw_room_owner_id") String r9, @Query("episode_id") long r11, @Query("enter_source") String r12, @Query("offset") long r13, @Query("offset_type") int r15, @Query("episode_id_list") String r16, @Query("inner_outer_same") boolean r17);

    @PbRequest(FileUtils.FEED_CACHE)
    @GET
    Observable<BaseListResponse<FeedItem, FeedExtra>> feed(@Url String r1, @Query("max_time") long r2, @Query("req_from") String r4, @Query(IS_DRAW_KEY) long r5, @Query("draw_room_id") long r7, @Query("draw_room_owner_id") String r9, @Query("enter_source") String r11);

    @PbRequest(FileUtils.FEED_CACHE)
    @GET
    Observable<BaseListResponse<FeedItem, FeedExtra>> feed(@Url String r1, @Query("max_time") long r2, @Query("req_from") String r4, @Query(IS_DRAW_KEY) long r5, @Query("draw_room_id") long r7, @Query("draw_room_owner_id") String r9, @Query("enter_source") String r11, @Query("exempt_impression_gid_list") String r12, @QueryMap Map<String, Object> r13);

    @PbRequest(FileUtils.FEED_CACHE)
    @GET
    Observable<BaseListResponse<FeedItem, FeedExtra>> feed(@Url String r1, @Query("max_time") long r2, @Query("req_from") String r4, @Query(IS_DRAW_KEY) long r5, @Query("draw_room_id") long r7, @Query("draw_room_owner_id") String r9, @Query("enter_source") String r11, @Query("exempt_impression_gid_list") String r12, @QueryMap Map<String, Object> r13, @Query("follow_group_id") long r14, @Query("follow_group_type") long r15, @Query("real_time_feature_sequence") String r17, @Query("recent_skip_live_info_sequence") String r18, @Query("toplist_impr_gids") String r19, @Query("inner_impr_gids") String r21, @Header("x-retry-type") String r22, @Header("W-Ab-Cut-key") String r23);

    @PbRequest(FileUtils.FEED_CACHE)
    @GET
    Observable<BaseListResponse<FeedItem, FeedExtra>> feed(@Url String r1, @Query("max_time") long r2, @Query("req_from") String r4, @Query("enter_source") String r5, @QueryMap Map<String, Object> r6);

    @PbRequest(FileUtils.FEED_CACHE)
    @GET
    Observable<BaseListResponse<FeedItem, FeedExtra>> feed(@Url String r1, @Query("max_time") long r2, @Query("enter_source") String r4, @QueryMap Map<String, Object> r5);

    @PbRequest(FileUtils.FEED_CACHE)
    @GET("/webcast/feed/cache/")
    Observable<BaseListResponse<FeedItem, FeedExtra>> feed(@Query(SOURCE_KEY) String r1, @Query("enter_source") String r2, @Query(NEED_MAP_KEY) long r3, @Query(IS_DRAW_KEY) int r5, @Query("draw_room_id") long r6, @Query("req_type") long r8, @Query("action_type") String r11, @Query("inner_style") long r12);

    @FormUrlEncoded
    @PbRequest(FileUtils.FEED_CACHE)
    @POST
    Observable<BaseListResponse<FeedItem, FeedExtra>> feedPost(@Url String r1, @Query("max_time") long r2, @Query("req_from") String r4, @Query(IS_DRAW_KEY) long r5, @Query("draw_room_id") long r7, @Query("draw_room_owner_id") String r9, @Query("enter_source") String r11, @Query("exempt_impression_gid_list") String r12, @QueryMap Map<String, Object> r13, @Query("follow_group_id") long r14, @Query("follow_group_type") long r15, @Field("real_time_feature_sequence") String r17, @Field("recent_skip_live_info_sequence") String r18, @Query("inner_impr_gids") String r19, @Header("x-retry-type") String r21, @Header("live-multi-path") String r22, @Header("live-api-priority") String r23, @Header("W-Ab-Cut-key") String r24);

    @GET("/webcast/openapi/ranklist/hot/")
    Observable<BaseResponse<com.bytedance.android.live.base.model.rank.b, FeedExtra>> hotRank();
}
